package androidx.compose.foundation.f;

import androidx.compose.runtime.y;
import androidx.compose.ui.e.ad;
import androidx.compose.ui.e.z;
import androidx.compose.ui.h.x.a;
import androidx.compose.ui.m.b.c.a;
import androidx.compose.ui.n.c;
import androidx.compose.ui.n.l;
import androidx.compose.ui.n.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/text/TextController;", "", "state", "Landroidx/compose/foundation/text/TextState;", "(Landroidx/compose/foundation/text/TextState;)V", "commit", "Lkotlin/Function1;", "Landroidx/compose/runtime/DisposableEffectScope;", "Landroidx/compose/runtime/DisposableEffectResult;", "Lkotlin/ExtensionFunctionType;", "getCommit", "()Lkotlin/jvm/functions/Function1;", "longPressDragObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getLongPressDragObserver", "()Landroidx/compose/foundation/text/TextDragObserver;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "modifiers", "Landroidx/compose/ui/Modifier;", "getModifiers", "()Landroidx/compose/ui/Modifier;", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "selectionRegistrar", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "getSelectionRegistrar", "()Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "setSelectionRegistrar", "(Landroidx/compose/foundation/text/selection/SelectionRegistrar;)V", "getState", "()Landroidx/compose/foundation/text/TextState;", "outOfBoundary", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "outOfBoundary-0a9Yr6o", "(JJ)Z", "update", "", "drawTextAndSelectionBehind", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  final i ahb;
  androidx.compose.foundation.f.a.g ahc;
  final androidx.compose.ui.f ahd;
  final androidx.compose.ui.h.p ahe;
  final kotlin.g.a.b<y, androidx.compose.runtime.x> ahf;
  final h ahg;
  final androidx.compose.foundation.f.a.b ahh;
  
  public f(i parami)
  {
    AppMethodBeat.i(203718);
    this.ahb = parami;
    this.ahd = androidx.compose.ui.k.n.a(androidx.compose.ui.h.u.c(androidx.compose.ui.b.i.a(ad.a((androidx.compose.ui.f)androidx.compose.ui.f.aud, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0L, null, false, 8191), (kotlin.g.a.b)new b(this)), (kotlin.g.a.b)new e(this)), false, (kotlin.g.a.b)new f(this));
    this.ahe = ((androidx.compose.ui.h.p)new d(this));
    this.ahf = ((kotlin.g.a.b)new a(this));
    this.ahg = ((h)new c(this));
    this.ahh = ((androidx.compose.foundation.f.a.b)new g(this));
    AppMethodBeat.o(203718);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.b<y, androidx.compose.runtime.x>
  {
    a(f paramf)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/layout/LayoutCoordinates;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<androidx.compose.ui.h.j>
    {
      a(f paramf)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/text/TextLayoutResult;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<androidx.compose.ui.m.q>
    {
      b(f paramf)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      implements androidx.compose.runtime.x
    {
      public c(f paramf) {}
      
      public final void dispose() {}
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<androidx.compose.ui.e.b.e, ah>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/text/TextController$longPressDragObserver$1", "Landroidx/compose/foundation/text/TextDragObserver;", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "getDragBeginPosition", "()J", "setDragBeginPosition", "(J)V", "J", "dragTotalDistance", "getDragTotalDistance", "setDragTotalDistance", "onCancel", "", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements h
  {
    private long ahj;
    private long ahk;
    
    c(f paramf)
    {
      AppMethodBeat.i(203716);
      paramf = androidx.compose.ui.d.e.avo;
      this.ahj = androidx.compose.ui.d.e.su();
      paramf = androidx.compose.ui.d.e.avo;
      this.ahk = androidx.compose.ui.d.e.su();
      AppMethodBeat.o(203716);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(203734);
      androidx.compose.foundation.f.a.h.a(this.ahi.ahc, this.ahi.ahb.ahv);
      AppMethodBeat.o(203734);
    }
    
    public final void onStop()
    {
      AppMethodBeat.i(203731);
      androidx.compose.foundation.f.a.h.a(this.ahi.ahc, this.ahi.ahb.ahv);
      AppMethodBeat.o(203731);
    }
    
    public final void v(long paramLong)
    {
      AppMethodBeat.i(203723);
      Object localObject = this.ahi.ahb.ahy;
      f localf;
      if (localObject != null)
      {
        localf = this.ahi;
        if (!((androidx.compose.ui.h.j)localObject).isAttached())
        {
          AppMethodBeat.o(203723);
          return;
        }
        if (!f.a(localf, paramLong, paramLong)) {
          break label93;
        }
        if (localf.ahc == null) {}
      }
      for (;;)
      {
        this.ahj = paramLong;
        if (androidx.compose.foundation.f.a.h.a(this.ahi.ahc, this.ahi.ahb.ahv)) {
          break;
        }
        AppMethodBeat.o(203723);
        return;
        label93:
        if (localf.ahc != null) {
          localObject = androidx.compose.foundation.f.a.f.ahL;
        }
      }
      localObject = androidx.compose.ui.d.e.avo;
      this.ahk = androidx.compose.ui.d.e.su();
      AppMethodBeat.o(203723);
    }
    
    public final void w(long paramLong)
    {
      AppMethodBeat.i(203729);
      Object localObject = this.ahi.ahb.ahy;
      if (localObject != null)
      {
        f localf = this.ahi;
        if (!((androidx.compose.ui.h.j)localObject).isAttached())
        {
          AppMethodBeat.o(203729);
          return;
        }
        if (!androidx.compose.foundation.f.a.h.a(localf.ahc, localf.ahb.ahv))
        {
          AppMethodBeat.o(203729);
          return;
        }
        this.ahk = androidx.compose.ui.d.e.g(this.ahk, paramLong);
        if ((!f.a(localf, this.ahj, androidx.compose.ui.d.e.g(this.ahj, this.ahk))) && (localf.ahc != null))
        {
          androidx.compose.ui.d.e.g(this.ahj, this.ahk);
          localObject = androidx.compose.foundation.f.a.f.ahK;
        }
      }
      AppMethodBeat.o(203729);
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/text/TextController$measurePolicy$1", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements androidx.compose.ui.h.p
  {
    d(f paramf) {}
    
    public final androidx.compose.ui.h.q a(androidx.compose.ui.h.r paramr, List<? extends androidx.compose.ui.h.o> paramList, long paramLong)
    {
      AppMethodBeat.i(203737);
      s.u(paramr, "$receiver");
      s.u(paramList, "measurables");
      Object localObject2 = this.ahi.ahb.ahu;
      Object localObject3 = paramr.getLayoutDirection();
      Object localObject1 = this.ahi.ahb.ahz;
      s.u(localObject3, "layoutDirection");
      Object localObject5;
      Object localObject6;
      int j;
      boolean bool;
      if (localObject1 != null)
      {
        Object localObject8 = ((g)localObject2).ahm;
        localObject5 = ((g)localObject2).ahn;
        localObject6 = ((g)localObject2).ahr;
        j = ((g)localObject2).maxLines;
        bool = ((g)localObject2).aho;
        k = ((g)localObject2).ahp;
        Object localObject7 = ((g)localObject2).TD;
        c.a locala = ((g)localObject2).ahq;
        s.u(localObject1, "$this$canReuse");
        s.u(localObject8, "text");
        s.u(localObject5, "style");
        s.u(localObject6, "placeholders");
        s.u(localObject7, "density");
        s.u(localObject3, "layoutDirection");
        s.u(locala, "resourceLoader");
        localObject4 = ((androidx.compose.ui.m.q)localObject1).bav;
        if (s.p(((androidx.compose.ui.m.p)localObject4).ahm, localObject8))
        {
          localObject8 = ((androidx.compose.ui.m.p)localObject4).ahn;
          s.u(localObject8, "<this>");
          s.u(localObject5, "other");
          if ((androidx.compose.ui.n.o.e(((androidx.compose.ui.m.u)localObject8).bai, ((androidx.compose.ui.m.u)localObject5).bai)) && (s.p(((androidx.compose.ui.m.u)localObject8).baj, ((androidx.compose.ui.m.u)localObject5).baj)) && (s.p(((androidx.compose.ui.m.u)localObject8).bak, ((androidx.compose.ui.m.u)localObject5).bak)) && (s.p(((androidx.compose.ui.m.u)localObject8).bal, ((androidx.compose.ui.m.u)localObject5).bal)) && (s.p(((androidx.compose.ui.m.u)localObject8).bam, ((androidx.compose.ui.m.u)localObject5).bam)) && (s.p(((androidx.compose.ui.m.u)localObject8).ban, ((androidx.compose.ui.m.u)localObject5).ban)) && (androidx.compose.ui.n.o.e(((androidx.compose.ui.m.u)localObject8).bao, ((androidx.compose.ui.m.u)localObject5).bao)) && (s.p(((androidx.compose.ui.m.u)localObject8).bap, ((androidx.compose.ui.m.u)localObject5).bap)) && (s.p(((androidx.compose.ui.m.u)localObject8).baq, ((androidx.compose.ui.m.u)localObject5).baq)) && (s.p(((androidx.compose.ui.m.u)localObject8).bar, ((androidx.compose.ui.m.u)localObject5).bar)) && (z.e(((androidx.compose.ui.m.u)localObject8).bas, ((androidx.compose.ui.m.u)localObject5).bas)) && (s.p(((androidx.compose.ui.m.u)localObject8).aZc, ((androidx.compose.ui.m.u)localObject5).aZc)) && (s.p(((androidx.compose.ui.m.u)localObject8).aZd, ((androidx.compose.ui.m.u)localObject5).aZd)) && (androidx.compose.ui.n.o.e(((androidx.compose.ui.m.u)localObject8).aZe, ((androidx.compose.ui.m.u)localObject5).aZe)) && (s.p(((androidx.compose.ui.m.u)localObject8).aZf, ((androidx.compose.ui.m.u)localObject5).aZf)))
          {
            i = 1;
            if ((i != 0) && (s.p(((androidx.compose.ui.m.p)localObject4).ahr, localObject6)) && (((androidx.compose.ui.m.p)localObject4).maxLines == j) && (((androidx.compose.ui.m.p)localObject4).aho == bool) && (androidx.compose.ui.m.f.h.C(((androidx.compose.ui.m.p)localObject4).ahp, k)) && (s.p(((androidx.compose.ui.m.p)localObject4).TD, localObject7)) && (((androidx.compose.ui.m.p)localObject4).agm == localObject3) && (s.p(((androidx.compose.ui.m.p)localObject4).ahq, locala))) {
              break label890;
            }
          }
        }
        else
        {
          i = 0;
          label540:
          if (i == 0) {
            break label959;
          }
          localObject3 = ((androidx.compose.ui.m.q)localObject1).bav;
          localObject2 = ((g)localObject2).ahn;
          localObject4 = ((androidx.compose.ui.m.p)localObject3).ahm;
          localObject5 = ((androidx.compose.ui.m.p)localObject3).ahr;
          i = ((androidx.compose.ui.m.p)localObject3).maxLines;
          bool = ((androidx.compose.ui.m.p)localObject3).aho;
          j = ((androidx.compose.ui.m.p)localObject3).ahp;
          localObject6 = ((androidx.compose.ui.m.p)localObject3).TD;
          localObject7 = ((androidx.compose.ui.m.p)localObject3).agm;
          localObject3 = ((androidx.compose.ui.m.p)localObject3).ahq;
          s.u(localObject4, "text");
          s.u(localObject2, "style");
          s.u(localObject5, "placeholders");
          s.u(localObject6, "density");
          s.u(localObject7, "layoutDirection");
          s.u(localObject3, "resourceLoader");
          localObject2 = new androidx.compose.ui.m.p((androidx.compose.ui.m.a)localObject4, (androidx.compose.ui.m.u)localObject2, (List)localObject5, i, bool, j, (androidx.compose.ui.n.d)localObject6, (androidx.compose.ui.n.n)localObject7, (c.a)localObject3, paramLong, (byte)0);
          paramLong = c.q(paramLong, m.an((int)(float)Math.ceil(((androidx.compose.ui.m.q)localObject1).baw.width), (int)(float)Math.ceil(((androidx.compose.ui.m.q)localObject1).baw.height)));
          s.u(localObject2, "layoutInput");
          localObject1 = new androidx.compose.ui.m.q((androidx.compose.ui.m.p)localObject2, ((androidx.compose.ui.m.q)localObject1).baw, paramLong, (byte)0);
          if (!s.p(this.ahi.ahb.ahz, localObject1))
          {
            this.ahi.ahb.ahw.invoke(localObject1);
            localObject2 = this.ahi.ahb.ahz;
            if (localObject2 != null) {
              s.p(((androidx.compose.ui.m.q)localObject2).bav.ahm, ((androidx.compose.ui.m.q)localObject1).bav.ahm);
            }
          }
          this.ahi.ahb.ahz = ((androidx.compose.ui.m.q)localObject1);
          if (paramList.size() < ((androidx.compose.ui.m.q)localObject1).aYQ.size()) {
            break label1378;
          }
        }
      }
      label959:
      label1094:
      label1113:
      label1378:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label1384;
        }
        paramr = (Throwable)new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(203737);
        throw paramr;
        i = 0;
        break;
        label890:
        if (androidx.compose.ui.n.b.aT(paramLong) == androidx.compose.ui.n.b.aT(((androidx.compose.ui.m.p)localObject4).aeB))
        {
          if (!bool)
          {
            localObject5 = androidx.compose.ui.m.f.h.beA;
            if (!androidx.compose.ui.m.f.h.C(k, androidx.compose.ui.m.f.h.Ce()))
            {
              i = 1;
              break label540;
            }
          }
          if (androidx.compose.ui.n.b.aU(paramLong) == androidx.compose.ui.n.b.aU(((androidx.compose.ui.m.p)localObject4).aeB))
          {
            i = 1;
            break label540;
          }
        }
        i = 0;
        break label540;
        s.u(localObject3, "layoutDirection");
        float f2;
        float f1;
        if ((((g)localObject2).ahs == null) || (localObject3 != ((g)localObject2).aht))
        {
          ((g)localObject2).aht = ((androidx.compose.ui.n.n)localObject3);
          localObject1 = ((g)localObject2).ahm;
          localObject4 = androidx.compose.ui.m.v.a(((g)localObject2).ahn, (androidx.compose.ui.n.n)localObject3);
          localObject5 = ((g)localObject2).TD;
          localObject6 = ((g)localObject2).ahq;
          localObject1 = new androidx.compose.ui.m.e((androidx.compose.ui.m.a)localObject1, (androidx.compose.ui.m.u)localObject4, ((g)localObject2).ahr, (androidx.compose.ui.n.d)localObject5, (c.a)localObject6);
          ((g)localObject2).ahs = ((androidx.compose.ui.m.e)localObject1);
          f2 = androidx.compose.ui.n.b.aT(paramLong);
          if (!((g)localObject2).aho)
          {
            i = ((g)localObject2).ahp;
            localObject1 = androidx.compose.ui.m.f.h.beA;
            if (!androidx.compose.ui.m.f.h.C(i, androidx.compose.ui.m.f.h.Ce())) {
              break label1322;
            }
          }
          i = 1;
          if ((i == 0) || (!androidx.compose.ui.n.b.aX(paramLong))) {
            break label1328;
          }
          f1 = androidx.compose.ui.n.b.aU(paramLong);
          if (((g)localObject2).aho) {
            break label1336;
          }
          i = ((g)localObject2).ahp;
          localObject1 = androidx.compose.ui.m.f.h.beA;
          if (!androidx.compose.ui.m.f.h.C(i, androidx.compose.ui.m.f.h.Ce())) {
            break label1336;
          }
          i = 1;
          label1147:
          if (i == 0) {
            break label1342;
          }
          i = 1;
          if (f2 != f1) {
            break label1352;
          }
          j = 1;
          if (j == 0) {
            break label1358;
          }
        }
        for (;;)
        {
          localObject1 = ((g)localObject2).mY();
          j = ((g)localObject2).ahp;
          localObject4 = androidx.compose.ui.m.f.h.beA;
          localObject1 = new androidx.compose.ui.m.d((androidx.compose.ui.m.e)localObject1, i, androidx.compose.ui.m.f.h.C(j, androidx.compose.ui.m.f.h.Ce()), f1);
          long l = c.q(paramLong, m.an((int)(float)Math.ceil(((androidx.compose.ui.m.d)localObject1).width), (int)(float)Math.ceil(((androidx.compose.ui.m.d)localObject1).height)));
          localObject1 = new androidx.compose.ui.m.q(new androidx.compose.ui.m.p(((g)localObject2).ahm, ((g)localObject2).ahn, ((g)localObject2).ahr, ((g)localObject2).maxLines, ((g)localObject2).aho, ((g)localObject2).ahp, ((g)localObject2).TD, (androidx.compose.ui.n.n)localObject3, ((g)localObject2).ahq, paramLong, (byte)0), (androidx.compose.ui.m.d)localObject1, l, (byte)0);
          break;
          localObject1 = ((g)localObject2).ahs;
          break label1046;
          i = 0;
          break label1094;
          f1 = (1.0F / 1.0F);
          break label1113;
          i = 0;
          break label1147;
          i = ((g)localObject2).maxLines;
          break label1155;
          j = 0;
          break label1166;
          f1 = kotlin.k.k.C(((g)localObject2).mY().AG(), f2, f1);
        }
      }
      label1046:
      label1322:
      label1328:
      label1336:
      label1342:
      label1352:
      label1358:
      label1384:
      localObject3 = ((androidx.compose.ui.m.q)localObject1).aYQ;
      label1155:
      label1166:
      Object localObject4 = new ArrayList(((List)localObject3).size());
      int k = ((List)localObject3).size() - 1;
      if (k >= 0) {}
      for (i = 0;; i = j)
      {
        j = i + 1;
        localObject2 = (androidx.compose.ui.d.g)((List)localObject3).get(i);
        if (localObject2 == null) {}
        for (localObject2 = null;; localObject2 = new kotlin.r(((androidx.compose.ui.h.o)paramList.get(i)).aw(c.o((int)(float)Math.floor(((androidx.compose.ui.d.g)localObject2).getWidth()), (int)(float)Math.floor(((androidx.compose.ui.d.g)localObject2).getHeight()), 5)), androidx.compose.ui.n.j.bh(androidx.compose.ui.n.k.am(kotlin.h.a.eH(((androidx.compose.ui.d.g)localObject2).left), kotlin.h.a.eH(((androidx.compose.ui.d.g)localObject2).top)))))
        {
          if (localObject2 != null) {
            ((Collection)localObject4).add(localObject2);
          }
          if (j <= k) {
            break;
          }
          paramList = (List)localObject4;
          paramr = paramr.a(l.bi(((androidx.compose.ui.m.q)localObject1).size), l.bj(((androidx.compose.ui.m.q)localObject1).size), ak.e(new kotlin.r[] { kotlin.v.Y(androidx.compose.ui.h.b.wC(), Integer.valueOf(kotlin.h.a.eH(((androidx.compose.ui.m.q)localObject1).bax))), kotlin.v.Y(androidx.compose.ui.h.b.wD(), Integer.valueOf(kotlin.h.a.eH(((androidx.compose.ui.m.q)localObject1).bay))) }), (kotlin.g.a.b)new a(paramList));
          AppMethodBeat.o(203737);
          return paramr;
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.b<x.a, ah>
    {
      a(List<? extends kotlin.r<? extends androidx.compose.ui.h.x, androidx.compose.ui.n.j>> paramList)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/layout/LayoutCoordinates;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<androidx.compose.ui.h.j, ah>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<androidx.compose.ui.k.u, ah>
  {
    f(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/text/TextController$mouseSelectionObserver$1", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "getDragBeginPosition", "()J", "setDragBeginPosition", "(J)V", "J", "onDrag", "", "dragPosition", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "onDrag-3MmeM6k", "(JLandroidx/compose/foundation/text/selection/SelectionAdjustment;)Z", "onExtend", "downPosition", "onExtend-k-4lQ0M", "(J)Z", "onExtendDrag", "onExtendDrag-k-4lQ0M", "onStart", "onStart-3MmeM6k", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements androidx.compose.foundation.f.a.b
  {
    private long ahj;
    
    g(f paramf)
    {
      AppMethodBeat.i(203703);
      paramf = androidx.compose.ui.d.e.avo;
      this.ahj = androidx.compose.ui.d.e.su();
      AppMethodBeat.o(203703);
    }
    
    public final boolean a(long paramLong, androidx.compose.foundation.f.a.f paramf)
    {
      AppMethodBeat.i(203707);
      s.u(paramf, "adjustment");
      paramf = this.ahi.ahb.ahy;
      if (paramf != null)
      {
        f localf = this.ahi;
        if (!paramf.isAttached())
        {
          AppMethodBeat.o(203707);
          return false;
        }
        this.ahj = paramLong;
        boolean bool = androidx.compose.foundation.f.a.h.a(localf.ahc, localf.ahb.ahv);
        AppMethodBeat.o(203707);
        return bool;
      }
      AppMethodBeat.o(203707);
      return false;
    }
    
    public final boolean a(androidx.compose.foundation.f.a.f paramf)
    {
      AppMethodBeat.i(203711);
      s.u(paramf, "adjustment");
      paramf = this.ahi.ahb.ahy;
      if (paramf != null)
      {
        f localf = this.ahi;
        if (!paramf.isAttached())
        {
          AppMethodBeat.o(203711);
          return false;
        }
        if (!androidx.compose.foundation.f.a.h.a(localf.ahc, localf.ahb.ahv))
        {
          AppMethodBeat.o(203711);
          return false;
        }
      }
      AppMethodBeat.o(203711);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.f.f
 * JD-Core Version:    0.7.0.1
 */