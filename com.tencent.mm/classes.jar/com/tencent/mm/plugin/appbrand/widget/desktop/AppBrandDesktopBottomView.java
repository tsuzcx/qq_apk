package com.tencent.mm.plugin.appbrand.widget.desktop;

import a.l;
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
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopBottomView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawColor", "leftArcRectF", "Landroid/graphics/RectF;", "mContext", "mPaint", "Landroid/graphics/Paint;", "mPath", "Landroid/graphics/Path;", "radii", "", "radius", "", "rightArcRectF", "computeRadius", "", "dp", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setDrawColor", "color", "setTopRoundRadius", "topRadius", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandDesktopBottomView
  extends View
{
  public static final AppBrandDesktopBottomView.a jdd;
  private int jcZ;
  private float[] jda;
  private RectF jdb;
  private RectF jdc;
  private Context mContext;
  private Paint mPaint;
  private Path ou;
  private float radius;
  
  static
  {
    AppMethodBeat.i(144005);
    jdd = new AppBrandDesktopBottomView.a((byte)0);
    AppMethodBeat.o(144005);
  }
  
  public AppBrandDesktopBottomView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(144003);
    this.mPaint = new Paint();
    this.ou = new Path();
    this.jda = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    this.jdb = new RectF();
    this.jdc = new RectF();
    init(paramContext);
    AppMethodBeat.o(144003);
  }
  
  public AppBrandDesktopBottomView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(144004);
    this.mPaint = new Paint();
    this.ou = new Path();
    this.jda = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
    this.jdb = new RectF();
    this.jdc = new RectF();
    init(paramContext);
    AppMethodBeat.o(144004);
  }
  
  private final void init(Context paramContext)
  {
    AppMethodBeat.i(143998);
    this.mContext = paramContext;
    this.jcZ = getResources().getColor(2131689692);
    pY(8);
    AppMethodBeat.o(143998);
  }
  
  private final void pY(int paramInt)
  {
    AppMethodBeat.i(143999);
    this.radius = a.fromDPToPix(getContext(), paramInt);
    this.jda[0] = this.radius;
    this.jda[1] = this.radius;
    this.jda[2] = this.radius;
    this.jda[3] = this.radius;
    ab.i("Mp.AppBrandDesktopBottomView", "alvinluo computeRadius radius: %f", new Object[] { Float.valueOf(this.radius) });
    AppMethodBeat.o(143999);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(144002);
    super.onDraw(paramCanvas);
    this.mPaint.setColor(this.jcZ);
    this.mPaint.setStyle(Paint.Style.FILL);
    if (d.iU(20))
    {
      this.ou.addRoundRect(getLeft(), getTop(), getRight(), getBottom(), this.jda, Path.Direction.CCW);
      if (paramCanvas != null) {
        paramCanvas.drawPath(this.ou, this.mPaint);
      }
      this.ou.reset();
      AppMethodBeat.o(144002);
      return;
    }
    this.jdb.set(getLeft(), getTop(), getLeft() + this.radius * 2.0F, getTop() + this.radius * 2.0F);
    this.jdc.set(getRight() - this.radius * 2.0F, getTop(), getRight(), getTop() + this.radius * 2.0F);
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.jdb, 180.0F, 90.0F, true, this.mPaint);
    }
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.jdc, 270.0F, 90.0F, true, this.mPaint);
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
      AppMethodBeat.o(144002);
      return;
    }
    AppMethodBeat.o(144002);
  }
  
  public final void setDrawColor(int paramInt)
  {
    AppMethodBeat.i(144001);
    this.jcZ = paramInt;
    invalidate();
    AppMethodBeat.o(144001);
  }
  
  public final void setTopRoundRadius(int paramInt)
  {
    AppMethodBeat.i(144000);
    pY(paramInt);
    AppMethodBeat.o(144000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopBottomView
 * JD-Core Version:    0.7.0.1
 */