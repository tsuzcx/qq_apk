package com.tencent.mm.accessibility;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class AccessibilityCapture$IAccessibilityManagerClientInvocationHandler
  implements InvocationHandler
{
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    paramObject = paramMethod.getName();
    paramMethod = paramMethod.getParameterTypes();
    if ((paramObject.equals("setState")) && (paramMethod.length == 1) && (paramMethod[0].equals(Integer.TYPE)))
    {
      paramObject = paramArrayOfObject[0];
      if ((paramObject != null) && ((paramObject instanceof Integer))) {}
    }
    else
    {
      return null;
    }
    int i = ((Integer)paramObject).intValue();
    AccessibilityCapture.access$600().i("MicroMsg.AccessibilityCapture", "setState %d", new Object[] { Integer.valueOf(i) });
    AccessibilityCapture.access$700(i);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.accessibility.AccessibilityCapture.IAccessibilityManagerClientInvocationHandler
 * JD-Core Version:    0.7.0.1
 */