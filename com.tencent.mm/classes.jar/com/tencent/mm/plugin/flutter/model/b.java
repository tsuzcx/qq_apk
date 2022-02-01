package com.tencent.mm.plugin.flutter.model;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.Map;

public class b
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private MethodChannel methodChannel;
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263026);
    Log.i("MicroMsg.Flutter.FlutterCrashReportPlugin", "onAttachedToEngine FlutterCrashReportPlugin CHANNEL%s", new Object[] { "com.tencent.mm.flutter.crashreport" });
    this.methodChannel = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "com.tencent.mm.flutter.crashreport");
    this.methodChannel.setMethodCallHandler(this);
    AppMethodBeat.o(263026);
  }
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263034);
    this.methodChannel.setMethodCallHandler(null);
    AppMethodBeat.o(263034);
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(148871);
    Log.d("MicroMsg.Flutter.FlutterCrashReportPlugin", "onMethodCall method", new Object[] { paramMethodCall.method });
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
      AppMethodBeat.o(148871);
      return;
      if (!paramResult.equals("crash_report")) {
        break;
      }
      i = 0;
      break;
      paramResult = (Map)paramMethodCall.argument("crashInfo");
      String str = (String)paramMethodCall.argument("sessionId");
      boolean bool = ((Boolean)paramMethodCall.argument("killSelf")).booleanValue();
      paramMethodCall = new StringBuffer();
      paramMethodCall.append("\n#deviceParameters=" + paramResult.get("deviceParameters"));
      paramMethodCall.append("\n#customParameters=" + paramResult.get("customParameters"));
      paramMethodCall.append("\n#applicationParameters=" + paramResult.get("applicationParameters"));
      paramMethodCall.append("\n#dateTime=" + paramResult.get("dateTime"));
      paramMethodCall.append("\n#context=" + paramResult.get("context"));
      com.tencent.mm.plugin.flutter.c.a locala = com.tencent.mm.plugin.flutter.c.a.Hkw;
      com.tencent.mm.plugin.flutter.c.a.c(paramResult, bool);
      long l = System.currentTimeMillis();
      Log.i("MicroMsg.Flutter.FlutterReportLogic", "reportFlutterActionAction %s %s", new Object[] { "FlutterCrash", str });
      f.Ozc.b(17326, new Object[] { Long.valueOf(l), "FlutterCrash", str });
      f.Ozc.idkeyStat(1053L, 2L, 1L, false);
      CrashReportFactory.reportCrashMessage(paramMethodCall.toString(), "Flutter\n\tErrorMsg=" + paramResult.get("error") + "\n" + paramResult.get("stackTrace") + "\nkillSelf" + bool);
      Log.appenderFlushSync();
      if (bool)
      {
        Log.appenderClose();
        paramMethodCall = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        paramResult = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(paramResult, paramMethodCall.aYi(), "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)paramMethodCall.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramResult, "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        paramMethodCall = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        paramResult = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(paramResult, paramMethodCall.aYi(), "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "java/lang/System_EXEC_", "exit", "(I)V");
        System.exit(((Integer)paramMethodCall.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramResult, "com/tencent/mm/plugin/flutter/model/FlutterCrashReportPlugin", "onMethodCall", "(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "java/lang/System_EXEC_", "exit", "(I)V");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.b
 * JD-Core Version:    0.7.0.1
 */