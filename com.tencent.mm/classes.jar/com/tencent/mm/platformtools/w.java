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
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.z;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class w
{
  public static boolean E(Context paramContext, String paramString)
  {
    boolean bool = bk.bl(paramString);
    y.v("MicroMsg.MMAccountManager", "remove account : " + paramString);
    if (paramContext == null)
    {
      y.e("MicroMsg.MMAccountManager", "null context");
      return false;
    }
    for (;;)
    {
      int i;
      try
      {
        Account[] arrayOfAccount = bR(paramContext);
        if ((arrayOfAccount == null) || (arrayOfAccount.length == 0))
        {
          y.d("MicroMsg.MMAccountManager", "get account info is null or nil");
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
            y.i("MicroMsg.MMAccountManager", "remove account success: " + paramString);
          }
        }
      }
      catch (Exception paramContext)
      {
        y.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
        y.e("MicroMsg.MMAccountManager", "exception in removeAccount() " + paramContext.getMessage());
        return false;
      }
      return true;
      i += 1;
    }
  }
  
  public static void F(Context paramContext, String paramString)
  {
    if (bO(paramContext))
    {
      com.tencent.mm.sdk.f.e.b(new h(paramContext, bQ(paramContext), paramString), "MMAccountManager_deleteSpecifiedContact").start();
      return;
    }
    E(paramContext, null);
    y.d("MicroMsg.MMAccountManager", "no account added or not current account");
  }
  
  private static boolean G(Context paramContext, String paramString)
  {
    paramContext = bR(paramContext);
    if ((paramContext == null) || (paramContext.length == 0)) {}
    for (;;)
    {
      return false;
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        if (paramContext[i].name.equals(paramString)) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private static Account[] H(Context paramContext, String paramString)
  {
    try
    {
      paramContext = AccountManager.get(paramContext).getAccountsByType(paramString);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.MMAccountManager", "get all accounts failed");
      y.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  private static String UV()
  {
    if (!g.DK())
    {
      y.e("MicroMsg.MMAccountManager", "getCurrentAccountName MMCore.acc Not Ready");
      return "";
    }
    Object localObject = (String)g.DP().Dz().get(4, null);
    if (!bk.bl((String)localObject)) {}
    for (;;)
    {
      return pf((String)localObject);
      String str = q.Gk();
      localObject = str;
      if (bk.bl(str))
      {
        str = q.Gj();
        if (!bk.bl(str))
        {
          localObject = str;
          if (!ad.aaX(str)) {}
        }
        else
        {
          localObject = "";
        }
      }
    }
  }
  
  public static int a(Context paramContext, w.a parama)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.MMAccountManager", "context is null");
      return 0;
    }
    Object localObject2 = UV();
    Object localObject1 = localObject2;
    if (bk.bl((String)localObject2))
    {
      y.e("MicroMsg.MMAccountManager", "account username is null or nil");
      localObject1 = (String)g.DP().Dz().get(6, "");
      if (bk.bl((String)localObject1)) {}
    }
    else
    {
      if (!G(paramContext, (String)localObject1)) {
        break label69;
      }
      return 3;
    }
    return 0;
    label69:
    if (!a.j(paramContext, "android.permission.READ_CONTACTS")) {
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
          parama.k(paramContext);
        }
        return 1;
      }
    }
    catch (Exception paramContext)
    {
      y.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
      y.e("MicroMsg.MMAccountManager", "exception in addAccountNoNeedBindMobile() " + paramContext.getMessage());
      if (parama != null) {
        parama.k(null);
      }
    }
    return 2;
  }
  
  public static int a(Context paramContext, String paramString, w.a parama)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.MMAccountManager", "activity is null");
      return 0;
    }
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.MMAccountManager", "account username is null or nil");
      return 0;
    }
    Object localObject = UV();
    if (bk.bl((String)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = AccountManager.get(paramContext);
        Account localAccount = new Account(paramString, "com.tencent.mm.account");
        if (!a.j(paramContext, "android.permission.READ_CONTACTS")) {
          return 2;
        }
        if (G(paramContext, paramString))
        {
          ContentResolver.setSyncAutomatically(localAccount, "com.android.contacts", true);
          return 3;
        }
        E(paramContext, null);
        if (((AccountManager)localObject).addAccountExplicitly(localAccount, "", null))
        {
          ContentResolver.setSyncAutomatically(localAccount, "com.android.contacts", true);
          localObject = new Bundle();
          ((Bundle)localObject).putString("authAccount", paramString);
          ((Bundle)localObject).putString("accountType", "com.tencent.mm.account");
          if (parama != null) {
            parama.k((Bundle)localObject);
          }
          localObject = new ContentValues();
          ((ContentValues)localObject).put("account_name", paramString);
          ((ContentValues)localObject).put("account_type", "com.tencent.mm.account");
          ((ContentValues)localObject).put("should_sync", Integer.valueOf(1));
          ((ContentValues)localObject).put("ungrouped_visible", Integer.valueOf(1));
          paramContext.getContentResolver().insert(ContactsContract.Settings.CONTENT_URI, (ContentValues)localObject);
          return 1;
        }
      }
      catch (Exception paramContext)
      {
        y.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
        y.e("MicroMsg.MMAccountManager", "exception in addAccount() " + paramContext.getMessage());
        if (parama != null) {
          parama.k(null);
        }
        return 2;
      }
      paramString = (String)localObject;
    }
  }
  
  public static void bL(Context paramContext)
  {
    d.coz();
    if (com.tencent.mm.sdk.platformtools.e.bvp == 0) {
      y.d("MicroMsg.MMAccountManager", "do not auto add account");
    }
    do
    {
      return;
      if (com.tencent.mm.sdk.platformtools.e.bvp == 1)
      {
        if (l.WP() == l.a.ffT)
        {
          i = a(paramContext, l.WR(), null);
          y.d("MicroMsg.MMAccountManager", "auto add account result: " + i);
          return;
        }
        y.i("MicroMsg.MMAccountManager", "the user not bind mobile or not aggreed to upload addressbook");
        return;
      }
    } while (com.tencent.mm.sdk.platformtools.e.bvp != 2);
    int i = a(paramContext, null);
    y.d("MicroMsg.MMAccountManager", "auto add account result: " + i);
  }
  
  @JgMethodChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.INTENTCHECK})
  public static boolean bM(Context paramContext)
  {
    boolean bool1 = false;
    if (paramContext != null)
    {
      Intent localIntent = new Intent("com.tencent.mm.login.ACTION_LOGOUT");
      localIntent.putExtra("accountName", UV());
      localIntent.putExtra("accountType", "com.tencent.mm.account");
      boolean bool2 = E(paramContext, UV());
      bool1 = bool2;
      if (bool2)
      {
        paramContext.sendBroadcast(localIntent);
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public static void bN(Context paramContext)
  {
    if (bO(paramContext))
    {
      com.tencent.mm.sdk.f.e.b(new h(paramContext, bQ(paramContext)), "MMAccountManager_updateAllContact").start();
      return;
    }
    E(paramContext, null);
    y.d("MicroMsg.MMAccountManager", "no account added or not current account");
  }
  
  public static boolean bO(Context paramContext)
  {
    paramContext = bQ(paramContext);
    if (paramContext == null) {}
    while (!paramContext.name.equals(UV())) {
      return false;
    }
    return true;
  }
  
  public static boolean bP(Context paramContext)
  {
    if (!bO(paramContext)) {
      y.e("MicroMsg.MMAccountManager", "no account added or not current account");
    }
    while (!a.j(paramContext, "android.permission.READ_CONTACTS")) {
      return false;
    }
    paramContext = bQ(paramContext);
    if (paramContext != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("expedited", true);
      localBundle.putBoolean("do_not_retry", true);
      ContentResolver.requestSync(paramContext, "com.android.contacts", localBundle);
      return true;
    }
    y.e("MicroMsg.MMAccountManager", "no account added");
    return false;
  }
  
  public static Account bQ(Context paramContext)
  {
    String str2 = UV();
    String str1 = str2;
    if (bk.bl(str2)) {
      str1 = (String)g.DP().Dz().get(6, "");
    }
    if (!bk.bl(str1))
    {
      paramContext = bR(paramContext);
      if (paramContext == null) {
        return null;
      }
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        str2 = paramContext[i];
        if (str2.name.equals(str1)) {
          return str2;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private static Account[] bR(Context paramContext)
  {
    try
    {
      paramContext = AccountManager.get(paramContext).getAccountsByType("com.tencent.mm.account");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      y.e("MicroMsg.MMAccountManager", "get all accounts failed");
      y.printErrStackTrace("MicroMsg.MMAccountManager", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  public static String bS(Context paramContext)
  {
    Account[] arrayOfAccount = H(paramContext, "com.google");
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
          if (!bk.bl(str))
          {
            paramContext = str;
            if (bk.ZC(str)) {
              break;
            }
          }
          i += 1;
        }
      }
    }
    return paramContext;
  }
  
  private static String pf(String paramString)
  {
    try
    {
      String str = Pattern.compile("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#¥￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(paramString).replaceAll("_").trim();
      return str;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMAccountManager", "stringFilter failed, %s, %s", new Object[] { paramString, localException.getMessage() });
      y.printErrStackTrace("MicroMsg.MMAccountManager", localException, "", new Object[0]);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.w
 * JD-Core Version:    0.7.0.1
 */