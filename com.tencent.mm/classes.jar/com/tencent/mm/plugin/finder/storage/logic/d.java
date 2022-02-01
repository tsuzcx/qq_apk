package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class d
{
  private static final String TAG = "Finder.FinderMentionLogic";
  public static final a qKK;
  
  static
  {
    AppMethodBeat.i(167113);
    qKK = new a((byte)0);
    TAG = "Finder.FinderMentionLogic";
    AppMethodBeat.o(167113);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionLogic$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBeforeTimeLimit", "", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "mentionId", "", "limit", "", "types", "", "scene", "getByMentionId", "getDbSelect", "getLocalFlag", "insertMention", "", "mention", "mentionList", "isMentionExists", "replaceMention", "transformFinderMentionToCovertData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "transformMentionToLocal", "Lcom/tencent/mm/protocal/protobuf/FinderMention;", "plugin-finder_release"})
  public static final class a
  {
    public static int E(List<com.tencent.mm.plugin.finder.storage.l> paramList, int paramInt)
    {
      AppMethodBeat.i(199098);
      k.h(paramList, "mentionList");
      Iterator localIterator = ((Iterable)paramList).iterator();
      int i = 0;
      Object localObject;
      com.tencent.mm.plugin.finder.storage.l locall;
      boolean bool;
      if (localIterator.hasNext())
      {
        paramList = (com.tencent.mm.plugin.finder.storage.l)localIterator.next();
        localObject = d.qKK;
        k.h(paramList, "mention");
        k.h(paramList, "mention");
        localObject = ((PluginFinder)g.ad(PluginFinder.class)).getMentionStorage(ahC(paramInt));
        locall = an(paramList.field_id, paramInt);
        if (locall != null)
        {
          paramList.systemRowid = locall.systemRowid;
          bool = ((j)localObject).update(paramList.systemRowid, (c)paramList);
          label117:
          localObject = d.access$getTAG$cp();
          StringBuilder localStringBuilder = new StringBuilder("replace mention success ").append(paramList.field_id).append(", ");
          if (locall != null) {
            break label200;
          }
          paramList = "null";
          label153:
          ad.i((String)localObject, paramList + ", " + bool);
          if (!bool) {
            break label234;
          }
          i += 1;
        }
      }
      label200:
      label234:
      for (;;)
      {
        break;
        bool = ((j)localObject).insert((c)paramList);
        break label117;
        paramList = Long.valueOf(locall.systemRowid);
        break label153;
        ad.i(d.access$getTAG$cp(), "insert mention ".concat(String.valueOf(i)));
        AppMethodBeat.o(199098);
        return i;
      }
    }
    
    /* Error */
    public static List<com.tencent.mm.plugin.finder.storage.l> a(long paramLong, int paramInt1, int[] paramArrayOfInt, int paramInt2)
    {
      // Byte code:
      //   0: ldc 184
      //   2: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_3
      //   6: ldc 185
      //   8: invokestatic 61	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   11: ldc 86
      //   13: invokestatic 92	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   16: checkcast 86	com/tencent/mm/plugin/finder/PluginFinder
      //   19: iload 4
      //   21: invokestatic 96	com/tencent/mm/plugin/finder/storage/logic/d$a:ahC	(I)I
      //   24: invokevirtual 100	com/tencent/mm/plugin/finder/PluginFinder:getMentionStorage	(I)Lcom/tencent/mm/sdk/e/j;
      //   27: astore 12
      //   29: invokestatic 189	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
      //   32: astore 10
      //   34: aload 10
      //   36: ldc 191
      //   38: invokestatic 194	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   41: aload 10
      //   43: invokevirtual 200	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
      //   46: getstatic 206	com/tencent/mm/storage/ae$a:Fxg	Lcom/tencent/mm/storage/ae$a;
      //   49: iconst_0
      //   50: invokevirtual 212	com/tencent/mm/storage/ab:getInt	(Lcom/tencent/mm/storage/ae$a;I)I
      //   53: istore 7
      //   55: aload_3
      //   56: arraylength
      //   57: ifne +194 -> 251
      //   60: iconst_1
      //   61: istore 5
      //   63: iload 5
      //   65: ifeq +192 -> 257
      //   68: new 124	java/lang/StringBuilder
      //   71: dup
      //   72: invokespecial 213	java/lang/StringBuilder:<init>	()V
      //   75: iload 4
      //   77: invokestatic 216	com/tencent/mm/plugin/finder/storage/logic/d$a:ahB	(I)Ljava/lang/String;
      //   80: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   83: ldc 218
      //   85: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   88: lload_0
      //   89: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   92: bipush 32
      //   94: invokevirtual 221	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   97: ldc 223
      //   99: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: iload 7
      //   104: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   107: ldc 228
      //   109: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   112: iload_2
      //   113: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   116: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   119: astore_3
      //   120: invokestatic 122	com/tencent/mm/plugin/finder/storage/logic/d:access$getTAG$cp	()Ljava/lang/String;
      //   123: ldc 230
      //   125: aload_3
      //   126: invokestatic 233	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   129: invokevirtual 175	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   132: invokestatic 154	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   135: aload 12
      //   137: aload_3
      //   138: iconst_0
      //   139: anewarray 168	java/lang/String
      //   142: invokevirtual 237	com/tencent/mm/sdk/e/j:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   145: astore 11
      //   147: aload 11
      //   149: ifnull +326 -> 475
      //   152: new 239	java/util/LinkedList
      //   155: dup
      //   156: invokespecial 240	java/util/LinkedList:<init>	()V
      //   159: astore_3
      //   160: aload 11
      //   162: checkcast 242	java/io/Closeable
      //   165: astore 12
      //   167: aload 12
      //   169: checkcast 244	android/database/Cursor
      //   172: astore 10
      //   174: aload 10
      //   176: invokeinterface 247 1 0
      //   181: ifeq +264 -> 445
      //   184: ldc 79
      //   186: invokevirtual 252	java/lang/Class:newInstance	()Ljava/lang/Object;
      //   189: checkcast 113	com/tencent/mm/sdk/e/c
      //   192: astore 13
      //   194: aload 13
      //   196: aload 10
      //   198: invokevirtual 256	com/tencent/mm/sdk/e/c:convertFrom	(Landroid/database/Cursor;)V
      //   201: aload_3
      //   202: aload 13
      //   204: invokevirtual 260	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   207: pop
      //   208: goto -34 -> 174
      //   211: astore 10
      //   213: ldc 184
      //   215: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   218: aload 10
      //   220: athrow
      //   221: astore_3
      //   222: aload 12
      //   224: aload 10
      //   226: invokestatic 265	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   229: ldc 184
      //   231: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   234: aload_3
      //   235: athrow
      //   236: astore_3
      //   237: aload 11
      //   239: invokeinterface 268 1 0
      //   244: ldc 184
      //   246: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   249: aload_3
      //   250: athrow
      //   251: iconst_0
      //   252: istore 5
      //   254: goto -191 -> 63
      //   257: ldc_w 270
      //   260: astore 10
      //   262: iconst_0
      //   263: istore 5
      //   265: aload_3
      //   266: arraylength
      //   267: istore 8
      //   269: iconst_0
      //   270: istore 6
      //   272: iload 6
      //   274: iload 8
      //   276: if_icmpge +81 -> 357
      //   279: aload_3
      //   280: iload 6
      //   282: iaload
      //   283: istore 9
      //   285: aload 10
      //   287: astore 11
      //   289: iload 5
      //   291: ifle +26 -> 317
      //   294: new 124	java/lang/StringBuilder
      //   297: dup
      //   298: invokespecial 213	java/lang/StringBuilder:<init>	()V
      //   301: aload 10
      //   303: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   306: ldc_w 272
      //   309: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   312: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   315: astore 11
      //   317: new 124	java/lang/StringBuilder
      //   320: dup
      //   321: invokespecial 213	java/lang/StringBuilder:<init>	()V
      //   324: aload 11
      //   326: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   329: iload 9
      //   331: invokestatic 171	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   334: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   337: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   340: astore 10
      //   342: iload 6
      //   344: iconst_1
      //   345: iadd
      //   346: istore 6
      //   348: iload 5
      //   350: iconst_1
      //   351: iadd
      //   352: istore 5
      //   354: goto -82 -> 272
      //   357: new 124	java/lang/StringBuilder
      //   360: dup
      //   361: invokespecial 213	java/lang/StringBuilder:<init>	()V
      //   364: aload 10
      //   366: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   369: ldc_w 274
      //   372: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   375: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   378: astore_3
      //   379: new 124	java/lang/StringBuilder
      //   382: dup
      //   383: invokespecial 213	java/lang/StringBuilder:<init>	()V
      //   386: iload 4
      //   388: invokestatic 216	com/tencent/mm/plugin/finder/storage/logic/d$a:ahB	(I)Ljava/lang/String;
      //   391: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   394: ldc 218
      //   396: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   399: lload_0
      //   400: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   403: bipush 32
      //   405: invokevirtual 221	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   408: ldc_w 276
      //   411: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   414: aload_3
      //   415: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   418: ldc_w 278
      //   421: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   424: iload 7
      //   426: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   429: ldc 228
      //   431: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   434: iload_2
      //   435: invokevirtual 226	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   438: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   441: astore_3
      //   442: goto -322 -> 120
      //   445: getstatic 284	d/y:JfV	Ld/y;
      //   448: astore 10
      //   450: aload 12
      //   452: aconst_null
      //   453: invokestatic 265	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   456: aload_3
      //   457: checkcast 286	java/util/List
      //   460: astore_3
      //   461: aload 11
      //   463: invokeinterface 268 1 0
      //   468: ldc 184
      //   470: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   473: aload_3
      //   474: areturn
      //   475: new 239	java/util/LinkedList
      //   478: dup
      //   479: invokespecial 240	java/util/LinkedList:<init>	()V
      //   482: checkcast 286	java/util/List
      //   485: astore_3
      //   486: goto -25 -> 461
      //   489: astore_3
      //   490: aconst_null
      //   491: astore 10
      //   493: goto -271 -> 222
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	496	0	paramLong	long
      //   0	496	2	paramInt1	int
      //   0	496	3	paramArrayOfInt	int[]
      //   0	496	4	paramInt2	int
      //   61	292	5	i	int
      //   270	77	6	j	int
      //   53	372	7	k	int
      //   267	10	8	m	int
      //   283	47	9	n	int
      //   32	165	10	localObject1	Object
      //   211	14	10	localThrowable	java.lang.Throwable
      //   260	232	10	localObject2	Object
      //   145	317	11	localObject3	Object
      //   27	424	12	localObject4	Object
      //   192	11	13	localc	c
      // Exception table:
      //   from	to	target	type
      //   167	174	211	java/lang/Throwable
      //   174	208	211	java/lang/Throwable
      //   445	450	211	java/lang/Throwable
      //   213	221	221	finally
      //   152	167	236	finally
      //   222	236	236	finally
      //   450	461	236	finally
      //   475	486	236	finally
      //   167	174	489	finally
      //   174	208	489	finally
      //   445	450	489	finally
    }
    
    private static String ahB(int paramInt)
    {
      AppMethodBeat.i(199100);
      StringBuilder localStringBuilder = new StringBuilder("SELECT rowid, * FROM ");
      if (ahC(paramInt) == 1) {}
      for (String str = cd.qnQ;; str = cd.qnP)
      {
        str = str;
        AppMethodBeat.o(199100);
        return str;
      }
    }
    
    private static int ahC(int paramInt)
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
    public static com.tencent.mm.plugin.finder.storage.l an(long paramLong, int paramInt)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 4
      //   3: ldc_w 300
      //   6: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: invokestatic 122	com/tencent/mm/plugin/finder/storage/logic/d:access$getTAG$cp	()Ljava/lang/String;
      //   12: ldc_w 302
      //   15: lload_0
      //   16: invokestatic 305	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   19: invokevirtual 175	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   22: invokestatic 154	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   25: ldc 86
      //   27: invokestatic 92	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   30: checkcast 86	com/tencent/mm/plugin/finder/PluginFinder
      //   33: iload_2
      //   34: invokestatic 96	com/tencent/mm/plugin/finder/storage/logic/d$a:ahC	(I)I
      //   37: invokevirtual 100	com/tencent/mm/plugin/finder/PluginFinder:getMentionStorage	(I)Lcom/tencent/mm/sdk/e/j;
      //   40: astore_3
      //   41: new 124	java/lang/StringBuilder
      //   44: dup
      //   45: invokespecial 213	java/lang/StringBuilder:<init>	()V
      //   48: iload_2
      //   49: invokestatic 216	com/tencent/mm/plugin/finder/storage/logic/d$a:ahB	(I)Ljava/lang/String;
      //   52: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   55: ldc_w 307
      //   58: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   61: lload_0
      //   62: invokevirtual 133	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   65: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   68: astore 5
      //   70: invokestatic 122	com/tencent/mm/plugin/finder/storage/logic/d:access$getTAG$cp	()Ljava/lang/String;
      //   73: ldc 230
      //   75: aload 5
      //   77: invokestatic 233	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   80: invokevirtual 175	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   83: invokestatic 310	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   86: aload_3
      //   87: aload 5
      //   89: iconst_0
      //   90: anewarray 168	java/lang/String
      //   93: invokevirtual 237	com/tencent/mm/sdk/e/j:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   96: astore_3
      //   97: aload_3
      //   98: ifnull +58 -> 156
      //   101: aload_3
      //   102: checkcast 242	java/io/Closeable
      //   105: astore 5
      //   107: aload_3
      //   108: invokeinterface 247 1 0
      //   113: ifeq +33 -> 146
      //   116: new 79	com/tencent/mm/plugin/finder/storage/l
      //   119: dup
      //   120: invokespecial 311	com/tencent/mm/plugin/finder/storage/l:<init>	()V
      //   123: astore 6
      //   125: aload 6
      //   127: aload_3
      //   128: invokevirtual 312	com/tencent/mm/plugin/finder/storage/l:convertFrom	(Landroid/database/Cursor;)V
      //   131: aload 5
      //   133: aconst_null
      //   134: invokestatic 265	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   137: ldc_w 300
      //   140: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   143: aload 6
      //   145: areturn
      //   146: getstatic 284	d/y:JfV	Ld/y;
      //   149: astore_3
      //   150: aload 5
      //   152: aconst_null
      //   153: invokestatic 265	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   156: ldc_w 300
      //   159: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   162: aconst_null
      //   163: areturn
      //   164: astore 4
      //   166: ldc_w 300
      //   169: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   172: aload 4
      //   174: athrow
      //   175: astore_3
      //   176: aload 5
      //   178: aload 4
      //   180: invokestatic 265	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   183: ldc_w 300
      //   186: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   189: aload_3
      //   190: athrow
      //   191: astore_3
      //   192: goto -16 -> 176
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	195	0	paramLong	long
      //   0	195	2	paramInt	int
      //   40	110	3	localObject1	Object
      //   175	15	3	localObject2	Object
      //   191	1	3	localObject3	Object
      //   1	1	4	localObject4	Object
      //   164	15	4	localThrowable	java.lang.Throwable
      //   68	109	5	localObject5	Object
      //   123	21	6	locall	com.tencent.mm.plugin.finder.storage.l
      // Exception table:
      //   from	to	target	type
      //   107	131	164	java/lang/Throwable
      //   146	150	164	java/lang/Throwable
      //   166	175	175	finally
      //   107	131	191	finally
      //   146	150	191	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.d
 * JD-Core Version:    0.7.0.1
 */