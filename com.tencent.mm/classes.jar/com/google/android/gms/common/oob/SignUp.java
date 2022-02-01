package com.google.android.gms.common.oob;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public class SignUp
{
  public static final String ACTION_OOB_SIGN_UP = "com.google.android.gms.common.oob.OOB_SIGN_UP";
  public static final String EXTRAS_CALLING_APP_DESCRIPTION = "com.google.android.gms.common.oob.EXTRAS_APP_DESCRIPTION";
  public static final String EXTRAS_CLIENT_CALLING_APP_PACKAGE = "com.google.android.gms.common.oob.EXTRAS_CLIENT_CALLING_APP_PACKAGE";
  public static final String EXTRAS_PROMO_APP_PACKAGE = "com.google.android.gms.common.oob.EXTRAS_PROMO_APP_PACKAGE";
  public static final String EXTRAS_PROMO_APP_TEXT = "com.google.android.gms.common.oob.EXTRAS_PROMO_APP_TEXT";
  public static final String EXTRA_ACCOUNT_NAME = "com.google.android.gms.common.oob.EXTRA_ACCOUNT_NAME";
  public static final String EXTRA_BACK_BUTTON_NAME = "com.google.android.gms.common.oob.EXTRA_BACK_BUTTON_NAME";
  public static final String EXTRA_GPSRC = "com.google.android.gms.plus.GPSRC";
  public static final String EXTRA_OVERRIDE_THEME = "com.google.android.gms.plus.OVERRIDE_THEME";
  public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = BaseGmsClient.GOOGLE_PLUS_REQUIRED_FEATURES;
  public static final int THEME_DEFAULT = 0;
  public static final int THEME_FULL = 1;
  public static final int THEME_SETUP_WIZARD = 2;
  
  public static AccountManagerFuture<Boolean> checkSignUpState(Context paramContext, String paramString, String[] paramArrayOfString, AccountManagerCallback<Boolean> paramAccountManagerCallback, Handler paramHandler)
  {
    AppMethodBeat.i(11905);
    if (!TextUtils.isEmpty(paramString))
    {
      bool = true;
      Preconditions.checkArgument(bool, "The accountName is required");
      if (paramArrayOfString == null) {
        break label101;
      }
    }
    int j;
    label101:
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "The requiredFeatures parameter is required");
      paramContext = AccountManager.get(paramContext);
      Account[] arrayOfAccount = paramContext.getAccountsByType("com.google");
      int k = arrayOfAccount.length;
      int i = 0;
      j = 0;
      while (i < k)
      {
        if (paramString.equals(arrayOfAccount[i].name)) {
          j = 1;
        }
        i += 1;
      }
      bool = false;
      break;
    }
    if (j == 0)
    {
      paramContext = new IllegalStateException("Given account does not exist on the device");
      AppMethodBeat.o(11905);
      throw paramContext;
    }
    paramContext = paramContext.hasFeatures(new Account(paramString, "com.google"), paramArrayOfString, paramAccountManagerCallback, paramHandler);
    AppMethodBeat.o(11905);
    return paramContext;
  }
  
  public static boolean isSignedUpBlocking(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(11906);
    boolean bool = ((Boolean)checkSignUpState(paramContext, paramString, paramArrayOfString, null, null).getResult()).booleanValue();
    AppMethodBeat.o(11906);
    return bool;
  }
  
  public static Intent newSignUpIntent(String paramString)
  {
    AppMethodBeat.i(11902);
    paramString = newSignUpIntent(paramString, null);
    AppMethodBeat.o(11902);
    return paramString;
  }
  
  public static Intent newSignUpIntent(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11903);
    Intent localIntent = new Intent();
    localIntent.setPackage("com.google.android.gms");
    localIntent.setAction("com.google.android.gms.common.oob.OOB_SIGN_UP");
    localIntent.putExtra("com.google.android.gms.common.oob.EXTRA_ACCOUNT_NAME", paramString1);
    localIntent.putExtra("com.google.android.gms.common.oob.EXTRA_BACK_BUTTON_NAME", paramString2);
    AppMethodBeat.o(11903);
    return localIntent;
  }
  
  public static Intent newSignUpIntent(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(11904);
    Intent localIntent = new Intent();
    localIntent.setPackage("com.google.android.gms");
    localIntent.setAction("com.google.android.gms.common.oob.OOB_SIGN_UP");
    localIntent.putExtra("com.google.android.gms.common.oob.EXTRA_ACCOUNT_NAME", paramString1);
    localIntent.putExtra("com.google.android.gms.common.oob.EXTRA_BACK_BUTTON_NAME", paramString2);
    localIntent.putExtra("com.google.android.gms.common.oob.EXTRAS_PROMO_APP_PACKAGE", paramString3);
    localIntent.putExtra("com.google.android.gms.common.oob.EXTRAS_PROMO_APP_TEXT", paramString4);
    AppMethodBeat.o(11904);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.oob.SignUp
 * JD-Core Version:    0.7.0.1
 */