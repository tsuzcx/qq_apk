package com.tencent.mm.plugin.game;

import android.content.Context;
import android.database.Cursor;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.c.a;
import com.tencent.mm.plugin.game.api.c.b;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.e;
import com.tencent.mm.plugin.game.model.o.f;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.protobuf.bb;
import com.tencent.mm.plugin.game.protobuf.cb;
import com.tencent.mm.plugin.game.protobuf.cd;
import com.tencent.mm.plugin.game.protobuf.ck;
import com.tencent.mm.plugin.game.protobuf.cu;
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
  public final int C(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(204093);
    Log.i("MicroMsg.GameExternalService", "fromUsername:%s, toUsername:%s", new Object[] { paramString1, paramString2 });
    if ((paramContext == null) || (Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(204093);
      return -1;
    }
    bb localbb = a.dSY();
    if ((localbb == null) || (localbb.xLb == null) || (localbb.xLb.xMh == null))
    {
      Log.i("MicroMsg.GameExternalService", "no Gift info");
      AppMethodBeat.o(204093);
      return -1;
    }
    Log.i("MicroMsg.GameExternalService", "GiftEntranceType:%d", new Object[] { Integer.valueOf(localbb.xLb.xMh.oUv) });
    switch (localbb.xLb.xMh.oUv)
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(204093);
        return -1;
      } while (Util.isNullOrNil(localbb.xLb.xMh.xIy));
      localObject = new HashMap();
      ((HashMap)localObject).put("from_username", paramString1);
      ((HashMap)localObject).put("to_username", paramString2);
      paramString1 = com.tencent.mm.plugin.game.e.c.F(localbb.xLb.xMh.xIy, (Map)localObject);
      Log.i("MicroMsg.GameExternalService", "Gift jumpUrl:%s", new Object[] { paramString1 });
      com.tencent.mm.plugin.game.e.c.aQ(paramContext, paramString1);
      AppMethodBeat.o(204093);
      return 40;
    } while ((localbb.xLb.xMh.xJb == null) || (Util.isNullOrNil(localbb.xLb.xMh.xJb.jfi)));
    Object localObject = localbb.xLb.xMh.xJb.xut;
    if (Util.isNullOrNil((String)localObject)) {}
    HashMap localHashMap;
    for (paramString1 = "?from_username=" + URLEncoder.encode(paramString1) + "&to_username=" + URLEncoder.encode(paramString2);; paramString1 = com.tencent.mm.plugin.game.e.c.F((String)localObject, localHashMap))
    {
      Log.i("MicroMsg.GameExternalService", "Gift Weapp, AppId:%s, Path:%s", new Object[] { localbb.xLb.xMh.xJb.jfi, paramString1 });
      com.tencent.mm.plugin.game.e.c.c(paramContext, localbb.xLb.xMh.xJb.jfi, paramString1, localbb.xLb.xMh.xJb.xMC);
      AppMethodBeat.o(204093);
      return 71;
      localHashMap = new HashMap();
      localHashMap.put("from_username", paramString1);
      localHashMap.put("to_username", paramString2);
    }
  }
  
  public final int NY(int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(204088);
    if (paramInt == 1) {
      i = 1;
    }
    while (paramInt == 2)
    {
      paramInt = ((f)g.af(f.class)).dSK().Op(i);
      AppMethodBeat.o(204088);
      return paramInt;
    }
    AppMethodBeat.o(204088);
    return 0;
  }
  
  public final String NZ(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(204089);
    Object localObject1;
    if (paramInt == 1) {
      localObject1 = MMApplicationContext.getContext().getString(2131761229);
    }
    Object localObject3;
    for (paramInt = 1;; paramInt = 2)
    {
      localObject3 = ((f)g.af(f.class)).dSK().On(paramInt);
      if (localObject3 != null) {
        break label182;
      }
      if (localObject2 != null)
      {
        ((o)localObject2).dVl();
        localObject3 = ((o)localObject2).xFg.mText;
        localObject1 = localObject3;
        if (Util.isNullOrNil((String)localObject3)) {
          localObject1 = ((o)localObject2).xFi.mDesc;
        }
        if (!Util.isNullOrNil((String)localObject1)) {
          break label216;
        }
        localObject2 = MMApplicationContext.getContext().getString(2131761177);
        label99:
        paramInt = ((f)g.af(f.class)).dSK().Op(paramInt);
        localObject1 = localObject2;
        if (paramInt > 1) {
          localObject1 = MMApplicationContext.getContext().getString(2131761293, new Object[] { Integer.valueOf(paramInt), localObject2 });
        }
      }
      AppMethodBeat.o(204089);
      return localObject1;
      if (paramInt != 2) {
        break;
      }
      localObject1 = MMApplicationContext.getContext().getString(2131761319);
    }
    AppMethodBeat.o(204089);
    return "";
    label182:
    if (((Cursor)localObject3).moveToFirst())
    {
      localObject2 = new o();
      ((o)localObject2).convertFrom((Cursor)localObject3);
    }
    for (;;)
    {
      ((Cursor)localObject3).close();
      break;
      label216:
      localObject2 = localObject1;
      break label99;
      localObject2 = null;
    }
  }
  
  public final void a(final c.a parama)
  {
    AppMethodBeat.i(204090);
    if (((Boolean)g.aAh().azQ().get(ar.a.Odd, Boolean.FALSE)).booleanValue())
    {
      parama.a(null);
      AppMethodBeat.o(204090);
      return;
    }
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204086);
        Object localObject = a.dSY();
        if ((localObject == null) || (((bb)localObject).xKY == null) || (Util.isNullOrNil(((bb)localObject).xKY.xMs)))
        {
          if (parama != null) {
            parama.a(null);
          }
          AppMethodBeat.o(204086);
          return;
        }
        localObject = ((f)g.af(f.class)).dSK().dVB();
        if (parama != null) {
          parama.a((c.b)localObject);
        }
        AppMethodBeat.o(204086);
      }
    });
    AppMethodBeat.o(204090);
  }
  
  public final void dSH()
  {
    AppMethodBeat.i(204092);
    g.aAh().azQ().set(ar.a.Odd, Boolean.TRUE);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204087);
        Log.i("MicroMsg.GameMessageStorage", "deleteGameLifeChatMsg history ret:%s", new Object[] { Boolean.valueOf(((f)g.af(f.class)).dSK().execSQL("GameRawMessage", "delete from GameRawMessage where rawXML like \"%<chatmsg%\"")) });
        AppMethodBeat.o(204087);
      }
    });
    AppMethodBeat.o(204092);
  }
  
  public final void fV(Context paramContext)
  {
    AppMethodBeat.i(204091);
    bb localbb = a.dSY();
    if ((localbb != null) && (localbb.xKY != null) && (!Util.isNullOrNil(localbb.xKY.xMs))) {
      com.tencent.mm.plugin.game.e.c.aQ(paramContext, localbb.xKY.xMs);
    }
    AppMethodBeat.o(204091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d
 * JD-Core Version:    0.7.0.1
 */