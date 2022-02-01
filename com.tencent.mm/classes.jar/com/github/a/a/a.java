package com.github.a.a;

import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.d;
import io.flutter.plugin.a.d.a;
import io.flutter.plugin.a.d.c;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import java.util.List;

public final class a
  implements k.c
{
  k aKT;
  d aKU;
  OrientationEventListener aKV;
  int aKW = -1;
  Activity activity;
  
  public final void a(j paramj, k.d paramd)
  {
    int j = 0;
    AppMethodBeat.i(215355);
    if (this.activity == null)
    {
      paramd.b("NO_ACTIVITY", "OrientationPlugin requires a foreground activity.", null);
      AppMethodBeat.o(215355);
      return;
    }
    String str = paramj.method;
    paramj = paramj.ZZe;
    int k;
    int i;
    if (str.equals("SystemChrome.setEnabledSystemUIOverlays"))
    {
      paramj = (List)paramj;
      k = 7942;
      if (j < paramj.size())
      {
        if (paramj.get(j).equals("SystemUiOverlay.top")) {
          i = k & 0xFFFFFFFB;
        }
        for (;;)
        {
          j += 1;
          k = i;
          break;
          i = k;
          if (paramj.get(j).equals("SystemUiOverlay.bottom")) {
            i = k & 0xFFFFFFFD;
          }
        }
      }
      this.activity.getWindow().getDecorView().setSystemUiVisibility(k);
      paramd.bb(null);
      AppMethodBeat.o(215355);
      return;
    }
    if (str.equals("SystemChrome.setPreferredOrientations"))
    {
      paramj = (List)paramj;
      j = 0;
      k = 0;
      if (j < paramj.size())
      {
        if (paramj.get(j).equals("DeviceOrientation.portraitUp")) {
          i = k | 0x1;
        }
        for (;;)
        {
          j += 1;
          k = i;
          break;
          if (paramj.get(j).equals("DeviceOrientation.landscapeLeft"))
          {
            i = k | 0x2;
          }
          else if (paramj.get(j).equals("DeviceOrientation.portraitDown"))
          {
            i = k | 0x4;
          }
          else
          {
            i = k;
            if (paramj.get(j).equals("DeviceOrientation.landscapeRight")) {
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
        paramd.bb(null);
        AppMethodBeat.o(215355);
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
      paramj = (String)paramj;
      if (paramj.equals("DeviceOrientation.portraitUp")) {
        this.activity.setRequestedOrientation(1);
      }
      for (;;)
      {
        paramd.bb(null);
        AppMethodBeat.o(215355);
        return;
        if (paramj.equals("DeviceOrientation.portraitDown")) {
          this.activity.setRequestedOrientation(9);
        } else if (paramj.equals("DeviceOrientation.landscapeLeft")) {
          this.activity.setRequestedOrientation(8);
        } else if (paramj.equals("DeviceOrientation.landscapeRight")) {
          this.activity.setRequestedOrientation(0);
        } else {
          this.activity.setRequestedOrientation(-1);
        }
      }
    }
    paramd.epZ();
    AppMethodBeat.o(215355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.github.a.a.a
 * JD-Core Version:    0.7.0.1
 */