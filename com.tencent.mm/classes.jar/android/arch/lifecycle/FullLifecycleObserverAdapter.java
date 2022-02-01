package android.arch.lifecycle;

class FullLifecycleObserverAdapter
  implements GenericLifecycleObserver
{
  private final FullLifecycleObserver co;
  
  FullLifecycleObserverAdapter(FullLifecycleObserver paramFullLifecycleObserver)
  {
    this.co = paramFullLifecycleObserver;
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    switch (1.cp[paramEvent.ordinal()])
    {
    default: 
      return;
    case 1: 
      this.co.onCreate(paramLifecycleOwner);
      return;
    case 2: 
      this.co.onStart(paramLifecycleOwner);
      return;
    case 3: 
      this.co.onResume(paramLifecycleOwner);
      return;
    case 4: 
      this.co.onPause(paramLifecycleOwner);
      return;
    case 5: 
      this.co.onStop(paramLifecycleOwner);
      return;
    case 6: 
      this.co.onDestroy(paramLifecycleOwner);
      return;
    }
    throw new IllegalArgumentException("ON_ANY must not been send by anybody");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.FullLifecycleObserverAdapter
 * JD-Core Version:    0.7.0.1
 */