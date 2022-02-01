package com.tencent.mm.plugin.appbrand.jsapi.video.ui;

import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.k;

public final class a
{
  public int dG;
  public Context mContext;
  public GestureDetector mQj;
  View sIf;
  public a sIg;
  public b sIh;
  public float sIi;
  public int sIj;
  public int sIk;
  Runnable sIl;
  public float sxi;
  
  public a(Context paramContext, View paramView, b paramb)
  {
    AppMethodBeat.i(328142);
    this.sIg = a.sIn;
    this.sxi = 0.0F;
    this.dG = 0;
    this.sIi = 0.0F;
    this.sIj = -1;
    this.sIk = 0;
    this.sIl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(328147);
        a.this.sIh.cvh();
        AppMethodBeat.o(328147);
      }
    };
    this.mContext = paramContext;
    this.sIh = paramb;
    this.sIf = paramView;
    this.mQj = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(328173);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(328173);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(328157);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        a.this.sIf.removeCallbacks(a.this.sIl);
        a.this.sIh.cvi();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(328157);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(328168);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(328168);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(328166);
        if ((paramAnonymousMotionEvent1 == null) || (paramAnonymousMotionEvent2 == null))
        {
          AppMethodBeat.o(328166);
          return true;
        }
        if (a.this.sIg == a.a.sIn)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label112;
          }
          a.this.sIg = a.a.sIq;
        }
        float f;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = a.this;
          if (paramAnonymousMotionEvent1.sIg != a.a.sIq) {
            break label217;
          }
          if (paramAnonymousMotionEvent1.sIh.cvp()) {
            break;
          }
          AppMethodBeat.o(328166);
          return false;
          label112:
          if (paramAnonymousMotionEvent1.getX() < a.this.sIf.getMeasuredWidth() / 2) {
            a.this.sIg = a.a.sIp;
          } else {
            a.this.sIg = a.a.sIo;
          }
        }
        if (paramAnonymousMotionEvent1.sIj == -1)
        {
          paramAnonymousMotionEvent1.sIh.cvj();
          paramAnonymousMotionEvent1.sIj = paramAnonymousMotionEvent1.sIh.getCurrentPosition();
        }
        paramAnonymousMotionEvent1.sIk = paramAnonymousMotionEvent1.sIh.p(paramAnonymousMotionEvent1.sIj, paramAnonymousFloat1 - paramAnonymousFloat2);
        AppMethodBeat.o(328166);
        return true;
        label217:
        if (paramAnonymousMotionEvent1.sIg == a.a.sIp)
        {
          if (!paramAnonymousMotionEvent1.sIh.cvn())
          {
            AppMethodBeat.o(328166);
            return false;
          }
          paramAnonymousFloat2 = f * -1.0F / paramAnonymousMotionEvent1.sIf.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.sxi;
          if (paramAnonymousFloat2 < 0.0F) {
            paramAnonymousFloat1 = 0.0F;
          }
          for (;;)
          {
            k.b(paramAnonymousMotionEvent1.mContext, paramAnonymousFloat1);
            paramAnonymousMotionEvent1.sIh.bL(paramAnonymousFloat1);
            AppMethodBeat.o(328166);
            return true;
            paramAnonymousFloat1 = paramAnonymousFloat2;
            if (paramAnonymousFloat2 > 1.0F) {
              paramAnonymousFloat1 = 1.0F;
            }
          }
        }
        int j;
        int i;
        if (paramAnonymousMotionEvent1.sIg == a.a.sIo)
        {
          if (!paramAnonymousMotionEvent1.sIh.cvo())
          {
            AppMethodBeat.o(328166);
            return false;
          }
          paramAnonymousFloat1 = f * -1.0F;
          paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousMotionEvent1.sIf.getMeasuredHeight();
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
          int k = i + paramAnonymousMotionEvent1.dG;
          if (k < 0) {
            i = 0;
          }
          for (;;)
          {
            com.tencent.mm.compatible.b.a.a(paramAnonymousMotionEvent2, 3, i, 0);
            paramAnonymousFloat1 = i / j;
            paramAnonymousMotionEvent1.sIh.bK(paramAnonymousFloat1);
            AppMethodBeat.o(328166);
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
          AppMethodBeat.o(328166);
          return true;
        }
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(328151);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        a.this.sIf.postDelayed(a.this.sIl, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(328151);
        return true;
      }
    });
    this.sxi = k.eN(paramContext);
    AppMethodBeat.o(328142);
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(328155);
      sIn = new a("None", 0);
      sIo = new a("Volume", 1);
      sIp = new a("Brightness", 2);
      sIq = new a("FastBackwardOrForward", 3);
      sIr = new a[] { sIn, sIo, sIp, sIq };
      AppMethodBeat.o(328155);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void bK(float paramFloat);
    
    public abstract void bL(float paramFloat);
    
    public abstract void cvh();
    
    public abstract void cvi();
    
    public abstract void cvj();
    
    public abstract boolean cvk();
    
    public abstract void cvl();
    
    public abstract void cvm();
    
    public abstract boolean cvn();
    
    public abstract boolean cvo();
    
    public abstract boolean cvp();
    
    public abstract int getCurrentPosition();
    
    public abstract int p(int paramInt, float paramFloat);
    
    public abstract void q(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.ui.a
 * JD-Core Version:    0.7.0.1
 */