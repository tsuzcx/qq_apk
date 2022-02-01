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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public class YANumberPicker
  extends View
{
  private int aYS;
  private int aYT;
  private int aqc;
  private float cNR;
  private boolean mHasInit;
  private int mScrollState;
  private VelocityTracker mVelocityTracker;
  private int ncn;
  private int nqA;
  private int nqB;
  private int nqC;
  private int nqD;
  private int nqE;
  private int nqF;
  private int nqG;
  private int nqH;
  private int nqI;
  private int nqJ;
  private int nqK;
  private int nqL;
  private int nqM;
  private int nqN;
  private int nqO;
  private int nqP;
  private int nqQ;
  private int nqR;
  private int nqS;
  private int nqT;
  private String nqU;
  private String nqV;
  private String nqW;
  private String nqX;
  private float nqY;
  private float nqZ;
  private int nqr;
  private int nqs;
  private int nqt;
  private int nqu;
  private int nqv;
  private int nqw;
  private int nqx;
  private int nqy;
  private int nqz;
  private float nrA;
  private float nrB;
  private boolean nrC;
  private float nrD;
  private float nrE;
  private float nrF;
  private int nrG;
  private int nrH;
  private int nrI;
  private int nrJ;
  private int nrK;
  private float nra;
  private float nrb;
  private boolean nrc;
  private boolean nrd;
  private boolean nre;
  private boolean nrf;
  private boolean nrg;
  private boolean nrh;
  private boolean nri;
  private p nrj;
  private Paint nrk;
  private TextPaint nrl;
  private Paint nrm;
  private String[] nrn;
  private CharSequence[] nro;
  private CharSequence[] nrp;
  private aq nrq;
  private Handler nrr;
  private d nrs;
  private b nrt;
  private a nru;
  private c nrv;
  private int nrw;
  private int nrx;
  private int nry;
  private int nrz;
  
  public YANumberPicker(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138091);
    this.nqr = -13421773;
    this.nqs = -695533;
    this.nqt = -695533;
    this.nqu = 0;
    this.nqv = 0;
    this.nqw = 0;
    this.nqx = 0;
    this.nqy = 0;
    this.nqz = 0;
    this.nqA = 0;
    this.nqB = 0;
    this.nqC = 0;
    this.nqD = -695533;
    this.aqc = 2;
    this.nqE = 0;
    this.nqF = 0;
    this.nqG = 3;
    this.nqH = 0;
    this.nqI = 0;
    this.nqJ = -1;
    this.nqK = -1;
    this.nqL = 0;
    this.nqM = 0;
    this.nqN = 0;
    this.nqO = 0;
    this.nqP = 0;
    this.nqQ = 0;
    this.nqR = 0;
    this.nqS = 150;
    this.nqT = 8;
    this.nqY = 1.0F;
    this.nqZ = 0.0F;
    this.nra = 0.0F;
    this.nrb = 0.0F;
    this.nrc = true;
    this.nrd = true;
    this.nre = false;
    this.mHasInit = false;
    this.nrf = true;
    this.nrg = false;
    this.nrh = false;
    this.nri = true;
    this.nrk = new Paint();
    this.nrl = new TextPaint();
    this.nrm = new Paint();
    this.mScrollState = 0;
    this.nrA = 0.0F;
    this.cNR = 0.0F;
    this.nrB = 0.0F;
    this.nrC = false;
    this.nrG = 0;
    this.nrH = 0;
    this.nrI = 0;
    this.nrJ = 0;
    this.nrK = 0;
    init(paramContext);
    AppMethodBeat.o(138091);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138092);
    this.nqr = -13421773;
    this.nqs = -695533;
    this.nqt = -695533;
    this.nqu = 0;
    this.nqv = 0;
    this.nqw = 0;
    this.nqx = 0;
    this.nqy = 0;
    this.nqz = 0;
    this.nqA = 0;
    this.nqB = 0;
    this.nqC = 0;
    this.nqD = -695533;
    this.aqc = 2;
    this.nqE = 0;
    this.nqF = 0;
    this.nqG = 3;
    this.nqH = 0;
    this.nqI = 0;
    this.nqJ = -1;
    this.nqK = -1;
    this.nqL = 0;
    this.nqM = 0;
    this.nqN = 0;
    this.nqO = 0;
    this.nqP = 0;
    this.nqQ = 0;
    this.nqR = 0;
    this.nqS = 150;
    this.nqT = 8;
    this.nqY = 1.0F;
    this.nqZ = 0.0F;
    this.nra = 0.0F;
    this.nrb = 0.0F;
    this.nrc = true;
    this.nrd = true;
    this.nre = false;
    this.mHasInit = false;
    this.nrf = true;
    this.nrg = false;
    this.nrh = false;
    this.nri = true;
    this.nrk = new Paint();
    this.nrl = new TextPaint();
    this.nrm = new Paint();
    this.mScrollState = 0;
    this.nrA = 0.0F;
    this.cNR = 0.0F;
    this.nrB = 0.0F;
    this.nrC = false;
    this.nrG = 0;
    this.nrH = 0;
    this.nrI = 0;
    this.nrJ = 0;
    this.nrK = 0;
    b(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(138092);
  }
  
  public YANumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(138093);
    this.nqr = -13421773;
    this.nqs = -695533;
    this.nqt = -695533;
    this.nqu = 0;
    this.nqv = 0;
    this.nqw = 0;
    this.nqx = 0;
    this.nqy = 0;
    this.nqz = 0;
    this.nqA = 0;
    this.nqB = 0;
    this.nqC = 0;
    this.nqD = -695533;
    this.aqc = 2;
    this.nqE = 0;
    this.nqF = 0;
    this.nqG = 3;
    this.nqH = 0;
    this.nqI = 0;
    this.nqJ = -1;
    this.nqK = -1;
    this.nqL = 0;
    this.nqM = 0;
    this.nqN = 0;
    this.nqO = 0;
    this.nqP = 0;
    this.nqQ = 0;
    this.nqR = 0;
    this.nqS = 150;
    this.nqT = 8;
    this.nqY = 1.0F;
    this.nqZ = 0.0F;
    this.nra = 0.0F;
    this.nrb = 0.0F;
    this.nrc = true;
    this.nrd = true;
    this.nre = false;
    this.mHasInit = false;
    this.nrf = true;
    this.nrg = false;
    this.nrh = false;
    this.nri = true;
    this.nrk = new Paint();
    this.nrl = new TextPaint();
    this.nrm = new Paint();
    this.mScrollState = 0;
    this.nrA = 0.0F;
    this.cNR = 0.0F;
    this.nrB = 0.0F;
    this.nrC = false;
    this.nrG = 0;
    this.nrH = 0;
    this.nrI = 0;
    this.nrJ = 0;
    this.nrK = 0;
    b(paramContext, paramAttributeSet);
    init(paramContext);
    AppMethodBeat.o(138093);
  }
  
  private void O(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(138128);
    this.nrG = (paramInt - (this.nqG - 1) / 2);
    this.nrG = q(this.nrG, getOneRecycleSize(), paramBoolean);
    if (this.ncn == 0)
    {
      this.nre = true;
      AppMethodBeat.o(138128);
      return;
    }
    this.nrI = (this.nrG * this.ncn);
    this.nrw = (this.nrG + this.nqG / 2);
    this.nrw %= getOneRecycleSize();
    if (this.nrw < 0) {
      this.nrw += getOneRecycleSize();
    }
    this.nrx = this.nrw;
    bGj();
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
        this.nqG = localTypedArray.getInt(j, 3);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 3)
        {
          this.nqD = localTypedArray.getColor(j, -695533);
        }
        else if (j == 4)
        {
          this.aqc = localTypedArray.getDimensionPixelSize(j, 2);
        }
        else if (j == 5)
        {
          this.nqE = localTypedArray.getDimensionPixelSize(j, 0);
        }
        else if (j == 6)
        {
          this.nqF = localTypedArray.getDimensionPixelSize(j, 0);
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
              this.nrn = paramAttributeSet;
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
            this.nqr = localTypedArray.getColor(j, -13421773);
          } else if (j == 22) {
            this.nqs = localTypedArray.getColor(j, -695533);
          } else if (j == 20) {
            this.nqt = localTypedArray.getColor(j, -695533);
          } else if (j == 25) {
            this.nqu = localTypedArray.getDimensionPixelSize(j, d(paramContext, 13.0F));
          } else if (j == 26) {
            this.nqv = localTypedArray.getDimensionPixelSize(j, d(paramContext, 15.0F));
          } else if (j == 24) {
            this.nqw = localTypedArray.getDimensionPixelSize(j, d(paramContext, 14.0F));
          } else if (j == 14) {
            this.nqJ = localTypedArray.getInteger(j, 0);
          } else if (j == 13) {
            this.nqK = localTypedArray.getInteger(j, 0);
          } else if (j == 27) {
            this.nrd = localTypedArray.getBoolean(j, true);
          } else if (j == 18) {
            this.nrc = localTypedArray.getBoolean(j, true);
          } else if (j == 8) {
            this.nqU = localTypedArray.getString(j);
          } else if (j == 0) {
            this.nqX = localTypedArray.getString(j);
          } else if (j == 7) {
            this.nqW = localTypedArray.getString(j);
          } else if (j == 12) {
            this.nqz = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == 11) {
            this.nqA = localTypedArray.getDimensionPixelSize(j, e(paramContext, 8.0F));
          } else if (j == 10) {
            this.nqB = localTypedArray.getDimensionPixelSize(j, e(paramContext, 2.0F));
          } else if (j == 9) {
            this.nqC = localTypedArray.getDimensionPixelSize(j, e(paramContext, 5.0F));
          } else if (j == 1) {
            this.nro = localTypedArray.getTextArray(j);
          } else if (j == 2) {
            this.nrp = localTypedArray.getTextArray(j);
          } else if (j == 16) {
            this.nrh = localTypedArray.getBoolean(j, false);
          } else if (j == 15) {
            this.nri = localTypedArray.getBoolean(j, true);
          } else if (j == 23) {
            this.nqV = localTypedArray.getString(j);
          }
        }
      }
    }
    localTypedArray.recycle();
    AppMethodBeat.o(138094);
  }
  
  private void bGh()
  {
    AppMethodBeat.i(138124);
    O(getPickedIndexRelativeToRaw() - this.nqJ, false);
    this.nrd = false;
    postInvalidate();
    AppMethodBeat.o(138124);
  }
  
  private void bGi()
  {
    AppMethodBeat.i(138125);
    this.nry = 0;
    this.nrz = (-this.nqG * this.ncn);
    if (this.nrn != null)
    {
      this.nry = ((getOneRecycleSize() - this.nqG / 2 - 1) * this.ncn);
      this.nrz = (-(this.nqG / 2) * this.ncn);
    }
    AppMethodBeat.o(138125);
  }
  
  private void bGj()
  {
    AppMethodBeat.i(138130);
    this.nrG = ((int)Math.floor(this.nrI / this.ncn));
    this.nrH = (-(this.nrI - this.nrG * this.ncn));
    if (this.nrv != null) {
      if (-this.nrH <= this.ncn / 2) {
        break label131;
      }
    }
    label131:
    for (this.nrx = (this.nrG + 1 + this.nqG / 2);; this.nrx = (this.nrG + this.nqG / 2))
    {
      this.nrx %= getOneRecycleSize();
      if (this.nrx < 0) {
        this.nrx += getOneRecycleSize();
      }
      this.nrw = this.nrx;
      AppMethodBeat.o(138130);
      return;
    }
  }
  
  private void bGk()
  {
    AppMethodBeat.i(138135);
    float f = this.nrl.getTextSize();
    this.nrl.setTextSize(this.nqv);
    this.nqN = a(this.nrn, this.nrl);
    this.nqP = a(this.nro, this.nrl);
    this.nqQ = a(this.nrp, this.nrl);
    this.nrl.setTextSize(this.nqw);
    this.nqy = a(this.nqX, this.nrl);
    this.nrl.setTextSize(f);
    AppMethodBeat.o(138135);
  }
  
  private void bGl()
  {
    AppMethodBeat.i(138138);
    float f = this.nrl.getTextSize();
    this.nrl.setTextSize(this.nqv);
    this.nqO = ((int)(this.nrl.getFontMetrics().bottom - this.nrl.getFontMetrics().top + 0.5D));
    this.nrl.setTextSize(f);
    AppMethodBeat.o(138138);
  }
  
  private void bGm()
  {
    AppMethodBeat.i(138139);
    bGn();
    bGo();
    if (this.nqJ == -1) {
      this.nqJ = 0;
    }
    if (this.nqK == -1) {
      this.nqK = (this.nrn.length - 1);
    }
    p(this.nqJ, this.nqK, false);
    AppMethodBeat.o(138139);
  }
  
  private void bGn()
  {
    if (this.nrn == null)
    {
      this.nrn = new String[1];
      this.nrn[0] = "0";
    }
  }
  
  private void bGo()
  {
    if (this.nrn.length <= this.nqG) {}
    for (boolean bool = false;; bool = true)
    {
      this.nrf = bool;
      return;
    }
  }
  
  private void bGp()
  {
    AppMethodBeat.i(138140);
    if ((this.nrj != null) && (!this.nrj.Ur.isFinished()))
    {
      this.nrj.startScroll(0, this.nrj.Ur.getCurrY(), 0, 0, 1);
      this.nrj.Ur.abortAnimation();
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
    Object localObject = this.nqV;
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
  
  private void im(boolean paramBoolean)
  {
    AppMethodBeat.i(138131);
    bGk();
    bGl();
    if ((paramBoolean) && ((this.nrJ == -2147483648) || (this.nrK == -2147483648))) {
      this.nrr.sendEmptyMessage(3);
    }
    AppMethodBeat.o(138131);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(138095);
    this.nrj = p.a(paramContext, null);
    this.nqS = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    this.nqT = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    if (this.nqu == 0) {
      this.nqu = d(paramContext, 13.0F);
    }
    if (this.nqv == 0) {
      this.nqv = d(paramContext, 15.0F);
    }
    if (this.nqw == 0) {
      this.nqw = d(paramContext, 14.0F);
    }
    if (this.nqz == 0) {
      this.nqz = e(paramContext, 8.0F);
    }
    if (this.nqA == 0) {
      this.nqA = e(paramContext, 8.0F);
    }
    this.nrk.setColor(this.nqD);
    this.nrk.setAntiAlias(true);
    this.nrk.setStyle(Paint.Style.STROKE);
    this.nrk.setStrokeWidth(this.aqc);
    this.nrl.setColor(this.nqr);
    this.nrl.setAntiAlias(true);
    this.nrl.setTextAlign(Paint.Align.CENTER);
    this.nrm.setColor(this.nqt);
    this.nrm.setAntiAlias(true);
    this.nrm.setTextAlign(Paint.Align.CENTER);
    this.nrm.setTextSize(this.nqw);
    if (this.nqG % 2 == 0) {
      this.nqG += 1;
    }
    if ((this.nqJ == -1) || (this.nqK == -1)) {
      bGm();
    }
    initHandler();
    AppMethodBeat.o(138095);
  }
  
  private void initHandler()
  {
    AppMethodBeat.i(138096);
    this.nrq = new aq("HandlerThread-For-Refreshing")
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
    this.nrr = new Handler()
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
    if (this.nrn == null)
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
    if (paramInt1 > this.nrn.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("minShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.nrn.length - 1) + " minShowIndex is " + paramInt1);
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt2 < 0)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be less than 0, now maxShowIndex is ".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    if (paramInt2 > this.nrn.length - 1)
    {
      localIllegalArgumentException = new IllegalArgumentException("maxShowIndex should not be greater than (mDisplayedValues.length - 1), now (mDisplayedValues.length - 1) is " + (this.nrn.length - 1) + " maxShowIndex is " + paramInt2);
      AppMethodBeat.o(138119);
      throw localIllegalArgumentException;
    }
    this.nqJ = paramInt1;
    this.nqK = paramInt2;
    if (paramBoolean)
    {
      this.nqR = (this.nqJ + 0);
      if ((!this.nrd) || (!this.nrf)) {
        break label335;
      }
    }
    label335:
    for (paramBoolean = true;; paramBoolean = false)
    {
      O(0, paramBoolean);
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
  
  private void wQ(int paramInt)
  {
    if (this.mScrollState == paramInt) {
      return;
    }
    this.mScrollState = paramInt;
  }
  
  private int wR(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(138123);
    if (this.ncn == 0)
    {
      AppMethodBeat.o(138123);
      return 0;
    }
    paramInt /= this.ncn;
    int i = this.nqG / 2;
    int j = getOneRecycleSize();
    boolean bool1 = bool2;
    if (this.nrd)
    {
      bool1 = bool2;
      if (this.nrf) {
        bool1 = true;
      }
    }
    paramInt = q(paramInt + i, j, bool1);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      i = this.nqJ;
      AppMethodBeat.o(138123);
      return paramInt + i;
    }
    IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("getWillPickIndexByGlobalY illegal index : " + paramInt + " getOneRecycleSize() : " + getOneRecycleSize() + " mWrapSelectorWheel : " + this.nrd);
    AppMethodBeat.o(138123);
    throw localIllegalArgumentException;
  }
  
  private int wS(int paramInt)
  {
    if ((this.nrd) && (this.nrf)) {}
    do
    {
      return paramInt;
      if (paramInt < this.nrz) {
        return this.nrz;
      }
    } while (paramInt <= this.nry);
    return this.nry;
  }
  
  public final void bGq()
  {
    AppMethodBeat.i(138141);
    bGp();
    if (this.nrq != null) {
      this.nrq.sendMessageDelayed(c(1, 0, 0, null), 0L);
    }
    AppMethodBeat.o(138141);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(138129);
    if (this.ncn == 0)
    {
      AppMethodBeat.o(138129);
      return;
    }
    if (this.nrj.Ur.computeScrollOffset())
    {
      this.nrI = this.nrj.Ur.getCurrY();
      bGj();
      postInvalidate();
    }
    AppMethodBeat.o(138129);
  }
  
  public String getContentByCurrValue()
  {
    AppMethodBeat.i(138108);
    String str = this.nrn[(getValue() - this.nqL)];
    AppMethodBeat.o(138108);
    return str;
  }
  
  public String[] getDisplayedValues()
  {
    return this.nrn;
  }
  
  public int getMaxValue()
  {
    return this.nqM;
  }
  
  public int getMinValue()
  {
    return this.nqL;
  }
  
  public int getOneRecycleSize()
  {
    return this.nqK - this.nqJ + 1;
  }
  
  public int getPickedIndexRelativeToRaw()
  {
    AppMethodBeat.i(138118);
    int i;
    if (this.nrH != 0) {
      if (this.nrH < -this.ncn / 2) {
        i = wR(this.nrI + this.ncn + this.nrH);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(138118);
      return i;
      i = wR(this.nrI + this.nrH);
      continue;
      i = wR(this.nrI);
    }
  }
  
  public int getRawContentSize()
  {
    if (this.nrn != null) {
      return this.nrn.length;
    }
    return 0;
  }
  
  public int getValue()
  {
    AppMethodBeat.i(138107);
    int i = getPickedIndexRelativeToRaw();
    int j = this.nqL;
    AppMethodBeat.o(138107);
    return i + j;
  }
  
  public boolean getWrapSelectorWheel()
  {
    return this.nrd;
  }
  
  public boolean getWrapSelectorWheelAbsolutely()
  {
    return (this.nrd) && (this.nrf);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(138100);
    super.onAttachedToWindow();
    if (this.nrq == null) {
      initHandler();
    }
    AppMethodBeat.o(138100);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(138101);
    super.onDetachedFromWindow();
    this.nrq.quit();
    this.nrr = null;
    if (this.ncn == 0)
    {
      AppMethodBeat.o(138101);
      return;
    }
    if (!this.nrj.Ur.isFinished())
    {
      this.nrj.Ur.abortAnimation();
      this.nrI = this.nrj.Ur.getCurrY();
      bGj();
      if (this.nrH != 0)
      {
        if (this.nrH >= -this.ncn / 2) {
          break label185;
        }
        this.nrI = (this.nrI + this.ncn + this.nrH);
      }
    }
    for (;;)
    {
      bGj();
      wQ(0);
      int i = wR(this.nrI);
      if ((i != this.nqR) && (this.nrh)) {}
      try
      {
        if (this.nrt != null) {
          this.nrt.a(this, this.nqL + i);
        }
        this.nqR = i;
        AppMethodBeat.o(138101);
        return;
        label185:
        this.nrI += this.nrH;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.YANumberPicker", localException, "", new Object[0]);
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
    if (j < this.nqG + 1)
    {
      float f5 = this.nrH + this.ncn * j;
      int i = this.nrG;
      int k = getOneRecycleSize();
      boolean bool;
      label71:
      float f3;
      float f2;
      if ((this.nrd) && (this.nrf))
      {
        bool = true;
        k = q(i + j, k, bool);
        if (j != this.nqG / 2) {
          break label297;
        }
        f3 = (this.ncn + this.nrH) / this.ncn;
        i = c(f3, this.nqr, this.nqs);
        f1 = this.nqu;
        f1 += (this.nqv - f1) * f3;
        f2 = this.nqZ;
        f2 += (this.nra - f2) * f3;
        label165:
        this.nrl.setColor(i);
        this.nrl.setTextSize(f1);
        if ((k < 0) || (k >= getOneRecycleSize())) {
          break label406;
        }
        String str = this.nrn[(this.nqJ + k)];
        Object localObject = str;
        if (this.nqV != null) {
          localObject = TextUtils.ellipsize(str, this.nrl, getWidth() - this.nqC * 2, getEllipsizeType());
        }
        paramCanvas.drawText(((CharSequence)localObject).toString(), this.nrF, f2 + (f5 + this.ncn / 2), this.nrl);
      }
      for (;;)
      {
        j += 1;
        f1 = f3;
        break;
        bool = false;
        break label71;
        label297:
        if (j == this.nqG / 2 + 1)
        {
          i = c(1.0F - f1, this.nqr, this.nqs);
          f2 = this.nqu;
          f2 = (1.0F - f1) * (this.nqv - f2) + f2;
          f3 = this.nqZ;
          f4 = (1.0F - f1) * (this.nra - f3) + f3;
          f3 = f1;
          f1 = f2;
          f2 = f4;
          break label165;
        }
        i = this.nqr;
        float f4 = this.nqu;
        f2 = this.nqZ;
        f3 = f1;
        f1 = f4;
        break label165;
        label406:
        if (!TextUtils.isEmpty(this.nqW)) {
          paramCanvas.drawText(this.nqW, this.nrF, f2 + (f5 + this.ncn / 2), this.nrl);
        }
      }
    }
    if (this.nrc)
    {
      paramCanvas.drawLine(getPaddingLeft() + this.nqE, this.nrD, this.aYS - getPaddingRight() - this.nqF, this.nrD, this.nrk);
      paramCanvas.drawLine(getPaddingLeft() + this.nqE, this.nrE, this.aYS - getPaddingRight() - this.nqF, this.nrE, this.nrk);
    }
    if (!TextUtils.isEmpty(this.nqU)) {
      paramCanvas.drawText(this.nqU, this.nrF + (this.nqN + this.nqx) / 2 + this.nqz, (this.nrD + this.nrE) / 2.0F + this.nrb, this.nrm);
    }
    AppMethodBeat.o(138132);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(138097);
    super.onMeasure(paramInt1, paramInt2);
    im(false);
    int k = View.MeasureSpec.getMode(paramInt1);
    this.nrJ = k;
    int j = View.MeasureSpec.getSize(paramInt1);
    if (k == 1073741824)
    {
      paramInt1 = j;
      j = View.MeasureSpec.getMode(paramInt2);
      this.nrK = j;
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
      if (Math.max(this.nqx, this.nqy) == 0)
      {
        paramInt1 = 0;
        label102:
        if (Math.max(this.nqx, this.nqy) != 0) {
          break label206;
        }
      }
      for (;;)
      {
        int m = this.nqP;
        int n = Math.max(this.nqN, this.nqQ);
        i = Math.max(m, (paramInt1 + (i + Math.max(this.nqx, this.nqy)) + this.nqC * 2) * 2 + n) + (getPaddingLeft() + getPaddingRight());
        paramInt1 = i;
        if (k != -2147483648) {
          break;
        }
        paramInt1 = Math.min(i, j);
        break;
        paramInt1 = this.nqA;
        break label102;
        label206:
        i = this.nqz;
      }
      label214:
      i = this.nqG * (this.nqO + this.nqB * 2) + (getPaddingTop() + getPaddingBottom());
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
    this.ncn = (this.aYT / this.nqG);
    this.nrF = ((this.aYS + getPaddingLeft() - getPaddingRight()) / 2.0F);
    if (getOneRecycleSize() > 1) {
      if (this.mHasInit) {
        paramInt1 = getValue() - this.nqL;
      }
    }
    for (;;)
    {
      if ((this.nrd) && (this.nrf)) {}
      IllegalArgumentException localIllegalArgumentException;
      for (boolean bool = true;; bool = false)
      {
        O(paramInt1, bool);
        if (this.nqu > this.ncn) {
          this.nqu = this.ncn;
        }
        if (this.nqv > this.ncn) {
          this.nqv = this.ncn;
        }
        if (this.nrm != null) {
          break label209;
        }
        localIllegalArgumentException = new IllegalArgumentException("mPaintHint should not be null.");
        AppMethodBeat.o(138098);
        throw localIllegalArgumentException;
        if (this.nre)
        {
          paramInt1 = this.nrG + (this.nqG - 1) / 2;
          break;
        }
        paramInt1 = 0;
        break;
      }
      label209:
      this.nrm.setTextSize(this.nqw);
      this.nrb = a(this.nrm.getFontMetrics());
      this.nqx = a(this.nqU, this.nrm);
      if (this.nrl == null)
      {
        localIllegalArgumentException = new IllegalArgumentException("mPaintText should not be null.");
        AppMethodBeat.o(138098);
        throw localIllegalArgumentException;
      }
      this.nrl.setTextSize(this.nqv);
      this.nra = a(this.nrl.getFontMetrics());
      this.nrl.setTextSize(this.nqu);
      this.nqZ = a(this.nrl.getFontMetrics());
      bGi();
      this.nqH = (this.nqG / 2);
      this.nqI = (this.nqH + 1);
      this.nrD = (this.nqH * this.aYT / this.nqG);
      this.nrE = (this.nqI * this.aYT / this.nqG);
      if (this.nqE < 0) {
        this.nqE = 0;
      }
      if (this.nqF < 0) {
        this.nqF = 0;
      }
      if ((this.nqE + this.nqF != 0) && (getPaddingLeft() + this.nqE >= this.aYS - getPaddingRight() - this.nqF))
      {
        paramInt1 = getPaddingLeft() + this.nqE + getPaddingRight() + this.nqF - this.aYS;
        this.nqE = ((int)(this.nqE - paramInt1 * this.nqE / (this.nqE + this.nqF)));
        this.nqF = ((int)(this.nqF - paramInt1 * this.nqF / (this.nqE + this.nqF)));
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
    if (this.ncn == 0)
    {
      AppMethodBeat.o(138126);
      return true;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    this.nrB = paramMotionEvent.getY();
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
            this.nrC = true;
            this.nrq.removeMessages(1);
            bGp();
            this.cNR = this.nrB;
            this.nrA = this.nrI;
            wQ(0);
            getParent().requestDisallowInterceptTouchEvent(true);
            continue;
            f = this.cNR - this.nrB;
            if ((!this.nrC) || (-this.nqT >= f) || (f >= this.nqT))
            {
              this.nrC = false;
              this.nrI = wS((int)(f + this.nrA));
              bGj();
              invalidate();
            }
            wQ(1);
          }
          if (!this.nrC) {
            break;
          }
          f = paramMotionEvent.getY();
          i = 0;
        } while (i >= this.nqG);
        if ((this.ncn * i > f) || (f >= this.ncn * (i + 1))) {
          break;
        }
      } while ((i < 0) || (i >= this.nqG));
      i -= this.nqG / 2;
      if (this.nrd)
      {
        j = i;
        if (this.nrf) {}
      }
      else
      {
        k = getPickedIndexRelativeToRaw();
        if (k + i <= this.nqK) {
          break;
        }
        j = this.nqK - k;
      }
      if (this.nrH < -this.ncn / 2)
      {
        k = this.ncn + this.nrH;
        i = (int)((this.ncn + this.nrH) * 300.0F / this.ncn);
        if (j < 0)
        {
          i = -i - j * 300;
          label392:
          n = this.ncn;
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
      this.nrj.startScroll(0, this.nrI, 0, k + j * n, m);
      this.nrq.sendMessageDelayed(c(1, 0, 0, null), m / 4);
      postInvalidate();
      break;
      j = i;
      if (k + i >= this.nqJ) {
        break label330;
      }
      j = this.nqJ - k;
      break label330;
      i += j * 300;
      break label392;
      k = this.nrH;
      i = (int)(-this.nrH * 300.0F / this.ncn);
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
      j = (int)(paramMotionEvent.getYVelocity() * this.nqY);
      if (Math.abs(j) > this.nqS)
      {
        paramMotionEvent = this.nrj;
        i = this.nrI;
        j = -j;
        k = wS(-2147483648);
        m = wS(2147483647);
        paramMotionEvent.Ur.fling(0, i, 0, j, -2147483648, 2147483647, k, m);
        invalidate();
        wQ(2);
      }
      this.nrq.sendMessageDelayed(c(1, 0, 0, null), 0L);
      if (this.mVelocityTracker == null) {
        break;
      }
      this.mVelocityTracker.clear();
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
      break;
      this.nrA = this.nrI;
      bGp();
      this.nrq.sendMessageDelayed(c(1, 0, 0, null), 0L);
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
    this.nrl.setTypeface(paramTypeface);
    AppMethodBeat.o(138121);
  }
  
  public void setDisplayedValues(String[] paramArrayOfString)
  {
    boolean bool = true;
    AppMethodBeat.i(138102);
    if (this.nrq != null) {
      this.nrq.removeMessages(1);
    }
    bGp();
    if (paramArrayOfString == null)
    {
      paramArrayOfString = new IllegalArgumentException("newDisplayedValues should not be null.");
      AppMethodBeat.o(138102);
      throw paramArrayOfString;
    }
    if (this.nqM - this.nqL + 1 > paramArrayOfString.length)
    {
      paramArrayOfString = new IllegalArgumentException("mMaxValue - mMinValue + 1 should not be greater than mDisplayedValues.length, now ((mMaxValue - mMinValue + 1) is " + (this.nqM - this.nqL + 1) + " newDisplayedValues.length is " + paramArrayOfString.length + ", you need to set MaxValue and MinValue before setDisplayedValues(String[])");
      AppMethodBeat.o(138102);
      throw paramArrayOfString;
    }
    this.nrn = paramArrayOfString;
    bGo();
    im(true);
    this.nqR = (this.nqJ + 0);
    if ((this.nrd) && (this.nrf)) {}
    for (;;)
    {
      O(0, bool);
      postInvalidate();
      this.nrr.sendEmptyMessage(3);
      AppMethodBeat.o(138102);
      return;
      bool = false;
    }
  }
  
  public void setDividerColor(int paramInt)
  {
    AppMethodBeat.i(138114);
    if (this.nqD == paramInt)
    {
      AppMethodBeat.o(138114);
      return;
    }
    this.nqD = paramInt;
    this.nrk.setColor(this.nqD);
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
    this.nrk.setStrokeWidth(this.aqc);
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
        this.nqV = paramString;
        AppMethodBeat.o(138133);
        return;
      }
      i += 1;
    }
    this.nqV = "end";
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
    this.nqY = (ViewConfiguration.getScrollFriction() / paramFloat);
    AppMethodBeat.o(138120);
  }
  
  public void setHintText(String paramString)
  {
    AppMethodBeat.i(138109);
    String str = this.nqU;
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
    this.nqU = paramString;
    this.nrb = a(this.nrm.getFontMetrics());
    this.nqx = a(this.nqU, this.nrm);
    this.nrr.sendEmptyMessage(3);
    AppMethodBeat.o(138109);
  }
  
  public void setHintTextColor(int paramInt)
  {
    AppMethodBeat.i(138113);
    if (this.nqt == paramInt)
    {
      AppMethodBeat.o(138113);
      return;
    }
    this.nqt = paramInt;
    this.nrm.setColor(this.nqt);
    postInvalidate();
    AppMethodBeat.o(138113);
  }
  
  public void setHintTextTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(138122);
    this.nrm.setTypeface(paramTypeface);
    AppMethodBeat.o(138122);
  }
  
  public void setItemPaddingVertical(int paramInt)
  {
    AppMethodBeat.i(138116);
    if (this.nqB == paramInt)
    {
      AppMethodBeat.o(138116);
      return;
    }
    this.nqB = paramInt;
    postInvalidate();
    AppMethodBeat.o(138116);
  }
  
  public void setMaxValue(int paramInt)
  {
    AppMethodBeat.i(138105);
    Object localObject;
    if (this.nrn == null)
    {
      localObject = new NullPointerException("mDisplayedValues should not be null");
      AppMethodBeat.o(138105);
      throw ((Throwable)localObject);
    }
    if (paramInt - this.nqL + 1 > this.nrn.length)
    {
      localObject = new IllegalArgumentException("(maxValue - mMinValue + 1) should not be greater than mDisplayedValues.length now  (maxValue - mMinValue + 1) is " + (paramInt - this.nqL + 1) + " and mDisplayedValues.length is " + this.nrn.length);
      AppMethodBeat.o(138105);
      throw ((Throwable)localObject);
    }
    this.nqM = paramInt;
    this.nqK = (this.nqM - this.nqL + this.nqJ);
    p(this.nqJ, this.nqK, true);
    bGi();
    AppMethodBeat.o(138105);
  }
  
  public void setMinValue(int paramInt)
  {
    AppMethodBeat.i(138104);
    this.nqL = paramInt;
    this.nqJ = 0;
    bGi();
    AppMethodBeat.o(138104);
  }
  
  public void setNormalTextColor(int paramInt)
  {
    AppMethodBeat.i(138111);
    if (this.nqr == paramInt)
    {
      AppMethodBeat.o(138111);
      return;
    }
    this.nqr = paramInt;
    postInvalidate();
    AppMethodBeat.o(138111);
  }
  
  public void setOnScrollListener(a parama)
  {
    this.nru = parama;
  }
  
  public void setOnValueChangeListenerInScrolling(c paramc)
  {
    this.nrv = paramc;
  }
  
  public void setOnValueChangedListener(b paramb)
  {
    this.nrt = paramb;
  }
  
  public void setOnValueChangedListenerRelativeToRaw(d paramd)
  {
    this.nrs = paramd;
  }
  
  public void setPickedIndexRelativeToMin(int paramInt)
  {
    AppMethodBeat.i(138110);
    if ((paramInt >= 0) && (paramInt < getOneRecycleSize()))
    {
      this.nqR = (this.nqJ + paramInt);
      if ((!this.nrd) || (!this.nrf)) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      O(paramInt, bool);
      postInvalidate();
      AppMethodBeat.o(138110);
      return;
    }
  }
  
  public void setPickedIndexRelativeToRaw(int paramInt)
  {
    AppMethodBeat.i(138117);
    int i;
    if ((this.nqJ >= 0) && (this.nqJ <= paramInt) && (paramInt <= this.nqK))
    {
      this.nqR = paramInt;
      i = this.nqJ;
      if ((!this.nrd) || (!this.nrf)) {
        break label74;
      }
    }
    label74:
    for (boolean bool = true;; bool = false)
    {
      O(paramInt - i, bool);
      postInvalidate();
      AppMethodBeat.o(138117);
      return;
    }
  }
  
  public void setSelectedTextColor(int paramInt)
  {
    AppMethodBeat.i(138112);
    if (this.nqs == paramInt)
    {
      AppMethodBeat.o(138112);
      return;
    }
    this.nqs = paramInt;
    postInvalidate();
    AppMethodBeat.o(138112);
  }
  
  public void setValue(int paramInt)
  {
    AppMethodBeat.i(138106);
    IllegalArgumentException localIllegalArgumentException;
    if (paramInt < this.nqL)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value less than mMinValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(138106);
      throw localIllegalArgumentException;
    }
    if (paramInt > this.nqM)
    {
      localIllegalArgumentException = new IllegalArgumentException("should not set a value greater than mMaxValue, value is ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(138106);
      throw localIllegalArgumentException;
    }
    setPickedIndexRelativeToRaw(paramInt - this.nqL);
    AppMethodBeat.o(138106);
  }
  
  public void setWrapSelectorWheel(boolean paramBoolean)
  {
    AppMethodBeat.i(138103);
    if (this.nrd != paramBoolean)
    {
      if (!paramBoolean)
      {
        if (this.mScrollState == 0)
        {
          bGh();
          AppMethodBeat.o(138103);
          return;
        }
        this.nrg = true;
        AppMethodBeat.o(138103);
        return;
      }
      this.nrd = paramBoolean;
      bGo();
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