package com.tencent.qav.observer;

public class ObserverDispatcher
  extends FilterableObservable
{
  private static ObserverDispatcher sInstance;
  private static final Object sInstanceLock = new Object();
  
  public static ObserverDispatcher instance()
  {
    if (sInstance == null) {}
    synchronized (sInstanceLock)
    {
      if (sInstance == null) {
        sInstance = new ObserverDispatcher();
      }
      return sInstance;
    }
  }
  
  public void destroy()
  {
    super.destroy();
    sInstance = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.qav.observer.ObserverDispatcher
 * JD-Core Version:    0.7.0.1
 */