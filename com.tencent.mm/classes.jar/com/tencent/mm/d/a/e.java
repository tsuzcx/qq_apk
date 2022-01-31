package com.tencent.mm.d.a;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.tencent.mm.plugin.appbrand.i.q;

public final class e
  extends c
{
  public q bzl;
  private final JavaVoidCallback bzm = new JavaVoidCallback()
  {
    public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array) {}
  };
  
  public e()
  {
    super("console");
  }
  
  protected final void a(b paramb, V8Object paramV8Object)
  {
    paramV8Object.registerJavaMethod(new e.2(this), "log");
    paramV8Object.registerJavaMethod(new e.3(this), "info");
    paramV8Object.registerJavaMethod(new e.4(this), "warn");
    paramV8Object.registerJavaMethod(new e.5(this), "error");
    paramV8Object.registerJavaMethod(new JavaVoidCallback()
    {
      public final void invoke(V8Object paramAnonymousV8Object, V8Array paramAnonymousV8Array)
      {
        paramAnonymousV8Array.toString();
      }
    }, "debug");
    paramV8Object.registerJavaMethod(this.bzm, "assert");
    paramV8Object.registerJavaMethod(this.bzm, "count");
    paramV8Object.registerJavaMethod(this.bzm, "profile");
    paramV8Object.registerJavaMethod(this.bzm, "profileEnd");
    paramV8Object.registerJavaMethod(this.bzm, "time");
    paramV8Object.registerJavaMethod(this.bzm, "timeEnd");
    paramV8Object.registerJavaMethod(this.bzm, "timeStamp");
    paramV8Object.registerJavaMethod(this.bzm, "takeHeapSnapshot");
    paramV8Object.registerJavaMethod(this.bzm, "group");
    paramV8Object.registerJavaMethod(this.bzm, "groupCollapsed");
    paramV8Object.registerJavaMethod(this.bzm, "groupEnd");
    paramV8Object.registerJavaMethod(this.bzm, "clear");
    paramV8Object.registerJavaMethod(this.bzm, "dir");
    paramV8Object.registerJavaMethod(this.bzm, "dirxml");
    paramV8Object.registerJavaMethod(this.bzm, "table");
    paramV8Object.registerJavaMethod(this.bzm, "trace");
  }
  
  public final void cleanup() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.d.a.e
 * JD-Core Version:    0.7.0.1
 */