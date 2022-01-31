package com.tencent.mm.accessibility;

import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class AccessibilityCapture$IAccessibilityManagerInvocationHandler
  implements InvocationHandler
{
  private final Object originalInstance;
  
  private AccessibilityCapture$IAccessibilityManagerInvocationHandler(Object paramObject)
  {
    this.originalInstance = paramObject;
  }
  
  public Object getOriginalInstance()
  {
    return this.originalInstance;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getName();
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    if ((paramObject.equals("sendAccessibilityEvent")) && (arrayOfClass.length == 2) && (arrayOfClass[0].equals(AccessibilityEvent.class)) && (arrayOfClass[1].equals(Integer.TYPE)))
    {
      paramObject = paramArrayOfObject[0];
      if ((paramObject == null) || (!(paramObject instanceof AccessibilityEvent))) {
        return null;
      }
      paramObject = (AccessibilityEvent)paramObject;
      if (AccessibilityCapture.access$200())
      {
        if ((AccessibilityCapture.access$300(paramObject)) && (AccessibilityCapture.access$400(paramObject))) {
          AccessibilityCapture.access$500(AccessibilityEvent.obtain(paramObject));
        }
        return paramMethod.invoke(this.originalInstance, paramArrayOfObject);
      }
      if ((AccessibilityCapture.access$300(paramObject)) && (AccessibilityCapture.access$400(paramObject)))
      {
        AccessibilityCapture.access$500(paramObject);
        return Boolean.valueOf(false);
      }
      AccessibilityCapture.access$600().v("MicroMsg.AccessibilityCapture", "filter a event: %s", new Object[] { AccessibilityEvent.eventTypeToString(paramObject.getEventType()) });
      return Boolean.valueOf(true);
    }
    AccessibilityCapture.access$600().i("MicroMsg.AccessibilityCapture", "[oneliang]original accessibility instance: %s,method name:%s", new Object[] { this.originalInstance, paramObject });
    if (this.originalInstance != null) {
      return paramMethod.invoke(this.originalInstance, paramArrayOfObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.accessibility.AccessibilityCapture.IAccessibilityManagerInvocationHandler
 * JD-Core Version:    0.7.0.1
 */