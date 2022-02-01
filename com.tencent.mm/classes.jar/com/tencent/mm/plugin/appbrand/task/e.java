package com.tencent.mm.plugin.appbrand.task;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.game.f.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.q;

public enum e
{
  public final int code;
  public final int lwA;
  public final Class<? extends q> lwB;
  public final Class<? extends aa> lwC;
  
  static
  {
    AppMethodBeat.i(48433);
    lwx = new e("WASERVICE", 0, 1, 2147483647, com.tencent.mm.plugin.appbrand.service.c.class, ae.class);
    lwy = new e("WAGAME", 1, 2, 2, com.tencent.mm.plugin.appbrand.game.c.class, d.class);
    lwz = new e("NIL", 2, 0, 0, null, null);
    lwD = new e[] { lwx, lwy, lwz };
    AppMethodBeat.o(48433);
  }
  
  private e(int paramInt1, int paramInt2, Class<? extends q> paramClass, Class<? extends aa> paramClass1)
  {
    this.code = paramInt1;
    this.lwA = paramInt2;
    this.lwB = paramClass;
    this.lwC = paramClass1;
  }
  
  public static e J(Intent paramIntent)
  {
    AppMethodBeat.i(48431);
    int j = paramIntent.getIntExtra("AppBrandServiceType", lwz.code);
    paramIntent = values();
    int k = paramIntent.length;
    int i = 0;
    while (i < k)
    {
      e locale = paramIntent[i];
      if (locale.code == j)
      {
        AppMethodBeat.o(48431);
        return locale;
      }
      i += 1;
    }
    paramIntent = new IllegalStateException("AppBrandServiceType DeserializeFrom[Intent] Unreached Code");
    AppMethodBeat.o(48431);
    throw paramIntent;
  }
  
  public static e gW(boolean paramBoolean)
  {
    if (paramBoolean) {
      return lwy;
    }
    return lwx;
  }
  
  public static e i(AppBrandInitConfigWC paramAppBrandInitConfigWC)
  {
    AppMethodBeat.i(48432);
    if (paramAppBrandInitConfigWC.CZ())
    {
      paramAppBrandInitConfigWC = lwy;
      AppMethodBeat.o(48432);
      return paramAppBrandInitConfigWC;
    }
    paramAppBrandInitConfigWC = lwx;
    AppMethodBeat.o(48432);
    return paramAppBrandInitConfigWC;
  }
  
  public final Intent I(Intent paramIntent)
  {
    AppMethodBeat.i(196129);
    paramIntent.putExtra("AppBrandServiceType", this.code);
    AppMethodBeat.o(196129);
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.e
 * JD-Core Version:    0.7.0.1
 */