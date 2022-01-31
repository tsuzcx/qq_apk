package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class AppBrand404PageUI$1
  implements Runnable
{
  AppBrand404PageUI$1(Intent paramIntent) {}
  
  public final void run()
  {
    AppMethodBeat.i(132882);
    this.val$intent.addFlags(268435456);
    ah.getContext().startActivity(this.val$intent);
    AppMethodBeat.o(132882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI.1
 * JD-Core Version:    0.7.0.1
 */