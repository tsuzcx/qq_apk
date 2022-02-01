package com.tencent.mm.plugin.favorite;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gs;
import com.tencent.mm.g.a.gs.a;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements ax
{
  private com.tencent.mm.sdk.b.c rFt;
  
  public f()
  {
    AppMethodBeat.i(24613);
    this.rFt = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(gs paramAnonymousgs)
      {
        AppMethodBeat.i(24611);
        Object localObject1;
        Object localObject2;
        if ((paramAnonymousgs.dsJ.dsM != null) && ((paramAnonymousgs.dsJ.dsM instanceof o.a)) && (paramAnonymousgs.dsJ.dkO != null) && ((paramAnonymousgs.dsJ.dkO instanceof Context)))
        {
          localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramAnonymousgs.dsJ.dnC);
          localObject2 = paramAnonymousgs.dsJ.dsK;
          if ((bt.isNullOrNil((String)localObject2)) || ((((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 18) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 14))) {
            break label481;
          }
        }
        for (;;)
        {
          try
          {
            LinkedList localLinkedList = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nZa;
            if (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 18) {
              break label497;
            }
            i = 1;
            if (i >= localLinkedList.size()) {
              break label491;
            }
            Object localObject3 = (ajn)localLinkedList.get(i);
            if (((String)localObject2).startsWith(((ajn)localObject3).dsU))
            {
              localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject1).cuX();
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = paramAnonymousgs.dsJ.dsL;
              ((com.tencent.mm.plugin.fav.a.g)localObject2).rsm = true;
              ((com.tencent.mm.plugin.fav.a.g)localObject2).rsn = ((com.tencent.mm.plugin.fav.a.g)localObject1);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).dsK = (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId + "_" + ((ajn)localObject3).dsU);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.nZa = new LinkedList();
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.nZa.add(localObject3);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aPd(((ajn)localObject3).title);
              if (((ajn)localObject3).GhL != null)
              {
                if (paramAnonymousgs.dsJ.dsL == 6) {
                  ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.d(((ajn)localObject3).GhL.Giu);
                }
              }
              else
              {
                localObject1 = localObject2;
                if ((localObject1 != null) || (bt.isNullOrNil(paramAnonymousgs.dsJ.dsN))) {
                  break label494;
                }
                localObject1 = b.agj(paramAnonymousgs.dsJ.dsN);
                localObject2 = (o.a)paramAnonymousgs.dsJ.dsM;
                localObject3 = (Context)paramAnonymousgs.dsJ.dkO;
                d.a((o.a)localObject2, (Context)localObject3, (com.tencent.mm.plugin.fav.a.g)localObject1);
                d.b((o.a)localObject2, (Context)localObject3, (com.tencent.mm.plugin.fav.a.g)localObject1);
                paramAnonymousgs.dsJ.dnC = 0L;
                paramAnonymousgs.dsJ.dsK = "";
                paramAnonymousgs.dsJ.dsM = null;
                paramAnonymousgs.dsJ.dkO = null;
                AppMethodBeat.o(24611);
                return false;
              }
              if (paramAnonymousgs.dsJ.dsL != 5) {
                continue;
              }
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.b(((ajn)localObject3).GhL.Giw);
              continue;
              continue;
            }
          }
          catch (Exception localException)
          {
            ad.e("MicroMsg.Fav.SubCoreFav", "FavInitConfirmDialogContentEvent callback : %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
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
    ad.i("MicroMsg.Fav.SubCoreFav", "onAccountPostReset updated:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    a.IbL.b(this.rFt);
    com.tencent.mm.kernel.g.b(y.class, new c());
    com.tencent.mm.kernel.g.b(ab.class, new e());
    AppMethodBeat.o(24614);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24615);
    a.IbL.d(this.rFt);
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