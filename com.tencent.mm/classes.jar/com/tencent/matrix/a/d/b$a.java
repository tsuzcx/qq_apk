package com.tencent.matrix.a.d;

import android.os.IBinder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class b$a
  implements InvocationHandler
{
  private final IBinder cvP;
  private final Object cvQ;
  
  b$a(IBinder paramIBinder, Object paramObject)
  {
    this.cvP = paramIBinder;
    this.cvQ = paramObject;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (("queryLocalInterface".equals(paramMethod.getName())) && (this.cvQ != null)) {
      return this.cvQ;
    }
    return paramMethod.invoke(this.cvP, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.matrix.a.d.b.a
 * JD-Core Version:    0.7.0.1
 */