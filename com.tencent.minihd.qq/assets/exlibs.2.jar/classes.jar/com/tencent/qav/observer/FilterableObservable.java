package com.tencent.qav.observer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class FilterableObservable
{
  private Handler mBgHandler;
  private final List<FilterableObserver> mBgObservers = new Vector();
  private Handler mUIHandler;
  private final List<FilterableObserver> mUIObservers = new Vector();
  
  FilterableObservable()
  {
    if (this.mUIHandler == null) {
      this.mUIHandler = new Handler(Looper.getMainLooper());
    }
    if (this.mBgHandler == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("FilterableObservable-bg-thread");
      localHandlerThread.start();
      this.mBgHandler = new Handler(localHandlerThread.getLooper());
    }
  }
  
  private void notifyObserver(final FilterableObserver paramFilterableObserver, Handler paramHandler, final int paramInt, final Object... paramVarArgs)
  {
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        paramFilterableObserver.update(paramInt, paramVarArgs);
      }
    });
  }
  
  public void addObserver(FilterableObserver paramFilterableObserver)
  {
    addObserver(paramFilterableObserver, false);
  }
  
  public void addObserver(FilterableObserver paramFilterableObserver, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.mBgObservers.add(paramFilterableObserver);
        return;
      }
      finally {}
      this.mUIObservers.add(paramFilterableObserver);
    }
  }
  
  public void destroy()
  {
    try
    {
      this.mUIObservers.clear();
      this.mBgObservers.clear();
      if (this.mBgHandler != null) {
        this.mBgHandler.getLooper().quit();
      }
      this.mUIHandler = null;
      this.mBgHandler = null;
      return;
    }
    finally {}
  }
  
  public void notifyObservers(Class<? extends FilterableObserver> paramClass, int paramInt, Object... paramVarArgs)
  {
    Iterator localIterator;
    FilterableObserver localFilterableObserver;
    synchronized (this.mUIObservers)
    {
      localIterator = this.mUIObservers.iterator();
      while (localIterator.hasNext())
      {
        localFilterableObserver = (FilterableObserver)localIterator.next();
        if ((paramClass != null) && (localFilterableObserver != null) && (paramClass.isAssignableFrom(localFilterableObserver.getClass()))) {
          notifyObserver(localFilterableObserver, this.mUIHandler, paramInt, paramVarArgs);
        }
      }
    }
    synchronized (this.mBgObservers)
    {
      localIterator = this.mBgObservers.iterator();
      while (localIterator.hasNext())
      {
        localFilterableObserver = (FilterableObserver)localIterator.next();
        if ((paramClass != null) && (localFilterableObserver != null) && (paramClass.isAssignableFrom(localFilterableObserver.getClass()))) {
          notifyObserver(localFilterableObserver, this.mBgHandler, paramInt, paramVarArgs);
        }
      }
    }
  }
  
  public void removeObserver(FilterableObserver paramFilterableObserver)
  {
    if (paramFilterableObserver != null) {}
    try
    {
      this.mUIObservers.remove(paramFilterableObserver);
      this.mBgObservers.remove(paramFilterableObserver);
      return;
    }
    finally
    {
      paramFilterableObserver = finally;
      throw paramFilterableObserver;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.qav.observer.FilterableObservable
 * JD-Core Version:    0.7.0.1
 */