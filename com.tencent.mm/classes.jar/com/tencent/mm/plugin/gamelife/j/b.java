package com.tencent.mm.plugin.gamelife.j;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.gamelife.PluginGameLife;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.a.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoService;", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfoService;", "()V", "getSessionId", "", "selfUsername", "", "talker", "scene", "", "extInfo", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfoService$SessionIdCallback;", "getSessionIdFromLocal", "getSessionIdFromServer", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "sessionId", "Lcom/tencent/mm/plugin/gamelife/autogen/GameLifeMsgExtInfo;", "getSessionInfoBySessionId", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeSessionInfo;", "getTalkerFromLocal", "Companion", "plugin-gamelife_release"})
public final class b
  implements com.tencent.mm.plugin.gamelife.a.f
{
  public static final a DhZ;
  
  static
  {
    AppMethodBeat.i(204394);
    DhZ = new a((byte)0);
    AppMethodBeat.o(204394);
  }
  
  public final void a(String paramString1, final String paramString2, int paramInt, com.tencent.mm.cd.b paramb, final f.a parama)
  {
    AppMethodBeat.i(204389);
    p.k(parama, "callback");
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
      parama.aKD("");
      Log.e("GameLife.GameLifeSessionInfoService", "[get SessionId] self:" + paramString1 + " talker:" + paramString2 + " in invalid");
      AppMethodBeat.o(204389);
      return;
      i = 0;
      break;
    }
    label132:
    p.k(paramString1, "selfUsername");
    p.k(paramString2, "talker");
    Object localObject3 = ((PluginGameLife)h.ag(PluginGameLife.class)).getSessionInfoStorage();
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
        break label469;
      }
    }
    label295:
    label301:
    label469:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label475;
      }
      parama.aKD((String)localObject1);
      AppMethodBeat.o(204389);
      return;
      i = 0;
      break;
      i = 0;
      break label210;
      localObject2 = (a)((c)localObject3).Dib.get(c.ib(paramString1, paramString2));
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label224;
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
        ((Map)((c)localObject2).Dib).put(c.ib(paramString1, paramString2), localObject1);
      }
      break label224;
    }
    label475:
    parama = (m)new b(paramString1, paramString2, parama);
    new com.tencent.mm.plugin.gamelife.c.c(paramString1, paramString2, paramInt, paramb).bhW().j((com.tencent.mm.vending.c.a)new c(parama));
    AppMethodBeat.o(204389);
  }
  
  public final String aED(String paramString)
  {
    AppMethodBeat.i(204391);
    String str = ((PluginGameLife)h.ag(PluginGameLife.class)).getSessionInfoStorage().aKP(paramString).field_talker;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    AppMethodBeat.o(204391);
    return paramString;
  }
  
  public final e aKJ(String paramString)
  {
    AppMethodBeat.i(204390);
    paramString = (e)((PluginGameLife)h.ag(PluginGameLife.class)).getSessionInfoStorage().aKP(paramString);
    AppMethodBeat.o(204390);
    return paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoService$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "sessionId", "", "extInfo", "Lcom/tencent/mm/plugin/gamelife/autogen/GameLifeMsgExtInfo;", "invoke"})
  static final class b
    extends q
    implements m<String, com.tencent.mm.plugin.gamelife.b.c, x>
  {
    b(String paramString1, String paramString2, f.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/plugin/gamelife/autogen/GetChatSessionIdResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(m paramm) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.j.b
 * JD-Core Version:    0.7.0.1
 */