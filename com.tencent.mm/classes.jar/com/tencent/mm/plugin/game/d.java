package com.tencent.mm.plugin.game;

import android.content.Context;
import android.database.Cursor;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.c.a;
import com.tencent.mm.plugin.game.api.c.b;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.plugin.game.d.cb;
import com.tencent.mm.plugin.game.d.cd;
import com.tencent.mm.plugin.game.d.ck;
import com.tencent.mm.plugin.game.d.cu;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.e;
import com.tencent.mm.plugin.game.model.o.f;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class d
  implements com.tencent.mm.plugin.game.api.c
{
  public final int A(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(195610);
    ae.i("MicroMsg.GameExternalService", "fromUsername:%s, toUsername:%s", new Object[] { paramString1, paramString2 });
    if ((paramContext == null) || (bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(195610);
      return -1;
    }
    ba localba = a.cZy();
    if ((localba == null) || (localba.usJ == null) || (localba.usJ.uuf == null))
    {
      ae.i("MicroMsg.GameExternalService", "no Gift info");
      AppMethodBeat.o(195610);
      return -1;
    }
    ae.i("MicroMsg.GameExternalService", "GiftEntranceType:%d", new Object[] { Integer.valueOf(localba.usJ.uuf.nJA) });
    switch (localba.usJ.uuf.nJA)
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(195610);
        return -1;
      } while (bu.isNullOrNil(localba.usJ.uuf.uqf));
      localObject = new HashMap();
      ((HashMap)localObject).put("from_username", paramString1);
      ((HashMap)localObject).put("to_username", paramString2);
      paramString1 = com.tencent.mm.plugin.game.f.c.A(localba.usJ.uuf.uqf, (Map)localObject);
      ae.i("MicroMsg.GameExternalService", "Gift jumpUrl:%s", new Object[] { paramString1 });
      com.tencent.mm.plugin.game.f.c.aD(paramContext, paramString1);
      AppMethodBeat.o(195610);
      return 40;
    } while ((localba.usJ.uuf.uqJ == null) || (bu.isNullOrNil(localba.usJ.uuf.uqJ.ikm)));
    Object localObject = localba.usJ.uuf.uqJ.uuA;
    if (bu.isNullOrNil((String)localObject)) {}
    HashMap localHashMap;
    for (paramString1 = "?from_username=" + URLEncoder.encode(paramString1) + "&to_username=" + URLEncoder.encode(paramString2);; paramString1 = com.tencent.mm.plugin.game.f.c.A((String)localObject, localHashMap))
    {
      ae.i("MicroMsg.GameExternalService", "Gift Weapp, AppId:%s, Path:%s", new Object[] { localba.usJ.uuf.uqJ.ikm, paramString1 });
      com.tencent.mm.plugin.game.f.c.b(paramContext, localba.usJ.uuf.uqJ.ikm, paramString1, localba.usJ.uuf.uqJ.uuB);
      AppMethodBeat.o(195610);
      return 71;
      localHashMap = new HashMap();
      localHashMap.put("from_username", paramString1);
      localHashMap.put("to_username", paramString2);
    }
  }
  
  public final int HV(int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(195605);
    if (paramInt == 1) {
      i = 1;
    }
    while (paramInt == 2)
    {
      paramInt = ((f)g.ab(f.class)).cZl().Io(i);
      AppMethodBeat.o(195605);
      return paramInt;
    }
    AppMethodBeat.o(195605);
    return 0;
  }
  
  public final String HW(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(195606);
    Object localObject1;
    if (paramInt == 1) {
      localObject1 = ak.getContext().getString(2131766875);
    }
    Object localObject3;
    for (paramInt = 1;; paramInt = 2)
    {
      localObject3 = ((f)g.ab(f.class)).cZl().Im(paramInt);
      if (localObject3 != null) {
        break label182;
      }
      if (localObject2 != null)
      {
        ((o)localObject2).dbE();
        localObject3 = ((o)localObject2).umO.mText;
        localObject1 = localObject3;
        if (bu.isNullOrNil((String)localObject3)) {
          localObject1 = ((o)localObject2).umQ.mDesc;
        }
        if (!bu.isNullOrNil((String)localObject1)) {
          break label216;
        }
        localObject2 = ak.getContext().getString(2131766873);
        label99:
        paramInt = ((f)g.ab(f.class)).cZl().Io(paramInt);
        localObject1 = localObject2;
        if (paramInt > 1) {
          localObject1 = ak.getContext().getString(2131766889, new Object[] { Integer.valueOf(paramInt), localObject2 });
        }
      }
      AppMethodBeat.o(195606);
      return localObject1;
      if (paramInt != 2) {
        break;
      }
      localObject1 = ak.getContext().getString(2131766891);
    }
    AppMethodBeat.o(195606);
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
    AppMethodBeat.i(195607);
    if (((Boolean)g.ajR().ajA().get(am.a.IUP, Boolean.FALSE)).booleanValue())
    {
      parama.a(null);
      AppMethodBeat.o(195607);
      return;
    }
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195603);
        Object localObject = a.cZy();
        if ((localObject == null) || (((ba)localObject).usG == null) || (bu.isNullOrNil(((ba)localObject).usG.uuq)))
        {
          if (parama != null) {
            parama.a(null);
          }
          AppMethodBeat.o(195603);
          return;
        }
        localObject = ((f)g.ab(f.class)).cZl().dbU();
        if (parama != null) {
          parama.a((c.b)localObject);
        }
        AppMethodBeat.o(195603);
      }
    });
    AppMethodBeat.o(195607);
  }
  
  public final void cZi()
  {
    AppMethodBeat.i(195609);
    g.ajR().ajA().set(am.a.IUP, Boolean.TRUE);
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195604);
        ae.i("MicroMsg.GameMessageStorage", "deleteGameLifeChatMsg history ret:%s", new Object[] { Boolean.valueOf(((f)g.ab(f.class)).cZl().execSQL("GameRawMessage", "delete from GameRawMessage where rawXML like \"%<chatmsg%\"")) });
        AppMethodBeat.o(195604);
      }
    });
    AppMethodBeat.o(195609);
  }
  
  public final void fp(Context paramContext)
  {
    AppMethodBeat.i(195608);
    ba localba = a.cZy();
    if ((localba != null) && (localba.usG != null) && (!bu.isNullOrNil(localba.usG.uuq))) {
      com.tencent.mm.plugin.game.f.c.aD(paramContext, localba.usG.uuq);
    }
    AppMethodBeat.o(195608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d
 * JD-Core Version:    0.7.0.1
 */