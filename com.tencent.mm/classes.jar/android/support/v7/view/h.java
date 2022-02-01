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
  y ael;
  private final z aem = new z()
  {
    private boolean aen = false;
    private int aeo = 0;
    
    public final void aH(View paramAnonymousView)
    {
      if (this.aen) {}
      do
      {
        return;
        this.aen = true;
      } while (h.this.ael == null);
      h.this.ael.aH(null);
    }
    
    public final void aI(View paramAnonymousView)
    {
      int i = this.aeo + 1;
      this.aeo = i;
      if (i == h.this.wW.size())
      {
        if (h.this.ael != null) {
          h.this.ael.aI(null);
        }
        this.aeo = 0;
        this.aen = false;
        h.this.mIsStarted = false;
      }
    }
  };
  private long mDuration = -1L;
  private Interpolator mInterpolator;
  boolean mIsStarted;
  final ArrayList<x> wW = new ArrayList();
  
  public final h a(x paramx)
  {
    if (!this.mIsStarted) {
      this.wW.add(paramx);
    }
    return this;
  }
  
  public final h a(x paramx1, x paramx2)
  {
    this.wW.add(paramx1);
    paramx2.k(paramx1.getDuration());
    this.wW.add(paramx2);
    return this;
  }
  
  public final h b(y paramy)
  {
    if (!this.mIsStarted) {
      this.ael = paramy;
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
    Iterator localIterator = this.wW.iterator();
    while (localIterator.hasNext()) {
      ((x)localIterator.next()).cancel();
    }
    this.mIsStarted = false;
  }
  
  public final h hz()
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
    Iterator localIterator = this.wW.iterator();
    while (localIterator.hasNext())
    {
      x localx = (x)localIterator.next();
      if (this.mDuration >= 0L) {
        localx.j(this.mDuration);
      }
      if (this.mInterpolator != null) {
        localx.a(this.mInterpolator);
      }
      if (this.ael != null) {
        localx.a(this.aem);
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