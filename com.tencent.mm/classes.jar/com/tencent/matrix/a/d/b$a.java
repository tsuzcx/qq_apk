package com.tencent.matrix.a.d;

import android.os.IBinder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class b$a
  implements InvocationHandler
{
  private final IBinder cEA;
  private final Object cEB;
  
  b$a(IBinder paramIBinder, Object paramObject)
  {
    this.cEA = paramIBinder;
    this.cEB = paramObject;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (("queryLocalInterface".equals(paramMethod.getName())) && (this.cEB != null)) {
      return this.cEB;
    }
    return paramMethod.invoke(this.cEA, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.matrix.a.d.b.a
 * JD-Core Version:    0.7.0.1
 */