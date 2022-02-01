package androidx.compose.runtime;

import androidx.compose.runtime.b.a.a.a.a.a.l;
import androidx.compose.runtime.f.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.j;

@Metadata(d1={""}, d2={"derivedStateObservers", "Landroidx/compose/runtime/SnapshotThreadLocal;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Lkotlin/Pair;", "Lkotlin/Function1;", "Landroidx/compose/runtime/DerivedState;", "", "Landroidx/compose/runtime/DerivedStateObservers;", "derivedStateOf", "Landroidx/compose/runtime/State;", "T", "calculation", "Lkotlin/Function0;", "mutableStateListOf", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "elements", "", "([Ljava/lang/Object;)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "mutableStateMapOf", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "K", "V", "pairs", "([Lkotlin/Pair;)Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "mutableStateOf", "Landroidx/compose/runtime/MutableState;", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)Landroidx/compose/runtime/MutableState;", "neverEqualPolicy", "notifyObservers", "R", "derivedState", "block", "(Landroidx/compose/runtime/DerivedState;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "observeDerivedStateRecalculations", "start", "Lkotlin/ParameterName;", "name", "done", "produceState", "initialValue", "key1", "", "key2", "key3", "producer", "Lkotlin/Function2;", "Landroidx/compose/runtime/ProduceStateScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "keys", "(Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "referentialEqualityPolicy", "rememberUpdatedState", "newValue", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "snapshotFlow", "Lkotlinx/coroutines/flow/Flow;", "structuralEqualityPolicy", "collectAsState", "initial", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Lkotlinx/coroutines/flow/StateFlow;", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/CoroutineContext;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "getValue", "thisObj", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/compose/runtime/State;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "intersects", "", "", "other", "setValue", "(Landroidx/compose/runtime/MutableState;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toMutableStateList", "", "toMutableStateMap", "", "DerivedStateObservers", "runtime_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class bj
{
  private static final bk<androidx.compose.runtime.b.a.a.a.h<kotlin.r<kotlin.g.a.b<v<?>, ah>, kotlin.g.a.b<v<?>, ah>>>> aqb;
  
  static
  {
    AppMethodBeat.i(202142);
    aqb = new bk();
    AppMethodBeat.o(202142);
  }
  
  public static final <R> void a(kotlin.g.a.b<? super bm<?>, ah> paramb1, kotlin.g.a.b<? super bm<?>, ah> paramb2, a<? extends R> parama)
  {
    AppMethodBeat.i(202076);
    s.u(paramb1, "start");
    s.u(paramb2, "done");
    s.u(parama, "block");
    androidx.compose.runtime.b.a.a.a.h localh3 = (androidx.compose.runtime.b.a.a.a.h)aqb.get();
    try
    {
      bk localbk = aqb;
      androidx.compose.runtime.b.a.a.a.h localh2 = (androidx.compose.runtime.b.a.a.a.h)localbk.get();
      androidx.compose.runtime.b.a.a.a.h localh1 = localh2;
      if (localh2 == null) {
        localh1 = l.qG();
      }
      localbk.set(localh1.X(kotlin.v.Y(paramb1, paramb2)));
      parama.invoke();
      return;
    }
    finally
    {
      aqb.set(localh3);
      AppMethodBeat.o(202076);
    }
  }
  
  public static final <T> an<T> b(T paramT, bi<T> parambi)
  {
    AppMethodBeat.i(202010);
    s.u(parambi, "policy");
    paramT = (an)b.a(paramT, parambi);
    AppMethodBeat.o(202010);
    return paramT;
  }
  
  public static final <T> bm<T> b(T paramT, h paramh)
  {
    AppMethodBeat.i(202093);
    paramh.bx(-1519447800);
    paramh.bx(-3687241);
    Object localObject2 = paramh.or();
    Object localObject1 = h.alD;
    localObject1 = localObject2;
    if (localObject2 == h.a.ox())
    {
      localObject1 = T(paramT);
      paramh.F(localObject1);
    }
    paramh.od();
    ((an)localObject1).setValue(paramT);
    paramT = (an)localObject1;
    paramh.od();
    paramT = (bm)paramT;
    AppMethodBeat.o(202093);
    return paramT;
  }
  
  public static final <T> bm<T> f(a<? extends T> parama)
  {
    AppMethodBeat.i(202060);
    s.u(parama, "calculation");
    parama = (bm)new u(parama);
    AppMethodBeat.o(202060);
    return parama;
  }
  
  public static final <T> g<T> g(a<? extends T> parama)
  {
    AppMethodBeat.i(202107);
    s.u(parama, "block");
    parama = j.y((m)new a(parama, null));
    AppMethodBeat.o(202107);
    return parama;
  }
  
  public static final <T> bi<T> qh()
  {
    return (bi)ax.apy;
  }
  
  public static final <T> bi<T> qi()
  {
    return (bi)bp.aqi;
  }
  
  public static final <T> bi<T> qj()
  {
    return (bi)ao.aov;
  }
  
  public static final <T> androidx.compose.runtime.f.r<T> qk()
  {
    AppMethodBeat.i(202042);
    androidx.compose.runtime.f.r localr = new androidx.compose.runtime.f.r();
    AppMethodBeat.o(202042);
    return localr;
  }
  
  public static final <K, V> t<K, V> ql()
  {
    AppMethodBeat.i(202051);
    t localt = new t();
    AppMethodBeat.o(202051);
    return localt;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<kotlinx.coroutines.b.h<? super T>, d<? super ah>, Object>
  {
    Object Uf;
    Object VC;
    Object VD;
    Object Ze;
    int aai;
    Object aqc;
    int label;
    
    a(a<? extends T> parama, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(202149);
      paramd = new a(this.$block, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(202149);
      return paramObject;
    }
    
    /* Error */
    public final Object invokeSuspend(Object paramObject)
    {
      // Byte code:
      //   0: ldc 89
      //   2: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: getstatic 95	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
      //   8: astore 17
      //   10: aload_0
      //   11: getfield 97	androidx/compose/runtime/bj$a:label	I
      //   14: tableswitch	default:+30 -> 44, 0:+47->61, 1:+330->344, 2:+503->517, 3:+918->932
      //   45: nop
      //   46: dadd
      //   47: dup
      //   48: ldc 101
      //   50: invokespecial 104	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   53: astore_1
      //   54: ldc 89
      //   56: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   59: aload_1
      //   60: athrow
      //   61: aload_1
      //   62: invokestatic 110	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   65: aload_0
      //   66: getfield 65	androidx/compose/runtime/bj$a:L$0	Ljava/lang/Object;
      //   69: checkcast 76	kotlinx/coroutines/b/h
      //   72: astore 8
      //   74: new 112	java/util/LinkedHashSet
      //   77: dup
      //   78: invokespecial 115	java/util/LinkedHashSet:<init>	()V
      //   81: checkcast 117	java/util/Set
      //   84: astore 7
      //   86: new 119	androidx/compose/runtime/bj$a$a
      //   89: dup
      //   90: aload 7
      //   92: invokespecial 122	androidx/compose/runtime/bj$a$a:<init>	(Ljava/util/Set;)V
      //   95: checkcast 124	kotlin/g/a/b
      //   98: astore 6
      //   100: ldc 125
      //   102: aconst_null
      //   103: bipush 6
      //   105: invokestatic 131	kotlinx/coroutines/a/k:a	(ILkotlinx/coroutines/a/g;I)Lkotlinx/coroutines/a/h;
      //   108: astore 9
      //   110: getstatic 137	androidx/compose/runtime/f/h:asx	Landroidx/compose/runtime/f/h$a;
      //   113: astore_1
      //   114: new 14	androidx/compose/runtime/bj$a$b
      //   117: dup
      //   118: aload 9
      //   120: invokespecial 140	androidx/compose/runtime/bj$a$b:<init>	(Lkotlinx/coroutines/a/h;)V
      //   123: checkcast 7	kotlin/g/a/m
      //   126: invokestatic 146	androidx/compose/runtime/f/h$a:c	(Lkotlin/g/a/m;)Landroidx/compose/runtime/f/f;
      //   129: astore_1
      //   130: aload_1
      //   131: astore 4
      //   133: getstatic 137	androidx/compose/runtime/f/h:asx	Landroidx/compose/runtime/f/h$a;
      //   136: astore 5
      //   138: aload_1
      //   139: astore 4
      //   141: invokestatic 152	androidx/compose/runtime/f/l:rx	()Landroidx/compose/runtime/f/h;
      //   144: aload 6
      //   146: invokevirtual 156	androidx/compose/runtime/f/h:h	(Lkotlin/g/a/b;)Landroidx/compose/runtime/f/h;
      //   149: astore 5
      //   151: aload_1
      //   152: astore 4
      //   154: aload_0
      //   155: getfield 46	androidx/compose/runtime/bj$a:$block	Lkotlin/g/a/a;
      //   158: astore 10
      //   160: aload 5
      //   162: invokevirtual 159	androidx/compose/runtime/f/h:rr	()Landroidx/compose/runtime/f/h;
      //   165: astore 4
      //   167: aload 10
      //   169: invokeinterface 164 1 0
      //   174: astore 10
      //   176: aload 4
      //   178: invokestatic 167	androidx/compose/runtime/f/h:c	(Landroidx/compose/runtime/f/h;)V
      //   181: aload_1
      //   182: astore 4
      //   184: aload 5
      //   186: invokevirtual 170	androidx/compose/runtime/f/h:dispose	()V
      //   189: aload_1
      //   190: astore 4
      //   192: aload_0
      //   193: checkcast 67	kotlin/d/d
      //   196: astore 5
      //   198: aload_1
      //   199: astore 4
      //   201: aload_0
      //   202: aload 8
      //   204: putfield 65	androidx/compose/runtime/bj$a:L$0	Ljava/lang/Object;
      //   207: aload_1
      //   208: astore 4
      //   210: aload_0
      //   211: aload 7
      //   213: putfield 172	androidx/compose/runtime/bj$a:Uf	Ljava/lang/Object;
      //   216: aload_1
      //   217: astore 4
      //   219: aload_0
      //   220: aload 6
      //   222: putfield 174	androidx/compose/runtime/bj$a:VC	Ljava/lang/Object;
      //   225: aload_1
      //   226: astore 4
      //   228: aload_0
      //   229: aload 9
      //   231: putfield 176	androidx/compose/runtime/bj$a:VD	Ljava/lang/Object;
      //   234: aload_1
      //   235: astore 4
      //   237: aload_0
      //   238: aload_1
      //   239: putfield 178	androidx/compose/runtime/bj$a:Ze	Ljava/lang/Object;
      //   242: aload_1
      //   243: astore 4
      //   245: aload_0
      //   246: aload 10
      //   248: putfield 180	androidx/compose/runtime/bj$a:aqc	Ljava/lang/Object;
      //   251: aload_1
      //   252: astore 4
      //   254: aload_0
      //   255: iconst_1
      //   256: putfield 97	androidx/compose/runtime/bj$a:label	I
      //   259: aload_1
      //   260: astore 4
      //   262: aload 8
      //   264: aload 10
      //   266: aload 5
      //   268: invokeinterface 183 3 0
      //   273: astore 5
      //   275: aload 5
      //   277: aload 17
      //   279: if_acmpne +788 -> 1067
      //   282: ldc 89
      //   284: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   287: aload 17
      //   289: areturn
      //   290: astore 6
      //   292: aload 4
      //   294: invokestatic 167	androidx/compose/runtime/f/h:c	(Landroidx/compose/runtime/f/h;)V
      //   297: ldc 89
      //   299: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   302: aload 6
      //   304: athrow
      //   305: astore 6
      //   307: aload_1
      //   308: astore 4
      //   310: aload 5
      //   312: invokevirtual 170	androidx/compose/runtime/f/h:dispose	()V
      //   315: aload_1
      //   316: astore 4
      //   318: ldc 89
      //   320: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   323: aload_1
      //   324: astore 4
      //   326: aload 6
      //   328: athrow
      //   329: astore_1
      //   330: aload 4
      //   332: invokeinterface 186 1 0
      //   337: ldc 89
      //   339: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   342: aload_1
      //   343: athrow
      //   344: aload_0
      //   345: getfield 180	androidx/compose/runtime/bj$a:aqc	Ljava/lang/Object;
      //   348: astore 10
      //   350: aload_0
      //   351: getfield 178	androidx/compose/runtime/bj$a:Ze	Ljava/lang/Object;
      //   354: checkcast 185	androidx/compose/runtime/f/f
      //   357: astore 5
      //   359: aload_0
      //   360: getfield 176	androidx/compose/runtime/bj$a:VD	Ljava/lang/Object;
      //   363: checkcast 188	kotlinx/coroutines/a/h
      //   366: astore 9
      //   368: aload_0
      //   369: getfield 174	androidx/compose/runtime/bj$a:VC	Ljava/lang/Object;
      //   372: checkcast 124	kotlin/g/a/b
      //   375: astore 6
      //   377: aload_0
      //   378: getfield 172	androidx/compose/runtime/bj$a:Uf	Ljava/lang/Object;
      //   381: checkcast 117	java/util/Set
      //   384: astore 7
      //   386: aload_0
      //   387: getfield 65	androidx/compose/runtime/bj$a:L$0	Ljava/lang/Object;
      //   390: checkcast 76	kotlinx/coroutines/b/h
      //   393: astore 8
      //   395: aload 5
      //   397: astore 4
      //   399: aload_1
      //   400: invokestatic 110	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   403: aload 5
      //   405: astore_1
      //   406: aload_1
      //   407: astore 4
      //   409: aload_0
      //   410: checkcast 67	kotlin/d/d
      //   413: astore 5
      //   415: aload_1
      //   416: astore 4
      //   418: aload_0
      //   419: aload 8
      //   421: putfield 65	androidx/compose/runtime/bj$a:L$0	Ljava/lang/Object;
      //   424: aload_1
      //   425: astore 4
      //   427: aload_0
      //   428: aload 7
      //   430: putfield 172	androidx/compose/runtime/bj$a:Uf	Ljava/lang/Object;
      //   433: aload_1
      //   434: astore 4
      //   436: aload_0
      //   437: aload 6
      //   439: putfield 174	androidx/compose/runtime/bj$a:VC	Ljava/lang/Object;
      //   442: aload_1
      //   443: astore 4
      //   445: aload_0
      //   446: aload 9
      //   448: putfield 176	androidx/compose/runtime/bj$a:VD	Ljava/lang/Object;
      //   451: aload_1
      //   452: astore 4
      //   454: aload_0
      //   455: aload_1
      //   456: putfield 178	androidx/compose/runtime/bj$a:Ze	Ljava/lang/Object;
      //   459: aload_1
      //   460: astore 4
      //   462: aload_0
      //   463: aload 10
      //   465: putfield 180	androidx/compose/runtime/bj$a:aqc	Ljava/lang/Object;
      //   468: aload_1
      //   469: astore 4
      //   471: aload_0
      //   472: iconst_0
      //   473: putfield 190	androidx/compose/runtime/bj$a:aai	I
      //   476: aload_1
      //   477: astore 4
      //   479: aload_0
      //   480: iconst_2
      //   481: putfield 97	androidx/compose/runtime/bj$a:label	I
      //   484: aload_1
      //   485: astore 4
      //   487: aload 9
      //   489: aload 5
      //   491: invokeinterface 194 2 0
      //   496: astore 5
      //   498: aload 5
      //   500: astore 4
      //   502: aload 4
      //   504: aload 17
      //   506: if_acmpne +529 -> 1035
      //   509: ldc 89
      //   511: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   514: aload 17
      //   516: areturn
      //   517: aload_0
      //   518: getfield 190	androidx/compose/runtime/bj$a:aai	I
      //   521: istore_2
      //   522: aload_0
      //   523: getfield 180	androidx/compose/runtime/bj$a:aqc	Ljava/lang/Object;
      //   526: astore 15
      //   528: aload_0
      //   529: getfield 178	androidx/compose/runtime/bj$a:Ze	Ljava/lang/Object;
      //   532: checkcast 185	androidx/compose/runtime/f/f
      //   535: astore 5
      //   537: aload_0
      //   538: getfield 176	androidx/compose/runtime/bj$a:VD	Ljava/lang/Object;
      //   541: checkcast 188	kotlinx/coroutines/a/h
      //   544: astore 11
      //   546: aload_0
      //   547: getfield 174	androidx/compose/runtime/bj$a:VC	Ljava/lang/Object;
      //   550: checkcast 124	kotlin/g/a/b
      //   553: astore 14
      //   555: aload_0
      //   556: getfield 172	androidx/compose/runtime/bj$a:Uf	Ljava/lang/Object;
      //   559: checkcast 117	java/util/Set
      //   562: astore 13
      //   564: aload_0
      //   565: getfield 65	androidx/compose/runtime/bj$a:L$0	Ljava/lang/Object;
      //   568: checkcast 76	kotlinx/coroutines/b/h
      //   571: astore 12
      //   573: aload 5
      //   575: astore 4
      //   577: aload_1
      //   578: invokestatic 110	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   581: aload_1
      //   582: astore 6
      //   584: aload 5
      //   586: astore 4
      //   588: aload 6
      //   590: checkcast 117	java/util/Set
      //   593: astore_1
      //   594: iload_2
      //   595: istore_3
      //   596: iload_3
      //   597: ifne +473 -> 1070
      //   600: aload 5
      //   602: astore 4
      //   604: aload 13
      //   606: aload_1
      //   607: invokestatic 197	androidx/compose/runtime/bj:a	(Ljava/util/Set;Ljava/util/Set;)Z
      //   610: ifeq +276 -> 886
      //   613: goto +457 -> 1070
      //   616: aload 5
      //   618: astore 4
      //   620: aload 11
      //   622: invokeinterface 200 1 0
      //   627: invokestatic 205	kotlinx/coroutines/a/l:getOrNull-impl	(Ljava/lang/Object;)Ljava/lang/Object;
      //   630: checkcast 117	java/util/Set
      //   633: astore 6
      //   635: aload 6
      //   637: astore_1
      //   638: iload_2
      //   639: istore_3
      //   640: aload 6
      //   642: ifnonnull -46 -> 596
      //   645: aload 14
      //   647: astore 6
      //   649: aload 13
      //   651: astore 7
      //   653: aload 12
      //   655: astore 8
      //   657: aload 5
      //   659: astore_1
      //   660: aload 11
      //   662: astore 9
      //   664: aload 15
      //   666: astore 10
      //   668: iload_2
      //   669: ifeq -263 -> 406
      //   672: aload 5
      //   674: astore 4
      //   676: aload 13
      //   678: invokeinterface 208 1 0
      //   683: aload 5
      //   685: astore 4
      //   687: getstatic 137	androidx/compose/runtime/f/h:asx	Landroidx/compose/runtime/f/h$a;
      //   690: astore_1
      //   691: aload 5
      //   693: astore 4
      //   695: invokestatic 152	androidx/compose/runtime/f/l:rx	()Landroidx/compose/runtime/f/h;
      //   698: aload 14
      //   700: invokevirtual 156	androidx/compose/runtime/f/h:h	(Lkotlin/g/a/b;)Landroidx/compose/runtime/f/h;
      //   703: astore_1
      //   704: aload 5
      //   706: astore 4
      //   708: aload_0
      //   709: getfield 46	androidx/compose/runtime/bj$a:$block	Lkotlin/g/a/a;
      //   712: astore 6
      //   714: aload_1
      //   715: invokevirtual 159	androidx/compose/runtime/f/h:rr	()Landroidx/compose/runtime/f/h;
      //   718: astore 4
      //   720: aload 6
      //   722: invokeinterface 164 1 0
      //   727: astore 16
      //   729: aload 4
      //   731: invokestatic 167	androidx/compose/runtime/f/h:c	(Landroidx/compose/runtime/f/h;)V
      //   734: aload 5
      //   736: astore 4
      //   738: aload_1
      //   739: invokevirtual 170	androidx/compose/runtime/f/h:dispose	()V
      //   742: aload 5
      //   744: astore 4
      //   746: aload 14
      //   748: astore 6
      //   750: aload 13
      //   752: astore 7
      //   754: aload 12
      //   756: astore 8
      //   758: aload 5
      //   760: astore_1
      //   761: aload 11
      //   763: astore 9
      //   765: aload 15
      //   767: astore 10
      //   769: aload 16
      //   771: aload 15
      //   773: invokestatic 214	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
      //   776: ifne -370 -> 406
      //   779: aload 5
      //   781: astore 4
      //   783: aload_0
      //   784: checkcast 67	kotlin/d/d
      //   787: astore_1
      //   788: aload 5
      //   790: astore 4
      //   792: aload_0
      //   793: aload 12
      //   795: putfield 65	androidx/compose/runtime/bj$a:L$0	Ljava/lang/Object;
      //   798: aload 5
      //   800: astore 4
      //   802: aload_0
      //   803: aload 13
      //   805: putfield 172	androidx/compose/runtime/bj$a:Uf	Ljava/lang/Object;
      //   808: aload 5
      //   810: astore 4
      //   812: aload_0
      //   813: aload 14
      //   815: putfield 174	androidx/compose/runtime/bj$a:VC	Ljava/lang/Object;
      //   818: aload 5
      //   820: astore 4
      //   822: aload_0
      //   823: aload 11
      //   825: putfield 176	androidx/compose/runtime/bj$a:VD	Ljava/lang/Object;
      //   828: aload 5
      //   830: astore 4
      //   832: aload_0
      //   833: aload 5
      //   835: putfield 178	androidx/compose/runtime/bj$a:Ze	Ljava/lang/Object;
      //   838: aload 5
      //   840: astore 4
      //   842: aload_0
      //   843: aload 16
      //   845: putfield 180	androidx/compose/runtime/bj$a:aqc	Ljava/lang/Object;
      //   848: aload 5
      //   850: astore 4
      //   852: aload_0
      //   853: iconst_3
      //   854: putfield 97	androidx/compose/runtime/bj$a:label	I
      //   857: aload 5
      //   859: astore 4
      //   861: aload 12
      //   863: aload 16
      //   865: aload_1
      //   866: invokeinterface 183 3 0
      //   871: astore_1
      //   872: aload_1
      //   873: aload 17
      //   875: if_acmpne +134 -> 1009
      //   878: ldc 89
      //   880: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   883: aload 17
      //   885: areturn
      //   886: iconst_0
      //   887: istore_2
      //   888: goto -272 -> 616
      //   891: astore 6
      //   893: aload 4
      //   895: invokestatic 167	androidx/compose/runtime/f/h:c	(Landroidx/compose/runtime/f/h;)V
      //   898: ldc 89
      //   900: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   903: aload 6
      //   905: athrow
      //   906: astore 6
      //   908: aload 5
      //   910: astore 4
      //   912: aload_1
      //   913: invokevirtual 170	androidx/compose/runtime/f/h:dispose	()V
      //   916: aload 5
      //   918: astore 4
      //   920: ldc 89
      //   922: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   925: aload 5
      //   927: astore 4
      //   929: aload 6
      //   931: athrow
      //   932: aload_0
      //   933: getfield 180	androidx/compose/runtime/bj$a:aqc	Ljava/lang/Object;
      //   936: astore 10
      //   938: aload_0
      //   939: getfield 178	androidx/compose/runtime/bj$a:Ze	Ljava/lang/Object;
      //   942: checkcast 185	androidx/compose/runtime/f/f
      //   945: astore 5
      //   947: aload_0
      //   948: getfield 176	androidx/compose/runtime/bj$a:VD	Ljava/lang/Object;
      //   951: checkcast 188	kotlinx/coroutines/a/h
      //   954: astore 9
      //   956: aload_0
      //   957: getfield 174	androidx/compose/runtime/bj$a:VC	Ljava/lang/Object;
      //   960: checkcast 124	kotlin/g/a/b
      //   963: astore 6
      //   965: aload_0
      //   966: getfield 172	androidx/compose/runtime/bj$a:Uf	Ljava/lang/Object;
      //   969: checkcast 117	java/util/Set
      //   972: astore 7
      //   974: aload_0
      //   975: getfield 65	androidx/compose/runtime/bj$a:L$0	Ljava/lang/Object;
      //   978: checkcast 76	kotlinx/coroutines/b/h
      //   981: astore 8
      //   983: aload 5
      //   985: astore 4
      //   987: aload_1
      //   988: invokestatic 110	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
      //   991: aload 10
      //   993: astore 4
      //   995: aload 5
      //   997: astore_1
      //   998: aload 4
      //   1000: astore 10
      //   1002: goto -596 -> 406
      //   1005: astore_1
      //   1006: goto -676 -> 330
      //   1009: aload 16
      //   1011: astore 4
      //   1013: aload 5
      //   1015: astore_1
      //   1016: aload 14
      //   1018: astore 6
      //   1020: aload 13
      //   1022: astore 7
      //   1024: aload 12
      //   1026: astore 8
      //   1028: aload 11
      //   1030: astore 9
      //   1032: goto -34 -> 998
      //   1035: iconst_0
      //   1036: istore_2
      //   1037: aload 6
      //   1039: astore 14
      //   1041: aload 7
      //   1043: astore 13
      //   1045: aload 8
      //   1047: astore 12
      //   1049: aload 4
      //   1051: astore 6
      //   1053: aload_1
      //   1054: astore 5
      //   1056: aload 9
      //   1058: astore 11
      //   1060: aload 10
      //   1062: astore 15
      //   1064: goto -480 -> 584
      //   1067: goto -661 -> 406
      //   1070: iconst_1
      //   1071: istore_2
      //   1072: goto -456 -> 616
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1075	0	this	a
      //   0	1075	1	paramObject	Object
      //   521	551	2	i	int
      //   595	45	3	j	int
      //   131	919	4	localObject1	Object
      //   136	919	5	localObject2	Object
      //   98	123	6	localb	kotlin.g.a.b
      //   290	13	6	localObject3	Object
      //   305	22	6	localObject4	Object
      //   375	374	6	localObject5	Object
      //   891	13	6	localObject6	Object
      //   906	24	6	localObject7	Object
      //   963	89	6	localObject8	Object
      //   84	958	7	localObject9	Object
      //   72	974	8	localObject10	Object
      //   108	949	9	localObject11	Object
      //   158	903	10	localObject12	Object
      //   544	515	11	localObject13	Object
      //   571	477	12	localObject14	Object
      //   562	482	13	localObject15	Object
      //   553	487	14	localObject16	Object
      //   526	537	15	localObject17	Object
      //   727	283	16	localObject18	Object
      //   8	876	17	locala	kotlin.d.a.a
      // Exception table:
      //   from	to	target	type
      //   167	176	290	finally
      //   160	167	305	finally
      //   176	181	305	finally
      //   292	305	305	finally
      //   133	138	329	finally
      //   141	151	329	finally
      //   154	160	329	finally
      //   184	189	329	finally
      //   192	198	329	finally
      //   201	207	329	finally
      //   210	216	329	finally
      //   219	225	329	finally
      //   228	234	329	finally
      //   237	242	329	finally
      //   245	251	329	finally
      //   254	259	329	finally
      //   262	275	329	finally
      //   310	315	329	finally
      //   318	323	329	finally
      //   326	329	329	finally
      //   409	415	329	finally
      //   418	424	329	finally
      //   427	433	329	finally
      //   436	442	329	finally
      //   445	451	329	finally
      //   454	459	329	finally
      //   462	468	329	finally
      //   471	476	329	finally
      //   479	484	329	finally
      //   487	498	329	finally
      //   588	594	329	finally
      //   604	613	329	finally
      //   620	635	329	finally
      //   676	683	329	finally
      //   687	691	329	finally
      //   695	704	329	finally
      //   708	714	329	finally
      //   738	742	329	finally
      //   769	779	329	finally
      //   783	788	329	finally
      //   792	798	329	finally
      //   802	808	329	finally
      //   812	818	329	finally
      //   822	828	329	finally
      //   832	838	329	finally
      //   842	848	329	finally
      //   852	857	329	finally
      //   861	872	329	finally
      //   912	916	329	finally
      //   920	925	329	finally
      //   929	932	329	finally
      //   720	729	891	finally
      //   714	720	906	finally
      //   729	734	906	finally
      //   893	906	906	finally
      //   399	403	1005	finally
      //   577	581	1005	finally
      //   987	991	1005	finally
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "changed", "", "", "<anonymous parameter 1>", "Landroidx/compose/runtime/snapshots/Snapshot;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements m<Set<? extends Object>, androidx.compose.runtime.f.h, ah>
    {
      b(kotlinx.coroutines.a.h<Set<Object>> paramh)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.bj
 * JD-Core Version:    0.7.0.1
 */