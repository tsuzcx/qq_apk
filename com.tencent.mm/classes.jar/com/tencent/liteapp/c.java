package com.tencent.liteapp;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/liteapp/WxaLiteAppPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "wxa_lite_app_release"})
public final class c
  implements io.flutter.embedding.engine.plugins.a, k.c
{
  public static final c.a coF;
  private k aKT;
  
  static
  {
    AppMethodBeat.i(259166);
    coF = new c.a((byte)0);
    AppMethodBeat.o(259166);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(259161);
    p.k(paramb, "flutterPluginBinding");
    this.aKT = new k((io.flutter.plugin.a.c)paramb.iAZ().getDartExecutor(), "wxa_lite_app");
    paramb = this.aKT;
    if (paramb == null) {
      p.bGy("channel");
    }
    paramb.a((k.c)this);
    AppMethodBeat.o(259161);
  }
  
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(259163);
    p.k(paramj, "call");
    p.k(paramd, "result");
    if (p.h(paramj.method, "getPlatformVersion"))
    {
      paramd.bb("Android " + Build.VERSION.RELEASE);
      AppMethodBeat.o(259163);
      return;
    }
    paramd.epZ();
    AppMethodBeat.o(259163);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(259164);
    p.k(paramb, "binding");
    paramb = this.aKT;
    if (paramb == null) {
      p.bGy("channel");
    }
    paramb.a(null);
    AppMethodBeat.o(259164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteapp.c
 * JD-Core Version:    0.7.0.1
 */