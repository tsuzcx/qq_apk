package com.tencent.mm.plugin.appbrand.keylogger.stepview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class VerticalStepViewIndicator
  extends View
{
  private float cHR;
  private int kFA;
  private int kFB;
  private PathEffect kFC;
  private a kFD;
  private boolean kFE;
  private List<c> kFi;
  private int kFj;
  private final String kFm;
  private int kFn;
  private float kFo;
  private float kFp;
  private Drawable kFq;
  private Drawable kFr;
  private Drawable kFs;
  private Drawable kFt;
  private float kFu;
  private float kFv;
  private float kFw;
  private List<Float> kFx;
  private Paint kFy;
  private Paint kFz;
  private int mHeight;
  private Rect mRect;
  private Path uW;
  
  public VerticalStepViewIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepViewIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(194900);
    this.kFm = getClass().getSimpleName();
    this.kFn = ((int)TypedValue.applyDimension(1, 40.0F, getResources().getDisplayMetrics()));
    this.kFi = new ArrayList();
    this.kFA = b.n(getContext(), 2131101193);
    this.kFB = -1;
    this.uW = new Path();
    this.kFC = new DashPathEffect(new float[] { 8.0F, 8.0F, 8.0F, 8.0F }, 1.0F);
    this.kFx = new ArrayList();
    this.kFy = new Paint();
    this.kFz = new Paint();
    this.kFy.setAntiAlias(true);
    this.kFy.setColor(this.kFA);
    this.kFy.setStyle(Paint.Style.STROKE);
    this.kFy.setStrokeWidth(2.0F);
    this.kFz.setAntiAlias(true);
    this.kFz.setColor(this.kFB);
    this.kFz.setStyle(Paint.Style.STROKE);
    this.kFz.setStrokeWidth(2.0F);
    this.kFy.setPathEffect(this.kFC);
    this.kFz.setStyle(Paint.Style.FILL);
    this.kFo = (0.05F * this.kFn);
    this.kFp = (0.28F * this.kFn);
    this.kFw = (0.85F * this.kFn);
    this.kFq = b.l(getContext(), 2131234846);
    this.kFr = b.l(getContext(), 2131234843);
    this.kFs = b.l(getContext(), 2131234847);
    this.kFt = b.l(getContext(), 2131234845);
    this.kFE = true;
    AppMethodBeat.o(194900);
  }
  
  public List<Float> getCircleCenterPointPositionList()
  {
    return this.kFx;
  }
  
  public float getCircleRadius()
  {
    return this.kFp;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    AppMethodBeat.i(194903);
    super.onDraw(paramCanvas);
    if (this.kFD != null) {
      this.kFD.bgc();
    }
    this.kFy.setColor(this.kFA);
    this.kFz.setColor(this.kFB);
    int j = 0;
    int i = k;
    float f1;
    if (j < this.kFx.size() - 1)
    {
      f1 = ((Float)this.kFx.get(j)).floatValue();
      float f2 = ((Float)this.kFx.get(j + 1)).floatValue();
      if (j < this.kFj) {
        if (this.kFE) {
          paramCanvas.drawRect(this.kFu, f2 + this.kFp - 10.0F, this.kFv, f1 - this.kFp + 10.0F, this.kFz);
        }
      }
      for (;;)
      {
        j += 1;
        break;
        paramCanvas.drawRect(this.kFu, this.kFp + f1 - 10.0F, this.kFv, f2 - this.kFp + 10.0F, this.kFz);
        continue;
        if (this.kFE)
        {
          this.uW.moveTo(this.cHR, f2 + this.kFp);
          this.uW.lineTo(this.cHR, f1 - this.kFp);
          paramCanvas.drawPath(this.uW, this.kFy);
        }
        else
        {
          this.uW.moveTo(this.cHR, this.kFp + f1);
          this.uW.lineTo(this.cHR, f2 - this.kFp);
          paramCanvas.drawPath(this.uW, this.kFy);
        }
      }
    }
    if (i < this.kFx.size())
    {
      f1 = ((Float)this.kFx.get(i)).floatValue();
      this.mRect = new Rect((int)(this.cHR - this.kFp), (int)(f1 - this.kFp), (int)(this.cHR + this.kFp), (int)(f1 + this.kFp));
      j = ((c)this.kFi.get(i)).mState;
      if (j == 0)
      {
        this.kFq.setBounds(this.mRect);
        this.kFq.draw(paramCanvas);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 2)
        {
          this.kFr.setBounds(this.mRect);
          this.kFr.draw(paramCanvas);
        }
        else if (j == -2)
        {
          this.kFs.setBounds(this.mRect);
          this.kFs.draw(paramCanvas);
        }
        else
        {
          this.kFt.setBounds(this.mRect);
          this.kFt.draw(paramCanvas);
        }
      }
    }
    AppMethodBeat.o(194903);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194901);
    super.onMeasure(paramInt1, paramInt2);
    int i = this.kFn;
    this.mHeight = 0;
    paramInt2 = this.kFi.size();
    if (paramInt2 > 0)
    {
      float f1 = getPaddingTop() + getPaddingBottom();
      float f2 = this.kFp;
      float f3 = paramInt2;
      this.mHeight = ((int)((paramInt2 - 1) * this.kFw + (f1 + f2 * 2.0F * f3)));
    }
    paramInt2 = i;
    if (View.MeasureSpec.getMode(paramInt1) != 0) {
      paramInt2 = Math.min(i, View.MeasureSpec.getSize(paramInt1));
    }
    setMeasuredDimension(paramInt2, this.mHeight);
    AppMethodBeat.o(194901);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(194902);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.cHR = (getWidth() / 2);
    this.kFu = (this.cHR - this.kFo / 2.0F);
    this.kFv = (this.cHR + this.kFo / 2.0F);
    paramInt1 = 0;
    if (paramInt1 < this.kFi.size())
    {
      if (this.kFE) {
        this.kFx.add(Float.valueOf(this.mHeight - (this.kFp + paramInt1 * this.kFp * 2.0F + paramInt1 * this.kFw)));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.kFx.add(Float.valueOf(this.kFp + paramInt1 * this.kFp * 2.0F + paramInt1 * this.kFw));
      }
    }
    if (this.kFD != null) {
      this.kFD.bgc();
    }
    AppMethodBeat.o(194902);
  }
  
  public void setAttentionIcon(Drawable paramDrawable)
  {
    this.kFr = paramDrawable;
  }
  
  public void setComplectingPosition(int paramInt)
  {
    AppMethodBeat.i(194905);
    this.kFj = paramInt;
    requestLayout();
    AppMethodBeat.o(194905);
  }
  
  public void setCompleteIcon(Drawable paramDrawable)
  {
    this.kFq = paramDrawable;
  }
  
  public void setCompletedLineColor(int paramInt)
  {
    this.kFB = paramInt;
  }
  
  public void setDefaultIcon(Drawable paramDrawable)
  {
    this.kFs = paramDrawable;
  }
  
  public void setIndicatorLinePaddingProportion(float paramFloat)
  {
    this.kFw = (this.kFn * paramFloat);
  }
  
  public void setOnDrawListener(a parama)
  {
    this.kFD = parama;
  }
  
  public void setSteps(List<c> paramList)
  {
    AppMethodBeat.i(194904);
    if (paramList == null)
    {
      this.kFi = new ArrayList();
      AppMethodBeat.o(194904);
      return;
    }
    this.kFi = paramList;
    requestLayout();
    AppMethodBeat.o(194904);
  }
  
  public void setUnCompletedLineColor(int paramInt)
  {
    this.kFA = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void bgc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepViewIndicator
 * JD-Core Version:    0.7.0.1
 */