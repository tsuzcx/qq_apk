package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.z;
import com.tencent.mm.sdk.platformtools.Log;

final class q
  extends o
{
  z dqt;
  private final JavaVoidCallback dqu;
  
  public q()
  {
    super("console");
    AppMethodBeat.i(144082);
    this.dqu = new JavaVoidCallback()
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
        Log.v("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144077);
      }
    }, "log");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144078);
        Log.i("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144078);
      }
    }, "info");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144079);
        Log.w("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144079);
      }
    }, "warn");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144080);
        paramAnonymousV8Object = paramAnonymousV8Array.toString();
        Log.e("MicroMsg.J2V8_Console", paramAnonymousV8Object);
        if (q.this.dqt != null) {
          q.this.dqt.onError(paramAnonymousV8Object);
        }
        AppMethodBeat.o(144080);
      }
    }, "error");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144081);
        Log.d("MicroMsg.J2V8_Console", paramAnonymousV8Array.toString());
        AppMethodBeat.o(144081);
      }
    }, "debug");
    paramV8Object.registerJavaMethod(this.dqu, "assert");
    paramV8Object.registerJavaMethod(this.dqu, "count");
    paramV8Object.registerJavaMethod(this.dqu, "profile");
    paramV8Object.registerJavaMethod(this.dqu, "profileEnd");
    paramV8Object.registerJavaMethod(this.dqu, "time");
    paramV8Object.registerJavaMethod(this.dqu, "timeEnd");
    paramV8Object.registerJavaMethod(this.dqu, "timeStamp");
    paramV8Object.registerJavaMethod(this.dqu, "takeHeapSnapshot");
    paramV8Object.registerJavaMethod(this.dqu, "group");
    paramV8Object.registerJavaMethod(this.dqu, "groupCollapsed");
    paramV8Object.registerJavaMethod(this.dqu, "groupEnd");
    paramV8Object.registerJavaMethod(this.dqu, "clear");
    paramV8Object.registerJavaMethod(this.dqu, "dir");
    paramV8Object.registerJavaMethod(this.dqu, "dirxml");
    paramV8Object.registerJavaMethod(this.dqu, "table");
    paramV8Object.registerJavaMethod(this.dqu, "trace");
    AppMethodBeat.o(144083);
  }
  
  public final void cleanup()
  {
    this.dqt = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.q
 * JD-Core Version:    0.7.0.1
 */