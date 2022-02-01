package com.tencent.mm.plugin.flutter.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

public final class c
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private MethodChannel methodChannel;
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263024);
    Log.i("MicroMsg.Flutter.FlutterDataReportPlugin", "onAttachedToEngine FlutterDataReportPlugin CHANNEL%s", new Object[] { "com.tencent.mm.flutter.datareport" });
    this.methodChannel = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "com.tencent.mm.flutter.datareport");
    this.methodChannel.setMethodCallHandler(this);
    AppMethodBeat.o(263024);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263032);
    if (this.methodChannel != null) {
      this.methodChannel.setMethodCallHandler(null);
    }
    AppMethodBeat.o(263032);
  }
  
  public final void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(148872);
    paramResult = paramMethodCall.method;
    int i = -1;
    switch (paramResult.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(148872);
      return;
      if (!paramResult.equals("android_kv_report")) {
        break;
      }
      i = 0;
      break;
      if (!paramResult.equals("android_idkey_report")) {
        break;
      }
      i = 1;
      break;
      i = ((Integer)paramMethodCall.argument("id")).intValue();
      paramMethodCall = (String)paramMethodCall.argument("value");
      f.Ozc.kvStat(i, paramMethodCall);
      AppMethodBeat.o(148872);
      return;
      i = ((Integer)paramMethodCall.argument("id")).intValue();
      int j = ((Integer)paramMethodCall.argument("key")).intValue();
      int k = ((Integer)paramMethodCall.argument("value")).intValue();
      f.Ozc.idkeyStat(i, j, k, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.c
 * JD-Core Version:    0.7.0.1
 */