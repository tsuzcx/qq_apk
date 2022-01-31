package android.arch.lifecycle;

import java.util.List;
import java.util.Map;

class ReflectiveGenericLifecycleObserver
  implements GenericLifecycleObserver
{
  private final Object dj;
  private final ClassesInfoCache.CallbackInfo dk;
  
  ReflectiveGenericLifecycleObserver(Object paramObject)
  {
    this.dj = paramObject;
    this.dk = ClassesInfoCache.bY.f(this.dj.getClass());
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    ClassesInfoCache.CallbackInfo localCallbackInfo = this.dk;
    Object localObject = this.dj;
    ClassesInfoCache.CallbackInfo.a((List)localCallbackInfo.cb.get(paramEvent), paramLifecycleOwner, paramEvent, localObject);
    ClassesInfoCache.CallbackInfo.a((List)localCallbackInfo.cb.get(Lifecycle.Event.ON_ANY), paramLifecycleOwner, paramEvent, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ReflectiveGenericLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */