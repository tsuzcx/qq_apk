package com.tencent.mm.platformtools;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Settings;
import com.jg.JgMethodChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class w
{
  public static boolean I(Context paramContext, String paramString)
  {
    AppMethodBeat.i(124568);
    boolean bool = bo.isNullOrNil(paramString);
    ab.v("MicroMsg.MMAccountManager", "remove account : ".concat(String.valueOf(paramString)));
    if (paramContext == null)
    {
      ab.e("MicroMsg.MMAccountManager", "null context");
      AppMethodBeat.o(124568);
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        Account[] arrayOfAccount = cy(paramContext);
        if ((arrayOfAccount == null) || (arrayOfAccount.length == 0))
        {
          ab.d("MicroMsg.MMAccountManager", "get account info is null or nil");
          AppMethodBeat.o(124568);
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
          else if (localAccount.name.equals(paramString))
          {
            paramContext.removeAccount(localAccount, null, null);
            ab.i("MicroMsg.MMAccountManager", "remove account success: ".concat(String.valueOf(paramString)));
          }
        }
      }
      catch (Exception paramContext)
      {
        ab.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
        ab.e("MicroMsg.MMAccountManager", "exception in removeAccount() " + paramContext.getMessage());
        AppMethodBeat.o(124568);
        return false;
      }
      AppMethodBeat.o(124568);
      return true;
      i += 1;
    }
  }
  
  public static void J(Context paramContext, String paramString)
  {
    AppMethodBeat.i(124573);
    if (cv(paramContext))
    {
      if (!com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yMa, false))
      {
        com.tencent.mm.sdk.g.d.h(new h(paramContext, cx(paramContext), paramString), "MMAccountManager_deleteSpecifiedContact").start();
        AppMethodBeat.o(124573);
      }
    }
    else
    {
      I(paramContext, null);
      ab.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }
    AppMethodBeat.o(124573);
  }
  
  private static boolean K(Context paramContext, String paramString)
  {
    AppMethodBeat.i(124578);
    paramContext = cy(paramContext);
    if ((paramContext == null) || (paramContext.length == 0))
    {
      AppMethodBeat.o(124578);
      return false;
    }
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      if (paramContext[i].name.equals(paramString))
      {
        AppMethodBeat.o(124578);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(124578);
    return false;
  }
  
  private static Account[] L(Context paramContext, String paramString)
  {
    AppMethodBeat.i(124579);
    Object localObject = null;
    try
    {
      paramContext = AccountManager.get(paramContext).getAccountsByType(paramString);
      AppMethodBeat.o(124579);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ab.e("MicroMsg.MMAccountManager", "get all accounts failed");
        ab.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
        paramContext = localObject;
      }
    }
  }
  
  public static int a(Context paramContext, w.a parama)
  {
    AppMethodBeat.i(124565);
    if (paramContext == null)
    {
      ab.e("MicroMsg.MMAccountManager", "context is null");
      AppMethodBeat.o(124565);
      return 0;
    }
    Object localObject2 = aou();
    Object localObject1 = localObject2;
    if (bo.isNullOrNil((String)localObject2))
    {
      ab.e("MicroMsg.MMAccountManager", "account username is null or nil");
      localObject1 = (String)com.tencent.mm.kernel.g.RL().Ru().get(6, "");
      if (bo.isNullOrNil((String)localObject1)) {}
    }
    else
    {
      if (!K(paramContext, (String)localObject1)) {
        break label89;
      }
      AppMethodBeat.o(124565);
      return 3;
    }
    AppMethodBeat.o(124565);
    return 0;
    label89:
    if (!b.o(paramContext, "android.permission.READ_CONTACTS"))
    {
      AppMethodBeat.o(124565);
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
          parama.t(paramContext);
        }
        AppMethodBeat.o(124565);
        return 1;
      }
    }
    catch (Exception paramContext)
    {
      ab.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
      ab.e("MicroMsg.MMAccountManager", "exception in addAccountNoNeedBindMobile() " + paramContext.getMessage());
      if (parama != null) {
        parama.t(null);
      }
      AppMethodBeat.o(124565);
    }
    return 2;
  }
  
  public static int a(Context paramContext, String paramString, w.a parama)
  {
    AppMethodBeat.i(124566);
    if (paramContext == null)
    {
      ab.e("MicroMsg.MMAccountManager", "activity is null");
      AppMethodBeat.o(124566);
      return 0;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.MMAccountManager", "account username is null or nil");
      AppMethodBeat.o(124566);
      return 0;
    }
    Object localObject = aou();
    if (bo.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = AccountManager.get(paramContext);
        Account localAccount = new Account(paramString, "com.tencent.mm.account");
        boolean bool = b.o(paramContext, "android.permission.READ_CONTACTS");
        if (!bool)
        {
          AppMethodBeat.o(124566);
          return 2;
        }
        if (K(paramContext, paramString))
        {
          ContentResolver.setSyncAutomatically(localAccount, "com.android.contacts", true);
          AppMethodBeat.o(124566);
          return 3;
        }
        I(paramContext, null);
        if (((AccountManager)localObject).addAccountExplicitly(localAccount, "", null))
        {
          ContentResolver.setSyncAutomatically(localAccount, "com.android.contacts", true);
          localObject = new Bundle();
          ((Bundle)localObject).putString("authAccount", paramString);
          ((Bundle)localObject).putString("accountType", "com.tencent.mm.account");
          if (parama != null) {
            parama.t((Bundle)localObject);
          }
          localObject = new ContentValues();
          ((ContentValues)localObject).put("account_name", paramString);
          ((ContentValues)localObject).put("account_type", "com.tencent.mm.account");
          ((ContentValues)localObject).put("should_sync", Integer.valueOf(1));
          ((ContentValues)localObject).put("ungrouped_visible", Integer.valueOf(1));
          paramContext.getContentResolver().insert(ContactsContract.Settings.CONTENT_URI, (ContentValues)localObject);
          AppMethodBeat.o(124566);
          return 1;
        }
      }
      catch (Exception paramContext)
      {
        ab.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
        ab.e("MicroMsg.MMAccountManager", "exception in addAccount() " + paramContext.getMessage());
        if (parama != null) {
          parama.t(null);
        }
        AppMethodBeat.o(124566);
        return 2;
      }
      paramString = (String)localObject;
    }
  }
  
  private static String aou()
  {
    AppMethodBeat.i(124570);
    if (!com.tencent.mm.kernel.g.RG())
    {
      ab.e("MicroMsg.MMAccountManager", "getCurrentAccountName MMCore.acc Not Ready");
      AppMethodBeat.o(124570);
      return "";
    }
    Object localObject = (String)com.tencent.mm.kernel.g.RL().Ru().get(4, null);
    if (!bo.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      localObject = ww((String)localObject);
      AppMethodBeat.o(124570);
      return localObject;
      String str = r.Zo();
      localObject = str;
      if (bo.isNullOrNil(str))
      {
        str = r.Zn();
        if (!bo.isNullOrNil(str))
        {
          localObject = str;
          if (!ad.ari(str)) {}
        }
        else
        {
          localObject = "";
        }
      }
    }
  }
  
  public static void cs(Context paramContext)
  {
    AppMethodBeat.i(124567);
    com.tencent.mm.bq.d.dpU();
    if (com.tencent.mm.sdk.platformtools.g.bWA == 0)
    {
      ab.d("MicroMsg.MMAccountManager", "do not auto add account");
      AppMethodBeat.o(124567);
      return;
    }
    if (com.tencent.mm.sdk.platformtools.g.bWA == 1)
    {
      if (l.aqq() == l.a.gxB)
      {
        ab.d("MicroMsg.MMAccountManager", "auto add account result: ".concat(String.valueOf(a(paramContext, l.aqs(), null))));
        AppMethodBeat.o(124567);
        return;
      }
      ab.i("MicroMsg.MMAccountManager", "the user not bind mobile or not aggreed to upload addressbook");
      AppMethodBeat.o(124567);
      return;
    }
    if (com.tencent.mm.sdk.platformtools.g.bWA == 2) {
      ab.d("MicroMsg.MMAccountManager", "auto add account result: ".concat(String.valueOf(a(paramContext, null))));
    }
    AppMethodBeat.o(124567);
  }
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
  public static boolean ct(Context paramContext)
  {
    AppMethodBeat.i(124569);
    boolean bool1 = false;
    if (paramContext != null)
    {
      Intent localIntent = new Intent("com.tencent.mm.login.ACTION_LOGOUT");
      localIntent.putExtra("accountName", aou());
      localIntent.putExtra("accountType", "com.tencent.mm.account");
      boolean bool2 = I(paramContext, aou());
      bool1 = bool2;
      if (bool2)
      {
        paramContext.sendBroadcast(localIntent);
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(124569);
    return bool1;
  }
  
  public static void cu(Context paramContext)
  {
    AppMethodBeat.i(124571);
    if (cv(paramContext))
    {
      if (!com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yMa, false))
      {
        com.tencent.mm.sdk.g.d.h(new h(paramContext, cx(paramContext)), "MMAccountManager_updateAllContact").start();
        AppMethodBeat.o(124571);
      }
    }
    else
    {
      I(paramContext, null);
      ab.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }
    AppMethodBeat.o(124571);
  }
  
  private static boolean cv(Context paramContext)
  {
    AppMethodBeat.i(124574);
    paramContext = cx(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(124574);
      return false;
    }
    if (paramContext.name.equals(aou()))
    {
      AppMethodBeat.o(124574);
      return true;
    }
    AppMethodBeat.o(124574);
    return false;
  }
  
  public static boolean cw(Context paramContext)
  {
    AppMethodBeat.i(124575);
    if (!cv(paramContext))
    {
      ab.e("MicroMsg.MMAccountManager", "no account added or not current account");
      AppMethodBeat.o(124575);
      return false;
    }
    if (!b.o(paramContext, "android.permission.READ_CONTACTS"))
    {
      AppMethodBeat.o(124575);
      return false;
    }
    paramContext = cx(paramContext);
    if (paramContext != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("expedited", true);
      localBundle.putBoolean("do_not_retry", true);
      ContentResolver.requestSync(paramContext, "com.android.contacts", localBundle);
      AppMethodBeat.o(124575);
      return true;
    }
    ab.e("MicroMsg.MMAccountManager", "no account added");
    AppMethodBeat.o(124575);
    return false;
  }
  
  private static Account cx(Context paramContext)
  {
    AppMethodBeat.i(124576);
    String str2 = aou();
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      str1 = (String)com.tencent.mm.kernel.g.RL().Ru().get(6, "");
    }
    if (!bo.isNullOrNil(str1))
    {
      paramContext = cy(paramContext);
      if (paramContext == null)
      {
        AppMethodBeat.o(124576);
        return null;
      }
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        str2 = paramContext[i];
        if (str2.name.equals(str1))
        {
          AppMethodBeat.o(124576);
          return str2;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(124576);
    return null;
  }
  
  private static Account[] cy(Context paramContext)
  {
    AppMethodBeat.i(124577);
    try
    {
      paramContext = AccountManager.get(paramContext).getAccountsByType("com.tencent.mm.account");
      AppMethodBeat.o(124577);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ab.e("MicroMsg.MMAccountManager", "get all accounts failed");
      ab.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
      AppMethodBeat.o(124577);
    }
    return null;
  }
  
  public static String cz(Context paramContext)
  {
    AppMethodBeat.i(124580);
    Account[] arrayOfAccount = L(paramContext, "com.google");
    Object localObject = null;
    String str = null;
    paramContext = localObject;
    if (arrayOfAccount != null)
    {
      paramContext = localObject;
      if (arrayOfAccount.length > 0)
      {
        int j = arrayOfAccount.length;
        int i = 0;
        for (paramContext = str; i < j; paramContext = str)
        {
          str = arrayOfAccount[i].name;
          if (!bo.isNullOrNil(str))
          {
            paramContext = str;
            if (bo.apH(str)) {
              break;
            }
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(124580);
    return paramContext;
  }
  
  public static void n(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(124572);
    if (cv(paramContext))
    {
      if (!com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yMa, false))
      {
        com.tencent.mm.sdk.g.d.h(new h(paramContext, cx(paramContext), paramString1, paramString2), "MMAccountManager_updateSpecifiedContact").start();
        AppMethodBeat.o(124572);
      }
    }
    else
    {
      I(paramContext, null);
      ab.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }
    AppMethodBeat.o(124572);
  }
  
  private static String ww(String paramString)
  {
    AppMethodBeat.i(124581);
    try
    {
      String str = Pattern.compile("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#¥￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(paramString).replaceAll("_").trim();
      AppMethodBeat.o(124581);
      return str;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMAccountManager", "stringFilter failed, %s, %s", new Object[] { paramString, localException.getMessage() });
      ab.printErrStackTrace("MicroMsg.MMAccountManager", localException, "", new Object[0]);
      AppMethodBeat.o(124581);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.w
 * JD-Core Version:    0.7.0.1
 */