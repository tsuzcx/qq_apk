package com.tencent.mm.plugin.favorite;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.g.a.gp.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements aw
{
  private com.tencent.mm.sdk.b.c qVf;
  
  public f()
  {
    AppMethodBeat.i(24613);
    this.qVf = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(gp paramAnonymousgp)
      {
        AppMethodBeat.i(24611);
        Object localObject1;
        Object localObject2;
        if ((paramAnonymousgp.dhl.dho != null) && ((paramAnonymousgp.dhl.dho instanceof o.a)) && (paramAnonymousgp.dhl.cZw != null) && ((paramAnonymousgp.dhl.cZw instanceof Context)))
        {
          localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramAnonymousgp.dhl.dcg);
          localObject2 = paramAnonymousgp.dhl.dhm;
          if ((bs.isNullOrNil((String)localObject2)) || ((((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 18) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 14))) {
            break label481;
          }
        }
        for (;;)
        {
          try
          {
            LinkedList localLinkedList = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.nxC;
            if (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 18) {
              break label497;
            }
            i = 1;
            if (i >= localLinkedList.size()) {
              break label491;
            }
            Object localObject3 = (agx)localLinkedList.get(i);
            if (((String)localObject2).startsWith(((agx)localObject3).dhw))
            {
              localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject1).cps();
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = paramAnonymousgp.dhl.dhn;
              ((com.tencent.mm.plugin.fav.a.g)localObject2).qIl = true;
              ((com.tencent.mm.plugin.fav.a.g)localObject2).qIm = ((com.tencent.mm.plugin.fav.a.g)localObject1);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).dhm = (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId + "_" + ((agx)localObject3).dhw);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.nxC = new LinkedList();
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.nxC.add(localObject3);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aJA(((agx)localObject3).title);
              if (((agx)localObject3).EzZ != null)
              {
                if (paramAnonymousgp.dhl.dhn == 6) {
                  ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.d(((agx)localObject3).EzZ.EAI);
                }
              }
              else
              {
                localObject1 = localObject2;
                if ((localObject1 != null) || (bs.isNullOrNil(paramAnonymousgp.dhl.dhp))) {
                  break label494;
                }
                localObject1 = b.acu(paramAnonymousgp.dhl.dhp);
                localObject2 = (o.a)paramAnonymousgp.dhl.dho;
                localObject3 = (Context)paramAnonymousgp.dhl.cZw;
                d.a((o.a)localObject2, (Context)localObject3, (com.tencent.mm.plugin.fav.a.g)localObject1);
                d.b((o.a)localObject2, (Context)localObject3, (com.tencent.mm.plugin.fav.a.g)localObject1);
                paramAnonymousgp.dhl.dcg = 0L;
                paramAnonymousgp.dhl.dhm = "";
                paramAnonymousgp.dhl.dho = null;
                paramAnonymousgp.dhl.cZw = null;
                AppMethodBeat.o(24611);
                return false;
              }
              if (paramAnonymousgp.dhl.dhn != 5) {
                continue;
              }
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.b(((agx)localObject3).EzZ.EAK);
              continue;
              continue;
            }
          }
          catch (Exception localException)
          {
            ac.e("MicroMsg.Fav.SubCoreFav", "FavInitConfirmDialogContentEvent callback : %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
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
    ac.i("MicroMsg.Fav.SubCoreFav", "onAccountPostReset updated:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    a.GpY.b(this.qVf);
    com.tencent.mm.kernel.g.b(y.class, new c());
    com.tencent.mm.kernel.g.b(ab.class, new e());
    AppMethodBeat.o(24614);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24615);
    a.GpY.d(this.qVf);
    ((n)com.tencent.mm.kernel.g.ad(n.class)).unregisterFTSUILogic(128);
    ((n)com.tencent.mm.kernel.g.ad(n.class)).unregisterFTSUILogic(4192);
    AppMethodBeat.o(24615);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.f
 * JD-Core Version:    0.7.0.1
 */