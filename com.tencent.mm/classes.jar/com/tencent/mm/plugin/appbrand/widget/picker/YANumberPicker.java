package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v4.view.q;
import android.support.v4.widget.n;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.OverScroller;
import com.tencent.luggage.c.a.a.g;
import com.tencent.mm.sdk.platformtools.y;

public class YANumberPicker
  extends View
{
  private int adV = 2;
  private int aqF;
  private int aqG;
  private int db;
  private VelocityTracker fB;
  private float fSz = 0.0F;
  private int hAA = 0;
  private int hAB = 0;
  private int hAC = 0;
  private int hAD = 0;
  private int hAE = -695533;
  private int hAF = 0;
  private int hAG = 0;
  private int hAH = 3;
  private int hAI = 0;
  private int hAJ = 0;
  private int hAK = -1;
  private int hAL = -1;
  private int hAM = 0;
  private int hAN = 0;
  private int hAO = 0;
  private int hAP = 0;
  private int hAQ = 0;
  private int hAR = 0;
  private int hAS = 0;
  private int hAT = 150;
  private int hAU = 8;
  private String hAV;
  private String hAW;
  private String hAX;
  private String hAY;
  private float hAZ = 1.0F;
  private int hAs = -13421773;
  private int hAt = -695533;
  private int hAu = -695533;
  private int hAv = 0;
  private int hAw = 0;
  private int hAx = 0;
  private int hAy = 0;
  private int hAz = 0;
  private int hBA;
  private float hBB = 0.0F;
  private float hBC = 0.0F;
  private boolean hBD = false;
  private float hBE;
  private float hBF;
  private float hBG;
  private int hBH = 0;
  private int hBI = 0;
  private int hBJ = 0;
  private int hBK = 0;
  private int hBL = 0;
  private float hBa = 0.0F;
  private float hBb = 0.0F;
  private float hBc = 0.0F;
  private boolean hBd = true;
  private boolean hBe = true;
  private boolean hBf = false;
  private boolean hBg = true;
  private boolean hBh = false;
  private boolean hBi = false;
  private boolean hBj = true;
  private n hBk;
  private Paint hBl = new Paint();
  private TextPaint hBm = new TextPaint();
  private Paint hBn = new Paint();
  private String[] hBo;
  private CharSequence[] hBp;
  private CharSequence[] hBq;
  private Handler hBr;
  private Handler hBs;
  private YANumberPicker.d hBt;
  private YANumberPicker.b hBu;
  private YANumberPicker.a hBv;
  private YANumberPicker.c hBw;
  private int hBx;
  private int hBy;
  private int hBz;
  private int lf = 0;
  private HandlerThread mHandlerThread;
  private boolean mHasInit = false;
  
  public YANumberPicker(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void H(int paramInt, boolean paramBoolean)
  {
    this.hBH = (paramInt - (this.hAH - 1) / 2);
    this.hBH = h(this.hBH, getOneRecycleSize(), paramBoolean);
    if (this.db == 0)
    {
      this.hBf = true;
      return;
    }
    this.hBJ = (this.hBH * this.db);
    this.hBx = (this.hBH + this.hAH / 2);
    this.hBx %= getOneRecycleSize();
    if (this.hBx < 0) {
      this.hBx += getOneRecycleSize();
    }
    this.hBy = this.hBx;
    asV();
  }
  
  private static float a(Paint.FontMetrics paramFontMetrics)
  {
    if (paramFontMetrics == null) {
      return 0.0F;
    }
    return Math.abs(paramFontMetrics.top + paramFontMetrics.bottom) / 2.0F;
  }
  
  private static int a(float paramFloat, int paramInt1, int paramInt2)
  {
    int k = (paramInt1 & 0xFF000000) >>> 24;
    int j = (paramInt1 & 0xFF0000) >>> 16;
    int i = (paramInt1 & 0xFF00) >>> 8;
    paramInt1 = (paramInt1 & 0xFF) >>> 0;
    float f = k;
    k = (int)((((0xFF000000 & paramInt2) >>> 24) - k) * paramFloat + f);
    f = j;
    j = (int)((((0xFF0000 & paramInt2) >>> 16) - j) * paramFloat + f);
    f = i;
    i = (int)((((0xFF00 & paramInt2) >>> 8) - i) * paramFloat + f);
    f = paramInt1;
    return k << 24 | j << 16 | i << 8 | (int)((((paramInt2 & 0xFF) >>> 0) - paramInt1) * paramFloat + f);
  }
  
  private static int a(CharSequence paramCharSequence, Paint paramPaint)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      return (int)(paramPaint.measureText(paramCharSequence.toString()) + 0.5F);
    }
    return 0;
  }
  
  private static int a(CharSequence[] paramArrayOfCharSequence, Paint paramPaint)
  {
    int k;
    if (paramArrayOfCharSequence == null)
    {
      k = 0;
      return k;
    }
    int m = paramArrayOfCharSequence.length;
    int j = 0;
    for (int i = 0;; i = k)
    {
      k = i;
      if (j >= m) {
        break;
      }
      CharSequence localCharSequence = paramArrayOfCharSequence[j];
      k = i;
      if (localCharSequence != null) {
        k = Math.max(a(localCharSequence, paramPaint), i);
      }
      j += 1;
    }
  }
  
  private void asS()
  {
    this.mHandlerThread = new HandlerThread("HandlerThread-For-Refreshing");
    this.mHandlerThread.start();
    this.hBr = new YANumberPicker.1(this, this.mHandlerThread.getLooper());
    this.hBs = new YANumberPicker.2(this);
  }
  
  private void asT()
  {
    H(getPickedIndexRelativeToRaw() - this.hAK, false);
    this.hBe = false;
    postInvalidate();
  }
  
  private void asU()
  {
    this.hBz = 0;
    this.hBA = (-this.hAH * this.db);
    if (this.hBo != null)
    {
      this.hBz = ((getOneRecycleSize() - this.hAH / 2 - 1) * this.db);
      this.hBA = (-(this.hAH / 2) * this.db);
    }
  }
  
  private void asV()
  {
    this.hBH = ((int)Math.floor(this.hBJ / this.db));
    this.hBI = (-(this.hBJ - this.hBH * this.db));
    if (this.hBw != null) {
      if (-this.hBI <= this.db / 2) {
        break label119;
      }
    }
    label119:
    for (this.hBy = (this.hBH + 1 + this.hAH / 2);; this.hBy = (this.hBH + this.hAH / 2))
    {
      this.hBy %= getOneRecycleSize();
      if (this.hBy < 0) {
        this.hBy += getOneRecycleSize();
      }
      this.hBx = this.hBy;
      return;
    }
  }
  
  private void asW()
  {
    if (this.hBo.length <= this.hAH) {}
    for (boolean bool = false;; bool = true)
    {
      this.hBg = bool;
      return;
    }
  }
  
  private void asX()
  {
    if ((this.hBk != null) && (!this.hBk.iY.isFinished()))
    {
      this.hBk.startScroll(0, this.hBk.iY.getCurrY(), 0, 0, 1);
      this.hBk.iY.abortAnimation();
      postInvalidate();
    }
  }
  
  private static Message b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    return localMessage;
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return;
    }
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.g.YANumberPicker);
    int k = localTypedArray.getIndexCount();
    int i = 0;
    if (i < k)
    {
      int j = localTypedArray.getIndex(i);
      if (j == a.g.YANumberPicker_npv_ShowCount) {
        this.hAH = localTypedArray.getInt(j, 3);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == a.g.YANumberPicker_npv_DividerColor)
        {
          this.hAE = localTypedArray.getColor(j, -695533);
        }
        else if (j == a.g.YANumberPicker_npv_DividerHeight)
        {
          this.adV = localTypedArray.getDimensionPixelSize(j, 2);
        }
        else if (j == a.g.YANumberPicker_npv_DividerMarginLeft)
        {
          this.hAF = localTypedArray.getDimensionPixelSize(j, 0);
        }
        else if (j == a.g.YANumberPicker_npv_DividerMarginRight)
        {
          this.hAG = localTypedArray.getDimensionPixelSize(j, 0);
        }
        else
        {
          if (j == a.g.YANumberPicker_npv_TextArray)
          {
            CharSequence[] arrayOfCharSequence = localTypedArray.getTextArray(j);
            if (arrayOfCharSequence == null) {
              paramAttributeSet = null;
            }
            for (;;)
            {
              this.hBo = paramAttributeSet;
              break;
              paramAttributeSet = new String[arrayOfCharSequence.length];
              j = 0;
              while (j < arrayOfCharSequence.length)
              {
                paramAttributeSet[j] = arrayOfCharSequence[j].toString();
                j += 1;
              }
            }
          }
          if (j == a.g.YANumberPicker_npv_TextColorNormal) {
            this.hAs = localTypedArray.getColor(j, -13421773);
          } else if (j == a.g.YANumberPicker_npv_TextColorSelected) {
            this.hAt = localTypedArray.getColor(j, -695533);
          } else if (j == a.g.YANumberPicker_npv_TextColorHint) {
            this.hAu = localTypedArray.getColor(j, -695533);
          } else if (j == a.g.YANumberPicker_npv_TextSizeNormal) {
            this.hAv = localTypedArray.getDimensionPixelSize(j, d(paramContext, 13.0F));
          } else if (j == a.g.YANumberPicker_npv_TextSizeSelected) {
            this.hAw = localTypedArray.getDimensionPixelSize(j, d(paramContext, 15.0F));
          } else if (j == a.g.YANumberPicker_npv_TextSizeHint) {
            this.hAx = localTypedArray.getDimensionPixelSize(j, d(paramContext, 14.0F));
          } else if (j == a.g.YANumberPicker_npv_MinValue) {
            this.hAK = localTypedArray.getInteger(j, 0);
          } else if (j == a.g.YANumberPicker_npv_MaxValue) {
            this.hAL = localTypedArray.getInteger(j, 0);
          } else if (j == a.g.YANumberPicker_npv_WrapSelectorWheel) {
            this.hBe = localTypedArray.getBoolean(j, true);
          } else if (j == a.g.YANumberPicker_npv_ShowDivider) {
            this.hBd = localTypedArray.getBoolean(j, true);
          } else if (j == a.g.YANumberPicker_npv_HintText) {
            this.hAV = localTypedArray.getString(j);
          } else if (j == a.g.YANumberPicker_npv_AlternativeHint) {
            this.hAY = localTypedArray.getString(j);
          } else if (j == a.g.YANumberPicker_npv_EmptyItemHint) {
            this.hAX = localTypedArray.getString(j);
          } else if (j == a.g.YANumberPicker_npv_MarginStartOfHint) {
            this.hAA = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == a.g.YANumberPicker_npv_MarginEndOfHint) {
            this.hAB = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == a.g.YANumberPicker_npv_ItemPaddingVertical) {
            this.hAC = localTypedArray.getDimensionPixelSize(j, e(paramContext, 2.0F));
          } else if (j == a.g.YANumberPicker_npv_ItemPaddingHorizontal) {
            this.hAD = localTypedArray.getDimensionPixelSize(j, e(paramContext, 5.0F));
          } else if (j == a.g.YANumberPicker_npv_AlternativeTextArrayWithMeasureHint) {
            this.hBp = localTypedArray.getTextArray(j);
          } else if (j == a.g.YANumberPicker_npv_AlternativeTextArrayWithoutMeasureHint) {
            this.hBq = localTypedArray.getTextArray(j);
          } else if (j == a.g.YANumberPicker_npv_RespondChangeOnDetached) {
            this.hBi = localTypedArray.getBoolean(j, false);
          } else if (j == a.g.YANumberPicker_npv_RespondChangeInMainThread) {
            this.hBj = localTypedArray.getBoolean(j, true);
          } else if (j == a.g.YANumberPicker_npv_TextEllipsize) {
            this.hAW = localTypedArray.getString(j);
          }
        }
      }
    }
    localTypedArray.recycle();
  }
  
  private static int d(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  private void dY(boolean paramBoolean)
  {
    float f = this.hBm.getTextSize();
    this.hBm.setTextSize(this.hAw);
    this.hAO = a(this.hBo, this.hBm);
    this.hAQ = a(this.hBp, this.hBm);
    this.hAR = a(this.hBq, this.hBm);
    this.hBm.setTextSize(this.hAx);
    this.hAz = a(this.hAY, this.hBm);
    this.hBm.setTextSize(f);
    f = this.hBm.getTextSize();
    this.hBm.setTextSize(this.hAw);
    this.hAP = ((int)(this.hBm.getFontMetrics().bottom - this.hBm.getFontMetrics().top + 0.5D));
    this.hBm.setTextSize(f);
    if ((paramBoolean) && ((this.hBK == -2147483648) || (this.hBL == -2147483648))) {
      this.hBs.sendEmptyMessage(3);
    }
  }
  
  private static int e(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void g(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt1 > paramInt2) {
      throw new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + paramInt1 + ", maxShowIndex is " + paramInt2 + ".");
    }
    if (this.hBo == null) {
      throw new IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
    }
    if (paramInt1 < 0) {
      throw new IllegalArgumentException("minShowIndex should not be less than 0, now minShowIndex is " + paramInt1);
    }
    if (paramInt1 > this.hBo.length - 1) {
      throw new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.hBo.length - 1) + " minShowIndex is " + paramInt1);
    }
    if (paramInt2 < 0) {
      throw new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is " + paramInt2);
    }
    if (paramInt2 > this.hBo.length - 1) {
      throw new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.hBo.length - 1) + " maxShowIndex is " + paramInt2);
    }
    this.hAK = paramInt1;
    this.hAL = paramInt2;
    if (paramBoolean)
    {
      this.hAS = (this.hAK + 0);
      if ((!this.hBe) || (!this.hBg)) {
        break label277;
      }
    }
    label277:
    for (paramBoolean = true;; paramBoolean = false)
    {
      H(0, paramBoolean);
      postInvalidate();
      return;
    }
  }
  
  private TextUtils.TruncateAt getEllipsizeType()
  {
    String str = this.hAW;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Illegal text ellipsize type.");
        if (str.equals("start"))
        {
          i = 0;
          continue;
          if (str.equals("middle"))
          {
            i = 1;
            continue;
            if (str.equals("end")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    return TextUtils.TruncateAt.START;
    return TextUtils.TruncateAt.MIDDLE;
    return TextUtils.TruncateAt.END;
  }
  
  private static int h(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 <= 0) {
      paramInt1 = 0;
    }
    int i;
    do
    {
      return paramInt1;
      if (!paramBoolean) {
        break;
      }
      i = paramInt1 % paramInt2;
      paramInt1 = i;
    } while (i >= 0);
    return i + paramInt2;
    return paramInt1;
  }
  
  private void init(Context paramContext)
  {
    this.hBk = n.a(paramContext, null);
    this.hAT = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    this.hAU = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    if (this.hAv == 0) {
      this.hAv = d(paramContext, 13.0F);
    }
    if (this.hAw == 0) {
      this.hAw = d(paramContext, 15.0F);
    }
    if (this.hAx == 0) {
      this.hAx = d(paramContext, 14.0F);
    }
    if (this.hAA == 0) {
      this.hAA = e(paramContext, 8.0F);
    }
    if (this.hAB == 0) {
      this.hAB = e(paramContext, 8.0F);
    }
    this.hBl.setColor(this.hAE);
    this.hBl.setAntiAlias(true);
    this.hBl.setStyle(Paint.Style.STROKE);
    this.hBl.setStrokeWidth(this.adV);
    this.hBm.setColor(this.hAs);
    this.hBm.setAntiAlias(true);
    this.hBm.setTextAlign(Paint.Align.CENTER);
    this.hBn.setColor(this.hAu);
    this.hBn.setAntiAlias(true);
    this.hBn.setTextAlign(Paint.Align.CENTER);
    this.hBn.setTextSize(this.hAx);
    if (this.hAH % 2 == 0) {
      this.hAH += 1;
    }
    if ((this.hAK == -1) || (this.hAL == -1))
    {
      if (this.hBo == null)
      {
        this.hBo = new String[1];
        this.hBo[0] = "0";
      }
      asW();
      if (this.hAK == -1) {
        this.hAK = 0;
      }
      if (this.hAL == -1) {
        this.hAL = (this.hBo.length - 1);
      }
      g(this.hAK, this.hAL, false);
    }
    asS();
  }
  
  private void nf(int paramInt)
  {
    if (this.lf == paramInt) {
      return;
    }
    this.lf = paramInt;
  }
  
  private int ng(int paramInt)
  {
    boolean bool2 = false;
    if (this.db == 0) {
      return 0;
    }
    paramInt /= this.db;
    int i = this.hAH / 2;
    int j = getOneRecycleSize();
    boolean bool1 = bool2;
    if (this.hBe)
    {
      bool1 = bool2;
      if (this.hBg) {
        bool1 = true;
      }
    }
    paramInt = h(paramInt + i, j, bool1);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize())) {
      return paramInt + this.hAK;
    }
    throw new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + paramInt + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.hBe);
  }
  
  private int nh(int paramInt)
  {
    if ((this.hBe) && (this.hBg)) {}
    do
    {
      return paramInt;
      if (paramInt < this.hBA) {
        return this.hBA;
      }
    } while (paramInt <= this.hBz);
    return this.hBz;
  }
  
  public final void asY()
  {
    asX();
    if (this.hBr != null) {
      this.hBr.sendMessageDelayed(b(1, 0, 0, null), 0L);
    }
  }
  
  public void computeScroll()
  {
    if (this.db == 0) {}
    while (!this.hBk.iY.computeScrollOffset()) {
      return;
    }
    this.hBJ = this.hBk.iY.getCurrY();
    asV();
    postInvalidate();
  }
  
  public String getContentByCurrValue()
  {
    return this.hBo[(getValue() - this.hAM)];
  }
  
  public String[] getDisplayedValues()
  {
    return this.hBo;
  }
  
  public int getMaxValue()
  {
    return this.hAN;
  }
  
  public int getMinValue()
  {
    return this.hAM;
  }
  
  public int getOneRecycleSize()
  {
    return this.hAL - this.hAK + 1;
  }
  
  public int getPickedIndexRelativeToRaw()
  {
    if (this.hBI != 0)
    {
      if (this.hBI < -this.db / 2) {
        return ng(this.hBJ + this.db + this.hBI);
      }
      return ng(this.hBJ + this.hBI);
    }
    return ng(this.hBJ);
  }
  
  public int getRawContentSize()
  {
    if (this.hBo != null) {
      return this.hBo.length;
    }
    return 0;
  }
  
  public int getValue()
  {
    return getPickedIndexRelativeToRaw() + this.hAM;
  }
  
  public boolean getWrapSelectorWheel()
  {
    return this.hBe;
  }
  
  public boolean getWrapSelectorWheelAbsolutely()
  {
    return (this.hBe) && (this.hBg);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.mHandlerThread == null) || (!this.mHandlerThread.isAlive())) {
      asS();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.mHandlerThread.quit();
    if (this.db == 0) {
      return;
    }
    if (!this.hBk.iY.isFinished())
    {
      this.hBk.iY.abortAnimation();
      this.hBJ = this.hBk.iY.getCurrY();
      asV();
      if (this.hBI != 0)
      {
        if (this.hBI >= -this.db / 2) {
          break label162;
        }
        this.hBJ = (this.hBJ + this.db + this.hBI);
      }
    }
    for (;;)
    {
      asV();
      nf(0);
      int i = ng(this.hBJ);
      if ((i != this.hAS) && (this.hBi)) {}
      try
      {
        if (this.hBu != null) {
          this.hBu.a(this, this.hAM + i);
        }
        this.hAS = i;
        return;
        label162:
        this.hBJ += this.hBI;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.YANumberPicker", localException, "", new Object[0]);
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = 0.0F;
    int j = 0;
    if (j < this.hAH + 1)
    {
      float f5 = this.hBI + this.db * j;
      int i = this.hBH;
      int k = getOneRecycleSize();
      boolean bool;
      label65:
      float f3;
      float f2;
      if ((this.hBe) && (this.hBg))
      {
        bool = true;
        k = h(i + j, k, bool);
        if (j != this.hAH / 2) {
          break label291;
        }
        f3 = (this.db + this.hBI) / this.db;
        i = a(f3, this.hAs, this.hAt);
        f1 = this.hAv;
        f2 = (this.hAw - f1) * f3 + f1;
        f1 = this.hBa;
        f1 += (this.hBb - f1) * f3;
        label159:
        this.hBm.setColor(i);
        this.hBm.setTextSize(f2);
        if ((k < 0) || (k >= getOneRecycleSize())) {
          break label398;
        }
        String str = this.hBo[(this.hAK + k)];
        Object localObject = str;
        if (this.hAW != null) {
          localObject = TextUtils.ellipsize(str, this.hBm, getWidth() - this.hAD * 2, getEllipsizeType());
        }
        paramCanvas.drawText(((CharSequence)localObject).toString(), this.hBG, f1 + (f5 + this.db / 2), this.hBm);
      }
      for (;;)
      {
        j += 1;
        f1 = f3;
        break;
        bool = false;
        break label65;
        label291:
        if (j == this.hAH / 2 + 1)
        {
          i = a(1.0F - f1, this.hAs, this.hAt);
          f2 = this.hAv;
          f2 += (1.0F - f1) * (this.hAw - f2);
          f3 = this.hBa;
          f4 = (1.0F - f1) * (this.hBb - f3) + f3;
          f3 = f1;
          f1 = f4;
          break label159;
        }
        i = this.hAs;
        f2 = this.hAv;
        float f4 = this.hBa;
        f3 = f1;
        f1 = f4;
        break label159;
        label398:
        if (!TextUtils.isEmpty(this.hAX)) {
          paramCanvas.drawText(this.hAX, this.hBG, f1 + (f5 + this.db / 2), this.hBm);
        }
      }
    }
    if (this.hBd)
    {
      paramCanvas.drawLine(getPaddingLeft() + this.hAF, this.hBE, this.aqF - getPaddingRight() - this.hAG, this.hBE, this.hBl);
      paramCanvas.drawLine(getPaddingLeft() + this.hAF, this.hBF, this.aqF - getPaddingRight() - this.hAG, this.hBF, this.hBl);
    }
    if (!TextUtils.isEmpty(this.hAV)) {
      paramCanvas.drawText(this.hAV, this.hBG + (this.hAO + this.hAy) / 2 + this.hAA, (this.hBE + this.hBF) / 2.0F + this.hBc, this.hBn);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    super.onMeasure(paramInt1, paramInt2);
    dY(false);
    int k = View.MeasureSpec.getMode(paramInt1);
    this.hBK = k;
    int j = View.MeasureSpec.getSize(paramInt1);
    if (k == 1073741824)
    {
      paramInt1 = j;
      j = View.MeasureSpec.getMode(paramInt2);
      this.hBL = j;
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      if (j != 1073741824) {
        break label202;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      if (Math.max(this.hAy, this.hAz) == 0)
      {
        paramInt1 = 0;
        label90:
        if (Math.max(this.hAy, this.hAz) != 0) {
          break label194;
        }
      }
      for (;;)
      {
        int m = this.hAQ;
        int n = Math.max(this.hAO, this.hAR);
        i = Math.max(m, (paramInt1 + (i + Math.max(this.hAy, this.hAz)) + this.hAD * 2) * 2 + n) + (getPaddingLeft() + getPaddingRight());
        paramInt1 = i;
        if (k != -2147483648) {
          break;
        }
        paramInt1 = Math.min(i, j);
        break;
        paramInt1 = this.hAB;
        break label90;
        label194:
        i = this.hAA;
      }
      label202:
      i = this.hAH * (this.hAP + this.hAC * 2) + (getPaddingTop() + getPaddingBottom());
      if (j == -2147483648) {
        paramInt2 = Math.min(i, paramInt2);
      } else {
        paramInt2 = i;
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.aqF = paramInt1;
    this.aqG = paramInt2;
    this.db = (this.aqG / this.hAH);
    this.hBG = ((this.aqF + getPaddingLeft() - getPaddingRight()) / 2.0F);
    if (getOneRecycleSize() > 1) {
      if (this.mHasInit) {
        paramInt1 = getValue() - this.hAM;
      }
    }
    for (;;)
    {
      if ((this.hBe) && (this.hBg)) {}
      for (boolean bool = true;; bool = false)
      {
        H(paramInt1, bool);
        if (this.hAv > this.db) {
          this.hAv = this.db;
        }
        if (this.hAw > this.db) {
          this.hAw = this.db;
        }
        if (this.hBn != null) {
          break label193;
        }
        throw new IllegalArgumentException("mPaintHint should not be null.");
        if (this.hBf)
        {
          paramInt1 = this.hBH + (this.hAH - 1) / 2;
          break;
        }
        paramInt1 = 0;
        break;
      }
      label193:
      this.hBn.setTextSize(this.hAx);
      this.hBc = a(this.hBn.getFontMetrics());
      this.hAy = a(this.hAV, this.hBn);
      if (this.hBm == null) {
        throw new IllegalArgumentException("mPaintText should not be null.");
      }
      this.hBm.setTextSize(this.hAw);
      this.hBb = a(this.hBm.getFontMetrics());
      this.hBm.setTextSize(this.hAv);
      this.hBa = a(this.hBm.getFontMetrics());
      asU();
      this.hAI = (this.hAH / 2);
      this.hAJ = (this.hAI + 1);
      this.hBE = (this.hAI * this.aqG / this.hAH);
      this.hBF = (this.hAJ * this.aqG / this.hAH);
      if (this.hAF < 0) {
        this.hAF = 0;
      }
      if (this.hAG < 0) {
        this.hAG = 0;
      }
      if ((this.hAF + this.hAG != 0) && (getPaddingLeft() + this.hAF >= this.aqF - getPaddingRight() - this.hAG))
      {
        paramInt1 = getPaddingLeft() + this.hAF + getPaddingRight() + this.hAG - this.aqF;
        this.hAF = ((int)(this.hAF - paramInt1 * this.hAF / (this.hAF + this.hAG)));
        this.hAG = ((int)(this.hAG - paramInt1 * this.hAG / (this.hAF + this.hAG)));
      }
      this.mHasInit = true;
      return;
      paramInt1 = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.db == 0) {}
    int i;
    label212:
    do
    {
      float f;
      do
      {
        return true;
        if (this.fB == null) {
          this.fB = VelocityTracker.obtain();
        }
        this.fB.addMovement(paramMotionEvent);
        this.hBC = paramMotionEvent.getY();
        switch (paramMotionEvent.getAction())
        {
        default: 
          return true;
        case 0: 
          this.hBD = true;
          this.hBr.removeMessages(1);
          asX();
          this.fSz = this.hBC;
          this.hBB = this.hBJ;
          nf(0);
          getParent().requestDisallowInterceptTouchEvent(true);
          return true;
        case 2: 
          f = this.fSz - this.hBC;
          if ((!this.hBD) || (-this.hAU >= f) || (f >= this.hAU))
          {
            this.hBD = false;
            this.hBJ = nh((int)(f + this.hBB));
            asV();
            invalidate();
          }
          nf(1);
          return true;
        case 1: 
          if (!this.hBD) {
            break label551;
          }
          f = paramMotionEvent.getY();
          i = 0;
        }
      } while (i >= this.hAH);
      if ((this.db * i > f) || (f >= this.db * (i + 1))) {
        break;
      }
    } while ((i < 0) || (i >= this.hAH));
    i -= this.hAH / 2;
    int j;
    int k;
    if (this.hBe)
    {
      j = i;
      if (this.hBg) {}
    }
    else
    {
      k = getPickedIndexRelativeToRaw();
      if (k + i <= this.hAL) {
        break label453;
      }
      j = this.hAL - k;
    }
    label310:
    label372:
    int n;
    if (this.hBI < -this.db / 2)
    {
      k = this.db + this.hBI;
      i = (int)((this.db + this.hBI) * 300.0F / this.db);
      if (j < 0)
      {
        i = -i - j * 300;
        n = this.db;
        if (i >= 300) {
          break label726;
        }
        i = 300;
      }
    }
    label453:
    label726:
    for (;;)
    {
      int m = i;
      if (i > 600) {
        m = 600;
      }
      this.hBk.startScroll(0, this.hBJ, 0, k + j * n, m);
      this.hBr.sendMessageDelayed(b(1, 0, 0, null), m / 4);
      postInvalidate();
      return true;
      j = i;
      if (k + i >= this.hAK) {
        break label310;
      }
      j = this.hAK - k;
      break label310;
      i += j * 300;
      break label372;
      k = this.hBI;
      i = (int)(-this.hBI * 300.0F / this.db);
      if (j < 0)
      {
        i -= j * 300;
        break label372;
      }
      i += j * 300;
      break label372;
      i += 1;
      break label212;
      paramMotionEvent = this.fB;
      paramMotionEvent.computeCurrentVelocity(1000);
      j = (int)(paramMotionEvent.getYVelocity() * this.hAZ);
      if (Math.abs(j) > this.hAT)
      {
        paramMotionEvent = this.hBk;
        i = this.hBJ;
        j = -j;
        k = nh(-2147483648);
        m = nh(2147483647);
        paramMotionEvent.iY.fling(0, i, 0, j, -2147483648, 2147483647, k, m);
        invalidate();
        nf(2);
      }
      this.hBr.sendMessageDelayed(b(1, 0, 0, null), 0L);
      if (this.fB == null) {
        break;
      }
      this.fB.clear();
      this.fB.recycle();
      this.fB = null;
      return true;
      this.hBB = this.hBJ;
      asX();
      this.hBr.sendMessageDelayed(b(1, 0, 0, null), 0L);
      return true;
    }
  }
  
  public void postInvalidate()
  {
    if (!q.ao(this)) {
      return;
    }
    super.postInvalidate();
  }
  
  public void setContentTextTypeface(Typeface paramTypeface)
  {
    this.hBm.setTypeface(paramTypeface);
  }
  
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    boolean bool = true;
    if (this.hBr != null) {
      this.hBr.removeMessages(1);
    }
    asX();
    if (paramArrayOfString == null) {
      throw new IllegalArgumentException("newDisplayedValues should not be null.");
    }
    if (this.hAN - this.hAM + 1 > paramArrayOfString.length) {
      throw new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + (this.hAN - this.hAM + 1) + " newDisplayedValues.length is " + paramArrayOfString.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
    }
    this.hBo = paramArrayOfString;
    asW();
    dY(true);
    this.hAS = (this.hAK + 0);
    if ((this.hBe) && (this.hBg)) {}
    for (;;)
    {
      H(0, bool);
      postInvalidate();
      this.hBs.sendEmptyMessage(3);
      return;
      bool = false;
    }
  }
  
  public void setDividerColor(int paramInt)
  {
    if (this.hAE == paramInt) {
      return;
    }
    this.hAE = paramInt;
    this.hBl.setColor(this.hAE);
    postInvalidate();
  }
  
  public void setDividerHeight(int paramInt)
  {
    if (paramInt == this.adV) {
      return;
    }
    this.adV = paramInt;
    this.hBl.setStrokeWidth(this.adV);
    postInvalidate();
  }
  
  public void setEllipsizeType(String paramString)
  {
    int i = 0;
    while (i < 3)
    {
      if (new String[] { "end", "middle", "start" }[i].equals(paramString))
      {
        this.hAW = paramString;
        return;
      }
      i += 1;
    }
    this.hAW = "end";
  }
  
  public void setFriction(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException("you should set a a positive float friction, now friction is " + paramFloat);
    }
    ViewConfiguration.get(getContext());
    this.hAZ = (ViewConfiguration.getScrollFriction() / paramFloat);
  }
  
  public void setHintText(String paramString)
  {
    String str = this.hAV;
    boolean bool;
    if (str == null) {
      if (paramString == null) {
        bool = true;
      }
    }
    while (bool)
    {
      return;
      bool = false;
      continue;
      bool = str.equals(paramString);
    }
    this.hAV = paramString;
    this.hBc = a(this.hBn.getFontMetrics());
    this.hAy = a(this.hAV, this.hBn);
    this.hBs.sendEmptyMessage(3);
  }
  
  public void setHintTextColor(int paramInt)
  {
    if (this.hAu == paramInt) {
      return;
    }
    this.hAu = paramInt;
    this.hBn.setColor(this.hAu);
    postInvalidate();
  }
  
  public void setHintTextTypeface(Typeface paramTypeface)
  {
    this.hBn.setTypeface(paramTypeface);
  }
  
  public void setItemPaddingVertical(int paramInt)
  {
    if (this.hAC == paramInt) {
      return;
    }
    this.hAC = paramInt;
    postInvalidate();
  }
  
  public void setMaxValue(int paramInt)
  {
    if (this.hBo == null) {
      throw new NullPointerException("mDisplayedValues should not be null");
    }
    if (paramInt - this.hAM + 1 > this.hBo.length) {
      throw new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + (paramInt - this.hAM + 1) + " and mDisplayedValues.length is " + this.hBo.length);
    }
    this.hAN = paramInt;
    this.hAL = (this.hAN - this.hAM + this.hAK);
    g(this.hAK, this.hAL, true);
    asU();
  }
  
  public void setMinValue(int paramInt)
  {
    this.hAM = paramInt;
    this.hAK = 0;
    asU();
  }
  
  public void setNormalTextColor(int paramInt)
  {
    if (this.hAs == paramInt) {
      return;
    }
    this.hAs = paramInt;
    postInvalidate();
  }
  
  public void setOnScrollListener(YANumberPicker.a parama)
  {
    this.hBv = parama;
  }
  
  public void setOnValueChangeListenerInScrolling(YANumberPicker.c paramc)
  {
    this.hBw = paramc;
  }
  
  public void setOnValueChangedListener(YANumberPicker.b paramb)
  {
    this.hBu = paramb;
  }
  
  public void setOnValueChangedListenerRelativeToRaw(YANumberPicker.d paramd)
  {
    this.hBt = paramd;
  }
  
  public void setPickedIndexRelativeToMin(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      this.hAS = (this.hAK + paramInt);
      if ((!this.hBe) || (!this.hBg)) {
        break label49;
      }
    }
    label49:
    for (boolean bool = true;; bool = false)
    {
      H(paramInt, bool);
      postInvalidate();
      return;
    }
  }
  
  public void setPickedIndexRelativeToRaw(int paramInt)
  {
    int i;
    if ((this.hAK >= 0) && (this.hAK <= paramInt) && (paramInt <= this.hAL))
    {
      this.hAS = paramInt;
      i = this.hAK;
      if ((!this.hBe) || (!this.hBg)) {
        break label62;
      }
    }
    label62:
    for (boolean bool = true;; bool = false)
    {
      H(paramInt - i, bool);
      postInvalidate();
      return;
    }
  }
  
  public void setSelectedTextColor(int paramInt)
  {
    if (this.hAt == paramInt) {
      return;
    }
    this.hAt = paramInt;
    postInvalidate();
  }
  
  public void setValue(int paramInt)
  {
    if (paramInt < this.hAM) {
      throw new IllegalArgumentException("should not set a value less than mMinValue, value is " + paramInt);
    }
    if (paramInt > this.hAN) {
      throw new IllegalArgumentException("should not set a value greater than mMaxValue, value is " + paramInt);
    }
    setPickedIndexRelativeToRaw(paramInt - this.hAM);
  }
  
  public void setWrapSelectorWheel(boolean paramBoolean)
  {
    if (this.hBe != paramBoolean)
    {
      if (paramBoolean) {
        break label30;
      }
      if (this.lf == 0) {
        asT();
      }
    }
    else
    {
      return;
    }
    this.hBh = true;
    return;
    label30:
    this.hBe = paramBoolean;
    asW();
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker
 * JD-Core Version:    0.7.0.1
 */