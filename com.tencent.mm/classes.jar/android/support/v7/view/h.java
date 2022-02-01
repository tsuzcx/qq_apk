package android.support.v7.view;

import android.support.v4.view.x;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
{
  y acu;
  private final z acv = new z()
  {
    private boolean acw = false;
    private int acx = 0;
    
    public final void aH(View paramAnonymousView)
    {
      if (this.acw) {}
      do
      {
        return;
        this.acw = true;
      } while (h.this.acu == null);
      h.this.acu.aH(null);
    }
    
    public final void aI(View paramAnonymousView)
    {
      int i = this.acx + 1;
      this.acx = i;
      if (i == h.this.vd.size())
      {
        if (h.this.acu != null) {
          h.this.acu.aI(null);
        }
        this.acx = 0;
        this.acw = false;
        h.this.mIsStarted = false;
      }
    }
  };
  private long mDuration = -1L;
  private Interpolator mInterpolator;
  boolean mIsStarted;
  final ArrayList<x> vd = new ArrayList();
  
  public final h a(x paramx)
  {
    if (!this.mIsStarted) {
      this.vd.add(paramx);
    }
    return this;
  }
  
  public final h a(x paramx1, x paramx2)
  {
    this.vd.add(paramx1);
    paramx2.k(paramx1.getDuration());
    this.vd.add(paramx2);
    return this;
  }
  
  public final h b(y paramy)
  {
    if (!this.mIsStarted) {
      this.acu = paramy;
    }
    return this;
  }
  
  public final h b(Interpolator paramInterpolator)
  {
    if (!this.mIsStarted) {
      this.mInterpolator = paramInterpolator;
    }
    return this;
  }
  
  public final void cancel()
  {
    if (!this.mIsStarted) {
      return;
    }
    Iterator localIterator = this.vd.iterator();
    while (localIterator.hasNext()) {
      ((x)localIterator.next()).cancel();
    }
    this.mIsStarted = false;
  }
  
  public final h hj()
  {
    if (!this.mIsStarted) {
      this.mDuration = 250L;
    }
    return this;
  }
  
  public final void start()
  {
    if (this.mIsStarted) {
      return;
    }
    Iterator localIterator = this.vd.iterator();
    while (localIterator.hasNext())
    {
      x localx = (x)localIterator.next();
      if (this.mDuration >= 0L) {
        localx.j(this.mDuration);
      }
      if (this.mInterpolator != null) {
        localx.a(this.mInterpolator);
      }
      if (this.acu != null) {
        localx.a(this.acv);
      }
      localx.start();
    }
    this.mIsStarted = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.h
 * JD-Core Version:    0.7.0.1
 */