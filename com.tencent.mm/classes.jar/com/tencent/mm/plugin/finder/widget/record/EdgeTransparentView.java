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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.e.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/widget/record/EdgeTransparentView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomMask", "drawSize", "", "leftMask", "mGradientColors", "", "mGradientPosition", "", "mHeight", "mPaint", "Landroid/graphics/Paint;", "mWidth", "position", "rightMask", "topMask", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "drawChild", "", "child", "Landroid/view/View;", "drawingTime", "", "init", "initShader", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EdgeTransparentView
  extends FrameLayout
{
  private float Hbb;
  private final int Hbc;
  private final int Hbd;
  private final int Hbe;
  private final int Hbf;
  private final int[] Hbg;
  private final float[] Hbh;
  private int mHeight;
  private Paint mPaint;
  private int mWidth;
  private int position;
  
  public EdgeTransparentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(330660);
    AppMethodBeat.o(330660);
  }
  
  public EdgeTransparentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(330647);
    this.Hbc = 1;
    this.Hbd = (this.Hbc << 1);
    this.Hbe = (this.Hbc << 2);
    this.Hbf = (this.Hbc << 3);
    this.mPaint = new Paint(1);
    Paint localPaint = this.mPaint;
    s.checkNotNull(localPaint);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint = this.mPaint;
    s.checkNotNull(localPaint);
    localPaint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, e.j.EdgeTransparentView);
    s.s(paramAttributeSet, "context.obtainStyledAttr…able.EdgeTransparentView)");
    this.position = paramAttributeSet.getInt(e.j.EdgeTransparentView_edge_position, 0);
    this.Hbb = paramAttributeSet.getDimension(e.j.EdgeTransparentView_edge_width, a.fromDPToPix(paramContext, 20.0F));
    paramAttributeSet.recycle();
    this.Hbg = new int[] { -1, 0 };
    this.Hbh = new float[] { 0.0F, 1.0F };
    AppMethodBeat.o(330647);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(330666);
    s.u(paramCanvas, "canvas");
    super.dispatchDraw(paramCanvas);
    AppMethodBeat.o(330666);
  }
  
  protected final boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(330685);
    s.u(paramCanvas, "canvas");
    s.u(paramView, "child");
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getWidth(), getHeight(), null);
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    float f1;
    float f2;
    if ((this.position == 0) || ((this.position & this.Hbc) != 0))
    {
      f1 = this.mWidth;
      f2 = this.Hbb;
      paramView = this.mPaint;
      s.checkNotNull(paramView);
      paramCanvas.drawRect(0.0F, 0.0F, f1, f2, paramView);
    }
    if ((this.position == 0) || ((this.position & this.Hbd) != 0))
    {
      j = paramCanvas.save();
      paramCanvas.rotate(180.0F, this.mWidth / 2.0F, this.mHeight / 2.0F);
      f1 = this.mWidth;
      f2 = this.Hbb;
      paramView = this.mPaint;
      s.checkNotNull(paramView);
      paramCanvas.drawRect(0.0F, 0.0F, f1, f2, paramView);
      paramCanvas.restoreToCount(j);
    }
    int j = (this.mHeight - this.mWidth) / 2;
    int k;
    float f3;
    float f4;
    if ((this.position == 0) || ((this.position & this.Hbe) != 0))
    {
      k = paramCanvas.save();
      paramCanvas.rotate(90.0F, this.mWidth / 2.0F, this.mHeight / 2.0F);
      paramCanvas.translate(0.0F, j);
      f1 = j;
      f2 = this.mWidth;
      f3 = j;
      f4 = this.Hbb;
      paramView = this.mPaint;
      s.checkNotNull(paramView);
      paramCanvas.drawRect(0.0F - f1, 0.0F, f3 + f2, f4, paramView);
      paramCanvas.restoreToCount(k);
    }
    if ((this.position == 0) || ((this.position & this.Hbf) != 0))
    {
      k = paramCanvas.save();
      paramCanvas.rotate(270.0F, this.mWidth / 2.0F, this.mHeight / 2.0F);
      paramCanvas.translate(0.0F, j);
      f1 = j;
      f2 = this.mWidth;
      f3 = j;
      f4 = this.Hbb;
      paramView = this.mPaint;
      s.checkNotNull(paramView);
      paramCanvas.drawRect(0.0F - f1, 0.0F, f3 + f2, f4, paramView);
      paramCanvas.restoreToCount(k);
    }
    paramCanvas.restoreToCount(i);
    AppMethodBeat.o(330685);
    return bool;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(330689);
    s.u(paramCanvas, "canvas");
    super.onDraw(paramCanvas);
    AppMethodBeat.o(330689);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(330673);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Paint localPaint = this.mPaint;
    s.checkNotNull(localPaint);
    localPaint.setShader((Shader)new LinearGradient(0.0F, 0.0F, 0.0F, this.Hbb, this.Hbg, this.Hbh, Shader.TileMode.CLAMP));
    this.mWidth = getWidth();
    this.mHeight = getHeight();
    AppMethodBeat.o(330673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.record.EdgeTransparentView
 * JD-Core Version:    0.7.0.1
 */