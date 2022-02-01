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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/RoundLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "cornerRadius", "Lcom/tencent/mm/plugin/finder/feed/RoundLinearLayout$CornerRadius;", "getCornerRadius", "()Lcom/tencent/mm/plugin/finder/feed/RoundLinearLayout$CornerRadius;", "setCornerRadius", "(Lcom/tencent/mm/plugin/finder/feed/RoundLinearLayout$CornerRadius;)V", "path", "Landroid/graphics/Path;", "radiusPercent", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "init", "attributeSet", "defStyle", "setRadius", "percent", "CornerRadius", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class RoundLinearLayout
  extends LinearLayout
{
  private a BbM;
  private float BbN;
  private final Path path;
  
  public RoundLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(363791);
    this.BbN = 0.5F;
    this.path = new Path();
    b(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(363791);
  }
  
  public RoundLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(363799);
    this.BbN = 0.5F;
    this.path = new Path();
    b(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(363799);
  }
  
  private final void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(363806);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.RoundLinearLayout, paramInt, 0);
    s.s(paramContext, "context.obtainStyledAttr…inearLayout, defStyle, 0)");
    float f = paramContext.getDimension(a.m.RoundLinearLayout_corner, 0.0F);
    this.BbM = new a(f, f, f, f);
    setWillNotDraw(false);
    paramContext.recycle();
    AppMethodBeat.o(363806);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(363840);
    s.u(paramCanvas, "canvas");
    this.path.reset();
    Object localObject2 = this.BbM;
    int i;
    label60:
    label78:
    label96:
    label104:
    Object localObject1;
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    if (localObject2 != null)
    {
      if (((a)localObject2).BbO == 0.0F)
      {
        i = 1;
        if (i == 0) {
          break label215;
        }
        if (((a)localObject2).BbP != 0.0F) {
          break label197;
        }
        i = 1;
        if (i == 0) {
          break label215;
        }
        if (((a)localObject2).BbQ != 0.0F) {
          break label203;
        }
        i = 1;
        if (i == 0) {
          break label215;
        }
        if (((a)localObject2).BbR != 0.0F) {
          break label209;
        }
        i = 1;
        if (i == 0) {
          break label215;
        }
        i = 1;
        if (i == 0) {
          break label221;
        }
      }
    }
    else
    {
      localObject1 = this.path;
      f1 = getWidth();
      f2 = getHeight();
      f3 = getWidth();
      f4 = this.BbN;
      f5 = getHeight();
      ((Path)localObject1).addRoundRect(0.0F, 0.0F, f1, f2, f4 * f3, this.BbN * f5, Path.Direction.CW);
    }
    for (;;)
    {
      paramCanvas.clipPath(this.path);
      super.dispatchDraw(paramCanvas);
      AppMethodBeat.o(363840);
      return;
      i = 0;
      break;
      label197:
      i = 0;
      break label60;
      label203:
      i = 0;
      break label78;
      label209:
      i = 0;
      break label96;
      label215:
      i = 0;
      break label104;
      label221:
      localObject1 = new RectF(0.0F, 0.0F, getWidth(), getHeight());
      Path localPath = this.path;
      f1 = ((a)localObject2).BbO;
      f2 = ((a)localObject2).BbO;
      f3 = ((a)localObject2).BbP;
      f4 = ((a)localObject2).BbP;
      f5 = ((a)localObject2).BbR;
      float f6 = ((a)localObject2).BbR;
      float f7 = ((a)localObject2).BbQ;
      float f8 = ((a)localObject2).BbQ;
      localObject2 = Path.Direction.CCW;
      localPath.addRoundRect((RectF)localObject1, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, (Path.Direction)localObject2);
      this.path.close();
    }
  }
  
  public final a getCornerRadius()
  {
    return this.BbM;
  }
  
  public final void setCornerRadius(a parama)
  {
    this.BbM = parama;
  }
  
  public final void setRadius(float paramFloat)
  {
    AppMethodBeat.i(363825);
    if ((paramFloat >= 0.0F) && (paramFloat <= 0.5F))
    {
      this.BbN = paramFloat;
      invalidate();
    }
    AppMethodBeat.o(363825);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/RoundLinearLayout$CornerRadius;", "", "topLeft", "", "topRight", "bottomLeft", "bottomRight", "(FFFF)V", "getBottomLeft", "()F", "setBottomLeft", "(F)V", "getBottomRight", "setBottomRight", "getTopLeft", "setTopLeft", "getTopRight", "setTopRight", "isEmpty", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    float BbO;
    float BbP;
    float BbQ;
    float BbR;
    
    public a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.BbO = paramFloat1;
      this.BbP = paramFloat2;
      this.BbQ = paramFloat3;
      this.BbR = paramFloat4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.RoundLinearLayout
 * JD-Core Version:    0.7.0.1
 */