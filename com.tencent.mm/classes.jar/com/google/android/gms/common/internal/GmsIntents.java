package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcelable;
import android.support.v4.app.y.a;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.api.Scope;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Locale;

public class GmsIntents
{
  public static final String ACTION_FITNESS_APP_DISCONNECTED = "com.google.android.gms.fitness.app_disconnected";
  public static final String ACTION_ICING_CONTACT_CHANGED = "com.google.android.gms.icing.action.CONTACT_CHANGED";
  public static final String ACTION_SET_GMS_ACCOUNT = "com.google.android.gms.common.SET_GMS_ACCOUNT";
  public static final String ACTION_UDC_SETTING_CHANGED = "com.google.android.gms.udc.action.SETTING_CHANGED";
  public static final String BROADCAST_CIRCLES_CHANGED = "com.google.android.gms.people.BROADCAST_CIRCLES_CHANGED";
  public static final String COMMON_SIGN_IN_EXTRA_PACKAGE_NAME = "SIGN_IN_PACKAGE_NAME";
  public static final String COMMON_SIGN_IN_EXTRA_SAVE_DEFAULT_ACCOUNT = "SIGN_IN_SAVE_DEFAULT_ACCOUNT";
  public static final String COMMON_SIGN_IN_EXTRA_SCOPE_ARRAY = "SIGN_IN_SCOPE_ARRAY";
  public static final String EXTRA_ACCOUNT = "com.google.android.gms.fitness.disconnected_account";
  public static final String EXTRA_APP = "com.google.android.gms.fitness.disconnected_app";
  public static final String EXTRA_ICING_CONTACT_CHANGED_IS_SIGNIFICANT = "com.google.android.gms.icing.extra.isSignificant";
  public static final String EXTRA_SET_GMS_ACCOUNT_NAME = "ACCOUNT_NAME";
  public static final String EXTRA_SET_GMS_ACCOUNT_PACKAGE_NAME = "PACKAGE_NAME";
  public static final String EXTRA_UDC_ACCOUNT_NAME = "com.google.android.gms.udc.extra.accountName";
  public static final String EXTRA_UDC_SETTING_ID_LIST = "com.google.android.gms.udc.extra.settingIdList";
  public static final String GOOGLE_NOW_PACKAGE_NAME = "com.google.android.googlequicksearchbox";
  public static final String MIME_ACTIVITY_DISCONNECT_TYPE = "vnd.google.android.fitness/app_disconnect";
  public static final String PERMISSION_GMS_INTERNAL_BROADCAST = "com.google.android.gms.permission.INTERNAL_BROADCAST";
  private static final Uri zztz;
  private static final Uri zzua;
  
  static
  {
    AppMethodBeat.i(4663);
    Uri localUri = Uri.parse("https://plus.google.com/");
    zztz = localUri;
    zzua = localUri.buildUpon().appendPath("circles").appendPath("find").build();
    AppMethodBeat.o(4663);
  }
  
  public static Intent createAndroidWearUpdateIntent()
  {
    AppMethodBeat.i(4650);
    Intent localIntent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
    localIntent.setPackage("com.google.android.wearable.app");
    AppMethodBeat.o(4650);
    return localIntent;
  }
  
  public static Intent createChooseGmsAccountIntent()
  {
    AppMethodBeat.i(4658);
    Intent localIntent = AccountPicker.newChooseAccountIntent(null, null, new String[] { "com.google" }, true, null, null, null, null, true);
    AppMethodBeat.o(4658);
    return localIntent;
  }
  
  public static Intent createChooseGmsAccountWithConsentIntent(String paramString, Scope[] paramArrayOfScope, boolean paramBoolean)
  {
    AppMethodBeat.i(4659);
    Intent localIntent = new Intent("com.google.android.gms.signin.action.SIGN_IN");
    localIntent.putExtra("SIGN_IN_PACKAGE_NAME", paramString);
    localIntent.putExtra("SIGN_IN_SCOPE_ARRAY", paramArrayOfScope);
    localIntent.putExtra("SIGN_IN_SAVE_DEFAULT_ACCOUNT", paramBoolean);
    AppMethodBeat.o(4659);
    return localIntent;
  }
  
  public static Intent createDateSettingsIntent()
  {
    AppMethodBeat.i(4644);
    Intent localIntent = new Intent("android.settings.DATE_SETTINGS");
    AppMethodBeat.o(4644);
    return localIntent;
  }
  
  public static Intent createFindPeopleIntent(Context paramContext)
  {
    AppMethodBeat.i(4654);
    paramContext = zza(paramContext, zzua);
    AppMethodBeat.o(4654);
    return paramContext;
  }
  
