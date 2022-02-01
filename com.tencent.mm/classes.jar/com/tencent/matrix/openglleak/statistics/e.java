package com.tencent.matrix.openglleak.statistics;

import android.app.Application;
import android.os.Handler;
import com.tencent.matrix.openglleak.statistics.resource.ResRecordManager;
import com.tencent.matrix.openglleak.statistics.resource.c;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends d
  implements com.tencent.matrix.b.a
{
  private final long eXu = 900000L;
  public a eXv;
  private List<c> eXw = new LinkedList();
  private Handler mH = new Handler(com.tencent.matrix.openglleak.a.d.ayV().getLooper());
  private Runnable mRunnable = new Runnable()
  {
    public final void run()
    {
      synchronized (e.a(e.this))
      {
        Iterator localIterator = e.a(e.this).iterator();
        while (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          if (localc != null)
          {
            if ((e.b(e.this) != null) && (!ResRecordManager.ayR().e(localc))) {
              e.b(e.this).a(localc);
            }
            localIterator.remove();
          }
        }
      }
      if (e.b(e.this) == null) {}
    }
  };
  
  public final void a(c paramc)
  {
    synchronized (this.eXw)
    {
      this.eXw.add(paramc);
      return;
    }
  }
  
  public final void d(Application paramApplication)
  {
    com.tencent.matrix.a.eLw.a(this);
    super.d(paramApplication);
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mH.removeCallbacks(this.mRunnable);
      return;
    }
    this.mH.postDelayed(this.mRunnable, this.eXu);
  }
  
  public static abstract interface a
  {
    public abstract void a(c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.openglleak.statistics.e
 * JD-Core Version:    0.7.0.1
 */