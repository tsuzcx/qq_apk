package com.tencent.matrix.trace.view;

import android.annotation.SuppressLint;
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
import com.tencent.matrix.trace.f.c.b;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class a
  extends com.tencent.matrix.trace.e.b
  implements com.tencent.matrix.b.a
{
  private static Handler die = new Handler(Looper.getMainLooper());
  private static a dif;
  private static final Object lock = new Object();
  private DisplayMetrics cCm = new DisplayMetrics();
  private long dgV;
  private int[] dgY = new int[c.b.values().length];
  private int dhR;
  private int dhS;
  private int dhT;
  private int dhU;
  private int dhV;
  private WindowManager.LayoutParams dib;
  public boolean dic;
  private FloatFrameView did;
  public View.OnClickListener dig;
  public boolean dih = true;
  private float dii = 1.0F * (float)com.tencent.matrix.trace.core.b.Ya().cQd / 1000000.0F;
  private float dij = Math.round(1000.0F / this.dii);
  private long[] dik = new long[1];
  private long dil;
  private int dim = this.dhR;
  private long[] din = new long[1];
  private int[] dio = new int[c.b.values().length];
  private String dip = "default";
  private Runnable diq = new Runnable()
  {
    public final void run()
    {
      a.g(a.this).dht.setText(String.format("%.2f FPS", new Object[] { Float.valueOf(a.f(a.this)) }));
      a.g(a.this).dht.setTextColor(a.g(a.this).getResources().getColor(a.a.level_best_color));
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
  private a(Context paramContext, FloatFrameView paramFloatFrameView)
  {
    this.did = paramFloatFrameView;
    paramFloatFrameView.dht.setText(String.format("%.2f FPS", new Object[] { Float.valueOf(this.dij) }));
    this.dhR = paramContext.getResources().getColor(a.a.level_best_color);
    this.dhS = paramContext.getResources().getColor(a.a.level_normal_color);
    this.dhT = paramContext.getResources().getColor(a.a.level_middle_color);
    this.dhU = paramContext.getResources().getColor(a.a.level_high_color);
    this.dhV = paramContext.getResources().getColor(a.a.level_frozen_color);
    com.tencent.matrix.a.cQs.a(this);
    paramFloatFrameView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        com.tencent.matrix.e.c.i("Matrix.FrameDecorator", "onViewAttachedToWindow", new Object[0]);
        if (com.tencent.matrix.b.Vt())
        {
          paramAnonymousView = (com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.deH.a(a.this);
          }
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        com.tencent.matrix.e.c.i("Matrix.FrameDecorator", "onViewDetachedFromWindow", new Object[0]);
        if (com.tencent.matrix.b.Vt())
        {
          paramAnonymousView = (com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.deH.b(a.this);
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
          this.windowManager.getDefaultDisplay().getMetrics(this.cCm);
          this.windowManager.getDefaultDisplay().getMetrics(paramContext);
        }
        this.dib = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT < 26) {
          continue;
        }
        this.dib.type = 2038;
        this.dib.flags = 40;
        this.dib.gravity = 8388659;
        if (this.did != null) {
          this.dib.x = (paramContext.widthPixels - this.did.getLayoutParams().width * 2);
        }
        this.dib.y = 0;
        this.dib.width = -2;
        this.dib.height = -2;
        this.dib.format = -2;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      paramFloatFrameView.setOnTouchListener(new a.2(this, paramFloatFrameView));
      return;
      this.dib.type = 2002;
    }
  }
  
  public static a bw(Context paramContext)
  {
    if (dif == null)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label41;
      }
      dif = new a(paramContext, new FloatFrameView(paramContext));
    }
    for (;;)
    {
      return dif;
      try
      {
        synchronized (lock)
        {
          label41:
          die.post(new Runnable()
          {
            public final void run()
            {
              a.i(new a(this.val$context, new FloatFrameView(this.val$context), (byte)0));
              synchronized (a.Yn())
              {
                a.Yn().notifyAll();
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
    if (!Objects.equals(paramString, this.dip))
    {
      this.dgY = new int[c.b.values().length];
      this.dip = paramString;
      this.dik[0] = 0L;
      this.din[0] = 0L;
    }
    this.dgV = (((float)this.dgV + (paramInt + 1) * this.dii));
    this.dil += 1L;
    float f1 = (float)(this.dgV - this.dik[0]);
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
      paramString = this.dgY;
      paramInt = c.b.dgN.index;
      paramString[paramInt] += 1;
      paramString = this.dio;
      paramInt = c.b.dgN.index;
      paramString[paramInt] += 1;
      this.dim = this.dhV;
      paramLong1 = this.dil;
      paramLong2 = this.din[0];
      if (f1 >= 200.0F)
      {
        f9 = Math.min(this.dij, (float)(paramLong1 - paramLong2) * 1000.0F / f1);
        paramString = this.did;
        paramInt = this.dim;
        n = this.dgY[c.b.dgQ.index];
        i1 = this.dgY[c.b.dgP.index];
        i2 = this.dgY[c.b.dgO.index];
        i3 = this.dgY[c.b.dgN.index];
        i = this.dio[c.b.dgQ.index];
        j = this.dio[c.b.dgP.index];
        k = this.dio[c.b.dgO.index];
        m = this.dio[c.b.dgN.index];
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
      die.post(new a.4(this, paramString, f9, paramInt, str11, str5, str1, str2, str3, str4, str10, str6, str7, str8, str9));
      this.dim = this.dhR;
      this.dik[0] = this.dgV;
      this.din[0] = this.dil;
      die.removeCallbacks(this.diq);
      die.postDelayed(this.diq, 250L);
      return;
      if (paramInt >= 24)
      {
        paramString = this.dgY;
        paramInt = c.b.dgO.index;
        paramString[paramInt] += 1;
        paramString = this.dio;
        paramInt = c.b.dgO.index;
        paramString[paramInt] += 1;
        if (this.dim == this.dhV) {
          break;
        }
        this.dim = this.dhU;
        break;
      }
      if (paramInt >= 9)
      {
        paramString = this.dgY;
        paramInt = c.b.dgP.index;
        paramString[paramInt] += 1;
        paramString = this.dio;
        paramInt = c.b.dgP.index;
        paramString[paramInt] += 1;
        if ((this.dim == this.dhV) || (this.dim == this.dhU)) {
          break;
        }
        this.dim = this.dhT;
        break;
      }
      if (paramInt >= 3)
      {
        paramString = this.dgY;
        paramInt = c.b.dgQ.index;
        paramString[paramInt] += 1;
        paramString = this.dio;
        paramInt = c.b.dgQ.index;
        paramString[paramInt] += 1;
        if ((this.dim == this.dhV) || (this.dim == this.dhU) || (this.dim == this.dhT)) {
          break;
        }
        this.dim = this.dhS;
        break;
      }
      paramString = this.dgY;
      paramInt = c.b.dgR.index;
      paramString[paramInt] += 1;
      paramString = this.dio;
      paramInt = c.b.dgR.index;
      paramString[paramInt] += 1;
      if ((this.dim == this.dhV) || (this.dim == this.dhU) || (this.dim == this.dhT) || (this.dim == this.dhS)) {
        break;
      }
      this.dim = this.dhR;
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
    if (!this.dih) {
      return;
    }
    die.post(new Runnable()
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
  
  public final void fL(String paramString)
  {
    if (this.did != null)
    {
      TextView localTextView = (TextView)this.did.findViewById(a.b.extra_info);
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
    com.tencent.matrix.e.c.i("Matrix.FrameDecorator", "[onForeground] isForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!this.dih) {}
    while (die == null) {
      return;
    }
    die.post(new Runnable()
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
    if (!this.dih) {
      return;
    }
    die.post(new Runnable()
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