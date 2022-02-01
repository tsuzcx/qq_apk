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
  private float cQO;
  private List<c> lHY;
  private int lHZ;
  private final String lIc;
  private int lId;
  private float lIe;
  private float lIf;
  private Drawable lIg;
  private Drawable lIh;
  private Drawable lIi;
  private Drawable lIj;
  private float lIk;
  private float lIl;
  private float lIm;
  private List<Float> lIn;
  private Paint lIo;
  private Paint lIp;
  private int lIq;
  private int lIr;
  private PathEffect lIs;
  private a lIt;
  private boolean lIu;
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
    AppMethodBeat.i(201294);
    this.lIc = getClass().getSimpleName();
    this.lId = ((int)TypedValue.applyDimension(1, 40.0F, getResources().getDisplayMetrics()));
    this.lHY = new ArrayList();
    this.lIq = b.n(getContext(), 2131101193);
    this.lIr = -1;
    this.xN = new Path();
    this.lIs = new DashPathEffect(new float[] { 8.0F, 8.0F, 8.0F, 8.0F }, 1.0F);
    this.lIn = new ArrayList();
    this.lIo = new Paint();
    this.lIp = new Paint();
    this.lIo.setAntiAlias(true);
    this.lIo.setColor(this.lIq);
    this.lIo.setStyle(Paint.Style.STROKE);
    this.lIo.setStrokeWidth(2.0F);
    this.lIp.setAntiAlias(true);
    this.lIp.setColor(this.lIr);
    this.lIp.setStyle(Paint.Style.STROKE);
    this.lIp.setStrokeWidth(2.0F);
    this.lIo.setPathEffect(this.lIs);
    this.lIp.setStyle(Paint.Style.FILL);
    this.lIe = (0.05F * this.lId);
    this.lIf = (0.28F * this.lId);
    this.lIm = (0.85F * this.lId);
    this.lIg = b.l(getContext(), 2131234846);
    this.lIh = b.l(getContext(), 2131234843);
    this.lIi = b.l(getContext(), 2131234847);
    this.lIj = b.l(getContext(), 2131234845);
    this.lIu = true;
    AppMethodBeat.o(201294);
  }
  
  public List<Float> getCircleCenterPointPositionList()
  {
    return this.lIn;
  }
  
  public float getCircleRadius()
  {
    return this.lIf;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int k = 0;
    AppMethodBeat.i(201297);
    super.onDraw(paramCanvas);
    if (this.lIt != null) {
      this.lIt.brr();
    }
    this.lIo.setColor(this.lIq);
    this.lIp.setColor(this.lIr);
    int j = 0;
    int i = k;
    float f1;
    if (j < this.lIn.size() - 1)
    {
      f1 = ((Float)this.lIn.get(j)).floatValue();
      float f2 = ((Float)this.lIn.get(j + 1)).floatValue();
      if (j < this.lHZ) {
        if (this.lIu) {
          paramCanvas.drawRect(this.lIk, f2 + this.lIf - 10.0F, this.lIl, f1 - this.lIf + 10.0F, this.lIp);
        }
      }
      for (;;)
      {
        j += 1;
        break;
        paramCanvas.drawRect(this.lIk, this.lIf + f1 - 10.0F, this.lIl, f2 - this.lIf + 10.0F, this.lIp);
        continue;
        if (this.lIu)
        {
          this.xN.moveTo(this.cQO, f2 + this.lIf);
          this.xN.lineTo(this.cQO, f1 - this.lIf);
          paramCanvas.drawPath(this.xN, this.lIo);
        }
        else
        {
          this.xN.moveTo(this.cQO, this.lIf + f1);
          this.xN.lineTo(this.cQO, f2 - this.lIf);
          paramCanvas.drawPath(this.xN, this.lIo);
        }
      }
    }
    if (i < this.lIn.size())
    {
      f1 = ((Float)this.lIn.get(i)).floatValue();
      this.mRect = new Rect((int)(this.cQO - this.lIf), (int)(f1 - this.lIf), (int)(this.cQO + this.lIf), (int)(f1 + this.lIf));
      j = ((c)this.lHY.get(i)).mState;
      if (j == 0)
      {
        this.lIg.setBounds(this.mRect);
        this.lIg.draw(paramCanvas);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 2)
        {
          this.lIh.setBounds(this.mRect);
          this.lIh.draw(paramCanvas);
        }
        else if (j == -2)
        {
          this.lIi.setBounds(this.mRect);
          this.lIi.draw(paramCanvas);
        }
        else
        {
          this.lIj.setBounds(this.mRect);
          this.lIj.draw(paramCanvas);
        }
      }
    }
    AppMethodBeat.o(201297);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201295);
    super.onMeasure(paramInt1, paramInt2);
    int i = this.lId;
    this.mHeight = 0;
    paramInt2 = this.lHY.size();
    if (paramInt2 > 0)
    {
      float f1 = getPaddingTop() + getPaddingBottom();
      float f2 = this.lIf;
      float f3 = paramInt2;
      this.mHeight = ((int)((paramInt2 - 1) * this.lIm + (f1 + f2 * 2.0F * f3)));
    }
    paramInt2 = i;
    if (View.MeasureSpec.getMode(paramInt1) != 0) {
      paramInt2 = Math.min(i, View.MeasureSpec.getSize(paramInt1));
    }
    setMeasuredDimension(paramInt2, this.mHeight);
    AppMethodBeat.o(201295);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(201296);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.cQO = (getWidth() / 2);
    this.lIk = (this.cQO - this.lIe / 2.0F);
    this.lIl = (this.cQO + this.lIe / 2.0F);
    paramInt1 = 0;
    if (paramInt1 < this.lHY.size())
    {
      if (this.lIu) {
        this.lIn.add(Float.valueOf(this.mHeight - (this.lIf + paramInt1 * this.lIf * 2.0F + paramInt1 * this.lIm)));
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        this.lIn.add(Float.valueOf(this.lIf + paramInt1 * this.lIf * 2.0F + paramInt1 * this.lIm));
      }
    }
    if (this.lIt != null) {
      this.lIt.brr();
    }
    AppMethodBeat.o(201296);
  }
  
  public void setAttentionIcon(Drawable paramDrawable)
  {
    this.lIh = paramDrawable;
  }
  
  public void setComplectingPosition(int paramInt)
  {
    AppMethodBeat.i(201299);
    this.lHZ = paramInt;
    requestLayout();
    AppMethodBeat.o(201299);
  }
  
  public void setCompleteIcon(Drawable paramDrawable)
  {
    this.lIg = paramDrawable;
  }
  
  public void setCompletedLineColor(int paramInt)
  {
    this.lIr = paramInt;
  }
  
  public void setDefaultIcon(Drawable paramDrawable)
  {
    this.lIi = paramDrawable;
  }
  
  public void setIndicatorLinePaddingProportion(float paramFloat)
  {
    this.lIm = (this.lId * paramFloat);
  }
  
  public void setOnDrawListener(a parama)
  {
    this.lIt = parama;
  }
  
  public void setSteps(List<c> paramList)
  {
    AppMethodBeat.i(201298);
    if (paramList == null)
    {
      this.lHY = new ArrayList();
      AppMethodBeat.o(201298);
      return;
    }
    this.lHY = paramList;
    requestLayout();
    AppMethodBeat.o(201298);
  }
  
  public void setUnCompletedLineColor(int paramInt)
  {
    this.lIq = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void brr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.stepview.VerticalStepViewIndicator
 * JD-Core Version:    0.7.0.1
 */