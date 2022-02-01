package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.e.c;
import kotlinx.coroutines.e.e;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/MutatorMutex;", "", "()V", "currentMutator", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/animation/core/MutatorMutex$Mutator;", "Landroidx/compose/animation/core/AtomicReference;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "mutate", "R", "priority", "Landroidx/compose/animation/core/MutatePriority;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/animation/core/MutatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mutateWith", "T", "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/animation/core/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryMutateOrCancel", "", "mutator", "Mutator", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
{
  final c VA;
  final AtomicReference<al.a> Vz;
  
  public al()
  {
    AppMethodBeat.i(203367);
    this.Vz = new AtomicReference(null);
    this.VA = e.kEM();
    AppMethodBeat.o(203367);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super R>, Object>
  {
    Object Uf;
    Object VC;
    Object VD;
    int label;
    
    b(ak paramak, al paramal, b<? super d<? super R>, ? extends Object> paramb, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(203447);
      paramd = new b(this.VE, this.VF, this.Uk, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(203447);
      return paramObject;
    }
    
    /* Error */
    public final Object invokeSuspend(Object paramObject)
    {
      // Byte code:
      //   0: ldc 88
      //   2: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: getstatic 94	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
      //   8: astore 7
      //   10: aload_0
      //   11: getfield 96	androidx/compose/a/a/al$b:label	I
      //   14: tableswitch	default:+26 -> 40, 0:+43->57, 1:+274->288, 2:+367->381
      //   41: nop
      //   42: fadd
      //   43: dup
      //   44: ldc 100
      //   46: invokespecial 103	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   49: astore_1
      //   50: ldc 88
      //   52: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   55: aload_1
      //   56: athrow
      //   57: aload_1
      //   58: invokestatic 109	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   61: aload_0
      //   62: getfield 64	androidx/compose/a/a/al$b:L$0	Ljava/lang/Object;
      //   65: checkcast 75	kotlinx/coroutines/aq
      //   68: astore_3
      //   69: aload_0
      //   70: getfield 41	androidx/compose/a/a/al$b:VE	Landroidx/compose/a/a/ak;
      //   73: astore_1
      //   74: aload_3
      //   75: invokeinterface 113 1 0
      //   80: getstatic 119	kotlinx/coroutines/cb:ajws	Lkotlinx/coroutines/cb$b;
      //   83: checkcast 121	kotlin/d/f$c
      //   86: invokeinterface 127 2 0
      //   91: astore_3
      //   92: aload_3
      //   93: invokestatic 132	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
      //   96: new 134	androidx/compose/a/a/al$a
      //   99: dup
      //   100: aload_1
      //   101: aload_3
      //   102: checkcast 115	kotlinx/coroutines/cb
      //   105: invokespecial 137	androidx/compose/a/a/al$a:<init>	(Landroidx/compose/a/a/ak;Lkotlinx/coroutines/cb;)V
      //   108: astore_3
      //   109: aload_0
      //   110: getfield 43	androidx/compose/a/a/al$b:VF	Landroidx/compose/a/a/al;
      //   113: astore_1
      //   114: aload_1
      //   115: getfield 141	androidx/compose/a/a/al:Vz	Ljava/util/concurrent/atomic/AtomicReference;
      //   118: invokevirtual 146	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   121: checkcast 134	androidx/compose/a/a/al$a
      //   124: astore 4
      //   126: aload 4
      //   128: ifnull +34 -> 162
      //   131: aload 4
      //   133: ldc 148
      //   135: invokestatic 152	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
      //   138: aload_3
      //   139: getfield 155	androidx/compose/a/a/al$a:VB	Landroidx/compose/a/a/ak;
      //   142: aload 4
      //   144: getfield 155	androidx/compose/a/a/al$a:VB	Landroidx/compose/a/a/ak;
      //   147: checkcast 157	java/lang/Enum
      //   150: invokevirtual 163	androidx/compose/a/a/ak:compareTo	(Ljava/lang/Enum;)I
      //   153: iflt +113 -> 266
      //   156: iconst_1
      //   157: istore_2
      //   158: iload_2
      //   159: ifeq +112 -> 271
      //   162: aload_1
      //   163: getfield 141	androidx/compose/a/a/al:Vz	Ljava/util/concurrent/atomic/AtomicReference;
      //   166: aload 4
      //   168: aload_3
      //   169: invokevirtual 167	java/util/concurrent/atomic/AtomicReference:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   172: ifeq -58 -> 114
      //   175: aload 4
      //   177: ifnull +14 -> 191
      //   180: aload 4
      //   182: getfield 171	androidx/compose/a/a/al$a:job	Lkotlinx/coroutines/cb;
      //   185: aconst_null
      //   186: invokeinterface 175 2 0
      //   191: aload_0
      //   192: getfield 43	androidx/compose/a/a/al$b:VF	Landroidx/compose/a/a/al;
      //   195: getfield 179	androidx/compose/a/a/al:VA	Lkotlinx/coroutines/e/c;
      //   198: astore 4
      //   200: aload_0
      //   201: getfield 45	androidx/compose/a/a/al$b:Uk	Lkotlin/g/a/b;
      //   204: astore 5
      //   206: aload_0
      //   207: getfield 43	androidx/compose/a/a/al$b:VF	Landroidx/compose/a/a/al;
      //   210: astore_1
      //   211: aload_0
      //   212: checkcast 66	kotlin/d/d
      //   215: astore 6
      //   217: aload_0
      //   218: aload_3
      //   219: putfield 64	androidx/compose/a/a/al$b:L$0	Ljava/lang/Object;
      //   222: aload_0
      //   223: aload 4
      //   225: putfield 181	androidx/compose/a/a/al$b:Uf	Ljava/lang/Object;
      //   228: aload_0
      //   229: aload 5
      //   231: putfield 183	androidx/compose/a/a/al$b:VC	Ljava/lang/Object;
      //   234: aload_0
      //   235: aload_1
      //   236: putfield 185	androidx/compose/a/a/al$b:VD	Ljava/lang/Object;
      //   239: aload_0
      //   240: iconst_1
      //   241: putfield 96	androidx/compose/a/a/al$b:label	I
      //   244: aload 4
      //   246: aload 6
      //   248: invokeinterface 191 2 0
      //   253: aload 7
      //   255: if_acmpne +290 -> 545
      //   258: ldc 88
      //   260: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   263: aload 7
      //   265: areturn
      //   266: iconst_0
      //   267: istore_2
      //   268: goto -110 -> 158
      //   271: new 193	java/util/concurrent/CancellationException
      //   274: dup
      //   275: ldc 195
      //   277: invokespecial 196	java/util/concurrent/CancellationException:<init>	(Ljava/lang/String;)V
      //   280: astore_1
      //   281: ldc 88
      //   283: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   286: aload_1
      //   287: athrow
      //   288: aload_0
      //   289: getfield 185	androidx/compose/a/a/al$b:VD	Ljava/lang/Object;
      //   292: checkcast 9	androidx/compose/a/a/al
      //   295: astore 6
      //   297: aload_0
      //   298: getfield 183	androidx/compose/a/a/al$b:VC	Ljava/lang/Object;
      //   301: checkcast 198	kotlin/g/a/b
      //   304: astore 5
      //   306: aload_0
      //   307: getfield 181	androidx/compose/a/a/al$b:Uf	Ljava/lang/Object;
      //   310: checkcast 187	kotlinx/coroutines/e/c
      //   313: astore 4
      //   315: aload_0
      //   316: getfield 64	androidx/compose/a/a/al$b:L$0	Ljava/lang/Object;
      //   319: checkcast 134	androidx/compose/a/a/al$a
      //   322: astore_3
      //   323: aload_1
      //   324: invokestatic 109	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   327: aload 6
      //   329: astore_1
      //   330: aload_0
      //   331: aload_3
      //   332: putfield 64	androidx/compose/a/a/al$b:L$0	Ljava/lang/Object;
      //   335: aload_0
      //   336: aload 4
      //   338: putfield 181	androidx/compose/a/a/al$b:Uf	Ljava/lang/Object;
      //   341: aload_0
      //   342: aload_1
      //   343: putfield 183	androidx/compose/a/a/al$b:VC	Ljava/lang/Object;
      //   346: aload_0
      //   347: aconst_null
      //   348: putfield 185	androidx/compose/a/a/al$b:VD	Ljava/lang/Object;
      //   351: aload_0
      //   352: iconst_2
      //   353: putfield 96	androidx/compose/a/a/al$b:label	I
      //   356: aload 5
      //   358: aload_0
      //   359: invokeinterface 200 2 0
      //   364: astore 5
      //   366: aload 5
      //   368: aload 7
      //   370: if_acmpne +159 -> 529
      //   373: ldc 88
      //   375: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   378: aload 7
      //   380: areturn
      //   381: aload_0
      //   382: getfield 183	androidx/compose/a/a/al$b:VC	Ljava/lang/Object;
      //   385: checkcast 9	androidx/compose/a/a/al
      //   388: astore_3
      //   389: aload_0
      //   390: getfield 181	androidx/compose/a/a/al$b:Uf	Ljava/lang/Object;
      //   393: checkcast 187	kotlinx/coroutines/e/c
      //   396: astore 4
      //   398: aload_0
      //   399: getfield 64	androidx/compose/a/a/al$b:L$0	Ljava/lang/Object;
      //   402: checkcast 134	androidx/compose/a/a/al$a
      //   405: astore 5
      //   407: aload_1
      //   408: invokestatic 109	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   411: aload 5
      //   413: astore 6
      //   415: aload_1
      //   416: astore 5
      //   418: aload 4
      //   420: astore_1
      //   421: aload_3
      //   422: astore 4
      //   424: aload 4
      //   426: getfield 141	androidx/compose/a/a/al:Vz	Ljava/util/concurrent/atomic/AtomicReference;
      //   429: aload 6
      //   431: aconst_null
      //   432: invokevirtual 167	java/util/concurrent/atomic/AtomicReference:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   435: pop
      //   436: aload_1
      //   437: aconst_null
      //   438: invokeinterface 203 2 0
      //   443: ldc 88
      //   445: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   448: aload 5
      //   450: areturn
      //   451: astore 5
      //   453: aload 4
      //   455: astore 6
      //   457: aload_3
      //   458: astore 4
      //   460: aload 6
      //   462: astore_3
      //   463: aload_1
      //   464: getfield 141	androidx/compose/a/a/al:Vz	Ljava/util/concurrent/atomic/AtomicReference;
      //   467: aload 4
      //   469: aconst_null
      //   470: invokevirtual 167	java/util/concurrent/atomic/AtomicReference:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   473: pop
      //   474: ldc 88
      //   476: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   479: aload 5
      //   481: athrow
      //   482: astore_1
      //   483: aload_3
      //   484: aconst_null
      //   485: invokeinterface 203 2 0
      //   490: ldc 88
      //   492: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   495: aload_1
      //   496: athrow
      //   497: astore 4
      //   499: aload_1
      //   500: astore_3
      //   501: aload 4
      //   503: astore_1
      //   504: goto -21 -> 483
      //   507: astore 6
      //   509: aload 5
      //   511: astore 7
      //   513: aload_3
      //   514: astore_1
      //   515: aload 6
      //   517: astore 5
      //   519: aload 4
      //   521: astore_3
      //   522: aload 7
      //   524: astore 4
      //   526: goto -63 -> 463
      //   529: aload 4
      //   531: astore 6
      //   533: aload_1
      //   534: astore 4
      //   536: aload 6
      //   538: astore_1
      //   539: aload_3
      //   540: astore 6
      //   542: goto -118 -> 424
      //   545: goto -215 -> 330
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	548	0	this	b
      //   0	548	1	paramObject	Object
      //   157	111	2	i	int
      //   68	472	3	localObject1	Object
      //   124	344	4	localObject2	Object
      //   497	23	4	localObject3	Object
      //   524	11	4	localObject4	Object
      //   204	245	5	localObject5	Object
      //   451	59	5	localObject6	Object
      //   517	1	5	localObject7	Object
      //   215	246	6	localObject8	Object
      //   507	9	6	localObject9	Object
      //   531	10	6	localObject10	Object
      //   8	515	7	localObject11	Object
      // Exception table:
      //   from	to	target	type
      //   330	366	451	finally
      //   463	482	482	finally
      //   424	436	497	finally
      //   407	411	507	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.al
 * JD-Core Version:    0.7.0.1
 */