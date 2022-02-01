package com.tencent.mm.plugin.finder.widget.record;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.finder.b.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/widget/record/EdgeTransparentView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomMask", "drawSize", "", "leftMask", "mGradientColors", "", "mGradientPosition", "", "mHeight", "mPaint", "Landroid/graphics/Paint;", "mWidth", "position", "rightMask", "topMask", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawChild", "", "child", "Landroid/view/View;", "drawingTime", "", "init", "initShader", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "plugin-finder_release"})
public final class EdgeTransparentView
  extends FrameLayout
{
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private int position;
  private float wDI;
  private final int wDJ;
  private final int wDK;
  private final int wDL;
  private final int wDM;
  private final int[] wDN;
  private final float[] wDO;
  
  public EdgeTransparentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public EdgeTransparentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(256163);
    this.wDJ = 1;
    this.wDK = (this.wDJ << 1);
    this.wDL = (this.wDJ << 2);
    this.wDM = (this.wDJ << 3);
    this.mPaint = new Paint(1);
    Paint localPaint = this.mPaint;
    if (localPaint == null) {
      p.hyc();
    }
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = this.mPaint;
    if (localPaint == null) {
      p.hyc();
    }
    localPaint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.a.EdgeTransparentView);
    this.position = paramAttributeSet.getInt(0, 0);
    this.wDI = paramAttributeSet.getDimension(1, a.fromDPToPix(paramContext, 20.0F));
    paramAttributeSet.recycle();
    this.wDN = new int[] { -1, 0 };
    this.wDO = new float[] { 0.0F, 1.0F };
    AppMethodBeat.o(256163);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(256159);
    p.h(paramCanvas, "canvas");
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(256159);
  }
  
  protected final boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(256161);
    p.h(paramCanvas, "canvas");
    p.h(paramView, "child");
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    float f1;
    float f2;
    if ((this.position == 0) || ((this.position & this.wDJ) != 0))
    {
      f1 = this.mWidth;
      f2 = this.wDI;
      paramView = this.mPaint;
      if (paramView == null) {
        p.hyc();
      }
      paramCanvas.drawRect(0.0F, 0.0F, f1, f2, paramView);
    }
    if ((this.position == 0) || ((this.position & this.wDK) != 0))
    {
      j = paramCanvas.save();
      paramCanvas.rotate(180.0F, this.mWidth / 2.0F, this.mHeight / 2.0F);
      f1 = this.mWidth;
      f2 = this.wDI;
      paramView = this.mPaint;
      if (paramView == null) {
        p.hyc();
      }
      paramCanvas.drawRect(0.0F, 0.0F, f1, f2, paramView);
      paramCanvas.restoreToCount(j);
    }
    int j = (this.mHeight - this.mWidth) / 2;
    int k;
    float f3;
    float f4;
    if ((this.position == 0) || ((this.position & this.wDL) != 0))
    {
      k = paramCanvas.save();
      paramCanvas.rotate(90.0F, this.mWidth / 2.0F, this.mHeight / 2.0F);
      paramCanvas.translate(0.0F, j);
      f1 = j;
      f2 = this.mWidth;
      f3 = j;
      f4 = this.wDI;
      paramView = this.mPaint;
      if (paramView == null) {
        p.hyc();
      }
      paramCanvas.drawRect(0.0F - f1, 0.0F, f3 + f2, f4, paramView);
      paramCanvas.restoreToCount(k);
    }
    if ((this.position == 0) || ((this.position & this.wDM) != 0))
    {
      k = paramCanvas.save();
      paramCanvas.rotate(270.0F, this.mWidth / 2.0F, this.mHeight / 2.0F);
      paramCanvas.translate(0.0F, j);
      f1 = j;
      f2 = this.mWidth;
      f3 = j;
      f4 = this.wDI;
      paramView = this.mPaint;
      if (paramView == null) {
        p.hyc();
      }
      paramCanvas.drawRect(0.0F - f1, 0.0F, f3 + f2, f4, paramView);
      paramCanvas.restoreToCount(k);
    }
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(256161);
    return bool;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(256162);
    p.h(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    AppMethodBeat.o(256162);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(256160);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Paint localPaint = this.mPaint;
    if (localPaint == null) {
      p.hyc();
    }
    localPaint.setShader((Shader)new LinearGradient(0.0F, 0.0F, 0.0F, this.wDI, this.wDN, this.wDO, Shader.TileMode.CLAMP));
    this.mWidth = getWidth();
    this.mHeight = getHeight();
    AppMethodBeat.o(256160);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.record.EdgeTransparentView
 * JD-Core Version:    0.7.0.1
 */