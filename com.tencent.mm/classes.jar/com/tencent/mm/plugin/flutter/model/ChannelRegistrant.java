package com.tencent.mm.plugin.flutter.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.e;
import com.tencent.mm.plugin.flutter.e.f;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.PluginRegistry;

public class ChannelRegistrant
{
  public static void registerWith(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(262986);
    if (paramFlutterEngine.getPlugins().has(b.class))
    {
      Log.w("ChannelRegistrant", "already registered");
      AppMethodBeat.o(262986);
      return;
    }
    Log.d("ChannelRegistrant", "registerWith FlutterEngine");
    paramFlutterEngine.getPlugins().add(new b());
    paramFlutterEngine.getPlugins().add(new c());
    paramFlutterEngine.getPlugins().add(new d());
    paramFlutterEngine.getPlugins().add(new f());
    paramFlutterEngine.getPlugins().add(new com.tencent.mm.plugin.c());
    paramFlutterEngine.getPlugins().add(new com.tencent.mm.plugin.d());
    paramFlutterEngine.getPlugins().add(new com.i.a.c());
    paramFlutterEngine.getPlugins().add(new e());
    paramFlutterEngine.getPlugins().add(new com.tencent.mm.plugin.b());
    paramFlutterEngine.getPlugins().add(new com.tencent.mm.plugin.flutter.d.a.c());
    paramFlutterEngine.addDataReportListener(new a(paramFlutterEngine));
    AppMethodBeat.o(262986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.ChannelRegistrant
 * JD-Core Version:    0.7.0.1
 */