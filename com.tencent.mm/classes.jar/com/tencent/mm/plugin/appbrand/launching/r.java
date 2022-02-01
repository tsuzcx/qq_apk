package com.tencent.mm.plugin.appbrand.launching;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.storage.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Locale;

public final class r
{
  private static final Uri CONTENT_URI;
  private static final r pUB;
  
  static
  {
    AppMethodBeat.i(146066);
    pUB = new r();
    CONTENT_URI = Uri.parse("content://" + a.AUTHORITY + "/DevPkgLaunchExtInfo");
    AppMethodBeat.o(146066);
  }
  
  public static r bZP()
  {
    return pUB;
  }
  
  public static String cs(String paramString, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(146065);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(146065);
      return null;
    }
    Cursor localCursor = MMApplicationContext.getContext().getContentResolver().query(CONTENT_URI, null, String.format(Locale.US, "%s=? And %s=?", new Object[] { "appId", "versionType" }), new String[] { paramString, String.valueOf(paramInt) }, null, null);
    if (localCursor == null)
    {
      AppMethodBeat.o(146065);
      return null;
    }
    paramString = localObject;
    if (!localCursor.isClosed())
    {
      paramString = localObject;
      if (localCursor.moveToFirst())
      {
        paramString = new q();
        paramString.convertFrom(localCursor);
      }
    }
    localCursor.close();
    if (paramString != null)
    {
      paramString = paramString.field_extJson;
      AppMethodBeat.o(146065);
      return paramString;
    }
    AppMethodBeat.o(146065);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.r
 * JD-Core Version:    0.7.0.1
 */