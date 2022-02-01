package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class d
{
  private static final String TAG = "Finder.FinderMentionLogic";
  public static final a sAw;
  
  static
  {
    AppMethodBeat.i(167113);
    sAw = new a((byte)0);
    TAG = "Finder.FinderMentionLogic";
    AppMethodBeat.o(167113);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionLogic$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getBeforeTimeLimit", "", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "mentionId", "", "limit", "", "types", "", "scene", "getByMentionIdCreateTime", "mentionCreateTime", "getDbSelect", "getLocalFlag", "insertMention", "", "mention", "mentionList", "removePrivateMention", "", "clientMsgId", "transformFinderMentionToCovertData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "transformMentionToLocal", "Lcom/tencent/mm/protocal/protobuf/FinderMention;", "updateMentionExtFlag", "plugin-finder_release"})
  public static final class a
  {
    private static String Fw(int paramInt)
    {
      AppMethodBeat.i(203876);
      StringBuilder localStringBuilder = new StringBuilder("SELECT rowid, * FROM ");
      if (Fx(paramInt) == 1) {}
      for (String str = ci.eZq;; str = ci.eZp)
      {
        str = str;
        AppMethodBeat.o(203876);
        return str;
      }
    }
    
    public static int Fx(int paramInt)
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
    public static List<ac> a(long paramLong, int paramInt1, int[] paramArrayOfInt, int paramInt2)
    {
      // Byte code:
      //   0: ldc 90
      //   2: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_3
      //   6: ldc 91
      //   8: invokestatic 97	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   11: ldc 99
      //   13: invokestatic 105	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   16: checkcast 99	com/tencent/mm/plugin/finder/PluginFinder
      //   19: iload 4
      //   21: invokestatic 67	com/tencent/mm/plugin/finder/storage/logic/d$a:Fx	(I)I
      //   24: invokevirtual 109	com/tencent/mm/plugin/finder/PluginFinder:getMentionStorage	(I)Lcom/tencent/mm/sdk/e/j;
      //   27: astore 12
      //   29: invokestatic 113	com/tencent/mm/kernel/g:ajC	()Lcom/tencent/mm/kernel/e;
      //   32: astore 10
      //   34: aload 10
      //   36: ldc 115
      //   38: invokestatic 118	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   41: aload 10
      //   43: invokevirtual 124	com/tencent/mm/kernel/e:ajl	()Lcom/tencent/mm/storage/ai;
      //   46: getstatic 130	com/tencent/mm/storage/al$a:IIg	Lcom/tencent/mm/storage/al$a;
      //   49: iconst_0
      //   50: invokevirtual 136	com/tencent/mm/storage/ai:getInt	(Lcom/tencent/mm/storage/al$a;I)I
      //   53: istore 7
      //   55: aload_3
      //   56: arraylength
      //   57: ifne +194 -> 251
      //   60: iconst_1
      //   61: istore 5
      //   63: iload 5
      //   65: ifeq +192 -> 257
      //   68: new 58	java/lang/StringBuilder
      //   71: dup
      //   72: invokespecial 137	java/lang/StringBuilder:<init>	()V
      //   75: iload 4
      //   77: invokestatic 139	com/tencent/mm/plugin/finder/storage/logic/d$a:Fw	(I)Ljava/lang/String;
      //   80: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   83: ldc 141
      //   85: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   88: lload_0
      //   89: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   92: bipush 32
      //   94: invokevirtual 147	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   97: ldc 149
      //   99: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: iload 7
      //   104: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   107: ldc 154
      //   109: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   112: iload_2
      //   113: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   116: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   119: astore_3
      //   120: invokestatic 157	com/tencent/mm/plugin/finder/storage/logic/d:access$getTAG$cp	()Ljava/lang/String;
      //   123: ldc 159
      //   125: aload_3
      //   126: invokestatic 165	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   129: invokevirtual 169	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   132: invokestatic 174	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   135: aload 12
      //   137: aload_3
      //   138: iconst_0
      //   139: anewarray 161	java/lang/String
      //   142: invokevirtual 180	com/tencent/mm/sdk/e/j:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   145: astore 11
      //   147: aload 11
      //   149: ifnull +321 -> 470
      //   152: new 182	java/util/LinkedList
      //   155: dup
      //   156: invokespecial 183	java/util/LinkedList:<init>	()V
      //   159: astore_3
      //   160: aload 11
      //   162: checkcast 185	java/io/Closeable
      //   165: astore 12
      //   167: aload 12
      //   169: checkcast 187	android/database/Cursor
      //   172: astore 10
      //   174: aload 10
      //   176: invokeinterface 191 1 0
      //   181: ifeq +259 -> 440
      //   184: ldc 193
      //   186: invokevirtual 199	java/lang/Class:newInstance	()Ljava/lang/Object;
      //   189: checkcast 201	com/tencent/mm/sdk/e/c
      //   192: astore 13
      //   194: aload 13
      //   196: aload 10
      //   198: invokevirtual 205	com/tencent/mm/sdk/e/c:convertFrom	(Landroid/database/Cursor;)V
      //   201: aload_3
      //   202: aload 13
      //   204: invokevirtual 209	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   207: pop
      //   208: goto -34 -> 174
      //   211: astore 10
      //   213: ldc 90
      //   215: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   218: aload 10
      //   220: athrow
      //   221: astore_3
      //   222: aload 12
      //   224: aload 10
      //   226: invokestatic 214	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   229: ldc 90
      //   231: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   234: aload_3
      //   235: athrow
      //   236: astore_3
      //   237: aload 11
      //   239: invokeinterface 217 1 0
      //   244: ldc 90
      //   246: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   249: aload_3
      //   250: athrow
      //   251: iconst_0
      //   252: istore 5
      //   254: goto -191 -> 63
      //   257: ldc 219
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
      //   293: new 58	java/lang/StringBuilder
      //   296: dup
      //   297: invokespecial 137	java/lang/StringBuilder:<init>	()V
      //   300: aload 10
      //   302: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   305: ldc 221
      //   307: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   310: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   313: astore 11
      //   315: new 58	java/lang/StringBuilder
      //   318: dup
      //   319: invokespecial 137	java/lang/StringBuilder:<init>	()V
      //   322: aload 11
      //   324: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   327: iload 9
      //   329: invokestatic 223	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   332: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   335: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
      //   355: new 58	java/lang/StringBuilder
      //   358: dup
      //   359: invokespecial 137	java/lang/StringBuilder:<init>	()V
      //   362: aload 10
      //   364: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   367: ldc 225
      //   369: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   372: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   375: astore_3
      //   376: new 58	java/lang/StringBuilder
      //   379: dup
      //   380: invokespecial 137	java/lang/StringBuilder:<init>	()V
      //   383: iload 4
      //   385: invokestatic 139	com/tencent/mm/plugin/finder/storage/logic/d$a:Fw	(I)Ljava/lang/String;
      //   388: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   391: ldc 141
      //   393: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   396: lload_0
      //   397: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   400: bipush 32
      //   402: invokevirtual 147	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   405: ldc 227
      //   407: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   410: aload_3
      //   411: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   414: ldc 229
      //   416: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   419: iload 7
      //   421: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   424: ldc 154
      //   426: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   429: iload_2
      //   430: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   433: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   436: astore_3
      //   437: goto -317 -> 120
      //   440: getstatic 235	d/z:MKo	Ld/z;
      //   443: astore 10
      //   445: aload 12
      //   447: aconst_null
      //   448: invokestatic 214	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   451: aload_3
      //   452: checkcast 237	java/util/List
      //   455: astore_3
      //   456: aload 11
      //   458: invokeinterface 217 1 0
      //   463: ldc 90
      //   465: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   468: aload_3
      //   469: areturn
      //   470: new 182	java/util/LinkedList
      //   473: dup
      //   474: invokespecial 183	java/util/LinkedList:<init>	()V
      //   477: checkcast 237	java/util/List
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
    
    public static boolean a(ac paramac, int paramInt)
    {
      AppMethodBeat.i(203874);
      p.h(paramac, "mention");
      j localj = ((PluginFinder)g.ad(PluginFinder.class)).getMentionStorage(Fx(paramInt));
      if (Fx(paramInt) == 1) {}
      for (String str1 = ci.eZq;; str1 = ci.eZp)
      {
        String str2 = "UPDATE " + str1 + " SET extFlag=" + paramac.field_extFlag + " WHERE id=" + paramac.field_id;
        boolean bool = localj.execSQL(str1, str2);
        ad.i(d.access$getTAG$cp(), "updateMentionExtFlag sql:" + str2 + ", flag:" + paramac.field_extFlag);
        AppMethodBeat.o(203874);
        return bool;
      }
    }
    
    /* Error */
    public static ac l(long paramLong, int paramInt1, int paramInt2)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: ldc_w 267
      //   6: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: invokestatic 157	com/tencent/mm/plugin/finder/storage/logic/d:access$getTAG$cp	()Ljava/lang/String;
      //   12: new 58	java/lang/StringBuilder
      //   15: dup
      //   16: ldc_w 269
      //   19: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   22: lload_0
      //   23: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   26: ldc_w 271
      //   29: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   32: iload_2
      //   33: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   36: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   39: invokestatic 174	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   42: ldc 99
      //   44: invokestatic 105	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   47: checkcast 99	com/tencent/mm/plugin/finder/PluginFinder
      //   50: iload_3
      //   51: invokestatic 67	com/tencent/mm/plugin/finder/storage/logic/d$a:Fx	(I)I
      //   54: invokevirtual 109	com/tencent/mm/plugin/finder/PluginFinder:getMentionStorage	(I)Lcom/tencent/mm/sdk/e/j;
      //   57: astore 4
      //   59: new 58	java/lang/StringBuilder
      //   62: dup
      //   63: invokespecial 137	java/lang/StringBuilder:<init>	()V
      //   66: iload_3
      //   67: invokestatic 139	com/tencent/mm/plugin/finder/storage/logic/d$a:Fw	(I)Ljava/lang/String;
      //   70: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   73: ldc_w 273
      //   76: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   79: lload_0
      //   80: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   83: ldc_w 275
      //   86: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   89: iload_2
      //   90: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   93: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   96: astore 6
      //   98: invokestatic 157	com/tencent/mm/plugin/finder/storage/logic/d:access$getTAG$cp	()Ljava/lang/String;
      //   101: ldc 159
      //   103: aload 6
      //   105: invokestatic 165	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   108: invokevirtual 169	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   111: invokestatic 278	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   114: aload 4
      //   116: aload 6
      //   118: iconst_0
      //   119: anewarray 161	java/lang/String
      //   122: invokevirtual 180	com/tencent/mm/sdk/e/j:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   125: astore 4
      //   127: aload 4
      //   129: ifnull +62 -> 191
      //   132: aload 4
      //   134: checkcast 185	java/io/Closeable
      //   137: astore 6
      //   139: aload 4
      //   141: invokeinterface 191 1 0
      //   146: ifeq +34 -> 180
      //   149: new 193	com/tencent/mm/plugin/finder/storage/ac
      //   152: dup
      //   153: invokespecial 279	com/tencent/mm/plugin/finder/storage/ac:<init>	()V
      //   156: astore 7
      //   158: aload 7
      //   160: aload 4
      //   162: invokevirtual 280	com/tencent/mm/plugin/finder/storage/ac:convertFrom	(Landroid/database/Cursor;)V
      //   165: aload 6
      //   167: aconst_null
      //   168: invokestatic 214	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   171: ldc_w 267
      //   174: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   177: aload 7
      //   179: areturn
      //   180: getstatic 235	d/z:MKo	Ld/z;
      //   183: astore 4
      //   185: aload 6
      //   187: aconst_null
      //   188: invokestatic 214	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   191: ldc_w 267
      //   194: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   197: aconst_null
      //   198: areturn
      //   199: astore 5
      //   201: ldc_w 267
      //   204: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   207: aload 5
      //   209: athrow
      //   210: astore 4
      //   212: aload 6
      //   214: aload 5
      //   216: invokestatic 214	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   219: ldc_w 267
      //   222: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   225: aload 4
      //   227: athrow
      //   228: astore 4
      //   230: goto -18 -> 212
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	233	0	paramLong	long
      //   0	233	2	paramInt1	int
      //   0	233	3	paramInt2	int
      //   57	127	4	localObject1	Object
      //   210	16	4	localObject2	Object
      //   228	1	4	localObject3	Object
      //   1	1	5	localObject4	Object
      //   199	16	5	localThrowable	java.lang.Throwable
      //   96	117	6	localObject5	Object
      //   156	22	7	localac	ac
      // Exception table:
      //   from	to	target	type
      //   139	165	199	java/lang/Throwable
      //   180	185	199	java/lang/Throwable
      //   201	210	210	finally
      //   139	165	228	finally
      //   180	185	228	finally
    }
    
    public static int p(List<ac> paramList, int paramInt)
    {
      AppMethodBeat.i(203873);
      p.h(paramList, "mentionList");
      Iterator localIterator = ((Iterable)paramList).iterator();
      int i = 0;
      ac localac;
      if (localIterator.hasNext())
      {
        paramList = (ac)localIterator.next();
        Object localObject = d.sAw;
        p.h(paramList, "mention");
        localObject = ((PluginFinder)g.ad(PluginFinder.class)).getMentionStorage(Fx(paramInt));
        localac = l(paramList.field_id, paramList.field_createTime, paramInt);
        if (localac != null) {
          ((j)localObject).delete(localac.systemRowid);
        }
        boolean bool = ((j)localObject).insert((c)paramList);
        localObject = d.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("replace mention success ").append(paramList.field_id).append(", ");
        if (localac == null)
        {
          paramList = "null";
          label154:
          ad.i((String)localObject, paramList + ", " + bool);
          if (!bool) {
            break label225;
          }
          i += 1;
        }
      }
      label225:
      for (;;)
      {
        break;
        paramList = Long.valueOf(localac.systemRowid);
        break label154;
        ad.i(d.access$getTAG$cp(), "insert mention ".concat(String.valueOf(i)));
        AppMethodBeat.o(203873);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.d
 * JD-Core Version:    0.7.0.1
 */