package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

final class i$2
  implements JavaVoidCallback
{
  i$2(i parami, int paramInt) {}
  
  public final void invoke(V8Object paramV8Object, V8Array paramV8Array)
  {
    if ((paramV8Array.length() <= 0) || (paramV8Array.getType(0) != 4)) {
      return;
    }
    this.bzL.bzH.i(this.val$id, paramV8Array.getString(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.d.a.i.2
 * JD-Core Version:    0.7.0.1
 */