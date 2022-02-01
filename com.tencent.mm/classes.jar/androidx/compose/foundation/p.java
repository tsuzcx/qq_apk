package androidx.compose.foundation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.e.c;
import kotlinx.coroutines.e.e;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/MutatorMutex;", "", "()V", "currentMutator", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/foundation/MutatorMutex$Mutator;", "Landroidx/compose/foundation/AtomicReference;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "mutate", "R", "priority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mutateWith", "T", "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryMutateOrCancel", "", "mutator", "Mutator", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  final c VA;
  final AtomicReference<a> Vz;
  
  public p()
  {
    AppMethodBeat.i(203584);
    this.Vz = new AtomicReference(null);
    this.VA = e.kEM();
    AppMethodBeat.o(203584);
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/MutatorMutex$Mutator;", "", "priority", "Landroidx/compose/foundation/MutatePriority;", "job", "Lkotlinx/coroutines/Job;", "(Landroidx/compose/foundation/MutatePriority;Lkotlinx/coroutines/Job;)V", "getJob", "()Lkotlinx/coroutines/Job;", "getPriority", "()Landroidx/compose/foundation/MutatePriority;", "canInterrupt", "", "other", "cancel", "", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    final o Zd;
    final cb job;
    
    public a(o paramo, cb paramcb)
    {
      AppMethodBeat.i(203516);
      this.Zd = paramo;
      this.job = paramcb;
      AppMethodBeat.o(203516);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends k
    implements m<aq, d<? super R>, Object>
  {
    Object Uf;
    Object VC;
    Object VD;
    Object Ze;
    int label;
    
    public b(o paramo, p paramp, m<? super T, ? super d<? super R>, ? extends Object> paramm, T paramT, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(203536);
      paramd = new b(this.Zf, this.Zg, this.VV, this.Zh, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(203536);
      return paramObject;
    }
    
    /* Error */
    public final Object invokeSuspend(Object paramObject)
    {
      // Byte code:
      //   0: ldc 94
      //   2: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: getstatic 100	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
      //   8: astore 8
      //   10: aload_0
      //   11: getfield 102	androidx/compose/foundation/p$b:label	I
      //   14: tableswitch	default:+26 -> 40, 0:+43->57, 1:+286->300, 2:+392->406
      //   41: nop
      //   42: imul
      //   43: dup
      //   44: ldc 106
      //   46: invokespecial 109	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   49: astore_1
      //   50: ldc 94
      //   52: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   55: aload_1
      //   56: athrow
      //   57: aload_1
      //   58: invokestatic 115	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   61: aload_0
      //   62: getfield 70	androidx/compose/foundation/p$b:L$0	Ljava/lang/Object;
      //   65: checkcast 81	kotlinx/coroutines/aq
      //   68: astore_3
      //   69: aload_0
      //   70: getfield 45	androidx/compose/foundation/p$b:Zf	Landroidx/compose/foundation/o;
      //   73: astore_1
      //   74: aload_3
      //   75: invokeinterface 119 1 0
      //   80: getstatic 125	kotlinx/coroutines/cb:ajws	Lkotlinx/coroutines/cb$b;
      //   83: checkcast 127	kotlin/d/f$c
      //   86: invokeinterface 133 2 0
      //   91: astore_3
      //   92: aload_3
      //   93: invokestatic 138	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
      //   96: new 140	androidx/compose/foundation/p$a
      //   99: dup
      //   100: aload_1
      //   101: aload_3
      //   102: checkcast 121	kotlinx/coroutines/cb
      //   105: invokespecial 143	androidx/compose/foundation/p$a:<init>	(Landroidx/compose/foundation/o;Lkotlinx/coroutines/cb;)V
      //   108: astore_3
      //   109: aload_0
      //   110: getfield 47	androidx/compose/foundation/p$b:Zg	Landroidx/compose/foundation/p;
      //   113: astore_1
      //   114: aload_1
      //   115: getfield 147	androidx/compose/foundation/p:Vz	Ljava/util/concurrent/atomic/AtomicReference;
      //   118: invokevirtual 152	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
      //   121: checkcast 140	androidx/compose/foundation/p$a
      //   124: astore 4
      //   126: aload 4
      //   128: ifnull +34 -> 162
      //   131: aload 4
      //   133: ldc 154
      //   135: invokestatic 158	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
      //   138: aload_3
      //   139: getfield 161	androidx/compose/foundation/p$a:Zd	Landroidx/compose/foundation/o;
      //   142: aload 4
      //   144: getfield 161	androidx/compose/foundation/p$a:Zd	Landroidx/compose/foundation/o;
      //   147: checkcast 163	java/lang/Enum
      //   150: invokevirtual 169	androidx/compose/foundation/o:compareTo	(Ljava/lang/Enum;)I
      //   153: iflt +125 -> 278
      //   156: iconst_1
      //   157: istore_2
      //   158: iload_2
      //   159: ifeq +124 -> 283
      //   162: aload_1
      //   163: getfield 147	androidx/compose/foundation/p:Vz	Ljava/util/concurrent/atomic/AtomicReference;
      //   166: aload 4
      //   168: aload_3
      //   169: invokevirtual 173	java/util/concurrent/atomic/AtomicReference:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   172: ifeq -58 -> 114
      //   175: aload 4
      //   177: ifnull +14 -> 191
      //   180: aload 4
      //   182: getfield 177	androidx/compose/foundation/p$a:job	Lkotlinx/coroutines/cb;
      //   185: aconst_null
      //   186: invokeinterface 181 2 0
      //   191: aload_0
      //   192: getfield 47	androidx/compose/foundation/p$b:Zg	Landroidx/compose/foundation/p;
      //   195: getfield 185	androidx/compose/foundation/p:VA	Lkotlinx/coroutines/e/c;
      //   198: astore 4
      //   200: aload_0
      //   201: getfield 49	androidx/compose/foundation/p$b:VV	Lkotlin/g/a/m;
      //   204: astore 6
      //   206: aload_0
      //   207: getfield 51	androidx/compose/foundation/p$b:Zh	Ljava/lang/Object;
      //   210: astore 5
      //   212: aload_0
      //   213: getfield 47	androidx/compose/foundation/p$b:Zg	Landroidx/compose/foundation/p;
      //   216: astore_1
      //   217: aload_0
      //   218: checkcast 72	kotlin/d/d
      //   221: astore 7
      //   223: aload_0
      //   224: aload_3
      //   225: putfield 70	androidx/compose/foundation/p$b:L$0	Ljava/lang/Object;
      //   228: aload_0
      //   229: aload 4
      //   231: putfield 187	androidx/compose/foundation/p$b:Uf	Ljava/lang/Object;
      //   234: aload_0
      //   235: aload 6
      //   237: putfield 189	androidx/compose/foundation/p$b:VC	Ljava/lang/Object;
      //   240: aload_0
      //   241: aload 5
      //   243: putfield 191	androidx/compose/foundation/p$b:VD	Ljava/lang/Object;
      //   246: aload_0
      //   247: aload_1
      //   248: putfield 193	androidx/compose/foundation/p$b:Ze	Ljava/lang/Object;
      //   251: aload_0
      //   252: iconst_1
      //   253: putfield 102	androidx/compose/foundation/p$b:label	I
      //   256: aload 4
      //   258: aload 7
      //   260: invokeinterface 199 2 0
      //   265: aload 8
      //   267: if_acmpne +303 -> 570
      //   270: ldc 94
      //   272: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   275: aload 8
      //   277: areturn
      //   278: iconst_0
      //   279: istore_2
      //   280: goto -122 -> 158
      //   283: new 201	java/util/concurrent/CancellationException
      //   286: dup
      //   287: ldc 203
      //   289: invokespecial 204	java/util/concurrent/CancellationException:<init>	(Ljava/lang/String;)V
      //   292: astore_1
      //   293: ldc 94
      //   295: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   298: aload_1
      //   299: athrow
      //   300: aload_0
      //   301: getfield 193	androidx/compose/foundation/p$b:Ze	Ljava/lang/Object;
      //   304: checkcast 9	androidx/compose/foundation/p
      //   307: astore 7
      //   309: aload_0
      //   310: getfield 191	androidx/compose/foundation/p$b:VD	Ljava/lang/Object;
      //   313: astore 5
      //   315: aload_0
      //   316: getfield 189	androidx/compose/foundation/p$b:VC	Ljava/lang/Object;
      //   319: checkcast 7	kotlin/g/a/m
      //   322: astore 6
      //   324: aload_0
      //   325: getfield 187	androidx/compose/foundation/p$b:Uf	Ljava/lang/Object;
      //   328: checkcast 195	kotlinx/coroutines/e/c
      //   331: astore 4
      //   333: aload_0
      //   334: getfield 70	androidx/compose/foundation/p$b:L$0	Ljava/lang/Object;
      //   337: checkcast 140	androidx/compose/foundation/p$a
      //   340: astore_3
      //   341: aload_1
      //   342: invokestatic 115	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   345: aload 7
      //   347: astore_1
      //   348: aload_0
      //   349: aload_3
      //   350: putfield 70	androidx/compose/foundation/p$b:L$0	Ljava/lang/Object;
      //   353: aload_0
      //   354: aload 4
      //   356: putfield 187	androidx/compose/foundation/p$b:Uf	Ljava/lang/Object;
      //   359: aload_0
      //   360: aload_1
      //   361: putfield 189	androidx/compose/foundation/p$b:VC	Ljava/lang/Object;
      //   364: aload_0
      //   365: aconst_null
      //   366: putfield 191	androidx/compose/foundation/p$b:VD	Ljava/lang/Object;
      //   369: aload_0
      //   370: aconst_null
      //   371: putfield 193	androidx/compose/foundation/p$b:Ze	Ljava/lang/Object;
      //   374: aload_0
      //   375: iconst_2
      //   376: putfield 102	androidx/compose/foundation/p$b:label	I
      //   379: aload 6
      //   381: aload 5
      //   383: aload_0
      //   384: invokeinterface 206 3 0
      //   389: astore 5
      //   391: aload 5
      //   393: aload 8
      //   395: if_acmpne +159 -> 554
      //   398: ldc 94
      //   400: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   403: aload 8
      //   405: areturn
      //   406: aload_0
      //   407: getfield 189	androidx/compose/foundation/p$b:VC	Ljava/lang/Object;
      //   410: checkcast 9	androidx/compose/foundation/p
      //   413: astore_3
      //   414: aload_0
      //   415: getfield 187	androidx/compose/foundation/p$b:Uf	Ljava/lang/Object;
      //   418: checkcast 195	kotlinx/coroutines/e/c
      //   421: astore 4
      //   423: aload_0
      //   424: getfield 70	androidx/compose/foundation/p$b:L$0	Ljava/lang/Object;
      //   427: checkcast 140	androidx/compose/foundation/p$a
      //   430: astore 5
      //   432: aload_1
      //   433: invokestatic 115	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   436: aload 5
      //   438: astore 6
      //   440: aload_1
      //   441: astore 5
      //   443: aload 4
      //   445: astore_1
      //   446: aload_3
      //   447: astore 4
      //   449: aload 4
      //   451: getfield 147	androidx/compose/foundation/p:Vz	Ljava/util/concurrent/atomic/AtomicReference;
      //   454: aload 6
      //   456: aconst_null
      //   457: invokevirtual 173	java/util/concurrent/atomic/AtomicReference:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   460: pop
      //   461: aload_1
      //   462: aconst_null
      //   463: invokeinterface 209 2 0
      //   468: ldc 94
      //   470: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   473: aload 5
      //   475: areturn
      //   476: astore 5
      //   478: aload 4
      //   480: astore 6
      //   482: aload_3
      //   483: astore 4
      //   485: aload 6
      //   487: astore_3
      //   488: aload_1
      //   489: getfield 147	androidx/compose/foundation/p:Vz	Ljava/util/concurrent/atomic/AtomicReference;
      //   492: aload 4
      //   494: aconst_null
      //   495: invokevirtual 173	java/util/concurrent/atomic/AtomicReference:compareAndSet	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   498: pop
      //   499: ldc 94
      //   501: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   504: aload 5
      //   506: athrow
      //   507: astore_1
      //   508: aload_3
      //   509: aconst_null
      //   510: invokeinterface 209 2 0
      //   515: ldc 94
      //   517: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   520: aload_1
      //   521: athrow
      //   522: astore 4
      //   524: aload_1
      //   525: astore_3
      //   526: aload 4
      //   528: astore_1
      //   529: goto -21 -> 508
      //   532: astore 6
      //   534: aload 5
      //   536: astore 7
      //   538: aload_3
      //   539: astore_1
      //   540: aload 6
      //   542: astore 5
      //   544: aload 4
      //   546: astore_3
      //   547: aload 7
      //   549: astore 4
      //   551: goto -63 -> 488
      //   554: aload 4
      //   556: astore 6
      //   558: aload_1
      //   559: astore 4
      //   561: aload 6
      //   563: astore_1
      //   564: aload_3
      //   565: astore 6
      //   567: goto -118 -> 449
      //   570: goto -222 -> 348
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	573	0	this	b
      //   0	573	1	paramObject	Object
      //   157	123	2	i	int
      //   68	497	3	localObject1	Object
      //   124	369	4	localObject2	Object
      //   522	23	4	localObject3	Object
      //   549	11	4	localObject4	Object
      //   210	264	5	localObject5	Object
      //   476	59	5	localObject6	Object
      //   542	1	5	localObject7	Object
      //   204	282	6	localObject8	Object
      //   532	9	6	localObject9	Object
      //   556	10	6	localObject10	Object
      //   221	327	7	localObject11	Object
      //   8	396	8	locala	kotlin.d.a.a
      // Exception table:
      //   from	to	target	type
      //   348	391	476	finally
      //   488	507	507	finally
      //   449	461	522	finally
      //   432	436	532	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.p
 * JD-Core Version:    0.7.0.1
 */