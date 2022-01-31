package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements JavaCallback
{
  d$1(d paramd) {}
  
  public final Object invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    paramV8Object = Integer.valueOf(this.bzj.byZ.tD());
    y.i("V8DirectApiBuffer", "generateId:%d", new Object[] { paramV8Object });
    return paramV8Object;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.d.a.d.1
 * JD-Core Version:    0.7.0.1
 */