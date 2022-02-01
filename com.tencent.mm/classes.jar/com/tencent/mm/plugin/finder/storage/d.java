package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ce;
import com.tencent.mm.plugin.finder.conv.c.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "clearUnreadCount", "", "sessionId", "", "genSceneTypeIndex", "", "get", "getGreetConvCount", "", "scene", "getTopPlaceCount", "type", "getUnreadCount", "isExit", "query", "", "offset", "nextCount", "", "queryLimit", "limitCount", "types", "replace", "item", "isNotify", "setEditing", "editing", "setTopPlace", "isTopPlace", "Companion", "plugin-finder_release"})
public final class d
  extends j<com.tencent.mm.plugin.finder.conv.c>
{
  private static final String[] SQL_CREATE;
  public static final a sxD;
  private final com.tencent.mm.sdk.e.e db;
  
  static
  {
    AppMethodBeat.i(203652);
    sxD = new a((byte)0);
    c.a locala = com.tencent.mm.plugin.finder.conv.c.rLn;
    SQL_CREATE = new String[] { j.getCreateSQLs(com.tencent.mm.plugin.finder.conv.c.access$getInfo$cp(), "FinderConversation") };
    AppMethodBeat.o(203652);
  }
  
  public d(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, com.tencent.mm.plugin.finder.conv.c.access$getInfo$cp(), "FinderConversation", ce.INDEX_CREATE);
    AppMethodBeat.i(203651);
    this.db = parame;
    this.db.execSQL("FinderConversation", "CREATE INDEX IF NOT EXISTS FinderConversation_type_scene_index ON FinderConversation(scene,type)");
    AppMethodBeat.o(203651);
  }
  
  /* Error */
  private boolean air(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 125
    //   5: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 126
    //   11: invokestatic 101	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: new 128	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 130
    //   20: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 139
    //   29: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore_1
    //   36: aload_0
    //   37: getfield 112	com/tencent/mm/plugin/finder/storage/d:db	Lcom/tencent/mm/sdk/e/e;
    //   40: aload_1
    //   41: aconst_null
    //   42: invokeinterface 147 3 0
    //   47: checkcast 149	java/io/Closeable
    //   50: astore 5
    //   52: aload 5
    //   54: checkcast 151	android/database/Cursor
    //   57: astore_1
    //   58: aload_1
    //   59: ldc 153
    //   61: invokestatic 156	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   64: aload_1
    //   65: invokeinterface 160 1 0
    //   70: istore_2
    //   71: iload_2
    //   72: ifle +18 -> 90
    //   75: iconst_1
    //   76: istore_3
    //   77: aload 5
    //   79: aconst_null
    //   80: invokestatic 165	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   83: ldc 125
    //   85: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: iload_3
    //   89: ireturn
    //   90: iconst_0
    //   91: istore_3
    //   92: goto -15 -> 77
    //   95: astore 4
    //   97: ldc 125
    //   99: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: aload 4
    //   104: athrow
    //   105: astore_1
    //   106: aload 5
    //   108: aload 4
    //   110: invokestatic 165	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   113: ldc 125
    //   115: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_1
    //   119: athrow
    //   120: astore_1
    //   121: goto -15 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	d
    //   0	124	1	paramString	String
    //   70	2	2	i	int
    //   76	16	3	bool	boolean
    //   1	1	4	localObject	Object
    //   95	14	4	localThrowable	java.lang.Throwable
    //   50	57	5	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   52	71	95	java/lang/Throwable
    //   97	105	105	finally
    //   52	71	120	finally
  }
  
  /* Error */
  private final List<com.tencent.mm.plugin.finder.conv.c> b(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    // Byte code:
    //   0: ldc 168
    //   2: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 170	java/util/LinkedList
    //   8: dup
    //   9: invokespecial 172	java/util/LinkedList:<init>	()V
    //   12: astore 13
    //   14: aload_0
    //   15: iload 4
    //   17: invokevirtual 176	com/tencent/mm/plugin/finder/storage/d:Fm	(I)I
    //   20: istore 7
    //   22: aload_3
    //   23: ifnull +433 -> 456
    //   26: ldc 178
    //   28: astore 11
    //   30: iconst_0
    //   31: istore 5
    //   33: aload_3
    //   34: arraylength
    //   35: istore 8
    //   37: iconst_0
    //   38: istore 6
    //   40: iload 6
    //   42: iload 8
    //   44: if_icmpge +106 -> 150
    //   47: aload_3
    //   48: iload 6
    //   50: iaload
    //   51: istore 9
    //   53: iload 7
    //   55: ifgt +14 -> 69
    //   58: aload 11
    //   60: astore 12
    //   62: iload 9
    //   64: bipush 100
    //   66: if_icmpeq +65 -> 131
    //   69: new 128	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   76: aload 11
    //   78: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 181
    //   83: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: iload 9
    //   88: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   91: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore 11
    //   96: aload 11
    //   98: astore 12
    //   100: iload 5
    //   102: iconst_1
    //   103: iadd
    //   104: aload_3
    //   105: arraylength
    //   106: if_icmpge +25 -> 131
    //   109: new 128	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   116: aload 11
    //   118: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc 186
    //   123: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: astore 12
    //   131: iload 6
    //   133: iconst_1
    //   134: iadd
    //   135: istore 6
    //   137: iload 5
    //   139: iconst_1
    //   140: iadd
    //   141: istore 5
    //   143: aload 12
    //   145: astore 11
    //   147: goto -107 -> 40
    //   150: ldc 186
    //   152: checkcast 188	java/lang/CharSequence
    //   155: astore 12
    //   157: aload 11
    //   159: ldc 190
    //   161: invokestatic 101	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   164: aload 12
    //   166: ldc 192
    //   168: invokestatic 101	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   171: aload 11
    //   173: checkcast 188	java/lang/CharSequence
    //   176: astore_3
    //   177: aload_3
    //   178: ldc 194
    //   180: invokestatic 101	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   183: aload 12
    //   185: ldc 192
    //   187: invokestatic 101	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   190: aload_3
    //   191: instanceof 77
    //   194: ifeq +228 -> 422
    //   197: aload_3
    //   198: checkcast 77	java/lang/String
    //   201: aload 12
    //   203: checkcast 77	java/lang/String
    //   206: invokestatic 199	d/n/n:nA	(Ljava/lang/String;Ljava/lang/String;)Z
    //   209: istore 10
    //   211: aload 11
    //   213: astore_3
    //   214: iload 10
    //   216: ifeq +29 -> 245
    //   219: aload 11
    //   221: iconst_0
    //   222: aload 11
    //   224: invokevirtual 202	java/lang/String:length	()I
    //   227: aload 12
    //   229: invokeinterface 203 1 0
    //   234: isub
    //   235: invokevirtual 207	java/lang/String:substring	(II)Ljava/lang/String;
    //   238: astore_3
    //   239: aload_3
    //   240: ldc 209
    //   242: invokestatic 156	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   245: new 128	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   252: aload_3
    //   253: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: ldc 211
    //   258: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: astore_3
    //   265: new 128	java/lang/StringBuilder
    //   268: dup
    //   269: ldc 213
    //   271: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   274: iload 4
    //   276: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: ldc 215
    //   281: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_3
    //   285: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc 217
    //   290: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: iload_2
    //   294: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: ldc 219
    //   299: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: iload_1
    //   303: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   306: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: astore_3
    //   310: aload_0
    //   311: getfield 112	com/tencent/mm/plugin/finder/storage/d:db	Lcom/tencent/mm/sdk/e/e;
    //   314: aload_3
    //   315: aconst_null
    //   316: invokeinterface 147 3 0
    //   321: checkcast 149	java/io/Closeable
    //   324: astore 12
    //   326: aconst_null
    //   327: astore 11
    //   329: aload 12
    //   331: checkcast 151	android/database/Cursor
    //   334: astore_3
    //   335: aload_3
    //   336: invokeinterface 223 1 0
    //   341: ifeq +154 -> 495
    //   344: aload_3
    //   345: ldc 225
    //   347: invokestatic 156	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   350: aload_3
    //   351: invokeinterface 228 1 0
    //   356: ifne +139 -> 495
    //   359: new 71	com/tencent/mm/plugin/finder/conv/c
    //   362: dup
    //   363: invokespecial 229	com/tencent/mm/plugin/finder/conv/c:<init>	()V
    //   366: astore 14
    //   368: aload 14
    //   370: aload_3
    //   371: invokevirtual 233	com/tencent/mm/plugin/finder/conv/c:convertFrom	(Landroid/database/Cursor;)V
    //   374: aload 14
    //   376: invokevirtual 236	com/tencent/mm/plugin/finder/conv/c:prepare	()V
    //   379: aload 13
    //   381: aload 14
    //   383: invokevirtual 240	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   386: pop
    //   387: aload_3
    //   388: invokeinterface 243 1 0
    //   393: pop
    //   394: goto -50 -> 344
    //   397: astore 11
    //   399: ldc 168
    //   401: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   404: aload 11
    //   406: athrow
    //   407: astore_3
    //   408: aload 12
    //   410: aload 11
    //   412: invokestatic 165	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   415: ldc 168
    //   417: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   420: aload_3
    //   421: athrow
    //   422: aload_3
    //   423: aload_3
    //   424: invokeinterface 203 1 0
    //   429: aload 12
    //   431: invokeinterface 203 1 0
    //   436: isub
    //   437: aload 12
    //   439: iconst_0
    //   440: aload 12
    //   442: invokeinterface 203 1 0
    //   447: iconst_0
    //   448: invokestatic 246	d/n/n:a	(Ljava/lang/CharSequence;ILjava/lang/CharSequence;IIZ)Z
    //   451: istore 10
    //   453: goto -242 -> 211
    //   456: new 128	java/lang/StringBuilder
    //   459: dup
    //   460: ldc 213
    //   462: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   465: iload 4
    //   467: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: ldc 217
    //   472: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: iload_2
    //   476: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   479: ldc 219
    //   481: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: iload_1
    //   485: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   488: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: astore_3
    //   492: goto -182 -> 310
    //   495: getstatic 252	d/z:MKo	Ld/z;
    //   498: astore_3
    //   499: aload 12
    //   501: aconst_null
    //   502: invokestatic 165	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   505: aload 13
    //   507: checkcast 254	java/util/List
    //   510: astore_3
    //   511: ldc 168
    //   513: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   516: aload_3
    //   517: areturn
    //   518: astore_3
    //   519: goto -111 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	522	0	this	d
    //   0	522	1	paramInt1	int
    //   0	522	2	paramInt2	int
    //   0	522	3	paramArrayOfInt	int[]
    //   0	522	4	paramInt3	int
    //   31	111	5	i	int
    //   38	98	6	j	int
    //   20	34	7	k	int
    //   35	10	8	m	int
    //   51	36	9	n	int
    //   209	243	10	bool	boolean
    //   28	300	11	localObject1	Object
    //   397	14	11	localThrowable	java.lang.Throwable
    //   60	440	12	localObject2	Object
    //   12	494	13	localLinkedList	java.util.LinkedList
    //   366	16	14	localc	com.tencent.mm.plugin.finder.conv.c
    // Exception table:
    //   from	to	target	type
    //   329	344	397	java/lang/Throwable
    //   344	394	397	java/lang/Throwable
    //   495	499	397	java/lang/Throwable
    //   399	407	407	finally
    //   329	344	518	finally
    //   344	394	518	finally
    //   495	499	518	finally
  }
  
  /* Error */
  public final int Fm(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 259
    //   5: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 112	com/tencent/mm/plugin/finder/storage/d:db	Lcom/tencent/mm/sdk/e/e;
    //   12: new 128	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 261
    //   19: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: iload_1
    //   23: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 263
    //   29: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: aconst_null
    //   36: invokeinterface 147 3 0
    //   41: checkcast 149	java/io/Closeable
    //   44: astore 4
    //   46: aload 4
    //   48: checkcast 151	android/database/Cursor
    //   51: astore_2
    //   52: aload_2
    //   53: invokeinterface 223 1 0
    //   58: ifeq +57 -> 115
    //   61: aload_2
    //   62: iconst_0
    //   63: invokeinterface 266 2 0
    //   68: istore_1
    //   69: getstatic 252	d/z:MKo	Ld/z;
    //   72: astore_2
    //   73: aload 4
    //   75: aconst_null
    //   76: invokestatic 165	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   79: ldc_w 259
    //   82: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: iload_1
    //   86: ireturn
    //   87: astore_3
    //   88: ldc_w 259
    //   91: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aload_3
    //   95: athrow
    //   96: astore_2
    //   97: aload 4
    //   99: aload_3
    //   100: invokestatic 165	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   103: ldc_w 259
    //   106: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_2
    //   110: athrow
    //   111: astore_2
    //   112: goto -15 -> 97
    //   115: iconst_0
    //   116: istore_1
    //   117: goto -48 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	d
    //   0	120	1	paramInt	int
    //   51	22	2	localObject1	Object
    //   96	14	2	localObject2	Object
    //   111	1	2	localObject3	Object
    //   1	1	3	localObject4	Object
    //   87	13	3	localThrowable	java.lang.Throwable
    //   44	54	4	localCloseable	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   46	69	87	java/lang/Throwable
    //   69	73	87	java/lang/Throwable
    //   88	96	96	finally
    //   46	69	111	finally
    //   69	73	111	finally
  }
  
  public final List<com.tencent.mm.plugin.finder.conv.c> a(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(203640);
    List localList = b(paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    ad.i("Finder.ConversationStorage", "[query] offset=" + paramInt1 + " pageCount=" + paramInt2 + " type=" + paramArrayOfInt + " list size=" + localList.size() + ", scene=" + paramInt3);
    AppMethodBeat.o(203640);
    return localList;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.conv.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(203644);
    Object localObject2 = new StringBuilder("[replace] ");
    if (paramc != null) {}
    for (Object localObject1 = e.b(paramc);; localObject1 = null)
    {
      ad.i("Finder.ConversationStorage", (String)localObject1);
      if (paramc != null) {
        break;
      }
      AppMethodBeat.o(203644);
      return false;
    }
    localObject1 = paramc.convertTo();
    localObject2 = paramc.field_sessionId;
    p.g(localObject2, "item.field_sessionId");
    boolean bool;
    if (air((String)localObject2)) {
      if (this.db.update(getTableName(), (ContentValues)localObject1, "sessionId = ?", new String[] { paramc.field_sessionId }) > 0) {
        bool = true;
      }
    }
    for (;;)
    {
      if ((bool) && (paramBoolean)) {
        doNotify(paramc.field_sessionId);
      }
      AppMethodBeat.o(203644);
      return bool;
      bool = false;
      continue;
      bool = super.insertNotify((com.tencent.mm.sdk.e.c)paramc, false);
    }
  }
  
  /* Error */
  public final int aif(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc_w 334
    //   5: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 126
    //   11: invokestatic 101	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: ldc_w 336
    //   17: aload_1
    //   18: invokestatic 340	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   21: invokevirtual 344	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore 4
    //   26: aload_0
    //   27: getfield 112	com/tencent/mm/plugin/finder/storage/d:db	Lcom/tencent/mm/sdk/e/e;
    //   30: aload 4
    //   32: aconst_null
    //   33: invokeinterface 147 3 0
    //   38: checkcast 149	java/io/Closeable
    //   41: astore 4
    //   43: aload 4
    //   45: checkcast 151	android/database/Cursor
    //   48: astore 5
    //   50: aload 5
    //   52: invokeinterface 223 1 0
    //   57: ifeq +108 -> 165
    //   60: aload 5
    //   62: ldc 225
    //   64: invokestatic 156	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   67: aload 5
    //   69: invokeinterface 228 1 0
    //   74: ifne +91 -> 165
    //   77: aload 5
    //   79: iconst_1
    //   80: invokeinterface 266 2 0
    //   85: istore_2
    //   86: getstatic 252	d/z:MKo	Ld/z;
    //   89: astore 5
    //   91: aload 4
    //   93: aconst_null
    //   94: invokestatic 165	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   97: ldc_w 271
    //   100: new 128	java/lang/StringBuilder
    //   103: dup
    //   104: ldc_w 346
    //   107: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: aload_1
    //   111: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: bipush 32
    //   116: invokevirtual 349	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   119: iload_2
    //   120: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 292	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: ldc_w 334
    //   132: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iload_2
    //   136: ireturn
    //   137: astore_3
    //   138: ldc_w 334
    //   141: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_3
    //   145: athrow
    //   146: astore_1
    //   147: aload 4
    //   149: aload_3
    //   150: invokestatic 165	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   153: ldc_w 334
    //   156: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_1
    //   160: athrow
    //   161: astore_1
    //   162: goto -15 -> 147
    //   165: iconst_0
    //   166: istore_2
    //   167: goto -81 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	d
    //   0	170	1	paramString	String
    //   85	82	2	i	int
    //   1	1	3	localObject1	Object
    //   137	13	3	localThrowable	java.lang.Throwable
    //   24	124	4	localObject2	Object
    //   48	42	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   43	86	137	java/lang/Throwable
    //   86	91	137	java/lang/Throwable
    //   138	146	146	finally
    //   43	86	161	finally
    //   86	91	161	finally
  }
  
  public final com.tencent.mm.plugin.finder.conv.c aiq(String paramString)
  {
    AppMethodBeat.i(203641);
    p.h(paramString, "sessionId");
    Object localObject = "select *, rowid from FinderConversation where sessionId = '" + paramString + "' ";
    localObject = this.db.rawQuery((String)localObject, null);
    com.tencent.mm.plugin.finder.conv.c localc = new com.tencent.mm.plugin.finder.conv.c();
    localc.field_sessionId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        localc.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(203641);
    return localc;
  }
  
  public final boolean ais(String paramString)
  {
    AppMethodBeat.i(203649);
    p.h(paramString, "sessionId");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(203649);
      return false;
    }
    com.tencent.mm.plugin.finder.conv.c localc = aiq(paramString);
    i = localc.field_unReadCount;
    localc.field_unReadCount = 0;
    localc.field_readStatus = 1;
    boolean bool = update(localc.systemRowid, (com.tencent.mm.sdk.e.c)localc);
    doNotify(localc.field_sessionId, 5, localc);
    ad.i("Finder.ConversationStorage", "[clearUnreadCount] ret=" + bool + ' ' + i + " => " + localc.field_unReadCount + " sessionId=" + paramString);
    AppMethodBeat.o(203649);
    return bool;
  }
  
  public final boolean be(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(203650);
    p.h(paramString, "sessionId");
    com.tencent.mm.plugin.finder.conv.c localc = aiq(paramString);
    boolean bool1 = localc.cyS();
    long l;
    boolean bool2;
    if (paramBoolean)
    {
      l = 1L;
      localc.field_placedFlag = l;
      bool2 = update(localc.systemRowid, (com.tencent.mm.sdk.e.c)localc, false);
      if (!paramBoolean) {
        break label145;
      }
      doNotify(localc.field_sessionId, 3, localc);
    }
    for (;;)
    {
      ad.i("Finder.ConversationStorage", "[setTopPlace] ret=" + bool2 + " isTopPlace=" + bool1 + " => " + localc.cyS() + " sessionId=" + paramString);
      AppMethodBeat.o(203650);
      return bool2;
      l = 0L;
      break;
      label145:
      doNotify(localc.field_sessionId, 4, localc);
    }
  }
  
  /* Error */
  public final int fQ(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: ldc_w 404
    //   12: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   15: iload_2
    //   16: iflt +249 -> 265
    //   19: new 128	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 406
    //   26: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: iload_2
    //   30: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc_w 408
    //   36: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_1
    //   40: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: astore 5
    //   48: aload_0
    //   49: getfield 112	com/tencent/mm/plugin/finder/storage/d:db	Lcom/tencent/mm/sdk/e/e;
    //   52: aload 5
    //   54: aconst_null
    //   55: invokeinterface 147 3 0
    //   60: checkcast 149	java/io/Closeable
    //   63: astore 8
    //   65: aload 8
    //   67: checkcast 151	android/database/Cursor
    //   70: astore 5
    //   72: iload 4
    //   74: istore_3
    //   75: aload 5
    //   77: invokeinterface 223 1 0
    //   82: ifeq +32 -> 114
    //   85: aload 5
    //   87: ldc 225
    //   89: invokestatic 156	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   92: iload 4
    //   94: istore_3
    //   95: aload 5
    //   97: invokeinterface 228 1 0
    //   102: ifne +12 -> 114
    //   105: aload 5
    //   107: iconst_0
    //   108: invokeinterface 266 2 0
    //   113: istore_3
    //   114: getstatic 252	d/z:MKo	Ld/z;
    //   117: astore 5
    //   119: aload 8
    //   121: aconst_null
    //   122: invokestatic 165	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   125: aload_0
    //   126: getfield 112	com/tencent/mm/plugin/finder/storage/d:db	Lcom/tencent/mm/sdk/e/e;
    //   129: new 128	java/lang/StringBuilder
    //   132: dup
    //   133: ldc_w 410
    //   136: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: iload_2
    //   140: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: ldc_w 408
    //   146: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: iload_1
    //   150: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: aconst_null
    //   157: invokeinterface 147 3 0
    //   162: checkcast 149	java/io/Closeable
    //   165: astore 7
    //   167: aload 7
    //   169: checkcast 151	android/database/Cursor
    //   172: astore 5
    //   174: aload 5
    //   176: invokeinterface 223 1 0
    //   181: ifeq +32 -> 213
    //   184: aload 5
    //   186: ldc 225
    //   188: invokestatic 156	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   191: aload 5
    //   193: invokeinterface 228 1 0
    //   198: ifne +15 -> 213
    //   201: new 71	com/tencent/mm/plugin/finder/conv/c
    //   204: dup
    //   205: invokespecial 229	com/tencent/mm/plugin/finder/conv/c:<init>	()V
    //   208: aload 5
    //   210: invokevirtual 233	com/tencent/mm/plugin/finder/conv/c:convertFrom	(Landroid/database/Cursor;)V
    //   213: getstatic 252	d/z:MKo	Ld/z;
    //   216: astore 5
    //   218: aload 7
    //   220: aconst_null
    //   221: invokestatic 165	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   224: ldc_w 271
    //   227: new 128	java/lang/StringBuilder
    //   230: dup
    //   231: ldc_w 412
    //   234: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   237: iload_2
    //   238: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: ldc_w 414
    //   244: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: iload_3
    //   248: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   251: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 292	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: ldc_w 404
    //   260: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: iload_3
    //   264: ireturn
    //   265: ldc_w 416
    //   268: iload_1
    //   269: invokestatic 419	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   272: invokevirtual 344	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   275: astore 5
    //   277: goto -229 -> 48
    //   280: astore 6
    //   282: ldc_w 404
    //   285: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: aload 6
    //   290: athrow
    //   291: astore 5
    //   293: aload 8
    //   295: aload 6
    //   297: invokestatic 165	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   300: ldc_w 404
    //   303: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload 5
    //   308: athrow
    //   309: astore 6
    //   311: ldc_w 404
    //   314: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: aload 6
    //   319: athrow
    //   320: astore 5
    //   322: aload 7
    //   324: aload 6
    //   326: invokestatic 165	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   329: ldc_w 404
    //   332: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: aload 5
    //   337: athrow
    //   338: astore 5
    //   340: goto -18 -> 322
    //   343: astore 5
    //   345: aload 7
    //   347: astore 6
    //   349: goto -56 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	d
    //   0	352	1	paramInt1	int
    //   0	352	2	paramInt2	int
    //   74	190	3	i	int
    //   1	92	4	j	int
    //   46	230	5	localObject1	Object
    //   291	16	5	localObject2	Object
    //   320	16	5	localObject3	Object
    //   338	1	5	localObject4	Object
    //   343	1	5	localObject5	Object
    //   4	1	6	localObject6	Object
    //   280	16	6	localThrowable1	java.lang.Throwable
    //   309	16	6	localThrowable2	java.lang.Throwable
    //   347	1	6	localObject7	Object
    //   7	339	7	localCloseable1	java.io.Closeable
    //   63	231	8	localCloseable2	java.io.Closeable
    // Exception table:
    //   from	to	target	type
    //   65	72	280	java/lang/Throwable
    //   75	92	280	java/lang/Throwable
    //   95	114	280	java/lang/Throwable
    //   114	119	280	java/lang/Throwable
    //   282	291	291	finally
    //   167	213	309	java/lang/Throwable
    //   213	218	309	java/lang/Throwable
    //   311	320	320	finally
    //   167	213	338	finally
    //   213	218	338	finally
    //   65	72	343	finally
    //   75	92	343	finally
    //   95	114	343	finally
    //   114	119	343	finally
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage$Companion;", "", "()V", "HOLDER_PLACE", "", "SET_TOP_PLACE", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "UNSET_TOP_PLACE", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.d
 * JD-Core Version:    0.7.0.1
 */