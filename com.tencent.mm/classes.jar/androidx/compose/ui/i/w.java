package androidx.compose.ui.i;

import androidx.compose.runtime.a.e;
import androidx.compose.ui.e.ae;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.x;
import androidx.compose.ui.h.x.a;
import androidx.compose.ui.h.x.a.a;
import androidx.compose.ui.n.l;
import androidx.compose.ui.n.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/OuterMeasurablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "outerWrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutNodeWrapper;)V", "duringAlignmentLinesQuery", "", "getDuringAlignmentLinesQuery$ui_release", "()Z", "setDuringAlignmentLinesQuery$ui_release", "(Z)V", "lastConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLastConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "lastLayerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "lastPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "lastZIndex", "", "<set-?>", "", "measureIteration", "getMeasureIteration", "()J", "measuredHeight", "", "getMeasuredHeight", "()I", "measuredOnce", "measuredWidth", "getMeasuredWidth", "getOuterWrapper", "()Landroidx/compose/ui/node/LayoutNodeWrapper;", "setOuterWrapper", "(Landroidx/compose/ui/node/LayoutNodeWrapper;)V", "", "parentData", "getParentData", "()Ljava/lang/Object;", "placedOnce", "get", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "maxIntrinsicHeight", "width", "maxIntrinsicWidth", "height", "measure", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "onIntrinsicsQueried", "placeAt", "position", "zIndex", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "recalculateParentData", "remeasure", "remeasure-BRTryo0", "(J)Z", "replace", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends x
  implements o
{
  private final f aOb;
  long aPH;
  public j aPZ;
  private boolean aQa;
  boolean aQb;
  boolean aQc;
  long aQd;
  kotlin.g.a.b<? super ae, ah> aQe;
  float aQf;
  Object aQg;
  
  public w(f paramf, j paramj)
  {
    AppMethodBeat.i(204570);
    this.aOb = paramf;
    this.aPZ = paramj;
    paramf = androidx.compose.ui.n.j.beN;
    this.aQd = androidx.compose.ui.n.j.su();
    this.aPH = -1L;
    AppMethodBeat.o(204570);
  }
  
  public final void a(long paramLong, float paramFloat, kotlin.g.a.b<? super ae, ah> paramb)
  {
    AppMethodBeat.i(204621);
    this.aQb = true;
    this.aQd = paramLong;
    this.aQf = paramFloat;
    this.aQe = paramb;
    this.aOb.aOu.aPf = false;
    x.a.a locala = x.a.aMX;
    if (paramb == null)
    {
      x.a.a.a((x)this.aPZ, paramLong, this.aQf);
      AppMethodBeat.o(204621);
      return;
    }
    x.a.a.b((x)this.aPZ, paramLong, this.aQf, paramb);
    AppMethodBeat.o(204621);
  }
  
  public final boolean aF(final long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(204607);
    Object localObject1 = i.q(this.aOb);
    long l = ((y)localObject1).getMeasureIteration();
    Object localObject2 = this.aOb.xu();
    Object localObject3 = this.aOb;
    boolean bool1;
    if ((this.aOb.aOB) || ((localObject2 != null) && (((f)localObject2).aOB)))
    {
      bool1 = true;
      ((f)localObject3).aOB = bool1;
      if ((this.aPH == l) && (!this.aOb.aOB)) {
        break label131;
      }
    }
    label131:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label136;
      }
      localObject1 = (Throwable)new IllegalStateException("measure() may not be called multiple times on the same Measurable".toString());
      AppMethodBeat.o(204607);
      throw ((Throwable)localObject1);
      bool1 = false;
      break;
    }
    label136:
    this.aPH = ((y)localObject1).getMeasureIteration();
    int j;
    if ((this.aOb.aOn == f.d.aOO) || (!androidx.compose.ui.n.b.e(wP(), paramLong)))
    {
      this.aOb.aOu.aPe = false;
      localObject2 = this.aOb.xr();
      j = ((e)localObject2).size;
      if (j > 0)
      {
        localObject2 = ((e)localObject2).aqq;
        i = 0;
      }
    }
    for (;;)
    {
      ((f)localObject2[i]).aOu.aPb = false;
      i += 1;
      if (i >= j)
      {
        this.aQa = true;
        this.aOb.a(f.d.aOP);
        ay(paramLong);
        l = this.aPZ.aMV;
        localObject1 = ((y)localObject1).getSnapshotObserver();
        localObject2 = this.aOb;
        localObject3 = (a)new b(this, paramLong);
        s.u(localObject2, "node");
        s.u(localObject3, "block");
        ((aa)localObject1).a((z)localObject2, ((aa)localObject1).aQn, (a)localObject3);
        if (this.aOb.aOn == f.d.aOP) {
          this.aOb.a(f.d.aOQ);
        }
        if ((l.e(this.aPZ.aMV, l)) && (this.aPZ.width == this.width))
        {
          bool1 = bool2;
          if (this.aPZ.height == this.height) {}
        }
        else
        {
          bool1 = true;
        }
        ax(m.an(this.aPZ.width, this.aPZ.height));
        AppMethodBeat.o(204607);
        return bool1;
        AppMethodBeat.o(204607);
        return false;
      }
    }
  }
  
  public final x aw(long paramLong)
  {
    AppMethodBeat.i(204593);
    Object localObject1 = this.aOb.xu();
    if (localObject1 == null) {}
    f localf;
    for (localObject1 = null;; localObject1 = ((f)localObject1).aOn)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = f.d.aOR;
      }
      localf = this.aOb;
      switch (a.$EnumSwitchMapping$0[localObject2.ordinal()])
      {
      default: 
        localObject1 = new IllegalStateException(s.X("Measurable could be only measured from the parent's measure or layout block.Parents state is ", localObject2));
        AppMethodBeat.o(204593);
        throw ((Throwable)localObject1);
      }
    }
    for (localObject1 = f.f.aOU;; localObject1 = f.f.aOV)
    {
      s.u(localObject1, "<set-?>");
      localf.aOA = ((f.f)localObject1);
      aF(paramLong);
      localObject1 = (x)this;
      AppMethodBeat.o(204593);
      return localObject1;
    }
  }
  
  public final int getMeasuredHeight()
  {
    AppMethodBeat.i(204616);
    int i = this.aPZ.getMeasuredHeight();
    AppMethodBeat.o(204616);
    return i;
  }
  
  public final Object wI()
  {
    return this.aQg;
  }
  
  public final int wN()
  {
    AppMethodBeat.i(369514);
    int i = this.aPZ.wN();
    AppMethodBeat.o(369514);
    return i;
  }
  
  public final androidx.compose.ui.n.b yj()
  {
    AppMethodBeat.i(204579);
    if (this.aQa)
    {
      androidx.compose.ui.n.b localb = androidx.compose.ui.n.b.bb(wP());
      AppMethodBeat.o(204579);
      return localb;
    }
    AppMethodBeat.o(204579);
    return null;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(w paramw, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.w
 * JD-Core Version:    0.7.0.1
 */