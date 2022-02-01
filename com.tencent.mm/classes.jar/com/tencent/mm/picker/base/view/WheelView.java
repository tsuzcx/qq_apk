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
  private int Is;
  private int MW;
  private Paint bLZ;
  String content;
  public boolean hYH;
  private Handler handler;
  private GestureDetector irA;
  public com.tencent.mm.picker.base.b.b irB;
  private boolean irC;
  public boolean irD;
  public ScheduledExecutorService irE;
  public ScheduledFuture<?> irF;
  private Paint irG;
  private com.tencent.mm.picker.base.a.b<?> irH;
  private int irI;
  private float irJ;
  private int irK;
  private float irL;
  private float irM;
  private float irN;
  private int irO;
  private int irP;
  private int irQ;
  private int irR;
  private int irS;
  private int irT;
  private float irU;
  private int irV;
  private int irW;
  private int irx;
  private int iry;
  private final int irz;
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
    this.irx = 0;
    this.textColor = Color.rgb(255, 255, 255);
    this.irz = 2;
    this.content = "";
    this.irC = false;
    this.irD = true;
    this.irE = Executors.newSingleThreadScheduledExecutor();
    this.irR = 5;
    this.MW = 0;
    this.irU = 0.0F;
    this.startTime = 0L;
    this.Is = 17;
    this.irW = 0;
    this.rect = new Rect();
    this.textSize = getResources().getDimensionPixelSize(2131166686);
    this.irI = getResources().getDimensionPixelSize(2131166685);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WheelView, 0, 0);
      this.Is = paramAttributeSet.getInt(1, 17);
      this.irK = paramAttributeSet.getColor(0, -2763307);
      paramAttributeSet.recycle();
    }
    this.handler = new com.tencent.mm.picker.base.c.b(this);
    this.irA = new GestureDetector(paramContext, new a(this));
    this.irA.setIsLongpressEnabled(false);
    this.hYH = true;
    this.irN = 0.0F;
    this.irO = -1;
    this.bLZ = new Paint();
    this.bLZ.setColor(this.textColor);
    this.bLZ.setAntiAlias(true);
    this.bLZ.setTextSize(this.textSize);
    this.irG = new Paint();
    this.irG.setColor(this.irK);
    this.irG.setAntiAlias(true);
    setLayerType(2, null);
    AppMethodBeat.o(175306);
  }
  
  private void aME()
  {
    AppMethodBeat.i(175307);
    if (this.irH == null)
    {
      AppMethodBeat.o(175307);
      return;
    }
    this.irJ = (this.irx + getPaddingBottom() + getPaddingTop());
    this.irS = ((int)(this.irJ * this.irR));
    this.irT = View.MeasureSpec.getSize(this.irV);
    this.irL = ((this.irS - this.irJ) / 2.0F);
    this.irM = ((this.irS + this.irJ) / 2.0F);
    if (this.irO == -1) {
      if (!this.hYH) {
        break label141;
      }
    }
    label141:
    for (this.irO = ((this.irH.getItemsCount() + 1) / 2);; this.irO = 0)
    {
      this.irQ = this.irO;
      AppMethodBeat.o(175307);
      return;
    }
  }
  
  private void aMG()
  {
    AppMethodBeat.i(175317);
    Rect localRect = new Rect();
    this.bLZ.getTextBounds(this.content, 0, this.content.length(), localRect);
    localRect = new Rect();
    this.bLZ.getTextBounds(this.content, 0, 0, localRect);
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
      this.bLZ.getTextBounds(this.content, 0, k, localRect);
      if (localRect.width() >= aMH()) {
        j = k - 1;
      } else if (localRect.width() < aMH()) {
        i = k + 1;
      }
    }
    do
    {
      this.content = this.content.substring(0, k);
      if (this.bLZ.measureText(this.content + "...") <= aMH()) {
        break;
      }
      i = k - 1;
      k = i;
    } while (i > 0);
    this.content += "...";
    AppMethodBeat.o(175317);
  }
  
  private int aMH()
  {
    AppMethodBeat.i(175318);
    int i = this.irT;
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(175318);
    return i - j - k;
  }
  
  private void aMI()
  {
    AppMethodBeat.i(175319);
    int i = this.textSize;
    this.bLZ.setTextSize(i);
    while ((i > this.irI) && (!aMJ()))
    {
      i -= 1;
      this.bLZ.setTextSize(i);
    }
    AppMethodBeat.o(175319);
  }
  
  private boolean aMJ()
  {
    AppMethodBeat.i(175320);
    if (this.bLZ.measureText(this.content) <= this.irT - getPaddingLeft() - getPaddingRight())
    {
      AppMethodBeat.o(175320);
      return true;
    }
    AppMethodBeat.o(175320);
    return false;
  }
  
  private static String bZ(Object paramObject)
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
  
  private String qn(int paramInt)
  {
    AppMethodBeat.i(175314);
    int i = paramInt;
    if (this.hYH) {
      i = qo(paramInt);
    }
    String str = this.irH.qk(i);
    AppMethodBeat.o(175314);
    return str;
  }
  
  private int qo(int paramInt)
  {
    AppMethodBeat.i(175315);
    int i;
    if (paramInt < 0) {
      i = qo(this.irH.getItemsCount() + paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(175315);
      return i;
      i = paramInt;
      if (paramInt > this.irH.getItemsCount() - 1) {
        i = qo(paramInt - this.irH.getItemsCount());
      }
    }
  }
  
  public final void a(WheelView.a parama)
  {
    AppMethodBeat.i(175308);
    aMF();
    if ((parama == WheelView.a.irZ) || (parama == WheelView.a.isa))
    {
      this.MW = ((int)((this.irN % this.irJ + this.irJ) % this.irJ));
      if (this.MW <= this.irJ / 2.0F) {
        break label117;
      }
    }
    label117:
    for (this.MW = ((int)(this.irJ - this.MW));; this.MW = (-this.MW))
    {
      this.irF = this.irE.scheduleWithFixedDelay(new c(this, this.MW), 0L, 10L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(175308);
      return;
    }
  }
  
  public final void aMF()
  {
    AppMethodBeat.i(175309);
    if ((this.irF != null) && (!this.irF.isCancelled()))
    {
      this.irF.cancel(true);
      this.irF = null;
    }
    AppMethodBeat.o(175309);
  }
  
  public final com.tencent.mm.picker.base.a.b getAdapter()
  {
    return this.irH;
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(175312);
    if (this.irH == null)
    {
      AppMethodBeat.o(175312);
      return 0;
    }
    if ((this.hYH) && ((this.irP < 0) || (this.irP >= this.irH.getItemsCount())))
    {
      i = Math.max(0, Math.min(Math.abs(Math.abs(this.irP) - this.irH.getItemsCount()), this.irH.getItemsCount() - 1));
      AppMethodBeat.o(175312);
      return i;
    }
    int i = Math.max(0, Math.min(this.irP, this.irH.getItemsCount() - 1));
    AppMethodBeat.o(175312);
    return i;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public int getInitPosition()
  {
    return this.irO;
  }
  
  public float getItemHeight()
  {
    return this.irJ;
  }
  
  public int getItemsCount()
  {
    AppMethodBeat.i(175323);
    if (this.irH != null)
    {
      int i = this.irH.getItemsCount();
      AppMethodBeat.o(175323);
      return i;
    }
    AppMethodBeat.o(175323);
    return 0;
  }
  
  public float getTotalScrollY()
  {
    return this.irN;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(175313);
    super.onDraw(paramCanvas);
    if (this.irH == null)
    {
      AppMethodBeat.o(175313);
      return;
    }
    this.irO = Math.min(Math.max(0, this.irO), this.irH.getItemsCount() - 1);
    Object[] arrayOfObject = new Object[this.irR];
    Object localObject2 = new Object();
    Object localObject1 = new Object();
    int i = (int)(this.irN / this.irJ);
    label1042:
    label1045:
    for (;;)
    {
      try
      {
        j = this.irO;
        this.irQ = (i % this.irH.getItemsCount() + j);
        if (!this.hYH)
        {
          if (this.irQ < 0) {
            this.irQ = 0;
          }
          if (this.irQ > this.irH.getItemsCount() - 1) {
            this.irQ = (this.irH.getItemsCount() - 1);
          }
          f1 = this.irN;
          f2 = this.irJ;
          i = 0;
          if (i >= this.irR) {
            continue;
          }
          j = this.irQ - (this.irR / 2 - i);
          if (i != 0) {
            break label1045;
          }
          localObject2 = qn(j - 1);
          if (i != this.irR - 1) {
            break label1042;
          }
          localObject1 = qn(j + 1);
          arrayOfObject[i] = qn(j);
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
        if (this.irQ < 0) {
          this.irQ = (this.irH.getItemsCount() + this.irQ);
        }
        if (this.irQ <= this.irH.getItemsCount() - 1) {
          continue;
        }
        this.irQ -= this.irH.getItemsCount();
        continue;
        paramCanvas.drawLine(0.0F, this.irL, this.irT, this.irL, this.irG);
        paramCanvas.drawLine(0.0F, this.irM, this.irT, this.irM, this.irG);
        int j = 0;
        if (j < this.irR + 2)
        {
          Object localObject3;
          float f3;
          if (j == 0)
          {
            localObject3 = localObject2;
            f3 = this.irJ * j - f1 % f2 + this.irJ / 2.0F - this.irJ;
            if ((this.irD) || (TextUtils.isEmpty(this.label)) || (TextUtils.isEmpty(bZ(localObject3)))) {
              continue;
            }
            this.content = (bZ(localObject3) + this.label);
            this.bLZ.getTextBounds(this.content, 0, this.content.length(), this.rect);
          }
          int k;
          switch (this.Is)
          {
          default: 
            float f4 = this.irS / 2.0F;
            f4 = Math.abs((f3 - f4) / f4);
            k = (int)((1.0F - new AccelerateInterpolator(0.3F).getInterpolation(f4)) * this.iry);
            if (k < this.iry * 0.14F)
            {
              i = (int)(this.iry * 0.14F);
              this.bLZ.setAlpha(i);
              if ((f3 >= this.irL) && (f3 <= this.irM)) {
                this.irP = (this.irQ - (this.irR / 2 - j) - 1);
              }
              if ((f3 >= 0.0F) && (f3 <= this.irS))
              {
                localObject3 = this.content;
                f4 = this.irW;
                Paint.FontMetricsInt localFontMetricsInt = this.bLZ.getFontMetricsInt();
                float f5 = Math.abs(localFontMetricsInt.top);
                float f6 = localFontMetricsInt.bottom;
                paramCanvas.drawText((String)localObject3, f4, f3 - f6 + (f6 + f5) / 2.0F, this.bLZ);
              }
              j += 1;
              this.bLZ.setTextSize(this.textSize);
              continue;
              if (j == this.irR + 2 - 1)
              {
                localObject3 = localObject1;
                continue;
              }
              localObject3 = arrayOfObject[(j - 1)];
              continue;
              this.content = bZ(localObject3);
            }
            break;
          case 17: 
            if ((this.irC) || (this.label == null) || (this.label.equals("")) || (!this.irD))
            {
              if (this.irT < this.rect.width())
              {
                aMI();
                if (!aMJ()) {
                  aMG();
                }
                this.bLZ.getTextBounds(this.content, 0, this.content.length(), this.rect);
                this.irW = ((int)((this.irT - this.rect.width()) * 0.5D));
                continue;
              }
              this.irW = ((int)((this.irT - this.rect.width()) * 0.5D));
              continue;
            }
            this.irW = ((int)((this.irT - this.rect.width()) * 0.25D));
            break;
          case 3: 
            this.irW = 0;
            break;
          case 5: 
            this.irW = (this.irT - this.rect.width());
            continue;
            i = k;
            if (k <= this.iry) {
              continue;
            }
            i = this.iry;
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
    this.irV = paramInt1;
    aME();
    setMeasuredDimension(this.irT, this.irS);
    AppMethodBeat.o(175321);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(175322);
    boolean bool = this.irA.onTouchEvent(paramMotionEvent);
    float f1 = -this.irO;
    float f2 = this.irJ;
    float f3 = this.irH.getItemsCount() - 1 - this.irO;
    float f4 = this.irJ;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      if (bool) {
        break label348;
      }
      if (System.currentTimeMillis() - this.startTime > 120L)
      {
        a(WheelView.a.isa);
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
        aMF();
        this.irU = paramMotionEvent.getRawY();
        i = 0;
        continue;
        float f5 = this.irU - paramMotionEvent.getRawY();
        this.irU = paramMotionEvent.getRawY();
        this.irN += f5;
        if (this.hYH) {
          break;
        }
        if (((this.irN - this.irJ * 0.25F < f1 * f2) && (f5 < 0.0F)) || ((this.irN + this.irJ * 0.25F > f3 * f4) && (f5 > 0.0F)))
        {
          this.irN -= f5;
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
    int i = (int)(paramMotionEvent.getY() - this.irS / 2.0F);
    if (i > 0) {}
    for (i = (int)(i + this.irJ / 2.0F);; i = (int)(i - this.irJ / 2.0F))
    {
      if (this.irJ != 0.0F)
      {
        this.MW = ((int)((int)(i / this.irJ) * this.irJ));
        a(WheelView.a.irY);
      }
      label348:
      i = 0;
      break;
    }
  }
  
  public final WheelView qp(int paramInt)
  {
    AppMethodBeat.i(175326);
    this.irx = paramInt;
    invalidate();
    AppMethodBeat.o(175326);
    return this;
  }
  
  public final WheelView qq(int paramInt)
  {
    AppMethodBeat.i(175327);
    this.textColor = paramInt;
    this.bLZ.setColor(this.textColor);
    this.iry = ((int)((paramInt >> 24 & 0xFF) / 255.0F * 255.0F));
    AppMethodBeat.o(175327);
    return this;
  }
  
  public final void setAdapter(com.tencent.mm.picker.base.a.b<?> paramb)
  {
    AppMethodBeat.i(175311);
    this.irH = paramb;
    aME();
    invalidate();
    AppMethodBeat.o(175311);
  }
  
  public final void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(175310);
    this.irP = paramInt;
    this.irO = paramInt;
    this.irN = 0.0F;
    invalidate();
    AppMethodBeat.o(175310);
  }
  
  public final void setCyclic(boolean paramBoolean)
  {
    this.hYH = paramBoolean;
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175324);
    if (paramInt != 0)
    {
      this.irK = paramInt;
      this.irG.setColor(this.irK);
    }
    AppMethodBeat.o(175324);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175325);
    this.irG.setStrokeWidth(paramFloat);
    AppMethodBeat.o(175325);
  }
  
  public void setGravity(int paramInt)
  {
    this.Is = paramInt;
  }
  
  public void setIsOptions(boolean paramBoolean)
  {
    this.irC = paramBoolean;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public final void setOnItemSelectedListener(com.tencent.mm.picker.base.b.b paramb)
  {
    this.irB = paramb;
  }
  
  public void setTotalScrollY(float paramFloat)
  {
    this.irN = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.base.view.WheelView
 * JD-Core Version:    0.7.0.1
 */