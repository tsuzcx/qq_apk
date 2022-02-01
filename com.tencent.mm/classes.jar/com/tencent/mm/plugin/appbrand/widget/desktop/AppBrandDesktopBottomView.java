package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopBottomView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawColor", "leftArcRectF", "Landroid/graphics/RectF;", "mContext", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "radii", "", "radius", "", "rightArcRectF", "computeRadius", "", "dp", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setDrawColor", "color", "setTopRoundRadius", "topRadius", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandDesktopBottomView
  extends View
{
  public static final a lSX;
  private int lST;
  private float[] lSU;
  private RectF lSV;
  private RectF lSW;
  private Context mContext;
  private Paint mPaint;
  private float radius;
  private Path uW;
  
  static
  {
    AppMethodBeat.i(51414);
    lSX = new a((byte)0);
    AppMethodBeat.o(51414);
  }
  
  public AppBrandDesktopBottomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51412);
    this.mPaint = new Paint();
    this.uW = new Path();
    this.lSU = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    this.lSV = new RectF();
    this.lSW = new RectF();
    init(paramContext);
    AppMethodBeat.o(51412);
  }
  
  public AppBrandDesktopBottomView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(51413);
    this.mPaint = new Paint();
    this.uW = new Path();
    this.lSU = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    this.lSV = new RectF();
    this.lSW = new RectF();
    init(paramContext);
    AppMethodBeat.o(51413);
  }
  
  private final void init(Context paramContext)
  {
    AppMethodBeat.i(51407);
    this.mContext = paramContext;
    this.lST = getResources().getColor(2131099930);
    uC(8);
    AppMethodBeat.o(51407);
  }
  
  private final void uC(int paramInt)
  {
    AppMethodBeat.i(51408);
    this.radius = a.fromDPToPix(getContext(), paramInt);
    this.lSU[0] = this.radius;
    this.lSU[1] = this.radius;
    this.lSU[2] = this.radius;
    this.lSU[3] = this.radius;
    ad.i("Mp.AppBrandDesktopBottomView", "alvinluo computeRadius radius: %f", new Object[] { Float.valueOf(this.radius) });
    AppMethodBeat.o(51408);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(51411);
    super.onDraw(paramCanvas);
    this.mPaint.setColor(this.lST);
    this.mPaint.setStyle(Paint.Style.FILL);
    if (d.lh(20))
    {
      this.uW.addRoundRect(getLeft(), getTop(), getRight(), getBottom(), this.lSU, Path.Direction.CCW);
      if (paramCanvas != null) {
        paramCanvas.drawPath(this.uW, this.mPaint);
      }
      this.uW.reset();
      AppMethodBeat.o(51411);
      return;
    }
    this.lSV.set(getLeft(), getTop(), getLeft() + this.radius * 2.0F, getTop() + this.radius * 2.0F);
    this.lSW.set(getRight() - this.radius * 2.0F, getTop(), getRight(), getTop() + this.radius * 2.0F);
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.lSV, 180.0F, 90.0F, true, this.mPaint);
    }
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.lSW, 270.0F, 90.0F, true, this.mPaint);
    }
    float f1;
    if (paramCanvas != null)
    {
      f1 = getLeft();
      paramCanvas.drawRect(this.radius + f1, getTop(), getRight() - this.radius, this.radius, this.mPaint);
    }
    if (paramCanvas != null)
    {
      f1 = getLeft();
      float f2 = getTop();
      paramCanvas.drawRect(f1, this.radius + f2, getRight(), getBottom(), this.mPaint);
      AppMethodBeat.o(51411);
      return;
    }
    AppMethodBeat.o(51411);
  }
  
  public final void setDrawColor(int paramInt)
  {
    AppMethodBeat.i(51410);
    this.lST = paramInt;
    invalidate();
    AppMethodBeat.o(51410);
  }
  
  public final void setTopRoundRadius(int paramInt)
  {
    AppMethodBeat.i(51409);
    uC(paramInt);
    AppMethodBeat.o(51409);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopBottomView$Companion;", "", "()V", "DEFAULT_RADIUS_IN_DP", "", "TAG", "", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopBottomView
 * JD-Core Version:    0.7.0.1
 */