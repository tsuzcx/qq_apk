package com.tencent.mm.plugin.game.chatroom.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.du;
import com.tencent.mm.plugin.game.commlib.b.a;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.stubs.logger.Log;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.f.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfoDaoImpl;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfo;", "Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfoDao;", "storage", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "insertionAdapter", "Lcom/tencent/mm/plugin/game/commlib/db/EntityInsertionAdapter;", "getStorage", "()Lcom/tencent/mm/storagebase/SqliteDB;", "deleteAll", "", "chatroomName", "", "insertAll", "users", "", "query", "userName", "limitCnt", "", "queryByLike", "keyword", "queryByUserNames", "userNameList", "queryMemberNum", "", "Companion", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends MAutoStorage<c>
  implements d
{
  public static final a IkB;
  public static final String[] SQL_CREATE;
  private final h IkC;
  private final a<c> IkD;
  
  static
  {
    AppMethodBeat.i(275697);
    IkB = new a((byte)0);
    Object localObject = p.al(new String[] { MAutoStorage.getCreateSQLs(c.nVV, "GameSimpleUserInfo") });
    Collection localCollection = (Collection)localObject;
    String[] arrayOfString = c.INDEX_CREATE;
    s.s(arrayOfString, "INDEX_CREATE");
    p.a(localCollection, (Object[])arrayOfString);
    localObject = ((Collection)localObject).toArray(new String[0]);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(275697);
      throw ((Throwable)localObject);
    }
    SQL_CREATE = (String[])localObject;
    AppMethodBeat.o(275697);
  }
  
  public e(h paramh)
  {
    super((ISQLiteDatabase)paramh, c.nVV, "GameSimpleUserInfo", du.INDEX_CREATE);
    AppMethodBeat.i(275688);
    this.IkC = paramh;
    this.IkD = ((a)new b(this.IkC));
    AppMethodBeat.o(275688);
  }
  
  public final List<c> SV(String paramString)
  {
    AppMethodBeat.i(275713);
    s.u(paramString, "userName");
    paramString = s.X("SELECT * FROM GameSimpleUserInfo WHERE userName = ", h.EQ(paramString));
    ArrayList localArrayList = new ArrayList();
    paramString = (Closeable)this.IkC.rawQuery(paramString, null, 2);
    try
    {
      Cursor localCursor = (Cursor)paramString;
      if (localCursor.moveToFirst()) {
        while (!localCursor.isAfterLast())
        {
          c localc = new c();
          localc.convertFrom(localCursor);
          ah localah2 = ah.aiuX;
          localArrayList.add(localc);
          localCursor.moveToNext();
        }
      }
      ah localah1;
      return paramString;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(275713);
        throw localThrowable;
      }
      finally
      {
        b.a(paramString, localThrowable);
        AppMethodBeat.o(275713);
      }
      localah1 = ah.aiuX;
      b.a(paramString, null);
      paramString = (List)localThrowable;
      AppMethodBeat.o(275713);
    }
  }
  
  /* Error */
  public final long aFw(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 214
    //   4: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 215
    //   10: invokestatic 132	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: ldc 217
    //   15: aload_1
    //   16: invokestatic 161	com/tencent/mm/storagebase/h:EQ	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 165	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 143	com/tencent/mm/plugin/game/chatroom/f/e:IkC	Lcom/tencent/mm/storagebase/h;
    //   27: aload_1
    //   28: aconst_null
    //   29: iconst_2
    //   30: invokevirtual 173	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   33: astore_1
    //   34: lconst_0
    //   35: lstore_3
    //   36: aload_1
    //   37: checkcast 175	java/io/Closeable
    //   40: astore_1
    //   41: aload_1
    //   42: checkcast 177	android/database/Cursor
    //   45: astore 5
    //   47: aload 5
    //   49: ifnull +44 -> 93
    //   52: aload 5
    //   54: invokeinterface 202 1 0
    //   59: iconst_1
    //   60: if_icmpne +33 -> 93
    //   63: iload_2
    //   64: ifeq +12 -> 76
    //   67: aload 5
    //   69: iconst_0
    //   70: invokeinterface 221 2 0
    //   75: lstore_3
    //   76: getstatic 195	kotlin/ah:aiuX	Lkotlin/ah;
    //   79: astore 5
    //   81: aload_1
    //   82: aconst_null
    //   83: invokestatic 207	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   86: ldc 214
    //   88: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: lload_3
    //   92: lreturn
    //   93: iconst_0
    //   94: istore_2
    //   95: goto -32 -> 63
    //   98: astore 5
    //   100: ldc 214
    //   102: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload 5
    //   107: athrow
    //   108: astore 6
    //   110: aload_1
    //   111: aload 5
    //   113: invokestatic 207	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   116: ldc 214
    //   118: invokestatic 123	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload 6
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	e
    //   0	124	1	paramString	String
    //   1	94	2	i	int
    //   35	57	3	l	long
    //   45	35	5	localObject1	Object
    //   98	14	5	localThrowable	Throwable
    //   108	14	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   41	47	98	finally
    //   52	63	98	finally
    //   67	76	98	finally
    //   76	81	98	finally
    //   100	108	108	finally
  }
  
  public final List<c> aFx(String paramString)
  {
    AppMethodBeat.i(275733);
    s.u(paramString, "chatroomName");
    paramString = "SELECT * FROM GameSimpleUserInfo WHERE roomName = " + h.EQ(paramString) + " ORDER BY role ASC LIMIT 400";
    ArrayList localArrayList = new ArrayList();
    paramString = (Closeable)this.IkC.rawQuery(paramString, null, 2);
    for (;;)
    {
      try
      {
        localCursor = (Cursor)paramString;
        if ((!localCursor.moveToFirst()) || (localCursor.isAfterLast())) {
          continue;
        }
        localc = new c();
        localc.convertFrom(localCursor);
        CharSequence localCharSequence = (CharSequence)localc.field_nickName;
        if (localCharSequence == null) {
          break label200;
        }
        if (localCharSequence.length() != 0) {
          continue;
        }
      }
      finally
      {
        try
        {
          Cursor localCursor;
          c localc;
          AppMethodBeat.o(275733);
          throw localThrowable;
        }
        finally
        {
          b.a(paramString, localThrowable);
          AppMethodBeat.o(275733);
        }
        i = 0;
        continue;
        ah localah = ah.aiuX;
        b.a(paramString, null);
        paramString = (List)localThrowable;
        AppMethodBeat.o(275733);
        return paramString;
      }
      if (i == 0) {
        localArrayList.add(localc);
      }
      localCursor.moveToNext();
      continue;
      label200:
      int i = 1;
    }
  }
  
  public final void aFy(String paramString)
  {
    AppMethodBeat.i(275748);
    s.u(paramString, "chatroomName");
    int i = this.IkC.delete("GameSimpleUserInfo", "roomName = ?", new String[] { paramString });
    Log.i("ChatroomMemberPreloadManager.daoImpl", "deleteAll By chatroomName = " + paramString + "  delete num = " + i);
    AppMethodBeat.o(275748);
  }
  
  public final List<c> iP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(275741);
    s.u(paramString1, "keyword");
    s.u(paramString2, "chatroomName");
    long l = System.currentTimeMillis();
    paramString2 = "SELECT * FROM GameSimpleUserInfo WHERE roomName = " + h.EQ(paramString2) + " AND nickName LIKE '%" + paramString1 + "%' ORDER BY role ASC";
    ArrayList localArrayList = new ArrayList();
    paramString2 = (Closeable)this.IkC.rawQuery(paramString2, null, 2);
    try
    {
      Object localObject2 = (Cursor)paramString2;
      if (((Cursor)localObject2).moveToFirst()) {
        while (!((Cursor)localObject2).isAfterLast())
        {
          c localc = new c();
          localc.convertFrom((Cursor)localObject2);
          ah localah = ah.aiuX;
          localArrayList.add(localc);
          ((Cursor)localObject2).moveToNext();
        }
      }
      return paramString1;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(275741);
        throw paramString1;
      }
      finally
      {
        b.a(paramString2, paramString1);
        AppMethodBeat.o(275741);
      }
      localObject2 = ah.aiuX;
      b.a(paramString2, null);
      Log.i("ChatroomMemberPreloadManager.daoImpl", "query cost time = " + (System.currentTimeMillis() - l) + " keyword = " + paramString1 + "  result.size = " + localObject1.size() + ' ');
      paramString1 = (List)localObject1;
      AppMethodBeat.o(275741);
    }
  }
  
  public final List<c> y(List<String> paramList, String paramString)
  {
    AppMethodBeat.i(275722);
    s.u(paramList, "userNameList");
    s.u(paramString, "chatroomName");
    long l = System.currentTimeMillis();
    paramString = "SELECT * FROM GameSimpleUserInfo WHERE userName IN " + com.tencent.mm.plugin.game.chatroom.e.ig(paramList) + " AND roomName = " + h.EQ(paramString) + " ORDER BY role ASC";
    ArrayList localArrayList = new ArrayList();
    paramString = (Closeable)this.IkC.rawQuery(paramString, null, 2);
    try
    {
      Object localObject2 = (Cursor)paramString;
      if (((Cursor)localObject2).moveToFirst()) {
        while (!((Cursor)localObject2).isAfterLast())
        {
          c localc = new c();
          localc.convertFrom((Cursor)localObject2);
          ah localah = ah.aiuX;
          localArrayList.add(localc);
          ((Cursor)localObject2).moveToNext();
        }
      }
      return paramList;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(275722);
        throw paramList;
      }
      finally
      {
        b.a(paramString, paramList);
        AppMethodBeat.o(275722);
      }
      localObject2 = ah.aiuX;
      b.a(paramString, null);
      Log.i("ChatroomMemberPreloadManager.daoImpl", "query cost time = " + (System.currentTimeMillis() - l) + " rawSize = " + paramList.size() + "   result.size = " + localObject1.size() + ' ');
      paramList = (List)localObject1;
      AppMethodBeat.o(275722);
    }
  }
  
  public final void z(List<? extends c> paramList, String paramString)
  {
    AppMethodBeat.i(275745);
    s.u(paramList, "users");
    s.u(paramString, "chatroomName");
    if (paramList.isEmpty())
    {
      Log.i("ChatroomMemberPreloadManager.daoImpl", s.X("insertAll  size = ", Integer.valueOf(paramList.size())));
      AppMethodBeat.o(275745);
      return;
    }
    int i = paramList.size();
    long l1 = System.currentTimeMillis();
    long l2 = this.IkC.beginTransaction(-1L);
    try
    {
      this.IkD.b((Iterable)paramList);
      this.IkC.endTransaction(l2);
      Log.i("ChatroomMemberPreloadManager.daoImpl", "insertAll insertDataSize = " + i + "  cost time = " + (System.currentTimeMillis() - l1));
      AppMethodBeat.o(275745);
      return;
    }
    finally
    {
      this.IkC.endTransaction(l2);
      AppMethodBeat.o(275745);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfoDaoImpl$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TAG", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfoDaoImpl$insertionAdapter$1", "Lcom/tencent/mm/plugin/game/commlib/db/EntityInsertionAdapter;", "Lcom/tencent/mm/plugin/game/chatroom/db/GameSimpleUserInfo;", "bind", "", "stmt", "Lcom/tencent/wcdb/database/SQLiteStatement;", "entity", "createQuery", "", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends a<c>
  {
    b(h paramh)
    {
      super();
    }
    
    public final String fCI()
    {
      return "INSERT OR REPLACE INTO `GameSimpleUserInfo` (`compositionKey`,`userName`,`roomName`,`nickName`,`avatarURL`,`role`,`updateTime`) VALUES (?,?,?,?,?,?,?)";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.f.e
 * JD-Core Version:    0.7.0.1
 */