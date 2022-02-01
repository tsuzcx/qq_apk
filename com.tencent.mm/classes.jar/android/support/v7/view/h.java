package android.support.v7.view;

import android.support.v4.view.aa;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
{
  z aey;
  private final aa aez = new aa()
  {
    private boolean aeA = false;
    private int aeB = 0;
    
    public final void aI(View paramAnonymousView)
    {
      if (this.aeA) {}
      do
      {
        return;
        this.aeA = true;
      } while (h.this.aey == null);
      h.this.aey.aI(null);
    }
    
    public final void aJ(View paramAnonymousView)
    {
      int i = this.aeB + 1;
      this.aeB = i;
      if (i == h.this.xd.size())
      {
        if (h.this.aey != null) {
          h.this.aey.aJ(null);
        }
        this.aeB = 0;
        this.aeA = false;
        h.this.mIsStarted = false;
      }
    }
  };
  private long mDuration = -1L;
  private Interpolator mInterpolator;
  boolean mIsStarted;
  final ArrayList<y> xd = new ArrayList();
  
  public final h a(y paramy)
  {
    if (!this.mIsStarted) {
      this.xd.add(paramy);
    }
    return this;
  }
  
  public final h a(y paramy1, y paramy2)
  {
    this.xd.add(paramy1);
    paramy2.k(paramy1.getDuration());
    this.xd.add(paramy2);
    return this;
  }
  
  public final h b(z paramz)
  {
    if (!this.mIsStarted) {
      this.aey = paramz;
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
    Iterator localIterator = this.xd.iterator();
    while (localIterator.hasNext()) {
      ((y)localIterator.next()).cancel();
    }
    this.mIsStarted = false;
  }
  
  public final h hI()
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
    Iterator localIterator = this.xd.iterator();
    while (localIterator.hasNext())
    {
      y localy = (y)localIterator.next();
      if (this.mDuration >= 0L) {
        localy.j(this.mDuration);
      }
      if (this.mInterpolator != null) {
        localy.a(this.mInterpolator);
      }
      if (this.aey != null) {
        localy.a(this.aez);
      }
      localy.start();
    }
    this.mIsStarted = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.h
 * JD-Core Version:    0.7.0.1
 */