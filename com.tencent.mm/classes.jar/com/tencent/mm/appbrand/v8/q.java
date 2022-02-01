package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.y;
import com.tencent.mm.sdk.platformtools.ac;

final class q
  extends o
{
  y cNB;
  private final JavaVoidCallback cNC;
  
  public q()
  {
    super("console");
    AppMethodBeat.i(144082);
    this.cNC = new JavaVoidCallback()
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
        ac.v("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144077);
      }
    }, "log");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144078);
        ac.i("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144078);
      }
    }, "info");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144079);
        ac.w("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144079);
      }
    }, "warn");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144080);
        paramAnonymousV8Object = paramAnonymousV8Array.toString();
        ac.e("MicroMsg.J2V8_Console", paramAnonymousV8Object);
        if (q.this.cNB != null) {
          q.this.cNB.onError(paramAnonymousV8Object);
        }
        AppMethodBeat.o(144080);
      }
    }, "error");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144081);
        ac.d("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144081);
      }
    }, "debug");
    paramV8Object.registerJavaMethod(this.cNC, "assert");
    paramV8Object.registerJavaMethod(this.cNC, "count");
    paramV8Object.registerJavaMethod(this.cNC, "profile");
    paramV8Object.registerJavaMethod(this.cNC, "profileEnd");
    paramV8Object.registerJavaMethod(this.cNC, "time");
    paramV8Object.registerJavaMethod(this.cNC, "timeEnd");
    paramV8Object.registerJavaMethod(this.cNC, "timeStamp");
    paramV8Object.registerJavaMethod(this.cNC, "takeHeapSnapshot");
    paramV8Object.registerJavaMethod(this.cNC, "group");
    paramV8Object.registerJavaMethod(this.cNC, "groupCollapsed");
    paramV8Object.registerJavaMethod(this.cNC, "groupEnd");
    paramV8Object.registerJavaMethod(this.cNC, "clear");
    paramV8Object.registerJavaMethod(this.cNC, "dir");
    paramV8Object.registerJavaMethod(this.cNC, "dirxml");
    paramV8Object.registerJavaMethod(this.cNC, "table");
    paramV8Object.registerJavaMethod(this.cNC, "trace");
    AppMethodBeat.o(144083);
  }
  
  public final void cleanup()
  {
    this.cNB = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.q
 * JD-Core Version:    0.7.0.1
 */