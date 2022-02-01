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
  private int aYS;
  private int aYT;
  private int aqc;
  private float cNh;
  private boolean mHasInit;
  private int mItemHeight;
  private int mScrollState;
  private VelocityTracker mVelocityTracker;
  private int nlA;
  private int nlB;
  private int nlC;
  private int nlD;
  private int nlE;
  private int nlF;
  private int nlG;
  private int nlH;
  private int nlI;
  private int nlJ;
  private String nlK;
  private String nlL;
  private String nlM;
  private String nlN;
  private float nlO;
  private float nlP;
  private float nlQ;
  private float nlR;
  private boolean nlS;
  private boolean nlT;
  private boolean nlU;
  private boolean nlV;
  private boolean nlW;
  private boolean nlX;
  private boolean nlY;
  private p nlZ;
  private int nlh;
  private int nli;
  private int nlj;
  private int nlk;
  private int nll;
  private int nlm;
  private int nln;
  private int nlo;
  private int nlp;
  private int nlq;
  private int nlr;
  private int nls;
  private int nlt;
  private int nlu;
  private int nlv;
  private int nlw;
  private int nlx;
  private int nly;
  private int nlz;
  private int nmA;
  private Paint nma;
  private TextPaint nmb;
  private Paint nmc;
  private String[] nmd;
  private CharSequence[] nme;
  private CharSequence[] nmf;
  private ap nmg;
  private Handler nmh;
  private d nmi;
  private b nmj;
  private a nmk;
  private c nml;
  private int nmm;
  private int nmn;
  private int nmo;
  private int nmp;
  private float nmq;
  private float nmr;
  private boolean nms;
  private float nmt;
  private float nmu;
  private float nmv;
  private int nmw;
  private int nmx;
  private int nmy;
  private int nmz;
  
  public YANumberPicker(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138091);
    this.nlh = -13421773;
    this.nli = -695533;
    this.nlj = -695533;
    this.nlk = 0;
    this.nll = 0;
    this.nlm = 0;
    this.nln = 0;
    this.nlo = 0;
    this.nlp = 0;
    this.nlq = 0;
    this.nlr = 0;
    this.nls = 0;
    this.nlt = -695533;
    this.aqc = 2;
    this.nlu = 0;
    this.nlv = 0;
    this.nlw = 3;
    this.nlx = 0;
    this.nly = 0;
    this.nlz = -1;
    this.nlA = -1;
    this.nlB = 0;
    this.nlC = 0;
    this.nlD = 0;
    this.nlE = 0;
    this.nlF = 0;
    this.nlG = 0;
    this.nlH = 0;
    this.nlI = 150;
    this.nlJ = 8;
    this.nlO = 1.0F;
    this.nlP = 0.0F;
    this.nlQ = 0.0F;
    this.nlR = 0.0F;
    this.nlS = true;
    this.nlT = true;
    this.nlU = false;
    this.mHasInit = false;
    this.nlV = true;
    this.nlW = false;
    this.nlX = false;
    this.nlY = true;
    this.nma = new Paint();
    this.nmb = new TextPaint();
    this.nmc = new Paint();
    this.mScrollState = 0;
    this.nmq = 0.0F;
    this.cNh = 0.0F;
    this.nmr = 0.0F;
    this.nms = false;
    this.nmw = 0;
    this.nmx = 0;
    this.nmy = 0;
    this.nmz = 0;
    this.nmA = 0;
    init(paramContext);
    AppMethodBeat.o(138091);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138092);
    this.nlh = -13421773;
    this.nli = -695533;
    this.nlj = -695533;
    this.nlk = 0;
    this.nll = 0;
    this.nlm = 0;
    this.nln = 0;
    this.nlo = 0;
    this.nlp = 0;
    this.nlq = 0;
    this.nlr = 0;
    this.nls = 0;
    this.nlt = -695533;
    this.aqc = 2;
    this.nlu = 0;
    this.nlv = 0;
    this.nlw = 3;
    this.nlx = 0;
    this.nly = 0;
    this.nlz = -1;
    this.nlA = -1;
    this.nlB = 0;
    this.nlC = 0;
    this.nlD = 0;
    this.nlE = 0;
    this.nlF = 0;
    this.nlG = 0;
    this.nlH = 0;
    this.nlI = 150;
    this.nlJ = 8;
    this.nlO = 1.0F;
    this.nlP = 0.0F;
    this.nlQ = 0.0F;
    this.nlR = 0.0F;
    this.nlS = true;
    this.nlT = true;
    this.nlU = false;
    this.mHasInit = false;
    this.nlV = true;
    this.nlW = false;
    this.nlX = false;
    this.nlY = true;
    this.nma = new Paint();
    this.nmb = new TextPaint();
    this.nmc = new Paint();
    this.mScrollState = 0;
    this.nmq = 0.0F;
    this.cNh = 0.0F;
    this.nmr = 0.0F;
    this.nms = false;
    this.nmw = 0;
    this.nmx = 0;
    this.nmy = 0;
    this.nmz = 0;
    this.nmA = 0;
    b(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(138092);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138093);
    this.nlh = -13421773;
    this.nli = -695533;
    this.nlj = -695533;
    this.nlk = 0;
    this.nll = 0;
    this.nlm = 0;
    this.nln = 0;
    this.nlo = 0;
    this.nlp = 0;
    this.nlq = 0;
    this.nlr = 0;
    this.nls = 0;
    this.nlt = -695533;
    this.aqc = 2;
    this.nlu = 0;
    this.nlv = 0;
    this.nlw = 3;
    this.nlx = 0;
    this.nly = 0;
    this.nlz = -1;
    this.nlA = -1;
    this.nlB = 0;
    this.nlC = 0;
    this.nlD = 0;
    this.nlE = 0;
    this.nlF = 0;
    this.nlG = 0;
    this.nlH = 0;
    this.nlI = 150;
    this.nlJ = 8;
    this.nlO = 1.0F;
    this.nlP = 0.0F;
    this.nlQ = 0.0F;
    this.nlR = 0.0F;
    this.nlS = true;
    this.nlT = true;
    this.nlU = false;
    this.mHasInit = false;
    this.nlV = true;
    this.nlW = false;
    this.nlX = false;
    this.nlY = true;
    this.nma = new Paint();
    this.nmb = new TextPaint();
    this.nmc = new Paint();
    this.mScrollState = 0;
    this.nmq = 0.0F;
    this.cNh = 0.0F;
    this.nmr = 0.0F;
    this.nms = false;
    this.nmw = 0;
    this.nmx = 0;
    this.nmy = 0;
    this.nmz = 0;
    this.nmA = 0;
    b(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(138093);
  }
  
  private void N(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(138128);
    this.nmw = (paramInt - (this.nlw - 1) / 2);
    this.nmw = q(this.nmw, getOneRecycleSize(), paramBoolean);
    if (this.mItemHeight == 0)
    {
      this.nlU = true;
      AppMethodBeat.o(138128);
      return;
    }
    this.nmy = (this.nmw * this.mItemHeight);
    this.nmm = (this.nmw + this.nlw / 2);
    this.nmm %= getOneRecycleSize();
    if (this.nmm < 0) {
      this.nmm += getOneRecycleSize();
    }
    this.nmn = this.nmm;
    bFo();
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
        this.nlw = localTypedArray.getInt(j, 3);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          this.nlt = localTypedArray.getColor(j, -695533);
        }
        else if (j == 4)
        {
          this.aqc = localTypedArray.getDimensionPixelSize(j, 2);
        }
        else if (j == 5)
        {
          this.nlu = localTypedArray.getDimensionPixelSize(j, 0);
        }
        else if (j == 6)
        {
          this.nlv = localTypedArray.getDimensionPixelSize(j, 0);
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
              this.nmd = paramAttributeSet;
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
            this.nlh = localTypedArray.getColor(j, -13421773);
          } else if (j == 22) {
            this.nli = localTypedArray.getColor(j, -695533);
          } else if (j == 20) {
            this.nlj = localTypedArray.getColor(j, -695533);
          } else if (j == 25) {
            this.nlk = localTypedArray.getDimensionPixelSize(j, d(paramContext, 13.0F));
          } else if (j == 26) {
            this.nll = localTypedArray.getDimensionPixelSize(j, d(paramContext, 15.0F));
          } else if (j == 24) {
            this.nlm = localTypedArray.getDimensionPixelSize(j, d(paramContext, 14.0F));
          } else if (j == 14) {
            this.nlz = localTypedArray.getInteger(j, 0);
          } else if (j == 13) {
            this.nlA = localTypedArray.getInteger(j, 0);
          } else if (j == 27) {
            this.nlT = localTypedArray.getBoolean(j, true);
          } else if (j == 18) {
            this.nlS = localTypedArray.getBoolean(j, true);
          } else if (j == 8) {
            this.nlK = localTypedArray.getString(j);
          } else if (j == 0) {
            this.nlN = localTypedArray.getString(j);
          } else if (j == 7) {
            this.nlM = localTypedArray.getString(j);
          } else if (j == 12) {
            this.nlp = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == 11) {
            this.nlq = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == 10) {
            this.nlr = localTypedArray.getDimensionPixelSize(j, e(paramContext, 2.0F));
          } else if (j == 9) {
            this.nls = localTypedArray.getDimensionPixelSize(j, e(paramContext, 5.0F));
          } else if (j == 1) {
            this.nme = localTypedArray.getTextArray(j);
          } else if (j == 2) {
            this.nmf = localTypedArray.getTextArray(j);
          } else if (j == 16) {
            this.nlX = localTypedArray.getBoolean(j, false);
          } else if (j == 15) {
            this.nlY = localTypedArray.getBoolean(j, true);
          } else if (j == 23) {
            this.nlL = localTypedArray.getString(j);
          }
        }
      }
    }
    localTypedArray.recycle();
    AppMethodBeat.o(138094);
  }
  
  private void bFm()
  {
    AppMethodBeat.i(138124);
    N(getPickedIndexRelativeToRaw() - this.nlz, false);
    this.nlT = false;
    postInvalidate();
    AppMethodBeat.o(138124);
  }
  
  private void bFn()
  {
    AppMethodBeat.i(138125);
    this.nmo = 0;
    this.nmp = (-this.nlw * this.mItemHeight);
    if (this.nmd != null)
    {
      this.nmo = ((getOneRecycleSize() - this.nlw / 2 - 1) * this.mItemHeight);
      this.nmp = (-(this.nlw / 2) * this.mItemHeight);
    }
    AppMethodBeat.o(138125);
  }
  
  private void bFo()
  {
    AppMethodBeat.i(138130);
    this.nmw = ((int)Math.floor(this.nmy / this.mItemHeight));
    this.nmx = (-(this.nmy - this.nmw * this.mItemHeight));
    if (this.nml != null) {
      if (-this.nmx <= this.mItemHeight / 2) {
        break label131;
      }
    }
    label131:
    for (this.nmn = (this.nmw + 1 + this.nlw / 2);; this.nmn = (this.nmw + this.nlw / 2))
    {
      this.nmn %= getOneRecycleSize();
      if (this.nmn < 0) {
        this.nmn += getOneRecycleSize();
      }
      this.nmm = this.nmn;
      AppMethodBeat.o(138130);
      return;
    }
  }
  
  private void bFp()
  {
    AppMethodBeat.i(138135);
    float f = this.nmb.getTextSize();
    this.nmb.setTextSize(this.nll);
    this.nlD = a(this.nmd, this.nmb);
    this.nlF = a(this.nme, this.nmb);
    this.nlG = a(this.nmf, this.nmb);
    this.nmb.setTextSize(this.nlm);
    this.nlo = a(this.nlN, this.nmb);
    this.nmb.setTextSize(f);
    AppMethodBeat.o(138135);
  }
  
  private void bFq()
  {
    AppMethodBeat.i(138138);
    float f = this.nmb.getTextSize();
    this.nmb.setTextSize(this.nll);
    this.nlE = ((int)(this.nmb.getFontMetrics().bottom - this.nmb.getFontMetrics().top + 0.5D));
    this.nmb.setTextSize(f);
    AppMethodBeat.o(138138);
  }
  
  private void bFr()
  {
    AppMethodBeat.i(138139);
    bFs();
    bFt();
    if (this.nlz == -1) {
      this.nlz = 0;
    }
    if (this.nlA == -1) {
      this.nlA = (this.nmd.length - 1);
    }
    p(this.nlz, this.nlA, false);
    AppMethodBeat.o(138139);
  }
  
  private void bFs()
  {
    if (this.nmd == null)
    {
      this.nmd = new String[1];
      this.nmd[0] = "0";
    }
  }
  
  private void bFt()
  {
    if (this.nmd.length <= this.nlw) {}
    for (boolean bool = false;; bool = true)
    {
      this.nlV = bool;
      return;
    }
  }
  
  private void bFu()
  {
    AppMethodBeat.i(138140);
    if ((this.nlZ != null) && (!this.nlZ.Ur.isFinished()))
    {
      this.nlZ.startScroll(0, this.nlZ.Ur.getCurrY(), 0, 0, 1);
      this.nlZ.Ur.abortAnimation();
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
    Object localObject = this.nlL;
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
    this.nlZ = p.a(paramContext, null);
    this.nlI = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    this.nlJ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    if (this.nlk == 0) {
      this.nlk = d(paramContext, 13.0F);
    }
    if (this.nll == 0) {
      this.nll = d(paramContext, 15.0F);
    }
    if (this.nlm == 0) {
      this.nlm = d(paramContext, 14.0F);
    }
    if (this.nlp == 0) {
      this.nlp = e(paramContext, 8.0F);
    }
    if (this.nlq == 0) {
      this.nlq = e(paramContext, 8.0F);
    }
    this.nma.setColor(this.nlt);
    this.nma.setAntiAlias(true);
    this.nma.setStyle(Paint.Style.STROKE);
    this.nma.setStrokeWidth(this.aqc);
    this.nmb.setColor(this.nlh);
    this.nmb.setAntiAlias(true);
    this.nmb.setTextAlign(Paint.Align.CENTER);
    this.nmc.setColor(this.nlj);
    this.nmc.setAntiAlias(true);
    this.nmc.setTextAlign(Paint.Align.CENTER);
    this.nmc.setTextSize(this.nlm);
    if (this.nlw % 2 == 0) {
      this.nlw += 1;
    }
    if ((this.nlz == -1) || (this.nlA == -1)) {
      bFr();
    }
    initHandler();
    AppMethodBeat.o(138095);
  }
  
  private void initHandler()
  {
    AppMethodBeat.i(138096);
    this.nmg = new ap("HandlerThread-For-Refreshing")
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
          if (!YANumberPicker.a(YANumberPicker.this).Ur.isFinished())
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
    this.nmh = new Handler()
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
  
  private void io(boolean paramBoolean)
  {
    AppMethodBeat.i(138131);
    bFp();
    bFq();
    if ((paramBoolean) && ((this.nmz == -2147483648) || (this.nmA == -2147483648))) {
      this.nmh.sendEmptyMessage(3);
    }
    AppMethodBeat.o(138131);
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
    if (this.nmd == null)
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
    if (paramInt1 > this.nmd.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.nmd.length - 1) + " minShowIndex is " + paramInt1);
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt2 < 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt2 > this.nmd.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.nmd.length - 1) + " maxShowIndex is " + paramInt2);
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    this.nlz = paramInt1;
    this.nlA = paramInt2;
    if (paramBoolean)
    {
      this.nlH = (this.nlz + 0);
      if ((!this.nlT) || (!this.nlV)) {
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
  
  private void wL(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
  }
  
  private int wM(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(138123);
    if (this.mItemHeight == 0)
    {
      AppMethodBeat.o(138123);
      return 0;
    }
    paramInt /= this.mItemHeight;
    int i = this.nlw / 2;
    int j = getOneRecycleSize();
    boolean bool1 = bool2;
    if (this.nlT)
    {
      bool1 = bool2;
      if (this.nlV) {
        bool1 = true;
      }
    }
    paramInt = q(paramInt + i, j, bool1);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      i = this.nlz;
      AppMethodBeat.o(138123);
      return paramInt + i;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + paramInt + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.nlT);
    AppMethodBeat.o(138123);
    throw localIllegalArgumentException;
  }
  
  private int wN(int paramInt)
  {
    if ((this.nlT) && (this.nlV)) {}
    do
    {
      return paramInt;
      if (paramInt < this.nmp) {
        return this.nmp;
      }
    } while (paramInt <= this.nmo);
    return this.nmo;
  }
  
  public final void bFv()
  {
    AppMethodBeat.i(138141);
    bFu();
    if (this.nmg != null) {
      this.nmg.sendMessageDelayed(c(1, 0, 0, null), 0L);
    }
    AppMethodBeat.o(138141);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(138129);
    if (this.mItemHeight == 0)
    {
      AppMethodBeat.o(138129);
      return;
    }
    if (this.nlZ.Ur.computeScrollOffset())
    {
      this.nmy = this.nlZ.Ur.getCurrY();
      bFo();
      postInvalidate();
    }
    AppMethodBeat.o(138129);
  }
  
  public String getContentByCurrValue()
  {
    AppMethodBeat.i(138108);
    String str = this.nmd[(getValue() - this.nlB)];
    AppMethodBeat.o(138108);
    return str;
  }
  
  public String[] getDisplayedValues()
  {
    return this.nmd;
  }
  
  public int getMaxValue()
  {
    return this.nlC;
  }
  
  public int getMinValue()
  {
    return this.nlB;
  }
  
  public int getOneRecycleSize()
  {
    return this.nlA - this.nlz + 1;
  }
  
  public int getPickedIndexRelativeToRaw()
  {
    AppMethodBeat.i(138118);
    int i;
    if (this.nmx != 0) {
      if (this.nmx < -this.mItemHeight / 2) {
        i = wM(this.nmy + this.mItemHeight + this.nmx);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(138118);
      return i;
      i = wM(this.nmy + this.nmx);
      continue;
      i = wM(this.nmy);
    }
  }
  
  public int getRawContentSize()
  {
    if (this.nmd != null) {
      return this.nmd.length;
    }
    return 0;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(138107);
    int i = getPickedIndexRelativeToRaw();
    int j = this.nlB;
    AppMethodBeat.o(138107);
    return i + j;
  }
  
  public boolean getWrapSelectorWheel()
  {
    return this.nlT;
  }
  
  public boolean getWrapSelectorWheelAbsolutely()
  {
    return (this.nlT) && (this.nlV);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(138100);
    super.onAttachedToWindow();
    if (this.nmg == null) {
      initHandler();
    }
    AppMethodBeat.o(138100);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(138101);
    super.onDetachedFromWindow();
    this.nmg.quit();
    this.nmh = null;
    if (this.mItemHeight == 0)
    {
      AppMethodBeat.o(138101);
      return;
    }
    if (!this.nlZ.Ur.isFinished())
    {
      this.nlZ.Ur.abortAnimation();
      this.nmy = this.nlZ.Ur.getCurrY();
      bFo();
      if (this.nmx != 0)
      {
        if (this.nmx >= -this.mItemHeight / 2) {
          break label185;
        }
        this.nmy = (this.nmy + this.mItemHeight + this.nmx);
      }
    }
    for (;;)
    {
      bFo();
      wL(0);
      int i = wM(this.nmy);
      if ((i != this.nlH) && (this.nlX)) {}
      try
      {
        if (this.nmj != null) {
          this.nmj.a(this, this.nlB + i);
        }
        this.nlH = i;
        AppMethodBeat.o(138101);
        return;
        label185:
        this.nmy += this.nmx;
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
    if (j < this.nlw + 1)
    {
      float f5 = this.nmx + this.mItemHeight * j;
      int i = this.nmw;
      int k = getOneRecycleSize();
      boolean bool;
      label71:
      float f3;
      float f2;
      if ((this.nlT) && (this.nlV))
      {
        bool = true;
        k = q(i + j, k, bool);
        if (j != this.nlw / 2) {
          break label297;
        }
        f3 = (this.mItemHeight + this.nmx) / this.mItemHeight;
        i = c(f3, this.nlh, this.nli);
        f1 = this.nlk;
        f1 += (this.nll - f1) * f3;
        f2 = this.nlP;
        f2 += (this.nlQ - f2) * f3;
        label165:
        this.nmb.setColor(i);
        this.nmb.setTextSize(f1);
        if ((k < 0) || (k >= getOneRecycleSize())) {
          break label406;
        }
        String str = this.nmd[(this.nlz + k)];
        Object localObject = str;
        if (this.nlL != null) {
          localObject = TextUtils.ellipsize(str, this.nmb, getWidth() - this.nls * 2, getEllipsizeType());
        }
        paramCanvas.drawText(((CharSequence)localObject).toString(), this.nmv, f2 + (f5 + this.mItemHeight / 2), this.nmb);
      }
      for (;;)
      {
        j += 1;
        f1 = f3;
        break;
        bool = false;
        break label71;
        label297:
        if (j == this.nlw / 2 + 1)
        {
          i = c(1.0F - f1, this.nlh, this.nli);
          f2 = this.nlk;
          f2 = (1.0F - f1) * (this.nll - f2) + f2;
          f3 = this.nlP;
          f4 = (1.0F - f1) * (this.nlQ - f3) + f3;
          f3 = f1;
          f1 = f2;
          f2 = f4;
          break label165;
        }
        i = this.nlh;
        float f4 = this.nlk;
        f2 = this.nlP;
        f3 = f1;
        f1 = f4;
        break label165;
        label406:
        if (!TextUtils.isEmpty(this.nlM)) {
          paramCanvas.drawText(this.nlM, this.nmv, f2 + (f5 + this.mItemHeight / 2), this.nmb);
        }
      }
    }
    if (this.nlS)
    {
      paramCanvas.drawLine(getPaddingLeft() + this.nlu, this.nmt, this.aYS - getPaddingRight() - this.nlv, this.nmt, this.nma);
      paramCanvas.drawLine(getPaddingLeft() + this.nlu, this.nmu, this.aYS - getPaddingRight() - this.nlv, this.nmu, this.nma);
    }
    if (!TextUtils.isEmpty(this.nlK)) {
      paramCanvas.drawText(this.nlK, this.nmv + (this.nlD + this.nln) / 2 + this.nlp, (this.nmt + this.nmu) / 2.0F + this.nlR, this.nmc);
    }
    AppMethodBeat.o(138132);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(138097);
    super.onMeasure(paramInt1, paramInt2);
    io(false);
    int k = View.MeasureSpec.getMode(paramInt1);
    this.nmz = k;
    int j = View.MeasureSpec.getSize(paramInt1);
    if (k == 1073741824)
    {
      paramInt1 = j;
      j = View.MeasureSpec.getMode(paramInt2);
      this.nmA = j;
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
      if (Math.max(this.nln, this.nlo) == 0)
      {
        paramInt1 = 0;
        label102:
        if (Math.max(this.nln, this.nlo) != 0) {
          break label206;
        }
      }
      for (;;)
      {
        int m = this.nlF;
        int n = Math.max(this.nlD, this.nlG);
        i = Math.max(m, (paramInt1 + (i + Math.max(this.nln, this.nlo)) + this.nls * 2) * 2 + n) + (getPaddingLeft() + getPaddingRight());
        paramInt1 = i;
        if (k != -2147483648) {
          break;
        }
        paramInt1 = Math.min(i, j);
        break;
        paramInt1 = this.nlq;
        break label102;
        label206:
        i = this.nlp;
      }
      label214:
      i = this.nlw * (this.nlE + this.nlr * 2) + (getPaddingTop() + getPaddingBottom());
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
    this.aYS = paramInt1;
    this.aYT = paramInt2;
    this.mItemHeight = (this.aYT / this.nlw);
    this.nmv = ((this.aYS + getPaddingLeft() - getPaddingRight()) / 2.0F);
    if (getOneRecycleSize() > 1) {
      if (this.mHasInit) {
        paramInt1 = getValue() - this.nlB;
      }
    }
    for (;;)
    {
      if ((this.nlT) && (this.nlV)) {}
      IllegalArgumentException localIllegalArgumentException;
      for (boolean bool = true;; bool = false)
      {
        N(paramInt1, bool);
        if (this.nlk > this.mItemHeight) {
          this.nlk = this.mItemHeight;
        }
        if (this.nll > this.mItemHeight) {
          this.nll = this.mItemHeight;
        }
        if (this.nmc != null) {
          break label209;
        }
        localIllegalArgumentException = new IllegalArgumentException("mPaintHint should not be null.");
        AppMethodBeat.o(138098);
        throw localIllegalArgumentException;
        if (this.nlU)
        {
          paramInt1 = this.nmw + (this.nlw - 1) / 2;
          break;
        }
        paramInt1 = 0;
        break;
      }
      label209:
      this.nmc.setTextSize(this.nlm);
      this.nlR = a(this.nmc.getFontMetrics());
      this.nln = a(this.nlK, this.nmc);
      if (this.nmb == null)
      {
        localIllegalArgumentException = new IllegalArgumentException("mPaintText should not be null.");
        AppMethodBeat.o(138098);
        throw localIllegalArgumentException;
      }
      this.nmb.setTextSize(this.nll);
      this.nlQ = a(this.nmb.getFontMetrics());
      this.nmb.setTextSize(this.nlk);
      this.nlP = a(this.nmb.getFontMetrics());
      bFn();
      this.nlx = (this.nlw / 2);
      this.nly = (this.nlx + 1);
      this.nmt = (this.nlx * this.aYT / this.nlw);
      this.nmu = (this.nly * this.aYT / this.nlw);
      if (this.nlu < 0) {
        this.nlu = 0;
      }
      if (this.nlv < 0) {
        this.nlv = 0;
      }
      if ((this.nlu + this.nlv != 0) && (getPaddingLeft() + this.nlu >= this.aYS - getPaddingRight() - this.nlv))
      {
        paramInt1 = getPaddingLeft() + this.nlu + getPaddingRight() + this.nlv - this.aYS;
        this.nlu = ((int)(this.nlu - paramInt1 * this.nlu / (this.nlu + this.nlv)));
        this.nlv = ((int)(this.nlv - paramInt1 * this.nlv / (this.nlu + this.nlv)));
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
    if (this.mItemHeight == 0)
    {
      AppMethodBeat.o(138126);
      return true;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    this.nmr = paramMotionEvent.getY();
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
            this.nms = true;
            this.nmg.removeMessages(1);
            bFu();
            this.cNh = this.nmr;
            this.nmq = this.nmy;
            wL(0);
            getParent().requestDisallowInterceptTouchEvent(true);
            continue;
            f = this.cNh - this.nmr;
            if ((!this.nms) || (-this.nlJ >= f) || (f >= this.nlJ))
            {
              this.nms = false;
              this.nmy = wN((int)(f + this.nmq));
              bFo();
              invalidate();
            }
            wL(1);
          }
          if (!this.nms) {
            break;
          }
          f = paramMotionEvent.getY();
          i = 0;
        } while (i >= this.nlw);
        if ((this.mItemHeight * i > f) || (f >= this.mItemHeight * (i + 1))) {
          break;
        }
      } while ((i < 0) || (i >= this.nlw));
      i -= this.nlw / 2;
      if (this.nlT)
      {
        j = i;
        if (this.nlV) {}
      }
      else
      {
        k = getPickedIndexRelativeToRaw();
        if (k + i <= this.nlA) {
          break;
        }
        j = this.nlA - k;
      }
      if (this.nmx < -this.mItemHeight / 2)
      {
        k = this.mItemHeight + this.nmx;
        i = (int)((this.mItemHeight + this.nmx) * 300.0F / this.mItemHeight);
        if (j < 0)
        {
          i = -i - j * 300;
          label392:
          n = this.mItemHeight;
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
      this.nlZ.startScroll(0, this.nmy, 0, k + j * n, m);
      this.nmg.sendMessageDelayed(c(1, 0, 0, null), m / 4);
      postInvalidate();
      break;
      j = i;
      if (k + i >= this.nlz) {
        break label330;
      }
      j = this.nlz - k;
      break label330;
      i += j * 300;
      break label392;
      k = this.nmx;
      i = (int)(-this.nmx * 300.0F / this.mItemHeight);
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
      j = (int)(paramMotionEvent.getYVelocity() * this.nlO);
      if (Math.abs(j) > this.nlI)
      {
        paramMotionEvent = this.nlZ;
        i = this.nmy;
        j = -j;
        k = wN(-2147483648);
        m = wN(2147483647);
        paramMotionEvent.Ur.fling(0, i, 0, j, -2147483648, 2147483647, k, m);
        invalidate();
        wL(2);
      }
      this.nmg.sendMessageDelayed(c(1, 0, 0, null), 0L);
      if (this.mVelocityTracker == null) {
        break;
      }
      this.mVelocityTracker.clear();
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      break;
      this.nmq = this.nmy;
      bFu();
      this.nmg.sendMessageDelayed(c(1, 0, 0, null), 0L);
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
    this.nmb.setTypeface(paramTypeface);
    AppMethodBeat.o(138121);
  }
  
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    boolean bool = true;
    AppMethodBeat.i(138102);
    if (this.nmg != null) {
      this.nmg.removeMessages(1);
    }
    bFu();
    if (paramArrayOfString == null)
    {
      paramArrayOfString = new IllegalArgumentException("newDisplayedValues should not be null.");
      AppMethodBeat.o(138102);
      throw paramArrayOfString;
    }
    if (this.nlC - this.nlB + 1 > paramArrayOfString.length)
    {
      paramArrayOfString = new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + (this.nlC - this.nlB + 1) + " newDisplayedValues.length is " + paramArrayOfString.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
      AppMethodBeat.o(138102);
      throw paramArrayOfString;
    }
    this.nmd = paramArrayOfString;
    bFt();
    io(true);
    this.nlH = (this.nlz + 0);
    if ((this.nlT) && (this.nlV)) {}
    for (;;)
    {
      N(0, bool);
      postInvalidate();
      this.nmh.sendEmptyMessage(3);
      AppMethodBeat.o(138102);
      return;
      bool = false;
    }
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(138114);
    if (this.nlt == paramInt)
    {
      AppMethodBeat.o(138114);
      return;
    }
    this.nlt = paramInt;
    this.nma.setColor(this.nlt);
    postInvalidate();
    AppMethodBeat.o(138114);
  }
  
  public void setDividerHeight(int paramInt)
  {
    AppMethodBeat.i(138115);
    if (paramInt == this.aqc)
    {
      AppMethodBeat.o(138115);
      return;
    }
    this.aqc = paramInt;
    this.nma.setStrokeWidth(this.aqc);
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
        this.nlL = paramString;
        AppMethodBeat.o(138133);
        return;
      }
      i += 1;
    }
    this.nlL = "end";
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
    this.nlO = (ViewConfiguration.getScrollFriction() / paramFloat);
    AppMethodBeat.o(138120);
  }
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(138109);
    String str = this.nlK;
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
    this.nlK = paramString;
    this.nlR = a(this.nmc.getFontMetrics());
    this.nln = a(this.nlK, this.nmc);
    this.nmh.sendEmptyMessage(3);
    AppMethodBeat.o(138109);
  }
  
  public void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(138113);
    if (this.nlj == paramInt)
    {
      AppMethodBeat.o(138113);
      return;
    }
    this.nlj = paramInt;
    this.nmc.setColor(this.nlj);
    postInvalidate();
    AppMethodBeat.o(138113);
  }
  
  public void setHintTextTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(138122);
    this.nmc.setTypeface(paramTypeface);
    AppMethodBeat.o(138122);
  }
  
  public void setItemPaddingVertical(int paramInt)
  {
    AppMethodBeat.i(138116);
    if (this.nlr == paramInt)
    {
      AppMethodBeat.o(138116);
      return;
    }
    this.nlr = paramInt;
    postInvalidate();
    AppMethodBeat.o(138116);
  }
  
  public void setMaxValue(int paramInt)
  {
    AppMethodBeat.i(138105);
    Object localObject;
    if (this.nmd == null)
    {
      localObject = new NullPointerException("mDisplayedValues should not be null");
      AppMethodBeat.o(138105);
      throw ((Throwable)localObject);
    }
    if (paramInt - this.nlB + 1 > this.nmd.length)
    {
      localObject = new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + (paramInt - this.nlB + 1) + " and mDisplayedValues.length is " + this.nmd.length);
      AppMethodBeat.o(138105);
      throw ((Throwable)localObject);
    }
    this.nlC = paramInt;
    this.nlA = (this.nlC - this.nlB + this.nlz);
    p(this.nlz, this.nlA, true);
    bFn();
    AppMethodBeat.o(138105);
  }
  
  public void setMinValue(int paramInt)
  {
    AppMethodBeat.i(138104);
    this.nlB = paramInt;
    this.nlz = 0;
    bFn();
    AppMethodBeat.o(138104);
  }
  
  public void setNormalTextColor(int paramInt)
  {
    AppMethodBeat.i(138111);
    if (this.nlh == paramInt)
    {
      AppMethodBeat.o(138111);
      return;
    }
    this.nlh = paramInt;
    postInvalidate();
    AppMethodBeat.o(138111);
  }
  
  public void setOnScrollListener(a parama)
  {
    this.nmk = parama;
  }
  
  public void setOnValueChangeListenerInScrolling(c paramc)
  {
    this.nml = paramc;
  }
  
  public void setOnValueChangedListener(b paramb)
  {
    this.nmj = paramb;
  }
  
  public void setOnValueChangedListenerRelativeToRaw(d paramd)
  {
    this.nmi = paramd;
  }
  
  public void setPickedIndexRelativeToMin(int paramInt)
  {
    AppMethodBeat.i(138110);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      this.nlH = (this.nlz + paramInt);
      if ((!this.nlT) || (!this.nlV)) {
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
    if ((this.nlz >= 0) && (this.nlz <= paramInt) && (paramInt <= this.nlA))
    {
      this.nlH = paramInt;
      i = this.nlz;
      if ((!this.nlT) || (!this.nlV)) {
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
    if (this.nli == paramInt)
    {
      AppMethodBeat.o(138112);
      return;
    }
    this.nli = paramInt;
    postInvalidate();
    AppMethodBeat.o(138112);
  }
  
  public void setValue(int paramInt)
  {
    AppMethodBeat.i(138106);
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt < this.nlB)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value less than mMinValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(138106);
      throw localIllegalArgumentException;
    }
    if (paramInt > this.nlC)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value greater than mMaxValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(138106);
      throw localIllegalArgumentException;
    }
    setPickedIndexRelativeToRaw(paramInt - this.nlB);
    AppMethodBeat.o(138106);
  }
  
  public void setWrapSelectorWheel(boolean paramBoolean)
  {
    AppMethodBeat.i(138103);
    if (this.nlT != paramBoolean)
    {
      if (!paramBoolean)
      {
        if (this.mScrollState == 0)
        {
          bFm();
          AppMethodBeat.o(138103);
          return;
        }
        this.nlW = true;
        AppMethodBeat.o(138103);
        return;
      }
      this.nlT = paramBoolean;
      bFt();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker
 * JD-Core Version:    0.7.0.1
 */