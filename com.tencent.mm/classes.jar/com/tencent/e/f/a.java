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
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 17	java/io/ByteArrayInputStream
    //   8: dup
    //   9: aload_1
    //   10: invokevirtual 23	android/content/pm/Signature:toByteArray	()[B
    //   13: invokespecial 27	java/io/ByteArrayInputStream:<init>	([B)V
    //   16: astore_1
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 33	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   22: checkcast 35	java/security/cert/X509Certificate
    //   25: astore_0
    //   26: aload_1
    //   27: invokevirtual 39	java/io/ByteArrayInputStream:close	()V
    //   30: ldc 9
    //   32: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: areturn
    //   37: astore_0
    //   38: aload_1
    //   39: invokevirtual 39	java/io/ByteArrayInputStream:close	()V
    //   42: aconst_null
    //   43: astore_0
    //   44: goto -14 -> 30
    //   47: astore_0
    //   48: aconst_null
    //   49: astore_0
    //   50: goto -20 -> 30
    //   53: astore_1
    //   54: goto -24 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	paramCertificateFactory	CertificateFactory
    //   0	57	1	paramSignature	android.content.pm.Signature
    // Exception table:
    //   from	to	target	type
    //   17	26	37	finally
    //   38	42	47	java/io/IOException
    //   26	30	53	java/io/IOException
  }
  
  public static List<byte[]> dm(Context paramContext, String paramString)
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
              localArrayList.add(e.md5(paramString.getEncoded()));
              i += 1;
            }
            catch (CertificateEncodingException paramString)
            {
              for (;;)
              {
                h.he("extractPkgCertMd5s(), CertificateEncodingException: ".concat(String.valueOf(paramString)));
              }
            }
          }
        }
      }
      return localArrayList;
    }
    finally
    {
      h.he("extractPkgCertMd5s(), Exception: ".concat(String.valueOf(paramContext)));
      AppMethodBeat.o(138452);
    }
  }
  
  public static com.tencent.e.a.a dn(Context paramContext, String paramString)
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
        locala.ahsf = e.aC(e.md5(paramContext.getEncoded()));
      }
    }
    finally
    {
      label81:
      break label81;
    }
    AppMethodBeat.o(138453);
    return locala;
  }
  
  public static List<com.tencent.e.a.a> ob(Context paramContext)
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
          break label231;
        }
        i = 1;
        locala = dn(paramContext, localApplicationInfo.packageName);
        if (locala == null) {
          continue;
        }
        locala.ahse = localPackageManager.getApplicationLabel(localApplicationInfo).toString();
        if (locala.ahse != null) {
          break label241;
        }
        locala.ahse = "";
      }
      finally
      {
        ApplicationInfo localApplicationInfo;
        com.tencent.e.a.a locala;
        h.hd("getAllAppInfos(), exception: ".concat(String.valueOf(paramContext)));
        AppMethodBeat.o(138451);
        return localArrayList;
      }
      locala.appType = i;
      locala.fileSize = new File(localApplicationInfo.sourceDir).length();
      locala.ahsg = localApplicationInfo.sourceDir;
      localArrayList.add(locala);
      new StringBuilder("add app: ").append(localApplicationInfo.packageName);
      h.jXD();
      continue;
      label231:
      int i = 0;
      continue;
      label241:
      while (i == 0)
      {
        i = 0;
        break;
      }
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.f.a
 * JD-Core Version:    0.7.0.1
 */