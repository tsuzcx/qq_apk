package com.facebook.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public class FacebookSignatureValidator
{
  private static final String FBF_HASH = "2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3";
  private static final String FBI_HASH = "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc";
  private static final String FBL2_HASH = "df6b721c8b4d3b6eb44c861d4415007e5a35fc95";
  private static final String FBL_HASH = "5e8f16062ea3cd2c4a0d547876baa6f38cabf625";
  private static final String FBR2_HASH = "cc2751449a350f668590264ed76692694a80308a";
  private static final String FBR_HASH = "8a3c4b262d721acd49a4bf97d5213199c86fa2b9";
  private static final String MSR_HASH = "9b8f518b086098de3d77736f9458a3d2f6f95a37";
  private static final HashSet<String> validAppSignatureHashes;
  
  static
  {
    AppMethodBeat.i(17728);
    validAppSignatureHashes = buildAppSignatureHashes();
    AppMethodBeat.o(17728);
  }
  
  private static HashSet<String> buildAppSignatureHashes()
  {
    AppMethodBeat.i(17726);
    HashSet localHashSet = new HashSet();
    localHashSet.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
    localHashSet.add("cc2751449a350f668590264ed76692694a80308a");
    localHashSet.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
    localHashSet.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
    localHashSet.add("df6b721c8b4d3b6eb44c861d4415007e5a35fc95");
    localHashSet.add("9b8f518b086098de3d77736f9458a3d2f6f95a37");
    localHashSet.add("2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3");
    AppMethodBeat.o(17726);
    return localHashSet;
  }
  
  public static boolean validateSignature(Context paramContext, String paramString)
  {
    AppMethodBeat.i(17727);
    String str = Build.BRAND;
    int i = paramContext.getApplicationInfo().flags;
    if ((str.startsWith("generic")) && ((i & 0x2) != 0))
    {
      AppMethodBeat.o(17727);
      return true;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if ((paramContext.signatures == null) || (paramContext.signatures.length <= 0))
      {
        AppMethodBeat.o(17727);
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      AppMethodBeat.o(17727);
      return false;
    }
    paramContext = paramContext.signatures;
    int j = paramContext.length;
    i = 0;
    while (i < j)
    {
      paramString = Utility.sha1hash(paramContext[i].toByteArray());
      if (!validAppSignatureHashes.contains(paramString))
      {
        AppMethodBeat.o(17727);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(17727);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.internal.FacebookSignatureValidator
 * JD-Core Version:    0.7.0.1
 */