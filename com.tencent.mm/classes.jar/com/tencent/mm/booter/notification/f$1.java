package com.tencent.mm.booter.notification;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.LauncherUI;

final class f$1
  implements Runnable
{
  f$1(int paramInt) {}
  
  public final void run()
  {
    boolean bool = true;
    AppMethodBeat.i(19973);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("package", MMApplicationContext.getPackageName());
      localBundle.putString("class", LauncherUI.class.getName());
      localBundle.putInt("badgenumber", this.lug);
      if (MMApplicationContext.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, localBundle) != null) {}
      for (;;)
      {
        f.access$002(bool);
        Log.i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", new Object[] { Integer.valueOf(this.lug), Boolean.valueOf(f.access$000()) });
        AppMethodBeat.o(19973);
        return;
        bool = false;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.i("MicroMsg.BusinessNotification", "no huawei badge");
      Log.e("MicroMsg.BusinessNotification", "alvin: no badge" + localException.toString());
      f.access$002(false);
      AppMethodBeat.o(19973);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.notification.f.1
 * JD-Core Version:    0.7.0.1
 */