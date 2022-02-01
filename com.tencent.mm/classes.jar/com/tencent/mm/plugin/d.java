package com.tencent.mm.plugin;

import com.tencent.c.d.a;
import com.tencent.c.d.c;
import com.tencent.c.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/FlutterExptPlugin;", "Lcom/tencent/pigeon/FlutterExptPigeon$FlutterExptHost;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "get", "Lcom/tencent/pigeon/FlutterExptPigeon$FlutterExptResponse;", "request", "Lcom/tencent/pigeon/FlutterExptPigeon$FlutterExptRequest;", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "plugin-flutter-foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends d.a
  implements FlutterPlugin
{
  public final d.d a(d.c paramc)
  {
    AppMethodBeat.i(260312);
    s.u(paramc, "request");
    d.d locald = new d.d();
    locald.result = ((c)h.ax(c.class)).aqb(paramc.key);
    AppMethodBeat.o(260312);
    return locald;
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(260304);
    s.u(paramFlutterPluginBinding, "binding");
    d.a.a(paramFlutterPluginBinding.getBinaryMessenger(), (d.a)this);
    AppMethodBeat.o(260304);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(260307);
    s.u(paramFlutterPluginBinding, "binding");
    AppMethodBeat.o(260307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.d
 * JD-Core Version:    0.7.0.1
 */