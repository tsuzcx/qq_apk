package com.tencent.matrix.a.d;

import android.os.IBinder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class b$a
  implements InvocationHandler
{
  private final IBinder csX;
  private final Object csY;
  
  b$a(IBinder paramIBinder, Object paramObject)
  {
    this.csX = paramIBinder;
    this.csY = paramObject;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (("queryLocalInterface".equals(paramMethod.getName())) && (this.csY != null)) {
      return this.csY;
    }
    return paramMethod.invoke(this.csX, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.matrix.a.d.b.a
 * JD-Core Version:    0.7.0.1
 */