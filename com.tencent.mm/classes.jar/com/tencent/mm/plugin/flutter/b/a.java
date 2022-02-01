package com.tencent.mm.plugin.flutter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.d;
import com.tencent.mm.plugin.e;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.plugins.connectivity.patched.PatchedConnectivityPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/base/BasicPluginsRegistry;", "", "()V", "register", "", "plugins", "Lio/flutter/embedding/engine/plugins/PluginRegistry;", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Hkd;
  
  static
  {
    AppMethodBeat.i(263148);
    Hkd = new a();
    AppMethodBeat.o(263148);
  }
  
  public static void a(PluginRegistry paramPluginRegistry)
  {
    AppMethodBeat.i(263137);
    s.u(paramPluginRegistry, "plugins");
    paramPluginRegistry.add((FlutterPlugin)new PathProviderPlugin());
    paramPluginRegistry.add((FlutterPlugin)new PatchedConnectivityPlugin());
    paramPluginRegistry.add((FlutterPlugin)new com.tencent.mm.plugin.flutter.model.b());
    paramPluginRegistry.add((FlutterPlugin)new com.tencent.mm.plugin.flutter.model.c());
    paramPluginRegistry.add((FlutterPlugin)new com.tencent.mm.plugin.c());
    paramPluginRegistry.add((FlutterPlugin)new d());
    paramPluginRegistry.add((FlutterPlugin)new com.tencent.mm.plugin.b());
    paramPluginRegistry.add((FlutterPlugin)new e());
    paramPluginRegistry.add((FlutterPlugin)new d.a.a.b.a());
    paramPluginRegistry.add((FlutterPlugin)new d.a.a.a.a());
    AppMethodBeat.o(263137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.b.a
 * JD-Core Version:    0.7.0.1
 */