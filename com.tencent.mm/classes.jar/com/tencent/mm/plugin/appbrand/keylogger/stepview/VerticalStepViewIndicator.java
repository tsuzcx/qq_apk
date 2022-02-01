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
  private float cEZ;
  private List<c> lgB;
  private int lgC;
  private final String lgF;
  private int lgG;
  private float lgH;
  private float lgI;
  private Drawable lgJ;
  private Drawable lgK;
  private Drawable lgL;
  private Drawable lgM;
  private float lgN;
  private float lgO;
  private float lgP;
  private List<Float> lgQ;
  private Paint lgR;
  private Paint lgS;
  private int lgT;
  private int lgU;
  private PathEffect lgV;
  private a lgW;
  private boolean lgX;
  private int mHeight;
  private Rect mRect;
  private Path vU;
  
  public VerticalStepViewIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepViewIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(201055);
    this.lgF = getClass().getSimpleName();
    this.lgG = ((int)TypedValue.applyDimension(1, 40.0F, getResources().getDisplayMetrics()));
    this.lgB = new ArrayList();
    this.lgT = b.n(getContext(), 2131101193);
    this.lgU = -1;
    this.vU = new Path();
    this.lgV = new DashPathEffect(new float[] { 8.0F, 8.0F, 8.0F, 8.0F }, 1.0F);
    this.lgQ = new ArrayList();
    this.lgR = new Paint();
    this.lgS = new Paint();
    this.lgR.setAntiAlias(true);
    this.lgR.setColor(this.lgT);
    this.lgR.setStyle(Paint.Style.STROKE);
    this.lgR.setStrokeWidth(2.0F);
    this.lgS.setAntiAlias(true);
    this.lgS.setColor(this.lgU);
    this.lgS.setStyle(Paint.Style.STROKE);
    this.lgS.setStrokeWidth(2.0F);
    this.lgR.setPathEffect(this.lgV);
    this.lgS.setStyle(Paint.Style.FILL);
    this.lgH = (0.05F * this.lgG);
    this.lgI = (0.28F * this.lgG);
    this.lgP = (0.85F * this.lgG);
    this.lgJ = b.l(getContext(), 2131234846);
    this.lgK = b.l(getContext(), 2131234843);
    this.lgL = b.l(getContext(), 2131234847);
    this.lgM = b.l(getContext(), 2131234845);
    this.lgX = true;
    AppMethodBeat.o(201055);
  }
  
  public List<Float> getCircleCenterPointPositionList()
  {
    return this.lgQ;
  }
  
  public float getCircleRadius()
  {
    return this.lgI;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    AppMethodBeat.i(201058);
    super.onDraw(paramCanvas);
    if (this.lgW != null) {
      this.lgW.bmW();
    }
    this.lgR.setColor(this.lgT);
    this.lgS.setColor(this.lgU);
    int j = 0;
    int i = k;
    float f1;
    if (j < this.lgQ.size() - 1)
    {
      f1 = ((Float)this.lgQ.get(j)).floatValue();
      float f2 = ((Float)this.lgQ.get(j + 1)).floatValue();
      if (j < this.lgC) {
        if (this.lgX) {
          paramCanvas.drawRect(this.lgN, f2 + this.lgI - 10.0F, this.lgO, f1 - this.lgI + 10.0F, this.lgS);
        }
      }
      for (;;)
      {
        j += 1;
        break;
        paramCanvas.drawRect(this.lgN, this.lgI + f1 - 10.0F, this.lgO, f2 - this.lgI + 10.0F, this.lgS);
        continue;
        if (this.lgX)
        {
          this.vU.moveTo(this.cEZ, f2 + this.lgI);
          this.vU.lineTo(this.cEZ, f1 - this.lgI);
          paramCanvas.drawPath(this.vU, this.lgR);
        }
        else
        {
          this.vU.moveTo(this.cEZ, this.lgI + f1);
          this.vU.lineTo(this.cEZ, f2 - this.lgI);
          paramCanvas.drawPath(this.vU, this.lgR);
        }
      }
    }
    if (i < this.lgQ.size())
    {
      f1 = ((Float)this.lgQ.get(i)).floatValue();
      this.mRect = new Rect((int)(this.cEZ - this.lgI), (int)(f1 - this.lgI), (int)(this.cEZ + this.lgI), (int)(f1 + this.lgI));
      j = ((c)this.lgB.get(i)).mState;
      if (j == 0)
      {
        this.lgJ.setBounds(this.mRect);
        this.lgJ.draw(paramCanvas);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 2)
        {
          this.lgK.setBounds(this.mRect);
          this.lgK.draw(paramCanvas);
        }
        else if (j == -2)
        {
          this.lgL.setBounds(this.mRect);
          this.lgL.draw(paramCanvas);
        }
        else
        {
          this.lgM.setBounds(this.mRect);
          this.lgM.draw(paramCanvas);
        }
      }
    }
    AppMethodBeat.o(201058);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201056);
    super.onMeasure(paramInt1, paramInt2);
    int i = this.lgG;
    this.mHeight = 0;
    paramInt2 = this.lgB.size();
    if (paramInt2 > 0)
    {
      float f1 = getPaddingTop() + getPaddingBottom();
      float f2 = this.lgI;
      float f3 = paramInt2;
      this.mHeight = ((int)((paramInt2 - 1) * this.lgP + (f1 + f2 * 2.0F * f3)));
    }
    paramInt2 = i;
    if (View.MeasureSpec.getMode(paramInt1) != 0) {
      paramInt2 = Math.min(i, View.MeasureSpec.getSize(paramInt1));
    }
    setMeasuredDimension(paramInt2, this.mHeight);
    AppMethodBeat.o(201056);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(201057);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.cEZ = (getWidth() / 2);
    this.lgN = (this.cEZ - this.lgH / 2.0F);
    this.lgO = (this.cEZ + this.lgH / 2.0F);
    paramInt1 = 0;
    if (paramInt1 < this.lgB.size())
    {
      if (this.lgX) {
        this.lgQ.add(Float.valueOf(this.mHeight - (this.lgI + paramInt1 * this.lgI * 2.0F + paramInt1 * this.lgP)));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.lgQ.add(Float.valueOf(this.lgI + paramInt1 * this.lgI * 2.0F + paramInt1 * this.lgP));
      }
    }
    if (this.lgW != null) {
      this.lgW.bmW();
    }
    AppMethodBeat.o(201057);
  }
  
  public void setAttentionIcon(Drawable paramDrawable)
  {
    this.lgK = paramDrawable;
  }
  
  public void setComplectingPosition(int paramInt)
  {
    AppMethodBeat.i(201060);
    this.lgC = paramInt;
    requestLayout();
    AppMethodBeat.o(201060);
  }
  
  public void setCompleteIcon(Drawable paramDrawable)
  {
    this.lgJ = paramDrawable;
  }
  
  public void setCompletedLineColor(int paramInt)
  {
    this.lgU = paramInt;
  }
  
  public void setDefaultIcon(Drawable paramDrawable)
  {
    this.lgL = paramDrawable;
  }
  
  public void setIndicatorLinePaddingProportion(float paramFloat)
  {
    this.lgP = (this.lgG * paramFloat);
  }
  
  public void setOnDrawListener(a parama)
  {
    this.lgW = parama;
  }
  
  public void setSteps(List<c> paramList)
  {
    AppMethodBeat.i(201059);
    if (paramList == null)
    {
      this.lgB = new ArrayList();
      AppMethodBeat.o(201059);
      return;
    }
    this.lgB = paramList;
    requestLayout();
    AppMethodBeat.o(201059);
  }
  
  public void setUnCompletedLineColor(int paramInt)
  {
    this.lgT = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void bmW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepViewIndicator
 * JD-Core Version:    0.7.0.1
 */