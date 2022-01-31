package com.google.android.gms.auth;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CookieUtil
{
  public static String getCookieUrl(String paramString, Boolean paramBoolean)
  {
    AppMethodBeat.i(76936);
    Preconditions.checkNotEmpty(paramString);
    if (zzd(paramBoolean)) {}
    for (paramBoolean = "https";; paramBoolean = "http")
    {
      paramString = String.valueOf(paramBoolean).length() + 3 + String.valueOf(paramString).length() + paramBoolean + "://" + paramString;
      AppMethodBeat.o(76936);
      return paramString;
    }
  }
  
  public static String getCookieValue(String paramString1, String paramString2, String paramString3, String paramString4, Boolean paramBoolean1, Boolean paramBoolean2, Long paramLong)
  {
    AppMethodBeat.i(76937);
    paramString1 = new StringBuilder(paramString1).append('=');
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.append(paramString2);
    }
    if (zzd(paramBoolean1)) {
      paramString1.append(";HttpOnly");
    }
    if (zzd(paramBoolean2)) {
      paramString1.append(";Secure");
    }
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1.append(";Domain=").append(paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      paramString1.append(";Path=").append(paramString4);
    }
    if ((paramLong != null) && (paramLong.longValue() > 0L)) {
      paramString1.append(";Max-Age=").append(paramLong);
    }
    paramString1 = paramString1.toString();
    AppMethodBeat.o(76937);
    return paramString1;
  }
  
  private static boolean zzd(Boolean paramBoolean)
  {
    AppMethodBeat.i(76935);
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      AppMethodBeat.o(76935);
      return true;
    }
    AppMethodBeat.o(76935);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.CookieUtil
 * JD-Core Version:    0.7.0.1
 */