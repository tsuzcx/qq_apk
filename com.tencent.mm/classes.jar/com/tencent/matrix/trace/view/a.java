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
import com.tencent.matrix.trace.f.c.a;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class a
  extends com.tencent.matrix.trace.e.b
  implements com.tencent.matrix.b.b
{
  private static Handler azU = new Handler(Looper.getMainLooper());
  private static a cEN;
  private static final Object lock = new Object();
  private DisplayMetrics aGM = new DisplayMetrics();
  private long cDE;
  private int[] cDH = new int[c.a.values().length];
  private int cEA;
  private int cEB;
  private int cEC;
  private int cED;
  private int cEE;
  private WindowManager.LayoutParams cEK;
  public boolean cEL;
  private FloatFrameView cEM;
  public View.OnClickListener cEO;
  public boolean cEP = true;
  private float cEQ = 1.0F * (float)com.tencent.matrix.trace.core.b.HU().csA / 1000000.0F;
  private long[] cER = new long[1];
  private long cES;
  private int cET = this.cEA;
  private long[] cEU = new long[1];
  private int[] cEV = new int[c.a.values().length];
  private String cEW = "default";
  private Runnable cEX = new Runnable()
  {
    public final void run()
    {
      a.f(a.this).cEc.setText("60.00 FPS");
      a.f(a.this).cEc.setTextColor(a.f(a.this).getResources().getColor(2131100532));
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
    this.cEM = paramFloatFrameView;
    this.cEA = paramContext.getResources().getColor(2131100532);
    this.cEB = paramContext.getResources().getColor(2131100536);
    this.cEC = paramContext.getResources().getColor(2131100535);
    this.cED = paramContext.getResources().getColor(2131100534);
    this.cEE = paramContext.getResources().getColor(2131100533);
    com.tencent.matrix.a.csS.a(this);
    paramFloatFrameView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "onViewAttachedToWindow", new Object[0]);
        if (com.tencent.matrix.b.GE())
        {
          paramAnonymousView = (com.tencent.matrix.trace.a)com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.cBu.a(a.this);
          }
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "onViewDetachedFromWindow", new Object[0]);
        if (com.tencent.matrix.b.GE())
        {
          paramAnonymousView = (com.tencent.matrix.trace.a)com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.cBu.b(a.this);
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
          this.windowManager.getDefaultDisplay().getMetrics(this.aGM);
          this.windowManager.getDefaultDisplay().getMetrics(paramContext);
        }
        this.cEK = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT < 26) {
          continue;
        }
        this.cEK.type = 2038;
        this.cEK.flags = 40;
        this.cEK.gravity = 8388659;
        if (this.cEM != null) {
          this.cEK.x = (paramContext.widthPixels - this.cEM.getLayoutParams().width * 2);
        }
        this.cEK.y = 0;
        this.cEK.width = -2;
        this.cEK.height = -2;
        this.cEK.format = -2;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      paramFloatFrameView.setOnTouchListener(new View.OnTouchListener()
      {
        float cEZ = 0.0F;
        float cFa = 0.0F;
        int cFb = 0;
        int cFc = 0;
        
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
              this.cEZ = paramAnonymousMotionEvent.getX();
              this.cFa = paramAnonymousMotionEvent.getY();
              this.cFb = a.a(a.this).x;
              this.cFc = a.a(a.this).y;
              return true;
              float f2 = paramAnonymousMotionEvent.getX();
              float f1 = paramAnonymousMotionEvent.getY();
              paramAnonymousMotionEvent = a.a(a.this);
              float f3 = paramAnonymousMotionEvent.x;
              paramAnonymousMotionEvent.x = ((int)((f2 - this.cEZ) / 3.0F + f3));
              paramAnonymousMotionEvent = a.a(a.this);
              f2 = paramAnonymousMotionEvent.y;
              paramAnonymousMotionEvent.y = ((int)((f1 - this.cFa) / 3.0F + f2));
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
            if ((Math.abs(i - this.cFb) > 20) || (Math.abs(j - this.cFc) > 20) || (a.e(a.this) == null)) {
              break;
            }
            a.e(a.this).onClick(paramAnonymousView);
            return true;
          }
        }
      });
      return;
      this.cEK.type = 2002;
    }
  }
  
  public static a aM(Context paramContext)
  {
    if (cEN == null)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label41;
      }
      cEN = new a(paramContext, new FloatFrameView(paramContext));
    }
    for (;;)
    {
      return cEN;
      try
      {
        synchronized (lock)
        {
          label41:
          azU.post(new Runnable()
          {
            public final void run()
            {
              a.h(new a(this.val$context, new FloatFrameView(this.val$context), (byte)0));
              synchronized (a.Ij())
              {
                a.Ij().notifyAll();
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
    if (!Objects.equals(paramString, this.cEW))
    {
      this.cDH = new int[c.a.values().length];
      this.cEW = paramString;
      this.cER[0] = 0L;
      this.cEU[0] = 0L;
    }
    this.cDE = (((float)this.cDE + (paramInt + 1) * this.cEQ));
    this.cES += 1L;
    float f1 = (float)(this.cDE - this.cER[0]);
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
      paramString = this.cDH;
      paramInt = c.a.cDw.index;
      paramString[paramInt] += 1;
      paramString = this.cEV;
      paramInt = c.a.cDw.index;
      paramString[paramInt] += 1;
      this.cET = this.cEE;
      paramLong1 = this.cES;
      paramLong2 = this.cEU[0];
      if (f1 >= 200.0F)
      {
        f9 = Math.min(60.0F, (float)(paramLong1 - paramLong2) * 1000.0F / f1);
        paramString = this.cEM;
        paramInt = this.cET;
        n = this.cDH[c.a.cDz.index];
        i1 = this.cDH[c.a.cDy.index];
        i2 = this.cDH[c.a.cDx.index];
        i3 = this.cDH[c.a.cDw.index];
        i = this.cEV[c.a.cDz.index];
        j = this.cEV[c.a.cDy.index];
        k = this.cEV[c.a.cDx.index];
        m = this.cEV[c.a.cDw.index];
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
      azU.post(new Runnable()
      {
        public final void run()
        {
          FloatFrameView.LineChartView localLineChartView = paramString.cEd;
          FloatFrameView.LineChartView.a locala = new FloatFrameView.LineChartView.a(localLineChartView, (int)f9, paramInt);
          if (localLineChartView.cEt.size() >= 50) {
            localLineChartView.cEt.removeLast();
          }
          localLineChartView.cEt.addFirst(locala);
          localLineChartView.invalidate();
          paramString.cEc.setText(str11);
          paramString.cEc.setTextColor(paramInt);
          paramString.cEo.setText(str5);
          paramString.cEe.setText(str1);
          paramString.cEf.setText(str2);
          paramString.cEg.setText(str3);
          paramString.cEh.setText(str4);
          paramString.cEp.setText(str10);
          paramString.cEi.setText(str6);
          paramString.cEj.setText(str7);
          paramString.cEk.setText(str8);
          paramString.cEl.setText(str9);
        }
      });
      this.cET = this.cEA;
      this.cER[0] = this.cDE;
      this.cEU[0] = this.cES;
      azU.removeCallbacks(this.cEX);
      azU.postDelayed(this.cEX, 250L);
      return;
      if (paramInt >= 24)
      {
        paramString = this.cDH;
        paramInt = c.a.cDx.index;
        paramString[paramInt] += 1;
        paramString = this.cEV;
        paramInt = c.a.cDx.index;
        paramString[paramInt] += 1;
        if (this.cET == this.cEE) {
          break;
        }
        this.cET = this.cED;
        break;
      }
      if (paramInt >= 9)
      {
        paramString = this.cDH;
        paramInt = c.a.cDy.index;
        paramString[paramInt] += 1;
        paramString = this.cEV;
        paramInt = c.a.cDy.index;
        paramString[paramInt] += 1;
        if ((this.cET == this.cEE) || (this.cET == this.cED)) {
          break;
        }
        this.cET = this.cEC;
        break;
      }
      if (paramInt >= 3)
      {
        paramString = this.cDH;
        paramInt = c.a.cDz.index;
        paramString[paramInt] += 1;
        paramString = this.cEV;
        paramInt = c.a.cDz.index;
        paramString[paramInt] += 1;
        if ((this.cET == this.cEE) || (this.cET == this.cED) || (this.cET == this.cEC)) {
          break;
        }
        this.cET = this.cEB;
        break;
      }
      paramString = this.cDH;
      paramInt = c.a.cDA.index;
      paramString[paramInt] += 1;
      paramString = this.cEV;
      paramInt = c.a.cDA.index;
      paramString[paramInt] += 1;
      if ((this.cET == this.cEE) || (this.cET == this.cED) || (this.cET == this.cEC) || (this.cET == this.cEB)) {
        break;
      }
      this.cET = this.cEA;
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
    if (!this.cEP) {
      return;
    }
    azU.post(new Runnable()
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
  
  public final void dr(String paramString)
  {
    if (this.cEM != null)
    {
      TextView localTextView = (TextView)this.cEM.findViewById(2131299636);
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
    if (!this.cEP) {}
    while (azU == null) {
      return;
    }
    azU.post(new Runnable()
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
    if (!this.cEP) {
      return;
    }
    azU.post(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.trace.view.a
 * JD-Core Version:    0.7.0.1
 */