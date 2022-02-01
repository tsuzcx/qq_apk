package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;

public class SliderSeekBar
  extends View
{
  private boolean LmJ;
  private boolean LmK;
  private Paint borderPaint;
  private int borderWidth;
  private int padding;
  private View.OnTouchListener ryf;
  private n.a tGN;
  private boolean tGO;
  boolean tGP;
  private int tGQ;
  private int tGR;
  private Drawable tGS;
  private Drawable tGT;
  private int tGU;
  private float tGV;
  private int tGW;
  private float tGX;
  private int tGY;
  private Paint tGZ;
  private float tHa;
  private Paint tHb;
  private Paint tHc;
  private int tHd;
  private float tHe;
  private float tHf;
  private float tHg;
  private int tHh;
  private Rect tHi;
  private Rect tHj;
  
  public SliderSeekBar(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(94449);
    AppMethodBeat.o(94449);
  }
  
  public SliderSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SliderSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(205846);
    this.tGO = false;
    this.tGP = false;
    this.LmJ = false;
    this.LmK = false;
    this.tGX = -1.0F;
    this.tHf = -1.0F;
    this.tHg = -1.0F;
    this.padding = 0;
    this.ryf = new n.2(this);
    this.tGU = a.fromDPToPix(getContext(), 8);
    this.tGV = (this.tGU * 0.5F);
    this.tHh = a.fromDPToPix(getContext(), 8);
    this.tGS = new n.b(this, a.l(getContext(), 2131691359), a.l(getContext(), 2131691358));
    this.tGT = new n.b(this, a.l(getContext(), 2131691359), a.l(getContext(), 2131691358));
    this.tGW = a.fromDPToPix(getContext(), 1);
    this.tGY = a.ao(getContext(), 2131166956);
    this.tGX = -1.0F;
    this.tGZ = new Paint();
    this.tGZ.setColor(a.n(getContext(), 2131101179));
    this.tGZ.setAlpha(102);
    this.tHb = new Paint();
    this.tHb.setColor(a.n(getContext(), 2131100017));
    this.tHb.setAlpha(102);
    this.borderPaint = new Paint();
    this.borderPaint.setColor(a.n(getContext(), 2131101179));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.borderWidth = fx(getContext());
    this.borderPaint.setStrokeWidth(this.borderWidth);
    this.tHa = (this.borderWidth * 0.5F);
    this.tHc = new Paint();
    this.tHc.setColor(a.n(getContext(), 2131101179));
    this.tHc.setStyle(Paint.Style.STROKE);
    this.tHd = fx(getContext());
    this.tHe = (this.tHd * 0.5F);
    this.tHc.setStrokeWidth(this.tHd);
    this.tHc.setAlpha(178);
    setOnTouchListener(this.ryf);
    AppMethodBeat.o(205846);
  }
  
  private static int fx(Context paramContext)
  {
    AppMethodBeat.i(94450);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(94450);
    return i;
  }
  
  private boolean nk(boolean paramBoolean)
  {
    AppMethodBeat.i(94453);
    if (paramBoolean)
    {
      paramBoolean = n.b.a((n.b)this.tGS);
      AppMethodBeat.o(94453);
      return paramBoolean;
    }
    paramBoolean = n.b.a((n.b)this.tGT);
    AppMethodBeat.o(94453);
    return paramBoolean;
  }
  
  public final void bb(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(205847);
    post(new n.1(this, paramInt1, paramInt3, paramInt2));
    AppMethodBeat.o(205847);
  }
  
  public final boolean d(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(205849);
    if ((!this.tGO) || (this.tGS == null) || (this.tGT == null) || (this.tGS.getBounds().width() <= 0) || (this.tGT.getBounds().width() <= 0))
    {
      AppMethodBeat.o(205849);
      return false;
    }
    float f1;
    float f2;
    boolean bool;
    label152:
    Rect localRect;
    if (paramBoolean)
    {
      f1 = this.tGT.getBounds().right - this.tGR;
      f2 = this.tGV + f1;
      f1 = Math.max(this.padding + this.tGV, this.tGT.getBounds().right - this.tGQ + this.tGV);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label270;
      }
      bool = true;
      if (!paramBoolean) {
        break label276;
      }
      localRect = this.tGS.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.tGV), 0);
      this.tGS.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(205849);
      return bool;
      f1 = this.tGS.getBounds().left + this.tGR - this.tGV;
      f2 = Math.min(getWidth() - this.padding - this.tGV, this.tGS.getBounds().left + this.tGQ - this.tGV);
      break;
      label270:
      bool = false;
      break label152;
      label276:
      localRect = this.tGT.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat - this.tGV), 0);
      this.tGT.setBounds(localRect);
    }
  }
  
  public final void fXU()
  {
    this.tGP = true;
  }
  
  public final void fXV()
  {
    this.tGP = false;
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(94454);
    int i = this.tGS.getBounds().left;
    AppMethodBeat.o(94454);
    return i;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(94455);
    int i = this.tGT.getBounds().right;
    AppMethodBeat.o(94455);
    return i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94451);
    if (this.tGX > 0.0F)
    {
      float f = getWidth() * this.tGX;
      paramCanvas.drawRect(f - this.tGW * 0.5F, 0.0F, this.tGW * 0.5F + f, getHeight(), this.tGZ);
    }
    if (!this.tGO)
    {
      AppMethodBeat.o(94451);
      return;
    }
    int i = this.tGS.getBounds().centerX();
    int j = this.tGT.getBounds().centerX();
    if ((nk(true)) || (nk(false))) {
      paramCanvas.drawRect(this.padding + this.tHe, this.tHe, getWidth() - this.padding - this.tHe, getBottom() - this.tHe, this.tHc);
    }
    if (this.tGS.getBounds().left > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, i, getHeight(), this.tHb);
    }
    if (this.tGT.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth(), getHeight(), this.tHb);
    }
    paramCanvas.drawLine(i, this.tHa, j, this.tHa, this.borderPaint);
    paramCanvas.drawLine(i, getHeight() - this.tHa, j, getHeight() - this.tHa, this.borderPaint);
    this.tGS.draw(paramCanvas);
    this.tGT.draw(paramCanvas);
    AppMethodBeat.o(94451);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94456);
    if ((this.tHi != null) && (this.tHj != null))
    {
      Rect localRect1 = new Rect(this.tHi.left, this.tHi.top, this.tHi.right, this.tHi.bottom);
      Rect localRect2 = new Rect(this.tHj.left, this.tHj.top, this.tHj.right, this.tHj.bottom);
      this.tGS.setBounds(localRect1);
      this.tGT.setBounds(localRect2);
      this.tGX = 0.0F;
      postInvalidate();
    }
    AppMethodBeat.o(94456);
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(94452);
    if (!this.tGO)
    {
      AppMethodBeat.o(94452);
      return;
    }
    this.tGX = paramFloat;
    invalidate();
    AppMethodBeat.o(94452);
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.LmK = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(205848);
    this.tHb.setColor(paramInt);
    AppMethodBeat.o(205848);
  }
  
  public void setOnSliderTouchListener(n.a parama)
  {
    this.tGN = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.SliderSeekBar
 * JD-Core Version:    0.7.0.1
 */