package com.tencent.mm.plugin.gamelife.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.d;
import com.tencent.mm.plugin.gamelife.a.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfoService;", "()V", "getSessionId", "", "selfUsername", "", "talker", "callback", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfoService$SessionIdCallback;", "getSessionIdFromLocal", "getSessionIdFromServer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sessionId", "getSessionInfoBySessionId", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "getTalkerFromLocal", "Companion", "plugin-gamelife_release"})
public final class b
  implements com.tencent.mm.plugin.gamelife.a.e
{
  public static final a uyw;
  
  static
  {
    AppMethodBeat.i(211405);
    uyw = new a((byte)0);
    AppMethodBeat.o(211405);
  }
  
  public final void a(String paramString1, final String paramString2, final e.a parama)
  {
    AppMethodBeat.i(211402);
    p.h(parama, "callback");
    Object localObject1 = (CharSequence)paramString1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = (CharSequence)paramString2;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label124;
        }
      }
    }
    label124:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label130;
      }
      parama.onDone("");
      ad.e("GameLife.GameLifeSessionInfoService", "[get SessionId] self:" + paramString1 + " talker:" + paramString2 + " in invalid");
      AppMethodBeat.o(211402);
      return;
      i = 0;
      break;
    }
    label130:
    p.h(paramString1, "selfUsername");
    p.h(paramString2, "talker");
    Object localObject3 = ((PluginGameLife)g.ad(PluginGameLife.class)).getSessionInfoStorage();
    localObject1 = (CharSequence)paramString1;
    label208:
    label222:
    Object localObject2;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = (CharSequence)paramString2;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label292;
        }
        i = 1;
        if (i == 0) {
          break label298;
        }
      }
      localObject1 = new a();
      localObject2 = ((a)localObject1).field_sessionId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label466;
      }
    }
    label292:
    label298:
    label466:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label472;
      }
      parama.onDone((String)localObject1);
      AppMethodBeat.o(211402);
      return;
      i = 0;
      break;
      i = 0;
      break label208;
      localObject2 = (a)((c)localObject3).uyy.get(c.he(paramString1, paramString2));
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label222;
      }
      localObject2 = (c)localObject3;
      localObject1 = "select * , rowid from GameLifeSessionInfo  where talker = '" + paramString2 + '\'' + " and selfUserName = '" + paramString1 + '\'';
      localObject3 = ((c)localObject2).db.rawQuery((String)localObject1, null);
      localObject1 = new a();
      ((a)localObject1).field_talker = paramString2;
      ((a)localObject1).field_selfUserName = paramString1;
      if (localObject3 != null)
      {
        if (((Cursor)localObject3).moveToFirst()) {
          ((a)localObject1).convertFrom((Cursor)localObject3);
        }
        ((Cursor)localObject3).close();
      }
      if (((a)localObject1).field_sessionId != null) {
        ((Map)((c)localObject2).uyy).put(c.he(paramString1, paramString2), localObject1);
      }
      break label222;
    }
    label472:
    parama = (d.g.a.b)new b(paramString1, paramString2, parama);
    new com.tencent.mm.plugin.gamelife.c.c(paramString1, paramString2).aED().j((com.tencent.mm.vending.c.a)new c(parama));
    AppMethodBeat.o(211402);
  }
  
  public final String aii(String paramString)
  {
    AppMethodBeat.i(211404);
    String str = ((PluginGameLife)g.ad(PluginGameLife.class)).getSessionInfoStorage().amI(paramString).field_talker;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    AppMethodBeat.o(211404);
    return paramString;
  }
  
  public final d amC(String paramString)
  {
    AppMethodBeat.i(211403);
    paramString = (d)((PluginGameLife)g.ad(PluginGameLife.class)).getSessionInfoStorage().amI(paramString);
    AppMethodBeat.o(211403);
    return paramString;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoService$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<String, z>
  {
    b(String paramString1, String paramString2, e.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionIdResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(d.g.a.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.i.b
 * JD-Core Version:    0.7.0.1
 */