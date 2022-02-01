package com.tencent.mm.plugin.flutter.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.EngineDataReportListener;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.embedding.engine.systemchannels.StatChannel;
import java.nio.charset.StandardCharsets;

public final class a
  implements EngineDataReportListener
{
  private FlutterUiDisplayListener Hku;
  private boolean aUP;
  private final FlutterEngine.EngineLifecycleListener engineLifecycleListener;
  private final FlutterEngine flutterEngine;
  
  public a(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(263007);
    this.aUP = false;
    this.engineLifecycleListener = new FlutterEngine.EngineLifecycleListener()
    {
      public final void onEngineWillDestroy()
      {
        AppMethodBeat.i(262989);
        Log.d("MicroMsg.Flutter.EngineDataReportHandler", "onEngineWillDestroy");
        a.a(a.this);
        a.c(a.this).removeEngineLifecycleListener(a.b(a.this));
        a.c(a.this).getRenderer().removeIsDisplayingFlutterUiListener(a.d(a.this));
        AppMethodBeat.o(262989);
      }
      
      public final void onPreEngineRestart() {}
    };
    this.Hku = new FlutterUiDisplayListener()
    {
      public final void onFlutterUiDisplayed()
      {
        AppMethodBeat.i(262982);
        Log.i("MicroMsg.Flutter.EngineDataReportHandler", "onFlutterUiDisplayed");
        if (!a.e(a.this)) {
          a.c(a.this).getStatChannel().reportMemoryUsage();
        }
        AppMethodBeat.o(262982);
      }
      
      public final void onFlutterUiNoLongerDisplayed() {}
    };
    Log.i("MicroMsg.Flutter.EngineDataReportHandler", "EngineDataReportHandler ".concat(String.valueOf(paramFlutterEngine)));
    this.flutterEngine = paramFlutterEngine;
    paramFlutterEngine.addEngineLifecycleListener(this.engineLifecycleListener);
    paramFlutterEngine.getRenderer().addIsDisplayingFlutterUiListener(this.Hku);
    AppMethodBeat.o(263007);
  }
  
  public final void onReportJSON(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(263047);
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, StandardCharsets.UTF_8);
      Log.i("MicroMsg.Flutter.EngineDataReportHandler", "onReportJSON: ".concat(String.valueOf(paramArrayOfByte)));
      f.Ozc.kvStat(24757, "flutter_engine_mm," + paramArrayOfByte.replaceAll(",", ";"));
      AppMethodBeat.o(263047);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.Flutter.EngineDataReportHandler", paramArrayOfByte, "parse json sys err", new Object[0]);
      AppMethodBeat.o(263047);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.model.a
 * JD-Core Version:    0.7.0.1
 */