package com.tencent.e.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  /* Error */
  private static java.security.cert.Certificate a(CertificateFactory paramCertificateFactory, android.content.pm.Signature paramSignature)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 19	java/io/ByteArrayInputStream
    //   8: dup
    //   9: aload_1
    //   10: invokevirtual 25	android/content/pm/Signature:toByteArray	()[B
    //   13: invokespecial 29	java/io/ByteArrayInputStream:<init>	([B)V
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 35	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   22: checkcast 37	java/security/cert/X509Certificate
    //   25: astore_0
    //   26: aload_1
    //   27: invokevirtual 41	java/io/ByteArrayInputStream:close	()V
    //   30: ldc 11
    //   32: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: areturn
    //   37: astore_0
    //   38: aload_1
    //   39: invokevirtual 41	java/io/ByteArrayInputStream:close	()V
    //   42: aconst_null
    //   43: astore_0
    //   44: goto -14 -> 30
    //   47: astore_0
    //   48: aconst_null
    //   49: astore_0
    //   50: goto -20 -> 30
    //   53: astore_0
    //   54: aload_1
    //   55: invokevirtual 41	java/io/ByteArrayInputStream:close	()V
    //   58: ldc 11
    //   60: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: athrow
    //   65: astore_1
    //   66: goto -36 -> 30
    //   69: astore_1
    //   70: goto -12 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramCertificateFactory	CertificateFactory
    //   0	73	1	paramSignature	android.content.pm.Signature
    // Exception table:
    //   from	to	target	type
    //   17	26	37	java/lang/Throwable
    //   38	42	47	java/io/IOException
    //   17	26	53	finally
    //   26	30	65	java/io/IOException
    //   54	58	69	java/io/IOException
  }
  
  public static List<byte[]> cS(Context paramContext, String paramString)
  {
    AppMethodBeat.i(138452);
    localArrayList = new ArrayList();
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if ((paramContext != null) && (paramContext.signatures != null) && (paramContext.signatures.length > 0))
      {
        paramContext = paramContext.signatures;
        int i = 0;
        for (;;)
        {
          if ((i < paramContext.length) && (i < 5))
          {
            paramString = (X509Certificate)a(CertificateFactory.getInstance("X.509"), paramContext[i]);
            if (paramString != null) {}
            try
            {
              localArrayList.add(e.cX(paramString.getEncoded()));
              i += 1;
            }
            catch (CertificateEncodingException paramString)
            {
              for (;;)
              {
                h.eA("extractPkgCertMd5s(), CertificateEncodingException: ".concat(String.valueOf(paramString)));
              }
            }
          }
        }
      }
      return localArrayList;
    }
    catch (Throwable paramContext)
    {
      h.eA("extractPkgCertMd5s(), Exception: ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(138452);
    }
  }
  
  public static com.tencent.e.a.a cT(Context paramContext, String paramString)
  {
    AppMethodBeat.i(138453);
    com.tencent.e.a.a locala = new com.tencent.e.a.a();
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      locala.pkgName = paramString;
      locala.versionName = paramContext.versionName;
      locala.versionCode = paramContext.versionCode;
      paramContext = (X509Certificate)a(CertificateFactory.getInstance("X.509"), paramContext.signatures[0]);
      if (paramContext != null) {
        locala.RKQ = e.bytesToHexString(e.cX(paramContext.getEncoded()));
      }
    }
    catch (Throwable paramContext)
    {
      label81:
      break label81;
    }
    AppMethodBeat.o(138453);
    return locala;
  }
  
  public static List<com.tencent.e.a.a> md(Context paramContext)
  {
    AppMethodBeat.i(138451);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        String str = paramContext.getPackageName();
        PackageManager localPackageManager = paramContext.getPackageManager();
        Iterator localIterator = localPackageManager.getInstalledApplications(0).iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        localApplicationInfo = (ApplicationInfo)localIterator.next();
        if ((localApplicationInfo.packageName == null) || (localApplicationInfo.packageName.equals(str))) {
          continue;
        }
        if ((localApplicationInfo.flags & 0x1) == 0) {
          break label226;
        }
        i = 1;
        locala = cT(paramContext, localApplicationInfo.packageName);
        locala.RKP = localPackageManager.getApplicationLabel(localApplicationInfo).toString();
        if (locala.RKP != null) {
          break label236;
        }
        locala.RKP = "";
      }
      catch (Throwable paramContext)
      {
        ApplicationInfo localApplicationInfo;
        com.tencent.e.a.a locala;
        h.ez("getAllAppInfos(), exception: ".concat(String.valueOf(paramContext)));
        AppMethodBeat.o(138451);
        return localArrayList;
      }
      locala.appType = i;
      locala.fileSize = new File(localApplicationInfo.sourceDir).length();
      locala.RKR = localApplicationInfo.sourceDir;
      localArrayList.add(locala);
      new StringBuilder("add app: ").append(localApplicationInfo.packageName);
      h.hkS();
      continue;
      label226:
      int i = 0;
      continue;
      label236:
      while (i == 0)
      {
        i = 0;
        break;
      }
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.e.f.a
 * JD-Core Version:    0.7.0.1
 */