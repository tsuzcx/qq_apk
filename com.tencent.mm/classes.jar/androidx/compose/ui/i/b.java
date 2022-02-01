package androidx.compose.ui.i;

import androidx.compose.ui.e.ae;
import androidx.compose.ui.e.u;
import androidx.compose.ui.f.c;
import androidx.compose.ui.h.a;
import androidx.compose.ui.h.q;
import androidx.compose.ui.h.x;
import androidx.compose.ui.h.x.a;
import androidx.compose.ui.h.x.a.a;
import androidx.compose.ui.k.w;
import androidx.compose.ui.n.k;
import androidx.compose.ui.n.l;
import androidx.compose.ui.n.n;
import androidx.compose.ui.platform.af;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "T", "Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "wrapped", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/Modifier$Element;)V", "isChained", "", "()Z", "setChained", "(Z)V", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "getMeasureScope", "()Landroidx/compose/ui/layout/MeasureScope;", "getModifier", "()Landroidx/compose/ui/Modifier$Element;", "setModifier", "(Landroidx/compose/ui/Modifier$Element;)V", "Landroidx/compose/ui/Modifier$Element;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "toBeReusedForSameModifier", "getToBeReusedForSameModifier", "setToBeReusedForSameModifier", "<set-?>", "getWrapped$ui_release", "()Landroidx/compose/ui/node/LayoutNodeWrapper;", "setWrapped", "(Landroidx/compose/ui/node/LayoutNodeWrapper;)V", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "findLastFocusWrapper", "Landroidx/compose/ui/node/ModifiedFocusNode;", "findLastKeyInputWrapper", "Landroidx/compose/ui/node/ModifiedKeyInputNode;", "findNextFocusWrapper", "findNextKeyInputWrapper", "findNextNestedScrollWrapper", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDelegatingWrapper;", "findPreviousFocusWrapper", "findPreviousKeyInputWrapper", "findPreviousNestedScrollWrapper", "hitTest", "", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitPointerInputFilters", "", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "hitTest-3MmeM6k", "(JLjava/util/List;)V", "hitTestSemantics", "hitSemanticsWrappers", "Landroidx/compose/ui/semantics/SemanticsWrapper;", "hitTestSemantics-3MmeM6k", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "setModifierTo", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b<T extends f.c>
  extends j
{
  protected j aNN;
  private T aNO;
  boolean aNP;
  boolean aNQ;
  
  public b(j paramj, T paramT)
  {
    super(paramj.aOb);
    AppMethodBeat.i(204493);
    this.aNN = paramj;
    this.aNO = paramT;
    this.aNN.aPj = ((j)this);
    AppMethodBeat.o(204493);
  }
  
  public int a(a parama)
  {
    AppMethodBeat.i(204559);
    kotlin.g.b.s.u(parama, "alignmentLine");
    int i = this.aNN.b(parama);
    AppMethodBeat.o(204559);
    return i;
  }
  
  public final void a(long paramLong, float paramFloat, kotlin.g.a.b<? super ae, ah> paramb)
  {
    int i = 1;
    AppMethodBeat.i(204564);
    super.a(paramLong, paramFloat, paramb);
    paramb = this.aPj;
    if ((paramb != null) && (paramb.xW() == true)) {}
    while (i != 0)
    {
      AppMethodBeat.o(204564);
      return;
      i = 0;
    }
    paramb = x.a.aMX;
    i = l.bi(this.aMV);
    paramb = this.aNN.xh().getLayoutDirection();
    Object localObject = x.a.aMX;
    int j = x.a.a.wV();
    localObject = x.a.aMX;
    localObject = x.a.a.wW();
    x.a.a locala = x.a.aMX;
    x.a.cP(i);
    locala = x.a.aMX;
    x.a.d(paramb);
    xT().wM();
    paramb = x.a.aMX;
    x.a.cP(j);
    paramb = x.a.aMX;
    x.a.d((n)localObject);
    AppMethodBeat.o(204564);
  }
  
  public void a(T paramT)
  {
    AppMethodBeat.i(204523);
    kotlin.g.b.s.u(paramT, "<set-?>");
    this.aNO = paramT;
    AppMethodBeat.o(204523);
  }
  
  public x aw(long paramLong)
  {
    AppMethodBeat.i(204575);
    ((j)this).ay(paramLong);
    a((q)new a(this, this.aNN.aw(paramLong)));
    x localx = (x)this;
    AppMethodBeat.o(204575);
    return localx;
  }
  
  public void b(long paramLong, List<androidx.compose.ui.g.c.s> paramList)
  {
    AppMethodBeat.i(204548);
    kotlin.g.b.s.u(paramList, "hitPointerInputFilters");
    if (aD(paramLong))
    {
      paramLong = this.aNN.aC(paramLong);
      this.aNN.b(paramLong, paramList);
    }
    AppMethodBeat.o(204548);
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(204532);
    kotlin.g.b.s.u(paramc, "modifier");
    if (paramc != wb())
    {
      if (!kotlin.g.b.s.p(af.am(paramc), af.am(wb())))
      {
        paramc = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
        AppMethodBeat.o(204532);
        throw paramc;
      }
      a(paramc);
    }
    AppMethodBeat.o(204532);
  }
  
  public void c(long paramLong, List<w> paramList)
  {
    AppMethodBeat.i(204556);
    kotlin.g.b.s.u(paramList, "hitSemanticsWrappers");
    if (aD(paramLong))
    {
      paramLong = this.aNN.aC(paramLong);
      this.aNN.c(paramLong, paramList);
    }
    AppMethodBeat.o(204556);
  }
  
  protected void c(u paramu)
  {
    AppMethodBeat.i(204540);
    kotlin.g.b.s.u(paramu, "canvas");
    this.aNN.e(paramu);
    AppMethodBeat.o(204540);
  }
  
  public androidx.compose.ui.g.b.b vY()
  {
    AppMethodBeat.i(204612);
    Object localObject = this.aPj;
    if (localObject == null)
    {
      AppMethodBeat.o(204612);
      return null;
    }
    localObject = ((j)localObject).vY();
    AppMethodBeat.o(204612);
    return localObject;
  }
  
  public androidx.compose.ui.g.b.b vZ()
  {
    AppMethodBeat.i(204617);
    androidx.compose.ui.g.b.b localb = this.aNN.vZ();
    AppMethodBeat.o(204617);
    return localb;
  }
  
  public Object wI()
  {
    AppMethodBeat.i(204642);
    Object localObject = this.aNN.wI();
    AppMethodBeat.o(204642);
    return localObject;
  }
  
  public T wb()
  {
    return this.aNO;
  }
  
  public final j xg()
  {
    return this.aNN;
  }
  
  public final androidx.compose.ui.h.r xh()
  {
    AppMethodBeat.i(204527);
    androidx.compose.ui.h.r localr = this.aNN.xh();
    AppMethodBeat.o(204527);
    return localr;
  }
  
  public o xj()
  {
    AppMethodBeat.i(204584);
    Object localObject = this.aPj;
    if (localObject == null)
    {
      AppMethodBeat.o(204584);
      return null;
    }
    localObject = ((j)localObject).xj();
    AppMethodBeat.o(204584);
    return localObject;
  }
  
  public o xk()
  {
    AppMethodBeat.i(204591);
    o localo = this.aNN.xk();
    AppMethodBeat.o(204591);
    return localo;
  }
  
  public final o xl()
  {
    AppMethodBeat.i(204602);
    Object localObject1 = xk();
    Object localObject2 = null;
    while (localObject1 != null)
    {
      o localo = ((b)localObject1).aNN.xk();
      localObject2 = localObject1;
      localObject1 = localo;
    }
    AppMethodBeat.o(204602);
    return localObject2;
  }
  
  public r xm()
  {
    AppMethodBeat.i(204624);
    Object localObject = this.aPj;
    if (localObject == null)
    {
      AppMethodBeat.o(204624);
      return null;
    }
    localObject = ((j)localObject).xm();
    AppMethodBeat.o(204624);
    return localObject;
  }
  
  public final r xn()
  {
    AppMethodBeat.i(204633);
    r localr = this.aOb.aOC.xm();
    if (localr != this)
    {
      AppMethodBeat.o(204633);
      return localr;
    }
    AppMethodBeat.o(204633);
    return null;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/node/DelegatingLayoutNodeWrapper$measure$1$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "width", "getWidth", "placeChildren", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements q
  {
    private final Map<a, Integer> aMO;
    private final int height;
    private final int width;
    
    a(b<T> paramb, x paramx)
    {
      AppMethodBeat.i(204654);
      this.width = this.aNR.aNN.xT().getWidth();
      this.height = this.aNR.aNN.xT().getHeight();
      this.aMO = ak.kkZ();
      AppMethodBeat.o(204654);
    }
    
    public final int getHeight()
    {
      return this.height;
    }
    
    public final int getWidth()
    {
      return this.width;
    }
    
    public final Map<a, Integer> wL()
    {
      return this.aMO;
    }
    
    public final void wM()
    {
      AppMethodBeat.i(204674);
      Object localObject = x.a.aMX;
      localObject = this.Tw;
      long l = b.a(this.aNR);
      x.a.a((x)localObject, k.am(-androidx.compose.ui.n.j.bf(l), -androidx.compose.ui.n.j.bg(l)));
      AppMethodBeat.o(204674);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.b
 * JD-Core Version:    0.7.0.1
 */