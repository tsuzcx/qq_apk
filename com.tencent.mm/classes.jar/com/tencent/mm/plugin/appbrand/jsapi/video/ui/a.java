package com.tencent.mm.plugin.appbrand.jsapi.video.ui;

import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.r;

public final class a
{
  int KO;
  float kNg;
  View kVm;
  a kVn;
  private GestureDetector kVo;
  b kVp;
  private float kVq;
  int kVr;
  int kVs;
  Runnable kVt;
  Context mContext;
  
  public a(Context paramContext, View paramView, b paramb)
  {
    AppMethodBeat.i(194639);
    this.kVn = a.kVv;
    this.kNg = 0.0F;
    this.KO = 0;
    this.kVq = 0.0F;
    this.kVr = -1;
    this.kVs = 0;
    this.kVt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194632);
        a.this.kVp.bjj();
        AppMethodBeat.o(194632);
      }
    };
    this.mContext = paramContext;
    this.kVp = paramb;
    this.kVm = paramView;
    this.kVo = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(194634);
        a.this.kVm.removeCallbacks(a.this.kVt);
        a.this.kVp.bjk();
        AppMethodBeat.o(194634);
        return true;
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(194635);
        if ((paramAnonymousMotionEvent1 == null) || (paramAnonymousMotionEvent2 == null))
        {
          AppMethodBeat.o(194635);
          return true;
        }
        if (a.this.kVn == a.a.kVv)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label112;
          }
          a.this.kVn = a.a.kVy;
        }
        float f;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = a.this;
          if (paramAnonymousMotionEvent1.kVn != a.a.kVy) {
            break label217;
          }
          if (paramAnonymousMotionEvent1.kVp.bjq()) {
            break;
          }
          AppMethodBeat.o(194635);
          return false;
          label112:
          if (paramAnonymousMotionEvent1.getX() < a.this.kVm.getMeasuredWidth() / 2) {
            a.this.kVn = a.a.kVx;
          } else {
            a.this.kVn = a.a.kVw;
          }
        }
        if (paramAnonymousMotionEvent1.kVr == -1)
        {
          paramAnonymousMotionEvent1.kVp.bjl();
          paramAnonymousMotionEvent1.kVr = paramAnonymousMotionEvent1.kVp.getCurrentPosition();
        }
        paramAnonymousMotionEvent1.kVs = paramAnonymousMotionEvent1.kVp.j(paramAnonymousMotionEvent1.kVr, paramAnonymousFloat1 - paramAnonymousFloat2);
        AppMethodBeat.o(194635);
        return true;
        label217:
        if (paramAnonymousMotionEvent1.kVn == a.a.kVx)
        {
          if (!paramAnonymousMotionEvent1.kVp.bjo())
          {
            AppMethodBeat.o(194635);
            return false;
          }
          paramAnonymousFloat2 = f * -1.0F / paramAnonymousMotionEvent1.kVm.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.kNg;
          if (paramAnonymousFloat2 < 0.0F) {
            paramAnonymousFloat1 = 0.0F;
          }
          for (;;)
          {
            r.b(paramAnonymousMotionEvent1.mContext, paramAnonymousFloat1);
            paramAnonymousMotionEvent1.kVp.aA(paramAnonymousFloat1);
            AppMethodBeat.o(194635);
            return true;
            paramAnonymousFloat1 = paramAnonymousFloat2;
            if (paramAnonymousFloat2 > 1.0F) {
              paramAnonymousFloat1 = 1.0F;
            }
          }
        }
        int j;
        int i;
        if (paramAnonymousMotionEvent1.kVn == a.a.kVw)
        {
          if (!paramAnonymousMotionEvent1.kVp.bjp())
          {
            AppMethodBeat.o(194635);
            return false;
          }
          paramAnonymousFloat1 = f * -1.0F;
          paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousMotionEvent1.kVm.getMeasuredHeight();
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
          int k = i + paramAnonymousMotionEvent1.KO;
          if (k < 0) {
            i = 0;
          }
          for (;;)
          {
            com.tencent.mm.compatible.b.a.b(paramAnonymousMotionEvent2, 3, i);
            paramAnonymousFloat1 = i / j;
            paramAnonymousMotionEvent1.kVp.az(paramAnonymousFloat1);
            AppMethodBeat.o(194635);
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
          AppMethodBeat.o(194635);
          return true;
        }
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(194633);
        a.this.kVm.postDelayed(a.this.kVt, 200L);
        AppMethodBeat.o(194633);
        return true;
      }
    });
    this.kNg = r.dy(paramContext);
    AppMethodBeat.o(194639);
  }
  
  private void bkZ()
  {
    AppMethodBeat.i(194641);
    this.KO = ((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(3);
    this.kNg = r.dy(this.mContext);
    AppMethodBeat.o(194641);
  }
  
  public final void bkY()
  {
    this.kVr = -1;
    this.kVs = 0;
    this.kVq = 0.0F;
  }
  
  public final void y(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(194640);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.kVq = paramMotionEvent.getRawX();
      bkZ();
    }
    this.kVo.onTouchEvent(paramMotionEvent);
    if ((i == 1) || (i == 3))
    {
      if (this.kVn != a.kVy) {
        break label105;
      }
      this.kVp.k(this.kVs, paramMotionEvent.getRawX() - this.kVq);
      this.kVr = -1;
      this.kVs = 0;
      this.kVq = 0.0F;
    }
    for (;;)
    {
      this.kVn = a.kVv;
      AppMethodBeat.o(194640);
      return;
      label105:
      if (this.kVn == a.kVw)
      {
        ((AudioManager)this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
        this.kVp.bjm();
      }
      else if (this.kVn == a.kVx)
      {
        this.kVp.bjn();
      }
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(194638);
      kVv = new a("None", 0);
      kVw = new a("Volume", 1);
      kVx = new a("Brightness", 2);
      kVy = new a("FastBackwardOrForward", 3);
      kVz = new a[] { kVv, kVw, kVx, kVy };
      AppMethodBeat.o(194638);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void aA(float paramFloat);
    
    public abstract void az(float paramFloat);
    
    public abstract void bjj();
    
    public abstract void bjk();
    
    public abstract void bjl();
    
    public abstract void bjm();
    
    public abstract void bjn();
    
    public abstract boolean bjo();
    
    public abstract boolean bjp();
    
    public abstract boolean bjq();
    
    public abstract int getCurrentPosition();
    
    public abstract int j(int paramInt, float paramFloat);
    
    public abstract void k(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.ui.a
 * JD-Core Version:    0.7.0.1
 */