package androidx.compose.runtime;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.b;
import kotlin.d.f.c;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/BroadcastFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "onNewAwaiters", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "awaiters", "", "Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "failureCause", "", "hasAwaiters", "", "getHasAwaiters", "()Z", "lock", "", "spareList", "cancel", "cancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "fail", "cause", "sendFrame", "timeNanos", "", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "FrameAwaiter", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements al
{
  public static final int Ue = 8;
  private final a<ah> alr;
  private Throwable als;
  List<a<?>> alt;
  List<a<?>> alu;
  final Object lock;
  
  public e(a<ah> parama)
  {
    AppMethodBeat.i(202322);
    this.alr = parama;
    this.lock = new Object();
    this.alt = ((List)new ArrayList());
    this.alu = ((List)new ArrayList());
    AppMethodBeat.o(202322);
  }
  
  /* Error */
  public final <R> Object b(b<? super Long, ? extends R> arg1, d<? super R> paramd)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc 103
    //   8: invokestatic 80	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: new 105	kotlinx/coroutines/q
    //   14: dup
    //   15: aload_2
    //   16: invokestatic 111	kotlin/d/a/b:au	(Lkotlin/d/d;)Lkotlin/d/d;
    //   19: iconst_1
    //   20: invokespecial 114	kotlinx/coroutines/q:<init>	(Lkotlin/d/d;I)V
    //   23: astore 6
    //   25: aload 6
    //   27: invokevirtual 117	kotlinx/coroutines/q:kBA	()V
    //   30: aload 6
    //   32: checkcast 119	kotlinx/coroutines/p
    //   35: astore 8
    //   37: new 121	kotlin/g/b/ah$f
    //   40: dup
    //   41: invokespecial 122	kotlin/g/b/ah$f:<init>	()V
    //   44: astore 9
    //   46: aload_0
    //   47: getfield 84	androidx/compose/runtime/e:lock	Ljava/lang/Object;
    //   50: astore 7
    //   52: aload 7
    //   54: monitorenter
    //   55: aload_0
    //   56: getfield 124	androidx/compose/runtime/e:als	Ljava/lang/Throwable;
    //   59: astore 10
    //   61: aload 10
    //   63: ifnull +57 -> 120
    //   66: aload 8
    //   68: checkcast 126	kotlin/d/d
    //   71: astore_1
    //   72: getstatic 132	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   75: astore 8
    //   77: aload_1
    //   78: aload 10
    //   80: invokestatic 138	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   83: invokestatic 142	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   86: invokeinterface 146 2 0
    //   91: aload 7
    //   93: monitorexit
    //   94: aload 6
    //   96: invokevirtual 150	kotlinx/coroutines/q:getResult	()Ljava/lang/Object;
    //   99: astore_1
    //   100: aload_1
    //   101: getstatic 156	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
    //   104: if_acmpne +9 -> 113
    //   107: aload_2
    //   108: ldc 158
    //   110: invokestatic 164	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   113: ldc 103
    //   115: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_1
    //   119: areturn
    //   120: aload 9
    //   122: new 8	androidx/compose/runtime/e$a
    //   125: dup
    //   126: aload_1
    //   127: aload 8
    //   129: checkcast 126	kotlin/d/d
    //   132: invokespecial 167	androidx/compose/runtime/e$a:<init>	(Lkotlin/g/a/b;Lkotlin/d/d;)V
    //   135: putfield 170	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   138: aload_0
    //   139: getfield 91	androidx/compose/runtime/e:alt	Ljava/util/List;
    //   142: checkcast 172	java/util/Collection
    //   145: invokeinterface 175 1 0
    //   150: ifne +114 -> 264
    //   153: iconst_1
    //   154: istore_3
    //   155: aload_0
    //   156: getfield 91	androidx/compose/runtime/e:alt	Ljava/util/List;
    //   159: astore 10
    //   161: aload 9
    //   163: getfield 170	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   166: ifnonnull +103 -> 269
    //   169: ldc 177
    //   171: invokestatic 181	kotlin/g/b/s:bIx	(Ljava/lang/String;)V
    //   174: aconst_null
    //   175: astore_1
    //   176: aload 10
    //   178: aload_1
    //   179: invokeinterface 185 2 0
    //   184: pop
    //   185: iload_3
    //   186: ifne +95 -> 281
    //   189: iload 5
    //   191: istore_3
    //   192: aload 7
    //   194: monitorexit
    //   195: aload 8
    //   197: new 11	androidx/compose/runtime/e$b
    //   200: dup
    //   201: aload_0
    //   202: aload 9
    //   204: invokespecial 188	androidx/compose/runtime/e$b:<init>	(Landroidx/compose/runtime/e;Lkotlin/g/b/ah$f;)V
    //   207: checkcast 190	kotlin/g/a/b
    //   210: invokeinterface 194 2 0
    //   215: iload_3
    //   216: ifeq -122 -> 94
    //   219: aload_0
    //   220: getfield 82	androidx/compose/runtime/e:alr	Lkotlin/g/a/a;
    //   223: ifnull -129 -> 94
    //   226: aload_0
    //   227: getfield 82	androidx/compose/runtime/e:alr	Lkotlin/g/a/a;
    //   230: invokeinterface 199 1 0
    //   235: pop
    //   236: goto -142 -> 94
    //   239: astore 7
    //   241: aload_0
    //   242: getfield 84	androidx/compose/runtime/e:lock	Ljava/lang/Object;
    //   245: astore_1
    //   246: aload_1
    //   247: monitorenter
    //   248: aload_0
    //   249: getfield 124	androidx/compose/runtime/e:als	Ljava/lang/Throwable;
    //   252: astore 8
    //   254: aload 8
    //   256: ifnull +41 -> 297
    //   259: aload_1
    //   260: monitorexit
    //   261: goto -167 -> 94
    //   264: iconst_0
    //   265: istore_3
    //   266: goto -111 -> 155
    //   269: aload 9
    //   271: getfield 170	kotlin/g/b/ah$f:aqH	Ljava/lang/Object;
    //   274: checkcast 8	androidx/compose/runtime/e$a
    //   277: astore_1
    //   278: goto -102 -> 176
    //   281: iconst_0
    //   282: istore_3
    //   283: goto -91 -> 192
    //   286: astore_1
    //   287: aload 7
    //   289: monitorexit
    //   290: ldc 103
    //   292: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   295: aload_1
    //   296: athrow
    //   297: aload_0
    //   298: aload 7
    //   300: putfield 124	androidx/compose/runtime/e:als	Ljava/lang/Throwable;
    //   303: aload_0
    //   304: getfield 91	androidx/compose/runtime/e:alt	Ljava/util/List;
    //   307: astore 8
    //   309: aload 8
    //   311: invokeinterface 203 1 0
    //   316: iconst_1
    //   317: isub
    //   318: istore 5
    //   320: iload 5
    //   322: iflt +54 -> 376
    //   325: iload 4
    //   327: istore_3
    //   328: iload_3
    //   329: iconst_1
    //   330: iadd
    //   331: istore 4
    //   333: aload 8
    //   335: iload_3
    //   336: invokeinterface 207 2 0
    //   341: checkcast 8	androidx/compose/runtime/e$a
    //   344: getfield 211	androidx/compose/runtime/e$a:alw	Lkotlin/d/d;
    //   347: astore 9
    //   349: getstatic 132	kotlin/Result:Companion	Lkotlin/Result$Companion;
    //   352: astore 10
    //   354: aload 9
    //   356: aload 7
    //   358: invokestatic 138	kotlin/ResultKt:createFailure	(Ljava/lang/Throwable;)Ljava/lang/Object;
    //   361: invokestatic 142	kotlin/Result:constructor-impl	(Ljava/lang/Object;)Ljava/lang/Object;
    //   364: invokeinterface 146 2 0
    //   369: iload 4
    //   371: iload 5
    //   373: if_icmple +32 -> 405
    //   376: aload_0
    //   377: getfield 91	androidx/compose/runtime/e:alt	Ljava/util/List;
    //   380: invokeinterface 214 1 0
    //   385: getstatic 220	kotlin/ah:aiuX	Lkotlin/ah;
    //   388: astore 7
    //   390: aload_1
    //   391: monitorexit
    //   392: goto -298 -> 94
    //   395: astore_2
    //   396: aload_1
    //   397: monitorexit
    //   398: ldc 103
    //   400: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: aload_2
    //   404: athrow
    //   405: iload 4
    //   407: istore_3
    //   408: goto -80 -> 328
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	e
    //   0	411	2	paramd	d<? super R>
    //   154	254	3	i	int
    //   4	402	4	j	int
    //   1	373	5	k	int
    //   23	72	6	localq	kotlinx.coroutines.q
    //   50	143	7	localObject1	Object
    //   239	118	7	localThrowable	Throwable
    //   388	1	7	localah	ah
    //   35	299	8	localObject2	Object
    //   44	311	9	localObject3	Object
    //   59	294	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   226	236	239	finally
    //   55	61	286	finally
    //   66	91	286	finally
    //   120	153	286	finally
    //   155	174	286	finally
    //   176	185	286	finally
    //   269	278	286	finally
    //   248	254	395	finally
    //   297	320	395	finally
    //   333	369	395	finally
    //   376	390	395	finally
  }
  
  public final <R> R fold(R paramR, m<? super R, ? super f.b, ? extends R> paramm)
  {
    AppMethodBeat.i(202402);
    paramR = al.a.a((al)this, paramR, paramm);
    AppMethodBeat.o(202402);
    return paramR;
  }
  
  public final <E extends f.b> E get(f.c<E> paramc)
  {
    AppMethodBeat.i(202397);
    paramc = al.a.a((al)this, paramc);
    AppMethodBeat.o(202397);
    return paramc;
  }
  
  public final f.c<?> getKey()
  {
    AppMethodBeat.i(202423);
    f.c localc = al.a.a(this);
    AppMethodBeat.o(202423);
    return localc;
  }
  
  public final f minusKey(f.c<?> paramc)
  {
    AppMethodBeat.i(202406);
    paramc = al.a.b((al)this, paramc);
    AppMethodBeat.o(202406);
    return paramc;
  }
  
  public final boolean nT()
  {
    AppMethodBeat.i(202365);
    synchronized (this.lock)
    {
      boolean bool = ((Collection)this.alt).isEmpty();
      if (!bool)
      {
        bool = true;
        AppMethodBeat.o(202365);
        return bool;
      }
      bool = false;
    }
  }
  
  public final f plus(f paramf)
  {
    AppMethodBeat.i(202413);
    paramf = al.a.a((al)this, paramf);
    AppMethodBeat.o(202413);
    return paramf;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/BroadcastFrameClock$FrameAwaiter;", "R", "", "onFrame", "Lkotlin/Function1;", "", "continuation", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "getContinuation", "()Lkotlin/coroutines/Continuation;", "getOnFrame", "()Lkotlin/jvm/functions/Function1;", "resume", "", "timeNanos", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a<R>
  {
    final b<Long, R> alv;
    final d<R> alw;
    
    public a(b<? super Long, ? extends R> paramb, d<? super R> paramd)
    {
      AppMethodBeat.i(202161);
      this.alv = paramb;
      this.alw = paramd;
      AppMethodBeat.o(202161);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "R", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Throwable, ah>
  {
    b(e parame, ah.f<e.a<R>> paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.e
 * JD-Core Version:    0.7.0.1
 */