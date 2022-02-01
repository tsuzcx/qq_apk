package com.tencent.matrix.iocanary.b;

import com.tencent.matrix.e.c;
import com.tencent.matrix.iocanary.c.a;
import com.tencent.matrix.report.g;
import com.tencent.matrix.report.h;
import com.tencent.matrix.report.h.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends h
  implements InvocationHandler
{
  private final Object eVx;
  
  public b(h.a parama, Object paramObject)
  {
    super(parama);
    this.eVx = paramObject;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    c.i("Matrix.CloseGuardInvocationHandler", "invoke method: %s", new Object[] { paramMethod.getName() });
    if (paramMethod.getName().equals("report"))
    {
      if (paramArrayOfObject.length != 2)
      {
        c.e("Matrix.CloseGuardInvocationHandler", "closeGuard report should has 2 params, current: %d", new Object[] { Integer.valueOf(paramArrayOfObject.length) });
        return null;
      }
      if (!(paramArrayOfObject[1] instanceof Throwable))
      {
        c.e("Matrix.CloseGuardInvocationHandler", "closeGuard report args 1 should be throwable, current: %s", new Object[] { paramArrayOfObject[1] });
        return null;
      }
      paramObject = a.getThrowableStack((Throwable)paramArrayOfObject[1]);
      if (gY(paramObject)) {
        c.d("Matrix.CloseGuardInvocationHandler", "close leak issue already published; key:%s", new Object[] { paramObject });
      }
      for (;;)
      {
        return null;
        paramMethod = new g(4);
        paramMethod.key = paramObject;
        paramArrayOfObject = new JSONObject();
        try
        {
          paramArrayOfObject.put("stack", paramObject);
          paramMethod.eYz = paramArrayOfObject;
          b(paramMethod);
          c.i("Matrix.CloseGuardInvocationHandler", "close leak issue publish, key:%s", new Object[] { paramObject });
          gX(paramObject);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            c.e("Matrix.CloseGuardInvocationHandler", "json content error: %s", new Object[] { localJSONException });
          }
        }
      }
    }
    return paramMethod.invoke(this.eVx, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.iocanary.b.b
 * JD-Core Version:    0.7.0.1
 */