package com.tencent.matrix.trace.view;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import com.tencent.matrix.trace.f.c.b;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class a
  extends com.tencent.matrix.trace.e.b
  implements com.tencent.matrix.b.b
{
  private static Handler aCF = new Handler(Looper.getMainLooper());
  private static a cND;
  private static final Object lock = new Object();
  private DisplayMetrics aJt = new DisplayMetrics();
  private long cMu;
  private int[] cMx = new int[c.b.values().length];
  private WindowManager.LayoutParams cNA;
  public boolean cNB;
  private FloatFrameView cNC;
  public View.OnClickListener cNE;
  public boolean cNF = true;
  private float cNG = 1.0F * (float)com.tencent.matrix.trace.core.b.Ji().cBg / 1000000.0F;
  private float cNH = Math.round(1000.0F / this.cNG);
  private long[] cNI = new long[1];
  private long cNJ;
  private int cNK = this.cNq;
  private long[] cNL = new long[1];
  private int[] cNM = new int[c.b.values().length];
  private String cNN = "default";
  private Runnable cNO = new Runnable()
  {
    public final void run()
    {
      a.g(a.this).cMS.setText(String.format("%.2f FPS", new Object[] { Float.valueOf(a.f(a.this)) }));
      a.g(a.this).cMS.setTextColor(a.g(a.this).getResources().getColor(2131100532));
    }
  };
  private int cNq;
  private int cNr;
  private int cNs;
  private int cNt;
  private int cNu;
  private Executor executor = new Executor()
  {
    public final void execute(Runnable paramAnonymousRunnable)
    {
      a.h(a.this).post(paramAnonymousRunnable);
    }
  };
  private Handler handler;
  private WindowManager windowManager;
  
  @SuppressLint({"ClickableViewAccessibility"})
  private a(Context paramContext, final FloatFrameView paramFloatFrameView)
  {
    this.cNC = paramFloatFrameView;
    paramFloatFrameView.cMS.setText(String.format("%.2f FPS", new Object[] { Float.valueOf(this.cNH) }));
    this.cNq = paramContext.getResources().getColor(2131100532);
    this.cNr = paramContext.getResources().getColor(2131100536);
    this.cNs = paramContext.getResources().getColor(2131100535);
    this.cNt = paramContext.getResources().getColor(2131100534);
    this.cNu = paramContext.getResources().getColor(2131100533);
    com.tencent.matrix.a.cBz.a(this);
    paramFloatFrameView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "onViewAttachedToWindow", new Object[0]);
        if (com.tencent.matrix.b.HS())
        {
          paramAnonymousView = (com.tencent.matrix.trace.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.cKh.a(a.this);
          }
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "onViewDetachedFromWindow", new Object[0]);
        if (com.tencent.matrix.b.HS())
        {
          paramAnonymousView = (com.tencent.matrix.trace.a)com.tencent.matrix.b.HT().V(com.tencent.matrix.trace.a.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.cKh.b(a.this);
          }
        }
      }
    });
    this.windowManager = ((WindowManager)paramContext.getApplicationContext().getSystemService("window"));
    for (;;)
    {
      try
      {
        paramContext = new DisplayMetrics();
        if (this.windowManager.getDefaultDisplay() != null)
        {
          this.windowManager.getDefaultDisplay().getMetrics(this.aJt);
          this.windowManager.getDefaultDisplay().getMetrics(paramContext);
        }
        this.cNA = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT < 26) {
          continue;
        }
        this.cNA.type = 2038;
        this.cNA.flags = 40;
        this.cNA.gravity = 8388659;
        if (this.cNC != null) {
          this.cNA.x = (paramContext.widthPixels - this.cNC.getLayoutParams().width * 2);
        }
        this.cNA.y = 0;
        this.cNA.width = -2;
        this.cNA.height = -2;
        this.cNA.format = -2;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      paramFloatFrameView.setOnTouchListener(new View.OnTouchListener()
      {
        float cNQ = 0.0F;
        float cNR = 0.0F;
        int cNS = 0;
        int cNT = 0;
        
        public final boolean onTouch(final View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          switch (paramAnonymousMotionEvent.getAction())
          {
          default: 
          case 0: 
          case 2: 
            do
            {
              return true;
              this.cNQ = paramAnonymousMotionEvent.getX();
              this.cNR = paramAnonymousMotionEvent.getY();
              this.cNS = a.a(a.this).x;
              this.cNT = a.a(a.this).y;
              return true;
              float f2 = paramAnonymousMotionEvent.getX();
              float f1 = paramAnonymousMotionEvent.getY();
              paramAnonymousMotionEvent = a.a(a.this);
              float f3 = paramAnonymousMotionEvent.x;
              paramAnonymousMotionEvent.x = ((int)((f2 - this.cNQ) / 3.0F + f3));
              paramAnonymousMotionEvent = a.a(a.this);
              f2 = paramAnonymousMotionEvent.y;
              paramAnonymousMotionEvent.y = ((int)((f1 - this.cNR) / 3.0F + f2));
            } while (paramAnonymousView == null);
            a.b(a.this).updateViewLayout(paramAnonymousView, a.a(a.this));
            return true;
          }
          int j = a.a(a.this).x;
          if (a.a(a.this).x > a.c(a.this).widthPixels / 2) {}
          for (int i = a.c(a.this).widthPixels - paramFloatFrameView.getWidth();; i = 0)
          {
            paramAnonymousMotionEvent = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("trans", new int[] { j, i }) });
            ((ValueAnimator)paramAnonymousMotionEvent).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
            {
              public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
              {
                if (!a.d(a.this)) {
                  return;
                }
                int i = ((Integer)paramAnonymous2ValueAnimator.getAnimatedValue("trans")).intValue();
                a.a(a.this).x = i;
                a.b(a.this).updateViewLayout(paramAnonymousView, a.a(a.this));
              }
            });
            paramAnonymousMotionEvent.setInterpolator(new AccelerateInterpolator());
            paramAnonymousMotionEvent.setDuration(180L).start();
            i = a.a(a.this).x;
            j = a.a(a.this).y;
            if ((Math.abs(i - this.cNS) > 20) || (Math.abs(j - this.cNT) > 20) || (a.e(a.this) == null)) {
              break;
            }
            a.e(a.this).onClick(paramAnonymousView);
            return true;
          }
        }
      });
      return;
      this.cNA.type = 2002;
    }
  }
  
  public static a aO(Context paramContext)
  {
    if (cND == null)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label41;
      }
      cND = new a(paramContext, new FloatFrameView(paramContext));
    }
    for (;;)
    {
      return cND;
      try
      {
        synchronized (lock)
        {
          label41:
          aCF.post(new Runnable()
          {
            public final void run()
            {
              a.i(new a(this.val$context, new FloatFrameView(this.val$context), (byte)0));
              synchronized (a.Jv())
              {
                a.Jv().notifyAll();
                return;
              }
            }
          });
          lock.wait();
        }
      }
      catch (InterruptedException paramContext) {}
    }
  }
  
  public final void a(String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    super.a(paramString, paramLong1, paramLong2, paramInt, paramBoolean, paramLong3, paramLong4, paramLong5, paramLong6);
    if (!Objects.equals(paramString, this.cNN))
    {
      this.cMx = new int[c.b.values().length];
      this.cNN = paramString;
      this.cNI[0] = 0L;
      this.cNL[0] = 0L;
    }
    this.cMu = (((float)this.cMu + (paramInt + 1) * this.cNG));
    this.cNJ += 1L;
    float f1 = (float)(this.cMu - this.cNI[0]);
    float f9;
    int n;
    int i1;
    int i2;
    int i3;
    int i;
    int j;
    int k;
    int m;
    int i4;
    label344:
    float f2;
    label352:
    float f3;
    label360:
    float f4;
    label368:
    float f5;
    label389:
    float f6;
    label397:
    float f7;
    if (paramInt >= 42)
    {
      paramString = this.cMx;
      paramInt = c.b.cMm.index;
      paramString[paramInt] += 1;
      paramString = this.cNM;
      paramInt = c.b.cMm.index;
      paramString[paramInt] += 1;
      this.cNK = this.cNu;
      paramLong1 = this.cNJ;
      paramLong2 = this.cNL[0];
      if (f1 >= 200.0F)
      {
        f9 = Math.min(this.cNH, (float)(paramLong1 - paramLong2) * 1000.0F / f1);
        paramString = this.cNC;
        paramInt = this.cNK;
        n = this.cMx[c.b.cMp.index];
        i1 = this.cMx[c.b.cMo.index];
        i2 = this.cMx[c.b.cMn.index];
        i3 = this.cMx[c.b.cMm.index];
        i = this.cNM[c.b.cMp.index];
        j = this.cNM[c.b.cMo.index];
        k = this.cNM[c.b.cMn.index];
        m = this.cNM[c.b.cMm.index];
        i4 = n + i1 + i2 + i3;
        if (i4 > 0) {
          break label1103;
        }
        f1 = 0.0F;
        if (i4 > 0) {
          break label1121;
        }
        f2 = 0.0F;
        if (i4 > 0) {
          break label1139;
        }
        f3 = 0.0F;
        if (i4 > 0) {
          break label1157;
        }
        f4 = 0.0F;
        n = i + j + k + m;
        if (n > 0) {
          break label1173;
        }
        f5 = 0.0F;
        if (n > 0) {
          break label1191;
        }
        f6 = 0.0F;
        if (n > 0) {
          break label1209;
        }
        f7 = 0.0F;
        label405:
        if (n > 0) {
          break label1227;
        }
      }
    }
    label1157:
    label1173:
    label1191:
    label1209:
    label1227:
    for (float f8 = 0.0F;; f8 = 1.0F * i / n * 1.0F)
    {
      String str1 = String.format("%.1f", new Object[] { Float.valueOf(f1) });
      String str2 = String.format("%.1f", new Object[] { Float.valueOf(f2) });
      String str3 = String.format("%.1f", new Object[] { Float.valueOf(f3) });
      String str4 = String.format("%.1f", new Object[] { Float.valueOf(f4) });
      String str5 = String.format("current: %.1f", new Object[] { Float.valueOf(f1 + f2 + f3 + f4) });
      String str6 = String.format("%.1f", new Object[] { Float.valueOf(f5) });
      String str7 = String.format("%.1f", new Object[] { Float.valueOf(f6) });
      String str8 = String.format("%.1f", new Object[] { Float.valueOf(f7) });
      String str9 = String.format("%.1f", new Object[] { Float.valueOf(f8) });
      String str10 = String.format("sum: %.1f", new Object[] { Float.valueOf(f5 + f6 + f7 + f8) });
      String str11 = String.format("%.2f FPS", new Object[] { Float.valueOf(f9) });
      aCF.post(new a.4(this, paramString, f9, paramInt, str11, str5, str1, str2, str3, str4, str10, str6, str7, str8, str9));
      this.cNK = this.cNq;
      this.cNI[0] = this.cMu;
      this.cNL[0] = this.cNJ;
      aCF.removeCallbacks(this.cNO);
      aCF.postDelayed(this.cNO, 250L);
      return;
      if (paramInt >= 24)
      {
        paramString = this.cMx;
        paramInt = c.b.cMn.index;
        paramString[paramInt] += 1;
        paramString = this.cNM;
        paramInt = c.b.cMn.index;
        paramString[paramInt] += 1;
        if (this.cNK == this.cNu) {
          break;
        }
        this.cNK = this.cNt;
        break;
      }
      if (paramInt >= 9)
      {
        paramString = this.cMx;
        paramInt = c.b.cMo.index;
        paramString[paramInt] += 1;
        paramString = this.cNM;
        paramInt = c.b.cMo.index;
        paramString[paramInt] += 1;
        if ((this.cNK == this.cNu) || (this.cNK == this.cNt)) {
          break;
        }
        this.cNK = this.cNs;
        break;
      }
      if (paramInt >= 3)
      {
        paramString = this.cMx;
        paramInt = c.b.cMp.index;
        paramString[paramInt] += 1;
        paramString = this.cNM;
        paramInt = c.b.cMp.index;
        paramString[paramInt] += 1;
        if ((this.cNK == this.cNu) || (this.cNK == this.cNt) || (this.cNK == this.cNs)) {
          break;
        }
        this.cNK = this.cNr;
        break;
      }
      paramString = this.cMx;
      paramInt = c.b.cMq.index;
      paramString[paramInt] += 1;
      paramString = this.cNM;
      paramInt = c.b.cMq.index;
      paramString[paramInt] += 1;
      if ((this.cNK == this.cNu) || (this.cNK == this.cNt) || (this.cNK == this.cNs) || (this.cNK == this.cNr)) {
        break;
      }
      this.cNK = this.cNq;
      break;
      label1103:
      f1 = i3 * 1.0F / i4 * 60.0F;
      break label344;
      label1121:
      f2 = 1.0F * i2 / i4 * 25.0F;
      break label352;
      label1139:
      f3 = 1.0F * i1 / i4 * 14.0F;
      break label360;
      f4 = 1.0F * n / i4 * 1.0F;
      break label368;
      f5 = 1.0F * m / n * 60.0F;
      break label389;
      f6 = 1.0F * k / n * 25.0F;
      break label397;
      f7 = 1.0F * j / n * 14.0F;
      break label405;
    }
  }
  
  public final void dismiss()
  {
    if (!this.cNF) {
      return;
    }
    aCF.post(new Runnable()
    {
      public final void run()
      {
        if (a.d(a.this))
        {
          a.a(a.this, false);
          a.b(a.this).removeView(a.g(a.this));
        }
      }
    });
  }
  
  public final void eg(String paramString)
  {
    if (this.cNC != null)
    {
      TextView localTextView = (TextView)this.cNC.findViewById(2131299636);
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
    }
  }
  
  public final Executor getExecutor()
  {
    return this.executor;
  }
  
  public final void onForeground(final boolean paramBoolean)
  {
    com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "[onForeground] isForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!this.cNF) {}
    while (aCF == null) {
      return;
    }
    aCF.post(new Runnable()
    {
      public final void run()
      {
        if (paramBoolean)
        {
          a.this.show();
          return;
        }
        a.this.dismiss();
      }
    });
  }
  
  public final void show()
  {
    if (!this.cNF) {
      return;
    }
    aCF.post(new Runnable()
    {
      public final void run()
      {
        if (!a.d(a.this))
        {
          a.a(a.this, true);
          a.b(a.this).addView(a.g(a.this), a.a(a.this));
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.view.a
 * JD-Core Version:    0.7.0.1
 */