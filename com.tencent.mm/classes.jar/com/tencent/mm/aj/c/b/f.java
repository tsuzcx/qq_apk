package com.tencent.mm.aj.c.b;

import androidx.compose.foundation.a.s;
import androidx.compose.foundation.lazy.aa;
import androidx.compose.foundation.o;
import androidx.compose.runtime.an;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/widget/pager/PagerState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "currentPage", "", "(I)V", "<set-?>", "_currentPage", "get_currentPage", "()I", "set_currentPage", "_currentPage$delegate", "Landroidx/compose/runtime/MutableState;", "animationTargetPage", "getAnimationTargetPage", "()Ljava/lang/Integer;", "setAnimationTargetPage", "(Ljava/lang/Integer;)V", "animationTargetPage$delegate", "currentLayoutPageInfo", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getCurrentLayoutPageInfo$compose_base_release", "()Landroidx/compose/foundation/lazy/LazyListItemInfo;", "currentLayoutPageOffset", "", "getCurrentLayoutPageOffset", "()F", "value", "getCurrentPage", "setCurrentPage$compose_base_release", "currentPageOffset", "getCurrentPageOffset", "currentPageOffset$delegate", "Landroidx/compose/runtime/State;", "Lkotlin/Function0;", "flingAnimationTarget", "getFlingAnimationTarget$compose_base_release", "()Lkotlin/jvm/functions/Function0;", "setFlingAnimationTarget$compose_base_release", "(Lkotlin/jvm/functions/Function0;)V", "flingAnimationTarget$delegate", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "isScrollInProgress", "", "()Z", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "getLazyListState$compose_base_release", "()Landroidx/compose/foundation/lazy/LazyListState;", "pageCount", "getPageCount", "pageCount$delegate", "targetPage", "getTargetPage", "animateScrollToPage", "", "page", "pageOffset", "(IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "initialVelocity", "skipPages", "(IFLandroidx/compose/animation/core/AnimationSpec;FZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "onScrollFinished", "onScrollFinished$compose_base_release", "requireCurrentPage", "name", "", "requireCurrentPageOffset", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToPage", "toString", "updateCurrentPageBasedOnLazyListState", "updateCurrentPageBasedOnLazyListState$compose_base_release", "Companion", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements s
{
  private static final i<f, ?> ZG;
  public static final f.a oif;
  final aa afi;
  private final an oig;
  private final bm oih;
  private final bm oii;
  private final an oij;
  private final an oik;
  
  static
  {
    AppMethodBeat.i(238864);
    oif = new f.a((byte)0);
    ZG = androidx.compose.runtime.e.a.a((kotlin.g.a.m)f.b.oil, (b)f.c.oim);
    AppMethodBeat.o(238864);
  }
  
  public f(int paramInt)
  {
    AppMethodBeat.i(238817);
    this.afi = new aa(paramInt, 2, (byte)0);
    this.oig = bj.T(Integer.valueOf(paramInt));
    this.oih = bj.f((kotlin.g.a.a)new f(this));
    this.oii = bj.f((kotlin.g.a.a)new e(this));
    this.oij = bj.T(null);
    this.oik = bj.T(null);
    AppMethodBeat.o(238817);
  }
  
  private final Integer bzn()
  {
    AppMethodBeat.i(238831);
    Integer localInteger = (Integer)((bm)this.oij).getValue();
    AppMethodBeat.o(238831);
    return localInteger;
  }
  
  private kotlin.g.a.a<Integer> bzo()
  {
    AppMethodBeat.i(238839);
    kotlin.g.a.a locala = (kotlin.g.a.a)((bm)this.oik).getValue();
    AppMethodBeat.o(238839);
    return locala;
  }
  
  private final void l(Integer paramInteger)
  {
    AppMethodBeat.i(238835);
    this.oij.setValue(paramInteger);
    AppMethodBeat.o(238835);
  }
  
  private final void uR(int paramInt)
  {
    AppMethodBeat.i(238827);
    this.oig.setValue(Integer.valueOf(paramInt));
    AppMethodBeat.o(238827);
  }
  
  public final Object a(o paramo, kotlin.g.a.m<? super androidx.compose.foundation.a.p, ? super kotlin.d.d<? super ah>, ? extends Object> paramm, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(238898);
    paramo = this.afi.a(paramo, paramm, paramd);
    if (paramo == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(238898);
      return paramo;
    }
    paramo = ah.aiuX;
    AppMethodBeat.o(238898);
    return paramo;
  }
  
  public final void ac(kotlin.g.a.a<Integer> parama)
  {
    AppMethodBeat.i(238884);
    this.oik.setValue(parama);
    AppMethodBeat.o(238884);
  }
  
  public final int bzk()
  {
    AppMethodBeat.i(238867);
    int i = ((Number)((bm)this.oig).getValue()).intValue();
    AppMethodBeat.o(238867);
    return i;
  }
  
  public final androidx.compose.foundation.lazy.m bzl()
  {
    AppMethodBeat.i(238870);
    Object localObject = this.afi.mQ().mE();
    ListIterator localListIterator = ((List)localObject).listIterator(((List)localObject).size());
    int i;
    if (localListIterator.hasPrevious())
    {
      localObject = localListIterator.previous();
      if (((androidx.compose.foundation.lazy.m)localObject).getOffset() <= 0)
      {
        i = 1;
        label62:
        if (i == 0) {
          break label82;
        }
      }
    }
    for (;;)
    {
      localObject = (androidx.compose.foundation.lazy.m)localObject;
      AppMethodBeat.o(238870);
      return localObject;
      i = 0;
      break label62;
      label82:
      break;
      localObject = null;
    }
  }
  
  public final float bzm()
  {
    AppMethodBeat.i(238880);
    float f = ((Number)this.oii.getValue()).floatValue();
    AppMethodBeat.o(238880);
    return f;
  }
  
  public final int bzp()
  {
    AppMethodBeat.i(238886);
    Object localObject = bzn();
    if (localObject == null)
    {
      localObject = bzo();
      if (localObject == null) {
        localObject = null;
      }
      while (localObject == null) {
        if (!this.afi.ml())
        {
          i = bzk();
          AppMethodBeat.o(238886);
          return i;
          localObject = (Integer)((kotlin.g.a.a)localObject).invoke();
        }
        else
        {
          if (Math.abs(bzm()) < 0.001F)
          {
            i = bzk();
            AppMethodBeat.o(238886);
            return i;
          }
          if (bzm() < 0.0F)
          {
            i = k.qu(bzk() - 1, 0);
            AppMethodBeat.o(238886);
            return i;
          }
          i = k.qv(bzk() + 1, getPageCount() - 1);
          AppMethodBeat.o(238886);
          return i;
        }
      }
      i = ((Integer)localObject).intValue();
      AppMethodBeat.o(238886);
      return i;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(238886);
    return i;
  }
  
  public final void bzq()
  {
    AppMethodBeat.i(238893);
    androidx.compose.foundation.lazy.m localm = bzl();
    if (localm == null) {}
    for (int i = 0;; i = localm.getIndex())
    {
      uS(i);
      AppMethodBeat.o(238893);
      return;
    }
  }
  
  public final void bzr()
  {
    AppMethodBeat.i(238895);
    bzq();
    l(null);
    AppMethodBeat.o(238895);
  }
  
  /* Error */
  public final Object c(int paramInt, kotlin.d.d<? super ah> paramd)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: ldc_w 372
    //   9: invokestatic 131	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_2
    //   13: instanceof 10
    //   16: ifeq +107 -> 123
    //   19: aload_2
    //   20: checkcast 10	com/tencent/mm/aj/c/b/f$d
    //   23: astore 8
    //   25: aload 8
    //   27: getfield 376	com/tencent/mm/aj/c/b/f$d:label	I
    //   30: ldc_w 377
    //   33: iand
    //   34: ifeq +89 -> 123
    //   37: aload 8
    //   39: aload 8
    //   41: getfield 376	com/tencent/mm/aj/c/b/f$d:label	I
    //   44: ldc_w 377
    //   47: iadd
    //   48: putfield 376	com/tencent/mm/aj/c/b/f$d:label	I
    //   51: aload 8
    //   53: getfield 381	com/tencent/mm/aj/c/b/f$d:result	Ljava/lang/Object;
    //   56: astore 10
    //   58: getstatic 276	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
    //   61: astore 9
    //   63: aload 8
    //   65: getfield 376	com/tencent/mm/aj/c/b/f$d:label	I
    //   68: tableswitch	default:+36 -> 104, 0:+69->137, 1:+265->333, 2:+306->374, 3:+342->410, 4:+603->671
    //   105: aconst_null
    //   106: land
    //   107: dup
    //   108: ldc_w 385
    //   111: invokespecial 388	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   114: astore_2
    //   115: ldc_w 372
    //   118: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_2
    //   122: athrow
    //   123: new 10	com/tencent/mm/aj/c/b/f$d
    //   126: dup
    //   127: aload_0
    //   128: aload_2
    //   129: invokespecial 391	com/tencent/mm/aj/c/b/f$d:<init>	(Lcom/tencent/mm/aj/c/b/f;Lkotlin/d/d;)V
    //   132: astore 8
    //   134: goto -83 -> 51
    //   137: aload 10
    //   139: invokestatic 396	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   142: aload_0
    //   143: invokevirtual 353	com/tencent/mm/aj/c/b/f:getPageCount	()I
    //   146: ifne +49 -> 195
    //   149: iload_1
    //   150: ifne +39 -> 189
    //   153: iload 4
    //   155: ifne +121 -> 276
    //   158: new 398	java/lang/IllegalArgumentException
    //   161: dup
    //   162: ldc_w 399
    //   165: ldc_w 401
    //   168: invokestatic 407	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   171: invokevirtual 410	java/lang/Object:toString	()Ljava/lang/String;
    //   174: invokespecial 411	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   177: checkcast 413	java/lang/Throwable
    //   180: astore_2
    //   181: ldc_w 372
    //   184: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_2
    //   188: athrow
    //   189: iconst_0
    //   190: istore 4
    //   192: goto -39 -> 153
    //   195: iload 5
    //   197: istore 4
    //   199: iload_1
    //   200: iflt +18 -> 218
    //   203: iload 5
    //   205: istore 4
    //   207: iload_1
    //   208: aload_0
    //   209: invokevirtual 353	com/tencent/mm/aj/c/b/f:getPageCount	()I
    //   212: if_icmpge +6 -> 218
    //   215: iconst_1
    //   216: istore 4
    //   218: iload 4
    //   220: ifne +56 -> 276
    //   223: new 398	java/lang/IllegalArgumentException
    //   226: dup
    //   227: new 415	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 416	java/lang/StringBuilder:<init>	()V
    //   234: ldc_w 399
    //   237: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: bipush 91
    //   242: invokevirtual 423	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   245: iload_1
    //   246: invokevirtual 426	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   249: ldc_w 428
    //   252: invokevirtual 420	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 429	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokevirtual 410	java/lang/Object:toString	()Ljava/lang/String;
    //   261: invokespecial 411	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   264: checkcast 413	java/lang/Throwable
    //   267: astore_2
    //   268: ldc_w 372
    //   271: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: aload_2
    //   275: athrow
    //   276: aload_0
    //   277: invokevirtual 353	com/tencent/mm/aj/c/b/f:getPageCount	()I
    //   280: pop
    //   281: aload_0
    //   282: iload_1
    //   283: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   286: invokespecial 371	com/tencent/mm/aj/c/b/f:l	(Ljava/lang/Integer;)V
    //   289: aload_0
    //   290: getfield 177	com/tencent/mm/aj/c/b/f:afi	Landroidx/compose/foundation/lazy/aa;
    //   293: astore_2
    //   294: aload 8
    //   296: aload_0
    //   297: putfield 432	com/tencent/mm/aj/c/b/f$d:L$0	Ljava/lang/Object;
    //   300: aload 8
    //   302: iconst_1
    //   303: putfield 376	com/tencent/mm/aj/c/b/f$d:label	I
    //   306: aload_2
    //   307: iload_1
    //   308: aload 8
    //   310: invokestatic 435	androidx/compose/foundation/lazy/aa:b	(Landroidx/compose/foundation/lazy/aa;ILkotlin/d/d;)Ljava/lang/Object;
    //   313: astore 6
    //   315: aload_0
    //   316: astore_2
    //   317: aload 6
    //   319: aload 9
    //   321: if_acmpne +33 -> 354
    //   324: ldc_w 372
    //   327: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: aload 9
    //   332: areturn
    //   333: aload 8
    //   335: getfield 432	com/tencent/mm/aj/c/b/f$d:L$0	Ljava/lang/Object;
    //   338: checkcast 2	com/tencent/mm/aj/c/b/f
    //   341: astore 6
    //   343: aload 6
    //   345: astore_2
    //   346: aload 10
    //   348: invokestatic 396	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   351: aload 6
    //   353: astore_2
    //   354: aload_2
    //   355: astore 6
    //   357: aload 6
    //   359: invokevirtual 437	com/tencent/mm/aj/c/b/f:bzr	()V
    //   362: getstatic 282	kotlin/ah:aiuX	Lkotlin/ah;
    //   365: astore_2
    //   366: ldc_w 372
    //   369: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   372: aload_2
    //   373: areturn
    //   374: aload 8
    //   376: getfield 432	com/tencent/mm/aj/c/b/f$d:L$0	Ljava/lang/Object;
    //   379: checkcast 2	com/tencent/mm/aj/c/b/f
    //   382: astore 6
    //   384: aload 6
    //   386: astore_2
    //   387: aload 10
    //   389: invokestatic 396	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   392: goto -35 -> 357
    //   395: astore 6
    //   397: aload_2
    //   398: invokevirtual 437	com/tencent/mm/aj/c/b/f:bzr	()V
    //   401: ldc_w 372
    //   404: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   407: aload 6
    //   409: athrow
    //   410: aload 8
    //   412: getfield 440	com/tencent/mm/aj/c/b/f$d:asI	I
    //   415: istore 5
    //   417: aload 8
    //   419: getfield 444	com/tencent/mm/aj/c/b/f$d:aad	F
    //   422: fstore_3
    //   423: aload 8
    //   425: getfield 447	com/tencent/mm/aj/c/b/f$d:aai	I
    //   428: istore 4
    //   430: aload 8
    //   432: getfield 432	com/tencent/mm/aj/c/b/f$d:L$0	Ljava/lang/Object;
    //   435: checkcast 2	com/tencent/mm/aj/c/b/f
    //   438: astore 7
    //   440: aload 7
    //   442: astore_2
    //   443: aload 10
    //   445: invokestatic 396	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   448: aload 7
    //   450: astore_2
    //   451: aload 7
    //   453: getfield 177	com/tencent/mm/aj/c/b/f:afi	Landroidx/compose/foundation/lazy/aa;
    //   456: invokevirtual 298	androidx/compose/foundation/lazy/aa:mQ	()Landroidx/compose/foundation/lazy/p;
    //   459: invokeinterface 304 1 0
    //   464: checkcast 449	java/lang/Iterable
    //   467: invokeinterface 453 1 0
    //   472: astore 6
    //   474: aload 7
    //   476: astore_2
    //   477: aload 6
    //   479: invokeinterface 458 1 0
    //   484: ifeq +154 -> 638
    //   487: aload 7
    //   489: astore_2
    //   490: aload 6
    //   492: invokeinterface 461 1 0
    //   497: astore 10
    //   499: aload 7
    //   501: astore_2
    //   502: aload 10
    //   504: checkcast 217	androidx/compose/foundation/lazy/m
    //   507: invokeinterface 365 1 0
    //   512: iload 4
    //   514: if_icmpne +119 -> 633
    //   517: iconst_1
    //   518: istore_1
    //   519: iload_1
    //   520: ifeq -46 -> 474
    //   523: aload 7
    //   525: astore_2
    //   526: aload 10
    //   528: checkcast 217	androidx/compose/foundation/lazy/m
    //   531: astore 10
    //   533: aload 7
    //   535: astore 6
    //   537: aload 7
    //   539: astore_2
    //   540: aload 10
    //   542: invokeinterface 223 1 0
    //   547: iload 5
    //   549: if_icmpeq -192 -> 357
    //   552: aload 7
    //   554: astore_2
    //   555: aload 7
    //   557: getfield 177	com/tencent/mm/aj/c/b/f:afi	Landroidx/compose/foundation/lazy/aa;
    //   560: astore 6
    //   562: aload 7
    //   564: astore_2
    //   565: aload 10
    //   567: invokeinterface 223 1 0
    //   572: i2f
    //   573: fload_3
    //   574: fmul
    //   575: invokestatic 467	kotlin/h/a:eH	(F)I
    //   578: istore_1
    //   579: aload 7
    //   581: astore_2
    //   582: aload 8
    //   584: aload 7
    //   586: putfield 432	com/tencent/mm/aj/c/b/f$d:L$0	Ljava/lang/Object;
    //   589: aload 7
    //   591: astore_2
    //   592: aload 8
    //   594: iconst_4
    //   595: putfield 376	com/tencent/mm/aj/c/b/f$d:label	I
    //   598: aload 7
    //   600: astore_2
    //   601: aload 6
    //   603: iload 4
    //   605: iload_1
    //   606: aload 8
    //   608: invokevirtual 470	androidx/compose/foundation/lazy/aa:a	(IILkotlin/d/d;)Ljava/lang/Object;
    //   611: astore 8
    //   613: aload 7
    //   615: astore 6
    //   617: aload 8
    //   619: aload 9
    //   621: if_acmpne -264 -> 357
    //   624: ldc_w 372
    //   627: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   630: aload 9
    //   632: areturn
    //   633: iconst_0
    //   634: istore_1
    //   635: goto -116 -> 519
    //   638: aload 7
    //   640: astore_2
    //   641: new 472	java/util/NoSuchElementException
    //   644: dup
    //   645: ldc_w 474
    //   648: invokespecial 475	java/util/NoSuchElementException:<init>	(Ljava/lang/String;)V
    //   651: checkcast 413	java/lang/Throwable
    //   654: astore 6
    //   656: aload 7
    //   658: astore_2
    //   659: ldc_w 372
    //   662: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   665: aload 7
    //   667: astore_2
    //   668: aload 6
    //   670: athrow
    //   671: aload 8
    //   673: getfield 432	com/tencent/mm/aj/c/b/f$d:L$0	Ljava/lang/Object;
    //   676: checkcast 2	com/tencent/mm/aj/c/b/f
    //   679: astore 6
    //   681: aload 6
    //   683: astore_2
    //   684: aload 10
    //   686: invokestatic 396	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   689: goto -332 -> 357
    //   692: astore 6
    //   694: aload_0
    //   695: astore_2
    //   696: goto -299 -> 397
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	699	0	this	f
    //   0	699	1	paramInt	int
    //   0	699	2	paramd	kotlin.d.d<? super ah>
    //   422	152	3	f	float
    //   1	603	4	i	int
    //   4	546	5	j	int
    //   313	72	6	localObject1	Object
    //   395	13	6	localObject2	Object
    //   472	210	6	localObject3	Object
    //   692	1	6	localObject4	Object
    //   438	228	7	localf	f
    //   23	649	8	localObject5	Object
    //   61	570	9	locala	kotlin.d.a.a
    //   56	629	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   346	351	395	finally
    //   387	392	395	finally
    //   443	448	395	finally
    //   451	474	395	finally
    //   477	487	395	finally
    //   490	499	395	finally
    //   502	517	395	finally
    //   526	533	395	finally
    //   540	552	395	finally
    //   555	562	395	finally
    //   565	579	395	finally
    //   582	589	395	finally
    //   592	598	395	finally
    //   601	613	395	finally
    //   641	656	395	finally
    //   659	665	395	finally
    //   668	671	395	finally
    //   684	689	395	finally
    //   281	315	692	finally
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(238873);
    int i = ((Number)this.oih.getValue()).intValue();
    AppMethodBeat.o(238873);
    return i;
  }
  
  public final boolean ml()
  {
    AppMethodBeat.i(369573);
    boolean bool = this.afi.ml();
    AppMethodBeat.o(369573);
    return bool;
  }
  
  public final float s(float paramFloat)
  {
    AppMethodBeat.i(238901);
    paramFloat = this.afi.s(paramFloat);
    AppMethodBeat.o(238901);
    return paramFloat;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(238906);
    String str = "PagerState(pageCount=" + getPageCount() + ", currentPage=" + bzk() + ", currentPageOffset=" + bzm() + ')';
    AppMethodBeat.o(238906);
    return str;
  }
  
  public final void uS(int paramInt)
  {
    AppMethodBeat.i(238877);
    if (paramInt != bzk()) {
      uR(paramInt);
    }
    AppMethodBeat.o(238877);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    float aad;
    int aai;
    int asI;
    int label;
    
    d(f paramf, kotlin.d.d<? super d> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(238774);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.oin.c(0, (kotlin.d.d)this);
      AppMethodBeat.o(238774);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Float>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Integer>
  {
    f(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.c.b.f
 * JD-Core Version:    0.7.0.1
 */