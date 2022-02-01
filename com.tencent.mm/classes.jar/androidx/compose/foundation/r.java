package androidx.compose.foundation;

import androidx.compose.foundation.a.o;
import androidx.compose.runtime.e.i;
import androidx.compose.runtime.h;
import androidx.compose.ui.e.ak;
import androidx.compose.ui.e.ak.b;
import androidx.compose.ui.e.ay;
import androidx.compose.ui.f;
import androidx.compose.ui.n.n;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"HorizontalScrollableClipModifier", "Landroidx/compose/ui/Modifier;", "MaxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "VerticalScrollableClipModifier", "rememberScrollState", "Landroidx/compose/foundation/ScrollState;", "initial", "", "(ILandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/ScrollState;", "assertNotNestingScrollableContainers", "", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "assertNotNestingScrollableContainers-K40F9xA", "(JZ)V", "clipScrollableContainer", "horizontalScroll", "state", "enabled", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "reverseScrolling", "scroll", "isScrollable", "verticalScroll", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class r
{
  private static final float Zk;
  private static final f Zl;
  private static final f Zm;
  
  static
  {
    AppMethodBeat.i(203556);
    Zk = androidx.compose.ui.n.g.ai(30.0F);
    Zl = androidx.compose.ui.b.d.a((f)f.aud, (ay)new a());
    Zm = androidx.compose.ui.b.d.a((f)f.aud, (ay)new b());
    AppMethodBeat.o(203556);
  }
  
  public static final f a(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(203544);
    kotlin.g.b.s.u(paramf, "<this>");
    if (paramBoolean) {}
    for (f localf = Zm;; localf = Zl)
    {
      paramf = paramf.a(localf);
      AppMethodBeat.o(203544);
      return paramf;
    }
  }
  
  public static final void b(long paramLong, boolean paramBoolean)
  {
    int j = 1;
    int i = 1;
    AppMethodBeat.i(203537);
    Throwable localThrowable;
    if (paramBoolean)
    {
      if (androidx.compose.ui.n.b.aW(paramLong) != 2147483647) {}
      while (i == 0)
      {
        localThrowable = (Throwable)new IllegalStateException("Nesting scrollable in the same direction layouts like LazyColumn and Column(Modifier.verticalScroll()) is not allowed. If you want to add a header before the list of items please take a look on LazyColumn component which has a DSL api which allows to first add a header via item() function and then the list of items via items().".toString());
        AppMethodBeat.o(203537);
        throw localThrowable;
        i = 0;
      }
    }
    if (androidx.compose.ui.n.b.aU(paramLong) != 2147483647) {}
    for (i = j; i == 0; i = 0)
    {
      localThrowable = (Throwable)new IllegalStateException("Nesting scrollable in the same direction layouts like LazyRow and Row(Modifier.horizontalScroll() is not allowed. If you want to add a header before the list of items please take a look on LazyRow component which has a DSL api which allows to first add a fixed element via item() function and then the list of items via items().".toString());
      AppMethodBeat.o(203537);
      throw localThrowable;
    }
    AppMethodBeat.o(203537);
  }
  
  public static final s d(h paramh)
  {
    AppMethodBeat.i(203525);
    paramh.bx(122203214);
    Object localObject = s.ZB;
    localObject = s.mm();
    kotlin.g.a.a locala = (kotlin.g.a.a)new c();
    localObject = (s)androidx.compose.runtime.e.b.a(new Object[0], (i)localObject, locala, paramh, 4);
    paramh.od();
    AppMethodBeat.o(203525);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/ScrollKt$HorizontalScrollableClipModifier$1", "Landroidx/compose/ui/graphics/Shape;", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ay
  {
    public final ak a(long paramLong, n paramn, androidx.compose.ui.n.d paramd)
    {
      AppMethodBeat.i(203523);
      kotlin.g.b.s.u(paramn, "layoutDirection");
      kotlin.g.b.s.u(paramd, "density");
      float f = paramd.v(r.mk());
      paramn = (ak)new ak.b(new androidx.compose.ui.d.g(0.0F, -f, androidx.compose.ui.d.k.Q(paramLong), f + androidx.compose.ui.d.k.R(paramLong)));
      AppMethodBeat.o(203523);
      return paramn;
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/ScrollKt$VerticalScrollableClipModifier$1", "Landroidx/compose/ui/graphics/Shape;", "createOutline", "Landroidx/compose/ui/graphics/Outline;", "size", "Landroidx/compose/ui/geometry/Size;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "density", "Landroidx/compose/ui/unit/Density;", "createOutline-Pq9zytI", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/unit/Density;)Landroidx/compose/ui/graphics/Outline;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ay
  {
    public final ak a(long paramLong, n paramn, androidx.compose.ui.n.d paramd)
    {
      AppMethodBeat.i(203513);
      kotlin.g.b.s.u(paramn, "layoutDirection");
      kotlin.g.b.s.u(paramd, "density");
      float f = paramd.v(r.mk());
      paramn = (ak)new ak.b(new androidx.compose.ui.d.g(-f, 0.0F, f + androidx.compose.ui.d.k.Q(paramLong), androidx.compose.ui.d.k.R(paramLong)));
      AppMethodBeat.o(203513);
      return paramn;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<s>
  {
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<ad, ah>
  {
    public d(s params)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements q<f, h, Integer, f>
  {
    e(s params)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.b<androidx.compose.ui.k.u, ah>
    {
      a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, s params, aq paramaq)
      {
        super();
      }
      
      @Metadata(k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends kotlin.g.b.u
        implements kotlin.g.a.a<Float>
      {
        a(s params)
        {
          super();
        }
      }
      
      @Metadata(k=3, mv={1, 5, 1}, xi=48)
      static final class b
        extends kotlin.g.b.u
        implements kotlin.g.a.a<Float>
      {
        b(s params)
        {
          super();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.r
 * JD-Core Version:    0.7.0.1
 */