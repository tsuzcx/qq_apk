package com.tencent.mm.plugin;

import com.tencent.c.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/FlutterAccountPlugin;", "Lcom/tencent/pigeon/FlutterAccountPigeon$FlutterAccountHost;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "getUin", "", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "plugin-flutter-foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a.a
  implements FlutterPlugin
{
  public final String getUin()
  {
    AppMethodBeat.i(260287);
    h.baC();
    String str = com.tencent.mm.kernel.b.aZs();
    s.s(str, "account().uinString");
    AppMethodBeat.o(260287);
    return str;
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(260293);
    s.u(paramFlutterPluginBinding, "binding");
    a.a.a(paramFlutterPluginBinding.getBinaryMessenger(), (a.a)this);
    AppMethodBeat.o(260293);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(260298);
    s.u(paramFlutterPluginBinding, "binding");
    a.a.a(paramFlutterPluginBinding.getBinaryMessenger(), null);
    AppMethodBeat.o(260298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.b
 * JD-Core Version:    0.7.0.1
 */