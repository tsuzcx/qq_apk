package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.w;
import com.tencent.mm.sdk.platformtools.ab;

final class p
  extends n
{
  w cbZ;
  private final JavaVoidCallback cca;
  
  public p()
  {
    super("console");
    AppMethodBeat.i(113866);
    this.cca = new p.1(this);
    AppMethodBeat.o(113866);
  }
  
  protected final void a(l paraml, V8Object paramV8Object)
  {
    AppMethodBeat.i(113867);
    paramV8Object.registerJavaMethod(new p.2(this), "log");
    paramV8Object.registerJavaMethod(new p.3(this), "info");
    paramV8Object.registerJavaMethod(new p.4(this), "warn");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        AppMethodBeat.i(113864);
        paramAnonymousV8Object = paramAnonymousV8Array.toString();
        ab.e("MicroMsg.J2V8_Console", paramAnonymousV8Object);
        if (p.this.cbZ != null) {
          p.this.cbZ.onError(paramAnonymousV8Object);
        }
        AppMethodBeat.o(113864);
      }
    }, "error");
    paramV8Object.registerJavaMethod(new p.6(this), "debug");
    paramV8Object.registerJavaMethod(this.cca, "assert");
    paramV8Object.registerJavaMethod(this.cca, "count");
    paramV8Object.registerJavaMethod(this.cca, "profile");
    paramV8Object.registerJavaMethod(this.cca, "profileEnd");
    paramV8Object.registerJavaMethod(this.cca, "time");
    paramV8Object.registerJavaMethod(this.cca, "timeEnd");
    paramV8Object.registerJavaMethod(this.cca, "timeStamp");
    paramV8Object.registerJavaMethod(this.cca, "takeHeapSnapshot");
    paramV8Object.registerJavaMethod(this.cca, "group");
    paramV8Object.registerJavaMethod(this.cca, "groupCollapsed");
    paramV8Object.registerJavaMethod(this.cca, "groupEnd");
    paramV8Object.registerJavaMethod(this.cca, "clear");
    paramV8Object.registerJavaMethod(this.cca, "dir");
    paramV8Object.registerJavaMethod(this.cca, "dirxml");
    paramV8Object.registerJavaMethod(this.cca, "table");
    paramV8Object.registerJavaMethod(this.cca, "trace");
    AppMethodBeat.o(113867);
  }
  
  public final void cleanup()
  {
    this.cbZ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.d.a.p
 * JD-Core Version:    0.7.0.1
 */