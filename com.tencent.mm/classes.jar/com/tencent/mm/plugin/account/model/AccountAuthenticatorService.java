package com.tencent.mm.plugin.account.model;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class AccountAuthenticatorService
  extends Service
{
  private static AccountAuthenticatorService.a gAA = null;
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(124652);
    if (paramIntent == null)
    {
      AppMethodBeat.o(124652);
      return null;
    }
    if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.accounts.AccountAuthenticator")))
    {
      if (gAA == null) {
        gAA = new AccountAuthenticatorService.a(this);
      }
      paramIntent = gAA.getIBinder();
      AppMethodBeat.o(124652);
      return paramIntent;
    }
    AppMethodBeat.o(124652);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.AccountAuthenticatorService
 * JD-Core Version:    0.7.0.1
 */