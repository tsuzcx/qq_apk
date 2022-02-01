package com.tencent.mm.plugin.account.model;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.ui.ContactsSyncUI;
import com.tencent.mm.sdk.platformtools.Log;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class AccountAuthenticatorService
  extends Service
{
  private static a kif = null;
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(127806);
    if (paramIntent == null)
    {
      AppMethodBeat.o(127806);
      return null;
    }
    if ((paramIntent.getAction() != null) && (paramIntent.getAction().equals("android.accounts.AccountAuthenticator")))
    {
      if (kif == null) {
        kif = new a(this);
      }
      paramIntent = kif.getIBinder();
      AppMethodBeat.o(127806);
      return paramIntent;
    }
    AppMethodBeat.o(127806);
    return null;
  }
  
  static final class a
    extends AbstractAccountAuthenticator
  {
    private Context mContext;
    
    public a(Context paramContext)
    {
      super();
      this.mContext = paramContext;
    }
    
    public final Bundle addAccount(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle)
    {
      AppMethodBeat.i(127799);
      paramString1 = new Bundle();
      paramString2 = new Intent(this.mContext, ContactsSyncUI.class);
      paramString2.putExtra("accountAuthenticatorResponse", paramAccountAuthenticatorResponse);
      paramString2.putExtra("contact_sync_scene", 1);
      paramString1.putParcelable("intent", paramString2);
      AppMethodBeat.o(127799);
      return paramString1;
    }
    
    public final Bundle confirmCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, Bundle paramBundle)
    {
      AppMethodBeat.i(127800);
      Log.i("MicroMsg.AccountAuthenticatorService", "confirmCredentials");
      AppMethodBeat.o(127800);
      return null;
    }
    
    public final Bundle editProperties(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString)
    {
      AppMethodBeat.i(127801);
      Log.i("MicroMsg.AccountAuthenticatorService", "editProperties");
      AppMethodBeat.o(127801);
      return null;
    }
    
    public final Bundle getAuthToken(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(127802);
      Log.i("MicroMsg.AccountAuthenticatorService", "getAuthToken");
      AppMethodBeat.o(127802);
      return null;
    }
    
    public final String getAuthTokenLabel(String paramString)
    {
      AppMethodBeat.i(127803);
      Log.i("MicroMsg.AccountAuthenticatorService", "getAuthTokenLabel");
      AppMethodBeat.o(127803);
      return null;
    }
    
    public final Bundle hasFeatures(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String[] paramArrayOfString)
    {
      AppMethodBeat.i(127804);
      Log.i("MicroMsg.AccountAuthenticatorService", "hasFeatures: ".concat(String.valueOf(paramArrayOfString)));
      AppMethodBeat.o(127804);
      return null;
    }
    
    public final Bundle updateCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(127805);
      Log.i("MicroMsg.AccountAuthenticatorService", "updateCredentials");
      AppMethodBeat.o(127805);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.AccountAuthenticatorService
 * JD-Core Version:    0.7.0.1
 */