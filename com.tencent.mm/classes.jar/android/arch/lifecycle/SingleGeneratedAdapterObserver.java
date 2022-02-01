package android.arch.lifecycle;

public class SingleGeneratedAdapterObserver
  implements GenericLifecycleObserver
{
  private final GeneratedAdapter ds;
  
  SingleGeneratedAdapterObserver(GeneratedAdapter paramGeneratedAdapter)
  {
    this.ds = paramGeneratedAdapter;
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    this.ds.callMethods(paramLifecycleOwner, paramEvent, false, null);
    this.ds.callMethods(paramLifecycleOwner, paramEvent, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.SingleGeneratedAdapterObserver
 * JD-Core Version:    0.7.0.1
 */