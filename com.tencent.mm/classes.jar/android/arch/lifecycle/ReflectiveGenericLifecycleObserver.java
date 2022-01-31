package android.arch.lifecycle;

import java.util.List;
import java.util.Map;

class ReflectiveGenericLifecycleObserver
  implements GenericLifecycleObserver
{
  private final Object cD;
  private final ClassesInfoCache.CallbackInfo cE;
  
  ReflectiveGenericLifecycleObserver(Object paramObject)
  {
    this.cD = paramObject;
    this.cE = ClassesInfoCache.bU.e(this.cD.getClass());
  }
  
  public void onStateChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    ClassesInfoCache.CallbackInfo localCallbackInfo = this.cE;
    Object localObject = this.cD;
    ClassesInfoCache.CallbackInfo.a((List)localCallbackInfo.bX.get(paramEvent), paramLifecycleOwner, paramEvent, localObject);
    ClassesInfoCache.CallbackInfo.a((List)localCallbackInfo.bX.get(Lifecycle.Event.ON_ANY), paramLifecycleOwner, paramEvent, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ReflectiveGenericLifecycleObserver
 * JD-Core Version:    0.7.0.1
 */