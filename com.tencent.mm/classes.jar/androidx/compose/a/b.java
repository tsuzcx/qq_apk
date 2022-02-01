package androidx.compose.a;

import androidx.compose.a.a.aj;
import androidx.compose.a.a.at;
import androidx.compose.a.a.au;
import androidx.compose.runtime.aa;
import androidx.compose.runtime.an;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.br;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.f;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.r;
import androidx.compose.ui.h.r.a;
import androidx.compose.ui.h.x;
import androidx.compose.ui.i.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<+Landroidx.compose.ui.h.o;>;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"AnimatedEnterExitImpl", "", "T", "transition", "Landroidx/compose/animation/core/Transition;", "visible", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "enter", "Landroidx/compose/animation/EnterTransition;", "exit", "Landroidx/compose/animation/ExitTransition;", "content", "Landroidx/compose/animation/AnimatedVisibilityScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/animation/EnterExitState;", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "AnimatedVisibility", "visibleState", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "initiallyVisible", "Lkotlin/Function0;", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/ColumnScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/RowScope;", "(Landroidx/compose/foundation/layout/RowScope;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/foundation/layout/RowScope;ZLandroidx/compose/ui/Modifier;Landroidx/compose/animation/EnterTransition;Landroidx/compose/animation/ExitTransition;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "targetEnterExit", "targetState", "(Landroidx/compose/animation/core/Transition;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/EnterExitState;", "animation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final <T> i a(at<T> paramat, kotlin.g.a.b<? super T, Boolean> paramb, T paramT, androidx.compose.runtime.h paramh)
  {
    AppMethodBeat.i(203079);
    paramh.bx(-721839832);
    paramh.i(-721839725, paramat);
    paramh.bx(-3687241);
    Object localObject2 = paramh.or();
    Object localObject1 = androidx.compose.runtime.h.alD;
    localObject1 = localObject2;
    if (localObject2 == h.a.ox())
    {
      localObject1 = bj.T(Boolean.FALSE);
      paramh.F(localObject1);
    }
    paramh.od();
    localObject1 = (an)localObject1;
    if (((Boolean)paramb.invoke(paramat.Wd.lN())).booleanValue()) {
      ((an)localObject1).setValue(Boolean.TRUE);
    }
    if (((Boolean)paramb.invoke(paramT)).booleanValue()) {
      paramat = i.SX;
    }
    for (;;)
    {
      paramh.oe();
      paramh.od();
      AppMethodBeat.o(203079);
      return paramat;
      if (((Boolean)((an)localObject1).getValue()).booleanValue()) {
        paramat = i.SY;
      } else {
        paramat = i.SW;
      }
    }
  }
  
  static final <T> void a(at<T> paramat, final kotlin.g.a.b<? super T, Boolean> paramb, final f paramf, final k paramk, final m paramm, final kotlin.g.a.q<? super c, ? super androidx.compose.runtime.h, ? super Integer, ah> paramq, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(203067);
    androidx.compose.runtime.h localh = paramh.by(-918811683);
    int i;
    if ((paramInt & 0xE) == 0) {
      if (localh.G(paramat)) {
        i = 4;
      }
    }
    for (int j = paramInt | i;; j = paramInt)
    {
      i = j;
      if ((paramInt & 0x70) == 0)
      {
        if (localh.G(paramb))
        {
          i = 32;
          label72:
          i = j | i;
        }
      }
      else
      {
        j = i;
        if ((paramInt & 0x380) == 0)
        {
          if (!localh.G(paramf)) {
            break label1237;
          }
          j = 256;
          label108:
          j = i | j;
        }
        i = j;
        if ((paramInt & 0x1C00) == 0)
        {
          if (!localh.G(paramk)) {
            break label1245;
          }
          i = 2048;
          label144:
          i = j | i;
        }
        j = i;
        if ((0xE000 & paramInt) == 0)
        {
          if (!localh.G(paramm)) {
            break label1253;
          }
          j = 16384;
          label180:
          j = i | j;
        }
        if ((0x70000 & paramInt) != 0) {
          break label1332;
        }
        if (!localh.G(paramq)) {
          break label1261;
        }
        i = 131072;
        label211:
        i |= j;
      }
      for (;;)
      {
        if (((0x5B6DB & i ^ 0x12492) != 0) || (!localh.nZ()))
        {
          localh.bx(-3686930);
          boolean bool1 = localh.G(paramat);
          Object localObject1 = localh.or();
          if (!bool1)
          {
            paramh = androidx.compose.runtime.h.alD;
            paramh = (androidx.compose.runtime.h)localObject1;
            if (localObject1 != h.a.ox()) {}
          }
          else
          {
            paramh = bj.T(paramb.invoke(paramat.Wd.lN()));
            localh.F(paramh);
          }
          localh.od();
          Object localObject2 = (an)paramh;
          if ((((Boolean)paramb.invoke(paramat.lO())).booleanValue()) || (((Boolean)((an)localObject2).getValue()).booleanValue()))
          {
            localh.bx(-918811264);
            j = i & 0xE;
            localh.bx(1117104460);
            localh.bx(-3686930);
            bool1 = localh.G(paramat);
            localObject1 = localh.or();
            if (!bool1)
            {
              paramh = androidx.compose.runtime.h.alD;
              paramh = (androidx.compose.runtime.h)localObject1;
              if (localObject1 != h.a.ox()) {}
            }
            else
            {
              paramh = paramat.Wd.lN();
              localh.F(paramh);
            }
            localh.od();
            localh.bx(-174040094);
            paramh = a(paramat, paramb, paramh, localh);
            localh.od();
            localObject1 = paramat.lO();
            localh.bx(-174040094);
            localObject1 = a(paramat, paramb, localObject1, localh);
            localh.od();
            Object localObject3 = au.a(paramat, paramh, localObject1, "ChildTransition", localh, j << 6 & 0x1C00 | j & 0xE);
            localh.od();
            localh.bx(-3686552);
            bool1 = localh.G(localObject3);
            boolean bool2 = localh.G(localObject2);
            paramh = localh.or();
            if (!(bool2 | bool1))
            {
              localObject1 = androidx.compose.runtime.h.alD;
              if (paramh != h.a.ox()) {}
            }
            else
            {
              paramh = (kotlin.g.a.m)new a((at)localObject3, (an)localObject2, null);
              localh.F(paramh);
              label648:
              localh.od();
              aa.a(localObject3, (kotlin.g.a.m)paramh, localh);
              i = i >> 3 & 0x70 | i >> 3 & 0x380 | i >> 3 & 0x1C00 | 0xE000 & i >> 3;
              localh.bx(-918810546);
              if ((((at)localObject3).Wd.lN() != i.SX) && (((at)localObject3).lO() != i.SX)) {
                break label1282;
              }
              localh.bx(-918809988);
              localh.bx(-3686930);
              bool1 = localh.G(localObject3);
              localObject1 = localh.or();
              if (!bool1)
              {
                paramh = androidx.compose.runtime.h.alD;
                paramh = (androidx.compose.runtime.h)localObject1;
                if (localObject1 != h.a.ox()) {}
              }
              else
              {
                paramh = new d((at)localObject3);
                localh.F(paramh);
              }
              localh.od();
              paramh = (d)paramh;
              Object localObject4 = paramf.a(j.a((at)localObject3, paramk, paramm, localh, i & 0xE | i >> 3 & 0x70 | i >> 3 & 0x380));
              localObject3 = (androidx.compose.ui.h.p)new c(paramh);
              localh.bx(1376089335);
              localObject2 = (androidx.compose.ui.n.d)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
              localObject1 = (androidx.compose.ui.n.n)localh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
              Object localObject5 = androidx.compose.ui.i.a.aNC;
              localObject5 = a.a.xb();
              localObject4 = androidx.compose.ui.h.m.i((f)localObject4);
              if (!(localh.nX() instanceof androidx.compose.runtime.d)) {
                androidx.compose.runtime.g.nW();
              }
              localh.ol();
              if (!localh.nY()) {
                break label1272;
              }
              localh.a((kotlin.g.a.a)localObject5);
              label988:
              localh.op();
              s.u(localh, "composer");
              localObject5 = androidx.compose.ui.i.a.aNC;
              br.a(localh, localObject3, a.a.xe());
              localObject3 = androidx.compose.ui.i.a.aNC;
              br.a(localh, localObject2, a.a.xd());
              localObject2 = androidx.compose.ui.i.a.aNC;
              br.a(localh, localObject1, a.a.xf());
              localh.oq();
              s.u(localh, "composer");
              ((kotlin.g.a.q)localObject4).invoke(bc.p(localh), localh, Integer.valueOf(0));
              localh.bx(2058660585);
              localh.bx(-174038756);
              paramq.invoke(paramh, localh, Integer.valueOf(i >> 9 & 0x70 | 0x8));
              localh.od();
              localh.od();
              localh.on();
              localh.od();
              localh.od();
              label1163:
              localh.od();
              localh.od();
            }
          }
        }
        for (;;)
        {
          paramh = localh.oh();
          if (paramh != null) {
            paramh.b((kotlin.g.a.m)new b(paramat, paramb, paramf, paramk, paramm, paramq, paramInt));
          }
          AppMethodBeat.o(203067);
          return;
          i = 2;
          break;
          i = 16;
          break label72;
          label1237:
          j = 128;
          break label108;
          label1245:
          i = 1024;
          break label144;
          label1253:
          j = 8192;
          break label180;
          label1261:
          i = 65536;
          break label211;
          break label648;
          label1272:
          localh.om();
          break label988;
          label1282:
          localh.bx(-918809227);
          localh.od();
          break label1163;
          localh.bx(-918810644);
          localh.od();
          continue;
          localh.oi();
        }
        label1332:
        i = j;
      }
    }
  }
  
  public static final void a(boolean paramBoolean, final f paramf, final k paramk, final m paramm, final kotlin.g.a.q<? super c, ? super androidx.compose.runtime.h, ? super Integer, ah> paramq, androidx.compose.runtime.h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(203048);
    s.u(paramq, "content");
    androidx.compose.runtime.h localh = paramh.by(1844969890);
    int i;
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label55:
    label62:
    label74:
    label81:
    label94:
    label101:
    label742:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      if ((paramInt2 & 0x2) != 0)
      {
        i = 48;
        i = j | i;
        if ((paramInt2 & 0x4) == 0) {
          break label604;
        }
        j = 384;
        j = i | j;
        if ((paramInt2 & 0x8) == 0) {
          break label644;
        }
        i = 3072;
        i = j | i;
        if ((paramInt2 & 0x10) == 0) {
          break label684;
        }
        j = 24576;
        label114:
        i |= j;
      }
      for (;;)
      {
        if (((0xB6DB & i ^ 0x2492) != 0) || (!localh.nZ()))
        {
          if ((paramInt2 & 0x2) == 0) {
            break label736;
          }
          paramf = (f)f.aud;
        }
        for (;;)
        {
          Object localObject2;
          Object localObject3;
          Object localObject1;
          if ((paramInt2 & 0x4) != 0)
          {
            localObject2 = j.lr();
            localObject3 = j.lt();
            s.u(localObject3, "enter");
            paramh = ((k)localObject2).lx().TQ;
            paramk = paramh;
            if (paramh == null) {
              paramk = ((k)localObject3).lx().TQ;
            }
            localObject1 = ((k)localObject2).lx().TR;
            paramh = (androidx.compose.runtime.h)localObject1;
            if (localObject1 == null) {
              paramh = ((k)localObject3).lx().TR;
            }
            localObject2 = ((k)localObject2).lx().TS;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = ((k)localObject3).lx().TS;
            }
            paramk = (k)new l(new w(paramk, paramh, (e)localObject1));
          }
          for (;;)
          {
            if ((paramInt2 & 0x8) != 0)
            {
              localObject2 = j.lu();
              localObject3 = j.ls();
              s.u(localObject3, "exit");
              paramh = ((m)localObject2).lx().TQ;
              paramm = paramh;
              if (paramh == null) {
                paramm = ((m)localObject3).lx().TQ;
              }
              localObject1 = ((m)localObject2).lx().TR;
              paramh = (androidx.compose.runtime.h)localObject1;
              if (localObject1 == null) {
                paramh = ((m)localObject3).lx().TR;
              }
              localObject2 = ((m)localObject2).lx().TS;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = ((m)localObject3).lx().TS;
              }
              paramm = (m)new n(new w(paramm, paramh, (e)localObject1));
            }
            for (;;)
            {
              a(au.c(Boolean.valueOf(paramBoolean), localh, i & 0xE), (kotlin.g.a.b)b.d.SB, paramf, paramk, paramm, paramq, localh, i << 3 & 0x70000 | i << 3 & 0x380 | i << 3 & 0x1C00 | 0xE000 & i << 3);
              for (;;)
              {
                paramh = localh.oh();
                if (paramh != null) {
                  paramh.b((kotlin.g.a.m)new e(paramBoolean, paramf, paramk, paramm, paramq, paramInt1, paramInt2));
                }
                AppMethodBeat.o(203048);
                return;
                if ((paramInt1 & 0xE) != 0) {
                  break label742;
                }
                if (localh.am(paramBoolean))
                {
                  i = 4;
                  break;
                }
                i = 2;
                break;
                i = j;
                if ((paramInt1 & 0x70) != 0) {
                  break label62;
                }
                if (localh.G(paramf))
                {
                  i = 32;
                  break label55;
                }
                i = 16;
                break label55;
                j = i;
                if ((paramInt1 & 0x380) != 0) {
                  break label81;
                }
                if (localh.G(paramk))
                {
                  j = 256;
                  break label74;
                }
                j = 128;
                break label74;
                i = j;
                if ((paramInt1 & 0x1C00) != 0) {
                  break label101;
                }
                if (localh.G(paramm))
                {
                  i = 2048;
                  break label94;
                }
                i = 1024;
                break label94;
                if ((0xE000 & paramInt1) != 0) {
                  break label739;
                }
                if (localh.G(paramq))
                {
                  j = 16384;
                  break label114;
                }
                j = 8192;
                break label114;
                localh.oi();
              }
            }
          }
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(at<i> paramat, an<Boolean> paraman, kotlin.d.d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(203014);
      paramObject = (kotlin.d.d)new a(this.Sq, this.Sr, paramd);
      AppMethodBeat.o(203014);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(203009);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(203009);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = bj.g((kotlin.g.a.a)new kotlin.g.b.u(this.Sq) {});
        kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(this.Sr);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(203009);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(203009);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements kotlinx.coroutines.b.h<Boolean>
    {
      public a(an paraman) {}
      
      public final Object a(Boolean paramBoolean, kotlin.d.d<? super ah> paramd)
      {
        AppMethodBeat.i(203003);
        boolean bool = ((Boolean)paramBoolean).booleanValue();
        this.Ss.setValue(Boolean.valueOf(bool));
        paramBoolean = ah.aiuX;
        AppMethodBeat.o(203003);
        return paramBoolean;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    b(at<T> paramat, kotlin.g.a.b<? super T, Boolean> paramb, f paramf, k paramk, m paramm, kotlin.g.a.q<? super c, ? super androidx.compose.runtime.h, ? super Integer, ah> paramq, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    implements androidx.compose.ui.h.p
  {
    public c(d paramd) {}
    
    public final androidx.compose.ui.h.q a(r paramr, List<? extends o> paramList, long paramLong)
    {
      AppMethodBeat.i(203000);
      s.u(paramr, "$this$Layout");
      s.u(paramList, "measureables");
      Object localObject = (Iterable)paramList;
      paramList = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramList.add(((o)((Iterator)localObject).next()).aw(paramLong));
      }
      List localList = (List)paramList;
      int j;
      label116:
      int i;
      label140:
      int m;
      label231:
      int k;
      if (localList.isEmpty())
      {
        paramList = null;
        paramList = (x)paramList;
        if (paramList == null)
        {
          j = 0;
          if (!localList.isEmpty()) {
            break label285;
          }
          paramList = null;
          paramList = (x)paramList;
          if (paramList != null) {
            break label371;
          }
          i = 0;
          this.Sz.SE.setValue(androidx.compose.ui.n.l.bk(androidx.compose.ui.n.m.an(j, i)));
          paramr = r.a.a(paramr, j, i, (kotlin.g.a.b)new b.c.a(localList));
          AppMethodBeat.o(203000);
          return paramr;
        }
      }
      else
      {
        localObject = localList.get(0);
        i = ((x)localObject).width;
        m = kotlin.a.p.oE(localList);
        paramList = (List<? extends o>)localObject;
        if (m > 0)
        {
          j = 1;
          paramList = (List<? extends o>)localObject;
          localObject = localList.get(j);
          k = ((x)localObject).width;
          if (i >= k) {
            break label401;
          }
          paramList = (List<? extends o>)localObject;
          i = k;
        }
      }
      label401:
      for (;;)
      {
        if (j == m)
        {
          break;
          j = paramList.width;
          break label116;
          label285:
          localObject = localList.get(0);
          i = ((x)localObject).height;
          int n = kotlin.a.p.oE(localList);
          paramList = (List<? extends o>)localObject;
          if (n > 0)
          {
            k = 1;
            paramList = (List<? extends o>)localObject;
          }
          for (;;)
          {
            localObject = localList.get(k);
            m = ((x)localObject).height;
            if (i < m)
            {
              paramList = (List<? extends o>)localObject;
              i = m;
            }
            for (;;)
            {
              if (k != n) {
                break label383;
              }
              break;
              label371:
              i = paramList.height;
              break label140;
            }
            label383:
            k += 1;
          }
        }
        j += 1;
        break label231;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    e(boolean paramBoolean, f paramf, k paramk, m paramm, kotlin.g.a.q<? super c, ? super androidx.compose.runtime.h, ? super Integer, ah> paramq, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.b
 * JD-Core Version:    0.7.0.1
 */