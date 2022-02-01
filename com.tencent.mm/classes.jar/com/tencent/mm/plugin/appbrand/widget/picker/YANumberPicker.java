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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public class YANumberPicker
  extends View
{
  private int aNI;
  private int aNJ;
  private int anp;
  private float cFa;
  private int lUA;
  private boolean mHasInit;
  private int mScrollState;
  private VelocityTracker mVelocityTracker;
  private int miL;
  private int miM;
  private int miN;
  private int miO;
  private int miP;
  private int miQ;
  private int miR;
  private int miS;
  private int miT;
  private int miU;
  private int miV;
  private int miW;
  private int miX;
  private int miY;
  private int miZ;
  private boolean mjA;
  private boolean mjB;
  private boolean mjC;
  private p mjD;
  private Paint mjE;
  private TextPaint mjF;
  private Paint mjG;
  private String[] mjH;
  private CharSequence[] mjI;
  private CharSequence[] mjJ;
  private ap mjK;
  private Handler mjL;
  private d mjM;
  private b mjN;
  private a mjO;
  private c mjP;
  private int mjQ;
  private int mjR;
  private int mjS;
  private int mjT;
  private float mjU;
  private float mjV;
  private boolean mjW;
  private float mjX;
  private float mjY;
  private float mjZ;
  private int mja;
  private int mjb;
  private int mjc;
  private int mjd;
  private int mje;
  private int mjf;
  private int mjg;
  private int mjh;
  private int mji;
  private int mjj;
  private int mjk;
  private int mjl;
  private int mjm;
  private int mjn;
  private String mjo;
  private String mjp;
  private String mjq;
  private String mjr;
  private float mjs;
  private float mjt;
  private float mju;
  private float mjv;
  private boolean mjw;
  private boolean mjx;
  private boolean mjy;
  private boolean mjz;
  private int mka;
  private int mkb;
  private int mkc;
  private int mkd;
  private int mke;
  
  public YANumberPicker(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138091);
    this.miL = -13421773;
    this.miM = -695533;
    this.miN = -695533;
    this.miO = 0;
    this.miP = 0;
    this.miQ = 0;
    this.miR = 0;
    this.miS = 0;
    this.miT = 0;
    this.miU = 0;
    this.miV = 0;
    this.miW = 0;
    this.miX = -695533;
    this.anp = 2;
    this.miY = 0;
    this.miZ = 0;
    this.mja = 3;
    this.mjb = 0;
    this.mjc = 0;
    this.mjd = -1;
    this.mje = -1;
    this.mjf = 0;
    this.mjg = 0;
    this.mjh = 0;
    this.mji = 0;
    this.mjj = 0;
    this.mjk = 0;
    this.mjl = 0;
    this.mjm = 150;
    this.mjn = 8;
    this.mjs = 1.0F;
    this.mjt = 0.0F;
    this.mju = 0.0F;
    this.mjv = 0.0F;
    this.mjw = true;
    this.mjx = true;
    this.mjy = false;
    this.mHasInit = false;
    this.mjz = true;
    this.mjA = false;
    this.mjB = false;
    this.mjC = true;
    this.mjE = new Paint();
    this.mjF = new TextPaint();
    this.mjG = new Paint();
    this.mScrollState = 0;
    this.mjU = 0.0F;
    this.cFa = 0.0F;
    this.mjV = 0.0F;
    this.mjW = false;
    this.mka = 0;
    this.mkb = 0;
    this.mkc = 0;
    this.mkd = 0;
    this.mke = 0;
    init(paramContext);
    AppMethodBeat.o(138091);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138092);
    this.miL = -13421773;
    this.miM = -695533;
    this.miN = -695533;
    this.miO = 0;
    this.miP = 0;
    this.miQ = 0;
    this.miR = 0;
    this.miS = 0;
    this.miT = 0;
    this.miU = 0;
    this.miV = 0;
    this.miW = 0;
    this.miX = -695533;
    this.anp = 2;
    this.miY = 0;
    this.miZ = 0;
    this.mja = 3;
    this.mjb = 0;
    this.mjc = 0;
    this.mjd = -1;
    this.mje = -1;
    this.mjf = 0;
    this.mjg = 0;
    this.mjh = 0;
    this.mji = 0;
    this.mjj = 0;
    this.mjk = 0;
    this.mjl = 0;
    this.mjm = 150;
    this.mjn = 8;
    this.mjs = 1.0F;
    this.mjt = 0.0F;
    this.mju = 0.0F;
    this.mjv = 0.0F;
    this.mjw = true;
    this.mjx = true;
    this.mjy = false;
    this.mHasInit = false;
    this.mjz = true;
    this.mjA = false;
    this.mjB = false;
    this.mjC = true;
    this.mjE = new Paint();
    this.mjF = new TextPaint();
    this.mjG = new Paint();
    this.mScrollState = 0;
    this.mjU = 0.0F;
    this.cFa = 0.0F;
    this.mjV = 0.0F;
    this.mjW = false;
    this.mka = 0;
    this.mkb = 0;
    this.mkc = 0;
    this.mkd = 0;
    this.mke = 0;
    b(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(138092);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138093);
    this.miL = -13421773;
    this.miM = -695533;
    this.miN = -695533;
    this.miO = 0;
    this.miP = 0;
    this.miQ = 0;
    this.miR = 0;
    this.miS = 0;
    this.miT = 0;
    this.miU = 0;
    this.miV = 0;
    this.miW = 0;
    this.miX = -695533;
    this.anp = 2;
    this.miY = 0;
    this.miZ = 0;
    this.mja = 3;
    this.mjb = 0;
    this.mjc = 0;
    this.mjd = -1;
    this.mje = -1;
    this.mjf = 0;
    this.mjg = 0;
    this.mjh = 0;
    this.mji = 0;
    this.mjj = 0;
    this.mjk = 0;
    this.mjl = 0;
    this.mjm = 150;
    this.mjn = 8;
    this.mjs = 1.0F;
    this.mjt = 0.0F;
    this.mju = 0.0F;
    this.mjv = 0.0F;
    this.mjw = true;
    this.mjx = true;
    this.mjy = false;
    this.mHasInit = false;
    this.mjz = true;
    this.mjA = false;
    this.mjB = false;
    this.mjC = true;
    this.mjE = new Paint();
    this.mjF = new TextPaint();
    this.mjG = new Paint();
    this.mScrollState = 0;
    this.mjU = 0.0F;
    this.cFa = 0.0F;
    this.mjV = 0.0F;
    this.mjW = false;
    this.mka = 0;
    this.mkb = 0;
    this.mkc = 0;
    this.mkd = 0;
    this.mke = 0;
    b(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(138093);
  }
  
  private void N(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(138128);
    this.mka = (paramInt - (this.mja - 1) / 2);
    this.mka = q(this.mka, getOneRecycleSize(), paramBoolean);
    if (this.lUA == 0)
    {
      this.mjy = true;
      AppMethodBeat.o(138128);
      return;
    }
    this.mkc = (this.mka * this.lUA);
    this.mjQ = (this.mka + this.mja / 2);
    this.mjQ %= getOneRecycleSize();
    if (this.mjQ < 0) {
      this.mjQ += getOneRecycleSize();
    }
    this.mjR = this.mjQ;
    bup();
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
        this.mja = localTypedArray.getInt(j, 3);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          this.miX = localTypedArray.getColor(j, -695533);
        }
        else if (j == 4)
        {
          this.anp = localTypedArray.getDimensionPixelSize(j, 2);
        }
        else if (j == 5)
        {
          this.miY = localTypedArray.getDimensionPixelSize(j, 0);
        }
        else if (j == 6)
        {
          this.miZ = localTypedArray.getDimensionPixelSize(j, 0);
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
              this.mjH = paramAttributeSet;
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
            this.miL = localTypedArray.getColor(j, -13421773);
          } else if (j == 22) {
            this.miM = localTypedArray.getColor(j, -695533);
          } else if (j == 20) {
            this.miN = localTypedArray.getColor(j, -695533);
          } else if (j == 25) {
            this.miO = localTypedArray.getDimensionPixelSize(j, d(paramContext, 13.0F));
          } else if (j == 26) {
            this.miP = localTypedArray.getDimensionPixelSize(j, d(paramContext, 15.0F));
          } else if (j == 24) {
            this.miQ = localTypedArray.getDimensionPixelSize(j, d(paramContext, 14.0F));
          } else if (j == 14) {
            this.mjd = localTypedArray.getInteger(j, 0);
          } else if (j == 13) {
            this.mje = localTypedArray.getInteger(j, 0);
          } else if (j == 27) {
            this.mjx = localTypedArray.getBoolean(j, true);
          } else if (j == 18) {
            this.mjw = localTypedArray.getBoolean(j, true);
          } else if (j == 8) {
            this.mjo = localTypedArray.getString(j);
          } else if (j == 0) {
            this.mjr = localTypedArray.getString(j);
          } else if (j == 7) {
            this.mjq = localTypedArray.getString(j);
          } else if (j == 12) {
            this.miT = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == 11) {
            this.miU = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == 10) {
            this.miV = localTypedArray.getDimensionPixelSize(j, e(paramContext, 2.0F));
          } else if (j == 9) {
            this.miW = localTypedArray.getDimensionPixelSize(j, e(paramContext, 5.0F));
          } else if (j == 1) {
            this.mjI = localTypedArray.getTextArray(j);
          } else if (j == 2) {
            this.mjJ = localTypedArray.getTextArray(j);
          } else if (j == 16) {
            this.mjB = localTypedArray.getBoolean(j, false);
          } else if (j == 15) {
            this.mjC = localTypedArray.getBoolean(j, true);
          } else if (j == 23) {
            this.mjp = localTypedArray.getString(j);
          }
        }
      }
    }
    localTypedArray.recycle();
    AppMethodBeat.o(138094);
  }
  
  private void bun()
  {
    AppMethodBeat.i(138124);
    N(getPickedIndexRelativeToRaw() - this.mjd, false);
    this.mjx = false;
    postInvalidate();
    AppMethodBeat.o(138124);
  }
  
  private void buo()
  {
    AppMethodBeat.i(138125);
    this.mjS = 0;
    this.mjT = (-this.mja * this.lUA);
    if (this.mjH != null)
    {
      this.mjS = ((getOneRecycleSize() - this.mja / 2 - 1) * this.lUA);
      this.mjT = (-(this.mja / 2) * this.lUA);
    }
    AppMethodBeat.o(138125);
  }
  
  private void bup()
  {
    AppMethodBeat.i(138130);
    this.mka = ((int)Math.floor(this.mkc / this.lUA));
    this.mkb = (-(this.mkc - this.mka * this.lUA));
    if (this.mjP != null) {
      if (-this.mkb <= this.lUA / 2) {
        break label131;
      }
    }
    label131:
    for (this.mjR = (this.mka + 1 + this.mja / 2);; this.mjR = (this.mka + this.mja / 2))
    {
      this.mjR %= getOneRecycleSize();
      if (this.mjR < 0) {
        this.mjR += getOneRecycleSize();
      }
      this.mjQ = this.mjR;
      AppMethodBeat.o(138130);
      return;
    }
  }
  
  private void buq()
  {
    AppMethodBeat.i(138135);
    float f = this.mjF.getTextSize();
    this.mjF.setTextSize(this.miP);
    this.mjh = a(this.mjH, this.mjF);
    this.mjj = a(this.mjI, this.mjF);
    this.mjk = a(this.mjJ, this.mjF);
    this.mjF.setTextSize(this.miQ);
    this.miS = a(this.mjr, this.mjF);
    this.mjF.setTextSize(f);
    AppMethodBeat.o(138135);
  }
  
  private void bur()
  {
    AppMethodBeat.i(138138);
    float f = this.mjF.getTextSize();
    this.mjF.setTextSize(this.miP);
    this.mji = ((int)(this.mjF.getFontMetrics().bottom - this.mjF.getFontMetrics().top + 0.5D));
    this.mjF.setTextSize(f);
    AppMethodBeat.o(138138);
  }
  
  private void bus()
  {
    AppMethodBeat.i(138139);
    but();
    buu();
    if (this.mjd == -1) {
      this.mjd = 0;
    }
    if (this.mje == -1) {
      this.mje = (this.mjH.length - 1);
    }
    p(this.mjd, this.mje, false);
    AppMethodBeat.o(138139);
  }
  
  private void but()
  {
    if (this.mjH == null)
    {
      this.mjH = new String[1];
      this.mjH[0] = "0";
    }
  }
  
  private void buu()
  {
    if (this.mjH.length <= this.mja) {}
    for (boolean bool = false;; bool = true)
    {
      this.mjz = bool;
      return;
    }
  }
  
  private void buv()
  {
    AppMethodBeat.i(138140);
    if ((this.mjD != null) && (!this.mjD.RH.isFinished()))
    {
      this.mjD.startScroll(0, this.mjD.RH.getCurrY(), 0, 0, 1);
      this.mjD.RH.abortAnimation();
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
    Object localObject = this.mjp;
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
  
  private void hG(boolean paramBoolean)
  {
    AppMethodBeat.i(138131);
    buq();
    bur();
    if ((paramBoolean) && ((this.mkd == -2147483648) || (this.mke == -2147483648))) {
      this.mjL.sendEmptyMessage(3);
    }
    AppMethodBeat.o(138131);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(138095);
    this.mjD = p.a(paramContext, null);
    this.mjm = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    this.mjn = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    if (this.miO == 0) {
      this.miO = d(paramContext, 13.0F);
    }
    if (this.miP == 0) {
      this.miP = d(paramContext, 15.0F);
    }
    if (this.miQ == 0) {
      this.miQ = d(paramContext, 14.0F);
    }
    if (this.miT == 0) {
      this.miT = e(paramContext, 8.0F);
    }
    if (this.miU == 0) {
      this.miU = e(paramContext, 8.0F);
    }
    this.mjE.setColor(this.miX);
    this.mjE.setAntiAlias(true);
    this.mjE.setStyle(Paint.Style.STROKE);
    this.mjE.setStrokeWidth(this.anp);
    this.mjF.setColor(this.miL);
    this.mjF.setAntiAlias(true);
    this.mjF.setTextAlign(Paint.Align.CENTER);
    this.mjG.setColor(this.miN);
    this.mjG.setAntiAlias(true);
    this.mjG.setTextAlign(Paint.Align.CENTER);
    this.mjG.setTextSize(this.miQ);
    if (this.mja % 2 == 0) {
      this.mja += 1;
    }
    if ((this.mjd == -1) || (this.mje == -1)) {
      bus();
    }
    initHandler();
    AppMethodBeat.o(138095);
  }
  
  private void initHandler()
  {
    AppMethodBeat.i(138096);
    this.mjK = new ap("HandlerThread-For-Refreshing")
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
          if (!YANumberPicker.a(YANumberPicker.this).RH.isFinished())
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
    this.mjL = new Handler()
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
    if (this.mjH == null)
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
    if (paramInt1 > this.mjH.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.mjH.length - 1) + " minShowIndex is " + paramInt1);
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt2 < 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt2 > this.mjH.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.mjH.length - 1) + " maxShowIndex is " + paramInt2);
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    this.mjd = paramInt1;
    this.mje = paramInt2;
    if (paramBoolean)
    {
      this.mjl = (this.mjd + 0);
      if ((!this.mjx) || (!this.mjz)) {
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
  
  private void vp(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
  }
  
  private int vq(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(138123);
    if (this.lUA == 0)
    {
      AppMethodBeat.o(138123);
      return 0;
    }
    paramInt /= this.lUA;
    int i = this.mja / 2;
    int j = getOneRecycleSize();
    boolean bool1 = bool2;
    if (this.mjx)
    {
      bool1 = bool2;
      if (this.mjz) {
        bool1 = true;
      }
    }
    paramInt = q(paramInt + i, j, bool1);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      i = this.mjd;
      AppMethodBeat.o(138123);
      return paramInt + i;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + paramInt + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.mjx);
    AppMethodBeat.o(138123);
    throw localIllegalArgumentException;
  }
  
  private int vr(int paramInt)
  {
    if ((this.mjx) && (this.mjz)) {}
    do
    {
      return paramInt;
      if (paramInt < this.mjT) {
        return this.mjT;
      }
    } while (paramInt <= this.mjS);
    return this.mjS;
  }
  
  public final void buw()
  {
    AppMethodBeat.i(138141);
    buv();
    if (this.mjK != null) {
      this.mjK.sendMessageDelayed(c(1, 0, 0, null), 0L);
    }
    AppMethodBeat.o(138141);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(138129);
    if (this.lUA == 0)
    {
      AppMethodBeat.o(138129);
      return;
    }
    if (this.mjD.RH.computeScrollOffset())
    {
      this.mkc = this.mjD.RH.getCurrY();
      bup();
      postInvalidate();
    }
    AppMethodBeat.o(138129);
  }
  
  public String getContentByCurrValue()
  {
    AppMethodBeat.i(138108);
    String str = this.mjH[(getValue() - this.mjf)];
    AppMethodBeat.o(138108);
    return str;
  }
  
  public String[] getDisplayedValues()
  {
    return this.mjH;
  }
  
  public int getMaxValue()
  {
    return this.mjg;
  }
  
  public int getMinValue()
  {
    return this.mjf;
  }
  
  public int getOneRecycleSize()
  {
    return this.mje - this.mjd + 1;
  }
  
  public int getPickedIndexRelativeToRaw()
  {
    AppMethodBeat.i(138118);
    int i;
    if (this.mkb != 0) {
      if (this.mkb < -this.lUA / 2) {
        i = vq(this.mkc + this.lUA + this.mkb);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(138118);
      return i;
      i = vq(this.mkc + this.mkb);
      continue;
      i = vq(this.mkc);
    }
  }
  
  public int getRawContentSize()
  {
    if (this.mjH != null) {
      return this.mjH.length;
    }
    return 0;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(138107);
    int i = getPickedIndexRelativeToRaw();
    int j = this.mjf;
    AppMethodBeat.o(138107);
    return i + j;
  }
  
  public boolean getWrapSelectorWheel()
  {
    return this.mjx;
  }
  
  public boolean getWrapSelectorWheelAbsolutely()
  {
    return (this.mjx) && (this.mjz);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(138100);
    super.onAttachedToWindow();
    if (this.mjK == null) {
      initHandler();
    }
    AppMethodBeat.o(138100);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(138101);
    super.onDetachedFromWindow();
    this.mjK.quit();
    this.mjL = null;
    if (this.lUA == 0)
    {
      AppMethodBeat.o(138101);
      return;
    }
    if (!this.mjD.RH.isFinished())
    {
      this.mjD.RH.abortAnimation();
      this.mkc = this.mjD.RH.getCurrY();
      bup();
      if (this.mkb != 0)
      {
        if (this.mkb >= -this.lUA / 2) {
          break label185;
        }
        this.mkc = (this.mkc + this.lUA + this.mkb);
      }
    }
    for (;;)
    {
      bup();
      vp(0);
      int i = vq(this.mkc);
      if ((i != this.mjl) && (this.mjB)) {}
      try
      {
        if (this.mjN != null) {
          this.mjN.a(this, this.mjf + i);
        }
        this.mjl = i;
        AppMethodBeat.o(138101);
        return;
        label185:
        this.mkc += this.mkb;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.YANumberPicker", localException, "", new Object[0]);
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
    if (j < this.mja + 1)
    {
      float f5 = this.mkb + this.lUA * j;
      int i = this.mka;
      int k = getOneRecycleSize();
      boolean bool;
      label71:
      float f3;
      float f2;
      if ((this.mjx) && (this.mjz))
      {
        bool = true;
        k = q(i + j, k, bool);
        if (j != this.mja / 2) {
          break label297;
        }
        f3 = (this.lUA + this.mkb) / this.lUA;
        i = c(f3, this.miL, this.miM);
        f1 = this.miO;
        f1 += (this.miP - f1) * f3;
        f2 = this.mjt;
        f2 += (this.mju - f2) * f3;
        label165:
        this.mjF.setColor(i);
        this.mjF.setTextSize(f1);
        if ((k < 0) || (k >= getOneRecycleSize())) {
          break label406;
        }
        String str = this.mjH[(this.mjd + k)];
        Object localObject = str;
        if (this.mjp != null) {
          localObject = TextUtils.ellipsize(str, this.mjF, getWidth() - this.miW * 2, getEllipsizeType());
        }
        paramCanvas.drawText(((CharSequence)localObject).toString(), this.mjZ, f2 + (f5 + this.lUA / 2), this.mjF);
      }
      for (;;)
      {
        j += 1;
        f1 = f3;
        break;
        bool = false;
        break label71;
        label297:
        if (j == this.mja / 2 + 1)
        {
          i = c(1.0F - f1, this.miL, this.miM);
          f2 = this.miO;
          f2 = (1.0F - f1) * (this.miP - f2) + f2;
          f3 = this.mjt;
          f4 = (1.0F - f1) * (this.mju - f3) + f3;
          f3 = f1;
          f1 = f2;
          f2 = f4;
          break label165;
        }
        i = this.miL;
        float f4 = this.miO;
        f2 = this.mjt;
        f3 = f1;
        f1 = f4;
        break label165;
        label406:
        if (!TextUtils.isEmpty(this.mjq)) {
          paramCanvas.drawText(this.mjq, this.mjZ, f2 + (f5 + this.lUA / 2), this.mjF);
        }
      }
    }
    if (this.mjw)
    {
      paramCanvas.drawLine(getPaddingLeft() + this.miY, this.mjX, this.aNI - getPaddingRight() - this.miZ, this.mjX, this.mjE);
      paramCanvas.drawLine(getPaddingLeft() + this.miY, this.mjY, this.aNI - getPaddingRight() - this.miZ, this.mjY, this.mjE);
    }
    if (!TextUtils.isEmpty(this.mjo)) {
      paramCanvas.drawText(this.mjo, this.mjZ + (this.mjh + this.miR) / 2 + this.miT, (this.mjX + this.mjY) / 2.0F + this.mjv, this.mjG);
    }
    AppMethodBeat.o(138132);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(138097);
    super.onMeasure(paramInt1, paramInt2);
    hG(false);
    int k = View.MeasureSpec.getMode(paramInt1);
    this.mkd = k;
    int j = View.MeasureSpec.getSize(paramInt1);
    if (k == 1073741824)
    {
      paramInt1 = j;
      j = View.MeasureSpec.getMode(paramInt2);
      this.mke = j;
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
      if (Math.max(this.miR, this.miS) == 0)
      {
        paramInt1 = 0;
        label102:
        if (Math.max(this.miR, this.miS) != 0) {
          break label206;
        }
      }
      for (;;)
      {
        int m = this.mjj;
        int n = Math.max(this.mjh, this.mjk);
        i = Math.max(m, (paramInt1 + (i + Math.max(this.miR, this.miS)) + this.miW * 2) * 2 + n) + (getPaddingLeft() + getPaddingRight());
        paramInt1 = i;
        if (k != -2147483648) {
          break;
        }
        paramInt1 = Math.min(i, j);
        break;
        paramInt1 = this.miU;
        break label102;
        label206:
        i = this.miT;
      }
      label214:
      i = this.mja * (this.mji + this.miV * 2) + (getPaddingTop() + getPaddingBottom());
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
    this.aNI = paramInt1;
    this.aNJ = paramInt2;
    this.lUA = (this.aNJ / this.mja);
    this.mjZ = ((this.aNI + getPaddingLeft() - getPaddingRight()) / 2.0F);
    if (getOneRecycleSize() > 1) {
      if (this.mHasInit) {
        paramInt1 = getValue() - this.mjf;
      }
    }
    for (;;)
    {
      if ((this.mjx) && (this.mjz)) {}
      IllegalArgumentException localIllegalArgumentException;
      for (boolean bool = true;; bool = false)
      {
        N(paramInt1, bool);
        if (this.miO > this.lUA) {
          this.miO = this.lUA;
        }
        if (this.miP > this.lUA) {
          this.miP = this.lUA;
        }
        if (this.mjG != null) {
          break label209;
        }
        localIllegalArgumentException = new IllegalArgumentException("mPaintHint should not be null.");
        AppMethodBeat.o(138098);
        throw localIllegalArgumentException;
        if (this.mjy)
        {
          paramInt1 = this.mka + (this.mja - 1) / 2;
          break;
        }
        paramInt1 = 0;
        break;
      }
      label209:
      this.mjG.setTextSize(this.miQ);
      this.mjv = a(this.mjG.getFontMetrics());
      this.miR = a(this.mjo, this.mjG);
      if (this.mjF == null)
      {
        localIllegalArgumentException = new IllegalArgumentException("mPaintText should not be null.");
        AppMethodBeat.o(138098);
        throw localIllegalArgumentException;
      }
      this.mjF.setTextSize(this.miP);
      this.mju = a(this.mjF.getFontMetrics());
      this.mjF.setTextSize(this.miO);
      this.mjt = a(this.mjF.getFontMetrics());
      buo();
      this.mjb = (this.mja / 2);
      this.mjc = (this.mjb + 1);
      this.mjX = (this.mjb * this.aNJ / this.mja);
      this.mjY = (this.mjc * this.aNJ / this.mja);
      if (this.miY < 0) {
        this.miY = 0;
      }
      if (this.miZ < 0) {
        this.miZ = 0;
      }
      if ((this.miY + this.miZ != 0) && (getPaddingLeft() + this.miY >= this.aNI - getPaddingRight() - this.miZ))
      {
        paramInt1 = getPaddingLeft() + this.miY + getPaddingRight() + this.miZ - this.aNI;
        this.miY = ((int)(this.miY - paramInt1 * this.miY / (this.miY + this.miZ)));
        this.miZ = ((int)(this.miZ - paramInt1 * this.miZ / (this.miY + this.miZ)));
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
    if (this.lUA == 0)
    {
      AppMethodBeat.o(138126);
      return true;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    this.mjV = paramMotionEvent.getY();
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
            this.mjW = true;
            this.mjK.removeMessages(1);
            buv();
            this.cFa = this.mjV;
            this.mjU = this.mkc;
            vp(0);
            getParent().requestDisallowInterceptTouchEvent(true);
            continue;
            f = this.cFa - this.mjV;
            if ((!this.mjW) || (-this.mjn >= f) || (f >= this.mjn))
            {
              this.mjW = false;
              this.mkc = vr((int)(f + this.mjU));
              bup();
              invalidate();
            }
            vp(1);
          }
          if (!this.mjW) {
            break;
          }
          f = paramMotionEvent.getY();
          i = 0;
        } while (i >= this.mja);
        if ((this.lUA * i > f) || (f >= this.lUA * (i + 1))) {
          break;
        }
      } while ((i < 0) || (i >= this.mja));
      i -= this.mja / 2;
      if (this.mjx)
      {
        j = i;
        if (this.mjz) {}
      }
      else
      {
        k = getPickedIndexRelativeToRaw();
        if (k + i <= this.mje) {
          break;
        }
        j = this.mje - k;
      }
      if (this.mkb < -this.lUA / 2)
      {
        k = this.lUA + this.mkb;
        i = (int)((this.lUA + this.mkb) * 300.0F / this.lUA);
        if (j < 0)
        {
          i = -i - j * 300;
          label392:
          n = this.lUA;
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
      this.mjD.startScroll(0, this.mkc, 0, k + j * n, m);
      this.mjK.sendMessageDelayed(c(1, 0, 0, null), m / 4);
      postInvalidate();
      break;
      j = i;
      if (k + i >= this.mjd) {
        break label330;
      }
      j = this.mjd - k;
      break label330;
      i += j * 300;
      break label392;
      k = this.mkb;
      i = (int)(-this.mkb * 300.0F / this.lUA);
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
      j = (int)(paramMotionEvent.getYVelocity() * this.mjs);
      if (Math.abs(j) > this.mjm)
      {
        paramMotionEvent = this.mjD;
        i = this.mkc;
        j = -j;
        k = vr(-2147483648);
        m = vr(2147483647);
        paramMotionEvent.RH.fling(0, i, 0, j, -2147483648, 2147483647, k, m);
        invalidate();
        vp(2);
      }
      this.mjK.sendMessageDelayed(c(1, 0, 0, null), 0L);
      if (this.mVelocityTracker == null) {
        break;
      }
      this.mVelocityTracker.clear();
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      break;
      this.mjU = this.mkc;
      buv();
      this.mjK.sendMessageDelayed(c(1, 0, 0, null), 0L);
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
    this.mjF.setTypeface(paramTypeface);
    AppMethodBeat.o(138121);
  }
  
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    boolean bool = true;
    AppMethodBeat.i(138102);
    if (this.mjK != null) {
      this.mjK.removeMessages(1);
    }
    buv();
    if (paramArrayOfString == null)
    {
      paramArrayOfString = new IllegalArgumentException("newDisplayedValues should not be null.");
      AppMethodBeat.o(138102);
      throw paramArrayOfString;
    }
    if (this.mjg - this.mjf + 1 > paramArrayOfString.length)
    {
      paramArrayOfString = new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + (this.mjg - this.mjf + 1) + " newDisplayedValues.length is " + paramArrayOfString.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
      AppMethodBeat.o(138102);
      throw paramArrayOfString;
    }
    this.mjH = paramArrayOfString;
    buu();
    hG(true);
    this.mjl = (this.mjd + 0);
    if ((this.mjx) && (this.mjz)) {}
    for (;;)
    {
      N(0, bool);
      postInvalidate();
      this.mjL.sendEmptyMessage(3);
      AppMethodBeat.o(138102);
      return;
      bool = false;
    }
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(138114);
    if (this.miX == paramInt)
    {
      AppMethodBeat.o(138114);
      return;
    }
    this.miX = paramInt;
    this.mjE.setColor(this.miX);
    postInvalidate();
    AppMethodBeat.o(138114);
  }
  
  public void setDividerHeight(int paramInt)
  {
    AppMethodBeat.i(138115);
    if (paramInt == this.anp)
    {
      AppMethodBeat.o(138115);
      return;
    }
    this.anp = paramInt;
    this.mjE.setStrokeWidth(this.anp);
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
        this.mjp = paramString;
        AppMethodBeat.o(138133);
        return;
      }
      i += 1;
    }
    this.mjp = "end";
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
    this.mjs = (ViewConfiguration.getScrollFriction() / paramFloat);
    AppMethodBeat.o(138120);
  }
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(138109);
    String str = this.mjo;
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
    this.mjo = paramString;
    this.mjv = a(this.mjG.getFontMetrics());
    this.miR = a(this.mjo, this.mjG);
    this.mjL.sendEmptyMessage(3);
    AppMethodBeat.o(138109);
  }
  
  public void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(138113);
    if (this.miN == paramInt)
    {
      AppMethodBeat.o(138113);
      return;
    }
    this.miN = paramInt;
    this.mjG.setColor(this.miN);
    postInvalidate();
    AppMethodBeat.o(138113);
  }
  
  public void setHintTextTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(138122);
    this.mjG.setTypeface(paramTypeface);
    AppMethodBeat.o(138122);
  }
  
  public void setItemPaddingVertical(int paramInt)
  {
    AppMethodBeat.i(138116);
    if (this.miV == paramInt)
    {
      AppMethodBeat.o(138116);
      return;
    }
    this.miV = paramInt;
    postInvalidate();
    AppMethodBeat.o(138116);
  }
  
  public void setMaxValue(int paramInt)
  {
    AppMethodBeat.i(138105);
    Object localObject;
    if (this.mjH == null)
    {
      localObject = new NullPointerException("mDisplayedValues should not be null");
      AppMethodBeat.o(138105);
      throw ((Throwable)localObject);
    }
    if (paramInt - this.mjf + 1 > this.mjH.length)
    {
      localObject = new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + (paramInt - this.mjf + 1) + " and mDisplayedValues.length is " + this.mjH.length);
      AppMethodBeat.o(138105);
      throw ((Throwable)localObject);
    }
    this.mjg = paramInt;
    this.mje = (this.mjg - this.mjf + this.mjd);
    p(this.mjd, this.mje, true);
    buo();
    AppMethodBeat.o(138105);
  }
  
  public void setMinValue(int paramInt)
  {
    AppMethodBeat.i(138104);
    this.mjf = paramInt;
    this.mjd = 0;
    buo();
    AppMethodBeat.o(138104);
  }
  
  public void setNormalTextColor(int paramInt)
  {
    AppMethodBeat.i(138111);
    if (this.miL == paramInt)
    {
      AppMethodBeat.o(138111);
      return;
    }
    this.miL = paramInt;
    postInvalidate();
    AppMethodBeat.o(138111);
  }
  
  public void setOnScrollListener(a parama)
  {
    this.mjO = parama;
  }
  
  public void setOnValueChangeListenerInScrolling(c paramc)
  {
    this.mjP = paramc;
  }
  
  public void setOnValueChangedListener(b paramb)
  {
    this.mjN = paramb;
  }
  
  public void setOnValueChangedListenerRelativeToRaw(d paramd)
  {
    this.mjM = paramd;
  }
  
  public void setPickedIndexRelativeToMin(int paramInt)
  {
    AppMethodBeat.i(138110);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      this.mjl = (this.mjd + paramInt);
      if ((!this.mjx) || (!this.mjz)) {
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
    if ((this.mjd >= 0) && (this.mjd <= paramInt) && (paramInt <= this.mje))
    {
      this.mjl = paramInt;
      i = this.mjd;
      if ((!this.mjx) || (!this.mjz)) {
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
    if (this.miM == paramInt)
    {
      AppMethodBeat.o(138112);
      return;
    }
    this.miM = paramInt;
    postInvalidate();
    AppMethodBeat.o(138112);
  }
  
  public void setValue(int paramInt)
  {
    AppMethodBeat.i(138106);
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt < this.mjf)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value less than mMinValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(138106);
      throw localIllegalArgumentException;
    }
    if (paramInt > this.mjg)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value greater than mMaxValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(138106);
      throw localIllegalArgumentException;
    }
    setPickedIndexRelativeToRaw(paramInt - this.mjf);
    AppMethodBeat.o(138106);
  }
  
  public void setWrapSelectorWheel(boolean paramBoolean)
  {
    AppMethodBeat.i(138103);
    if (this.mjx != paramBoolean)
    {
      if (!paramBoolean)
      {
        if (this.mScrollState == 0)
        {
          bun();
          AppMethodBeat.o(138103);
          return;
        }
        this.mjA = true;
        AppMethodBeat.o(138103);
        return;
      }
      this.mjx = paramBoolean;
      buu();
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