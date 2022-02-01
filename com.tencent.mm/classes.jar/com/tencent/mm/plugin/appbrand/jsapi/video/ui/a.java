package com.tencent.mm.plugin.appbrand.jsapi.video.ui;

import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.l;

public final class a
{
  int JT;
  float klO;
  View ktX;
  a ktY;
  private GestureDetector ktZ;
  b kua;
  private float kub;
  int kuc;
  int kud;
  Runnable kue;
  Context mContext;
  
  public a(Context paramContext, View paramView, b paramb)
  {
    AppMethodBeat.i(194294);
    this.ktY = a.kug;
    this.klO = 0.0F;
    this.JT = 0;
    this.kub = 0.0F;
    this.kuc = -1;
    this.kud = 0;
    this.kue = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194287);
        a.this.kua.bcn();
        AppMethodBeat.o(194287);
      }
    };
    this.mContext = paramContext;
    this.kua = paramb;
    this.ktX = paramView;
    this.ktZ = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(194289);
        a.this.ktX.removeCallbacks(a.this.kue);
        a.this.kua.bco();
        AppMethodBeat.o(194289);
        return true;
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(194290);
        if ((paramAnonymousMotionEvent1 == null) || (paramAnonymousMotionEvent2 == null))
        {
          AppMethodBeat.o(194290);
          return true;
        }
        if (a.this.ktY == a.a.kug)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label112;
          }
          a.this.ktY = a.a.kuj;
        }
        float f;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = a.this;
          if (paramAnonymousMotionEvent1.ktY != a.a.kuj) {
            break label217;
          }
          if (paramAnonymousMotionEvent1.kua.bcu()) {
            break;
          }
          AppMethodBeat.o(194290);
          return false;
          label112:
          if (paramAnonymousMotionEvent1.getX() < a.this.ktX.getMeasuredWidth() / 2) {
            a.this.ktY = a.a.kui;
          } else {
            a.this.ktY = a.a.kuh;
          }
        }
        if (paramAnonymousMotionEvent1.kuc == -1)
        {
          paramAnonymousMotionEvent1.kua.bcp();
          paramAnonymousMotionEvent1.kuc = paramAnonymousMotionEvent1.kua.getCurrentPosition();
        }
        paramAnonymousMotionEvent1.kud = paramAnonymousMotionEvent1.kua.j(paramAnonymousMotionEvent1.kuc, paramAnonymousFloat1 - paramAnonymousFloat2);
        AppMethodBeat.o(194290);
        return true;
        label217:
        if (paramAnonymousMotionEvent1.ktY == a.a.kui)
        {
          if (!paramAnonymousMotionEvent1.kua.bcs())
          {
            AppMethodBeat.o(194290);
            return false;
          }
          paramAnonymousFloat2 = f * -1.0F / paramAnonymousMotionEvent1.ktX.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.klO;
          if (paramAnonymousFloat2 < 0.0F) {
            paramAnonymousFloat1 = 0.0F;
          }
          for (;;)
          {
            l.b(paramAnonymousMotionEvent1.mContext, paramAnonymousFloat1);
            paramAnonymousMotionEvent1.kua.aw(paramAnonymousFloat1);
            AppMethodBeat.o(194290);
            return true;
            paramAnonymousFloat1 = paramAnonymousFloat2;
            if (paramAnonymousFloat2 > 1.0F) {
              paramAnonymousFloat1 = 1.0F;
            }
          }
        }
        int j;
        int i;
        if (paramAnonymousMotionEvent1.ktY == a.a.kuh)
        {
          if (!paramAnonymousMotionEvent1.kua.bct())
          {
            AppMethodBeat.o(194290);
            return false;
          }
          paramAnonymousFloat1 = f * -1.0F;
          paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousMotionEvent1.ktX.getMeasuredHeight();
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
          int k = i + paramAnonymousMotionEvent1.JT;
          if (k < 0) {
            i = 0;
          }
          for (;;)
          {
            com.tencent.mm.compatible.b.a.b(paramAnonymousMotionEvent2, 3, i);
            paramAnonymousFloat1 = i / j;
            paramAnonymousMotionEvent1.kua.av(paramAnonymousFloat1);
            AppMethodBeat.o(194290);
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
          AppMethodBeat.o(194290);
          return true;
        }
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(194288);
        a.this.ktX.postDelayed(a.this.kue, 200L);
        AppMethodBeat.o(194288);
        return true;
      }
    });
    this.klO = l.dp(paramContext);
    AppMethodBeat.o(194294);
  }
  
  private void bef()
  {
    AppMethodBeat.i(194296);
    this.JT = ((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(3);
    this.klO = l.dp(this.mContext);
    AppMethodBeat.o(194296);
  }
  
  public final void A(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(194295);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.kub = paramMotionEvent.getRawX();
      bef();
    }
    this.ktZ.onTouchEvent(paramMotionEvent);
    if ((i == 1) || (i == 3))
    {
      if (this.ktY != a.kuj) {
        break label105;
      }
      this.kua.k(this.kud, paramMotionEvent.getRawX() - this.kub);
      this.kuc = -1;
      this.kud = 0;
      this.kub = 0.0F;
    }
    for (;;)
    {
      this.ktY = a.kug;
      AppMethodBeat.o(194295);
      return;
      label105:
      if (this.ktY == a.kuh)
      {
        ((AudioManager)this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
        this.kua.bcq();
      }
      else if (this.ktY == a.kui)
      {
        this.kua.bcr();
      }
    }
  }
  
  public final void bee()
  {
    this.kuc = -1;
    this.kud = 0;
    this.kub = 0.0F;
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(194293);
      kug = new a("None", 0);
      kuh = new a("Volume", 1);
      kui = new a("Brightness", 2);
      kuj = new a("FastBackwardOrForward", 3);
      kuk = new a[] { kug, kuh, kui, kuj };
      AppMethodBeat.o(194293);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void av(float paramFloat);
    
    public abstract void aw(float paramFloat);
    
    public abstract void bcn();
    
    public abstract void bco();
    
    public abstract void bcp();
    
    public abstract void bcq();
    
    public abstract void bcr();
    
    public abstract boolean bcs();
    
    public abstract boolean bct();
    
    public abstract boolean bcu();
    
    public abstract int getCurrentPosition();
    
    public abstract int j(int paramInt, float paramFloat);
    
    public abstract void k(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.ui.a
 * JD-Core Version:    0.7.0.1
 */