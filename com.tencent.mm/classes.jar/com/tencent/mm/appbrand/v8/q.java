package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.z;
import com.tencent.mm.sdk.platformtools.Log;

final class q
  extends o
{
  z hnn;
  private final JavaVoidCallback hno;
  
  public q()
  {
    super("console");
    AppMethodBeat.i(144082);
    this.hno = new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array) {}
    };
    AppMethodBeat.o(144082);
  }
  
  protected final void b(m paramm, V8Object paramV8Object)
  {
    AppMethodBeat.i(144083);
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144077);
        paramAnonymousV8Object = paramAnonymousV8Array.toString();
        Log.v("MicroMsg.J2V8_Console", paramAnonymousV8Object);
        q.g(2, "MicroMsg.J2V8_Console", paramAnonymousV8Object);
        AppMethodBeat.o(144077);
      }
    }, "log");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144078);
        paramAnonymousV8Object = paramAnonymousV8Array.toString();
        Log.i("MicroMsg.J2V8_Console", paramAnonymousV8Object);
        q.g(4, "MicroMsg.J2V8_Console", paramAnonymousV8Object);
        AppMethodBeat.o(144078);
      }
    }, "info");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144079);
        paramAnonymousV8Object = paramAnonymousV8Array.toString();
        Log.w("MicroMsg.J2V8_Console", paramAnonymousV8Object);
        q.g(5, "MicroMsg.J2V8_Console", paramAnonymousV8Object);
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
        q.g(6, "MicroMsg.J2V8_Console", paramAnonymousV8Object);
        if (q.this.hnn != null) {
          q.this.hnn.onError(paramAnonymousV8Object);
        }
        AppMethodBeat.o(144080);
      }
    }, "error");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(144081);
        paramAnonymousV8Object = paramAnonymousV8Array.toString();
        Log.d("MicroMsg.J2V8_Console", paramAnonymousV8Object);
        q.g(3, "MicroMsg.J2V8_Console", paramAnonymousV8Object);
        AppMethodBeat.o(144081);
      }
    }, "debug");
    paramV8Object.registerJavaMethod(this.hno, "assert");
    paramV8Object.registerJavaMethod(this.hno, "count");
    paramV8Object.registerJavaMethod(this.hno, "profile");
    paramV8Object.registerJavaMethod(this.hno, "profileEnd");
    paramV8Object.registerJavaMethod(this.hno, "time");
    paramV8Object.registerJavaMethod(this.hno, "timeEnd");
    paramV8Object.registerJavaMethod(this.hno, "timeStamp");
    paramV8Object.registerJavaMethod(this.hno, "takeHeapSnapshot");
    paramV8Object.registerJavaMethod(this.hno, "group");
    paramV8Object.registerJavaMethod(this.hno, "groupCollapsed");
    paramV8Object.registerJavaMethod(this.hno, "groupEnd");
    paramV8Object.registerJavaMethod(this.hno, "clear");
    paramV8Object.registerJavaMethod(this.hno, "dir");
    paramV8Object.registerJavaMethod(this.hno, "dirxml");
    paramV8Object.registerJavaMethod(this.hno, "table");
    paramV8Object.registerJavaMethod(this.hno, "trace");
    AppMethodBeat.o(144083);
  }
  
  public final void cleanup()
  {
    this.hnn = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.q
 * JD-Core Version:    0.7.0.1
 */