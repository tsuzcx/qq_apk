package android.support.v7.view;

import android.support.v4.view.u;
import android.support.v4.view.v;
import android.support.v4.view.w;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class h
{
  boolean OU;
  v TM;
  private final w TN = new w()
  {
    private boolean TO = false;
    private int TP = 0;
    
    public final void au(View paramAnonymousView)
    {
      if (this.TO) {}
      do
      {
        return;
        this.TO = true;
      } while (h.this.TM == null);
      h.this.TM.au(null);
    }
    
    public final void av(View paramAnonymousView)
    {
      int i = this.TP + 1;
      this.TP = i;
      if (i == h.this.mG.size())
      {
        if (h.this.TM != null) {
          h.this.TM.av(null);
        }
        this.TP = 0;
        this.TO = false;
        h.this.OU = false;
      }
    }
  };
  private long mDuration = -1L;
  final ArrayList<u> mG = new ArrayList();
  private Interpolator mInterpolator;
  
  public final h a(u paramu)
  {
    if (!this.OU) {
      this.mG.add(paramu);
    }
    return this;
  }
  
  public final h a(u paramu1, u paramu2)
  {
    this.mG.add(paramu1);
    paramu1 = (View)paramu1.Hz.get();
    if (paramu1 != null) {}
    for (long l = paramu1.animate().getDuration();; l = 0L)
    {
      paramu1 = (View)paramu2.Hz.get();
      if (paramu1 != null) {
        paramu1.animate().setStartDelay(l);
      }
      this.mG.add(paramu2);
      return this;
    }
  }
  
  public final h b(v paramv)
  {
    if (!this.OU) {
      this.TM = paramv;
    }
    return this;
  }
  
  public final void cancel()
  {
    if (!this.OU) {
      return;
    }
    Iterator localIterator = this.mG.iterator();
    while (localIterator.hasNext()) {
      ((u)localIterator.next()).cancel();
    }
    this.OU = false;
  }
  
  public final h d(Interpolator paramInterpolator)
  {
    if (!this.OU) {
      this.mInterpolator = paramInterpolator;
    }
    return this;
  }
  
  public final h eR()
  {
    if (!this.OU) {
      this.mDuration = 250L;
    }
    return this;
  }
  
  public final void start()
  {
    if (this.OU) {
      return;
    }
    Iterator localIterator = this.mG.iterator();
    while (localIterator.hasNext())
    {
      u localu = (u)localIterator.next();
      if (this.mDuration >= 0L) {
        localu.k(this.mDuration);
      }
      if (this.mInterpolator != null) {
        localu.c(this.mInterpolator);
      }
      if (this.TM != null) {
        localu.a(this.TN);
      }
      localu.start();
    }
    this.OU = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.h
 * JD-Core Version:    0.7.0.1
 */