package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.z;
import com.tencent.mm.sdk.platformtools.ae;

final class q
  extends o
{
  z cZP;
  private final JavaVoidCallback cZQ;
  
  public q()
  {
    super("console");
    AppMethodBeat.i(144082);
    this.cZQ = new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array) {}
    };
    AppMethodBeat.o(144082);
  }
  
  protected final void a(m paramm, V8Object paramV8Object)
  {
    AppMethodBeat.i(144083);
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144077);
        ae.v("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144077);
      }
    }, "log");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144078);
        ae.i("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144078);
      }
    }, "info");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144079);
        ae.w("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144079);
      }
    }, "warn");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144080);
        paramAnonymousV8Object = paramAnonymousV8Array.toString();
        ae.e("MicroMsg.J2V8_Console", paramAnonymousV8Object);
        if (q.this.cZP != null) {
          q.this.cZP.onError(paramAnonymousV8Object);
        }
        AppMethodBeat.o(144080);
      }
    }, "error");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144081);
        ae.d("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144081);
      }
    }, "debug");
    paramV8Object.registerJavaMethod(this.cZQ, "assert");
    paramV8Object.registerJavaMethod(this.cZQ, "count");
    paramV8Object.registerJavaMethod(this.cZQ, "profile");
    paramV8Object.registerJavaMethod(this.cZQ, "profileEnd");
    paramV8Object.registerJavaMethod(this.cZQ, "time");
    paramV8Object.registerJavaMethod(this.cZQ, "timeEnd");
    paramV8Object.registerJavaMethod(this.cZQ, "timeStamp");
    paramV8Object.registerJavaMethod(this.cZQ, "takeHeapSnapshot");
    paramV8Object.registerJavaMethod(this.cZQ, "group");
    paramV8Object.registerJavaMethod(this.cZQ, "groupCollapsed");
    paramV8Object.registerJavaMethod(this.cZQ, "groupEnd");
    paramV8Object.registerJavaMethod(this.cZQ, "clear");
    paramV8Object.registerJavaMethod(this.cZQ, "dir");
    paramV8Object.registerJavaMethod(this.cZQ, "dirxml");
    paramV8Object.registerJavaMethod(this.cZQ, "table");
    paramV8Object.registerJavaMethod(this.cZQ, "trace");
    AppMethodBeat.o(144083);
  }
  
  public final void cleanup()
  {
    this.cZP = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.q
 * JD-Core Version:    0.7.0.1
 */