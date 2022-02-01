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
import androidx.core.g.z;
import androidx.core.widget.i;
import com.tencent.luggage.b.a.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class YANumberPicker
  extends View
{
  private float fig;
  private boolean mHasInit;
  private int mScrollState;
  private VelocityTracker mVelocityTracker;
  private int mViewHeight;
  private int mViewWidth;
  private i mri;
  private int tR;
  private int uAa;
  private int uNY;
  private int uNZ;
  private int uOA;
  private String uOB;
  private String uOC;
  private String uOD;
  private String uOE;
  private float uOF;
  private float uOG;
  private float uOH;
  private float uOI;
  private boolean uOJ;
  private boolean uOK;
  private boolean uOL;
  private boolean uOM;
  private boolean uON;
  private boolean uOO;
  private boolean uOP;
  private Paint uOQ;
  private TextPaint uOR;
  private Paint uOS;
  private String[] uOT;
  private CharSequence[] uOU;
  private CharSequence[] uOV;
  private MMHandler uOW;
  private Handler uOX;
  private d uOY;
  private YANumberPicker.b uOZ;
  private int uOa;
  private int uOb;
  private int uOc;
  private int uOd;
  private int uOe;
  private int uOf;
  private int uOg;
  private int uOh;
  private int uOi;
  private int uOj;
  private int uOk;
  private int uOl;
  private int uOm;
  private int uOn;
  private int uOo;
  private int uOp;
  private int uOq;
  private int uOr;
  private int uOs;
  private int uOt;
  private int uOu;
  private int uOv;
  private int uOw;
  private int uOx;
  private int uOy;
  private int uOz;
  private a uPa;
  private c uPb;
  private int uPc;
  private int uPd;
  private int uPe;
  private int uPf;
  private float uPg;
  private float uPh;
  private boolean uPi;
  private float uPj;
  private float uPk;
  private float uPl;
  private int uPm;
  private int uPn;
  private int uPo;
  private int uPp;
  private int uPq;
  
  public YANumberPicker(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138091);
    this.uNY = -13421773;
    this.uNZ = -695533;
    this.uOa = -695533;
    this.uOb = 0;
    this.uOc = 0;
    this.uOd = 0;
    this.uOe = 0;
    this.uOf = 0;
    this.uOg = 0;
    this.uOh = 0;
    this.uOi = 0;
    this.uOj = 0;
    this.uOk = -695533;
    this.tR = 2;
    this.uOl = 0;
    this.uOm = 0;
    this.uOn = 3;
    this.uOo = 0;
    this.uOp = 0;
    this.uOq = -1;
    this.uOr = -1;
    this.uOs = 0;
    this.uOt = 0;
    this.uOu = 0;
    this.uOv = 0;
    this.uOw = 0;
    this.uOx = 0;
    this.uOy = 0;
    this.uOz = 150;
    this.uOA = 8;
    this.uOF = 1.0F;
    this.uOG = 0.0F;
    this.uOH = 0.0F;
    this.uOI = 0.0F;
    this.uOJ = true;
    this.uOK = true;
    this.uOL = false;
    this.mHasInit = false;
    this.uOM = true;
    this.uON = false;
    this.uOO = false;
    this.uOP = true;
    this.uOQ = new Paint();
    this.uOR = new TextPaint();
    this.uOS = new Paint();
    this.mScrollState = 0;
    this.uPg = 0.0F;
    this.fig = 0.0F;
    this.uPh = 0.0F;
    this.uPi = false;
    this.uPm = 0;
    this.uPn = 0;
    this.uPo = 0;
    this.uPp = 0;
    this.uPq = 0;
    init(paramContext);
    AppMethodBeat.o(138091);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138092);
    this.uNY = -13421773;
    this.uNZ = -695533;
    this.uOa = -695533;
    this.uOb = 0;
    this.uOc = 0;
    this.uOd = 0;
    this.uOe = 0;
    this.uOf = 0;
    this.uOg = 0;
    this.uOh = 0;
    this.uOi = 0;
    this.uOj = 0;
    this.uOk = -695533;
    this.tR = 2;
    this.uOl = 0;
    this.uOm = 0;
    this.uOn = 3;
    this.uOo = 0;
    this.uOp = 0;
    this.uOq = -1;
    this.uOr = -1;
    this.uOs = 0;
    this.uOt = 0;
    this.uOu = 0;
    this.uOv = 0;
    this.uOw = 0;
    this.uOx = 0;
    this.uOy = 0;
    this.uOz = 150;
    this.uOA = 8;
    this.uOF = 1.0F;
    this.uOG = 0.0F;
    this.uOH = 0.0F;
    this.uOI = 0.0F;
    this.uOJ = true;
    this.uOK = true;
    this.uOL = false;
    this.mHasInit = false;
    this.uOM = true;
    this.uON = false;
    this.uOO = false;
    this.uOP = true;
    this.uOQ = new Paint();
    this.uOR = new TextPaint();
    this.uOS = new Paint();
    this.mScrollState = 0;
    this.uPg = 0.0F;
    this.fig = 0.0F;
    this.uPh = 0.0F;
    this.uPi = false;
    this.uPm = 0;
    this.uPn = 0;
    this.uPo = 0;
    this.uPp = 0;
    this.uPq = 0;
    a(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(138092);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138093);
    this.uNY = -13421773;
    this.uNZ = -695533;
    this.uOa = -695533;
    this.uOb = 0;
    this.uOc = 0;
    this.uOd = 0;
    this.uOe = 0;
    this.uOf = 0;
    this.uOg = 0;
    this.uOh = 0;
    this.uOi = 0;
    this.uOj = 0;
    this.uOk = -695533;
    this.tR = 2;
    this.uOl = 0;
    this.uOm = 0;
    this.uOn = 3;
    this.uOo = 0;
    this.uOp = 0;
    this.uOq = -1;
    this.uOr = -1;
    this.uOs = 0;
    this.uOt = 0;
    this.uOu = 0;
    this.uOv = 0;
    this.uOw = 0;
    this.uOx = 0;
    this.uOy = 0;
    this.uOz = 150;
    this.uOA = 8;
    this.uOF = 1.0F;
    this.uOG = 0.0F;
    this.uOH = 0.0F;
    this.uOI = 0.0F;
    this.uOJ = true;
    this.uOK = true;
    this.uOL = false;
    this.mHasInit = false;
    this.uOM = true;
    this.uON = false;
    this.uOO = false;
    this.uOP = true;
    this.uOQ = new Paint();
    this.uOR = new TextPaint();
    this.uOS = new Paint();
    this.mScrollState = 0;
    this.uPg = 0.0F;
    this.fig = 0.0F;
    this.uPh = 0.0F;
    this.uPi = false;
    this.uPm = 0;
    this.uPn = 0;
    this.uPo = 0;
    this.uPp = 0;
    this.uPq = 0;
    a(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(138093);
  }
  
  private void EF(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
  }
  
  private int EG(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(138123);
    if (this.uAa == 0)
    {
      AppMethodBeat.o(138123);
      return 0;
    }
    paramInt /= this.uAa;
    int i = this.uOn / 2;
    int j = getOneRecycleSize();
    boolean bool1 = bool2;
    if (this.uOK)
    {
      bool1 = bool2;
      if (this.uOM) {
        bool1 = true;
      }
    }
    paramInt = u(paramInt + i, j, bool1);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      i = this.uOq;
      AppMethodBeat.o(138123);
      return paramInt + i;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + paramInt + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.uOK);
    AppMethodBeat.o(138123);
    throw localIllegalArgumentException;
  }
  
  private int EH(int paramInt)
  {
    if ((this.uOK) && (this.uOM)) {}
    do
    {
      return paramInt;
      if (paramInt < this.uPf) {
        return this.uPf;
      }
    } while (paramInt <= this.uPe);
    return this.uPe;
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
        this.uOn = localTypedArray.getInt(j, 3);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == a.i.YANumberPicker_npv_DividerColor)
        {
          this.uOk = localTypedArray.getColor(j, -695533);
        }
        else if (j == a.i.YANumberPicker_npv_DividerHeight)
        {
          this.tR = localTypedArray.getDimensionPixelSize(j, 2);
        }
        else if (j == a.i.YANumberPicker_npv_DividerMarginLeft)
        {
          this.uOl = localTypedArray.getDimensionPixelSize(j, 0);
        }
        else if (j == a.i.YANumberPicker_npv_DividerMarginRight)
        {
          this.uOm = localTypedArray.getDimensionPixelSize(j, 0);
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
              this.uOT = paramAttributeSet;
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
            this.uNY = localTypedArray.getColor(j, -13421773);
          } else if (j == a.i.YANumberPicker_npv_TextColorSelected) {
            this.uNZ = localTypedArray.getColor(j, -695533);
          } else if (j == a.i.YANumberPicker_npv_TextColorHint) {
            this.uOa = localTypedArray.getColor(j, -695533);
          } else if (j == a.i.YANumberPicker_npv_TextSizeNormal) {
            this.uOb = localTypedArray.getDimensionPixelSize(j, d(paramContext, 13.0F));
          } else if (j == a.i.YANumberPicker_npv_TextSizeSelected) {
            this.uOc = localTypedArray.getDimensionPixelSize(j, d(paramContext, 15.0F));
          } else if (j == a.i.YANumberPicker_npv_TextSizeHint) {
            this.uOd = localTypedArray.getDimensionPixelSize(j, d(paramContext, 14.0F));
          } else if (j == a.i.YANumberPicker_npv_MinValue) {
            this.uOq = localTypedArray.getInteger(j, 0);
          } else if (j == a.i.YANumberPicker_npv_MaxValue) {
            this.uOr = localTypedArray.getInteger(j, 0);
          } else if (j == a.i.YANumberPicker_npv_WrapSelectorWheel) {
            this.uOK = localTypedArray.getBoolean(j, true);
          } else if (j == a.i.YANumberPicker_npv_ShowDivider) {
            this.uOJ = localTypedArray.getBoolean(j, true);
          } else if (j == a.i.YANumberPicker_npv_HintText) {
            this.uOB = localTypedArray.getString(j);
          } else if (j == a.i.YANumberPicker_npv_AlternativeHint) {
            this.uOE = localTypedArray.getString(j);
          } else if (j == a.i.YANumberPicker_npv_EmptyItemHint) {
            this.uOD = localTypedArray.getString(j);
          } else if (j == a.i.YANumberPicker_npv_MarginStartOfHint) {
            this.uOg = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == a.i.YANumberPicker_npv_MarginEndOfHint) {
            this.uOh = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == a.i.YANumberPicker_npv_ItemPaddingVertical) {
            this.uOi = localTypedArray.getDimensionPixelSize(j, e(paramContext, 2.0F));
          } else if (j == a.i.YANumberPicker_npv_ItemPaddingHorizontal) {
            this.uOj = localTypedArray.getDimensionPixelSize(j, e(paramContext, 5.0F));
          } else if (j == a.i.YANumberPicker_npv_AlternativeTextArrayWithMeasureHint) {
            this.uOU = localTypedArray.getTextArray(j);
          } else if (j == a.i.YANumberPicker_npv_AlternativeTextArrayWithoutMeasureHint) {
            this.uOV = localTypedArray.getTextArray(j);
          } else if (j == a.i.YANumberPicker_npv_RespondChangeOnDetached) {
            this.uOO = localTypedArray.getBoolean(j, false);
          } else if (j == a.i.YANumberPicker_npv_RespondChangeInMainThread) {
            this.uOP = localTypedArray.getBoolean(j, true);
          } else if (j == a.i.YANumberPicker_npv_TextEllipsize) {
            this.uOC = localTypedArray.getString(j);
          }
        }
      }
    }
    localTypedArray.recycle();
    AppMethodBeat.o(138094);
  }
  
  private void al(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(138128);
    this.uPm = (paramInt - (this.uOn - 1) / 2);
    this.uPm = u(this.uPm, getOneRecycleSize(), paramBoolean);
    if (this.uAa == 0)
    {
      this.uOL = true;
      AppMethodBeat.o(138128);
      return;
    }
    this.uPo = (this.uPm * this.uAa);
    this.uPc = (this.uPm + this.uOn / 2);
    this.uPc %= getOneRecycleSize();
    if (this.uPc < 0) {
      this.uPc += getOneRecycleSize();
    }
    this.uPd = this.uPc;
    cSw();
    AppMethodBeat.o(138128);
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
  
  private void cSA()
  {
    if (this.uOT == null)
    {
      this.uOT = new String[1];
      this.uOT[0] = "0";
    }
  }
  
  private void cSB()
  {
    if (this.uOT.length <= this.uOn) {}
    for (boolean bool = false;; bool = true)
    {
      this.uOM = bool;
      return;
    }
  }
  
  private void cSC()
  {
    AppMethodBeat.i(138140);
    if ((this.mri != null) && (!this.mri.bwz.isFinished()))
    {
      this.mri.startScroll(0, this.mri.bwz.getCurrY(), 0, 0, 1);
      this.mri.bwz.abortAnimation();
      postInvalidate();
    }
    AppMethodBeat.o(138140);
  }
  
  private void cSu()
  {
    AppMethodBeat.i(138124);
    al(getPickedIndexRelativeToRaw() - this.uOq, false);
    this.uOK = false;
    postInvalidate();
    AppMethodBeat.o(138124);
  }
  
  private void cSv()
  {
    AppMethodBeat.i(138125);
    this.uPe = 0;
    this.uPf = (-this.uOn * this.uAa);
    if (this.uOT != null)
    {
      this.uPe = ((getOneRecycleSize() - this.uOn / 2 - 1) * this.uAa);
      this.uPf = (-(this.uOn / 2) * this.uAa);
    }
    AppMethodBeat.o(138125);
  }
  
  private void cSw()
  {
    AppMethodBeat.i(138130);
    this.uPm = ((int)Math.floor(this.uPo / this.uAa));
    this.uPn = (-(this.uPo - this.uPm * this.uAa));
    if (this.uPb != null) {
      if (-this.uPn <= this.uAa / 2) {
        break label131;
      }
    }
    label131:
    for (this.uPd = (this.uPm + 1 + this.uOn / 2);; this.uPd = (this.uPm + this.uOn / 2))
    {
      this.uPd %= getOneRecycleSize();
      if (this.uPd < 0) {
        this.uPd += getOneRecycleSize();
      }
      this.uPc = this.uPd;
      AppMethodBeat.o(138130);
      return;
    }
  }
  
  private void cSx()
  {
    AppMethodBeat.i(138135);
    float f = this.uOR.getTextSize();
    this.uOR.setTextSize(this.uOc);
    this.uOu = a(this.uOT, this.uOR);
    this.uOw = a(this.uOU, this.uOR);
    this.uOx = a(this.uOV, this.uOR);
    this.uOR.setTextSize(this.uOd);
    this.uOf = a(this.uOE, this.uOR);
    this.uOR.setTextSize(f);
    AppMethodBeat.o(138135);
  }
  
  private void cSy()
  {
    AppMethodBeat.i(138138);
    float f = this.uOR.getTextSize();
    this.uOR.setTextSize(this.uOc);
    this.uOv = ((int)(this.uOR.getFontMetrics().bottom - this.uOR.getFontMetrics().top + 0.5D));
    this.uOR.setTextSize(f);
    AppMethodBeat.o(138138);
  }
  
  private void cSz()
  {
    AppMethodBeat.i(138139);
    cSA();
    cSB();
    if (this.uOq == -1) {
      this.uOq = 0;
    }
    if (this.uOr == -1) {
      this.uOr = (this.uOT.length - 1);
    }
    t(this.uOq, this.uOr, false);
    AppMethodBeat.o(138139);
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
    Object localObject = this.uOC;
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
    this.mri = i.a(paramContext, null);
    this.uOz = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    this.uOA = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    if (this.uOb == 0) {
      this.uOb = d(paramContext, 13.0F);
    }
    if (this.uOc == 0) {
      this.uOc = d(paramContext, 15.0F);
    }
    if (this.uOd == 0) {
      this.uOd = d(paramContext, 14.0F);
    }
    if (this.uOg == 0) {
      this.uOg = e(paramContext, 8.0F);
    }
    if (this.uOh == 0) {
      this.uOh = e(paramContext, 8.0F);
    }
    this.uOQ.setColor(this.uOk);
    this.uOQ.setAntiAlias(true);
    this.uOQ.setStyle(Paint.Style.STROKE);
    this.uOQ.setStrokeWidth(this.tR);
    this.uOR.setColor(this.uNY);
    this.uOR.setAntiAlias(true);
    this.uOR.setTextAlign(Paint.Align.CENTER);
    this.uOS.setColor(this.uOa);
    this.uOS.setAntiAlias(true);
    this.uOS.setTextAlign(Paint.Align.CENTER);
    this.uOS.setTextSize(this.uOd);
    if (this.uOn % 2 == 0) {
      this.uOn += 1;
    }
    if ((this.uOq == -1) || (this.uOr == -1)) {
      cSz();
    }
    initHandler();
    AppMethodBeat.o(138095);
  }
  
  private void initHandler()
  {
    AppMethodBeat.i(138096);
    this.uOW = new MMHandler("HandlerThread-For-Refreshing")
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
          if (!YANumberPicker.a(YANumberPicker.this).bwz.isFinished())
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
              i locali = YANumberPicker.a(YANumberPicker.this);
              i = YANumberPicker.f(YANumberPicker.this);
              int k = YANumberPicker.e(YANumberPicker.this);
              locali.startScroll(0, i, 0, YANumberPicker.d(YANumberPicker.this) + k, j * 3);
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
    this.uOX = new Handler()
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
  
  private void lK(boolean paramBoolean)
  {
    AppMethodBeat.i(138131);
    cSx();
    cSy();
    if ((paramBoolean) && ((this.uPp == -2147483648) || (this.uPq == -2147483648))) {
      this.uOX.sendEmptyMessage(3);
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
    if (this.uOT == null)
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
    if (paramInt1 > this.uOT.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.uOT.length - 1) + " minShowIndex is " + paramInt1);
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt2 < 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt2 > this.uOT.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.uOT.length - 1) + " maxShowIndex is " + paramInt2);
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    this.uOq = paramInt1;
    this.uOr = paramInt2;
    if (paramBoolean)
    {
      this.uOy = (this.uOq + 0);
      if ((!this.uOK) || (!this.uOM)) {
        break label335;
      }
    }
    label335:
    for (paramBoolean = true;; paramBoolean = false)
    {
      al(0, paramBoolean);
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
  
  public final void cSD()
  {
    AppMethodBeat.i(138141);
    cSC();
    if (this.uOW != null) {
      this.uOW.sendMessageDelayed(b(1, 0, 0, null), 0L);
    }
    AppMethodBeat.o(138141);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(138129);
    if (this.uAa == 0)
    {
      AppMethodBeat.o(138129);
      return;
    }
    if (this.mri.bwz.computeScrollOffset())
    {
      this.uPo = this.mri.bwz.getCurrY();
      cSw();
      postInvalidate();
    }
    AppMethodBeat.o(138129);
  }
  
  public String getContentByCurrValue()
  {
    AppMethodBeat.i(138108);
    String str = this.uOT[(getValue() - this.uOs)];
    AppMethodBeat.o(138108);
    return str;
  }
  
  public String[] getDisplayedValues()
  {
    return this.uOT;
  }
  
  public int getMaxValue()
  {
    return this.uOt;
  }
  
  public int getMinValue()
  {
    return this.uOs;
  }
  
  public int getOneRecycleSize()
  {
    return this.uOr - this.uOq + 1;
  }
  
  public int getPickedIndexRelativeToRaw()
  {
    AppMethodBeat.i(138118);
    int i;
    if (this.uPn != 0) {
      if (this.uPn < -this.uAa / 2) {
        i = EG(this.uPo + this.uAa + this.uPn);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(138118);
      return i;
      i = EG(this.uPo + this.uPn);
      continue;
      i = EG(this.uPo);
    }
  }
  
  public int getRawContentSize()
  {
    if (this.uOT != null) {
      return this.uOT.length;
    }
    return 0;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(138107);
    int i = getPickedIndexRelativeToRaw();
    int j = this.uOs;
    AppMethodBeat.o(138107);
    return i + j;
  }
  
  public boolean getWrapSelectorWheel()
  {
    return this.uOK;
  }
  
  public boolean getWrapSelectorWheelAbsolutely()
  {
    return (this.uOK) && (this.uOM);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(138100);
    super.onAttachedToWindow();
    if (this.uOW == null) {
      initHandler();
    }
    AppMethodBeat.o(138100);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(138101);
    super.onDetachedFromWindow();
    this.uOW.quit();
    this.uOX = null;
    if (this.uAa == 0)
    {
      AppMethodBeat.o(138101);
      return;
    }
    if (!this.mri.bwz.isFinished())
    {
      this.mri.bwz.abortAnimation();
      this.uPo = this.mri.bwz.getCurrY();
      cSw();
      if (this.uPn != 0)
      {
        if (this.uPn >= -this.uAa / 2) {
          break label185;
        }
        this.uPo = (this.uPo + this.uAa + this.uPn);
      }
    }
    for (;;)
    {
      cSw();
      EF(0);
      int i = EG(this.uPo);
      if ((i != this.uOy) && (this.uOO)) {}
      try
      {
        if (this.uOZ != null) {
          this.uOZ.a(this, this.uOs + i);
        }
        this.uOy = i;
        AppMethodBeat.o(138101);
        return;
        label185:
        this.uPo += this.uPn;
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
    if (j < this.uOn + 1)
    {
      float f5 = this.uPn + this.uAa * j;
      int i = this.uPm;
      int k = getOneRecycleSize();
      boolean bool;
      label71:
      float f3;
      float f2;
      if ((this.uOK) && (this.uOM))
      {
        bool = true;
        k = u(i + j, k, bool);
        if (j != this.uOn / 2) {
          break label297;
        }
        f3 = (this.uAa + this.uPn) / this.uAa;
        i = a(f3, this.uNY, this.uNZ);
        f1 = this.uOb;
        f1 += (this.uOc - f1) * f3;
        f2 = this.uOG;
        f2 += (this.uOH - f2) * f3;
        label165:
        this.uOR.setColor(i);
        this.uOR.setTextSize(f1);
        if ((k < 0) || (k >= getOneRecycleSize())) {
          break label406;
        }
        String str = this.uOT[(this.uOq + k)];
        Object localObject = str;
        if (this.uOC != null) {
          localObject = TextUtils.ellipsize(str, this.uOR, getWidth() - this.uOj * 2, getEllipsizeType());
        }
        paramCanvas.drawText(((CharSequence)localObject).toString(), this.uPl, f2 + (f5 + this.uAa / 2), this.uOR);
      }
      for (;;)
      {
        j += 1;
        f1 = f3;
        break;
        bool = false;
        break label71;
        label297:
        if (j == this.uOn / 2 + 1)
        {
          i = a(1.0F - f1, this.uNY, this.uNZ);
          f2 = this.uOb;
          f2 = (1.0F - f1) * (this.uOc - f2) + f2;
          f3 = this.uOG;
          f4 = (1.0F - f1) * (this.uOH - f3) + f3;
          f3 = f1;
          f1 = f2;
          f2 = f4;
          break label165;
        }
        i = this.uNY;
        float f4 = this.uOb;
        f2 = this.uOG;
        f3 = f1;
        f1 = f4;
        break label165;
        label406:
        if (!TextUtils.isEmpty(this.uOD)) {
          paramCanvas.drawText(this.uOD, this.uPl, f2 + (f5 + this.uAa / 2), this.uOR);
        }
      }
    }
    if (this.uOJ)
    {
      paramCanvas.drawLine(getPaddingLeft() + this.uOl, this.uPj, this.mViewWidth - getPaddingRight() - this.uOm, this.uPj, this.uOQ);
      paramCanvas.drawLine(getPaddingLeft() + this.uOl, this.uPk, this.mViewWidth - getPaddingRight() - this.uOm, this.uPk, this.uOQ);
    }
    if (!TextUtils.isEmpty(this.uOB)) {
      paramCanvas.drawText(this.uOB, this.uPl + (this.uOu + this.uOe) / 2 + this.uOg, (this.uPj + this.uPk) / 2.0F + this.uOI, this.uOS);
    }
    AppMethodBeat.o(138132);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(138097);
    super.onMeasure(paramInt1, paramInt2);
    lK(false);
    int k = View.MeasureSpec.getMode(paramInt1);
    this.uPp = k;
    int j = View.MeasureSpec.getSize(paramInt1);
    if (k == 1073741824)
    {
      paramInt1 = j;
      j = View.MeasureSpec.getMode(paramInt2);
      this.uPq = j;
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
      if (Math.max(this.uOe, this.uOf) == 0)
      {
        paramInt1 = 0;
        label102:
        if (Math.max(this.uOe, this.uOf) != 0) {
          break label206;
        }
      }
      for (;;)
      {
        int m = this.uOw;
        int n = Math.max(this.uOu, this.uOx);
        i = Math.max(m, (paramInt1 + (i + Math.max(this.uOe, this.uOf)) + this.uOj * 2) * 2 + n) + (getPaddingLeft() + getPaddingRight());
        paramInt1 = i;
        if (k != -2147483648) {
          break;
        }
        paramInt1 = Math.min(i, j);
        break;
        paramInt1 = this.uOh;
        break label102;
        label206:
        i = this.uOg;
      }
      label214:
      i = this.uOn * (this.uOv + this.uOi * 2) + (getPaddingTop() + getPaddingBottom());
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
    this.mViewWidth = paramInt1;
    this.mViewHeight = paramInt2;
    this.uAa = (this.mViewHeight / this.uOn);
    this.uPl = ((this.mViewWidth + getPaddingLeft() - getPaddingRight()) / 2.0F);
    if (getOneRecycleSize() > 1) {
      if (this.mHasInit) {
        paramInt1 = getValue() - this.uOs;
      }
    }
    for (;;)
    {
      if ((this.uOK) && (this.uOM)) {}
      IllegalArgumentException localIllegalArgumentException;
      for (boolean bool = true;; bool = false)
      {
        al(paramInt1, bool);
        if (this.uOb > this.uAa) {
          this.uOb = this.uAa;
        }
        if (this.uOc > this.uAa) {
          this.uOc = this.uAa;
        }
        if (this.uOS != null) {
          break label209;
        }
        localIllegalArgumentException = new IllegalArgumentException("mPaintHint should not be null.");
        AppMethodBeat.o(138098);
        throw localIllegalArgumentException;
        if (this.uOL)
        {
          paramInt1 = this.uPm + (this.uOn - 1) / 2;
          break;
        }
        paramInt1 = 0;
        break;
      }
      label209:
      this.uOS.setTextSize(this.uOd);
      this.uOI = a(this.uOS.getFontMetrics());
      this.uOe = a(this.uOB, this.uOS);
      if (this.uOR == null)
      {
        localIllegalArgumentException = new IllegalArgumentException("mPaintText should not be null.");
        AppMethodBeat.o(138098);
        throw localIllegalArgumentException;
      }
      this.uOR.setTextSize(this.uOc);
      this.uOH = a(this.uOR.getFontMetrics());
      this.uOR.setTextSize(this.uOb);
      this.uOG = a(this.uOR.getFontMetrics());
      cSv();
      this.uOo = (this.uOn / 2);
      this.uOp = (this.uOo + 1);
      this.uPj = (this.uOo * this.mViewHeight / this.uOn);
      this.uPk = (this.uOp * this.mViewHeight / this.uOn);
      if (this.uOl < 0) {
        this.uOl = 0;
      }
      if (this.uOm < 0) {
        this.uOm = 0;
      }
      if ((this.uOl + this.uOm != 0) && (getPaddingLeft() + this.uOl >= this.mViewWidth - getPaddingRight() - this.uOm))
      {
        paramInt1 = getPaddingLeft() + this.uOl + getPaddingRight() + this.uOm - this.mViewWidth;
        this.uOl = ((int)(this.uOl - paramInt1 * this.uOl / (this.uOl + this.uOm)));
        this.uOm = ((int)(this.uOm - paramInt1 * this.uOm / (this.uOl + this.uOm)));
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
    if (this.uAa == 0)
    {
      AppMethodBeat.o(138126);
      return true;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    this.uPh = paramMotionEvent.getY();
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
            this.uPi = true;
            this.uOW.removeMessages(1);
            cSC();
            this.fig = this.uPh;
            this.uPg = this.uPo;
            EF(0);
            getParent().requestDisallowInterceptTouchEvent(true);
            continue;
            f = this.fig - this.uPh;
            if ((!this.uPi) || (-this.uOA >= f) || (f >= this.uOA))
            {
              this.uPi = false;
              this.uPo = EH((int)(f + this.uPg));
              cSw();
              invalidate();
            }
            EF(1);
          }
          if (!this.uPi) {
            break;
          }
          f = paramMotionEvent.getY();
          i = 0;
        } while (i >= this.uOn);
        if ((this.uAa * i > f) || (f >= this.uAa * (i + 1))) {
          break;
        }
      } while ((i < 0) || (i >= this.uOn));
      i -= this.uOn / 2;
      if (this.uOK)
      {
        j = i;
        if (this.uOM) {}
      }
      else
      {
        k = getPickedIndexRelativeToRaw();
        if (k + i <= this.uOr) {
          break;
        }
        j = this.uOr - k;
      }
      if (this.uPn < -this.uAa / 2)
      {
        k = this.uAa + this.uPn;
        i = (int)((this.uAa + this.uPn) * 300.0F / this.uAa);
        if (j < 0)
        {
          i = -i - j * 300;
          label392:
          n = this.uAa;
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
      this.mri.startScroll(0, this.uPo, 0, k + j * n, m);
      this.uOW.sendMessageDelayed(b(1, 0, 0, null), m / 4);
      postInvalidate();
      break;
      j = i;
      if (k + i >= this.uOq) {
        break label330;
      }
      j = this.uOq - k;
      break label330;
      i += j * 300;
      break label392;
      k = this.uPn;
      i = (int)(-this.uPn * 300.0F / this.uAa);
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
      j = (int)(paramMotionEvent.getYVelocity() * this.uOF);
      if (Math.abs(j) > this.uOz)
      {
        paramMotionEvent = this.mri;
        i = this.uPo;
        j = -j;
        k = EH(-2147483648);
        m = EH(2147483647);
        paramMotionEvent.bwz.fling(0, i, 0, j, -2147483648, 2147483647, k, m);
        invalidate();
        EF(2);
      }
      this.uOW.sendMessageDelayed(b(1, 0, 0, null), 0L);
      if (this.mVelocityTracker == null) {
        break;
      }
      this.mVelocityTracker.clear();
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      break;
      this.uPg = this.uPo;
      cSC();
      this.uOW.sendMessageDelayed(b(1, 0, 0, null), 0L);
      break;
    }
  }
  
  public void postInvalidate()
  {
    AppMethodBeat.i(138099);
    if (!z.ay(this))
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
    this.uOR.setTypeface(paramTypeface);
    AppMethodBeat.o(138121);
  }
  
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    boolean bool = true;
    AppMethodBeat.i(138102);
    if (this.uOW != null) {
      this.uOW.removeMessages(1);
    }
    cSC();
    if (paramArrayOfString == null)
    {
      paramArrayOfString = new IllegalArgumentException("newDisplayedValues should not be null.");
      AppMethodBeat.o(138102);
      throw paramArrayOfString;
    }
    if (this.uOt - this.uOs + 1 > paramArrayOfString.length)
    {
      paramArrayOfString = new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + (this.uOt - this.uOs + 1) + " newDisplayedValues.length is " + paramArrayOfString.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
      AppMethodBeat.o(138102);
      throw paramArrayOfString;
    }
    this.uOT = paramArrayOfString;
    cSB();
    lK(true);
    this.uOy = (this.uOq + 0);
    if ((this.uOK) && (this.uOM)) {}
    for (;;)
    {
      al(0, bool);
      postInvalidate();
      this.uOX.sendEmptyMessage(3);
      AppMethodBeat.o(138102);
      return;
      bool = false;
    }
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(138114);
    if (this.uOk == paramInt)
    {
      AppMethodBeat.o(138114);
      return;
    }
    this.uOk = paramInt;
    this.uOQ.setColor(this.uOk);
    postInvalidate();
    AppMethodBeat.o(138114);
  }
  
  public void setDividerHeight(int paramInt)
  {
    AppMethodBeat.i(138115);
    if (paramInt == this.tR)
    {
      AppMethodBeat.o(138115);
      return;
    }
    this.tR = paramInt;
    this.uOQ.setStrokeWidth(this.tR);
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
        this.uOC = paramString;
        AppMethodBeat.o(138133);
        return;
      }
      i += 1;
    }
    this.uOC = "end";
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
    this.uOF = (ViewConfiguration.getScrollFriction() / paramFloat);
    AppMethodBeat.o(138120);
  }
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(138109);
    String str = this.uOB;
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
    this.uOB = paramString;
    this.uOI = a(this.uOS.getFontMetrics());
    this.uOe = a(this.uOB, this.uOS);
    this.uOX.sendEmptyMessage(3);
    AppMethodBeat.o(138109);
  }
  
  public void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(138113);
    if (this.uOa == paramInt)
    {
      AppMethodBeat.o(138113);
      return;
    }
    this.uOa = paramInt;
    this.uOS.setColor(this.uOa);
    postInvalidate();
    AppMethodBeat.o(138113);
  }
  
  public void setHintTextTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(138122);
    this.uOS.setTypeface(paramTypeface);
    AppMethodBeat.o(138122);
  }
  
  public void setItemPaddingVertical(int paramInt)
  {
    AppMethodBeat.i(138116);
    if (this.uOi == paramInt)
    {
      AppMethodBeat.o(138116);
      return;
    }
    this.uOi = paramInt;
    postInvalidate();
    AppMethodBeat.o(138116);
  }
  
  public void setMaxValue(int paramInt)
  {
    AppMethodBeat.i(138105);
    Object localObject;
    if (this.uOT == null)
    {
      localObject = new NullPointerException("mDisplayedValues should not be null");
      AppMethodBeat.o(138105);
      throw ((Throwable)localObject);
    }
    if (paramInt - this.uOs + 1 > this.uOT.length)
    {
      localObject = new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + (paramInt - this.uOs + 1) + " and mDisplayedValues.length is " + this.uOT.length);
      AppMethodBeat.o(138105);
      throw ((Throwable)localObject);
    }
    this.uOt = paramInt;
    this.uOr = (this.uOt - this.uOs + this.uOq);
    t(this.uOq, this.uOr, true);
    cSv();
    AppMethodBeat.o(138105);
  }
  
  public void setMinValue(int paramInt)
  {
    AppMethodBeat.i(138104);
    this.uOs = paramInt;
    this.uOq = 0;
    cSv();
    AppMethodBeat.o(138104);
  }
  
  public void setNormalTextColor(int paramInt)
  {
    AppMethodBeat.i(138111);
    if (this.uNY == paramInt)
    {
      AppMethodBeat.o(138111);
      return;
    }
    this.uNY = paramInt;
    postInvalidate();
    AppMethodBeat.o(138111);
  }
  
  public void setOnScrollListener(a parama)
  {
    this.uPa = parama;
  }
  
  public void setOnValueChangeListenerInScrolling(c paramc)
  {
    this.uPb = paramc;
  }
  
  public void setOnValueChangedListener(YANumberPicker.b paramb)
  {
    this.uOZ = paramb;
  }
  
  public void setOnValueChangedListenerRelativeToRaw(d paramd)
  {
    this.uOY = paramd;
  }
  
  public void setPickedIndexRelativeToMin(int paramInt)
  {
    AppMethodBeat.i(138110);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      this.uOy = (this.uOq + paramInt);
      if ((!this.uOK) || (!this.uOM)) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      al(paramInt, bool);
      postInvalidate();
      AppMethodBeat.o(138110);
      return;
    }
  }
  
  public void setPickedIndexRelativeToRaw(int paramInt)
  {
    AppMethodBeat.i(138117);
    int i;
    if ((this.uOq >= 0) && (this.uOq <= paramInt) && (paramInt <= this.uOr))
    {
      this.uOy = paramInt;
      i = this.uOq;
      if ((!this.uOK) || (!this.uOM)) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      al(paramInt - i, bool);
      postInvalidate();
      AppMethodBeat.o(138117);
      return;
    }
  }
  
  public void setSelectedTextColor(int paramInt)
  {
    AppMethodBeat.i(138112);
    if (this.uNZ == paramInt)
    {
      AppMethodBeat.o(138112);
      return;
    }
    this.uNZ = paramInt;
    postInvalidate();
    AppMethodBeat.o(138112);
  }
  
  public void setValue(int paramInt)
  {
    AppMethodBeat.i(138106);
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt < this.uOs)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value less than mMinValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(138106);
      throw localIllegalArgumentException;
    }
    if (paramInt > this.uOt)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value greater than mMaxValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(138106);
      throw localIllegalArgumentException;
    }
    setPickedIndexRelativeToRaw(paramInt - this.uOs);
    AppMethodBeat.o(138106);
  }
  
  public void setWrapSelectorWheel(boolean paramBoolean)
  {
    AppMethodBeat.i(138103);
    if (this.uOK != paramBoolean)
    {
      if (!paramBoolean)
      {
        if (this.mScrollState == 0)
        {
          cSu();
          AppMethodBeat.o(138103);
          return;
        }
        this.uON = true;
        AppMethodBeat.o(138103);
        return;
      }
      this.uOK = paramBoolean;
      cSB();
      postInvalidate();
    }
    AppMethodBeat.o(138103);
  }
  
  public static abstract interface a {}
  
  public static abstract interface c {}
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker
 * JD-Core Version:    0.7.0.1
 */