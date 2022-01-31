package android.arch.lifecycle;

public class SingleGeneratedAdapterObserver
  implements GenericLifecycleObserver
{
  private final GeneratedAdapter cG;
  
  SingleGeneratedAdapterObserver(GeneratedAdapter paramGeneratedAdapter)
  {
    this.cG = paramGeneratedAdapter;
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    this.cG.callMethods(paramLifecycleOwner, paramEvent, false, null);
    this.cG.callMethods(paramLifecycleOwner, paramEvent, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.SingleGeneratedAdapterObserver
 * JD-Core Version:    0.7.0.1
 */