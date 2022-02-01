package com.tencent.matrix.iocanary.b;

import com.tencent.matrix.iocanary.c.a;
import com.tencent.matrix.report.d;
import com.tencent.matrix.report.d.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends d
  implements InvocationHandler
{
  private final Object cEb;
  
  public b(d.a parama, Object paramObject)
  {
    super(parama);
    this.cEb = paramObject;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    com.tencent.matrix.g.c.i("Matrix.CloseGuardInvocationHandler", "invoke method: %s", new Object[] { paramMethod.getName() });
    if (paramMethod.getName().equals("report"))
    {
      if (paramArrayOfObject.length != 2)
      {
        com.tencent.matrix.g.c.e("Matrix.CloseGuardInvocationHandler", "closeGuard report should has 2 params, current: %d", new Object[] { Integer.valueOf(paramArrayOfObject.length) });
        return null;
      }
      if (!(paramArrayOfObject[1] instanceof Throwable))
      {
        com.tencent.matrix.g.c.e("Matrix.CloseGuardInvocationHandler", "closeGuard report args 1 should be throwable, current: %s", new Object[] { paramArrayOfObject[1] });
        return null;
      }
      paramObject = a.getThrowableStack((Throwable)paramArrayOfObject[1]);
      if (dP(paramObject)) {
        com.tencent.matrix.g.c.d("Matrix.CloseGuardInvocationHandler", "close leak issue already published; key:%s", new Object[] { paramObject });
      }
      for (;;)
      {
        return null;
        paramMethod = new com.tencent.matrix.report.c(4);
        paramMethod.key = paramObject;
        paramArrayOfObject = new JSONObject();
        try
        {
          paramArrayOfObject.put("stack", paramObject);
          paramMethod.cEZ = paramArrayOfObject;
          b(paramMethod);
          com.tencent.matrix.g.c.i("Matrix.CloseGuardInvocationHandler", "close leak issue publish, key:%s", new Object[] { paramObject });
          dO(paramObject);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            com.tencent.matrix.g.c.e("Matrix.CloseGuardInvocationHandler", "json content error: %s", new Object[] { localJSONException });
          }
        }
      }
    }
    return paramMethod.invoke(this.cEb, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.iocanary.b.b
 * JD-Core Version:    0.7.0.1
 */