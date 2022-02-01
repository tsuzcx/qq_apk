package com.tencent.mm.booter.notification;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.LauncherUI;

final class d$1
  implements Runnable
{
  d$1(int paramInt) {}
  
  public final void run()
  {
    boolean bool = true;
    AppMethodBeat.i(19973);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("package", ai.getPackageName());
      localBundle.putString("class", LauncherUI.class.getName());
      localBundle.putInt("badgenumber", this.foA);
      if (ai.getContext().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, localBundle) != null) {}
      for (;;)
      {
        d.access$002(bool);
        ac.i("MicroMsg.BusinessNotification", "huawei badge: %d, %b", new Object[] { Integer.valueOf(this.foA), Boolean.valueOf(d.access$000()) });
        AppMethodBeat.o(19973);
        return;
        bool = false;
      }
      return;
    }
    catch (Exception localException)
    {
      ac.i("MicroMsg.BusinessNotification", "no huawei badge");
      ac.e("MicroMsg.BusinessNotification", "alvin: no badge" + localException.toString());
      d.access$002(false);
      AppMethodBeat.o(19973);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.notification.d.1
 * JD-Core Version:    0.7.0.1
 */