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
import android.support.v4.view.t;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;

public class YANumberPicker
  extends View
{
  private int aOy;
  private int aOz;
  private int aok;
  private float cCi;
  private boolean mHasInit;
  private int mKL;
  private int mKM;
  private int mKN;
  private int mKO;
  private int mKP;
  private int mKQ;
  private int mKR;
  private int mKS;
  private int mKT;
  private int mKU;
  private int mKV;
  private int mKW;
  private int mKX;
  private int mKY;
  private int mKZ;
  private boolean mLA;
  private boolean mLB;
  private boolean mLC;
  private p mLD;
  private Paint mLE;
  private TextPaint mLF;
  private Paint mLG;
  private String[] mLH;
  private CharSequence[] mLI;
  private CharSequence[] mLJ;
  private ao mLK;
  private Handler mLL;
  private d mLM;
  private YANumberPicker.b mLN;
  private a mLO;
  private c mLP;
  private int mLQ;
  private int mLR;
  private int mLS;
  private int mLT;
  private float mLU;
  private float mLV;
  private boolean mLW;
  private float mLX;
  private float mLY;
  private float mLZ;
  private int mLa;
  private int mLb;
  private int mLc;
  private int mLd;
  private int mLe;
  private int mLf;
  private int mLg;
  private int mLh;
  private int mLi;
  private int mLj;
  private int mLk;
  private int mLl;
  private int mLm;
  private int mLn;
  private String mLo;
  private String mLp;
  private String mLq;
  private String mLr;
  private float mLs;
  private float mLt;
  private float mLu;
  private float mLv;
  private boolean mLw;
  private boolean mLx;
  private boolean mLy;
  private boolean mLz;
  private int mMa;
  private int mMb;
  private int mMc;
  private int mMd;
  private int mMe;
  private int mScrollState;
  private VelocityTracker mVelocityTracker;
  private int mwC;
  
  public YANumberPicker(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138091);
    this.mKL = -13421773;
    this.mKM = -695533;
    this.mKN = -695533;
    this.mKO = 0;
    this.mKP = 0;
    this.mKQ = 0;
    this.mKR = 0;
    this.mKS = 0;
    this.mKT = 0;
    this.mKU = 0;
    this.mKV = 0;
    this.mKW = 0;
    this.mKX = -695533;
    this.aok = 2;
    this.mKY = 0;
    this.mKZ = 0;
    this.mLa = 3;
    this.mLb = 0;
    this.mLc = 0;
    this.mLd = -1;
    this.mLe = -1;
    this.mLf = 0;
    this.mLg = 0;
    this.mLh = 0;
    this.mLi = 0;
    this.mLj = 0;
    this.mLk = 0;
    this.mLl = 0;
    this.mLm = 150;
    this.mLn = 8;
    this.mLs = 1.0F;
    this.mLt = 0.0F;
    this.mLu = 0.0F;
    this.mLv = 0.0F;
    this.mLw = true;
    this.mLx = true;
    this.mLy = false;
    this.mHasInit = false;
    this.mLz = true;
    this.mLA = false;
    this.mLB = false;
    this.mLC = true;
    this.mLE = new Paint();
    this.mLF = new TextPaint();
    this.mLG = new Paint();
    this.mScrollState = 0;
    this.mLU = 0.0F;
    this.cCi = 0.0F;
    this.mLV = 0.0F;
    this.mLW = false;
    this.mMa = 0;
    this.mMb = 0;
    this.mMc = 0;
    this.mMd = 0;
    this.mMe = 0;
    init(paramContext);
    AppMethodBeat.o(138091);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138092);
    this.mKL = -13421773;
    this.mKM = -695533;
    this.mKN = -695533;
    this.mKO = 0;
    this.mKP = 0;
    this.mKQ = 0;
    this.mKR = 0;
    this.mKS = 0;
    this.mKT = 0;
    this.mKU = 0;
    this.mKV = 0;
    this.mKW = 0;
    this.mKX = -695533;
    this.aok = 2;
    this.mKY = 0;
    this.mKZ = 0;
    this.mLa = 3;
    this.mLb = 0;
    this.mLc = 0;
    this.mLd = -1;
    this.mLe = -1;
    this.mLf = 0;
    this.mLg = 0;
    this.mLh = 0;
    this.mLi = 0;
    this.mLj = 0;
    this.mLk = 0;
    this.mLl = 0;
    this.mLm = 150;
    this.mLn = 8;
    this.mLs = 1.0F;
    this.mLt = 0.0F;
    this.mLu = 0.0F;
    this.mLv = 0.0F;
    this.mLw = true;
    this.mLx = true;
    this.mLy = false;
    this.mHasInit = false;
    this.mLz = true;
    this.mLA = false;
    this.mLB = false;
    this.mLC = true;
    this.mLE = new Paint();
    this.mLF = new TextPaint();
    this.mLG = new Paint();
    this.mScrollState = 0;
    this.mLU = 0.0F;
    this.cCi = 0.0F;
    this.mLV = 0.0F;
    this.mLW = false;
    this.mMa = 0;
    this.mMb = 0;
    this.mMc = 0;
    this.mMd = 0;
    this.mMe = 0;
    b(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(138092);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138093);
    this.mKL = -13421773;
    this.mKM = -695533;
    this.mKN = -695533;
    this.mKO = 0;
    this.mKP = 0;
    this.mKQ = 0;
    this.mKR = 0;
    this.mKS = 0;
    this.mKT = 0;
    this.mKU = 0;
    this.mKV = 0;
    this.mKW = 0;
    this.mKX = -695533;
    this.aok = 2;
    this.mKY = 0;
    this.mKZ = 0;
    this.mLa = 3;
    this.mLb = 0;
    this.mLc = 0;
    this.mLd = -1;
    this.mLe = -1;
    this.mLf = 0;
    this.mLg = 0;
    this.mLh = 0;
    this.mLi = 0;
    this.mLj = 0;
    this.mLk = 0;
    this.mLl = 0;
    this.mLm = 150;
    this.mLn = 8;
    this.mLs = 1.0F;
    this.mLt = 0.0F;
    this.mLu = 0.0F;
    this.mLv = 0.0F;
    this.mLw = true;
    this.mLx = true;
    this.mLy = false;
    this.mHasInit = false;
    this.mLz = true;
    this.mLA = false;
    this.mLB = false;
    this.mLC = true;
    this.mLE = new Paint();
    this.mLF = new TextPaint();
    this.mLG = new Paint();
    this.mScrollState = 0;
    this.mLU = 0.0F;
    this.cCi = 0.0F;
    this.mLV = 0.0F;
    this.mLW = false;
    this.mMa = 0;
    this.mMb = 0;
    this.mMc = 0;
    this.mMd = 0;
    this.mMe = 0;
    b(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(138093);
  }
  
  private void N(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(138128);
    this.mMa = (paramInt - (this.mLa - 1) / 2);
    this.mMa = q(this.mMa, getOneRecycleSize(), paramBoolean);
    if (this.mwC == 0)
    {
      this.mLy = true;
      AppMethodBeat.o(138128);
      return;
    }
    this.mMc = (this.mMa * this.mwC);
    this.mLQ = (this.mMa + this.mLa / 2);
    this.mLQ %= getOneRecycleSize();
    if (this.mLQ < 0) {
      this.mLQ += getOneRecycleSize();
    }
    this.mLR = this.mLQ;
    bBm();
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
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
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
        this.mLa = localTypedArray.getInt(j, 3);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          this.mKX = localTypedArray.getColor(j, -695533);
        }
        else if (j == 4)
        {
          this.aok = localTypedArray.getDimensionPixelSize(j, 2);
        }
        else if (j == 5)
        {
          this.mKY = localTypedArray.getDimensionPixelSize(j, 0);
        }
        else if (j == 6)
        {
          this.mKZ = localTypedArray.getDimensionPixelSize(j, 0);
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
              this.mLH = paramAttributeSet;
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
            this.mKL = localTypedArray.getColor(j, -13421773);
          } else if (j == 22) {
            this.mKM = localTypedArray.getColor(j, -695533);
          } else if (j == 20) {
            this.mKN = localTypedArray.getColor(j, -695533);
          } else if (j == 25) {
            this.mKO = localTypedArray.getDimensionPixelSize(j, d(paramContext, 13.0F));
          } else if (j == 26) {
            this.mKP = localTypedArray.getDimensionPixelSize(j, d(paramContext, 15.0F));
          } else if (j == 24) {
            this.mKQ = localTypedArray.getDimensionPixelSize(j, d(paramContext, 14.0F));
          } else if (j == 14) {
            this.mLd = localTypedArray.getInteger(j, 0);
          } else if (j == 13) {
            this.mLe = localTypedArray.getInteger(j, 0);
          } else if (j == 27) {
            this.mLx = localTypedArray.getBoolean(j, true);
          } else if (j == 18) {
            this.mLw = localTypedArray.getBoolean(j, true);
          } else if (j == 8) {
            this.mLo = localTypedArray.getString(j);
          } else if (j == 0) {
            this.mLr = localTypedArray.getString(j);
          } else if (j == 7) {
            this.mLq = localTypedArray.getString(j);
          } else if (j == 12) {
            this.mKT = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == 11) {
            this.mKU = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == 10) {
            this.mKV = localTypedArray.getDimensionPixelSize(j, e(paramContext, 2.0F));
          } else if (j == 9) {
            this.mKW = localTypedArray.getDimensionPixelSize(j, e(paramContext, 5.0F));
          } else if (j == 1) {
            this.mLI = localTypedArray.getTextArray(j);
          } else if (j == 2) {
            this.mLJ = localTypedArray.getTextArray(j);
          } else if (j == 16) {
            this.mLB = localTypedArray.getBoolean(j, false);
          } else if (j == 15) {
            this.mLC = localTypedArray.getBoolean(j, true);
          } else if (j == 23) {
            this.mLp = localTypedArray.getString(j);
          }
        }
      }
    }
    localTypedArray.recycle();
    AppMethodBeat.o(138094);
  }
  
  private void bBk()
  {
    AppMethodBeat.i(138124);
    N(getPickedIndexRelativeToRaw() - this.mLd, false);
    this.mLx = false;
    postInvalidate();
    AppMethodBeat.o(138124);
  }
  
  private void bBl()
  {
    AppMethodBeat.i(138125);
    this.mLS = 0;
    this.mLT = (-this.mLa * this.mwC);
    if (this.mLH != null)
    {
      this.mLS = ((getOneRecycleSize() - this.mLa / 2 - 1) * this.mwC);
      this.mLT = (-(this.mLa / 2) * this.mwC);
    }
    AppMethodBeat.o(138125);
  }
  
  private void bBm()
  {
    AppMethodBeat.i(138130);
    this.mMa = ((int)Math.floor(this.mMc / this.mwC));
    this.mMb = (-(this.mMc - this.mMa * this.mwC));
    if (this.mLP != null) {
      if (-this.mMb <= this.mwC / 2) {
        break label131;
      }
    }
    label131:
    for (this.mLR = (this.mMa + 1 + this.mLa / 2);; this.mLR = (this.mMa + this.mLa / 2))
    {
      this.mLR %= getOneRecycleSize();
      if (this.mLR < 0) {
        this.mLR += getOneRecycleSize();
      }
      this.mLQ = this.mLR;
      AppMethodBeat.o(138130);
      return;
    }
  }
  
  private void bBn()
  {
    AppMethodBeat.i(138135);
    float f = this.mLF.getTextSize();
    this.mLF.setTextSize(this.mKP);
    this.mLh = a(this.mLH, this.mLF);
    this.mLj = a(this.mLI, this.mLF);
    this.mLk = a(this.mLJ, this.mLF);
    this.mLF.setTextSize(this.mKQ);
    this.mKS = a(this.mLr, this.mLF);
    this.mLF.setTextSize(f);
    AppMethodBeat.o(138135);
  }
  
  private void bBo()
  {
    AppMethodBeat.i(138138);
    float f = this.mLF.getTextSize();
    this.mLF.setTextSize(this.mKP);
    this.mLi = ((int)(this.mLF.getFontMetrics().bottom - this.mLF.getFontMetrics().top + 0.5D));
    this.mLF.setTextSize(f);
    AppMethodBeat.o(138138);
  }
  
  private void bBp()
  {
    AppMethodBeat.i(138139);
    bBq();
    bBr();
    if (this.mLd == -1) {
      this.mLd = 0;
    }
    if (this.mLe == -1) {
      this.mLe = (this.mLH.length - 1);
    }
    p(this.mLd, this.mLe, false);
    AppMethodBeat.o(138139);
  }
  
  private void bBq()
  {
    if (this.mLH == null)
    {
      this.mLH = new String[1];
      this.mLH[0] = "0";
    }
  }
  
  private void bBr()
  {
    if (this.mLH.length <= this.mLa) {}
    for (boolean bool = false;; bool = true)
    {
      this.mLz = bool;
      return;
    }
  }
  
  private void bBs()
  {
    AppMethodBeat.i(138140);
    if ((this.mLD != null) && (!this.mLD.SC.isFinished()))
    {
      this.mLD.startScroll(0, this.mLD.SC.getCurrY(), 0, 0, 1);
      this.mLD.SC.abortAnimation();
      postInvalidate();
    }
    AppMethodBeat.o(138140);
  }
  
  private static int c(float paramFloat, int paramInt1, int paramInt2)
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
  
  private static Message c(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
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
    Object localObject = this.mLp;
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
  
  private void jdMethod_if(boolean paramBoolean)
  {
    AppMethodBeat.i(138131);
    bBn();
    bBo();
    if ((paramBoolean) && ((this.mMd == -2147483648) || (this.mMe == -2147483648))) {
      this.mLL.sendEmptyMessage(3);
    }
    AppMethodBeat.o(138131);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(138095);
    this.mLD = p.a(paramContext, null);
    this.mLm = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    this.mLn = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    if (this.mKO == 0) {
      this.mKO = d(paramContext, 13.0F);
    }
    if (this.mKP == 0) {
      this.mKP = d(paramContext, 15.0F);
    }
    if (this.mKQ == 0) {
      this.mKQ = d(paramContext, 14.0F);
    }
    if (this.mKT == 0) {
      this.mKT = e(paramContext, 8.0F);
    }
    if (this.mKU == 0) {
      this.mKU = e(paramContext, 8.0F);
    }
    this.mLE.setColor(this.mKX);
    this.mLE.setAntiAlias(true);
    this.mLE.setStyle(Paint.Style.STROKE);
    this.mLE.setStrokeWidth(this.aok);
    this.mLF.setColor(this.mKL);
    this.mLF.setAntiAlias(true);
    this.mLF.setTextAlign(Paint.Align.CENTER);
    this.mLG.setColor(this.mKN);
    this.mLG.setAntiAlias(true);
    this.mLG.setTextAlign(Paint.Align.CENTER);
    this.mLG.setTextSize(this.mKQ);
    if (this.mLa % 2 == 0) {
      this.mLa += 1;
    }
    if ((this.mLd == -1) || (this.mLe == -1)) {
      bBp();
    }
    initHandler();
    AppMethodBeat.o(138095);
  }
  
  private void initHandler()
  {
    AppMethodBeat.i(138096);
    this.mLK = new ao("HandlerThread-For-Refreshing")
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
          if (!YANumberPicker.a(YANumberPicker.this).SC.isFinished())
          {
            if (YANumberPicker.b(YANumberPicker.this) == 0) {
              YANumberPicker.b(YANumberPicker.this, 1);
            }
            YANumberPicker.c(YANumberPicker.this).sendMessageDelayed(YANumberPicker.d(1, 0, 0, paramAnonymousMessage.obj), 32L);
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
            paramAnonymousMessage = YANumberPicker.d(2, YANumberPicker.g(YANumberPicker.this), i, paramAnonymousMessage.obj);
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
    this.mLL = new Handler()
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
  
  private void p(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(138119);
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt1 > paramInt2)
    {
      localIllegalArgumentException = new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + paramInt1 + ", maxShowIndex is " + paramInt2 + ".");
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (this.mLH == null)
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
    if (paramInt1 > this.mLH.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.mLH.length - 1) + " minShowIndex is " + paramInt1);
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt2 < 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt2 > this.mLH.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.mLH.length - 1) + " maxShowIndex is " + paramInt2);
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    this.mLd = paramInt1;
    this.mLe = paramInt2;
    if (paramBoolean)
    {
      this.mLl = (this.mLd + 0);
      if ((!this.mLx) || (!this.mLz)) {
        break label335;
      }
    }
    label335:
    for (paramBoolean = true;; paramBoolean = false)
    {
      N(0, paramBoolean);
      postInvalidate();
      AppMethodBeat.o(138119);
      return;
    }
  }
  
  private static int q(int paramInt1, int paramInt2, boolean paramBoolean)
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
  
  private void wg(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
  }
  
  private int wh(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(138123);
    if (this.mwC == 0)
    {
      AppMethodBeat.o(138123);
      return 0;
    }
    paramInt /= this.mwC;
    int i = this.mLa / 2;
    int j = getOneRecycleSize();
    boolean bool1 = bool2;
    if (this.mLx)
    {
      bool1 = bool2;
      if (this.mLz) {
        bool1 = true;
      }
    }
    paramInt = q(paramInt + i, j, bool1);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      i = this.mLd;
      AppMethodBeat.o(138123);
      return paramInt + i;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + paramInt + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.mLx);
    AppMethodBeat.o(138123);
    throw localIllegalArgumentException;
  }
  
  private int wi(int paramInt)
  {
    if ((this.mLx) && (this.mLz)) {}
    do
    {
      return paramInt;
      if (paramInt < this.mLT) {
        return this.mLT;
      }
    } while (paramInt <= this.mLS);
    return this.mLS;
  }
  
  public final void bBt()
  {
    AppMethodBeat.i(138141);
    bBs();
    if (this.mLK != null) {
      this.mLK.sendMessageDelayed(c(1, 0, 0, null), 0L);
    }
    AppMethodBeat.o(138141);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(138129);
    if (this.mwC == 0)
    {
      AppMethodBeat.o(138129);
      return;
    }
    if (this.mLD.SC.computeScrollOffset())
    {
      this.mMc = this.mLD.SC.getCurrY();
      bBm();
      postInvalidate();
    }
    AppMethodBeat.o(138129);
  }
  
  public String getContentByCurrValue()
  {
    AppMethodBeat.i(138108);
    String str = this.mLH[(getValue() - this.mLf)];
    AppMethodBeat.o(138108);
    return str;
  }
  
  public String[] getDisplayedValues()
  {
    return this.mLH;
  }
  
  public int getMaxValue()
  {
    return this.mLg;
  }
  
  public int getMinValue()
  {
    return this.mLf;
  }
  
  public int getOneRecycleSize()
  {
    return this.mLe - this.mLd + 1;
  }
  
  public int getPickedIndexRelativeToRaw()
  {
    AppMethodBeat.i(138118);
    int i;
    if (this.mMb != 0) {
      if (this.mMb < -this.mwC / 2) {
        i = wh(this.mMc + this.mwC + this.mMb);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(138118);
      return i;
      i = wh(this.mMc + this.mMb);
      continue;
      i = wh(this.mMc);
    }
  }
  
  public int getRawContentSize()
  {
    if (this.mLH != null) {
      return this.mLH.length;
    }
    return 0;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(138107);
    int i = getPickedIndexRelativeToRaw();
    int j = this.mLf;
    AppMethodBeat.o(138107);
    return i + j;
  }
  
  public boolean getWrapSelectorWheel()
  {
    return this.mLx;
  }
  
  public boolean getWrapSelectorWheelAbsolutely()
  {
    return (this.mLx) && (this.mLz);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(138100);
    super.onAttachedToWindow();
    if (this.mLK == null) {
      initHandler();
    }
    AppMethodBeat.o(138100);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(138101);
    super.onDetachedFromWindow();
    this.mLK.quit();
    this.mLL = null;
    if (this.mwC == 0)
    {
      AppMethodBeat.o(138101);
      return;
    }
    if (!this.mLD.SC.isFinished())
    {
      this.mLD.SC.abortAnimation();
      this.mMc = this.mLD.SC.getCurrY();
      bBm();
      if (this.mMb != 0)
      {
        if (this.mMb >= -this.mwC / 2) {
          break label185;
        }
        this.mMc = (this.mMc + this.mwC + this.mMb);
      }
    }
    for (;;)
    {
      bBm();
      wg(0);
      int i = wh(this.mMc);
      if ((i != this.mLl) && (this.mLB)) {}
      try
      {
        if (this.mLN != null) {
          this.mLN.a(this, this.mLf + i);
        }
        this.mLl = i;
        AppMethodBeat.o(138101);
        return;
        label185:
        this.mMc += this.mMb;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.YANumberPicker", localException, "", new Object[0]);
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
    if (j < this.mLa + 1)
    {
      float f5 = this.mMb + this.mwC * j;
      int i = this.mMa;
      int k = getOneRecycleSize();
      boolean bool;
      label71:
      float f3;
      float f2;
      if ((this.mLx) && (this.mLz))
      {
        bool = true;
        k = q(i + j, k, bool);
        if (j != this.mLa / 2) {
          break label297;
        }
        f3 = (this.mwC + this.mMb) / this.mwC;
        i = c(f3, this.mKL, this.mKM);
        f1 = this.mKO;
        f1 += (this.mKP - f1) * f3;
        f2 = this.mLt;
        f2 += (this.mLu - f2) * f3;
        label165:
        this.mLF.setColor(i);
        this.mLF.setTextSize(f1);
        if ((k < 0) || (k >= getOneRecycleSize())) {
          break label406;
        }
        String str = this.mLH[(this.mLd + k)];
        Object localObject = str;
        if (this.mLp != null) {
          localObject = TextUtils.ellipsize(str, this.mLF, getWidth() - this.mKW * 2, getEllipsizeType());
        }
        paramCanvas.drawText(((CharSequence)localObject).toString(), this.mLZ, f2 + (f5 + this.mwC / 2), this.mLF);
      }
      for (;;)
      {
        j += 1;
        f1 = f3;
        break;
        bool = false;
        break label71;
        label297:
        if (j == this.mLa / 2 + 1)
        {
          i = c(1.0F - f1, this.mKL, this.mKM);
          f2 = this.mKO;
          f2 = (1.0F - f1) * (this.mKP - f2) + f2;
          f3 = this.mLt;
          f4 = (1.0F - f1) * (this.mLu - f3) + f3;
          f3 = f1;
          f1 = f2;
          f2 = f4;
          break label165;
        }
        i = this.mKL;
        float f4 = this.mKO;
        f2 = this.mLt;
        f3 = f1;
        f1 = f4;
        break label165;
        label406:
        if (!TextUtils.isEmpty(this.mLq)) {
          paramCanvas.drawText(this.mLq, this.mLZ, f2 + (f5 + this.mwC / 2), this.mLF);
        }
      }
    }
    if (this.mLw)
    {
      paramCanvas.drawLine(getPaddingLeft() + this.mKY, this.mLX, this.aOy - getPaddingRight() - this.mKZ, this.mLX, this.mLE);
      paramCanvas.drawLine(getPaddingLeft() + this.mKY, this.mLY, this.aOy - getPaddingRight() - this.mKZ, this.mLY, this.mLE);
    }
    if (!TextUtils.isEmpty(this.mLo)) {
      paramCanvas.drawText(this.mLo, this.mLZ + (this.mLh + this.mKR) / 2 + this.mKT, (this.mLX + this.mLY) / 2.0F + this.mLv, this.mLG);
    }
    AppMethodBeat.o(138132);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(138097);
    super.onMeasure(paramInt1, paramInt2);
    jdMethod_if(false);
    int k = View.MeasureSpec.getMode(paramInt1);
    this.mMd = k;
    int j = View.MeasureSpec.getSize(paramInt1);
    if (k == 1073741824)
    {
      paramInt1 = j;
      j = View.MeasureSpec.getMode(paramInt2);
      this.mMe = j;
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
      if (Math.max(this.mKR, this.mKS) == 0)
      {
        paramInt1 = 0;
        label102:
        if (Math.max(this.mKR, this.mKS) != 0) {
          break label206;
        }
      }
      for (;;)
      {
        int m = this.mLj;
        int n = Math.max(this.mLh, this.mLk);
        i = Math.max(m, (paramInt1 + (i + Math.max(this.mKR, this.mKS)) + this.mKW * 2) * 2 + n) + (getPaddingLeft() + getPaddingRight());
        paramInt1 = i;
        if (k != -2147483648) {
          break;
        }
        paramInt1 = Math.min(i, j);
        break;
        paramInt1 = this.mKU;
        break label102;
        label206:
        i = this.mKT;
      }
      label214:
      i = this.mLa * (this.mLi + this.mKV * 2) + (getPaddingTop() + getPaddingBottom());
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
    this.aOy = paramInt1;
    this.aOz = paramInt2;
    this.mwC = (this.aOz / this.mLa);
    this.mLZ = ((this.aOy + getPaddingLeft() - getPaddingRight()) / 2.0F);
    if (getOneRecycleSize() > 1) {
      if (this.mHasInit) {
        paramInt1 = getValue() - this.mLf;
      }
    }
    for (;;)
    {
      if ((this.mLx) && (this.mLz)) {}
      IllegalArgumentException localIllegalArgumentException;
      for (boolean bool = true;; bool = false)
      {
        N(paramInt1, bool);
        if (this.mKO > this.mwC) {
          this.mKO = this.mwC;
        }
        if (this.mKP > this.mwC) {
          this.mKP = this.mwC;
        }
        if (this.mLG != null) {
          break label209;
        }
        localIllegalArgumentException = new IllegalArgumentException("mPaintHint should not be null.");
        AppMethodBeat.o(138098);
        throw localIllegalArgumentException;
        if (this.mLy)
        {
          paramInt1 = this.mMa + (this.mLa - 1) / 2;
          break;
        }
        paramInt1 = 0;
        break;
      }
      label209:
      this.mLG.setTextSize(this.mKQ);
      this.mLv = a(this.mLG.getFontMetrics());
      this.mKR = a(this.mLo, this.mLG);
      if (this.mLF == null)
      {
        localIllegalArgumentException = new IllegalArgumentException("mPaintText should not be null.");
        AppMethodBeat.o(138098);
        throw localIllegalArgumentException;
      }
      this.mLF.setTextSize(this.mKP);
      this.mLu = a(this.mLF.getFontMetrics());
      this.mLF.setTextSize(this.mKO);
      this.mLt = a(this.mLF.getFontMetrics());
      bBl();
      this.mLb = (this.mLa / 2);
      this.mLc = (this.mLb + 1);
      this.mLX = (this.mLb * this.aOz / this.mLa);
      this.mLY = (this.mLc * this.aOz / this.mLa);
      if (this.mKY < 0) {
        this.mKY = 0;
      }
      if (this.mKZ < 0) {
        this.mKZ = 0;
      }
      if ((this.mKY + this.mKZ != 0) && (getPaddingLeft() + this.mKY >= this.aOy - getPaddingRight() - this.mKZ))
      {
        paramInt1 = getPaddingLeft() + this.mKY + getPaddingRight() + this.mKZ - this.aOy;
        this.mKY = ((int)(this.mKY - paramInt1 * this.mKY / (this.mKY + this.mKZ)));
        this.mKZ = ((int)(this.mKZ - paramInt1 * this.mKZ / (this.mKY + this.mKZ)));
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
    if (this.mwC == 0)
    {
      AppMethodBeat.o(138126);
      return true;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    this.mLV = paramMotionEvent.getY();
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
            this.mLW = true;
            this.mLK.removeMessages(1);
            bBs();
            this.cCi = this.mLV;
            this.mLU = this.mMc;
            wg(0);
            getParent().requestDisallowInterceptTouchEvent(true);
            continue;
            f = this.cCi - this.mLV;
            if ((!this.mLW) || (-this.mLn >= f) || (f >= this.mLn))
            {
              this.mLW = false;
              this.mMc = wi((int)(f + this.mLU));
              bBm();
              invalidate();
            }
            wg(1);
          }
          if (!this.mLW) {
            break;
          }
          f = paramMotionEvent.getY();
          i = 0;
        } while (i >= this.mLa);
        if ((this.mwC * i > f) || (f >= this.mwC * (i + 1))) {
          break;
        }
      } while ((i < 0) || (i >= this.mLa));
      i -= this.mLa / 2;
      if (this.mLx)
      {
        j = i;
        if (this.mLz) {}
      }
      else
      {
        k = getPickedIndexRelativeToRaw();
        if (k + i <= this.mLe) {
          break;
        }
        j = this.mLe - k;
      }
      if (this.mMb < -this.mwC / 2)
      {
        k = this.mwC + this.mMb;
        i = (int)((this.mwC + this.mMb) * 300.0F / this.mwC);
        if (j < 0)
        {
          i = -i - j * 300;
          label392:
          n = this.mwC;
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
      this.mLD.startScroll(0, this.mMc, 0, k + j * n, m);
      this.mLK.sendMessageDelayed(c(1, 0, 0, null), m / 4);
      postInvalidate();
      break;
      j = i;
      if (k + i >= this.mLd) {
        break label330;
      }
      j = this.mLd - k;
      break label330;
      i += j * 300;
      break label392;
      k = this.mMb;
      i = (int)(-this.mMb * 300.0F / this.mwC);
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
      j = (int)(paramMotionEvent.getYVelocity() * this.mLs);
      if (Math.abs(j) > this.mLm)
      {
        paramMotionEvent = this.mLD;
        i = this.mMc;
        j = -j;
        k = wi(-2147483648);
        m = wi(2147483647);
        paramMotionEvent.SC.fling(0, i, 0, j, -2147483648, 2147483647, k, m);
        invalidate();
        wg(2);
      }
      this.mLK.sendMessageDelayed(c(1, 0, 0, null), 0L);
      if (this.mVelocityTracker == null) {
        break;
      }
      this.mVelocityTracker.clear();
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      break;
      this.mLU = this.mMc;
      bBs();
      this.mLK.sendMessageDelayed(c(1, 0, 0, null), 0L);
      break;
    }
  }
  
  public void postInvalidate()
  {
    AppMethodBeat.i(138099);
    if (!t.aC(this))
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
    this.mLF.setTypeface(paramTypeface);
    AppMethodBeat.o(138121);
  }
  
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    boolean bool = true;
    AppMethodBeat.i(138102);
    if (this.mLK != null) {
      this.mLK.removeMessages(1);
    }
    bBs();
    if (paramArrayOfString == null)
    {
      paramArrayOfString = new IllegalArgumentException("newDisplayedValues should not be null.");
      AppMethodBeat.o(138102);
      throw paramArrayOfString;
    }
    if (this.mLg - this.mLf + 1 > paramArrayOfString.length)
    {
      paramArrayOfString = new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + (this.mLg - this.mLf + 1) + " newDisplayedValues.length is " + paramArrayOfString.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
      AppMethodBeat.o(138102);
      throw paramArrayOfString;
    }
    this.mLH = paramArrayOfString;
    bBr();
    jdMethod_if(true);
    this.mLl = (this.mLd + 0);
    if ((this.mLx) && (this.mLz)) {}
    for (;;)
    {
      N(0, bool);
      postInvalidate();
      this.mLL.sendEmptyMessage(3);
      AppMethodBeat.o(138102);
      return;
      bool = false;
    }
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(138114);
    if (this.mKX == paramInt)
    {
      AppMethodBeat.o(138114);
      return;
    }
    this.mKX = paramInt;
    this.mLE.setColor(this.mKX);
    postInvalidate();
    AppMethodBeat.o(138114);
  }
  
  public void setDividerHeight(int paramInt)
  {
    AppMethodBeat.i(138115);
    if (paramInt == this.aok)
    {
      AppMethodBeat.o(138115);
      return;
    }
    this.aok = paramInt;
    this.mLE.setStrokeWidth(this.aok);
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
        this.mLp = paramString;
        AppMethodBeat.o(138133);
        return;
      }
      i += 1;
    }
    this.mLp = "end";
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
    this.mLs = (ViewConfiguration.getScrollFriction() / paramFloat);
    AppMethodBeat.o(138120);
  }
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(138109);
    String str = this.mLo;
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
    this.mLo = paramString;
    this.mLv = a(this.mLG.getFontMetrics());
    this.mKR = a(this.mLo, this.mLG);
    this.mLL.sendEmptyMessage(3);
    AppMethodBeat.o(138109);
  }
  
  public void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(138113);
    if (this.mKN == paramInt)
    {
      AppMethodBeat.o(138113);
      return;
    }
    this.mKN = paramInt;
    this.mLG.setColor(this.mKN);
    postInvalidate();
    AppMethodBeat.o(138113);
  }
  
  public void setHintTextTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(138122);
    this.mLG.setTypeface(paramTypeface);
    AppMethodBeat.o(138122);
  }
  
  public void setItemPaddingVertical(int paramInt)
  {
    AppMethodBeat.i(138116);
    if (this.mKV == paramInt)
    {
      AppMethodBeat.o(138116);
      return;
    }
    this.mKV = paramInt;
    postInvalidate();
    AppMethodBeat.o(138116);
  }
  
  public void setMaxValue(int paramInt)
  {
    AppMethodBeat.i(138105);
    Object localObject;
    if (this.mLH == null)
    {
      localObject = new NullPointerException("mDisplayedValues should not be null");
      AppMethodBeat.o(138105);
      throw ((Throwable)localObject);
    }
    if (paramInt - this.mLf + 1 > this.mLH.length)
    {
      localObject = new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + (paramInt - this.mLf + 1) + " and mDisplayedValues.length is " + this.mLH.length);
      AppMethodBeat.o(138105);
      throw ((Throwable)localObject);
    }
    this.mLg = paramInt;
    this.mLe = (this.mLg - this.mLf + this.mLd);
    p(this.mLd, this.mLe, true);
    bBl();
    AppMethodBeat.o(138105);
  }
  
  public void setMinValue(int paramInt)
  {
    AppMethodBeat.i(138104);
    this.mLf = paramInt;
    this.mLd = 0;
    bBl();
    AppMethodBeat.o(138104);
  }
  
  public void setNormalTextColor(int paramInt)
  {
    AppMethodBeat.i(138111);
    if (this.mKL == paramInt)
    {
      AppMethodBeat.o(138111);
      return;
    }
    this.mKL = paramInt;
    postInvalidate();
    AppMethodBeat.o(138111);
  }
  
  public void setOnScrollListener(a parama)
  {
    this.mLO = parama;
  }
  
  public void setOnValueChangeListenerInScrolling(c paramc)
  {
    this.mLP = paramc;
  }
  
  public void setOnValueChangedListener(YANumberPicker.b paramb)
  {
    this.mLN = paramb;
  }
  
  public void setOnValueChangedListenerRelativeToRaw(d paramd)
  {
    this.mLM = paramd;
  }
  
  public void setPickedIndexRelativeToMin(int paramInt)
  {
    AppMethodBeat.i(138110);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      this.mLl = (this.mLd + paramInt);
      if ((!this.mLx) || (!this.mLz)) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      N(paramInt, bool);
      postInvalidate();
      AppMethodBeat.o(138110);
      return;
    }
  }
  
  public void setPickedIndexRelativeToRaw(int paramInt)
  {
    AppMethodBeat.i(138117);
    int i;
    if ((this.mLd >= 0) && (this.mLd <= paramInt) && (paramInt <= this.mLe))
    {
      this.mLl = paramInt;
      i = this.mLd;
      if ((!this.mLx) || (!this.mLz)) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      N(paramInt - i, bool);
      postInvalidate();
      AppMethodBeat.o(138117);
      return;
    }
  }
  
  public void setSelectedTextColor(int paramInt)
  {
    AppMethodBeat.i(138112);
    if (this.mKM == paramInt)
    {
      AppMethodBeat.o(138112);
      return;
    }
    this.mKM = paramInt;
    postInvalidate();
    AppMethodBeat.o(138112);
  }
  
  public void setValue(int paramInt)
  {
    AppMethodBeat.i(138106);
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt < this.mLf)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value less than mMinValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(138106);
      throw localIllegalArgumentException;
    }
    if (paramInt > this.mLg)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value greater than mMaxValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(138106);
      throw localIllegalArgumentException;
    }
    setPickedIndexRelativeToRaw(paramInt - this.mLf);
    AppMethodBeat.o(138106);
  }
  
  public void setWrapSelectorWheel(boolean paramBoolean)
  {
    AppMethodBeat.i(138103);
    if (this.mLx != paramBoolean)
    {
      if (!paramBoolean)
      {
        if (this.mScrollState == 0)
        {
          bBk();
          AppMethodBeat.o(138103);
          return;
        }
        this.mLA = true;
        AppMethodBeat.o(138103);
        return;
      }
      this.mLx = paramBoolean;
      bBr();
      postInvalidate();
    }
    AppMethodBeat.o(138103);
  }
  
  public static abstract interface a {}
  
  public static abstract interface c {}
  
  public static abstract interface d {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker
 * JD-Core Version:    0.7.0.1
 */