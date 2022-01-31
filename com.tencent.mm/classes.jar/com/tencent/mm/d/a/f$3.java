package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

final class f$3
  implements JavaVoidCallback
{
  f$3(f paramf) {}
  
  public final void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if ((paramV8Array.length() <= 0) || (paramV8Array.getType(0) != 1)) {
      return;
    }
    f.a(this.bzq, paramV8Array.getInteger(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.d.a.f.3
 * JD-Core Version:    0.7.0.1
 */