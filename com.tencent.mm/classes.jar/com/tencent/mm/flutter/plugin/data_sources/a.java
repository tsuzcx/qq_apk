package com.tencent.mm.flutter.plugin.data_sources;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.flutter.plugin.data_sources.c.c;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/flutter/plugin/data_sources/FlutterDataSourcesService;", "Lcom/tencent/mm/flutter/plugin/data_sources/IFlutterDataSourcesService;", "()V", "registerFlutterPlugin", "", "engine", "Lio/flutter/embedding/engine/FlutterEngine;", "plugin-voip-status_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  public final void a(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(233300);
    s.u(paramFlutterEngine, "engine");
    paramFlutterEngine = paramFlutterEngine.getPlugins();
    paramFlutterEngine.add((FlutterPlugin)new com.tencent.mm.flutter.plugin.data_sources.c.a());
    paramFlutterEngine.add((FlutterPlugin)new com.tencent.mm.flutter.plugin.data_sources.c.b());
    paramFlutterEngine.add((FlutterPlugin)new c());
    AppMethodBeat.o(233300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.flutter.plugin.data_sources.a
 * JD-Core Version:    0.7.0.1
 */