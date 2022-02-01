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
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import androidx.core.content.a;
import com.tencent.luggage.a.b;
import com.tencent.luggage.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class VerticalStepViewIndicator
  extends View
{
  private Path auD;
  private float eYP;
  private int mHeight;
  private Rect mRect;
  private List<c> pQF;
  private int pQG;
  private final String pQJ;
  private int pQK;
  private float pQL;
  private float pQM;
  private Drawable pQN;
  private Drawable pQO;
  private Drawable pQP;
  private Drawable pQQ;
  private float pQR;
  private float pQS;
  private float pQT;
  private List<Float> pQU;
  private Paint pQV;
  private Paint pQW;
  private int pQX;
  private int pQY;
  private PathEffect pQZ;
  private a pRa;
  private boolean pRb;
  
  public VerticalStepViewIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepViewIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208702);
    this.pQJ = getClass().getSimpleName();
    this.pQK = ((int)TypedValue.applyDimension(1, 40.0F, getResources().getDisplayMetrics()));
    this.pQF = new ArrayList();
    this.pQX = a.w(getContext(), a.b.uncompleted_color);
    this.pQY = -1;
    this.auD = new Path();
    this.pQZ = new DashPathEffect(new float[] { 8.0F, 8.0F, 8.0F, 8.0F }, 1.0F);
    this.pQU = new ArrayList();
    this.pQV = new Paint();
    this.pQW = new Paint();
    this.pQV.setAntiAlias(true);
    this.pQV.setColor(this.pQX);
    this.pQV.setStyle(Paint.Style.STROKE);
    this.pQV.setStrokeWidth(2.0F);
    this.pQW.setAntiAlias(true);
    this.pQW.setColor(this.pQY);
    this.pQW.setStyle(Paint.Style.STROKE);
    this.pQW.setStrokeWidth(2.0F);
    this.pQV.setPathEffect(this.pQZ);
    this.pQW.setStyle(Paint.Style.FILL);
    this.pQL = (0.05F * this.pQK);
    this.pQM = (0.28F * this.pQK);
    this.pQT = (0.85F * this.pQK);
    this.pQN = a.m(getContext(), a.d.step_ok);
    this.pQO = a.m(getContext(), a.d.step_attention);
    this.pQP = a.m(getContext(), a.d.step_optional);
    this.pQQ = a.m(getContext(), a.d.step_error);
    this.pRb = true;
    AppMethodBeat.o(208702);
  }
  
  public List<Float> getCircleCenterPointPositionList()
  {
    return this.pQU;
  }
  
  public float getCircleRadius()
  {
    return this.pQM;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    AppMethodBeat.i(208705);
    super.onDraw(paramCanvas);
    if (this.pRa != null) {
      this.pRa.bZu();
    }
    this.pQV.setColor(this.pQX);
    this.pQW.setColor(this.pQY);
    int j = 0;
    int i = k;
    float f1;
    if (j < this.pQU.size() - 1)
    {
      f1 = ((Float)this.pQU.get(j)).floatValue();
      float f2 = ((Float)this.pQU.get(j + 1)).floatValue();
      if (j < this.pQG) {
        if (this.pRb) {
          paramCanvas.drawRect(this.pQR, f2 + this.pQM - 10.0F, this.pQS, f1 - this.pQM + 10.0F, this.pQW);
        }
      }
      for (;;)
      {
        j += 1;
        break;
        paramCanvas.drawRect(this.pQR, this.pQM + f1 - 10.0F, this.pQS, f2 - this.pQM + 10.0F, this.pQW);
        continue;
        if (this.pRb)
        {
          this.auD.moveTo(this.eYP, f2 + this.pQM);
          this.auD.lineTo(this.eYP, f1 - this.pQM);
          paramCanvas.drawPath(this.auD, this.pQV);
        }
        else
        {
          this.auD.moveTo(this.eYP, this.pQM + f1);
          this.auD.lineTo(this.eYP, f2 - this.pQM);
          paramCanvas.drawPath(this.auD, this.pQV);
        }
      }
    }
    if (i < this.pQU.size())
    {
      f1 = ((Float)this.pQU.get(i)).floatValue();
      this.mRect = new Rect((int)(this.eYP - this.pQM), (int)(f1 - this.pQM), (int)(this.eYP + this.pQM), (int)(f1 + this.pQM));
      j = ((c)this.pQF.get(i)).mState;
      if (j == 0)
      {
        this.pQN.setBounds(this.mRect);
        this.pQN.draw(paramCanvas);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 2)
        {
          this.pQO.setBounds(this.mRect);
          this.pQO.draw(paramCanvas);
        }
        else if (j == -2)
        {
          this.pQP.setBounds(this.mRect);
          this.pQP.draw(paramCanvas);
        }
        else
        {
          this.pQQ.setBounds(this.mRect);
          this.pQQ.draw(paramCanvas);
        }
      }
    }
    AppMethodBeat.o(208705);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208703);
    super.onMeasure(paramInt1, paramInt2);
    int i = this.pQK;
    this.mHeight = 0;
    paramInt2 = this.pQF.size();
    if (paramInt2 > 0)
    {
      float f1 = getPaddingTop() + getPaddingBottom();
      float f2 = this.pQM;
      float f3 = paramInt2;
      this.mHeight = ((int)((paramInt2 - 1) * this.pQT + (f1 + f2 * 2.0F * f3)));
    }
    paramInt2 = i;
    if (View.MeasureSpec.getMode(paramInt1) != 0) {
      paramInt2 = Math.min(i, View.MeasureSpec.getSize(paramInt1));
    }
    setMeasuredDimension(paramInt2, this.mHeight);
    AppMethodBeat.o(208703);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(208704);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.eYP = (getWidth() / 2);
    this.pQR = (this.eYP - this.pQL / 2.0F);
    this.pQS = (this.eYP + this.pQL / 2.0F);
    paramInt1 = 0;
    if (paramInt1 < this.pQF.size())
    {
      if (this.pRb) {
        this.pQU.add(Float.valueOf(this.mHeight - (this.pQM + paramInt1 * this.pQM * 2.0F + paramInt1 * this.pQT)));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.pQU.add(Float.valueOf(this.pQM + paramInt1 * this.pQM * 2.0F + paramInt1 * this.pQT));
      }
    }
    if (this.pRa != null) {
      this.pRa.bZu();
    }
    AppMethodBeat.o(208704);
  }
  
  public void setAttentionIcon(Drawable paramDrawable)
  {
    this.pQO = paramDrawable;
  }
  
  public void setComplectingPosition(int paramInt)
  {
    AppMethodBeat.i(208708);
    this.pQG = paramInt;
    requestLayout();
    AppMethodBeat.o(208708);
  }
  
  public void setCompleteIcon(Drawable paramDrawable)
  {
    this.pQN = paramDrawable;
  }
  
  public void setCompletedLineColor(int paramInt)
  {
    this.pQY = paramInt;
  }
  
  public void setDefaultIcon(Drawable paramDrawable)
  {
    this.pQP = paramDrawable;
  }
  
  public void setIndicatorLinePaddingProportion(float paramFloat)
  {
    this.pQT = (this.pQK * paramFloat);
  }
  
  public void setOnDrawListener(a parama)
  {
    this.pRa = parama;
  }
  
  public void setSteps(List<c> paramList)
  {
    AppMethodBeat.i(208707);
    if (paramList == null)
    {
      this.pQF = new ArrayList();
      AppMethodBeat.o(208707);
      return;
    }
    this.pQF = paramList;
    requestLayout();
    AppMethodBeat.o(208707);
  }
  
  public void setUnCompletedLineColor(int paramInt)
  {
    this.pQX = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void bZu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepViewIndicator
 * JD-Core Version:    0.7.0.1
 */