package com.tencent.mm.plugin.gamelife.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cw;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import d.g.b.p;
import d.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "sessionIdToSessionInfoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "usernameToSessionInfoCache", "getSelfUsername", "sessionId", "getSessionId", "selfUsername", "talker", "getSessionInfoBySessionId", "getSessionInfoByUsername", "getTalker", "isExistSession", "", "replaceSessionInfo", "", "testAllSessionInfo", "usernameCacheKey", "Companion", "plugin-gamelife_release"})
public final class c
  extends j<a>
{
  private static final String[] SQL_CREATE;
  public static final a uyz;
  final e db;
  private final ConcurrentHashMap<String, a> szf;
  final ConcurrentHashMap<String, a> uyy;
  
  static
  {
    AppMethodBeat.i(211410);
    uyz = new a((byte)0);
    a.a locala = a.uyv;
    SQL_CREATE = new String[] { j.getCreateSQLs(a.access$getInfo$cp(), "GameLifeSessionInfo") };
    AppMethodBeat.o(211410);
  }
  
  public c(e parame)
  {
    super(parame, a.access$getInfo$cp(), "GameLifeSessionInfo", cw.INDEX_CREATE);
    AppMethodBeat.i(211409);
    this.db = parame;
    this.uyy = new ConcurrentHashMap();
    this.szf = new ConcurrentHashMap();
    AppMethodBeat.o(211409);
  }
  
  static String he(String paramString1, String paramString2)
  {
    AppMethodBeat.i(211408);
    paramString1 = paramString1 + '_' + paramString2;
    AppMethodBeat.o(211408);
    return paramString1;
  }
  
  public final void ak(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(211407);
    p.h(paramString1, "sessionId");
    p.h(paramString2, "selfUsername");
    p.h(paramString3, "talker");
    a locala = new a();
    locala.field_sessionId = paramString1;
    locala.field_talker = paramString3;
    locala.field_selfUserName = paramString2;
    if (am.aSV(paramString3))
    {
      paramString1 = (Throwable)new RuntimeException(paramString3 + " is invalid");
      AppMethodBeat.o(211407);
      throw paramString1;
    }
    ad.i("GameLife.GameLifeSessionInfoStorage", "[replaceSessionInfo] sessionId=" + paramString1 + ", talker=" + paramString3 + ", selfUsername=" + locala.field_selfUserName);
    ((Map)this.szf).put(paramString1, locala);
    ((Map)this.uyy).put(he(paramString2, paramString3), locala);
    replace((com.tencent.mm.sdk.e.c)locala);
    AppMethodBeat.o(211407);
  }
  
  public final a amI(String paramString)
  {
    AppMethodBeat.i(211406);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = new a();
      AppMethodBeat.o(211406);
      return paramString;
    }
    Object localObject2 = (a)this.szf.get(paramString);
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
        ((Map)((c)localObject2).szf).put(paramString, localObject1);
        paramString = (Map)((c)localObject2).uyy;
        localObject2 = ((a)localObject1).field_selfUserName;
        p.g(localObject2, "cache.field_selfUserName");
        localObject3 = ((a)localObject1).field_talker;
        p.g(localObject3, "cache.field_talker");
        paramString.put(he((String)localObject2, (String)localObject3), localObject1);
      }
    }
    AppMethodBeat.o(211406);
    return localObject1;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-gamelife_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.i.c
 * JD-Core Version:    0.7.0.1
 */