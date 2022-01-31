package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.utils.V8ObjectUtils;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

final class f$1
  implements JavaCallback
{
  f$1(f paramf, b paramb) {}
  
  public final Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if ((paramV8Array.length() <= 0) || (paramV8Array.getType(0) != 7))
    {
      y.w("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout parameters invalid length:%d type[0]:%d", new Object[] { Integer.valueOf(paramV8Array.length()), Integer.valueOf(paramV8Array.getType(0)) });
      return null;
    }
    V8Function localV8Function = (V8Function)paramV8Array.getObject(0);
    int i;
    if (paramV8Array.length() > 1) {
      if (paramV8Array.getType(1) == 1) {
        i = paramV8Array.getInteger(1);
      }
    }
    label326:
    for (;;)
    {
      if (paramV8Array.length() > 2) {
        paramV8Object = V8ObjectUtils.toList(paramV8Array);
      }
      for (paramV8Object = V8ObjectUtils.toV8Array(this.bzk.byX, paramV8Object.subList(2, paramV8Object.size() - 1));; paramV8Object = this.bzk.byX.newV8Array())
      {
        y.d("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout %d", new Object[] { Integer.valueOf(i) });
        paramV8Array = this.bzq;
        b localb = this.bzk;
        Timer localTimer = new Timer();
        Integer localInteger = Integer.valueOf(paramV8Array.bzo.addAndGet(1));
        paramV8Object = new f.a(paramV8Array, localb.byX, localTimer, localInteger.intValue(), localV8Function, paramV8Object);
        localTimer.schedule(new f.5(paramV8Array, localb, paramV8Object), i);
        paramV8Array.bzp.put(localInteger, paramV8Object);
        return Integer.valueOf(localInteger.intValue());
        if (paramV8Array.getType(1) == 2)
        {
          i = (int)paramV8Array.getDouble(1);
          break;
        }
        if (paramV8Array.getType(1) == 4)
        {
          i = f.cC(paramV8Array.getString(1));
          if (i != -2147483648) {
            break label326;
          }
          return null;
        }
        y.w("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout parameters[1] type:%d", new Object[] { Integer.valueOf(paramV8Array.getType(1)) });
        return null;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.d.a.f.1
 * JD-Core Version:    0.7.0.1
 */