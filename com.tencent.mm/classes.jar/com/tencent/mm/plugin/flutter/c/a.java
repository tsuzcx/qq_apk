package com.tencent.mm.plugin.flutter.c;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.plugin.a.m.c;
import io.flutter.plugin.a.m.f;
import io.flutter.view.FlutterNativeView;

public final class a
  implements k.c
{
  private final m.c aRg;
  
  public a(m.c paramc)
  {
    this.aRg = paramc;
  }
  
  private float cHZ()
  {
    AppMethodBeat.i(148875);
    float f2 = this.aRg.Iq().getWindow().getAttributes().screenBrightness;
    f1 = f2;
    if (f2 < 0.0F) {}
    try
    {
      int i = Settings.System.getInt(this.aRg.Ir().getContentResolver(), "screen_brightness");
      f1 = i / 255.0F;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      for (;;)
      {
        f1 = 1.0F;
        ac.printErrStackTrace("MicroMsg.FlutterScreenPlugin", localSettingNotFoundException, "", new Object[0]);
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
        paramd.daE();
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
    if (this.aRg.Iq() == null)
    {
      ac.w("MicroMsg.FlutterScreenPlugin", "activity is null, please must sure the activity have attach. ignore");
      paramd.e("MicroMsg.FlutterScreenPlugin", "activity is null", "");
      AppMethodBeat.o(148874);
      return;
    }
    paramd.db(Float.valueOf(cHZ()));
    AppMethodBeat.o(148874);
    return;
    if (this.aRg.Iq() == null)
    {
      ac.w("MicroMsg.FlutterScreenPlugin", "activity is null, please must sure the activity have attach. ignore");
      paramd.e("MicroMsg.FlutterScreenPlugin", "activity is null", "");
      AppMethodBeat.o(148874);
      return;
    }
    double d = ((Double)paramj.tn("brightness")).doubleValue();
    paramj = this.aRg.Iq().getWindow().getAttributes();
    paramj.screenBrightness = ((float)d);
    this.aRg.Iq().getWindow().setAttributes(paramj);
    paramd.db(null);
    AppMethodBeat.o(148874);
    return;
    if (this.aRg.Iq() == null)
    {
      ac.w("MicroMsg.FlutterScreenPlugin", "activity is null, please must sure the activity have attach. ignore");
      paramd.e("MicroMsg.FlutterScreenPlugin", "activity is null", "");
      AppMethodBeat.o(148874);
      return;
    }
    if ((this.aRg.Iq().getWindow().getAttributes().flags & 0x80) != 0) {}
    for (;;)
    {
      paramd.db(Boolean.valueOf(bool));
      AppMethodBeat.o(148874);
      return;
      bool = false;
    }
    if (this.aRg.Iq() == null)
    {
      ac.w("MicroMsg.FlutterScreenPlugin", "activity is null, please must sure the activity have attach. ignore");
      paramd.e("MicroMsg.FlutterScreenPlugin", "activity is null", "");
      AppMethodBeat.o(148874);
      return;
    }
    if (((Boolean)paramj.tn("on")).booleanValue())
    {
      ac.i("MicroMsg.FlutterScreenPlugin", "Keeping screen on ");
      this.aRg.Iq().getWindow().addFlags(128);
    }
    for (;;)
    {
      paramd.db(null);
      AppMethodBeat.o(148874);
      return;
      ac.i("MicroMsg.FlutterScreenPlugin", "Not keeping screen on");
      this.aRg.Iq().getWindow().clearFlags(128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.c.a
 * JD-Core Version:    0.7.0.1
 */