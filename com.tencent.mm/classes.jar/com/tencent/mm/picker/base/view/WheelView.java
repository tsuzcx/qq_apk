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
import com.tencent.mm.picker.base.c.d;
import com.tencent.mm.picker.base.c.e;
import com.tencent.stubs.logger.Log;
import java.util.concurrent.Future;

public class WheelView
  extends View
{
  private int Ku;
  private Paint cgU;
  String content;
  private int fs;
  private Handler handler;
  private int jKA;
  private int jKB;
  private int jKC;
  private int jKD;
  private float jKE;
  private int jKF;
  private int jKG;
  private int jKh;
  private int jKi;
  private final int jKj;
  private GestureDetector jKk;
  public com.tencent.mm.picker.base.b.b jKl;
  private boolean jKm;
  public boolean jKn;
  public final com.tencent.mm.picker.base.c.b jKo;
  public Future<?> jKp;
  private Paint jKq;
  private com.tencent.mm.picker.base.a.b<?> jKr;
  private int jKs;
  private float jKt;
  private int jKu;
  private float jKv;
  private float jKw;
  private float jKx;
  private int jKy;
  private int jKz;
  public boolean jqj;
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
    this.jKh = 0;
    this.textColor = Color.rgb(255, 255, 255);
    this.jKj = 2;
    this.content = "";
    this.jKm = false;
    this.jKn = true;
    if (com.tencent.mm.picker.c.a.jKQ == null) {
      com.tencent.mm.picker.c.a.jKQ = new com.tencent.mm.picker.base.c.a();
    }
    this.jKo = com.tencent.mm.picker.c.a.jKQ;
    this.jKB = 5;
    this.fs = 0;
    this.jKE = 0.0F;
    this.startTime = 0L;
    this.Ku = 17;
    this.jKG = 0;
    this.rect = new Rect();
    this.textSize = getResources().getDimensionPixelSize(2131166806);
    this.jKs = getResources().getDimensionPixelSize(2131166805);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.WheelView, 0, 0);
      this.Ku = paramAttributeSet.getInt(1, 17);
      this.jKu = paramAttributeSet.getColor(0, -2763307);
      paramAttributeSet.recycle();
    }
    this.handler = new d(this);
    this.jKk = new GestureDetector(paramContext, new com.tencent.mm.picker.base.b.a(this));
    this.jKk.setIsLongpressEnabled(false);
    this.jqj = true;
    this.jKx = 0.0F;
    this.jKy = -1;
    this.cgU = new Paint();
    this.cgU.setColor(this.textColor);
    this.cgU.setAntiAlias(true);
    this.cgU.setTextSize(this.textSize);
    this.jKq = new Paint();
    this.jKq.setColor(this.jKu);
    this.jKq.setAntiAlias(true);
    setLayerType(2, null);
    AppMethodBeat.o(175306);
  }
  
  private void bkT()
  {
    AppMethodBeat.i(175307);
    if (this.jKr == null)
    {
      AppMethodBeat.o(175307);
      return;
    }
    this.jKt = (this.jKh + getPaddingBottom() + getPaddingTop());
    this.jKC = ((int)(this.jKt * this.jKB));
    this.jKD = View.MeasureSpec.getSize(this.jKF);
    this.jKv = ((this.jKC - this.jKt) / 2.0F);
    this.jKw = ((this.jKC + this.jKt) / 2.0F);
    if (this.jKy == -1) {
      if (!this.jqj) {
        break label141;
      }
    }
    label141:
    for (this.jKy = ((this.jKr.getItemsCount() + 1) / 2);; this.jKy = 0)
    {
      this.jKA = this.jKy;
      AppMethodBeat.o(175307);
      return;
    }
  }
  
  private void bkV()
  {
    AppMethodBeat.i(175317);
    Rect localRect = new Rect();
    this.cgU.getTextBounds(this.content, 0, this.content.length(), localRect);
    localRect = new Rect();
    this.cgU.getTextBounds(this.content, 0, 0, localRect);
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
      this.cgU.getTextBounds(this.content, 0, k, localRect);
      if (localRect.width() >= bkW()) {
        j = k - 1;
      } else if (localRect.width() < bkW()) {
        i = k + 1;
      }
    }
    do
    {
      this.content = this.content.substring(0, k);
      if (this.cgU.measureText(this.content + "...") <= bkW()) {
        break;
      }
      i = k - 1;
      k = i;
    } while (i > 0);
    this.content += "...";
    AppMethodBeat.o(175317);
  }
  
  private int bkW()
  {
    AppMethodBeat.i(175318);
    int i = this.jKD;
    int j = getPaddingLeft();
    int k = getPaddingRight();
    AppMethodBeat.o(175318);
    return i - j - k;
  }
  
  private void bkX()
  {
    AppMethodBeat.i(175319);
    int i = this.textSize;
    this.cgU.setTextSize(i);
    while ((i > this.jKs) && (!bkY()))
    {
      i -= 1;
      this.cgU.setTextSize(i);
    }
    AppMethodBeat.o(175319);
  }
  
  private boolean bkY()
  {
    AppMethodBeat.i(175320);
    if (this.cgU.measureText(this.content) <= this.jKD - getPaddingLeft() - getPaddingRight())
    {
      AppMethodBeat.o(175320);
      return true;
    }
    AppMethodBeat.o(175320);
    return false;
  }
  
  private static String cl(Object paramObject)
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
  
  private String uI(int paramInt)
  {
    AppMethodBeat.i(175314);
    int i = paramInt;
    if (this.jqj) {
      i = uJ(paramInt);
    }
    String str = this.jKr.uG(i);
    AppMethodBeat.o(175314);
    return str;
  }
  
  private int uJ(int paramInt)
  {
    AppMethodBeat.i(175315);
    int i;
    if (paramInt < 0) {
      i = uJ(this.jKr.getItemsCount() + paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(175315);
      return i;
      i = paramInt;
      if (paramInt > this.jKr.getItemsCount() - 1) {
        i = uJ(paramInt - this.jKr.getItemsCount());
      }
    }
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(175308);
    bkU();
    if ((parama == a.jKJ) || (parama == a.jKK))
    {
      this.fs = ((int)((this.jKx % this.jKt + this.jKt) % this.jKt));
      if (this.fs <= this.jKt / 2.0F) {
        break label113;
      }
    }
    label113:
    for (this.fs = ((int)(this.jKt - this.fs));; this.fs = (-this.fs))
    {
      this.jKp = this.jKo.h(new e(this, this.fs), 10L);
      AppMethodBeat.o(175308);
      return;
    }
  }
  
  public final void bkU()
  {
    AppMethodBeat.i(175309);
    if ((this.jKp != null) && (!this.jKp.isCancelled()))
    {
      this.jKp.cancel(true);
      this.jKp = null;
    }
    AppMethodBeat.o(175309);
  }
  
  public final com.tencent.mm.picker.base.a.b getAdapter()
  {
    return this.jKr;
  }
  
  public final int getCurrentItem()
  {
    AppMethodBeat.i(175312);
    if (this.jKr == null)
    {
      AppMethodBeat.o(175312);
      return 0;
    }
    if ((this.jqj) && ((this.jKz < 0) || (this.jKz >= this.jKr.getItemsCount())))
    {
      i = Math.max(0, Math.min(Math.abs(Math.abs(this.jKz) - this.jKr.getItemsCount()), this.jKr.getItemsCount() - 1));
      AppMethodBeat.o(175312);
      return i;
    }
    int i = Math.max(0, Math.min(this.jKz, this.jKr.getItemsCount() - 1));
    AppMethodBeat.o(175312);
    return i;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public int getInitPosition()
  {
    return this.jKy;
  }
  
  public float getItemHeight()
  {
    return this.jKt;
  }
  
  public int getItemsCount()
  {
    AppMethodBeat.i(175323);
    if (this.jKr != null)
    {
      int i = this.jKr.getItemsCount();
      AppMethodBeat.o(175323);
      return i;
    }
    AppMethodBeat.o(175323);
    return 0;
  }
  
  public float getTotalScrollY()
  {
    return this.jKx;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(175313);
    super.onDraw(paramCanvas);
    if (this.jKr == null)
    {
      AppMethodBeat.o(175313);
      return;
    }
    this.jKy = Math.min(Math.max(0, this.jKy), this.jKr.getItemsCount() - 1);
    Object[] arrayOfObject = new Object[this.jKB];
    Object localObject2 = new Object();
    Object localObject1 = new Object();
    int i = (int)(this.jKx / this.jKt);
    label1042:
    label1045:
    for (;;)
    {
      try
      {
        j = this.jKy;
        this.jKA = (i % this.jKr.getItemsCount() + j);
        if (!this.jqj)
        {
          if (this.jKA < 0) {
            this.jKA = 0;
          }
          if (this.jKA > this.jKr.getItemsCount() - 1) {
            this.jKA = (this.jKr.getItemsCount() - 1);
          }
          f1 = this.jKx;
          f2 = this.jKt;
          i = 0;
          if (i >= this.jKB) {
            continue;
          }
          j = this.jKA - (this.jKB / 2 - i);
          if (i != 0) {
            break label1045;
          }
          localObject2 = uI(j - 1);
          if (i != this.jKB - 1) {
            break label1042;
          }
          localObject1 = uI(j + 1);
          arrayOfObject[i] = uI(j);
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
        if (this.jKA < 0) {
          this.jKA = (this.jKr.getItemsCount() + this.jKA);
        }
        if (this.jKA <= this.jKr.getItemsCount() - 1) {
          continue;
        }
        this.jKA -= this.jKr.getItemsCount();
        continue;
        paramCanvas.drawLine(0.0F, this.jKv, this.jKD, this.jKv, this.jKq);
        paramCanvas.drawLine(0.0F, this.jKw, this.jKD, this.jKw, this.jKq);
        int j = 0;
        if (j < this.jKB + 2)
        {
          Object localObject3;
          float f3;
          if (j == 0)
          {
            localObject3 = localObject2;
            f3 = this.jKt * j - f1 % f2 + this.jKt / 2.0F - this.jKt;
            if ((this.jKn) || (TextUtils.isEmpty(this.label)) || (TextUtils.isEmpty(cl(localObject3)))) {
              continue;
            }
            this.content = (cl(localObject3) + this.label);
            this.cgU.getTextBounds(this.content, 0, this.content.length(), this.rect);
          }
          int k;
          switch (this.Ku)
          {
          default: 
            float f4 = this.jKC / 2.0F;
            f4 = Math.abs((f3 - f4) / f4);
            k = (int)((1.0F - new AccelerateInterpolator(0.3F).getInterpolation(f4)) * this.jKi);
            if (k < this.jKi * 0.14F)
            {
              i = (int)(this.jKi * 0.14F);
              this.cgU.setAlpha(i);
              if ((f3 >= this.jKv) && (f3 <= this.jKw)) {
                this.jKz = (this.jKA - (this.jKB / 2 - j) - 1);
              }
              if ((f3 >= 0.0F) && (f3 <= this.jKC))
              {
                localObject3 = this.content;
                f4 = this.jKG;
                Paint.FontMetricsInt localFontMetricsInt = this.cgU.getFontMetricsInt();
                float f5 = Math.abs(localFontMetricsInt.top);
                float f6 = localFontMetricsInt.bottom;
                paramCanvas.drawText((String)localObject3, f4, f3 - f6 + (f6 + f5) / 2.0F, this.cgU);
              }
              j += 1;
              this.cgU.setTextSize(this.textSize);
              continue;
              if (j == this.jKB + 2 - 1)
              {
                localObject3 = localObject1;
                continue;
              }
              localObject3 = arrayOfObject[(j - 1)];
              continue;
              this.content = cl(localObject3);
            }
            break;
          case 17: 
            if ((this.jKm) || (this.label == null) || (this.label.equals("")) || (!this.jKn))
            {
              if (this.jKD < this.rect.width())
              {
                bkX();
                if (!bkY()) {
                  bkV();
                }
                this.cgU.getTextBounds(this.content, 0, this.content.length(), this.rect);
                this.jKG = ((int)((this.jKD - this.rect.width()) * 0.5D));
                continue;
              }
              this.jKG = ((int)((this.jKD - this.rect.width()) * 0.5D));
              continue;
            }
            this.jKG = ((int)((this.jKD - this.rect.width()) * 0.25D));
            break;
          case 3: 
            this.jKG = 0;
            break;
          case 5: 
            this.jKG = (this.jKD - this.rect.width());
            continue;
            i = k;
            if (k <= this.jKi) {
              continue;
            }
            i = this.jKi;
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
    this.jKF = paramInt1;
    bkT();
    setMeasuredDimension(this.jKD, this.jKC);
    AppMethodBeat.o(175321);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(175322);
    GestureDetector localGestureDetector = this.jKk;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.axQ(), "com/tencent/mm/picker/base/view/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/picker/base/view/WheelView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1 = -this.jKy;
    float f2 = this.jKt;
    float f3 = this.jKr.getItemsCount() - 1 - this.jKy;
    float f4 = this.jKt;
    switch (paramMotionEvent.getAction())
    {
    case 1: 
    default: 
      if (bool) {
        break label424;
      }
      if (System.currentTimeMillis() - this.startTime > 120L)
      {
        a(a.jKK);
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
        bkU();
        this.jKE = paramMotionEvent.getRawY();
        i = 0;
        continue;
        float f5 = this.jKE - paramMotionEvent.getRawY();
        this.jKE = paramMotionEvent.getRawY();
        this.jKx += f5;
        if (this.jqj) {
          break;
        }
        if (((this.jKx - this.jKt * 0.25F < f1 * f2) && (f5 < 0.0F)) || ((this.jKx + this.jKt * 0.25F > f3 * f4) && (f5 > 0.0F)))
        {
          this.jKx -= f5;
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
    int i = (int)(paramMotionEvent.getY() - this.jKC / 2.0F);
    if (i > 0) {}
    for (i = (int)(i + this.jKt / 2.0F);; i = (int)(i - this.jKt / 2.0F))
    {
      if (this.jKt != 0.0F)
      {
        this.fs = ((int)((int)(i / this.jKt) * this.jKt));
        a(a.jKI);
      }
      label424:
      i = 0;
      break;
    }
  }
  
  public final void setAdapter(com.tencent.mm.picker.base.a.b<?> paramb)
  {
    AppMethodBeat.i(175311);
    this.jKr = paramb;
    bkT();
    invalidate();
    AppMethodBeat.o(175311);
  }
  
  public final void setCurrentItem(int paramInt)
  {
    AppMethodBeat.i(175310);
    this.jKz = paramInt;
    this.jKy = paramInt;
    this.jKx = 0.0F;
    invalidate();
    AppMethodBeat.o(175310);
  }
  
  public final void setCyclic(boolean paramBoolean)
  {
    this.jqj = paramBoolean;
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(175324);
    if (paramInt != 0)
    {
      this.jKu = paramInt;
      this.jKq.setColor(this.jKu);
    }
    AppMethodBeat.o(175324);
  }
  
  public void setDividerHeight(float paramFloat)
  {
    AppMethodBeat.i(175325);
    this.jKq.setStrokeWidth(paramFloat);
    AppMethodBeat.o(175325);
  }
  
  public void setGravity(int paramInt)
  {
    this.Ku = paramInt;
  }
  
  public void setIsOptions(boolean paramBoolean)
  {
    this.jKm = paramBoolean;
  }
  
  public void setLabel(String paramString)
  {
    this.label = paramString;
  }
  
  public final void setOnItemSelectedListener(com.tencent.mm.picker.base.b.b paramb)
  {
    this.jKl = paramb;
  }
  
  public void setTotalScrollY(float paramFloat)
  {
    this.jKx = paramFloat;
  }
  
  public final WheelView uK(int paramInt)
  {
    AppMethodBeat.i(175326);
    this.jKh = paramInt;
    invalidate();
    AppMethodBeat.o(175326);
    return this;
  }
  
  public final WheelView uL(int paramInt)
  {
    AppMethodBeat.i(175327);
    this.textColor = paramInt;
    this.cgU.setColor(this.textColor);
    this.jKi = ((int)((paramInt >> 24 & 0xFF) / 255.0F * 255.0F));
    AppMethodBeat.o(175327);
    return this;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(175302);
      jKI = new a("CLICK", 0);
      jKJ = new a("FLING", 1);
      jKK = new a("DAGGLE", 2);
      jKL = new a[] { jKI, jKJ, jKK };
      AppMethodBeat.o(175302);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.picker.base.view.WheelView
 * JD-Core Version:    0.7.0.1
 */