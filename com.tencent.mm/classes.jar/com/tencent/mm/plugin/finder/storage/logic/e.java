package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.plugin.finder.model.au;
import com.tencent.mm.plugin.finder.model.av;
import com.tencent.mm.plugin.finder.model.aw;
import com.tencent.mm.plugin.finder.model.ax;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.model.ba;
import com.tencent.mm.plugin.finder.model.bb;
import com.tencent.mm.plugin.finder.model.bd;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class e
{
  private static final String TAG = "Finder.FinderMentionLogic";
  public static final a vGT;
  
  static
  {
    AppMethodBeat.i(167113);
    vGT = new a((byte)0);
    TAG = "Finder.FinderMentionLogic";
    AppMethodBeat.o(167113);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionLogic$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getAfterTimeLimit", "", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "mentionId", "", "limit", "", "types", "", "scene", "getBeforeTimeLimit", "getByMentionIdCreateTime", "mentionCreateTime", "getDbSelect", "getLocalFlag", "insertMention", "", "mention", "mentionList", "removePrivateMention", "", "clientMsgId", "transformFinderMentionToCovertData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "transformMentionToLocal", "Lcom/tencent/mm/protocal/protobuf/FinderMention;", "updateMentionExtFlag", "plugin-finder_release"})
  public static final class a
  {
    private static String Lh(int paramInt)
    {
      AppMethodBeat.i(252092);
      StringBuilder localStringBuilder = new StringBuilder("SELECT rowid, * FROM ");
      if (Li(paramInt) == 1) {}
      for (String str = cm.fFi;; str = cm.fFh)
      {
        str = str;
        AppMethodBeat.o(252092);
        return str;
      }
    }
    
    public static int Li(int paramInt)
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
    public static List<ao> a(long paramLong, int paramInt1, int[] paramArrayOfInt, int paramInt2)
    {
      // Byte code:
      //   0: ldc 91
      //   2: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_3
      //   6: ldc 92
      //   8: invokestatic 98	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
      //   11: ldc 100
      //   13: invokestatic 106	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   16: checkcast 100	com/tencent/mm/plugin/finder/PluginFinder
      //   19: iload 4
      //   21: invokestatic 68	com/tencent/mm/plugin/finder/storage/logic/e$a:Li	(I)I
      //   24: invokevirtual 110	com/tencent/mm/plugin/finder/PluginFinder:getMentionStorage	(I)Lcom/tencent/mm/sdk/storage/MAutoStorage;
      //   27: astore 12
      //   29: invokestatic 114	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
      //   32: astore 10
      //   34: aload 10
      //   36: ldc 116
      //   38: invokestatic 119	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   41: aload 10
      //   43: invokevirtual 125	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
      //   46: getstatic 131	com/tencent/mm/storage/ar$a:OlN	Lcom/tencent/mm/storage/ar$a;
      //   49: iconst_0
      //   50: invokevirtual 137	com/tencent/mm/storage/ao:getInt	(Lcom/tencent/mm/storage/ar$a;I)I
      //   53: istore 7
      //   55: aload_3
      //   56: arraylength
      //   57: ifne +205 -> 262
      //   60: iconst_1
      //   61: istore 5
      //   63: iload 5
      //   65: ifeq +203 -> 268
      //   68: new 59	java/lang/StringBuilder
      //   71: dup
      //   72: invokespecial 138	java/lang/StringBuilder:<init>	()V
      //   75: iload 4
      //   77: invokestatic 140	com/tencent/mm/plugin/finder/storage/logic/e$a:Lh	(I)Ljava/lang/String;
      //   80: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   83: ldc 142
      //   85: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   88: lload_0
      //   89: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   92: bipush 32
      //   94: invokevirtual 148	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   97: ldc 150
      //   99: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: iload 7
      //   104: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   107: ldc 155
      //   109: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   112: iload_2
      //   113: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   116: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   119: astore_3
      //   120: invokestatic 158	com/tencent/mm/plugin/finder/storage/logic/e:access$getTAG$cp	()Ljava/lang/String;
      //   123: ldc 160
      //   125: aload_3
      //   126: invokestatic 166	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   129: invokevirtual 170	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   132: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   135: aload 12
      //   137: aload_3
      //   138: iconst_0
      //   139: anewarray 162	java/lang/String
      //   142: invokevirtual 181	com/tencent/mm/sdk/storage/MAutoStorage:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   145: astore 11
      //   147: aload 11
      //   149: ifnull +332 -> 481
      //   152: new 183	java/util/LinkedList
      //   155: dup
      //   156: invokespecial 184	java/util/LinkedList:<init>	()V
      //   159: astore_3
      //   160: aload 11
      //   162: checkcast 186	java/io/Closeable
      //   165: astore 12
      //   167: aload 12
      //   169: checkcast 188	android/database/Cursor
      //   172: astore 10
      //   174: aload 10
      //   176: invokeinterface 192 1 0
      //   181: ifeq +270 -> 451
      //   184: ldc 194
      //   186: invokevirtual 200	java/lang/Class:newInstance	()Ljava/lang/Object;
      //   189: astore 13
      //   191: aload 13
      //   193: ldc 202
      //   195: invokestatic 119	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   198: aload 13
      //   200: checkcast 204	com/tencent/mm/sdk/storage/IAutoDBItem
      //   203: astore 13
      //   205: aload 13
      //   207: aload 10
      //   209: invokevirtual 208	com/tencent/mm/sdk/storage/IAutoDBItem:convertFrom	(Landroid/database/Cursor;)V
      //   212: aload_3
      //   213: aload 13
      //   215: invokevirtual 212	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   218: pop
      //   219: goto -45 -> 174
      //   222: astore 10
      //   224: ldc 91
      //   226: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   229: aload 10
      //   231: athrow
      //   232: astore_3
      //   233: aload 12
      //   235: aload 10
      //   237: invokestatic 217	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   240: ldc 91
      //   242: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   245: aload_3
      //   246: athrow
      //   247: astore_3
      //   248: aload 11
      //   250: invokeinterface 220 1 0
      //   255: ldc 91
      //   257: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   260: aload_3
      //   261: athrow
      //   262: iconst_0
      //   263: istore 5
      //   265: goto -202 -> 63
      //   268: ldc 222
      //   270: astore 10
      //   272: iconst_0
      //   273: istore 5
      //   275: aload_3
      //   276: arraylength
      //   277: istore 8
      //   279: iconst_0
      //   280: istore 6
      //   282: iload 6
      //   284: iload 8
      //   286: if_icmpge +80 -> 366
      //   289: aload_3
      //   290: iload 6
      //   292: iaload
      //   293: istore 9
      //   295: aload 10
      //   297: astore 11
      //   299: iload 5
      //   301: ifle +25 -> 326
      //   304: new 59	java/lang/StringBuilder
      //   307: dup
      //   308: invokespecial 138	java/lang/StringBuilder:<init>	()V
      //   311: aload 10
      //   313: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   316: ldc 224
      //   318: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   321: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   324: astore 11
      //   326: new 59	java/lang/StringBuilder
      //   329: dup
      //   330: invokespecial 138	java/lang/StringBuilder:<init>	()V
      //   333: aload 11
      //   335: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   338: iload 9
      //   340: invokestatic 226	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   343: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   346: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   349: astore 10
      //   351: iload 6
      //   353: iconst_1
      //   354: iadd
      //   355: istore 6
      //   357: iload 5
      //   359: iconst_1
      //   360: iadd
      //   361: istore 5
      //   363: goto -81 -> 282
      //   366: new 59	java/lang/StringBuilder
      //   369: dup
      //   370: invokespecial 138	java/lang/StringBuilder:<init>	()V
      //   373: aload 10
      //   375: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   378: ldc 228
      //   380: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   383: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   386: astore_3
      //   387: new 59	java/lang/StringBuilder
      //   390: dup
      //   391: invokespecial 138	java/lang/StringBuilder:<init>	()V
      //   394: iload 4
      //   396: invokestatic 140	com/tencent/mm/plugin/finder/storage/logic/e$a:Lh	(I)Ljava/lang/String;
      //   399: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   402: ldc 142
      //   404: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   407: lload_0
      //   408: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   411: bipush 32
      //   413: invokevirtual 148	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   416: ldc 230
      //   418: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   421: aload_3
      //   422: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   425: ldc 232
      //   427: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   430: iload 7
      //   432: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   435: ldc 155
      //   437: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   440: iload_2
      //   441: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   444: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   447: astore_3
      //   448: goto -328 -> 120
      //   451: getstatic 238	kotlin/x:SXb	Lkotlin/x;
      //   454: astore 10
      //   456: aload 12
      //   458: aconst_null
      //   459: invokestatic 217	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   462: aload_3
      //   463: checkcast 240	java/util/List
      //   466: astore_3
      //   467: aload 11
      //   469: invokeinterface 220 1 0
      //   474: ldc 91
      //   476: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   479: aload_3
      //   480: areturn
      //   481: new 183	java/util/LinkedList
      //   484: dup
      //   485: invokespecial 184	java/util/LinkedList:<init>	()V
      //   488: checkcast 240	java/util/List
      //   491: astore_3
      //   492: goto -25 -> 467
      //   495: astore_3
      //   496: aconst_null
      //   497: astore 10
      //   499: goto -266 -> 233
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	502	0	paramLong	long
      //   0	502	2	paramInt1	int
      //   0	502	3	paramArrayOfInt	int[]
      //   0	502	4	paramInt2	int
      //   61	301	5	i	int
      //   280	76	6	j	int
      //   53	378	7	k	int
      //   277	10	8	m	int
      //   293	46	9	n	int
      //   32	176	10	localObject1	Object
      //   222	14	10	localThrowable	java.lang.Throwable
      //   270	228	10	localObject2	Object
      //   145	323	11	localObject3	Object
      //   27	430	12	localObject4	Object
      //   189	25	13	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   167	174	222	java/lang/Throwable
      //   174	219	222	java/lang/Throwable
      //   451	456	222	java/lang/Throwable
      //   224	232	232	finally
      //   152	167	247	finally
      //   233	247	247	finally
      //   456	467	247	finally
      //   481	492	247	finally
      //   167	174	495	finally
      //   174	219	495	finally
      //   451	456	495	finally
    }
    
    public static boolean a(ao paramao, int paramInt)
    {
      AppMethodBeat.i(252089);
      p.h(paramao, "mention");
      MAutoStorage localMAutoStorage = ((PluginFinder)g.ah(PluginFinder.class)).getMentionStorage(Li(paramInt));
      if (Li(paramInt) == 1) {}
      for (String str1 = cm.fFi;; str1 = cm.fFh)
      {
        String str2 = "UPDATE " + str1 + " SET extFlag=" + paramao.field_extFlag + " WHERE id=" + paramao.field_id;
        boolean bool = localMAutoStorage.execSQL(str1, str2);
        Log.i(e.access$getTAG$cp(), "updateMentionExtFlag sql:" + str2 + ", flag:" + paramao.field_extFlag);
        AppMethodBeat.o(252089);
        return bool;
      }
    }
    
    public static a b(ao paramao)
    {
      AppMethodBeat.i(252091);
      p.h(paramao, "mention");
      switch (paramao.field_type)
      {
      case 6: 
      case 9: 
      default: 
        AppMethodBeat.o(252091);
        return null;
      case 4: 
        paramao = (a)new bd(paramao);
        AppMethodBeat.o(252091);
        return paramao;
      case 2: 
        paramao = (a)new ba(paramao);
        AppMethodBeat.o(252091);
        return paramao;
      case 3: 
        paramao = (a)new au(paramao);
        AppMethodBeat.o(252091);
        return paramao;
      case 5: 
        paramao = (a)new bb(paramao);
        AppMethodBeat.o(252091);
        return paramao;
      case 1: 
        paramao = (a)new av(paramao);
        AppMethodBeat.o(252091);
        return paramao;
      case 7: 
        paramao = (a)new az(paramao);
        AppMethodBeat.o(252091);
        return paramao;
      case 8: 
        paramao = (a)new ay(paramao);
        AppMethodBeat.o(252091);
        return paramao;
      case 10: 
        paramao = (a)new aw(paramao);
        AppMethodBeat.o(252091);
        return paramao;
      }
      paramao = (a)new ax(paramao);
      AppMethodBeat.o(252091);
      return paramao;
    }
    
    /* Error */
    public static ao k(long paramLong, int paramInt1, int paramInt2)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: ldc_w 307
      //   6: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: invokestatic 158	com/tencent/mm/plugin/finder/storage/logic/e:access$getTAG$cp	()Ljava/lang/String;
      //   12: new 59	java/lang/StringBuilder
      //   15: dup
      //   16: ldc_w 309
      //   19: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   22: lload_0
      //   23: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   26: ldc_w 311
      //   29: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   32: iload_2
      //   33: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   36: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   39: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   42: ldc 100
      //   44: invokestatic 106	com/tencent/mm/kernel/g:ah	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   47: checkcast 100	com/tencent/mm/plugin/finder/PluginFinder
      //   50: iload_3
      //   51: invokestatic 68	com/tencent/mm/plugin/finder/storage/logic/e$a:Li	(I)I
      //   54: invokevirtual 110	com/tencent/mm/plugin/finder/PluginFinder:getMentionStorage	(I)Lcom/tencent/mm/sdk/storage/MAutoStorage;
      //   57: astore 4
      //   59: new 59	java/lang/StringBuilder
      //   62: dup
      //   63: invokespecial 138	java/lang/StringBuilder:<init>	()V
      //   66: iload_3
      //   67: invokestatic 140	com/tencent/mm/plugin/finder/storage/logic/e$a:Lh	(I)Ljava/lang/String;
      //   70: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   73: ldc_w 313
      //   76: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   79: lload_0
      //   80: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   83: ldc_w 315
      //   86: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   89: iload_2
      //   90: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   93: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   96: astore 6
      //   98: invokestatic 158	com/tencent/mm/plugin/finder/storage/logic/e:access$getTAG$cp	()Ljava/lang/String;
      //   101: ldc 160
      //   103: aload 6
      //   105: invokestatic 166	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   108: invokevirtual 170	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   111: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   114: aload 4
      //   116: aload 6
      //   118: iconst_0
      //   119: anewarray 162	java/lang/String
      //   122: invokevirtual 181	com/tencent/mm/sdk/storage/MAutoStorage:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   125: astore 4
      //   127: aload 4
      //   129: ifnull +62 -> 191
      //   132: aload 4
      //   134: checkcast 186	java/io/Closeable
      //   137: astore 6
      //   139: aload 4
      //   141: invokeinterface 192 1 0
      //   146: ifeq +34 -> 180
      //   149: new 194	com/tencent/mm/plugin/finder/storage/ao
      //   152: dup
      //   153: invokespecial 319	com/tencent/mm/plugin/finder/storage/ao:<init>	()V
      //   156: astore 7
      //   158: aload 7
      //   160: aload 4
      //   162: invokevirtual 320	com/tencent/mm/plugin/finder/storage/ao:convertFrom	(Landroid/database/Cursor;)V
      //   165: aload 6
      //   167: aconst_null
      //   168: invokestatic 217	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   171: ldc_w 307
      //   174: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   177: aload 7
      //   179: areturn
      //   180: getstatic 238	kotlin/x:SXb	Lkotlin/x;
      //   183: astore 4
      //   185: aload 6
      //   187: aconst_null
      //   188: invokestatic 217	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   191: ldc_w 307
      //   194: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   197: aconst_null
      //   198: areturn
      //   199: astore 5
      //   201: ldc_w 307
      //   204: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   207: aload 5
      //   209: athrow
      //   210: astore 4
      //   212: aload 6
      //   214: aload 5
      //   216: invokestatic 217	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   219: ldc_w 307
      //   222: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   156	22	7	localao	ao
      // Exception table:
      //   from	to	target	type
      //   139	165	199	java/lang/Throwable
      //   180	185	199	java/lang/Throwable
      //   201	210	210	finally
      //   139	165	228	finally
      //   180	185	228	finally
    }
    
    public static int t(List<ao> paramList, int paramInt)
    {
      AppMethodBeat.i(252088);
      p.h(paramList, "mentionList");
      Iterator localIterator = ((Iterable)paramList).iterator();
      int i = 0;
      ao localao;
      if (localIterator.hasNext())
      {
        paramList = (ao)localIterator.next();
        Object localObject = e.vGT;
        p.h(paramList, "mention");
        localObject = ((PluginFinder)g.ah(PluginFinder.class)).getMentionStorage(Li(paramInt));
        localao = k(paramList.field_id, paramList.field_createTime, paramInt);
        if (localao != null) {
          ((MAutoStorage)localObject).delete(localao.systemRowid);
        }
        boolean bool = ((MAutoStorage)localObject).insert((IAutoDBItem)paramList);
        localObject = e.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("replace mention success ").append(paramList.field_id).append(", ");
        if (localao == null)
        {
          paramList = "null";
          label154:
          Log.i((String)localObject, paramList + ", " + bool);
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
        paramList = Long.valueOf(localao.systemRowid);
        break label154;
        Log.i(e.access$getTAG$cp(), "insert mention ".concat(String.valueOf(i)));
        AppMethodBeat.o(252088);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.e
 * JD-Core Version:    0.7.0.1
 */