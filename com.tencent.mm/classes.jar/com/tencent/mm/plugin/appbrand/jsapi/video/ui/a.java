package com.tencent.mm.plugin.appbrand.jsapi.video.ui;

import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.l;

public final class a
{
  int MG;
  float lnw;
  View lwK;
  a lwL;
  private GestureDetector lwM;
  b lwN;
  private float lwO;
  int lwP;
  int lwQ;
  Runnable lwR;
  Context mContext;
  
  public a(Context paramContext, View paramView, b paramb)
  {
    AppMethodBeat.i(211483);
    this.lwL = a.lwT;
    this.lnw = 0.0F;
    this.MG = 0;
    this.lwO = 0.0F;
    this.lwP = -1;
    this.lwQ = 0;
    this.lwR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211474);
        a.this.lwN.bnF();
        AppMethodBeat.o(211474);
      }
    };
    this.mContext = paramContext;
    this.lwN = paramb;
    this.lwK = paramView;
    this.lwM = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211479);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(211479);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211476);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        a.this.lwK.removeCallbacks(a.this.lwR);
        a.this.lwN.bnG();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(211476);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211478);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(211478);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(211477);
        if ((paramAnonymousMotionEvent1 == null) || (paramAnonymousMotionEvent2 == null))
        {
          AppMethodBeat.o(211477);
          return true;
        }
        if (a.this.lwL == a.a.lwT)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label112;
          }
          a.this.lwL = a.a.lwW;
        }
        float f;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = a.this;
          if (paramAnonymousMotionEvent1.lwL != a.a.lwW) {
            break label217;
          }
          if (paramAnonymousMotionEvent1.lwN.bnM()) {
            break;
          }
          AppMethodBeat.o(211477);
          return false;
          label112:
          if (paramAnonymousMotionEvent1.getX() < a.this.lwK.getMeasuredWidth() / 2) {
            a.this.lwL = a.a.lwV;
          } else {
            a.this.lwL = a.a.lwU;
          }
        }
        if (paramAnonymousMotionEvent1.lwP == -1)
        {
          paramAnonymousMotionEvent1.lwN.bnH();
          paramAnonymousMotionEvent1.lwP = paramAnonymousMotionEvent1.lwN.getCurrentPosition();
        }
        paramAnonymousMotionEvent1.lwQ = paramAnonymousMotionEvent1.lwN.k(paramAnonymousMotionEvent1.lwP, paramAnonymousFloat1 - paramAnonymousFloat2);
        AppMethodBeat.o(211477);
        return true;
        label217:
        if (paramAnonymousMotionEvent1.lwL == a.a.lwV)
        {
          if (!paramAnonymousMotionEvent1.lwN.bnK())
          {
            AppMethodBeat.o(211477);
            return false;
          }
          paramAnonymousFloat2 = f * -1.0F / paramAnonymousMotionEvent1.lwK.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.lnw;
          if (paramAnonymousFloat2 < 0.0F) {
            paramAnonymousFloat1 = 0.0F;
          }
          for (;;)
          {
            l.b(paramAnonymousMotionEvent1.mContext, paramAnonymousFloat1);
            paramAnonymousMotionEvent1.lwN.aD(paramAnonymousFloat1);
            AppMethodBeat.o(211477);
            return true;
            paramAnonymousFloat1 = paramAnonymousFloat2;
            if (paramAnonymousFloat2 > 1.0F) {
              paramAnonymousFloat1 = 1.0F;
            }
          }
        }
        int j;
        int i;
        if (paramAnonymousMotionEvent1.lwL == a.a.lwU)
        {
          if (!paramAnonymousMotionEvent1.lwN.bnL())
          {
            AppMethodBeat.o(211477);
            return false;
          }
          paramAnonymousFloat1 = f * -1.0F;
          paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousMotionEvent1.lwK.getMeasuredHeight();
          paramAnonymousMotionEvent2 = (AudioManager)paramAnonymousMotionEvent1.mContext.getSystemService("audio");
          j = paramAnonymousMotionEvent2.getStreamMaxVolume(3);
          paramAnonymousFloat2 = 1.2F * (paramAnonymousFloat2 * j);
          i = (int)paramAnonymousFloat2;
          if ((i != 0) || (Math.abs(paramAnonymousFloat2) <= 0.2F)) {
            break label513;
          }
          if (paramAnonymousFloat1 > 0.0F) {
            i = 1;
          }
        }
        label513:
        for (;;)
        {
          int k = i + paramAnonymousMotionEvent1.MG;
          if (k < 0) {
            i = 0;
          }
          for (;;)
          {
            com.tencent.mm.compatible.b.a.b(paramAnonymousMotionEvent2, 3, i);
            paramAnonymousFloat1 = i / j;
            paramAnonymousMotionEvent1.lwN.aC(paramAnonymousFloat1);
            AppMethodBeat.o(211477);
            return true;
            if (paramAnonymousFloat1 >= 0.0F) {
              break label513;
            }
            i = -1;
            break;
            i = k;
            if (k >= j) {
              i = j;
            }
          }
          AppMethodBeat.o(211477);
          return true;
        }
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(211475);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        a.this.lwK.postDelayed(a.this.lwR, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(211475);
        return true;
      }
    });
    this.lnw = l.dA(paramContext);
    AppMethodBeat.o(211483);
  }
  
  private void bpu()
  {
    AppMethodBeat.i(211485);
    this.MG = ((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(3);
    this.lnw = l.dA(this.mContext);
    AppMethodBeat.o(211485);
  }
  
  public final void bpt()
  {
    this.lwP = -1;
    this.lwQ = 0;
    this.lwO = 0.0F;
  }
  
  public final void w(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(211484);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.lwO = paramMotionEvent.getRawX();
      bpu();
    }
    GestureDetector localGestureDetector = this.lwM;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahE(), "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((i == 1) || (i == 3))
    {
      if (this.lwL != a.lwW) {
        break label165;
      }
      this.lwN.l(this.lwQ, paramMotionEvent.getRawX() - this.lwO);
      this.lwP = -1;
      this.lwQ = 0;
      this.lwO = 0.0F;
    }
    for (;;)
    {
      this.lwL = a.lwT;
      AppMethodBeat.o(211484);
      return;
      label165:
      if (this.lwL == a.lwU)
      {
        ((AudioManager)this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
        this.lwN.bnI();
      }
      else if (this.lwL == a.lwV)
      {
        this.lwN.bnJ();
      }
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(211482);
      lwT = new a("None", 0);
      lwU = new a("Volume", 1);
      lwV = new a("Brightness", 2);
      lwW = new a("FastBackwardOrForward", 3);
      lwX = new a[] { lwT, lwU, lwV, lwW };
      AppMethodBeat.o(211482);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void aC(float paramFloat);
    
    public abstract void aD(float paramFloat);
    
    public abstract void bnF();
    
    public abstract void bnG();
    
    public abstract void bnH();
    
    public abstract void bnI();
    
    public abstract void bnJ();
    
    public abstract boolean bnK();
    
    public abstract boolean bnL();
    
    public abstract boolean bnM();
    
    public abstract int getCurrentPosition();
    
    public abstract int k(int paramInt, float paramFloat);
    
    public abstract void l(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.ui.a
 * JD-Core Version:    0.7.0.1
 */