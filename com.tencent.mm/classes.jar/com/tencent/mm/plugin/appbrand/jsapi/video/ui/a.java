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
  int MQ;
  Context mContext;
  View mDH;
  a mDI;
  private GestureDetector mDJ;
  b mDK;
  private float mDL;
  int mDM;
  int mDN;
  Runnable mDO;
  float mue;
  
  public a(Context paramContext, View paramView, b paramb)
  {
    AppMethodBeat.i(235160);
    this.mDI = a.mDQ;
    this.mue = 0.0F;
    this.MQ = 0;
    this.mDL = 0.0F;
    this.mDM = -1;
    this.mDN = 0;
    this.mDO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235151);
        a.this.mDK.bJj();
        AppMethodBeat.o(235151);
      }
    };
    this.mContext = paramContext;
    this.mDK = paramb;
    this.mDH = paramView;
    this.mDJ = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(235156);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(235156);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(235153);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        a.this.mDH.removeCallbacks(a.this.mDO);
        a.this.mDK.bJk();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(235153);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(235155);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(235155);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(235154);
        if ((paramAnonymousMotionEvent1 == null) || (paramAnonymousMotionEvent2 == null))
        {
          AppMethodBeat.o(235154);
          return true;
        }
        if (a.this.mDI == a.a.mDQ)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label112;
          }
          a.this.mDI = a.a.mDT;
        }
        float f;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = a.this;
          if (paramAnonymousMotionEvent1.mDI != a.a.mDT) {
            break label217;
          }
          if (paramAnonymousMotionEvent1.mDK.bJq()) {
            break;
          }
          AppMethodBeat.o(235154);
          return false;
          label112:
          if (paramAnonymousMotionEvent1.getX() < a.this.mDH.getMeasuredWidth() / 2) {
            a.this.mDI = a.a.mDS;
          } else {
            a.this.mDI = a.a.mDR;
          }
        }
        if (paramAnonymousMotionEvent1.mDM == -1)
        {
          paramAnonymousMotionEvent1.mDK.bJl();
          paramAnonymousMotionEvent1.mDM = paramAnonymousMotionEvent1.mDK.getCurrentPosition();
        }
        paramAnonymousMotionEvent1.mDN = paramAnonymousMotionEvent1.mDK.k(paramAnonymousMotionEvent1.mDM, paramAnonymousFloat1 - paramAnonymousFloat2);
        AppMethodBeat.o(235154);
        return true;
        label217:
        if (paramAnonymousMotionEvent1.mDI == a.a.mDS)
        {
          if (!paramAnonymousMotionEvent1.mDK.bJo())
          {
            AppMethodBeat.o(235154);
            return false;
          }
          paramAnonymousFloat2 = f * -1.0F / paramAnonymousMotionEvent1.mDH.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.mue;
          if (paramAnonymousFloat2 < 0.0F) {
            paramAnonymousFloat1 = 0.0F;
          }
          for (;;)
          {
            l.b(paramAnonymousMotionEvent1.mContext, paramAnonymousFloat1);
            paramAnonymousMotionEvent1.mDK.aN(paramAnonymousFloat1);
            AppMethodBeat.o(235154);
            return true;
            paramAnonymousFloat1 = paramAnonymousFloat2;
            if (paramAnonymousFloat2 > 1.0F) {
              paramAnonymousFloat1 = 1.0F;
            }
          }
        }
        int j;
        int i;
        if (paramAnonymousMotionEvent1.mDI == a.a.mDR)
        {
          if (!paramAnonymousMotionEvent1.mDK.bJp())
          {
            AppMethodBeat.o(235154);
            return false;
          }
          paramAnonymousFloat1 = f * -1.0F;
          paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousMotionEvent1.mDH.getMeasuredHeight();
          paramAnonymousMotionEvent2 = (AudioManager)paramAnonymousMotionEvent1.mContext.getSystemService("audio");
          j = paramAnonymousMotionEvent2.getStreamMaxVolume(3);
          paramAnonymousFloat2 = 1.2F * (paramAnonymousFloat2 * j);
          i = (int)paramAnonymousFloat2;
          if ((i != 0) || (Math.abs(paramAnonymousFloat2) <= 0.2F)) {
            break label514;
          }
          if (paramAnonymousFloat1 > 0.0F) {
            i = 1;
          }
        }
        label514:
        for (;;)
        {
          int k = i + paramAnonymousMotionEvent1.MQ;
          if (k < 0) {
            i = 0;
          }
          for (;;)
          {
            com.tencent.mm.compatible.b.a.a(paramAnonymousMotionEvent2, 3, i, 0);
            paramAnonymousFloat1 = i / j;
            paramAnonymousMotionEvent1.mDK.aM(paramAnonymousFloat1);
            AppMethodBeat.o(235154);
            return true;
            if (paramAnonymousFloat1 >= 0.0F) {
              break label514;
            }
            i = -1;
            break;
            i = k;
            if (k >= j) {
              i = j;
            }
          }
          AppMethodBeat.o(235154);
          return true;
        }
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(235152);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        a.this.mDH.postDelayed(a.this.mDO, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(235152);
        return true;
      }
    });
    this.mue = l.dV(paramContext);
    AppMethodBeat.o(235160);
  }
  
  private void bLa()
  {
    AppMethodBeat.i(235162);
    this.MQ = ((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(3);
    this.mue = l.dV(this.mContext);
    AppMethodBeat.o(235162);
  }
  
  public final void A(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235161);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.mDL = paramMotionEvent.getRawX();
      bLa();
    }
    GestureDetector localGestureDetector = this.mDJ;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((i == 1) || (i == 3))
    {
      if (this.mDI != a.mDT) {
        break label165;
      }
      this.mDK.l(this.mDN, paramMotionEvent.getRawX() - this.mDL);
      this.mDM = -1;
      this.mDN = 0;
      this.mDL = 0.0F;
    }
    for (;;)
    {
      this.mDI = a.mDQ;
      AppMethodBeat.o(235161);
      return;
      label165:
      if (this.mDI == a.mDR)
      {
        ((AudioManager)this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
        this.mDK.bJm();
      }
      else if (this.mDI == a.mDS)
      {
        this.mDK.bJn();
      }
    }
  }
  
  public final void bKZ()
  {
    this.mDM = -1;
    this.mDN = 0;
    this.mDL = 0.0F;
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(235159);
      mDQ = new a("None", 0);
      mDR = new a("Volume", 1);
      mDS = new a("Brightness", 2);
      mDT = new a("FastBackwardOrForward", 3);
      mDU = new a[] { mDQ, mDR, mDS, mDT };
      AppMethodBeat.o(235159);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void aM(float paramFloat);
    
    public abstract void aN(float paramFloat);
    
    public abstract void bJj();
    
    public abstract void bJk();
    
    public abstract void bJl();
    
    public abstract void bJm();
    
    public abstract void bJn();
    
    public abstract boolean bJo();
    
    public abstract boolean bJp();
    
    public abstract boolean bJq();
    
    public abstract int getCurrentPosition();
    
    public abstract int k(int paramInt, float paramFloat);
    
    public abstract void l(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.ui.a
 * JD-Core Version:    0.7.0.1
 */