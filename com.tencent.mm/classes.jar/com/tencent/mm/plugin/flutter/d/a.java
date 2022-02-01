package com.tencent.mm.plugin.flutter.d;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.plugin.a.m.c;
import io.flutter.plugin.a.m.f;
import io.flutter.view.FlutterNativeView;

public final class a
  implements k.c
{
  private final m.c bbB;
  
  public a(m.c paramc)
  {
    this.bbB = paramc;
  }
  
  private float cST()
  {
    AppMethodBeat.i(148875);
    float f2 = this.bbB.JY().getWindow().getAttributes().screenBrightness;
    f1 = f2;
    if (f2 < 0.0F) {}
    try
    {
      int i = Settings.System.getInt(this.bbB.JZ().getContentResolver(), "screen_brightness");
      f1 = i / 255.0F;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      for (;;)
      {
        f1 = 1.0F;
        ae.printErrStackTrace("MicroMsg.FlutterScreenPlugin", localSettingNotFoundException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(148875);
    return f1;
  }
  
  public final void a(j paramj, k.d paramd)
  {
    boolean bool = true;
    AppMethodBeat.i(148874);
    String str = paramj.method;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramd.dmQ();
        AppMethodBeat.o(148874);
        return;
        if (str.equals("brightness"))
        {
          i = 0;
          continue;
          if (str.equals("setBrightness"))
          {
            i = 1;
            continue;
            if (str.equals("isKeptOn"))
            {
              i = 2;
              continue;
              if (str.equals("keepOn")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    if (this.bbB.JY() == null)
    {
      ae.w("MicroMsg.FlutterScreenPlugin", "activity is null, please must sure the activity have attach. ignore");
      paramd.f("MicroMsg.FlutterScreenPlugin", "activity is null", "");
      AppMethodBeat.o(148874);
      return;
    }
    paramd.df(Float.valueOf(cST()));
    AppMethodBeat.o(148874);
    return;
    if (this.bbB.JY() == null)
    {
      ae.w("MicroMsg.FlutterScreenPlugin", "activity is null, please must sure the activity have attach. ignore");
      paramd.f("MicroMsg.FlutterScreenPlugin", "activity is null", "");
      AppMethodBeat.o(148874);
      return;
    }
    double d = ((Double)paramj.wM("brightness")).doubleValue();
    paramj = this.bbB.JY().getWindow().getAttributes();
    paramj.screenBrightness = ((float)d);
    this.bbB.JY().getWindow().setAttributes(paramj);
    paramd.df(null);
    AppMethodBeat.o(148874);
    return;
    if (this.bbB.JY() == null)
    {
      ae.w("MicroMsg.FlutterScreenPlugin", "activity is null, please must sure the activity have attach. ignore");
      paramd.f("MicroMsg.FlutterScreenPlugin", "activity is null", "");
      AppMethodBeat.o(148874);
      return;
    }
    if ((this.bbB.JY().getWindow().getAttributes().flags & 0x80) != 0) {}
    for (;;)
    {
      paramd.df(Boolean.valueOf(bool));
      AppMethodBeat.o(148874);
      return;
      bool = false;
    }
    if (this.bbB.JY() == null)
    {
      ae.w("MicroMsg.FlutterScreenPlugin", "activity is null, please must sure the activity have attach. ignore");
      paramd.f("MicroMsg.FlutterScreenPlugin", "activity is null", "");
      AppMethodBeat.o(148874);
      return;
    }
    if (((Boolean)paramj.wM("on")).booleanValue())
    {
      ae.i("MicroMsg.FlutterScreenPlugin", "Keeping screen on ");
      this.bbB.JY().getWindow().addFlags(128);
    }
    for (;;)
    {
      paramd.df(null);
      AppMethodBeat.o(148874);
      return;
      ae.i("MicroMsg.FlutterScreenPlugin", "Not keeping screen on");
      this.bbB.JY().getWindow().clearFlags(128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.d.a
 * JD-Core Version:    0.7.0.1
 */