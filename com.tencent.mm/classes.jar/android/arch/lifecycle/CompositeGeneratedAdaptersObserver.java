package android.arch.lifecycle;

public class CompositeGeneratedAdaptersObserver
  implements GenericLifecycleObserver
{
  private final GeneratedAdapter[] ce;
  
  CompositeGeneratedAdaptersObserver(GeneratedAdapter[] paramArrayOfGeneratedAdapter)
  {
    this.ce = paramArrayOfGeneratedAdapter;
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    int j = 0;
    MethodCallsLogger localMethodCallsLogger = new MethodCallsLogger();
    GeneratedAdapter[] arrayOfGeneratedAdapter = this.ce;
    int k = arrayOfGeneratedAdapter.length;
    int i = 0;
    while (i < k)
    {
      arrayOfGeneratedAdapter[i].callMethods(paramLifecycleOwner, paramEvent, false, localMethodCallsLogger);
      i += 1;
    }
    arrayOfGeneratedAdapter = this.ce;
    k = arrayOfGeneratedAdapter.length;
    i = j;
    while (i < k)
    {
      arrayOfGeneratedAdapter[i].callMethods(paramLifecycleOwner, paramEvent, true, localMethodCallsLogger);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.CompositeGeneratedAdaptersObserver
 * JD-Core Version:    0.7.0.1
 */