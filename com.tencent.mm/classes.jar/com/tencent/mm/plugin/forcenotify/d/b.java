package com.tencent.mm.plugin.forcenotify.d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.forcenotify.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/storage/ForceNotifyStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "()V", "TABLE_NAME", "", "TAG", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "mCache", "Ljava/util/concurrent/ConcurrentHashMap;", "delete", "", "forcePushId", "deleteExpireInfo", "", "deleteGameLife", "get", "userName", "getById", "getErrorCount", "", "getExpireTime", "", "getList", "Ljava/util/ArrayList;", "getListExcept", "pushIdList", "", "getUnExpireCount", "isHasSetForceNotify", "isNeedNotify", "set", "info", "transformOldData", "updateStatus", "status", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MAutoStorage<com.tencent.mm.plugin.forcenotify.c.h>
{
  public static final ConcurrentHashMap<String, com.tencent.mm.plugin.forcenotify.c.h> HoA;
  public static final b Hoz;
  public static final com.tencent.mm.storagebase.h omV;
  
  static
  {
    AppMethodBeat.i(149193);
    Hoz = new b();
    com.tencent.mm.storagebase.h localh = com.tencent.mm.kernel.h.baE().mCN;
    s.checkNotNull(localh);
    omV = localh;
    HoA = new ConcurrentHashMap();
    AppMethodBeat.o(149193);
  }
  
  private b()
  {
    super((ISQLiteDatabase)com.tencent.mm.kernel.h.baE().mCN, com.tencent.mm.plugin.forcenotify.c.h.info, "ForceNotifyData", new String[] { "DROP INDEX IF EXISTS statusIndex", "CREATE INDEX IF NOT EXISTS userNameIndex ON ForceNotifyData(UserName)", "CREATE INDEX IF NOT EXISTS forcePushIdIndex ON ForceNotifyData(ForcePushId)", "CREATE INDEX IF NOT EXISTS ForceNotifyData_statusIndex ON ForceNotifyData(Status)", "CREATE INDEX IF NOT EXISTS expireTimeIndex ON ForceNotifyData(ExpiredTime)" });
    AppMethodBeat.i(149192);
    AppMethodBeat.o(149192);
  }
  
  public static boolean aDP(String paramString)
  {
    AppMethodBeat.i(149182);
    s.u(paramString, "forcePushId");
    Log.i("MicroMsg.ForceNotifyStorage", "isNeedNotify(" + paramString + ')');
    if (!HoA.isEmpty())
    {
      localObject1 = (com.tencent.mm.plugin.forcenotify.c.h)HoA.get(paramString);
      if (localObject1 != null)
      {
        if ((!((com.tencent.mm.plugin.forcenotify.c.h)localObject1).dgl()) && (((com.tencent.mm.plugin.forcenotify.c.h)localObject1).isEnable()))
        {
          AppMethodBeat.o(149182);
          return true;
        }
        AppMethodBeat.o(149182);
        return false;
      }
    }
    Cursor localCursor = omV.query("ForceNotifyData", new String[] { "*" }, "ForcePushId=?", new String[] { paramString }, null, null, null, 2);
    Object localObject1 = (Closeable)localCursor;
    try
    {
      if (localCursor.moveToFirst())
      {
        com.tencent.mm.plugin.forcenotify.c.h localh = new com.tencent.mm.plugin.forcenotify.c.h();
        localh.convertFrom(localCursor);
        ((Map)HoA).put(paramString, localh);
        Log.i("MicroMsg.ForceNotifyStorage", "[isNeedNotify] forcePushId:%s %s", new Object[] { paramString, localh });
        if (!localh.dgl())
        {
          bool = localh.isEnable();
          if (!bool) {}
        }
        for (boolean bool = true;; bool = false)
        {
          kotlin.f.b.a((Closeable)localObject1, null);
          AppMethodBeat.o(149182);
          return bool;
        }
      }
      paramString = ah.aiuX;
      kotlin.f.b.a((Closeable)localObject1, null);
      AppMethodBeat.o(149182);
      return false;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(149182);
        throw paramString;
      }
      finally
      {
        kotlin.f.b.a((Closeable)localObject1, paramString);
        AppMethodBeat.o(149182);
      }
    }
  }
  
  public static boolean aDS(String paramString)
  {
    AppMethodBeat.i(149183);
    s.u(paramString, "forcePushId");
    Log.i("MicroMsg.ForceNotifyStorage", "isHasSetForceNotify(" + paramString + ')');
    if (!HoA.isEmpty())
    {
      if ((com.tencent.mm.plugin.forcenotify.c.h)HoA.get(paramString) == null)
      {
        AppMethodBeat.o(149183);
        return false;
      }
      AppMethodBeat.o(149183);
      return true;
    }
    Cursor localCursor = omV.query("ForceNotifyData", new String[] { "*" }, "ForcePushId=?", new String[] { paramString }, null, null, null, 2);
    Closeable localCloseable = (Closeable)localCursor;
    try
    {
      s.checkNotNull(localCursor);
      if (localCursor.moveToFirst())
      {
        com.tencent.mm.plugin.forcenotify.c.h localh = new com.tencent.mm.plugin.forcenotify.c.h();
        localh.convertFrom(localCursor);
        Log.i("MicroMsg.ForceNotifyStorage", "[isHasSetForceNotify] id:%s %s", new Object[] { paramString, localh });
        kotlin.f.b.a(localCloseable, null);
        AppMethodBeat.o(149183);
        return true;
      }
      paramString = ah.aiuX;
      kotlin.f.b.a(localCloseable, null);
      AppMethodBeat.o(149183);
      return false;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(149183);
        throw paramString;
      }
      finally
      {
        kotlin.f.b.a(localCloseable, paramString);
        AppMethodBeat.o(149183);
      }
    }
  }
  
  public static com.tencent.mm.plugin.forcenotify.c.h aDT(String paramString)
  {
    AppMethodBeat.i(274840);
    s.u(paramString, "forcePushId");
    Log.i("MicroMsg.ForceNotifyStorage", "getById(" + paramString + ')');
    Cursor localCursor = omV.query("ForceNotifyData", new String[] { "*" }, "ForcePushId=?", new String[] { paramString }, null, null, "ExpiredTime Desc", 2);
    com.tencent.mm.plugin.forcenotify.c.h localh = new com.tencent.mm.plugin.forcenotify.c.h();
    paramString = (Closeable)localCursor;
    try
    {
      localCursor.moveToFirst();
      s.checkNotNull(localCursor);
      if (!localCursor.isAfterLast())
      {
        localh.convertFrom(localCursor);
        kotlin.f.b.a(paramString, null);
        AppMethodBeat.o(274840);
        return localh;
      }
      kotlin.f.b.a(paramString, null);
      AppMethodBeat.o(274840);
      return null;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(274840);
        throw localThrowable;
      }
      finally
      {
        kotlin.f.b.a(paramString, localThrowable);
        AppMethodBeat.o(274840);
      }
    }
  }
  
  /* Error */
  public static java.util.ArrayList<com.tencent.mm.plugin.forcenotify.c.h> fwO()
  {
    // Byte code:
    //   0: ldc 232
    //   2: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 130
    //   7: ldc 234
    //   9: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: new 236	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 237	java/util/ArrayList:<init>	()V
    //   19: astore_3
    //   20: ldc 239
    //   22: invokestatic 243	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   25: checkcast 239	com/tencent/mm/plugin/messenger/foundation/a/n
    //   28: invokeinterface 247 1 0
    //   33: astore 4
    //   35: getstatic 86	com/tencent/mm/plugin/forcenotify/d/b:omV	Lcom/tencent/mm/storagebase/h;
    //   38: astore_2
    //   39: invokestatic 253	com/tencent/mm/model/cn:bDv	()J
    //   42: lstore_0
    //   43: aload_2
    //   44: ldc 104
    //   46: iconst_1
    //   47: anewarray 106	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: ldc 168
    //   54: aastore
    //   55: ldc 255
    //   57: iconst_1
    //   58: anewarray 106	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: lload_0
    //   64: invokestatic 259	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   67: aastore
    //   68: aconst_null
    //   69: aconst_null
    //   70: ldc 226
    //   72: iconst_2
    //   73: invokevirtual 176	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   76: astore 5
    //   78: aload 5
    //   80: checkcast 178	java/io/Closeable
    //   83: astore_2
    //   84: aload 5
    //   86: invokeinterface 183 1 0
    //   91: pop
    //   92: aload 5
    //   94: invokestatic 84	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   97: aload 5
    //   99: invokeinterface 229 1 0
    //   104: ifne +137 -> 241
    //   107: new 99	com/tencent/mm/plugin/forcenotify/c/h
    //   110: dup
    //   111: invokespecial 184	com/tencent/mm/plugin/forcenotify/c/h:<init>	()V
    //   114: astore 6
    //   116: aload 6
    //   118: aload 5
    //   120: invokevirtual 188	com/tencent/mm/plugin/forcenotify/c/h:convertFrom	(Landroid/database/Cursor;)V
    //   123: aload 6
    //   125: getfield 263	com/tencent/mm/plugin/forcenotify/c/h:field_ForcePushId	Ljava/lang/String;
    //   128: ifnull +79 -> 207
    //   131: aload 6
    //   133: aload 4
    //   135: aload 6
    //   137: getfield 266	com/tencent/mm/plugin/forcenotify/c/h:field_UserName	Ljava/lang/String;
    //   140: invokeinterface 272 2 0
    //   145: putfield 276	com/tencent/mm/plugin/forcenotify/c/h:contact	Lcom/tencent/mm/storage/au;
    //   148: aload_3
    //   149: aload 6
    //   151: invokevirtual 280	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   154: pop
    //   155: ldc 130
    //   157: ldc_w 282
    //   160: iconst_1
    //   161: anewarray 198	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload 6
    //   168: aastore
    //   169: invokestatic 201	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: getstatic 91	com/tencent/mm/plugin/forcenotify/d/b:HoA	Ljava/util/concurrent/ConcurrentHashMap;
    //   175: checkcast 190	java/util/Map
    //   178: astore 7
    //   180: aload 6
    //   182: getfield 263	com/tencent/mm/plugin/forcenotify/c/h:field_ForcePushId	Ljava/lang/String;
    //   185: astore 8
    //   187: aload 8
    //   189: ldc_w 284
    //   192: invokestatic 287	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   195: aload 7
    //   197: aload 8
    //   199: aload 6
    //   201: invokeinterface 194 3 0
    //   206: pop
    //   207: aload 5
    //   209: invokeinterface 290 1 0
    //   214: pop
    //   215: goto -123 -> 92
    //   218: astore_3
    //   219: ldc 232
    //   221: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aload_3
    //   225: athrow
    //   226: astore 4
    //   228: aload_2
    //   229: aload_3
    //   230: invokestatic 207	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   233: ldc 232
    //   235: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload 4
    //   240: athrow
    //   241: getstatic 213	kotlin/ah:aiuX	Lkotlin/ah;
    //   244: astore 4
    //   246: aload_2
    //   247: aconst_null
    //   248: invokestatic 207	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   251: ldc 232
    //   253: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload_3
    //   257: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	22	0	l	long
    //   38	209	2	localObject1	Object
    //   19	130	3	localArrayList	java.util.ArrayList
    //   218	39	3	localThrowable	Throwable
    //   33	101	4	localbx	com.tencent.mm.storage.bx
    //   226	13	4	localObject2	Object
    //   244	1	4	localah	ah
    //   76	132	5	localCursor	Cursor
    //   114	86	6	localh	com.tencent.mm.plugin.forcenotify.c.h
    //   178	18	7	localMap	Map
    //   185	13	8	str	String
    // Exception table:
    //   from	to	target	type
    //   84	92	218	finally
    //   92	207	218	finally
    //   207	215	218	finally
    //   241	246	218	finally
    //   219	226	226	finally
  }
  
  public static void fwQ()
  {
    AppMethodBeat.i(149190);
    Log.i("MicroMsg.ForceNotifyStorage", "deleteExpireInfo()");
    if ((!com.tencent.mm.kernel.h.baz()) || (com.tencent.mm.kernel.h.ax(a.class) == null))
    {
      AppMethodBeat.o(149190);
      return;
    }
    Object localObject1 = omV;
    long l = cn.bDv();
    Cursor localCursor = ((com.tencent.mm.storagebase.h)localObject1).query("ForceNotifyData", new String[] { "*" }, "ExpiredTime<=?", new String[] { String.valueOf(l) }, null, null, null, 2);
    localObject1 = (Closeable)localCursor;
    try
    {
      localCursor.moveToFirst();
      for (;;)
      {
        s.checkNotNull(localCursor);
        if (localCursor.isAfterLast()) {
          break;
        }
        com.tencent.mm.plugin.forcenotify.c.h localh = new com.tencent.mm.plugin.forcenotify.c.h();
        localh.convertFrom(localCursor);
        ((a)com.tencent.mm.kernel.h.ax(a.class)).E(localh.field_ForcePushId, 5, cn.bDv() / 1000L);
        localCursor.moveToNext();
      }
      ah localah;
      return;
    }
    finally
    {
      try
      {
        AppMethodBeat.o(149190);
        throw localThrowable;
      }
      finally
      {
        kotlin.f.b.a((Closeable)localObject1, localThrowable);
        AppMethodBeat.o(149190);
      }
      localah = ah.aiuX;
      kotlin.f.b.a((Closeable)localObject1, null);
      Log.i("MicroMsg.ForceNotifyStorage", "[deleteExpireInfo] ret:%s", new Object[] { Integer.valueOf(omV.delete("ForceNotifyData", "ExpiredTime<=?", new String[] { String.valueOf(cn.bDv()) })) });
      AppMethodBeat.o(149190);
    }
  }
  
  public final void dX(String paramString, int paramInt)
  {
    AppMethodBeat.i(149184);
    s.u(paramString, "forcePushId");
    Log.i("MicroMsg.ForceNotifyStorage", "updateStatus(" + paramString + ", " + paramInt + ')');
    com.tencent.mm.plugin.forcenotify.c.h localh = new com.tencent.mm.plugin.forcenotify.c.h();
    localh.field_ForcePushId = paramString;
    if (get((IAutoDBItem)localh, new String[0]))
    {
      localh.field_Status = paramInt;
      Log.i("MicroMsg.ForceNotifyStorage", "[updateStatus] ret:%s %s", new Object[] { Long.valueOf(omV.replace("ForceNotifyData", "ForcePushId", localh.convertTo())), localh });
      ((Map)HoA).put(paramString, localh);
      doNotify();
    }
    AppMethodBeat.o(149184);
  }
  
  public final int fwP()
  {
    AppMethodBeat.i(149188);
    Log.i("MicroMsg.ForceNotifyStorage", "transformOldData()");
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = omV;
    long l = cn.bDv();
    Cursor localCursor = ((com.tencent.mm.storagebase.h)localObject1).query("ForceNotifyInfo", new String[] { "*" }, "ExpiredTime>=?", new String[] { String.valueOf(l) }, null, null, "ExpiredTime Desc", 2);
    localObject1 = (Closeable)localCursor;
    int i;
    try
    {
      localCursor.moveToFirst();
      for (;;)
      {
        s.checkNotNull(localCursor);
        if (localCursor.isAfterLast()) {
          break;
        }
        com.tencent.mm.plugin.forcenotify.c.h localh2 = new com.tencent.mm.plugin.forcenotify.c.h();
        localh2.convertFrom(localCursor);
        localLinkedList.add(localh2);
        localCursor.moveToNext();
      }
      ah localah;
      if (!((Iterator)localObject1).hasNext()) {}
    }
    finally
    {
      try
      {
        AppMethodBeat.o(149188);
        throw localThrowable;
      }
      finally
      {
        kotlin.f.b.a((Closeable)localObject1, localThrowable);
        AppMethodBeat.o(149188);
      }
      localah = ah.aiuX;
      kotlin.f.b.a((Closeable)localObject1, null);
      localObject1 = localThrowable.iterator();
      i = 0;
    }
    for (;;)
    {
      com.tencent.mm.plugin.forcenotify.c.h localh1 = (com.tencent.mm.plugin.forcenotify.c.h)((Iterator)localObject1).next();
      i += 1;
      if (!insertNotify((IAutoDBItem)localh1, false))
      {
        Log.i("MicroMsg.ForceNotifyStorage", "[transformOldData] insert error! %s", new Object[] { localh1 });
        continue;
        omV.bzv("ForceNotifyInfo");
        AppMethodBeat.o(149188);
        return i;
      }
    }
  }
  
  public final boolean iP(String paramString)
  {
    AppMethodBeat.i(149185);
    s.u(paramString, "forcePushId");
    Log.i("MicroMsg.ForceNotifyStorage", "delete(" + paramString + ')');
    if (omV.delete("ForceNotifyData", "ForcePushId=?", new String[] { paramString }) >= 0)
    {
      HoA.remove(paramString);
      doNotify();
      AppMethodBeat.o(149185);
      return true;
    }
    AppMethodBeat.o(149185);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.d.b
 * JD-Core Version:    0.7.0.1
 */