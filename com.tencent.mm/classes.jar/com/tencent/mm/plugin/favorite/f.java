package com.tencent.mm.plugin.favorite;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.he;
import com.tencent.mm.f.a.he.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements be
{
  private IListener wTN;
  
  public f()
  {
    AppMethodBeat.i(24613);
    this.wTN = new IListener()
    {
      private static boolean a(he paramAnonymoushe)
      {
        AppMethodBeat.i(24611);
        Object localObject1;
        Object localObject2;
        if ((paramAnonymoushe.fDP.fDS != null) && ((paramAnonymoushe.fDP.fDS instanceof o.a)) && (paramAnonymoushe.fDP.fvM != null) && ((paramAnonymoushe.fDP.fvM instanceof Context)))
        {
          localObject1 = ((ag)h.ag(ag.class)).getFavItemInfoStorage().Km(paramAnonymoushe.fDP.fyE);
          localObject2 = paramAnonymoushe.fDP.fDQ;
          if ((Util.isNullOrNil((String)localObject2)) || (((localObject1 == null) || (((g)localObject1).field_type != 18)) && (((g)localObject1).field_type != 14))) {
            break label485;
          }
        }
        for (;;)
        {
          try
          {
            LinkedList localLinkedList = ((g)localObject1).field_favProto.syG;
            if (((g)localObject1).field_type != 18) {
              break label501;
            }
            i = 1;
            if (i >= localLinkedList.size()) {
              break label495;
            }
            Object localObject3 = (anm)localLinkedList.get(i);
            if (((String)localObject2).startsWith(((anm)localObject3).fEa))
            {
              localObject2 = ((g)localObject1).djI();
              ((g)localObject2).field_type = paramAnonymoushe.fDP.fDR;
              ((g)localObject2).wGh = true;
              ((g)localObject2).wGi = ((g)localObject1);
              ((g)localObject2).fDQ = (((g)localObject1).field_localId + "_" + ((anm)localObject3).fEa);
              ((g)localObject2).field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(((g)localObject1).field_favProto);
              ((g)localObject2).field_favProto.syG = new LinkedList();
              ((g)localObject2).field_favProto.syG.add(localObject3);
              ((g)localObject2).field_favProto.btv(((anm)localObject3).title);
              if (((anm)localObject3).SyG != null)
              {
                if (paramAnonymoushe.fDP.fDR == 6) {
                  ((g)localObject2).field_favProto.d(((anm)localObject3).SyG.Szp);
                }
              }
              else
              {
                localObject1 = localObject2;
                if ((localObject1 != null) || (Util.isNullOrNil(paramAnonymoushe.fDP.fDT))) {
                  break label498;
                }
                localObject1 = b.azP(paramAnonymoushe.fDP.fDT);
                localObject2 = (o.a)paramAnonymoushe.fDP.fDS;
                localObject3 = (Context)paramAnonymoushe.fDP.fvM;
                d.a((o.a)localObject2, (Context)localObject3, (g)localObject1);
                d.b((o.a)localObject2, (Context)localObject3, (g)localObject1);
                paramAnonymoushe.fDP.fyE = 0L;
                paramAnonymoushe.fDP.fDQ = "";
                paramAnonymoushe.fDP.fDS = null;
                paramAnonymoushe.fDP.fvM = null;
                AppMethodBeat.o(24611);
                return false;
              }
              if (paramAnonymoushe.fDP.fDR != 5) {
                continue;
              }
              ((g)localObject2).field_favProto.c(((anm)localObject3).SyG.Szr);
              continue;
              continue;
            }
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.Fav.SubCoreFav", "FavInitConfirmDialogContentEvent callback : %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
          }
          label485:
          i += 1;
          continue;
          label495:
          continue;
          label498:
          continue;
          label501:
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
    Log.i("MicroMsg.Fav.SubCoreFav", "onAccountPostReset updated:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    EventCenter.instance.add(this.wTN);
    h.b(z.class, new c());
    h.b(ac.class, new e());
    AppMethodBeat.o(24614);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24615);
    EventCenter.instance.removeListener(this.wTN);
    ((n)h.ag(n.class)).unregisterFTSUILogic(128);
    ((n)h.ag(n.class)).unregisterFTSUILogic(4192);
    AppMethodBeat.o(24615);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.f
 * JD-Core Version:    0.7.0.1
 */