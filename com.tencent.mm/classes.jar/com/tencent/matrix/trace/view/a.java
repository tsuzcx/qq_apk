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
  implements com.tencent.matrix.b.c
{
  private static Handler aDv = new Handler(Looper.getMainLooper());
  private static a deb;
  private static final Object lock = new Object();
  private DisplayMetrics aJm = new DisplayMetrics();
  private long dcS;
  private int[] dcV = new int[c.b.values().length];
  private int ddO;
  private int ddP;
  private int ddQ;
  private int ddR;
  private int ddS;
  private WindowManager.LayoutParams ddY;
  public boolean ddZ;
  private FloatFrameView dea;
  public View.OnClickListener dec;
  public boolean ded = true;
  private float dee = 1.0F * (float)com.tencent.matrix.trace.core.b.Tw().cPm / 1000000.0F;
  private float def = Math.round(1000.0F / this.dee);
  private long[] deg = new long[1];
  private long deh;
  private int dei = this.ddO;
  private long[] dej = new long[1];
  private int[] dek = new int[c.b.values().length];
  private String del = "default";
  private Runnable dem = new Runnable()
  {
    public final void run()
    {
      a.g(a.this).ddq.setText(String.format("%.2f FPS", new Object[] { Float.valueOf(a.f(a.this)) }));
      a.g(a.this).ddq.setTextColor(a.g(a.this).getResources().getColor(2131100670));
    }
  };
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
    this.dea = paramFloatFrameView;
    paramFloatFrameView.ddq.setText(String.format("%.2f FPS", new Object[] { Float.valueOf(this.def) }));
    this.ddO = paramContext.getResources().getColor(2131100670);
    this.ddP = paramContext.getResources().getColor(2131100674);
    this.ddQ = paramContext.getResources().getColor(2131100673);
    this.ddR = paramContext.getResources().getColor(2131100672);
    this.ddS = paramContext.getResources().getColor(2131100671);
    com.tencent.matrix.a.cPA.a(this);
    paramFloatFrameView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "onViewAttachedToWindow", new Object[0]);
        if (com.tencent.matrix.b.isInstalled())
        {
          paramAnonymousView = (com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.daF.a(a.this);
          }
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "onViewDetachedFromWindow", new Object[0]);
        if (com.tencent.matrix.b.isInstalled())
        {
          paramAnonymousView = (com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.daF.b(a.this);
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
          this.windowManager.getDefaultDisplay().getMetrics(this.aJm);
          this.windowManager.getDefaultDisplay().getMetrics(paramContext);
        }
        this.ddY = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT < 26) {
          continue;
        }
        this.ddY.type = 2038;
        this.ddY.flags = 40;
        this.ddY.gravity = 8388659;
        if (this.dea != null) {
          this.ddY.x = (paramContext.widthPixels - this.dea.getLayoutParams().width * 2);
        }
        this.ddY.y = 0;
        this.ddY.width = -2;
        this.ddY.height = -2;
        this.ddY.format = -2;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      paramFloatFrameView.setOnTouchListener(new View.OnTouchListener()
      {
        float deo = 0.0F;
        float dep = 0.0F;
        int deq = 0;
        int der = 0;
        
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
              this.deo = paramAnonymousMotionEvent.getX();
              this.dep = paramAnonymousMotionEvent.getY();
              this.deq = a.a(a.this).x;
              this.der = a.a(a.this).y;
              return true;
              float f2 = paramAnonymousMotionEvent.getX();
              float f1 = paramAnonymousMotionEvent.getY();
              paramAnonymousMotionEvent = a.a(a.this);
              float f3 = paramAnonymousMotionEvent.x;
              paramAnonymousMotionEvent.x = ((int)((f2 - this.deo) / 3.0F + f3));
              paramAnonymousMotionEvent = a.a(a.this);
              f2 = paramAnonymousMotionEvent.y;
              paramAnonymousMotionEvent.y = ((int)((f1 - this.dep) / 3.0F + f2));
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
            if ((Math.abs(i - this.deq) > 20) || (Math.abs(j - this.der) > 20) || (a.e(a.this) == null)) {
              break;
            }
            a.e(a.this).onClick(paramAnonymousView);
            return true;
          }
        }
      });
      return;
      this.ddY.type = 2002;
    }
  }
  
  public static a bi(Context paramContext)
  {
    if (deb == null)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label41;
      }
      deb = new a(paramContext, new FloatFrameView(paramContext));
    }
    for (;;)
    {
      return deb;
      try
      {
        synchronized (lock)
        {
          label41:
          aDv.post(new Runnable()
          {
            public final void run()
            {
              a.i(new a(this.val$context, new FloatFrameView(this.val$context), (byte)0));
              synchronized (a.TJ())
              {
                a.TJ().notifyAll();
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
    if (!Objects.equals(paramString, this.del))
    {
      this.dcV = new int[c.b.values().length];
      this.del = paramString;
      this.deg[0] = 0L;
      this.dej[0] = 0L;
    }
    this.dcS = (((float)this.dcS + (paramInt + 1) * this.dee));
    this.deh += 1L;
    float f1 = (float)(this.dcS - this.deg[0]);
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
      paramString = this.dcV;
      paramInt = c.b.dcK.index;
      paramString[paramInt] += 1;
      paramString = this.dek;
      paramInt = c.b.dcK.index;
      paramString[paramInt] += 1;
      this.dei = this.ddS;
      paramLong1 = this.deh;
      paramLong2 = this.dej[0];
      if (f1 >= 200.0F)
      {
        f9 = Math.min(this.def, (float)(paramLong1 - paramLong2) * 1000.0F / f1);
        paramString = this.dea;
        paramInt = this.dei;
        n = this.dcV[c.b.dcN.index];
        i1 = this.dcV[c.b.dcM.index];
        i2 = this.dcV[c.b.dcL.index];
        i3 = this.dcV[c.b.dcK.index];
        i = this.dek[c.b.dcN.index];
        j = this.dek[c.b.dcM.index];
        k = this.dek[c.b.dcL.index];
        m = this.dek[c.b.dcK.index];
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
      aDv.post(new Runnable()
      {
        public final void run()
        {
          FloatFrameView.LineChartView localLineChartView = paramString.ddr;
          FloatFrameView.LineChartView.a locala = new FloatFrameView.LineChartView.a(localLineChartView, (int)f9, paramInt);
          if (localLineChartView.ddH.size() >= 50) {
            localLineChartView.ddH.removeLast();
          }
          localLineChartView.ddH.addFirst(locala);
          localLineChartView.invalidate();
          paramString.ddq.setText(str11);
          paramString.ddq.setTextColor(paramInt);
          paramString.ddC.setText(str5);
          paramString.dds.setText(str1);
          paramString.ddt.setText(str2);
          paramString.ddu.setText(str3);
          paramString.ddv.setText(str4);
          paramString.ddD.setText(str10);
          paramString.ddw.setText(str6);
          paramString.ddx.setText(str7);
          paramString.ddy.setText(str8);
          paramString.ddz.setText(str9);
        }
      });
      this.dei = this.ddO;
      this.deg[0] = this.dcS;
      this.dej[0] = this.deh;
      aDv.removeCallbacks(this.dem);
      aDv.postDelayed(this.dem, 250L);
      return;
      if (paramInt >= 24)
      {
        paramString = this.dcV;
        paramInt = c.b.dcL.index;
        paramString[paramInt] += 1;
        paramString = this.dek;
        paramInt = c.b.dcL.index;
        paramString[paramInt] += 1;
        if (this.dei == this.ddS) {
          break;
        }
        this.dei = this.ddR;
        break;
      }
      if (paramInt >= 9)
      {
        paramString = this.dcV;
        paramInt = c.b.dcM.index;
        paramString[paramInt] += 1;
        paramString = this.dek;
        paramInt = c.b.dcM.index;
        paramString[paramInt] += 1;
        if ((this.dei == this.ddS) || (this.dei == this.ddR)) {
          break;
        }
        this.dei = this.ddQ;
        break;
      }
      if (paramInt >= 3)
      {
        paramString = this.dcV;
        paramInt = c.b.dcN.index;
        paramString[paramInt] += 1;
        paramString = this.dek;
        paramInt = c.b.dcN.index;
        paramString[paramInt] += 1;
        if ((this.dei == this.ddS) || (this.dei == this.ddR) || (this.dei == this.ddQ)) {
          break;
        }
        this.dei = this.ddP;
        break;
      }
      paramString = this.dcV;
      paramInt = c.b.dcO.index;
      paramString[paramInt] += 1;
      paramString = this.dek;
      paramInt = c.b.dcO.index;
      paramString[paramInt] += 1;
      if ((this.dei == this.ddS) || (this.dei == this.ddR) || (this.dei == this.ddQ) || (this.dei == this.ddP)) {
        break;
      }
      this.dei = this.ddO;
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
    if (!this.ded) {
      return;
    }
    aDv.post(new Runnable()
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
  
  public final void eQ(String paramString)
  {
    if (this.dea != null)
    {
      TextView localTextView = (TextView)this.dea.findViewById(2131300270);
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
    if (!this.ded) {}
    while (aDv == null) {
      return;
    }
    aDv.post(new Runnable()
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
    if (!this.ded) {
      return;
    }
    aDv.post(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.trace.view.a
 * JD-Core Version:    0.7.0.1
 */