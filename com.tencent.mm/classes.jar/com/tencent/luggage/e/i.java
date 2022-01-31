package com.tencent.luggage.e;

import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.j.c;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class i
{
  public ConcurrentHashMap<i.f, Boolean> biD = new ConcurrentHashMap();
  private Handler mMainHandler = new Handler(Looper.getMainLooper());
  
  final boolean k(Class<? extends i.f> paramClass)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {}
    for (int i = 1; i == 0; i = 0)
    {
      c.e("LuggagePageEventBus", "notifyListener on non-UI thread");
      return false;
    }
    Iterator localIterator = this.biD.keySet().iterator();
    while (localIterator.hasNext())
    {
      i.f localf = (i.f)localIterator.next();
      if (paramClass.isInstance(localf))
      {
        boolean bool = localf.qm();
        if (((Boolean)this.biD.get(localf)).booleanValue()) {
          this.biD.remove(localf);
        }
        if (bool) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static abstract class c
    extends i.f
  {
    public c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.e.i
 * JD-Core Version:    0.7.0.1
 */