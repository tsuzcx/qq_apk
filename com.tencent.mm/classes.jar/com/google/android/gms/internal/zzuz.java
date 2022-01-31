package com.google.android.gms.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;

public class zzuz
{
  public static String zzct(String paramString)
  {
    boolean bool2 = false;
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzac.zzb(bool1, "account type cannot be empty");
      String str = Uri.parse(paramString).getScheme();
      if (!"http".equalsIgnoreCase(str))
      {
        bool1 = bool2;
        if (!"https".equalsIgnoreCase(str)) {}
      }
      else
      {
        bool1 = true;
      }
      zzac.zzb(bool1, "Account type must be an http or https URI");
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzuz
 * JD-Core Version:    0.7.0.1
 */