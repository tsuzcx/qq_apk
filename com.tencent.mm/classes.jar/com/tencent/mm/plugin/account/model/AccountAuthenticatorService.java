package com.tencent.mm.plugin.account.model;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.jg.JgClassChecked;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class AccountAuthenticatorService
  extends Service
{
  private static AccountAuthenticatorService.a fji = null;
  
  public IBinder onBind(Intent paramIntent)
  {
    if (paramIntent == null) {}
    while ((paramIntent.getAction() == null) || (!paramIntent.getAction().equals("android.accounts.AccountAuthenticator"))) {
      return null;
    }
    if (fji == null) {
      fji = new AccountAuthenticatorService.a(this);
    }
    return fji.getIBinder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.AccountAuthenticatorService
 * JD-Core Version:    0.7.0.1
 */