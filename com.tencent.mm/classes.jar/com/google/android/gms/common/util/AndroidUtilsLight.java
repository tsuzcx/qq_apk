package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AndroidUtilsLight
{
  public static final String DIGEST_ALGORITHM_SHA1 = "SHA1";
  public static final String DIGEST_ALGORITHM_SHA512 = "SHA-512";
  
  public static MessageDigest getMessageDigest(String paramString)
  {
    AppMethodBeat.i(89994);
    int i = 0;
    while (i < 2) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
        if (localMessageDigest != null)
        {
          AppMethodBeat.o(89994);
          return localMessageDigest;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i += 1;
      }
    }
    AppMethodBeat.o(89994);
    return null;
  }
  
  public static byte[] getPackageCertificateHashBytes(Context paramContext, String paramString)
  {
    AppMethodBeat.i(89993);
    paramContext = getPackageCertificateHashBytes(paramContext, paramString, "SHA1");
    AppMethodBeat.o(89993);
    return paramContext;
  }
  
  public static byte[] getPackageCertificateHashBytes(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89992);
    paramContext = Wrappers.packageManager(paramContext).getPackageInfo(paramString1, 64);
    if ((paramContext.signatures != null) && (paramContext.signatures.length == 1))
    {
      paramString1 = getMessageDigest(paramString2);
      if (paramString1 != null)
      {
        paramContext = paramString1.digest(paramContext.signatures[0].toByteArray());
        AppMethodBeat.o(89992);
        return paramContext;
      }
    }
    AppMethodBeat.o(89992);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.AndroidUtilsLight
 * JD-Core Version:    0.7.0.1
 */