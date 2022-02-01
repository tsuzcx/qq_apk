package com.tencent.mm.plugin.finder.live.viewmodel.data.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.utils.bq;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxContextDiskStore;", "", "()V", "genFilePath", "", "liveId", "", "boxId", "genFolderPath", "readData", "", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/BoxContext;", "Lkotlin/collections/ArrayList;", "writeData", "", "boxContext", "boxContextList", "", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final String TAG;
  public static final a akgg;
  private static final String path;
  
  static
  {
    AppMethodBeat.i(371728);
    akgg = new a((byte)0);
    TAG = "Finder.BoxContextDiskStore";
    path = s.X(h.baE().cachePath, "livebox/");
    AppMethodBeat.o(371728);
  }
  
  /* Error */
  public static java.util.Map<java.lang.Long, java.util.ArrayList<anc>> Cs(long paramLong)
  {
    // Byte code:
    //   0: ldc 88
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: lload_0
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +14 -> 22
    //   11: invokestatic 94	kotlin/a/ak:kkZ	()Ljava/util/Map;
    //   14: astore_2
    //   15: ldc 88
    //   17: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aload_2
    //   21: areturn
    //   22: new 96	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 97	java/util/ArrayList:<init>	()V
    //   29: astore 4
    //   31: lload_0
    //   32: invokestatic 101	com/tencent/mm/plugin/finder/live/viewmodel/data/a/d:Ct	(J)Ljava/lang/String;
    //   35: astore_3
    //   36: aload_3
    //   37: invokestatic 107	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   40: ifeq +258 -> 298
    //   43: aload_3
    //   44: iconst_0
    //   45: invokestatic 111	com/tencent/mm/vfs/y:eB	(Ljava/lang/String;Z)Ljava/lang/Iterable;
    //   48: astore_2
    //   49: aload_2
    //   50: ifnull +298 -> 348
    //   53: aload_2
    //   54: invokeinterface 117 1 0
    //   59: astore 5
    //   61: aload 5
    //   63: invokeinterface 123 1 0
    //   68: ifeq +280 -> 348
    //   71: aload 5
    //   73: invokeinterface 127 1 0
    //   78: checkcast 129	com/tencent/mm/vfs/j
    //   81: astore 6
    //   83: aload 6
    //   85: getfield 133	com/tencent/mm/vfs/j:agxh	Z
    //   88: ifne -27 -> 61
    //   91: new 135	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   98: aload_3
    //   99: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: bipush 47
    //   104: invokevirtual 143	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   107: aload 6
    //   109: getfield 146	com/tencent/mm/vfs/j:name	Ljava/lang/String;
    //   112: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: iconst_0
    //   119: iconst_m1
    //   120: invokestatic 154	com/tencent/mm/vfs/y:bi	(Ljava/lang/String;II)[B
    //   123: astore 7
    //   125: new 156	com/tencent/mm/protocal/protobuf/anc
    //   128: dup
    //   129: invokespecial 157	com/tencent/mm/protocal/protobuf/anc:<init>	()V
    //   132: checkcast 159	com/tencent/mm/bx/a
    //   135: astore_2
    //   136: aload_2
    //   137: aload 7
    //   139: invokevirtual 163	com/tencent/mm/bx/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   142: pop
    //   143: aload_2
    //   144: checkcast 156	com/tencent/mm/protocal/protobuf/anc
    //   147: astore_2
    //   148: aload_2
    //   149: ifnull -88 -> 61
    //   152: aload 4
    //   154: aload_2
    //   155: invokevirtual 167	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   158: pop
    //   159: getstatic 173	com/tencent/mm/plugin/finder/utils/bq:akii	Lcom/tencent/mm/plugin/finder/utils/bq;
    //   162: astore 7
    //   164: getstatic 56	com/tencent/mm/plugin/finder/live/viewmodel/data/a/d:TAG	Ljava/lang/String;
    //   167: astore 7
    //   169: new 135	java/lang/StringBuilder
    //   172: dup
    //   173: ldc 175
    //   175: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: lload_0
    //   179: invokestatic 183	com/tencent/mm/ae/d:hF	(J)Ljava/lang/String;
    //   182: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 185
    //   187: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: astore 8
    //   192: getstatic 173	com/tencent/mm/plugin/finder/utils/bq:akii	Lcom/tencent/mm/plugin/finder/utils/bq;
    //   195: astore 9
    //   197: aload 7
    //   199: aload 8
    //   201: aload_2
    //   202: invokestatic 189	com/tencent/mm/plugin/finder/utils/bq:c	(Lcom/tencent/mm/protocal/protobuf/anc;)Ljava/lang/String;
    //   205: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 193	com/tencent/mm/plugin/finder/utils/bq:rP	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: goto -153 -> 61
    //   217: astore_2
    //   218: getstatic 173	com/tencent/mm/plugin/finder/utils/bq:akii	Lcom/tencent/mm/plugin/finder/utils/bq;
    //   221: astore 7
    //   223: getstatic 56	com/tencent/mm/plugin/finder/live/viewmodel/data/a/d:TAG	Ljava/lang/String;
    //   226: new 135	java/lang/StringBuilder
    //   229: dup
    //   230: ldc 195
    //   232: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   235: lload_0
    //   236: invokestatic 183	com/tencent/mm/ae/d:hF	(J)Ljava/lang/String;
    //   239: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc 185
    //   244: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload 6
    //   249: getfield 146	com/tencent/mm/vfs/j:name	Ljava/lang/String;
    //   252: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 193	com/tencent/mm/plugin/finder/utils/bq:rP	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: getstatic 56	com/tencent/mm/plugin/finder/live/viewmodel/data/a/d:TAG	Ljava/lang/String;
    //   264: aload_2
    //   265: ldc 197
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: goto -213 -> 61
    //   277: astore_2
    //   278: ldc 205
    //   280: ldc 206
    //   282: iconst_1
    //   283: anewarray 4	java/lang/Object
    //   286: dup
    //   287: iconst_0
    //   288: aload_2
    //   289: aastore
    //   290: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:printDebugStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: aconst_null
    //   294: astore_2
    //   295: goto -152 -> 143
    //   298: getstatic 173	com/tencent/mm/plugin/finder/utils/bq:akii	Lcom/tencent/mm/plugin/finder/utils/bq;
    //   301: astore_2
    //   302: getstatic 56	com/tencent/mm/plugin/finder/live/viewmodel/data/a/d:TAG	Ljava/lang/String;
    //   305: new 135	java/lang/StringBuilder
    //   308: dup
    //   309: ldc 212
    //   311: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: aload_3
    //   315: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: ldc 214
    //   320: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_3
    //   324: iconst_0
    //   325: invokestatic 218	com/tencent/mm/vfs/y:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   328: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 193	com/tencent/mm/plugin/finder/utils/bq:rP	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: invokestatic 94	kotlin/a/ak:kkZ	()Ljava/util/Map;
    //   340: astore_2
    //   341: ldc 88
    //   343: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   346: aload_2
    //   347: areturn
    //   348: new 223	kotlin/r
    //   351: dup
    //   352: lload_0
    //   353: invokestatic 229	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   356: aload 4
    //   358: invokespecial 232	kotlin/r:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   361: invokestatic 236	kotlin/a/ak:l	(Lkotlin/r;)Ljava/util/Map;
    //   364: astore_2
    //   365: ldc 88
    //   367: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   370: aload_2
    //   371: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	paramLong	long
    //   14	188	2	localObject1	Object
    //   217	48	2	localThrowable	Throwable
    //   277	12	2	localException	java.lang.Exception
    //   294	77	2	localObject2	Object
    //   35	289	3	str	String
    //   29	328	4	localArrayList	java.util.ArrayList
    //   59	13	5	localIterator	Iterator
    //   81	167	6	localj	com.tencent.mm.vfs.j
    //   123	99	7	localObject3	Object
    //   190	10	8	localStringBuilder	StringBuilder
    //   195	1	9	localbq	bq
    // Exception table:
    //   from	to	target	type
    //   91	136	217	finally
    //   136	143	217	finally
    //   143	148	217	finally
    //   152	214	217	finally
    //   278	293	217	finally
    //   136	143	277	java/lang/Exception
  }
  
  private static String Ct(long paramLong)
  {
    AppMethodBeat.i(371706);
    String str = s.X(path, com.tencent.mm.ae.d.hF(paramLong));
    AppMethodBeat.o(371706);
    return str;
  }
  
  public static void a(anc paramanc)
  {
    AppMethodBeat.i(371697);
    s.u(paramanc, "boxContext");
    long l = paramanc.mMJ;
    Object localObject1 = paramanc.Don;
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((l != 0L) && (localObject1 != null)) {
        if (((CharSequence)localObject1).length() != 0) {
          break label120;
        }
      }
    }
    Object localObject2;
    label120:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label125;
      }
      localObject2 = bq.akii;
      bq.rP(TAG, "writeData invalid, " + com.tencent.mm.ae.d.hF(paramanc.mMJ) + ", " + localObject1);
      AppMethodBeat.o(371697);
      return;
      localObject1 = ((bfv)localObject1).id;
      break;
    }
    try
    {
      label125:
      localObject2 = Ct(l);
      if (!y.ZC((String)localObject2)) {
        y.bDX((String)localObject2);
      }
      localObject2 = au(paramanc.mMJ, (String)localObject1);
      localObject3 = paramanc.toByteArray();
      y.f((String)localObject2, (byte[])localObject3, localObject3.length);
      localObject3 = bq.akii;
      localObject3 = TAG;
      localObject2 = new StringBuilder("writeData, path:").append(y.n((String)localObject2, false)).append(", ");
      localbq = bq.akii;
      bq.rP((String)localObject3, bq.c(paramanc));
      AppMethodBeat.o(371697);
      return;
    }
    finally
    {
      Object localObject3 = bq.akii;
      localObject3 = TAG;
      localObject1 = new StringBuilder("write data failed. liveId:").append(com.tencent.mm.ae.d.hF(l)).append(", ").append(localObject1).append(", ");
      bq localbq = bq.akii;
      bq.rP((String)localObject3, bq.c(paramanc));
      Log.printErrStackTrace(TAG, localThrowable, "write data failed.", new Object[0]);
      AppMethodBeat.o(371697);
    }
  }
  
  private static String au(long paramLong, String paramString)
  {
    AppMethodBeat.i(371716);
    StringBuilder localStringBuilder = new StringBuilder().append(path).append(com.tencent.mm.ae.d.hF(paramLong)).append('/');
    Charset localCharset = kotlin.n.d.UTF_8;
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(371716);
      throw paramString;
    }
    paramString = paramString.getBytes(localCharset);
    s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = Base64.encodeToString(paramString, 2);
    AppMethodBeat.o(371716);
    return paramString;
  }
  
  public static void kK(List<? extends anc> paramList)
  {
    AppMethodBeat.i(371685);
    s.u(paramList, "boxContextList");
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      a((anc)paramList.next());
    }
    AppMethodBeat.o(371685);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/box/BoxContextDiskStore$Companion;", "", "()V", "TAG", "", "path", "getPath", "()Ljava/lang/String;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.a.d
 * JD-Core Version:    0.7.0.1
 */