package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.luggage.wxa.storage.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class t
{
  private static final Uri URI;
  private static final t hkn;
  
  static
  {
    AppMethodBeat.i(94156);
    URI = Uri.parse("content://" + a.AUTHORITY + "/WxaAttributesTable");
    hkn = new t();
    AppMethodBeat.o(94156);
  }
  
  public static WxaAttributes AF(String paramVarArgs)
  {
    AppMethodBeat.i(94154);
    paramVarArgs = f(String.format("%s=?", new Object[] { "appId" }), new String[] { paramVarArgs });
    AppMethodBeat.o(94154);
    return paramVarArgs;
  }
  
  public static t ayI()
  {
    return hkn;
  }
  
  public static WxaAttributes f(String paramString, String[] paramArrayOfString)
  {
    Object localObject = null;
    AppMethodBeat.i(94155);
    paramArrayOfString = ah.getContext().getContentResolver().query(URI, null, paramString, paramArrayOfString, null);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(94155);
      return null;
    }
    paramString = localObject;
    if (!paramArrayOfString.isClosed())
    {
      paramString = localObject;
      if (paramArrayOfString.moveToFirst())
      {
        paramString = new WxaAttributes();
        paramString.convertFrom(paramArrayOfString);
      }
    }
    paramArrayOfString.close();
    AppMethodBeat.o(94155);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.t
 * JD-Core Version:    0.7.0.1
 */