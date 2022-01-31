package com.tencent.mm.plugin.account.model;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.account.ui.ContactsSyncUI;
import com.tencent.mm.sdk.platformtools.y;

final class AccountAuthenticatorService$a
  extends AbstractAccountAuthenticator
{
  private Context mContext;
  
  public AccountAuthenticatorService$a(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
  }
  
  public final Bundle addAccount(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle)
  {
    paramString1 = new Bundle();
    paramString2 = new Intent(this.mContext, ContactsSyncUI.class);
    paramString2.putExtra("accountAuthenticatorResponse", paramAccountAuthenticatorResponse);
    paramString2.putExtra("contact_sync_scene", 1);
    paramString1.putParcelable("intent", paramString2);
    return paramString1;
  }
  
  public final Bundle confirmCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, Bundle paramBundle)
  {
    y.i("MicroMsg.AccountAuthenticatorService", "confirmCredentials");
    return null;
  }
  
  public final Bundle editProperties(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString)
  {
    y.i("MicroMsg.AccountAuthenticatorService", "editProperties");
    return null;
  }
  
  public final Bundle getAuthToken(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
  {
    y.i("MicroMsg.AccountAuthenticatorService", "getAuthToken");
    return null;
  }
  
  public final String getAuthTokenLabel(String paramString)
  {
    y.i("MicroMsg.AccountAuthenticatorService", "getAuthTokenLabel");
    return null;
  }
  
  public final Bundle hasFeatures(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String[] paramArrayOfString)
  {
    y.i("MicroMsg.AccountAuthenticatorService", "hasFeatures: " + paramArrayOfString);
    return null;
  }
  
  public final Bundle updateCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
  {
    y.i("MicroMsg.AccountAuthenticatorService", "updateCredentials");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.AccountAuthenticatorService.a
 * JD-Core Version:    0.7.0.1
 */