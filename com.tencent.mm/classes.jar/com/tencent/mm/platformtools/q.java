package com.tencent.mm.platformtools;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract.Settings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public final class q
{
  private static boolean R(Context paramContext, String paramString)
  {
    AppMethodBeat.i(127736);
    paramContext = eh(paramContext);
    if ((paramContext == null) || (paramContext.length == 0))
    {
      AppMethodBeat.o(127736);
      return false;
    }
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      if (paramContext[i].name.equals(paramString))
      {
        AppMethodBeat.o(127736);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(127736);
    return false;
  }
  
  private static String Sf(String paramString)
  {
    AppMethodBeat.i(127739);
    try
    {
      String str = Pattern.compile("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#¥￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(paramString).replaceAll("_").trim();
      AppMethodBeat.o(127739);
      return str;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMAccountManager", "stringFilter failed, %s, %s", new Object[] { paramString, localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.MMAccountManager", localException, "", new Object[0]);
      AppMethodBeat.o(127739);
    }
    return paramString;
  }
  
  public static int a(Context paramContext, a parama)
  {
    AppMethodBeat.i(127723);
    if (paramContext == null)
    {
      Log.e("MicroMsg.MMAccountManager", "context is null");
      AppMethodBeat.o(127723);
      return 0;
    }
    Object localObject2 = bTK();
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.e("MicroMsg.MMAccountManager", "account username is null or nil");
      localObject1 = (String)h.baE().ban().d(6, "");
      if (Util.isNullOrNil((String)localObject1)) {}
    }
    else
    {
      if (!R(paramContext, (String)localObject1)) {
        break label89;
      }
      AppMethodBeat.o(127723);
      return 3;
    }
    AppMethodBeat.o(127723);
    return 0;
    label89:
    if (!b.s(paramContext, "android.permission.READ_CONTACTS"))
    {
      AppMethodBeat.o(127723);
      return 2;
    }
    try
    {
      paramContext = AccountManager.get(paramContext);
      localObject2 = new Account((String)localObject1, "com.tencent.mm.account");
      if (paramContext.addAccountExplicitly((Account)localObject2, "", null))
      {
        ContentResolver.setSyncAutomatically((Account)localObject2, "com.android.contacts", true);
        paramContext = new Bundle();
        paramContext.putString("authAccount", (String)localObject1);
        paramContext.putString("accountType", "com.tencent.mm.account");
        if (parama != null) {
          parama.S(paramContext);
        }
        AppMethodBeat.o(127723);
        return 1;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
      Log.e("MicroMsg.MMAccountManager", "exception in addAccountNoNeedBindMobile() " + paramContext.getMessage());
      if (parama != null) {
        parama.S(null);
      }
      AppMethodBeat.o(127723);
    }
    return 2;
  }
  
  public static int a(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(127724);
    if (paramContext == null)
    {
      Log.e("MicroMsg.MMAccountManager", "activity is null");
      AppMethodBeat.o(127724);
      return 0;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.MMAccountManager", "account username is null or nil");
      AppMethodBeat.o(127724);
      return 0;
    }
    Object localObject = bTK();
    if (Util.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = AccountManager.get(paramContext);
        Account localAccount = new Account(paramString, "com.tencent.mm.account");
        boolean bool = b.s(paramContext, "android.permission.READ_CONTACTS");
        if (!bool)
        {
          AppMethodBeat.o(127724);
          return 2;
        }
        if (R(paramContext, paramString))
        {
          ContentResolver.setSyncAutomatically(localAccount, "com.android.contacts", true);
          AppMethodBeat.o(127724);
          return 3;
        }
        eg(paramContext);
        if (((AccountManager)localObject).addAccountExplicitly(localAccount, "", null))
        {
          ContentResolver.setSyncAutomatically(localAccount, "com.android.contacts", true);
          localObject = new Bundle();
          ((Bundle)localObject).putString("authAccount", paramString);
          ((Bundle)localObject).putString("accountType", "com.tencent.mm.account");
          if (parama != null) {
            parama.S((Bundle)localObject);
          }
          localObject = new ContentValues();
          ((ContentValues)localObject).put("account_name", paramString);
          ((ContentValues)localObject).put("account_type", "com.tencent.mm.account");
          ((ContentValues)localObject).put("should_sync", Integer.valueOf(1));
          ((ContentValues)localObject).put("ungrouped_visible", Integer.valueOf(1));
          paramContext.getContentResolver().insert(ContactsContract.Settings.CONTENT_URI, (ContentValues)localObject);
          AppMethodBeat.o(127724);
          return 1;
        }
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
        Log.e("MicroMsg.MMAccountManager", "exception in addAccount() " + paramContext.getMessage());
        if (parama != null) {
          parama.S(null);
        }
        AppMethodBeat.o(127724);
        return 2;
      }
      paramString = (String)localObject;
    }
  }
  
  private static String bTK()
  {
    AppMethodBeat.i(127728);
    if (!h.baz())
    {
      Log.e("MicroMsg.MMAccountManager", "getCurrentAccountName MMCore.acc Not Ready");
      AppMethodBeat.o(127728);
      return "";
    }
    Object localObject = (String)h.baE().ban().d(4, null);
    if (!Util.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      localObject = Sf((String)localObject);
      AppMethodBeat.o(127728);
      return localObject;
      String str = z.bAN();
      localObject = str;
      if (Util.isNullOrNil(str))
      {
        str = z.bAM();
        if (!Util.isNullOrNil(str))
        {
          localObject = str;
          if (!au.bxb(str)) {}
        }
        else
        {
          localObject = "";
        }
      }
    }
  }
  
  private static boolean eg(Context paramContext)
  {
    AppMethodBeat.i(234063);
    boolean bool = Util.isNullOrNil(null);
    Log.v("MicroMsg.MMAccountManager", "remove account : " + null);
    if (paramContext == null)
    {
      Log.e("MicroMsg.MMAccountManager", "null context");
      AppMethodBeat.o(234063);
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        Account[] arrayOfAccount = eh(paramContext);
        if ((arrayOfAccount == null) || (arrayOfAccount.length == 0))
        {
          Log.d("MicroMsg.MMAccountManager", "get account info is null or nil");
          AppMethodBeat.o(234063);
          return true;
        }
        paramContext = AccountManager.get(paramContext);
        int j = arrayOfAccount.length;
        i = 0;
        if (i < j)
        {
          Account localAccount = arrayOfAccount[i];
          if (bool)
          {
            paramContext.removeAccount(localAccount, null, null);
          }
          else if (localAccount.name.equals(null))
          {
            paramContext.removeAccount(localAccount, null, null);
            Log.i("MicroMsg.MMAccountManager", "remove account success: " + null);
          }
        }
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
        Log.e("MicroMsg.MMAccountManager", "exception in removeAccount() " + paramContext.getMessage());
        AppMethodBeat.o(234063);
        return false;
      }
      AppMethodBeat.o(234063);
      return true;
      i += 1;
    }
  }
  
  private static Account[] eh(Context paramContext)
  {
    AppMethodBeat.i(127735);
    try
    {
      paramContext = AccountManager.get(paramContext).getAccountsByType("com.tencent.mm.account");
      AppMethodBeat.o(127735);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.MMAccountManager", "get all accounts failed");
      Log.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
      AppMethodBeat.o(127735);
    }
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void S(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.q
 * JD-Core Version:    0.7.0.1
 */