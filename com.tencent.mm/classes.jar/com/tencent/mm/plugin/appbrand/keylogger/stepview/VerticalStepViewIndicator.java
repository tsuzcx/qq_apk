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
  private float cQe;
  private int lDA;
  private final String lDD;
  private int lDE;
  private float lDF;
  private float lDG;
  private Drawable lDH;
  private Drawable lDI;
  private Drawable lDJ;
  private Drawable lDK;
  private float lDL;
  private float lDM;
  private float lDN;
  private List<Float> lDO;
  private Paint lDP;
  private Paint lDQ;
  private int lDR;
  private int lDS;
  private PathEffect lDT;
  private a lDU;
  private boolean lDV;
  private List<c> lDz;
  private int mHeight;
  private Rect mRect;
  private Path xN;
  
  public VerticalStepViewIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VerticalStepViewIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(187727);
    this.lDD = getClass().getSimpleName();
    this.lDE = ((int)TypedValue.applyDimension(1, 40.0F, getResources().getDisplayMetrics()));
    this.lDz = new ArrayList();
    this.lDR = b.n(getContext(), 2131101193);
    this.lDS = -1;
    this.xN = new Path();
    this.lDT = new DashPathEffect(new float[] { 8.0F, 8.0F, 8.0F, 8.0F }, 1.0F);
    this.lDO = new ArrayList();
    this.lDP = new Paint();
    this.lDQ = new Paint();
    this.lDP.setAntiAlias(true);
    this.lDP.setColor(this.lDR);
    this.lDP.setStyle(Paint.Style.STROKE);
    this.lDP.setStrokeWidth(2.0F);
    this.lDQ.setAntiAlias(true);
    this.lDQ.setColor(this.lDS);
    this.lDQ.setStyle(Paint.Style.STROKE);
    this.lDQ.setStrokeWidth(2.0F);
    this.lDP.setPathEffect(this.lDT);
    this.lDQ.setStyle(Paint.Style.FILL);
    this.lDF = (0.05F * this.lDE);
    this.lDG = (0.28F * this.lDE);
    this.lDN = (0.85F * this.lDE);
    this.lDH = b.l(getContext(), 2131234846);
    this.lDI = b.l(getContext(), 2131234843);
    this.lDJ = b.l(getContext(), 2131234847);
    this.lDK = b.l(getContext(), 2131234845);
    this.lDV = true;
    AppMethodBeat.o(187727);
  }
  
  public List<Float> getCircleCenterPointPositionList()
  {
    return this.lDO;
  }
  
  public float getCircleRadius()
  {
    return this.lDG;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    AppMethodBeat.i(187730);
    super.onDraw(paramCanvas);
    if (this.lDU != null) {
      this.lDU.bqH();
    }
    this.lDP.setColor(this.lDR);
    this.lDQ.setColor(this.lDS);
    int j = 0;
    int i = k;
    float f1;
    if (j < this.lDO.size() - 1)
    {
      f1 = ((Float)this.lDO.get(j)).floatValue();
      float f2 = ((Float)this.lDO.get(j + 1)).floatValue();
      if (j < this.lDA) {
        if (this.lDV) {
          paramCanvas.drawRect(this.lDL, f2 + this.lDG - 10.0F, this.lDM, f1 - this.lDG + 10.0F, this.lDQ);
        }
      }
      for (;;)
      {
        j += 1;
        break;
        paramCanvas.drawRect(this.lDL, this.lDG + f1 - 10.0F, this.lDM, f2 - this.lDG + 10.0F, this.lDQ);
        continue;
        if (this.lDV)
        {
          this.xN.moveTo(this.cQe, f2 + this.lDG);
          this.xN.lineTo(this.cQe, f1 - this.lDG);
          paramCanvas.drawPath(this.xN, this.lDP);
        }
        else
        {
          this.xN.moveTo(this.cQe, this.lDG + f1);
          this.xN.lineTo(this.cQe, f2 - this.lDG);
          paramCanvas.drawPath(this.xN, this.lDP);
        }
      }
    }
    if (i < this.lDO.size())
    {
      f1 = ((Float)this.lDO.get(i)).floatValue();
      this.mRect = new Rect((int)(this.cQe - this.lDG), (int)(f1 - this.lDG), (int)(this.cQe + this.lDG), (int)(f1 + this.lDG));
      j = ((c)this.lDz.get(i)).mState;
      if (j == 0)
      {
        this.lDH.setBounds(this.mRect);
        this.lDH.draw(paramCanvas);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 2)
        {
          this.lDI.setBounds(this.mRect);
          this.lDI.draw(paramCanvas);
        }
        else if (j == -2)
        {
          this.lDJ.setBounds(this.mRect);
          this.lDJ.draw(paramCanvas);
        }
        else
        {
          this.lDK.setBounds(this.mRect);
          this.lDK.draw(paramCanvas);
        }
      }
    }
    AppMethodBeat.o(187730);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187728);
    super.onMeasure(paramInt1, paramInt2);
    int i = this.lDE;
    this.mHeight = 0;
    paramInt2 = this.lDz.size();
    if (paramInt2 > 0)
    {
      float f1 = getPaddingTop() + getPaddingBottom();
      float f2 = this.lDG;
      float f3 = paramInt2;
      this.mHeight = ((int)((paramInt2 - 1) * this.lDN + (f1 + f2 * 2.0F * f3)));
    }
    paramInt2 = i;
    if (View.MeasureSpec.getMode(paramInt1) != 0) {
      paramInt2 = Math.min(i, View.MeasureSpec.getSize(paramInt1));
    }
    setMeasuredDimension(paramInt2, this.mHeight);
    AppMethodBeat.o(187728);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(187729);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.cQe = (getWidth() / 2);
    this.lDL = (this.cQe - this.lDF / 2.0F);
    this.lDM = (this.cQe + this.lDF / 2.0F);
    paramInt1 = 0;
    if (paramInt1 < this.lDz.size())
    {
      if (this.lDV) {
        this.lDO.add(Float.valueOf(this.mHeight - (this.lDG + paramInt1 * this.lDG * 2.0F + paramInt1 * this.lDN)));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.lDO.add(Float.valueOf(this.lDG + paramInt1 * this.lDG * 2.0F + paramInt1 * this.lDN));
      }
    }
    if (this.lDU != null) {
      this.lDU.bqH();
    }
    AppMethodBeat.o(187729);
  }
  
  public void setAttentionIcon(Drawable paramDrawable)
  {
    this.lDI = paramDrawable;
  }
  
  public void setComplectingPosition(int paramInt)
  {
    AppMethodBeat.i(187732);
    this.lDA = paramInt;
    requestLayout();
    AppMethodBeat.o(187732);
  }
  
  public void setCompleteIcon(Drawable paramDrawable)
  {
    this.lDH = paramDrawable;
  }
  
  public void setCompletedLineColor(int paramInt)
  {
    this.lDS = paramInt;
  }
  
  public void setDefaultIcon(Drawable paramDrawable)
  {
    this.lDJ = paramDrawable;
  }
  
  public void setIndicatorLinePaddingProportion(float paramFloat)
  {
    this.lDN = (this.lDE * paramFloat);
  }
  
  public void setOnDrawListener(a parama)
  {
    this.lDU = parama;
  }
  
  public void setSteps(List<c> paramList)
  {
    AppMethodBeat.i(187731);
    if (paramList == null)
    {
      this.lDz = new ArrayList();
      AppMethodBeat.o(187731);
      return;
    }
    this.lDz = paramList;
    requestLayout();
    AppMethodBeat.o(187731);
  }
  
  public void setUnCompletedLineColor(int paramInt)
  {
    this.lDR = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void bqH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepViewIndicator
 * JD-Core Version:    0.7.0.1
 */