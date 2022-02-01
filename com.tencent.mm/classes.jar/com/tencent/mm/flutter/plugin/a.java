package com.tencent.mm.flutter.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/flutter/plugin/MMFoundationPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "mm_foundation_release"}, k=1, mv={1, 1, 16})
public final class a
  implements FlutterPlugin
{
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(233296);
    s.t(paramFlutterPluginBinding, "binding");
    AppMethodBeat.o(233296);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(233298);
    s.t(paramFlutterPluginBinding, "binding");
    AppMethodBeat.o(233298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.a
 * JD-Core Version:    0.7.0.1
 */