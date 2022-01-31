package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8Object;

final class d
  extends c
{
  a byZ;
  
  d(a parama)
  {
    this.byZ = parama;
  }
  
  protected final void a(b paramb, V8Object paramV8Object)
  {
    paramV8Object.registerJavaMethod(new d.1(this), "getNativeBufferId");
    paramV8Object.registerJavaMethod(new d.2(this, paramb), "getNativeBuffer");
    paramV8Object.registerJavaMethod(new d.3(this), "setNativeBuffer");
  }
  
  public final void cleanup() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.d.a.d
 * JD-Core Version:    0.7.0.1
 */