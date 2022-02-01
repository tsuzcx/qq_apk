package com.tencent.mm.plugin.favorite;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.go;
import com.tencent.mm.g.a.go.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements aw
{
  private com.tencent.mm.sdk.b.c qmD;
  
  public f()
  {
    AppMethodBeat.i(24613);
    this.qmD = new com.tencent.mm.sdk.b.c()
    {
      private static boolean a(go paramAnonymousgo)
      {
        AppMethodBeat.i(24611);
        Object localObject1;
        Object localObject2;
        if ((paramAnonymousgo.djQ.djT != null) && ((paramAnonymousgo.djQ.djT instanceof o.a)) && (paramAnonymousgo.djQ.dbX != null) && ((paramAnonymousgo.djQ.dbX instanceof Context)))
        {
          localObject1 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramAnonymousgo.djQ.deL);
          localObject2 = paramAnonymousgo.djQ.djR;
          if ((bt.isNullOrNil((String)localObject2)) || ((((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 18) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 14))) {
            break label481;
          }
        }
        for (;;)
        {
          try
          {
            LinkedList localLinkedList = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.mVb;
            if (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 18) {
              break label497;
            }
            i = 1;
            if (i >= localLinkedList.size()) {
              break label491;
            }
            Object localObject3 = (afy)localLinkedList.get(i);
            if (((String)localObject2).startsWith(((afy)localObject3).dkb))
            {
              localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject1).chL();
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = paramAnonymousgo.djQ.djS;
              ((com.tencent.mm.plugin.fav.a.g)localObject2).pZE = true;
              ((com.tencent.mm.plugin.fav.a.g)localObject2).pZF = ((com.tencent.mm.plugin.fav.a.g)localObject1);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).djR = (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId + "_" + ((afy)localObject3).dkb);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.mVb = new LinkedList();
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.mVb.add(localObject3);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aEj(((afy)localObject3).title);
              if (((afy)localObject3).DgT != null)
              {
                if (paramAnonymousgo.djQ.djS == 6) {
                  ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.d(((afy)localObject3).DgT.DhC);
                }
              }
              else
              {
                localObject1 = localObject2;
                if ((localObject1 != null) || (bt.isNullOrNil(paramAnonymousgo.djQ.djU))) {
                  break label494;
                }
                localObject1 = b.XY(paramAnonymousgo.djQ.djU);
                localObject2 = (o.a)paramAnonymousgo.djQ.djT;
                localObject3 = (Context)paramAnonymousgo.djQ.dbX;
                d.a((o.a)localObject2, (Context)localObject3, (com.tencent.mm.plugin.fav.a.g)localObject1);
                d.b((o.a)localObject2, (Context)localObject3, (com.tencent.mm.plugin.fav.a.g)localObject1);
                paramAnonymousgo.djQ.deL = 0L;
                paramAnonymousgo.djQ.djR = "";
                paramAnonymousgo.djQ.djT = null;
                paramAnonymousgo.djQ.dbX = null;
                AppMethodBeat.o(24611);
                return false;
              }
              if (paramAnonymousgo.djQ.djS != 5) {
                continue;
              }
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.b(((afy)localObject3).DgT.DhE);
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
    a.ESL.b(this.qmD);
    com.tencent.mm.kernel.g.b(y.class, new c());
    com.tencent.mm.kernel.g.b(ab.class, new e());
    AppMethodBeat.o(24614);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24615);
    a.ESL.d(this.qmD);
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