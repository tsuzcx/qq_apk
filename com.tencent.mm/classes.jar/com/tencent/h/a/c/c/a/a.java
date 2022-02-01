package com.tencent.h.a.c.c.a;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.MotionEvent.PointerCoords;
import android.view.View;
import com.tencent.h.a.a.c;
import com.tencent.h.a.b.c.b.a;
import com.tencent.h.a.b.c.b.b;
import com.tencent.h.a.h.a;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class a
  implements b.b
{
  private c ZSp;
  com.tencent.h.a.b.c.a.b ZUe;
  private Rect ZUf = new Rect();
  private Set<Integer> ZUg = new CopyOnWriteArraySet();
  protected b ZUh;
  
  public a(c paramc, com.tencent.h.a.b.c.a.b paramb)
  {
    this.ZSp = paramc;
    this.ZUe = paramb;
  }
  
  protected static com.tencent.h.a.c.b.i a(int paramInt, long paramLong, float paramFloat1, float paramFloat2)
  {
    com.tencent.h.a.c.b.i locali = new com.tencent.h.a.c.b.i();
    locali.ZTY = paramInt;
    locali.ZTZ = paramLong;
    com.tencent.g.c.i.i("sensor_AbsTouch", "[method: buildTouchInfo ] touchTimestamp : " + locali.ZTZ);
    locali.ZUa = paramFloat1;
    locali.ZUb = paramFloat2;
    return locali;
  }
  
  protected abstract void a(MotionEvent paramMotionEvent, b.a parama);
  
  public final void a(MotionEvent paramMotionEvent, b.a parama, b paramb)
  {
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool1 = true;
    this.ZUh = paramb;
    if (paramMotionEvent == null)
    {
      com.tencent.g.c.i.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] motionEvent is null");
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
        this.ZSp.ZSs.b(paramMotionEvent, "handleTouch");
        return;
      }
      if ((this.ZUe == null) || (this.ZUe.itO() == null))
      {
        com.tencent.g.c.i.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] getMasterEngine or getBuilder is null");
      }
      else
      {
        paramb = this.ZUe.itO().ZRX;
        if (paramb != null) {
          break;
        }
        com.tencent.g.c.i.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] monitorView is null");
      }
    }
    j = paramMotionEvent.getActionIndex();
    i = paramMotionEvent.getPointerId(j);
    k = paramMotionEvent.getActionMasked();
    if (k == 2) {
      if ((this.ZUg.isEmpty()) || (!this.ZUg.contains(Integer.valueOf(i)))) {
        break label641;
      }
    }
    label641:
    for (bool1 = bool3;; bool1 = false)
    {
      com.tencent.g.c.i.i("sensor_AbsTouch", "[method: isTouchValid ] MotionEvent.ACTION_MOVE : " + bool1 + ", pointerId : " + i);
      break;
      if ((k == 0) || (k == 5))
      {
        if ((this.ZUf.right - this.ZUf.left <= 0) || (this.ZUf.bottom - this.ZUf.top <= 0))
        {
          int[] arrayOfInt = new int[2];
          paramb.getLocationOnScreen(arrayOfInt);
          this.ZUf.left = arrayOfInt[0];
          this.ZUf.top = arrayOfInt[1];
          this.ZUf.right = (this.ZUf.left + paramb.getWidth());
          this.ZUf.bottom = (this.ZUf.top + paramb.getHeight());
          com.tencent.g.c.i.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] init ");
        }
        k = (int)paramMotionEvent.getRawX();
        int m = (int)paramMotionEvent.getRawY();
        com.tencent.g.c.i.i("sensor_AbsTouch", "[method: isViewTouch ] x = " + k + ", y = " + m);
        paramb = new MotionEvent.PointerCoords();
        paramMotionEvent.getPointerCoords(j, paramb);
        j = (int)paramb.x;
        k = (int)paramb.y;
        com.tencent.g.c.i.i("sensor_AbsTouch", "[method: isViewTouch ] pointer : [" + paramb.x + ", " + paramb.y + "]");
        bool1 = this.ZUf.contains(j, k);
        com.tencent.g.c.i.i("sensor_AbsTouch", "[method: isMonitorViewTouch ] " + this.ZUf + ", ret : " + bool1);
        if (bool1) {
          this.ZUg.add(Integer.valueOf(i));
        }
        com.tencent.g.c.i.i("sensor_AbsTouch", "[method: isTouchValid ] MotionEvent.ACTION_DOWN : " + bool1 + ", pointerId : " + i);
        break;
      }
      bool1 = bool2;
      if (!this.ZUg.isEmpty())
      {
        bool1 = bool2;
        if (this.ZUg.contains(Integer.valueOf(i)))
        {
          this.ZUg.remove(Integer.valueOf(i));
          bool1 = true;
        }
      }
      com.tencent.g.c.i.i("sensor_AbsTouch", "[method: isTouchValid ] MotionEvent.ACTION_UP : " + bool1 + ", pointerId : " + i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.c.a.a
 * JD-Core Version:    0.7.0.1
 */