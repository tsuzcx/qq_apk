package com.tencent.mm.plugin.finder.storage;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.c.a;
import com.tencent.mm.plugin.finder.conv.c.b;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.plugin.finder.conv.l.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.as;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.a.a;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/conv/FinderSessionInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "sessionIdToSessionInfoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "talkerToSessionInfoCache", "checkOldSessionInfo", "", "deleteSession", "sessionId", "isNotify", "getSessionId", "talker", "roleType", "", "getSessionInfoBySelfUserName", "Ljava/util/LinkedList;", "selfUserName", "getSessionInfoBySenderUserName", "senderUserName", "getSessionInfoBySessionId", "getSessionInfoByTalker", "getSessionSender", "getTalker", "isSessionInfoExistByTalker", "isSessionRejectMsg", "replaceSessionInfo", "", "type", "enable_action", "source", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$ReplaceSource;", "rejectMsg", "canSendMsg", "reportSize", "updateOpType", "updateOpTypeAndAction", "actionPermission", "Companion", "ReplaceSource", "plugin-finder_release"})
public final class af
  extends MAutoStorage<com.tencent.mm.plugin.finder.conv.l>
{
  public static final a Amt;
  private static final String[] SQL_CREATE;
  public final ConcurrentHashMap<String, com.tencent.mm.plugin.finder.conv.l> Amr;
  public final ConcurrentHashMap<String, com.tencent.mm.plugin.finder.conv.l> Ams;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(286460);
    Amt = new a((byte)0);
    l.a locala = com.tencent.mm.plugin.finder.conv.l.xgH;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.finder.conv.l.access$getInfo$cp(), "FinderSessionInfo") };
    AppMethodBeat.o(286460);
  }
  
  public af(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, com.tencent.mm.plugin.finder.conv.l.access$getInfo$cp(), "FinderSessionInfo", cv.INDEX_CREATE);
    AppMethodBeat.i(286459);
    this.db = paramISQLiteDatabase;
    this.Amr = new ConcurrentHashMap();
    this.Ams = new ConcurrentHashMap();
    AppMethodBeat.o(286459);
  }
  
  /* Error */
  private final com.tencent.mm.plugin.finder.conv.l dY(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc 143
    //   5: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: checkcast 145	java/lang/CharSequence
    //   12: astore 6
    //   14: aload 6
    //   16: ifnull +13 -> 29
    //   19: aload 6
    //   21: invokeinterface 149 1 0
    //   26: ifne +24 -> 50
    //   29: iconst_1
    //   30: istore_3
    //   31: iload_3
    //   32: ifeq +23 -> 55
    //   35: new 90	com/tencent/mm/plugin/finder/conv/l
    //   38: dup
    //   39: invokespecial 150	com/tencent/mm/plugin/finder/conv/l:<init>	()V
    //   42: astore_1
    //   43: ldc 143
    //   45: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_1
    //   49: areturn
    //   50: iconst_0
    //   51: istore_3
    //   52: goto -21 -> 31
    //   55: iload_2
    //   56: tableswitch	default:+28 -> 84, 1:+331->387, 2:+339->395, 3:+347->403
    //   85: dcmpl
    //   86: astore 6
    //   88: aload_0
    //   89: getfield 136	com/tencent/mm/plugin/finder/storage/af:Amr	Ljava/util/concurrent/ConcurrentHashMap;
    //   92: new 153	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   99: aload_1
    //   100: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: bipush 95
    //   105: invokevirtual 161	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   108: aload 6
    //   110: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: invokevirtual 169	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   119: checkcast 90	com/tencent/mm/plugin/finder/conv/l
    //   122: astore 8
    //   124: aload 8
    //   126: ifnonnull +327 -> 453
    //   129: aload_0
    //   130: checkcast 2	com/tencent/mm/plugin/finder/storage/af
    //   133: astore 9
    //   135: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   138: lstore 4
    //   140: new 153	java/lang/StringBuilder
    //   143: dup
    //   144: ldc 177
    //   146: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: aload_1
    //   150: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 182
    //   155: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 6
    //   160: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: bipush 39
    //   165: invokevirtual 161	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   168: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore 11
    //   173: aload 9
    //   175: getfield 130	com/tencent/mm/plugin/finder/storage/af:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   178: aload 11
    //   180: aconst_null
    //   181: invokeinterface 188 3 0
    //   186: checkcast 190	java/io/Closeable
    //   189: astore 8
    //   191: aload 8
    //   193: checkcast 192	android/database/Cursor
    //   196: astore 10
    //   198: new 194	com/tencent/mm/plugin/finder/conv/c$a
    //   201: dup
    //   202: invokespecial 195	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   205: astore 12
    //   207: invokestatic 201	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   210: astore 13
    //   212: aload 13
    //   214: ldc 203
    //   216: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   219: aload 13
    //   221: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   224: astore 13
    //   226: aload 13
    //   228: ldc 211
    //   230: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   233: aload 12
    //   235: aload 13
    //   237: invokevirtual 215	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   240: aload 11
    //   242: invokevirtual 218	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   245: astore 11
    //   247: aload 11
    //   249: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   252: lload 4
    //   254: lsub
    //   255: putfield 222	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   258: aload 11
    //   260: ldc 224
    //   262: invokevirtual 227	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   265: invokevirtual 231	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   268: invokevirtual 236	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   271: aload 10
    //   273: invokeinterface 240 1 0
    //   278: ifeq +133 -> 411
    //   281: new 90	com/tencent/mm/plugin/finder/conv/l
    //   284: dup
    //   285: invokespecial 150	com/tencent/mm/plugin/finder/conv/l:<init>	()V
    //   288: astore 11
    //   290: aload 11
    //   292: aload 10
    //   294: invokevirtual 244	com/tencent/mm/plugin/finder/conv/l:convertFrom	(Landroid/database/Cursor;)V
    //   297: aload 9
    //   299: getfield 138	com/tencent/mm/plugin/finder/storage/af:Ams	Ljava/util/concurrent/ConcurrentHashMap;
    //   302: checkcast 246	java/util/Map
    //   305: astore 10
    //   307: aload 11
    //   309: getfield 250	com/tencent/mm/plugin/finder/conv/l:field_sessionId	Ljava/lang/String;
    //   312: astore 12
    //   314: aload 12
    //   316: ldc 252
    //   318: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   321: aload 10
    //   323: aload 12
    //   325: aload 11
    //   327: invokeinterface 256 3 0
    //   332: pop
    //   333: aload 9
    //   335: getfield 136	com/tencent/mm/plugin/finder/storage/af:Amr	Ljava/util/concurrent/ConcurrentHashMap;
    //   338: checkcast 246	java/util/Map
    //   341: new 153	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   348: aload_1
    //   349: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: bipush 95
    //   354: invokevirtual 161	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   357: aload 6
    //   359: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: aload 11
    //   367: invokeinterface 256 3 0
    //   372: pop
    //   373: aload 8
    //   375: aconst_null
    //   376: invokestatic 261	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   379: ldc 143
    //   381: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   384: aload 11
    //   386: areturn
    //   387: invokestatic 266	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
    //   390: astore 6
    //   392: goto -304 -> 88
    //   395: invokestatic 269	com/tencent/mm/model/z:bdi	()Ljava/lang/String;
    //   398: astore 6
    //   400: goto -312 -> 88
    //   403: invokestatic 272	com/tencent/mm/model/z:bdh	()Ljava/lang/String;
    //   406: astore 6
    //   408: goto -320 -> 88
    //   411: getstatic 278	kotlin/x:aazN	Lkotlin/x;
    //   414: astore_1
    //   415: aload 8
    //   417: aconst_null
    //   418: invokestatic 261	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   421: ldc 143
    //   423: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   426: aconst_null
    //   427: areturn
    //   428: astore 6
    //   430: ldc 143
    //   432: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   435: aload 6
    //   437: athrow
    //   438: astore_1
    //   439: aload 8
    //   441: aload 6
    //   443: invokestatic 261	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   446: ldc 143
    //   448: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   451: aload_1
    //   452: athrow
    //   453: ldc 143
    //   455: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   458: aload 8
    //   460: areturn
    //   461: astore_1
    //   462: aload 7
    //   464: astore 6
    //   466: goto -27 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	this	af
    //   0	469	1	paramString	String
    //   0	469	2	paramInt	int
    //   30	22	3	i	int
    //   138	115	4	l	long
    //   12	395	6	localObject1	Object
    //   428	14	6	localThrowable	Throwable
    //   464	1	6	localObject2	Object
    //   1	462	7	localObject3	Object
    //   122	337	8	localObject4	Object
    //   133	201	9	localaf	af
    //   196	126	10	localObject5	Object
    //   171	214	11	localObject6	Object
    //   205	119	12	localObject7	Object
    //   210	26	13	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   191	373	428	java/lang/Throwable
    //   411	415	428	java/lang/Throwable
    //   430	438	438	finally
    //   191	373	461	finally
    //   411	415	461	finally
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, b paramb, int paramInt3, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(286455);
    p.k(paramString1, "sessionId");
    p.k(paramString2, "talker");
    p.k(paramb, "source");
    p.k(paramString3, "senderUserName");
    Object localObject1 = new com.tencent.mm.plugin.finder.conv.l();
    ((com.tencent.mm.plugin.finder.conv.l)localObject1).field_sessionId = paramString1;
    ((com.tencent.mm.plugin.finder.conv.l)localObject1).field_talker = paramString2;
    ((com.tencent.mm.plugin.finder.conv.l)localObject1).field_type = paramInt1;
    ((com.tencent.mm.plugin.finder.conv.l)localObject1).field_updateTime = cm.bfE();
    ((com.tencent.mm.plugin.finder.conv.l)localObject1).field_selfUsername = z.bdh();
    ((com.tencent.mm.plugin.finder.conv.l)localObject1).field_actionPermission = paramInt2;
    ((com.tencent.mm.plugin.finder.conv.l)localObject1).field_rejectMsg = paramInt3;
    ((com.tencent.mm.plugin.finder.conv.l)localObject1).field_disableSendMsg = paramInt4;
    ((com.tencent.mm.plugin.finder.conv.l)localObject1).field_senderUserName = paramString3;
    if (as.bvP(paramString3)) {
      paramInt3 = 3;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.finder.conv.l)localObject1).field_senderRoleType = paramInt3;
      if (!as.aEF(paramString2)) {
        break;
      }
      paramString1 = (Throwable)new RuntimeException(paramString2 + " is invalid");
      AppMethodBeat.o(286455);
      throw paramString1;
      if (as.bvO(paramString3)) {
        paramInt3 = 2;
      } else {
        paramInt3 = 1;
      }
    }
    long l = SystemClock.uptimeMillis();
    boolean bool = replace((IAutoDBItem)localObject1, false);
    paramString3 = new c.a();
    Object localObject2 = Thread.currentThread();
    p.j(localObject2, "Thread.currentThread()");
    localObject2 = ((Thread)localObject2).getName();
    p.j(localObject2, "Thread.currentThread().name");
    paramString3 = paramString3.aAY((String)localObject2).aAX("replace");
    paramString3.duration = (SystemClock.uptimeMillis() - l);
    paramString3.aAW("FinderSessionInfoStorage.replaceSessionInfo").dpk().report();
    if (bool)
    {
      this.Amr.remove(((com.tencent.mm.plugin.finder.conv.l)localObject1).field_talker + '_' + ((com.tencent.mm.plugin.finder.conv.l)localObject1).field_senderUserName);
      this.Ams.remove(paramString1);
      doNotify(((com.tencent.mm.plugin.finder.conv.l)localObject1).field_sessionId);
    }
    if (paramb == b.Amx)
    {
      paramString3 = ((PluginFinder)h.ag(PluginFinder.class)).getConversationStorage();
      localObject1 = paramString3.aEG(paramString1);
      ((d)localObject1).field_talker = paramString2;
      ((d)localObject1).field_actionPermission = paramInt2;
      ((d)localObject1).field_type = paramInt1;
      if (!paramString3.a((d)localObject1, false)) {
        Log.e("Finder.SessionStorage", "[replaceSessionInfo] fail! sessionId=".concat(String.valueOf(paramString1)));
      }
    }
    Log.i("Finder.SessionStorage", "[replaceSessionInfo] source=" + paramb + ", ret=" + bool + ", sessionId=" + paramString1 + ", talker=" + paramString2 + ", actionPermission=" + paramInt2 + ", type=" + paramInt1);
    AppMethodBeat.o(286455);
  }
  
  /* Error */
  public final boolean aEM(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 424
    //   6: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 153	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 426
    //   16: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_1
    //   20: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 428
    //   26: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore 7
    //   34: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   37: lstore_2
    //   38: aload_0
    //   39: getfield 130	com/tencent/mm/plugin/finder/storage/af:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   42: aload 7
    //   44: aconst_null
    //   45: invokeinterface 188 3 0
    //   50: checkcast 190	java/io/Closeable
    //   53: astore 6
    //   55: aload 6
    //   57: checkcast 192	android/database/Cursor
    //   60: astore_1
    //   61: new 194	com/tencent/mm/plugin/finder/conv/c$a
    //   64: dup
    //   65: invokespecial 195	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   68: astore 8
    //   70: invokestatic 201	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   73: astore 9
    //   75: aload 9
    //   77: ldc 203
    //   79: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   82: aload 9
    //   84: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   87: astore 9
    //   89: aload 9
    //   91: ldc 211
    //   93: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   96: aload 8
    //   98: aload 9
    //   100: invokevirtual 215	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   103: aload 7
    //   105: invokevirtual 218	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   108: astore 7
    //   110: aload 7
    //   112: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   115: lload_2
    //   116: lsub
    //   117: putfield 222	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   120: aload 7
    //   122: ldc 224
    //   124: invokevirtual 227	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   127: invokevirtual 231	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   130: invokevirtual 236	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   133: aload_1
    //   134: invokeinterface 431 1 0
    //   139: ifle +25 -> 164
    //   142: iconst_1
    //   143: istore 4
    //   145: getstatic 278	kotlin/x:aazN	Lkotlin/x;
    //   148: astore_1
    //   149: aload 6
    //   151: aconst_null
    //   152: invokestatic 261	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   155: ldc_w 424
    //   158: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: iload 4
    //   163: ireturn
    //   164: iconst_0
    //   165: istore 4
    //   167: goto -22 -> 145
    //   170: astore 5
    //   172: ldc_w 424
    //   175: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: aload 5
    //   180: athrow
    //   181: astore_1
    //   182: aload 6
    //   184: aload 5
    //   186: invokestatic 261	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   189: ldc_w 424
    //   192: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: aload_1
    //   196: athrow
    //   197: astore_1
    //   198: goto -16 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	af
    //   0	201	1	paramString	String
    //   37	79	2	l	long
    //   143	23	4	bool	boolean
    //   1	1	5	localObject1	Object
    //   170	15	5	localThrowable	Throwable
    //   53	130	6	localCloseable	java.io.Closeable
    //   32	89	7	localObject2	Object
    //   68	29	8	locala	c.a
    //   73	26	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   55	142	170	java/lang/Throwable
    //   145	149	170	java/lang/Throwable
    //   172	181	181	finally
    //   55	142	197	finally
    //   145	149	197	finally
  }
  
  /* Error */
  public final com.tencent.mm.plugin.finder.conv.l aEN(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc_w 434
    //   6: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: checkcast 145	java/lang/CharSequence
    //   13: astore 5
    //   15: aload 5
    //   17: ifnull +13 -> 30
    //   20: aload 5
    //   22: invokeinterface 149 1 0
    //   27: ifne +25 -> 52
    //   30: iconst_1
    //   31: istore_2
    //   32: iload_2
    //   33: ifeq +24 -> 57
    //   36: new 90	com/tencent/mm/plugin/finder/conv/l
    //   39: dup
    //   40: invokespecial 150	com/tencent/mm/plugin/finder/conv/l:<init>	()V
    //   43: astore_1
    //   44: ldc_w 434
    //   47: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_1
    //   51: areturn
    //   52: iconst_0
    //   53: istore_2
    //   54: goto -22 -> 32
    //   57: aload_0
    //   58: getfield 138	com/tencent/mm/plugin/finder/storage/af:Ams	Ljava/util/concurrent/ConcurrentHashMap;
    //   61: aload_1
    //   62: invokevirtual 169	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 90	com/tencent/mm/plugin/finder/conv/l
    //   68: astore 7
    //   70: aload 7
    //   72: astore 5
    //   74: aload 7
    //   76: ifnonnull +247 -> 323
    //   79: aload_0
    //   80: checkcast 2	com/tencent/mm/plugin/finder/storage/af
    //   83: astore 8
    //   85: new 153	java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 436
    //   92: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_1
    //   96: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc_w 438
    //   102: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: astore 10
    //   110: new 90	com/tencent/mm/plugin/finder/conv/l
    //   113: dup
    //   114: invokespecial 150	com/tencent/mm/plugin/finder/conv/l:<init>	()V
    //   117: astore 5
    //   119: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   122: lstore_3
    //   123: aload 8
    //   125: getfield 130	com/tencent/mm/plugin/finder/storage/af:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   128: aload 10
    //   130: aconst_null
    //   131: invokeinterface 188 3 0
    //   136: checkcast 190	java/io/Closeable
    //   139: astore 7
    //   141: aload 7
    //   143: checkcast 192	android/database/Cursor
    //   146: astore 9
    //   148: new 194	com/tencent/mm/plugin/finder/conv/c$a
    //   151: dup
    //   152: invokespecial 195	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   155: astore 11
    //   157: invokestatic 201	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   160: astore 12
    //   162: aload 12
    //   164: ldc 203
    //   166: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   169: aload 12
    //   171: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   174: astore 12
    //   176: aload 12
    //   178: ldc 211
    //   180: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   183: aload 11
    //   185: aload 12
    //   187: invokevirtual 215	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   190: aload 10
    //   192: invokevirtual 218	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   195: astore 10
    //   197: aload 10
    //   199: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   202: lload_3
    //   203: lsub
    //   204: putfield 222	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   207: aload 10
    //   209: ldc_w 440
    //   212: invokevirtual 227	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   215: invokevirtual 231	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   218: invokevirtual 236	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   221: aload 9
    //   223: invokeinterface 240 1 0
    //   228: ifeq +10 -> 238
    //   231: aload 5
    //   233: aload 9
    //   235: invokevirtual 244	com/tencent/mm/plugin/finder/conv/l:convertFrom	(Landroid/database/Cursor;)V
    //   238: getstatic 278	kotlin/x:aazN	Lkotlin/x;
    //   241: astore 9
    //   243: aload 7
    //   245: aconst_null
    //   246: invokestatic 261	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   249: aload 5
    //   251: getfield 443	com/tencent/mm/plugin/finder/conv/l:systemRowid	J
    //   254: lconst_0
    //   255: lcmp
    //   256: ifle +67 -> 323
    //   259: aload 8
    //   261: getfield 138	com/tencent/mm/plugin/finder/storage/af:Ams	Ljava/util/concurrent/ConcurrentHashMap;
    //   264: checkcast 246	java/util/Map
    //   267: aload_1
    //   268: aload 5
    //   270: invokeinterface 256 3 0
    //   275: pop
    //   276: aload 8
    //   278: getfield 136	com/tencent/mm/plugin/finder/storage/af:Amr	Ljava/util/concurrent/ConcurrentHashMap;
    //   281: checkcast 246	java/util/Map
    //   284: new 153	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   291: aload 5
    //   293: getfield 289	com/tencent/mm/plugin/finder/conv/l:field_talker	Ljava/lang/String;
    //   296: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: bipush 95
    //   301: invokevirtual 161	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   304: aload 5
    //   306: getfield 316	com/tencent/mm/plugin/finder/conv/l:field_senderUserName	Ljava/lang/String;
    //   309: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: aload 5
    //   317: invokeinterface 256 3 0
    //   322: pop
    //   323: ldc_w 434
    //   326: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: aload 5
    //   331: areturn
    //   332: astore 5
    //   334: ldc_w 434
    //   337: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   340: aload 5
    //   342: athrow
    //   343: astore_1
    //   344: aload 7
    //   346: aload 5
    //   348: invokestatic 261	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   351: ldc_w 434
    //   354: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   357: aload_1
    //   358: athrow
    //   359: astore_1
    //   360: aload 6
    //   362: astore 5
    //   364: goto -20 -> 344
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	af
    //   0	367	1	paramString	String
    //   31	23	2	i	int
    //   122	81	3	l	long
    //   13	317	5	localObject1	Object
    //   332	15	5	localThrowable	Throwable
    //   362	1	5	localObject2	Object
    //   1	360	6	localObject3	Object
    //   68	277	7	localObject4	Object
    //   83	194	8	localaf	af
    //   146	96	9	localObject5	Object
    //   108	100	10	localObject6	Object
    //   155	29	11	locala	c.a
    //   160	26	12	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   141	238	332	java/lang/Throwable
    //   238	243	332	java/lang/Throwable
    //   334	343	343	finally
    //   141	238	359	finally
    //   238	243	359	finally
  }
  
  /* Error */
  public final LinkedList<com.tencent.mm.plugin.finder.conv.l> aEO(String paramString)
  {
    // Byte code:
    //   0: ldc_w 446
    //   3: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 286
    //   10: invokestatic 119	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: checkcast 145	java/lang/CharSequence
    //   17: invokeinterface 149 1 0
    //   22: ifne +17 -> 39
    //   25: iconst_1
    //   26: istore_2
    //   27: iload_2
    //   28: ifeq +16 -> 44
    //   31: ldc_w 446
    //   34: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: iconst_0
    //   40: istore_2
    //   41: goto -14 -> 27
    //   44: new 153	java/lang/StringBuilder
    //   47: dup
    //   48: ldc_w 448
    //   51: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: aload_1
    //   55: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 438
    //   61: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 7
    //   69: new 450	java/util/LinkedList
    //   72: dup
    //   73: invokespecial 451	java/util/LinkedList:<init>	()V
    //   76: astore_1
    //   77: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   80: lstore_3
    //   81: aload_0
    //   82: getfield 130	com/tencent/mm/plugin/finder/storage/af:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   85: aload 7
    //   87: aconst_null
    //   88: invokeinterface 188 3 0
    //   93: checkcast 190	java/io/Closeable
    //   96: astore 6
    //   98: aload 6
    //   100: checkcast 192	android/database/Cursor
    //   103: astore 5
    //   105: new 194	com/tencent/mm/plugin/finder/conv/c$a
    //   108: dup
    //   109: invokespecial 195	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   112: astore 8
    //   114: invokestatic 201	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   117: astore 9
    //   119: aload 9
    //   121: ldc 203
    //   123: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   126: aload 9
    //   128: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   131: astore 9
    //   133: aload 9
    //   135: ldc 211
    //   137: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   140: aload 8
    //   142: aload 9
    //   144: invokevirtual 215	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   147: aload 7
    //   149: invokevirtual 218	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   152: astore 7
    //   154: aload 7
    //   156: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   159: lload_3
    //   160: lsub
    //   161: putfield 222	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   164: aload 7
    //   166: ldc_w 453
    //   169: invokevirtual 227	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   172: invokevirtual 231	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   175: invokevirtual 236	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   178: aload 5
    //   180: invokeinterface 456 1 0
    //   185: ifeq +56 -> 241
    //   188: new 90	com/tencent/mm/plugin/finder/conv/l
    //   191: dup
    //   192: invokespecial 150	com/tencent/mm/plugin/finder/conv/l:<init>	()V
    //   195: astore 7
    //   197: aload 7
    //   199: aload 5
    //   201: invokevirtual 244	com/tencent/mm/plugin/finder/conv/l:convertFrom	(Landroid/database/Cursor;)V
    //   204: aload_1
    //   205: aload 7
    //   207: invokevirtual 460	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   210: pop
    //   211: goto -33 -> 178
    //   214: astore 5
    //   216: ldc_w 446
    //   219: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload 5
    //   224: athrow
    //   225: astore_1
    //   226: aload 6
    //   228: aload 5
    //   230: invokestatic 261	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   233: ldc_w 446
    //   236: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload_1
    //   240: athrow
    //   241: getstatic 278	kotlin/x:aazN	Lkotlin/x;
    //   244: astore 5
    //   246: aload 6
    //   248: aconst_null
    //   249: invokestatic 261	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   252: ldc_w 446
    //   255: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload_1
    //   259: areturn
    //   260: astore_1
    //   261: aconst_null
    //   262: astore 5
    //   264: goto -38 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	af
    //   0	267	1	paramString	String
    //   26	15	2	i	int
    //   80	80	3	l	long
    //   103	97	5	localCursor	android.database.Cursor
    //   214	15	5	localThrowable	Throwable
    //   244	19	5	localx	kotlin.x
    //   96	151	6	localCloseable	java.io.Closeable
    //   67	139	7	localObject1	Object
    //   112	29	8	locala	c.a
    //   117	26	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   98	178	214	java/lang/Throwable
    //   178	211	214	java/lang/Throwable
    //   241	246	214	java/lang/Throwable
    //   216	225	225	finally
    //   98	178	260	finally
    //   178	211	260	finally
    //   241	246	260	finally
  }
  
  /* Error */
  public final LinkedList<com.tencent.mm.plugin.finder.conv.l> aEP(String paramString)
  {
    // Byte code:
    //   0: ldc_w 464
    //   3: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 465
    //   10: invokestatic 119	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: checkcast 145	java/lang/CharSequence
    //   17: invokeinterface 149 1 0
    //   22: ifne +17 -> 39
    //   25: iconst_1
    //   26: istore_2
    //   27: iload_2
    //   28: ifeq +16 -> 44
    //   31: ldc_w 464
    //   34: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: iconst_0
    //   40: istore_2
    //   41: goto -14 -> 27
    //   44: new 153	java/lang/StringBuilder
    //   47: dup
    //   48: ldc_w 467
    //   51: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: aload_1
    //   55: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 438
    //   61: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 7
    //   69: new 450	java/util/LinkedList
    //   72: dup
    //   73: invokespecial 451	java/util/LinkedList:<init>	()V
    //   76: astore_1
    //   77: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   80: lstore_3
    //   81: aload_0
    //   82: getfield 130	com/tencent/mm/plugin/finder/storage/af:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   85: aload 7
    //   87: aconst_null
    //   88: invokeinterface 188 3 0
    //   93: checkcast 190	java/io/Closeable
    //   96: astore 6
    //   98: aload 6
    //   100: checkcast 192	android/database/Cursor
    //   103: astore 5
    //   105: new 194	com/tencent/mm/plugin/finder/conv/c$a
    //   108: dup
    //   109: invokespecial 195	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   112: astore 8
    //   114: invokestatic 201	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   117: astore 9
    //   119: aload 9
    //   121: ldc 203
    //   123: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   126: aload 9
    //   128: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   131: astore 9
    //   133: aload 9
    //   135: ldc 211
    //   137: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   140: aload 8
    //   142: aload 9
    //   144: invokevirtual 215	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   147: aload 7
    //   149: invokevirtual 218	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   152: astore 7
    //   154: aload 7
    //   156: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   159: lload_3
    //   160: lsub
    //   161: putfield 222	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   164: aload 7
    //   166: ldc_w 453
    //   169: invokevirtual 227	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   172: invokevirtual 231	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   175: invokevirtual 236	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   178: aload 5
    //   180: invokeinterface 456 1 0
    //   185: ifeq +56 -> 241
    //   188: new 90	com/tencent/mm/plugin/finder/conv/l
    //   191: dup
    //   192: invokespecial 150	com/tencent/mm/plugin/finder/conv/l:<init>	()V
    //   195: astore 7
    //   197: aload 7
    //   199: aload 5
    //   201: invokevirtual 244	com/tencent/mm/plugin/finder/conv/l:convertFrom	(Landroid/database/Cursor;)V
    //   204: aload_1
    //   205: aload 7
    //   207: invokevirtual 460	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   210: pop
    //   211: goto -33 -> 178
    //   214: astore 5
    //   216: ldc_w 464
    //   219: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload 5
    //   224: athrow
    //   225: astore_1
    //   226: aload 6
    //   228: aload 5
    //   230: invokestatic 261	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   233: ldc_w 464
    //   236: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aload_1
    //   240: athrow
    //   241: getstatic 278	kotlin/x:aazN	Lkotlin/x;
    //   244: astore 5
    //   246: aload 6
    //   248: aconst_null
    //   249: invokestatic 261	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   252: ldc_w 464
    //   255: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aload_1
    //   259: areturn
    //   260: astore_1
    //   261: aconst_null
    //   262: astore 5
    //   264: goto -38 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	af
    //   0	267	1	paramString	String
    //   26	15	2	i	int
    //   80	80	3	l	long
    //   103	97	5	localCursor	android.database.Cursor
    //   214	15	5	localThrowable	Throwable
    //   244	19	5	localx	kotlin.x
    //   96	151	6	localCloseable	java.io.Closeable
    //   67	139	7	localObject1	Object
    //   112	29	8	locala	c.a
    //   117	26	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   98	178	214	java/lang/Throwable
    //   178	211	214	java/lang/Throwable
    //   241	246	214	java/lang/Throwable
    //   216	225	225	finally
    //   98	178	260	finally
    //   178	211	260	finally
    //   241	246	260	finally
  }
  
  public final boolean aEQ(String paramString)
  {
    AppMethodBeat.i(286457);
    p.k(paramString, "sessionId");
    Object localObject = aEN(paramString);
    this.Ams.remove(paramString);
    this.Amr.remove(((com.tencent.mm.plugin.finder.conv.l)localObject).field_talker + '_' + ((com.tencent.mm.plugin.finder.conv.l)localObject).field_senderUserName);
    long l = SystemClock.uptimeMillis();
    boolean bool = delete((IAutoDBItem)localObject, false, new String[] { "sessionId" });
    paramString = new c.a();
    localObject = Thread.currentThread();
    p.j(localObject, "Thread.currentThread()");
    localObject = ((Thread)localObject).getName();
    p.j(localObject, "Thread.currentThread().name");
    paramString = paramString.aAY((String)localObject).aAX("updateNotify");
    paramString.duration = (SystemClock.uptimeMillis() - l);
    paramString.aAW("FinderSessionInfoStorage.deleteSession").dpk().report();
    AppMethodBeat.o(286457);
    return bool;
  }
  
  /* Error */
  public final boolean bvP()
  {
    // Byte code:
    //   0: ldc_w 482
    //   3: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 383
    //   9: ldc_w 484
    //   12: invokestatic 422	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: new 450	java/util/LinkedList
    //   18: dup
    //   19: invokespecial 451	java/util/LinkedList:<init>	()V
    //   22: astore 9
    //   24: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   27: lstore_2
    //   28: aload_0
    //   29: getfield 130	com/tencent/mm/plugin/finder/storage/af:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   32: ldc_w 486
    //   35: aconst_null
    //   36: invokeinterface 188 3 0
    //   41: checkcast 190	java/io/Closeable
    //   44: astore 11
    //   46: aconst_null
    //   47: astore 10
    //   49: aload 11
    //   51: checkcast 192	android/database/Cursor
    //   54: astore 12
    //   56: new 194	com/tencent/mm/plugin/finder/conv/c$a
    //   59: dup
    //   60: invokespecial 195	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   63: astore 13
    //   65: invokestatic 201	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   68: astore 14
    //   70: aload 14
    //   72: ldc 203
    //   74: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   77: aload 14
    //   79: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   82: astore 14
    //   84: aload 14
    //   86: ldc 211
    //   88: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   91: aload 13
    //   93: aload 14
    //   95: invokevirtual 215	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   98: ldc_w 486
    //   101: invokevirtual 218	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   104: astore 13
    //   106: aload 13
    //   108: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   111: lload_2
    //   112: lsub
    //   113: putfield 222	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   116: aload 13
    //   118: ldc_w 488
    //   121: invokevirtual 227	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   124: invokevirtual 231	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   127: invokevirtual 236	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   130: aload 12
    //   132: invokeinterface 456 1 0
    //   137: ifeq +59 -> 196
    //   140: new 90	com/tencent/mm/plugin/finder/conv/l
    //   143: dup
    //   144: invokespecial 150	com/tencent/mm/plugin/finder/conv/l:<init>	()V
    //   147: astore 13
    //   149: aload 13
    //   151: aload 12
    //   153: invokevirtual 244	com/tencent/mm/plugin/finder/conv/l:convertFrom	(Landroid/database/Cursor;)V
    //   156: aload 9
    //   158: aload 13
    //   160: invokevirtual 460	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   163: pop
    //   164: goto -34 -> 130
    //   167: astore 10
    //   169: ldc_w 482
    //   172: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload 10
    //   177: athrow
    //   178: astore 9
    //   180: aload 11
    //   182: aload 10
    //   184: invokestatic 261	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   187: ldc_w 482
    //   190: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload 9
    //   195: athrow
    //   196: getstatic 278	kotlin/x:aazN	Lkotlin/x;
    //   199: astore 12
    //   201: aload 11
    //   203: aconst_null
    //   204: invokestatic 261	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   207: ldc_w 383
    //   210: new 153	java/lang/StringBuilder
    //   213: dup
    //   214: ldc_w 490
    //   217: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   220: aload 9
    //   222: invokevirtual 493	java/util/LinkedList:size	()I
    //   225: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 422	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: invokestatic 266	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
    //   237: astore 11
    //   239: invokestatic 272	com/tencent/mm/model/z:bdh	()Ljava/lang/String;
    //   242: astore 12
    //   244: iconst_0
    //   245: istore 7
    //   247: aload_0
    //   248: getfield 130	com/tencent/mm/plugin/finder/storage/af:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   251: astore 10
    //   253: aload 10
    //   255: ifnonnull +24 -> 279
    //   258: new 495	kotlin/t
    //   261: dup
    //   262: ldc_w 497
    //   265: invokespecial 498	kotlin/t:<init>	(Ljava/lang/String;)V
    //   268: astore 9
    //   270: ldc_w 482
    //   273: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload 9
    //   278: athrow
    //   279: aload 10
    //   281: checkcast 500	com/tencent/mm/storagebase/h
    //   284: invokevirtual 503	com/tencent/mm/storagebase/h:bLA	()J
    //   287: lstore 4
    //   289: iconst_1
    //   290: istore 6
    //   292: new 505	kotlin/g/b/aa$d
    //   295: dup
    //   296: invokespecial 506	kotlin/g/b/aa$d:<init>	()V
    //   299: astore 10
    //   301: aload 10
    //   303: iconst_0
    //   304: putfield 509	kotlin/g/b/aa$d:aaBA	I
    //   307: aload 9
    //   309: checkcast 511	java/lang/Iterable
    //   312: invokeinterface 515 1 0
    //   317: astore 13
    //   319: aload 13
    //   321: invokeinterface 520 1 0
    //   326: ifeq +270 -> 596
    //   329: aload 13
    //   331: invokeinterface 524 1 0
    //   336: checkcast 90	com/tencent/mm/plugin/finder/conv/l
    //   339: astore 14
    //   341: aload 14
    //   343: getfield 316	com/tencent/mm/plugin/finder/conv/l:field_senderUserName	Ljava/lang/String;
    //   346: checkcast 145	java/lang/CharSequence
    //   349: astore 15
    //   351: aload 15
    //   353: ifnull +696 -> 1049
    //   356: aload 15
    //   358: invokeinterface 149 1 0
    //   363: ifne +707 -> 1070
    //   366: goto +683 -> 1049
    //   369: iload_1
    //   370: ifeq +676 -> 1046
    //   373: aload 14
    //   375: getfield 289	com/tencent/mm/plugin/finder/conv/l:field_talker	Ljava/lang/String;
    //   378: invokestatic 322	com/tencent/mm/storage/as:bvP	(Ljava/lang/String;)Z
    //   381: ifeq +107 -> 488
    //   384: aload 14
    //   386: aload 11
    //   388: putfield 316	com/tencent/mm/plugin/finder/conv/l:field_senderUserName	Ljava/lang/String;
    //   391: aload 14
    //   393: iconst_1
    //   394: putfield 325	com/tencent/mm/plugin/finder/conv/l:field_senderRoleType	I
    //   397: new 153	java/lang/StringBuilder
    //   400: dup
    //   401: ldc_w 526
    //   404: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   407: aload 14
    //   409: getfield 316	com/tencent/mm/plugin/finder/conv/l:field_senderUserName	Ljava/lang/String;
    //   412: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc_w 528
    //   418: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload 14
    //   423: getfield 325	com/tencent/mm/plugin/finder/conv/l:field_senderRoleType	I
    //   426: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   429: ldc_w 530
    //   432: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload 14
    //   437: getfield 289	com/tencent/mm/plugin/finder/conv/l:field_talker	Ljava/lang/String;
    //   440: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: bipush 39
    //   445: invokevirtual 161	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   448: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: astore 14
    //   453: aload_0
    //   454: getfield 130	com/tencent/mm/plugin/finder/storage/af:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   457: ldc 102
    //   459: aload 14
    //   461: invokeinterface 534 3 0
    //   466: istore 8
    //   468: iload 8
    //   470: ifne +584 -> 1054
    //   473: aload 10
    //   475: aload 10
    //   477: getfield 509	kotlin/g/b/aa$d:aaBA	I
    //   480: iconst_1
    //   481: iadd
    //   482: putfield 509	kotlin/g/b/aa$d:aaBA	I
    //   485: goto +569 -> 1054
    //   488: aload 14
    //   490: aload 12
    //   492: putfield 316	com/tencent/mm/plugin/finder/conv/l:field_senderUserName	Ljava/lang/String;
    //   495: aload 14
    //   497: iconst_3
    //   498: putfield 325	com/tencent/mm/plugin/finder/conv/l:field_senderRoleType	I
    //   501: goto -104 -> 397
    //   504: astore 11
    //   506: ldc_w 383
    //   509: new 153	java/lang/StringBuilder
    //   512: dup
    //   513: ldc_w 536
    //   516: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   519: aload 11
    //   521: invokevirtual 539	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   524: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   530: invokestatic 422	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   533: getstatic 545	com/tencent/mm/plugin/findersdk/b:BuZ	Lcom/tencent/mm/plugin/findersdk/b;
    //   536: ldc_w 546
    //   539: iconst_0
    //   540: iconst_0
    //   541: new 13	com/tencent/mm/plugin/finder/storage/af$c
    //   544: dup
    //   545: aload 11
    //   547: invokespecial 549	com/tencent/mm/plugin/finder/storage/af$c:<init>	(Ljava/lang/Exception;)V
    //   550: checkcast 551	kotlin/g/a/a
    //   553: bipush 12
    //   555: invokestatic 556	com/tencent/mm/ae/f$a:a	(Lcom/tencent/mm/ae/f;Ljava/lang/String;ZZLkotlin/g/a/a;I)V
    //   558: aload_0
    //   559: getfield 130	com/tencent/mm/plugin/finder/storage/af:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   562: astore 11
    //   564: aload 11
    //   566: ifnonnull +249 -> 815
    //   569: new 495	kotlin/t
    //   572: dup
    //   573: ldc_w 497
    //   576: invokespecial 498	kotlin/t:<init>	(Ljava/lang/String;)V
    //   579: astore 9
    //   581: ldc_w 482
    //   584: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   587: aload 9
    //   589: athrow
    //   590: iconst_0
    //   591: istore 6
    //   593: goto +474 -> 1067
    //   596: aload_0
    //   597: getfield 130	com/tencent/mm/plugin/finder/storage/af:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   600: astore 11
    //   602: aload 11
    //   604: ifnonnull +24 -> 628
    //   607: new 495	kotlin/t
    //   610: dup
    //   611: ldc_w 497
    //   614: invokespecial 498	kotlin/t:<init>	(Ljava/lang/String;)V
    //   617: astore 9
    //   619: ldc_w 482
    //   622: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   625: aload 9
    //   627: athrow
    //   628: aload 11
    //   630: checkcast 500	com/tencent/mm/storagebase/h
    //   633: lload 4
    //   635: invokevirtual 560	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   638: pop
    //   639: new 194	com/tencent/mm/plugin/finder/conv/c$a
    //   642: dup
    //   643: invokespecial 195	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   646: astore 11
    //   648: invokestatic 201	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   651: astore 12
    //   653: aload 12
    //   655: ldc 203
    //   657: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   660: aload 12
    //   662: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   665: astore 12
    //   667: aload 12
    //   669: ldc 211
    //   671: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   674: aload 11
    //   676: aload 12
    //   678: invokevirtual 215	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   681: ldc_w 562
    //   684: invokevirtual 218	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   687: astore 11
    //   689: aload 11
    //   691: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   694: lload_2
    //   695: lsub
    //   696: putfield 222	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   699: aload 11
    //   701: ldc_w 564
    //   704: invokevirtual 227	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   707: invokevirtual 231	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   710: invokevirtual 236	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   713: ldc_w 383
    //   716: new 153	java/lang/StringBuilder
    //   719: dup
    //   720: ldc_w 566
    //   723: invokespecial 180	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   726: aload 9
    //   728: invokevirtual 493	java/util/LinkedList:size	()I
    //   731: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   734: ldc_w 568
    //   737: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: aload 10
    //   742: getfield 509	kotlin/g/b/aa$d:aaBA	I
    //   745: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   748: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 422	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   754: getstatic 545	com/tencent/mm/plugin/findersdk/b:BuZ	Lcom/tencent/mm/plugin/findersdk/b;
    //   757: astore 11
    //   759: aload 10
    //   761: getfield 509	kotlin/g/b/aa$d:aaBA	I
    //   764: ifne +271 -> 1035
    //   767: iconst_1
    //   768: istore 7
    //   770: aload 11
    //   772: ldc_w 570
    //   775: iload 7
    //   777: iconst_0
    //   778: new 15	com/tencent/mm/plugin/finder/storage/af$d
    //   781: dup
    //   782: aload 9
    //   784: aload 10
    //   786: invokespecial 573	com/tencent/mm/plugin/finder/storage/af$d:<init>	(Ljava/util/LinkedList;Lkotlin/g/b/aa$d;)V
    //   789: checkcast 551	kotlin/g/a/a
    //   792: bipush 12
    //   794: invokestatic 556	com/tencent/mm/ae/f$a:a	(Lcom/tencent/mm/ae/f;Ljava/lang/String;ZZLkotlin/g/a/a;I)V
    //   797: ldc_w 383
    //   800: ldc_w 575
    //   803: invokestatic 422	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   806: ldc_w 482
    //   809: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   812: iload 6
    //   814: ireturn
    //   815: aload 11
    //   817: checkcast 500	com/tencent/mm/storagebase/h
    //   820: lload 4
    //   822: invokevirtual 560	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   825: pop
    //   826: new 194	com/tencent/mm/plugin/finder/conv/c$a
    //   829: dup
    //   830: invokespecial 195	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   833: astore 11
    //   835: invokestatic 201	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   838: astore 12
    //   840: aload 12
    //   842: ldc 203
    //   844: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   847: aload 12
    //   849: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   852: astore 12
    //   854: aload 12
    //   856: ldc 211
    //   858: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   861: aload 11
    //   863: aload 12
    //   865: invokevirtual 215	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   868: ldc_w 562
    //   871: invokevirtual 218	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   874: astore 11
    //   876: aload 11
    //   878: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   881: lload_2
    //   882: lsub
    //   883: putfield 222	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   886: aload 11
    //   888: ldc_w 564
    //   891: invokevirtual 227	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   894: invokevirtual 231	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   897: invokevirtual 236	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   900: iload 7
    //   902: istore 6
    //   904: goto -191 -> 713
    //   907: astore 9
    //   909: aload_0
    //   910: getfield 130	com/tencent/mm/plugin/finder/storage/af:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   913: astore 10
    //   915: aload 10
    //   917: ifnonnull +24 -> 941
    //   920: new 495	kotlin/t
    //   923: dup
    //   924: ldc_w 497
    //   927: invokespecial 498	kotlin/t:<init>	(Ljava/lang/String;)V
    //   930: astore 9
    //   932: ldc_w 482
    //   935: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   938: aload 9
    //   940: athrow
    //   941: aload 10
    //   943: checkcast 500	com/tencent/mm/storagebase/h
    //   946: lload 4
    //   948: invokevirtual 560	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   951: pop
    //   952: new 194	com/tencent/mm/plugin/finder/conv/c$a
    //   955: dup
    //   956: invokespecial 195	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   959: astore 10
    //   961: invokestatic 201	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   964: astore 11
    //   966: aload 11
    //   968: ldc 203
    //   970: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   973: aload 11
    //   975: invokevirtual 209	java/lang/Thread:getName	()Ljava/lang/String;
    //   978: astore 11
    //   980: aload 11
    //   982: ldc 211
    //   984: invokestatic 206	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   987: aload 10
    //   989: aload 11
    //   991: invokevirtual 215	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   994: ldc_w 562
    //   997: invokevirtual 218	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   1000: astore 10
    //   1002: aload 10
    //   1004: invokestatic 175	android/os/SystemClock:uptimeMillis	()J
    //   1007: lload_2
    //   1008: lsub
    //   1009: putfield 222	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   1012: aload 10
    //   1014: ldc_w 564
    //   1017: invokevirtual 227	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   1020: invokevirtual 231	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   1023: invokevirtual 236	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   1026: ldc_w 482
    //   1029: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1032: aload 9
    //   1034: athrow
    //   1035: iconst_0
    //   1036: istore 7
    //   1038: goto -268 -> 770
    //   1041: astore 9
    //   1043: goto -863 -> 180
    //   1046: goto +21 -> 1067
    //   1049: iconst_1
    //   1050: istore_1
    //   1051: goto -682 -> 369
    //   1054: iload 6
    //   1056: ifeq -466 -> 590
    //   1059: iload 8
    //   1061: ifeq -471 -> 590
    //   1064: iconst_1
    //   1065: istore 6
    //   1067: goto -748 -> 319
    //   1070: iconst_0
    //   1071: istore_1
    //   1072: goto -703 -> 369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1075	0	this	af
    //   369	703	1	i	int
    //   27	981	2	l1	long
    //   287	660	4	l2	long
    //   290	776	6	bool1	boolean
    //   245	792	7	bool2	boolean
    //   466	594	8	bool3	boolean
    //   22	135	9	localLinkedList	LinkedList
    //   178	43	9	localObject1	Object
    //   268	515	9	localt1	kotlin.t
    //   907	1	9	localObject2	Object
    //   930	103	9	localt2	kotlin.t
    //   1041	1	9	localObject3	Object
    //   47	1	10	localObject4	Object
    //   167	16	10	localThrowable	Throwable
    //   251	762	10	localObject5	Object
    //   44	343	11	localObject6	Object
    //   504	42	11	localException	Exception
    //   562	428	11	localObject7	Object
    //   54	810	12	localObject8	Object
    //   63	267	13	localObject9	Object
    //   68	428	14	localObject10	Object
    //   349	8	15	localCharSequence	java.lang.CharSequence
    // Exception table:
    //   from	to	target	type
    //   49	130	167	java/lang/Throwable
    //   130	164	167	java/lang/Throwable
    //   196	201	167	java/lang/Throwable
    //   169	178	178	finally
    //   307	319	504	java/lang/Exception
    //   319	351	504	java/lang/Exception
    //   356	366	504	java/lang/Exception
    //   373	397	504	java/lang/Exception
    //   397	468	504	java/lang/Exception
    //   473	485	504	java/lang/Exception
    //   488	501	504	java/lang/Exception
    //   307	319	907	finally
    //   319	351	907	finally
    //   356	366	907	finally
    //   373	397	907	finally
    //   397	468	907	finally
    //   473	485	907	finally
    //   488	501	907	finally
    //   506	558	907	finally
    //   49	130	1041	finally
    //   130	164	1041	finally
    //   196	201	1041	finally
  }
  
  public final String dZ(String paramString, int paramInt)
  {
    AppMethodBeat.i(286454);
    paramString = dY(paramString, paramInt);
    if (paramString != null)
    {
      String str = paramString.field_sessionId;
      paramString = str;
      if (str != null) {}
    }
    else
    {
      paramString = "";
    }
    AppMethodBeat.o(286454);
    return paramString;
  }
  
  public final void ea(String paramString, int paramInt)
  {
    AppMethodBeat.i(286456);
    p.k(paramString, "sessionId");
    paramString = aEN(paramString);
    paramString.field_rejectMsg = paramInt;
    long l = SystemClock.uptimeMillis();
    boolean bool = updateNotify((IAutoDBItem)paramString, false, new String[] { null });
    c.a locala = new c.a();
    Object localObject = Thread.currentThread();
    p.j(localObject, "Thread.currentThread()");
    localObject = ((Thread)localObject).getName();
    p.j(localObject, "Thread.currentThread().name");
    locala = locala.aAY((String)localObject).aAX("updateNotify");
    locala.duration = (SystemClock.uptimeMillis() - l);
    locala.aAW("FinderSessionInfoStorage.updateOpType").dpk().report();
    if (bool)
    {
      this.Amr.remove(paramString.field_talker + '_' + paramString.field_senderUserName);
      this.Ams.remove(paramString.field_sessionId);
      doNotify(paramString.field_sessionId);
    }
    AppMethodBeat.o(286456);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$ReplaceSource;", "", "(Ljava/lang/String;I)V", "RECEIVE", "GET_SESSION_ID", "SELF_REPLY", "FOR_TEST", "plugin-finder_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(271748);
      b localb1 = new b("RECEIVE", 0);
      Amu = localb1;
      b localb2 = new b("GET_SESSION_ID", 1);
      Amv = localb2;
      b localb3 = new b("SELF_REPLY", 2);
      Amw = localb3;
      b localb4 = new b("FOR_TEST", 3);
      Amx = localb4;
      Amy = new b[] { localb1, localb2, localb3, localb4 };
      AppMethodBeat.o(271748);
    }
    
    private b() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<String>
  {
    c(Exception paramException)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<String>
  {
    d(LinkedList paramLinkedList, aa.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.af
 * JD-Core Version:    0.7.0.1
 */