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
import androidx.core.g.w;
import androidx.core.widget.h;
import com.tencent.luggage.b.a.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class YANumberPicker
  extends View
{
  private int aIj;
  private int aIk;
  private float diu;
  private h jRY;
  private boolean mHasInit;
  private int mScrollState;
  private VelocityTracker mVelocityTracker;
  private int rCH;
  private int rCI;
  private int rCJ;
  private int rCK;
  private int rCL;
  private int rCM;
  private int rCN;
  private int rCO;
  private int rCP;
  private int rCQ;
  private int rCR;
  private int rCS;
  private int rCT;
  private int rCU;
  private int rCV;
  private int rCW;
  private int rCX;
  private int rCY;
  private int rCZ;
  private TextPaint rDA;
  private Paint rDB;
  private String[] rDC;
  private CharSequence[] rDD;
  private CharSequence[] rDE;
  private MMHandler rDF;
  private Handler rDG;
  private d rDH;
  private YANumberPicker.b rDI;
  private a rDJ;
  private c rDK;
  private int rDL;
  private int rDM;
  private int rDN;
  private int rDO;
  private float rDP;
  private float rDQ;
  private boolean rDR;
  private float rDS;
  private float rDT;
  private float rDU;
  private int rDV;
  private int rDW;
  private int rDX;
  private int rDY;
  private int rDZ;
  private int rDa;
  private int rDb;
  private int rDc;
  private int rDd;
  private int rDe;
  private int rDf;
  private int rDg;
  private int rDh;
  private int rDi;
  private int rDj;
  private String rDk;
  private String rDl;
  private String rDm;
  private String rDn;
  private float rDo;
  private float rDp;
  private float rDq;
  private float rDr;
  private boolean rDs;
  private boolean rDt;
  private boolean rDu;
  private boolean rDv;
  private boolean rDw;
  private boolean rDx;
  private boolean rDy;
  private Paint rDz;
  private int rpO;
  private int sS;
  
  public YANumberPicker(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138091);
    this.rCH = -13421773;
    this.rCI = -695533;
    this.rCJ = -695533;
    this.rCK = 0;
    this.rCL = 0;
    this.rCM = 0;
    this.rCN = 0;
    this.rCO = 0;
    this.rCP = 0;
    this.rCQ = 0;
    this.rCR = 0;
    this.rCS = 0;
    this.rCT = -695533;
    this.sS = 2;
    this.rCU = 0;
    this.rCV = 0;
    this.rCW = 3;
    this.rCX = 0;
    this.rCY = 0;
    this.rCZ = -1;
    this.rDa = -1;
    this.rDb = 0;
    this.rDc = 0;
    this.rDd = 0;
    this.rDe = 0;
    this.rDf = 0;
    this.rDg = 0;
    this.rDh = 0;
    this.rDi = 150;
    this.rDj = 8;
    this.rDo = 1.0F;
    this.rDp = 0.0F;
    this.rDq = 0.0F;
    this.rDr = 0.0F;
    this.rDs = true;
    this.rDt = true;
    this.rDu = false;
    this.mHasInit = false;
    this.rDv = true;
    this.rDw = false;
    this.rDx = false;
    this.rDy = true;
    this.rDz = new Paint();
    this.rDA = new TextPaint();
    this.rDB = new Paint();
    this.mScrollState = 0;
    this.rDP = 0.0F;
    this.diu = 0.0F;
    this.rDQ = 0.0F;
    this.rDR = false;
    this.rDV = 0;
    this.rDW = 0;
    this.rDX = 0;
    this.rDY = 0;
    this.rDZ = 0;
    init(paramContext);
    AppMethodBeat.o(138091);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138092);
    this.rCH = -13421773;
    this.rCI = -695533;
    this.rCJ = -695533;
    this.rCK = 0;
    this.rCL = 0;
    this.rCM = 0;
    this.rCN = 0;
    this.rCO = 0;
    this.rCP = 0;
    this.rCQ = 0;
    this.rCR = 0;
    this.rCS = 0;
    this.rCT = -695533;
    this.sS = 2;
    this.rCU = 0;
    this.rCV = 0;
    this.rCW = 3;
    this.rCX = 0;
    this.rCY = 0;
    this.rCZ = -1;
    this.rDa = -1;
    this.rDb = 0;
    this.rDc = 0;
    this.rDd = 0;
    this.rDe = 0;
    this.rDf = 0;
    this.rDg = 0;
    this.rDh = 0;
    this.rDi = 150;
    this.rDj = 8;
    this.rDo = 1.0F;
    this.rDp = 0.0F;
    this.rDq = 0.0F;
    this.rDr = 0.0F;
    this.rDs = true;
    this.rDt = true;
    this.rDu = false;
    this.mHasInit = false;
    this.rDv = true;
    this.rDw = false;
    this.rDx = false;
    this.rDy = true;
    this.rDz = new Paint();
    this.rDA = new TextPaint();
    this.rDB = new Paint();
    this.mScrollState = 0;
    this.rDP = 0.0F;
    this.diu = 0.0F;
    this.rDQ = 0.0F;
    this.rDR = false;
    this.rDV = 0;
    this.rDW = 0;
    this.rDX = 0;
    this.rDY = 0;
    this.rDZ = 0;
    a(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(138092);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138093);
    this.rCH = -13421773;
    this.rCI = -695533;
    this.rCJ = -695533;
    this.rCK = 0;
    this.rCL = 0;
    this.rCM = 0;
    this.rCN = 0;
    this.rCO = 0;
    this.rCP = 0;
    this.rCQ = 0;
    this.rCR = 0;
    this.rCS = 0;
    this.rCT = -695533;
    this.sS = 2;
    this.rCU = 0;
    this.rCV = 0;
    this.rCW = 3;
    this.rCX = 0;
    this.rCY = 0;
    this.rCZ = -1;
    this.rDa = -1;
    this.rDb = 0;
    this.rDc = 0;
    this.rDd = 0;
    this.rDe = 0;
    this.rDf = 0;
    this.rDg = 0;
    this.rDh = 0;
    this.rDi = 150;
    this.rDj = 8;
    this.rDo = 1.0F;
    this.rDp = 0.0F;
    this.rDq = 0.0F;
    this.rDr = 0.0F;
    this.rDs = true;
    this.rDt = true;
    this.rDu = false;
    this.mHasInit = false;
    this.rDv = true;
    this.rDw = false;
    this.rDx = false;
    this.rDy = true;
    this.rDz = new Paint();
    this.rDA = new TextPaint();
    this.rDB = new Paint();
    this.mScrollState = 0;
    this.rDP = 0.0F;
    this.diu = 0.0F;
    this.rDQ = 0.0F;
    this.rDR = false;
    this.rDV = 0;
    this.rDW = 0;
    this.rDX = 0;
    this.rDY = 0;
    this.rDZ = 0;
    a(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(138093);
  }
  
  private void Ef(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
  }
  
  private int Eg(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(138123);
    if (this.rpO == 0)
    {
      AppMethodBeat.o(138123);
      return 0;
    }
    paramInt /= this.rpO;
    int i = this.rCW / 2;
    int j = getOneRecycleSize();
    boolean bool1 = bool2;
    if (this.rDt)
    {
      bool1 = bool2;
      if (this.rDv) {
        bool1 = true;
      }
    }
    paramInt = u(paramInt + i, j, bool1);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      i = this.rCZ;
      AppMethodBeat.o(138123);
      return paramInt + i;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + paramInt + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.rDt);
    AppMethodBeat.o(138123);
    throw localIllegalArgumentException;
  }
  
  private int Eh(int paramInt)
  {
    if ((this.rDt) && (this.rDv)) {}
    do
    {
      return paramInt;
      if (paramInt < this.rDO) {
        return this.rDO;
      }
    } while (paramInt <= this.rDN);
    return this.rDN;
  }
  
  private void V(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(138128);
    this.rDV = (paramInt - (this.rCW - 1) / 2);
    this.rDV = u(this.rDV, getOneRecycleSize(), paramBoolean);
    if (this.rpO == 0)
    {
      this.rDu = true;
      AppMethodBeat.o(138128);
      return;
    }
    this.rDX = (this.rDV * this.rpO);
    this.rDL = (this.rDV + this.rCW / 2);
    this.rDL %= getOneRecycleSize();
    if (this.rDL < 0) {
      this.rDL += getOneRecycleSize();
    }
    this.rDM = this.rDL;
    cpQ();
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
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.YANumberPicker);
    int k = localTypedArray.getIndexCount();
    int i = 0;
    if (i < k)
    {
      int j = localTypedArray.getIndex(i);
      if (j == a.i.YANumberPicker_npv_ShowCount) {
        this.rCW = localTypedArray.getInt(j, 3);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == a.i.YANumberPicker_npv_DividerColor)
        {
          this.rCT = localTypedArray.getColor(j, -695533);
        }
        else if (j == a.i.YANumberPicker_npv_DividerHeight)
        {
          this.sS = localTypedArray.getDimensionPixelSize(j, 2);
        }
        else if (j == a.i.YANumberPicker_npv_DividerMarginLeft)
        {
          this.rCU = localTypedArray.getDimensionPixelSize(j, 0);
        }
        else if (j == a.i.YANumberPicker_npv_DividerMarginRight)
        {
          this.rCV = localTypedArray.getDimensionPixelSize(j, 0);
        }
        else
        {
          if (j == a.i.YANumberPicker_npv_TextArray)
          {
            CharSequence[] arrayOfCharSequence = localTypedArray.getTextArray(j);
            if (arrayOfCharSequence == null) {
              paramAttributeSet = null;
            }
            for (;;)
            {
              this.rDC = paramAttributeSet;
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
          if (j == a.i.YANumberPicker_npv_TextColorNormal) {
            this.rCH = localTypedArray.getColor(j, -13421773);
          } else if (j == a.i.YANumberPicker_npv_TextColorSelected) {
            this.rCI = localTypedArray.getColor(j, -695533);
          } else if (j == a.i.YANumberPicker_npv_TextColorHint) {
            this.rCJ = localTypedArray.getColor(j, -695533);
          } else if (j == a.i.YANumberPicker_npv_TextSizeNormal) {
            this.rCK = localTypedArray.getDimensionPixelSize(j, d(paramContext, 13.0F));
          } else if (j == a.i.YANumberPicker_npv_TextSizeSelected) {
            this.rCL = localTypedArray.getDimensionPixelSize(j, d(paramContext, 15.0F));
          } else if (j == a.i.YANumberPicker_npv_TextSizeHint) {
            this.rCM = localTypedArray.getDimensionPixelSize(j, d(paramContext, 14.0F));
          } else if (j == a.i.YANumberPicker_npv_MinValue) {
            this.rCZ = localTypedArray.getInteger(j, 0);
          } else if (j == a.i.YANumberPicker_npv_MaxValue) {
            this.rDa = localTypedArray.getInteger(j, 0);
          } else if (j == a.i.YANumberPicker_npv_WrapSelectorWheel) {
            this.rDt = localTypedArray.getBoolean(j, true);
          } else if (j == a.i.YANumberPicker_npv_ShowDivider) {
            this.rDs = localTypedArray.getBoolean(j, true);
          } else if (j == a.i.YANumberPicker_npv_HintText) {
            this.rDk = localTypedArray.getString(j);
          } else if (j == a.i.YANumberPicker_npv_AlternativeHint) {
            this.rDn = localTypedArray.getString(j);
          } else if (j == a.i.YANumberPicker_npv_EmptyItemHint) {
            this.rDm = localTypedArray.getString(j);
          } else if (j == a.i.YANumberPicker_npv_MarginStartOfHint) {
            this.rCP = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == a.i.YANumberPicker_npv_MarginEndOfHint) {
            this.rCQ = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == a.i.YANumberPicker_npv_ItemPaddingVertical) {
            this.rCR = localTypedArray.getDimensionPixelSize(j, e(paramContext, 2.0F));
          } else if (j == a.i.YANumberPicker_npv_ItemPaddingHorizontal) {
            this.rCS = localTypedArray.getDimensionPixelSize(j, e(paramContext, 5.0F));
          } else if (j == a.i.YANumberPicker_npv_AlternativeTextArrayWithMeasureHint) {
            this.rDD = localTypedArray.getTextArray(j);
          } else if (j == a.i.YANumberPicker_npv_AlternativeTextArrayWithoutMeasureHint) {
            this.rDE = localTypedArray.getTextArray(j);
          } else if (j == a.i.YANumberPicker_npv_RespondChangeOnDetached) {
            this.rDx = localTypedArray.getBoolean(j, false);
          } else if (j == a.i.YANumberPicker_npv_RespondChangeInMainThread) {
            this.rDy = localTypedArray.getBoolean(j, true);
          } else if (j == a.i.YANumberPicker_npv_TextEllipsize) {
            this.rDl = localTypedArray.getString(j);
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
  
  private void cpO()
  {
    AppMethodBeat.i(138124);
    V(getPickedIndexRelativeToRaw() - this.rCZ, false);
    this.rDt = false;
    postInvalidate();
    AppMethodBeat.o(138124);
  }
  
  private void cpP()
  {
    AppMethodBeat.i(138125);
    this.rDN = 0;
    this.rDO = (-this.rCW * this.rpO);
    if (this.rDC != null)
    {
      this.rDN = ((getOneRecycleSize() - this.rCW / 2 - 1) * this.rpO);
      this.rDO = (-(this.rCW / 2) * this.rpO);
    }
    AppMethodBeat.o(138125);
  }
  
  private void cpQ()
  {
    AppMethodBeat.i(138130);
    this.rDV = ((int)Math.floor(this.rDX / this.rpO));
    this.rDW = (-(this.rDX - this.rDV * this.rpO));
    if (this.rDK != null) {
      if (-this.rDW <= this.rpO / 2) {
        break label131;
      }
    }
    label131:
    for (this.rDM = (this.rDV + 1 + this.rCW / 2);; this.rDM = (this.rDV + this.rCW / 2))
    {
      this.rDM %= getOneRecycleSize();
      if (this.rDM < 0) {
        this.rDM += getOneRecycleSize();
      }
      this.rDL = this.rDM;
      AppMethodBeat.o(138130);
      return;
    }
  }
  
  private void cpR()
  {
    AppMethodBeat.i(138135);
    float f = this.rDA.getTextSize();
    this.rDA.setTextSize(this.rCL);
    this.rDd = a(this.rDC, this.rDA);
    this.rDf = a(this.rDD, this.rDA);
    this.rDg = a(this.rDE, this.rDA);
    this.rDA.setTextSize(this.rCM);
    this.rCO = a(this.rDn, this.rDA);
    this.rDA.setTextSize(f);
    AppMethodBeat.o(138135);
  }
  
  private void cpS()
  {
    AppMethodBeat.i(138138);
    float f = this.rDA.getTextSize();
    this.rDA.setTextSize(this.rCL);
    this.rDe = ((int)(this.rDA.getFontMetrics().bottom - this.rDA.getFontMetrics().top + 0.5D));
    this.rDA.setTextSize(f);
    AppMethodBeat.o(138138);
  }
  
  private void cpT()
  {
    AppMethodBeat.i(138139);
    cpU();
    cpV();
    if (this.rCZ == -1) {
      this.rCZ = 0;
    }
    if (this.rDa == -1) {
      this.rDa = (this.rDC.length - 1);
    }
    t(this.rCZ, this.rDa, false);
    AppMethodBeat.o(138139);
  }
  
  private void cpU()
  {
    if (this.rDC == null)
    {
      this.rDC = new String[1];
      this.rDC[0] = "0";
    }
  }
  
  private void cpV()
  {
    if (this.rDC.length <= this.rCW) {}
    for (boolean bool = false;; bool = true)
    {
      this.rDv = bool;
      return;
    }
  }
  
  private void cpW()
  {
    AppMethodBeat.i(138140);
    if ((this.jRY != null) && (!this.jRY.Qi.isFinished()))
    {
      this.jRY.startScroll(0, this.jRY.Qi.getCurrY(), 0, 0, 1);
      this.jRY.Qi.abortAnimation();
      postInvalidate();
    }
    AppMethodBeat.o(138140);
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
    Object localObject = this.rDl;
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
    this.jRY = h.a(paramContext, null);
    this.rDi = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    this.rDj = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    if (this.rCK == 0) {
      this.rCK = d(paramContext, 13.0F);
    }
    if (this.rCL == 0) {
      this.rCL = d(paramContext, 15.0F);
    }
    if (this.rCM == 0) {
      this.rCM = d(paramContext, 14.0F);
    }
    if (this.rCP == 0) {
      this.rCP = e(paramContext, 8.0F);
    }
    if (this.rCQ == 0) {
      this.rCQ = e(paramContext, 8.0F);
    }
    this.rDz.setColor(this.rCT);
    this.rDz.setAntiAlias(true);
    this.rDz.setStyle(Paint.Style.STROKE);
    this.rDz.setStrokeWidth(this.sS);
    this.rDA.setColor(this.rCH);
    this.rDA.setAntiAlias(true);
    this.rDA.setTextAlign(Paint.Align.CENTER);
    this.rDB.setColor(this.rCJ);
    this.rDB.setAntiAlias(true);
    this.rDB.setTextAlign(Paint.Align.CENTER);
    this.rDB.setTextSize(this.rCM);
    if (this.rCW % 2 == 0) {
      this.rCW += 1;
    }
    if ((this.rCZ == -1) || (this.rDa == -1)) {
      cpT();
    }
    initHandler();
    AppMethodBeat.o(138095);
  }
  
  private void initHandler()
  {
    AppMethodBeat.i(138096);
    this.rDF = new MMHandler("HandlerThread-For-Refreshing")
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
          if (!YANumberPicker.a(YANumberPicker.this).Qi.isFinished())
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
              h localh = YANumberPicker.a(YANumberPicker.this);
              i = YANumberPicker.f(YANumberPicker.this);
              int k = YANumberPicker.e(YANumberPicker.this);
              localh.startScroll(0, i, 0, YANumberPicker.d(YANumberPicker.this) + k, j * 3);
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
    this.rDG = new Handler()
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
  
  private void ky(boolean paramBoolean)
  {
    AppMethodBeat.i(138131);
    cpR();
    cpS();
    if ((paramBoolean) && ((this.rDY == -2147483648) || (this.rDZ == -2147483648))) {
      this.rDG.sendEmptyMessage(3);
    }
    AppMethodBeat.o(138131);
  }
  
  private void t(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(138119);
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt1 > paramInt2)
    {
      localIllegalArgumentException = new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + paramInt1 + ", maxShowIndex is " + paramInt2 + ".");
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (this.rDC == null)
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
    if (paramInt1 > this.rDC.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.rDC.length - 1) + " minShowIndex is " + paramInt1);
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt2 < 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt2 > this.rDC.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.rDC.length - 1) + " maxShowIndex is " + paramInt2);
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    this.rCZ = paramInt1;
    this.rDa = paramInt2;
    if (paramBoolean)
    {
      this.rDh = (this.rCZ + 0);
      if ((!this.rDt) || (!this.rDv)) {
        break label335;
      }
    }
    label335:
    for (paramBoolean = true;; paramBoolean = false)
    {
      V(0, paramBoolean);
      postInvalidate();
      AppMethodBeat.o(138119);
      return;
    }
  }
  
  private static int u(int paramInt1, int paramInt2, boolean paramBoolean)
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
  
  public void computeScroll()
  {
    AppMethodBeat.i(138129);
    if (this.rpO == 0)
    {
      AppMethodBeat.o(138129);
      return;
    }
    if (this.jRY.Qi.computeScrollOffset())
    {
      this.rDX = this.jRY.Qi.getCurrY();
      cpQ();
      postInvalidate();
    }
    AppMethodBeat.o(138129);
  }
  
  public final void cpX()
  {
    AppMethodBeat.i(138141);
    cpW();
    if (this.rDF != null) {
      this.rDF.sendMessageDelayed(b(1, 0, 0, null), 0L);
    }
    AppMethodBeat.o(138141);
  }
  
  public String getContentByCurrValue()
  {
    AppMethodBeat.i(138108);
    String str = this.rDC[(getValue() - this.rDb)];
    AppMethodBeat.o(138108);
    return str;
  }
  
  public String[] getDisplayedValues()
  {
    return this.rDC;
  }
  
  public int getMaxValue()
  {
    return this.rDc;
  }
  
  public int getMinValue()
  {
    return this.rDb;
  }
  
  public int getOneRecycleSize()
  {
    return this.rDa - this.rCZ + 1;
  }
  
  public int getPickedIndexRelativeToRaw()
  {
    AppMethodBeat.i(138118);
    int i;
    if (this.rDW != 0) {
      if (this.rDW < -this.rpO / 2) {
        i = Eg(this.rDX + this.rpO + this.rDW);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(138118);
      return i;
      i = Eg(this.rDX + this.rDW);
      continue;
      i = Eg(this.rDX);
    }
  }
  
  public int getRawContentSize()
  {
    if (this.rDC != null) {
      return this.rDC.length;
    }
    return 0;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(138107);
    int i = getPickedIndexRelativeToRaw();
    int j = this.rDb;
    AppMethodBeat.o(138107);
    return i + j;
  }
  
  public boolean getWrapSelectorWheel()
  {
    return this.rDt;
  }
  
  public boolean getWrapSelectorWheelAbsolutely()
  {
    return (this.rDt) && (this.rDv);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(138100);
    super.onAttachedToWindow();
    if (this.rDF == null) {
      initHandler();
    }
    AppMethodBeat.o(138100);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(138101);
    super.onDetachedFromWindow();
    this.rDF.quit();
    this.rDG = null;
    if (this.rpO == 0)
    {
      AppMethodBeat.o(138101);
      return;
    }
    if (!this.jRY.Qi.isFinished())
    {
      this.jRY.Qi.abortAnimation();
      this.rDX = this.jRY.Qi.getCurrY();
      cpQ();
      if (this.rDW != 0)
      {
        if (this.rDW >= -this.rpO / 2) {
          break label185;
        }
        this.rDX = (this.rDX + this.rpO + this.rDW);
      }
    }
    for (;;)
    {
      cpQ();
      Ef(0);
      int i = Eg(this.rDX);
      if ((i != this.rDh) && (this.rDx)) {}
      try
      {
        if (this.rDI != null) {
          this.rDI.a(this, this.rDb + i);
        }
        this.rDh = i;
        AppMethodBeat.o(138101);
        return;
        label185:
        this.rDX += this.rDW;
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
    if (j < this.rCW + 1)
    {
      float f5 = this.rDW + this.rpO * j;
      int i = this.rDV;
      int k = getOneRecycleSize();
      boolean bool;
      label71:
      float f3;
      float f2;
      if ((this.rDt) && (this.rDv))
      {
        bool = true;
        k = u(i + j, k, bool);
        if (j != this.rCW / 2) {
          break label297;
        }
        f3 = (this.rpO + this.rDW) / this.rpO;
        i = a(f3, this.rCH, this.rCI);
        f1 = this.rCK;
        f1 += (this.rCL - f1) * f3;
        f2 = this.rDp;
        f2 += (this.rDq - f2) * f3;
        label165:
        this.rDA.setColor(i);
        this.rDA.setTextSize(f1);
        if ((k < 0) || (k >= getOneRecycleSize())) {
          break label406;
        }
        String str = this.rDC[(this.rCZ + k)];
        Object localObject = str;
        if (this.rDl != null) {
          localObject = TextUtils.ellipsize(str, this.rDA, getWidth() - this.rCS * 2, getEllipsizeType());
        }
        paramCanvas.drawText(((CharSequence)localObject).toString(), this.rDU, f2 + (f5 + this.rpO / 2), this.rDA);
      }
      for (;;)
      {
        j += 1;
        f1 = f3;
        break;
        bool = false;
        break label71;
        label297:
        if (j == this.rCW / 2 + 1)
        {
          i = a(1.0F - f1, this.rCH, this.rCI);
          f2 = this.rCK;
          f2 = (1.0F - f1) * (this.rCL - f2) + f2;
          f3 = this.rDp;
          f4 = (1.0F - f1) * (this.rDq - f3) + f3;
          f3 = f1;
          f1 = f2;
          f2 = f4;
          break label165;
        }
        i = this.rCH;
        float f4 = this.rCK;
        f2 = this.rDp;
        f3 = f1;
        f1 = f4;
        break label165;
        label406:
        if (!TextUtils.isEmpty(this.rDm)) {
          paramCanvas.drawText(this.rDm, this.rDU, f2 + (f5 + this.rpO / 2), this.rDA);
        }
      }
    }
    if (this.rDs)
    {
      paramCanvas.drawLine(getPaddingLeft() + this.rCU, this.rDS, this.aIj - getPaddingRight() - this.rCV, this.rDS, this.rDz);
      paramCanvas.drawLine(getPaddingLeft() + this.rCU, this.rDT, this.aIj - getPaddingRight() - this.rCV, this.rDT, this.rDz);
    }
    if (!TextUtils.isEmpty(this.rDk)) {
      paramCanvas.drawText(this.rDk, this.rDU + (this.rDd + this.rCN) / 2 + this.rCP, (this.rDS + this.rDT) / 2.0F + this.rDr, this.rDB);
    }
    AppMethodBeat.o(138132);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(138097);
    super.onMeasure(paramInt1, paramInt2);
    ky(false);
    int k = View.MeasureSpec.getMode(paramInt1);
    this.rDY = k;
    int j = View.MeasureSpec.getSize(paramInt1);
    if (k == 1073741824)
    {
      paramInt1 = j;
      j = View.MeasureSpec.getMode(paramInt2);
      this.rDZ = j;
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
      if (Math.max(this.rCN, this.rCO) == 0)
      {
        paramInt1 = 0;
        label102:
        if (Math.max(this.rCN, this.rCO) != 0) {
          break label206;
        }
      }
      for (;;)
      {
        int m = this.rDf;
        int n = Math.max(this.rDd, this.rDg);
        i = Math.max(m, (paramInt1 + (i + Math.max(this.rCN, this.rCO)) + this.rCS * 2) * 2 + n) + (getPaddingLeft() + getPaddingRight());
        paramInt1 = i;
        if (k != -2147483648) {
          break;
        }
        paramInt1 = Math.min(i, j);
        break;
        paramInt1 = this.rCQ;
        break label102;
        label206:
        i = this.rCP;
      }
      label214:
      i = this.rCW * (this.rDe + this.rCR * 2) + (getPaddingTop() + getPaddingBottom());
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
    this.aIj = paramInt1;
    this.aIk = paramInt2;
    this.rpO = (this.aIk / this.rCW);
    this.rDU = ((this.aIj + getPaddingLeft() - getPaddingRight()) / 2.0F);
    if (getOneRecycleSize() > 1) {
      if (this.mHasInit) {
        paramInt1 = getValue() - this.rDb;
      }
    }
    for (;;)
    {
      if ((this.rDt) && (this.rDv)) {}
      IllegalArgumentException localIllegalArgumentException;
      for (boolean bool = true;; bool = false)
      {
        V(paramInt1, bool);
        if (this.rCK > this.rpO) {
          this.rCK = this.rpO;
        }
        if (this.rCL > this.rpO) {
          this.rCL = this.rpO;
        }
        if (this.rDB != null) {
          break label209;
        }
        localIllegalArgumentException = new IllegalArgumentException("mPaintHint should not be null.");
        AppMethodBeat.o(138098);
        throw localIllegalArgumentException;
        if (this.rDu)
        {
          paramInt1 = this.rDV + (this.rCW - 1) / 2;
          break;
        }
        paramInt1 = 0;
        break;
      }
      label209:
      this.rDB.setTextSize(this.rCM);
      this.rDr = a(this.rDB.getFontMetrics());
      this.rCN = a(this.rDk, this.rDB);
      if (this.rDA == null)
      {
        localIllegalArgumentException = new IllegalArgumentException("mPaintText should not be null.");
        AppMethodBeat.o(138098);
        throw localIllegalArgumentException;
      }
      this.rDA.setTextSize(this.rCL);
      this.rDq = a(this.rDA.getFontMetrics());
      this.rDA.setTextSize(this.rCK);
      this.rDp = a(this.rDA.getFontMetrics());
      cpP();
      this.rCX = (this.rCW / 2);
      this.rCY = (this.rCX + 1);
      this.rDS = (this.rCX * this.aIk / this.rCW);
      this.rDT = (this.rCY * this.aIk / this.rCW);
      if (this.rCU < 0) {
        this.rCU = 0;
      }
      if (this.rCV < 0) {
        this.rCV = 0;
      }
      if ((this.rCU + this.rCV != 0) && (getPaddingLeft() + this.rCU >= this.aIj - getPaddingRight() - this.rCV))
      {
        paramInt1 = getPaddingLeft() + this.rCU + getPaddingRight() + this.rCV - this.aIj;
        this.rCU = ((int)(this.rCU - paramInt1 * this.rCU / (this.rCU + this.rCV)));
        this.rCV = ((int)(this.rCV - paramInt1 * this.rCV / (this.rCU + this.rCV)));
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
    if (this.rpO == 0)
    {
      AppMethodBeat.o(138126);
      return true;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    this.rDQ = paramMotionEvent.getY();
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
            this.rDR = true;
            this.rDF.removeMessages(1);
            cpW();
            this.diu = this.rDQ;
            this.rDP = this.rDX;
            Ef(0);
            getParent().requestDisallowInterceptTouchEvent(true);
            continue;
            f = this.diu - this.rDQ;
            if ((!this.rDR) || (-this.rDj >= f) || (f >= this.rDj))
            {
              this.rDR = false;
              this.rDX = Eh((int)(f + this.rDP));
              cpQ();
              invalidate();
            }
            Ef(1);
          }
          if (!this.rDR) {
            break;
          }
          f = paramMotionEvent.getY();
          i = 0;
        } while (i >= this.rCW);
        if ((this.rpO * i > f) || (f >= this.rpO * (i + 1))) {
          break;
        }
      } while ((i < 0) || (i >= this.rCW));
      i -= this.rCW / 2;
      if (this.rDt)
      {
        j = i;
        if (this.rDv) {}
      }
      else
      {
        k = getPickedIndexRelativeToRaw();
        if (k + i <= this.rDa) {
          break;
        }
        j = this.rDa - k;
      }
      if (this.rDW < -this.rpO / 2)
      {
        k = this.rpO + this.rDW;
        i = (int)((this.rpO + this.rDW) * 300.0F / this.rpO);
        if (j < 0)
        {
          i = -i - j * 300;
          label392:
          n = this.rpO;
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
      this.jRY.startScroll(0, this.rDX, 0, k + j * n, m);
      this.rDF.sendMessageDelayed(b(1, 0, 0, null), m / 4);
      postInvalidate();
      break;
      j = i;
      if (k + i >= this.rCZ) {
        break label330;
      }
      j = this.rCZ - k;
      break label330;
      i += j * 300;
      break label392;
      k = this.rDW;
      i = (int)(-this.rDW * 300.0F / this.rpO);
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
      j = (int)(paramMotionEvent.getYVelocity() * this.rDo);
      if (Math.abs(j) > this.rDi)
      {
        paramMotionEvent = this.jRY;
        i = this.rDX;
        j = -j;
        k = Eh(-2147483648);
        m = Eh(2147483647);
        paramMotionEvent.Qi.fling(0, i, 0, j, -2147483648, 2147483647, k, m);
        invalidate();
        Ef(2);
      }
      this.rDF.sendMessageDelayed(b(1, 0, 0, null), 0L);
      if (this.mVelocityTracker == null) {
        break;
      }
      this.mVelocityTracker.clear();
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      break;
      this.rDP = this.rDX;
      cpW();
      this.rDF.sendMessageDelayed(b(1, 0, 0, null), 0L);
      break;
    }
  }
  
  public void postInvalidate()
  {
    AppMethodBeat.i(138099);
    if (!w.al(this))
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
    this.rDA.setTypeface(paramTypeface);
    AppMethodBeat.o(138121);
  }
  
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    boolean bool = true;
    AppMethodBeat.i(138102);
    if (this.rDF != null) {
      this.rDF.removeMessages(1);
    }
    cpW();
    if (paramArrayOfString == null)
    {
      paramArrayOfString = new IllegalArgumentException("newDisplayedValues should not be null.");
      AppMethodBeat.o(138102);
      throw paramArrayOfString;
    }
    if (this.rDc - this.rDb + 1 > paramArrayOfString.length)
    {
      paramArrayOfString = new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + (this.rDc - this.rDb + 1) + " newDisplayedValues.length is " + paramArrayOfString.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
      AppMethodBeat.o(138102);
      throw paramArrayOfString;
    }
    this.rDC = paramArrayOfString;
    cpV();
    ky(true);
    this.rDh = (this.rCZ + 0);
    if ((this.rDt) && (this.rDv)) {}
    for (;;)
    {
      V(0, bool);
      postInvalidate();
      this.rDG.sendEmptyMessage(3);
      AppMethodBeat.o(138102);
      return;
      bool = false;
    }
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(138114);
    if (this.rCT == paramInt)
    {
      AppMethodBeat.o(138114);
      return;
    }
    this.rCT = paramInt;
    this.rDz.setColor(this.rCT);
    postInvalidate();
    AppMethodBeat.o(138114);
  }
  
  public void setDividerHeight(int paramInt)
  {
    AppMethodBeat.i(138115);
    if (paramInt == this.sS)
    {
      AppMethodBeat.o(138115);
      return;
    }
    this.sS = paramInt;
    this.rDz.setStrokeWidth(this.sS);
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
        this.rDl = paramString;
        AppMethodBeat.o(138133);
        return;
      }
      i += 1;
    }
    this.rDl = "end";
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
    this.rDo = (ViewConfiguration.getScrollFriction() / paramFloat);
    AppMethodBeat.o(138120);
  }
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(138109);
    String str = this.rDk;
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
    this.rDk = paramString;
    this.rDr = a(this.rDB.getFontMetrics());
    this.rCN = a(this.rDk, this.rDB);
    this.rDG.sendEmptyMessage(3);
    AppMethodBeat.o(138109);
  }
  
  public void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(138113);
    if (this.rCJ == paramInt)
    {
      AppMethodBeat.o(138113);
      return;
    }
    this.rCJ = paramInt;
    this.rDB.setColor(this.rCJ);
    postInvalidate();
    AppMethodBeat.o(138113);
  }
  
  public void setHintTextTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(138122);
    this.rDB.setTypeface(paramTypeface);
    AppMethodBeat.o(138122);
  }
  
  public void setItemPaddingVertical(int paramInt)
  {
    AppMethodBeat.i(138116);
    if (this.rCR == paramInt)
    {
      AppMethodBeat.o(138116);
      return;
    }
    this.rCR = paramInt;
    postInvalidate();
    AppMethodBeat.o(138116);
  }
  
  public void setMaxValue(int paramInt)
  {
    AppMethodBeat.i(138105);
    Object localObject;
    if (this.rDC == null)
    {
      localObject = new NullPointerException("mDisplayedValues should not be null");
      AppMethodBeat.o(138105);
      throw ((Throwable)localObject);
    }
    if (paramInt - this.rDb + 1 > this.rDC.length)
    {
      localObject = new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + (paramInt - this.rDb + 1) + " and mDisplayedValues.length is " + this.rDC.length);
      AppMethodBeat.o(138105);
      throw ((Throwable)localObject);
    }
    this.rDc = paramInt;
    this.rDa = (this.rDc - this.rDb + this.rCZ);
    t(this.rCZ, this.rDa, true);
    cpP();
    AppMethodBeat.o(138105);
  }
  
  public void setMinValue(int paramInt)
  {
    AppMethodBeat.i(138104);
    this.rDb = paramInt;
    this.rCZ = 0;
    cpP();
    AppMethodBeat.o(138104);
  }
  
  public void setNormalTextColor(int paramInt)
  {
    AppMethodBeat.i(138111);
    if (this.rCH == paramInt)
    {
      AppMethodBeat.o(138111);
      return;
    }
    this.rCH = paramInt;
    postInvalidate();
    AppMethodBeat.o(138111);
  }
  
  public void setOnScrollListener(a parama)
  {
    this.rDJ = parama;
  }
  
  public void setOnValueChangeListenerInScrolling(c paramc)
  {
    this.rDK = paramc;
  }
  
  public void setOnValueChangedListener(YANumberPicker.b paramb)
  {
    this.rDI = paramb;
  }
  
  public void setOnValueChangedListenerRelativeToRaw(d paramd)
  {
    this.rDH = paramd;
  }
  
  public void setPickedIndexRelativeToMin(int paramInt)
  {
    AppMethodBeat.i(138110);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      this.rDh = (this.rCZ + paramInt);
      if ((!this.rDt) || (!this.rDv)) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      V(paramInt, bool);
      postInvalidate();
      AppMethodBeat.o(138110);
      return;
    }
  }
  
  public void setPickedIndexRelativeToRaw(int paramInt)
  {
    AppMethodBeat.i(138117);
    int i;
    if ((this.rCZ >= 0) && (this.rCZ <= paramInt) && (paramInt <= this.rDa))
    {
      this.rDh = paramInt;
      i = this.rCZ;
      if ((!this.rDt) || (!this.rDv)) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      V(paramInt - i, bool);
      postInvalidate();
      AppMethodBeat.o(138117);
      return;
    }
  }
  
  public void setSelectedTextColor(int paramInt)
  {
    AppMethodBeat.i(138112);
    if (this.rCI == paramInt)
    {
      AppMethodBeat.o(138112);
      return;
    }
    this.rCI = paramInt;
    postInvalidate();
    AppMethodBeat.o(138112);
  }
  
  public void setValue(int paramInt)
  {
    AppMethodBeat.i(138106);
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt < this.rDb)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value less than mMinValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(138106);
      throw localIllegalArgumentException;
    }
    if (paramInt > this.rDc)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value greater than mMaxValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(138106);
      throw localIllegalArgumentException;
    }
    setPickedIndexRelativeToRaw(paramInt - this.rDb);
    AppMethodBeat.o(138106);
  }
  
  public void setWrapSelectorWheel(boolean paramBoolean)
  {
    AppMethodBeat.i(138103);
    if (this.rDt != paramBoolean)
    {
      if (!paramBoolean)
      {
        if (this.mScrollState == 0)
        {
          cpO();
          AppMethodBeat.o(138103);
          return;
        }
        this.rDw = true;
        AppMethodBeat.o(138103);
        return;
      }
      this.rDt = paramBoolean;
      cpV();
      postInvalidate();
    }
    AppMethodBeat.o(138103);
  }
  
  public static abstract interface a {}
  
  public static abstract interface c {}
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker
 * JD-Core Version:    0.7.0.1
 */