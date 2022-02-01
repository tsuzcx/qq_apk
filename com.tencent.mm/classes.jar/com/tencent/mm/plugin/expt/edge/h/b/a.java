package com.tencent.mm.plugin.expt.edge.h.b;

import android.os.SystemClock;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a
  implements b
{
  public Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    if (paramV8Array == null) {
      paramV8Object = localObject1;
    }
    for (;;)
    {
      return paramV8Object;
      localObject1 = localObject3;
      try
      {
        long l = SystemClock.uptimeMillis();
        localObject1 = localObject3;
        localObject3 = b(paramV8Array);
        localObject1 = localObject3;
        com.tencent.mm.plugin.expt.edge.f.a.D(SystemClock.uptimeMillis() - l, getType());
        localObject1 = localObject3;
        Log.i("EdgeComputingJsApiBase", "[EdgeComputingJsApiBase] invoke type : " + getType());
        if ((paramV8Object != null) && (!paramV8Object.isReleased())) {
          paramV8Object.release();
        }
        paramV8Object = localObject3;
        if (paramV8Array == null) {
          continue;
        }
        paramV8Object = localObject3;
        if (paramV8Array.isReleased()) {
          continue;
        }
        paramV8Array.release();
        return localObject3;
      }
      catch (Exception localException)
      {
        Log.e("EdgeComputingJsApiBase", "[EdgeComputingJsApiBase] invoke throw Exception e : " + localException.getMessage());
        if ((paramV8Object != null) && (!paramV8Object.isReleased())) {
          paramV8Object.release();
        }
        paramV8Object = localObject1;
        if (paramV8Array == null) {
          continue;
        }
        paramV8Object = localObject1;
        if (paramV8Array.isReleased()) {
          continue;
        }
        paramV8Array.release();
        return localObject1;
      }
      finally
      {
        if ((paramV8Object != null) && (!paramV8Object.isReleased())) {
          paramV8Object.release();
        }
        if ((paramV8Array != null) && (!paramV8Array.isReleased())) {
          paramV8Array.release();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.h.b.a
 * JD-Core Version:    0.7.0.1
 */