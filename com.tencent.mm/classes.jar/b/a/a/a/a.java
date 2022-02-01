package b.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.j;
import io.flutter.a.a.k.c;
import io.flutter.a.a.k.d;
import io.flutter.a.a.m.c;
import java.io.PrintStream;

public final class a
  implements k.c
{
  private m.c IWE;
  
  public a(m.c paramc)
  {
    this.IWE = paramc;
  }
  
  private float cuL()
  {
    AppMethodBeat.i(160027);
    float f2 = this.IWE.IH().getWindow().getAttributes().screenBrightness;
    f1 = f2;
    if (f2 < 0.0F) {}
    try
    {
      int i = Settings.System.getInt(this.IWE.II().getContentResolver(), "screen_brightness");
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
        paramd.Av();
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
    paramd.ay(Float.valueOf(cuL()));
    AppMethodBeat.o(160026);
    return;
    double d = ((Double)paramj.qa("brightness")).doubleValue();
    paramj = this.IWE.IH().getWindow().getAttributes();
    paramj.screenBrightness = ((float)d);
    this.IWE.IH().getWindow().setAttributes(paramj);
    paramd.ay(null);
    AppMethodBeat.o(160026);
    return;
    if ((this.IWE.IH().getWindow().getAttributes().flags & 0x80) != 0) {}
    for (;;)
    {
      paramd.ay(Boolean.valueOf(bool));
      AppMethodBeat.o(160026);
      return;
      bool = false;
    }
    if (((Boolean)paramj.qa("on")).booleanValue())
    {
      System.out.println("Keeping screen on ");
      this.IWE.IH().getWindow().addFlags(128);
    }
    for (;;)
    {
      paramd.ay(null);
      AppMethodBeat.o(160026);
      return;
      System.out.println("Not keeping screen on");
      this.IWE.IH().getWindow().clearFlags(128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     b.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */