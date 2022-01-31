package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.a;

public final class l
{
  int De;
  float iaW;
  View idW;
  l.a idX;
  private GestureDetector idY;
  l.b idZ;
  private float iea;
  int ieb;
  int iec;
  Runnable ied;
  Context mContext;
  
  public l(Context paramContext, View paramView, l.b paramb)
  {
    AppMethodBeat.i(126587);
    this.idX = l.a.ief;
    this.iaW = 0.0F;
    this.De = 0;
    this.iea = 0.0F;
    this.ieb = -1;
    this.iec = 0;
    this.ied = new l.1(this);
    this.mContext = paramContext;
    this.idZ = paramb;
    this.idW = paramView;
    this.idY = new GestureDetector(this.mContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(126582);
        l.this.idW.removeCallbacks(l.this.ied);
        l.this.idZ.aEY();
        AppMethodBeat.o(126582);
        return true;
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        float f1 = 1.0F;
        float f2 = 0.0F;
        AppMethodBeat.i(126583);
        if ((paramAnonymousMotionEvent1 == null) || (paramAnonymousMotionEvent2 == null))
        {
          AppMethodBeat.o(126583);
          return true;
        }
        if (l.this.idX == l.a.ief)
        {
          if (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)) {
            break label118;
          }
          l.this.idX = l.a.iei;
        }
        float f3;
        for (;;)
        {
          paramAnonymousFloat1 = paramAnonymousMotionEvent2.getX();
          paramAnonymousFloat2 = paramAnonymousMotionEvent1.getX();
          f3 = paramAnonymousMotionEvent2.getY() - paramAnonymousMotionEvent1.getY();
          paramAnonymousMotionEvent1 = l.this;
          if (paramAnonymousMotionEvent1.idX != l.a.iei) {
            break label223;
          }
          if (paramAnonymousMotionEvent1.idZ.aFe()) {
            break;
          }
          AppMethodBeat.o(126583);
          return false;
          label118:
          if (paramAnonymousMotionEvent1.getX() < l.this.idW.getMeasuredWidth() / 2) {
            l.this.idX = l.a.ieh;
          } else {
            l.this.idX = l.a.ieg;
          }
        }
        if (paramAnonymousMotionEvent1.ieb == -1)
        {
          paramAnonymousMotionEvent1.idZ.aEZ();
          paramAnonymousMotionEvent1.ieb = paramAnonymousMotionEvent1.idZ.getCurrentPosition();
        }
        paramAnonymousMotionEvent1.iec = paramAnonymousMotionEvent1.idZ.h(paramAnonymousMotionEvent1.ieb, paramAnonymousFloat1 - paramAnonymousFloat2);
        AppMethodBeat.o(126583);
        return true;
        label223:
        if (paramAnonymousMotionEvent1.idX == l.a.ieh)
        {
          if (!paramAnonymousMotionEvent1.idZ.aFc())
          {
            AppMethodBeat.o(126583);
            return false;
          }
          paramAnonymousFloat1 = -1.0F * f3 / paramAnonymousMotionEvent1.idW.getMeasuredHeight() * 1.2F + paramAnonymousMotionEvent1.iaW;
          if (paramAnonymousFloat1 < 0.0F) {
            paramAnonymousFloat1 = f2;
          }
        }
        label575:
        label578:
        for (;;)
        {
          paramAnonymousMotionEvent2 = paramAnonymousMotionEvent1.mContext;
          if ((paramAnonymousMotionEvent2 instanceof Activity))
          {
            if (paramAnonymousFloat1 >= 0.01F) {
              break label365;
            }
            paramAnonymousFloat2 = 0.01F;
          }
          for (;;)
          {
            paramAnonymousMotionEvent2 = (Activity)paramAnonymousMotionEvent2;
            WindowManager.LayoutParams localLayoutParams = paramAnonymousMotionEvent2.getWindow().getAttributes();
            localLayoutParams.screenBrightness = paramAnonymousFloat2;
            paramAnonymousMotionEvent2.getWindow().setAttributes(localLayoutParams);
            paramAnonymousMotionEvent1.idZ.ax(paramAnonymousFloat1);
            AppMethodBeat.o(126583);
            return true;
            if (paramAnonymousFloat1 <= 1.0F) {
              break label578;
            }
            paramAnonymousFloat1 = 1.0F;
            break;
            label365:
            paramAnonymousFloat2 = f1;
            if (paramAnonymousFloat1 <= 1.0F) {
              paramAnonymousFloat2 = paramAnonymousFloat1;
            }
          }
          int j;
          int i;
          if (paramAnonymousMotionEvent1.idX == l.a.ieg)
          {
            if (!paramAnonymousMotionEvent1.idZ.aFd())
            {
              AppMethodBeat.o(126583);
              return false;
            }
            paramAnonymousFloat1 = f3 * -1.0F;
            paramAnonymousFloat2 = paramAnonymousFloat1 / paramAnonymousMotionEvent1.idW.getMeasuredHeight();
            paramAnonymousMotionEvent2 = (AudioManager)paramAnonymousMotionEvent1.mContext.getSystemService("audio");
            j = paramAnonymousMotionEvent2.getStreamMaxVolume(3);
            paramAnonymousFloat2 = 1.2F * (paramAnonymousFloat2 * j);
            i = (int)paramAnonymousFloat2;
            if ((i != 0) || (Math.abs(paramAnonymousFloat2) <= 0.2F)) {
              break label575;
            }
            if (paramAnonymousFloat1 > 0.0F) {
              i = 1;
            }
          }
          for (;;)
          {
            int k = i + paramAnonymousMotionEvent1.De;
            if (k < 0) {
              i = 0;
            }
            for (;;)
            {
              a.b(paramAnonymousMotionEvent2, 3, i);
              paramAnonymousFloat1 = i / j;
              paramAnonymousMotionEvent1.idZ.aw(paramAnonymousFloat1);
              AppMethodBeat.o(126583);
              return true;
              if (paramAnonymousFloat1 >= 0.0F) {
                break label575;
              }
              i = -1;
              break;
              i = k;
              if (k >= j) {
                i = j;
              }
            }
            AppMethodBeat.o(126583);
            return true;
          }
        }
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(126581);
        l.this.idW.postDelayed(l.this.ied, 200L);
        AppMethodBeat.o(126581);
        return true;
      }
    });
    this.iaW = m.cP(paramContext);
    AppMethodBeat.o(126587);
  }
  
  private void aFH()
  {
    AppMethodBeat.i(126589);
    this.De = ((AudioManager)this.mContext.getSystemService("audio")).getStreamVolume(3);
    this.iaW = m.cP(this.mContext);
    AppMethodBeat.o(126589);
  }
  
  public final void aFG()
  {
    this.ieb = -1;
    this.iec = 0;
    this.iea = 0.0F;
  }
  
  public final void z(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126588);
    int i = paramMotionEvent.getActionMasked();
    if (i == 0)
    {
      this.iea = paramMotionEvent.getRawX();
      aFH();
    }
    this.idY.onTouchEvent(paramMotionEvent);
    if ((i == 1) || (i == 3))
    {
      if (this.idX != l.a.iei) {
        break label105;
      }
      this.idZ.i(this.iec, paramMotionEvent.getRawX() - this.iea);
      this.ieb = -1;
      this.iec = 0;
      this.iea = 0.0F;
    }
    for (;;)
    {
      this.idX = l.a.ief;
      AppMethodBeat.o(126588);
      return;
      label105:
      if (this.idX == l.a.ieg)
      {
        ((AudioManager)this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
        this.idZ.aFa();
      }
      else if (this.idX == l.a.ieh)
      {
        this.idZ.aFb();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.l
 * JD-Core Version:    0.7.0.1
 */