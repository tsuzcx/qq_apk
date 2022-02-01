package com.tencent.mm.plugin.finder.storage;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.autogen.b.dd;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.a.a;
import com.tencent.mm.plugin.finder.conv.a.b;
import com.tencent.mm.plugin.finder.conv.o;
import com.tencent.mm.plugin.finder.conv.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.au;
import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/conv/FinderSessionInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "sessionIdToSessionInfoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "talkerToSessionInfoCache", "checkOldSessionInfo", "", "deleteSession", "sessionId", "isNotify", "getSessionId", "talker", "roleType", "", "getSessionInfoBySelfUserName", "Ljava/util/LinkedList;", "selfUserName", "getSessionInfoBySenderUserName", "senderUserName", "getSessionInfoBySessionId", "getSessionInfoByTalker", "getSessionSender", "getTalker", "isSessionInfoExistByTalker", "isSessionRejectMsg", "replaceSessionInfo", "", "type", "enable_action", "source", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$ReplaceSource;", "rejectMsg", "canSendMsg", "reportSize", "updateOpType", "updateOpTypeAndAction", "actionPermission", "Companion", "ReplaceSource", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
  extends MAutoStorage<o>
{
  public static final a FMl;
  private static final String[] SQL_CREATE;
  public final ConcurrentHashMap<String, o> FMm;
  public final ConcurrentHashMap<String, o> FMn;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(339454);
    FMl = new a((byte)0);
    o.a locala = o.AHd;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(o.access$getInfo$cp(), "FinderSessionInfo") };
    AppMethodBeat.o(339454);
  }
  
  public ak(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, o.access$getInfo$cp(), "FinderSessionInfo", dd.INDEX_CREATE);
    AppMethodBeat.i(339426);
    this.db = paramISQLiteDatabase;
    this.FMm = new ConcurrentHashMap();
    this.FMn = new ConcurrentHashMap();
    AppMethodBeat.o(339426);
  }
  
  private final o eJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(339438);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = new o();
      AppMethodBeat.o(339438);
      return paramString;
    }
    switch (paramInt)
    {
    default: 
      localObject1 = "";
    }
    Object localObject3;
    for (;;)
    {
      localObject3 = (o)this.FMm.get(paramString + '_' + localObject1);
      if (localObject3 == null)
      {
        ak localak = (ak)this;
        long l = SystemClock.uptimeMillis();
        Object localObject5 = "select * , rowid from FinderSessionInfo  where talker = '" + paramString + "' and senderUserName = '" + localObject1 + '\'';
        localObject3 = (Closeable)localak.db.rawQuery((String)localObject5, null);
        try
        {
          Object localObject4 = (Cursor)localObject3;
          Object localObject6 = new a.a();
          String str = Thread.currentThread().getName();
          s.s(str, "currentThread().name");
          localObject5 = ((a.a)localObject6).avh(str).avg((String)localObject5);
          ((a.a)localObject5).duration = (SystemClock.uptimeMillis() - l);
          ((a.a)localObject5).avf("FinderSessionInfoStorage.getSessionInfoByTalker").dWL().report();
          if (((Cursor)localObject4).moveToFirst())
          {
            localObject5 = new o();
            ((o)localObject5).convertFrom((Cursor)localObject4);
            localObject4 = (Map)localak.FMn;
            localObject6 = ((o)localObject5).field_sessionId;
            s.s(localObject6, "cache.field_sessionId");
            ((Map)localObject4).put(localObject6, localObject5);
            ((Map)localak.FMm).put(paramString + '_' + localObject1, localObject5);
            kotlin.f.b.a((Closeable)localObject3, null);
            AppMethodBeat.o(339438);
            return localObject5;
            localObject1 = z.bAM();
            continue;
            localObject1 = z.bAX();
            continue;
            localObject1 = z.bAW();
          }
          else
          {
            paramString = ah.aiuX;
            kotlin.f.b.a((Closeable)localObject3, null);
            AppMethodBeat.o(339438);
            return null;
          }
        }
        finally
        {
          try
          {
            AppMethodBeat.o(339438);
            throw paramString;
          }
          finally
          {
            kotlin.f.b.a((Closeable)localObject3, paramString);
            AppMethodBeat.o(339438);
          }
        }
      }
    }
    AppMethodBeat.o(339438);
    return localObject3;
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, b paramb, int paramInt3, int paramInt4, String paramString3)
  {
    AppMethodBeat.i(339505);
    s.u(paramString1, "sessionId");
    s.u(paramString2, "talker");
    s.u(paramb, "source");
    s.u(paramString3, "senderUserName");
    Object localObject = new o();
    ((o)localObject).field_sessionId = paramString1;
    ((o)localObject).field_talker = paramString2;
    ((o)localObject).field_type = paramInt1;
    ((o)localObject).field_updateTime = cn.bDw();
    ((o)localObject).field_selfUsername = z.bAW();
    ((o)localObject).field_actionPermission = paramInt2;
    ((o)localObject).field_rejectMsg = paramInt3;
    ((o)localObject).field_disableSendMsg = paramInt4;
    ((o)localObject).field_senderUserName = paramString3;
    if (au.bwV(paramString3)) {
      paramInt3 = 3;
    }
    for (;;)
    {
      ((o)localObject).field_senderRoleType = paramInt3;
      if (!au.aAy(paramString2)) {
        break;
      }
      paramString1 = new RuntimeException(s.X(paramString2, " is invalid"));
      AppMethodBeat.o(339505);
      throw paramString1;
      if (au.bwU(paramString3)) {
        paramInt3 = 2;
      } else {
        paramInt3 = 1;
      }
    }
    long l = SystemClock.uptimeMillis();
    boolean bool = replace((IAutoDBItem)localObject, false);
    paramString3 = new a.a();
    String str = Thread.currentThread().getName();
    s.s(str, "currentThread().name");
    paramString3 = paramString3.avh(str).avg("replace");
    paramString3.duration = (SystemClock.uptimeMillis() - l);
    paramString3.avf("FinderSessionInfoStorage.replaceSessionInfo").dWL().report();
    if (bool)
    {
      this.FMm.remove(((o)localObject).field_talker + '_' + ((o)localObject).field_senderUserName);
      this.FMn.remove(paramString1);
      doNotify(((o)localObject).field_sessionId);
    }
    if (paramb == b.FMr)
    {
      paramString3 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getConversationStorage();
      localObject = paramString3.aAz(paramString1);
      ((com.tencent.mm.plugin.finder.conv.b)localObject).field_talker = paramString2;
      ((com.tencent.mm.plugin.finder.conv.b)localObject).field_actionPermission = paramInt2;
      ((com.tencent.mm.plugin.finder.conv.b)localObject).field_type = paramInt1;
      if (!paramString3.a((com.tencent.mm.plugin.finder.conv.b)localObject, false)) {
        Log.e("Finder.SessionStorage", s.X("[replaceSessionInfo] fail! sessionId=", paramString1));
      }
    }
    Log.i("Finder.SessionStorage", "[replaceSessionInfo] source=" + paramb + ", ret=" + bool + ", sessionId=" + paramString1 + ", talker=" + paramString2 + ", actionPermission=" + paramInt2 + ", type=" + paramInt1);
    AppMethodBeat.o(339505);
  }
  
  /* Error */
  public final boolean aAF(String paramString)
  {
    // Byte code:
    //   0: ldc_w 419
    //   3: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 156	java/lang/StringBuilder
    //   9: dup
    //   10: ldc_w 421
    //   13: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: aload_1
    //   17: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   20: ldc_w 423
    //   23: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore 6
    //   31: invokestatic 178	android/os/SystemClock:uptimeMillis	()J
    //   34: lstore_2
    //   35: aload_0
    //   36: getfield 133	com/tencent/mm/plugin/finder/storage/ak:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   39: aload 6
    //   41: aconst_null
    //   42: invokeinterface 194 3 0
    //   47: checkcast 196	java/io/Closeable
    //   50: astore_1
    //   51: aload_1
    //   52: checkcast 198	android/database/Cursor
    //   55: astore 5
    //   57: new 200	com/tencent/mm/plugin/finder/conv/a$a
    //   60: dup
    //   61: invokespecial 201	com/tencent/mm/plugin/finder/conv/a$a:<init>	()V
    //   64: astore 7
    //   66: invokestatic 207	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   69: invokevirtual 210	java/lang/Thread:getName	()Ljava/lang/String;
    //   72: astore 8
    //   74: aload 8
    //   76: ldc 212
    //   78: invokestatic 215	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   81: aload 7
    //   83: aload 8
    //   85: invokevirtual 219	com/tencent/mm/plugin/finder/conv/a$a:avh	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/a$a;
    //   88: aload 6
    //   90: invokevirtual 222	com/tencent/mm/plugin/finder/conv/a$a:avg	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/a$a;
    //   93: astore 6
    //   95: aload 6
    //   97: invokestatic 178	android/os/SystemClock:uptimeMillis	()J
    //   100: lload_2
    //   101: lsub
    //   102: putfield 226	com/tencent/mm/plugin/finder/conv/a$a:duration	J
    //   105: aload 6
    //   107: ldc 228
    //   109: invokevirtual 231	com/tencent/mm/plugin/finder/conv/a$a:avf	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/a$a;
    //   112: invokevirtual 235	com/tencent/mm/plugin/finder/conv/a$a:dWL	()Lcom/tencent/mm/plugin/finder/conv/a$b;
    //   115: invokevirtual 240	com/tencent/mm/plugin/finder/conv/a$b:report	()V
    //   118: aload 5
    //   120: invokeinterface 426 1 0
    //   125: ifle +25 -> 150
    //   128: iconst_1
    //   129: istore 4
    //   131: getstatic 282	kotlin/ah:aiuX	Lkotlin/ah;
    //   134: astore 5
    //   136: aload_1
    //   137: aconst_null
    //   138: invokestatic 265	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   141: ldc_w 419
    //   144: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: iload 4
    //   149: ireturn
    //   150: iconst_0
    //   151: istore 4
    //   153: goto -22 -> 131
    //   156: astore 5
    //   158: ldc_w 419
    //   161: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload 5
    //   166: athrow
    //   167: astore 6
    //   169: aload_1
    //   170: aload 5
    //   172: invokestatic 265	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   175: ldc_w 419
    //   178: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload 6
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	ak
    //   0	184	1	paramString	String
    //   34	67	2	l	long
    //   129	23	4	bool	boolean
    //   55	80	5	localObject1	Object
    //   156	15	5	localThrowable	Throwable
    //   29	77	6	localObject2	Object
    //   167	15	6	localObject3	Object
    //   64	18	7	locala	a.a
    //   72	12	8	str	String
    // Exception table:
    //   from	to	target	type
    //   51	128	156	finally
    //   131	136	156	finally
    //   158	167	167	finally
  }
  
  public final o aAG(String paramString)
  {
    AppMethodBeat.i(339475);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = new o();
      AppMethodBeat.o(339475);
      return paramString;
    }
    localObject1 = (o)this.FMn.get(paramString);
    if (localObject1 == null)
    {
      ak localak = (ak)this;
      Object localObject4 = "select * , rowid from FinderSessionInfo where sessionId = '" + paramString + "' ";
      o localo = new o();
      long l = SystemClock.uptimeMillis();
      localObject1 = (Closeable)localak.db.rawQuery((String)localObject4, null);
      try
      {
        Object localObject3 = (Cursor)localObject1;
        a.a locala = new a.a();
        String str = Thread.currentThread().getName();
        s.s(str, "currentThread().name");
        localObject4 = locala.avh(str).avg((String)localObject4);
        ((a.a)localObject4).duration = (SystemClock.uptimeMillis() - l);
        ((a.a)localObject4).avf("FinderSessionInfoStorage.getSessionInfoBySessionId").dWL().report();
        if (((Cursor)localObject3).moveToFirst()) {
          localo.convertFrom((Cursor)localObject3);
        }
        localObject3 = ah.aiuX;
        kotlin.f.b.a((Closeable)localObject1, null);
        if (localo.systemRowid > 0L)
        {
          ((Map)localak.FMn).put(paramString, localo);
          ((Map)localak.FMm).put(localo.field_talker + '_' + localo.field_senderUserName, localo);
        }
        AppMethodBeat.o(339475);
        return localo;
      }
      finally
      {
        try
        {
          AppMethodBeat.o(339475);
          throw paramString;
        }
        finally
        {
          kotlin.f.b.a((Closeable)localObject1, paramString);
          AppMethodBeat.o(339475);
        }
      }
    }
    AppMethodBeat.o(339475);
    return localObject1;
  }
  
  /* Error */
  public final LinkedList<o> aAH(String paramString)
  {
    // Byte code:
    //   0: ldc_w 441
    //   3: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 288
    //   10: invokestatic 122	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: checkcast 148	java/lang/CharSequence
    //   17: invokeinterface 152 1 0
    //   22: ifne +17 -> 39
    //   25: iconst_1
    //   26: istore_2
    //   27: iload_2
    //   28: ifeq +16 -> 44
    //   31: ldc_w 441
    //   34: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: iconst_0
    //   40: istore_2
    //   41: goto -14 -> 27
    //   44: new 156	java/lang/StringBuilder
    //   47: dup
    //   48: ldc_w 443
    //   51: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: aload_1
    //   55: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 433
    //   61: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 7
    //   69: new 445	java/util/LinkedList
    //   72: dup
    //   73: invokespecial 446	java/util/LinkedList:<init>	()V
    //   76: astore 5
    //   78: invokestatic 178	android/os/SystemClock:uptimeMillis	()J
    //   81: lstore_3
    //   82: aload_0
    //   83: getfield 133	com/tencent/mm/plugin/finder/storage/ak:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   86: aload 7
    //   88: aconst_null
    //   89: invokeinterface 194 3 0
    //   94: checkcast 196	java/io/Closeable
    //   97: astore_1
    //   98: aload_1
    //   99: checkcast 198	android/database/Cursor
    //   102: astore 6
    //   104: new 200	com/tencent/mm/plugin/finder/conv/a$a
    //   107: dup
    //   108: invokespecial 201	com/tencent/mm/plugin/finder/conv/a$a:<init>	()V
    //   111: astore 8
    //   113: invokestatic 207	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   116: invokevirtual 210	java/lang/Thread:getName	()Ljava/lang/String;
    //   119: astore 9
    //   121: aload 9
    //   123: ldc 212
    //   125: invokestatic 215	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   128: aload 8
    //   130: aload 9
    //   132: invokevirtual 219	com/tencent/mm/plugin/finder/conv/a$a:avh	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/a$a;
    //   135: aload 7
    //   137: invokevirtual 222	com/tencent/mm/plugin/finder/conv/a$a:avg	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/a$a;
    //   140: astore 7
    //   142: aload 7
    //   144: invokestatic 178	android/os/SystemClock:uptimeMillis	()J
    //   147: lload_3
    //   148: lsub
    //   149: putfield 226	com/tencent/mm/plugin/finder/conv/a$a:duration	J
    //   152: aload 7
    //   154: ldc_w 448
    //   157: invokevirtual 231	com/tencent/mm/plugin/finder/conv/a$a:avf	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/a$a;
    //   160: invokevirtual 235	com/tencent/mm/plugin/finder/conv/a$a:dWL	()Lcom/tencent/mm/plugin/finder/conv/a$b;
    //   163: invokevirtual 240	com/tencent/mm/plugin/finder/conv/a$b:report	()V
    //   166: aload 6
    //   168: invokeinterface 451 1 0
    //   173: ifeq +58 -> 231
    //   176: new 93	com/tencent/mm/plugin/finder/conv/o
    //   179: dup
    //   180: invokespecial 153	com/tencent/mm/plugin/finder/conv/o:<init>	()V
    //   183: astore 7
    //   185: aload 7
    //   187: aload 6
    //   189: invokevirtual 248	com/tencent/mm/plugin/finder/conv/o:convertFrom	(Landroid/database/Cursor;)V
    //   192: aload 5
    //   194: aload 7
    //   196: invokevirtual 455	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   199: pop
    //   200: goto -34 -> 166
    //   203: astore 5
    //   205: ldc_w 441
    //   208: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload 5
    //   213: athrow
    //   214: astore 6
    //   216: aload_1
    //   217: aload 5
    //   219: invokestatic 265	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   222: ldc_w 441
    //   225: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload 6
    //   230: athrow
    //   231: getstatic 282	kotlin/ah:aiuX	Lkotlin/ah;
    //   234: astore 6
    //   236: aload_1
    //   237: aconst_null
    //   238: invokestatic 265	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   241: ldc_w 441
    //   244: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aload 5
    //   249: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	ak
    //   0	250	1	paramString	String
    //   26	15	2	i	int
    //   81	67	3	l	long
    //   76	117	5	localLinkedList	LinkedList
    //   203	45	5	localThrowable	Throwable
    //   102	86	6	localCursor	Cursor
    //   214	15	6	localObject1	Object
    //   234	1	6	localah	ah
    //   67	128	7	localObject2	Object
    //   111	18	8	locala	a.a
    //   119	12	9	str	String
    // Exception table:
    //   from	to	target	type
    //   98	166	203	finally
    //   166	200	203	finally
    //   231	236	203	finally
    //   205	214	214	finally
  }
  
  /* Error */
  public final LinkedList<o> aAI(String paramString)
  {
    // Byte code:
    //   0: ldc_w 459
    //   3: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc_w 460
    //   10: invokestatic 122	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: checkcast 148	java/lang/CharSequence
    //   17: invokeinterface 152 1 0
    //   22: ifne +17 -> 39
    //   25: iconst_1
    //   26: istore_2
    //   27: iload_2
    //   28: ifeq +16 -> 44
    //   31: ldc_w 459
    //   34: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aconst_null
    //   38: areturn
    //   39: iconst_0
    //   40: istore_2
    //   41: goto -14 -> 27
    //   44: new 156	java/lang/StringBuilder
    //   47: dup
    //   48: ldc_w 462
    //   51: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: aload_1
    //   55: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc_w 433
    //   61: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 7
    //   69: new 445	java/util/LinkedList
    //   72: dup
    //   73: invokespecial 446	java/util/LinkedList:<init>	()V
    //   76: astore 5
    //   78: invokestatic 178	android/os/SystemClock:uptimeMillis	()J
    //   81: lstore_3
    //   82: aload_0
    //   83: getfield 133	com/tencent/mm/plugin/finder/storage/ak:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   86: aload 7
    //   88: aconst_null
    //   89: invokeinterface 194 3 0
    //   94: checkcast 196	java/io/Closeable
    //   97: astore_1
    //   98: aload_1
    //   99: checkcast 198	android/database/Cursor
    //   102: astore 6
    //   104: new 200	com/tencent/mm/plugin/finder/conv/a$a
    //   107: dup
    //   108: invokespecial 201	com/tencent/mm/plugin/finder/conv/a$a:<init>	()V
    //   111: astore 8
    //   113: invokestatic 207	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   116: invokevirtual 210	java/lang/Thread:getName	()Ljava/lang/String;
    //   119: astore 9
    //   121: aload 9
    //   123: ldc 212
    //   125: invokestatic 215	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   128: aload 8
    //   130: aload 9
    //   132: invokevirtual 219	com/tencent/mm/plugin/finder/conv/a$a:avh	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/a$a;
    //   135: aload 7
    //   137: invokevirtual 222	com/tencent/mm/plugin/finder/conv/a$a:avg	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/a$a;
    //   140: astore 7
    //   142: aload 7
    //   144: invokestatic 178	android/os/SystemClock:uptimeMillis	()J
    //   147: lload_3
    //   148: lsub
    //   149: putfield 226	com/tencent/mm/plugin/finder/conv/a$a:duration	J
    //   152: aload 7
    //   154: ldc_w 448
    //   157: invokevirtual 231	com/tencent/mm/plugin/finder/conv/a$a:avf	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/a$a;
    //   160: invokevirtual 235	com/tencent/mm/plugin/finder/conv/a$a:dWL	()Lcom/tencent/mm/plugin/finder/conv/a$b;
    //   163: invokevirtual 240	com/tencent/mm/plugin/finder/conv/a$b:report	()V
    //   166: aload 6
    //   168: invokeinterface 451 1 0
    //   173: ifeq +58 -> 231
    //   176: new 93	com/tencent/mm/plugin/finder/conv/o
    //   179: dup
    //   180: invokespecial 153	com/tencent/mm/plugin/finder/conv/o:<init>	()V
    //   183: astore 7
    //   185: aload 7
    //   187: aload 6
    //   189: invokevirtual 248	com/tencent/mm/plugin/finder/conv/o:convertFrom	(Landroid/database/Cursor;)V
    //   192: aload 5
    //   194: aload 7
    //   196: invokevirtual 455	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   199: pop
    //   200: goto -34 -> 166
    //   203: astore 5
    //   205: ldc_w 459
    //   208: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload 5
    //   213: athrow
    //   214: astore 6
    //   216: aload_1
    //   217: aload 5
    //   219: invokestatic 265	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   222: ldc_w 459
    //   225: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload 6
    //   230: athrow
    //   231: getstatic 282	kotlin/ah:aiuX	Lkotlin/ah;
    //   234: astore 6
    //   236: aload_1
    //   237: aconst_null
    //   238: invokestatic 265	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   241: ldc_w 459
    //   244: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aload 5
    //   249: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	this	ak
    //   0	250	1	paramString	String
    //   26	15	2	i	int
    //   81	67	3	l	long
    //   76	117	5	localLinkedList	LinkedList
    //   203	45	5	localThrowable	Throwable
    //   102	86	6	localCursor	Cursor
    //   214	15	6	localObject1	Object
    //   234	1	6	localah	ah
    //   67	128	7	localObject2	Object
    //   111	18	8	locala	a.a
    //   119	12	9	str	String
    // Exception table:
    //   from	to	target	type
    //   98	166	203	finally
    //   166	200	203	finally
    //   231	236	203	finally
    //   205	214	214	finally
  }
  
  public final boolean aAJ(String paramString)
  {
    AppMethodBeat.i(339521);
    s.u(paramString, "sessionId");
    Object localObject = aAG(paramString);
    this.FMn.remove(paramString);
    this.FMm.remove(((o)localObject).field_talker + '_' + ((o)localObject).field_senderUserName);
    long l = SystemClock.uptimeMillis();
    boolean bool = delete((IAutoDBItem)localObject, false, new String[] { "sessionId" });
    paramString = new a.a();
    localObject = Thread.currentThread().getName();
    s.s(localObject, "currentThread().name");
    paramString = paramString.avh((String)localObject).avg("updateNotify");
    paramString.duration = (SystemClock.uptimeMillis() - l);
    paramString.avf("FinderSessionInfoStorage.deleteSession").dWL().report();
    AppMethodBeat.o(339521);
    return bool;
  }
  
  public final boolean bUc()
  {
    AppMethodBeat.i(339545);
    Log.i("Finder.SessionStorage", "[checkOldSessionInfo] begin");
    LinkedList localLinkedList = new LinkedList();
    long l1 = SystemClock.uptimeMillis();
    Object localObject2 = (Closeable)this.db.rawQuery("select * , rowid from FinderSessionInfo", null);
    boolean bool2;
    boolean bool1;
    try
    {
      Cursor localCursor = (Cursor)localObject2;
      Object localObject6 = new a.a();
      Object localObject7 = Thread.currentThread().getName();
      s.s(localObject7, "currentThread().name");
      localObject6 = ((a.a)localObject6).avh((String)localObject7).avg("select * , rowid from FinderSessionInfo");
      ((a.a)localObject6).duration = (SystemClock.uptimeMillis() - l1);
      ((a.a)localObject6).avf("FinderConversationStorage.checkOldSessionInfo").dWL().report();
      while (localCursor.moveToNext())
      {
        localObject6 = new o();
        ((o)localObject6).convertFrom(localCursor);
        localLinkedList.add(localObject6);
      }
      try
      {
        localObject7 = ((Iterable)localThrowable).iterator();
        if (((Iterator)localObject7).hasNext())
        {
          localObject8 = (o)((Iterator)localObject7).next();
          localCharSequence = (CharSequence)((o)localObject8).field_senderUserName;
          if (localCharSequence == null) {
            break label865;
          }
          if (localCharSequence.length() != 0) {
            break label886;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject4;
        Log.i("Finder.SessionStorage", s.X("crash catch [checkOldSessionInfo] ", localException.getMessage()));
        e.a.a((e)com.tencent.mm.plugin.findersdk.b.HbT, "checkOldSessionInfo", false, null, false, (a)new c(localException), 28);
        ((com.tencent.mm.storagebase.h)this.db).endTransaction(l2);
        localObject5 = new a.a();
        localObject6 = Thread.currentThread().getName();
        s.s(localObject6, "currentThread().name");
        localObject5 = ((a.a)localObject5).avh((String)localObject6).avg("UPDATE FinderSessionInfo SET senderUserName = 'xxx' , senderRoleType = 'xxxx'\"WHERE talker = 'xxx'");
        ((a.a)localObject5).duration = (SystemClock.uptimeMillis() - l1);
        ((a.a)localObject5).avf("FinderConversationStorage.checkOldSessionInfo#UPDATE").dWL().report();
        bool1 = bool2;
        for (;;)
        {
          Log.i("Finder.SessionStorage", "[checkOldSessionInfo] status, total:" + localThrowable.size() + ", failed:" + ((ah.d)localObject2).aixb);
          localObject5 = (e)com.tencent.mm.plugin.findersdk.b.HbT;
          if (((ah.d)localObject2).aixb != 0) {
            break;
          }
          bool2 = true;
          e.a.a((e)localObject5, "checkOldSessionInfo-status", bool2, null, false, (a)new d(localThrowable, (ah.d)localObject2), 28);
          Log.i("Finder.SessionStorage", "[checkOldSessionInfo] end");
          AppMethodBeat.o(339545);
          return bool1;
          bool1 = false;
          break label883;
          ((com.tencent.mm.storagebase.h)this.db).endTransaction(l2);
          localObject5 = new a.a();
          localObject6 = Thread.currentThread().getName();
          s.s(localObject6, "currentThread().name");
          localObject5 = ((a.a)localObject5).avh((String)localObject6).avg("UPDATE FinderSessionInfo SET senderUserName = 'xxx' , senderRoleType = 'xxxx'\"WHERE talker = 'xxx'");
          ((a.a)localObject5).duration = (SystemClock.uptimeMillis() - l1);
          ((a.a)localObject5).avf("FinderConversationStorage.checkOldSessionInfo#UPDATE").dWL().report();
        }
      }
      finally
      {
        long l2;
        ((com.tencent.mm.storagebase.h)this.db).endTransaction(l2);
        localObject2 = new a.a();
        localObject5 = Thread.currentThread().getName();
        s.s(localObject5, "currentThread().name");
        localObject2 = ((a.a)localObject2).avh((String)localObject5).avg("UPDATE FinderSessionInfo SET senderUserName = 'xxx' , senderRoleType = 'xxxx'\"WHERE talker = 'xxx'");
        ((a.a)localObject2).duration = (SystemClock.uptimeMillis() - l1);
        ((a.a)localObject2).avf("FinderConversationStorage.checkOldSessionInfo#UPDATE").dWL().report();
        AppMethodBeat.o(339545);
      }
    }
    finally
    {
      try
      {
        AppMethodBeat.o(339545);
        throw localThrowable;
      }
      finally
      {
        kotlin.f.b.a((Closeable)localObject2, localThrowable);
        AppMethodBeat.o(339545);
      }
      localObject4 = ah.aiuX;
      kotlin.f.b.a((Closeable)localObject2, null);
      Log.i("Finder.SessionStorage", s.X("[checkOldSessionInfo] size:", Integer.valueOf(localThrowable.size())));
      localObject4 = z.bAM();
      localObject6 = z.bAW();
      bool2 = false;
      l2 = ((com.tencent.mm.storagebase.h)this.db).beginTransaction(-1L);
      bool1 = true;
      localObject2 = new ah.d();
    }
    for (;;)
    {
      Object localObject8;
      CharSequence localCharSequence;
      boolean bool3;
      if (i != 0)
      {
        if (au.bwV(((o)localObject8).field_talker))
        {
          ((o)localObject8).field_senderUserName = ((String)localObject4);
          ((o)localObject8).field_senderRoleType = 1;
          localObject8 = "UPDATE FinderSessionInfo SET senderUserName = '" + ((o)localObject8).field_senderUserName + "' , senderRoleType = '" + ((o)localObject8).field_senderRoleType + "' WHERE talker = '" + ((o)localObject8).field_talker + '\'';
          bool3 = this.db.execSQL("FinderSessionInfo", (String)localObject8);
          if (bool3) {
            break label870;
          }
          ((ah.d)localObject2).aixb += 1;
          break label870;
        }
        ((o)localObject8).field_senderUserName = ((String)localObject6);
        ((o)localObject8).field_senderRoleType = 3;
      }
      label865:
      label870:
      while ((!bool1) || (!bool3))
      {
        for (;;)
        {
          Object localObject5;
          bool2 = false;
        }
        break label883;
        i = 1;
        break;
      }
      bool1 = true;
      label883:
      continue;
      label886:
      int i = 0;
    }
  }
  
  public final String eK(String paramString, int paramInt)
  {
    AppMethodBeat.i(339492);
    paramString = eJ(paramString, paramInt);
    if (paramString == null)
    {
      AppMethodBeat.o(339492);
      return "";
    }
    paramString = paramString.field_sessionId;
    if (paramString == null)
    {
      AppMethodBeat.o(339492);
      return "";
    }
    AppMethodBeat.o(339492);
    return paramString;
  }
  
  public final void eL(String paramString, int paramInt)
  {
    AppMethodBeat.i(339512);
    s.u(paramString, "sessionId");
    paramString = aAG(paramString);
    paramString.field_rejectMsg = paramInt;
    long l = SystemClock.uptimeMillis();
    boolean bool = updateNotify((IAutoDBItem)paramString, false, new String[] { null });
    a.a locala = new a.a();
    String str = Thread.currentThread().getName();
    s.s(str, "currentThread().name");
    locala = locala.avh(str).avg("updateNotify");
    locala.duration = (SystemClock.uptimeMillis() - l);
    locala.avf("FinderSessionInfoStorage.updateOpType").dWL().report();
    if (bool)
    {
      this.FMm.remove(paramString.field_talker + '_' + paramString.field_senderUserName);
      this.FMn.remove(paramString.field_sessionId);
      doNotify(paramString.field_sessionId);
    }
    AppMethodBeat.o(339512);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$ReplaceSource;", "", "(Ljava/lang/String;I)V", "RECEIVE", "GET_SESSION_ID", "SELF_REPLY", "FOR_TEST", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(338969);
      FMo = new b("RECEIVE", 0);
      FMp = new b("GET_SESSION_ID", 1);
      FMq = new b("SELF_REPLY", 2);
      FMr = new b("FOR_TEST", 3);
      FMs = new b[] { FMo, FMp, FMq, FMr };
      AppMethodBeat.o(338969);
    }
    
    private b() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<String>
  {
    c(Exception paramException)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<String>
  {
    d(LinkedList<o> paramLinkedList, ah.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ak
 * JD-Core Version:    0.7.0.1
 */