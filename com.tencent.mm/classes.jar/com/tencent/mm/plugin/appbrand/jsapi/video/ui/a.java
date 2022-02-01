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
  int dG;
  Context mContext;
  View pCS;
  a pCT;
  private GestureDetector pCU;
  b pCV;
  private float pCW;
  int pCX;
  int pCY;
  Runnable pCZ;
  float psp;
  
  public a(Context paramContext, View paramView, b paramb)
  {
    AppMethodBeat.i(229859);
    this.pCT = a.pDb;
    this.psp = 0.0F;
    this.dG = 0;
    this.pCW = 0.0F;
    this.pCX = -1;
    this.pCY = 0;
    this.pCZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(229103);
        a.this.pCV.bUS();
        AppMethodBeat.o(229103);
      }
    };
    this.mContext = paramContext;
    this.pCV = paramb;
    this.pCS = paramView;
    this.pCU = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(228544);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(228544);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(228523);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        a.this.pCS.removeCallbacks(a.this.pCZ);
        a.this.pCV.bUT();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(228523);
        return true;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(228541);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(228541);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(228538);
        if ((paramAnonymousMotionEvent1 == null) || (paramAnonymousMotionEvent2 == null))
        {
          AppMethodBeat.o(228538);
          return true;
        }
        if (a.this.pCT == a.a.pDb)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label112;
          }
          a.this.pCT = a.a.pDe;
        }
        float f;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = a.this;
          if (paramAnonymousMotionEvent1.pCT != a.a.pDe) {
            break label217;
          }
          if (paramAnonymousMotionEvent1.pCV.bUZ()) {
            break;
          }
          AppMethodBeat.o(228538);
          return false;
          label112:
          if (paramAnonymousMotionEvent1.getX() < a.this.pCS.getMeasuredWidth() / 2) {
            a.this.pCT = a.a.pDd;
          } else {
            a.this.pCT = a.a.pDc;
          }
        }
        if (paramAnonymousMotionEvent1.pCX == -1)
        {
          paramAnonymousMotionEvent1.pCV.bUU();
          paramAnonymousMotionEvent1.pCX = paramAnonymousMotionEvent1.pCV.getCurrentPosition();
        }
        paramAnonymousMotionEvent1.pCY = paramAnonymousMotionEvent1.pCV.l(paramAnonymousMotionEvent1.pCX, paramAnonymousFloat1 - paramAnonymousFloat2);
        AppMethodBeat.o(228538);
        return true;
        label217:
        if (paramAnonymousMotionEvent1.pCT == a.a.pDd)
        {
          if (!paramAnonymousMotionEvent1.pCV.bUX())
          {
            AppMethodBeat.o(228538);
            return false;
          }
          paramAnonymousFloat2 = f * -1.0F / paramAnonymousMotionEvent1.pCS.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.psp;
          if (paramAnonymousFloat2 < 0.0F) {
            paramAnonymousFloat1 = 0.0F;
          }
          for (;;)
          {
            k.b(paramAnonymousMotionEvent1.mContext, paramAnonymousFloat1);
            paramAnonymousMotionEvent1.pCV.aN(paramAnonymousFloat1);
            AppMethodBeat.o(228538);
            return true;
            paramAnonymousFloat1 = paramAnonymousFloat2;
            if (paramAnonymousFloat2 > 1.0F) {
              paramAnonymousFloat1 = 1.0F;
            }
          }
        }
        int j;
        int i;
        if (paramAnonymousMotionEvent1.pCT == a.a.pDc)
        {
          if (!paramAnonymousMotionEvent1.pCV.bUY())
          {
            AppMethodBeat.o(228538);
            return false;
          }
          paramAnonymousFloat1 = f * -1.0F;
          paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousMotionEvent1.pCS.getMeasuredHeight();
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
            paramAnonymousMotionEvent1.pCV.aM(paramAnonymousFloat1);
            AppMethodBeat.o(228538);
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
          AppMethodBeat.o(228538);
          return true;
        }
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(228520);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        a.this.pCS.postDelayed(a.this.pCZ, 200L);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(228520);
        return true;
      }
    });
    this.psp = k.dT(paramContext);
    AppMethodBeat.o(229859);
  }
  
  private void bXa()
  {
    AppMethodBeat.i(229862);
    this.dG = ((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(3);
    this.psp = k.dT(this.mContext);
    AppMethodBeat.o(229862);
  }
  
  public final void C(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(229860);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.pCW = paramMotionEvent.getRawX();
      bXa();
    }
    GestureDetector localGestureDetector = this.pCU;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aFh(), "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((i == 1) || (i == 3))
    {
      if (this.pCT != a.pDe) {
        break label165;
      }
      this.pCV.m(this.pCY, paramMotionEvent.getRawX() - this.pCW);
      this.pCX = -1;
      this.pCY = 0;
      this.pCW = 0.0F;
    }
    for (;;)
    {
      this.pCT = a.pDb;
      AppMethodBeat.o(229860);
      return;
      label165:
      if (this.pCT == a.pDc)
      {
        ((AudioManager)this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
        this.pCV.bUV();
      }
      else if (this.pCT == a.pDd)
      {
        this.pCV.bUW();
      }
    }
  }
  
  public final void bWZ()
  {
    this.pCX = -1;
    this.pCY = 0;
    this.pCW = 0.0F;
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(227882);
      pDb = new a("None", 0);
      pDc = new a("Volume", 1);
      pDd = new a("Brightness", 2);
      pDe = new a("FastBackwardOrForward", 3);
      pDf = new a[] { pDb, pDc, pDd, pDe };
      AppMethodBeat.o(227882);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void aM(float paramFloat);
    
    public abstract void aN(float paramFloat);
    
    public abstract void bUS();
    
    public abstract void bUT();
    
    public abstract void bUU();
    
    public abstract void bUV();
    
    public abstract void bUW();
    
    public abstract boolean bUX();
    
    public abstract boolean bUY();
    
    public abstract boolean bUZ();
    
    public abstract int getCurrentPosition();
    
    public abstract int l(int paramInt, float paramFloat);
    
    public abstract void m(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.ui.a
 * JD-Core Version:    0.7.0.1
 */