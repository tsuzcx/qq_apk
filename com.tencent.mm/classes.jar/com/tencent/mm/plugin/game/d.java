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
import com.tencent.mm.plugin.game.d.au;
import com.tencent.mm.plugin.game.d.bu;
import com.tencent.mm.plugin.game.d.bw;
import com.tencent.mm.plugin.game.d.cd;
import com.tencent.mm.plugin.game.d.cm;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.o.d;
import com.tencent.mm.plugin.game.model.o.e;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class d
  implements com.tencent.mm.plugin.game.api.c
{
  public final int A(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(206802);
    ad.i("MicroMsg.GameExternalService", "fromUsername:%s, toUsername:%s", new Object[] { paramString1, paramString2 });
    if ((paramContext == null) || (bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(206802);
      return -1;
    }
    au localau = a.cWU();
    if ((localau == null) || (localau.uhm == null) || (localau.uhm.uiH == null))
    {
      ad.i("MicroMsg.GameExternalService", "no Gift info");
      AppMethodBeat.o(206802);
      return -1;
    }
    ad.i("MicroMsg.GameExternalService", "GiftEntranceType:%d", new Object[] { Integer.valueOf(localau.uhm.uiH.nEf) });
    switch (localau.uhm.uiH.nEf)
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(206802);
        return -1;
      } while (bt.isNullOrNil(localau.uhm.uiH.ueY));
      localObject = new HashMap();
      ((HashMap)localObject).put("from_username", paramString1);
      ((HashMap)localObject).put("to_username", paramString2);
      paramString1 = com.tencent.mm.plugin.game.f.c.z(localau.uhm.uiH.ueY, (Map)localObject);
      ad.i("MicroMsg.GameExternalService", "Gift jumpUrl:%s", new Object[] { paramString1 });
      com.tencent.mm.plugin.game.f.c.aB(paramContext, paramString1);
      AppMethodBeat.o(206802);
      return 40;
    } while ((localau.uhm.uiH.uiI == null) || (bt.isNullOrNil(localau.uhm.uiH.uiI.iht)));
    Object localObject = localau.uhm.uiH.uiI.ujc;
    if (bt.isNullOrNil((String)localObject)) {}
    HashMap localHashMap;
    for (paramString1 = "?from_username=" + URLEncoder.encode(paramString1) + "&to_username=" + URLEncoder.encode(paramString2);; paramString1 = com.tencent.mm.plugin.game.f.c.z((String)localObject, localHashMap))
    {
      ad.i("MicroMsg.GameExternalService", "Gift Weapp, AppId:%s, Path:%s", new Object[] { localau.uhm.uiH.uiI.iht, paramString1 });
      com.tencent.mm.plugin.game.f.c.b(paramContext, localau.uhm.uiH.uiI.iht, paramString1, localau.uhm.uiH.uiI.ujd);
      AppMethodBeat.o(206802);
      return 71;
      localHashMap = new HashMap();
      localHashMap.put("from_username", paramString1);
      localHashMap.put("to_username", paramString2);
    }
  }
  
  public final int Hy(int paramInt)
  {
    int i = 2;
    AppMethodBeat.i(206796);
    if (paramInt == 1) {
      i = 1;
    }
    while (paramInt == 2)
    {
      paramInt = ((f)g.ab(f.class)).cWH().HR(i);
      AppMethodBeat.o(206796);
      return paramInt;
    }
    AppMethodBeat.o(206796);
    return 0;
  }
  
  public final String Hz(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(206797);
    Object localObject1;
    if (paramInt == 1) {
      localObject1 = aj.getContext().getString(2131766875);
    }
    Object localObject3;
    for (paramInt = 1;; paramInt = 2)
    {
      localObject3 = ((f)g.ab(f.class)).cWH().HP(paramInt);
      if (localObject3 != null) {
        break label182;
      }
      if (localObject2 != null)
      {
        ((o)localObject2).cYU();
        localObject3 = ((o)localObject2).ubM.mText;
        localObject1 = localObject3;
        if (bt.isNullOrNil((String)localObject3)) {
          localObject1 = ((o)localObject2).ubO.mDesc;
        }
        if (!bt.isNullOrNil((String)localObject1)) {
          break label216;
        }
        localObject2 = aj.getContext().getString(2131766873);
        label99:
        paramInt = ((f)g.ab(f.class)).cWH().HR(paramInt);
        localObject1 = localObject2;
        if (paramInt > 1) {
          localObject1 = aj.getContext().getString(2131766889, new Object[] { Integer.valueOf(paramInt), localObject2 });
        }
      }
      AppMethodBeat.o(206797);
      return localObject1;
      if (paramInt != 2) {
        break;
      }
      localObject1 = aj.getContext().getString(2131766891);
    }
    AppMethodBeat.o(206797);
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
    AppMethodBeat.i(206798);
    if (((Boolean)g.ajC().ajl().get(al.a.IAq, Boolean.FALSE)).booleanValue())
    {
      parama.a(null);
      AppMethodBeat.o(206798);
      return;
    }
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206794);
        Object localObject = a.cWU();
        if ((localObject == null) || (((au)localObject).uhj == null) || (bt.isNullOrNil(((au)localObject).uhj.uiT)))
        {
          if (parama != null) {
            parama.a(null);
          }
          AppMethodBeat.o(206794);
          return;
        }
        localObject = ((f)g.ab(f.class)).cWH().cZj();
        if (parama != null) {
          parama.a((c.b)localObject);
        }
        AppMethodBeat.o(206794);
      }
    });
    AppMethodBeat.o(206798);
  }
  
  public final void cWD()
  {
    AppMethodBeat.i(206800);
    g.ajC().ajl().set(al.a.IAq, Boolean.TRUE);
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206795);
        ad.i("MicroMsg.GameMessageStorage", "deleteGameLifeChatMsg history ret:%s", new Object[] { Boolean.valueOf(((f)g.ab(f.class)).cWH().execSQL("GameRawMessage", "delete from GameRawMessage where rawXML like \"%<chatmsg%\"")) });
        AppMethodBeat.o(206795);
      }
    });
    AppMethodBeat.o(206800);
  }
  
  public final boolean cWE()
  {
    AppMethodBeat.i(206801);
    au localau = a.cWU();
    if ((localau != null) && (localau.uhm != null) && (localau.uhm.uiH != null) && (localau.uhm.uiH.nEf != 0))
    {
      AppMethodBeat.o(206801);
      return true;
    }
    AppMethodBeat.o(206801);
    return false;
  }
  
  public final void fl(Context paramContext)
  {
    AppMethodBeat.i(206799);
    au localau = a.cWU();
    if ((localau != null) && (localau.uhj != null) && (!bt.isNullOrNil(localau.uhj.uiT))) {
      com.tencent.mm.plugin.game.f.c.aB(paramContext, localau.uhj.uiT);
    }
    AppMethodBeat.o(206799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d
 * JD-Core Version:    0.7.0.1
 */