package com.tencent.mm.plugin.finder.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ck;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.j.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import d.g.b.p;
import d.l;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/conv/FinderSessionInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "sessionIdToSessionInfoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "talkerToSessionInfoCache", "deleteSession", "", "sessionId", "isNotify", "getSessionId", "talker", "getSessionInfoBySessionId", "getSessionInfoByTalker", "getTalker", "isSessionRejectMsg", "replaceSessionInfo", "", "type", "", "enable_action", "source", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$ReplaceSource;", "rejectMsg", "canSendMsg", "updateOpType", "updateOpTypeAndAction", "actionPermission", "Companion", "ReplaceSource", "plugin-finder_release"})
public final class w
  extends com.tencent.mm.sdk.e.j<com.tencent.mm.plugin.finder.conv.j>
{
  private static final String[] SQL_CREATE;
  public static final a sJX;
  private final e db;
  public final ConcurrentHashMap<String, com.tencent.mm.plugin.finder.conv.j> sJV;
  public final ConcurrentHashMap<String, com.tencent.mm.plugin.finder.conv.j> sJW;
  
  static
  {
    AppMethodBeat.i(204307);
    sJX = new a((byte)0);
    j.a locala = com.tencent.mm.plugin.finder.conv.j.rUc;
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(com.tencent.mm.plugin.finder.conv.j.access$getInfo$cp(), "FinderSessionInfo") };
    AppMethodBeat.o(204307);
  }
  
  public w(e parame)
  {
    super(parame, com.tencent.mm.plugin.finder.conv.j.access$getInfo$cp(), "FinderSessionInfo", ck.INDEX_CREATE);
    AppMethodBeat.i(204306);
    this.db = parame;
    this.sJV = new ConcurrentHashMap();
    this.sJW = new ConcurrentHashMap();
    AppMethodBeat.o(204306);
  }
  
  /* Error */
  private final com.tencent.mm.plugin.finder.conv.j ajs(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 131
    //   4: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: checkcast 133	java/lang/CharSequence
    //   11: astore 4
    //   13: aload 4
    //   15: ifnull +13 -> 28
    //   18: aload 4
    //   20: invokeinterface 137 1 0
    //   25: ifne +24 -> 49
    //   28: iconst_1
    //   29: istore_2
    //   30: iload_2
    //   31: ifeq +23 -> 54
    //   34: new 77	com/tencent/mm/plugin/finder/conv/j
    //   37: dup
    //   38: invokespecial 138	com/tencent/mm/plugin/finder/conv/j:<init>	()V
    //   41: astore_1
    //   42: ldc 131
    //   44: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_1
    //   48: areturn
    //   49: iconst_0
    //   50: istore_2
    //   51: goto -21 -> 30
    //   54: aload_0
    //   55: getfield 124	com/tencent/mm/plugin/finder/storage/w:sJV	Ljava/util/concurrent/ConcurrentHashMap;
    //   58: aload_1
    //   59: invokevirtual 142	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   62: checkcast 77	com/tencent/mm/plugin/finder/conv/j
    //   65: astore 4
    //   67: aload 4
    //   69: ifnonnull +189 -> 258
    //   72: aload_0
    //   73: checkcast 2	com/tencent/mm/plugin/finder/storage/w
    //   76: astore 5
    //   78: new 144	java/lang/StringBuilder
    //   81: dup
    //   82: ldc 146
    //   84: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: aload_1
    //   88: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc 155
    //   93: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore 4
    //   101: aload 5
    //   103: getfield 118	com/tencent/mm/plugin/finder/storage/w:db	Lcom/tencent/mm/sdk/e/e;
    //   106: aload 4
    //   108: aconst_null
    //   109: invokeinterface 165 3 0
    //   114: checkcast 167	java/io/Closeable
    //   117: astore 4
    //   119: aload 4
    //   121: checkcast 169	android/database/Cursor
    //   124: astore 7
    //   126: aload 7
    //   128: invokeinterface 173 1 0
    //   133: ifeq +86 -> 219
    //   136: new 77	com/tencent/mm/plugin/finder/conv/j
    //   139: dup
    //   140: invokespecial 138	com/tencent/mm/plugin/finder/conv/j:<init>	()V
    //   143: astore 6
    //   145: aload 6
    //   147: aload 7
    //   149: invokevirtual 177	com/tencent/mm/plugin/finder/conv/j:convertFrom	(Landroid/database/Cursor;)V
    //   152: aload 5
    //   154: getfield 126	com/tencent/mm/plugin/finder/storage/w:sJW	Ljava/util/concurrent/ConcurrentHashMap;
    //   157: checkcast 179	java/util/Map
    //   160: astore 7
    //   162: aload 6
    //   164: getfield 183	com/tencent/mm/plugin/finder/conv/j:field_sessionId	Ljava/lang/String;
    //   167: astore 8
    //   169: aload 8
    //   171: ldc 185
    //   173: invokestatic 188	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   176: aload 7
    //   178: aload 8
    //   180: aload 6
    //   182: invokeinterface 192 3 0
    //   187: pop
    //   188: aload 5
    //   190: getfield 124	com/tencent/mm/plugin/finder/storage/w:sJV	Ljava/util/concurrent/ConcurrentHashMap;
    //   193: checkcast 179	java/util/Map
    //   196: aload_1
    //   197: aload 6
    //   199: invokeinterface 192 3 0
    //   204: pop
    //   205: aload 4
    //   207: aconst_null
    //   208: invokestatic 197	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   211: ldc 131
    //   213: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aload 6
    //   218: areturn
    //   219: getstatic 203	d/z:Nhr	Ld/z;
    //   222: astore_1
    //   223: aload 4
    //   225: aconst_null
    //   226: invokestatic 197	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   229: ldc 131
    //   231: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aconst_null
    //   235: areturn
    //   236: astore_3
    //   237: ldc 131
    //   239: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   242: aload_3
    //   243: athrow
    //   244: astore_1
    //   245: aload 4
    //   247: aload_3
    //   248: invokestatic 197	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   251: ldc 131
    //   253: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload_1
    //   257: athrow
    //   258: ldc 131
    //   260: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload 4
    //   265: areturn
    //   266: astore_1
    //   267: goto -22 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	w
    //   0	270	1	paramString	String
    //   29	22	2	i	int
    //   1	1	3	localObject1	Object
    //   236	12	3	localThrowable	Throwable
    //   11	253	4	localObject2	Object
    //   76	113	5	localw	w
    //   143	74	6	localj	com.tencent.mm.plugin.finder.conv.j
    //   124	53	7	localObject3	Object
    //   167	12	8	str	String
    // Exception table:
    //   from	to	target	type
    //   119	205	236	java/lang/Throwable
    //   219	223	236	java/lang/Throwable
    //   237	244	244	finally
    //   119	205	266	finally
    //   219	223	266	finally
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, b paramb, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(204304);
    p.h(paramString1, "sessionId");
    p.h(paramString2, "talker");
    p.h(paramb, "source");
    Object localObject = new com.tencent.mm.plugin.finder.conv.j();
    ((com.tencent.mm.plugin.finder.conv.j)localObject).field_sessionId = paramString1;
    ((com.tencent.mm.plugin.finder.conv.j)localObject).field_talker = paramString2;
    ((com.tencent.mm.plugin.finder.conv.j)localObject).field_type = paramInt1;
    ((com.tencent.mm.plugin.finder.conv.j)localObject).field_updateTime = ch.aDc();
    ((com.tencent.mm.plugin.finder.conv.j)localObject).field_selfUsername = v.aAK();
    ((com.tencent.mm.plugin.finder.conv.j)localObject).field_actionPermission = paramInt2;
    ((com.tencent.mm.plugin.finder.conv.j)localObject).field_rejectMsg = paramInt3;
    ((com.tencent.mm.plugin.finder.conv.j)localObject).field_disableSendMsg = paramInt4;
    if (an.aji(paramString2))
    {
      paramString1 = (Throwable)new RuntimeException(paramString2 + " is invalid");
      AppMethodBeat.o(204304);
      throw paramString1;
    }
    boolean bool = replace((com.tencent.mm.sdk.e.c)localObject, false);
    if (bool)
    {
      this.sJV.remove(paramString2);
      this.sJW.remove(paramString1);
      doNotify(((com.tencent.mm.plugin.finder.conv.j)localObject).field_sessionId);
    }
    if (paramb == b.sKb)
    {
      localObject = ((PluginFinder)g.ad(PluginFinder.class)).getConversationStorage();
      com.tencent.mm.plugin.finder.conv.c localc = ((d)localObject).ajn(paramString1);
      localc.field_talker = paramString2;
      localc.field_actionPermission = paramInt2;
      localc.field_type = paramInt1;
      if (!((d)localObject).a(localc, false)) {
        ae.e("Finder.SessionStorage", "[replaceSessionInfo] fail! sessionId=".concat(String.valueOf(paramString1)));
      }
    }
    ae.i("Finder.SessionStorage", "[replaceSessionInfo] source=" + paramb + ", ret=" + bool + ", sessionId=" + paramString1 + ", talker=" + paramString2 + ", actionPermission=" + paramInt2 + ", type=" + paramInt1);
    AppMethodBeat.o(204304);
  }
  
  /* Error */
  public final com.tencent.mm.plugin.finder.conv.j ajt(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 341
    //   6: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: checkcast 133	java/lang/CharSequence
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull +12 -> 27
    //   18: aload_3
    //   19: invokeinterface 137 1 0
    //   24: ifne +25 -> 49
    //   27: iconst_1
    //   28: istore_2
    //   29: iload_2
    //   30: ifeq +24 -> 54
    //   33: new 77	com/tencent/mm/plugin/finder/conv/j
    //   36: dup
    //   37: invokespecial 138	com/tencent/mm/plugin/finder/conv/j:<init>	()V
    //   40: astore_1
    //   41: ldc_w 341
    //   44: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_1
    //   48: areturn
    //   49: iconst_0
    //   50: istore_2
    //   51: goto -22 -> 29
    //   54: aload_0
    //   55: getfield 126	com/tencent/mm/plugin/finder/storage/w:sJW	Ljava/util/concurrent/ConcurrentHashMap;
    //   58: aload_1
    //   59: invokevirtual 142	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   62: checkcast 77	com/tencent/mm/plugin/finder/conv/j
    //   65: astore 5
    //   67: aload 5
    //   69: astore_3
    //   70: aload 5
    //   72: ifnonnull +151 -> 223
    //   75: aload_0
    //   76: checkcast 2	com/tencent/mm/plugin/finder/storage/w
    //   79: astore 6
    //   81: new 144	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 343
    //   88: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_1
    //   92: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 155
    //   97: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore 5
    //   105: new 77	com/tencent/mm/plugin/finder/conv/j
    //   108: dup
    //   109: invokespecial 138	com/tencent/mm/plugin/finder/conv/j:<init>	()V
    //   112: astore_3
    //   113: aload 6
    //   115: getfield 118	com/tencent/mm/plugin/finder/storage/w:db	Lcom/tencent/mm/sdk/e/e;
    //   118: aload 5
    //   120: aconst_null
    //   121: invokeinterface 165 3 0
    //   126: checkcast 167	java/io/Closeable
    //   129: astore 5
    //   131: aload 5
    //   133: checkcast 169	android/database/Cursor
    //   136: astore 7
    //   138: aload 7
    //   140: invokeinterface 173 1 0
    //   145: ifeq +9 -> 154
    //   148: aload_3
    //   149: aload 7
    //   151: invokevirtual 177	com/tencent/mm/plugin/finder/conv/j:convertFrom	(Landroid/database/Cursor;)V
    //   154: getstatic 203	d/z:Nhr	Ld/z;
    //   157: astore 7
    //   159: aload 5
    //   161: aconst_null
    //   162: invokestatic 197	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   165: aload_3
    //   166: getfield 346	com/tencent/mm/plugin/finder/conv/j:systemRowid	J
    //   169: lconst_0
    //   170: lcmp
    //   171: ifle +52 -> 223
    //   174: aload 6
    //   176: getfield 126	com/tencent/mm/plugin/finder/storage/w:sJW	Ljava/util/concurrent/ConcurrentHashMap;
    //   179: checkcast 179	java/util/Map
    //   182: aload_1
    //   183: aload_3
    //   184: invokeinterface 192 3 0
    //   189: pop
    //   190: aload 6
    //   192: getfield 124	com/tencent/mm/plugin/finder/storage/w:sJV	Ljava/util/concurrent/ConcurrentHashMap;
    //   195: checkcast 179	java/util/Map
    //   198: astore_1
    //   199: aload_3
    //   200: getfield 213	com/tencent/mm/plugin/finder/conv/j:field_talker	Ljava/lang/String;
    //   203: astore 4
    //   205: aload 4
    //   207: ldc_w 348
    //   210: invokestatic 188	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   213: aload_1
    //   214: aload 4
    //   216: aload_3
    //   217: invokeinterface 192 3 0
    //   222: pop
    //   223: ldc_w 341
    //   226: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: aload_3
    //   230: areturn
    //   231: astore_3
    //   232: ldc_w 341
    //   235: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_3
    //   239: athrow
    //   240: astore_1
    //   241: aload 5
    //   243: aload_3
    //   244: invokestatic 197	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   247: ldc_w 341
    //   250: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: aload_1
    //   254: athrow
    //   255: astore_1
    //   256: aload 4
    //   258: astore_3
    //   259: goto -18 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	w
    //   0	262	1	paramString	String
    //   28	23	2	i	int
    //   13	217	3	localObject1	Object
    //   231	13	3	localThrowable	Throwable
    //   258	1	3	str1	String
    //   1	256	4	str2	String
    //   65	177	5	localObject2	Object
    //   79	112	6	localw	w
    //   136	22	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   131	154	231	java/lang/Throwable
    //   154	159	231	java/lang/Throwable
    //   232	240	240	finally
    //   131	154	255	finally
    //   154	159	255	finally
  }
  
  public final String aju(String paramString)
  {
    AppMethodBeat.i(204302);
    paramString = ajs(paramString);
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
    AppMethodBeat.o(204302);
    return paramString;
  }
  
  public final String ajv(String paramString)
  {
    AppMethodBeat.i(204303);
    String str = ajt(paramString).field_talker;
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    AppMethodBeat.o(204303);
    return paramString;
  }
  
  public final void du(String paramString, int paramInt)
  {
    AppMethodBeat.i(204305);
    p.h(paramString, "sessionId");
    paramString = ajt(paramString);
    paramString.field_rejectMsg = paramInt;
    if (updateNotify((com.tencent.mm.sdk.e.c)paramString, false, new String[] { null }))
    {
      this.sJV.remove(paramString.field_talker);
      this.sJW.remove(paramString.field_sessionId);
      doNotify(paramString.field_sessionId);
    }
    AppMethodBeat.o(204305);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage$ReplaceSource;", "", "(Ljava/lang/String;I)V", "RECEIVE", "GET_SESSION_ID", "SELF_REPLY", "FOR_TEST", "plugin-finder_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(204297);
      b localb1 = new b("RECEIVE", 0);
      sJY = localb1;
      b localb2 = new b("GET_SESSION_ID", 1);
      sJZ = localb2;
      b localb3 = new b("SELF_REPLY", 2);
      sKa = localb3;
      b localb4 = new b("FOR_TEST", 3);
      sKb = localb4;
      sKc = new b[] { localb1, localb2, localb3, localb4 };
      AppMethodBeat.o(204297);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.w
 * JD-Core Version:    0.7.0.1
 */