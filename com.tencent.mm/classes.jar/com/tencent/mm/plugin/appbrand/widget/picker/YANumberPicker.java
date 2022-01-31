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
import com.tencent.mm.sdk.platformtools.ab;

public class YANumberPicker
  extends View
{
  private int agi;
  private int asY;
  private int asZ;
  private float bTF;
  private int ef;
  private int jsH;
  private int jsI;
  private int jsJ;
  private int jsK;
  private int jsL;
  private int jsM;
  private int jsN;
  private int jsO;
  private int jsP;
  private int jsQ;
  private int jsR;
  private int jsS;
  private int jsT;
  private int jsU;
  private int jsV;
  private int jsW;
  private int jsX;
  private int jsY;
  private int jsZ;
  private Paint jtA;
  private TextPaint jtB;
  private Paint jtC;
  private String[] jtD;
  private CharSequence[] jtE;
  private CharSequence[] jtF;
  private Handler jtG;
  private Handler jtH;
  private YANumberPicker.d jtI;
  private YANumberPicker.b jtJ;
  private YANumberPicker.a jtK;
  private YANumberPicker.c jtL;
  private int jtM;
  private int jtN;
  private int jtO;
  private int jtP;
  private float jtQ;
  private float jtR;
  private boolean jtS;
  private float jtT;
  private float jtU;
  private float jtV;
  private int jtW;
  private int jtX;
  private int jtY;
  private int jtZ;
  private int jta;
  private int jtb;
  private int jtc;
  private int jtd;
  private int jte;
  private int jtf;
  private int jtg;
  private int jth;
  private int jti;
  private int jtj;
  private String jtk;
  private String jtl;
  private String jtm;
  private String jtn;
  private float jto;
  private float jtp;
  private float jtq;
  private float jtr;
  private boolean jts;
  private boolean jtt;
  private boolean jtu;
  private boolean jtv;
  private boolean jtw;
  private boolean jtx;
  private boolean jty;
  private p jtz;
  private int jua;
  private HandlerThread mHandlerThread;
  private boolean mHasInit;
  private int mScrollState;
  private VelocityTracker mVelocityTracker;
  
  public YANumberPicker(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126759);
    this.jsH = -13421773;
    this.jsI = -695533;
    this.jsJ = -695533;
    this.jsK = 0;
    this.jsL = 0;
    this.jsM = 0;
    this.jsN = 0;
    this.jsO = 0;
    this.jsP = 0;
    this.jsQ = 0;
    this.jsR = 0;
    this.jsS = 0;
    this.jsT = -695533;
    this.agi = 2;
    this.jsU = 0;
    this.jsV = 0;
    this.jsW = 3;
    this.jsX = 0;
    this.jsY = 0;
    this.jsZ = -1;
    this.jta = -1;
    this.jtb = 0;
    this.jtc = 0;
    this.jtd = 0;
    this.jte = 0;
    this.jtf = 0;
    this.jtg = 0;
    this.jth = 0;
    this.jti = 150;
    this.jtj = 8;
    this.jto = 1.0F;
    this.jtp = 0.0F;
    this.jtq = 0.0F;
    this.jtr = 0.0F;
    this.jts = true;
    this.jtt = true;
    this.jtu = false;
    this.mHasInit = false;
    this.jtv = true;
    this.jtw = false;
    this.jtx = false;
    this.jty = true;
    this.jtA = new Paint();
    this.jtB = new TextPaint();
    this.jtC = new Paint();
    this.mScrollState = 0;
    this.jtQ = 0.0F;
    this.bTF = 0.0F;
    this.jtR = 0.0F;
    this.jtS = false;
    this.jtW = 0;
    this.jtX = 0;
    this.jtY = 0;
    this.jtZ = 0;
    this.jua = 0;
    init(paramContext);
    AppMethodBeat.o(126759);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(126760);
    this.jsH = -13421773;
    this.jsI = -695533;
    this.jsJ = -695533;
    this.jsK = 0;
    this.jsL = 0;
    this.jsM = 0;
    this.jsN = 0;
    this.jsO = 0;
    this.jsP = 0;
    this.jsQ = 0;
    this.jsR = 0;
    this.jsS = 0;
    this.jsT = -695533;
    this.agi = 2;
    this.jsU = 0;
    this.jsV = 0;
    this.jsW = 3;
    this.jsX = 0;
    this.jsY = 0;
    this.jsZ = -1;
    this.jta = -1;
    this.jtb = 0;
    this.jtc = 0;
    this.jtd = 0;
    this.jte = 0;
    this.jtf = 0;
    this.jtg = 0;
    this.jth = 0;
    this.jti = 150;
    this.jtj = 8;
    this.jto = 1.0F;
    this.jtp = 0.0F;
    this.jtq = 0.0F;
    this.jtr = 0.0F;
    this.jts = true;
    this.jtt = true;
    this.jtu = false;
    this.mHasInit = false;
    this.jtv = true;
    this.jtw = false;
    this.jtx = false;
    this.jty = true;
    this.jtA = new Paint();
    this.jtB = new TextPaint();
    this.jtC = new Paint();
    this.mScrollState = 0;
    this.jtQ = 0.0F;
    this.bTF = 0.0F;
    this.jtR = 0.0F;
    this.jtS = false;
    this.jtW = 0;
    this.jtX = 0;
    this.jtY = 0;
    this.jtZ = 0;
    this.jua = 0;
    b(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(126760);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(126761);
    this.jsH = -13421773;
    this.jsI = -695533;
    this.jsJ = -695533;
    this.jsK = 0;
    this.jsL = 0;
    this.jsM = 0;
    this.jsN = 0;
    this.jsO = 0;
    this.jsP = 0;
    this.jsQ = 0;
    this.jsR = 0;
    this.jsS = 0;
    this.jsT = -695533;
    this.agi = 2;
    this.jsU = 0;
    this.jsV = 0;
    this.jsW = 3;
    this.jsX = 0;
    this.jsY = 0;
    this.jsZ = -1;
    this.jta = -1;
    this.jtb = 0;
    this.jtc = 0;
    this.jtd = 0;
    this.jte = 0;
    this.jtf = 0;
    this.jtg = 0;
    this.jth = 0;
    this.jti = 150;
    this.jtj = 8;
    this.jto = 1.0F;
    this.jtp = 0.0F;
    this.jtq = 0.0F;
    this.jtr = 0.0F;
    this.jts = true;
    this.jtt = true;
    this.jtu = false;
    this.mHasInit = false;
    this.jtv = true;
    this.jtw = false;
    this.jtx = false;
    this.jty = true;
    this.jtA = new Paint();
    this.jtB = new TextPaint();
    this.jtC = new Paint();
    this.mScrollState = 0;
    this.jtQ = 0.0F;
    this.bTF = 0.0F;
    this.jtR = 0.0F;
    this.jtS = false;
    this.jtW = 0;
    this.jtX = 0;
    this.jtY = 0;
    this.jtZ = 0;
    this.jua = 0;
    b(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(126761);
  }
  
  private void M(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126796);
    this.jtW = (paramInt - (this.jsW - 1) / 2);
    this.jtW = k(this.jtW, getOneRecycleSize(), paramBoolean);
    if (this.ef == 0)
    {
      this.jtu = true;
      AppMethodBeat.o(126796);
      return;
    }
    this.jtY = (this.jtW * this.ef);
    this.jtM = (this.jtW + this.jsW / 2);
    this.jtM %= getOneRecycleSize();
    if (this.jtM < 0) {
      this.jtM += getOneRecycleSize();
    }
    this.jtN = this.jtM;
    aRX();
    AppMethodBeat.o(126796);
  }
  
  private static float a(Paint.FontMetrics paramFontMetrics)
  {
    AppMethodBeat.i(126795);
    if (paramFontMetrics == null)
    {
      AppMethodBeat.o(126795);
      return 0.0F;
    }
    float f = Math.abs(paramFontMetrics.top + paramFontMetrics.bottom) / 2.0F;
    AppMethodBeat.o(126795);
    return f;
  }
  
  private static int a(CharSequence paramCharSequence, Paint paramPaint)
  {
    AppMethodBeat.i(126805);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      int i = (int)(paramPaint.measureText(paramCharSequence.toString()) + 0.5F);
      AppMethodBeat.o(126805);
      return i;
    }
    AppMethodBeat.o(126805);
    return 0;
  }
  
  private static int a(CharSequence[] paramArrayOfCharSequence, Paint paramPaint)
  {
    AppMethodBeat.i(126804);
    if (paramArrayOfCharSequence == null)
    {
      AppMethodBeat.o(126804);
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
    AppMethodBeat.o(126804);
    return j;
  }
  
  private void aRU()
  {
    AppMethodBeat.i(126764);
    this.mHandlerThread = new HandlerThread("HandlerThread-For-Refreshing");
    this.mHandlerThread.start();
    this.jtG = new YANumberPicker.1(this, this.mHandlerThread.getLooper());
    this.jtH = new YANumberPicker.2(this);
    AppMethodBeat.o(126764);
  }
  
  private void aRV()
  {
    AppMethodBeat.i(126792);
    M(getPickedIndexRelativeToRaw() - this.jsZ, false);
    this.jtt = false;
    postInvalidate();
    AppMethodBeat.o(126792);
  }
  
  private void aRW()
  {
    AppMethodBeat.i(126793);
    this.jtO = 0;
    this.jtP = (-this.jsW * this.ef);
    if (this.jtD != null)
    {
      this.jtO = ((getOneRecycleSize() - this.jsW / 2 - 1) * this.ef);
      this.jtP = (-(this.jsW / 2) * this.ef);
    }
    AppMethodBeat.o(126793);
  }
  
  private void aRX()
  {
    AppMethodBeat.i(126798);
    this.jtW = ((int)Math.floor(this.jtY / this.ef));
    this.jtX = (-(this.jtY - this.jtW * this.ef));
    if (this.jtL != null) {
      if (-this.jtX <= this.ef / 2) {
        break label131;
      }
    }
    label131:
    for (this.jtN = (this.jtW + 1 + this.jsW / 2);; this.jtN = (this.jtW + this.jsW / 2))
    {
      this.jtN %= getOneRecycleSize();
      if (this.jtN < 0) {
        this.jtN += getOneRecycleSize();
      }
      this.jtM = this.jtN;
      AppMethodBeat.o(126798);
      return;
    }
  }
  
  private void aRY()
  {
    AppMethodBeat.i(126803);
    float f = this.jtB.getTextSize();
    this.jtB.setTextSize(this.jsL);
    this.jtd = a(this.jtD, this.jtB);
    this.jtf = a(this.jtE, this.jtB);
    this.jtg = a(this.jtF, this.jtB);
    this.jtB.setTextSize(this.jsM);
    this.jsO = a(this.jtn, this.jtB);
    this.jtB.setTextSize(f);
    AppMethodBeat.o(126803);
  }
  
  private void aRZ()
  {
    AppMethodBeat.i(126806);
    float f = this.jtB.getTextSize();
    this.jtB.setTextSize(this.jsL);
    this.jte = ((int)(this.jtB.getFontMetrics().bottom - this.jtB.getFontMetrics().top + 0.5D));
    this.jtB.setTextSize(f);
    AppMethodBeat.o(126806);
  }
  
  private void aSa()
  {
    AppMethodBeat.i(126807);
    aSb();
    aSc();
    if (this.jsZ == -1) {
      this.jsZ = 0;
    }
    if (this.jta == -1) {
      this.jta = (this.jtD.length - 1);
    }
    j(this.jsZ, this.jta, false);
    AppMethodBeat.o(126807);
  }
  
  private void aSb()
  {
    if (this.jtD == null)
    {
      this.jtD = new String[1];
      this.jtD[0] = "0";
    }
  }
  
  private void aSc()
  {
    if (this.jtD.length <= this.jsW) {}
    for (boolean bool = false;; bool = true)
    {
      this.jtv = bool;
      return;
    }
  }
  
  private void aSd()
  {
    AppMethodBeat.i(126808);
    if ((this.jtz != null) && (!this.jtz.jR.isFinished()))
    {
      this.jtz.startScroll(0, this.jtz.jR.getCurrY(), 0, 0, 1);
      this.jtz.jR.abortAnimation();
      postInvalidate();
    }
    AppMethodBeat.o(126808);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(126762);
    if (paramAttributeSet == null)
    {
      AppMethodBeat.o(126762);
      return;
    }
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.YANumberPicker);
    int k = localTypedArray.getIndexCount();
    int i = 0;
    if (i < k)
    {
      int j = localTypedArray.getIndex(i);
      if (j == 0) {
        this.jsW = localTypedArray.getInt(j, 3);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 2)
        {
          this.jsT = localTypedArray.getColor(j, -695533);
        }
        else if (j == 5)
        {
          this.agi = localTypedArray.getDimensionPixelSize(j, 2);
        }
        else if (j == 3)
        {
          this.jsU = localTypedArray.getDimensionPixelSize(j, 0);
        }
        else if (j == 4)
        {
          this.jsV = localTypedArray.getDimensionPixelSize(j, 0);
        }
        else
        {
          if (j == 12)
          {
            CharSequence[] arrayOfCharSequence = localTypedArray.getTextArray(j);
            if (arrayOfCharSequence == null) {
              paramAttributeSet = null;
            }
            for (;;)
            {
              this.jtD = paramAttributeSet;
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
          if (j == 6) {
            this.jsH = localTypedArray.getColor(j, -13421773);
          } else if (j == 7) {
            this.jsI = localTypedArray.getColor(j, -695533);
          } else if (j == 8) {
            this.jsJ = localTypedArray.getColor(j, -695533);
          } else if (j == 9) {
            this.jsK = localTypedArray.getDimensionPixelSize(j, e(paramContext, 13.0F));
          } else if (j == 10) {
            this.jsL = localTypedArray.getDimensionPixelSize(j, e(paramContext, 15.0F));
          } else if (j == 11) {
            this.jsM = localTypedArray.getDimensionPixelSize(j, e(paramContext, 14.0F));
          } else if (j == 13) {
            this.jsZ = localTypedArray.getInteger(j, 0);
          } else if (j == 14) {
            this.jta = localTypedArray.getInteger(j, 0);
          } else if (j == 15) {
            this.jtt = localTypedArray.getBoolean(j, true);
          } else if (j == 1) {
            this.jts = localTypedArray.getBoolean(j, true);
          } else if (j == 17) {
            this.jtk = localTypedArray.getString(j);
          } else if (j == 27) {
            this.jtn = localTypedArray.getString(j);
          } else if (j == 18) {
            this.jtm = localTypedArray.getString(j);
          } else if (j == 19) {
            this.jsP = localTypedArray.getDimensionPixelSize(j, f(paramContext, 8.0F));
          } else if (j == 20) {
            this.jsQ = localTypedArray.getDimensionPixelSize(j, f(paramContext, 8.0F));
          } else if (j == 22) {
            this.jsR = localTypedArray.getDimensionPixelSize(j, f(paramContext, 2.0F));
          } else if (j == 21) {
            this.jsS = localTypedArray.getDimensionPixelSize(j, f(paramContext, 5.0F));
          } else if (j == 25) {
            this.jtE = localTypedArray.getTextArray(j);
          } else if (j == 26) {
            this.jtF = localTypedArray.getTextArray(j);
          } else if (j == 16) {
            this.jtx = localTypedArray.getBoolean(j, false);
          } else if (j == 23) {
            this.jty = localTypedArray.getBoolean(j, true);
          } else if (j == 24) {
            this.jtl = localTypedArray.getString(j);
          }
        }
      }
    }
    localTypedArray.recycle();
    AppMethodBeat.o(126762);
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
    AppMethodBeat.i(126810);
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    AppMethodBeat.o(126810);
    return localMessage;
  }
  
  private static int e(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(126811);
    int i = (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
    AppMethodBeat.o(126811);
    return i;
  }
  
  private static int f(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(126812);
    int i = (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
    AppMethodBeat.o(126812);
    return i;
  }
  
  private void fu(boolean paramBoolean)
  {
    AppMethodBeat.i(126799);
    aRY();
    aRZ();
    if ((paramBoolean) && ((this.jtZ == -2147483648) || (this.jua == -2147483648))) {
      this.jtH.sendEmptyMessage(3);
    }
    AppMethodBeat.o(126799);
  }
  
  private TextUtils.TruncateAt getEllipsizeType()
  {
    AppMethodBeat.i(126802);
    Object localObject = this.jtl;
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
        AppMethodBeat.o(126802);
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
    AppMethodBeat.o(126802);
    return localObject;
    localObject = TextUtils.TruncateAt.MIDDLE;
    AppMethodBeat.o(126802);
    return localObject;
    localObject = TextUtils.TruncateAt.END;
    AppMethodBeat.o(126802);
    return localObject;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(126763);
    this.jtz = p.a(paramContext, null);
    this.jti = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    this.jtj = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    if (this.jsK == 0) {
      this.jsK = e(paramContext, 13.0F);
    }
    if (this.jsL == 0) {
      this.jsL = e(paramContext, 15.0F);
    }
    if (this.jsM == 0) {
      this.jsM = e(paramContext, 14.0F);
    }
    if (this.jsP == 0) {
      this.jsP = f(paramContext, 8.0F);
    }
    if (this.jsQ == 0) {
      this.jsQ = f(paramContext, 8.0F);
    }
    this.jtA.setColor(this.jsT);
    this.jtA.setAntiAlias(true);
    this.jtA.setStyle(Paint.Style.STROKE);
    this.jtA.setStrokeWidth(this.agi);
    this.jtB.setColor(this.jsH);
    this.jtB.setAntiAlias(true);
    this.jtB.setTextAlign(Paint.Align.CENTER);
    this.jtC.setColor(this.jsJ);
    this.jtC.setAntiAlias(true);
    this.jtC.setTextAlign(Paint.Align.CENTER);
    this.jtC.setTextSize(this.jsM);
    if (this.jsW % 2 == 0) {
      this.jsW += 1;
    }
    if ((this.jsZ == -1) || (this.jta == -1)) {
      aSa();
    }
    aRU();
    AppMethodBeat.o(126763);
  }
  
  private void j(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(126787);
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt1 > paramInt2)
    {
      localIllegalArgumentException = new IllegalArgumentException("minShowIndex should be less than maxShowIndex, minShowIndex is " + paramInt1 + ", maxShowIndex is " + paramInt2 + ".");
      AppMethodBeat.o(126787);
      throw localIllegalArgumentException;
    }
    if (this.jtD == null)
    {
      localIllegalArgumentException = new IllegalArgumentException("mDisplayedValues should not be null, you need to set mDisplayedValues first.");
      AppMethodBeat.o(126787);
      throw localIllegalArgumentException;
    }
    if (paramInt1 < 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("minShowIndex should not be less than 0, now minShowIndex is ".concat(String.valueOf(paramInt1)));
      AppMethodBeat.o(126787);
      throw localIllegalArgumentException;
    }
    if (paramInt1 > this.jtD.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.jtD.length - 1) + " minShowIndex is " + paramInt1);
      AppMethodBeat.o(126787);
      throw localIllegalArgumentException;
    }
    if (paramInt2 < 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(126787);
      throw localIllegalArgumentException;
    }
    if (paramInt2 > this.jtD.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.jtD.length - 1) + " maxShowIndex is " + paramInt2);
      AppMethodBeat.o(126787);
      throw localIllegalArgumentException;
    }
    this.jsZ = paramInt1;
    this.jta = paramInt2;
    if (paramBoolean)
    {
      this.jth = (this.jsZ + 0);
      if ((!this.jtt) || (!this.jtv)) {
        break label335;
      }
    }
    label335:
    for (paramBoolean = true;; paramBoolean = false)
    {
      M(0, paramBoolean);
      postInvalidate();
      AppMethodBeat.o(126787);
      return;
    }
  }
  
  private static int k(int paramInt1, int paramInt2, boolean paramBoolean)
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
  
  private void qM(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
  }
  
  private int qN(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(126791);
    if (this.ef == 0)
    {
      AppMethodBeat.o(126791);
      return 0;
    }
    paramInt /= this.ef;
    int i = this.jsW / 2;
    int j = getOneRecycleSize();
    boolean bool1 = bool2;
    if (this.jtt)
    {
      bool1 = bool2;
      if (this.jtv) {
        bool1 = true;
      }
    }
    paramInt = k(paramInt + i, j, bool1);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      i = this.jsZ;
      AppMethodBeat.o(126791);
      return paramInt + i;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + paramInt + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.jtt);
    AppMethodBeat.o(126791);
    throw localIllegalArgumentException;
  }
  
  private int qO(int paramInt)
  {
    if ((this.jtt) && (this.jtv)) {}
    do
    {
      return paramInt;
      if (paramInt < this.jtP) {
        return this.jtP;
      }
    } while (paramInt <= this.jtO);
    return this.jtO;
  }
  
  public final void aSe()
  {
    AppMethodBeat.i(126809);
    aSd();
    if (this.jtG != null) {
      this.jtG.sendMessageDelayed(c(1, 0, 0, null), 0L);
    }
    AppMethodBeat.o(126809);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(126797);
    if (this.ef == 0)
    {
      AppMethodBeat.o(126797);
      return;
    }
    if (this.jtz.jR.computeScrollOffset())
    {
      this.jtY = this.jtz.jR.getCurrY();
      aRX();
      postInvalidate();
    }
    AppMethodBeat.o(126797);
  }
  
  public String getContentByCurrValue()
  {
    AppMethodBeat.i(126776);
    String str = this.jtD[(getValue() - this.jtb)];
    AppMethodBeat.o(126776);
    return str;
  }
  
  public String[] getDisplayedValues()
  {
    return this.jtD;
  }
  
  public int getMaxValue()
  {
    return this.jtc;
  }
  
  public int getMinValue()
  {
    return this.jtb;
  }
  
  public int getOneRecycleSize()
  {
    return this.jta - this.jsZ + 1;
  }
  
  public int getPickedIndexRelativeToRaw()
  {
    AppMethodBeat.i(126786);
    int i;
    if (this.jtX != 0) {
      if (this.jtX < -this.ef / 2) {
        i = qN(this.jtY + this.ef + this.jtX);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(126786);
      return i;
      i = qN(this.jtY + this.jtX);
      continue;
      i = qN(this.jtY);
    }
  }
  
  public int getRawContentSize()
  {
    if (this.jtD != null) {
      return this.jtD.length;
    }
    return 0;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(126775);
    int i = getPickedIndexRelativeToRaw();
    int j = this.jtb;
    AppMethodBeat.o(126775);
    return i + j;
  }
  
  public boolean getWrapSelectorWheel()
  {
    return this.jtt;
  }
  
  public boolean getWrapSelectorWheelAbsolutely()
  {
    return (this.jtt) && (this.jtv);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(126768);
    super.onAttachedToWindow();
    if ((this.mHandlerThread == null) || (!this.mHandlerThread.isAlive())) {
      aRU();
    }
    AppMethodBeat.o(126768);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(126769);
    super.onDetachedFromWindow();
    this.mHandlerThread.quit();
    if (this.ef == 0)
    {
      AppMethodBeat.o(126769);
      return;
    }
    if (!this.jtz.jR.isFinished())
    {
      this.jtz.jR.abortAnimation();
      this.jtY = this.jtz.jR.getCurrY();
      aRX();
      if (this.jtX != 0)
      {
        if (this.jtX >= -this.ef / 2) {
          break label180;
        }
        this.jtY = (this.jtY + this.ef + this.jtX);
      }
    }
    for (;;)
    {
      aRX();
      qM(0);
      int i = qN(this.jtY);
      if ((i != this.jth) && (this.jtx)) {}
      try
      {
        if (this.jtJ != null) {
          this.jtJ.a(this, this.jtb + i);
        }
        this.jth = i;
        AppMethodBeat.o(126769);
        return;
        label180:
        this.jtY += this.jtX;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.YANumberPicker", localException, "", new Object[0]);
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(126800);
    super.onDraw(paramCanvas);
    float f1 = 0.0F;
    int j = 0;
    if (j < this.jsW + 1)
    {
      float f5 = this.jtX + this.ef * j;
      int i = this.jtW;
      int k = getOneRecycleSize();
      boolean bool;
      label71:
      float f3;
      float f2;
      if ((this.jtt) && (this.jtv))
      {
        bool = true;
        k = k(i + j, k, bool);
        if (j != this.jsW / 2) {
          break label297;
        }
        f3 = (this.ef + this.jtX) / this.ef;
        i = c(f3, this.jsH, this.jsI);
        f1 = this.jsK;
        f1 += (this.jsL - f1) * f3;
        f2 = this.jtp;
        f2 += (this.jtq - f2) * f3;
        label165:
        this.jtB.setColor(i);
        this.jtB.setTextSize(f1);
        if ((k < 0) || (k >= getOneRecycleSize())) {
          break label406;
        }
        String str = this.jtD[(this.jsZ + k)];
        Object localObject = str;
        if (this.jtl != null) {
          localObject = TextUtils.ellipsize(str, this.jtB, getWidth() - this.jsS * 2, getEllipsizeType());
        }
        paramCanvas.drawText(((CharSequence)localObject).toString(), this.jtV, f2 + (f5 + this.ef / 2), this.jtB);
      }
      for (;;)
      {
        j += 1;
        f1 = f3;
        break;
        bool = false;
        break label71;
        label297:
        if (j == this.jsW / 2 + 1)
        {
          i = c(1.0F - f1, this.jsH, this.jsI);
          f2 = this.jsK;
          f2 = (1.0F - f1) * (this.jsL - f2) + f2;
          f3 = this.jtp;
          f4 = (1.0F - f1) * (this.jtq - f3) + f3;
          f3 = f1;
          f1 = f2;
          f2 = f4;
          break label165;
        }
        i = this.jsH;
        float f4 = this.jsK;
        f2 = this.jtp;
        f3 = f1;
        f1 = f4;
        break label165;
        label406:
        if (!TextUtils.isEmpty(this.jtm)) {
          paramCanvas.drawText(this.jtm, this.jtV, f2 + (f5 + this.ef / 2), this.jtB);
        }
      }
    }
    if (this.jts)
    {
      paramCanvas.drawLine(getPaddingLeft() + this.jsU, this.jtT, this.asY - getPaddingRight() - this.jsV, this.jtT, this.jtA);
      paramCanvas.drawLine(getPaddingLeft() + this.jsU, this.jtU, this.asY - getPaddingRight() - this.jsV, this.jtU, this.jtA);
    }
    if (!TextUtils.isEmpty(this.jtk)) {
      paramCanvas.drawText(this.jtk, this.jtV + (this.jtd + this.jsN) / 2 + this.jsP, (this.jtT + this.jtU) / 2.0F + this.jtr, this.jtC);
    }
    AppMethodBeat.o(126800);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(126765);
    super.onMeasure(paramInt1, paramInt2);
    fu(false);
    int k = View.MeasureSpec.getMode(paramInt1);
    this.jtZ = k;
    int j = View.MeasureSpec.getSize(paramInt1);
    if (k == 1073741824)
    {
      paramInt1 = j;
      j = View.MeasureSpec.getMode(paramInt2);
      this.jua = j;
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      if (j != 1073741824) {
        break label214;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      AppMethodBeat.o(126765);
      return;
      if (Math.max(this.jsN, this.jsO) == 0)
      {
        paramInt1 = 0;
        label102:
        if (Math.max(this.jsN, this.jsO) != 0) {
          break label206;
        }
      }
      for (;;)
      {
        int m = this.jtf;
        int n = Math.max(this.jtd, this.jtg);
        i = Math.max(m, (paramInt1 + (i + Math.max(this.jsN, this.jsO)) + this.jsS * 2) * 2 + n) + (getPaddingLeft() + getPaddingRight());
        paramInt1 = i;
        if (k != -2147483648) {
          break;
        }
        paramInt1 = Math.min(i, j);
        break;
        paramInt1 = this.jsQ;
        break label102;
        label206:
        i = this.jsP;
      }
      label214:
      i = this.jsW * (this.jte + this.jsR * 2) + (getPaddingTop() + getPaddingBottom());
      if (j == -2147483648) {
        paramInt2 = Math.min(i, paramInt2);
      } else {
        paramInt2 = i;
      }
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(126766);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.asY = paramInt1;
    this.asZ = paramInt2;
    this.ef = (this.asZ / this.jsW);
    this.jtV = ((this.asY + getPaddingLeft() - getPaddingRight()) / 2.0F);
    if (getOneRecycleSize() > 1) {
      if (this.mHasInit) {
        paramInt1 = getValue() - this.jtb;
      }
    }
    for (;;)
    {
      if ((this.jtt) && (this.jtv)) {}
      IllegalArgumentException localIllegalArgumentException;
      for (boolean bool = true;; bool = false)
      {
        M(paramInt1, bool);
        if (this.jsK > this.ef) {
          this.jsK = this.ef;
        }
        if (this.jsL > this.ef) {
          this.jsL = this.ef;
        }
        if (this.jtC != null) {
          break label209;
        }
        localIllegalArgumentException = new IllegalArgumentException("mPaintHint should not be null.");
        AppMethodBeat.o(126766);
        throw localIllegalArgumentException;
        if (this.jtu)
        {
          paramInt1 = this.jtW + (this.jsW - 1) / 2;
          break;
        }
        paramInt1 = 0;
        break;
      }
      label209:
      this.jtC.setTextSize(this.jsM);
      this.jtr = a(this.jtC.getFontMetrics());
      this.jsN = a(this.jtk, this.jtC);
      if (this.jtB == null)
      {
        localIllegalArgumentException = new IllegalArgumentException("mPaintText should not be null.");
        AppMethodBeat.o(126766);
        throw localIllegalArgumentException;
      }
      this.jtB.setTextSize(this.jsL);
      this.jtq = a(this.jtB.getFontMetrics());
      this.jtB.setTextSize(this.jsK);
      this.jtp = a(this.jtB.getFontMetrics());
      aRW();
      this.jsX = (this.jsW / 2);
      this.jsY = (this.jsX + 1);
      this.jtT = (this.jsX * this.asZ / this.jsW);
      this.jtU = (this.jsY * this.asZ / this.jsW);
      if (this.jsU < 0) {
        this.jsU = 0;
      }
      if (this.jsV < 0) {
        this.jsV = 0;
      }
      if ((this.jsU + this.jsV != 0) && (getPaddingLeft() + this.jsU >= this.asY - getPaddingRight() - this.jsV))
      {
        paramInt1 = getPaddingLeft() + this.jsU + getPaddingRight() + this.jsV - this.asY;
        this.jsU = ((int)(this.jsU - paramInt1 * this.jsU / (this.jsU + this.jsV)));
        this.jsV = ((int)(this.jsV - paramInt1 * this.jsV / (this.jsU + this.jsV)));
      }
      this.mHasInit = true;
      AppMethodBeat.o(126766);
      return;
      paramInt1 = 0;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126794);
    if (this.ef == 0)
    {
      AppMethodBeat.o(126794);
      return true;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    this.jtR = paramMotionEvent.getY();
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
            AppMethodBeat.o(126794);
            return true;
            this.jtS = true;
            this.jtG.removeMessages(1);
            aSd();
            this.bTF = this.jtR;
            this.jtQ = this.jtY;
            qM(0);
            getParent().requestDisallowInterceptTouchEvent(true);
            continue;
            f = this.bTF - this.jtR;
            if ((!this.jtS) || (-this.jtj >= f) || (f >= this.jtj))
            {
              this.jtS = false;
              this.jtY = qO((int)(f + this.jtQ));
              aRX();
              invalidate();
            }
            qM(1);
          }
          if (!this.jtS) {
            break;
          }
          f = paramMotionEvent.getY();
          i = 0;
        } while (i >= this.jsW);
        if ((this.ef * i > f) || (f >= this.ef * (i + 1))) {
          break;
        }
      } while ((i < 0) || (i >= this.jsW));
      i -= this.jsW / 2;
      if (this.jtt)
      {
        j = i;
        if (this.jtv) {}
      }
      else
      {
        k = getPickedIndexRelativeToRaw();
        if (k + i <= this.jta) {
          break;
        }
        j = this.jta - k;
      }
      if (this.jtX < -this.ef / 2)
      {
        k = this.ef + this.jtX;
        i = (int)((this.ef + this.jtX) * 300.0F / this.ef);
        if (j < 0)
        {
          i = -i - j * 300;
          label392:
          n = this.ef;
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
      this.jtz.startScroll(0, this.jtY, 0, k + j * n, m);
      this.jtG.sendMessageDelayed(c(1, 0, 0, null), m / 4);
      postInvalidate();
      break;
      j = i;
      if (k + i >= this.jsZ) {
        break label330;
      }
      j = this.jsZ - k;
      break label330;
      i += j * 300;
      break label392;
      k = this.jtX;
      i = (int)(-this.jtX * 300.0F / this.ef);
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
      j = (int)(paramMotionEvent.getYVelocity() * this.jto);
      if (Math.abs(j) > this.jti)
      {
        paramMotionEvent = this.jtz;
        i = this.jtY;
        j = -j;
        k = qO(-2147483648);
        m = qO(2147483647);
        paramMotionEvent.jR.fling(0, i, 0, j, -2147483648, 2147483647, k, m);
        invalidate();
        qM(2);
      }
      this.jtG.sendMessageDelayed(c(1, 0, 0, null), 0L);
      if (this.mVelocityTracker == null) {
        break;
      }
      this.mVelocityTracker.clear();
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      break;
      this.jtQ = this.jtY;
      aSd();
      this.jtG.sendMessageDelayed(c(1, 0, 0, null), 0L);
      break;
    }
  }
  
  public void postInvalidate()
  {
    AppMethodBeat.i(126767);
    if (!t.aw(this))
    {
      AppMethodBeat.o(126767);
      return;
    }
    super.postInvalidate();
    AppMethodBeat.o(126767);
  }
  
  public void setContentTextTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(126789);
    this.jtB.setTypeface(paramTypeface);
    AppMethodBeat.o(126789);
  }
  
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    boolean bool = true;
    AppMethodBeat.i(126770);
    if (this.jtG != null) {
      this.jtG.removeMessages(1);
    }
    aSd();
    if (paramArrayOfString == null)
    {
      paramArrayOfString = new IllegalArgumentException("newDisplayedValues should not be null.");
      AppMethodBeat.o(126770);
      throw paramArrayOfString;
    }
    if (this.jtc - this.jtb + 1 > paramArrayOfString.length)
    {
      paramArrayOfString = new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + (this.jtc - this.jtb + 1) + " newDisplayedValues.length is " + paramArrayOfString.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
      AppMethodBeat.o(126770);
      throw paramArrayOfString;
    }
    this.jtD = paramArrayOfString;
    aSc();
    fu(true);
    this.jth = (this.jsZ + 0);
    if ((this.jtt) && (this.jtv)) {}
    for (;;)
    {
      M(0, bool);
      postInvalidate();
      this.jtH.sendEmptyMessage(3);
      AppMethodBeat.o(126770);
      return;
      bool = false;
    }
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(126782);
    if (this.jsT == paramInt)
    {
      AppMethodBeat.o(126782);
      return;
    }
    this.jsT = paramInt;
    this.jtA.setColor(this.jsT);
    postInvalidate();
    AppMethodBeat.o(126782);
  }
  
  public void setDividerHeight(int paramInt)
  {
    AppMethodBeat.i(126783);
    if (paramInt == this.agi)
    {
      AppMethodBeat.o(126783);
      return;
    }
    this.agi = paramInt;
    this.jtA.setStrokeWidth(this.agi);
    postInvalidate();
    AppMethodBeat.o(126783);
  }
  
  public void setEllipsizeType(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(126801);
    while (i < 3)
    {
      if (new String[] { "end", "middle", "start" }[i].equals(paramString))
      {
        this.jtl = paramString;
        AppMethodBeat.o(126801);
        return;
      }
      i += 1;
    }
    this.jtl = "end";
    AppMethodBeat.o(126801);
  }
  
  public void setFriction(float paramFloat)
  {
    AppMethodBeat.i(126788);
    if (paramFloat <= 0.0F)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("you should set a a positive float friction, now friction is ".concat(String.valueOf(paramFloat)));
      AppMethodBeat.o(126788);
      throw localIllegalArgumentException;
    }
    ViewConfiguration.get(getContext());
    this.jto = (ViewConfiguration.getScrollFriction() / paramFloat);
    AppMethodBeat.o(126788);
  }
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(126777);
    String str = this.jtk;
    boolean bool;
    if (str == null) {
      if (paramString == null) {
        bool = true;
      }
    }
    while (bool)
    {
      AppMethodBeat.o(126777);
      return;
      bool = false;
      continue;
      bool = str.equals(paramString);
    }
    this.jtk = paramString;
    this.jtr = a(this.jtC.getFontMetrics());
    this.jsN = a(this.jtk, this.jtC);
    this.jtH.sendEmptyMessage(3);
    AppMethodBeat.o(126777);
  }
  
  public void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(126781);
    if (this.jsJ == paramInt)
    {
      AppMethodBeat.o(126781);
      return;
    }
    this.jsJ = paramInt;
    this.jtC.setColor(this.jsJ);
    postInvalidate();
    AppMethodBeat.o(126781);
  }
  
  public void setHintTextTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(126790);
    this.jtC.setTypeface(paramTypeface);
    AppMethodBeat.o(126790);
  }
  
  public void setItemPaddingVertical(int paramInt)
  {
    AppMethodBeat.i(126784);
    if (this.jsR == paramInt)
    {
      AppMethodBeat.o(126784);
      return;
    }
    this.jsR = paramInt;
    postInvalidate();
    AppMethodBeat.o(126784);
  }
  
  public void setMaxValue(int paramInt)
  {
    AppMethodBeat.i(126773);
    Object localObject;
    if (this.jtD == null)
    {
      localObject = new NullPointerException("mDisplayedValues should not be null");
      AppMethodBeat.o(126773);
      throw ((Throwable)localObject);
    }
    if (paramInt - this.jtb + 1 > this.jtD.length)
    {
      localObject = new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + (paramInt - this.jtb + 1) + " and mDisplayedValues.length is " + this.jtD.length);
      AppMethodBeat.o(126773);
      throw ((Throwable)localObject);
    }
    this.jtc = paramInt;
    this.jta = (this.jtc - this.jtb + this.jsZ);
    j(this.jsZ, this.jta, true);
    aRW();
    AppMethodBeat.o(126773);
  }
  
  public void setMinValue(int paramInt)
  {
    AppMethodBeat.i(126772);
    this.jtb = paramInt;
    this.jsZ = 0;
    aRW();
    AppMethodBeat.o(126772);
  }
  
  public void setNormalTextColor(int paramInt)
  {
    AppMethodBeat.i(126779);
    if (this.jsH == paramInt)
    {
      AppMethodBeat.o(126779);
      return;
    }
    this.jsH = paramInt;
    postInvalidate();
    AppMethodBeat.o(126779);
  }
  
  public void setOnScrollListener(YANumberPicker.a parama)
  {
    this.jtK = parama;
  }
  
  public void setOnValueChangeListenerInScrolling(YANumberPicker.c paramc)
  {
    this.jtL = paramc;
  }
  
  public void setOnValueChangedListener(YANumberPicker.b paramb)
  {
    this.jtJ = paramb;
  }
  
  public void setOnValueChangedListenerRelativeToRaw(YANumberPicker.d paramd)
  {
    this.jtI = paramd;
  }
  
  public void setPickedIndexRelativeToMin(int paramInt)
  {
    AppMethodBeat.i(126778);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      this.jth = (this.jsZ + paramInt);
      if ((!this.jtt) || (!this.jtv)) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      M(paramInt, bool);
      postInvalidate();
      AppMethodBeat.o(126778);
      return;
    }
  }
  
  public void setPickedIndexRelativeToRaw(int paramInt)
  {
    AppMethodBeat.i(126785);
    int i;
    if ((this.jsZ >= 0) && (this.jsZ <= paramInt) && (paramInt <= this.jta))
    {
      this.jth = paramInt;
      i = this.jsZ;
      if ((!this.jtt) || (!this.jtv)) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      M(paramInt - i, bool);
      postInvalidate();
      AppMethodBeat.o(126785);
      return;
    }
  }
  
  public void setSelectedTextColor(int paramInt)
  {
    AppMethodBeat.i(126780);
    if (this.jsI == paramInt)
    {
      AppMethodBeat.o(126780);
      return;
    }
    this.jsI = paramInt;
    postInvalidate();
    AppMethodBeat.o(126780);
  }
  
  public void setValue(int paramInt)
  {
    AppMethodBeat.i(126774);
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt < this.jtb)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value less than mMinValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(126774);
      throw localIllegalArgumentException;
    }
    if (paramInt > this.jtc)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value greater than mMaxValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(126774);
      throw localIllegalArgumentException;
    }
    setPickedIndexRelativeToRaw(paramInt - this.jtb);
    AppMethodBeat.o(126774);
  }
  
  public void setWrapSelectorWheel(boolean paramBoolean)
  {
    AppMethodBeat.i(126771);
    if (this.jtt != paramBoolean)
    {
      if (!paramBoolean)
      {
        if (this.mScrollState == 0)
        {
          aRV();
          AppMethodBeat.o(126771);
          return;
        }
        this.jtw = true;
        AppMethodBeat.o(126771);
        return;
      }
      this.jtt = paramBoolean;
      aSc();
      postInvalidate();
    }
    AppMethodBeat.o(126771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker
 * JD-Core Version:    0.7.0.1
 */