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
  y abA;
  private final z abB = new z()
  {
    private boolean abC = false;
    private int abD = 0;
    
    public final void aH(View paramAnonymousView)
    {
      if (this.abC) {}
      do
      {
        return;
        this.abC = true;
      } while (h.this.abA == null);
      h.this.abA.aH(null);
    }
    
    public final void aI(View paramAnonymousView)
    {
      int i = this.abD + 1;
      this.abD = i;
      if (i == h.this.ud.size())
      {
        if (h.this.abA != null) {
          h.this.abA.aI(null);
        }
        this.abD = 0;
        this.abC = false;
        h.this.mIsStarted = false;
      }
    }
  };
  private long mDuration = -1L;
  private Interpolator mInterpolator;
  boolean mIsStarted;
  final ArrayList<x> ud = new ArrayList();
  
  public final h a(x paramx)
  {
    if (!this.mIsStarted) {
      this.ud.add(paramx);
    }
    return this;
  }
  
  public final h a(x paramx1, x paramx2)
  {
    this.ud.add(paramx1);
    paramx2.i(paramx1.getDuration());
    this.ud.add(paramx2);
    return this;
  }
  
  public final h b(y paramy)
  {
    if (!this.mIsStarted) {
      this.abA = paramy;
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
    Iterator localIterator = this.ud.iterator();
    while (localIterator.hasNext()) {
      ((x)localIterator.next()).cancel();
    }
    this.mIsStarted = false;
  }
  
  public final h hb()
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
    Iterator localIterator = this.ud.iterator();
    while (localIterator.hasNext())
    {
      x localx = (x)localIterator.next();
      if (this.mDuration >= 0L) {
        localx.h(this.mDuration);
      }
      if (this.mInterpolator != null) {
        localx.a(this.mInterpolator);
      }
      if (this.abA != null) {
        localx.a(this.abB);
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