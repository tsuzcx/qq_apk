package com.tencent.mm.plugin.exdevice.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.n;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/exdevice/ui/ColorfulCircleProgress;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animate", "", "animateDuration", "", "getAnimateDuration", "()I", "setAnimateDuration", "(I)V", "animator", "Landroid/animation/ValueAnimator;", "arcWidth", "", "bgCirclePaint", "Landroid/graphics/Paint;", "blackMaskPaint", "circleRect", "Landroid/graphics/RectF;", "circleSpace", "innerCircleColorList", "", "innerCircleEndColor", "innerCircleStartColor", "innerCircleUnFinishedColor", "innerCircleUnFinishedColorList", "innerDestDegree", "getInnerDestDegree", "setInnerDestDegree", "mPaint", "midCircleColorList", "midCircleEndColor", "midCircleStartColor", "midCircleUnFinishedColor", "midCircleUnFinishedColorList", "midDestDegree", "getMidDestDegree", "setMidDestDegree", "outCircleColorList", "outCircleEndColor", "outCircleStartColor", "outCircleUnFinishedColor", "outCircleUnFinishedColorList", "outDestDegree", "getOutDestDegree", "setOutDestDegree", "rotateMatrix", "Landroid/graphics/Matrix;", "shadowColorArray", "shadowPaint", "startEndCirclePaint", "viewSize", "drawColorArc", "", "canvas", "Landroid/graphics/Canvas;", "color", "offset", "destDegree", "startAngle", "colorList", "drawStartEndCircle", "rect", "radius", "degree", "showShadow", "increaseWithAnim", "outDegree", "midDegree", "innerDegree", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setDegree", "type", "current", "", "goal", "startAnimateProgress", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ColorfulCircleProgress
  extends View
{
  public static final ColorfulCircleProgress.a ywD;
  private final ValueAnimator animator;
  private final Paint mPaint;
  private int ywE;
  private int ywF;
  private int ywG;
  private int ywH;
  private final boolean ywI;
  private final int ywJ;
  private final int ywK;
  private final int ywL;
  private final int[] ywM;
  private final int[] ywN;
  private final int ywO;
  private final int ywP;
  private final int ywQ;
  private final int[] ywR;
  private final int[] ywS;
  private final int ywT;
  private final int ywU;
  private final int ywV;
  private final int[] ywW;
  private final int[] ywX;
  private int[] ywY;
  private final RectF ywZ;
  private float yxa;
  private float yxb;
  private final Matrix yxc;
  private float yxd;
  private final Paint yxe;
  private final Paint yxf;
  private final Paint yxg;
  private final Paint yxh;
  
  static
  {
    AppMethodBeat.i(274834);
    ywD = new ColorfulCircleProgress.a((byte)0);
    AppMethodBeat.o(274834);
  }
  
  public ColorfulCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(274814);
    this.ywE = 500;
    this.ywZ = new RectF();
    this.yxc = new Matrix();
    this.yxe = new Paint();
    this.yxf = new Paint();
    this.yxg = new Paint();
    this.yxh = new Paint();
    setLayerType(1, null);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.n.gZP);
    s.s(paramContext, "context.obtainStyledAttr…e.ColorfulProgressCircle)");
    this.ywI = paramContext.getBoolean(R.n.gZQ, false);
    this.ywJ = paramContext.getColor(R.n.gZY, getResources().getColor(R.e.fkP));
    this.ywK = paramContext.getColor(R.n.gZX, getResources().getColor(R.e.fkQ));
    this.ywL = paramContext.getColor(R.n.gZZ, getResources().getColor(R.e.fkR));
    this.ywM = new int[] { this.ywJ, this.ywK };
    this.ywN = new int[] { this.ywL };
    this.ywO = paramContext.getColor(R.n.gZV, getResources().getColor(R.e.fkL));
    this.ywP = paramContext.getColor(R.n.gZU, getResources().getColor(R.e.fkK));
    this.ywQ = paramContext.getColor(R.n.gZW, getResources().getColor(R.e.fkM));
    this.ywR = new int[] { this.ywO, this.ywP };
    this.ywS = new int[] { this.ywQ };
    this.ywT = paramContext.getColor(R.n.gZS, getResources().getColor(R.e.fkC));
    this.ywU = paramContext.getColor(R.n.gZR, getResources().getColor(R.e.fkB));
    this.ywV = paramContext.getColor(R.n.gZT, getResources().getColor(R.e.fkD));
    this.ywW = new int[] { this.ywT, this.ywU };
    this.ywX = new int[] { this.ywV };
    paramContext.recycle();
    this.mPaint = new Paint();
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setAntiAlias(true);
    this.yxe.setStyle(Paint.Style.FILL);
    this.yxe.setAntiAlias(true);
    this.yxg.setColor(getResources().getColor(R.e.fki));
    this.yxg.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.OVERLAY));
    this.yxg.setAntiAlias(true);
    this.yxh.setStyle(Paint.Style.STROKE);
    this.yxh.setAntiAlias(true);
    this.yxh.setColor(getResources().getColor(R.e.BW_0_Alpha_0_9));
    this.ywY = new int[] { getResources().getColor(R.e.black), getResources().getColor(R.e.black), getResources().getColor(R.e.black) };
    paramContext = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    s.s(paramContext, "ofFloat(0f, 1f)");
    this.animator = paramContext;
    AppMethodBeat.o(274814);
  }
  
  private final void a(Canvas paramCanvas, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(274825);
    this.ywZ.set(paramFloat1, paramFloat1, this.yxa - paramFloat1, this.yxa - paramFloat1);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setColor(paramInt);
    localPaint.setStrokeWidth(this.yxd);
    if (paramCanvas != null) {
      paramCanvas.drawArc(this.ywZ, paramFloat3, paramFloat2, false, localPaint);
    }
    AppMethodBeat.o(274825);
  }
  
  private final void a(Canvas paramCanvas, RectF paramRectF, float paramFloat1, float paramFloat2, int paramInt)
  {
    AppMethodBeat.i(274831);
    double d1 = 0.0174532925199433D * (paramFloat2 - 90.0F);
    this.yxe.setColor(paramInt);
    if (paramCanvas != null)
    {
      paramFloat2 = (float)(paramRectF.left + paramRectF.width() / 2.0F + paramFloat1 * Math.cos(d1));
      double d2 = paramRectF.top + paramRectF.height() / 2.0F;
      double d3 = paramFloat1;
      paramCanvas.drawCircle(paramFloat2, (float)(Math.sin(d1) * d3 + d2), this.yxd / 2.0F, this.yxe);
    }
    AppMethodBeat.o(274831);
  }
  
  private final void a(Canvas paramCanvas, int[] paramArrayOfInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(274818);
    float f = this.yxa / 2.0F;
    Object localObject = new float[2];
    localObject[0] = 0.0F;
    localObject[1] = (paramFloat2 / 360.0F);
    if (paramFloat2 > 360.0F) {
      localObject[1] = 1.0F;
    }
    localObject = new SweepGradient(f, f, paramArrayOfInt, (float[])localObject);
    if (paramFloat2 > 360.0F)
    {
      this.yxc.setRotate(paramFloat2 - 360.0F - 90.0F, f, f);
      ((SweepGradient)localObject).setLocalMatrix(this.yxc);
      this.mPaint.setShader((Shader)localObject);
      this.ywZ.set(paramFloat1, paramFloat1, this.yxa - paramFloat1, this.yxa - paramFloat1);
      if (paramFloat2 > 360.0F) {
        break label215;
      }
      if (paramCanvas != null) {
        paramCanvas.drawArc(this.ywZ, -90.0F, paramFloat2, false, this.mPaint);
      }
      a(paramCanvas, this.ywZ, f - paramFloat1, 0.0F, paramArrayOfInt[0]);
    }
    for (;;)
    {
      if (paramArrayOfInt.length != 1) {
        break label248;
      }
      AppMethodBeat.o(274818);
      return;
      this.yxc.setRotate(-90.0F, f, f);
      break;
      label215:
      if (paramCanvas != null) {
        paramCanvas.drawArc(this.ywZ, -90.0F + (paramFloat2 - 360.0F), 360.0F, false, this.mPaint);
      }
    }
    label248:
    a(paramCanvas, this.ywZ, f - paramFloat1, paramFloat2, paramArrayOfInt[1]);
    AppMethodBeat.o(274818);
  }
  
  public final void a(int paramInt, double paramDouble1, double paramDouble2)
  {
    int i = (int)(360.0D * (paramDouble1 / paramDouble2));
    switch (paramInt)
    {
    default: 
      this.ywH = i;
      return;
    case 0: 
      this.ywF = i;
      return;
    case 1: 
      this.ywG = i;
      return;
    }
    this.ywH = i;
  }
  
  public final int getAnimateDuration()
  {
    return this.ywE;
  }
  
  public final int getInnerDestDegree()
  {
    return this.ywH;
  }
  
  public final int getMidDestDegree()
  {
    return this.ywG;
  }
  
  public final int getOutDestDegree()
  {
    return this.ywF;
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(274860);
    super.onDraw(paramCanvas);
    if (paramCanvas != null) {
      paramCanvas.drawCircle(this.yxa / 2.0F, this.yxa / 2.0F, this.yxa / 2.0F, this.yxg);
    }
    if (this.ywF < 360) {
      a(paramCanvas, this.ywL, this.yxd / 2.0F, 360.0F, 0.0F);
    }
    a(this, paramCanvas, this.ywM, this.yxd / 2.0F, this.ywF);
    float f = this.yxd + this.yxd / 2.0F + this.yxb;
    if (this.ywG < 360) {
      a(paramCanvas, this.ywQ, f, this.ywG + 360.0F, -90.0F + this.ywG + this.yxd);
    }
    a(this, paramCanvas, this.ywR, f, this.ywG);
    f = this.yxd * 2.0F + this.yxd / 2.0F + this.yxb + this.yxb;
    if (this.ywH < 360) {
      a(paramCanvas, this.ywV, f, this.ywH + 360.0F, -90.0F + this.ywH + this.yxd);
    }
    a(this, paramCanvas, this.ywW, f, this.ywH);
    AppMethodBeat.o(274860);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(274856);
    super.onMeasure(paramInt1, paramInt2);
    this.yxa = k.bu(getMeasuredWidth(), getMeasuredHeight());
    this.yxd = ((float)(this.yxa * 0.12D));
    this.yxb = (this.yxa * 0.03F);
    this.mPaint.setStrokeWidth(this.yxd);
    this.yxh.setStrokeWidth(this.yxd);
    AppMethodBeat.o(274856);
  }
  
  public final void setAnimateDuration(int paramInt)
  {
    this.ywE = paramInt;
  }
  
  public final void setInnerDestDegree(int paramInt)
  {
    this.ywH = paramInt;
  }
  
  public final void setMidDestDegree(int paramInt)
  {
    this.ywG = paramInt;
  }
  
  public final void setOutDestDegree(int paramInt)
  {
    this.ywF = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ColorfulCircleProgress
 * JD-Core Version:    0.7.0.1
 */