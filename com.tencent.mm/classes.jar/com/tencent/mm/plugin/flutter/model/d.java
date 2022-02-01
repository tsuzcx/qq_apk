package com.tencent.mm.plugin.flutter.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  private Context context;
  private MethodChannel methodChannel;
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263006);
    Log.i("MicroMsg.Flutter.FlutterLvCppHandler", "onAttachedToEngine FlutterLvCppHandler CHANNEL%s", new Object[] { "com.tencent.mm.mmflutter.lvcppmethod" });
    this.methodChannel = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "com.tencent.mm.mmflutter.lvcppmethod");
    this.methodChannel.setMethodCallHandler(this);
    this.context = paramFlutterPluginBinding.getApplicationContext();
    AppMethodBeat.o(263006);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(263012);
    this.methodChannel.setMethodCallHandler(null);
    AppMethodBeat.o(263012);
  }
  
  public final void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(148873);
    if (paramMethodCall.method.equals("getDisplayParams"))
    {
      paramMethodCall = new JSONObject();
      try
      {
        DisplayMetrics localDisplayMetrics = this.context.getResources().getDisplayMetrics();
        Point localPoint = aw.bf(this.context);
        paramMethodCall.put("screenWidth", localPoint.x);
        paramMethodCall.put("screenHeight", localPoint.y);
        paramMethodCall.put("densityDpi", localDisplayMetrics.densityDpi);
        paramMethodCall.put("density", localDisplayMetrics.density);
        paramResult.success(paramMethodCall.toString());
        AppMethodBeat.o(148873);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Flutter.FlutterLvCppHandler", localJSONException, "", new Object[0]);
        }
      }
    }
    paramResult.notImplemented();
    AppMethodBeat.o(148873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.d
 * JD-Core Version:    0.7.0.1
 */