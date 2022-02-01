package com.tencent.d.e.b.a.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class b
{
  public static String a(Signature paramSignature, String paramString)
  {
    localObject = null;
    AppMethodBeat.i(138438);
    paramSignature = paramSignature.toByteArray();
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(138438);
        return null;
      }
      paramSignature = paramString.digest(paramSignature);
      paramString = new StringBuilder();
      int j = paramSignature.length;
      int i = 0;
      while (i < j)
      {
        paramString.append(Integer.toHexString(paramSignature[i] & 0xFF | 0x100).substring(1, 3));
        i += 1;
      }
      paramSignature = paramString.toString();
    }
    catch (NoSuchAlgorithmException paramSignature)
    {
      for (;;)
      {
        paramSignature = localObject;
      }
    }
    AppMethodBeat.o(138438);
    return paramSignature;
  }
  
  public static Signature[] cx(Context paramContext, String paramString)
  {
    AppMethodBeat.i(138437);
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64).signatures;
      AppMethodBeat.o(138437);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.d.e.b.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */