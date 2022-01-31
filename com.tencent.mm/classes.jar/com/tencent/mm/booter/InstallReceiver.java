package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class InstallReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {
      return;
    }
    String str = paramIntent.getAction();
    y.i("MicroMsg.InstallReceiver", "action:[%s]", new Object[] { str });
    if ((bk.bl(str)) || (!str.equals("com.android.vending.INSTALL_REFERRER")))
    {
      y.e("MicroMsg.InstallReceiver", "action is null or nil, or not the installed action");
      return;
    }
    str = "";
    try
    {
      paramIntent = paramIntent.getStringExtra("referrer");
      y.i("MicroMsg.InstallReceiver", "get referer:[%s]", new Object[] { paramIntent });
      if (bk.bl(paramIntent))
      {
        y.e("MicroMsg.InstallReceiver", "get referer is null or nil");
        return;
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        y.e("MicroMsg.InstallReceiver", "%s", new Object[] { bk.j(paramIntent) });
        paramIntent = str;
      }
      y.d("MicroMsg.InstallReceiver", "[PREF] write installreferer = " + paramIntent);
      paramContext.getSharedPreferences(ae.cqR(), 0).edit().putString("installreferer", paramIntent).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.InstallReceiver
 * JD-Core Version:    0.7.0.1
 */