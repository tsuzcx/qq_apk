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
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class t
{
  private static String Bz(String paramString)
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
      ad.e("MicroMsg.MMAccountManager", "stringFilter failed, %s, %s", new Object[] { paramString, localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.MMAccountManager", localException, "", new Object[0]);
      AppMethodBeat.o(127739);
    }
    return paramString;
  }
  
  public static boolean I(Context paramContext, String paramString)
  {
    AppMethodBeat.i(127726);
    boolean bool = bt.isNullOrNil(paramString);
    ad.v("MicroMsg.MMAccountManager", "remove account : ".concat(String.valueOf(paramString)));
    if (paramContext == null)
    {
      ad.e("MicroMsg.MMAccountManager", "null context");
      AppMethodBeat.o(127726);
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        Account[] arrayOfAccount = cT(paramContext);
        if ((arrayOfAccount == null) || (arrayOfAccount.length == 0))
        {
          ad.d("MicroMsg.MMAccountManager", "get account info is null or nil");
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
            ad.i("MicroMsg.MMAccountManager", "remove account success: ".concat(String.valueOf(paramString)));
          }
        }
      }
      catch (Exception paramContext)
      {
        ad.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
        ad.e("MicroMsg.MMAccountManager", "exception in removeAccount() " + paramContext.getMessage());
        AppMethodBeat.o(127726);
        return false;
      }
      AppMethodBeat.o(127726);
      return true;
      i += 1;
    }
  }
  
  public static void J(Context paramContext, String paramString)
  {
    AppMethodBeat.i(127731);
    if (cQ(paramContext))
    {
      if (!com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FvC, false))
      {
        paramContext = new g(paramContext, cS(paramContext), paramString);
        h.Iye.aP(paramContext);
        AppMethodBeat.o(127731);
      }
    }
    else
    {
      I(paramContext, null);
      ad.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }
    AppMethodBeat.o(127731);
  }
  
  private static boolean K(Context paramContext, String paramString)
  {
    AppMethodBeat.i(127736);
    paramContext = cT(paramContext);
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
  
  private static Account[] L(Context paramContext, String paramString)
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
        ad.e("MicroMsg.MMAccountManager", "get all accounts failed");
        ad.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
        paramContext = localObject;
      }
    }
  }
  
  public static int a(Context paramContext, t.a parama)
  {
    AppMethodBeat.i(127723);
    if (paramContext == null)
    {
      ad.e("MicroMsg.MMAccountManager", "context is null");
      AppMethodBeat.o(127723);
      return 0;
    }
    Object localObject2 = aGF();
    Object localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      ad.e("MicroMsg.MMAccountManager", "account username is null or nil");
      localObject1 = (String)com.tencent.mm.kernel.g.afB().afk().get(6, "");
      if (bt.isNullOrNil((String)localObject1)) {}
    }
    else
    {
      if (!K(paramContext, (String)localObject1)) {
        break label89;
      }
      AppMethodBeat.o(127723);
      return 3;
    }
    AppMethodBeat.o(127723);
    return 0;
    label89:
    if (!b.o(paramContext, "android.permission.READ_CONTACTS"))
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
          parama.v(paramContext);
        }
        AppMethodBeat.o(127723);
        return 1;
      }
    }
    catch (Exception paramContext)
    {
      ad.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
      ad.e("MicroMsg.MMAccountManager", "exception in addAccountNoNeedBindMobile() " + paramContext.getMessage());
      if (parama != null) {
        parama.v(null);
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
      ad.e("MicroMsg.MMAccountManager", "activity is null");
      AppMethodBeat.o(127724);
      return 0;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.MMAccountManager", "account username is null or nil");
      AppMethodBeat.o(127724);
      return 0;
    }
    Object localObject = aGF();
    if (bt.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = AccountManager.get(paramContext);
        Account localAccount = new Account(paramString, "com.tencent.mm.account");
        boolean bool = b.o(paramContext, "android.permission.READ_CONTACTS");
        if (!bool)
        {
          AppMethodBeat.o(127724);
          return 2;
        }
        if (K(paramContext, paramString))
        {
          ContentResolver.setSyncAutomatically(localAccount, "com.android.contacts", true);
          AppMethodBeat.o(127724);
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
            parama.v((Bundle)localObject);
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
        ad.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
        ad.e("MicroMsg.MMAccountManager", "exception in addAccount() " + paramContext.getMessage());
        if (parama != null) {
          parama.v(null);
        }
        AppMethodBeat.o(127724);
        return 2;
      }
      paramString = (String)localObject;
    }
  }
  
  private static String aGF()
  {
    AppMethodBeat.i(127728);
    if (!com.tencent.mm.kernel.g.afw())
    {
      ad.e("MicroMsg.MMAccountManager", "getCurrentAccountName MMCore.acc Not Ready");
      AppMethodBeat.o(127728);
      return "";
    }
    Object localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(4, null);
    if (!bt.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      localObject = Bz((String)localObject);
      AppMethodBeat.o(127728);
      return localObject;
      String str = u.aqH();
      localObject = str;
      if (bt.isNullOrNil(str))
      {
        str = u.aqG();
        if (!bt.isNullOrNil(str))
        {
          localObject = str;
          if (!af.aHK(str)) {}
        }
        else
        {
          localObject = "";
        }
      }
    }
  }
  
  public static void cN(Context paramContext)
  {
    AppMethodBeat.i(127725);
    d.eBj();
    if (com.tencent.mm.sdk.platformtools.i.cJX == 0)
    {
      ad.d("MicroMsg.MMAccountManager", "do not auto add account");
      AppMethodBeat.o(127725);
      return;
    }
    if (com.tencent.mm.sdk.platformtools.i.cJX == 1)
    {
      if (l.aIL() == l.a.iky)
      {
        ad.d("MicroMsg.MMAccountManager", "auto add account result: ".concat(String.valueOf(a(paramContext, l.aIN(), null))));
        AppMethodBeat.o(127725);
        return;
      }
      ad.i("MicroMsg.MMAccountManager", "the user not bind mobile or not aggreed to upload addressbook");
      AppMethodBeat.o(127725);
      return;
    }
    if (com.tencent.mm.sdk.platformtools.i.cJX == 2) {
      ad.d("MicroMsg.MMAccountManager", "auto add account result: ".concat(String.valueOf(a(paramContext, null))));
    }
    AppMethodBeat.o(127725);
  }
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
  public static boolean cO(Context paramContext)
  {
    AppMethodBeat.i(127727);
    boolean bool1 = false;
    if (paramContext != null)
    {
      Intent localIntent = new Intent("com.tencent.mm.login.ACTION_LOGOUT");
      localIntent.putExtra("accountName", aGF());
      localIntent.putExtra("accountType", "com.tencent.mm.account");
      boolean bool2 = I(paramContext, aGF());
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
  
  public static void cP(Context paramContext)
  {
    AppMethodBeat.i(127729);
    if (cQ(paramContext))
    {
      if (!com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FvC, false))
      {
        paramContext = new g(paramContext, cS(paramContext));
        h.Iye.aP(paramContext);
        AppMethodBeat.o(127729);
      }
    }
    else
    {
      I(paramContext, null);
      ad.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }
    AppMethodBeat.o(127729);
  }
  
  private static boolean cQ(Context paramContext)
  {
    AppMethodBeat.i(127732);
    paramContext = cS(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(127732);
      return false;
    }
    if (paramContext.name.equals(aGF()))
    {
      AppMethodBeat.o(127732);
      return true;
    }
    AppMethodBeat.o(127732);
    return false;
  }
  
  public static boolean cR(Context paramContext)
  {
    AppMethodBeat.i(127733);
    if (!cQ(paramContext))
    {
      ad.e("MicroMsg.MMAccountManager", "no account added or not current account");
      AppMethodBeat.o(127733);
      return false;
    }
    if (!b.o(paramContext, "android.permission.READ_CONTACTS"))
    {
      AppMethodBeat.o(127733);
      return false;
    }
    paramContext = cS(paramContext);
    if (paramContext != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("expedited", true);
      localBundle.putBoolean("do_not_retry", true);
      ContentResolver.requestSync(paramContext, "com.android.contacts", localBundle);
      AppMethodBeat.o(127733);
      return true;
    }
    ad.e("MicroMsg.MMAccountManager", "no account added");
    AppMethodBeat.o(127733);
    return false;
  }
  
  private static Account cS(Context paramContext)
  {
    AppMethodBeat.i(127734);
    String str2 = aGF();
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      str1 = (String)com.tencent.mm.kernel.g.afB().afk().get(6, "");
    }
    if (!bt.isNullOrNil(str1))
    {
      paramContext = cT(paramContext);
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
  
  private static Account[] cT(Context paramContext)
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
      ad.e("MicroMsg.MMAccountManager", "get all accounts failed");
      ad.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
      AppMethodBeat.o(127735);
    }
    return null;
  }
  
  public static String cU(Context paramContext)
  {
    AppMethodBeat.i(127738);
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
          if (!bt.isNullOrNil(str))
          {
            paramContext = str;
            if (bt.aFV(str)) {
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
    if (cQ(paramContext))
    {
      if (!com.tencent.mm.kernel.g.afB().afk().getBoolean(ae.a.FvC, false))
      {
        paramContext = new g(paramContext, cS(paramContext), paramString1, paramString2);
        h.Iye.aP(paramContext);
        AppMethodBeat.o(127730);
      }
    }
    else
    {
      I(paramContext, null);
      ad.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }
    AppMethodBeat.o(127730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.t
 * JD-Core Version:    0.7.0.1
 */