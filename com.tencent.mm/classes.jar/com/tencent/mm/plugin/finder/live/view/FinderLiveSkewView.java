package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.p.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveSkewView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "skewBitmap", "Landroid/graphics/Bitmap;", "skewDrawable", "Landroid/graphics/drawable/Drawable;", "skewMatrix", "Landroid/graphics/Matrix;", "skewX", "", "skewY", "checkSkewBitmap", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveSkewView
  extends View
{
  private final Matrix DPA;
  private Drawable DPy;
  private Bitmap DPz;
  private float bbL;
  private float qTO;
  
  public FinderLiveSkewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(357766);
    AppMethodBeat.o(357766);
  }
  
  public FinderLiveSkewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(357759);
    this.DPA = new Matrix();
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, p.j.had);
      s.s(paramContext, "context.obtainStyledAttr…eable.FinderLiveSkewView)");
      this.bbL = paramContext.getFloat(p.j.CuC, 0.0F);
      this.qTO = paramContext.getFloat(p.j.CuD, 0.0F);
      this.DPy = paramContext.getDrawable(p.j.CuE);
      paramContext.recycle();
    }
    this.DPA.setSkew(this.bbL, this.qTO);
    AppMethodBeat.o(357759);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    int j = 1;
    AppMethodBeat.i(357772);
    if (paramCanvas != null) {
      paramCanvas.save();
    }
    int i;
    if (this.bbL == 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        if (this.qTO != 0.0F) {
          break label205;
        }
        i = j;
        label42:
        if (i != 0) {}
      }
      else if ((this.DPy != null) && (this.DPz == null))
      {
        localObject = this.DPy;
        if (localObject != null) {
          ((Drawable)localObject).setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
        if ((this.DPy instanceof GradientDrawable))
        {
          localObject = this.DPy;
          if (!(localObject instanceof GradientDrawable)) {
            break label210;
          }
        }
      }
    }
    label205:
    label210:
    for (Object localObject = (GradientDrawable)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((GradientDrawable)localObject).setSize(getMeasuredWidth(), getMeasuredHeight());
      }
      localObject = this.DPy;
      s.checkNotNull(localObject);
      this.DPz = d.drawable2Bitmap((Drawable)localObject);
      localObject = this.DPz;
      if ((localObject != null) && (paramCanvas != null)) {
        paramCanvas.drawBitmap((Bitmap)localObject, this.DPA, null);
      }
      super.onDraw(paramCanvas);
      if (paramCanvas != null) {
        paramCanvas.restore();
      }
      AppMethodBeat.o(357772);
      return;
      i = 0;
      break;
      i = 0;
      break label42;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveSkewView
 * JD-Core Version:    0.7.0.1
 */