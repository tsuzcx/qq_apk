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
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class a
  extends com.tencent.matrix.trace.e.b
  implements com.tencent.matrix.b.b
{
  private static Handler aCF = new Handler(Looper.getMainLooper());
  private static a cMU;
  private static final Object lock = new Object();
  private DisplayMetrics aJt = new DisplayMetrics();
  private long cLL;
  private int[] cLO = new int[c.b.values().length];
  private int cMH;
  private int cMI;
  private int cMJ;
  private int cMK;
  private int cML;
  private WindowManager.LayoutParams cMR;
  public boolean cMS;
  private FloatFrameView cMT;
  public View.OnClickListener cMV;
  public boolean cMW = true;
  private float cMX = 1.0F * (float)com.tencent.matrix.trace.core.b.Ja().cAz / 1000000.0F;
  private long[] cMY = new long[1];
  private long cMZ;
  private int cNa = this.cMH;
  private long[] cNb = new long[1];
  private int[] cNc = new int[c.b.values().length];
  private String cNd = "default";
  private Runnable cNe = new Runnable()
  {
    public final void run()
    {
      a.f(a.this).cMj.setText("60.00 FPS");
      a.f(a.this).cMj.setTextColor(a.f(a.this).getResources().getColor(2131100532));
    }
  };
  private Executor executor = new Executor()
  {
    public final void execute(Runnable paramAnonymousRunnable)
    {
      a.g(a.this).post(paramAnonymousRunnable);
    }
  };
  private Handler handler;
  private WindowManager windowManager;
  
  @SuppressLint({"ClickableViewAccessibility"})
  private a(Context paramContext, final FloatFrameView paramFloatFrameView)
  {
    this.cMT = paramFloatFrameView;
    this.cMH = paramContext.getResources().getColor(2131100532);
    this.cMI = paramContext.getResources().getColor(2131100536);
    this.cMJ = paramContext.getResources().getColor(2131100535);
    this.cMK = paramContext.getResources().getColor(2131100534);
    this.cML = paramContext.getResources().getColor(2131100533);
    com.tencent.matrix.a.cAS.a(this);
    paramFloatFrameView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "onViewAttachedToWindow", new Object[0]);
        if (com.tencent.matrix.b.HK())
        {
          paramAnonymousView = (com.tencent.matrix.trace.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.cJy.a(a.this);
          }
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "onViewDetachedFromWindow", new Object[0]);
        if (com.tencent.matrix.b.HK())
        {
          paramAnonymousView = (com.tencent.matrix.trace.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.cJy.b(a.this);
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
        this.cMR = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT < 26) {
          continue;
        }
        this.cMR.type = 2038;
        this.cMR.flags = 40;
        this.cMR.gravity = 8388659;
        if (this.cMT != null) {
          this.cMR.x = (paramContext.widthPixels - this.cMT.getLayoutParams().width * 2);
        }
        this.cMR.y = 0;
        this.cMR.width = -2;
        this.cMR.height = -2;
        this.cMR.format = -2;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      paramFloatFrameView.setOnTouchListener(new View.OnTouchListener()
      {
        float cNg = 0.0F;
        float cNh = 0.0F;
        int cNi = 0;
        int cNj = 0;
        
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
              this.cNg = paramAnonymousMotionEvent.getX();
              this.cNh = paramAnonymousMotionEvent.getY();
              this.cNi = a.a(a.this).x;
              this.cNj = a.a(a.this).y;
              return true;
              float f2 = paramAnonymousMotionEvent.getX();
              float f1 = paramAnonymousMotionEvent.getY();
              paramAnonymousMotionEvent = a.a(a.this);
              float f3 = paramAnonymousMotionEvent.x;
              paramAnonymousMotionEvent.x = ((int)((f2 - this.cNg) / 3.0F + f3));
              paramAnonymousMotionEvent = a.a(a.this);
              f2 = paramAnonymousMotionEvent.y;
              paramAnonymousMotionEvent.y = ((int)((f1 - this.cNh) / 3.0F + f2));
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
            if ((Math.abs(i - this.cNi) > 20) || (Math.abs(j - this.cNj) > 20) || (a.e(a.this) == null)) {
              break;
            }
            a.e(a.this).onClick(paramAnonymousView);
            return true;
          }
        }
      });
      return;
      this.cMR.type = 2002;
    }
  }
  
  public static a aN(Context paramContext)
  {
    if (cMU == null)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label41;
      }
      cMU = new a(paramContext, new FloatFrameView(paramContext));
    }
    for (;;)
    {
      return cMU;
      try
      {
        synchronized (lock)
        {
          label41:
          aCF.post(new Runnable()
          {
            public final void run()
            {
              a.h(new a(this.val$context, new FloatFrameView(this.val$context), (byte)0));
              synchronized (a.Jn())
              {
                a.Jn().notifyAll();
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
  
  public final void a(final String paramString, long paramLong1, long paramLong2, final int paramInt, boolean paramBoolean, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    super.a(paramString, paramLong1, paramLong2, paramInt, paramBoolean, paramLong3, paramLong4, paramLong5, paramLong6);
    if (!Objects.equals(paramString, this.cNd))
    {
      this.cLO = new int[c.b.values().length];
      this.cNd = paramString;
      this.cMY[0] = 0L;
      this.cNb[0] = 0L;
    }
    this.cLL = (((float)this.cLL + (paramInt + 1) * this.cMX));
    this.cMZ += 1L;
    float f1 = (float)(this.cLL - this.cMY[0]);
    final float f9;
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
      paramString = this.cLO;
      paramInt = c.b.cLD.index;
      paramString[paramInt] += 1;
      paramString = this.cNc;
      paramInt = c.b.cLD.index;
      paramString[paramInt] += 1;
      this.cNa = this.cML;
      paramLong1 = this.cMZ;
      paramLong2 = this.cNb[0];
      if (f1 >= 200.0F)
      {
        f9 = Math.min(60.0F, (float)(paramLong1 - paramLong2) * 1000.0F / f1);
        paramString = this.cMT;
        paramInt = this.cNa;
        n = this.cLO[c.b.cLG.index];
        i1 = this.cLO[c.b.cLF.index];
        i2 = this.cLO[c.b.cLE.index];
        i3 = this.cLO[c.b.cLD.index];
        i = this.cNc[c.b.cLG.index];
        j = this.cNc[c.b.cLF.index];
        k = this.cNc[c.b.cLE.index];
        m = this.cNc[c.b.cLD.index];
        i4 = n + i1 + i2 + i3;
        if (i4 > 0) {
          break label1104;
        }
        f1 = 0.0F;
        if (i4 > 0) {
          break label1122;
        }
        f2 = 0.0F;
        if (i4 > 0) {
          break label1140;
        }
        f3 = 0.0F;
        if (i4 > 0) {
          break label1158;
        }
        f4 = 0.0F;
        n = i + j + k + m;
        if (n > 0) {
          break label1174;
        }
        f5 = 0.0F;
        if (n > 0) {
          break label1192;
        }
        f6 = 0.0F;
        if (n > 0) {
          break label1210;
        }
        f7 = 0.0F;
        label405:
        if (n > 0) {
          break label1228;
        }
      }
    }
    label1158:
    label1174:
    label1192:
    label1210:
    label1228:
    for (float f8 = 0.0F;; f8 = 1.0F * i / n * 1.0F)
    {
      final String str1 = String.format("%.1f", new Object[] { Float.valueOf(f1) });
      final String str2 = String.format("%.1f", new Object[] { Float.valueOf(f2) });
      final String str3 = String.format("%.1f", new Object[] { Float.valueOf(f3) });
      final String str4 = String.format("%.1f", new Object[] { Float.valueOf(f4) });
      final String str5 = String.format("current: %.1f", new Object[] { Float.valueOf(f1 + f2 + f3 + f4) });
      final String str6 = String.format("%.1f", new Object[] { Float.valueOf(f5) });
      final String str7 = String.format("%.1f", new Object[] { Float.valueOf(f6) });
      final String str8 = String.format("%.1f", new Object[] { Float.valueOf(f7) });
      final String str9 = String.format("%.1f", new Object[] { Float.valueOf(f8) });
      final String str10 = String.format("sum: %.1f", new Object[] { Float.valueOf(f5 + f6 + f7 + f8) });
      final String str11 = String.format("%.2f FPS", new Object[] { Float.valueOf(f9) });
      aCF.post(new Runnable()
      {
        public final void run()
        {
          FloatFrameView.LineChartView localLineChartView = paramString.cMk;
          FloatFrameView.LineChartView.a locala = new FloatFrameView.LineChartView.a(localLineChartView, (int)f9, paramInt);
          if (localLineChartView.cMA.size() >= 50) {
            localLineChartView.cMA.removeLast();
          }
          localLineChartView.cMA.addFirst(locala);
          localLineChartView.invalidate();
          paramString.cMj.setText(str11);
          paramString.cMj.setTextColor(paramInt);
          paramString.cMv.setText(str5);
          paramString.cMl.setText(str1);
          paramString.cMm.setText(str2);
          paramString.cMn.setText(str3);
          paramString.cMo.setText(str4);
          paramString.cMw.setText(str10);
          paramString.cMp.setText(str6);
          paramString.cMq.setText(str7);
          paramString.cMr.setText(str8);
          paramString.cMs.setText(str9);
        }
      });
      this.cNa = this.cMH;
      this.cMY[0] = this.cLL;
      this.cNb[0] = this.cMZ;
      aCF.removeCallbacks(this.cNe);
      aCF.postDelayed(this.cNe, 250L);
      return;
      if (paramInt >= 24)
      {
        paramString = this.cLO;
        paramInt = c.b.cLE.index;
        paramString[paramInt] += 1;
        paramString = this.cNc;
        paramInt = c.b.cLE.index;
        paramString[paramInt] += 1;
        if (this.cNa == this.cML) {
          break;
        }
        this.cNa = this.cMK;
        break;
      }
      if (paramInt >= 9)
      {
        paramString = this.cLO;
        paramInt = c.b.cLF.index;
        paramString[paramInt] += 1;
        paramString = this.cNc;
        paramInt = c.b.cLF.index;
        paramString[paramInt] += 1;
        if ((this.cNa == this.cML) || (this.cNa == this.cMK)) {
          break;
        }
        this.cNa = this.cMJ;
        break;
      }
      if (paramInt >= 3)
      {
        paramString = this.cLO;
        paramInt = c.b.cLG.index;
        paramString[paramInt] += 1;
        paramString = this.cNc;
        paramInt = c.b.cLG.index;
        paramString[paramInt] += 1;
        if ((this.cNa == this.cML) || (this.cNa == this.cMK) || (this.cNa == this.cMJ)) {
          break;
        }
        this.cNa = this.cMI;
        break;
      }
      paramString = this.cLO;
      paramInt = c.b.cLH.index;
      paramString[paramInt] += 1;
      paramString = this.cNc;
      paramInt = c.b.cLH.index;
      paramString[paramInt] += 1;
      if ((this.cNa == this.cML) || (this.cNa == this.cMK) || (this.cNa == this.cMJ) || (this.cNa == this.cMI)) {
        break;
      }
      this.cNa = this.cMH;
      break;
      label1104:
      f1 = i3 * 1.0F / i4 * 60.0F;
      break label344;
      label1122:
      f2 = 1.0F * i2 / i4 * 25.0F;
      break label352;
      label1140:
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
    if (!this.cMW) {
      return;
    }
    aCF.post(new Runnable()
    {
      public final void run()
      {
        if (a.d(a.this))
        {
          a.a(a.this, false);
          a.b(a.this).removeView(a.f(a.this));
        }
      }
    });
  }
  
  public final void eb(String paramString)
  {
    if (this.cMT != null)
    {
      TextView localTextView = (TextView)this.cMT.findViewById(2131299636);
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
    if (!this.cMW) {}
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
    if (!this.cMW) {
      return;
    }
    aCF.post(new Runnable()
    {
      public final void run()
      {
        if (!a.d(a.this))
        {
          a.a(a.this, true);
          a.b(a.this).addView(a.f(a.this), a.a(a.this));
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.trace.view.a
 * JD-Core Version:    0.7.0.1
 */