package com.tencent.mm.plugin.favorite;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements bd
{
  private IListener tnp;
  
  public f()
  {
    AppMethodBeat.i(24613);
    this.tnp = new IListener()
    {
      private static boolean a(gx paramAnonymousgx)
      {
        AppMethodBeat.i(24611);
        Object localObject1;
        Object localObject2;
        if ((paramAnonymousgx.dLa.dLd != null) && ((paramAnonymousgx.dLa.dLd instanceof o.a)) && (paramAnonymousgx.dLa.dDg != null) && ((paramAnonymousgx.dLa.dDg instanceof Context)))
        {
          localObject1 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramAnonymousgx.dLa.dFW);
          localObject2 = paramAnonymousgx.dLa.dLb;
          if ((Util.isNullOrNil((String)localObject2)) || ((((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 18) && (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 14))) {
            break label481;
          }
        }
        for (;;)
        {
          try
          {
            LinkedList localLinkedList = ((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto.ppH;
            if (((com.tencent.mm.plugin.fav.a.g)localObject1).field_type != 18) {
              break label497;
            }
            i = 1;
            if (i >= localLinkedList.size()) {
              break label491;
            }
            Object localObject3 = (aml)localLinkedList.get(i);
            if (((String)localObject2).startsWith(((aml)localObject3).dLl))
            {
              localObject2 = ((com.tencent.mm.plugin.fav.a.g)localObject1).cUC();
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_type = paramAnonymousgx.dLa.dLc;
              ((com.tencent.mm.plugin.fav.a.g)localObject2).tad = true;
              ((com.tencent.mm.plugin.fav.a.g)localObject2).tae = ((com.tencent.mm.plugin.fav.a.g)localObject1);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).dLb = (((com.tencent.mm.plugin.fav.a.g)localObject1).field_localId + "_" + ((aml)localObject3).dLl);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto = com.tencent.mm.plugin.fav.a.a.c.c(((com.tencent.mm.plugin.fav.a.g)localObject1).field_favProto);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ppH = new LinkedList();
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.ppH.add(localObject3);
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.bhd(((aml)localObject3).title);
              if (((aml)localObject3).Lwh != null)
              {
                if (paramAnonymousgx.dLa.dLc == 6) {
                  ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.d(((aml)localObject3).Lwh.LwQ);
                }
              }
              else
              {
                localObject1 = localObject2;
                if ((localObject1 != null) || (Util.isNullOrNil(paramAnonymousgx.dLa.dLe))) {
                  break label494;
                }
                localObject1 = b.arO(paramAnonymousgx.dLa.dLe);
                localObject2 = (o.a)paramAnonymousgx.dLa.dLd;
                localObject3 = (Context)paramAnonymousgx.dLa.dDg;
                d.a((o.a)localObject2, (Context)localObject3, (com.tencent.mm.plugin.fav.a.g)localObject1);
                d.b((o.a)localObject2, (Context)localObject3, (com.tencent.mm.plugin.fav.a.g)localObject1);
                paramAnonymousgx.dLa.dFW = 0L;
                paramAnonymousgx.dLa.dLb = "";
                paramAnonymousgx.dLa.dLd = null;
                paramAnonymousgx.dLa.dDg = null;
                AppMethodBeat.o(24611);
                return false;
              }
              if (paramAnonymousgx.dLa.dLc != 5) {
                continue;
              }
              ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.b(((aml)localObject3).Lwh.LwS);
              continue;
              continue;
            }
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.Fav.SubCoreFav", "FavInitConfirmDialogContentEvent callback : %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
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
    Log.i("MicroMsg.Fav.SubCoreFav", "onAccountPostReset updated:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    EventCenter.instance.add(this.tnp);
    com.tencent.mm.kernel.g.b(y.class, new c());
    com.tencent.mm.kernel.g.b(ab.class, new e());
    AppMethodBeat.o(24614);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24615);
    EventCenter.instance.removeListener(this.tnp);
    ((n)com.tencent.mm.kernel.g.ah(n.class)).unregisterFTSUILogic(128);
    ((n)com.tencent.mm.kernel.g.ah(n.class)).unregisterFTSUILogic(4192);
    AppMethodBeat.o(24615);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.f
 * JD-Core Version:    0.7.0.1
 */