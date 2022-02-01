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
import com.tencent.mm.picker.base.c.c;
import com.tencent.stubs.logger.Log;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WheelView
  extends View
{
  private int Kk;
  private Paint bWm;
  String content;
  private int fq;
  private Handler handler;
  public ScheduledExecutorService iNA;
  public ScheduledFuture<?> iNB;
  private Paint iNC;
  private com.tencent.mm.picker.base.a.b<?> iND;
  private int iNE;
  private float iNF;
  private int iNG;
  private float iNH;
  private float iNI;
  private float iNJ;
  private int iNK;
  private int iNL;
  private int iNM;
  private int iNN;
  private int iNO;
  private int iNP;
  private float iNQ;
  private int iNR;
  private int iNS;
  private int iNt;
  private int iNu;
  private final int iNv;
  private GestureDetector iNw;
  public com.tencent.mm.picker.base.b.b iNx;
  private boolean iNy;
  public boolean iNz;
  public boolean iuX;
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
    this.iNt = 0;
    this.textColor = Color.rgb(255, 255, 255);
    this.iNv = 2;
    this.content = "";
    this.iNy = false;
    this.iNz = true;
    this.iNA = Executors.newSingleThreadScheduledExecutor();
    this.iNN = 5;
    this.fq = 0;
    this.iNQ = 0.0F;
    this.startTime = 0L;
    this.Kk = 17;
    this.iNS = 0;
    this.rect = new Rect();
    this.textSize = getResources().getDimensionPixelSize(2131166686);
    this.iNE = getResources().getDimensionPixelSize(2131166685);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WheelView, 0, 0);
      this.Kk = paramAttributeSet.getInt(1, 17);
      this.iNG = paramAttributeSet.getColor(0, -2763307);
      paramAttributeSet.recycle();
    }
    this.handler = new com.tencent.mm.picker.base.c.b(this);
    this.iNw = new GestureDetector(paramContext, new com.tencent.mm.picker.base.b.a(this));
    this.iNw.setIsLongpressEnabled(false);
    this.iuX = true;
    this.iNJ = 0.0F;
    this.iNK = -1;
    this.bWm = new Paint();
    this.bWm.setColor(this.textColor);
    this.bWm.setAntiAlias(true);
    this.bWm.setTextSize(this.textSize);
    this.iNC = new Paint();
    this.iNC.setColor(this.iNG);
    this.iNC.setAntiAlias(true);
    setLayerType(2, null);
    AppMethodBeat.o(175306);
  }
  
  private void aQo()
  {
    AppMethodBeat.i(175307);
    if (this.iND == null)
    {
      AppMethodBeat.o(175307);
      return;
    }
    this.iNF = (this.iNt + getPaddingBottom() + getPaddingTop());
    this.iNO = ((int)(this.iNF * this.iNN));
    this.iNP = View.MeasureSpec.getSize(this.iNR);
    this.iNH = ((this.iNO - this.iNF) / 2.0F);
    this.iNI = ((this.iNO + this.iNF) / 2.0F);
    if (this.iNK == -1) {
      if (!this.iuX) {
        break label141;
      }
    }
    label141:
    for (this.iNK = ((this.iND.getItemsCount() + 1) / 2);; this.iNK = 0)
    {
      this.iNM = this.iNK;
      AppMethodBeat.o(175307);
      return;
    }
  }
  
  private void aQq()
  {
    AppMethodBeat.i(175317);
    Rect localRect = new Rect();
    this.bWm.getTextBounds(this.content, 0, this.content.length(), localRect);
    localRect = new Rect();
    this.bWm.getTextBounds(this.content, 0, 0, localRect);
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
      this.bWm.getTextBounds(this.content, 0, k, localRect);
      if (localRect.width() >= aQr()) {
        j = k - 1;
      } else if (localRect.width() < aQr()) {
        i = k + 1;
      }
    }
    do
    {
      this.content = this.content.substring(0, k);
      if (this.bWm.measureText(this.content + "...") <= aQr()) {
        break;
      }
      i = k - 1;
      k = i;
    } while (i > 0);
    this.content += "...";
    AppMethodBeat.o(175317);
  }
  
  private int aQr()
  {
    AppMethodBeat.i(175318);
    int i = this.iNP;
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(175318);
    return i - j - k;
  }
  
  private void aQs()
  {
    AppMethodBeat.i(175319);
    int i = this.textSize;
    this.bWm.setTextSize(i);
    while ((i > this.iNE) && (!aQt()))
    {
      i -= 1;
      this.bWm.setTextSize(i);
    }
    AppMethodBeat.o(175319);
  }
  
  private boolean aQt()
  {
    AppMethodBeat.i(175320);
    if (this.bWm.measureText(this.content) <= this.iNP - getPaddingLeft() - getPaddingRight())
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
  
  private String qQ(int paramInt)
  {
    AppMethodBeat.i(175314);
    int i = paramInt;
    if (this.iuX) {
      i = qR(paramInt);
    }
    String str = this.iND.qO(i);
    AppMethodBeat.o(175314);
    return str;
  }
  
  private int qR(int paramInt)
  {
    AppMethodBeat.i(175315);
    int i;
    if (paramInt < 0) {
      i = qR(this.iND.getItemsCount() + paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(175315);
      return i;
      i = paramInt;
      if (paramInt > this.iND.getItemsCount() - 1) {
        i = qR(paramInt - this.iND.getItemsCount());
      }
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(175308);
    aQp();
    if ((parama == a.iNV) || (parama == a.iNW))
    {
      this.fq = ((int)((this.iNJ % this.iNF + this.iNF) % this.iNF));
      if (this.fq <= this.iNF / 2.0F) {
        break label117;
      }
    }
    label117:
    for (this.fq = ((int)(this.iNF - this.fq));; this.fq = (-this.fq))
    {
      this.iNB = this.iNA.scheduleWithFixedDelay(new c(this, this.fq), 0L, 10L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(175308);
      return;
    }
  }
  
  public final void aQp()
  {
    AppMethodBeat.i(175309);
    if ((this.iNB != null) && (!this.iNB.isCancelled()))
    {
      this.iNB.cancel(true);
      this.iNB = null;
    }
    AppMethodBeat.o(175309);
  }
  
  public final com.tencent.mm.picker.base.a.b getAdapter()
  {
    return this.iND;
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(175312);
    if (this.iND == null)
    {
      AppMethodBeat.o(175312);
      return 0;
    }
    if ((this.iuX) && ((this.iNL < 0) || (this.iNL >= this.iND.getItemsCount())))
    {
      i = Math.max(0, Math.min(Math.abs(Math.abs(this.iNL) - this.iND.getItemsCount()), this.iND.getItemsCount() - 1));
      AppMethodBeat.o(175312);
      return i;
    }
    int i = Math.max(0, Math.min(this.iNL, this.iND.getItemsCount() - 1));
    AppMethodBeat.o(175312);
    return i;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public int getInitPosition()
  {
    return this.iNK;
  }
  
  public float getItemHeight()
  {
    return this.iNF;
  }
  
  public int getItemsCount()
  {
    AppMethodBeat.i(175323);
    if (this.iND != null)
    {
      int i = this.iND.getItemsCount();
      AppMethodBeat.o(175323);
      return i;
    }
    AppMethodBeat.o(175323);
    return 0;
  }
  
  public float getTotalScrollY()
  {
    return this.iNJ;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(175313);
    super.onDraw(paramCanvas);
    if (this.iND == null)
    {
      AppMethodBeat.o(175313);
      return;
    }
    this.iNK = Math.min(Math.max(0, this.iNK), this.iND.getItemsCount() - 1);
    Object[] arrayOfObject = new Object[this.iNN];
    Object localObject2 = new Object();
    Object localObject1 = new Object();
    int i = (int)(this.iNJ / this.iNF);
    label1042:
    label1045:
    for (;;)
    {
      try
      {
        j = this.iNK;
        this.iNM = (i % this.iND.getItemsCount() + j);
        if (!this.iuX)
        {
          if (this.iNM < 0) {
            this.iNM = 0;
          }
          if (this.iNM > this.iND.getItemsCount() - 1) {
            this.iNM = (this.iND.getItemsCount() - 1);
          }
          f1 = this.iNJ;
          f2 = this.iNF;
          i = 0;
          if (i >= this.iNN) {
            continue;
          }
          j = this.iNM - (this.iNN / 2 - i);
          if (i != 0) {
            break label1045;
          }
          localObject2 = qQ(j - 1);
          if (i != this.iNN - 1) {
            break label1042;
          }
          localObject1 = qQ(j + 1);
          arrayOfObject[i] = qQ(j);
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
        if (this.iNM < 0) {
          this.iNM = (this.iND.getItemsCount() + this.iNM);
        }
        if (this.iNM <= this.iND.getItemsCount() - 1) {
          continue;
        }
        this.iNM -= this.iND.getItemsCount();
        continue;
        paramCanvas.drawLine(0.0F, this.iNH, this.iNP, this.iNH, this.iNC);
        paramCanvas.drawLine(0.0F, this.iNI, this.iNP, this.iNI, this.iNC);
        int j = 0;
        if (j < this.iNN + 2)
        {
          Object localObject3;
          float f3;
          if (j == 0)
          {
            localObject3 = localObject2;
            f3 = this.iNF * j - f1 % f2 + this.iNF / 2.0F - this.iNF;
            if ((this.iNz) || (TextUtils.isEmpty(this.label)) || (TextUtils.isEmpty(cc(localObject3)))) {
              continue;
            }
            this.content = (cc(localObject3) + this.label);
            this.bWm.getTextBounds(this.content, 0, this.content.length(), this.rect);
          }
          int k;
          switch (this.Kk)
          {
          default: 
            float f4 = this.iNO / 2.0F;
            f4 = Math.abs((f3 - f4) / f4);
            k = (int)((1.0F - new AccelerateInterpolator(0.3F).getInterpolation(f4)) * this.iNu);
            if (k < this.iNu * 0.14F)
            {
              i = (int)(this.iNu * 0.14F);
              this.bWm.setAlpha(i);
              if ((f3 >= this.iNH) && (f3 <= this.iNI)) {
                this.iNL = (this.iNM - (this.iNN / 2 - j) - 1);
              }
              if ((f3 >= 0.0F) && (f3 <= this.iNO))
              {
                localObject3 = this.content;
                f4 = this.iNS;
                Paint.FontMetricsInt localFontMetricsInt = this.bWm.getFontMetricsInt();
                float f5 = Math.abs(localFontMetricsInt.top);
                float f6 = localFontMetricsInt.bottom;
                paramCanvas.drawText((String)localObject3, f4, f3 - f6 + (f6 + f5) / 2.0F, this.bWm);
              }
              j += 1;
              this.bWm.setTextSize(this.textSize);
              continue;
              if (j == this.iNN + 2 - 1)
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
            if ((this.iNy) || (this.label == null) || (this.label.equals("")) || (!this.iNz))
            {
              if (this.iNP < this.rect.width())
              {
                aQs();
                if (!aQt()) {
                  aQq();
                }
                this.bWm.getTextBounds(this.content, 0, this.content.length(), this.rect);
                this.iNS = ((int)((this.iNP - this.rect.width()) * 0.5D));
                continue;
              }
              this.iNS = ((int)((this.iNP - this.rect.width()) * 0.5D));
              continue;
            }
            this.iNS = ((int)((this.iNP - this.rect.width()) * 0.25D));
            break;
          case 3: 
            this.iNS = 0;
            break;
          case 5: 
            this.iNS = (this.iNP - this.rect.width());
            continue;
            i = k;
            if (k <= this.iNu) {
              continue;
            }
            i = this.iNu;
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
    this.iNR = paramInt1;
    aQo();
    setMeasuredDimension(this.iNP, this.iNO);
    AppMethodBeat.o(175321);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(175322);
    GestureDetector localGestureDetector = this.iNw;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahE(), "com/tencent/mm/picker/base/view/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/picker/base/view/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1 = -this.iNK;
    float f2 = this.iNF;
    float f3 = this.iND.getItemsCount() - 1 - this.iNK;
    float f4 = this.iNF;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      if (bool) {
        break label424;
      }
      if (System.currentTimeMillis() - this.startTime > 120L)
      {
        a(a.iNW);
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
        aQp();
        this.iNQ = paramMotionEvent.getRawY();
        i = 0;
        continue;
        float f5 = this.iNQ - paramMotionEvent.getRawY();
        this.iNQ = paramMotionEvent.getRawY();
        this.iNJ += f5;
        if (this.iuX) {
          break;
        }
        if (((this.iNJ - this.iNF * 0.25F < f1 * f2) && (f5 < 0.0F)) || ((this.iNJ + this.iNF * 0.25F > f3 * f4) && (f5 > 0.0F)))
        {
          this.iNJ -= f5;
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
    int i = (int)(paramMotionEvent.getY() - this.iNO / 2.0F);
    if (i > 0) {}
    for (i = (int)(i + this.iNF / 2.0F);; i = (int)(i - this.iNF / 2.0F))
    {
      if (this.iNF != 0.0F)
      {
        this.fq = ((int)((int)(i / this.iNF) * this.iNF));
        a(a.iNU);
      }
      label424:
      i = 0;
      break;
    }
  }
  
  public final WheelView qS(int paramInt)
  {
    AppMethodBeat.i(175326);
    this.iNt = paramInt;
    invalidate();
    AppMethodBeat.o(175326);
    return this;
  }
  
  public final WheelView qT(int paramInt)
  {
    AppMethodBeat.i(175327);
    this.textColor = paramInt;
    this.bWm.setColor(this.textColor);
    this.iNu = ((int)((paramInt >> 24 & 0xFF) / 255.0F * 255.0F));
    AppMethodBeat.o(175327);
    return this;
  }
  
  public final void setAdapter(com.tencent.mm.picker.base.a.b<?> paramb)
  {
    AppMethodBeat.i(175311);
    this.iND = paramb;
    aQo();
    invalidate();
    AppMethodBeat.o(175311);
  }
  
  public final void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(175310);
    this.iNL = paramInt;
    this.iNK = paramInt;
    this.iNJ = 0.0F;
    invalidate();
    AppMethodBeat.o(175310);
  }
  
  public final void setCyclic(boolean paramBoolean)
  {
    this.iuX = paramBoolean;
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175324);
    if (paramInt != 0)
    {
      this.iNG = paramInt;
      this.iNC.setColor(this.iNG);
    }
    AppMethodBeat.o(175324);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175325);
    this.iNC.setStrokeWidth(paramFloat);
    AppMethodBeat.o(175325);
  }
  
  public void setGravity(int paramInt)
  {
    this.Kk = paramInt;
  }
  
  public void setIsOptions(boolean paramBoolean)
  {
    this.iNy = paramBoolean;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public final void setOnItemSelectedListener(com.tencent.mm.picker.base.b.b paramb)
  {
    this.iNx = paramb;
  }
  
  public void setTotalScrollY(float paramFloat)
  {
    this.iNJ = paramFloat;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(175302);
      iNU = new a("CLICK", 0);
      iNV = new a("FLING", 1);
      iNW = new a("DAGGLE", 2);
      iNX = new a[] { iNU, iNV, iNW };
      AppMethodBeat.o(175302);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.base.view.WheelView
 * JD-Core Version:    0.7.0.1
 */