package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionLogic$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBeforeTimeLimit", "", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "mentionId", "", "limit", "", "types", "", "scene", "getByMentionIdCreateTime", "mentionCreateTime", "getDbSelect", "getLocalFlag", "insertMention", "", "mention", "mentionList", "transformFinderMentionToCovertData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "transformMentionToLocal", "Lcom/tencent/mm/protocal/protobuf/FinderMention;", "plugin-finder_release"})
public final class d$a
{
  private static String En(int paramInt)
  {
    AppMethodBeat.i(203070);
    StringBuilder localStringBuilder = new StringBuilder("SELECT rowid, * FROM ");
    if (Eo(paramInt) == 1) {}
    for (String str = cf.eHq;; str = cf.eHp)
    {
      str = str;
      AppMethodBeat.o(203070);
      return str;
    }
  }
  
  private static int Eo(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 2: 
      return 1;
    }
    return 2;
  }
  
  /* Error */
  public static List<u> a(long paramLong, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    // Byte code:
    //   0: ldc 87
    //   2: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_3
    //   6: ldc 88
    //   8: invokestatic 94	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: ldc 96
    //   13: invokestatic 102	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   16: checkcast 96	com/tencent/mm/plugin/finder/PluginFinder
    //   19: iload 4
    //   21: invokestatic 64	com/tencent/mm/plugin/finder/storage/logic/d$a:Eo	(I)I
    //   24: invokevirtual 106	com/tencent/mm/plugin/finder/PluginFinder:getMentionStorage	(I)Lcom/tencent/mm/sdk/e/j;
    //   27: astore 12
    //   29: invokestatic 110	com/tencent/mm/kernel/g:agR	()Lcom/tencent/mm/kernel/e;
    //   32: astore 10
    //   34: aload 10
    //   36: ldc 112
    //   38: invokestatic 115	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   41: aload 10
    //   43: invokevirtual 121	com/tencent/mm/kernel/e:agA	()Lcom/tencent/mm/storage/ae;
    //   46: getstatic 127	com/tencent/mm/storage/ah$a:GVw	Lcom/tencent/mm/storage/ah$a;
    //   49: iconst_0
    //   50: invokevirtual 133	com/tencent/mm/storage/ae:getInt	(Lcom/tencent/mm/storage/ah$a;I)I
    //   53: istore 7
    //   55: aload_3
    //   56: arraylength
    //   57: ifne +194 -> 251
    //   60: iconst_1
    //   61: istore 5
    //   63: iload 5
    //   65: ifeq +192 -> 257
    //   68: new 55	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   75: iload 4
    //   77: invokestatic 136	com/tencent/mm/plugin/finder/storage/logic/d$a:En	(I)Ljava/lang/String;
    //   80: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 138
    //   85: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: lload_0
    //   89: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   92: bipush 32
    //   94: invokevirtual 144	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   97: ldc 146
    //   99: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload 7
    //   104: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: ldc 151
    //   109: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: iload_2
    //   113: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore_3
    //   120: invokestatic 154	com/tencent/mm/plugin/finder/storage/logic/d:access$getTAG$cp	()Ljava/lang/String;
    //   123: ldc 156
    //   125: aload_3
    //   126: invokestatic 162	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokevirtual 166	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokestatic 171	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 12
    //   137: aload_3
    //   138: iconst_0
    //   139: anewarray 158	java/lang/String
    //   142: invokevirtual 177	com/tencent/mm/sdk/e/j:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   145: astore 11
    //   147: aload 11
    //   149: ifnull +321 -> 470
    //   152: new 179	java/util/LinkedList
    //   155: dup
    //   156: invokespecial 180	java/util/LinkedList:<init>	()V
    //   159: astore_3
    //   160: aload 11
    //   162: checkcast 182	java/io/Closeable
    //   165: astore 12
    //   167: aload 12
    //   169: checkcast 184	android/database/Cursor
    //   172: astore 10
    //   174: aload 10
    //   176: invokeinterface 188 1 0
    //   181: ifeq +259 -> 440
    //   184: ldc 190
    //   186: invokevirtual 196	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   189: checkcast 198	com/tencent/mm/sdk/e/c
    //   192: astore 13
    //   194: aload 13
    //   196: aload 10
    //   198: invokevirtual 202	com/tencent/mm/sdk/e/c:convertFrom	(Landroid/database/Cursor;)V
    //   201: aload_3
    //   202: aload 13
    //   204: invokevirtual 206	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   207: pop
    //   208: goto -34 -> 174
    //   211: astore 10
    //   213: ldc 87
    //   215: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: aload 10
    //   220: athrow
    //   221: astore_3
    //   222: aload 12
    //   224: aload 10
    //   226: invokestatic 211	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   229: ldc 87
    //   231: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_3
    //   235: athrow
    //   236: astore_3
    //   237: aload 11
    //   239: invokeinterface 214 1 0
    //   244: ldc 87
    //   246: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: aload_3
    //   250: athrow
    //   251: iconst_0
    //   252: istore 5
    //   254: goto -191 -> 63
    //   257: ldc 216
    //   259: astore 10
    //   261: iconst_0
    //   262: istore 5
    //   264: aload_3
    //   265: arraylength
    //   266: istore 8
    //   268: iconst_0
    //   269: istore 6
    //   271: iload 6
    //   273: iload 8
    //   275: if_icmpge +80 -> 355
    //   278: aload_3
    //   279: iload 6
    //   281: iaload
    //   282: istore 9
    //   284: aload 10
    //   286: astore 11
    //   288: iload 5
    //   290: ifle +25 -> 315
    //   293: new 55	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   300: aload 10
    //   302: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc 218
    //   307: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: astore 11
    //   315: new 55	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   322: aload 11
    //   324: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: iload 9
    //   329: invokestatic 220	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   332: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: astore 10
    //   340: iload 6
    //   342: iconst_1
    //   343: iadd
    //   344: istore 6
    //   346: iload 5
    //   348: iconst_1
    //   349: iadd
    //   350: istore 5
    //   352: goto -81 -> 271
    //   355: new 55	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   362: aload 10
    //   364: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc 222
    //   369: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: astore_3
    //   376: new 55	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   383: iload 4
    //   385: invokestatic 136	com/tencent/mm/plugin/finder/storage/logic/d$a:En	(I)Ljava/lang/String;
    //   388: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: ldc 138
    //   393: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: lload_0
    //   397: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   400: bipush 32
    //   402: invokevirtual 144	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   405: ldc 224
    //   407: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_3
    //   411: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc 226
    //   416: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: iload 7
    //   421: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   424: ldc 151
    //   426: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: iload_2
    //   430: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   433: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: astore_3
    //   437: goto -317 -> 120
    //   440: getstatic 232	d/y:KTp	Ld/y;
    //   443: astore 10
    //   445: aload 12
    //   447: aconst_null
    //   448: invokestatic 211	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   451: aload_3
    //   452: checkcast 234	java/util/List
    //   455: astore_3
    //   456: aload 11
    //   458: invokeinterface 214 1 0
    //   463: ldc 87
    //   465: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   468: aload_3
    //   469: areturn
    //   470: new 179	java/util/LinkedList
    //   473: dup
    //   474: invokespecial 180	java/util/LinkedList:<init>	()V
    //   477: checkcast 234	java/util/List
    //   480: astore_3
    //   481: goto -25 -> 456
    //   484: astore_3
    //   485: aconst_null
    //   486: astore 10
    //   488: goto -266 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	491	0	paramLong	long
    //   0	491	2	paramInt1	int
    //   0	491	3	paramArrayOfInt	int[]
    //   0	491	4	paramInt2	int
    //   61	290	5	i	int
    //   269	76	6	j	int
    //   53	367	7	k	int
    //   266	10	8	m	int
    //   282	46	9	n	int
    //   32	165	10	localObject1	Object
    //   211	14	10	localThrowable	java.lang.Throwable
    //   259	228	10	localObject2	Object
    //   145	312	11	localObject3	Object
    //   27	419	12	localObject4	Object
    //   192	11	13	localc	c
    // Exception table:
    //   from	to	target	type
    //   167	174	211	java/lang/Throwable
    //   174	208	211	java/lang/Throwable
    //   440	445	211	java/lang/Throwable
    //   213	221	221	finally
    //   152	167	236	finally
    //   222	236	236	finally
    //   445	456	236	finally
    //   470	481	236	finally
    //   167	174	484	finally
    //   174	208	484	finally
    //   440	445	484	finally
  }
  
  /* Error */
  public static u k(long paramLong, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 239
    //   5: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 154	com/tencent/mm/plugin/finder/storage/logic/d:access$getTAG$cp	()Ljava/lang/String;
    //   11: new 55	java/lang/StringBuilder
    //   14: dup
    //   15: ldc 241
    //   17: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: lload_0
    //   21: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: ldc 243
    //   26: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload_2
    //   30: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 171	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: ldc 96
    //   41: invokestatic 102	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   44: checkcast 96	com/tencent/mm/plugin/finder/PluginFinder
    //   47: iload_3
    //   48: invokestatic 64	com/tencent/mm/plugin/finder/storage/logic/d$a:Eo	(I)I
    //   51: invokevirtual 106	com/tencent/mm/plugin/finder/PluginFinder:getMentionStorage	(I)Lcom/tencent/mm/sdk/e/j;
    //   54: astore 4
    //   56: new 55	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   63: iload_3
    //   64: invokestatic 136	com/tencent/mm/plugin/finder/storage/logic/d$a:En	(I)Ljava/lang/String;
    //   67: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 245
    //   72: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: lload_0
    //   76: invokevirtual 141	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   79: ldc 247
    //   81: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload_2
    //   85: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: astore 6
    //   93: invokestatic 154	com/tencent/mm/plugin/finder/storage/logic/d:access$getTAG$cp	()Ljava/lang/String;
    //   96: ldc 156
    //   98: aload 6
    //   100: invokestatic 162	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   103: invokevirtual 166	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   106: invokestatic 250	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload 4
    //   111: aload 6
    //   113: iconst_0
    //   114: anewarray 158	java/lang/String
    //   117: invokevirtual 177	com/tencent/mm/sdk/e/j:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   120: astore 4
    //   122: aload 4
    //   124: ifnull +61 -> 185
    //   127: aload 4
    //   129: checkcast 182	java/io/Closeable
    //   132: astore 6
    //   134: aload 4
    //   136: invokeinterface 188 1 0
    //   141: ifeq +33 -> 174
    //   144: new 190	com/tencent/mm/plugin/finder/storage/u
    //   147: dup
    //   148: invokespecial 251	com/tencent/mm/plugin/finder/storage/u:<init>	()V
    //   151: astore 7
    //   153: aload 7
    //   155: aload 4
    //   157: invokevirtual 252	com/tencent/mm/plugin/finder/storage/u:convertFrom	(Landroid/database/Cursor;)V
    //   160: aload 6
    //   162: aconst_null
    //   163: invokestatic 211	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   166: ldc 239
    //   168: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: aload 7
    //   173: areturn
    //   174: getstatic 232	d/y:KTp	Ld/y;
    //   177: astore 4
    //   179: aload 6
    //   181: aconst_null
    //   182: invokestatic 211	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   185: ldc 239
    //   187: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aconst_null
    //   191: areturn
    //   192: astore 5
    //   194: ldc 239
    //   196: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload 5
    //   201: athrow
    //   202: astore 4
    //   204: aload 6
    //   206: aload 5
    //   208: invokestatic 211	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   211: ldc 239
    //   213: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aload 4
    //   218: athrow
    //   219: astore 4
    //   221: goto -17 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	paramLong	long
    //   0	224	2	paramInt1	int
    //   0	224	3	paramInt2	int
    //   54	124	4	localObject1	Object
    //   202	15	4	localObject2	Object
    //   219	1	4	localObject3	Object
    //   1	1	5	localObject4	Object
    //   192	15	5	localThrowable	java.lang.Throwable
    //   91	114	6	localObject5	Object
    //   151	21	7	localu	u
    // Exception table:
    //   from	to	target	type
    //   134	160	192	java/lang/Throwable
    //   174	179	192	java/lang/Throwable
    //   194	202	202	finally
    //   134	160	219	finally
    //   174	179	219	finally
  }
  
  public static int n(List<u> paramList, int paramInt)
  {
    AppMethodBeat.i(203068);
    k.h(paramList, "mentionList");
    Iterator localIterator = ((Iterable)paramList).iterator();
    int i = 0;
    u localu;
    if (localIterator.hasNext())
    {
      paramList = (u)localIterator.next();
      Object localObject = d.rFp;
      k.h(paramList, "mention");
      localObject = ((PluginFinder)g.ad(PluginFinder.class)).getMentionStorage(Eo(paramInt));
      localu = k(paramList.field_id, paramList.field_createTime, paramInt);
      if (localu != null) {
        ((j)localObject).delete(localu.systemRowid);
      }
      boolean bool = ((j)localObject).insert((c)paramList);
      localObject = d.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder("replace mention success ").append(paramList.field_id).append(", ");
      if (localu == null)
      {
        paramList = "null";
        label154:
        ac.i((String)localObject, paramList + ", " + bool);
        if (!bool) {
          break label224;
        }
        i += 1;
      }
    }
    label224:
    for (;;)
    {
      break;
      paramList = Long.valueOf(localu.systemRowid);
      break label154;
      ac.i(d.access$getTAG$cp(), "insert mention ".concat(String.valueOf(i)));
      AppMethodBeat.o(203068);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.d.a
 * JD-Core Version:    0.7.0.1
 */