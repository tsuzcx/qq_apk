package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;

final class AppBrandPrepareTask$a$2$1
  implements Runnable
{
  AppBrandPrepareTask$a$2$1(AppBrandPrepareTask.a.2 param2) {}
  
  public final void run()
  {
    Toast.makeText(ae.getContext(), y.j.app_brand_account_release_error, 0).show();
    try
    {
      Intent localIntent = new Intent();
      localIntent.addFlags(268435456).addFlags(67108864);
      d.e(ae.getContext(), "com.tencent.mm.ui.LauncherUI", localIntent);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.a.2.1
 * JD-Core Version:    0.7.0.1
 */