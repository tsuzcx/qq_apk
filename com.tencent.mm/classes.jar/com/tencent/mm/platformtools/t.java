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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class t
{
  public static boolean Q(Context paramContext, String paramString)
  {
    AppMethodBeat.i(127726);
    boolean bool = Util.isNullOrNil(paramString);
    Log.v("MicroMsg.MMAccountManager", "remove account : ".concat(String.valueOf(paramString)));
    if (paramContext == null)
    {
      Log.e("MicroMsg.MMAccountManager", "null context");
      AppMethodBeat.o(127726);
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        Account[] arrayOfAccount = dx(paramContext);
        if ((arrayOfAccount == null) || (arrayOfAccount.length == 0))
        {
          Log.d("MicroMsg.MMAccountManager", "get account info is null or nil");
          AppMethodBeat.o(127726);
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
            Log.i("MicroMsg.MMAccountManager", "remove account success: ".concat(String.valueOf(paramString)));
          }
        }
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
        Log.e("MicroMsg.MMAccountManager", "exception in removeAccount() " + paramContext.getMessage());
        AppMethodBeat.o(127726);
        return false;
      }
      AppMethodBeat.o(127726);
      return true;
      i += 1;
    }
  }
  
  public static void R(Context paramContext, String paramString)
  {
    AppMethodBeat.i(127731);
    if (du(paramContext))
    {
      if (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.Ojh, false))
      {
        paramContext = new g(paramContext, dw(paramContext), paramString);
        h.RTc.aX(paramContext);
        AppMethodBeat.o(127731);
      }
    }
    else
    {
      Q(paramContext, null);
      Log.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }
    AppMethodBeat.o(127731);
  }
  
  private static boolean S(Context paramContext, String paramString)
  {
    AppMethodBeat.i(127736);
    paramContext = dx(paramContext);
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
  
  private static String Sp(String paramString)
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
  
  private static Account[] T(Context paramContext, String paramString)
  {
    AppMethodBeat.i(127737);
    Object localObject = null;
    try
    {
      paramContext = AccountManager.get(paramContext).getAccountsByType(paramString);
      AppMethodBeat.o(127737);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.e("MicroMsg.MMAccountManager", "get all accounts failed");
        Log.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
        paramContext = localObject;
      }
    }
  }
  
  public static int a(Context paramContext, t.a parama)
  {
    AppMethodBeat.i(127723);
    if (paramContext == null)
    {
      Log.e("MicroMsg.MMAccountManager", "context is null");
      AppMethodBeat.o(127723);
      return 0;
    }
    Object localObject2 = blH();
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.e("MicroMsg.MMAccountManager", "account username is null or nil");
      localObject1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(6, "");
      if (Util.isNullOrNil((String)localObject1)) {}
    }
    else
    {
      if (!S(paramContext, (String)localObject1)) {
        break label89;
      }
      AppMethodBeat.o(127723);
      return 3;
    }
    AppMethodBeat.o(127723);
    return 0;
    label89:
    if (!b.n(paramContext, "android.permission.READ_CONTACTS"))
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
          parama.D(paramContext);
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
        parama.D(null);
      }
      AppMethodBeat.o(127723);
    }
    return 2;
  }
  
  public static int a(Context paramContext, String paramString, t.a parama)
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
    Object localObject = blH();
    if (Util.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = AccountManager.get(paramContext);
        Account localAccount = new Account(paramString, "com.tencent.mm.account");
        boolean bool = b.n(paramContext, "android.permission.READ_CONTACTS");
        if (!bool)
        {
          AppMethodBeat.o(127724);
          return 2;
        }
        if (S(paramContext, paramString))
        {
          ContentResolver.setSyncAutomatically(localAccount, "com.android.contacts", true);
          AppMethodBeat.o(127724);
          return 3;
        }
        Q(paramContext, null);
        if (((AccountManager)localObject).addAccountExplicitly(localAccount, "", null))
        {
          ContentResolver.setSyncAutomatically(localAccount, "com.android.contacts", true);
          localObject = new Bundle();
          ((Bundle)localObject).putString("authAccount", paramString);
          ((Bundle)localObject).putString("accountType", "com.tencent.mm.account");
          if (parama != null) {
            parama.D((Bundle)localObject);
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
          parama.D(null);
        }
        AppMethodBeat.o(127724);
        return 2;
      }
      paramString = (String)localObject;
    }
  }
  
  private static String blH()
  {
    AppMethodBeat.i(127728);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      Log.e("MicroMsg.MMAccountManager", "getCurrentAccountName MMCore.acc Not Ready");
      AppMethodBeat.o(127728);
      return "";
    }
    Object localObject = (String)com.tencent.mm.kernel.g.aAh().azQ().get(4, null);
    if (!Util.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      localObject = Sp((String)localObject);
      AppMethodBeat.o(127728);
      return localObject;
      String str = z.aTZ();
      localObject = str;
      if (Util.isNullOrNil(str))
      {
        str = z.aTY();
        if (!Util.isNullOrNil(str))
        {
          localObject = str;
          if (!as.bjx(str)) {}
        }
        else
        {
          localObject = "";
        }
      }
    }
  }
  
  public static void dr(Context paramContext)
  {
    AppMethodBeat.i(127725);
    c.gsX();
    if (ChannelUtil.autoAddAccount == 0)
    {
      Log.d("MicroMsg.MMAccountManager", "do not auto add account");
      AppMethodBeat.o(127725);
      return;
    }
    if (ChannelUtil.autoAddAccount == 1)
    {
      if (l.bnZ() == l.a.keL)
      {
        Log.d("MicroMsg.MMAccountManager", "auto add account result: ".concat(String.valueOf(a(paramContext, l.bob(), null))));
        AppMethodBeat.o(127725);
        return;
      }
      Log.i("MicroMsg.MMAccountManager", "the user not bind mobile or not aggreed to upload addressbook");
      AppMethodBeat.o(127725);
      return;
    }
    if (ChannelUtil.autoAddAccount == 2) {
      Log.d("MicroMsg.MMAccountManager", "auto add account result: ".concat(String.valueOf(a(paramContext, null))));
    }
    AppMethodBeat.o(127725);
  }
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
  public static boolean ds(Context paramContext)
  {
    AppMethodBeat.i(127727);
    boolean bool1 = false;
    if (paramContext != null)
    {
      Intent localIntent = new Intent("com.tencent.mm.login.ACTION_LOGOUT");
      localIntent.putExtra("accountName", blH());
      localIntent.putExtra("accountType", "com.tencent.mm.account");
      boolean bool2 = Q(paramContext, blH());
      bool1 = bool2;
      if (bool2)
      {
        paramContext.sendBroadcast(localIntent);
        bool1 = bool2;
      }
    }
    AppMethodBeat.o(127727);
    return bool1;
  }
  
  public static void dt(Context paramContext)
  {
    AppMethodBeat.i(127729);
    if (du(paramContext))
    {
      if (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.Ojh, false))
      {
        paramContext = new g(paramContext, dw(paramContext));
        h.RTc.aX(paramContext);
        AppMethodBeat.o(127729);
      }
    }
    else
    {
      Q(paramContext, null);
      Log.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }
    AppMethodBeat.o(127729);
  }
  
  private static boolean du(Context paramContext)
  {
    AppMethodBeat.i(127732);
    paramContext = dw(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(127732);
      return false;
    }
    if (paramContext.name.equals(blH()))
    {
      AppMethodBeat.o(127732);
      return true;
    }
    AppMethodBeat.o(127732);
    return false;
  }
  
  public static boolean dv(Context paramContext)
  {
    AppMethodBeat.i(127733);
    if (!du(paramContext))
    {
      Log.e("MicroMsg.MMAccountManager", "no account added or not current account");
      AppMethodBeat.o(127733);
      return false;
    }
    if (!b.n(paramContext, "android.permission.READ_CONTACTS"))
    {
      AppMethodBeat.o(127733);
      return false;
    }
    paramContext = dw(paramContext);
    if (paramContext != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("expedited", true);
      localBundle.putBoolean("do_not_retry", true);
      ContentResolver.requestSync(paramContext, "com.android.contacts", localBundle);
      AppMethodBeat.o(127733);
      return true;
    }
    Log.e("MicroMsg.MMAccountManager", "no account added");
    AppMethodBeat.o(127733);
    return false;
  }
  
  private static Account dw(Context paramContext)
  {
    AppMethodBeat.i(127734);
    String str2 = blH();
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      str1 = (String)com.tencent.mm.kernel.g.aAh().azQ().get(6, "");
    }
    if (!Util.isNullOrNil(str1))
    {
      paramContext = dx(paramContext);
      if (paramContext == null)
      {
        AppMethodBeat.o(127734);
        return null;
      }
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        str2 = paramContext[i];
        if (str2.name.equals(str1))
        {
          AppMethodBeat.o(127734);
          return str2;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(127734);
    return null;
  }
  
  private static Account[] dx(Context paramContext)
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
  
  public static String dy(Context paramContext)
  {
    AppMethodBeat.i(127738);
    Account[] arrayOfAccount = T(paramContext, "com.google");
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
          if (!Util.isNullOrNil(str))
          {
            paramContext = str;
            if (Util.isValidEmail(str)) {
              break;
            }
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(127738);
    return paramContext;
  }
  
  public static void l(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(127730);
    if (du(paramContext))
    {
      if (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.Ojh, false))
      {
        paramContext = new g(paramContext, dw(paramContext), paramString1, paramString2);
        h.RTc.aX(paramContext);
        AppMethodBeat.o(127730);
      }
    }
    else
    {
      Q(paramContext, null);
      Log.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }
    AppMethodBeat.o(127730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.t
 * JD-Core Version:    0.7.0.1
 */