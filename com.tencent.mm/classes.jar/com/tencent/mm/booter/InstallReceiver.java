package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

@Deprecated
@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class InstallReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(19874);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(19874);
      return;
    }
    String str = paramIntent.getAction();
    Log.i("MicroMsg.InstallReceiver", "action:[%s]", new Object[] { str });
    if ((Util.isNullOrNil(str)) || (!str.equals("com.android.vending.INSTALL_REFERRER")))
    {
      Log.e("MicroMsg.InstallReceiver", "action is null or nil, or not the installed action");
      AppMethodBeat.o(19874);
      return;
    }
    str = "";
    try
    {
      paramIntent = paramIntent.getStringExtra("referrer");
      Log.i("MicroMsg.InstallReceiver", "get referer:[%s]", new Object[] { paramIntent });
      if (Util.isNullOrNil(paramIntent))
      {
        Log.e("MicroMsg.InstallReceiver", "get referer is null or nil");
        AppMethodBeat.o(19874);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        Log.e("MicroMsg.InstallReceiver", "%s", new Object[] { Util.stackTraceToString(paramIntent) });
        paramIntent = str;
      }
      Log.d("MicroMsg.InstallReceiver", "[PREF] write installreferer = ".concat(String.valueOf(paramIntent)));
      paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit().putString("installreferer", paramIntent).commit();
      AppMethodBeat.o(19874);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.InstallReceiver
 * JD-Core Version:    0.7.0.1
 */