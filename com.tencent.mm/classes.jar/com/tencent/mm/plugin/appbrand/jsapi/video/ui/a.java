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
  float ljJ;
  View lsl;
  a lsm;
  private GestureDetector lsn;
  b lso;
  private float lsp;
  int lsq;
  int lsr;
  Runnable lss;
  Context mContext;
  
  public a(Context paramContext, View paramView, b paramb)
  {
    AppMethodBeat.i(206453);
    this.lsm = a.lsu;
    this.ljJ = 0.0F;
    this.MG = 0;
    this.lsp = 0.0F;
    this.lsq = -1;
    this.lsr = 0;
    this.lss = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206444);
        a.this.lso.bmV();
        AppMethodBeat.o(206444);
      }
    };
    this.mContext = paramContext;
    this.lso = paramb;
    this.lsl = paramView;
    this.lsn = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(206449);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(206449);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(206446);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        a.this.lsl.removeCallbacks(a.this.lss);
        a.this.lso.bmW();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(206446);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(206448);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(206448);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(206447);
        if ((paramAnonymousMotionEvent1 == null) || (paramAnonymousMotionEvent2 == null))
        {
          AppMethodBeat.o(206447);
          return true;
        }
        if (a.this.lsm == a.a.lsu)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label112;
          }
          a.this.lsm = a.a.lsx;
        }
        float f;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = a.this;
          if (paramAnonymousMotionEvent1.lsm != a.a.lsx) {
            break label217;
          }
          if (paramAnonymousMotionEvent1.lso.bnc()) {
            break;
          }
          AppMethodBeat.o(206447);
          return false;
          label112:
          if (paramAnonymousMotionEvent1.getX() < a.this.lsl.getMeasuredWidth() / 2) {
            a.this.lsm = a.a.lsw;
          } else {
            a.this.lsm = a.a.lsv;
          }
        }
        if (paramAnonymousMotionEvent1.lsq == -1)
        {
          paramAnonymousMotionEvent1.lso.bmX();
          paramAnonymousMotionEvent1.lsq = paramAnonymousMotionEvent1.lso.getCurrentPosition();
        }
        paramAnonymousMotionEvent1.lsr = paramAnonymousMotionEvent1.lso.k(paramAnonymousMotionEvent1.lsq, paramAnonymousFloat1 - paramAnonymousFloat2);
        AppMethodBeat.o(206447);
        return true;
        label217:
        if (paramAnonymousMotionEvent1.lsm == a.a.lsw)
        {
          if (!paramAnonymousMotionEvent1.lso.bna())
          {
            AppMethodBeat.o(206447);
            return false;
          }
          paramAnonymousFloat2 = f * -1.0F / paramAnonymousMotionEvent1.lsl.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.ljJ;
          if (paramAnonymousFloat2 < 0.0F) {
            paramAnonymousFloat1 = 0.0F;
          }
          for (;;)
          {
            l.b(paramAnonymousMotionEvent1.mContext, paramAnonymousFloat1);
            paramAnonymousMotionEvent1.lso.aD(paramAnonymousFloat1);
            AppMethodBeat.o(206447);
            return true;
            paramAnonymousFloat1 = paramAnonymousFloat2;
            if (paramAnonymousFloat2 > 1.0F) {
              paramAnonymousFloat1 = 1.0F;
            }
          }
        }
        int j;
        int i;
        if (paramAnonymousMotionEvent1.lsm == a.a.lsv)
        {
          if (!paramAnonymousMotionEvent1.lso.bnb())
          {
            AppMethodBeat.o(206447);
            return false;
          }
          paramAnonymousFloat1 = f * -1.0F;
          paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousMotionEvent1.lsl.getMeasuredHeight();
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
            paramAnonymousMotionEvent1.lso.aC(paramAnonymousFloat1);
            AppMethodBeat.o(206447);
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
          AppMethodBeat.o(206447);
          return true;
        }
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(206445);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        a.this.lsl.postDelayed(a.this.lss, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(206445);
        return true;
      }
    });
    this.ljJ = l.dw(paramContext);
    AppMethodBeat.o(206453);
  }
  
  private void boK()
  {
    AppMethodBeat.i(206455);
    this.MG = ((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(3);
    this.ljJ = l.dw(this.mContext);
    AppMethodBeat.o(206455);
  }
  
  public final void boJ()
  {
    this.lsq = -1;
    this.lsr = 0;
    this.lsp = 0.0F;
  }
  
  public final void w(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(206454);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.lsp = paramMotionEvent.getRawX();
      boK();
    }
    GestureDetector localGestureDetector = this.lsn;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahp(), "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((i == 1) || (i == 3))
    {
      if (this.lsm != a.lsx) {
        break label165;
      }
      this.lso.l(this.lsr, paramMotionEvent.getRawX() - this.lsp);
      this.lsq = -1;
      this.lsr = 0;
      this.lsp = 0.0F;
    }
    for (;;)
    {
      this.lsm = a.lsu;
      AppMethodBeat.o(206454);
      return;
      label165:
      if (this.lsm == a.lsv)
      {
        ((AudioManager)this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
        this.lso.bmY();
      }
      else if (this.lsm == a.lsw)
      {
        this.lso.bmZ();
      }
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(206452);
      lsu = new a("None", 0);
      lsv = new a("Volume", 1);
      lsw = new a("Brightness", 2);
      lsx = new a("FastBackwardOrForward", 3);
      lsy = new a[] { lsu, lsv, lsw, lsx };
      AppMethodBeat.o(206452);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void aC(float paramFloat);
    
    public abstract void aD(float paramFloat);
    
    public abstract void bmV();
    
    public abstract void bmW();
    
    public abstract void bmX();
    
    public abstract void bmY();
    
    public abstract void bmZ();
    
    public abstract boolean bna();
    
    public abstract boolean bnb();
    
    public abstract boolean bnc();
    
    public abstract int getCurrentPosition();
    
    public abstract int k(int paramInt, float paramFloat);
    
    public abstract void l(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.ui.a
 * JD-Core Version:    0.7.0.1
 */