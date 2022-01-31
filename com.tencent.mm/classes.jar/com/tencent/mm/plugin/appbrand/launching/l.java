package com.tencent.mm.plugin.appbrand.launching;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.storage.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Locale;

public final class l
{
  private static final Uri CONTENT_URI;
  private static final l ilh;
  
  static
  {
    AppMethodBeat.i(139655);
    ilh = new l();
    CONTENT_URI = Uri.parse("content://" + a.AUTHORITY + "/DevPkgLaunchExtInfo");
    AppMethodBeat.o(139655);
  }
  
  public static l aGS()
  {
    return ilh;
  }
  
  public static String bm(String paramString, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(139654);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(139654);
      return null;
    }
    Cursor localCursor = ah.getContext().getContentResolver().query(CONTENT_URI, null, String.format(Locale.US, "%s=? And %s=?", new Object[] { "appId", "versionType" }), new String[] { paramString, String.valueOf(paramInt) }, null, null);
    if (localCursor == null)
    {
      AppMethodBeat.o(139654);
      return null;
    }
    paramString = localObject;
    if (!localCursor.isClosed())
    {
      paramString = localObject;
      if (localCursor.moveToFirst())
      {
        paramString = new k();
        paramString.convertFrom(localCursor);
      }
    }
    localCursor.close();
    if (paramString != null)
    {
      paramString = paramString.field_extJson;
      AppMethodBeat.o(139654);
      return paramString;
    }
    AppMethodBeat.o(139654);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.l
 * JD-Core Version:    0.7.0.1
 */