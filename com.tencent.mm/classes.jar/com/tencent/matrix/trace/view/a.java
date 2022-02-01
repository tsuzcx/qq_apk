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
import java.util.Objects;
import java.util.concurrent.Executor;

public final class a
  extends com.tencent.matrix.trace.e.b
  implements com.tencent.matrix.b.b
{
  private static Handler aAO = new Handler(Looper.getMainLooper());
  private static a cBV;
  private static final Object lock = new Object();
  private DisplayMetrics aHC = new DisplayMetrics();
  private long cAM;
  private int[] cAP = new int[c.a.values().length];
  private int cBI;
  private int cBJ;
  private int cBK;
  private int cBL;
  private int cBM;
  private WindowManager.LayoutParams cBS;
  public boolean cBT;
  private FloatFrameView cBU;
  public View.OnClickListener cBW;
  public boolean cBX = true;
  private float cBY = 1.0F * (float)com.tencent.matrix.trace.core.b.HF().cpI / 1000000.0F;
  private long[] cBZ = new long[1];
  private long cCa;
  private int cCb = this.cBI;
  private long[] cCc = new long[1];
  private int[] cCd = new int[c.a.values().length];
  private String cCe = "default";
  private Runnable cCf = new Runnable()
  {
    public final void run()
    {
      a.f(a.this).cBk.setText("60.00 FPS");
      a.f(a.this).cBk.setTextColor(a.f(a.this).getResources().getColor(2131100532));
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
    this.cBU = paramFloatFrameView;
    this.cBI = paramContext.getResources().getColor(2131100532);
    this.cBJ = paramContext.getResources().getColor(2131100536);
    this.cBK = paramContext.getResources().getColor(2131100535);
    this.cBL = paramContext.getResources().getColor(2131100534);
    this.cBM = paramContext.getResources().getColor(2131100533);
    com.tencent.matrix.a.cqa.a(this);
    paramFloatFrameView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "onViewAttachedToWindow", new Object[0]);
        if (com.tencent.matrix.b.Gp())
        {
          paramAnonymousView = (com.tencent.matrix.trace.a)com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.cyD.a(a.this);
          }
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "onViewDetachedFromWindow", new Object[0]);
        if (com.tencent.matrix.b.Gp())
        {
          paramAnonymousView = (com.tencent.matrix.trace.a)com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.cyD.b(a.this);
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
          this.windowManager.getDefaultDisplay().getMetrics(this.aHC);
          this.windowManager.getDefaultDisplay().getMetrics(paramContext);
        }
        this.cBS = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT < 26) {
          continue;
        }
        this.cBS.type = 2038;
        this.cBS.flags = 40;
        this.cBS.gravity = 8388659;
        if (this.cBU != null) {
          this.cBS.x = (paramContext.widthPixels - this.cBU.getLayoutParams().width * 2);
        }
        this.cBS.y = 0;
        this.cBS.width = -2;
        this.cBS.height = -2;
        this.cBS.format = -2;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      paramFloatFrameView.setOnTouchListener(new View.OnTouchListener()
      {
        float cCh = 0.0F;
        float cCi = 0.0F;
        int cCj = 0;
        int cCk = 0;
        
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
              this.cCh = paramAnonymousMotionEvent.getX();
              this.cCi = paramAnonymousMotionEvent.getY();
              this.cCj = a.a(a.this).x;
              this.cCk = a.a(a.this).y;
              return true;
              float f2 = paramAnonymousMotionEvent.getX();
              float f1 = paramAnonymousMotionEvent.getY();
              paramAnonymousMotionEvent = a.a(a.this);
              float f3 = paramAnonymousMotionEvent.x;
              paramAnonymousMotionEvent.x = ((int)((f2 - this.cCh) / 3.0F + f3));
              paramAnonymousMotionEvent = a.a(a.this);
              f2 = paramAnonymousMotionEvent.y;
              paramAnonymousMotionEvent.y = ((int)((f1 - this.cCi) / 3.0F + f2));
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
            if ((Math.abs(i - this.cCj) > 20) || (Math.abs(j - this.cCk) > 20) || (a.e(a.this) == null)) {
              break;
            }
            a.e(a.this).onClick(paramAnonymousView);
            return true;
          }
        }
      });
      return;
      this.cBS.type = 2002;
    }
  }
  
  public static a aN(Context paramContext)
  {
    if (cBV == null)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label41;
      }
      cBV = new a(paramContext, new FloatFrameView(paramContext));
    }
    for (;;)
    {
      return cBV;
      try
      {
        synchronized (lock)
        {
          label41:
          aAO.post(new Runnable()
          {
            public final void run()
            {
              a.h(new a(this.val$context, new FloatFrameView(this.val$context), (byte)0));
              synchronized (a.HS())
              {
                a.HS().notifyAll();
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
    if (!Objects.equals(paramString, this.cCe))
    {
      this.cAP = new int[c.a.values().length];
      this.cCe = paramString;
      this.cBZ[0] = 0L;
      this.cCc[0] = 0L;
    }
    this.cAM = (((float)this.cAM + (paramInt + 1) * this.cBY));
    this.cCa += 1L;
    float f1 = (float)(this.cAM - this.cBZ[0]);
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
      paramString = this.cAP;
      paramInt = c.a.cAE.index;
      paramString[paramInt] += 1;
      paramString = this.cCd;
      paramInt = c.a.cAE.index;
      paramString[paramInt] += 1;
      this.cCb = this.cBM;
      paramLong1 = this.cCa;
      paramLong2 = this.cCc[0];
      if (f1 >= 200.0F)
      {
        f9 = Math.min(60.0F, (float)(paramLong1 - paramLong2) * 1000.0F / f1);
        paramString = this.cBU;
        paramInt = this.cCb;
        n = this.cAP[c.a.cAH.index];
        i1 = this.cAP[c.a.cAG.index];
        i2 = this.cAP[c.a.cAF.index];
        i3 = this.cAP[c.a.cAE.index];
        i = this.cCd[c.a.cAH.index];
        j = this.cCd[c.a.cAG.index];
        k = this.cCd[c.a.cAF.index];
        m = this.cCd[c.a.cAE.index];
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
      aAO.post(new a.4(this, paramString, f9, paramInt, str11, str5, str1, str2, str3, str4, str10, str6, str7, str8, str9));
      this.cCb = this.cBI;
      this.cBZ[0] = this.cAM;
      this.cCc[0] = this.cCa;
      aAO.removeCallbacks(this.cCf);
      aAO.postDelayed(this.cCf, 250L);
      return;
      if (paramInt >= 24)
      {
        paramString = this.cAP;
        paramInt = c.a.cAF.index;
        paramString[paramInt] += 1;
        paramString = this.cCd;
        paramInt = c.a.cAF.index;
        paramString[paramInt] += 1;
        if (this.cCb == this.cBM) {
          break;
        }
        this.cCb = this.cBL;
        break;
      }
      if (paramInt >= 9)
      {
        paramString = this.cAP;
        paramInt = c.a.cAG.index;
        paramString[paramInt] += 1;
        paramString = this.cCd;
        paramInt = c.a.cAG.index;
        paramString[paramInt] += 1;
        if ((this.cCb == this.cBM) || (this.cCb == this.cBL)) {
          break;
        }
        this.cCb = this.cBK;
        break;
      }
      if (paramInt >= 3)
      {
        paramString = this.cAP;
        paramInt = c.a.cAH.index;
        paramString[paramInt] += 1;
        paramString = this.cCd;
        paramInt = c.a.cAH.index;
        paramString[paramInt] += 1;
        if ((this.cCb == this.cBM) || (this.cCb == this.cBL) || (this.cCb == this.cBK)) {
          break;
        }
        this.cCb = this.cBJ;
        break;
      }
      paramString = this.cAP;
      paramInt = c.a.cAI.index;
      paramString[paramInt] += 1;
      paramString = this.cCd;
      paramInt = c.a.cAI.index;
      paramString[paramInt] += 1;
      if ((this.cCb == this.cBM) || (this.cCb == this.cBL) || (this.cCb == this.cBK) || (this.cCb == this.cBJ)) {
        break;
      }
      this.cCb = this.cBI;
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
  
  public final void cY(String paramString)
  {
    if (this.cBU != null)
    {
      TextView localTextView = (TextView)this.cBU.findViewById(2131299636);
      if (localTextView != null) {
        localTextView.setText(paramString);
      }
    }
  }
  
  public final void dismiss()
  {
    if (!this.cBX) {
      return;
    }
    aAO.post(new Runnable()
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
  
  public final Executor getExecutor()
  {
    return this.executor;
  }
  
  public final void onForeground(final boolean paramBoolean)
  {
    com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "[onForeground] isForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!this.cBX) {}
    while (aAO == null) {
      return;
    }
    aAO.post(new Runnable()
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
    if (!this.cBX) {
      return;
    }
    aAO.post(new Runnable()
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