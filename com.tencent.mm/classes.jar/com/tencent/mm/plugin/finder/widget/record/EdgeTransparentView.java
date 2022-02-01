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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.finder.b.l;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/widget/record/EdgeTransparentView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomMask", "drawSize", "", "leftMask", "mGradientColors", "", "mGradientPosition", "", "mHeight", "mPaint", "Landroid/graphics/Paint;", "mWidth", "position", "rightMask", "topMask", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawChild", "", "child", "Landroid/view/View;", "drawingTime", "", "init", "initShader", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "plugin-finder_release"})
public final class EdgeTransparentView
  extends FrameLayout
{
  private float Buq;
  private final int Bur;
  private final int Bus;
  private final int But;
  private final int Buu;
  private final int[] Buv;
  private final float[] Buw;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private int position;
  
  public EdgeTransparentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public EdgeTransparentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(236892);
    this.Bur = 1;
    this.Bus = (this.Bur << 1);
    this.But = (this.Bur << 2);
    this.Buu = (this.Bur << 3);
    this.mPaint = new Paint(1);
    Paint localPaint = this.mPaint;
    if (localPaint == null) {
      p.iCn();
    }
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = this.mPaint;
    if (localPaint == null) {
      p.iCn();
    }
    localPaint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.l.EdgeTransparentView);
    this.position = paramAttributeSet.getInt(b.l.EdgeTransparentView_edge_position, 0);
    this.Buq = paramAttributeSet.getDimension(b.l.EdgeTransparentView_edge_width, a.fromDPToPix(paramContext, 20.0F));
    paramAttributeSet.recycle();
    this.Buv = new int[] { -1, 0 };
    this.Buw = new float[] { 0.0F, 1.0F };
    AppMethodBeat.o(236892);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(236881);
    p.k(paramCanvas, "canvas");
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(236881);
  }
  
  protected final boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(236887);
    p.k(paramCanvas, "canvas");
    p.k(paramView, "child");
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    float f1;
    float f2;
    if ((this.position == 0) || ((this.position & this.Bur) != 0))
    {
      f1 = this.mWidth;
      f2 = this.Buq;
      paramView = this.mPaint;
      if (paramView == null) {
        p.iCn();
      }
      paramCanvas.drawRect(0.0F, 0.0F, f1, f2, paramView);
    }
    if ((this.position == 0) || ((this.position & this.Bus) != 0))
    {
      j = paramCanvas.save();
      paramCanvas.rotate(180.0F, this.mWidth / 2.0F, this.mHeight / 2.0F);
      f1 = this.mWidth;
      f2 = this.Buq;
      paramView = this.mPaint;
      if (paramView == null) {
        p.iCn();
      }
      paramCanvas.drawRect(0.0F, 0.0F, f1, f2, paramView);
      paramCanvas.restoreToCount(j);
    }
    int j = (this.mHeight - this.mWidth) / 2;
    int k;
    float f3;
    float f4;
    if ((this.position == 0) || ((this.position & this.But) != 0))
    {
      k = paramCanvas.save();
      paramCanvas.rotate(90.0F, this.mWidth / 2.0F, this.mHeight / 2.0F);
      paramCanvas.translate(0.0F, j);
      f1 = j;
      f2 = this.mWidth;
      f3 = j;
      f4 = this.Buq;
      paramView = this.mPaint;
      if (paramView == null) {
        p.iCn();
      }
      paramCanvas.drawRect(0.0F - f1, 0.0F, f3 + f2, f4, paramView);
      paramCanvas.restoreToCount(k);
    }
    if ((this.position == 0) || ((this.position & this.Buu) != 0))
    {
      k = paramCanvas.save();
      paramCanvas.rotate(270.0F, this.mWidth / 2.0F, this.mHeight / 2.0F);
      paramCanvas.translate(0.0F, j);
      f1 = j;
      f2 = this.mWidth;
      f3 = j;
      f4 = this.Buq;
      paramView = this.mPaint;
      if (paramView == null) {
        p.iCn();
      }
      paramCanvas.drawRect(0.0F - f1, 0.0F, f3 + f2, f4, paramView);
      paramCanvas.restoreToCount(k);
    }
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(236887);
    return bool;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(236889);
    p.k(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    AppMethodBeat.o(236889);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(236883);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Paint localPaint = this.mPaint;
    if (localPaint == null) {
      p.iCn();
    }
    localPaint.setShader((Shader)new LinearGradient(0.0F, 0.0F, 0.0F, this.Buq, this.Buv, this.Buw, Shader.TileMode.CLAMP));
    this.mWidth = getWidth();
    this.mHeight = getHeight();
    AppMethodBeat.o(236883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.record.EdgeTransparentView
 * JD-Core Version:    0.7.0.1
 */