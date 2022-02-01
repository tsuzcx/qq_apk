package com.tencent.mm.plugin.gamelife.k;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.dp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "sessionIdToSessionInfoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "usernameToSessionInfoCache", "getSelfUsername", "sessionId", "getSessionId", "selfUsername", "talker", "getSessionInfoBySessionId", "getSessionInfoByUsername", "getTalker", "isExistSession", "", "replaceSessionInfo", "", "extInfo", "Lcom/tencent/mm/plugin/gamelife/autogen/GameLifeMsgExtInfo;", "testAllSessionInfo", "usernameCacheKey", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends MAutoStorage<a>
{
  public static final a JbS;
  private static final String[] SQL_CREATE;
  private final ConcurrentHashMap<String, a> FMn;
  final ConcurrentHashMap<String, a> JbT;
  final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(267996);
    JbS = new a((byte)0);
    a.a locala = a.JbP;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.access$getInfo$cp(), "GameLifeSessionInfo") };
    AppMethodBeat.o(267996);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.access$getInfo$cp(), "GameLifeSessionInfo", dp.INDEX_CREATE);
    AppMethodBeat.i(267973);
    this.db = paramISQLiteDatabase;
    this.JbT = new ConcurrentHashMap();
    this.FMn = new ConcurrentHashMap();
    AppMethodBeat.o(267973);
  }
  
  static String ji(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267980);
    paramString1 = paramString1 + '_' + paramString2;
    AppMethodBeat.o(267980);
    return paramString1;
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, com.tencent.mm.plugin.gamelife.b.c paramc)
  {
    Object localObject = null;
    AppMethodBeat.i(268020);
    s.u(paramString1, "sessionId");
    s.u(paramString2, "selfUsername");
    s.u(paramString3, "talker");
    a locala = new a();
    locala.field_sessionId = paramString1;
    locala.field_talker = paramString3;
    locala.field_selfUserName = paramString2;
    locala.field_extInfo = paramc;
    StringBuilder localStringBuilder = new StringBuilder("[replaceSessionInfo] sessionId=").append(paramString1).append(", talker=").append(paramString3).append(", selfUsername=").append(locala.field_selfUserName).append(" extInfo:");
    paramc = locala.field_extInfo;
    if (paramc == null)
    {
      paramc = null;
      localStringBuilder = localStringBuilder.append(paramc).append('/');
      paramc = locala.field_extInfo;
      if (paramc != null) {
        break label227;
      }
    }
    label227:
    for (paramc = localObject;; paramc = Long.valueOf(paramc.JaD))
    {
      Log.i("GameLife.GameLifeSessionInfoStorage", paramc);
      ((Map)this.FMn).put(paramString1, locala);
      ((Map)this.JbT).put(ji(paramString2, paramString3), locala);
      replace((IAutoDBItem)locala);
      AppMethodBeat.o(268020);
      return;
      paramc = Long.valueOf(paramc.JaE);
      break;
    }
  }
  
  public final a aHG(String paramString)
  {
    AppMethodBeat.i(268008);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = new a();
      AppMethodBeat.o(268008);
      return paramString;
    }
    localObject1 = (a)this.FMn.get(paramString);
    if (localObject1 == null)
    {
      Object localObject2 = (c)this;
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
        ((Map)((c)localObject2).FMn).put(paramString, localObject1);
        paramString = (Map)((c)localObject2).JbT;
        localObject2 = ((a)localObject1).field_selfUserName;
        s.s(localObject2, "cache.field_selfUserName");
        localObject3 = ((a)localObject1).field_talker;
        s.s(localObject3, "cache.field_talker");
        paramString.put(ji((String)localObject2, (String)localObject3), localObject1);
      }
      AppMethodBeat.o(268008);
      return localObject1;
    }
    AppMethodBeat.o(268008);
    return localObject1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.k.c
 * JD-Core Version:    0.7.0.1
 */