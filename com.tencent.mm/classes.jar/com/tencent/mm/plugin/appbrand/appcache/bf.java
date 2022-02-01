package com.tencent.mm.plugin.appbrand.appcache;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.storage.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class bf
{
  private static final Uri CONTENT_URI;
  private static final bf kND;
  
  static
  {
    AppMethodBeat.i(146008);
    kND = new bf();
    CONTENT_URI = Uri.parse("content://" + a.AUTHORITY + "/AppBrandWxaPkgManifestRecord");
    AppMethodBeat.o(146008);
  }
  
  public static void Vp(String paramString)
  {
    AppMethodBeat.i(146006);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(146006);
      return;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_PLUGINCODE_LIST");
      localContentValues.put("CONTENT_KEY_PLUGINCODE_LIST", paramString);
      MMApplicationContext.getContext().getContentResolver().insert(CONTENT_URI, localContentValues);
      AppMethodBeat.o(146006);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("Luggage.DevPkgLaunchExtInfoContentResolver", paramString, "updatePluginCodeList", new Object[0]);
      AppMethodBeat.o(146006);
    }
  }
  
  public static boolean aV(String paramString, int paramInt)
  {
    AppMethodBeat.i(229807);
    Log.i("Luggage.DevPkgLaunchExtInfoContentResolver", "deleteModuleList appId:%s, pkgType:%d, pkgVersion:%d", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(-1) });
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACTION_DELETE_MODULE_LIST");
      localContentValues.put("CONTENT_KEY_APPID", paramString);
      localContentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(paramInt));
      localContentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(-1));
      MMApplicationContext.getContext().getContentResolver().update(CONTENT_URI, localContentValues, null, null);
      AppMethodBeat.o(229807);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("Luggage.DevPkgLaunchExtInfoContentResolver", "deleteModuleList failed, appId:%s, pkgType:%d, pkgVersion:%d, exception:%s", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(-1), localException });
      }
    }
  }
  
  public static void b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(146007);
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACIION_UPDATE_WITHOUT_PLUGINCODE_INFO");
      localContentValues.put("CONTENT_KEY_APPID", paramString1);
      localContentValues.put("CONTENT_KEY_MODULE_NAME", paramString2);
      localContentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(0));
      localContentValues.put("CONTENT_KEY_CODE_TYPE", Integer.valueOf(paramInt));
      localContentValues.put("CONTENT_KEY_PKG_VERSION_MD5", paramString3);
      localContentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(12));
      MMApplicationContext.getContext().getContentResolver().insert(CONTENT_URI, localContentValues);
      AppMethodBeat.o(146007);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("Luggage.DevPkgLaunchExtInfoContentResolver", localException, "updateWithoutPluginCodeInfo, appId[%s] module[%s], version[%d], codeType[%d], md5[%s], pkgType[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(0), Integer.valueOf(paramInt), paramString3, Integer.valueOf(12) });
      AppMethodBeat.o(146007);
    }
  }
  
  public static bf bwx()
  {
    return kND;
  }
  
  public static void c(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(177310);
    if (TextUtils.isEmpty(paramString3))
    {
      AppMethodBeat.o(177310);
      return;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_PKG_INFO");
      localContentValues.put("CONTENT_KEY_APPID", paramString1);
      localContentValues.put("CONTENT_KEY_MODULE_NAME", paramString2);
      localContentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(0));
      localContentValues.put("CONTENT_KEY_CODE_TYPE", Integer.valueOf(paramInt));
      localContentValues.put("CONTENT_KEY_PKGINFO_LIST", paramString3);
      MMApplicationContext.getContext().getContentResolver().insert(CONTENT_URI, localContentValues);
      AppMethodBeat.o(177310);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("Luggage.DevPkgLaunchExtInfoContentResolver", paramString1, "updatePkgInfoList", new Object[0]);
      AppMethodBeat.o(177310);
    }
  }
  
  public static boolean q(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(146005);
    Log.i("Luggage.DevPkgLaunchExtInfoContentResolver", "updateModuleList appId:%s, pkgType:%d, pkgVersion:%d", new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(-1) });
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_MODULE_LIST");
      localContentValues.put("CONTENT_KEY_APPID", paramString1);
      localContentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(paramInt));
      localContentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(-1));
      localContentValues.put("CONTENT_KEY_MODULE_LIST_JSON", paramString2);
      MMApplicationContext.getContext().getContentResolver().insert(CONTENT_URI, localContentValues);
      AppMethodBeat.o(146005);
      return true;
    }
    catch (Exception paramString2)
    {
      Log.e("Luggage.DevPkgLaunchExtInfoContentResolver", "updateModuleList failed appId:%s, pkgType:%d, pkgVersion:%d, exception:%s", new Object[] { paramString1, Integer.valueOf(paramInt), Integer.valueOf(-1), paramString2 });
      AppMethodBeat.o(146005);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.bf
 * JD-Core Version:    0.7.0.1
 */