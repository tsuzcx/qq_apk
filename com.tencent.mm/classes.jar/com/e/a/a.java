package com.e.a;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/jhomlala/catcher/CatcherPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "catcher_release"}, k=1, mv={1, 1, 16})
public final class a
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private MethodChannel channel;
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(206937);
    s.t(paramFlutterPluginBinding, "flutterPluginBinding");
    this.channel = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "catcher");
    paramFlutterPluginBinding = this.channel;
    if (paramFlutterPluginBinding == null) {
      s.bIx("channel");
    }
    paramFlutterPluginBinding.setMethodCallHandler((MethodChannel.MethodCallHandler)this);
    AppMethodBeat.o(206937);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(206952);
    s.t(paramFlutterPluginBinding, "binding");
    paramFlutterPluginBinding = this.channel;
    if (paramFlutterPluginBinding == null) {
      s.bIx("channel");
    }
    paramFlutterPluginBinding.setMethodCallHandler(null);
    AppMethodBeat.o(206952);
  }
  
  public final void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(130925);
    s.t(paramMethodCall, "call");
    s.t(paramResult, "result");
    if (s.p(paramMethodCall.method, "getPlatformVersion"))
    {
      paramResult.success("Android " + Build.VERSION.RELEASE);
      AppMethodBeat.o(130925);
      return;
    }
    paramResult.notImplemented();
    AppMethodBeat.o(130925);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.e.a.a
 * JD-Core Version:    0.7.0.1
 */