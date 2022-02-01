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
  private Path cja;
  private float hcp;
  private int mHeight;
  private Rect mRect;
  private boolean sVA;
  private List<c> sVe;
  private int sVf;
  private final String sVi;
  private int sVj;
  private float sVk;
  private float sVl;
  private Drawable sVm;
  private Drawable sVn;
  private Drawable sVo;
  private Drawable sVp;
  private float sVq;
  private float sVr;
  private float sVs;
  private List<Float> sVt;
  private Paint sVu;
  private Paint sVv;
  private int sVw;
  private int sVx;
  private PathEffect sVy;
  private a sVz;
  
  public VerticalStepViewIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepViewIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(319468);
    this.sVi = getClass().getSimpleName();
    this.sVj = ((int)TypedValue.applyDimension(1, 40.0F, getResources().getDisplayMetrics()));
    this.sVe = new ArrayList();
    this.sVw = a.w(getContext(), a.b.uncompleted_color);
    this.sVx = -1;
    this.cja = new Path();
    this.sVy = new DashPathEffect(new float[] { 8.0F, 8.0F, 8.0F, 8.0F }, 1.0F);
    this.sVt = new ArrayList();
    this.sVu = new Paint();
    this.sVv = new Paint();
    this.sVu.setAntiAlias(true);
    this.sVu.setColor(this.sVw);
    this.sVu.setStyle(Paint.Style.STROKE);
    this.sVu.setStrokeWidth(2.0F);
    this.sVv.setAntiAlias(true);
    this.sVv.setColor(this.sVx);
    this.sVv.setStyle(Paint.Style.STROKE);
    this.sVv.setStrokeWidth(2.0F);
    this.sVu.setPathEffect(this.sVy);
    this.sVv.setStyle(Paint.Style.FILL);
    this.sVk = (0.05F * this.sVj);
    this.sVl = (0.28F * this.sVj);
    this.sVs = (0.85F * this.sVj);
    this.sVm = a.m(getContext(), a.d.step_ok);
    this.sVn = a.m(getContext(), a.d.step_attention);
    this.sVo = a.m(getContext(), a.d.step_optional);
    this.sVp = a.m(getContext(), a.d.step_error);
    this.sVA = true;
    AppMethodBeat.o(319468);
  }
  
  public List<Float> getCircleCenterPointPositionList()
  {
    return this.sVt;
  }
  
  public float getCircleRadius()
  {
    return this.sVl;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    AppMethodBeat.i(319511);
    super.onDraw(paramCanvas);
    if (this.sVz != null) {
      this.sVz.czF();
    }
    this.sVu.setColor(this.sVw);
    this.sVv.setColor(this.sVx);
    int j = 0;
    int i = k;
    float f1;
    if (j < this.sVt.size() - 1)
    {
      f1 = ((Float)this.sVt.get(j)).floatValue();
      float f2 = ((Float)this.sVt.get(j + 1)).floatValue();
      if (j < this.sVf) {
        if (this.sVA) {
          paramCanvas.drawRect(this.sVq, f2 + this.sVl - 10.0F, this.sVr, f1 - this.sVl + 10.0F, this.sVv);
        }
      }
      for (;;)
      {
        j += 1;
        break;
        paramCanvas.drawRect(this.sVq, this.sVl + f1 - 10.0F, this.sVr, f2 - this.sVl + 10.0F, this.sVv);
        continue;
        if (this.sVA)
        {
          this.cja.moveTo(this.hcp, f2 + this.sVl);
          this.cja.lineTo(this.hcp, f1 - this.sVl);
          paramCanvas.drawPath(this.cja, this.sVu);
        }
        else
        {
          this.cja.moveTo(this.hcp, this.sVl + f1);
          this.cja.lineTo(this.hcp, f2 - this.sVl);
          paramCanvas.drawPath(this.cja, this.sVu);
        }
      }
    }
    if (i < this.sVt.size())
    {
      f1 = ((Float)this.sVt.get(i)).floatValue();
      this.mRect = new Rect((int)(this.hcp - this.sVl), (int)(f1 - this.sVl), (int)(this.hcp + this.sVl), (int)(f1 + this.sVl));
      j = ((c)this.sVe.get(i)).mState;
      if (j == 0)
      {
        this.sVm.setBounds(this.mRect);
        this.sVm.draw(paramCanvas);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 2)
        {
          this.sVn.setBounds(this.mRect);
          this.sVn.draw(paramCanvas);
        }
        else if (j == -2)
        {
          this.sVo.setBounds(this.mRect);
          this.sVo.draw(paramCanvas);
        }
        else
        {
          this.sVp.setBounds(this.mRect);
          this.sVp.draw(paramCanvas);
        }
      }
    }
    AppMethodBeat.o(319511);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(319490);
    super.onMeasure(paramInt1, paramInt2);
    int i = this.sVj;
    this.mHeight = 0;
    paramInt2 = this.sVe.size();
    if (paramInt2 > 0)
    {
      float f1 = getPaddingTop() + getPaddingBottom();
      float f2 = this.sVl;
      float f3 = paramInt2;
      this.mHeight = ((int)((paramInt2 - 1) * this.sVs + (f1 + f2 * 2.0F * f3)));
    }
    paramInt2 = i;
    if (View.MeasureSpec.getMode(paramInt1) != 0) {
      paramInt2 = Math.min(i, View.MeasureSpec.getSize(paramInt1));
    }
    setMeasuredDimension(paramInt2, this.mHeight);
    AppMethodBeat.o(319490);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(319498);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.hcp = (getWidth() / 2);
    this.sVq = (this.hcp - this.sVk / 2.0F);
    this.sVr = (this.hcp + this.sVk / 2.0F);
    paramInt1 = 0;
    if (paramInt1 < this.sVe.size())
    {
      if (this.sVA) {
        this.sVt.add(Float.valueOf(this.mHeight - (this.sVl + paramInt1 * this.sVl * 2.0F + paramInt1 * this.sVs)));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.sVt.add(Float.valueOf(this.sVl + paramInt1 * this.sVl * 2.0F + paramInt1 * this.sVs));
      }
    }
    if (this.sVz != null) {
      this.sVz.czF();
    }
    AppMethodBeat.o(319498);
  }
  
  public void setAttentionIcon(Drawable paramDrawable)
  {
    this.sVn = paramDrawable;
  }
  
  public void setComplectingPosition(int paramInt)
  {
    AppMethodBeat.i(319527);
    this.sVf = paramInt;
    requestLayout();
    AppMethodBeat.o(319527);
  }
  
  public void setCompleteIcon(Drawable paramDrawable)
  {
    this.sVm = paramDrawable;
  }
  
  public void setCompletedLineColor(int paramInt)
  {
    this.sVx = paramInt;
  }
  
  public void setDefaultIcon(Drawable paramDrawable)
  {
    this.sVo = paramDrawable;
  }
  
  public void setIndicatorLinePaddingProportion(float paramFloat)
  {
    this.sVs = (this.sVj * paramFloat);
  }
  
  public void setOnDrawListener(a parama)
  {
    this.sVz = parama;
  }
  
  public void setSteps(List<c> paramList)
  {
    AppMethodBeat.i(319519);
    if (paramList == null)
    {
      this.sVe = new ArrayList();
      AppMethodBeat.o(319519);
      return;
    }
    this.sVe = paramList;
    requestLayout();
    AppMethodBeat.o(319519);
  }
  
  public void setUnCompletedLineColor(int paramInt)
  {
    this.sVw = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void czF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepViewIndicator
 * JD-Core Version:    0.7.0.1
 */