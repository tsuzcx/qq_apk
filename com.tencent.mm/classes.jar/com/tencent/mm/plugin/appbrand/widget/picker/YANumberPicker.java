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
import android.os.Message;
import android.support.v4.view.u;
import android.support.v4.widget.p;
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
import com.tencent.luggage.b.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class YANumberPicker
  extends View
{
  private int aYN;
  private int aYO;
  private int aqo;
  private float dep;
  private p hgg;
  private boolean mHasInit;
  private int mScrollState;
  private VelocityTracker mVelocityTracker;
  private int oAA;
  private String oAB;
  private String oAC;
  private String oAD;
  private String oAE;
  private float oAF;
  private float oAG;
  private float oAH;
  private float oAI;
  private boolean oAJ;
  private boolean oAK;
  private boolean oAL;
  private boolean oAM;
  private boolean oAN;
  private boolean oAO;
  private boolean oAP;
  private Paint oAQ;
  private TextPaint oAR;
  private Paint oAS;
  private String[] oAT;
  private CharSequence[] oAU;
  private CharSequence[] oAV;
  private MMHandler oAW;
  private Handler oAX;
  private d oAY;
  private b oAZ;
  private int oAa;
  private int oAb;
  private int oAc;
  private int oAd;
  private int oAe;
  private int oAf;
  private int oAg;
  private int oAh;
  private int oAi;
  private int oAj;
  private int oAk;
  private int oAl;
  private int oAm;
  private int oAn;
  private int oAo;
  private int oAp;
  private int oAq;
  private int oAr;
  private int oAs;
  private int oAt;
  private int oAu;
  private int oAv;
  private int oAw;
  private int oAx;
  private int oAy;
  private int oAz;
  private a oBa;
  private c oBb;
  private int oBc;
  private int oBd;
  private int oBe;
  private int oBf;
  private float oBg;
  private float oBh;
  private boolean oBi;
  private float oBj;
  private float oBk;
  private float oBl;
  private int oBm;
  private int oBn;
  private int oBo;
  private int oBp;
  private int oBq;
  private int onv;
  private int ozY;
  private int ozZ;
  
  public YANumberPicker(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138091);
    this.ozY = -13421773;
    this.ozZ = -695533;
    this.oAa = -695533;
    this.oAb = 0;
    this.oAc = 0;
    this.oAd = 0;
    this.oAe = 0;
    this.oAf = 0;
    this.oAg = 0;
    this.oAh = 0;
    this.oAi = 0;
    this.oAj = 0;
    this.oAk = -695533;
    this.aqo = 2;
    this.oAl = 0;
    this.oAm = 0;
    this.oAn = 3;
    this.oAo = 0;
    this.oAp = 0;
    this.oAq = -1;
    this.oAr = -1;
    this.oAs = 0;
    this.oAt = 0;
    this.oAu = 0;
    this.oAv = 0;
    this.oAw = 0;
    this.oAx = 0;
    this.oAy = 0;
    this.oAz = 150;
    this.oAA = 8;
    this.oAF = 1.0F;
    this.oAG = 0.0F;
    this.oAH = 0.0F;
    this.oAI = 0.0F;
    this.oAJ = true;
    this.oAK = true;
    this.oAL = false;
    this.mHasInit = false;
    this.oAM = true;
    this.oAN = false;
    this.oAO = false;
    this.oAP = true;
    this.oAQ = new Paint();
    this.oAR = new TextPaint();
    this.oAS = new Paint();
    this.mScrollState = 0;
    this.oBg = 0.0F;
    this.dep = 0.0F;
    this.oBh = 0.0F;
    this.oBi = false;
    this.oBm = 0;
    this.oBn = 0;
    this.oBo = 0;
    this.oBp = 0;
    this.oBq = 0;
    init(paramContext);
    AppMethodBeat.o(138091);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138092);
    this.ozY = -13421773;
    this.ozZ = -695533;
    this.oAa = -695533;
    this.oAb = 0;
    this.oAc = 0;
    this.oAd = 0;
    this.oAe = 0;
    this.oAf = 0;
    this.oAg = 0;
    this.oAh = 0;
    this.oAi = 0;
    this.oAj = 0;
    this.oAk = -695533;
    this.aqo = 2;
    this.oAl = 0;
    this.oAm = 0;
    this.oAn = 3;
    this.oAo = 0;
    this.oAp = 0;
    this.oAq = -1;
    this.oAr = -1;
    this.oAs = 0;
    this.oAt = 0;
    this.oAu = 0;
    this.oAv = 0;
    this.oAw = 0;
    this.oAx = 0;
    this.oAy = 0;
    this.oAz = 150;
    this.oAA = 8;
    this.oAF = 1.0F;
    this.oAG = 0.0F;
    this.oAH = 0.0F;
    this.oAI = 0.0F;
    this.oAJ = true;
    this.oAK = true;
    this.oAL = false;
    this.mHasInit = false;
    this.oAM = true;
    this.oAN = false;
    this.oAO = false;
    this.oAP = true;
    this.oAQ = new Paint();
    this.oAR = new TextPaint();
    this.oAS = new Paint();
    this.mScrollState = 0;
    this.oBg = 0.0F;
    this.dep = 0.0F;
    this.oBh = 0.0F;
    this.oBi = false;
    this.oBm = 0;
    this.oBn = 0;
    this.oBo = 0;
    this.oBp = 0;
    this.oBq = 0;
    a(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(138092);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138093);
    this.ozY = -13421773;
    this.ozZ = -695533;
    this.oAa = -695533;
    this.oAb = 0;
    this.oAc = 0;
    this.oAd = 0;
    this.oAe = 0;
    this.oAf = 0;
    this.oAg = 0;
    this.oAh = 0;
    this.oAi = 0;
    this.oAj = 0;
    this.oAk = -695533;
    this.aqo = 2;
    this.oAl = 0;
    this.oAm = 0;
    this.oAn = 3;
    this.oAo = 0;
    this.oAp = 0;
    this.oAq = -1;
    this.oAr = -1;
    this.oAs = 0;
    this.oAt = 0;
    this.oAu = 0;
    this.oAv = 0;
    this.oAw = 0;
    this.oAx = 0;
    this.oAy = 0;
    this.oAz = 150;
    this.oAA = 8;
    this.oAF = 1.0F;
    this.oAG = 0.0F;
    this.oAH = 0.0F;
    this.oAI = 0.0F;
    this.oAJ = true;
    this.oAK = true;
    this.oAL = false;
    this.mHasInit = false;
    this.oAM = true;
    this.oAN = false;
    this.oAO = false;
    this.oAP = true;
    this.oAQ = new Paint();
    this.oAR = new TextPaint();
    this.oAS = new Paint();
    this.mScrollState = 0;
    this.oBg = 0.0F;
    this.dep = 0.0F;
    this.oBh = 0.0F;
    this.oBi = false;
    this.oBm = 0;
    this.oBn = 0;
    this.oBo = 0;
    this.oBp = 0;
    this.oBq = 0;
    a(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(138093);
  }
  
  private int AA(int paramInt)
  {
    if ((this.oAK) && (this.oAM)) {}
    do
    {
      return paramInt;
      if (paramInt < this.oBf) {
        return this.oBf;
      }
    } while (paramInt <= this.oBe);
    return this.oBe;
  }
  
  private void Ay(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
  }
  
  private int Az(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(138123);
    if (this.onv == 0)
    {
      AppMethodBeat.o(138123);
      return 0;
    }
    paramInt /= this.onv;
    int i = this.oAn / 2;
    int j = getOneRecycleSize();
    boolean bool1 = bool2;
    if (this.oAK)
    {
      bool1 = bool2;
      if (this.oAM) {
        bool1 = true;
      }
    }
    paramInt = s(paramInt + i, j, bool1);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      i = this.oAq;
      AppMethodBeat.o(138123);
      return paramInt + i;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + paramInt + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.oAK);
    AppMethodBeat.o(138123);
    throw localIllegalArgumentException;
  }
  
  private void U(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(138128);
    this.oBm = (paramInt - (this.oAn - 1) / 2);
    this.oBm = s(this.oBm, getOneRecycleSize(), paramBoolean);
    if (this.onv == 0)
    {
      this.oAL = true;
      AppMethodBeat.o(138128);
      return;
    }
    this.oBo = (this.oBm * this.onv);
    this.oBc = (this.oBm + this.oAn / 2);
    this.oBc %= getOneRecycleSize();
    if (this.oBc < 0) {
      this.oBc += getOneRecycleSize();
    }
    this.oBd = this.oBc;
    ccz();
    AppMethodBeat.o(138128);
  }
  
  private static float a(Paint.FontMetrics paramFontMetrics)
  {
    AppMethodBeat.i(138127);
    if (paramFontMetrics == null)
    {
      AppMethodBeat.o(138127);
      return 0.0F;
    }
    float f = Math.abs(paramFontMetrics.top + paramFontMetrics.bottom) / 2.0F;
    AppMethodBeat.o(138127);
    return f;
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
    AppMethodBeat.i(138137);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      int i = (int)(paramPaint.measureText(paramCharSequence.toString()) + 0.5F);
      AppMethodBeat.o(138137);
      return i;
    }
    AppMethodBeat.o(138137);
    return 0;
  }
  
  private static int a(CharSequence[] paramArrayOfCharSequence, Paint paramPaint)
  {
    AppMethodBeat.i(138136);
    if (paramArrayOfCharSequence == null)
    {
      AppMethodBeat.o(138136);
      return 0;
    }
    int m = paramArrayOfCharSequence.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      CharSequence localCharSequence = paramArrayOfCharSequence[i];
      k = j;
      if (localCharSequence != null) {
        k = Math.max(a(localCharSequence, paramPaint), j);
      }
      i += 1;
    }
    AppMethodBeat.o(138136);
    return j;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(138094);
    if (paramAttributeSet == null)
    {
      AppMethodBeat.o(138094);
      return;
    }
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.YANumberPicker);
    int k = localTypedArray.getIndexCount();
    int i = 0;
    if (i < k)
    {
      int j = localTypedArray.getIndex(i);
      if (j == 17) {
        this.oAn = localTypedArray.getInt(j, 3);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          this.oAk = localTypedArray.getColor(j, -695533);
        }
        else if (j == 4)
        {
          this.aqo = localTypedArray.getDimensionPixelSize(j, 2);
        }
        else if (j == 5)
        {
          this.oAl = localTypedArray.getDimensionPixelSize(j, 0);
        }
        else if (j == 6)
        {
          this.oAm = localTypedArray.getDimensionPixelSize(j, 0);
        }
        else
        {
          if (j == 19)
          {
            CharSequence[] arrayOfCharSequence = localTypedArray.getTextArray(j);
            if (arrayOfCharSequence == null) {
              paramAttributeSet = null;
            }
            for (;;)
            {
              this.oAT = paramAttributeSet;
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
          if (j == 21) {
            this.ozY = localTypedArray.getColor(j, -13421773);
          } else if (j == 22) {
            this.ozZ = localTypedArray.getColor(j, -695533);
          } else if (j == 20) {
            this.oAa = localTypedArray.getColor(j, -695533);
          } else if (j == 25) {
            this.oAb = localTypedArray.getDimensionPixelSize(j, d(paramContext, 13.0F));
          } else if (j == 26) {
            this.oAc = localTypedArray.getDimensionPixelSize(j, d(paramContext, 15.0F));
          } else if (j == 24) {
            this.oAd = localTypedArray.getDimensionPixelSize(j, d(paramContext, 14.0F));
          } else if (j == 14) {
            this.oAq = localTypedArray.getInteger(j, 0);
          } else if (j == 13) {
            this.oAr = localTypedArray.getInteger(j, 0);
          } else if (j == 27) {
            this.oAK = localTypedArray.getBoolean(j, true);
          } else if (j == 18) {
            this.oAJ = localTypedArray.getBoolean(j, true);
          } else if (j == 8) {
            this.oAB = localTypedArray.getString(j);
          } else if (j == 0) {
            this.oAE = localTypedArray.getString(j);
          } else if (j == 7) {
            this.oAD = localTypedArray.getString(j);
          } else if (j == 12) {
            this.oAg = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == 11) {
            this.oAh = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == 10) {
            this.oAi = localTypedArray.getDimensionPixelSize(j, e(paramContext, 2.0F));
          } else if (j == 9) {
            this.oAj = localTypedArray.getDimensionPixelSize(j, e(paramContext, 5.0F));
          } else if (j == 1) {
            this.oAU = localTypedArray.getTextArray(j);
          } else if (j == 2) {
            this.oAV = localTypedArray.getTextArray(j);
          } else if (j == 16) {
            this.oAO = localTypedArray.getBoolean(j, false);
          } else if (j == 15) {
            this.oAP = localTypedArray.getBoolean(j, true);
          } else if (j == 23) {
            this.oAC = localTypedArray.getString(j);
          }
        }
      }
    }
    localTypedArray.recycle();
    AppMethodBeat.o(138094);
  }
  
  private static Message b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(138142);
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    AppMethodBeat.o(138142);
    return localMessage;
  }
  
  private void ccA()
  {
    AppMethodBeat.i(138135);
    float f = this.oAR.getTextSize();
    this.oAR.setTextSize(this.oAc);
    this.oAu = a(this.oAT, this.oAR);
    this.oAw = a(this.oAU, this.oAR);
    this.oAx = a(this.oAV, this.oAR);
    this.oAR.setTextSize(this.oAd);
    this.oAf = a(this.oAE, this.oAR);
    this.oAR.setTextSize(f);
    AppMethodBeat.o(138135);
  }
  
  private void ccB()
  {
    AppMethodBeat.i(138138);
    float f = this.oAR.getTextSize();
    this.oAR.setTextSize(this.oAc);
    this.oAv = ((int)(this.oAR.getFontMetrics().bottom - this.oAR.getFontMetrics().top + 0.5D));
    this.oAR.setTextSize(f);
    AppMethodBeat.o(138138);
  }
  
  private void ccC()
  {
    AppMethodBeat.i(138139);
    ccD();
    ccE();
    if (this.oAq == -1) {
      this.oAq = 0;
    }
    if (this.oAr == -1) {
      this.oAr = (this.oAT.length - 1);
    }
    r(this.oAq, this.oAr, false);
    AppMethodBeat.o(138139);
  }
  
  private void ccD()
  {
    if (this.oAT == null)
    {
      this.oAT = new String[1];
      this.oAT[0] = "0";
    }
  }
  
  private void ccE()
  {
    if (this.oAT.length <= this.oAn) {}
    for (boolean bool = false;; bool = true)
    {
      this.oAM = bool;
      return;
    }
  }
  
  private void ccF()
  {
    AppMethodBeat.i(138140);
    if ((this.hgg != null) && (!this.hgg.UD.isFinished()))
    {
      this.hgg.startScroll(0, this.hgg.UD.getCurrY(), 0, 0, 1);
      this.hgg.UD.abortAnimation();
      postInvalidate();
    }
    AppMethodBeat.o(138140);
  }
  
  private void ccx()
  {
    AppMethodBeat.i(138124);
    U(getPickedIndexRelativeToRaw() - this.oAq, false);
    this.oAK = false;
    postInvalidate();
    AppMethodBeat.o(138124);
  }
  
  private void ccy()
  {
    AppMethodBeat.i(138125);
    this.oBe = 0;
    this.oBf = (-this.oAn * this.onv);
    if (this.oAT != null)
    {
      this.oBe = ((getOneRecycleSize() - this.oAn / 2 - 1) * this.onv);
      this.oBf = (-(this.oAn / 2) * this.onv);
    }
    AppMethodBeat.o(138125);
  }
  
  private void ccz()
  {
    AppMethodBeat.i(138130);
    this.oBm = ((int)Math.floor(this.oBo / this.onv));
    this.oBn = (-(this.oBo - this.oBm * this.onv));
    if (this.oBb != null) {
      if (-this.oBn <= this.onv / 2) {
        break label131;
      }
    }
    label131:
    for (this.oBd = (this.oBm + 1 + this.oAn / 2);; this.oBd = (this.oBm + this.oAn / 2))
    {
      this.oBd %= getOneRecycleSize();
      if (this.oBd < 0) {
        this.oBd += getOneRecycleSize();
      }
      this.oBc = this.oBd;
      AppMethodBeat.o(138130);
      return;
    }
  }
  
  private static int d(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(138143);
    int i = (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
    AppMethodBeat.o(138143);
    return i;
  }
  
  private static int e(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(138144);
    int i = (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
    AppMethodBeat.o(138144);
    return i;
  }
  
  private TextUtils.TruncateAt getEllipsizeType()
  {
    AppMethodBeat.i(138134);
    Object localObject = this.oAC;
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        localObject = new IllegalArgumentException("Illegal text ellipsize type.");
        AppMethodBeat.o(138134);
        throw ((Throwable)localObject);
        if (((String)localObject).equals("start"))
        {
          i = 0;
          continue;
          if (((String)localObject).equals("middle"))
          {
            i = 1;
            continue;
            if (((String)localObject).equals("end")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    localObject = TextUtils.TruncateAt.START;
    AppMethodBeat.o(138134);
    return localObject;
    localObject = TextUtils.TruncateAt.MIDDLE;
    AppMethodBeat.o(138134);
    return localObject;
    localObject = TextUtils.TruncateAt.END;
    AppMethodBeat.o(138134);
    return localObject;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(138095);
    this.hgg = p.a(paramContext, null);
    this.oAz = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    this.oAA = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    if (this.oAb == 0) {
      this.oAb = d(paramContext, 13.0F);
    }
    if (this.oAc == 0) {
      this.oAc = d(paramContext, 15.0F);
    }
    if (this.oAd == 0) {
      this.oAd = d(paramContext, 14.0F);
    }
    if (this.oAg == 0) {
      this.oAg = e(paramContext, 8.0F);
    }
    if (this.oAh == 0) {
      this.oAh = e(paramContext, 8.0F);
    }
    this.oAQ.setColor(this.oAk);
    this.oAQ.setAntiAlias(true);
    this.oAQ.setStyle(Paint.Style.STROKE);
    this.oAQ.setStrokeWidth(this.aqo);
    this.oAR.setColor(this.ozY);
    this.oAR.setAntiAlias(true);
    this.oAR.setTextAlign(Paint.Align.CENTER);
    this.oAS.setColor(this.oAa);
    this.oAS.setAntiAlias(true);
    this.oAS.setTextAlign(Paint.Align.CENTER);
    this.oAS.setTextSize(this.oAd);
    if (this.oAn % 2 == 0) {
      this.oAn += 1;
    }
    if ((this.oAq == -1) || (this.oAr == -1)) {
      ccC();
    }
    initHandler();
    AppMethodBeat.o(138095);
  }
  
  private void initHandler()
  {
    AppMethodBeat.i(138096);
    this.oAW = new MMHandler("HandlerThread-For-Refreshing")
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        int j = 0;
        AppMethodBeat.i(138089);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(138089);
          return;
          if (!YANumberPicker.a(YANumberPicker.this).UD.isFinished())
          {
            if (YANumberPicker.b(YANumberPicker.this) == 0) {
              YANumberPicker.b(YANumberPicker.this, 1);
            }
            YANumberPicker.c(YANumberPicker.this).sendMessageDelayed(YANumberPicker.c(1, 0, 0, paramAnonymousMessage.obj), 32L);
            AppMethodBeat.o(138089);
            return;
          }
          int i;
          if (YANumberPicker.d(YANumberPicker.this) != 0)
          {
            if (YANumberPicker.b(YANumberPicker.this) == 0) {
              YANumberPicker.b(YANumberPicker.this, 1);
            }
            if (YANumberPicker.d(YANumberPicker.this) < -YANumberPicker.e(YANumberPicker.this) / 2)
            {
              j = (int)((YANumberPicker.e(YANumberPicker.this) + YANumberPicker.d(YANumberPicker.this)) * 300.0F / YANumberPicker.e(YANumberPicker.this));
              p localp = YANumberPicker.a(YANumberPicker.this);
              i = YANumberPicker.f(YANumberPicker.this);
              int k = YANumberPicker.e(YANumberPicker.this);
              localp.startScroll(0, i, 0, YANumberPicker.d(YANumberPicker.this) + k, j * 3);
              i = YANumberPicker.c(YANumberPicker.this, YANumberPicker.f(YANumberPicker.this) + YANumberPicker.e(YANumberPicker.this) + YANumberPicker.d(YANumberPicker.this));
              YANumberPicker.this.postInvalidate();
            }
          }
          for (;;)
          {
            paramAnonymousMessage = YANumberPicker.c(2, YANumberPicker.g(YANumberPicker.this), i, paramAnonymousMessage.obj);
            if (!YANumberPicker.h(YANumberPicker.this)) {
              break label418;
            }
            YANumberPicker.i(YANumberPicker.this).sendMessageDelayed(paramAnonymousMessage, j * 2);
            AppMethodBeat.o(138089);
            return;
            j = (int)(-YANumberPicker.d(YANumberPicker.this) * 300.0F / YANumberPicker.e(YANumberPicker.this));
            YANumberPicker.a(YANumberPicker.this).startScroll(0, YANumberPicker.f(YANumberPicker.this), 0, YANumberPicker.d(YANumberPicker.this), j * 3);
            i = YANumberPicker.c(YANumberPicker.this, YANumberPicker.f(YANumberPicker.this) + YANumberPicker.d(YANumberPicker.this));
            break;
            YANumberPicker.b(YANumberPicker.this, 0);
            i = YANumberPicker.c(YANumberPicker.this, YANumberPicker.f(YANumberPicker.this));
          }
          label418:
          YANumberPicker.c(YANumberPicker.this).sendMessageDelayed(paramAnonymousMessage, j * 2);
          AppMethodBeat.o(138089);
          return;
          YANumberPicker.a(YANumberPicker.this, paramAnonymousMessage.arg1, paramAnonymousMessage.arg2, paramAnonymousMessage.obj);
        }
      }
    };
    this.oAX = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(138090);
        super.handleMessage(paramAnonymousMessage);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(138090);
          return;
          YANumberPicker.this.requestLayout();
          AppMethodBeat.o(138090);
          return;
          YANumberPicker.a(YANumberPicker.this, paramAnonymousMessage.arg1, paramAnonymousMessage.arg2, paramAnonymousMessage.obj);
        }
      }
    };
    AppMethodBeat.o(138096);
  }
  
  private void jn(boolean paramBoolean)
  {
    AppMethodBeat.i(138131);
    ccA();
    ccB();
    if ((paramBoolean) && ((this.oBp == -2147483648) || (this.oBq == -2147483648))) {
      this.oAX.sendEmptyMessage(3);
    }
    AppMethodBeat.o(138131);
  }
  
  private void r(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(138119);
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt1 > paramInt2)
    {
      localIllegalArgumentException = new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + paramInt1 + ", maxShowIndex is " + paramInt2 + ".");
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (this.oAT == null)
    {
      localIllegalArgumentException = new IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt1 < 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("minShowIndex should not be less than 0, now minShowIndex is ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt1 > this.oAT.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.oAT.length - 1) + " minShowIndex is " + paramInt1);
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt2 < 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt2 > this.oAT.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.oAT.length - 1) + " maxShowIndex is " + paramInt2);
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    this.oAq = paramInt1;
    this.oAr = paramInt2;
    if (paramBoolean)
    {
      this.oAy = (this.oAq + 0);
      if ((!this.oAK) || (!this.oAM)) {
        break label335;
      }
    }
    label335:
    for (paramBoolean = true;; paramBoolean = false)
    {
      U(0, paramBoolean);
      postInvalidate();
      AppMethodBeat.o(138119);
      return;
    }
  }
  
  private static int s(int paramInt1, int paramInt2, boolean paramBoolean)
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
  
  public final void ccG()
  {
    AppMethodBeat.i(138141);
    ccF();
    if (this.oAW != null) {
      this.oAW.sendMessageDelayed(b(1, 0, 0, null), 0L);
    }
    AppMethodBeat.o(138141);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(138129);
    if (this.onv == 0)
    {
      AppMethodBeat.o(138129);
      return;
    }
    if (this.hgg.UD.computeScrollOffset())
    {
      this.oBo = this.hgg.UD.getCurrY();
      ccz();
      postInvalidate();
    }
    AppMethodBeat.o(138129);
  }
  
  public String getContentByCurrValue()
  {
    AppMethodBeat.i(138108);
    String str = this.oAT[(getValue() - this.oAs)];
    AppMethodBeat.o(138108);
    return str;
  }
  
  public String[] getDisplayedValues()
  {
    return this.oAT;
  }
  
  public int getMaxValue()
  {
    return this.oAt;
  }
  
  public int getMinValue()
  {
    return this.oAs;
  }
  
  public int getOneRecycleSize()
  {
    return this.oAr - this.oAq + 1;
  }
  
  public int getPickedIndexRelativeToRaw()
  {
    AppMethodBeat.i(138118);
    int i;
    if (this.oBn != 0) {
      if (this.oBn < -this.onv / 2) {
        i = Az(this.oBo + this.onv + this.oBn);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(138118);
      return i;
      i = Az(this.oBo + this.oBn);
      continue;
      i = Az(this.oBo);
    }
  }
  
  public int getRawContentSize()
  {
    if (this.oAT != null) {
      return this.oAT.length;
    }
    return 0;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(138107);
    int i = getPickedIndexRelativeToRaw();
    int j = this.oAs;
    AppMethodBeat.o(138107);
    return i + j;
  }
  
  public boolean getWrapSelectorWheel()
  {
    return this.oAK;
  }
  
  public boolean getWrapSelectorWheelAbsolutely()
  {
    return (this.oAK) && (this.oAM);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(138100);
    super.onAttachedToWindow();
    if (this.oAW == null) {
      initHandler();
    }
    AppMethodBeat.o(138100);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(138101);
    super.onDetachedFromWindow();
    this.oAW.quit();
    this.oAX = null;
    if (this.onv == 0)
    {
      AppMethodBeat.o(138101);
      return;
    }
    if (!this.hgg.UD.isFinished())
    {
      this.hgg.UD.abortAnimation();
      this.oBo = this.hgg.UD.getCurrY();
      ccz();
      if (this.oBn != 0)
      {
        if (this.oBn >= -this.onv / 2) {
          break label185;
        }
        this.oBo = (this.oBo + this.onv + this.oBn);
      }
    }
    for (;;)
    {
      ccz();
      Ay(0);
      int i = Az(this.oBo);
      if ((i != this.oAy) && (this.oAO)) {}
      try
      {
        if (this.oAZ != null) {
          this.oAZ.a(this, this.oAs + i);
        }
        this.oAy = i;
        AppMethodBeat.o(138101);
        return;
        label185:
        this.oBo += this.oBn;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.YANumberPicker", localException, "", new Object[0]);
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(138132);
    super.onDraw(paramCanvas);
    float f1 = 0.0F;
    int j = 0;
    if (j < this.oAn + 1)
    {
      float f5 = this.oBn + this.onv * j;
      int i = this.oBm;
      int k = getOneRecycleSize();
      boolean bool;
      label71:
      float f3;
      float f2;
      if ((this.oAK) && (this.oAM))
      {
        bool = true;
        k = s(i + j, k, bool);
        if (j != this.oAn / 2) {
          break label297;
        }
        f3 = (this.onv + this.oBn) / this.onv;
        i = a(f3, this.ozY, this.ozZ);
        f1 = this.oAb;
        f1 += (this.oAc - f1) * f3;
        f2 = this.oAG;
        f2 += (this.oAH - f2) * f3;
        label165:
        this.oAR.setColor(i);
        this.oAR.setTextSize(f1);
        if ((k < 0) || (k >= getOneRecycleSize())) {
          break label406;
        }
        String str = this.oAT[(this.oAq + k)];
        Object localObject = str;
        if (this.oAC != null) {
          localObject = TextUtils.ellipsize(str, this.oAR, getWidth() - this.oAj * 2, getEllipsizeType());
        }
        paramCanvas.drawText(((CharSequence)localObject).toString(), this.oBl, f2 + (f5 + this.onv / 2), this.oAR);
      }
      for (;;)
      {
        j += 1;
        f1 = f3;
        break;
        bool = false;
        break label71;
        label297:
        if (j == this.oAn / 2 + 1)
        {
          i = a(1.0F - f1, this.ozY, this.ozZ);
          f2 = this.oAb;
          f2 = (1.0F - f1) * (this.oAc - f2) + f2;
          f3 = this.oAG;
          f4 = (1.0F - f1) * (this.oAH - f3) + f3;
          f3 = f1;
          f1 = f2;
          f2 = f4;
          break label165;
        }
        i = this.ozY;
        float f4 = this.oAb;
        f2 = this.oAG;
        f3 = f1;
        f1 = f4;
        break label165;
        label406:
        if (!TextUtils.isEmpty(this.oAD)) {
          paramCanvas.drawText(this.oAD, this.oBl, f2 + (f5 + this.onv / 2), this.oAR);
        }
      }
    }
    if (this.oAJ)
    {
      paramCanvas.drawLine(getPaddingLeft() + this.oAl, this.oBj, this.aYN - getPaddingRight() - this.oAm, this.oBj, this.oAQ);
      paramCanvas.drawLine(getPaddingLeft() + this.oAl, this.oBk, this.aYN - getPaddingRight() - this.oAm, this.oBk, this.oAQ);
    }
    if (!TextUtils.isEmpty(this.oAB)) {
      paramCanvas.drawText(this.oAB, this.oBl + (this.oAu + this.oAe) / 2 + this.oAg, (this.oBj + this.oBk) / 2.0F + this.oAI, this.oAS);
    }
    AppMethodBeat.o(138132);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(138097);
    super.onMeasure(paramInt1, paramInt2);
    jn(false);
    int k = View.MeasureSpec.getMode(paramInt1);
    this.oBp = k;
    int j = View.MeasureSpec.getSize(paramInt1);
    if (k == 1073741824)
    {
      paramInt1 = j;
      j = View.MeasureSpec.getMode(paramInt2);
      this.oBq = j;
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      if (j != 1073741824) {
        break label214;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      AppMethodBeat.o(138097);
      return;
      if (Math.max(this.oAe, this.oAf) == 0)
      {
        paramInt1 = 0;
        label102:
        if (Math.max(this.oAe, this.oAf) != 0) {
          break label206;
        }
      }
      for (;;)
      {
        int m = this.oAw;
        int n = Math.max(this.oAu, this.oAx);
        i = Math.max(m, (paramInt1 + (i + Math.max(this.oAe, this.oAf)) + this.oAj * 2) * 2 + n) + (getPaddingLeft() + getPaddingRight());
        paramInt1 = i;
        if (k != -2147483648) {
          break;
        }
        paramInt1 = Math.min(i, j);
        break;
        paramInt1 = this.oAh;
        break label102;
        label206:
        i = this.oAg;
      }
      label214:
      i = this.oAn * (this.oAv + this.oAi * 2) + (getPaddingTop() + getPaddingBottom());
      if (j == -2147483648) {
        paramInt2 = Math.min(i, paramInt2);
      } else {
        paramInt2 = i;
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(138098);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.aYN = paramInt1;
    this.aYO = paramInt2;
    this.onv = (this.aYO / this.oAn);
    this.oBl = ((this.aYN + getPaddingLeft() - getPaddingRight()) / 2.0F);
    if (getOneRecycleSize() > 1) {
      if (this.mHasInit) {
        paramInt1 = getValue() - this.oAs;
      }
    }
    for (;;)
    {
      if ((this.oAK) && (this.oAM)) {}
      IllegalArgumentException localIllegalArgumentException;
      for (boolean bool = true;; bool = false)
      {
        U(paramInt1, bool);
        if (this.oAb > this.onv) {
          this.oAb = this.onv;
        }
        if (this.oAc > this.onv) {
          this.oAc = this.onv;
        }
        if (this.oAS != null) {
          break label209;
        }
        localIllegalArgumentException = new IllegalArgumentException("mPaintHint should not be null.");
        AppMethodBeat.o(138098);
        throw localIllegalArgumentException;
        if (this.oAL)
        {
          paramInt1 = this.oBm + (this.oAn - 1) / 2;
          break;
        }
        paramInt1 = 0;
        break;
      }
      label209:
      this.oAS.setTextSize(this.oAd);
      this.oAI = a(this.oAS.getFontMetrics());
      this.oAe = a(this.oAB, this.oAS);
      if (this.oAR == null)
      {
        localIllegalArgumentException = new IllegalArgumentException("mPaintText should not be null.");
        AppMethodBeat.o(138098);
        throw localIllegalArgumentException;
      }
      this.oAR.setTextSize(this.oAc);
      this.oAH = a(this.oAR.getFontMetrics());
      this.oAR.setTextSize(this.oAb);
      this.oAG = a(this.oAR.getFontMetrics());
      ccy();
      this.oAo = (this.oAn / 2);
      this.oAp = (this.oAo + 1);
      this.oBj = (this.oAo * this.aYO / this.oAn);
      this.oBk = (this.oAp * this.aYO / this.oAn);
      if (this.oAl < 0) {
        this.oAl = 0;
      }
      if (this.oAm < 0) {
        this.oAm = 0;
      }
      if ((this.oAl + this.oAm != 0) && (getPaddingLeft() + this.oAl >= this.aYN - getPaddingRight() - this.oAm))
      {
        paramInt1 = getPaddingLeft() + this.oAl + getPaddingRight() + this.oAm - this.aYN;
        this.oAl = ((int)(this.oAl - paramInt1 * this.oAl / (this.oAl + this.oAm)));
        this.oAm = ((int)(this.oAm - paramInt1 * this.oAm / (this.oAl + this.oAm)));
      }
      this.mHasInit = true;
      AppMethodBeat.o(138098);
      return;
      paramInt1 = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(138126);
    if (this.onv == 0)
    {
      AppMethodBeat.o(138126);
      return true;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    this.oBh = paramMotionEvent.getY();
    int i;
    label232:
    int j;
    int k;
    label330:
    int n;
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
    case 1: 
      do
      {
        float f;
        do
        {
          for (;;)
          {
            AppMethodBeat.o(138126);
            return true;
            this.oBi = true;
            this.oAW.removeMessages(1);
            ccF();
            this.dep = this.oBh;
            this.oBg = this.oBo;
            Ay(0);
            getParent().requestDisallowInterceptTouchEvent(true);
            continue;
            f = this.dep - this.oBh;
            if ((!this.oBi) || (-this.oAA >= f) || (f >= this.oAA))
            {
              this.oBi = false;
              this.oBo = AA((int)(f + this.oBg));
              ccz();
              invalidate();
            }
            Ay(1);
          }
          if (!this.oBi) {
            break;
          }
          f = paramMotionEvent.getY();
          i = 0;
        } while (i >= this.oAn);
        if ((this.onv * i > f) || (f >= this.onv * (i + 1))) {
          break;
        }
      } while ((i < 0) || (i >= this.oAn));
      i -= this.oAn / 2;
      if (this.oAK)
      {
        j = i;
        if (this.oAM) {}
      }
      else
      {
        k = getPickedIndexRelativeToRaw();
        if (k + i <= this.oAr) {
          break;
        }
        j = this.oAr - k;
      }
      if (this.oBn < -this.onv / 2)
      {
        k = this.onv + this.oBn;
        i = (int)((this.onv + this.oBn) * 300.0F / this.onv);
        if (j < 0)
        {
          i = -i - j * 300;
          label392:
          n = this.onv;
          if (i >= 300) {
            break label749;
          }
          i = 300;
        }
      }
      break;
    }
    label749:
    for (;;)
    {
      int m = i;
      if (i > 600) {
        m = 600;
      }
      this.hgg.startScroll(0, this.oBo, 0, k + j * n, m);
      this.oAW.sendMessageDelayed(b(1, 0, 0, null), m / 4);
      postInvalidate();
      break;
      j = i;
      if (k + i >= this.oAq) {
        break label330;
      }
      j = this.oAq - k;
      break label330;
      i += j * 300;
      break label392;
      k = this.oBn;
      i = (int)(-this.oBn * 300.0F / this.onv);
      if (j < 0)
      {
        i -= j * 300;
        break label392;
      }
      i += j * 300;
      break label392;
      i += 1;
      break label232;
      paramMotionEvent = this.mVelocityTracker;
      paramMotionEvent.computeCurrentVelocity(1000);
      j = (int)(paramMotionEvent.getYVelocity() * this.oAF);
      if (Math.abs(j) > this.oAz)
      {
        paramMotionEvent = this.hgg;
        i = this.oBo;
        j = -j;
        k = AA(-2147483648);
        m = AA(2147483647);
        paramMotionEvent.UD.fling(0, i, 0, j, -2147483648, 2147483647, k, m);
        invalidate();
        Ay(2);
      }
      this.oAW.sendMessageDelayed(b(1, 0, 0, null), 0L);
      if (this.mVelocityTracker == null) {
        break;
      }
      this.mVelocityTracker.clear();
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      break;
      this.oBg = this.oBo;
      ccF();
      this.oAW.sendMessageDelayed(b(1, 0, 0, null), 0L);
      break;
    }
  }
  
  public void postInvalidate()
  {
    AppMethodBeat.i(138099);
    if (!u.aD(this))
    {
      AppMethodBeat.o(138099);
      return;
    }
    super.postInvalidate();
    AppMethodBeat.o(138099);
  }
  
  public void setContentTextTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(138121);
    this.oAR.setTypeface(paramTypeface);
    AppMethodBeat.o(138121);
  }
  
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    boolean bool = true;
    AppMethodBeat.i(138102);
    if (this.oAW != null) {
      this.oAW.removeMessages(1);
    }
    ccF();
    if (paramArrayOfString == null)
    {
      paramArrayOfString = new IllegalArgumentException("newDisplayedValues should not be null.");
      AppMethodBeat.o(138102);
      throw paramArrayOfString;
    }
    if (this.oAt - this.oAs + 1 > paramArrayOfString.length)
    {
      paramArrayOfString = new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + (this.oAt - this.oAs + 1) + " newDisplayedValues.length is " + paramArrayOfString.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
      AppMethodBeat.o(138102);
      throw paramArrayOfString;
    }
    this.oAT = paramArrayOfString;
    ccE();
    jn(true);
    this.oAy = (this.oAq + 0);
    if ((this.oAK) && (this.oAM)) {}
    for (;;)
    {
      U(0, bool);
      postInvalidate();
      this.oAX.sendEmptyMessage(3);
      AppMethodBeat.o(138102);
      return;
      bool = false;
    }
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(138114);
    if (this.oAk == paramInt)
    {
      AppMethodBeat.o(138114);
      return;
    }
    this.oAk = paramInt;
    this.oAQ.setColor(this.oAk);
    postInvalidate();
    AppMethodBeat.o(138114);
  }
  
  public void setDividerHeight(int paramInt)
  {
    AppMethodBeat.i(138115);
    if (paramInt == this.aqo)
    {
      AppMethodBeat.o(138115);
      return;
    }
    this.aqo = paramInt;
    this.oAQ.setStrokeWidth(this.aqo);
    postInvalidate();
    AppMethodBeat.o(138115);
  }
  
  public void setEllipsizeType(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(138133);
    while (i < 3)
    {
      if (new String[] { "end", "middle", "start" }[i].equals(paramString))
      {
        this.oAC = paramString;
        AppMethodBeat.o(138133);
        return;
      }
      i += 1;
    }
    this.oAC = "end";
    AppMethodBeat.o(138133);
  }
  
  public void setFriction(float paramFloat)
  {
    AppMethodBeat.i(138120);
    if (paramFloat <= 0.0F)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("you should set a a positive float friction, now friction is ".concat(String.valueOf(paramFloat)));
      AppMethodBeat.o(138120);
      throw localIllegalArgumentException;
    }
    ViewConfiguration.get(getContext());
    this.oAF = (ViewConfiguration.getScrollFriction() / paramFloat);
    AppMethodBeat.o(138120);
  }
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(138109);
    String str = this.oAB;
    boolean bool;
    if (str == null) {
      if (paramString == null) {
        bool = true;
      }
    }
    while (bool)
    {
      AppMethodBeat.o(138109);
      return;
      bool = false;
      continue;
      bool = str.equals(paramString);
    }
    this.oAB = paramString;
    this.oAI = a(this.oAS.getFontMetrics());
    this.oAe = a(this.oAB, this.oAS);
    this.oAX.sendEmptyMessage(3);
    AppMethodBeat.o(138109);
  }
  
  public void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(138113);
    if (this.oAa == paramInt)
    {
      AppMethodBeat.o(138113);
      return;
    }
    this.oAa = paramInt;
    this.oAS.setColor(this.oAa);
    postInvalidate();
    AppMethodBeat.o(138113);
  }
  
  public void setHintTextTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(138122);
    this.oAS.setTypeface(paramTypeface);
    AppMethodBeat.o(138122);
  }
  
  public void setItemPaddingVertical(int paramInt)
  {
    AppMethodBeat.i(138116);
    if (this.oAi == paramInt)
    {
      AppMethodBeat.o(138116);
      return;
    }
    this.oAi = paramInt;
    postInvalidate();
    AppMethodBeat.o(138116);
  }
  
  public void setMaxValue(int paramInt)
  {
    AppMethodBeat.i(138105);
    Object localObject;
    if (this.oAT == null)
    {
      localObject = new NullPointerException("mDisplayedValues should not be null");
      AppMethodBeat.o(138105);
      throw ((Throwable)localObject);
    }
    if (paramInt - this.oAs + 1 > this.oAT.length)
    {
      localObject = new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + (paramInt - this.oAs + 1) + " and mDisplayedValues.length is " + this.oAT.length);
      AppMethodBeat.o(138105);
      throw ((Throwable)localObject);
    }
    this.oAt = paramInt;
    this.oAr = (this.oAt - this.oAs + this.oAq);
    r(this.oAq, this.oAr, true);
    ccy();
    AppMethodBeat.o(138105);
  }
  
  public void setMinValue(int paramInt)
  {
    AppMethodBeat.i(138104);
    this.oAs = paramInt;
    this.oAq = 0;
    ccy();
    AppMethodBeat.o(138104);
  }
  
  public void setNormalTextColor(int paramInt)
  {
    AppMethodBeat.i(138111);
    if (this.ozY == paramInt)
    {
      AppMethodBeat.o(138111);
      return;
    }
    this.ozY = paramInt;
    postInvalidate();
    AppMethodBeat.o(138111);
  }
  
  public void setOnScrollListener(a parama)
  {
    this.oBa = parama;
  }
  
  public void setOnValueChangeListenerInScrolling(c paramc)
  {
    this.oBb = paramc;
  }
  
  public void setOnValueChangedListener(b paramb)
  {
    this.oAZ = paramb;
  }
  
  public void setOnValueChangedListenerRelativeToRaw(d paramd)
  {
    this.oAY = paramd;
  }
  
  public void setPickedIndexRelativeToMin(int paramInt)
  {
    AppMethodBeat.i(138110);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      this.oAy = (this.oAq + paramInt);
      if ((!this.oAK) || (!this.oAM)) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      U(paramInt, bool);
      postInvalidate();
      AppMethodBeat.o(138110);
      return;
    }
  }
  
  public void setPickedIndexRelativeToRaw(int paramInt)
  {
    AppMethodBeat.i(138117);
    int i;
    if ((this.oAq >= 0) && (this.oAq <= paramInt) && (paramInt <= this.oAr))
    {
      this.oAy = paramInt;
      i = this.oAq;
      if ((!this.oAK) || (!this.oAM)) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      U(paramInt - i, bool);
      postInvalidate();
      AppMethodBeat.o(138117);
      return;
    }
  }
  
  public void setSelectedTextColor(int paramInt)
  {
    AppMethodBeat.i(138112);
    if (this.ozZ == paramInt)
    {
      AppMethodBeat.o(138112);
      return;
    }
    this.ozZ = paramInt;
    postInvalidate();
    AppMethodBeat.o(138112);
  }
  
  public void setValue(int paramInt)
  {
    AppMethodBeat.i(138106);
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt < this.oAs)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value less than mMinValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(138106);
      throw localIllegalArgumentException;
    }
    if (paramInt > this.oAt)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value greater than mMaxValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(138106);
      throw localIllegalArgumentException;
    }
    setPickedIndexRelativeToRaw(paramInt - this.oAs);
    AppMethodBeat.o(138106);
  }
  
  public void setWrapSelectorWheel(boolean paramBoolean)
  {
    AppMethodBeat.i(138103);
    if (this.oAK != paramBoolean)
    {
      if (!paramBoolean)
      {
        if (this.mScrollState == 0)
        {
          ccx();
          AppMethodBeat.o(138103);
          return;
        }
        this.oAN = true;
        AppMethodBeat.o(138103);
        return;
      }
      this.oAK = paramBoolean;
      ccE();
      postInvalidate();
    }
    AppMethodBeat.o(138103);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract void a(YANumberPicker paramYANumberPicker, int paramInt);
  }
  
  public static abstract interface c {}
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker
 * JD-Core Version:    0.7.0.1
 */