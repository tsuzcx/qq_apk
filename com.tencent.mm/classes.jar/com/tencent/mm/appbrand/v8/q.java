package com.tencent.mm.appbrand.v8;

import com.eclipsesource.mmv8.JavaVoidCallback;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.z;
import com.tencent.mm.sdk.platformtools.Log;

final class q
  extends o
{
  z fja;
  private final JavaVoidCallback fjb;
  
  public q()
  {
    super("console");
    AppMethodBeat.i(144082);
    this.fjb = new JavaVoidCallback()
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
        if (q.this.fja != null) {
          q.this.fja.onError(paramAnonymousV8Object);
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
    paramV8Object.registerJavaMethod(this.fjb, "assert");
    paramV8Object.registerJavaMethod(this.fjb, "count");
    paramV8Object.registerJavaMethod(this.fjb, "profile");
    paramV8Object.registerJavaMethod(this.fjb, "profileEnd");
    paramV8Object.registerJavaMethod(this.fjb, "time");
    paramV8Object.registerJavaMethod(this.fjb, "timeEnd");
    paramV8Object.registerJavaMethod(this.fjb, "timeStamp");
    paramV8Object.registerJavaMethod(this.fjb, "takeHeapSnapshot");
    paramV8Object.registerJavaMethod(this.fjb, "group");
    paramV8Object.registerJavaMethod(this.fjb, "groupCollapsed");
    paramV8Object.registerJavaMethod(this.fjb, "groupEnd");
    paramV8Object.registerJavaMethod(this.fjb, "clear");
    paramV8Object.registerJavaMethod(this.fjb, "dir");
    paramV8Object.registerJavaMethod(this.fjb, "dirxml");
    paramV8Object.registerJavaMethod(this.fjb, "table");
    paramV8Object.registerJavaMethod(this.fjb, "trace");
    AppMethodBeat.o(144083);
  }
  
  public final void cleanup()
  {
    this.fja = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.q
 * JD-Core Version:    0.7.0.1
 */