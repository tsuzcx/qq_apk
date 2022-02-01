package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.a;
import com.tencent.mm.sdk.platformtools.ad;

final class c$1
  extends a
{
  private final SparseIntArray jDp;
  
  c$1()
  {
    AppMethodBeat.i(44099);
    this.jDp = new SparseIntArray();
    AppMethodBeat.o(44099);
  }
  
  private void A(Activity paramActivity)
  {
    AppMethodBeat.i(44100);
    if (paramActivity == null)
    {
      AppMethodBeat.o(44100);
      return;
    }
    this.jDp.put(paramActivity.hashCode(), 1);
    c.fI(true);
    aYD();
    AppMethodBeat.o(44100);
  }
  
  private void B(Activity paramActivity)
  {
    AppMethodBeat.i(44101);
    if (paramActivity == null)
    {
      AppMethodBeat.o(44101);
      return;
    }
    this.jDp.delete(paramActivity.hashCode());
    if (this.jDp.size() <= 0) {
      c.fI(false);
    }
    aYD();
    AppMethodBeat.o(44101);
  }
  
  private void aYD()
  {
    AppMethodBeat.i(187973);
    ad.i("MicroMsg.AppBrandProcessProfileInit[applaunch][PreloadProfile]", "alive activity count %d", new Object[] { Integer.valueOf(this.jDp.size()) });
    AppMethodBeat.o(187973);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(44102);
    A(paramActivity);
    AppMethodBeat.o(44102);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(44105);
    B(paramActivity);
    AppMethodBeat.o(44105);
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(44103);
    A(paramActivity);
    AppMethodBeat.o(44103);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(44104);
    B(paramActivity);
    AppMethodBeat.o(44104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.c.1
 * JD-Core Version:    0.7.0.1
 */