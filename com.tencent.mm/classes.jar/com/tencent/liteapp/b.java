package com.tencent.liteapp;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.a.b;
import io.flutter.plugin.a.c;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/liteapp/WxaLiteAppPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "wxa_lite_app_release"})
public final class b
  implements io.flutter.embedding.engine.plugins.a, k.c
{
  public static final b.a cqR;
  private k bbv;
  
  static
  {
    AppMethodBeat.i(197922);
    cqR = new b.a((byte)0);
    AppMethodBeat.o(197922);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(197919);
    p.h(paramb, "flutterPluginBinding");
    this.bbv = new k((c)paramb.hwW().getDartExecutor(), "wxa_lite_app");
    paramb = this.bbv;
    if (paramb == null) {
      p.btv("channel");
    }
    paramb.a((k.c)this);
    AppMethodBeat.o(197919);
  }
  
  public final void a(j paramj, k.d paramd)
  {
    AppMethodBeat.i(197920);
    p.h(paramj, "call");
    p.h(paramd, "result");
    if (p.j(paramj.method, "getPlatformVersion"))
    {
      paramd.ba("Android " + Build.VERSION.RELEASE);
      AppMethodBeat.o(197920);
      return;
    }
    paramd.dLv();
    AppMethodBeat.o(197920);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(197921);
    p.h(paramb, "binding");
    paramb = this.bbv;
    if (paramb == null) {
      p.btv("channel");
    }
    paramb.a(null);
    AppMethodBeat.o(197921);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteapp.b
 * JD-Core Version:    0.7.0.1
 */