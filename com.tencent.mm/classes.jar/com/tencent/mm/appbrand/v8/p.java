package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaCallback;
import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8ArrayBuffer;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class p
  extends o
{
  e fhB;
  
  p(e parame)
  {
    this.fhB = parame;
  }
  
  protected final void a(final m paramm, V8Object paramV8Object)
  {
    AppMethodBeat.i(144076);
    paramV8Object.registerJavaMethod(new JavaCallback()
    {
      public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144073);
        paramAnonymousV8Object = Integer.valueOf(p.this.fhB.generateId());
        Log.d("V8DirectApiBuffer", "generateId:%d", new Object[] { paramAnonymousV8Object });
        AppMethodBeat.o(144073);
        return paramAnonymousV8Object;
      }
    }, "getNativeBufferId");
    paramV8Object.registerJavaMethod(new JavaCallback()
    {
      public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144074);
        if ((paramAnonymousV8Array.length() <= 0) || (paramAnonymousV8Array.getType(0) != 1))
        {
          Log.w("V8DirectApiBuffer", "getNativeBuffer invalid parameters");
          AppMethodBeat.o(144074);
          return null;
        }
        Log.d("V8DirectApiBuffer", "getNativeBuffer, id:%d", new Object[] { Integer.valueOf(paramAnonymousV8Array.getInteger(0)) });
        paramAnonymousV8Object = p.this.fhB.getBuffer(paramAnonymousV8Array.getInteger(0), false);
        if (paramAnonymousV8Object == null)
        {
          Log.w("V8DirectApiBuffer", "getNativeBuffer bb null");
          AppMethodBeat.o(144074);
          return null;
        }
        paramAnonymousV8Object = paramm.acm().newV8ArrayBuffer(paramAnonymousV8Object);
        AppMethodBeat.o(144074);
        return paramAnonymousV8Object;
      }
    }, "getNativeBuffer");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144075);
        if ((paramAnonymousV8Array.length() < 2) || (paramAnonymousV8Array.getType(0) != 1) || (paramAnonymousV8Array.getType(1) != 10))
        {
          Log.w("V8DirectApiBuffer", "setNativeBuffer invalid parameters");
          AppMethodBeat.o(144075);
          return;
        }
        Log.d("V8DirectApiBuffer", "setNativeBuffer, id:%d", new Object[] { Integer.valueOf(paramAnonymousV8Array.getInteger(0)) });
        paramAnonymousV8Object = (V8ArrayBuffer)paramAnonymousV8Array.get(1);
        if (paramAnonymousV8Object != null)
        {
          p.this.fhB.setBuffer(paramAnonymousV8Array.getInteger(0), paramAnonymousV8Object.getBackingStore());
          paramAnonymousV8Object.release();
          AppMethodBeat.o(144075);
          return;
        }
        Log.w("V8DirectApiBuffer", "setNativeBuffer buffer null");
        AppMethodBeat.o(144075);
      }
    }, "setNativeBuffer");
    AppMethodBeat.o(144076);
  }
  
  public final void cleanup() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.p
 * JD-Core Version:    0.7.0.1
 */