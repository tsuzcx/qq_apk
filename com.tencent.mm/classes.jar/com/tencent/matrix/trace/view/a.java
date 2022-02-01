package com.tencent.matrix.trace.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.a.a;
import com.tencent.matrix.trace.a.b;
import com.tencent.matrix.trace.tracer.b.b;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class a
  extends com.tencent.matrix.trace.e.b
  implements com.tencent.matrix.b.a
{
  private static a fhT;
  private static final Object lock = new Object();
  private static Handler mainHandler = new Handler(Looper.getMainLooper());
  public boolean egk = true;
  private DisplayMetrics euS = new DisplayMetrics();
  private Executor executor = new Executor()
  {
    public final void execute(Runnable paramAnonymousRunnable)
    {
      a.h(a.this).post(paramAnonymousRunnable);
    }
  };
  private long fge;
  private int[] fgh = new int[b.b.values().length];
  private int fhG;
  private int fhH;
  private int fhI;
  private int fhJ;
  private int fhK;
  private WindowManager.LayoutParams fhQ;
  public boolean fhR;
  private FloatFrameView fhS;
  public View.OnClickListener fhU;
  private float fhV = 1.0F * (float)com.tencent.matrix.trace.core.b.azL().eLi / 1000000.0F;
  private float fhW = Math.round(1000.0F / this.fhV);
  private long[] fhX = new long[1];
  private long fhY;
  private int fhZ = this.fhG;
  private long[] fia = new long[1];
  private int[] fib = new int[b.b.values().length];
  private String fic = "default";
  private Runnable fid = new Runnable()
  {
    public final void run()
    {
      a.g(a.this).fhi.setText(String.format("%.2f FPS", new Object[] { Float.valueOf(a.f(a.this)) }));
      a.g(a.this).fhi.setTextColor(a.g(a.this).getResources().getColor(a.a.level_best_color));
    }
  };
  private Handler handler;
  private WindowManager windowManager;
  
  private a(Context paramContext, FloatFrameView paramFloatFrameView)
  {
    this.fhS = paramFloatFrameView;
    paramFloatFrameView.fhi.setText(String.format("%.2f FPS", new Object[] { Float.valueOf(this.fhW) }));
    this.fhG = paramContext.getResources().getColor(a.a.level_best_color);
    this.fhH = paramContext.getResources().getColor(a.a.level_normal_color);
    this.fhI = paramContext.getResources().getColor(a.a.level_middle_color);
    this.fhJ = paramContext.getResources().getColor(a.a.level_high_color);
    this.fhK = paramContext.getResources().getColor(a.a.level_frozen_color);
    com.tencent.matrix.a.eLw.a(this);
    paramFloatFrameView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        com.tencent.matrix.e.c.i("Matrix.FrameDecorator", "onViewAttachedToWindow", new Object[0]);
        if (com.tencent.matrix.c.isInstalled())
        {
          paramAnonymousView = (com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.fdr.a(a.this);
          }
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        com.tencent.matrix.e.c.i("Matrix.FrameDecorator", "onViewDetachedFromWindow", new Object[0]);
        if (com.tencent.matrix.c.isInstalled())
        {
          paramAnonymousView = (com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.fdr.b(a.this);
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
          this.windowManager.getDefaultDisplay().getMetrics(this.euS);
          this.windowManager.getDefaultDisplay().getMetrics(paramContext);
        }
        this.fhQ = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT < 26) {
          continue;
        }
        this.fhQ.type = 2038;
        this.fhQ.flags = 40;
        this.fhQ.gravity = 8388659;
        if (this.fhS != null) {
          this.fhQ.x = (paramContext.widthPixels - this.fhS.getLayoutParams().width * 2);
        }
        this.fhQ.y = 0;
        this.fhQ.width = -2;
        this.fhQ.height = -2;
        this.fhQ.format = -2;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      paramFloatFrameView.setOnTouchListener(new a.2(this, paramFloatFrameView));
      return;
      this.fhQ.type = 2002;
    }
  }
  
  public static a cj(Context paramContext)
  {
    if (fhT == null)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label41;
      }
      fhT = new a(paramContext, new FloatFrameView(paramContext));
    }
    for (;;)
    {
      return fhT;
      try
      {
        synchronized (lock)
        {
          label41:
          mainHandler.post(new Runnable()
          {
            public final void run()
            {
              a.i(new a(this.val$context, new FloatFrameView(this.val$context), (byte)0));
              synchronized (a.aAg())
              {
                a.aAg().notifyAll();
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
  
  public final void b(String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    super.b(paramString, paramLong1, paramLong2, paramInt, paramBoolean, paramLong3, paramLong4, paramLong5, paramLong6);
    if (!Objects.equals(paramString, this.fic))
    {
      this.fgh = new int[b.b.values().length];
      this.fic = paramString;
      this.fhX[0] = 0L;
      this.fia[0] = 0L;
    }
    this.fge = (((float)this.fge + (paramInt + 1) * this.fhV));
    this.fhY += 1L;
    float f1 = (float)(this.fge - this.fhX[0]);
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
      paramString = this.fgh;
      paramInt = b.b.ffW.index;
      paramString[paramInt] += 1;
      paramString = this.fib;
      paramInt = b.b.ffW.index;
      paramString[paramInt] += 1;
      this.fhZ = this.fhK;
      paramLong1 = this.fhY;
      paramLong2 = this.fia[0];
      if (f1 >= 200.0F)
      {
        f9 = Math.min(this.fhW, (float)(paramLong1 - paramLong2) * 1000.0F / f1);
        paramString = this.fhS;
        paramInt = this.fhZ;
        n = this.fgh[b.b.ffZ.index];
        i1 = this.fgh[b.b.ffY.index];
        i2 = this.fgh[b.b.ffX.index];
        i3 = this.fgh[b.b.ffW.index];
        i = this.fib[b.b.ffZ.index];
        j = this.fib[b.b.ffY.index];
        k = this.fib[b.b.ffX.index];
        m = this.fib[b.b.ffW.index];
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
      mainHandler.post(new a.4(this, paramString, f9, paramInt, str11, str5, str1, str2, str3, str4, str10, str6, str7, str8, str9));
      this.fhZ = this.fhG;
      this.fhX[0] = this.fge;
      this.fia[0] = this.fhY;
      mainHandler.removeCallbacks(this.fid);
      mainHandler.postDelayed(this.fid, 250L);
      return;
      if (paramInt >= 24)
      {
        paramString = this.fgh;
        paramInt = b.b.ffX.index;
        paramString[paramInt] += 1;
        paramString = this.fib;
        paramInt = b.b.ffX.index;
        paramString[paramInt] += 1;
        if (this.fhZ == this.fhK) {
          break;
        }
        this.fhZ = this.fhJ;
        break;
      }
      if (paramInt >= 9)
      {
        paramString = this.fgh;
        paramInt = b.b.ffY.index;
        paramString[paramInt] += 1;
        paramString = this.fib;
        paramInt = b.b.ffY.index;
        paramString[paramInt] += 1;
        if ((this.fhZ == this.fhK) || (this.fhZ == this.fhJ)) {
          break;
        }
        this.fhZ = this.fhI;
        break;
      }
      if (paramInt >= 3)
      {
        paramString = this.fgh;
        paramInt = b.b.ffZ.index;
        paramString[paramInt] += 1;
        paramString = this.fib;
        paramInt = b.b.ffZ.index;
        paramString[paramInt] += 1;
        if ((this.fhZ == this.fhK) || (this.fhZ == this.fhJ) || (this.fhZ == this.fhI)) {
          break;
        }
        this.fhZ = this.fhH;
        break;
      }
      paramString = this.fgh;
      paramInt = b.b.fga.index;
      paramString[paramInt] += 1;
      paramString = this.fib;
      paramInt = b.b.fga.index;
      paramString[paramInt] += 1;
      if ((this.fhZ == this.fhK) || (this.fhZ == this.fhJ) || (this.fhZ == this.fhI) || (this.fhZ == this.fhH)) {
        break;
      }
      this.fhZ = this.fhG;
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
    if (!this.egk) {
      return;
    }
    mainHandler.post(new Runnable()
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
  
  public final Executor hI()
  {
    return this.executor;
  }
  
  public final void hn(String paramString)
  {
    if (this.fhS != null)
    {
      TextView localTextView = (TextView)this.fhS.findViewById(a.b.extra_info);
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
    }
  }
  
  public final void onForeground(final boolean paramBoolean)
  {
    com.tencent.matrix.e.c.i("Matrix.FrameDecorator", "[onForeground] isForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!this.egk) {}
    while (mainHandler == null) {
      return;
    }
    mainHandler.post(new Runnable()
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
    if (!this.egk) {
      return;
    }
    mainHandler.post(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.trace.view.a
 * JD-Core Version:    0.7.0.1
 */