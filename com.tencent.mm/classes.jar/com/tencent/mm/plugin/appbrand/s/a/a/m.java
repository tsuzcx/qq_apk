package com.tencent.mm.plugin.appbrand.s.a.a;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m
  implements k
{
  private final Activity mActivity;
  
  m(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public final int blT()
  {
    AppMethodBeat.i(176757);
    int i = i.cjn.aE(this.mActivity);
    AppMethodBeat.o(176757);
    return i;
  }
  
  public final void c(Configuration paramConfiguration) {}
  
  public final boolean ca()
  {
    AppMethodBeat.i(176756);
    if (Build.VERSION.SDK_INT < 21)
    {
      AppMethodBeat.o(176756);
      return false;
    }
    boolean bool = i.cjn.aF(this.mActivity);
    AppMethodBeat.o(176756);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a.a.m
 * JD-Core Version:    0.7.0.1
 */