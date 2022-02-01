package com.github.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;

public final class b
  implements FlutterPlugin, ActivityAware
{
  private a cEU;
  private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
  
  public final void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(208226);
    this.cEU = new a();
    a locala = this.cEU;
    paramActivityPluginBinding = paramActivityPluginBinding.getActivity();
    BinaryMessenger localBinaryMessenger = this.flutterPluginBinding.getBinaryMessenger();
    locala.activity = paramActivityPluginBinding;
    locala.channel = new MethodChannel(localBinaryMessenger, "sososdk.github.com/orientation");
    locala.channel.setMethodCallHandler(locala);
    locala.eventChannel = new EventChannel(localBinaryMessenger, "sososdk.github.com/orientationEvent");
    locala.eventChannel.setStreamHandler(new a.1(locala, paramActivityPluginBinding));
    AppMethodBeat.o(208226);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.flutterPluginBinding = paramFlutterPluginBinding;
  }
  
  public final void onDetachedFromActivity()
  {
    AppMethodBeat.i(208227);
    if (this.cEU == null)
    {
      AppMethodBeat.o(208227);
      return;
    }
    a locala = this.cEU;
    if (locala.channel != null)
    {
      locala.channel.setMethodCallHandler(null);
      locala.channel = null;
    }
    if (locala.eventChannel != null)
    {
      locala.eventChannel.setStreamHandler(null);
      locala.eventChannel = null;
    }
    AppMethodBeat.o(208227);
  }
  
  public final void onDetachedFromActivityForConfigChanges()
  {
    AppMethodBeat.i(208229);
    onDetachedFromActivity();
    AppMethodBeat.o(208229);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.flutterPluginBinding = null;
  }
  
  public final void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(208228);
    onAttachedToActivity(paramActivityPluginBinding);
    AppMethodBeat.o(208228);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.github.a.a.b
 * JD-Core Version:    0.7.0.1
 */