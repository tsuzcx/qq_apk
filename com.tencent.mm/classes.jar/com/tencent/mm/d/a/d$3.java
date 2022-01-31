package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8ArrayBuffer;
import com.eclipsesource.v8.V8Object;
import com.tencent.mm.sdk.platformtools.y;

final class d$3
  implements JavaVoidCallback
{
  d$3(d paramd) {}
  
  public final void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if ((paramV8Array.length() < 2) || (paramV8Array.getType(0) != 1) || (paramV8Array.getType(1) != 10))
    {
      y.w("V8DirectApiBuffer", "setNativeBuffer invalid parameters");
      return;
    }
    y.w("V8DirectApiBuffer", "setNativeBuffer, id:%d", new Object[] { Integer.valueOf(paramV8Array.getType(0)) });
    paramV8Object = (V8ArrayBuffer)paramV8Array.get(1);
    if (paramV8Object != null)
    {
      this.bzj.byZ.a(paramV8Array.getInteger(0), paramV8Object.getBackingStore());
      paramV8Object.release();
      return;
    }
    y.w("V8DirectApiBuffer", "setNativeBuffer buffer null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.d.a.d.3
 * JD-Core Version:    0.7.0.1
 */