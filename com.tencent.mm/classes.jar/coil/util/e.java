package coil.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"awaitStarted", "", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeStarted", "coil-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  /* Error */
  public static final Object a(androidx.lifecycle.j paramj, kotlin.d.d<? super kotlin.ah> paramd)
  {
    // Byte code:
    //   0: ldc 28
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: instanceof 8
    //   9: ifeq +84 -> 93
    //   12: aload_1
    //   13: checkcast 8	coil/util/e$a
    //   16: astore_2
    //   17: aload_2
    //   18: getfield 38	coil/util/e$a:label	I
    //   21: ldc 39
    //   23: iand
    //   24: ifeq +69 -> 93
    //   27: aload_2
    //   28: aload_2
    //   29: getfield 38	coil/util/e$a:label	I
    //   32: ldc 39
    //   34: iadd
    //   35: putfield 38	coil/util/e$a:label	I
    //   38: aload_2
    //   39: getfield 43	coil/util/e$a:result	Ljava/lang/Object;
    //   42: astore 4
    //   44: getstatic 49	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
    //   47: astore_3
    //   48: aload_2
    //   49: getfield 38	coil/util/e$a:label	I
    //   52: tableswitch	default:+24 -> 76, 0:+53->105, 1:+170->222
    //   77: nop
    //   78: baload
    //   79: dup
    //   80: ldc 53
    //   82: invokespecial 57	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   85: astore_0
    //   86: ldc 28
    //   88: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_0
    //   92: athrow
    //   93: new 8	coil/util/e$a
    //   96: dup
    //   97: aload_1
    //   98: invokespecial 63	coil/util/e$a:<init>	(Lkotlin/d/d;)V
    //   101: astore_2
    //   102: goto -64 -> 38
    //   105: aload 4
    //   107: invokestatic 69	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   110: new 71	kotlin/g/b/ah$f
    //   113: dup
    //   114: invokespecial 74	kotlin/g/b/ah$f:<init>	()V
    //   117: astore_1
    //   118: aload_2
    //   119: aload_0
    //   120: putfield 77	coil/util/e$a:L$0	Ljava/lang/Object;
    //   123: aload_2
    //   124: aload_1
    //   125: putfield 80	coil/util/e$a:Uf	Ljava/lang/Object;
    //   128: aload_2
    //   129: iconst_1
    //   130: putfield 38	coil/util/e$a:label	I
    //   133: new 82	kotlinx/coroutines/q
    //   136: dup
    //   137: aload_2
    //   138: invokestatic 88	kotlin/d/a/b:au	(Lkotlin/d/d;)Lkotlin/d/d;
    //   141: iconst_1
    //   142: invokespecial 91	kotlinx/coroutines/q:<init>	(Lkotlin/d/d;I)V
    //   145: astore 4
    //   147: aload 4
    //   149: invokevirtual 94	kotlinx/coroutines/q:kBA	()V
    //   152: aload_1
    //   153: new 6	coil/util/-Lifecycles$observeStarted$2$1
    //   156: dup
    //   157: aload 4
    //   159: checkcast 96	kotlinx/coroutines/p
    //   162: invokespecial 99	coil/util/-Lifecycles$observeStarted$2$1:<init>	(Lkotlinx/coroutines/p;)V
    //   165: putfield 102	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   168: aload_1
    //   169: getfield 102	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   172: astore 5
    //   174: aload 5
    //   176: invokestatic 107	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   179: aload_0
    //   180: aload 5
    //   182: checkcast 109	androidx/lifecycle/p
    //   185: invokevirtual 115	androidx/lifecycle/j:addObserver	(Landroidx/lifecycle/p;)V
    //   188: aload 4
    //   190: invokevirtual 119	kotlinx/coroutines/q:getResult	()Ljava/lang/Object;
    //   193: astore 4
    //   195: aload 4
    //   197: getstatic 49	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
    //   200: if_acmpne +9 -> 209
    //   203: aload_2
    //   204: ldc 121
    //   206: invokestatic 125	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   209: aload 4
    //   211: aload_3
    //   212: if_acmpne +106 -> 318
    //   215: ldc 28
    //   217: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: aload_3
    //   221: areturn
    //   222: aload_2
    //   223: getfield 80	coil/util/e$a:Uf	Ljava/lang/Object;
    //   226: checkcast 71	kotlin/g/b/ah$f
    //   229: astore_0
    //   230: aload_2
    //   231: getfield 77	coil/util/e$a:L$0	Ljava/lang/Object;
    //   234: checkcast 111	androidx/lifecycle/j
    //   237: astore_1
    //   238: aload 4
    //   240: invokestatic 69	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   243: aload_0
    //   244: astore_2
    //   245: aload_2
    //   246: getfield 102	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   249: checkcast 109	androidx/lifecycle/p
    //   252: astore_0
    //   253: aload_0
    //   254: ifnull +8 -> 262
    //   257: aload_1
    //   258: aload_0
    //   259: invokevirtual 128	androidx/lifecycle/j:removeObserver	(Landroidx/lifecycle/p;)V
    //   262: getstatic 134	kotlin/ah:aiuX	Lkotlin/ah;
    //   265: astore_0
    //   266: ldc 28
    //   268: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   271: aload_0
    //   272: areturn
    //   273: astore_3
    //   274: aload_0
    //   275: astore_2
    //   276: aload_3
    //   277: astore_0
    //   278: aload_1
    //   279: getfield 102	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   282: checkcast 109	androidx/lifecycle/p
    //   285: astore_1
    //   286: aload_1
    //   287: ifnull +8 -> 295
    //   290: aload_2
    //   291: aload_1
    //   292: invokevirtual 128	androidx/lifecycle/j:removeObserver	(Landroidx/lifecycle/p;)V
    //   295: ldc 28
    //   297: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: aload_0
    //   301: athrow
    //   302: astore 4
    //   304: aload_0
    //   305: astore_2
    //   306: aload_1
    //   307: astore_3
    //   308: aload 4
    //   310: astore_0
    //   311: aload_2
    //   312: astore_1
    //   313: aload_3
    //   314: astore_2
    //   315: goto -37 -> 278
    //   318: aload_1
    //   319: astore_2
    //   320: aload_0
    //   321: astore_1
    //   322: goto -77 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	paramj	androidx.lifecycle.j
    //   0	325	1	paramd	kotlin.d.d<? super kotlin.ah>
    //   16	304	2	localObject1	Object
    //   47	174	3	locala	kotlin.d.a.a
    //   273	4	3	localObject2	Object
    //   307	7	3	locald	kotlin.d.d<? super kotlin.ah>
    //   42	197	4	localObject3	Object
    //   302	7	4	localObject4	Object
    //   172	9	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   118	209	273	finally
    //   238	243	302	finally
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    a(kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(188102);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = e.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(188102);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.util.e
 * JD-Core Version:    0.7.0.1
 */