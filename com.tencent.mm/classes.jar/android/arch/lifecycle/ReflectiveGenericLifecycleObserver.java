package android.arch.lifecycle;

import java.util.List;
import java.util.Map;

class ReflectiveGenericLifecycleObserver
  implements GenericLifecycleObserver
{
  private final Object dm;
  private final ClassesInfoCache.CallbackInfo dn;
  
  ReflectiveGenericLifecycleObserver(Object paramObject)
  {
    this.dm = paramObject;
    this.dn = ClassesInfoCache.cb.c(this.dm.getClass());
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    ClassesInfoCache.CallbackInfo localCallbackInfo = this.dn;
    Object localObject = this.dm;
    ClassesInfoCache.CallbackInfo.a((List)localCallbackInfo.ce.get(paramEvent), paramLifecycleOwner, paramEvent, localObject);
    ClassesInfoCache.CallbackInfo.a((List)localCallbackInfo.ce.get(Lifecycle.Event.ON_ANY), paramLifecycleOwner, paramEvent, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ReflectiveGenericLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */