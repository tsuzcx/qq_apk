package com.tencent.mm.plugin.forcenotify.d;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.forcenotify.c.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/forcenotify/storage/ForceNotifyStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "()V", "TABLE_NAME", "", "TAG", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "mCache", "Ljava/util/concurrent/ConcurrentHashMap;", "delete", "", "forcePushId", "deleteExpireInfo", "", "getErrorCount", "", "getExpireTime", "", "getList", "Ljava/util/ArrayList;", "getUnExpireCount", "isHasSetForceNotify", "isNeedNotify", "set", "info", "userName", "transformOldData", "updateStatus", "status", "plugin-force-notify_release"})
public final class a
  extends com.tencent.mm.sdk.e.j<d>
{
  public static final h fnw;
  public static final ConcurrentHashMap<String, d> mHv;
  public static final a mHw;
  
  static
  {
    AppMethodBeat.i(51062);
    mHw = new a();
    Object localObject = g.RL();
    a.f.b.j.p(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).Rq();
    if (localObject == null) {
      a.f.b.j.ebi();
    }
    fnw = (h)localObject;
    mHv = new ConcurrentHashMap();
    AppMethodBeat.o(51062);
  }
  
  private a()
  {
    super((com.tencent.mm.sdk.e.e)locale.Rq(), d.info, "ForceNotifyData", new String[] { "CREATE INDEX IF NOT EXISTS userNameIndex ON ForceNotifyData(UserName)", "CREATE INDEX IF NOT EXISTS forcePushIdIndex ON ForceNotifyData(ForcePushId)", "CREATE INDEX IF NOT EXISTS statusIndex ON ForceNotifyData(Status)", "CREATE INDEX IF NOT EXISTS expireTimeIndex ON ForceNotifyData(ExpiredTime)" });
    AppMethodBeat.i(51061);
    AppMethodBeat.o(51061);
  }
  
  /* Error */
  public static boolean On(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 121
    //   4: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 122
    //   10: invokestatic 125	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 89	com/tencent/mm/plugin/forcenotify/d/a:mHv	Ljava/util/concurrent/ConcurrentHashMap;
    //   16: invokevirtual 129	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   19: ifne +59 -> 78
    //   22: getstatic 89	com/tencent/mm/plugin/forcenotify/d/a:mHv	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_0
    //   26: invokevirtual 133	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 97	com/tencent/mm/plugin/forcenotify/c/d
    //   32: astore_0
    //   33: aload_0
    //   34: ifnonnull +10 -> 44
    //   37: ldc 121
    //   39: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_0
    //   45: ldc 135
    //   47: invokestatic 73	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   50: aload_0
    //   51: invokevirtual 138	com/tencent/mm/plugin/forcenotify/c/d:bzK	()Z
    //   54: ifne +17 -> 71
    //   57: aload_0
    //   58: invokevirtual 141	com/tencent/mm/plugin/forcenotify/c/d:isEnable	()Z
    //   61: ifeq +10 -> 71
    //   64: ldc 121
    //   66: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iconst_1
    //   70: ireturn
    //   71: ldc 121
    //   73: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: iconst_0
    //   77: ireturn
    //   78: getstatic 84	com/tencent/mm/plugin/forcenotify/d/a:fnw	Lcom/tencent/mm/cg/h;
    //   81: ldc 102
    //   83: iconst_1
    //   84: anewarray 104	java/lang/String
    //   87: dup
    //   88: iconst_0
    //   89: ldc 143
    //   91: aastore
    //   92: ldc 145
    //   94: iconst_1
    //   95: anewarray 104	java/lang/String
    //   98: dup
    //   99: iconst_0
    //   100: aload_0
    //   101: aastore
    //   102: aconst_null
    //   103: aconst_null
    //   104: aconst_null
    //   105: iconst_2
    //   106: invokevirtual 151	com/tencent/mm/cg/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   109: astore 4
    //   111: aload 4
    //   113: checkcast 153	java/io/Closeable
    //   116: astore_3
    //   117: aload 4
    //   119: invokeinterface 158 1 0
    //   124: ifeq +91 -> 215
    //   127: new 97	com/tencent/mm/plugin/forcenotify/c/d
    //   130: dup
    //   131: invokespecial 159	com/tencent/mm/plugin/forcenotify/c/d:<init>	()V
    //   134: astore 5
    //   136: aload 5
    //   138: aload 4
    //   140: invokevirtual 163	com/tencent/mm/plugin/forcenotify/c/d:convertFrom	(Landroid/database/Cursor;)V
    //   143: getstatic 89	com/tencent/mm/plugin/forcenotify/d/a:mHv	Ljava/util/concurrent/ConcurrentHashMap;
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
    //   175: invokestatic 180	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: aload 5
    //   180: invokevirtual 138	com/tencent/mm/plugin/forcenotify/c/d:bzK	()Z
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
    //   200: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   203: ldc 121
    //   205: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iload_1
    //   209: ireturn
    //   210: iconst_0
    //   211: istore_1
    //   212: goto -14 -> 198
    //   215: getstatic 191	a/y:BMg	La/y;
    //   218: astore_0
    //   219: aload_3
    //   220: aconst_null
    //   221: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   224: ldc 121
    //   226: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: iconst_0
    //   230: ireturn
    //   231: astore_2
    //   232: ldc 121
    //   234: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload_2
    //   238: athrow
    //   239: astore_0
    //   240: aload_3
    //   241: aload_2
    //   242: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   245: ldc 121
    //   247: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public static boolean Op(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 193
    //   4: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 122
    //   10: invokestatic 125	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: getstatic 89	com/tencent/mm/plugin/forcenotify/d/a:mHv	Ljava/util/concurrent/ConcurrentHashMap;
    //   16: invokevirtual 129	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   19: ifne +30 -> 49
    //   22: getstatic 89	com/tencent/mm/plugin/forcenotify/d/a:mHv	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_0
    //   26: invokevirtual 133	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 97	com/tencent/mm/plugin/forcenotify/c/d
    //   32: ifnonnull +10 -> 42
    //   35: ldc 193
    //   37: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: iconst_0
    //   41: ireturn
    //   42: ldc 193
    //   44: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: iconst_1
    //   48: ireturn
    //   49: getstatic 84	com/tencent/mm/plugin/forcenotify/d/a:fnw	Lcom/tencent/mm/cg/h;
    //   52: ldc 102
    //   54: iconst_1
    //   55: anewarray 104	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc 143
    //   62: aastore
    //   63: ldc 145
    //   65: iconst_1
    //   66: anewarray 104	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: aload_0
    //   72: aastore
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: iconst_2
    //   77: invokevirtual 151	com/tencent/mm/cg/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   80: astore_3
    //   81: aload_3
    //   82: checkcast 153	java/io/Closeable
    //   85: astore_2
    //   86: aload_3
    //   87: ifnonnull +6 -> 93
    //   90: invokestatic 82	a/f/b/j:ebi	()V
    //   93: aload_3
    //   94: invokeinterface 158 1 0
    //   99: ifeq +50 -> 149
    //   102: new 97	com/tencent/mm/plugin/forcenotify/c/d
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
    //   134: invokestatic 180	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload_2
    //   138: aconst_null
    //   139: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   142: ldc 193
    //   144: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: iconst_1
    //   148: ireturn
    //   149: getstatic 191	a/y:BMg	La/y;
    //   152: astore_0
    //   153: aload_2
    //   154: aconst_null
    //   155: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   158: ldc 193
    //   160: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: iconst_0
    //   164: ireturn
    //   165: astore_1
    //   166: ldc 193
    //   168: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload_1
    //   172: athrow
    //   173: astore_0
    //   174: aload_2
    //   175: aload_1
    //   176: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   179: ldc 193
    //   181: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public static java.util.ArrayList<d> bzL()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 198
    //   4: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 200	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 201	java/util/ArrayList:<init>	()V
    //   14: astore_2
    //   15: ldc 203
    //   17: invokestatic 207	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   20: astore 4
    //   22: aload 4
    //   24: ldc 209
    //   26: invokestatic 73	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   29: aload 4
    //   31: checkcast 203	com/tencent/mm/plugin/messenger/foundation/a/j
    //   34: invokeinterface 213 1 0
    //   39: astore 5
    //   41: getstatic 84	com/tencent/mm/plugin/forcenotify/d/a:fnw	Lcom/tencent/mm/cg/h;
    //   44: astore 4
    //   46: invokestatic 219	com/tencent/mm/model/cb:abq	()J
    //   49: lstore_0
    //   50: aload 4
    //   52: ldc 102
    //   54: iconst_1
    //   55: anewarray 104	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc 143
    //   62: aastore
    //   63: ldc 221
    //   65: iconst_1
    //   66: anewarray 104	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: lload_0
    //   72: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   75: aastore
    //   76: aconst_null
    //   77: aconst_null
    //   78: ldc 227
    //   80: iconst_2
    //   81: invokevirtual 151	com/tencent/mm/cg/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   84: astore 6
    //   86: aload 6
    //   88: checkcast 153	java/io/Closeable
    //   91: astore 4
    //   93: aload 6
    //   95: invokeinterface 158 1 0
    //   100: pop
    //   101: aload 6
    //   103: ifnonnull +6 -> 109
    //   106: invokestatic 82	a/f/b/j:ebi	()V
    //   109: aload 6
    //   111: invokeinterface 230 1 0
    //   116: ifne +134 -> 250
    //   119: new 97	com/tencent/mm/plugin/forcenotify/c/d
    //   122: dup
    //   123: invokespecial 159	com/tencent/mm/plugin/forcenotify/c/d:<init>	()V
    //   126: astore 7
    //   128: aload 7
    //   130: aload 6
    //   132: invokevirtual 163	com/tencent/mm/plugin/forcenotify/c/d:convertFrom	(Landroid/database/Cursor;)V
    //   135: aload 7
    //   137: getfield 234	com/tencent/mm/plugin/forcenotify/c/d:field_ForcePushId	Ljava/lang/String;
    //   140: ifnull +77 -> 217
    //   143: aload 7
    //   145: aload 5
    //   147: aload 7
    //   149: getfield 237	com/tencent/mm/plugin/forcenotify/c/d:field_UserName	Ljava/lang/String;
    //   152: invokeinterface 243 2 0
    //   157: putfield 247	com/tencent/mm/plugin/forcenotify/c/d:contact	Lcom/tencent/mm/storage/ad;
    //   160: aload_2
    //   161: aload 7
    //   163: invokevirtual 251	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   166: pop
    //   167: ldc 171
    //   169: ldc 253
    //   171: iconst_1
    //   172: anewarray 175	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: aload 7
    //   179: aastore
    //   180: invokestatic 180	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: getstatic 89	com/tencent/mm/plugin/forcenotify/d/a:mHv	Ljava/util/concurrent/ConcurrentHashMap;
    //   186: checkcast 165	java/util/Map
    //   189: astore 8
    //   191: aload 7
    //   193: getfield 234	com/tencent/mm/plugin/forcenotify/c/d:field_ForcePushId	Ljava/lang/String;
    //   196: astore 9
    //   198: aload 9
    //   200: ldc 255
    //   202: invokestatic 73	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   205: aload 8
    //   207: aload 9
    //   209: aload 7
    //   211: invokeinterface 169 3 0
    //   216: pop
    //   217: aload 6
    //   219: invokeinterface 258 1 0
    //   224: pop
    //   225: goto -124 -> 101
    //   228: astore_3
    //   229: ldc 198
    //   231: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_3
    //   235: athrow
    //   236: astore_2
    //   237: aload 4
    //   239: aload_3
    //   240: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   243: ldc 198
    //   245: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: aload_2
    //   249: athrow
    //   250: getstatic 191	a/y:BMg	La/y;
    //   253: astore 5
    //   255: aload 4
    //   257: aconst_null
    //   258: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   261: ldc 198
    //   263: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: aload_2
    //   267: areturn
    //   268: astore_2
    //   269: goto -32 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   49	23	0	l	long
    //   14	147	2	localArrayList	java.util.ArrayList
    //   236	31	2	localArrayList1	java.util.ArrayList<d>
    //   268	1	2	localObject1	Object
    //   1	1	3	localObject2	Object
    //   228	12	3	localThrowable	java.lang.Throwable
    //   20	236	4	localObject3	Object
    //   39	215	5	localObject4	Object
    //   84	134	6	localCursor	android.database.Cursor
    //   126	84	7	locald	d
    //   189	17	8	localMap	Map
    //   196	12	9	str	String
    // Exception table:
    //   from	to	target	type
    //   93	101	228	java/lang/Throwable
    //   106	109	228	java/lang/Throwable
    //   109	217	228	java/lang/Throwable
    //   217	225	228	java/lang/Throwable
    //   250	255	228	java/lang/Throwable
    //   229	236	236	finally
    //   93	101	268	finally
    //   106	109	268	finally
    //   109	217	268	finally
    //   217	225	268	finally
    //   250	255	268	finally
  }
  
  /* Error */
  public static int bzN()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 263
    //   5: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 84	com/tencent/mm/plugin/forcenotify/d/a:fnw	Lcom/tencent/mm/cg/h;
    //   11: ldc_w 265
    //   14: iconst_1
    //   15: anewarray 104	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: invokestatic 219	com/tencent/mm/model/cb:abq	()J
    //   23: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   26: aastore
    //   27: invokevirtual 269	com/tencent/mm/cg/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   30: astore_1
    //   31: aload_1
    //   32: checkcast 153	java/io/Closeable
    //   35: astore_3
    //   36: aload_1
    //   37: ifnonnull +6 -> 43
    //   40: invokestatic 82	a/f/b/j:ebi	()V
    //   43: aload_1
    //   44: invokeinterface 158 1 0
    //   49: ifeq +24 -> 73
    //   52: aload_1
    //   53: iconst_0
    //   54: invokeinterface 273 2 0
    //   59: istore_0
    //   60: aload_3
    //   61: aconst_null
    //   62: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   65: ldc_w 263
    //   68: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: iload_0
    //   72: ireturn
    //   73: getstatic 191	a/y:BMg	La/y;
    //   76: astore_1
    //   77: aload_3
    //   78: aconst_null
    //   79: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   82: ldc_w 263
    //   85: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: iconst_0
    //   89: ireturn
    //   90: astore_2
    //   91: ldc_w 263
    //   94: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_2
    //   98: athrow
    //   99: astore_1
    //   100: aload_3
    //   101: aload_2
    //   102: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   105: ldc_w 263
    //   108: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public static void bzO()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 275
    //   5: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 278	com/tencent/mm/kernel/g:RG	()Z
    //   11: ifeq +12 -> 23
    //   14: ldc_w 280
    //   17: invokestatic 207	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   20: ifnonnull +10 -> 30
    //   23: ldc_w 275
    //   26: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: return
    //   30: getstatic 84	com/tencent/mm/plugin/forcenotify/d/a:fnw	Lcom/tencent/mm/cg/h;
    //   33: astore_2
    //   34: invokestatic 219	com/tencent/mm/model/cb:abq	()J
    //   37: lstore_0
    //   38: aload_2
    //   39: ldc 102
    //   41: iconst_1
    //   42: anewarray 104	java/lang/String
    //   45: dup
    //   46: iconst_0
    //   47: ldc 143
    //   49: aastore
    //   50: ldc_w 282
    //   53: iconst_1
    //   54: anewarray 104	java/lang/String
    //   57: dup
    //   58: iconst_0
    //   59: lload_0
    //   60: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   63: aastore
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: iconst_2
    //   68: invokevirtual 151	com/tencent/mm/cg/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   71: astore_2
    //   72: aload_2
    //   73: checkcast 153	java/io/Closeable
    //   76: astore 4
    //   78: aload_2
    //   79: invokeinterface 158 1 0
    //   84: pop
    //   85: aload_2
    //   86: ifnonnull +6 -> 92
    //   89: invokestatic 82	a/f/b/j:ebi	()V
    //   92: aload_2
    //   93: invokeinterface 230 1 0
    //   98: ifne +79 -> 177
    //   101: new 97	com/tencent/mm/plugin/forcenotify/c/d
    //   104: dup
    //   105: invokespecial 159	com/tencent/mm/plugin/forcenotify/c/d:<init>	()V
    //   108: astore 5
    //   110: aload 5
    //   112: aload_2
    //   113: invokevirtual 163	com/tencent/mm/plugin/forcenotify/c/d:convertFrom	(Landroid/database/Cursor;)V
    //   116: ldc_w 280
    //   119: invokestatic 207	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   122: checkcast 280	com/tencent/mm/plugin/forcenotify/a/a
    //   125: aload 5
    //   127: getfield 234	com/tencent/mm/plugin/forcenotify/c/d:field_ForcePushId	Ljava/lang/String;
    //   130: iconst_5
    //   131: invokestatic 219	com/tencent/mm/model/cb:abq	()J
    //   134: ldc2_w 283
    //   137: ldiv
    //   138: invokeinterface 288 5 0
    //   143: aload_2
    //   144: invokeinterface 258 1 0
    //   149: pop
    //   150: goto -65 -> 85
    //   153: astore_3
    //   154: ldc_w 275
    //   157: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_3
    //   161: athrow
    //   162: astore_2
    //   163: aload 4
    //   165: aload_3
    //   166: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   169: ldc_w 275
    //   172: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_2
    //   176: athrow
    //   177: getstatic 191	a/y:BMg	La/y;
    //   180: astore_2
    //   181: aload 4
    //   183: aconst_null
    //   184: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   187: ldc 171
    //   189: ldc_w 290
    //   192: iconst_1
    //   193: anewarray 175	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: getstatic 84	com/tencent/mm/plugin/forcenotify/d/a:fnw	Lcom/tencent/mm/cg/h;
    //   201: ldc 102
    //   203: ldc_w 282
    //   206: iconst_1
    //   207: anewarray 104	java/lang/String
    //   210: dup
    //   211: iconst_0
    //   212: invokestatic 219	com/tencent/mm/model/cb:abq	()J
    //   215: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   218: aastore
    //   219: invokevirtual 293	com/tencent/mm/cg/h:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   222: invokestatic 298	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: aastore
    //   226: invokestatic 180	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: ldc_w 275
    //   232: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: return
    //   236: astore_2
    //   237: goto -74 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   37	23	0	l	long
    //   33	111	2	localObject1	Object
    //   162	14	2	localObject2	Object
    //   180	1	2	localy	a.y
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
  public static int bzP()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 300
    //   5: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 84	com/tencent/mm/plugin/forcenotify/d/a:fnw	Lcom/tencent/mm/cg/h;
    //   11: ldc_w 302
    //   14: iconst_1
    //   15: anewarray 104	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc_w 304
    //   23: aastore
    //   24: invokevirtual 269	com/tencent/mm/cg/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore_1
    //   28: aload_1
    //   29: checkcast 153	java/io/Closeable
    //   32: astore_3
    //   33: aload_1
    //   34: ifnonnull +6 -> 40
    //   37: invokestatic 82	a/f/b/j:ebi	()V
    //   40: aload_1
    //   41: invokeinterface 158 1 0
    //   46: ifeq +24 -> 70
    //   49: aload_1
    //   50: iconst_0
    //   51: invokeinterface 273 2 0
    //   56: istore_0
    //   57: aload_3
    //   58: aconst_null
    //   59: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   62: ldc_w 300
    //   65: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: iload_0
    //   69: ireturn
    //   70: getstatic 191	a/y:BMg	La/y;
    //   73: astore_1
    //   74: aload_3
    //   75: aconst_null
    //   76: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   79: ldc_w 300
    //   82: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: iconst_0
    //   86: ireturn
    //   87: astore_2
    //   88: ldc_w 300
    //   91: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_2
    //   95: athrow
    //   96: astore_1
    //   97: aload_3
    //   98: aload_2
    //   99: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   102: ldc_w 300
    //   105: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void bX(String paramString, int paramInt)
  {
    AppMethodBeat.i(51055);
    a.f.b.j.q(paramString, "forcePushId");
    d locald = new d();
    locald.field_ForcePushId = paramString;
    if (get((c)locald, new String[0]))
    {
      locald.field_Status = paramInt;
      ab.i("MicroMsg.ForceNotifyStorage", "[updateStatus] ret:%s %s", new Object[] { Long.valueOf(fnw.replace("ForceNotifyData", "ForcePushId", locald.convertTo())), locald });
      ((Map)mHv).put(paramString, locald);
      doNotify();
    }
    AppMethodBeat.o(51055);
  }
  
  /* Error */
  public final int bzM()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 338
    //   6: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 340	java/util/LinkedList
    //   12: dup
    //   13: invokespecial 341	java/util/LinkedList:<init>	()V
    //   16: astore 4
    //   18: getstatic 84	com/tencent/mm/plugin/forcenotify/d/a:fnw	Lcom/tencent/mm/cg/h;
    //   21: astore 6
    //   23: invokestatic 219	com/tencent/mm/model/cb:abq	()J
    //   26: lstore_2
    //   27: aload 6
    //   29: ldc_w 343
    //   32: iconst_1
    //   33: anewarray 104	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc 143
    //   40: aastore
    //   41: ldc_w 345
    //   44: iconst_1
    //   45: anewarray 104	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: lload_2
    //   51: invokestatic 225	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   54: aastore
    //   55: aconst_null
    //   56: aconst_null
    //   57: ldc 227
    //   59: iconst_2
    //   60: invokevirtual 151	com/tencent/mm/cg/h:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/database/Cursor;
    //   63: astore 7
    //   65: aload 7
    //   67: checkcast 153	java/io/Closeable
    //   70: astore 6
    //   72: aload 7
    //   74: invokeinterface 158 1 0
    //   79: pop
    //   80: aload 7
    //   82: ifnonnull +6 -> 88
    //   85: invokestatic 82	a/f/b/j:ebi	()V
    //   88: aload 7
    //   90: invokeinterface 230 1 0
    //   95: ifne +67 -> 162
    //   98: new 97	com/tencent/mm/plugin/forcenotify/c/d
    //   101: dup
    //   102: invokespecial 159	com/tencent/mm/plugin/forcenotify/c/d:<init>	()V
    //   105: astore 8
    //   107: aload 8
    //   109: aload 7
    //   111: invokevirtual 163	com/tencent/mm/plugin/forcenotify/c/d:convertFrom	(Landroid/database/Cursor;)V
    //   114: aload 4
    //   116: aload 8
    //   118: invokevirtual 346	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload 7
    //   124: invokeinterface 258 1 0
    //   129: pop
    //   130: goto -50 -> 80
    //   133: astore 5
    //   135: ldc_w 338
    //   138: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload 5
    //   143: athrow
    //   144: astore 4
    //   146: aload 6
    //   148: aload 5
    //   150: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   153: ldc_w 338
    //   156: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload 4
    //   161: athrow
    //   162: getstatic 191	a/y:BMg	La/y;
    //   165: astore 7
    //   167: aload 6
    //   169: aconst_null
    //   170: invokestatic 185	a/e/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   173: aload 4
    //   175: invokevirtual 350	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   178: astore 4
    //   180: iconst_0
    //   181: istore_1
    //   182: aload 4
    //   184: invokeinterface 355 1 0
    //   189: ifeq +52 -> 241
    //   192: aload 4
    //   194: invokeinterface 359 1 0
    //   199: checkcast 97	com/tencent/mm/plugin/forcenotify/c/d
    //   202: astore 5
    //   204: aload_0
    //   205: aload 5
    //   207: checkcast 309	com/tencent/mm/sdk/e/c
    //   210: iconst_0
    //   211: invokevirtual 363	com/tencent/mm/plugin/forcenotify/d/a:insertNotify	(Lcom/tencent/mm/sdk/e/c;Z)Z
    //   214: ifne +20 -> 234
    //   217: ldc 171
    //   219: ldc_w 365
    //   222: iconst_1
    //   223: anewarray 175	java/lang/Object
    //   226: dup
    //   227: iconst_0
    //   228: aload 5
    //   230: aastore
    //   231: invokestatic 180	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: iload_1
    //   235: iconst_1
    //   236: iadd
    //   237: istore_1
    //   238: goto -56 -> 182
    //   241: getstatic 84	com/tencent/mm/plugin/forcenotify/d/a:fnw	Lcom/tencent/mm/cg/h;
    //   244: ldc_w 343
    //   247: invokevirtual 368	com/tencent/mm/cg/h:ate	(Ljava/lang/String;)Z
    //   250: pop
    //   251: ldc_w 338
    //   254: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final boolean qD(String paramString)
  {
    AppMethodBeat.i(51056);
    a.f.b.j.q(paramString, "forcePushId");
    if (fnw.delete("ForceNotifyData", "ForcePushId=?", new String[] { paramString }) >= 0)
    {
      mHv.remove(paramString);
      doNotify();
      AppMethodBeat.o(51056);
      return true;
    }
    AppMethodBeat.o(51056);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.d.a
 * JD-Core Version:    0.7.0.1
 */