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
  private float dhi;
  private int mHeight;
  private List<c> mPM;
  private int mPN;
  private final String mPQ;
  private int mPR;
  private float mPS;
  private float mPT;
  private Drawable mPU;
  private Drawable mPV;
  private Drawable mPW;
  private Drawable mPX;
  private float mPY;
  private float mPZ;
  private float mQa;
  private List<Float> mQb;
  private Paint mQc;
  private Paint mQd;
  private int mQe;
  private int mQf;
  private PathEffect mQg;
  private a mQh;
  private boolean mQi;
  private Rect mRect;
  private Path xT;
  
  public VerticalStepViewIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepViewIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(221339);
    this.mPQ = getClass().getSimpleName();
    this.mPR = ((int)TypedValue.applyDimension(1, 40.0F, getResources().getDisplayMetrics()));
    this.mPM = new ArrayList();
    this.mQe = b.n(getContext(), 2131101298);
    this.mQf = -1;
    this.xT = new Path();
    this.mQg = new DashPathEffect(new float[] { 8.0F, 8.0F, 8.0F, 8.0F }, 1.0F);
    this.mQb = new ArrayList();
    this.mQc = new Paint();
    this.mQd = new Paint();
    this.mQc.setAntiAlias(true);
    this.mQc.setColor(this.mQe);
    this.mQc.setStyle(Paint.Style.STROKE);
    this.mQc.setStrokeWidth(2.0F);
    this.mQd.setAntiAlias(true);
    this.mQd.setColor(this.mQf);
    this.mQd.setStyle(Paint.Style.STROKE);
    this.mQd.setStrokeWidth(2.0F);
    this.mQc.setPathEffect(this.mQg);
    this.mQd.setStyle(Paint.Style.FILL);
    this.mPS = (0.05F * this.mPR);
    this.mPT = (0.28F * this.mPR);
    this.mQa = (0.85F * this.mPR);
    this.mPU = b.l(getContext(), 2131235053);
    this.mPV = b.l(getContext(), 2131235050);
    this.mPW = b.l(getContext(), 2131235054);
    this.mPX = b.l(getContext(), 2131235052);
    this.mQi = true;
    AppMethodBeat.o(221339);
  }
  
  public List<Float> getCircleCenterPointPositionList()
  {
    return this.mQb;
  }
  
  public float getCircleRadius()
  {
    return this.mPT;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    AppMethodBeat.i(221342);
    super.onDraw(paramCanvas);
    if (this.mQh != null) {
      this.mQh.bNc();
    }
    this.mQc.setColor(this.mQe);
    this.mQd.setColor(this.mQf);
    int j = 0;
    int i = k;
    float f1;
    if (j < this.mQb.size() - 1)
    {
      f1 = ((Float)this.mQb.get(j)).floatValue();
      float f2 = ((Float)this.mQb.get(j + 1)).floatValue();
      if (j < this.mPN) {
        if (this.mQi) {
          paramCanvas.drawRect(this.mPY, f2 + this.mPT - 10.0F, this.mPZ, f1 - this.mPT + 10.0F, this.mQd);
        }
      }
      for (;;)
      {
        j += 1;
        break;
        paramCanvas.drawRect(this.mPY, this.mPT + f1 - 10.0F, this.mPZ, f2 - this.mPT + 10.0F, this.mQd);
        continue;
        if (this.mQi)
        {
          this.xT.moveTo(this.dhi, f2 + this.mPT);
          this.xT.lineTo(this.dhi, f1 - this.mPT);
          paramCanvas.drawPath(this.xT, this.mQc);
        }
        else
        {
          this.xT.moveTo(this.dhi, this.mPT + f1);
          this.xT.lineTo(this.dhi, f2 - this.mPT);
          paramCanvas.drawPath(this.xT, this.mQc);
        }
      }
    }
    if (i < this.mQb.size())
    {
      f1 = ((Float)this.mQb.get(i)).floatValue();
      this.mRect = new Rect((int)(this.dhi - this.mPT), (int)(f1 - this.mPT), (int)(this.dhi + this.mPT), (int)(f1 + this.mPT));
      j = ((c)this.mPM.get(i)).mState;
      if (j == 0)
      {
        this.mPU.setBounds(this.mRect);
        this.mPU.draw(paramCanvas);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 2)
        {
          this.mPV.setBounds(this.mRect);
          this.mPV.draw(paramCanvas);
        }
        else if (j == -2)
        {
          this.mPW.setBounds(this.mRect);
          this.mPW.draw(paramCanvas);
        }
        else
        {
          this.mPX.setBounds(this.mRect);
          this.mPX.draw(paramCanvas);
        }
      }
    }
    AppMethodBeat.o(221342);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(221340);
    super.onMeasure(paramInt1, paramInt2);
    int i = this.mPR;
    this.mHeight = 0;
    paramInt2 = this.mPM.size();
    if (paramInt2 > 0)
    {
      float f1 = getPaddingTop() + getPaddingBottom();
      float f2 = this.mPT;
      float f3 = paramInt2;
      this.mHeight = ((int)((paramInt2 - 1) * this.mQa + (f1 + f2 * 2.0F * f3)));
    }
    paramInt2 = i;
    if (View.MeasureSpec.getMode(paramInt1) != 0) {
      paramInt2 = Math.min(i, View.MeasureSpec.getSize(paramInt1));
    }
    setMeasuredDimension(paramInt2, this.mHeight);
    AppMethodBeat.o(221340);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(221341);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.dhi = (getWidth() / 2);
    this.mPY = (this.dhi - this.mPS / 2.0F);
    this.mPZ = (this.dhi + this.mPS / 2.0F);
    paramInt1 = 0;
    if (paramInt1 < this.mPM.size())
    {
      if (this.mQi) {
        this.mQb.add(Float.valueOf(this.mHeight - (this.mPT + paramInt1 * this.mPT * 2.0F + paramInt1 * this.mQa)));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.mQb.add(Float.valueOf(this.mPT + paramInt1 * this.mPT * 2.0F + paramInt1 * this.mQa));
      }
    }
    if (this.mQh != null) {
      this.mQh.bNc();
    }
    AppMethodBeat.o(221341);
  }
  
  public void setAttentionIcon(Drawable paramDrawable)
  {
    this.mPV = paramDrawable;
  }
  
  public void setComplectingPosition(int paramInt)
  {
    AppMethodBeat.i(221344);
    this.mPN = paramInt;
    requestLayout();
    AppMethodBeat.o(221344);
  }
  
  public void setCompleteIcon(Drawable paramDrawable)
  {
    this.mPU = paramDrawable;
  }
  
  public void setCompletedLineColor(int paramInt)
  {
    this.mQf = paramInt;
  }
  
  public void setDefaultIcon(Drawable paramDrawable)
  {
    this.mPW = paramDrawable;
  }
  
  public void setIndicatorLinePaddingProportion(float paramFloat)
  {
    this.mQa = (this.mPR * paramFloat);
  }
  
  public void setOnDrawListener(a parama)
  {
    this.mQh = parama;
  }
  
  public void setSteps(List<c> paramList)
  {
    AppMethodBeat.i(221343);
    if (paramList == null)
    {
      this.mPM = new ArrayList();
      AppMethodBeat.o(221343);
      return;
    }
    this.mPM = paramList;
    requestLayout();
    AppMethodBeat.o(221343);
  }
  
  public void setUnCompletedLineColor(int paramInt)
  {
    this.mQe = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void bNc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepViewIndicator
 * JD-Core Version:    0.7.0.1
 */