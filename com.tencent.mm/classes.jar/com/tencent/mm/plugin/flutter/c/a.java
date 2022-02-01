package com.tencent.mm.plugin.flutter.c;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import io.flutter.a.a.j;
import io.flutter.a.a.k.c;
import io.flutter.a.a.k.d;
import io.flutter.a.a.m.c;
import io.flutter.a.a.m.f;
import io.flutter.view.FlutterNativeView;

public final class a
  implements k.c
{
  private final m.c rdH;
  
  public a(m.c paramc)
  {
    this.rdH = paramc;
  }
  
  private float cuL()
  {
    AppMethodBeat.i(148875);
    float f2 = this.rdH.IH().getWindow().getAttributes().screenBrightness;
    f1 = f2;
    if (f2 < 0.0F) {}
    try
    {
      int i = Settings.System.getInt(this.rdH.II().getContentResolver(), "screen_brightness");
      f1 = i / 255.0F;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      for (;;)
      {
        f1 = 1.0F;
        ad.printErrStackTrace("MicroMsg.FLutterScreenPlugin", localSettingNotFoundException, "", new Object[0]);
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
        paramd.Av();
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
    paramd.ay(Float.valueOf(cuL()));
    AppMethodBeat.o(148874);
    return;
    double d = ((Double)paramj.qa("brightness")).doubleValue();
    paramj = this.rdH.IH().getWindow().getAttributes();
    paramj.screenBrightness = ((float)d);
    this.rdH.IH().getWindow().setAttributes(paramj);
    paramd.ay(null);
    AppMethodBeat.o(148874);
    return;
    if ((this.rdH.IH().getWindow().getAttributes().flags & 0x80) != 0) {}
    for (;;)
    {
      paramd.ay(Boolean.valueOf(bool));
      AppMethodBeat.o(148874);
      return;
      bool = false;
    }
    if (((Boolean)paramj.qa("on")).booleanValue())
    {
      ad.i("MicroMsg.FLutterScreenPlugin", "Keeping screen on ");
      this.rdH.IH().getWindow().addFlags(128);
    }
    for (;;)
    {
      paramd.ay(null);
      AppMethodBeat.o(148874);
      return;
      ad.i("MicroMsg.FLutterScreenPlugin", "Not keeping screen on");
      this.rdH.IH().getWindow().clearFlags(128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.c.a
 * JD-Core Version:    0.7.0.1
 */