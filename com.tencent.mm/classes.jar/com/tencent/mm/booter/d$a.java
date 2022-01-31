package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Locale;

public final class d$a
  implements MMReceivers.a
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    do
    {
      return;
      str = paramIntent.getStringExtra("exdevice_process_action_code_key");
      y.i("MicroMsg.ExDeviceProcessReceiver", "onReceive, action %s", new Object[] { str });
    } while ((bk.bl(str)) || (!str.equals("action_reload_resources")));
    String str = paramIntent.getStringExtra("exdevice_language");
    y.i("MicroMsg.ExDeviceProcessReceiver", "onReceive, language %s", new Object[] { str });
    paramIntent = x.Zi(str);
    if ("language_default".equalsIgnoreCase(str))
    {
      if (Build.VERSION.SDK_INT < 24) {
        break label126;
      }
      paramIntent = x.ueU;
      Locale.setDefault(paramIntent);
    }
    for (;;)
    {
      x.a(paramContext.getApplicationContext(), paramIntent);
      ae.d(a.a(paramContext.getApplicationContext().getResources(), paramContext.getApplicationContext(), str));
      return;
      label126:
      paramIntent = Locale.getDefault();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.d.a
 * JD-Core Version:    0.7.0.1
 */