package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.mm.plugin.appbrand.i.q;

final class e$5
  implements JavaVoidCallback
{
  e$5(e parame) {}
  
  public final void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    paramV8Object = paramV8Array.toString();
    if (this.bzn.bzl != null) {
      this.bzn.bzl.onError(paramV8Object);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.d.a.e.5
 * JD-Core Version:    0.7.0.1
 */