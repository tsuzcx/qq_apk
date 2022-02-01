package com.tencent.mm.plugin.favorite;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.g.a.gt.a;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements az
{
  private com.tencent.mm.sdk.b.c rNE;
  
  public f()
  {
    AppMethodBeat.i(24613);
    this.rNE = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(gt paramAnonymousgt)
      {
        AppMethodBeat.i(24611);
        Object localObject1;
        Object localObject2;
        if ((paramAnonymousgt.dtP.dtS != null) && ((paramAnonymousgt.dtP.dtS instanceof o.a)) && (paramAnonymousgt.dtP.dlQ != null) && ((paramAnonymousgt.dtP.dlQ instanceof Context)))
        {
          localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramAnonymousgt.dtP.doH);
          localObject2 = paramAnonymousgt.dtP.dtQ;
          if ((bu.isNullOrNil((String)localObject2)) || ((((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 18) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 14))) {
            break label481;
          }
        }
        for (;;)
        {
          try
          {
            LinkedList localLinkedList = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.oeJ;
            if (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 18) {
              break label497;
            }
            i = 1;
            if (i >= localLinkedList.size()) {
              break label491;
            }
            Object localObject3 = (ajx)localLinkedList.get(i);
            if (((String)localObject2).startsWith(((ajx)localObject3).dua))
            {
              localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject1).cwy();
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = paramAnonymousgt.dtP.dtR;
              ((com.tencent.mm.plugin.fav.a.g)localObject2).rAz = true;
              ((com.tencent.mm.plugin.fav.a.g)localObject2).rAA = ((com.tencent.mm.plugin.fav.a.g)localObject1);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).dtQ = (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId + "_" + ((ajx)localObject3).dua);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.oeJ = new LinkedList();
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.oeJ.add(localObject3);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aQA(((ajx)localObject3).title);
              if (((ajx)localObject3).GAu != null)
              {
                if (paramAnonymousgt.dtP.dtR == 6) {
                  ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.d(((ajx)localObject3).GAu.GBd);
                }
              }
              else
              {
                localObject1 = localObject2;
                if ((localObject1 != null) || (bu.isNullOrNil(paramAnonymousgt.dtP.dtT))) {
                  break label494;
                }
                localObject1 = b.ahg(paramAnonymousgt.dtP.dtT);
                localObject2 = (o.a)paramAnonymousgt.dtP.dtS;
                localObject3 = (Context)paramAnonymousgt.dtP.dlQ;
                d.a((o.a)localObject2, (Context)localObject3, (com.tencent.mm.plugin.fav.a.g)localObject1);
                d.b((o.a)localObject2, (Context)localObject3, (com.tencent.mm.plugin.fav.a.g)localObject1);
                paramAnonymousgt.dtP.doH = 0L;
                paramAnonymousgt.dtP.dtQ = "";
                paramAnonymousgt.dtP.dtS = null;
                paramAnonymousgt.dtP.dlQ = null;
                AppMethodBeat.o(24611);
                return false;
              }
              if (paramAnonymousgt.dtP.dtR != 5) {
                continue;
              }
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.b(((ajx)localObject3).GAu.GBf);
              continue;
              continue;
            }
          }
          catch (Exception localException)
          {
            ae.e("MicroMsg.Fav.SubCoreFav", "FavInitConfirmDialogContentEvent callback : %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          }
          label481:
          i += 1;
          continue;
          label491:
          continue;
          label494:
          continue;
          label497:
          int i = 0;
        }
      }
    };
    AppMethodBeat.o(24613);
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24614);
    ae.i("MicroMsg.Fav.SubCoreFav", "onAccountPostReset updated:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    a.IvT.b(this.rNE);
    com.tencent.mm.kernel.g.b(y.class, new c());
    com.tencent.mm.kernel.g.b(ab.class, new e());
    AppMethodBeat.o(24614);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24615);
    a.IvT.d(this.rNE);
    ((n)com.tencent.mm.kernel.g.ad(n.class)).unregisterFTSUILogic(128);
    ((n)com.tencent.mm.kernel.g.ad(n.class)).unregisterFTSUILogic(4192);
    AppMethodBeat.o(24615);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.f
 * JD-Core Version:    0.7.0.1
 */