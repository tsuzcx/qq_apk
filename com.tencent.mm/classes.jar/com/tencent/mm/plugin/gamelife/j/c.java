package com.tencent.mm.plugin.gamelife.j;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "sessionIdToSessionInfoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "usernameToSessionInfoCache", "getSelfUsername", "sessionId", "getSessionId", "selfUsername", "talker", "getSessionInfoBySessionId", "getSessionInfoByUsername", "getTalker", "isExistSession", "", "replaceSessionInfo", "", "extInfo", "Lcom/tencent/mm/plugin/gamelife/autogen/GameLifeMsgExtInfo;", "testAllSessionInfo", "usernameCacheKey", "Companion", "plugin-gamelife_release"})
public final class c
  extends j<a>
{
  private static final String[] SQL_CREATE;
  public static final a uKc;
  final e db;
  private final ConcurrentHashMap<String, a> sJW;
  final ConcurrentHashMap<String, a> uKb;
  
  static
  {
    AppMethodBeat.i(212188);
    uKc = new a((byte)0);
    a.a locala = a.uJY;
    SQL_CREATE = new String[] { j.getCreateSQLs(a.access$getInfo$cp(), "GameLifeSessionInfo") };
    AppMethodBeat.o(212188);
  }
  
  public c(e parame)
  {
    super(parame, a.access$getInfo$cp(), "GameLifeSessionInfo", cw.INDEX_CREATE);
    AppMethodBeat.i(212187);
    this.db = parame;
    this.uKb = new ConcurrentHashMap();
    this.sJW = new ConcurrentHashMap();
    AppMethodBeat.o(212187);
  }
  
  static String hl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212186);
    paramString1 = paramString1 + '_' + paramString2;
    AppMethodBeat.o(212186);
    return paramString1;
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, com.tencent.mm.plugin.gamelife.b.c paramc)
  {
    Object localObject = null;
    AppMethodBeat.i(212185);
    p.h(paramString1, "sessionId");
    p.h(paramString2, "selfUsername");
    p.h(paramString3, "talker");
    a locala = new a();
    locala.field_sessionId = paramString1;
    locala.field_talker = paramString3;
    locala.field_selfUserName = paramString2;
    locala.field_extInfo = paramc;
    StringBuilder localStringBuilder = new StringBuilder("[replaceSessionInfo] sessionId=").append(paramString1).append(", talker=").append(paramString3).append(", selfUsername=").append(locala.field_selfUserName).append(' ').append("extInfo:");
    paramc = locala.field_extInfo;
    if (paramc != null) {}
    for (paramc = Long.valueOf(paramc.uIO);; paramc = null)
    {
      localStringBuilder = localStringBuilder.append(paramc).append('/');
      com.tencent.mm.plugin.gamelife.b.c localc = locala.field_extInfo;
      paramc = localObject;
      if (localc != null) {
        paramc = Long.valueOf(localc.uIN);
      }
      ae.i("GameLife.GameLifeSessionInfoStorage", paramc);
      ((Map)this.sJW).put(paramString1, locala);
      ((Map)this.uKb).put(hl(paramString2, paramString3), locala);
      replace((com.tencent.mm.sdk.e.c)locala);
      AppMethodBeat.o(212185);
      return;
    }
  }
  
  public final a anJ(String paramString)
  {
    AppMethodBeat.i(212184);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = new a();
      AppMethodBeat.o(212184);
      return paramString;
    }
    Object localObject2 = (a)this.sJW.get(paramString);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = (c)this;
      localObject1 = "select * , rowid from GameLifeSessionInfo where sessionId = '" + paramString + "' ";
      Object localObject3 = ((c)localObject2).db.rawQuery((String)localObject1, null);
      localObject1 = new a();
      ((a)localObject1).field_sessionId = paramString;
      if (localObject3 != null)
      {
        if (((Cursor)localObject3).moveToFirst()) {
          ((a)localObject1).convertFrom((Cursor)localObject3);
        }
        ((Cursor)localObject3).close();
      }
      if (((a)localObject1).systemRowid > 0L)
      {
        ((Map)((c)localObject2).sJW).put(paramString, localObject1);
        paramString = (Map)((c)localObject2).uKb;
        localObject2 = ((a)localObject1).field_selfUserName;
        p.g(localObject2, "cache.field_selfUserName");
        localObject3 = ((a)localObject1).field_talker;
        p.g(localObject3, "cache.field_talker");
        paramString.put(hl((String)localObject2, (String)localObject3), localObject1);
      }
    }
    AppMethodBeat.o(212184);
    return localObject1;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.j.c
 * JD-Core Version:    0.7.0.1
 */