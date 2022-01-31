package com.tencent.mm.accessibility;

import android.view.accessibility.AccessibilityEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(118625);
    paramObject = paramMethod.getName();
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    if ((paramObject.equals("sendAccessibilityEvent")) && (arrayOfClass.length == 2) && (arrayOfClass[0].equals(AccessibilityEvent.class)) && (arrayOfClass[1].equals(Integer.TYPE)))
    {
      paramObject = paramArrayOfObject[0];
      if ((paramObject == null) || (!(paramObject instanceof AccessibilityEvent)))
      {
        AppMethodBeat.o(118625);
        return null;
      }
      paramObject = (AccessibilityEvent)paramObject;
      if (AccessibilityCapture.access$200())
      {
        if ((AccessibilityCapture.access$300(paramObject)) && (AccessibilityCapture.access$400(paramObject))) {
          AccessibilityCapture.access$500(AccessibilityEvent.obtain(paramObject));
        }
        paramObject = paramMethod.invoke(this.originalInstance, paramArrayOfObject);
        AppMethodBeat.o(118625);
        return paramObject;
      }
      if ((AccessibilityCapture.access$300(paramObject)) && (AccessibilityCapture.access$400(paramObject)))
      {
        AccessibilityCapture.access$500(paramObject);
        paramObject = Boolean.FALSE;
        AppMethodBeat.o(118625);
        return paramObject;
      }
      AccessibilityCapture.access$600().v("MicroMsg.AccessibilityCapture", "filter a event: %s", new Object[] { AccessibilityEvent.eventTypeToString(paramObject.getEventType()) });
      paramObject = Boolean.TRUE;
      AppMethodBeat.o(118625);
      return paramObject;
    }
    AccessibilityCapture.access$600().i("MicroMsg.AccessibilityCapture", "[oneliang]original accessibility instance: %s,method name:%s", new Object[] { this.originalInstance, paramObject });
    if (this.originalInstance != null)
    {
      paramObject = paramMethod.invoke(this.originalInstance, paramArrayOfObject);
      AppMethodBeat.o(118625);
      return paramObject;
    }
    AppMethodBeat.o(118625);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.accessibility.AccessibilityCapture.IAccessibilityManagerInvocationHandler
 * JD-Core Version:    0.7.0.1
 */