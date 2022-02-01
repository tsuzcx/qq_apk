package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.cr;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.plugin.finder.model.ax;
import com.tencent.mm.plugin.finder.model.ay;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.model.ba;
import com.tencent.mm.plugin.finder.model.bb;
import com.tencent.mm.plugin.finder.model.bc;
import com.tencent.mm.plugin.finder.model.bd;
import com.tencent.mm.plugin.finder.model.be;
import com.tencent.mm.plugin.finder.model.bg;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class e
{
  public static final a AnP;
  private static final String TAG = "Finder.FinderMentionLogic";
  
  static
  {
    AppMethodBeat.i(167113);
    AnP = new a((byte)0);
    TAG = "Finder.FinderMentionLogic";
    AppMethodBeat.o(167113);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderMentionLogic$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "deleteMention", "", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "scene", "", "getAfterTimeLimit", "", "mentionId", "", "limit", "types", "", "getBeforeTimeLimit", "getByMentionIdCreateTime", "mentionCreateTime", "getDbSelect", "getLocalFlag", "insertMention", "mentionList", "removePrivateMention", "", "clientMsgId", "transformFinderMentionToCovertData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "transformMentionToLocal", "Lcom/tencent/mm/protocal/protobuf/FinderMention;", "updateMentionExtFlag", "plugin-finder_release"})
  public static final class a
  {
    private static String Qr(int paramInt)
    {
      AppMethodBeat.i(274345);
      StringBuilder localStringBuilder = new StringBuilder("SELECT rowid, * FROM ");
      if (Qs(paramInt) == 1) {}
      for (String str = cr.hUo;; str = cr.hUn)
      {
        str = str;
        AppMethodBeat.o(274345);
        return str;
      }
    }
    
    public static int Qs(int paramInt)
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
    public static List<an> a(long paramLong, int paramInt1, int[] paramArrayOfInt, int paramInt2)
    {
      // Byte code:
      //   0: ldc 92
      //   2: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_3
      //   6: ldc 93
      //   8: invokestatic 99	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
      //   11: ldc 101
      //   13: invokestatic 107	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   16: checkcast 101	com/tencent/mm/plugin/finder/PluginFinder
      //   19: iload 4
      //   21: invokestatic 69	com/tencent/mm/plugin/finder/storage/logic/e$a:Qs	(I)I
      //   24: invokevirtual 111	com/tencent/mm/plugin/finder/PluginFinder:getMentionStorage	(I)Lcom/tencent/mm/sdk/storage/MAutoStorage;
      //   27: astore 12
      //   29: invokestatic 115	com/tencent/mm/kernel/h:aHG	()Lcom/tencent/mm/kernel/f;
      //   32: astore 10
      //   34: aload 10
      //   36: ldc 117
      //   38: invokestatic 120	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   41: aload 10
      //   43: invokevirtual 126	com/tencent/mm/kernel/f:aHp	()Lcom/tencent/mm/storage/ao;
      //   46: getstatic 132	com/tencent/mm/storage/ar$a:VAI	Lcom/tencent/mm/storage/ar$a;
      //   49: iconst_0
      //   50: invokevirtual 138	com/tencent/mm/storage/ao:getInt	(Lcom/tencent/mm/storage/ar$a;I)I
      //   53: istore 7
      //   55: aload_3
      //   56: arraylength
      //   57: ifne +205 -> 262
      //   60: iconst_1
      //   61: istore 5
      //   63: iload 5
      //   65: ifeq +203 -> 268
      //   68: new 60	java/lang/StringBuilder
      //   71: dup
      //   72: invokespecial 139	java/lang/StringBuilder:<init>	()V
      //   75: iload 4
      //   77: invokestatic 141	com/tencent/mm/plugin/finder/storage/logic/e$a:Qr	(I)Ljava/lang/String;
      //   80: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   83: ldc 143
      //   85: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   88: lload_0
      //   89: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   92: bipush 32
      //   94: invokevirtual 149	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   97: ldc 151
      //   99: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: iload 7
      //   104: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   107: ldc 156
      //   109: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   112: iload_2
      //   113: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   116: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   119: astore_3
      //   120: invokestatic 159	com/tencent/mm/plugin/finder/storage/logic/e:access$getTAG$cp	()Ljava/lang/String;
      //   123: ldc 161
      //   125: aload_3
      //   126: invokestatic 167	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   129: invokevirtual 171	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   132: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   135: aload 12
      //   137: aload_3
      //   138: iconst_0
      //   139: anewarray 163	java/lang/String
      //   142: invokevirtual 182	com/tencent/mm/sdk/storage/MAutoStorage:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   145: astore 11
      //   147: aload 11
      //   149: ifnull +332 -> 481
      //   152: new 184	java/util/LinkedList
      //   155: dup
      //   156: invokespecial 185	java/util/LinkedList:<init>	()V
      //   159: astore_3
      //   160: aload 11
      //   162: checkcast 187	java/io/Closeable
      //   165: astore 12
      //   167: aload 12
      //   169: checkcast 189	android/database/Cursor
      //   172: astore 10
      //   174: aload 10
      //   176: invokeinterface 193 1 0
      //   181: ifeq +270 -> 451
      //   184: ldc 195
      //   186: invokevirtual 201	java/lang/Class:newInstance	()Ljava/lang/Object;
      //   189: astore 13
      //   191: aload 13
      //   193: ldc 203
      //   195: invokestatic 120	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   198: aload 13
      //   200: checkcast 205	com/tencent/mm/sdk/storage/IAutoDBItem
      //   203: astore 13
      //   205: aload 13
      //   207: aload 10
      //   209: invokevirtual 209	com/tencent/mm/sdk/storage/IAutoDBItem:convertFrom	(Landroid/database/Cursor;)V
      //   212: aload_3
      //   213: aload 13
      //   215: invokevirtual 213	java/util/LinkedList:add	(Ljava/lang/Object;)Z
      //   218: pop
      //   219: goto -45 -> 174
      //   222: astore 10
      //   224: ldc 92
      //   226: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   229: aload 10
      //   231: athrow
      //   232: astore_3
      //   233: aload 12
      //   235: aload 10
      //   237: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   240: ldc 92
      //   242: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   245: aload_3
      //   246: athrow
      //   247: astore_3
      //   248: aload 11
      //   250: invokeinterface 221 1 0
      //   255: ldc 92
      //   257: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   260: aload_3
      //   261: athrow
      //   262: iconst_0
      //   263: istore 5
      //   265: goto -202 -> 63
      //   268: ldc 223
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
      //   304: new 60	java/lang/StringBuilder
      //   307: dup
      //   308: invokespecial 139	java/lang/StringBuilder:<init>	()V
      //   311: aload 10
      //   313: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   316: ldc 225
      //   318: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   321: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   324: astore 11
      //   326: new 60	java/lang/StringBuilder
      //   329: dup
      //   330: invokespecial 139	java/lang/StringBuilder:<init>	()V
      //   333: aload 11
      //   335: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   338: iload 9
      //   340: invokestatic 227	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   343: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   346: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
      //   366: new 60	java/lang/StringBuilder
      //   369: dup
      //   370: invokespecial 139	java/lang/StringBuilder:<init>	()V
      //   373: aload 10
      //   375: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   378: ldc 229
      //   380: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   383: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   386: astore_3
      //   387: new 60	java/lang/StringBuilder
      //   390: dup
      //   391: invokespecial 139	java/lang/StringBuilder:<init>	()V
      //   394: iload 4
      //   396: invokestatic 141	com/tencent/mm/plugin/finder/storage/logic/e$a:Qr	(I)Ljava/lang/String;
      //   399: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   402: ldc 143
      //   404: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   407: lload_0
      //   408: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   411: bipush 32
      //   413: invokevirtual 149	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   416: ldc 231
      //   418: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   421: aload_3
      //   422: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   425: ldc 233
      //   427: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   430: iload 7
      //   432: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   435: ldc 156
      //   437: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   440: iload_2
      //   441: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   444: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   447: astore_3
      //   448: goto -328 -> 120
      //   451: getstatic 239	kotlin/x:aazN	Lkotlin/x;
      //   454: astore 10
      //   456: aload 12
      //   458: aconst_null
      //   459: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   462: aload_3
      //   463: checkcast 241	java/util/List
      //   466: astore_3
      //   467: aload 11
      //   469: invokeinterface 221 1 0
      //   474: ldc 92
      //   476: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   479: aload_3
      //   480: areturn
      //   481: new 184	java/util/LinkedList
      //   484: dup
      //   485: invokespecial 185	java/util/LinkedList:<init>	()V
      //   488: checkcast 241	java/util/List
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
    
    public static boolean a(an paraman, int paramInt)
    {
      AppMethodBeat.i(274341);
      p.k(paraman, "mention");
      MAutoStorage localMAutoStorage = ((PluginFinder)h.ag(PluginFinder.class)).getMentionStorage(Qs(paramInt));
      if (Qs(paramInt) == 1) {}
      for (String str1 = cr.hUo;; str1 = cr.hUn)
      {
        String str2 = "UPDATE " + str1 + " SET extFlag=" + paraman.field_extFlag + " WHERE id=" + paraman.field_id;
        boolean bool = localMAutoStorage.execSQL(str1, str2);
        Log.i(e.access$getTAG$cp(), "updateMentionExtFlag sql:" + str2 + ", flag:" + paraman.field_extFlag);
        AppMethodBeat.o(274341);
        return bool;
      }
    }
    
    public static a b(an paraman)
    {
      AppMethodBeat.i(274344);
      p.k(paraman, "mention");
      switch (paraman.field_type)
      {
      case 6: 
      case 9: 
      default: 
        AppMethodBeat.o(274344);
        return null;
      case 4: 
        paraman = (a)new bg(paraman);
        AppMethodBeat.o(274344);
        return paraman;
      case 2: 
        paraman = (a)new bd(paraman);
        AppMethodBeat.o(274344);
        return paraman;
      case 3: 
        paraman = (a)new ax(paraman);
        AppMethodBeat.o(274344);
        return paraman;
      case 5: 
        paraman = (a)new be(paraman);
        AppMethodBeat.o(274344);
        return paraman;
      case 1: 
        paraman = (a)new ay(paraman);
        AppMethodBeat.o(274344);
        return paraman;
      case 7: 
        paraman = (a)new bc(paraman);
        AppMethodBeat.o(274344);
        return paraman;
      case 8: 
        paraman = (a)new bb(paraman);
        AppMethodBeat.o(274344);
        return paraman;
      case 10: 
        paraman = (a)new az(paraman);
        AppMethodBeat.o(274344);
        return paraman;
      }
      paraman = (a)new ba(paraman);
      AppMethodBeat.o(274344);
      return paraman;
    }
    
    public static boolean b(an paraman, int paramInt)
    {
      AppMethodBeat.i(274342);
      p.k(paraman, "mention");
      MAutoStorage localMAutoStorage = ((PluginFinder)h.ag(PluginFinder.class)).getMentionStorage(Qs(paramInt));
      if (Qs(paramInt) == 1) {}
      for (String str1 = cr.hUo;; str1 = cr.hUn)
      {
        String str2 = "DELETE FROM " + str1 + " WHERE id=" + paraman.field_id;
        boolean bool = localMAutoStorage.execSQL(str1, str2);
        Log.i(e.access$getTAG$cp(), "updateMentionExtFlag sql:" + str2 + ", flag:" + paraman.field_extFlag + " succ:" + bool);
        AppMethodBeat.o(274342);
        return bool;
      }
    }
    
    /* Error */
    public static an l(long paramLong, int paramInt1, int paramInt2)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 5
      //   3: ldc_w 316
      //   6: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: invokestatic 159	com/tencent/mm/plugin/finder/storage/logic/e:access$getTAG$cp	()Ljava/lang/String;
      //   12: new 60	java/lang/StringBuilder
      //   15: dup
      //   16: ldc_w 318
      //   19: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   22: lload_0
      //   23: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   26: ldc_w 320
      //   29: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   32: iload_2
      //   33: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   36: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   39: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   42: ldc 101
      //   44: invokestatic 107	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
      //   47: checkcast 101	com/tencent/mm/plugin/finder/PluginFinder
      //   50: iload_3
      //   51: invokestatic 69	com/tencent/mm/plugin/finder/storage/logic/e$a:Qs	(I)I
      //   54: invokevirtual 111	com/tencent/mm/plugin/finder/PluginFinder:getMentionStorage	(I)Lcom/tencent/mm/sdk/storage/MAutoStorage;
      //   57: astore 4
      //   59: new 60	java/lang/StringBuilder
      //   62: dup
      //   63: invokespecial 139	java/lang/StringBuilder:<init>	()V
      //   66: iload_3
      //   67: invokestatic 141	com/tencent/mm/plugin/finder/storage/logic/e$a:Qr	(I)Ljava/lang/String;
      //   70: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   73: ldc_w 322
      //   76: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   79: lload_0
      //   80: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   83: ldc_w 324
      //   86: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   89: iload_2
      //   90: invokevirtual 154	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   93: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   96: astore 6
      //   98: invokestatic 159	com/tencent/mm/plugin/finder/storage/logic/e:access$getTAG$cp	()Ljava/lang/String;
      //   101: ldc 161
      //   103: aload 6
      //   105: invokestatic 167	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   108: invokevirtual 171	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   111: invokestatic 327	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   114: aload 4
      //   116: aload 6
      //   118: iconst_0
      //   119: anewarray 163	java/lang/String
      //   122: invokevirtual 182	com/tencent/mm/sdk/storage/MAutoStorage:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
      //   125: astore 4
      //   127: aload 4
      //   129: ifnull +62 -> 191
      //   132: aload 4
      //   134: checkcast 187	java/io/Closeable
      //   137: astore 6
      //   139: aload 4
      //   141: invokeinterface 193 1 0
      //   146: ifeq +34 -> 180
      //   149: new 195	com/tencent/mm/plugin/finder/storage/an
      //   152: dup
      //   153: invokespecial 328	com/tencent/mm/plugin/finder/storage/an:<init>	()V
      //   156: astore 7
      //   158: aload 7
      //   160: aload 4
      //   162: invokevirtual 329	com/tencent/mm/plugin/finder/storage/an:convertFrom	(Landroid/database/Cursor;)V
      //   165: aload 6
      //   167: aconst_null
      //   168: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   171: ldc_w 316
      //   174: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   177: aload 7
      //   179: areturn
      //   180: getstatic 239	kotlin/x:aazN	Lkotlin/x;
      //   183: astore 4
      //   185: aload 6
      //   187: aconst_null
      //   188: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   191: ldc_w 316
      //   194: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   197: aconst_null
      //   198: areturn
      //   199: astore 5
      //   201: ldc_w 316
      //   204: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   207: aload 5
      //   209: athrow
      //   210: astore 4
      //   212: aload 6
      //   214: aload 5
      //   216: invokestatic 218	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   219: ldc_w 316
      //   222: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      //   156	22	7	localan	an
      // Exception table:
      //   from	to	target	type
      //   139	165	199	java/lang/Throwable
      //   180	185	199	java/lang/Throwable
      //   201	210	210	finally
      //   139	165	228	finally
      //   180	185	228	finally
    }
    
    public static int s(List<an> paramList, int paramInt)
    {
      AppMethodBeat.i(274340);
      p.k(paramList, "mentionList");
      Iterator localIterator = ((Iterable)paramList).iterator();
      int i = 0;
      an localan;
      if (localIterator.hasNext())
      {
        paramList = (an)localIterator.next();
        Object localObject = e.AnP;
        p.k(paramList, "mention");
        localObject = ((PluginFinder)h.ag(PluginFinder.class)).getMentionStorage(Qs(paramInt));
        localan = l(paramList.field_id, paramList.field_createTime, paramInt);
        if (localan != null) {
          ((MAutoStorage)localObject).delete(localan.systemRowid);
        }
        boolean bool = ((MAutoStorage)localObject).insert((IAutoDBItem)paramList);
        localObject = e.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("replace mention success ").append(paramList.field_id).append(", ");
        if (localan == null)
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
        paramList = Long.valueOf(localan.systemRowid);
        break label154;
        Log.i(e.access$getTAG$cp(), "insert mention ".concat(String.valueOf(i)));
        AppMethodBeat.o(274340);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.e
 * JD-Core Version:    0.7.0.1
 */