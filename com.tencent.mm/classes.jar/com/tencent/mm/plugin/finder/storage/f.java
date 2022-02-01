package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cg;
import com.tencent.mm.plugin.finder.conv.c.a;
import com.tencent.mm.plugin.finder.conv.c.b;
import com.tencent.mm.plugin.finder.conv.d;
import com.tencent.mm.plugin.finder.conv.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "checkOldConv", "", "clearUnreadCount", "sessionId", "", "genSceneTypeIndex", "", "get", "getAliasConvCount", "", "scene", "getGreetConvCount", "getTopPlaceCount", "type", "getUnreadCount", "isExit", "query", "", "offset", "nextCount", "", "queryLimit", "limitCount", "types", "replace", "item", "isNotify", "reportSize", "setEditing", "editing", "setTopPlace", "isTopPlace", "Companion", "plugin-finder_release"})
public final class f
  extends MAutoStorage<d>
{
  public static final a AkC;
  private static final String[] SQL_CREATE;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(268941);
    AkC = new a((byte)0);
    d.a locala = d.xgd;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(d.access$getInfo$cp(), "FinderConversation") };
    AppMethodBeat.o(268941);
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, d.access$getInfo$cp(), "FinderConversation", cg.INDEX_CREATE);
    AppMethodBeat.i(268940);
    this.db = paramISQLiteDatabase;
    this.db.execSQL("FinderConversation", "CREATE INDEX IF NOT EXISTS FinderConversation_type_scene_index ON FinderConversation(scene,type)");
    AppMethodBeat.o(268940);
  }
  
  /* Error */
  private boolean aEH(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 130
    //   5: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc 131
    //   11: invokestatic 106	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   17: lstore_3
    //   18: new 139	java/lang/StringBuilder
    //   21: dup
    //   22: ldc 141
    //   24: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: aload_1
    //   28: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 150
    //   33: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 8
    //   41: aload_0
    //   42: getfield 117	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   45: aload 8
    //   47: aconst_null
    //   48: invokeinterface 158 3 0
    //   53: checkcast 160	java/io/Closeable
    //   56: astore 7
    //   58: aload 7
    //   60: checkcast 162	android/database/Cursor
    //   63: astore_1
    //   64: new 164	com/tencent/mm/plugin/finder/conv/c$a
    //   67: dup
    //   68: invokespecial 166	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   71: astore 9
    //   73: invokestatic 172	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   76: astore 10
    //   78: aload 10
    //   80: ldc 174
    //   82: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   85: aload 10
    //   87: invokevirtual 180	java/lang/Thread:getName	()Ljava/lang/String;
    //   90: astore 10
    //   92: aload 10
    //   94: ldc 182
    //   96: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   99: aload 9
    //   101: aload 10
    //   103: invokevirtual 186	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   106: aload 8
    //   108: invokevirtual 189	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   111: astore 8
    //   113: aload 8
    //   115: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   118: lload_3
    //   119: lsub
    //   120: putfield 193	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   123: aload 8
    //   125: ldc 195
    //   127: invokevirtual 198	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   130: invokevirtual 202	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   133: invokevirtual 207	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   136: aload_1
    //   137: ldc 209
    //   139: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   142: aload_1
    //   143: invokeinterface 213 1 0
    //   148: istore_2
    //   149: iload_2
    //   150: ifle +20 -> 170
    //   153: iconst_1
    //   154: istore 5
    //   156: aload 7
    //   158: aconst_null
    //   159: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   162: ldc 130
    //   164: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: iload 5
    //   169: ireturn
    //   170: iconst_0
    //   171: istore 5
    //   173: goto -17 -> 156
    //   176: astore 6
    //   178: ldc 130
    //   180: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload 6
    //   185: athrow
    //   186: astore_1
    //   187: aload 7
    //   189: aload 6
    //   191: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   194: ldc 130
    //   196: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload_1
    //   200: athrow
    //   201: astore_1
    //   202: goto -15 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	f
    //   0	205	1	paramString	String
    //   148	2	2	i	int
    //   17	102	3	l	long
    //   154	18	5	bool	boolean
    //   1	1	6	localObject1	Object
    //   176	14	6	localThrowable	java.lang.Throwable
    //   56	132	7	localCloseable	java.io.Closeable
    //   39	85	8	localObject2	Object
    //   71	29	9	locala	c.a
    //   76	26	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   58	149	176	java/lang/Throwable
    //   178	186	186	finally
    //   58	149	201	finally
  }
  
  /* Error */
  private final List<d> b(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    // Byte code:
    //   0: ldc 221
    //   2: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 223	java/util/LinkedList
    //   8: dup
    //   9: invokespecial 224	java/util/LinkedList:<init>	()V
    //   12: astore 14
    //   14: aload_0
    //   15: iload 4
    //   17: invokevirtual 228	com/tencent/mm/plugin/finder/storage/f:Qh	(I)I
    //   20: istore 7
    //   22: getstatic 234	com/tencent/mm/plugin/finder/utils/aj:AGc	Lcom/tencent/mm/plugin/finder/utils/aj;
    //   25: astore 12
    //   27: getstatic 240	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   30: invokestatic 244	com/tencent/mm/plugin/finder/utils/aj:r	(Ljava/lang/Boolean;)Ljava/lang/String;
    //   33: astore 15
    //   35: aload_3
    //   36: ifnull +332 -> 368
    //   39: ldc 246
    //   41: astore 12
    //   43: aload_3
    //   44: arraylength
    //   45: istore 8
    //   47: iconst_0
    //   48: istore 5
    //   50: iconst_0
    //   51: istore 6
    //   53: iload 6
    //   55: iload 8
    //   57: if_icmpge +98 -> 155
    //   60: aload_3
    //   61: iload 6
    //   63: iaload
    //   64: istore 9
    //   66: iload 7
    //   68: ifgt +10 -> 78
    //   71: iload 9
    //   73: bipush 100
    //   75: if_icmpeq +447 -> 522
    //   78: new 139	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   85: aload 12
    //   87: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 249
    //   92: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: iload 9
    //   97: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore 13
    //   105: aload 13
    //   107: astore 12
    //   109: iload 5
    //   111: iconst_1
    //   112: iadd
    //   113: aload_3
    //   114: arraylength
    //   115: if_icmpge +25 -> 140
    //   118: new 139	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   125: aload 13
    //   127: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 254
    //   132: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: astore 12
    //   140: iload 6
    //   142: iconst_1
    //   143: iadd
    //   144: istore 6
    //   146: iload 5
    //   148: iconst_1
    //   149: iadd
    //   150: istore 5
    //   152: goto -99 -> 53
    //   155: aload 12
    //   157: ldc 254
    //   159: checkcast 256	java/lang/CharSequence
    //   162: invokestatic 262	kotlin/n/n:c	(Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   165: astore_3
    //   166: new 139	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   173: aload_3
    //   174: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc_w 264
    //   180: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore_3
    //   187: new 139	java/lang/StringBuilder
    //   190: dup
    //   191: ldc_w 266
    //   194: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   197: iload 4
    //   199: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: ldc_w 268
    //   205: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_3
    //   209: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 268
    //   215: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 15
    //   220: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc_w 270
    //   226: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: iload_2
    //   230: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: ldc_w 272
    //   236: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: iload_1
    //   240: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: astore_3
    //   247: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   250: lstore 10
    //   252: aload_0
    //   253: getfield 117	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   256: aload_3
    //   257: aconst_null
    //   258: invokeinterface 158 3 0
    //   263: checkcast 160	java/io/Closeable
    //   266: astore 13
    //   268: aload 13
    //   270: checkcast 162	android/database/Cursor
    //   273: astore 12
    //   275: aload 12
    //   277: invokeinterface 276 1 0
    //   282: ifeq +139 -> 421
    //   285: aload 12
    //   287: ldc_w 278
    //   290: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   293: aload 12
    //   295: invokeinterface 281 1 0
    //   300: ifne +121 -> 421
    //   303: new 77	com/tencent/mm/plugin/finder/conv/d
    //   306: dup
    //   307: invokespecial 282	com/tencent/mm/plugin/finder/conv/d:<init>	()V
    //   310: astore 15
    //   312: aload 15
    //   314: aload 12
    //   316: invokevirtual 286	com/tencent/mm/plugin/finder/conv/d:convertFrom	(Landroid/database/Cursor;)V
    //   319: aload 15
    //   321: invokevirtual 289	com/tencent/mm/plugin/finder/conv/d:prepare	()V
    //   324: aload 14
    //   326: aload 15
    //   328: invokevirtual 293	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   331: pop
    //   332: aload 12
    //   334: invokeinterface 296 1 0
    //   339: pop
    //   340: goto -55 -> 285
    //   343: astore 12
    //   345: ldc 221
    //   347: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   350: aload 12
    //   352: athrow
    //   353: astore_3
    //   354: aload 13
    //   356: aload 12
    //   358: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   361: ldc 221
    //   363: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   366: aload_3
    //   367: athrow
    //   368: new 139	java/lang/StringBuilder
    //   371: dup
    //   372: ldc_w 266
    //   375: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   378: iload 4
    //   380: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   383: ldc_w 268
    //   386: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload 15
    //   391: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: ldc_w 270
    //   397: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: iload_2
    //   401: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   404: ldc_w 272
    //   407: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: iload_1
    //   411: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   414: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: astore_3
    //   418: goto -171 -> 247
    //   421: getstatic 302	kotlin/x:aazN	Lkotlin/x;
    //   424: astore 12
    //   426: aload 13
    //   428: aconst_null
    //   429: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   432: new 164	com/tencent/mm/plugin/finder/conv/c$a
    //   435: dup
    //   436: invokespecial 166	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   439: astore 12
    //   441: invokestatic 172	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   444: astore 13
    //   446: aload 13
    //   448: ldc 174
    //   450: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   453: aload 13
    //   455: invokevirtual 180	java/lang/Thread:getName	()Ljava/lang/String;
    //   458: astore 13
    //   460: aload 13
    //   462: ldc 182
    //   464: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   467: aload 12
    //   469: aload 13
    //   471: invokevirtual 186	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   474: aload_3
    //   475: invokevirtual 189	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   478: astore_3
    //   479: aload_3
    //   480: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   483: lload 10
    //   485: lsub
    //   486: putfield 193	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   489: aload_3
    //   490: ldc_w 304
    //   493: invokevirtual 198	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   496: invokevirtual 202	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   499: invokevirtual 207	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   502: aload 14
    //   504: checkcast 306	java/util/List
    //   507: astore_3
    //   508: ldc 221
    //   510: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   513: aload_3
    //   514: areturn
    //   515: astore_3
    //   516: aconst_null
    //   517: astore 12
    //   519: goto -165 -> 354
    //   522: goto -382 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	525	0	this	f
    //   0	525	1	paramInt1	int
    //   0	525	2	paramInt2	int
    //   0	525	3	paramArrayOfInt	int[]
    //   0	525	4	paramInt3	int
    //   48	103	5	i	int
    //   51	94	6	j	int
    //   20	47	7	k	int
    //   45	13	8	m	int
    //   64	32	9	n	int
    //   250	234	10	l	long
    //   25	308	12	localObject1	Object
    //   343	14	12	localThrowable	java.lang.Throwable
    //   424	94	12	localObject2	Object
    //   103	367	13	localObject3	Object
    //   12	491	14	localLinkedList	LinkedList
    //   33	357	15	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   268	285	343	java/lang/Throwable
    //   285	340	343	java/lang/Throwable
    //   421	426	343	java/lang/Throwable
    //   345	353	353	finally
    //   268	285	515	finally
    //   285	340	515	finally
    //   421	426	515	finally
  }
  
  /* Error */
  public final int Qh(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 311
    //   6: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 139	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 313
    //   16: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: iload_1
    //   20: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: ldc_w 315
    //   26: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore 7
    //   34: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   37: lstore_2
    //   38: aload_0
    //   39: getfield 117	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   42: aload 7
    //   44: aconst_null
    //   45: invokeinterface 158 3 0
    //   50: checkcast 160	java/io/Closeable
    //   53: astore 6
    //   55: aload 6
    //   57: checkcast 162	android/database/Cursor
    //   60: astore 4
    //   62: new 164	com/tencent/mm/plugin/finder/conv/c$a
    //   65: dup
    //   66: invokespecial 166	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   69: astore 8
    //   71: invokestatic 172	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   74: astore 9
    //   76: aload 9
    //   78: ldc 174
    //   80: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   83: aload 9
    //   85: invokevirtual 180	java/lang/Thread:getName	()Ljava/lang/String;
    //   88: astore 9
    //   90: aload 9
    //   92: ldc 182
    //   94: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   97: aload 8
    //   99: aload 9
    //   101: invokevirtual 186	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   104: aload 7
    //   106: invokevirtual 189	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   109: astore 7
    //   111: aload 7
    //   113: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   116: lload_2
    //   117: lsub
    //   118: putfield 193	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   121: aload 7
    //   123: ldc_w 317
    //   126: invokevirtual 198	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   129: invokevirtual 202	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   132: invokevirtual 207	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   135: aload 4
    //   137: invokeinterface 276 1 0
    //   142: ifeq +65 -> 207
    //   145: aload 4
    //   147: iconst_0
    //   148: invokeinterface 320 2 0
    //   153: istore_1
    //   154: getstatic 302	kotlin/x:aazN	Lkotlin/x;
    //   157: astore 4
    //   159: aload 6
    //   161: aconst_null
    //   162: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   165: ldc_w 311
    //   168: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: iload_1
    //   172: ireturn
    //   173: astore 5
    //   175: ldc_w 311
    //   178: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload 5
    //   183: athrow
    //   184: astore 4
    //   186: aload 6
    //   188: aload 5
    //   190: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   193: ldc_w 311
    //   196: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload 4
    //   201: athrow
    //   202: astore 4
    //   204: goto -18 -> 186
    //   207: iconst_0
    //   208: istore_1
    //   209: goto -55 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	f
    //   0	212	1	paramInt	int
    //   37	80	2	l	long
    //   60	98	4	localObject1	Object
    //   184	16	4	localObject2	Object
    //   202	1	4	localObject3	Object
    //   1	1	5	localObject4	Object
    //   173	16	5	localThrowable	java.lang.Throwable
    //   53	134	6	localCloseable	java.io.Closeable
    //   32	90	7	localObject5	Object
    //   69	29	8	locala	c.a
    //   74	26	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   55	154	173	java/lang/Throwable
    //   154	159	173	java/lang/Throwable
    //   175	184	184	finally
    //   55	154	202	finally
    //   154	159	202	finally
  }
  
  public final List<d> a(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(268915);
    List localList = b(paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    Log.i("Finder.ConversationStorage", "[query] offset=" + paramInt1 + " pageCount=" + paramInt2 + " type=" + paramArrayOfInt + " list size=" + localList.size() + ", scene=" + paramInt3);
    AppMethodBeat.o(268915);
    return localList;
  }
  
  public final boolean a(d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(268923);
    Object localObject2 = new StringBuilder("[replace] ");
    if (paramd != null) {}
    for (Object localObject1 = g.b(paramd);; localObject1 = null)
    {
      Log.i("Finder.ConversationStorage", (String)localObject1);
      if (paramd != null) {
        break;
      }
      AppMethodBeat.o(268923);
      return false;
    }
    localObject1 = paramd.convertTo();
    localObject2 = paramd.field_sessionId;
    p.j(localObject2, "item.field_sessionId");
    boolean bool;
    if (aEH((String)localObject2)) {
      if (this.db.update(getTableName(), (ContentValues)localObject1, "sessionId = ?", new String[] { paramd.field_sessionId }) > 0) {
        bool = true;
      }
    }
    for (;;)
    {
      if ((bool) && (paramBoolean)) {
        doNotify(paramd.field_sessionId);
      }
      AppMethodBeat.o(268923);
      return bool;
      bool = false;
      continue;
      bool = super.insertNotify((IAutoDBItem)paramd, false);
    }
  }
  
  public final d aEG(String paramString)
  {
    AppMethodBeat.i(268917);
    p.k(paramString, "sessionId");
    long l = SystemClock.uptimeMillis();
    String str = "select *, rowid from FinderConversation where sessionId = '" + paramString + "' ";
    Object localObject = this.db.rawQuery(str, null);
    d locald = new d();
    locald.field_sessionId = paramString;
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        locald.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    paramString = new c.a();
    localObject = Thread.currentThread();
    p.j(localObject, "Thread.currentThread()");
    localObject = ((Thread)localObject).getName();
    p.j(localObject, "Thread.currentThread().name");
    paramString = paramString.aAY((String)localObject).aAX(str);
    paramString.duration = (SystemClock.uptimeMillis() - l);
    paramString.aAW("FinderConversationStorage.get").dpk().report();
    AppMethodBeat.o(268917);
    return locald;
  }
  
  public final boolean aEI(String paramString)
  {
    AppMethodBeat.i(268935);
    p.k(paramString, "sessionId");
    if (((CharSequence)paramString).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(268935);
      return false;
    }
    d locald = aEG(paramString);
    i = locald.field_unReadCount;
    locald.field_unReadCount = 0;
    locald.field_readStatus = 1;
    boolean bool = update(locald.systemRowid, (IAutoDBItem)locald);
    doNotify(locald.field_sessionId, 5, locald);
    Log.i("Finder.ConversationStorage", "[clearUnreadCount] ret=" + bool + ' ' + i + " => " + locald.field_unReadCount + " sessionId=" + paramString);
    AppMethodBeat.o(268935);
    return bool;
  }
  
  /* Error */
  public final int aEz(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 431
    //   6: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: ldc 131
    //   12: invokestatic 106	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   18: lstore_3
    //   19: ldc_w 433
    //   22: aload_1
    //   23: invokestatic 437	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: invokevirtual 441	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore 7
    //   31: aload_0
    //   32: getfield 117	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   35: aload 7
    //   37: aconst_null
    //   38: invokeinterface 158 3 0
    //   43: checkcast 160	java/io/Closeable
    //   46: astore 6
    //   48: aload 6
    //   50: checkcast 162	android/database/Cursor
    //   53: astore 8
    //   55: aload 8
    //   57: invokeinterface 276 1 0
    //   62: ifeq +185 -> 247
    //   65: aload 8
    //   67: ldc_w 278
    //   70: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   73: aload 8
    //   75: invokeinterface 281 1 0
    //   80: ifne +167 -> 247
    //   83: aload 8
    //   85: iconst_1
    //   86: invokeinterface 320 2 0
    //   91: istore_2
    //   92: getstatic 302	kotlin/x:aazN	Lkotlin/x;
    //   95: astore 8
    //   97: aload 6
    //   99: aconst_null
    //   100: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   103: new 164	com/tencent/mm/plugin/finder/conv/c$a
    //   106: dup
    //   107: invokespecial 166	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   110: astore 5
    //   112: invokestatic 172	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   115: astore 6
    //   117: aload 6
    //   119: ldc 174
    //   121: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   124: aload 6
    //   126: invokevirtual 180	java/lang/Thread:getName	()Ljava/lang/String;
    //   129: astore 6
    //   131: aload 6
    //   133: ldc 182
    //   135: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   138: aload 5
    //   140: aload 6
    //   142: invokevirtual 186	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   145: aload 7
    //   147: invokevirtual 189	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   150: astore 5
    //   152: aload 5
    //   154: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   157: lload_3
    //   158: lsub
    //   159: putfield 193	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   162: aload 5
    //   164: ldc_w 443
    //   167: invokevirtual 198	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   170: invokevirtual 202	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   173: invokevirtual 207	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   176: ldc_w 325
    //   179: new 139	java/lang/StringBuilder
    //   182: dup
    //   183: ldc_w 445
    //   186: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: aload_1
    //   190: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: bipush 32
    //   195: invokevirtual 424	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   198: iload_2
    //   199: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: ldc_w 431
    //   211: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: iload_2
    //   215: ireturn
    //   216: astore 5
    //   218: ldc_w 431
    //   221: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: aload 5
    //   226: athrow
    //   227: astore_1
    //   228: aload 6
    //   230: aload 5
    //   232: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   235: ldc_w 431
    //   238: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aload_1
    //   242: athrow
    //   243: astore_1
    //   244: goto -16 -> 228
    //   247: iconst_0
    //   248: istore_2
    //   249: goto -157 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	f
    //   0	252	1	paramString	String
    //   91	158	2	i	int
    //   18	140	3	l	long
    //   1	162	5	locala	c.a
    //   216	15	5	localThrowable	java.lang.Throwable
    //   46	183	6	localObject1	Object
    //   29	117	7	str	String
    //   53	43	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   48	92	216	java/lang/Throwable
    //   92	97	216	java/lang/Throwable
    //   218	227	227	finally
    //   48	92	243	finally
    //   92	97	243	finally
  }
  
  /* Error */
  public final boolean bvQ()
  {
    // Byte code:
    //   0: ldc_w 449
    //   3: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 325
    //   9: ldc_w 451
    //   12: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: new 223	java/util/LinkedList
    //   18: dup
    //   19: invokespecial 224	java/util/LinkedList:<init>	()V
    //   22: astore 9
    //   24: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   27: lstore_2
    //   28: aload_0
    //   29: getfield 117	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   32: ldc_w 453
    //   35: aconst_null
    //   36: invokeinterface 158 3 0
    //   41: checkcast 160	java/io/Closeable
    //   44: astore 11
    //   46: aconst_null
    //   47: astore 10
    //   49: aload 11
    //   51: checkcast 162	android/database/Cursor
    //   54: astore 12
    //   56: new 164	com/tencent/mm/plugin/finder/conv/c$a
    //   59: dup
    //   60: invokespecial 166	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   63: astore 13
    //   65: invokestatic 172	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   68: astore 14
    //   70: aload 14
    //   72: ldc 174
    //   74: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   77: aload 14
    //   79: invokevirtual 180	java/lang/Thread:getName	()Ljava/lang/String;
    //   82: astore 14
    //   84: aload 14
    //   86: ldc 182
    //   88: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   91: aload 13
    //   93: aload 14
    //   95: invokevirtual 186	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   98: ldc_w 453
    //   101: invokevirtual 189	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   104: astore 13
    //   106: aload 13
    //   108: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   111: lload_2
    //   112: lsub
    //   113: putfield 193	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   116: aload 13
    //   118: ldc_w 455
    //   121: invokevirtual 198	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   124: invokevirtual 202	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   127: invokevirtual 207	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   130: aload 12
    //   132: invokeinterface 296 1 0
    //   137: ifeq +59 -> 196
    //   140: new 77	com/tencent/mm/plugin/finder/conv/d
    //   143: dup
    //   144: invokespecial 282	com/tencent/mm/plugin/finder/conv/d:<init>	()V
    //   147: astore 13
    //   149: aload 13
    //   151: aload 12
    //   153: invokevirtual 286	com/tencent/mm/plugin/finder/conv/d:convertFrom	(Landroid/database/Cursor;)V
    //   156: aload 9
    //   158: aload 13
    //   160: invokevirtual 293	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   163: pop
    //   164: goto -34 -> 130
    //   167: astore 10
    //   169: ldc_w 449
    //   172: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload 10
    //   177: athrow
    //   178: astore 9
    //   180: aload 11
    //   182: aload 10
    //   184: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   187: ldc_w 449
    //   190: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: aload 9
    //   195: athrow
    //   196: getstatic 302	kotlin/x:aazN	Lkotlin/x;
    //   199: astore 12
    //   201: aload 11
    //   203: aconst_null
    //   204: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   207: ldc_w 325
    //   210: new 139	java/lang/StringBuilder
    //   213: dup
    //   214: ldc_w 457
    //   217: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   220: aload 9
    //   222: invokevirtual 458	java/util/LinkedList:size	()I
    //   225: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: invokestatic 463	com/tencent/mm/model/z:bcZ	()Ljava/lang/String;
    //   237: astore 11
    //   239: invokestatic 466	com/tencent/mm/model/z:bdh	()Ljava/lang/String;
    //   242: astore 12
    //   244: iconst_0
    //   245: istore 7
    //   247: aload_0
    //   248: getfield 117	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   251: astore 10
    //   253: aload 10
    //   255: ifnonnull +24 -> 279
    //   258: new 468	kotlin/t
    //   261: dup
    //   262: ldc_w 470
    //   265: invokespecial 471	kotlin/t:<init>	(Ljava/lang/String;)V
    //   268: astore 9
    //   270: ldc_w 449
    //   273: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload 9
    //   278: athrow
    //   279: aload 10
    //   281: checkcast 473	com/tencent/mm/storagebase/h
    //   284: invokevirtual 476	com/tencent/mm/storagebase/h:bLA	()J
    //   287: lstore_2
    //   288: iconst_1
    //   289: istore 6
    //   291: new 478	kotlin/g/b/aa$d
    //   294: dup
    //   295: invokespecial 479	kotlin/g/b/aa$d:<init>	()V
    //   298: astore 10
    //   300: aload 10
    //   302: iconst_0
    //   303: putfield 482	kotlin/g/b/aa$d:aaBA	I
    //   306: invokestatic 487	java/lang/System:currentTimeMillis	()J
    //   309: lstore 4
    //   311: aload 9
    //   313: checkcast 489	java/lang/Iterable
    //   316: invokeinterface 493 1 0
    //   321: astore 13
    //   323: aload 13
    //   325: invokeinterface 498 1 0
    //   330: ifeq +270 -> 600
    //   333: aload 13
    //   335: invokeinterface 502 1 0
    //   340: checkcast 77	com/tencent/mm/plugin/finder/conv/d
    //   343: astore 14
    //   345: aload 14
    //   347: getfield 505	com/tencent/mm/plugin/finder/conv/d:field_senderUserName	Ljava/lang/String;
    //   350: checkcast 256	java/lang/CharSequence
    //   353: astore 15
    //   355: aload 15
    //   357: ifnull +696 -> 1053
    //   360: aload 15
    //   362: invokeinterface 398 1 0
    //   367: ifne +707 -> 1074
    //   370: goto +683 -> 1053
    //   373: iload_1
    //   374: ifeq +676 -> 1050
    //   377: aload 14
    //   379: getfield 508	com/tencent/mm/plugin/finder/conv/d:field_talker	Ljava/lang/String;
    //   382: invokestatic 513	com/tencent/mm/storage/as:bvP	(Ljava/lang/String;)Z
    //   385: ifeq +107 -> 492
    //   388: aload 14
    //   390: aload 11
    //   392: putfield 505	com/tencent/mm/plugin/finder/conv/d:field_senderUserName	Ljava/lang/String;
    //   395: aload 14
    //   397: iconst_1
    //   398: putfield 516	com/tencent/mm/plugin/finder/conv/d:field_senderRoleType	I
    //   401: new 139	java/lang/StringBuilder
    //   404: dup
    //   405: ldc_w 518
    //   408: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   411: aload 14
    //   413: getfield 505	com/tencent/mm/plugin/finder/conv/d:field_senderUserName	Ljava/lang/String;
    //   416: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: ldc_w 520
    //   422: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 14
    //   427: getfield 516	com/tencent/mm/plugin/finder/conv/d:field_senderRoleType	I
    //   430: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   433: ldc_w 522
    //   436: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 14
    //   441: getfield 508	com/tencent/mm/plugin/finder/conv/d:field_talker	Ljava/lang/String;
    //   444: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: ldc 150
    //   449: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: astore 14
    //   457: aload_0
    //   458: getfield 117	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   461: ldc 89
    //   463: aload 14
    //   465: invokeinterface 125 3 0
    //   470: istore 8
    //   472: iload 8
    //   474: ifne +584 -> 1058
    //   477: aload 10
    //   479: aload 10
    //   481: getfield 482	kotlin/g/b/aa$d:aaBA	I
    //   484: iconst_1
    //   485: iadd
    //   486: putfield 482	kotlin/g/b/aa$d:aaBA	I
    //   489: goto +569 -> 1058
    //   492: aload 14
    //   494: aload 12
    //   496: putfield 505	com/tencent/mm/plugin/finder/conv/d:field_senderUserName	Ljava/lang/String;
    //   499: aload 14
    //   501: iconst_3
    //   502: putfield 516	com/tencent/mm/plugin/finder/conv/d:field_senderRoleType	I
    //   505: goto -104 -> 401
    //   508: astore 11
    //   510: ldc_w 325
    //   513: new 139	java/lang/StringBuilder
    //   516: dup
    //   517: ldc_w 524
    //   520: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   523: aload 11
    //   525: invokevirtual 527	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   528: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   537: getstatic 533	com/tencent/mm/plugin/findersdk/b:BuZ	Lcom/tencent/mm/plugin/findersdk/b;
    //   540: ldc_w 534
    //   543: iconst_0
    //   544: iconst_0
    //   545: new 10	com/tencent/mm/plugin/finder/storage/f$b
    //   548: dup
    //   549: aload 11
    //   551: invokespecial 537	com/tencent/mm/plugin/finder/storage/f$b:<init>	(Ljava/lang/Exception;)V
    //   554: checkcast 539	kotlin/g/a/a
    //   557: bipush 12
    //   559: invokestatic 544	com/tencent/mm/ae/f$a:a	(Lcom/tencent/mm/ae/f;Ljava/lang/String;ZZLkotlin/g/a/a;I)V
    //   562: aload_0
    //   563: getfield 117	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   566: astore 11
    //   568: aload 11
    //   570: ifnonnull +249 -> 819
    //   573: new 468	kotlin/t
    //   576: dup
    //   577: ldc_w 470
    //   580: invokespecial 471	kotlin/t:<init>	(Ljava/lang/String;)V
    //   583: astore 9
    //   585: ldc_w 449
    //   588: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   591: aload 9
    //   593: athrow
    //   594: iconst_0
    //   595: istore 6
    //   597: goto +474 -> 1071
    //   600: aload_0
    //   601: getfield 117	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   604: astore 11
    //   606: aload 11
    //   608: ifnonnull +24 -> 632
    //   611: new 468	kotlin/t
    //   614: dup
    //   615: ldc_w 470
    //   618: invokespecial 471	kotlin/t:<init>	(Ljava/lang/String;)V
    //   621: astore 9
    //   623: ldc_w 449
    //   626: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   629: aload 9
    //   631: athrow
    //   632: aload 11
    //   634: checkcast 473	com/tencent/mm/storagebase/h
    //   637: lload_2
    //   638: invokevirtual 548	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   641: pop
    //   642: new 164	com/tencent/mm/plugin/finder/conv/c$a
    //   645: dup
    //   646: invokespecial 166	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   649: astore 11
    //   651: invokestatic 172	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   654: astore 12
    //   656: aload 12
    //   658: ldc 174
    //   660: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   663: aload 12
    //   665: invokevirtual 180	java/lang/Thread:getName	()Ljava/lang/String;
    //   668: astore 12
    //   670: aload 12
    //   672: ldc 182
    //   674: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   677: aload 11
    //   679: aload 12
    //   681: invokevirtual 186	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   684: ldc_w 550
    //   687: invokevirtual 189	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   690: astore 11
    //   692: aload 11
    //   694: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   697: lload 4
    //   699: lsub
    //   700: putfield 193	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   703: aload 11
    //   705: ldc_w 552
    //   708: invokevirtual 198	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   711: invokevirtual 202	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   714: invokevirtual 207	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   717: ldc_w 325
    //   720: new 139	java/lang/StringBuilder
    //   723: dup
    //   724: ldc_w 554
    //   727: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   730: aload 9
    //   732: invokevirtual 458	java/util/LinkedList:size	()I
    //   735: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   738: ldc_w 556
    //   741: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: aload 10
    //   746: getfield 482	kotlin/g/b/aa$d:aaBA	I
    //   749: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   752: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   758: getstatic 533	com/tencent/mm/plugin/findersdk/b:BuZ	Lcom/tencent/mm/plugin/findersdk/b;
    //   761: astore 11
    //   763: aload 10
    //   765: getfield 482	kotlin/g/b/aa$d:aaBA	I
    //   768: ifne +271 -> 1039
    //   771: iconst_1
    //   772: istore 7
    //   774: aload 11
    //   776: ldc_w 558
    //   779: iload 7
    //   781: iconst_0
    //   782: new 12	com/tencent/mm/plugin/finder/storage/f$c
    //   785: dup
    //   786: aload 9
    //   788: aload 10
    //   790: invokespecial 561	com/tencent/mm/plugin/finder/storage/f$c:<init>	(Ljava/util/LinkedList;Lkotlin/g/b/aa$d;)V
    //   793: checkcast 539	kotlin/g/a/a
    //   796: bipush 12
    //   798: invokestatic 544	com/tencent/mm/ae/f$a:a	(Lcom/tencent/mm/ae/f;Ljava/lang/String;ZZLkotlin/g/a/a;I)V
    //   801: ldc_w 325
    //   804: ldc_w 563
    //   807: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   810: ldc_w 449
    //   813: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   816: iload 6
    //   818: ireturn
    //   819: aload 11
    //   821: checkcast 473	com/tencent/mm/storagebase/h
    //   824: lload_2
    //   825: invokevirtual 548	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   828: pop
    //   829: new 164	com/tencent/mm/plugin/finder/conv/c$a
    //   832: dup
    //   833: invokespecial 166	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   836: astore 11
    //   838: invokestatic 172	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   841: astore 12
    //   843: aload 12
    //   845: ldc 174
    //   847: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   850: aload 12
    //   852: invokevirtual 180	java/lang/Thread:getName	()Ljava/lang/String;
    //   855: astore 12
    //   857: aload 12
    //   859: ldc 182
    //   861: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   864: aload 11
    //   866: aload 12
    //   868: invokevirtual 186	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   871: ldc_w 550
    //   874: invokevirtual 189	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   877: astore 11
    //   879: aload 11
    //   881: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   884: lload 4
    //   886: lsub
    //   887: putfield 193	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   890: aload 11
    //   892: ldc_w 552
    //   895: invokevirtual 198	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   898: invokevirtual 202	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   901: invokevirtual 207	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   904: iload 7
    //   906: istore 6
    //   908: goto -191 -> 717
    //   911: astore 9
    //   913: aload_0
    //   914: getfield 117	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   917: astore 10
    //   919: aload 10
    //   921: ifnonnull +24 -> 945
    //   924: new 468	kotlin/t
    //   927: dup
    //   928: ldc_w 470
    //   931: invokespecial 471	kotlin/t:<init>	(Ljava/lang/String;)V
    //   934: astore 9
    //   936: ldc_w 449
    //   939: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   942: aload 9
    //   944: athrow
    //   945: aload 10
    //   947: checkcast 473	com/tencent/mm/storagebase/h
    //   950: lload_2
    //   951: invokevirtual 548	com/tencent/mm/storagebase/h:endTransaction	(J)I
    //   954: pop
    //   955: new 164	com/tencent/mm/plugin/finder/conv/c$a
    //   958: dup
    //   959: invokespecial 166	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   962: astore 10
    //   964: invokestatic 172	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   967: astore 11
    //   969: aload 11
    //   971: ldc 174
    //   973: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   976: aload 11
    //   978: invokevirtual 180	java/lang/Thread:getName	()Ljava/lang/String;
    //   981: astore 11
    //   983: aload 11
    //   985: ldc 182
    //   987: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   990: aload 10
    //   992: aload 11
    //   994: invokevirtual 186	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   997: ldc_w 550
    //   1000: invokevirtual 189	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   1003: astore 10
    //   1005: aload 10
    //   1007: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   1010: lload 4
    //   1012: lsub
    //   1013: putfield 193	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   1016: aload 10
    //   1018: ldc_w 552
    //   1021: invokevirtual 198	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   1024: invokevirtual 202	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   1027: invokevirtual 207	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   1030: ldc_w 449
    //   1033: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1036: aload 9
    //   1038: athrow
    //   1039: iconst_0
    //   1040: istore 7
    //   1042: goto -268 -> 774
    //   1045: astore 9
    //   1047: goto -867 -> 180
    //   1050: goto +21 -> 1071
    //   1053: iconst_1
    //   1054: istore_1
    //   1055: goto -682 -> 373
    //   1058: iload 6
    //   1060: ifeq -466 -> 594
    //   1063: iload 8
    //   1065: ifeq -471 -> 594
    //   1068: iconst_1
    //   1069: istore 6
    //   1071: goto -748 -> 323
    //   1074: iconst_0
    //   1075: istore_1
    //   1076: goto -703 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1079	0	this	f
    //   373	703	1	i	int
    //   27	924	2	l1	long
    //   309	702	4	l2	long
    //   289	781	6	bool1	boolean
    //   245	796	7	bool2	boolean
    //   470	594	8	bool3	boolean
    //   22	135	9	localLinkedList	LinkedList
    //   178	43	9	localObject1	Object
    //   268	519	9	localt1	kotlin.t
    //   911	1	9	localObject2	Object
    //   934	103	9	localt2	kotlin.t
    //   1045	1	9	localObject3	Object
    //   47	1	10	localObject4	Object
    //   167	16	10	localThrowable	java.lang.Throwable
    //   251	766	10	localObject5	Object
    //   44	347	11	localObject6	Object
    //   508	42	11	localException	Exception
    //   566	427	11	localObject7	Object
    //   54	813	12	localObject8	Object
    //   63	271	13	localObject9	Object
    //   68	432	14	localObject10	Object
    //   353	8	15	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   49	130	167	java/lang/Throwable
    //   130	164	167	java/lang/Throwable
    //   196	201	167	java/lang/Throwable
    //   169	178	178	finally
    //   311	323	508	java/lang/Exception
    //   323	355	508	java/lang/Exception
    //   360	370	508	java/lang/Exception
    //   377	401	508	java/lang/Exception
    //   401	472	508	java/lang/Exception
    //   477	489	508	java/lang/Exception
    //   492	505	508	java/lang/Exception
    //   311	323	911	finally
    //   323	355	911	finally
    //   360	370	911	finally
    //   377	401	911	finally
    //   401	472	911	finally
    //   477	489	911	finally
    //   492	505	911	finally
    //   510	562	911	finally
    //   49	130	1045	finally
    //   130	164	1045	finally
    //   196	201	1045	finally
  }
  
  public final boolean by(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(268936);
    p.k(paramString, "sessionId");
    d locald = aEG(paramString);
    boolean bool1 = locald.dpl();
    long l;
    boolean bool2;
    if (paramBoolean)
    {
      l = 1L;
      locald.field_placedFlag = l;
      bool2 = update(locald.systemRowid, (IAutoDBItem)locald, false);
      if (!paramBoolean) {
        break label145;
      }
      doNotify(locald.field_sessionId, 3, locald);
    }
    for (;;)
    {
      Log.i("Finder.ConversationStorage", "[setTopPlace] ret=" + bool2 + " isTopPlace=" + bool1 + " => " + locald.dpl() + " sessionId=" + paramString);
      AppMethodBeat.o(268936);
      return bool2;
      l = 0L;
      break;
      label145:
      doNotify(locald.field_sessionId, 4, locald);
    }
  }
  
  /* Error */
  public final int dYl()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 581
    //   6: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   12: lstore_2
    //   13: new 139	java/lang/StringBuilder
    //   16: dup
    //   17: ldc_w 583
    //   20: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: astore 7
    //   28: aload_0
    //   29: getfield 117	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   32: aload 7
    //   34: aconst_null
    //   35: invokeinterface 158 3 0
    //   40: checkcast 160	java/io/Closeable
    //   43: astore 6
    //   45: aload 6
    //   47: checkcast 162	android/database/Cursor
    //   50: astore 4
    //   52: new 164	com/tencent/mm/plugin/finder/conv/c$a
    //   55: dup
    //   56: invokespecial 166	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   59: astore 8
    //   61: invokestatic 172	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   64: astore 9
    //   66: aload 9
    //   68: ldc 174
    //   70: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   73: aload 9
    //   75: invokevirtual 180	java/lang/Thread:getName	()Ljava/lang/String;
    //   78: astore 9
    //   80: aload 9
    //   82: ldc 182
    //   84: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   87: aload 8
    //   89: aload 9
    //   91: invokevirtual 186	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   94: aload 7
    //   96: invokevirtual 189	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   99: astore 7
    //   101: aload 7
    //   103: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   106: lload_2
    //   107: lsub
    //   108: putfield 193	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   111: aload 7
    //   113: ldc_w 585
    //   116: invokevirtual 198	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   119: invokevirtual 202	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   122: invokevirtual 207	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   125: aload 4
    //   127: invokeinterface 276 1 0
    //   132: ifeq +65 -> 197
    //   135: aload 4
    //   137: iconst_0
    //   138: invokeinterface 320 2 0
    //   143: istore_1
    //   144: getstatic 302	kotlin/x:aazN	Lkotlin/x;
    //   147: astore 4
    //   149: aload 6
    //   151: aconst_null
    //   152: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   155: ldc_w 581
    //   158: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: iload_1
    //   162: ireturn
    //   163: astore 5
    //   165: ldc_w 581
    //   168: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload 5
    //   173: athrow
    //   174: astore 4
    //   176: aload 6
    //   178: aload 5
    //   180: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   183: ldc_w 581
    //   186: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload 4
    //   191: athrow
    //   192: astore 4
    //   194: goto -18 -> 176
    //   197: iconst_0
    //   198: istore_1
    //   199: goto -55 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	f
    //   143	56	1	i	int
    //   12	95	2	l	long
    //   50	98	4	localObject1	Object
    //   174	16	4	localObject2	Object
    //   192	1	4	localObject3	Object
    //   1	1	5	localObject4	Object
    //   163	16	5	localThrowable	java.lang.Throwable
    //   43	134	6	localCloseable	java.io.Closeable
    //   26	86	7	localObject5	Object
    //   59	29	8	locala	c.a
    //   64	26	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   45	144	163	java/lang/Throwable
    //   144	149	163	java/lang/Throwable
    //   165	174	174	finally
    //   45	144	192	finally
    //   144	149	192	finally
  }
  
  /* Error */
  public final int gV(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc_w 588
    //   6: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: iload_2
    //   10: iflt +222 -> 232
    //   13: new 139	java/lang/StringBuilder
    //   16: dup
    //   17: ldc_w 590
    //   20: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: iload_2
    //   24: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: ldc_w 592
    //   30: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: iload_1
    //   34: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore 5
    //   42: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   45: lstore_3
    //   46: aload_0
    //   47: getfield 117	com/tencent/mm/plugin/finder/storage/f:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   50: aload 5
    //   52: aconst_null
    //   53: invokeinterface 158 3 0
    //   58: checkcast 160	java/io/Closeable
    //   61: astore 7
    //   63: aload 7
    //   65: checkcast 162	android/database/Cursor
    //   68: astore 8
    //   70: aload 8
    //   72: invokeinterface 276 1 0
    //   77: ifeq +204 -> 281
    //   80: aload 8
    //   82: ldc_w 278
    //   85: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   88: aload 8
    //   90: invokeinterface 281 1 0
    //   95: ifne +186 -> 281
    //   98: aload 8
    //   100: iconst_0
    //   101: invokeinterface 320 2 0
    //   106: istore_1
    //   107: getstatic 302	kotlin/x:aazN	Lkotlin/x;
    //   110: astore 8
    //   112: aload 7
    //   114: aconst_null
    //   115: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   118: new 164	com/tencent/mm/plugin/finder/conv/c$a
    //   121: dup
    //   122: invokespecial 166	com/tencent/mm/plugin/finder/conv/c$a:<init>	()V
    //   125: astore 6
    //   127: invokestatic 172	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   130: astore 7
    //   132: aload 7
    //   134: ldc 174
    //   136: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   139: aload 7
    //   141: invokevirtual 180	java/lang/Thread:getName	()Ljava/lang/String;
    //   144: astore 7
    //   146: aload 7
    //   148: ldc 182
    //   150: invokestatic 177	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   153: aload 6
    //   155: aload 7
    //   157: invokevirtual 186	com/tencent/mm/plugin/finder/conv/c$a:aAY	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   160: aload 5
    //   162: invokevirtual 189	com/tencent/mm/plugin/finder/conv/c$a:aAX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   165: astore 5
    //   167: aload 5
    //   169: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   172: lload_3
    //   173: lsub
    //   174: putfield 193	com/tencent/mm/plugin/finder/conv/c$a:duration	J
    //   177: aload 5
    //   179: ldc_w 594
    //   182: invokevirtual 198	com/tencent/mm/plugin/finder/conv/c$a:aAW	(Ljava/lang/String;)Lcom/tencent/mm/plugin/finder/conv/c$a;
    //   185: invokevirtual 202	com/tencent/mm/plugin/finder/conv/c$a:dpk	()Lcom/tencent/mm/plugin/finder/conv/c$b;
    //   188: invokevirtual 207	com/tencent/mm/plugin/finder/conv/c$b:report	()V
    //   191: ldc_w 325
    //   194: new 139	java/lang/StringBuilder
    //   197: dup
    //   198: ldc_w 596
    //   201: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   204: iload_2
    //   205: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   208: ldc_w 598
    //   211: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload_1
    //   215: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: ldc_w 588
    //   227: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: iload_1
    //   231: ireturn
    //   232: ldc_w 600
    //   235: iload_1
    //   236: invokestatic 603	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   239: invokevirtual 441	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   242: astore 5
    //   244: goto -202 -> 42
    //   247: astore 6
    //   249: ldc_w 588
    //   252: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: aload 6
    //   257: athrow
    //   258: astore 5
    //   260: aload 7
    //   262: aload 6
    //   264: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   267: ldc_w 588
    //   270: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   273: aload 5
    //   275: athrow
    //   276: astore 5
    //   278: goto -18 -> 260
    //   281: iconst_0
    //   282: istore_1
    //   283: goto -176 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	f
    //   0	286	1	paramInt1	int
    //   0	286	2	paramInt2	int
    //   45	128	3	l	long
    //   40	203	5	localObject1	Object
    //   258	16	5	localObject2	Object
    //   276	1	5	localObject3	Object
    //   1	153	6	locala	c.a
    //   247	16	6	localThrowable	java.lang.Throwable
    //   61	200	7	localObject4	Object
    //   68	43	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   63	107	247	java/lang/Throwable
    //   107	112	247	java/lang/Throwable
    //   249	258	258	finally
    //   63	107	276	finally
    //   107	112	276	finally
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage$Companion;", "", "()V", "HOLDER_PLACE", "", "SET_TOP_PLACE", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "TAG", "UNSET_TOP_PLACE", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<String>
  {
    b(Exception paramException)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<String>
  {
    c(LinkedList paramLinkedList, aa.d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.f
 * JD-Core Version:    0.7.0.1
 */