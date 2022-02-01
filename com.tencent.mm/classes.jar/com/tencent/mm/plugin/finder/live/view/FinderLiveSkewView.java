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
import com.tencent.mm.plugin.finder.b.l;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveSkewView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "skewBitmap", "Landroid/graphics/Bitmap;", "skewDrawable", "Landroid/graphics/drawable/Drawable;", "skewMatrix", "Landroid/graphics/Matrix;", "skewX", "", "skewY", "checkSkewBitmap", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "plugin-finder_release"})
public final class FinderLiveSkewView
  extends View
{
  private float nUd;
  private float nUe;
  private Drawable yVE;
  private Bitmap yVF;
  private final Matrix yVG;
  
  public FinderLiveSkewView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(270663);
    AppMethodBeat.o(270663);
  }
  
  public FinderLiveSkewView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(270662);
    this.yVG = new Matrix();
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, b.l.FinderLiveSkewView);
      p.j(paramContext, "context.obtainStyledAttr…eable.FinderLiveSkewView)");
      this.nUd = paramContext.getFloat(b.l.FinderLiveSkewView_skewX, 0.0F);
      this.nUe = paramContext.getFloat(b.l.FinderLiveSkewView_skewY, 0.0F);
      this.yVE = paramContext.getDrawable(b.l.FinderLiveSkewView_srcDrawable);
      paramContext.recycle();
    }
    this.yVG.setSkew(this.nUd, this.nUe);
    AppMethodBeat.o(270662);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(270661);
    if (paramCanvas != null) {
      paramCanvas.save();
    }
    if (((this.nUd != 0.0F) || (this.nUe != 0.0F)) && (this.yVE != null) && (this.yVF == null))
    {
      localObject = this.yVE;
      if (localObject != null) {
        ((Drawable)localObject).setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
      if ((this.yVE instanceof GradientDrawable))
      {
        Drawable localDrawable = this.yVE;
        localObject = localDrawable;
        if (!(localDrawable instanceof GradientDrawable)) {
          localObject = null;
        }
        localObject = (GradientDrawable)localObject;
        if (localObject != null) {
          ((GradientDrawable)localObject).setSize(getMeasuredWidth(), getMeasuredHeight());
        }
      }
      localObject = this.yVE;
      if (localObject == null) {
        p.iCn();
      }
      this.yVF = d.drawable2Bitmap((Drawable)localObject);
    }
    Object localObject = this.yVF;
    if ((localObject != null) && (paramCanvas != null)) {
      paramCanvas.drawBitmap((Bitmap)localObject, this.yVG, null);
    }
    super.onDraw(paramCanvas);
    if (paramCanvas != null)
    {
      paramCanvas.restore();
      AppMethodBeat.o(270661);
      return;
    }
    AppMethodBeat.o(270661);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveSkewView
 * JD-Core Version:    0.7.0.1
 */