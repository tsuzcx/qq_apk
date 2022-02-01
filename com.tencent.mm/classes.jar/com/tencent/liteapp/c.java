package com.tencent.liteapp;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/liteapp/WxaLiteAppPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "Companion", "wxa_lite_app_release"}, k=1, mv={1, 1, 16})
public final class c
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  public static final c.a efQ;
  private MethodChannel channel;
  
  static
  {
    AppMethodBeat.i(218997);
    efQ = new c.a((byte)0);
    AppMethodBeat.o(218997);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(219005);
    s.t(paramFlutterPluginBinding, "flutterPluginBinding");
    this.channel = new MethodChannel((BinaryMessenger)paramFlutterPluginBinding.getFlutterEngine().getDartExecutor(), "wxa_lite_app");
    paramFlutterPluginBinding = this.channel;
    if (paramFlutterPluginBinding == null) {
      s.bIx("channel");
    }
    paramFlutterPluginBinding.setMethodCallHandler((MethodChannel.MethodCallHandler)this);
    AppMethodBeat.o(219005);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(219017);
    s.t(paramFlutterPluginBinding, "binding");
    paramFlutterPluginBinding = this.channel;
    if (paramFlutterPluginBinding == null) {
      s.bIx("channel");
    }
    paramFlutterPluginBinding.setMethodCallHandler(null);
    AppMethodBeat.o(219017);
  }
  
  public final void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(219012);
    s.t(paramMethodCall, "call");
    s.t(paramResult, "result");
    if (s.p(paramMethodCall.method, "getPlatformVersion"))
    {
      paramResult.success("Android " + Build.VERSION.RELEASE);
      AppMethodBeat.o(219012);
      return;
    }
    paramResult.notImplemented();
    AppMethodBeat.o(219012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.liteapp.c
 * JD-Core Version:    0.7.0.1
 */