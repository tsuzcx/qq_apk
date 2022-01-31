package android.arch.lifecycle;

class FullLifecycleObserverAdapter
  implements GenericLifecycleObserver
{
  private final FullLifecycleObserver cl;
  
  FullLifecycleObserverAdapter(FullLifecycleObserver paramFullLifecycleObserver)
  {
    this.cl = paramFullLifecycleObserver;
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    switch (1.cm[paramEvent.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.cl.onCreate(paramLifecycleOwner);
      return;
    case 2: 
      this.cl.onStart(paramLifecycleOwner);
      return;
    case 3: 
      this.cl.onResume(paramLifecycleOwner);
      return;
    case 4: 
      this.cl.onPause(paramLifecycleOwner);
      return;
    case 5: 
      this.cl.onStop(paramLifecycleOwner);
      return;
    case 6: 
      this.cl.onDestroy(paramLifecycleOwner);
      return;
    }
    throw new IllegalArgumentException("ON_ANY must not been send by anybody");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.FullLifecycleObserverAdapter
 * JD-Core Version:    0.7.0.1
 */