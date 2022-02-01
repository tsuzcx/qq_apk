package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.m;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/RoundLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "cornerRadius", "Lcom/tencent/mm/plugin/finder/feed/RoundLinearLayout$CornerRadius;", "getCornerRadius", "()Lcom/tencent/mm/plugin/finder/feed/RoundLinearLayout$CornerRadius;", "setCornerRadius", "(Lcom/tencent/mm/plugin/finder/feed/RoundLinearLayout$CornerRadius;)V", "path", "Landroid/graphics/Path;", "radiusPercent", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "init", "attributeSet", "defStyle", "setRadius", "percent", "CornerRadius", "plugin-finder_release"})
public class RoundLinearLayout
  extends LinearLayout
{
  private final Path aBZ;
  private a xER;
  private float xES;
  
  public RoundLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(274721);
    this.xES = 0.5F;
    this.aBZ = new Path();
    b(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(274721);
  }
  
  public RoundLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(274722);
    this.xES = 0.5F;
    this.aBZ = new Path();
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(274722);
  }
  
  private final void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(274717);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.RoundLinearLayout, paramInt, 0);
    float f = paramContext.getDimension(a.m.RoundLinearLayout_corner, 0.0F);
    this.xER = new a(f, f, f, f);
    setWillNotDraw(false);
    paramContext.recycle();
    AppMethodBeat.o(274717);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(274720);
    p.k(paramCanvas, "canvas");
    this.aBZ.reset();
    Object localObject2 = this.xER;
    int i;
    Object localObject1;
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    if (localObject2 != null)
    {
      if ((((a)localObject2).xET == 0.0F) && (((a)localObject2).xEU == 0.0F) && (((a)localObject2).xEV == 0.0F) && (((a)localObject2).xEW == 0.0F))
      {
        i = 1;
        if (i == 0) {
          break label165;
        }
      }
    }
    else
    {
      localObject1 = this.aBZ;
      f1 = getWidth();
      f2 = getHeight();
      f3 = getWidth();
      f4 = this.xES;
      f5 = getHeight();
      ((Path)localObject1).addRoundRect(0.0F, 0.0F, f1, f2, f4 * f3, this.xES * f5, Path.Direction.CW);
    }
    for (;;)
    {
      paramCanvas.clipPath(this.aBZ);
      super.dispatchDraw(paramCanvas);
      AppMethodBeat.o(274720);
      return;
      i = 0;
      break;
      label165:
      localObject1 = new RectF(0.0F, 0.0F, getWidth(), getHeight());
      Path localPath = this.aBZ;
      f1 = ((a)localObject2).xET;
      f2 = ((a)localObject2).xET;
      f3 = ((a)localObject2).xEU;
      f4 = ((a)localObject2).xEU;
      f5 = ((a)localObject2).xEW;
      float f6 = ((a)localObject2).xEW;
      float f7 = ((a)localObject2).xEV;
      float f8 = ((a)localObject2).xEV;
      localObject2 = Path.Direction.CCW;
      localPath.addRoundRect((RectF)localObject1, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, (Path.Direction)localObject2);
      this.aBZ.close();
    }
  }
  
  public final a getCornerRadius()
  {
    return this.xER;
  }
  
  public final void setCornerRadius(a parama)
  {
    this.xER = parama;
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(274718);
    if ((paramFloat >= 0.0F) && (paramFloat <= 0.5F))
    {
      this.xES = paramFloat;
      invalidate();
    }
    AppMethodBeat.o(274718);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/RoundLinearLayout$CornerRadius;", "", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(FFFF)V", "getBottomLeft", "()F", "setBottomLeft", "(F)V", "getBottomRight", "setBottomRight", "getTopLeft", "setTopLeft", "getTopRight", "setTopRight", "isEmpty", "", "plugin-finder_release"})
  public static final class a
  {
    float xET;
    float xEU;
    float xEV;
    float xEW;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.xET = paramFloat1;
      this.xEU = paramFloat2;
      this.xEV = paramFloat3;
      this.xEW = paramFloat4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.RoundLinearLayout
 * JD-Core Version:    0.7.0.1
 */