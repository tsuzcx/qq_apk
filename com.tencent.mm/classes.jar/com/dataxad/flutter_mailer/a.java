package com.dataxad.flutter_mailer;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodChannel;

public final class a
  implements FlutterPlugin, ActivityAware
{
  private b cBC;
  private ActivityPluginBinding cBD;
  private MethodChannel channel;
  
  public final void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(206935);
    this.cBD = paramActivityPluginBinding;
    this.cBD.addActivityResultListener(this.cBC);
    this.cBC.activity = this.cBD.getActivity();
    AppMethodBeat.o(206935);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(206925);
    b localb = new b(paramFlutterPluginBinding.getApplicationContext());
    this.channel = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "flutter_mailer");
    this.cBC = localb;
    this.channel.setMethodCallHandler(localb);
    AppMethodBeat.o(206925);
  }
  
  public final void onDetachedFromActivity()
  {
    this.cBC.activity = null;
  }
  
  public final void onDetachedFromActivityForConfigChanges()
  {
    AppMethodBeat.i(206953);
    onDetachedFromActivity();
    AppMethodBeat.o(206953);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(206930);
    this.channel.setMethodCallHandler(null);
    if (this.cBD != null) {
      this.cBD.removeActivityResultListener(this.cBC);
    }
    this.channel = null;
    this.cBC = null;
    this.cBD = null;
    AppMethodBeat.o(206930);
  }
  
  public final void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(206944);
    onAttachedToActivity(paramActivityPluginBinding);
    AppMethodBeat.o(206944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.dataxad.flutter_mailer.a
 * JD-Core Version:    0.7.0.1
 */