package com.tencent.mm.plugin.appbrand.appcache;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.g.d;
import com.tencent.luggage.wxa.storage.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class aw
{
  private static final Uri CONTENT_URI;
  private static final aw gWL;
  
  static
  {
    AppMethodBeat.i(139653);
    gWL = new aw();
    CONTENT_URI = Uri.parse("content://" + a.AUTHORITY + "/AppBrandWxaPkgManifestRecord");
    AppMethodBeat.o(139653);
  }
  
  public static aw awe()
  {
    return gWL;
  }
  
  public static void b(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    AppMethodBeat.i(139652);
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACIION_UPDATE_WITHOUT_CODELIB_INFO");
      localContentValues.put("CONTENT_KEY_APPID", paramString1);
      localContentValues.put("CONTENT_KEY_MODULE_NAME", paramString2);
      localContentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(0));
      localContentValues.put("CONTENT_KEY_CODE_TYPE", Integer.valueOf(paramInt));
      localContentValues.put("CONTENT_KEY_PKG_VERSION_MD5", paramString3);
      localContentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(12));
      ah.getContext().getContentResolver().insert(CONTENT_URI, localContentValues);
      AppMethodBeat.o(139652);
      return;
    }
    catch (Exception localException)
    {
      d.printErrStackTrace("Luggage.DevPkgLaunchExtInfoContentResolver", localException, "updateWithoutCodeLibInfo, appId[%s] module[%s], version[%d], codeType[%d], md5[%s], pkgType[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(0), Integer.valueOf(paramInt), paramString3, Integer.valueOf(12) });
      AppMethodBeat.o(139652);
    }
  }
  
  public static boolean g(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(139650);
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_MODULE_LIST");
      localContentValues.put("CONTENT_KEY_APPID", paramString1);
      localContentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(paramInt));
      localContentValues.put("CONTENT_KEY_PKG_VERSION", Integer.valueOf(-1));
      localContentValues.put("CONTENT_KEY_MODULE_LIST_JSON", paramString2);
      ah.getContext().getContentResolver().insert(CONTENT_URI, localContentValues);
      AppMethodBeat.o(139650);
      return true;
    }
    catch (Exception paramString1)
    {
      d.e("Luggage.DevPkgLaunchExtInfoContentResolver", "setExtInfo fail");
      AppMethodBeat.o(139650);
    }
    return false;
  }
  
  public static void yB(String paramString)
  {
    AppMethodBeat.i(139651);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(139651);
      return;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_CODELIB_LIST");
      localContentValues.put("CONTENT_KEY_CODELIB_LIST", paramString);
      ah.getContext().getContentResolver().insert(CONTENT_URI, localContentValues);
      AppMethodBeat.o(139651);
      return;
    }
    catch (Exception paramString)
    {
      d.printErrStackTrace("Luggage.DevPkgLaunchExtInfoContentResolver", paramString, "updateCodeLibList", new Object[0]);
      AppMethodBeat.o(139651);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aw
 * JD-Core Version:    0.7.0.1
 */