package androidx.compose.foundation.a;

import androidx.compose.runtime.an;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.ui.f;
import androidx.compose.ui.g.b.a.a;
import androidx.compose.ui.g.b.g;
import androidx.compose.ui.platform.ab;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Landroidx.compose.ui.n.r;>;
import kotlin.g.a.b;
import kotlin.g.a.q;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"NoOpScrollScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollableNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollLogic", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "enabled", "", "scrollable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "touchScrollImplementation", "controller", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class r
{
  private static final p abh;
  
  static
  {
    AppMethodBeat.i(204169);
    abh = (p)new a();
    AppMethodBeat.o(204169);
  }
  
  public static final f a(f paramf, final s params, final k paramk, final boolean paramBoolean1, final boolean paramBoolean2, final i parami, final androidx.compose.foundation.b.e parame)
  {
    AppMethodBeat.i(204152);
    kotlin.g.b.s.u(paramf, "<this>");
    kotlin.g.b.s.u(params, "state");
    kotlin.g.b.s.u(paramk, "orientation");
    if (ab.zi()) {}
    for (b localb = (b)new b(paramk, params, paramBoolean1, paramBoolean2, parami, parame);; localb = ab.zh())
    {
      paramf = androidx.compose.ui.e.a(paramf, localb, (q)new c(parame, paramk, paramBoolean2, params, parami, paramBoolean1));
      AppMethodBeat.o(204152);
      return paramf;
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/gestures/ScrollableKt$NoOpScrollScope$1", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollBy", "", "pixels", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements p
  {
    public final float t(float paramFloat)
    {
      return paramFloat;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    extends kotlin.g.b.u
    implements b<ad, ah>
  {
    public b(k paramk, s params, boolean paramBoolean1, boolean paramBoolean2, i parami, androidx.compose.foundation.b.e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements q<f, h, Integer, f>
  {
    c(androidx.compose.foundation.b.e parame, k paramk, boolean paramBoolean1, s params, i parami, boolean paramBoolean2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/gestures/ScrollableKt$scrollableNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements androidx.compose.ui.g.b.a
  {
    d(boolean paramBoolean, bm<u> parambm) {}
    
    public final long a(long paramLong1, long paramLong2, int paramInt)
    {
      AppMethodBeat.i(204003);
      if (this.eD)
      {
        localObject = g.aKL;
        boolean bool;
        if (g.C(paramInt, g.wg())) {
          bool = true;
        }
        while (bool)
        {
          localObject = (u)this.abk.getValue();
          if (((u)localObject).ZF.ml())
          {
            localObject = androidx.compose.ui.d.e.avo;
            paramLong1 = androidx.compose.ui.d.e.su();
            AppMethodBeat.o(204003);
            return paramLong1;
            localObject = g.aKL;
            bool = g.C(paramInt, g.wh());
          }
          else
          {
            paramLong1 = ((u)localObject).y(((u)localObject).A(((u)localObject).ZF.s(((u)localObject).A(((u)localObject).u(paramLong2)))));
            AppMethodBeat.o(204003);
            return paramLong1;
          }
        }
        localObject = g.aKL;
        if (g.C(paramInt, g.wi()))
        {
          localObject = (u)this.abk.getValue();
          j.a(((androidx.compose.ui.g.b.d)((u)localObject).abs.getValue()).wd(), null, null, (kotlin.g.a.m)new u.d((u)localObject, paramLong2, null), 3);
          AppMethodBeat.o(204003);
          return paramLong2;
        }
        localObject = (Throwable)new IllegalStateException((g.cJ(paramInt) + " scroll not supported.").toString());
        AppMethodBeat.o(204003);
        throw ((Throwable)localObject);
      }
      Object localObject = androidx.compose.ui.d.e.avo;
      paramLong1 = androidx.compose.ui.d.e.su();
      AppMethodBeat.o(204003);
      return paramLong1;
    }
    
    public final Object a(long paramLong1, long paramLong2, kotlin.d.d<? super androidx.compose.ui.n.r> paramd)
    {
      AppMethodBeat.i(204013);
      Object localObject;
      if ((paramd instanceof a))
      {
        localObject = (a)paramd;
        if ((((a)localObject).label & 0x80000000) != 0) {
          ((a)localObject).label += -2147483648;
        }
      }
      kotlin.d.a.a locala;
      for (paramd = (kotlin.d.d<? super androidx.compose.ui.n.r>)localObject;; paramd = new a(this, paramd))
      {
        localObject = paramd.result;
        locala = kotlin.d.a.a.aiwj;
        switch (paramd.label)
        {
        default: 
          paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(204013);
          throw paramd;
        }
      }
      ResultKt.throwOnFailure(localObject);
      if (this.eD)
      {
        localObject = (u)this.abk.getValue();
        paramd.Yx = paramLong2;
        paramd.label = 1;
        localObject = ((u)localObject).b(paramLong2, paramd);
        paramd = (kotlin.d.d<? super androidx.compose.ui.n.r>)localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(204013);
          return locala;
          paramLong2 = paramd.Yx;
          ResultKt.throwOnFailure(localObject);
          paramd = (kotlin.d.d<? super androidx.compose.ui.n.r>)localObject;
        }
      }
      for (paramLong1 = androidx.compose.ui.n.r.t(paramLong2, ((androidx.compose.ui.n.r)paramd).avp);; paramLong1 = androidx.compose.ui.n.r.su())
      {
        paramd = androidx.compose.ui.n.r.bs(paramLong1);
        AppMethodBeat.o(204013);
        return paramd;
        paramd = androidx.compose.ui.n.r.beY;
      }
    }
    
    public final Object a(long paramLong, kotlin.d.d<? super androidx.compose.ui.n.r> paramd)
    {
      AppMethodBeat.i(204025);
      paramd = a.a.vT();
      AppMethodBeat.o(204025);
      return paramd;
    }
    
    public final long b(long paramLong, int paramInt)
    {
      AppMethodBeat.i(204021);
      paramLong = a.a.a(this);
      AppMethodBeat.o(204021);
      return paramLong;
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.d
    {
      long Yx;
      int label;
      
      a(r.d paramd, kotlin.d.d<? super a> paramd1)
      {
        super();
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(204032);
        this.result = paramObject;
        this.label |= 0x80000000;
        paramObject = this.abl.a(0L, 0L, (kotlin.d.d)this);
        AppMethodBeat.o(204032);
        return paramObject;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements b<androidx.compose.ui.g.c.m, Boolean>
  {
    public static final e abm;
    
    static
    {
      AppMethodBeat.i(204002);
      abm = new e();
      AppMethodBeat.o(204002);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Boolean>
  {
    f(s params)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.k
    implements q<aq, Float, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    g(an<androidx.compose.ui.g.b.d> paraman, bm<u> parambm, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(203999);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(203999);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      final float f = this.aad;
      j.a(((androidx.compose.ui.g.b.d)this.abo.getValue()).wd(), null, null, (kotlin.g.a.m)new kotlin.d.b.a.k(this.abk, f)
      {
        int label;
        
        public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
        {
          AppMethodBeat.i(204137);
          paramAnonymousObject = (kotlin.d.d)new 1(this.abk, f, paramAnonymousd);
          AppMethodBeat.o(204137);
          return paramAnonymousObject;
        }
        
        public final Object invokeSuspend(Object paramAnonymousObject)
        {
          AppMethodBeat.i(204129);
          kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
          switch (this.label)
          {
          default: 
            paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(204129);
            throw paramAnonymousObject;
          case 0: 
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = (u)this.abk.getValue();
            float f = f;
            kotlin.d.d locald = (kotlin.d.d)this;
            this.label = 1;
            if (paramAnonymousObject.a(f, locald) == locala)
            {
              AppMethodBeat.o(204129);
              return locala;
            }
            break;
          case 1: 
            ResultKt.throwOnFailure(paramAnonymousObject);
          }
          paramAnonymousObject = ah.aiuX;
          AppMethodBeat.o(204129);
          return paramAnonymousObject;
        }
      }, 3);
      paramObject = ah.aiuX;
      AppMethodBeat.o(203999);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a.r
 * JD-Core Version:    0.7.0.1
 */