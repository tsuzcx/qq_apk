package com.tencent.mm.plugin.flutter.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.platform.PlatformViewFactory;
import io.flutter.plugin.platform.PlatformViewRegistry;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/plugins/platform/PlatformViewPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "Companion", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements FlutterPlugin
{
  public static final c.a HkA;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(263161);
    HkA = new c.a((byte)0);
    TAG = "PlatformViewPlugin";
    AppMethodBeat.o(263161);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263169);
    s.u(paramFlutterPluginBinding, "binding");
    PlatformViewRegistry localPlatformViewRegistry = paramFlutterPluginBinding.getPlatformViewRegistry();
    paramFlutterPluginBinding = paramFlutterPluginBinding.getBinaryMessenger();
    s.s(paramFlutterPluginBinding, "binding.binaryMessenger");
    localPlatformViewRegistry.registerViewFactory("wxa_hybrid-pagview-type", (PlatformViewFactory)new b(paramFlutterPluginBinding));
    AppMethodBeat.o(263169);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263175);
    s.u(paramFlutterPluginBinding, "binding");
    AppMethodBeat.o(263175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.a.c
 * JD-Core Version:    0.7.0.1
 */