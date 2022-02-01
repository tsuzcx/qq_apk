package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import com.tencent.luggage.k.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m
  implements k
{
  private final Activity mActivity;
  
  m(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public final void c(Configuration paramConfiguration) {}
  
  public final int chc()
  {
    AppMethodBeat.i(176757);
    int i = j.cEc.aM(this.mActivity);
    AppMethodBeat.o(176757);
    return i;
  }
  
  public final boolean xJ()
  {
    AppMethodBeat.i(176756);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(176756);
      return false;
    }
    boolean bool = j.cEc.aN(this.mActivity);
    AppMethodBeat.o(176756);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.m
 * JD-Core Version:    0.7.0.1
 */