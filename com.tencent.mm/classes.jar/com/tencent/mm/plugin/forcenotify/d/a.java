package com.tencent.mm.plugin.forcenotify.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h;
import d.g.b.k;
import d.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/forcenotify/storage/ForceNotifyStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "()V", "TABLE_NAME", "", "TAG", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "mCache", "Ljava/util/concurrent/ConcurrentHashMap;", "delete", "", "forcePushId", "deleteExpireInfo", "", "get", "userName", "getErrorCount", "", "getExpireTime", "", "getList", "Ljava/util/ArrayList;", "getUnExpireCount", "isHasSetForceNotify", "isNeedNotify", "set", "info", "transformOldData", "updateStatus", "status", "plugin-force-notify_release"})
public final class a
  extends j<d>
{
  public static final h hpA;
  public static final ConcurrentHashMap<String, d> snq;
  public static final a snr;
  
  static
  {
    AppMethodBeat.i(149193);
    snr = new a();
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).agw();
    if (localObject == null) {
      k.fOy();
    }
    hpA = (h)localObject;
    snq = new ConcurrentHashMap();
    AppMethodBeat.o(149193);
  }
  
  private a()
  {
    super((com.tencent.mm.sdk.e.e)locale.agw(), d.info, "ForceNotifyData", new String[] { "CREATE INDEX IF NOT EXISTS userNameIndex ON ForceNotifyData(UserName)", "CREATE INDEX IF NOT EXISTS forcePushIdIndex ON ForceNotifyData(ForcePushId)", "CREATE INDEX IF NOT EXISTS statusIndex ON ForceNotifyData(Status)", "CREATE INDEX IF NOT EXISTS expireTimeIndex ON ForceNotifyData(ExpiredTime)" });
    AppMethodBeat.i(149192);
    AppMethodBeat.o(149192);
  }
  
  /* Error */
  public static boolean afb(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 122
    //   4: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 123
    //   10: invokestatic 126	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 90	com/tencent/mm/plugin/forcenotify/d/a:snq	Ljava/util/concurrent/ConcurrentHashMap;
    //   16: invokevirtual 130	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   19: ifne +59 -> 78
    //   22: getstatic 90	com/tencent/mm/plugin/forcenotify/d/a:snq	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_0
    //   26: invokevirtual 133	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 98	com/tencent/mm/plugin/forcenotify/c/d
    //   32: astore_0
    //   33: aload_0
    //   34: ifnonnull +10 -> 44
    //   37: ldc 122
    //   39: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_0
    //   45: ldc 135
    //   47: invokestatic 74	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   50: aload_0
    //   51: invokevirtual 138	com/tencent/mm/plugin/forcenotify/c/d:cIm	()Z
    //   54: ifne +17 -> 71
    //   57: aload_0
    //   58: invokevirtual 141	com/tencent/mm/plugin/forcenotify/c/d:isEnable	()Z
    //   61: ifeq +10 -> 71
    //   64: ldc 122
    //   66: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iconst_1
    //   70: ireturn
    //   71: ldc 122
    //   73: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: iconst_0
    //   77: ireturn
    //   78: getstatic 85	com/tencent/mm/plugin/forcenotify/d/a:hpA	Lcom/tencent/mm/storagebase/h;
    //   81: ldc 103
    //   83: iconst_1
    //   84: anewarray 105	java/lang/String
    //   87: dup
    //   88: iconst_0
    //   89: ldc 143
    //   91: aastore
    //   92: ldc 145
    //   94: iconst_1
    //   95: anewarray 105	java/lang/String
    //   98: dup
    //   99: iconst_0
    //   100: aload_0
    //   101: aastore
    //   102: aconst_null
    //   103: aconst_null
    //   104: aconst_null
    //   105: iconst_2
    //   106: invokevirtual 151	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   109: astore 4
    //   111: aload 4
    //   113: checkcast 153	java/io/Closeable
    //   116: astore_3
    //   117: aload 4
    //   119: invokeinterface 158 1 0
    //   124: ifeq +91 -> 215
    //   127: new 98	com/tencent/mm/plugin/forcenotify/c/d
    //   130: dup
    //   131: invokespecial 159	com/tencent/mm/plugin/forcenotify/c/d:<init>	()V
    //   134: astore 5
    //   136: aload 5
    //   138: aload 4
    //   140: invokevirtual 163	com/tencent/mm/plugin/forcenotify/c/d:convertFrom	(Landroid/database/Cursor;)V
    //   143: getstatic 90	com/tencent/mm/plugin/forcenotify/d/a:snq	Ljava/util/concurrent/ConcurrentHashMap;
    //   146: checkcast 165	java/util/Map
    //   149: aload_0
    //   150: aload 5
    //   152: invokeinterface 169 3 0
    //   157: pop
    //   158: ldc 171
    //   160: ldc 173
    //   162: iconst_2
    //   163: anewarray 175	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload_0
    //   169: aastore
    //   170: dup
    //   171: iconst_1
    //   172: aload 5
    //   174: aastore
    //   175: invokestatic 180	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: aload 5
    //   180: invokevirtual 138	com/tencent/mm/plugin/forcenotify/c/d:cIm	()Z
    //   183: ifne +27 -> 210
    //   186: aload 5
    //   188: invokevirtual 141	com/tencent/mm/plugin/forcenotify/c/d:isEnable	()Z
    //   191: istore_1
    //   192: iload_1
    //   193: ifeq +17 -> 210
    //   196: iconst_1
    //   197: istore_1
    //   198: aload_3
    //   199: aconst_null
    //   200: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   203: ldc 122
    //   205: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iload_1
    //   209: ireturn
    //   210: iconst_0
    //   211: istore_1
    //   212: goto -14 -> 198
    //   215: getstatic 191	d/y:KTp	Ld/y;
    //   218: astore_0
    //   219: aload_3
    //   220: aconst_null
    //   221: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   224: ldc 122
    //   226: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: iconst_0
    //   230: ireturn
    //   231: astore_2
    //   232: ldc 122
    //   234: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_2
    //   238: athrow
    //   239: astore_0
    //   240: aload_3
    //   241: aload_2
    //   242: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   245: ldc 122
    //   247: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload_0
    //   251: athrow
    //   252: astore_0
    //   253: goto -13 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	paramString	String
    //   191	21	1	bool	boolean
    //   1	1	2	localObject	Object
    //   231	11	2	localThrowable	java.lang.Throwable
    //   116	125	3	localCloseable	java.io.Closeable
    //   109	30	4	localCursor	android.database.Cursor
    //   134	53	5	locald	d
    // Exception table:
    //   from	to	target	type
    //   117	192	231	java/lang/Throwable
    //   215	219	231	java/lang/Throwable
    //   232	239	239	finally
    //   117	192	252	finally
    //   215	219	252	finally
  }
  
  /* Error */
  public static boolean afe(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 193
    //   4: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 123
    //   10: invokestatic 126	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 90	com/tencent/mm/plugin/forcenotify/d/a:snq	Ljava/util/concurrent/ConcurrentHashMap;
    //   16: invokevirtual 130	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   19: ifne +30 -> 49
    //   22: getstatic 90	com/tencent/mm/plugin/forcenotify/d/a:snq	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_0
    //   26: invokevirtual 133	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 98	com/tencent/mm/plugin/forcenotify/c/d
    //   32: ifnonnull +10 -> 42
    //   35: ldc 193
    //   37: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_0
    //   41: ireturn
    //   42: ldc 193
    //   44: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: iconst_1
    //   48: ireturn
    //   49: getstatic 85	com/tencent/mm/plugin/forcenotify/d/a:hpA	Lcom/tencent/mm/storagebase/h;
    //   52: ldc 103
    //   54: iconst_1
    //   55: anewarray 105	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc 143
    //   62: aastore
    //   63: ldc 145
    //   65: iconst_1
    //   66: anewarray 105	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: aload_0
    //   72: aastore
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: iconst_2
    //   77: invokevirtual 151	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   80: astore_3
    //   81: aload_3
    //   82: checkcast 153	java/io/Closeable
    //   85: astore_2
    //   86: aload_3
    //   87: ifnonnull +6 -> 93
    //   90: invokestatic 83	d/g/b/k:fOy	()V
    //   93: aload_3
    //   94: invokeinterface 158 1 0
    //   99: ifeq +50 -> 149
    //   102: new 98	com/tencent/mm/plugin/forcenotify/c/d
    //   105: dup
    //   106: invokespecial 159	com/tencent/mm/plugin/forcenotify/c/d:<init>	()V
    //   109: astore 4
    //   111: aload 4
    //   113: aload_3
    //   114: invokevirtual 163	com/tencent/mm/plugin/forcenotify/c/d:convertFrom	(Landroid/database/Cursor;)V
    //   117: ldc 171
    //   119: ldc 195
    //   121: iconst_2
    //   122: anewarray 175	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_0
    //   128: aastore
    //   129: dup
    //   130: iconst_1
    //   131: aload 4
    //   133: aastore
    //   134: invokestatic 180	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload_2
    //   138: aconst_null
    //   139: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   142: ldc 193
    //   144: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: iconst_1
    //   148: ireturn
    //   149: getstatic 191	d/y:KTp	Ld/y;
    //   152: astore_0
    //   153: aload_2
    //   154: aconst_null
    //   155: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   158: ldc 193
    //   160: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: iconst_0
    //   164: ireturn
    //   165: astore_1
    //   166: ldc 193
    //   168: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_1
    //   172: athrow
    //   173: astore_0
    //   174: aload_2
    //   175: aload_1
    //   176: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   179: ldc 193
    //   181: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_0
    //   185: athrow
    //   186: astore_0
    //   187: goto -13 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramString	String
    //   1	1	1	localObject	Object
    //   165	11	1	localThrowable	java.lang.Throwable
    //   85	90	2	localCloseable	java.io.Closeable
    //   80	34	3	localCursor	android.database.Cursor
    //   109	23	4	locald	d
    // Exception table:
    //   from	to	target	type
    //   90	93	165	java/lang/Throwable
    //   93	137	165	java/lang/Throwable
    //   149	153	165	java/lang/Throwable
    //   166	173	173	finally
    //   90	93	186	finally
    //   93	137	186	finally
    //   149	153	186	finally
  }
  
  /* Error */
  public static d aff(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 198
    //   4: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 199
    //   10: invokestatic 126	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 85	com/tencent/mm/plugin/forcenotify/d/a:hpA	Lcom/tencent/mm/storagebase/h;
    //   16: ldc 103
    //   18: iconst_1
    //   19: anewarray 105	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc 143
    //   26: aastore
    //   27: ldc 201
    //   29: iconst_1
    //   30: anewarray 105	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: aload_0
    //   36: aastore
    //   37: aconst_null
    //   38: aconst_null
    //   39: ldc 203
    //   41: iconst_2
    //   42: invokevirtual 151	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   45: astore_0
    //   46: new 98	com/tencent/mm/plugin/forcenotify/c/d
    //   49: dup
    //   50: invokespecial 159	com/tencent/mm/plugin/forcenotify/c/d:<init>	()V
    //   53: astore_3
    //   54: aload_0
    //   55: checkcast 153	java/io/Closeable
    //   58: astore_2
    //   59: aload_0
    //   60: invokeinterface 158 1 0
    //   65: pop
    //   66: aload_0
    //   67: ifnonnull +6 -> 73
    //   70: invokestatic 83	d/g/b/k:fOy	()V
    //   73: aload_0
    //   74: invokeinterface 206 1 0
    //   79: ifne +8 -> 87
    //   82: aload_3
    //   83: aload_0
    //   84: invokevirtual 163	com/tencent/mm/plugin/forcenotify/c/d:convertFrom	(Landroid/database/Cursor;)V
    //   87: aload_2
    //   88: aconst_null
    //   89: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   92: ldc 198
    //   94: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_3
    //   98: areturn
    //   99: astore_1
    //   100: ldc 198
    //   102: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_1
    //   106: athrow
    //   107: astore_0
    //   108: aload_2
    //   109: aload_1
    //   110: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   113: ldc 198
    //   115: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: goto -13 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   1	1	1	localObject	Object
    //   99	11	1	localThrowable	java.lang.Throwable
    //   58	51	2	localCloseable	java.io.Closeable
    //   53	45	3	locald	d
    // Exception table:
    //   from	to	target	type
    //   59	66	99	java/lang/Throwable
    //   70	73	99	java/lang/Throwable
    //   73	87	99	java/lang/Throwable
    //   100	107	107	finally
    //   59	66	120	finally
    //   70	73	120	finally
    //   73	87	120	finally
  }
  
  /* Error */
  public static java.util.ArrayList<d> cIn()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 209
    //   4: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 211	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 212	java/util/ArrayList:<init>	()V
    //   14: astore_2
    //   15: ldc 214
    //   17: invokestatic 218	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   20: astore 4
    //   22: aload 4
    //   24: ldc 220
    //   26: invokestatic 74	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   29: aload 4
    //   31: checkcast 214	com/tencent/mm/plugin/messenger/foundation/a/k
    //   34: invokeinterface 224 1 0
    //   39: astore 5
    //   41: getstatic 85	com/tencent/mm/plugin/forcenotify/d/a:hpA	Lcom/tencent/mm/storagebase/h;
    //   44: astore 4
    //   46: invokestatic 230	com/tencent/mm/model/ce:azI	()J
    //   49: lstore_0
    //   50: aload 4
    //   52: ldc 103
    //   54: iconst_1
    //   55: anewarray 105	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc 143
    //   62: aastore
    //   63: ldc 232
    //   65: iconst_1
    //   66: anewarray 105	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: lload_0
    //   72: invokestatic 236	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   75: aastore
    //   76: aconst_null
    //   77: aconst_null
    //   78: ldc 203
    //   80: iconst_2
    //   81: invokevirtual 151	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   84: astore 6
    //   86: aload 6
    //   88: checkcast 153	java/io/Closeable
    //   91: astore 4
    //   93: aload 6
    //   95: invokeinterface 158 1 0
    //   100: pop
    //   101: aload 6
    //   103: ifnonnull +6 -> 109
    //   106: invokestatic 83	d/g/b/k:fOy	()V
    //   109: aload 6
    //   111: invokeinterface 206 1 0
    //   116: ifne +136 -> 252
    //   119: new 98	com/tencent/mm/plugin/forcenotify/c/d
    //   122: dup
    //   123: invokespecial 159	com/tencent/mm/plugin/forcenotify/c/d:<init>	()V
    //   126: astore 7
    //   128: aload 7
    //   130: aload 6
    //   132: invokevirtual 163	com/tencent/mm/plugin/forcenotify/c/d:convertFrom	(Landroid/database/Cursor;)V
    //   135: aload 7
    //   137: getfield 240	com/tencent/mm/plugin/forcenotify/c/d:field_ForcePushId	Ljava/lang/String;
    //   140: ifnull +79 -> 219
    //   143: aload 7
    //   145: aload 5
    //   147: aload 7
    //   149: getfield 243	com/tencent/mm/plugin/forcenotify/c/d:field_UserName	Ljava/lang/String;
    //   152: invokeinterface 249 2 0
    //   157: putfield 253	com/tencent/mm/plugin/forcenotify/c/d:contact	Lcom/tencent/mm/storage/ai;
    //   160: aload_2
    //   161: aload 7
    //   163: invokevirtual 257	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   166: pop
    //   167: ldc 171
    //   169: ldc_w 259
    //   172: iconst_1
    //   173: anewarray 175	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload 7
    //   180: aastore
    //   181: invokestatic 180	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: getstatic 90	com/tencent/mm/plugin/forcenotify/d/a:snq	Ljava/util/concurrent/ConcurrentHashMap;
    //   187: checkcast 165	java/util/Map
    //   190: astore 8
    //   192: aload 7
    //   194: getfield 240	com/tencent/mm/plugin/forcenotify/c/d:field_ForcePushId	Ljava/lang/String;
    //   197: astore 9
    //   199: aload 9
    //   201: ldc_w 261
    //   204: invokestatic 74	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   207: aload 8
    //   209: aload 9
    //   211: aload 7
    //   213: invokeinterface 169 3 0
    //   218: pop
    //   219: aload 6
    //   221: invokeinterface 264 1 0
    //   226: pop
    //   227: goto -126 -> 101
    //   230: astore_3
    //   231: ldc 209
    //   233: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_3
    //   237: athrow
    //   238: astore_2
    //   239: aload 4
    //   241: aload_3
    //   242: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   245: ldc 209
    //   247: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: aload_2
    //   251: athrow
    //   252: getstatic 191	d/y:KTp	Ld/y;
    //   255: astore 5
    //   257: aload 4
    //   259: aconst_null
    //   260: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   263: ldc 209
    //   265: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aload_2
    //   269: areturn
    //   270: astore_2
    //   271: goto -32 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   49	23	0	l	long
    //   14	147	2	localArrayList	java.util.ArrayList
    //   238	31	2	localArrayList1	java.util.ArrayList<d>
    //   270	1	2	localObject1	Object
    //   1	1	3	localObject2	Object
    //   230	12	3	localThrowable	java.lang.Throwable
    //   20	238	4	localObject3	Object
    //   39	217	5	localObject4	Object
    //   84	136	6	localCursor	android.database.Cursor
    //   126	86	7	locald	d
    //   190	18	8	localMap	Map
    //   197	13	9	str	String
    // Exception table:
    //   from	to	target	type
    //   93	101	230	java/lang/Throwable
    //   106	109	230	java/lang/Throwable
    //   109	219	230	java/lang/Throwable
    //   219	227	230	java/lang/Throwable
    //   252	257	230	java/lang/Throwable
    //   231	238	238	finally
    //   93	101	270	finally
    //   106	109	270	finally
    //   109	219	270	finally
    //   219	227	270	finally
    //   252	257	270	finally
  }
  
  /* Error */
  public static int cIp()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 269
    //   5: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 85	com/tencent/mm/plugin/forcenotify/d/a:hpA	Lcom/tencent/mm/storagebase/h;
    //   11: ldc_w 271
    //   14: iconst_1
    //   15: anewarray 105	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: invokestatic 230	com/tencent/mm/model/ce:azI	()J
    //   23: invokestatic 236	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   26: aastore
    //   27: invokevirtual 275	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_1
    //   31: aload_1
    //   32: checkcast 153	java/io/Closeable
    //   35: astore_3
    //   36: aload_1
    //   37: ifnonnull +6 -> 43
    //   40: invokestatic 83	d/g/b/k:fOy	()V
    //   43: aload_1
    //   44: invokeinterface 158 1 0
    //   49: ifeq +24 -> 73
    //   52: aload_1
    //   53: iconst_0
    //   54: invokeinterface 279 2 0
    //   59: istore_0
    //   60: aload_3
    //   61: aconst_null
    //   62: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   65: ldc_w 269
    //   68: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: iload_0
    //   72: ireturn
    //   73: getstatic 191	d/y:KTp	Ld/y;
    //   76: astore_1
    //   77: aload_3
    //   78: aconst_null
    //   79: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   82: ldc_w 269
    //   85: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: iconst_0
    //   89: ireturn
    //   90: astore_2
    //   91: ldc_w 269
    //   94: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_2
    //   98: athrow
    //   99: astore_1
    //   100: aload_3
    //   101: aload_2
    //   102: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   105: ldc_w 269
    //   108: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_1
    //   112: athrow
    //   113: astore_1
    //   114: goto -14 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   59	13	0	i	int
    //   30	47	1	localObject1	Object
    //   99	13	1	localObject2	Object
    //   113	1	1	localObject3	Object
    //   1	1	2	localObject4	Object
    //   90	12	2	localThrowable	java.lang.Throwable
    //   35	66	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   40	43	90	java/lang/Throwable
    //   43	60	90	java/lang/Throwable
    //   73	77	90	java/lang/Throwable
    //   91	99	99	finally
    //   40	43	113	finally
    //   43	60	113	finally
    //   73	77	113	finally
  }
  
  /* Error */
  public static void cIq()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 281
    //   5: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 284	com/tencent/mm/kernel/g:agM	()Z
    //   11: ifeq +12 -> 23
    //   14: ldc_w 286
    //   17: invokestatic 218	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   20: ifnonnull +10 -> 30
    //   23: ldc_w 281
    //   26: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: return
    //   30: getstatic 85	com/tencent/mm/plugin/forcenotify/d/a:hpA	Lcom/tencent/mm/storagebase/h;
    //   33: astore_2
    //   34: invokestatic 230	com/tencent/mm/model/ce:azI	()J
    //   37: lstore_0
    //   38: aload_2
    //   39: ldc 103
    //   41: iconst_1
    //   42: anewarray 105	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: ldc 143
    //   49: aastore
    //   50: ldc_w 288
    //   53: iconst_1
    //   54: anewarray 105	java/lang/String
    //   57: dup
    //   58: iconst_0
    //   59: lload_0
    //   60: invokestatic 236	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   63: aastore
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: iconst_2
    //   68: invokevirtual 151	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   71: astore_2
    //   72: aload_2
    //   73: checkcast 153	java/io/Closeable
    //   76: astore 4
    //   78: aload_2
    //   79: invokeinterface 158 1 0
    //   84: pop
    //   85: aload_2
    //   86: ifnonnull +6 -> 92
    //   89: invokestatic 83	d/g/b/k:fOy	()V
    //   92: aload_2
    //   93: invokeinterface 206 1 0
    //   98: ifne +79 -> 177
    //   101: new 98	com/tencent/mm/plugin/forcenotify/c/d
    //   104: dup
    //   105: invokespecial 159	com/tencent/mm/plugin/forcenotify/c/d:<init>	()V
    //   108: astore 5
    //   110: aload 5
    //   112: aload_2
    //   113: invokevirtual 163	com/tencent/mm/plugin/forcenotify/c/d:convertFrom	(Landroid/database/Cursor;)V
    //   116: ldc_w 286
    //   119: invokestatic 218	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   122: checkcast 286	com/tencent/mm/plugin/forcenotify/a/a
    //   125: aload 5
    //   127: getfield 240	com/tencent/mm/plugin/forcenotify/c/d:field_ForcePushId	Ljava/lang/String;
    //   130: iconst_5
    //   131: invokestatic 230	com/tencent/mm/model/ce:azI	()J
    //   134: ldc2_w 289
    //   137: ldiv
    //   138: invokeinterface 293 5 0
    //   143: aload_2
    //   144: invokeinterface 264 1 0
    //   149: pop
    //   150: goto -65 -> 85
    //   153: astore_3
    //   154: ldc_w 281
    //   157: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_3
    //   161: athrow
    //   162: astore_2
    //   163: aload 4
    //   165: aload_3
    //   166: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   169: ldc_w 281
    //   172: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_2
    //   176: athrow
    //   177: getstatic 191	d/y:KTp	Ld/y;
    //   180: astore_2
    //   181: aload 4
    //   183: aconst_null
    //   184: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   187: ldc 171
    //   189: ldc_w 295
    //   192: iconst_1
    //   193: anewarray 175	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: getstatic 85	com/tencent/mm/plugin/forcenotify/d/a:hpA	Lcom/tencent/mm/storagebase/h;
    //   201: ldc 103
    //   203: ldc_w 288
    //   206: iconst_1
    //   207: anewarray 105	java/lang/String
    //   210: dup
    //   211: iconst_0
    //   212: invokestatic 230	com/tencent/mm/model/ce:azI	()J
    //   215: invokestatic 236	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   218: aastore
    //   219: invokevirtual 298	com/tencent/mm/storagebase/h:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   222: invokestatic 303	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: invokestatic 180	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: ldc_w 281
    //   232: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: return
    //   236: astore_2
    //   237: goto -74 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   37	23	0	l	long
    //   33	111	2	localObject1	Object
    //   162	14	2	localObject2	Object
    //   180	1	2	localy	d.y
    //   236	1	2	localObject3	Object
    //   1	1	3	localObject4	Object
    //   153	13	3	localThrowable	java.lang.Throwable
    //   76	106	4	localCloseable	java.io.Closeable
    //   108	18	5	locald	d
    // Exception table:
    //   from	to	target	type
    //   78	85	153	java/lang/Throwable
    //   89	92	153	java/lang/Throwable
    //   92	150	153	java/lang/Throwable
    //   177	181	153	java/lang/Throwable
    //   154	162	162	finally
    //   78	85	236	finally
    //   89	92	236	finally
    //   92	150	236	finally
    //   177	181	236	finally
  }
  
  /* Error */
  public static int getErrorCount()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 304
    //   5: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 85	com/tencent/mm/plugin/forcenotify/d/a:hpA	Lcom/tencent/mm/storagebase/h;
    //   11: ldc_w 306
    //   14: iconst_1
    //   15: anewarray 105	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc_w 308
    //   23: aastore
    //   24: invokevirtual 275	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore_1
    //   28: aload_1
    //   29: checkcast 153	java/io/Closeable
    //   32: astore_3
    //   33: aload_1
    //   34: ifnonnull +6 -> 40
    //   37: invokestatic 83	d/g/b/k:fOy	()V
    //   40: aload_1
    //   41: invokeinterface 158 1 0
    //   46: ifeq +24 -> 70
    //   49: aload_1
    //   50: iconst_0
    //   51: invokeinterface 279 2 0
    //   56: istore_0
    //   57: aload_3
    //   58: aconst_null
    //   59: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   62: ldc_w 304
    //   65: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: iload_0
    //   69: ireturn
    //   70: getstatic 191	d/y:KTp	Ld/y;
    //   73: astore_1
    //   74: aload_3
    //   75: aconst_null
    //   76: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   79: ldc_w 304
    //   82: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: iconst_0
    //   86: ireturn
    //   87: astore_2
    //   88: ldc_w 304
    //   91: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_2
    //   95: athrow
    //   96: astore_1
    //   97: aload_3
    //   98: aload_2
    //   99: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   102: ldc_w 304
    //   105: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: goto -14 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   56	13	0	i	int
    //   27	47	1	localObject1	Object
    //   96	13	1	localObject2	Object
    //   110	1	1	localObject3	Object
    //   1	1	2	localObject4	Object
    //   87	12	2	localThrowable	java.lang.Throwable
    //   32	66	3	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   37	40	87	java/lang/Throwable
    //   40	57	87	java/lang/Throwable
    //   70	74	87	java/lang/Throwable
    //   88	96	96	finally
    //   37	40	110	finally
    //   40	57	110	finally
    //   70	74	110	finally
  }
  
  /* Error */
  public final int cIo()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 310
    //   6: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 312	java/util/LinkedList
    //   12: dup
    //   13: invokespecial 313	java/util/LinkedList:<init>	()V
    //   16: astore 4
    //   18: getstatic 85	com/tencent/mm/plugin/forcenotify/d/a:hpA	Lcom/tencent/mm/storagebase/h;
    //   21: astore 6
    //   23: invokestatic 230	com/tencent/mm/model/ce:azI	()J
    //   26: lstore_2
    //   27: aload 6
    //   29: ldc_w 315
    //   32: iconst_1
    //   33: anewarray 105	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc 143
    //   40: aastore
    //   41: ldc_w 317
    //   44: iconst_1
    //   45: anewarray 105	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: lload_2
    //   51: invokestatic 236	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   54: aastore
    //   55: aconst_null
    //   56: aconst_null
    //   57: ldc 203
    //   59: iconst_2
    //   60: invokevirtual 151	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   63: astore 7
    //   65: aload 7
    //   67: checkcast 153	java/io/Closeable
    //   70: astore 6
    //   72: aload 7
    //   74: invokeinterface 158 1 0
    //   79: pop
    //   80: aload 7
    //   82: ifnonnull +6 -> 88
    //   85: invokestatic 83	d/g/b/k:fOy	()V
    //   88: aload 7
    //   90: invokeinterface 206 1 0
    //   95: ifne +67 -> 162
    //   98: new 98	com/tencent/mm/plugin/forcenotify/c/d
    //   101: dup
    //   102: invokespecial 159	com/tencent/mm/plugin/forcenotify/c/d:<init>	()V
    //   105: astore 8
    //   107: aload 8
    //   109: aload 7
    //   111: invokevirtual 163	com/tencent/mm/plugin/forcenotify/c/d:convertFrom	(Landroid/database/Cursor;)V
    //   114: aload 4
    //   116: aload 8
    //   118: invokevirtual 318	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload 7
    //   124: invokeinterface 264 1 0
    //   129: pop
    //   130: goto -50 -> 80
    //   133: astore 5
    //   135: ldc_w 310
    //   138: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload 5
    //   143: athrow
    //   144: astore 4
    //   146: aload 6
    //   148: aload 5
    //   150: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   153: ldc_w 310
    //   156: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload 4
    //   161: athrow
    //   162: getstatic 191	d/y:KTp	Ld/y;
    //   165: astore 7
    //   167: aload 6
    //   169: aconst_null
    //   170: invokestatic 185	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   173: aload 4
    //   175: invokevirtual 322	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   178: astore 4
    //   180: iconst_0
    //   181: istore_1
    //   182: aload 4
    //   184: invokeinterface 327 1 0
    //   189: ifeq +52 -> 241
    //   192: aload 4
    //   194: invokeinterface 331 1 0
    //   199: checkcast 98	com/tencent/mm/plugin/forcenotify/c/d
    //   202: astore 5
    //   204: aload_0
    //   205: aload 5
    //   207: checkcast 333	com/tencent/mm/sdk/e/c
    //   210: iconst_0
    //   211: invokevirtual 337	com/tencent/mm/plugin/forcenotify/d/a:insertNotify	(Lcom/tencent/mm/sdk/e/c;Z)Z
    //   214: ifne +20 -> 234
    //   217: ldc 171
    //   219: ldc_w 339
    //   222: iconst_1
    //   223: anewarray 175	java/lang/Object
    //   226: dup
    //   227: iconst_0
    //   228: aload 5
    //   230: aastore
    //   231: invokestatic 180	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: iload_1
    //   235: iconst_1
    //   236: iadd
    //   237: istore_1
    //   238: goto -56 -> 182
    //   241: getstatic 85	com/tencent/mm/plugin/forcenotify/d/a:hpA	Lcom/tencent/mm/storagebase/h;
    //   244: ldc_w 315
    //   247: invokevirtual 342	com/tencent/mm/storagebase/h:aPk	(Ljava/lang/String;)Z
    //   250: pop
    //   251: ldc_w 310
    //   254: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   257: iload_1
    //   258: ireturn
    //   259: astore 4
    //   261: goto -115 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	this	a
    //   181	77	1	i	int
    //   26	25	2	l	long
    //   16	99	4	localLinkedList	java.util.LinkedList
    //   144	30	4	localObject1	Object
    //   178	15	4	localIterator	java.util.Iterator
    //   259	1	4	localObject2	Object
    //   1	1	5	localObject3	Object
    //   133	16	5	localThrowable	java.lang.Throwable
    //   202	27	5	locald1	d
    //   21	147	6	localObject4	Object
    //   63	103	7	localObject5	Object
    //   105	12	8	locald2	d
    // Exception table:
    //   from	to	target	type
    //   72	80	133	java/lang/Throwable
    //   85	88	133	java/lang/Throwable
    //   88	130	133	java/lang/Throwable
    //   162	167	133	java/lang/Throwable
    //   135	144	144	finally
    //   72	80	259	finally
    //   85	88	259	finally
    //   88	130	259	finally
    //   162	167	259	finally
  }
  
  public final void cP(String paramString, int paramInt)
  {
    AppMethodBeat.i(149184);
    k.h(paramString, "forcePushId");
    d locald = new d();
    locald.field_ForcePushId = paramString;
    if (get((c)locald, new String[0]))
    {
      locald.field_Status = paramInt;
      ac.i("MicroMsg.ForceNotifyStorage", "[updateStatus] ret:%s %s", new Object[] { Long.valueOf(hpA.replace("ForceNotifyData", "ForcePushId", locald.convertTo())), locald });
      ((Map)snq).put(paramString, locald);
      doNotify();
    }
    AppMethodBeat.o(149184);
  }
  
  public final boolean zB(String paramString)
  {
    AppMethodBeat.i(149185);
    k.h(paramString, "forcePushId");
    if (hpA.delete("ForceNotifyData", "ForcePushId=?", new String[] { paramString }) >= 0)
    {
      snq.remove(paramString);
      doNotify();
      AppMethodBeat.o(149185);
      return true;
    }
    AppMethodBeat.o(149185);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.d.a
 * JD-Core Version:    0.7.0.1
 */