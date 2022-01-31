package com.tencent.d.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
    //   0: new 12	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 18	android/content/pm/Signature:toByteArray	()[B
    //   8: invokespecial 22	java/io/ByteArrayInputStream:<init>	([B)V
    //   11: astore_1
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 28	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   17: checkcast 30	java/security/cert/X509Certificate
    //   20: astore_0
    //   21: aload_1
    //   22: invokevirtual 34	java/io/ByteArrayInputStream:close	()V
    //   25: aload_0
    //   26: areturn
    //   27: astore_0
    //   28: aload_1
    //   29: invokevirtual 34	java/io/ByteArrayInputStream:close	()V
    //   32: aconst_null
    //   33: areturn
    //   34: astore_0
    //   35: aconst_null
    //   36: areturn
    //   37: astore_0
    //   38: aload_1
    //   39: invokevirtual 34	java/io/ByteArrayInputStream:close	()V
    //   42: aload_0
    //   43: athrow
    //   44: astore_1
    //   45: aload_0
    //   46: areturn
    //   47: astore_1
    //   48: goto -6 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	paramCertificateFactory	CertificateFactory
    //   0	51	1	paramSignature	android.content.pm.Signature
    // Exception table:
    //   from	to	target	type
    //   12	21	27	java/lang/Throwable
    //   28	32	34	java/io/IOException
    //   12	21	37	finally
    //   21	25	44	java/io/IOException
    //   38	42	47	java/io/IOException
  }
  
  /* Error */
  public static String afI(String paramString)
  {
    // Byte code:
    //   0: new 39	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 46	java/io/File:exists	()Z
    //   11: ifne +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 48	java/util/zip/ZipFile
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 49	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: aload_0
    //   26: ldc 51
    //   28: invokevirtual 55	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   31: astore 4
    //   33: aload 4
    //   35: ifnonnull +12 -> 47
    //   38: aload_0
    //   39: invokevirtual 56	java/util/zip/ZipFile:close	()V
    //   42: aconst_null
    //   43: areturn
    //   44: astore_0
    //   45: aconst_null
    //   46: areturn
    //   47: aload 4
    //   49: invokevirtual 62	java/util/zip/ZipEntry:getSize	()J
    //   52: lstore_2
    //   53: lload_2
    //   54: ldc2_w 63
    //   57: lcmp
    //   58: iflt +12 -> 70
    //   61: aload_0
    //   62: invokevirtual 56	java/util/zip/ZipFile:close	()V
    //   65: aconst_null
    //   66: areturn
    //   67: astore_0
    //   68: aconst_null
    //   69: areturn
    //   70: new 66	java/io/BufferedReader
    //   73: dup
    //   74: new 68	java/io/InputStreamReader
    //   77: dup
    //   78: aload_0
    //   79: aload 4
    //   81: invokevirtual 72	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   84: invokespecial 75	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   87: invokespecial 78	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   90: astore 8
    //   92: aload_0
    //   93: astore 5
    //   95: aload 8
    //   97: astore 4
    //   99: aload 8
    //   101: invokevirtual 82	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   104: astore 6
    //   106: aload 6
    //   108: ifnull +111 -> 219
    //   111: aload_0
    //   112: astore 5
    //   114: aload 8
    //   116: astore 4
    //   118: aload 6
    //   120: ldc 84
    //   122: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   125: ifeq -33 -> 92
    //   128: aload_0
    //   129: astore 5
    //   131: aload 8
    //   133: astore 4
    //   135: aload 8
    //   137: invokevirtual 82	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   140: astore 6
    //   142: aload 6
    //   144: ifnull -52 -> 92
    //   147: aload_0
    //   148: astore 5
    //   150: aload 8
    //   152: astore 4
    //   154: aload 6
    //   156: ldc 92
    //   158: invokevirtual 90	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   161: ifeq -69 -> 92
    //   164: aload_0
    //   165: astore 5
    //   167: aload 8
    //   169: astore 4
    //   171: aload 6
    //   173: ldc 94
    //   175: invokevirtual 98	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   178: istore_1
    //   179: iload_1
    //   180: ifle -88 -> 92
    //   183: aload_0
    //   184: astore 5
    //   186: aload 8
    //   188: astore 4
    //   190: aload 6
    //   192: iload_1
    //   193: iconst_1
    //   194: iadd
    //   195: invokevirtual 102	java/lang/String:substring	(I)Ljava/lang/String;
    //   198: invokevirtual 105	java/lang/String:trim	()Ljava/lang/String;
    //   201: astore 6
    //   203: aload 8
    //   205: invokevirtual 106	java/io/BufferedReader:close	()V
    //   208: aload_0
    //   209: invokevirtual 56	java/util/zip/ZipFile:close	()V
    //   212: aload 6
    //   214: areturn
    //   215: astore_0
    //   216: aload 6
    //   218: areturn
    //   219: aload 8
    //   221: invokevirtual 106	java/io/BufferedReader:close	()V
    //   224: aload_0
    //   225: invokevirtual 56	java/util/zip/ZipFile:close	()V
    //   228: aconst_null
    //   229: areturn
    //   230: astore_0
    //   231: aconst_null
    //   232: areturn
    //   233: astore 7
    //   235: aconst_null
    //   236: astore 6
    //   238: aconst_null
    //   239: astore_0
    //   240: aload 6
    //   242: astore 5
    //   244: aload_0
    //   245: astore 4
    //   247: new 108	java/lang/StringBuilder
    //   250: dup
    //   251: ldc 110
    //   253: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   256: aload 7
    //   258: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 124	com/tencent/d/f/h:cp	(Ljava/lang/Object;)V
    //   267: aload_0
    //   268: ifnull +7 -> 275
    //   271: aload_0
    //   272: invokevirtual 106	java/io/BufferedReader:close	()V
    //   275: aload 6
    //   277: ifnull +105 -> 382
    //   280: aload 6
    //   282: invokevirtual 56	java/util/zip/ZipFile:close	()V
    //   285: aconst_null
    //   286: areturn
    //   287: astore_0
    //   288: aconst_null
    //   289: areturn
    //   290: astore 6
    //   292: aconst_null
    //   293: astore_0
    //   294: aconst_null
    //   295: astore 4
    //   297: aload 4
    //   299: ifnull +8 -> 307
    //   302: aload 4
    //   304: invokevirtual 106	java/io/BufferedReader:close	()V
    //   307: aload_0
    //   308: ifnull +7 -> 315
    //   311: aload_0
    //   312: invokevirtual 56	java/util/zip/ZipFile:close	()V
    //   315: aload 6
    //   317: athrow
    //   318: astore 4
    //   320: goto -112 -> 208
    //   323: astore 4
    //   325: goto -101 -> 224
    //   328: astore_0
    //   329: goto -54 -> 275
    //   332: astore 4
    //   334: goto -27 -> 307
    //   337: astore_0
    //   338: goto -23 -> 315
    //   341: astore 6
    //   343: aconst_null
    //   344: astore 4
    //   346: goto -49 -> 297
    //   349: astore 6
    //   351: aload 5
    //   353: astore_0
    //   354: goto -57 -> 297
    //   357: astore 7
    //   359: aconst_null
    //   360: astore 4
    //   362: aload_0
    //   363: astore 6
    //   365: aload 4
    //   367: astore_0
    //   368: goto -128 -> 240
    //   371: astore 7
    //   373: aload_0
    //   374: astore 6
    //   376: aload 8
    //   378: astore_0
    //   379: goto -139 -> 240
    //   382: aconst_null
    //   383: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	paramString	String
    //   178	17	1	i	int
    //   52	2	2	l	long
    //   31	272	4	localObject1	Object
    //   318	1	4	localIOException1	java.io.IOException
    //   323	1	4	localIOException2	java.io.IOException
    //   332	1	4	localIOException3	java.io.IOException
    //   344	22	4	localObject2	Object
    //   93	259	5	localObject3	Object
    //   104	177	6	str1	String
    //   290	26	6	localObject4	Object
    //   341	1	6	localObject5	Object
    //   349	1	6	localObject6	Object
    //   363	12	6	str2	String
    //   233	24	7	localThrowable1	Throwable
    //   357	1	7	localThrowable2	Throwable
    //   371	1	7	localThrowable3	Throwable
    //   90	287	8	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   38	42	44	java/io/IOException
    //   61	65	67	java/io/IOException
    //   208	212	215	java/io/IOException
    //   224	228	230	java/io/IOException
    //   0	14	233	java/lang/Throwable
    //   16	25	233	java/lang/Throwable
    //   280	285	287	java/io/IOException
    //   0	14	290	finally
    //   16	25	290	finally
    //   203	208	318	java/io/IOException
    //   219	224	323	java/io/IOException
    //   271	275	328	java/io/IOException
    //   302	307	332	java/io/IOException
    //   311	315	337	java/io/IOException
    //   25	33	341	finally
    //   47	53	341	finally
    //   70	92	341	finally
    //   99	106	349	finally
    //   118	128	349	finally
    //   135	142	349	finally
    //   154	164	349	finally
    //   171	179	349	finally
    //   190	203	349	finally
    //   247	267	349	finally
    //   25	33	357	java/lang/Throwable
    //   47	53	357	java/lang/Throwable
    //   70	92	357	java/lang/Throwable
    //   99	106	371	java/lang/Throwable
    //   118	128	371	java/lang/Throwable
    //   135	142	371	java/lang/Throwable
    //   154	164	371	java/lang/Throwable
    //   171	179	371	java/lang/Throwable
    //   190	203	371	java/lang/Throwable
  }
  
  public static List<byte[]> bL(Context paramContext, String paramString)
  {
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
              localArrayList.add(e.bQ(paramString.getEncoded()));
              i += 1;
            }
            catch (CertificateEncodingException paramString)
            {
              for (;;)
              {
                h.cp("extractPkgCertMd5s(), CertificateEncodingException: " + paramString);
              }
            }
          }
        }
      }
      return localArrayList;
    }
    catch (Throwable paramContext)
    {
      h.cp("extractPkgCertMd5s(), Exception: " + paramContext);
    }
  }
  
  public static com.tencent.d.a.a bM(Context paramContext, String paramString)
  {
    com.tencent.d.a.a locala = new com.tencent.d.a.a();
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      locala.bwQ = paramString;
      locala.versionName = paramContext.versionName;
      locala.versionCode = paramContext.versionCode;
      paramContext = (X509Certificate)a(CertificateFactory.getInstance("X.509"), paramContext.signatures[0]);
      if (paramContext != null) {
        locala.wLm = e.bytesToHexString(e.bQ(paramContext.getEncoded()));
      }
      return locala;
    }
    catch (Throwable paramContext) {}
    return locala;
  }
  
  public static List<com.tencent.d.a.a> hz(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        String str = paramContext.getPackageName();
        PackageManager localPackageManager = paramContext.getPackageManager();
        Iterator localIterator = localPackageManager.getInstalledApplications(0).iterator();
        if (!localIterator.hasNext()) {
          break label225;
        }
        localApplicationInfo = (ApplicationInfo)localIterator.next();
        if ((localApplicationInfo.packageName == null) || (localApplicationInfo.packageName.equals(str))) {
          continue;
        }
        if ((localApplicationInfo.flags & 0x1) == 0) {
          break label227;
        }
        i = 1;
        locala = bM(paramContext, localApplicationInfo.packageName);
        locala.wLl = localPackageManager.getApplicationLabel(localApplicationInfo).toString();
        if (locala.wLl != null) {
          break label237;
        }
        locala.wLl = "";
      }
      catch (Throwable paramContext)
      {
        ApplicationInfo localApplicationInfo;
        com.tencent.d.a.a locala;
        h.co("getAllAppInfos(), exception: " + paramContext);
      }
      locala.dlO = i;
      locala.fileSize = new File(localApplicationInfo.sourceDir).length();
      locala.wLn = localApplicationInfo.sourceDir;
      localArrayList.add(locala);
      h.cq("add app: " + localApplicationInfo.packageName);
      continue;
      label225:
      return localArrayList;
      label227:
      int i = 0;
      continue;
      label237:
      do
      {
        i = 0;
        break;
      } while (i == 0);
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.d.f.a
 * JD-Core Version:    0.7.0.1
 */