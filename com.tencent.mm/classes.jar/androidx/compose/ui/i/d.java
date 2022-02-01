package androidx.compose.ui.i;

import androidx.compose.runtime.a.e;
import androidx.compose.ui.e.ae;
import androidx.compose.ui.e.am;
import androidx.compose.ui.e.an;
import androidx.compose.ui.e.u;
import androidx.compose.ui.e.z;
import androidx.compose.ui.h.a;
import androidx.compose.ui.h.p;
import androidx.compose.ui.h.q;
import androidx.compose.ui.h.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/InnerPlaceable;", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "Landroidx/compose/ui/unit/Density;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "getMeasureScope", "()Landroidx/compose/ui/layout/MeasureScope;", "parentData", "", "getParentData", "()Ljava/lang/Object;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "findLastFocusWrapper", "Landroidx/compose/ui/node/ModifiedFocusNode;", "findLastKeyInputWrapper", "Landroidx/compose/ui/node/ModifiedKeyInputNode;", "findNextFocusWrapper", "findNextKeyInputWrapper", "findNextNestedScrollWrapper", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDelegatingWrapper;", "findPreviousFocusWrapper", "findPreviousKeyInputWrapper", "findPreviousNestedScrollWrapper", "getWrappedByCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "hitTest", "", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitPointerInputFilters", "", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "hitTest-3MmeM6k", "(JLjava/util/List;)V", "hitTestSemantics", "hitSemanticsWrappers", "Landroidx/compose/ui/semantics/SemanticsWrapper;", "hitTestSemantics-3MmeM6k", "hitTestSubtree", "T", "hitResult", "nodeHitTest", "Lkotlin/Function3;", "Lkotlin/ExtensionFunctionType;", "hitTestSubtree-9KIMszo", "(JLjava/util/List;Lkotlin/jvm/functions/Function3;)V", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends j
  implements androidx.compose.ui.n.d
{
  public static final d.a aNX;
  private static final am aNZ;
  
  static
  {
    AppMethodBeat.i(204534);
    aNX = new d.a((byte)0);
    am localam = androidx.compose.ui.e.i.sN();
    Object localObject = z.awK;
    localam.W(z.tx());
    localam.setStrokeWidth(1.0F);
    localObject = an.axO;
    localam.cC(an.tH());
    aNZ = localam;
    AppMethodBeat.o(204534);
  }
  
  public d(f paramf)
  {
    super(paramf);
    AppMethodBeat.i(204529);
    this.aNY = paramf.aOt;
    AppMethodBeat.o(204529);
  }
  
  public final int a(a parama)
  {
    AppMethodBeat.i(204636);
    kotlin.g.b.s.u(parama, "alignmentLine");
    f localf = this.aOb;
    if (!localf.aOD.aQc)
    {
      if (localf.aOn != f.d.aOP) {
        break label95;
      }
      localf.aOu.aPe = true;
      if (localf.aOu.dirty) {
        localf.aOn = f.d.aOQ;
      }
    }
    for (;;)
    {
      localf.xB();
      parama = (Integer)localf.aOu.aMO.get(parama);
      if (parama != null) {
        break;
      }
      AppMethodBeat.o(204636);
      return -2147483648;
      label95:
      localf.aOu.aPf = true;
    }
    int i = parama.intValue();
    AppMethodBeat.o(204636);
    return i;
  }
  
  public final void a(long paramLong, float paramFloat, kotlin.g.a.b<? super ae, ah> paramb)
  {
    AppMethodBeat.i(204625);
    super.a(paramLong, paramFloat, paramb);
    paramb = this.aPj;
    if ((paramb != null) && (paramb.xW() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(204625);
      return;
    }
    f localf1 = this.aOb;
    f localf2 = localf1.xu();
    paramFloat = localf1.aOC.zIndex;
    paramb = localf1.aOD.aPZ;
    j localj = localf1.aOC;
    while (!kotlin.g.b.s.p(paramb, localj))
    {
      paramFloat += paramb.zIndex;
      paramb = paramb.xg();
      kotlin.g.b.s.checkNotNull(paramb);
    }
    if (paramFloat == localf1.zIndex)
    {
      i = 1;
      if (i == 0)
      {
        localf1.zIndex = paramFloat;
        if (localf2 != null) {
          localf2.xv();
        }
        if (localf2 != null) {
          localf2.xA();
        }
      }
      if (!localf1.aOw)
      {
        if (localf2 != null) {
          localf2.xA();
        }
        localf1.xC();
      }
      if (localf2 == null) {
        break label302;
      }
      if (localf2.aOn != f.d.aOR) {
        break label290;
      }
      if (localf1.aOx != 2147483647) {
        break label262;
      }
    }
    label262:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        break label268;
      }
      paramb = (Throwable)new IllegalStateException("Place was called on a node which was placed already".toString());
      AppMethodBeat.o(204625);
      throw paramb;
      i = 0;
      break;
    }
    label268:
    localf1.aOx = localf2.aOz;
    localf2.aOz += 1;
    for (;;)
    {
      label290:
      localf1.xB();
      AppMethodBeat.o(204625);
      return;
      label302:
      localf1.aOx = 0;
    }
  }
  
  public final x aw(long paramLong)
  {
    AppMethodBeat.i(204569);
    ((j)this).ay(paramLong);
    Object localObject = this.aOb.ahe.a(this.aOb.aOt, this.aOb.xr().qp(), paramLong);
    f localf = this.aOb;
    kotlin.g.b.s.u(localObject, "measureResult");
    localf.aOC.a((q)localObject);
    localObject = (x)this;
    AppMethodBeat.o(204569);
    return localObject;
  }
  
  public final void b(long paramLong, List<androidx.compose.ui.g.c.s> paramList)
  {
    AppMethodBeat.i(204649);
    kotlin.g.b.s.u(paramList, "hitPointerInputFilters");
    int k;
    Object localObject;
    int i;
    int j;
    if (aD(paramLong))
    {
      k = paramList.size();
      localObject = this.aOb.xx();
      i = ((e)localObject).size;
      if (i > 0)
      {
        localObject = ((e)localObject).aqq;
        j = i - 1;
      }
    }
    for (;;)
    {
      f localf = (f)localObject[j];
      if (localf.aOw)
      {
        localf.d(paramLong, paramList);
        if (paramList.size() > k) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0)
        {
          j -= 1;
          if (j >= 0) {
            break;
          }
        }
        AppMethodBeat.o(204649);
        return;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  public final float bs(int paramInt)
  {
    AppMethodBeat.i(204555);
    float f = this.aNY.bs(paramInt);
    AppMethodBeat.o(204555);
    return f;
  }
  
  public final void c(long paramLong, List<androidx.compose.ui.k.w> paramList)
  {
    AppMethodBeat.i(204657);
    kotlin.g.b.s.u(paramList, "hitSemanticsWrappers");
    int k;
    Object localObject;
    int i;
    int j;
    if (aD(paramLong))
    {
      k = paramList.size();
      localObject = this.aOb.xx();
      i = ((e)localObject).size;
      if (i > 0)
      {
        localObject = ((e)localObject).aqq;
        j = i - 1;
      }
    }
    for (;;)
    {
      f localf = (f)localObject[j];
      if (localf.aOw)
      {
        localf.e(paramLong, paramList);
        if (paramList.size() > k) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0)
        {
          j -= 1;
          if (j >= 0) {
            break;
          }
        }
        AppMethodBeat.o(204657);
        return;
        i = 0;
        continue;
        i = 0;
      }
    }
  }
  
  protected final void c(u paramu)
  {
    AppMethodBeat.i(204643);
    kotlin.g.b.s.u(paramu, "canvas");
    y localy = i.q(this.aOb);
    Object localObject = this.aOb.xx();
    int j = ((e)localObject).size;
    int i;
    if (j > 0)
    {
      localObject = ((e)localObject).aqq;
      i = 0;
    }
    for (;;)
    {
      f localf = (f)localObject[i];
      if (localf.aOw) {
        localf.d(paramu);
      }
      i += 1;
      if (i >= j)
      {
        if (localy.getShowLayoutBounds()) {
          a(paramu, aNZ);
        }
        AppMethodBeat.o(204643);
        return;
      }
    }
  }
  
  public final float mn()
  {
    AppMethodBeat.i(204558);
    float f = this.aNY.mn();
    AppMethodBeat.o(204558);
    return f;
  }
  
  public final float mo()
  {
    AppMethodBeat.i(204560);
    float f = this.aNY.mo();
    AppMethodBeat.o(204560);
    return f;
  }
  
  public final float t(long paramLong)
  {
    AppMethodBeat.i(204550);
    float f = this.aNY.t(paramLong);
    AppMethodBeat.o(204550);
    return f;
  }
  
  public final int v(float paramFloat)
  {
    AppMethodBeat.i(204537);
    int i = this.aNY.v(paramFloat);
    AppMethodBeat.o(204537);
    return i;
  }
  
  public final androidx.compose.ui.g.b.b vY()
  {
    AppMethodBeat.i(204609);
    Object localObject = this.aPj;
    if (localObject == null)
    {
      AppMethodBeat.o(204609);
      return null;
    }
    localObject = ((j)localObject).vY();
    AppMethodBeat.o(204609);
    return localObject;
  }
  
  public final androidx.compose.ui.g.b.b vZ()
  {
    return null;
  }
  
  public final float w(float paramFloat)
  {
    AppMethodBeat.i(204542);
    paramFloat = this.aNY.w(paramFloat);
    AppMethodBeat.o(204542);
    return paramFloat;
  }
  
  public final Object wI()
  {
    return null;
  }
  
  public final long x(float paramFloat)
  {
    AppMethodBeat.i(204544);
    long l = this.aNY.x(paramFloat);
    AppMethodBeat.o(204544);
    return l;
  }
  
  public final androidx.compose.ui.h.r xh()
  {
    return this.aOb.aOt;
  }
  
  public final o xj()
  {
    AppMethodBeat.i(204583);
    Object localObject = this.aPj;
    if (localObject == null)
    {
      AppMethodBeat.o(204583);
      return null;
    }
    localObject = ((j)localObject).xj();
    AppMethodBeat.o(204583);
    return localObject;
  }
  
  public final o xk()
  {
    return null;
  }
  
  public final o xl()
  {
    AppMethodBeat.i(204594);
    o localo = xj();
    AppMethodBeat.o(204594);
    return localo;
  }
  
  public final r xm()
  {
    AppMethodBeat.i(204601);
    Object localObject = this.aPj;
    if (localObject == null)
    {
      AppMethodBeat.o(204601);
      return null;
    }
    localObject = ((j)localObject).xm();
    AppMethodBeat.o(204601);
    return localObject;
  }
  
  public final r xn()
  {
    AppMethodBeat.i(204618);
    r localr = xm();
    AppMethodBeat.o(204618);
    return localr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.d
 * JD-Core Version:    0.7.0.1
 */