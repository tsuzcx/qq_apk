package com.tencent.mm.plugin.forcenotify.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.forcenotify.d.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/storage/ForceNotifyStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "()V", "TABLE_NAME", "", "TAG", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "mCache", "Ljava/util/concurrent/ConcurrentHashMap;", "delete", "", "forcePushId", "deleteExpireInfo", "", "deleteGameLife", "get", "userName", "getById", "getErrorCount", "", "getExpireTime", "", "getList", "Ljava/util/ArrayList;", "getListExcept", "pushIdList", "", "getUnExpireCount", "isHasSetForceNotify", "isNeedNotify", "set", "info", "transformOldData", "updateStatus", "status", "plugin-force-notify_release"})
public final class b
  extends MAutoStorage<d>
{
  public static final ConcurrentHashMap<String, d> BDZ;
  public static final b BEa;
  public static final com.tencent.mm.storagebase.h lvy;
  
  static
  {
    AppMethodBeat.i(149193);
    BEa = new b();
    Object localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = ((f)localObject).getDataDB();
    if (localObject == null) {
      p.iCn();
    }
    lvy = (com.tencent.mm.storagebase.h)localObject;
    BDZ = new ConcurrentHashMap();
    AppMethodBeat.o(149193);
  }
  
  private b()
  {
    super((ISQLiteDatabase)localf.getDataDB(), d.info, "ForceNotifyData", new String[] { "DROP INDEX IF EXISTS statusIndex", "CREATE INDEX IF NOT EXISTS userNameIndex ON ForceNotifyData(UserName)", "CREATE INDEX IF NOT EXISTS forcePushIdIndex ON ForceNotifyData(ForcePushId)", "CREATE INDEX IF NOT EXISTS ForceNotifyData_statusIndex ON ForceNotifyData(Status)", "CREATE INDEX IF NOT EXISTS expireTimeIndex ON ForceNotifyData(ExpiredTime)" });
    AppMethodBeat.i(149192);
    AppMethodBeat.o(149192);
  }
  
  /* Error */
  public static boolean aHs(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 128
    //   4: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 129
    //   10: invokestatic 132	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: ldc 134
    //   15: new 136	java/lang/StringBuilder
    //   18: dup
    //   19: ldc 138
    //   21: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: bipush 41
    //   30: invokevirtual 148	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   33: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 94	com/tencent/mm/plugin/forcenotify/e/b:BDZ	Ljava/util/concurrent/ConcurrentHashMap;
    //   42: invokevirtual 161	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   45: ifne +46 -> 91
    //   48: getstatic 94	com/tencent/mm/plugin/forcenotify/e/b:BDZ	Ljava/util/concurrent/ConcurrentHashMap;
    //   51: aload_0
    //   52: invokevirtual 164	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 102	com/tencent/mm/plugin/forcenotify/d/d
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull +31 -> 91
    //   63: aload_3
    //   64: invokevirtual 167	com/tencent/mm/plugin/forcenotify/d/d:eqj	()Z
    //   67: ifne +17 -> 84
    //   70: aload_3
    //   71: invokevirtual 170	com/tencent/mm/plugin/forcenotify/d/d:isEnable	()Z
    //   74: ifeq +10 -> 84
    //   77: ldc 128
    //   79: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: iconst_1
    //   83: ireturn
    //   84: ldc 128
    //   86: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: iconst_0
    //   90: ireturn
    //   91: getstatic 89	com/tencent/mm/plugin/forcenotify/e/b:lvy	Lcom/tencent/mm/storagebase/h;
    //   94: ldc 107
    //   96: iconst_1
    //   97: anewarray 109	java/lang/String
    //   100: dup
    //   101: iconst_0
    //   102: ldc 172
    //   104: aastore
    //   105: ldc 174
    //   107: iconst_1
    //   108: anewarray 109	java/lang/String
    //   111: dup
    //   112: iconst_0
    //   113: aload_0
    //   114: aastore
    //   115: aconst_null
    //   116: aconst_null
    //   117: aconst_null
    //   118: iconst_2
    //   119: invokevirtual 180	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   122: astore 4
    //   124: aload 4
    //   126: checkcast 182	java/io/Closeable
    //   129: astore_3
    //   130: aload 4
    //   132: invokeinterface 187 1 0
    //   137: ifeq +91 -> 228
    //   140: new 102	com/tencent/mm/plugin/forcenotify/d/d
    //   143: dup
    //   144: invokespecial 188	com/tencent/mm/plugin/forcenotify/d/d:<init>	()V
    //   147: astore 5
    //   149: aload 5
    //   151: aload 4
    //   153: invokevirtual 192	com/tencent/mm/plugin/forcenotify/d/d:convertFrom	(Landroid/database/Cursor;)V
    //   156: getstatic 94	com/tencent/mm/plugin/forcenotify/e/b:BDZ	Ljava/util/concurrent/ConcurrentHashMap;
    //   159: checkcast 194	java/util/Map
    //   162: aload_0
    //   163: aload 5
    //   165: invokeinterface 198 3 0
    //   170: pop
    //   171: ldc 134
    //   173: ldc 200
    //   175: iconst_2
    //   176: anewarray 202	java/lang/Object
    //   179: dup
    //   180: iconst_0
    //   181: aload_0
    //   182: aastore
    //   183: dup
    //   184: iconst_1
    //   185: aload 5
    //   187: aastore
    //   188: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: aload 5
    //   193: invokevirtual 167	com/tencent/mm/plugin/forcenotify/d/d:eqj	()Z
    //   196: ifne +27 -> 223
    //   199: aload 5
    //   201: invokevirtual 170	com/tencent/mm/plugin/forcenotify/d/d:isEnable	()Z
    //   204: istore_1
    //   205: iload_1
    //   206: ifeq +17 -> 223
    //   209: iconst_1
    //   210: istore_1
    //   211: aload_3
    //   212: aconst_null
    //   213: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   216: ldc 128
    //   218: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: iload_1
    //   222: ireturn
    //   223: iconst_0
    //   224: istore_1
    //   225: goto -14 -> 211
    //   228: getstatic 217	kotlin/x:aazN	Lkotlin/x;
    //   231: astore_0
    //   232: aload_3
    //   233: aconst_null
    //   234: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   237: ldc 128
    //   239: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: iconst_0
    //   243: ireturn
    //   244: astore_2
    //   245: ldc 128
    //   247: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload_2
    //   251: athrow
    //   252: astore_0
    //   253: aload_3
    //   254: aload_2
    //   255: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   258: ldc 128
    //   260: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload_0
    //   264: athrow
    //   265: astore_0
    //   266: goto -13 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	paramString	String
    //   204	21	1	bool	boolean
    //   1	1	2	localObject1	Object
    //   244	11	2	localThrowable	java.lang.Throwable
    //   58	196	3	localObject2	Object
    //   122	30	4	localCursor	android.database.Cursor
    //   147	53	5	locald	d
    // Exception table:
    //   from	to	target	type
    //   130	205	244	java/lang/Throwable
    //   228	232	244	java/lang/Throwable
    //   245	252	252	finally
    //   130	205	265	finally
    //   228	232	265	finally
  }
  
  /* Error */
  public static boolean aHw(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 219
    //   4: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 129
    //   10: invokestatic 132	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: ldc 134
    //   15: new 136	java/lang/StringBuilder
    //   18: dup
    //   19: ldc 221
    //   21: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: bipush 41
    //   30: invokevirtual 148	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   33: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 94	com/tencent/mm/plugin/forcenotify/e/b:BDZ	Ljava/util/concurrent/ConcurrentHashMap;
    //   42: invokevirtual 161	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   45: ifne +30 -> 75
    //   48: getstatic 94	com/tencent/mm/plugin/forcenotify/e/b:BDZ	Ljava/util/concurrent/ConcurrentHashMap;
    //   51: aload_0
    //   52: invokevirtual 164	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 102	com/tencent/mm/plugin/forcenotify/d/d
    //   58: ifnonnull +10 -> 68
    //   61: ldc 219
    //   63: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: iconst_0
    //   67: ireturn
    //   68: ldc 219
    //   70: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: iconst_1
    //   74: ireturn
    //   75: getstatic 89	com/tencent/mm/plugin/forcenotify/e/b:lvy	Lcom/tencent/mm/storagebase/h;
    //   78: ldc 107
    //   80: iconst_1
    //   81: anewarray 109	java/lang/String
    //   84: dup
    //   85: iconst_0
    //   86: ldc 172
    //   88: aastore
    //   89: ldc 174
    //   91: iconst_1
    //   92: anewarray 109	java/lang/String
    //   95: dup
    //   96: iconst_0
    //   97: aload_0
    //   98: aastore
    //   99: aconst_null
    //   100: aconst_null
    //   101: aconst_null
    //   102: iconst_2
    //   103: invokevirtual 180	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   106: astore_3
    //   107: aload_3
    //   108: checkcast 182	java/io/Closeable
    //   111: astore_2
    //   112: aload_3
    //   113: ifnonnull +6 -> 119
    //   116: invokestatic 87	kotlin/g/b/p:iCn	()V
    //   119: aload_3
    //   120: invokeinterface 187 1 0
    //   125: ifeq +50 -> 175
    //   128: new 102	com/tencent/mm/plugin/forcenotify/d/d
    //   131: dup
    //   132: invokespecial 188	com/tencent/mm/plugin/forcenotify/d/d:<init>	()V
    //   135: astore 4
    //   137: aload 4
    //   139: aload_3
    //   140: invokevirtual 192	com/tencent/mm/plugin/forcenotify/d/d:convertFrom	(Landroid/database/Cursor;)V
    //   143: ldc 134
    //   145: ldc 223
    //   147: iconst_2
    //   148: anewarray 202	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: aload_0
    //   154: aastore
    //   155: dup
    //   156: iconst_1
    //   157: aload 4
    //   159: aastore
    //   160: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: aload_2
    //   164: aconst_null
    //   165: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   168: ldc 219
    //   170: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: iconst_1
    //   174: ireturn
    //   175: getstatic 217	kotlin/x:aazN	Lkotlin/x;
    //   178: astore_0
    //   179: aload_2
    //   180: aconst_null
    //   181: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   184: ldc 219
    //   186: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_1
    //   192: ldc 219
    //   194: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: aload_1
    //   198: athrow
    //   199: astore_0
    //   200: aload_2
    //   201: aload_1
    //   202: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   205: ldc 219
    //   207: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_0
    //   211: athrow
    //   212: astore_0
    //   213: goto -13 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramString	String
    //   1	1	1	localObject	Object
    //   191	11	1	localThrowable	java.lang.Throwable
    //   111	90	2	localCloseable	java.io.Closeable
    //   106	34	3	localCursor	android.database.Cursor
    //   135	23	4	locald	d
    // Exception table:
    //   from	to	target	type
    //   116	119	191	java/lang/Throwable
    //   119	163	191	java/lang/Throwable
    //   175	179	191	java/lang/Throwable
    //   192	199	199	finally
    //   116	119	212	finally
    //   119	163	212	finally
    //   175	179	212	finally
  }
  
  /* Error */
  public static d aHx(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 226
    //   4: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 129
    //   10: invokestatic 132	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: ldc 134
    //   15: new 136	java/lang/StringBuilder
    //   18: dup
    //   19: ldc 228
    //   21: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: aload_0
    //   25: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: bipush 41
    //   30: invokevirtual 148	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   33: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: getstatic 89	com/tencent/mm/plugin/forcenotify/e/b:lvy	Lcom/tencent/mm/storagebase/h;
    //   42: ldc 107
    //   44: iconst_1
    //   45: anewarray 109	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: ldc 172
    //   52: aastore
    //   53: ldc 174
    //   55: iconst_1
    //   56: anewarray 109	java/lang/String
    //   59: dup
    //   60: iconst_0
    //   61: aload_0
    //   62: aastore
    //   63: aconst_null
    //   64: aconst_null
    //   65: ldc 230
    //   67: iconst_2
    //   68: invokevirtual 180	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   71: astore_0
    //   72: new 102	com/tencent/mm/plugin/forcenotify/d/d
    //   75: dup
    //   76: invokespecial 188	com/tencent/mm/plugin/forcenotify/d/d:<init>	()V
    //   79: astore_3
    //   80: aload_0
    //   81: checkcast 182	java/io/Closeable
    //   84: astore_2
    //   85: aload_0
    //   86: invokeinterface 187 1 0
    //   91: pop
    //   92: aload_0
    //   93: ifnonnull +6 -> 99
    //   96: invokestatic 87	kotlin/g/b/p:iCn	()V
    //   99: aload_0
    //   100: invokeinterface 233 1 0
    //   105: ifne +20 -> 125
    //   108: aload_3
    //   109: aload_0
    //   110: invokevirtual 192	com/tencent/mm/plugin/forcenotify/d/d:convertFrom	(Landroid/database/Cursor;)V
    //   113: aload_2
    //   114: aconst_null
    //   115: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   118: ldc 226
    //   120: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload_3
    //   124: areturn
    //   125: aload_2
    //   126: aconst_null
    //   127: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   130: ldc 226
    //   132: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aconst_null
    //   136: areturn
    //   137: astore_1
    //   138: ldc 226
    //   140: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_1
    //   144: athrow
    //   145: astore_0
    //   146: aload_2
    //   147: aload_1
    //   148: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   151: ldc 226
    //   153: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: goto -13 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	String
    //   1	1	1	localObject	Object
    //   137	11	1	localThrowable	java.lang.Throwable
    //   84	63	2	localCloseable	java.io.Closeable
    //   79	45	3	locald	d
    // Exception table:
    //   from	to	target	type
    //   85	92	137	java/lang/Throwable
    //   96	99	137	java/lang/Throwable
    //   99	113	137	java/lang/Throwable
    //   138	145	145	finally
    //   85	92	158	finally
    //   96	99	158	finally
    //   99	113	158	finally
  }
  
  /* Error */
  public static java.util.ArrayList<d> eqm()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 236
    //   4: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 134
    //   9: ldc 238
    //   11: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: new 240	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 241	java/util/ArrayList:<init>	()V
    //   21: astore_2
    //   22: ldc 243
    //   24: invokestatic 247	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   27: astore 4
    //   29: aload 4
    //   31: ldc 249
    //   33: invokestatic 78	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   36: aload 4
    //   38: checkcast 243	com/tencent/mm/plugin/messenger/foundation/a/n
    //   41: invokeinterface 253 1 0
    //   46: astore 5
    //   48: getstatic 89	com/tencent/mm/plugin/forcenotify/e/b:lvy	Lcom/tencent/mm/storagebase/h;
    //   51: astore 4
    //   53: invokestatic 259	com/tencent/mm/model/cm:bfD	()J
    //   56: lstore_0
    //   57: aload 4
    //   59: ldc 107
    //   61: iconst_1
    //   62: anewarray 109	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: ldc 172
    //   69: aastore
    //   70: ldc_w 261
    //   73: iconst_1
    //   74: anewarray 109	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: lload_0
    //   80: invokestatic 265	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   83: aastore
    //   84: aconst_null
    //   85: aconst_null
    //   86: ldc 230
    //   88: iconst_2
    //   89: invokevirtual 180	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   92: astore 6
    //   94: aload 6
    //   96: checkcast 182	java/io/Closeable
    //   99: astore 4
    //   101: aload 6
    //   103: invokeinterface 187 1 0
    //   108: pop
    //   109: aload 6
    //   111: ifnonnull +6 -> 117
    //   114: invokestatic 87	kotlin/g/b/p:iCn	()V
    //   117: aload 6
    //   119: invokeinterface 233 1 0
    //   124: ifne +136 -> 260
    //   127: new 102	com/tencent/mm/plugin/forcenotify/d/d
    //   130: dup
    //   131: invokespecial 188	com/tencent/mm/plugin/forcenotify/d/d:<init>	()V
    //   134: astore 7
    //   136: aload 7
    //   138: aload 6
    //   140: invokevirtual 192	com/tencent/mm/plugin/forcenotify/d/d:convertFrom	(Landroid/database/Cursor;)V
    //   143: aload 7
    //   145: getfield 269	com/tencent/mm/plugin/forcenotify/d/d:field_ForcePushId	Ljava/lang/String;
    //   148: ifnull +79 -> 227
    //   151: aload 7
    //   153: aload 5
    //   155: aload 7
    //   157: getfield 272	com/tencent/mm/plugin/forcenotify/d/d:field_UserName	Ljava/lang/String;
    //   160: invokeinterface 278 2 0
    //   165: putfield 282	com/tencent/mm/plugin/forcenotify/d/d:contact	Lcom/tencent/mm/storage/as;
    //   168: aload_2
    //   169: aload 7
    //   171: invokevirtual 286	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   174: pop
    //   175: ldc 134
    //   177: ldc_w 288
    //   180: iconst_1
    //   181: anewarray 202	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: aload 7
    //   188: aastore
    //   189: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: getstatic 94	com/tencent/mm/plugin/forcenotify/e/b:BDZ	Ljava/util/concurrent/ConcurrentHashMap;
    //   195: checkcast 194	java/util/Map
    //   198: astore 8
    //   200: aload 7
    //   202: getfield 269	com/tencent/mm/plugin/forcenotify/d/d:field_ForcePushId	Ljava/lang/String;
    //   205: astore 9
    //   207: aload 9
    //   209: ldc_w 290
    //   212: invokestatic 78	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   215: aload 8
    //   217: aload 9
    //   219: aload 7
    //   221: invokeinterface 198 3 0
    //   226: pop
    //   227: aload 6
    //   229: invokeinterface 293 1 0
    //   234: pop
    //   235: goto -126 -> 109
    //   238: astore_3
    //   239: ldc 236
    //   241: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   244: aload_3
    //   245: athrow
    //   246: astore_2
    //   247: aload 4
    //   249: aload_3
    //   250: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   253: ldc 236
    //   255: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload_2
    //   259: athrow
    //   260: getstatic 217	kotlin/x:aazN	Lkotlin/x;
    //   263: astore 5
    //   265: aload 4
    //   267: aconst_null
    //   268: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   271: ldc 236
    //   273: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload_2
    //   277: areturn
    //   278: astore_2
    //   279: goto -32 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   56	24	0	l	long
    //   21	148	2	localArrayList	java.util.ArrayList
    //   246	31	2	localArrayList1	java.util.ArrayList<d>
    //   278	1	2	localObject1	Object
    //   1	1	3	localObject2	Object
    //   238	12	3	localThrowable	java.lang.Throwable
    //   27	239	4	localObject3	Object
    //   46	218	5	localObject4	Object
    //   92	136	6	localCursor	android.database.Cursor
    //   134	86	7	locald	d
    //   198	18	8	localMap	Map
    //   205	13	9	str	String
    // Exception table:
    //   from	to	target	type
    //   101	109	238	java/lang/Throwable
    //   114	117	238	java/lang/Throwable
    //   117	227	238	java/lang/Throwable
    //   227	235	238	java/lang/Throwable
    //   260	265	238	java/lang/Throwable
    //   239	246	246	finally
    //   101	109	278	finally
    //   114	117	278	finally
    //   117	227	278	finally
    //   227	235	278	finally
    //   260	265	278	finally
  }
  
  /* Error */
  public static void eqo()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 297
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 134
    //   10: ldc_w 299
    //   13: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: invokestatic 302	com/tencent/mm/kernel/h:aHB	()Z
    //   19: ifeq +12 -> 31
    //   22: ldc_w 304
    //   25: invokestatic 247	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   28: ifnonnull +10 -> 38
    //   31: ldc_w 297
    //   34: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: return
    //   38: getstatic 89	com/tencent/mm/plugin/forcenotify/e/b:lvy	Lcom/tencent/mm/storagebase/h;
    //   41: astore_2
    //   42: invokestatic 259	com/tencent/mm/model/cm:bfD	()J
    //   45: lstore_0
    //   46: aload_2
    //   47: ldc 107
    //   49: iconst_1
    //   50: anewarray 109	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: ldc 172
    //   57: aastore
    //   58: ldc_w 306
    //   61: iconst_1
    //   62: anewarray 109	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: lload_0
    //   68: invokestatic 265	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   71: aastore
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: iconst_2
    //   76: invokevirtual 180	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   79: astore_2
    //   80: aload_2
    //   81: checkcast 182	java/io/Closeable
    //   84: astore 4
    //   86: aload_2
    //   87: invokeinterface 187 1 0
    //   92: pop
    //   93: aload_2
    //   94: ifnonnull +6 -> 100
    //   97: invokestatic 87	kotlin/g/b/p:iCn	()V
    //   100: aload_2
    //   101: invokeinterface 233 1 0
    //   106: ifne +79 -> 185
    //   109: new 102	com/tencent/mm/plugin/forcenotify/d/d
    //   112: dup
    //   113: invokespecial 188	com/tencent/mm/plugin/forcenotify/d/d:<init>	()V
    //   116: astore 5
    //   118: aload 5
    //   120: aload_2
    //   121: invokevirtual 192	com/tencent/mm/plugin/forcenotify/d/d:convertFrom	(Landroid/database/Cursor;)V
    //   124: ldc_w 304
    //   127: invokestatic 247	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   130: checkcast 304	com/tencent/mm/plugin/forcenotify/a/a
    //   133: aload 5
    //   135: getfield 269	com/tencent/mm/plugin/forcenotify/d/d:field_ForcePushId	Ljava/lang/String;
    //   138: iconst_5
    //   139: invokestatic 259	com/tencent/mm/model/cm:bfD	()J
    //   142: ldc2_w 307
    //   145: ldiv
    //   146: invokeinterface 312 5 0
    //   151: aload_2
    //   152: invokeinterface 293 1 0
    //   157: pop
    //   158: goto -65 -> 93
    //   161: astore_3
    //   162: ldc_w 297
    //   165: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: aload_3
    //   169: athrow
    //   170: astore_2
    //   171: aload 4
    //   173: aload_3
    //   174: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   177: ldc_w 297
    //   180: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_2
    //   184: athrow
    //   185: getstatic 217	kotlin/x:aazN	Lkotlin/x;
    //   188: astore_2
    //   189: aload 4
    //   191: aconst_null
    //   192: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   195: ldc 134
    //   197: ldc_w 314
    //   200: iconst_1
    //   201: anewarray 202	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: getstatic 89	com/tencent/mm/plugin/forcenotify/e/b:lvy	Lcom/tencent/mm/storagebase/h;
    //   209: ldc 107
    //   211: ldc_w 306
    //   214: iconst_1
    //   215: anewarray 109	java/lang/String
    //   218: dup
    //   219: iconst_0
    //   220: invokestatic 259	com/tencent/mm/model/cm:bfD	()J
    //   223: invokestatic 265	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   226: aastore
    //   227: invokevirtual 317	com/tencent/mm/storagebase/h:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   230: invokestatic 322	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: aastore
    //   234: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: ldc_w 297
    //   240: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: return
    //   244: astore_2
    //   245: goto -74 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   45	23	0	l	long
    //   41	111	2	localObject1	Object
    //   170	14	2	localObject2	Object
    //   188	1	2	localx	kotlin.x
    //   244	1	2	localObject3	Object
    //   1	1	3	localObject4	Object
    //   161	13	3	localThrowable	java.lang.Throwable
    //   84	106	4	localCloseable	java.io.Closeable
    //   116	18	5	locald	d
    // Exception table:
    //   from	to	target	type
    //   86	93	161	java/lang/Throwable
    //   97	100	161	java/lang/Throwable
    //   100	158	161	java/lang/Throwable
    //   185	189	161	java/lang/Throwable
    //   162	170	170	finally
    //   86	93	244	finally
    //   97	100	244	finally
    //   100	158	244	finally
    //   185	189	244	finally
  }
  
  public final void dw(String paramString, int paramInt)
  {
    AppMethodBeat.i(149184);
    p.k(paramString, "forcePushId");
    Log.i("MicroMsg.ForceNotifyStorage", "updateStatus(" + paramString + ", " + paramInt + ')');
    d locald = new d();
    locald.field_ForcePushId = paramString;
    if (get((IAutoDBItem)locald, new String[0]))
    {
      locald.field_Status = paramInt;
      Log.i("MicroMsg.ForceNotifyStorage", "[updateStatus] ret:%s %s", new Object[] { Long.valueOf(lvy.replace("ForceNotifyData", "ForcePushId", locald.convertTo())), locald });
      ((Map)BDZ).put(paramString, locald);
      doNotify();
    }
    AppMethodBeat.o(149184);
  }
  
  /* Error */
  public final int eqn()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 364
    //   6: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 134
    //   11: ldc_w 366
    //   14: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: new 368	java/util/LinkedList
    //   20: dup
    //   21: invokespecial 369	java/util/LinkedList:<init>	()V
    //   24: astore 4
    //   26: getstatic 89	com/tencent/mm/plugin/forcenotify/e/b:lvy	Lcom/tencent/mm/storagebase/h;
    //   29: astore 6
    //   31: invokestatic 259	com/tencent/mm/model/cm:bfD	()J
    //   34: lstore_2
    //   35: aload 6
    //   37: ldc_w 371
    //   40: iconst_1
    //   41: anewarray 109	java/lang/String
    //   44: dup
    //   45: iconst_0
    //   46: ldc 172
    //   48: aastore
    //   49: ldc_w 373
    //   52: iconst_1
    //   53: anewarray 109	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: lload_2
    //   59: invokestatic 265	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   62: aastore
    //   63: aconst_null
    //   64: aconst_null
    //   65: ldc 230
    //   67: iconst_2
    //   68: invokevirtual 180	com/tencent/mm/storagebase/h:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   71: astore 7
    //   73: aload 7
    //   75: checkcast 182	java/io/Closeable
    //   78: astore 6
    //   80: aload 7
    //   82: invokeinterface 187 1 0
    //   87: pop
    //   88: aload 7
    //   90: ifnonnull +6 -> 96
    //   93: invokestatic 87	kotlin/g/b/p:iCn	()V
    //   96: aload 7
    //   98: invokeinterface 233 1 0
    //   103: ifne +67 -> 170
    //   106: new 102	com/tencent/mm/plugin/forcenotify/d/d
    //   109: dup
    //   110: invokespecial 188	com/tencent/mm/plugin/forcenotify/d/d:<init>	()V
    //   113: astore 8
    //   115: aload 8
    //   117: aload 7
    //   119: invokevirtual 192	com/tencent/mm/plugin/forcenotify/d/d:convertFrom	(Landroid/database/Cursor;)V
    //   122: aload 4
    //   124: aload 8
    //   126: invokevirtual 374	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   129: pop
    //   130: aload 7
    //   132: invokeinterface 293 1 0
    //   137: pop
    //   138: goto -50 -> 88
    //   141: astore 5
    //   143: ldc_w 364
    //   146: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload 5
    //   151: athrow
    //   152: astore 4
    //   154: aload 6
    //   156: aload 5
    //   158: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   161: ldc_w 364
    //   164: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: aload 4
    //   169: athrow
    //   170: getstatic 217	kotlin/x:aazN	Lkotlin/x;
    //   173: astore 7
    //   175: aload 6
    //   177: aconst_null
    //   178: invokestatic 211	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   181: aload 4
    //   183: invokevirtual 378	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   186: astore 4
    //   188: iconst_0
    //   189: istore_1
    //   190: aload 4
    //   192: invokeinterface 383 1 0
    //   197: ifeq +52 -> 249
    //   200: aload 4
    //   202: invokeinterface 387 1 0
    //   207: checkcast 102	com/tencent/mm/plugin/forcenotify/d/d
    //   210: astore 5
    //   212: aload_0
    //   213: aload 5
    //   215: checkcast 334	com/tencent/mm/sdk/storage/IAutoDBItem
    //   218: iconst_0
    //   219: invokevirtual 391	com/tencent/mm/plugin/forcenotify/e/b:insertNotify	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;Z)Z
    //   222: ifne +20 -> 242
    //   225: ldc 134
    //   227: ldc_w 393
    //   230: iconst_1
    //   231: anewarray 202	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload 5
    //   238: aastore
    //   239: invokestatic 205	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: iload_1
    //   243: iconst_1
    //   244: iadd
    //   245: istore_1
    //   246: goto -56 -> 190
    //   249: getstatic 89	com/tencent/mm/plugin/forcenotify/e/b:lvy	Lcom/tencent/mm/storagebase/h;
    //   252: ldc_w 371
    //   255: invokevirtual 396	com/tencent/mm/storagebase/h:bya	(Ljava/lang/String;)Z
    //   258: pop
    //   259: ldc_w 364
    //   262: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: iload_1
    //   266: ireturn
    //   267: astore 4
    //   269: goto -115 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	this	b
    //   189	77	1	i	int
    //   34	25	2	l	long
    //   24	99	4	localLinkedList	java.util.LinkedList
    //   152	30	4	localObject1	Object
    //   186	15	4	localIterator	java.util.Iterator
    //   267	1	4	localObject2	Object
    //   1	1	5	localObject3	Object
    //   141	16	5	localThrowable	java.lang.Throwable
    //   210	27	5	locald1	d
    //   29	147	6	localObject4	Object
    //   71	103	7	localObject5	Object
    //   113	12	8	locald2	d
    // Exception table:
    //   from	to	target	type
    //   80	88	141	java/lang/Throwable
    //   93	96	141	java/lang/Throwable
    //   96	138	141	java/lang/Throwable
    //   170	175	141	java/lang/Throwable
    //   143	152	152	finally
    //   80	88	267	finally
    //   93	96	267	finally
    //   96	138	267	finally
    //   170	175	267	finally
  }
  
  public final boolean ho(String paramString)
  {
    AppMethodBeat.i(149185);
    p.k(paramString, "forcePushId");
    Log.i("MicroMsg.ForceNotifyStorage", "delete(" + paramString + ')');
    if (lvy.delete("ForceNotifyData", "ForcePushId=?", new String[] { paramString }) >= 0)
    {
      BDZ.remove(paramString);
      doNotify();
      AppMethodBeat.o(149185);
      return true;
    }
    AppMethodBeat.o(149185);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.e.b
 * JD-Core Version:    0.7.0.1
 */