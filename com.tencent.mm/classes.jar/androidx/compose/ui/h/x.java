package androidx.compose.ui.h;

import androidx.compose.ui.e.ae;
import androidx.compose.ui.n.j;
import androidx.compose.ui.n.l;
import androidx.compose.ui.n.m;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measured;", "()V", "apparentToRealOffset", "Landroidx/compose/ui/unit/IntOffset;", "getApparentToRealOffset-nOcc-ac", "()J", "<set-?>", "", "height", "getHeight", "()I", "measuredHeight", "getMeasuredHeight", "value", "Landroidx/compose/ui/unit/IntSize;", "measuredSize", "getMeasuredSize-YbymL2g", "setMeasuredSize-ozmzZPI", "(J)V", "J", "measuredWidth", "getMeasuredWidth", "Landroidx/compose/ui/unit/Constraints;", "measurementConstraints", "getMeasurementConstraints-msEJaDk", "setMeasurementConstraints-BRTryo0", "width", "getWidth", "placeAt", "", "position", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "recalculateWidthAndHeight", "PlacementScope", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class x
{
  public static final int Ue = 8;
  public long aMV = m.an(0, 0);
  private long aMW = y.wX();
  public int height;
  public int width;
  
  private final void wO()
  {
    this.width = kotlin.k.k.bQ(l.bi(this.aMV), androidx.compose.ui.n.b.aT(this.aMW), androidx.compose.ui.n.b.aU(this.aMW));
    this.height = kotlin.k.k.bQ(l.bj(this.aMV), androidx.compose.ui.n.b.aV(this.aMW), androidx.compose.ui.n.b.aW(this.aMW));
  }
  
  protected abstract void a(long paramLong, float paramFloat, kotlin.g.a.b<? super ae, ah> paramb);
  
  protected final void ax(long paramLong)
  {
    if (!l.e(this.aMV, paramLong))
    {
      this.aMV = paramLong;
      wO();
    }
  }
  
  public final void ay(long paramLong)
  {
    if (!androidx.compose.ui.n.b.e(this.aMW, paramLong))
    {
      this.aMW = paramLong;
      wO();
    }
  }
  
  public int getMeasuredHeight()
  {
    return l.bj(this.aMV);
  }
  
  public int wN()
  {
    return l.bi(this.aMV);
  }
  
  protected final long wP()
  {
    return this.aMW;
  }
  
  public final long wQ()
  {
    return androidx.compose.ui.n.k.am((this.width - l.bi(this.aMV)) / 2, (this.height - l.bj(this.aMV)) / 2);
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "()V", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "parentWidth", "", "getParentWidth", "()I", "place", "", "Landroidx/compose/ui/layout/Placeable;", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "place-70tqf50", "(Landroidx/compose/ui/layout/Placeable;JF)V", "x", "y", "placeApparentToRealOffset", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeApparentToRealOffset-aW-9-wM$ui_release", "(Landroidx/compose/ui/layout/Placeable;JFLkotlin/jvm/functions/Function1;)V", "placeAutoMirrored", "placeAutoMirrored-aW-9-wM$ui_release", "placeRelative", "placeRelative-70tqf50", "placeRelativeWithLayer", "placeRelativeWithLayer-aW-9-wM", "placeWithLayer", "placeWithLayer-aW-9-wM", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a
  {
    public static final a aMX = new a((byte)0);
    private static n aMY = n.beP;
    private static int aMZ;
    
    public static void a(x paramx, long paramLong, float paramFloat)
    {
      s.u(paramx, "$receiver");
      long l = x.c(paramx);
      int i = j.bf(paramLong);
      int j = j.bf(l);
      int k = j.bg(paramLong);
      x.a(paramx, androidx.compose.ui.n.k.am(i + j, j.bg(l) + k), paramFloat, null);
    }
    
    public static void b(x paramx, long paramLong, float paramFloat, kotlin.g.a.b<? super ae, ah> paramb)
    {
      s.u(paramx, "$receiver");
      s.u(paramb, "layerBlock");
      long l = x.c(paramx);
      int i = j.bf(paramLong);
      int j = j.bf(l);
      int k = j.bg(paramLong);
      x.a(paramx, androidx.compose.ui.n.k.am(i + j, j.bg(l) + k), paramFloat, paramb);
    }
    
    protected abstract int wR();
    
    protected abstract n wS();
    
    @Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/Placeable$PlacementScope$Companion;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "()V", "<set-?>", "Landroidx/compose/ui/unit/LayoutDirection;", "parentLayoutDirection", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "", "parentWidth", "getParentWidth", "()I", "executeWithRtlMirroringValues", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends x.a
    {
      protected final int wR()
      {
        AppMethodBeat.i(205696);
        int i = x.a.wU();
        AppMethodBeat.o(205696);
        return i;
      }
      
      protected final n wS()
      {
        AppMethodBeat.i(205687);
        n localn = x.a.wT();
        AppMethodBeat.o(205687);
        return localn;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.h.x
 * JD-Core Version:    0.7.0.1
 */