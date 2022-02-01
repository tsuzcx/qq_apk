package com.tencent.mm.plugin.game;

import android.content.Context;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.c.a;
import com.tencent.mm.plugin.game.api.c.b;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.f;
import com.tencent.mm.plugin.game.model.o.g;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.protobuf.bc;
import com.tencent.mm.plugin.game.protobuf.cc;
import com.tencent.mm.plugin.game.protobuf.ce;
import com.tencent.mm.plugin.game.protobuf.cl;
import com.tencent.mm.plugin.game.protobuf.cv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class d
  implements com.tencent.mm.plugin.game.api.c
{
  public final int H(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(204271);
    Log.i("MicroMsg.GameExternalService", "fromUsername:%s, toUsername:%s", new Object[] { paramString1, paramString2 });
    if ((paramContext == null) || (Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(204271);
      return -1;
    }
    bc localbc = a.ewg();
    if ((localbc == null) || (localbc.CPi == null) || (localbc.CPi.CQq == null))
    {
      Log.i("MicroMsg.GameExternalService", "no Gift info");
      AppMethodBeat.o(204271);
      return -1;
    }
    Log.i("MicroMsg.GameExternalService", "GiftEntranceType:%d", new Object[] { Integer.valueOf(localbc.CPi.CQq.rWu) });
    switch (localbc.CPi.CQq.rWu)
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(204271);
        return -1;
      } while (Util.isNullOrNil(localbc.CPi.CQq.CMD));
      localObject = new HashMap();
      ((HashMap)localObject).put("from_username", paramString1);
      ((HashMap)localObject).put("to_username", paramString2);
      paramString1 = com.tencent.mm.plugin.game.d.c.H(localbc.CPi.CQq.CMD, (Map)localObject);
      Log.i("MicroMsg.GameExternalService", "Gift jumpUrl:%s", new Object[] { paramString1 });
      com.tencent.mm.plugin.game.d.c.aY(paramContext, paramString1);
      AppMethodBeat.o(204271);
      return 40;
    } while ((localbc.CPi.CQq.CNh == null) || (Util.isNullOrNil(localbc.CPi.CQq.CNh.lVG)));
    Object localObject = localbc.CPi.CQq.CNh.CqK;
    if (Util.isNullOrNil((String)localObject)) {}
    HashMap localHashMap;
    for (paramString1 = "?from_username=" + URLEncoder.encode(paramString1) + "&to_username=" + URLEncoder.encode(paramString2);; paramString1 = com.tencent.mm.plugin.game.d.c.H((String)localObject, localHashMap))
    {
      Log.i("MicroMsg.GameExternalService", "Gift Weapp, AppId:%s, Path:%s", new Object[] { localbc.CPi.CQq.CNh.lVG, paramString1 });
      com.tencent.mm.plugin.game.d.c.e(paramContext, localbc.CPi.CQq.CNh.lVG, paramString1, localbc.CPi.CQq.CNh.CQL);
      AppMethodBeat.o(204271);
      return 71;
      localHashMap = new HashMap();
      localHashMap.put("from_username", paramString1);
      localHashMap.put("to_username", paramString2);
    }
  }
  
  public final int Tn(int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(204265);
    if (paramInt == 1) {
      i = 1;
    }
    while (paramInt == 2)
    {
      paramInt = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().TJ(i);
      AppMethodBeat.o(204265);
      return paramInt;
    }
    AppMethodBeat.o(204265);
    return 0;
  }
  
  public final String To(int paramInt)
  {
    AppMethodBeat.i(204267);
    Object localObject1;
    if (paramInt == 1)
    {
      localObject1 = MMApplicationContext.getContext().getString(g.i.CoV);
      paramInt = 1;
      o localo = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().TH(paramInt);
      if (localo != null)
      {
        localo.eyt();
        localObject2 = localo.CJh.mText;
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject1 = localo.CJj.mDesc;
        }
        if (!Util.isNullOrNil((String)localObject1)) {
          break label180;
        }
      }
    }
    label180:
    for (Object localObject2 = MMApplicationContext.getContext().getString(g.i.CoB);; localObject2 = localObject1)
    {
      paramInt = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().TJ(paramInt);
      localObject1 = localObject2;
      if (paramInt > 1) {
        localObject1 = MMApplicationContext.getContext().getString(g.i.Cpk, new Object[] { Integer.valueOf(paramInt), localObject2 });
      }
      AppMethodBeat.o(204267);
      return localObject1;
      if (paramInt == 2)
      {
        localObject1 = MMApplicationContext.getContext().getString(g.i.Cpz);
        paramInt = 2;
        break;
      }
      AppMethodBeat.o(204267);
      return "";
    }
  }
  
  public final void a(final c.a parama)
  {
    AppMethodBeat.i(204268);
    if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vrk, Boolean.FALSE)).booleanValue())
    {
      parama.a(null);
      AppMethodBeat.o(204268);
      return;
    }
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198982);
        Object localObject = a.ewg();
        if ((localObject == null) || (((bc)localObject).CPf == null) || (Util.isNullOrNil(((bc)localObject).CPf.CQB)))
        {
          if (parama != null) {
            parama.a(null);
          }
          AppMethodBeat.o(198982);
          return;
        }
        localObject = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().eyJ();
        if (parama != null) {
          parama.a((c.b)localObject);
        }
        AppMethodBeat.o(198982);
      }
    });
    AppMethodBeat.o(204268);
  }
  
  public final void evl()
  {
    AppMethodBeat.i(204270);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vrk, Boolean.TRUE);
    com.tencent.e.h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193849);
        Log.i("MicroMsg.GameMessageStorage", "deleteGameLifeChatMsg history ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evo().execSQL("GameRawMessage", "delete from GameRawMessage where rawXML like \"%<chatmsg%\"")) });
        AppMethodBeat.o(193849);
      }
    });
    AppMethodBeat.o(204270);
  }
  
  public final void go(Context paramContext)
  {
    AppMethodBeat.i(204269);
    bc localbc = a.ewg();
    if ((localbc != null) && (localbc.CPf != null) && (!Util.isNullOrNil(localbc.CPf.CQB))) {
      com.tencent.mm.plugin.game.d.c.aY(paramContext, localbc.CPf.CQB);
    }
    AppMethodBeat.o(204269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d
 * JD-Core Version:    0.7.0.1
 */