  public static Intent createPlayStoreGamesIntent(Context paramContext)
  {
    AppMethodBeat.i(4649);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("http://play.google.com/store/apps/category/GAME"));
    localIntent.addFlags(524288);
    localIntent.setPackage("com.android.vending");
    if (paramContext.getPackageManager().resolveActivity(localIntent, 65536) == null)
    {
      paramContext = new Intent(localIntent.getAction(), localIntent.getData());
      paramContext.setFlags(localIntent.getFlags());
      AppMethodBeat.o(4649);
      return paramContext;
    }
    AppMethodBeat.o(4649);
    return localIntent;
  }
  
  public static Intent createPlayStoreIntent(String paramString)
  {
    AppMethodBeat.i(4646);
    paramString = createPlayStoreIntent(paramString, null);
    AppMethodBeat.o(4646);
    return paramString;
  }
  
  public static Intent createPlayStoreIntent(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4647);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    paramString1 = Uri.parse("market://details").buildUpon().appendQueryParameter("id", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.appendQueryParameter("pcampaignid", paramString2);
    }
    localIntent.setData(paramString1.build());
    localIntent.setPackage("com.android.vending");
    localIntent.addFlags(524288);
    AppMethodBeat.o(4647);
    return localIntent;
  }
  
  public static Intent createPlayStoreLightPurchaseFlowIntent(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(4648);
    Intent localIntent = new Intent("com.android.vending.billing.PURCHASE");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setPackage("com.android.vending");
    if (!TextUtils.isEmpty(paramString1)) {
      localIntent.putExtra("authAccount", paramString1);
    }
    localIntent.putExtra("backend", 3);
    localIntent.putExtra("document_type", 1);
    localIntent.putExtra("full_docid", paramString2);
    localIntent.putExtra("backend_docid", paramString2);
    localIntent.putExtra("offer_type", 1);
    paramString1 = localIntent;
    if (!isIntentResolvable(paramContext.getPackageManager(), localIntent))
    {
      paramString1 = new Intent("android.intent.action.VIEW");
      paramString1.setData(Uri.parse(String.format(Locale.US, "https://play.google.com/store/apps/details?id=%1$s&rdid=%1$s&rdot=%2$d", new Object[] { paramString2, Integer.valueOf(1) })));
      paramString1.setPackage("com.android.vending");
      paramString1.putExtra("use_direct_purchase", true);
    }
    AppMethodBeat.o(4648);
    return paramString1;
  }
  
  public static Intent createSettingsIntent(String paramString)
  {
    AppMethodBeat.i(4643);
    paramString = Uri.fromParts("package", paramString, null);
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(paramString);
    AppMethodBeat.o(4643);
    return localIntent;
  }
  
  public static Intent createShareOnPlusIntent(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(4657);
    y.a locala = new y.a(paramActivity);
    locala.mIntent.putExtra("android.intent.extra.SUBJECT", paramString1);
    locala.mIntent.putExtra("android.intent.extra.TEXT", paramString2);
    locala.mIntent.setType("text/plain");
    if (locala.FM != null)
    {
      locala.a("android.intent.extra.EMAIL", locala.FM);
      locala.FM = null;
    }
    if (locala.FN != null)
    {
      locala.a("android.intent.extra.CC", locala.FN);
      locala.FN = null;
    }
    if (locala.FO != null)
    {
      locala.a("android.intent.extra.BCC", locala.FO);
      locala.FO = null;
    }
    int i;
    if ((locala.FP != null) && (locala.FP.size() > 1))
    {
      i = 1;
      boolean bool = locala.mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
      if ((i == 0) && (bool))
      {
        locala.mIntent.setAction("android.intent.action.SEND");
        if ((locala.FP == null) || (locala.FP.isEmpty())) {
          break label338;
        }
        locala.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)locala.FP.get(0));
        label237:
        locala.FP = null;
      }
      if ((i != 0) && (!bool))
      {
        locala.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
        if ((locala.FP == null) || (locala.FP.isEmpty())) {
          break label352;
        }
        locala.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", locala.FP);
      }
    }
    for (;;)
    {
      paramString1 = locala.mIntent;
      paramString1.setPackage("com.google.android.apps.plus");
      if (!isIntentResolvable(paramActivity.getPackageManager(), paramString1)) {
        break label366;
      }
      AppMethodBeat.o(4657);
      return paramString1;
      i = 0;
      break;
      label338:
      locala.mIntent.removeExtra("android.intent.extra.STREAM");
      break label237;
      label352:
      locala.mIntent.removeExtra("android.intent.extra.STREAM");
    }
    label366:
    paramActivity = createPlayStoreIntent("com.google.android.apps.plus");
    AppMethodBeat.o(4657);
    return paramActivity;
  }
  
  public static Intent createShowProfileIntent(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4655);
    paramContext = zza(paramContext, Uri.parse(String.format("https://plus.google.com/%s/about", new Object[] { paramString })));
    AppMethodBeat.o(4655);
    return paramContext;
  }
  
  public static Intent getFitnessAppDisconnectedIntent(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4662);
    Intent localIntent = new Intent();
    localIntent.setPackage("com.google.android.gms");
    localIntent.setAction("com.google.android.gms.fitness.app_disconnected");
    localIntent.setType("vnd.google.android.fitness/app_disconnect");
    localIntent.putExtra("com.google.android.gms.fitness.disconnected_app", paramString1);
    localIntent.putExtra("com.google.android.gms.fitness.disconnected_account", paramString2);
    AppMethodBeat.o(4662);
    return localIntent;
  }
  
  public static Uri getPlayStoreUri(String paramString)
  {
    AppMethodBeat.i(4645);
    paramString = Uri.parse("https://play.google.com/store/apps/details").buildUpon().appendQueryParameter("id", paramString).build();
    AppMethodBeat.o(4645);
    return paramString;
  }
  
  public static boolean isIntentResolvable(PackageManager paramPackageManager, Intent paramIntent)
  {
    AppMethodBeat.i(4661);
    if (paramPackageManager.resolveActivity(paramIntent, 65536) != null)
    {
      AppMethodBeat.o(4661);
      return true;
    }
    AppMethodBeat.o(4661);
    return false;
  }
  
  public static void sendIcingContactChangedBroadcast(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(4653);
    Intent localIntent = new Intent("com.google.android.gms.icing.action.CONTACT_CHANGED").setPackage("com.google.android.gms").putExtra("com.google.android.gms.icing.extra.isSignificant", paramBoolean);
    if (Log.isLoggable("GmsIntents", 2))
    {
      String str = localIntent.getAction();
      new StringBuilder(String.valueOf(str).length() + 98).append("Icing detected contact change, broadcasting it with intent action: ").append(str).append(" and isSignificant extra: ").append(paramBoolean);
    }
    paramContext.sendBroadcast(localIntent);
    AppMethodBeat.o(4653);
  }
  
  public static void sendSetGmsAccountIntent(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(4660);
    Intent localIntent = new Intent("com.google.android.gms.common.SET_GMS_ACCOUNT");
    localIntent.putExtra("ACCOUNT_NAME", paramString1);
    localIntent.putExtra("PACKAGE_NAME", paramString2);
    localIntent.setPackage("com.google.android.gms");
    paramContext.sendBroadcast(localIntent, "com.google.android.gms.permission.INTERNAL_BROADCAST");
    AppMethodBeat.o(4660);
  }
  
  public static void sendUdcSettingsChangedBroadcast(Context paramContext, String paramString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(4651);
    zza("com.google.android.gms", paramContext, paramString, paramArrayOfInt);
    if (!GoogleSignatureVerifier.getInstance(paramContext).isPackageGoogleSigned("com.google.android.googlequicksearchbox"))
    {
      Log.isLoggable("GmsIntents", 5);
      AppMethodBeat.o(4651);
      return;
    }
    zza("com.google.android.googlequicksearchbox", paramContext, paramString, paramArrayOfInt);
    AppMethodBeat.o(4651);
  }
  
  private static Intent zza(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(4656);
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(paramUri);
    localIntent.setPackage("com.google.android.apps.plus");
    if (isIntentResolvable(paramContext.getPackageManager(), localIntent))
    {
      AppMethodBeat.o(4656);
      return localIntent;
    }
    paramContext = createPlayStoreIntent("com.google.android.apps.plus");
    AppMethodBeat.o(4656);
    return paramContext;
  }
  
  private static void zza(String paramString1, Context paramContext, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(4652);
    paramString2 = new Intent("com.google.android.gms.udc.action.SETTING_CHANGED").setPackage(paramString1).putExtra("com.google.android.gms.udc.extra.accountName", paramString2).putExtra("com.google.android.gms.udc.extra.settingIdList", paramArrayOfInt);
    if (Log.isLoggable("GmsIntents", 3))
    {
      paramArrayOfInt = paramString2.getAction();
      new StringBuilder(String.valueOf(paramString1).length() + 72 + String.valueOf(paramArrayOfInt).length()).append("UDC settings changed, sending broadcast to package ").append(paramString1).append(" with intent action: ").append(paramArrayOfInt);
    }
    paramContext.sendBroadcast(paramString2);
    AppMethodBeat.o(4652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.internal.GmsIntents
 * JD-Core Version:    0.7.0.1
 */