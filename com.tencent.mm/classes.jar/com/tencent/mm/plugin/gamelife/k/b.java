package com.tencent.mm.plugin.gamelife.k;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.a.f.a;
import com.tencent.mm.plugin.gamelife.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfoService;", "()V", "getSessionId", "", "selfUsername", "", "talker", "scene", "", "extInfo", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfoService$SessionIdCallback;", "getSessionIdFromLocal", "getSessionIdFromServer", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "sessionId", "Lcom/tencent/mm/plugin/gamelife/autogen/GameLifeMsgExtInfo;", "getSessionInfoBySessionId", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "getTalkerFromLocal", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.gamelife.a.f
{
  public static final a JbQ;
  
  static
  {
    AppMethodBeat.i(267985);
    JbQ = new a((byte)0);
    AppMethodBeat.o(267985);
  }
  
  private static final ah d(m paramm, com.tencent.mm.am.b.a parama)
  {
    AppMethodBeat.i(267978);
    s.u(paramm, "$callback");
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      String str = ((i)parama.ott).session_id;
      if (str == null)
      {
        str = "";
        paramm.invoke(str, ((i)parama.ott).JaL);
      }
    }
    for (;;)
    {
      paramm = ah.aiuX;
      AppMethodBeat.o(267978);
      return paramm;
      break;
      paramm.invoke("", null);
    }
  }
  
  public final void a(String paramString1, final String paramString2, int paramInt, com.tencent.mm.bx.b paramb, final f.a parama)
  {
    AppMethodBeat.i(268017);
    s.u(parama, "callback");
    Object localObject1 = (CharSequence)paramString1;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = (CharSequence)paramString2;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label126;
        }
      }
    }
    label126:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label132;
      }
      parama.onDone("");
      Log.e("GameLife.GameLifeSessionInfoService", "[get SessionId] self:" + paramString1 + " talker:" + paramString2 + " in invalid");
      AppMethodBeat.o(268017);
      return;
      i = 0;
      break;
    }
    label132:
    s.u(paramString1, "selfUsername");
    s.u(paramString2, "talker");
    Object localObject3 = ((PluginGameLife)h.az(PluginGameLife.class)).getSessionInfoStorage();
    localObject1 = (CharSequence)paramString1;
    label210:
    label224:
    Object localObject2;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = (CharSequence)paramString2;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label295;
        }
        i = 1;
        if (i == 0) {
          break label301;
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
        break label464;
      }
    }
    label295:
    label301:
    label464:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label470;
      }
      parama.onDone((String)localObject1);
      AppMethodBeat.o(268017);
      return;
      i = 0;
      break;
      i = 0;
      break label210;
      localObject2 = (a)((c)localObject3).JbT.get(c.ji(paramString1, paramString2));
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label224;
      }
      localObject2 = (c)localObject3;
      localObject1 = "select * , rowid from GameLifeSessionInfo  where talker = '" + paramString2 + "' and selfUserName = '" + paramString1 + '\'';
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
        ((Map)((c)localObject2).JbT).put(c.ji(paramString1, paramString2), localObject1);
      }
      break label224;
    }
    label470:
    parama = (m)new b(paramString1, paramString2, parama);
    new com.tencent.mm.plugin.gamelife.c.c(paramString1, paramString2, paramInt, paramb).bFJ().j(new b..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(268017);
  }
  
  public final String aAw(String paramString)
  {
    AppMethodBeat.i(268034);
    paramString = ((PluginGameLife)h.az(PluginGameLife.class)).getSessionInfoStorage().aHG(paramString).field_talker;
    if (paramString == null)
    {
      AppMethodBeat.o(268034);
      return "";
    }
    AppMethodBeat.o(268034);
    return paramString;
  }
  
  public final e aHz(String paramString)
  {
    AppMethodBeat.i(268026);
    paramString = (e)((PluginGameLife)h.az(PluginGameLife.class)).getSessionInfoStorage().aHG(paramString);
    AppMethodBeat.o(268026);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoService$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "sessionId", "", "extInfo", "Lcom/tencent/mm/plugin/gamelife/autogen/GameLifeMsgExtInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<String, com.tencent.mm.plugin.gamelife.b.c, ah>
  {
    b(String paramString1, String paramString2, f.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.k.b
 * JD-Core Version:    0.7.0.1
 */