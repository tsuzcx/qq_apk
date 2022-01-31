package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;
import com.tencent.mm.sdk.platformtools.y;

final class d$2
  implements JavaCallback
{
  d$2(d paramd, b paramb) {}
  
  public final Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if ((paramV8Array.length() <= 0) || (paramV8Array.getType(0) != 1))
    {
      y.w("V8DirectApiBuffer", "getNativeBuffer invalid parameters");
      return null;
    }
    y.i("V8DirectApiBuffer", "getNativeBuffer, id:%d", new Object[] { Integer.valueOf(paramV8Array.getInteger(0)) });
    paramV8Object = this.bzj.byZ.eu(paramV8Array.getInteger(0));
    if (paramV8Object == null)
    {
      y.w("V8DirectApiBuffer", "getNativeBuffer bb null");
      return null;
    }
    return this.bzk.byX.newV8ArrayBuffer(paramV8Object);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.d.a.d.2
 * JD-Core Version:    0.7.0.1
 */