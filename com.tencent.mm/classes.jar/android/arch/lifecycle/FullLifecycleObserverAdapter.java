package android.arch.lifecycle;

class FullLifecycleObserverAdapter
  implements GenericLifecycleObserver
{
  private final FullLifecycleObserver cb;
  
  FullLifecycleObserverAdapter(FullLifecycleObserver paramFullLifecycleObserver)
  {
    this.cb = paramFullLifecycleObserver;
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    switch (1.cc[paramEvent.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.cb.onCreate(paramLifecycleOwner);
      return;
    case 2: 
      this.cb.onStart(paramLifecycleOwner);
      return;
    case 3: 
      this.cb.onResume(paramLifecycleOwner);
      return;
    case 4: 
      this.cb.onPause(paramLifecycleOwner);
      return;
    case 5: 
      this.cb.onStop(paramLifecycleOwner);
      return;
    case 6: 
      this.cb.onDestroy(paramLifecycleOwner);
      return;
    }
    throw new IllegalArgumentException("ON_ANY must not been send by anybody");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.FullLifecycleObserverAdapter
 * JD-Core Version:    0.7.0.1
 */