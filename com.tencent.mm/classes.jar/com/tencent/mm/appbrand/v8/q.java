package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.y;
import com.tencent.mm.sdk.platformtools.ad;

final class q
  extends o
{
  y cYR;
  private final JavaVoidCallback cYS;
  
  public q()
  {
    super("console");
    AppMethodBeat.i(144082);
    this.cYS = new JavaVoidCallback()
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
        ad.v("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144077);
      }
    }, "log");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144078);
        ad.i("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144078);
      }
    }, "info");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144079);
        ad.w("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144079);
      }
    }, "warn");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144080);
        paramAnonymousV8Object = paramAnonymousV8Array.toString();
        ad.e("MicroMsg.J2V8_Console", paramAnonymousV8Object);
        if (q.this.cYR != null) {
          q.this.cYR.onError(paramAnonymousV8Object);
        }
        AppMethodBeat.o(144080);
      }
    }, "error");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144081);
        ad.d("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144081);
      }
    }, "debug");
    paramV8Object.registerJavaMethod(this.cYS, "assert");
    paramV8Object.registerJavaMethod(this.cYS, "count");
    paramV8Object.registerJavaMethod(this.cYS, "profile");
    paramV8Object.registerJavaMethod(this.cYS, "profileEnd");
    paramV8Object.registerJavaMethod(this.cYS, "time");
    paramV8Object.registerJavaMethod(this.cYS, "timeEnd");
    paramV8Object.registerJavaMethod(this.cYS, "timeStamp");
    paramV8Object.registerJavaMethod(this.cYS, "takeHeapSnapshot");
    paramV8Object.registerJavaMethod(this.cYS, "group");
    paramV8Object.registerJavaMethod(this.cYS, "groupCollapsed");
    paramV8Object.registerJavaMethod(this.cYS, "groupEnd");
    paramV8Object.registerJavaMethod(this.cYS, "clear");
    paramV8Object.registerJavaMethod(this.cYS, "dir");
    paramV8Object.registerJavaMethod(this.cYS, "dirxml");
    paramV8Object.registerJavaMethod(this.cYS, "table");
    paramV8Object.registerJavaMethod(this.cYS, "trace");
    AppMethodBeat.o(144083);
  }
  
  public final void cleanup()
  {
    this.cYR = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.q
 * JD-Core Version:    0.7.0.1
 */