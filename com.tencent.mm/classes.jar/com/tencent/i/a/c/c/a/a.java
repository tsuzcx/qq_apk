package com.tencent.i.a.c.c.a;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.View;
import com.tencent.h.c.h;
import com.tencent.i.a.a.c;
import com.tencent.i.a.b.c.b.a;
import com.tencent.i.a.b.c.b.b;
import com.tencent.i.a.c.b.i;
import com.tencent.i.a.h.a;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class a
  implements b.b
{
  private c SqM;
  com.tencent.i.a.b.c.a.b SsB;
  private Rect SsC = new Rect();
  private Set<Integer> SsD = new CopyOnWriteArraySet();
  protected b SsE;
  
  public a(c paramc, com.tencent.i.a.b.c.a.b paramb)
  {
    this.SqM = paramc;
    this.SsB = paramb;
  }
  
  protected static i a(int paramInt, long paramLong, float paramFloat1, float paramFloat2)
  {
    i locali = new i();
    locali.Ssv = paramInt;
    locali.Ssw = paramLong;
    h.i("sensor_AbsTouch", "[method: buildTouchInfo ] touchTimestamp : " + locali.Ssw);
    locali.Ssx = paramFloat1;
    locali.Ssy = paramFloat2;
    return locali;
  }
  
  protected abstract void a(MotionEvent paramMotionEvent, b.a parama);
  
  public final void a(MotionEvent paramMotionEvent, b.a parama, b paramb)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool1 = true;
    this.SsE = paramb;
    if (paramMotionEvent == null)
    {
      h.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] motionEvent is null");
      bool1 = false;
    }
    for (;;)
    {
      if (bool1) {}
      try
      {
        a(paramMotionEvent, parama);
        return;
      }
      catch (Throwable paramMotionEvent)
      {
        int j;
        int i;
        int k;
        this.SqM.SqP.b(paramMotionEvent, "handleTouch");
        return;
      }
      if ((this.SsB == null) || (this.SsB.hqh() == null))
      {
        h.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] getMasterEngine or getBuilder is null");
      }
      else
      {
        paramb = this.SsB.hqh().Squ;
        if (paramb != null) {
          break;
        }
        h.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] monitorView is null");
      }
    }
    j = paramMotionEvent.getActionIndex();
    i = paramMotionEvent.getPointerId(j);
    k = paramMotionEvent.getActionMasked();
    if (k == 2) {
      if ((this.SsD.isEmpty()) || (!this.SsD.contains(Integer.valueOf(i)))) {
        break label641;
      }
    }
    label641:
    for (bool1 = bool3;; bool1 = false)
    {
      h.i("sensor_AbsTouch", "[method: isTouchValid ] MotionEvent.ACTION_MOVE : " + bool1 + ", pointerId : " + i);
      break;
      if ((k == 0) || (k == 5))
      {
        if ((this.SsC.right - this.SsC.left <= 0) || (this.SsC.bottom - this.SsC.top <= 0))
        {
          int[] arrayOfInt = new int[2];
          paramb.getLocationOnScreen(arrayOfInt);
          this.SsC.left = arrayOfInt[0];
          this.SsC.top = arrayOfInt[1];
          this.SsC.right = (this.SsC.left + paramb.getWidth());
          this.SsC.bottom = (this.SsC.top + paramb.getHeight());
          h.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] init ");
        }
        k = (int)paramMotionEvent.getRawX();
        int m = (int)paramMotionEvent.getRawY();
        h.i("sensor_AbsTouch", "[method: isViewTouch ] x = " + k + ", y = " + m);
        paramb = new MotionEvent.PointerCoords();
        paramMotionEvent.getPointerCoords(j, paramb);
        j = (int)paramb.x;
        k = (int)paramb.y;
        h.i("sensor_AbsTouch", "[method: isViewTouch ] pointer : [" + paramb.x + ", " + paramb.y + "]");
        bool1 = this.SsC.contains(j, k);
        h.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] " + this.SsC + ", ret : " + bool1);
        if (bool1) {
          this.SsD.add(Integer.valueOf(i));
        }
        h.i("sensor_AbsTouch", "[method: isTouchValid ] MotionEvent.ACTION_DOWN : " + bool1 + ", pointerId : " + i);
        break;
      }
      bool1 = bool2;
      if (!this.SsD.isEmpty())
      {
        bool1 = bool2;
        if (this.SsD.contains(Integer.valueOf(i)))
        {
          this.SsD.remove(Integer.valueOf(i));
          bool1 = true;
        }
      }
      h.i("sensor_AbsTouch", "[method: isTouchValid ] MotionEvent.ACTION_UP : " + bool1 + ", pointerId : " + i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.c.a.a
 * JD-Core Version:    0.7.0.1
 */