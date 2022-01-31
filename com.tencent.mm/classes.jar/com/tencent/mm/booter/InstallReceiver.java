package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
public class InstallReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(15839);
    if ((paramContext == null) || (paramIntent == null))
    {
      AppMethodBeat.o(15839);
      return;
    }
    String str = paramIntent.getAction();
    ab.i("MicroMsg.InstallReceiver", "action:[%s]", new Object[] { str });
    if ((bo.isNullOrNil(str)) || (!str.equals("com.android.vending.INSTALL_REFERRER")))
    {
      ab.e("MicroMsg.InstallReceiver", "action is null or nil, or not the installed action");
      AppMethodBeat.o(15839);
      return;
    }
    str = "";
    try
    {
      paramIntent = paramIntent.getStringExtra("referrer");
      ab.i("MicroMsg.InstallReceiver", "get referer:[%s]", new Object[] { paramIntent });
      if (bo.isNullOrNil(paramIntent))
      {
        ab.e("MicroMsg.InstallReceiver", "get referer is null or nil");
        AppMethodBeat.o(15839);
        return;
      }
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        ab.e("MicroMsg.InstallReceiver", "%s", new Object[] { bo.l(paramIntent) });
        paramIntent = str;
      }
      ab.d("MicroMsg.InstallReceiver", "[PREF] write installreferer = ".concat(String.valueOf(paramIntent)));
      paramContext.getSharedPreferences(ah.dsP(), 0).edit().putString("installreferer", paramIntent).commit();
      AppMethodBeat.o(15839);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.InstallReceiver
 * JD-Core Version:    0.7.0.1
 */