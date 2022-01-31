package com.tencent.matrix.trace.core;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
  implements Choreographer.FrameCallback, a.a
{
  private static b brb;
  public final LinkedList<com.tencent.matrix.trace.c.b> brc = new LinkedList();
  public Choreographer brd;
  public boolean bre;
  public long brf;
  
  public static b ro()
  {
    if (brb == null) {
      brb = new b();
    }
    return brb;
  }
  
  public final void doFrame(long paramLong)
  {
    if (paramLong < this.brf)
    {
      com.tencent.matrix.d.b.w("Matrix.FrameBeat", "frameTimeNanos < mLastFrameNanos, just return", new Object[0]);
      this.brf = paramLong;
      this.brd.postFrameCallback(this);
    }
    while (this.brc == null) {
      return;
    }
    Iterator localIterator = this.brc.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.matrix.trace.c.b)localIterator.next()).k(this.brf, paramLong);
    }
    this.brd.postFrameCallback(this);
    this.brf = paramLong;
  }
  
  public final void onActivityCreated(Activity paramActivity) {}
  
  public final void onActivityPause(Activity paramActivity) {}
  
  public final void onActivityResume(Activity paramActivity) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onBackground(Activity paramActivity)
  {
    com.tencent.matrix.d.b.i("Matrix.FrameBeat", "[onBackground] isExist:%s removeFrameCallback", new Object[] { Boolean.valueOf(this.bre) });
    if ((this.bre) && (this.brd != null)) {
      this.brd.removeFrameCallback(this);
    }
  }
  
  public final void onChange(Activity paramActivity, Fragment paramFragment)
  {
    com.tencent.matrix.d.b.i("Matrix.FrameBeat", "[onChange] resetIndex mLastFrameNanos, current activity:%s", new Object[] { paramActivity.getClass().getSimpleName() });
  }
  
  public final void onFront(Activity paramActivity)
  {
    com.tencent.matrix.d.b.i("Matrix.FrameBeat", "[onFront] isExist:%s postFrameCallback", new Object[] { Boolean.valueOf(this.bre) });
    if ((this.bre) && (this.brd != null))
    {
      this.brf = System.nanoTime();
      this.brd.removeFrameCallback(this);
      this.brd.postFrameCallback(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.core.b
 * JD-Core Version:    0.7.0.1
 */