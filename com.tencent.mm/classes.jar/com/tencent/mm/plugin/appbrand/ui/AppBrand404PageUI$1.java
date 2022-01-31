package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ae;

final class AppBrand404PageUI$1
  implements Runnable
{
  AppBrand404PageUI$1(Intent paramIntent) {}
  
  public final void run()
  {
    this.val$intent.addFlags(268435456);
    ae.getContext().startActivity(this.val$intent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI.1
 * JD-Core Version:    0.7.0.1
 */