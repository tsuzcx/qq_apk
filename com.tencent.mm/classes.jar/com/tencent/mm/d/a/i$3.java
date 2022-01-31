package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Function;

public final class i$3
  implements Runnable
{
  public i$3(i parami, b paramb, String paramString) {}
  
  public final void run()
  {
    b localb = this.bzK;
    String str = this.bhH;
    if (localb.byX.getType("onmessage") == 7)
    {
      V8Function localV8Function = (V8Function)localb.byX.get("onmessage");
      V8Array localV8Array = localb.byX.newV8Array();
      localV8Array.push(str);
      localV8Function.call(localb.byX.getGlobalObject(), localV8Array);
      localV8Function.release();
      localV8Array.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.d.a.i.3
 * JD-Core Version:    0.7.0.1
 */