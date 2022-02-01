package com.tencent.mm.plugin.gamelife.j;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.df;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "sessionIdToSessionInfoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "usernameToSessionInfoCache", "getSelfUsername", "sessionId", "getSessionId", "selfUsername", "talker", "getSessionInfoBySessionId", "getSessionInfoByUsername", "getTalker", "isExistSession", "", "replaceSessionInfo", "", "extInfo", "Lcom/tencent/mm/plugin/gamelife/autogen/GameLifeMsgExtInfo;", "testAllSessionInfo", "usernameCacheKey", "Companion", "plugin-gamelife_release"})
public final class c
  extends MAutoStorage<a>
{
  public static final a Dic;
  private static final String[] SQL_CREATE;
  private final ConcurrentHashMap<String, a> Ams;
  final ConcurrentHashMap<String, a> Dib;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(202814);
    Dic = new a((byte)0);
    a.a locala = a.DhY;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.access$getInfo$cp(), "GameLifeSessionInfo") };
    AppMethodBeat.o(202814);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.access$getInfo$cp(), "GameLifeSessionInfo", df.INDEX_CREATE);
    AppMethodBeat.i(202813);
    this.db = paramISQLiteDatabase;
    this.Dib = new ConcurrentHashMap();
    this.Ams = new ConcurrentHashMap();
    AppMethodBeat.o(202813);
  }
  
  static String ib(String paramString1, String paramString2)
  {
    AppMethodBeat.i(202812);
    paramString1 = paramString1 + '_' + paramString2;
    AppMethodBeat.o(202812);
    return paramString1;
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, com.tencent.mm.plugin.gamelife.b.c paramc)
  {
    Object localObject = null;
    AppMethodBeat.i(202811);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "selfUsername");
    p.k(paramString3, "talker");
    a locala = new a();
    locala.field_sessionId = paramString1;
    locala.field_talker = paramString3;
    locala.field_selfUserName = paramString2;
    locala.field_extInfo = paramc;
    StringBuilder localStringBuilder = new StringBuilder("[replaceSessionInfo] sessionId=").append(paramString1).append(", talker=").append(paramString3).append(", selfUsername=").append(locala.field_selfUserName).append(' ').append("extInfo:");
    paramc = locala.field_extInfo;
    if (paramc != null) {}
    for (paramc = Long.valueOf(paramc.DgK);; paramc = null)
    {
      localStringBuilder = localStringBuilder.append(paramc).append('/');
      com.tencent.mm.plugin.gamelife.b.c localc = locala.field_extInfo;
      paramc = localObject;
      if (localc != null) {
        paramc = Long.valueOf(localc.DgJ);
      }
      Log.i("GameLife.GameLifeSessionInfoStorage", paramc);
      ((Map)this.Ams).put(paramString1, locala);
      ((Map)this.Dib).put(ib(paramString2, paramString3), locala);
      replace((IAutoDBItem)locala);
      AppMethodBeat.o(202811);
      return;
    }
  }
  
  public final a aKP(String paramString)
  {
    AppMethodBeat.i(202810);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = new a();
      AppMethodBeat.o(202810);
      return paramString;
    }
    Object localObject2 = (a)this.Ams.get(paramString);
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
        ((Map)((c)localObject2).Ams).put(paramString, localObject1);
        paramString = (Map)((c)localObject2).Dib;
        localObject2 = ((a)localObject1).field_selfUserName;
        p.j(localObject2, "cache.field_selfUserName");
        localObject3 = ((a)localObject1).field_talker;
        p.j(localObject3, "cache.field_talker");
        paramString.put(ib((String)localObject2, (String)localObject3), localObject1);
      }
    }
    AppMethodBeat.o(202810);
    return localObject1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.j.c
 * JD-Core Version:    0.7.0.1
 */