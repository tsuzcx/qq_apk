package b.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.plugin.a.m.c;
import java.io.PrintStream;

public final class a
  implements k.c
{
  private m.c KJP;
  
  public a(m.c paramc)
  {
    this.KJP = paramc;
  }
  
  private float cHZ()
  {
    AppMethodBeat.i(160027);
    float f2 = this.KJP.Iq().getWindow().getAttributes().screenBrightness;
    f1 = f2;
    if (f2 < 0.0F) {}
    try
    {
      int i = Settings.System.getInt(this.KJP.Ir().getContentResolver(), "screen_brightness");
      f1 = i / 255.0F;
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      for (;;)
      {
        f1 = 1.0F;
      }
    }
    AppMethodBeat.o(160027);
    return f1;
  }
  
  public final void a(j paramj, k.d paramd)
  {
    boolean bool = true;
    AppMethodBeat.i(160026);
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
        AppMethodBeat.o(160026);
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
    paramd.db(Float.valueOf(cHZ()));
    AppMethodBeat.o(160026);
    return;
    double d = ((Double)paramj.tn("brightness")).doubleValue();
    paramj = this.KJP.Iq().getWindow().getAttributes();
    paramj.screenBrightness = ((float)d);
    this.KJP.Iq().getWindow().setAttributes(paramj);
    paramd.db(null);
    AppMethodBeat.o(160026);
    return;
    if ((this.KJP.Iq().getWindow().getAttributes().flags & 0x80) != 0) {}
    for (;;)
    {
      paramd.db(Boolean.valueOf(bool));
      AppMethodBeat.o(160026);
      return;
      bool = false;
    }
    if (((Boolean)paramj.tn("on")).booleanValue())
    {
      System.out.println("Keeping screen on ");
      this.KJP.Iq().getWindow().addFlags(128);
    }
    for (;;)
    {
      paramd.db(null);
      AppMethodBeat.o(160026);
      return;
      System.out.println("Not keeping screen on");
      this.KJP.Iq().getWindow().clearFlags(128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     b.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */