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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.w.a.a.a.k;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/RCLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "cornerDp", "", "radiusArray", "", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "initAttribute", "defStyle", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class RCLinearLayout
  extends LinearLayout
{
  private float AVY;
  private float[] AVZ;
  
  public RCLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(166006);
    this.AVY = (a.fromDPToPix(getContext(), 4) * 1.0F);
    this.AVZ = new float[] { this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY };
    if (paramAttributeSet != null) {
      b(paramAttributeSet, 0);
    }
    AppMethodBeat.o(166006);
  }
  
  public RCLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(166007);
    this.AVY = (a.fromDPToPix(getContext(), 4) * 1.0F);
    this.AVZ = new float[] { this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY };
    if (paramAttributeSet != null) {
      b(paramAttributeSet, paramInt);
    }
    AppMethodBeat.o(166007);
  }
  
  private final void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(362657);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.k.RCLinearLayout, paramInt, 0);
      s.s(paramAttributeSet, "context.obtainStyledAttr…inearLayout, defStyle, 0)");
      if (paramAttributeSet.hasValue(a.k.RCLinearLayout_radius))
      {
        this.AVY = ((int)paramAttributeSet.getDimension(a.k.RCLinearLayout_radius, a.fromDPToPix(getContext(), 4) * 1.0F));
        this.AVZ = new float[] { this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY, this.AVY };
        Log.i("RCLinearLayout", s.X("initAttribute cornerDp:", Float.valueOf(this.AVY)));
      }
      paramAttributeSet.recycle();
    }
    AppMethodBeat.o(362657);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(166005);
    s.u(paramCanvas, "canvas");
    Path localPath = new Path();
    localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.AVZ, Path.Direction.CW);
    paramCanvas.clipPath(localPath);
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(166005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.RCLinearLayout
 * JD-Core Version:    0.7.0.1
 */