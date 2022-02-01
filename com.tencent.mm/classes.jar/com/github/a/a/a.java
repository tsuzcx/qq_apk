package com.github.a.a;

import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.EventChannel.StreamHandler;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.util.List;

public final class a
  implements MethodChannel.MethodCallHandler
{
  Activity activity;
  private OrientationEventListener cEP;
  private int cEQ = -1;
  MethodChannel channel;
  EventChannel eventChannel;
  
  public final void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    int j = 0;
    AppMethodBeat.i(208230);
    if (this.activity == null)
    {
      paramResult.error("NO_ACTIVITY", "OrientationPlugin requires a foreground activity.", null);
      AppMethodBeat.o(208230);
      return;
    }
    String str = paramMethodCall.method;
    paramMethodCall = paramMethodCall.arguments;
    int k;
    int i;
    if (str.equals("SystemChrome.setEnabledSystemUIOverlays"))
    {
      paramMethodCall = (List)paramMethodCall;
      k = 7942;
      if (j < paramMethodCall.size())
      {
        if (paramMethodCall.get(j).equals("SystemUiOverlay.top")) {
          i = k & 0xFFFFFFFB;
        }
        for (;;)
        {
          j += 1;
          k = i;
          break;
          i = k;
          if (paramMethodCall.get(j).equals("SystemUiOverlay.bottom")) {
            i = k & 0xFFFFFFFD;
          }
        }
      }
      this.activity.getWindow().getDecorView().setSystemUiVisibility(k);
      paramResult.success(null);
      AppMethodBeat.o(208230);
      return;
    }
    if (str.equals("SystemChrome.setPreferredOrientations"))
    {
      paramMethodCall = (List)paramMethodCall;
      j = 0;
      k = 0;
      if (j < paramMethodCall.size())
      {
        if (paramMethodCall.get(j).equals("DeviceOrientation.portraitUp")) {
          i = k | 0x1;
        }
        for (;;)
        {
          j += 1;
          k = i;
          break;
          if (paramMethodCall.get(j).equals("DeviceOrientation.landscapeLeft"))
          {
            i = k | 0x2;
          }
          else if (paramMethodCall.get(j).equals("DeviceOrientation.portraitDown"))
          {
            i = k | 0x4;
          }
          else
          {
            i = k;
            if (paramMethodCall.get(j).equals("DeviceOrientation.landscapeRight")) {
              i = k | 0x8;
            }
          }
        }
      }
      switch (k)
      {
      }
      for (;;)
      {
        paramResult.success(null);
        AppMethodBeat.o(208230);
        return;
        this.activity.setRequestedOrientation(-1);
        continue;
        this.activity.setRequestedOrientation(1);
        continue;
        this.activity.setRequestedOrientation(0);
        continue;
        this.activity.setRequestedOrientation(9);
        continue;
        this.activity.setRequestedOrientation(12);
        continue;
        this.activity.setRequestedOrientation(8);
        continue;
        this.activity.setRequestedOrientation(11);
        continue;
        this.activity.setRequestedOrientation(2);
        continue;
        this.activity.setRequestedOrientation(13);
        continue;
        this.activity.setRequestedOrientation(13);
      }
    }
    if (str.equals("SystemChrome.forceOrientation"))
    {
      paramMethodCall = (String)paramMethodCall;
      if (paramMethodCall.equals("DeviceOrientation.portraitUp")) {
        this.activity.setRequestedOrientation(1);
      }
      for (;;)
      {
        paramResult.success(null);
        AppMethodBeat.o(208230);
        return;
        if (paramMethodCall.equals("DeviceOrientation.portraitDown")) {
          this.activity.setRequestedOrientation(9);
        } else if (paramMethodCall.equals("DeviceOrientation.landscapeLeft")) {
          this.activity.setRequestedOrientation(8);
        } else if (paramMethodCall.equals("DeviceOrientation.landscapeRight")) {
          this.activity.setRequestedOrientation(0);
        } else {
          this.activity.setRequestedOrientation(-1);
        }
      }
    }
    paramResult.notImplemented();
    AppMethodBeat.o(208230);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.github.a.a.a
 * JD-Core Version:    0.7.0.1
 */