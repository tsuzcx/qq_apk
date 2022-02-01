package com.tencent.mm.plugin.game;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.c.a;
import com.tencent.mm.plugin.game.api.c.b;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.f;
import com.tencent.mm.plugin.game.model.o.g;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.protobuf.bd;
import com.tencent.mm.plugin.game.protobuf.cd;
import com.tencent.mm.plugin.game.protobuf.cf;
import com.tencent.mm.plugin.game.protobuf.cn;
import com.tencent.mm.plugin.game.protobuf.cy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.threadpool.i;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class d
  implements com.tencent.mm.plugin.game.api.c
{
  public final int H(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(275301);
    Log.i("MicroMsg.GameExternalService", "fromUsername:%s, toUsername:%s", new Object[] { paramString1, paramString2 });
    if ((paramContext == null) || (Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(275301);
      return -1;
    }
    bd localbd = a.fDW();
    if ((localbd == null) || (localbd.IJs == null) || (localbd.IJs.IKA == null))
    {
      Log.i("MicroMsg.GameExternalService", "no Gift info");
      AppMethodBeat.o(275301);
      return -1;
    }
    Log.i("MicroMsg.GameExternalService", "GiftEntranceType:%d", new Object[] { Integer.valueOf(localbd.IJs.IKA.vhJ) });
    switch (localbd.IJs.IKA.vhJ)
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(275301);
        return -1;
      } while (Util.isNullOrNil(localbd.IJs.IKA.IGI));
      localObject = new HashMap();
      ((HashMap)localObject).put("from_username", paramString1);
      ((HashMap)localObject).put("to_username", paramString2);
      paramString1 = com.tencent.mm.plugin.game.d.c.P(localbd.IJs.IKA.IGI, (Map)localObject);
      Log.i("MicroMsg.GameExternalService", "Gift jumpUrl:%s", new Object[] { paramString1 });
      com.tencent.mm.plugin.game.d.c.ba(paramContext, paramString1);
      AppMethodBeat.o(275301);
      return 40;
    } while ((localbd.IJs.IKA.IHm == null) || (Util.isNullOrNil(localbd.IJs.IKA.IHm.oOI)));
    Object localObject = localbd.IJs.IKA.IHm.IcT;
    if (Util.isNullOrNil((String)localObject)) {}
    HashMap localHashMap;
    for (paramString1 = "?from_username=" + URLEncoder.encode(paramString1) + "&to_username=" + URLEncoder.encode(paramString2);; paramString1 = com.tencent.mm.plugin.game.d.c.P((String)localObject, localHashMap))
    {
      Log.i("MicroMsg.GameExternalService", "Gift Weapp, AppId:%s, Path:%s", new Object[] { localbd.IJs.IKA.IHm.oOI, paramString1 });
      com.tencent.mm.plugin.game.d.c.f(paramContext, localbd.IJs.IKA.IHm.oOI, paramString1, localbd.IJs.IKA.IHm.IKZ);
      AppMethodBeat.o(275301);
      return 71;
      localHashMap = new HashMap();
      localHashMap.put("from_username", paramString1);
      localHashMap.put("to_username", paramString2);
    }
  }
  
  public final int WY(int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(275291);
    if (paramInt == 1) {
      i = 1;
    }
    while (paramInt == 2)
    {
      paramInt = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XD(i);
      AppMethodBeat.o(275291);
      return paramInt;
    }
    AppMethodBeat.o(275291);
    return 0;
  }
  
  public final String WZ(int paramInt)
  {
    AppMethodBeat.i(275292);
    Object localObject1;
    if (paramInt == 1)
    {
      localObject1 = MMApplicationContext.getContext().getString(h.i.Ibd);
      paramInt = 1;
      o localo = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XB(paramInt);
      if (localo != null)
      {
        localo.fGp();
        localObject2 = localo.IDs.mText;
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject1 = localo.IDu.mDesc;
        }
        if (!Util.isNullOrNil((String)localObject1)) {
          break label180;
        }
      }
    }
    label180:
    for (Object localObject2 = MMApplicationContext.getContext().getString(h.i.IaJ);; localObject2 = localObject1)
    {
      paramInt = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().XD(paramInt);
      localObject1 = localObject2;
      if (paramInt > 1) {
        localObject1 = MMApplicationContext.getContext().getString(h.i.Ibs, new Object[] { Integer.valueOf(paramInt), localObject2 });
      }
      AppMethodBeat.o(275292);
      return localObject1;
      if (paramInt == 2)
      {
        localObject1 = MMApplicationContext.getContext().getString(h.i.IbH);
        paramInt = 2;
        break;
      }
      AppMethodBeat.o(275292);
      return "";
    }
  }
  
  public final void a(final c.a parama)
  {
    AppMethodBeat.i(275293);
    if (((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acSM, Boolean.FALSE)).booleanValue())
    {
      if (parama != null) {
        parama.invoke(null);
      }
      AppMethodBeat.o(275293);
      return;
    }
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(275314);
        Object localObject = a.fDW();
        if ((localObject == null) || (((bd)localObject).IJp == null) || (Util.isNullOrNil(((bd)localObject).IJp.IKN)))
        {
          if (parama != null) {
            parama.invoke(null);
          }
          AppMethodBeat.o(275314);
          return;
        }
        localObject = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().fGF();
        if (parama != null) {
          parama.invoke((c.b)localObject);
        }
        AppMethodBeat.o(275314);
      }
    });
    AppMethodBeat.o(275293);
  }
  
  public final void fCe()
  {
    AppMethodBeat.i(275297);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acSM, Boolean.TRUE);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(275311);
        Log.i("MicroMsg.GameMessageStorage", "deleteGameLifeChatMsg history ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.api.f.class)).fCh().execSQL("GameRawMessage", "delete from GameRawMessage where rawXML like \"%<chatmsg%\"")) });
        AppMethodBeat.o(275311);
      }
    });
    AppMethodBeat.o(275297);
  }
  
  public final void hH(Context paramContext)
  {
    AppMethodBeat.i(275296);
    bd localbd = a.fDW();
    if ((localbd != null) && (localbd.IJp != null) && (!Util.isNullOrNil(localbd.IJp.IKN))) {
      com.tencent.mm.plugin.game.d.c.ba(paramContext, localbd.IJp.IKN);
    }
    AppMethodBeat.o(275296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d
 * JD-Core Version:    0.7.0.1
 */