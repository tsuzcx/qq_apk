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
import android.os.HandlerThread;
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
import java.util.LinkedList;

public final class a
  extends com.tencent.matrix.trace.e.b
  implements com.tencent.matrix.b.a
{
  private static Handler bTu = new Handler(Looper.getMainLooper());
  private static a bTv;
  private static Object lock = new Object();
  long bSB;
  long bTA;
  long[] bTB = new long[1];
  Runnable bTC = new Runnable()
  {
    public final void run()
    {
      a.f(a.this).bSW.setText("60.00 FPS");
      a.f(a.this).bSW.setTextColor(a.f(a.this).getResources().getColor(17170453));
    }
  };
  private WindowManager bTq;
  private WindowManager.LayoutParams bTr;
  private boolean bTs;
  private FloatFrameView bTt;
  public View.OnClickListener bTw;
  private DisplayMetrics bTx = new DisplayMetrics();
  public boolean bTy = true;
  long[] bTz = new long[1];
  private Handler handler;
  
  @SuppressLint({"ClickableViewAccessibility"})
  private a(Context paramContext, final FloatFrameView paramFloatFrameView)
  {
    this.bTt = paramFloatFrameView;
    com.tencent.matrix.a.bLP.a(this);
    paramFloatFrameView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView)
      {
        com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "onViewAttachedToWindow", new Object[0]);
        if (com.tencent.matrix.b.isInstalled())
        {
          paramAnonymousView = (com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.bQQ.a(a.this);
          }
        }
      }
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "onViewDetachedFromWindow", new Object[0]);
        if (com.tencent.matrix.b.isInstalled())
        {
          paramAnonymousView = (com.tencent.matrix.trace.b)com.tencent.matrix.b.yD().z(com.tencent.matrix.trace.b.class);
          if (paramAnonymousView != null) {
            paramAnonymousView.bQQ.b(a.this);
          }
        }
      }
    });
    this.bTq = ((WindowManager)paramContext.getApplicationContext().getSystemService("window"));
    for (;;)
    {
      try
      {
        this.bTq.getDefaultDisplay().getMetrics(this.bTx);
        paramContext = new DisplayMetrics();
        this.bTq.getDefaultDisplay().getMetrics(paramContext);
        this.bTr = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT < 26) {
          continue;
        }
        this.bTr.type = 2038;
        this.bTr.flags = 40;
        this.bTr.gravity = 8388659;
        this.bTr.x = (paramContext.widthPixels - this.bTt.getLayoutParams().width * 2);
        this.bTr.y = 0;
        this.bTr.width = -2;
        this.bTr.height = -2;
        this.bTr.format = -2;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      paramFloatFrameView.setOnTouchListener(new View.OnTouchListener()
      {
        float bTE = 0.0F;
        float bTF = 0.0F;
        int bTG = 0;
        int bTH = 0;
        
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
              this.bTE = paramAnonymousMotionEvent.getX();
              this.bTF = paramAnonymousMotionEvent.getY();
              this.bTG = a.a(a.this).x;
              this.bTH = a.a(a.this).y;
              return true;
              float f2 = paramAnonymousMotionEvent.getX();
              float f1 = paramAnonymousMotionEvent.getY();
              paramAnonymousMotionEvent = a.a(a.this);
              float f3 = paramAnonymousMotionEvent.x;
              paramAnonymousMotionEvent.x = ((int)((f2 - this.bTE) / 3.0F + f3));
              paramAnonymousMotionEvent = a.a(a.this);
              f2 = paramAnonymousMotionEvent.y;
              paramAnonymousMotionEvent.y = ((int)((f1 - this.bTF) / 3.0F + f2));
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
            if ((Math.abs(i - this.bTG) > 20) || (Math.abs(j - this.bTH) > 20) || (a.e(a.this) == null)) {
              break;
            }
            a.e(a.this).onClick(paramAnonymousView);
            return true;
          }
        }
      });
      return;
      this.bTr.type = 2002;
    }
  }
  
  public static a aB(Context arg0)
  {
    if (bTv == null)
    {
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label41;
      }
      bTv = new a(???, new FloatFrameView(???));
    }
    for (;;)
    {
      return bTv;
      try
      {
        label41:
        bTu.post(new Runnable()
        {
          public final void run()
          {
            a.g(new a(this.val$context, new FloatFrameView(this.val$context), (byte)0));
            synchronized (a.lock)
            {
              a.lock.notifyAll();
              return;
            }
          }
        });
        synchronized (lock)
        {
          lock.wait();
        }
      }
      catch (InterruptedException ???) {}
    }
  }
  
  public final void a(final String paramString, long paramLong, int paramInt)
  {
    super.a(paramString, paramLong, paramInt);
    this.bSB += (paramInt + 1) * com.tencent.matrix.trace.core.b.zt().bLF / 1000000L;
    this.bTA += 1L;
    paramLong = this.bSB - this.bTz[0];
    long l1 = this.bTA;
    long l2 = this.bTB[0];
    if (paramLong >= 200L)
    {
      final float f = Math.min(60.0F, (float)(l1 - l2) * 1000.0F / (float)paramLong);
      paramString = this.bTt.bSW;
      bTu.post(new Runnable()
      {
        public final void run()
        {
          paramString.setText(String.format("%.2f FPS", new Object[] { Float.valueOf(f) }));
          if (f >= 50.0F)
          {
            paramString.setTextColor(paramString.getResources().getColor(17170453));
            return;
          }
          if (f >= 30.0F)
          {
            paramString.setTextColor(paramString.getResources().getColor(17170457));
            return;
          }
          paramString.setTextColor(paramString.getResources().getColor(17170455));
        }
      });
      paramString = this.bTt.bSX;
      FloatFrameView.LineChartView.a locala = new FloatFrameView.LineChartView.a(paramString, (int)f);
      if (paramString.bTb.size() >= 75) {
        paramString.bTb.removeLast();
      }
      paramString.bTb.addFirst(locala);
      paramString.postInvalidate();
      this.bTz[0] = this.bSB;
      this.bTB[0] = this.bTA;
      bTu.removeCallbacks(this.bTC);
      bTu.postDelayed(this.bTC, 130L);
    }
  }
  
  public final void dismiss()
  {
    if (!this.bTy) {
      return;
    }
    bTu.post(new Runnable()
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
  
  public final Handler getHandler()
  {
    if ((this.handler == null) || (!this.handler.getLooper().getThread().isAlive())) {
      this.handler = new Handler(com.tencent.matrix.g.b.zI().getLooper());
    }
    return this.handler;
  }
  
  public final void onForeground(final boolean paramBoolean)
  {
    com.tencent.matrix.g.c.i("Matrix.FrameDecorator", "[onForeground] isForeground:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!this.bTy) {}
    while (bTu == null) {
      return;
    }
    bTu.post(new Runnable()
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
    if (!this.bTy) {
      return;
    }
    bTu.post(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.view.a
 * JD-Core Version:    0.7.0.1
 */