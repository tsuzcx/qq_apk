package com.tencent.mm.picker.base.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.a.a;
import com.tencent.mm.picker.base.b.a;
import com.tencent.mm.picker.base.c.c;
import com.tencent.stubs.logger.Log;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WheelView
  extends View
{
  private int Hu;
  private int LZ;
  private Paint bOr;
  String content;
  public ScheduledFuture<?> hRA;
  private Paint hRB;
  private com.tencent.mm.picker.base.a.b<?> hRC;
  private int hRD;
  private float hRE;
  private int hRF;
  private float hRG;
  private float hRH;
  private float hRI;
  private int hRJ;
  private int hRK;
  private int hRL;
  private int hRM;
  private int hRN;
  private int hRO;
  private float hRP;
  private int hRQ;
  private int hRR;
  private int hRs;
  private int hRt;
  private final int hRu;
  private GestureDetector hRv;
  public com.tencent.mm.picker.base.b.b hRw;
  private boolean hRx;
  public boolean hRy;
  public ScheduledExecutorService hRz;
  private Handler handler;
  public boolean hyg;
  private String label;
  private Rect rect;
  private long startTime;
  private int textColor;
  private int textSize;
  
  public WheelView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(175306);
    this.hRs = 0;
    this.textColor = Color.rgb(255, 255, 255);
    this.hRu = 2;
    this.content = "";
    this.hRx = false;
    this.hRy = true;
    this.hRz = Executors.newSingleThreadScheduledExecutor();
    this.hRM = 5;
    this.LZ = 0;
    this.hRP = 0.0F;
    this.startTime = 0L;
    this.Hu = 17;
    this.hRR = 0;
    this.rect = new Rect();
    this.textSize = getResources().getDimensionPixelSize(2131166686);
    this.hRD = getResources().getDimensionPixelSize(2131166685);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WheelView, 0, 0);
      this.Hu = paramAttributeSet.getInt(1, 17);
      this.hRF = paramAttributeSet.getColor(0, -2763307);
      paramAttributeSet.recycle();
    }
    this.handler = new com.tencent.mm.picker.base.c.b(this);
    this.hRv = new GestureDetector(paramContext, new a(this));
    this.hRv.setIsLongpressEnabled(false);
    this.hyg = true;
    this.hRI = 0.0F;
    this.hRJ = -1;
    this.bOr = new Paint();
    this.bOr.setColor(this.textColor);
    this.bOr.setAntiAlias(true);
    this.bOr.setTextSize(this.textSize);
    this.hRB = new Paint();
    this.hRB.setColor(this.hRF);
    this.hRB.setAntiAlias(true);
    setLayerType(2, null);
    AppMethodBeat.o(175306);
  }
  
  private void aFR()
  {
    AppMethodBeat.i(175307);
    if (this.hRC == null)
    {
      AppMethodBeat.o(175307);
      return;
    }
    this.hRE = (this.hRs + getPaddingBottom() + getPaddingTop());
    this.hRN = ((int)(this.hRE * this.hRM));
    this.hRO = View.MeasureSpec.getSize(this.hRQ);
    this.hRG = ((this.hRN - this.hRE) / 2.0F);
    this.hRH = ((this.hRN + this.hRE) / 2.0F);
    if (this.hRJ == -1) {
      if (!this.hyg) {
        break label141;
      }
    }
    label141:
    for (this.hRJ = ((this.hRC.getItemsCount() + 1) / 2);; this.hRJ = 0)
    {
      this.hRL = this.hRJ;
      AppMethodBeat.o(175307);
      return;
    }
  }
  
  private void aFT()
  {
    AppMethodBeat.i(175317);
    Rect localRect = new Rect();
    this.bOr.getTextBounds(this.content, 0, this.content.length(), localRect);
    localRect = new Rect();
    this.bOr.getTextBounds(this.content, 0, 0, localRect);
    int j = this.content.length();
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j - i <= 1) {
        break;
      }
      localRect = new Rect();
      k = (j - i >> 1) + i;
      this.bOr.getTextBounds(this.content, 0, k, localRect);
      if (localRect.width() >= aFU()) {
        j = k - 1;
      } else if (localRect.width() < aFU()) {
        i = k + 1;
      }
    }
    do
    {
      this.content = this.content.substring(0, k);
      if (this.bOr.measureText(this.content + "...") <= aFU()) {
        break;
      }
      i = k - 1;
      k = i;
    } while (i > 0);
    this.content += "...";
    AppMethodBeat.o(175317);
  }
  
  private int aFU()
  {
    AppMethodBeat.i(175318);
    int i = this.hRO;
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(175318);
    return i - j - k;
  }
  
  private void aFV()
  {
    AppMethodBeat.i(175319);
    int i = this.textSize;
    this.bOr.setTextSize(i);
    while ((i > this.hRD) && (!aFW()))
    {
      i -= 1;
      this.bOr.setTextSize(i);
    }
    AppMethodBeat.o(175319);
  }
  
  private boolean aFW()
  {
    AppMethodBeat.i(175320);
    if (this.bOr.measureText(this.content) <= this.hRO - getPaddingLeft() - getPaddingRight())
    {
      AppMethodBeat.o(175320);
      return true;
    }
    AppMethodBeat.o(175320);
    return false;
  }
  
  private static String cc(Object paramObject)
  {
    AppMethodBeat.i(175316);
    if (paramObject == null)
    {
      AppMethodBeat.o(175316);
      return "";
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(175316);
    return paramObject;
  }
  
  private String pA(int paramInt)
  {
    AppMethodBeat.i(175314);
    int i = paramInt;
    if (this.hyg) {
      i = pB(paramInt);
    }
    String str = this.hRC.pw(i);
    AppMethodBeat.o(175314);
    return str;
  }
  
  private int pB(int paramInt)
  {
    AppMethodBeat.i(175315);
    int i;
    if (paramInt < 0) {
      i = pB(this.hRC.getItemsCount() + paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(175315);
      return i;
      i = paramInt;
      if (paramInt > this.hRC.getItemsCount() - 1) {
        i = pB(paramInt - this.hRC.getItemsCount());
      }
    }
  }
  
  public final void a(WheelView.a parama)
  {
    AppMethodBeat.i(175308);
    aFS();
    if ((parama == WheelView.a.hRU) || (parama == WheelView.a.hRV))
    {
      this.LZ = ((int)((this.hRI % this.hRE + this.hRE) % this.hRE));
      if (this.LZ <= this.hRE / 2.0F) {
        break label117;
      }
    }
    label117:
    for (this.LZ = ((int)(this.hRE - this.LZ));; this.LZ = (-this.LZ))
    {
      this.hRA = this.hRz.scheduleWithFixedDelay(new c(this, this.LZ), 0L, 10L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(175308);
      return;
    }
  }
  
  public final void aFS()
  {
    AppMethodBeat.i(175309);
    if ((this.hRA != null) && (!this.hRA.isCancelled()))
    {
      this.hRA.cancel(true);
      this.hRA = null;
    }
    AppMethodBeat.o(175309);
  }
  
  public final com.tencent.mm.picker.base.a.b getAdapter()
  {
    return this.hRC;
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(175312);
    if (this.hRC == null)
    {
      AppMethodBeat.o(175312);
      return 0;
    }
    if ((this.hyg) && ((this.hRK < 0) || (this.hRK >= this.hRC.getItemsCount())))
    {
      i = Math.max(0, Math.min(Math.abs(Math.abs(this.hRK) - this.hRC.getItemsCount()), this.hRC.getItemsCount() - 1));
      AppMethodBeat.o(175312);
      return i;
    }
    int i = Math.max(0, Math.min(this.hRK, this.hRC.getItemsCount() - 1));
    AppMethodBeat.o(175312);
    return i;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public int getInitPosition()
  {
    return this.hRJ;
  }
  
  public float getItemHeight()
  {
    return this.hRE;
  }
  
  public int getItemsCount()
  {
    AppMethodBeat.i(175323);
    if (this.hRC != null)
    {
      int i = this.hRC.getItemsCount();
      AppMethodBeat.o(175323);
      return i;
    }
    AppMethodBeat.o(175323);
    return 0;
  }
  
  public float getTotalScrollY()
  {
    return this.hRI;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(175313);
    super.onDraw(paramCanvas);
    if (this.hRC == null)
    {
      AppMethodBeat.o(175313);
      return;
    }
    this.hRJ = Math.min(Math.max(0, this.hRJ), this.hRC.getItemsCount() - 1);
    Object[] arrayOfObject = new Object[this.hRM];
    Object localObject2 = new Object();
    Object localObject1 = new Object();
    int i = (int)(this.hRI / this.hRE);
    label1042:
    label1045:
    for (;;)
    {
      try
      {
        j = this.hRJ;
        this.hRL = (i % this.hRC.getItemsCount() + j);
        if (!this.hyg)
        {
          if (this.hRL < 0) {
            this.hRL = 0;
          }
          if (this.hRL > this.hRC.getItemsCount() - 1) {
            this.hRL = (this.hRC.getItemsCount() - 1);
          }
          f1 = this.hRI;
          f2 = this.hRE;
          i = 0;
          if (i >= this.hRM) {
            continue;
          }
          j = this.hRL - (this.hRM / 2 - i);
          if (i != 0) {
            break label1045;
          }
          localObject2 = pA(j - 1);
          if (i != this.hRM - 1) {
            break label1042;
          }
          localObject1 = pA(j + 1);
          arrayOfObject[i] = pA(j);
          i += 1;
          continue;
        }
      }
      catch (ArithmeticException localArithmeticException)
      {
        float f1;
        float f2;
        Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        continue;
        if (this.hRL < 0) {
          this.hRL = (this.hRC.getItemsCount() + this.hRL);
        }
        if (this.hRL <= this.hRC.getItemsCount() - 1) {
          continue;
        }
        this.hRL -= this.hRC.getItemsCount();
        continue;
        paramCanvas.drawLine(0.0F, this.hRG, this.hRO, this.hRG, this.hRB);
        paramCanvas.drawLine(0.0F, this.hRH, this.hRO, this.hRH, this.hRB);
        int j = 0;
        if (j < this.hRM + 2)
        {
          Object localObject3;
          float f3;
          if (j == 0)
          {
            localObject3 = localObject2;
            f3 = this.hRE * j - f1 % f2 + this.hRE / 2.0F - this.hRE;
            if ((this.hRy) || (TextUtils.isEmpty(this.label)) || (TextUtils.isEmpty(cc(localObject3)))) {
              continue;
            }
            this.content = (cc(localObject3) + this.label);
            this.bOr.getTextBounds(this.content, 0, this.content.length(), this.rect);
          }
          int k;
          switch (this.Hu)
          {
          default: 
            float f4 = this.hRN / 2.0F;
            f4 = Math.abs((f3 - f4) / f4);
            k = (int)((1.0F - new AccelerateInterpolator(0.3F).getInterpolation(f4)) * this.hRt);
            if (k < this.hRt * 0.14F)
            {
              i = (int)(this.hRt * 0.14F);
              this.bOr.setAlpha(i);
              if ((f3 >= this.hRG) && (f3 <= this.hRH)) {
                this.hRK = (this.hRL - (this.hRM / 2 - j) - 1);
              }
              if ((f3 >= 0.0F) && (f3 <= this.hRN))
              {
                localObject3 = this.content;
                f4 = this.hRR;
                Paint.FontMetricsInt localFontMetricsInt = this.bOr.getFontMetricsInt();
                float f5 = Math.abs(localFontMetricsInt.top);
                float f6 = localFontMetricsInt.bottom;
                paramCanvas.drawText((String)localObject3, f4, f3 - f6 + (f6 + f5) / 2.0F, this.bOr);
              }
              j += 1;
              this.bOr.setTextSize(this.textSize);
              continue;
              if (j == this.hRM + 2 - 1)
              {
                localObject3 = localObject1;
                continue;
              }
              localObject3 = arrayOfObject[(j - 1)];
              continue;
              this.content = cc(localObject3);
            }
            break;
          case 17: 
            if ((this.hRx) || (this.label == null) || (this.label.equals("")) || (!this.hRy))
            {
              if (this.hRO < this.rect.width())
              {
                aFV();
                if (!aFW()) {
                  aFT();
                }
                this.bOr.getTextBounds(this.content, 0, this.content.length(), this.rect);
                this.hRR = ((int)((this.hRO - this.rect.width()) * 0.5D));
                continue;
              }
              this.hRR = ((int)((this.hRO - this.rect.width()) * 0.5D));
              continue;
            }
            this.hRR = ((int)((this.hRO - this.rect.width()) * 0.25D));
            break;
          case 3: 
            this.hRR = 0;
            break;
          case 5: 
            this.hRR = (this.hRO - this.rect.width());
            continue;
            i = k;
            if (k <= this.hRt) {
              continue;
            }
            i = this.hRt;
            break;
          }
        }
        AppMethodBeat.o(175313);
        return;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175321);
    this.hRQ = paramInt1;
    aFR();
    setMeasuredDimension(this.hRO, this.hRN);
    AppMethodBeat.o(175321);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(175322);
    boolean bool = this.hRv.onTouchEvent(paramMotionEvent);
    float f1 = -this.hRJ;
    float f2 = this.hRE;
    float f3 = this.hRC.getItemsCount() - 1 - this.hRJ;
    float f4 = this.hRE;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      if (bool) {
        break label348;
      }
      if (System.currentTimeMillis() - this.startTime > 120L)
      {
        a(WheelView.a.hRV);
        i = 0;
      }
      break;
    case 0: 
    case 2: 
      for (;;)
      {
        if ((i == 0) && (paramMotionEvent.getAction() != 0)) {
          invalidate();
        }
        AppMethodBeat.o(175322);
        return true;
        this.startTime = System.currentTimeMillis();
        aFS();
        this.hRP = paramMotionEvent.getRawY();
        i = 0;
        continue;
        float f5 = this.hRP - paramMotionEvent.getRawY();
        this.hRP = paramMotionEvent.getRawY();
        this.hRI += f5;
        if (this.hyg) {
          break;
        }
        if (((this.hRI - this.hRE * 0.25F < f1 * f2) && (f5 < 0.0F)) || ((this.hRI + this.hRE * 0.25F > f3 * f4) && (f5 > 0.0F)))
        {
          this.hRI -= f5;
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
    int i = (int)(paramMotionEvent.getY() - this.hRN / 2.0F);
    if (i > 0) {}
    for (i = (int)(i + this.hRE / 2.0F);; i = (int)(i - this.hRE / 2.0F))
    {
      if (this.hRE != 0.0F)
      {
        this.LZ = ((int)((int)(i / this.hRE) * this.hRE));
        a(WheelView.a.hRT);
      }
      label348:
      i = 0;
      break;
    }
  }
  
  public final WheelView pC(int paramInt)
  {
    AppMethodBeat.i(175326);
    this.hRs = paramInt;
    invalidate();
    AppMethodBeat.o(175326);
    return this;
  }
  
  public final WheelView pD(int paramInt)
  {
    AppMethodBeat.i(175327);
    this.textColor = paramInt;
    this.bOr.setColor(this.textColor);
    this.hRt = ((int)((paramInt >> 24 & 0xFF) / 255.0F * 255.0F));
    AppMethodBeat.o(175327);
    return this;
  }
  
  public final void setAdapter(com.tencent.mm.picker.base.a.b<?> paramb)
  {
    AppMethodBeat.i(175311);
    this.hRC = paramb;
    aFR();
    invalidate();
    AppMethodBeat.o(175311);
  }
  
  public final void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(175310);
    this.hRK = paramInt;
    this.hRJ = paramInt;
    this.hRI = 0.0F;
    invalidate();
    AppMethodBeat.o(175310);
  }
  
  public final void setCyclic(boolean paramBoolean)
  {
    this.hyg = paramBoolean;
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175324);
    if (paramInt != 0)
    {
      this.hRF = paramInt;
      this.hRB.setColor(this.hRF);
    }
    AppMethodBeat.o(175324);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175325);
    this.hRB.setStrokeWidth(paramFloat);
    AppMethodBeat.o(175325);
  }
  
  public void setGravity(int paramInt)
  {
    this.Hu = paramInt;
  }
  
  public void setIsOptions(boolean paramBoolean)
  {
    this.hRx = paramBoolean;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public final void setOnItemSelectedListener(com.tencent.mm.picker.base.b.b paramb)
  {
    this.hRw = paramb;
  }
  
  public void setTotalScrollY(float paramFloat)
  {
    this.hRI = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.base.view.WheelView
 * JD-Core Version:    0.7.0.1
 */