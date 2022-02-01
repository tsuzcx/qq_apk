package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class r
  extends o
{
  final d cPD;
  
  public r(d paramd)
  {
    super("WeixinArrayBuffer");
    this.cPD = paramd;
  }
  
  protected final void a(m paramm, V8Object paramV8Object)
  {
    AppMethodBeat.i(144085);
    paramV8Object.registerJavaMethod(new JavaCallback()
    {
      public final Object invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144084);
        if ((paramAnonymousV8Array.length() <= 0) || (paramAnonymousV8Array.getType(0) != 1))
        {
          ad.w("MicroMsg.V8DirectApiSharedBuffer", "get invalid parameters");
          AppMethodBeat.o(144084);
          return null;
        }
        int i = paramAnonymousV8Array.getInteger(0);
        ad.i("MicroMsg.V8DirectApiSharedBuffer", "get, id:%d", new Object[] { Integer.valueOf(i) });
        paramAnonymousV8Object = r.this.cPD.hG(i);
        AppMethodBeat.o(144084);
        return paramAnonymousV8Object;
      }
    }, "get");
    AppMethodBeat.o(144085);
  }
  
  final void cleanup() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.r
 * JD-Core Version:    0.7.0.1
 */