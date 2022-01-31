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
  y Uw;
  boolean Ux;
  private final z Uy = new z()
  {
    private int UA = 0;
    private boolean Uz = false;
    
    public final void aB(View paramAnonymousView)
    {
      if (this.Uz) {}
      do
      {
        return;
        this.Uz = true;
      } while (h.this.Uw == null);
      h.this.Uw.aB(null);
    }
    
    public final void aC(View paramAnonymousView)
    {
      int i = this.UA + 1;
      this.UA = i;
      if (i == h.this.nD.size())
      {
        if (h.this.Uw != null) {
          h.this.Uw.aC(null);
        }
        this.UA = 0;
        this.Uz = false;
        h.this.Ux = false;
      }
    }
  };
  private long mDuration = -1L;
  private Interpolator mInterpolator;
  final ArrayList<x> nD = new ArrayList();
  
  public final h a(x paramx)
  {
    if (!this.Ux) {
      this.nD.add(paramx);
    }
    return this;
  }
  
  public final h a(x paramx1, x paramx2)
  {
    this.nD.add(paramx1);
    paramx2.i(paramx1.getDuration());
    this.nD.add(paramx2);
    return this;
  }
  
  public final h b(y paramy)
  {
    if (!this.Ux) {
      this.Uw = paramy;
    }
    return this;
  }
  
  public final void cancel()
  {
    if (!this.Ux) {
      return;
    }
    Iterator localIterator = this.nD.iterator();
    while (localIterator.hasNext()) {
      ((x)localIterator.next()).cancel();
    }
    this.Ux = false;
  }
  
  public final h d(Interpolator paramInterpolator)
  {
    if (!this.Ux) {
      this.mInterpolator = paramInterpolator;
    }
    return this;
  }
  
  public final h fF()
  {
    if (!this.Ux) {
      this.mDuration = 250L;
    }
    return this;
  }
  
  public final void start()
  {
    if (this.Ux) {
      return;
    }
    Iterator localIterator = this.nD.iterator();
    while (localIterator.hasNext())
    {
      x localx = (x)localIterator.next();
      if (this.mDuration >= 0L) {
        localx.h(this.mDuration);
      }
      if (this.mInterpolator != null) {
        localx.c(this.mInterpolator);
      }
      if (this.Uw != null) {
        localx.a(this.Uy);
      }
      localx.start();
    }
    this.Ux = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.h
 * JD-Core Version:    0.7.0.1
 */