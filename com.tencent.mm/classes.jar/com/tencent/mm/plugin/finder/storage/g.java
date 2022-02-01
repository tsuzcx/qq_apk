package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.autogen.b.ck;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.conv.a.a;
import com.tencent.mm.plugin.finder.conv.a.b;
import com.tencent.mm.plugin.finder.conv.b.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.au;
import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "checkOldConv", "", "clearUnreadCount", "sessionId", "", "genSceneTypeIndex", "", "get", "getAliasConvCount", "", "scene", "getGreetConvCount", "getTopPlaceCount", "type", "getUnreadCount", "isExit", "query", "", "offset", "nextCount", "", "queryLimit", "limitCount", "types", "replace", "item", "isNotify", "reportSize", "setEditing", "editing", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends MAutoStorage<com.tencent.mm.plugin.finder.conv.b>
{
  public static final a FJX;
  private static final String[] SQL_CREATE;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(339208);
    FJX = new a((byte)0);
    b.a locala = com.tencent.mm.plugin.finder.conv.b.AFx;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.finder.conv.b.access$getInfo$cp(), "FinderConversation") };
    AppMethodBeat.o(339208);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.plugin.finder.conv.b.access$getInfo$cp(), "FinderConversation", ck.INDEX_CREATE);
    AppMethodBeat.i(339182);
    this.db = paramISQLiteDatabase;
    this.db.execSQL("FinderConversation", "CREATE INDEX IF NOT EXISTS FinderConversation_scene_type_senderUserName_index ON FinderConversation(scene,type,senderUserName)");
    this.db.execSQL("FinderConversation", "CREATE INDEX IF NOT EXISTS FinderConversation_scene_type_senderUserNameVersion_index ON FinderConversation(scene,type,senderUserNameVersion)");
    this.db.execSQL("FinderConversation", "CREATE INDEX IF NOT EXISTS FinderConversation_scene_type_talker_index ON FinderConversation(scene,type,talker)");
    AppMethodBeat.o(339182);
  }
  
  /* Error */
  private boolean aAA(String paramString)
  {
    // Byte code:
    //   0: ldc 133
    //   2: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 134
    //   8: invokestatic 107	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: invokestatic 140	android/os/SystemClock:uptimeMillis	()J
    //   14: lstore_3
    //   15: new 142	java/lang/StringBuilder
    //   18: dup
    //   19: ldc 144
    //   21: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: aload_1
    //   25: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 153
    //   30: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 7
    //   38: aload_0
    //   39: getfield 118	com/tencent/mm/plugin/finder/storage/g:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   42: aload 7
    //   44: aconst_null
    //   45: invokeinterface 161 3 0
    //   50: checkcast 163	java/io/Closeable
    //   53: astore_1
    //   54: aload_1
    //   55: checkcast 165	android/database/Cursor
    //   58: astore 6
    //   60: new 167	com/tencent/mm/plugin/finder/conv/a$a
    //   63: dup
    //   64: invokespecial 169	com/tencent/mm/plugin/finder/conv/a$a:<init>	()V
    //   67: astore 8
    //   69: invokestatic 175	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   72: invokevirtual 178	java/lang/Thread:getName	()Ljava/lang/String;
    //   75: astore 9
    //   77: aload 9
    //   79: ldc 180
    //   81: invokestatic 183	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   84: aload 8
    //   86: aload 9
    //   88: invokevirtual 187	com/tencent/mm/plugin/finder/conv/a$a:avh	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/a$a;
    //   91: aload 7
    //   93: invokevirtual 190	com/tencent/mm/plugin/finder/conv/a$a:avg	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/a$a;
    //   96: astore 7
    //   98: aload 7
    //   100: invokestatic 140	android/os/SystemClock:uptimeMillis	()J
    //   103: lload_3
    //   104: lsub
    //   105: putfield 194	com/tencent/mm/plugin/finder/conv/a$a:duration	J
    //   108: aload 7
    //   110: ldc 196
    //   112: invokevirtual 199	com/tencent/mm/plugin/finder/conv/a$a:avf	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/a$a;
    //   115: invokevirtual 203	com/tencent/mm/plugin/finder/conv/a$a:dWL	()Lcom/tencent/mm/plugin/finder/conv/a$b;
    //   118: invokevirtual 208	com/tencent/mm/plugin/finder/conv/a$b:report	()V
    //   121: aload 6
    //   123: invokeinterface 212 1 0
    //   128: istore_2
    //   129: iload_2
    //   130: ifle +19 -> 149
    //   133: iconst_1
    //   134: istore 5
    //   136: aload_1
    //   137: aconst_null
    //   138: invokestatic 217	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   141: ldc 133
    //   143: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: iload 5
    //   148: ireturn
    //   149: iconst_0
    //   150: istore 5
    //   152: goto -16 -> 136
    //   155: astore 6
    //   157: ldc 133
    //   159: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload 6
    //   164: athrow
    //   165: astore 7
    //   167: aload_1
    //   168: aload 6
    //   170: invokestatic 217	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   173: ldc 133
    //   175: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload 7
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	g
    //   0	181	1	paramString	String
    //   128	2	2	i	int
    //   14	90	3	l	long
    //   134	17	5	bool	boolean
    //   58	64	6	localCursor	Cursor
    //   155	14	6	localThrowable	Throwable
    //   36	73	7	localObject1	Object
    //   165	14	7	localObject2	Object
    //   67	18	8	locala	a.a
    //   75	12	9	str	String
    // Exception table:
    //   from	to	target	type
    //   54	129	155	finally
    //   157	165	165	finally
  }
  
  private final List<com.tencent.mm.plugin.finder.conv.b> b(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(339200);
    LinkedList localLinkedList = new LinkedList();
    int k = Tp(paramInt3);
    Object localObject1 = av.GiL;
    Object localObject5 = av.w(Boolean.TRUE);
    int i;
    int j;
    Object localObject2;
    if (paramArrayOfInt != null)
    {
      localObject1 = "(";
      int m = paramArrayOfInt.length;
      i = 0;
      j = 0;
      if (j < m)
      {
        int n = paramArrayOfInt[j];
        if ((k <= 0) && (n == 100)) {
          break label467;
        }
        localObject2 = (String)localObject1 + "type=" + n;
        localObject1 = localObject2;
        if (i + 1 < paramArrayOfInt.length) {
          localObject1 = s.X((String)localObject2, " or ");
        }
      }
    }
    label467:
    for (;;)
    {
      j += 1;
      i += 1;
      break;
      paramArrayOfInt = s.X(n.d((String)localObject1, (CharSequence)" or "), ")");
      paramArrayOfInt = "select *, rowid from FinderConversation WHERE scene=" + paramInt3 + " and " + paramArrayOfInt + " and " + (String)localObject5 + " ORDER BY placedFlag DESC, updateTime DESC limit " + paramInt2 + " offset " + paramInt1;
      long l;
      for (;;)
      {
        l = SystemClock.uptimeMillis();
        localObject1 = (Closeable)this.db.rawQuery(paramArrayOfInt, null);
        try
        {
          localObject2 = (Cursor)localObject1;
          if (!((Cursor)localObject2).moveToFirst()) {
            break;
          }
          while (!((Cursor)localObject2).isAfterLast())
          {
            localObject5 = new com.tencent.mm.plugin.finder.conv.b();
            ((com.tencent.mm.plugin.finder.conv.b)localObject5).convertFrom((Cursor)localObject2);
            ((com.tencent.mm.plugin.finder.conv.b)localObject5).prepare();
            localLinkedList.add(localObject5);
            ((Cursor)localObject2).moveToNext();
          }
          paramArrayOfInt = "select *, rowid from FinderConversation WHERE scene=" + paramInt3 + " and " + (String)localObject5 + " ORDER BY placedFlag DESC, updateTime DESC limit " + paramInt2 + " offset " + paramInt1;
        }
        finally
        {
          try
          {
            AppMethodBeat.o(339200);
            throw paramArrayOfInt;
          }
          finally
          {
            kotlin.f.b.a((Closeable)localObject1, paramArrayOfInt);
            AppMethodBeat.o(339200);
          }
        }
      }
      Object localObject4 = ah.aiuX;
      kotlin.f.b.a((Closeable)localObject1, null);
      localObject1 = new a.a();
      localObject4 = Thread.currentThread().getName();
      s.s(localObject4, "currentThread().name");
      paramArrayOfInt = ((a.a)localObject1).avh((String)localObject4).avg(paramArrayOfInt);
      paramArrayOfInt.duration = (SystemClock.uptimeMillis() - l);
      paramArrayOfInt.avf("FinderConversationStorage.queryLimit").dWL().report();
      paramArrayOfInt = (List)localLinkedList;
      AppMethodBeat.o(339200);
      return paramArrayOfInt;
    }
  }
  
  public final int Tp(int paramInt)
  {
    AppMethodBeat.i(339232);
    Object localObject2 = "select count(*) from FinderConversation WHERE scene=" + paramInt + " and type=1";
    long l = SystemClock.uptimeMillis();
    Closeable localCloseable = (Closeable)this.db.rawQuery((String)localObject2, null);
    try
    {
      Object localObject1 = (Cursor)localCloseable;
      a.a locala = new a.a();
      String str = Thread.currentThread().getName();
      s.s(str, "currentThread().name");
      localObject2 = locala.avh(str).avg((String)localObject2);
      ((a.a)localObject2).duration = (SystemClock.uptimeMillis() - l);
      ((a.a)localObject2).avf("FinderConversationStorage.getGreetConvCount").dWL().report();
      if (((Cursor)localObject1).moveToFirst())
      {
        paramInt = ((Cursor)localObject1).getInt(0);
        localObject1 = ah.aiuX;
        kotlin.f.b.a(localCloseable, null);
        AppMethodBeat.o(339232);
        return paramInt;
      }
    }
    finally
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.o(339232);
          throw localThrowable;
        }
        finally
        {
          kotlin.f.b.a(localCloseable, localThrowable);
          AppMethodBeat.o(339232);
        }
        paramInt = 0;
      }
    }
  }
  
  public final List<com.tencent.mm.plugin.finder.conv.b> a(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(339211);
    List localList = b(paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    Log.i("Finder.ConversationStorage", "[query] offset=" + paramInt1 + " pageCount=" + paramInt2 + " type=" + paramArrayOfInt + " list size=" + localList.size() + ", scene=" + paramInt3);
    AppMethodBeat.o(339211);
    return localList;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.conv.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(339223);
    if (paramb == null) {}
    for (Object localObject = null;; localObject = h.a(paramb))
    {
      Log.i("Finder.ConversationStorage", s.X("[replace] ", localObject));
      if (paramb != null) {
        break;
      }
      AppMethodBeat.o(339223);
      return false;
    }
    localObject = paramb.convertTo();
    String str = paramb.field_sessionId;
    s.s(str, "item.field_sessionId");
    boolean bool;
    if (aAA(str)) {
      if (this.db.update(getTableName(), (ContentValues)localObject, "sessionId = ?", new String[] { s.X("", paramb.field_sessionId) }) > 0) {
        bool = true;
      }
    }
    for (;;)
    {
      if ((bool) && (paramBoolean)) {
        doNotify(paramb.field_sessionId);
      }
      AppMethodBeat.o(339223);
      return bool;
      bool = false;
      continue;
      bool = super.insertNotify((IAutoDBItem)paramb, false);
    }
  }
  
  public final boolean aAB(String paramString)
  {
    AppMethodBeat.i(339256);
    s.u(paramString, "sessionId");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(339256);
      return false;
    }
    com.tencent.mm.plugin.finder.conv.b localb = aAz(paramString);
    i = localb.field_unReadCount;
    localb.field_unReadCount = 0;
    localb.field_readStatus = 1;
    boolean bool = update(localb.systemRowid, (IAutoDBItem)localb);
    doNotify(localb.field_sessionId, 5, localb);
    Log.i("Finder.ConversationStorage", "[clearUnreadCount] ret=" + bool + ' ' + i + " => " + localb.field_unReadCount + " sessionId=" + paramString);
    AppMethodBeat.o(339256);
    return bool;
  }
  
  public final int aAs(String paramString)
  {
    AppMethodBeat.i(339250);
    s.u(paramString, "sessionId");
    long l = SystemClock.uptimeMillis();
    Object localObject1 = s.X("select unReadCount, sum(unReadCount) from FinderConversation WHERE sessionId=", paramString);
    Object localObject3 = (Closeable)this.db.rawQuery((String)localObject1, null);
    try
    {
      Object localObject4 = (Cursor)localObject3;
      if ((((Cursor)localObject4).moveToFirst()) && (!((Cursor)localObject4).isAfterLast()))
      {
        i = ((Cursor)localObject4).getInt(1);
        localObject4 = ah.aiuX;
        kotlin.f.b.a((Closeable)localObject3, null);
        localObject3 = new a.a();
        localObject4 = Thread.currentThread().getName();
        s.s(localObject4, "currentThread().name");
        localObject1 = ((a.a)localObject3).avh((String)localObject4).avg((String)localObject1);
        ((a.a)localObject1).duration = (SystemClock.uptimeMillis() - l);
        ((a.a)localObject1).avf("FinderConversationStorage.getUnreadCount#sessionId").dWL().report();
        Log.i("Finder.ConversationStorage", "[getUnreadCount] sessionId=" + paramString + ' ' + i);
        AppMethodBeat.o(339250);
        return i;
      }
    }
    finally
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.o(339250);
          throw paramString;
        }
        finally
        {
          kotlin.f.b.a((Closeable)localObject3, paramString);
          AppMethodBeat.o(339250);
        }
        int i = 0;
      }
    }
  }
  
  public final com.tencent.mm.plugin.finder.conv.b aAz(String paramString)
  {
    AppMethodBeat.i(339215);
    s.u(paramString, "sessionId");
    long l = SystemClock.uptimeMillis();
    String str = "select *, rowid from FinderConversation where sessionId = '" + paramString + "' ";
    Object localObject = this.db.rawQuery(str, null);
    com.tencent.mm.plugin.finder.conv.b localb = new com.tencent.mm.plugin.finder.conv.b();
    localb.field_sessionId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        localb.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    paramString = new a.a();
    localObject = Thread.currentThread().getName();
    s.s(localObject, "currentThread().name");
    paramString = paramString.avh((String)localObject).avg(str);
    paramString.duration = (SystemClock.uptimeMillis() - l);
    paramString.avf("FinderConversationStorage.get").dWL().report();
    AppMethodBeat.o(339215);
    return localb;
  }
  
  public final boolean bUd()
  {
    AppMethodBeat.i(339269);
    Log.i("Finder.ConversationStorage", "[checkOldConv] begin");
    LinkedList localLinkedList = new LinkedList();
    long l1 = SystemClock.uptimeMillis();
    Object localObject2 = (Closeable)this.db.rawQuery("select * from FinderConversation", null);
    boolean bool2;
    boolean bool1;
    try
    {
      Cursor localCursor = (Cursor)localObject2;
      Object localObject6 = new a.a();
      Object localObject7 = Thread.currentThread().getName();
      s.s(localObject7, "currentThread().name");
      localObject6 = ((a.a)localObject6).avh((String)localObject7).avg("select * from FinderConversation");
      ((a.a)localObject6).duration = (SystemClock.uptimeMillis() - l1);
      ((a.a)localObject6).avf("FinderConversationStorage.checkOldConv").dWL().report();
      while (localCursor.moveToNext())
      {
        localObject6 = new com.tencent.mm.plugin.finder.conv.b();
        ((com.tencent.mm.plugin.finder.conv.b)localObject6).convertFrom(localCursor);
        localLinkedList.add(localObject6);
      }
      try
      {
        localObject7 = ((Iterable)localThrowable).iterator();
        if (((Iterator)localObject7).hasNext())
        {
          localObject8 = (com.tencent.mm.plugin.finder.conv.b)((Iterator)localObject7).next();
          localCharSequence = (CharSequence)((com.tencent.mm.plugin.finder.conv.b)localObject8).field_senderUserName;
          if (localCharSequence == null) {
            break label869;
          }
          if (localCharSequence.length() != 0) {
            break label890;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject4;
        Log.i("Finder.ConversationStorage", s.X("crash catch [checkOldConv] ", localException.getMessage()));
        e.a.a((e)com.tencent.mm.plugin.findersdk.b.HbT, "checkOldConv", false, null, false, (a)new b(localException), 28);
        ((com.tencent.mm.storagebase.h)this.db).endTransaction(l1);
        localObject5 = new a.a();
        localObject6 = Thread.currentThread().getName();
        s.s(localObject6, "currentThread().name");
        localObject5 = ((a.a)localObject5).avh((String)localObject6).avg("UPDATE FinderConversation SET senderUserName = 'xxxx' , senderRoleType = xxx WHERE talker = xx ");
        ((a.a)localObject5).duration = (SystemClock.uptimeMillis() - l2);
        ((a.a)localObject5).avf("FinderConversationStorage.checkOldConv#UPDATE").dWL().report();
        bool1 = bool2;
        for (;;)
        {
          Log.i("Finder.ConversationStorage", "[checkOldConv] status, total:" + localThrowable.size() + ", failed:" + ((ah.d)localObject2).aixb);
          localObject5 = (e)com.tencent.mm.plugin.findersdk.b.HbT;
          if (((ah.d)localObject2).aixb != 0) {
            break;
          }
          bool2 = true;
          e.a.a((e)localObject5, "checkOldConv-status", bool2, null, false, (a)new c(localThrowable, (ah.d)localObject2), 28);
          Log.i("Finder.ConversationStorage", "[checkOldConv] end");
          AppMethodBeat.o(339269);
          return bool1;
          bool1 = false;
          break label887;
          ((com.tencent.mm.storagebase.h)this.db).endTransaction(l1);
          localObject5 = new a.a();
          localObject6 = Thread.currentThread().getName();
          s.s(localObject6, "currentThread().name");
          localObject5 = ((a.a)localObject5).avh((String)localObject6).avg("UPDATE FinderConversation SET senderUserName = 'xxxx' , senderRoleType = xxx WHERE talker = xx ");
          ((a.a)localObject5).duration = (SystemClock.uptimeMillis() - l2);
          ((a.a)localObject5).avf("FinderConversationStorage.checkOldConv#UPDATE").dWL().report();
        }
      }
      finally
      {
        long l2;
        ((com.tencent.mm.storagebase.h)this.db).endTransaction(l1);
        localObject2 = new a.a();
        localObject5 = Thread.currentThread().getName();
        s.s(localObject5, "currentThread().name");
        localObject2 = ((a.a)localObject2).avh((String)localObject5).avg("UPDATE FinderConversation SET senderUserName = 'xxxx' , senderRoleType = xxx WHERE talker = xx ");
        ((a.a)localObject2).duration = (SystemClock.uptimeMillis() - l2);
        ((a.a)localObject2).avf("FinderConversationStorage.checkOldConv#UPDATE").dWL().report();
        AppMethodBeat.o(339269);
      }
    }
    finally
    {
      try
      {
        AppMethodBeat.o(339269);
        throw localThrowable;
      }
      finally
      {
        kotlin.f.b.a((Closeable)localObject2, localThrowable);
        AppMethodBeat.o(339269);
      }
      localObject4 = ah.aiuX;
      kotlin.f.b.a((Closeable)localObject2, null);
      Log.i("Finder.ConversationStorage", s.X("[convList] size:", Integer.valueOf(localThrowable.size())));
      localObject4 = z.bAM();
      localObject6 = z.bAW();
      bool2 = false;
      l1 = ((com.tencent.mm.storagebase.h)this.db).beginTransaction(-1L);
      bool1 = true;
      localObject2 = new ah.d();
      l2 = System.currentTimeMillis();
    }
    for (;;)
    {
      Object localObject8;
      CharSequence localCharSequence;
      boolean bool3;
      if (i != 0)
      {
        if (au.bwV(((com.tencent.mm.plugin.finder.conv.b)localObject8).field_talker))
        {
          ((com.tencent.mm.plugin.finder.conv.b)localObject8).field_senderUserName = ((String)localObject4);
          ((com.tencent.mm.plugin.finder.conv.b)localObject8).field_senderRoleType = 1;
          localObject8 = "UPDATE FinderConversation SET senderUserName = '" + ((com.tencent.mm.plugin.finder.conv.b)localObject8).field_senderUserName + "' , senderRoleType = '" + ((com.tencent.mm.plugin.finder.conv.b)localObject8).field_senderRoleType + "' WHERE talker = '" + ((com.tencent.mm.plugin.finder.conv.b)localObject8).field_talker + "' ";
          bool3 = this.db.execSQL("FinderConversation", (String)localObject8);
          if (bool3) {
            break label874;
          }
          ((ah.d)localObject2).aixb += 1;
          break label874;
        }
        ((com.tencent.mm.plugin.finder.conv.b)localObject8).field_senderUserName = ((String)localObject6);
        ((com.tencent.mm.plugin.finder.conv.b)localObject8).field_senderRoleType = 3;
      }
      label869:
      label874:
      while ((!bool1) || (!bool3))
      {
        for (;;)
        {
          Object localObject5;
          bool2 = false;
        }
        break label887;
        i = 1;
        break;
      }
      bool1 = true;
      label887:
      continue;
      label890:
      int i = 0;
    }
  }
  
  public final int eYJ()
  {
    AppMethodBeat.i(339238);
    long l = SystemClock.uptimeMillis();
    Object localObject2 = "select count(*) from FinderConversation WHERE scene=1 and type=3";
    Closeable localCloseable = (Closeable)this.db.rawQuery((String)localObject2, null);
    try
    {
      Object localObject1 = (Cursor)localCloseable;
      a.a locala = new a.a();
      String str = Thread.currentThread().getName();
      s.s(str, "currentThread().name");
      localObject2 = locala.avh(str).avg((String)localObject2);
      ((a.a)localObject2).duration = (SystemClock.uptimeMillis() - l);
      ((a.a)localObject2).avf("FinderConversationStorage.getAliasConvCount").dWL().report();
      if (((Cursor)localObject1).moveToFirst())
      {
        i = ((Cursor)localObject1).getInt(0);
        localObject1 = ah.aiuX;
        kotlin.f.b.a(localCloseable, null);
        AppMethodBeat.o(339238);
        return i;
      }
    }
    finally
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.o(339238);
          throw localThrowable;
        }
        finally
        {
          kotlin.f.b.a(localCloseable, localThrowable);
          AppMethodBeat.o(339238);
        }
        int i = 0;
      }
    }
  }
  
  public final int im(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(339244);
    Object localObject1;
    if (paramInt2 >= 0) {
      localObject1 = "select sum(unReadCount) from FinderConversation WHERE type=" + paramInt2 + " and scene=" + paramInt1;
    }
    for (;;)
    {
      long l = SystemClock.uptimeMillis();
      Object localObject2 = (Closeable)this.db.rawQuery((String)localObject1, null);
      try
      {
        Object localObject3 = (Cursor)localObject2;
        if ((((Cursor)localObject3).moveToFirst()) && (!((Cursor)localObject3).isAfterLast()))
        {
          paramInt1 = ((Cursor)localObject3).getInt(0);
          localObject3 = ah.aiuX;
          kotlin.f.b.a((Closeable)localObject2, null);
          localObject2 = new a.a();
          localObject3 = Thread.currentThread().getName();
          s.s(localObject3, "currentThread().name");
          localObject1 = ((a.a)localObject2).avh((String)localObject3).avg((String)localObject1);
          ((a.a)localObject1).duration = (SystemClock.uptimeMillis() - l);
          ((a.a)localObject1).avf("FinderConversationStorage.getUnreadCount").dWL().report();
          Log.i("Finder.ConversationStorage", "[getUnreadCount] type=" + paramInt2 + " count=" + paramInt1);
          AppMethodBeat.o(339244);
          return paramInt1;
          localObject1 = s.X("select sum(unReadCount) from FinderConversation WHERE scene=", Integer.valueOf(paramInt1));
          continue;
        }
      }
      finally
      {
        for (;;)
        {
          try
          {
            AppMethodBeat.o(339244);
            throw localThrowable;
          }
          finally
          {
            kotlin.f.b.a((Closeable)localObject2, localThrowable);
            AppMethodBeat.o(339244);
          }
          paramInt1 = 0;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage$Companion;", "", "()V", "HOLDER_PLACE", "", "SET_TOP_PLACE", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "UNSET_TOP_PLACE", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<String>
  {
    b(Exception paramException)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<String>
  {
    c(LinkedList<com.tencent.mm.plugin.finder.conv.b> paramLinkedList, ah.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.g
 * JD-Core Version:    0.7.0.1
 */