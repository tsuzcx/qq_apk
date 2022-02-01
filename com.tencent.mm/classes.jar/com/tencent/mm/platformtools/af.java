package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class af
{
  public static boolean a(Context paramContext, ArrayList<c> paramArrayList, boolean paramBoolean)
  {
    AppMethodBeat.i(20754);
    if (paramArrayList.size() == 0)
    {
      AppMethodBeat.o(20754);
      return false;
    }
    Iterator localIterator = paramArrayList.iterator();
    c localc;
    Object localObject2;
    Object localObject1;
    Object localObject3;
    int i;
    label127:
    do
    {
      while (!((Iterator)localObject1).hasNext())
      {
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localc = (c)localIterator.next();
          } while (TextUtils.isEmpty(localc.pkgName));
          localObject2 = localc.pkgName;
          localObject1 = new ArrayList();
          localObject3 = paramContext.getPackageResourcePath();
          if (Build.VERSION.SDK_INT < 21) {
            break label599;
          }
          paramArrayList = ((String)localObject3).split("/");
          if (paramArrayList != null)
          {
            i = 0;
            if (i >= paramArrayList.length) {
              break label823;
            }
            if (!paramArrayList[i].contains(paramContext.getPackageName())) {
              break;
            }
            paramArrayList = paramArrayList[i];
            if (!TextUtils.isEmpty(paramArrayList))
            {
              String str = ((String)localObject3).replace(paramArrayList, (String)localObject2 + "-1");
              if (new q(str).ifE()) {
                ((List)localObject1).add(str);
              }
              paramArrayList = ((String)localObject3).replace(paramArrayList, (String)localObject2 + "-2");
              if (new q(paramArrayList).ifE()) {
                ((List)localObject1).add(paramArrayList);
              }
            }
          }
        } while (((List)localObject1).size() <= 0);
        localObject1 = ((List)localObject1).iterator();
      }
      localObject2 = new q((String)((Iterator)localObject1).next());
    } while (!((q)localObject2).ifE());
    label237:
    paramArrayList = "";
    for (;;)
    {
      try
      {
        label256:
        long l = System.currentTimeMillis();
        if (paramBoolean)
        {
          localObject2 = paramContext.getPackageManager().getPackageInfo(localc.pkgName, 64);
          if (((PackageInfo)localObject2).signatures.length <= 0) {
            break label829;
          }
          paramArrayList = MD5Util.getMD5String(localObject2.signatures[(localObject2.signatures.length - 1)].toCharsString());
          break label829;
          localObject2 = localc.pkgName;
          localObject3 = localc.mHb;
          if ((TextUtils.isEmpty(paramArrayList)) || (!paramArrayList.equalsIgnoreCase(localc.mHb))) {
            break label832;
          }
          bool = true;
          Log.i("MicroMsg.YYBMarketVerify", "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infoMD5[%s], sigMD5[%s], equal[%b], takes[%d]ms", new Object[] { Boolean.valueOf(paramBoolean), localObject2, localObject3, paramArrayList, Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
          if ((TextUtils.isEmpty(paramArrayList)) || (!paramArrayList.equalsIgnoreCase(localc.mHb))) {
            break label256;
          }
          l = System.currentTimeMillis();
          if (!paramBoolean) {
            continue;
          }
          i = paramContext.getPackageManager().getPackageInfo(localc.pkgName, 0).versionCode;
          paramArrayList = localc.pkgName;
          int j = localc.mHa;
          if (i > localc.mHa) {
            continue;
          }
          bool = true;
          Log.i("MicroMsg.YYBMarketVerify", "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infovc[%d], versionCode[%d], less[%b], takes[%d]ms", new Object[] { Boolean.valueOf(paramBoolean), paramArrayList, Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
          j = localc.mHa;
          if (i > j) {
            break label256;
          }
          AppMethodBeat.o(20754);
          return true;
          i += 1;
          break;
          label599:
          paramArrayList = ((String)localObject3).split("/");
          if (paramArrayList == null) {
            break label237;
          }
          localObject3 = new StringBuilder();
          i = 0;
          if (i < paramArrayList.length)
          {
            if (i != paramArrayList.length - 1)
            {
              ((StringBuilder)localObject3).append(paramArrayList[i]);
              ((StringBuilder)localObject3).append("/");
            }
            i += 1;
            continue;
          }
          paramArrayList = ((StringBuilder)localObject3).toString();
          localObject3 = paramArrayList + (String)localObject2 + "-1.apk";
          if (new q((String)localObject3).ifE()) {
            ((List)localObject1).add(localObject3);
          }
          paramArrayList = paramArrayList + (String)localObject2 + "-2.apk";
          if (!new q(paramArrayList).ifE()) {
            break label237;
          }
          ((List)localObject1).add(paramArrayList);
          break label237;
        }
        paramArrayList = b.m(((q)localObject2).ifG());
        continue;
        i = af.a.S(paramContext, localc.pkgName);
        continue;
        bool = false;
        continue;
      }
      catch (Exception paramArrayList)
      {
        Log.printErrStackTrace("MicroMsg.YYBMarketVerify", paramArrayList, "", new Object[0]);
      }
      AppMethodBeat.o(20754);
      return false;
      label823:
      paramArrayList = "";
      break label127;
      label829:
      continue;
      label832:
      boolean bool = false;
    }
  }
  
  public static final class b
  {
    private static char[] aO(byte[] paramArrayOfByte)
    {
      int k = paramArrayOfByte.length;
      char[] arrayOfChar = new char[k * 2];
      int i = 0;
      if (i < k)
      {
        int m = paramArrayOfByte[i];
        int j = m >> 4 & 0xF;
        if (j >= 10)
        {
          j = j + 97 - 10;
          label44:
          arrayOfChar[(i * 2)] = ((char)j);
          j = m & 0xF;
          if (j < 10) {
            break label97;
          }
          j = j + 97 - 10;
        }
        for (;;)
        {
          arrayOfChar[(i * 2 + 1)] = ((char)j);
          i += 1;
          break;
          j += 48;
          break label44;
          label97:
          j += 48;
        }
      }
      return arrayOfChar;
    }
    
    /* Error */
    public static String m(q paramq)
    {
      // Byte code:
      //   0: ldc 17
      //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 25	java/util/jar/JarFile
      //   8: dup
      //   9: aload_0
      //   10: invokevirtual 31	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
      //   13: invokespecial 35	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
      //   16: astore 6
      //   18: sipush 8192
      //   21: newarray byte
      //   23: astore 9
      //   25: aload 6
      //   27: invokevirtual 39	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
      //   30: astore 10
      //   32: aconst_null
      //   33: astore 5
      //   35: aconst_null
      //   36: astore_0
      //   37: aload_0
      //   38: astore 4
      //   40: aload_0
      //   41: astore_3
      //   42: aload 10
      //   44: invokeinterface 45 1 0
      //   49: ifeq +620 -> 669
      //   52: aload_0
      //   53: astore 4
      //   55: aload_0
      //   56: astore_3
      //   57: aload 10
      //   59: invokeinterface 49 1 0
      //   64: checkcast 51	java/util/jar/JarEntry
      //   67: astore 7
      //   69: aload_0
      //   70: astore 4
      //   72: aload_0
      //   73: astore_3
      //   74: aload 7
      //   76: invokevirtual 54	java/util/jar/JarEntry:isDirectory	()Z
      //   79: ifne -42 -> 37
      //   82: aload_0
      //   83: astore 4
      //   85: aload_0
      //   86: astore_3
      //   87: aload 7
      //   89: invokevirtual 57	java/util/jar/JarEntry:getName	()Ljava/lang/String;
      //   92: ldc 59
      //   94: invokevirtual 65	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   97: ifne -60 -> 37
      //   100: aload_0
      //   101: astore 4
      //   103: aload_0
      //   104: astore_3
      //   105: aload 7
      //   107: invokevirtual 57	java/util/jar/JarEntry:getName	()Ljava/lang/String;
      //   110: astore 8
      //   112: aload_0
      //   113: astore 4
      //   115: aload_0
      //   116: astore_3
      //   117: ldc 67
      //   119: aload 8
      //   121: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   124: ifne -87 -> 37
      //   127: aload_0
      //   128: astore 4
      //   130: aload_0
      //   131: astore_3
      //   132: ldc 73
      //   134: aload 8
      //   136: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   139: ifne -102 -> 37
      //   142: aload_0
      //   143: astore 4
      //   145: aload_0
      //   146: astore_3
      //   147: aload 7
      //   149: invokevirtual 77	java/util/jar/JarEntry:getSize	()J
      //   152: ldc2_w 78
      //   155: lcmp
      //   156: ifgt -119 -> 37
      //   159: aload_0
      //   160: astore 4
      //   162: aload_0
      //   163: astore_3
      //   164: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   167: lstore_1
      //   168: aload_0
      //   169: astore 4
      //   171: aload_0
      //   172: astore_3
      //   173: ldc 86
      //   175: ldc 88
      //   177: aload 8
      //   179: invokestatic 92	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   182: invokevirtual 96	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   185: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   188: aload_0
      //   189: astore 4
      //   191: aload_0
      //   192: astore_3
      //   193: aload 6
      //   195: aload 7
      //   197: invokevirtual 106	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
      //   200: astore_0
      //   201: aload_0
      //   202: astore 4
      //   204: aload_0
      //   205: astore_3
      //   206: ldc 86
      //   208: new 108	java/lang/StringBuilder
      //   211: dup
      //   212: ldc 110
      //   214: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   217: invokestatic 84	java/lang/System:currentTimeMillis	()J
      //   220: lload_1
      //   221: lsub
      //   222: invokevirtual 115	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   225: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   228: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   231: aload_0
      //   232: ifnull +31 -> 263
      //   235: aload_0
      //   236: astore 4
      //   238: aload_0
      //   239: astore_3
      //   240: aload_0
      //   241: aload 9
      //   243: iconst_0
      //   244: sipush 8192
      //   247: invokevirtual 124	java/io/InputStream:read	([BII)I
      //   250: iconst_m1
      //   251: if_icmpne -16 -> 235
      //   254: aload_0
      //   255: astore 4
      //   257: aload_0
      //   258: astore_3
      //   259: aload_0
      //   260: invokevirtual 128	java/io/InputStream:close	()V
      //   263: aload_0
      //   264: astore 4
      //   266: aload_0
      //   267: astore_3
      //   268: aload 7
      //   270: invokevirtual 132	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
      //   273: astore 8
      //   275: aload 8
      //   277: ifnull +14 -> 291
      //   280: aload_0
      //   281: astore 4
      //   283: aload_0
      //   284: astore_3
      //   285: aload 8
      //   287: arraylength
      //   288: ifne +114 -> 402
      //   291: aload_0
      //   292: astore 4
      //   294: aload_0
      //   295: astore_3
      //   296: new 134	java/lang/SecurityException
      //   299: dup
      //   300: new 108	java/lang/StringBuilder
      //   303: dup
      //   304: ldc 136
      //   306: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   309: aload 7
      //   311: invokevirtual 57	java/util/jar/JarEntry:getName	()Ljava/lang/String;
      //   314: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   317: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   320: invokespecial 140	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
      //   323: astore 5
      //   325: aload_0
      //   326: astore 4
      //   328: aload_0
      //   329: astore_3
      //   330: ldc 17
      //   332: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   335: aload_0
      //   336: astore 4
      //   338: aload_0
      //   339: astore_3
      //   340: aload 5
      //   342: athrow
      //   343: astore_3
      //   344: aload 4
      //   346: astore_0
      //   347: aload 6
      //   349: astore 4
      //   351: ldc 145
      //   353: aload_3
      //   354: ldc 147
      //   356: iconst_0
      //   357: anewarray 4	java/lang/Object
      //   360: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   363: ldc 17
      //   365: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   368: aload_3
      //   369: athrow
      //   370: astore 5
      //   372: aload_0
      //   373: astore_3
      //   374: aload 5
      //   376: astore_0
      //   377: aload_3
      //   378: ifnull +7 -> 385
      //   381: aload_3
      //   382: invokevirtual 128	java/io/InputStream:close	()V
      //   385: aload 4
      //   387: ifnull +8 -> 395
      //   390: aload 4
      //   392: invokevirtual 152	java/util/jar/JarFile:close	()V
      //   395: ldc 17
      //   397: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   400: aload_0
      //   401: athrow
      //   402: aload 5
      //   404: ifnonnull +256 -> 660
      //   407: aload_0
      //   408: astore 4
      //   410: aload_0
      //   411: astore_3
      //   412: aload 8
      //   414: iconst_0
      //   415: aaload
      //   416: checkcast 154	java/security/cert/X509Certificate
      //   419: astore 8
      //   421: aload 8
      //   423: astore 7
      //   425: aload_0
      //   426: astore 5
      //   428: aload 8
      //   430: ifnonnull +9 -> 439
      //   433: aload 8
      //   435: astore_3
      //   436: goto +227 -> 663
      //   439: aload 7
      //   441: ifnull +86 -> 527
      //   444: aload 5
      //   446: astore 4
      //   448: aload 5
      //   450: astore_3
      //   451: new 61	java/lang/String
      //   454: dup
      //   455: aload 7
      //   457: invokevirtual 158	java/security/cert/X509Certificate:getEncoded	()[B
      //   460: invokestatic 160	com/tencent/mm/platformtools/af$b:aO	([B)[C
      //   463: invokespecial 163	java/lang/String:<init>	([C)V
      //   466: invokevirtual 166	java/lang/String:getBytes	()[B
      //   469: invokestatic 172	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	([B)Ljava/lang/String;
      //   472: astore_0
      //   473: aload 5
      //   475: ifnull +8 -> 483
      //   478: aload 5
      //   480: invokevirtual 128	java/io/InputStream:close	()V
      //   483: aload 6
      //   485: invokevirtual 152	java/util/jar/JarFile:close	()V
      //   488: ldc 17
      //   490: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   493: aload_0
      //   494: areturn
      //   495: astore_3
      //   496: ldc 145
      //   498: aload_3
      //   499: ldc 147
      //   501: iconst_0
      //   502: anewarray 4	java/lang/Object
      //   505: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   508: goto -25 -> 483
      //   511: astore_3
      //   512: ldc 145
      //   514: aload_3
      //   515: ldc 147
      //   517: iconst_0
      //   518: anewarray 4	java/lang/Object
      //   521: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   524: goto -36 -> 488
      //   527: aload 5
      //   529: ifnull +8 -> 537
      //   532: aload 5
      //   534: invokevirtual 128	java/io/InputStream:close	()V
      //   537: aload 6
      //   539: invokevirtual 152	java/util/jar/JarFile:close	()V
      //   542: ldc 17
      //   544: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   547: ldc 147
      //   549: areturn
      //   550: astore_0
      //   551: ldc 145
      //   553: aload_0
      //   554: ldc 147
      //   556: iconst_0
      //   557: anewarray 4	java/lang/Object
      //   560: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   563: goto -26 -> 537
      //   566: astore_0
      //   567: ldc 145
      //   569: aload_0
      //   570: ldc 147
      //   572: iconst_0
      //   573: anewarray 4	java/lang/Object
      //   576: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   579: goto -37 -> 542
      //   582: astore_3
      //   583: ldc 145
      //   585: aload_3
      //   586: ldc 147
      //   588: iconst_0
      //   589: anewarray 4	java/lang/Object
      //   592: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   595: goto -210 -> 385
      //   598: astore_3
      //   599: ldc 145
      //   601: aload_3
      //   602: ldc 147
      //   604: iconst_0
      //   605: anewarray 4	java/lang/Object
      //   608: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   611: goto -216 -> 395
      //   614: astore_0
      //   615: aconst_null
      //   616: astore_3
      //   617: aconst_null
      //   618: astore 4
      //   620: goto -243 -> 377
      //   623: astore_0
      //   624: aconst_null
      //   625: astore_3
      //   626: aload 6
      //   628: astore 4
      //   630: goto -253 -> 377
      //   633: astore_0
      //   634: aload 6
      //   636: astore 4
      //   638: goto -261 -> 377
      //   641: astore_3
      //   642: aconst_null
      //   643: astore_0
      //   644: aconst_null
      //   645: astore 4
      //   647: goto -296 -> 351
      //   650: astore_3
      //   651: aconst_null
      //   652: astore_0
      //   653: aload 6
      //   655: astore 4
      //   657: goto -306 -> 351
      //   660: aload 5
      //   662: astore_3
      //   663: aload_3
      //   664: astore 5
      //   666: goto -629 -> 37
      //   669: aload 5
      //   671: astore 7
      //   673: aload_0
      //   674: astore 5
      //   676: goto -237 -> 439
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	679	0	paramq	q
      //   167	54	1	l	long
      //   41	299	3	localq	q
      //   343	26	3	localException1	Exception
      //   373	78	3	localObject1	Object
      //   495	4	3	localIOException1	java.io.IOException
      //   511	4	3	localIOException2	java.io.IOException
      //   582	4	3	localIOException3	java.io.IOException
      //   598	4	3	localIOException4	java.io.IOException
      //   616	10	3	localObject2	Object
      //   641	1	3	localException2	Exception
      //   650	1	3	localException3	Exception
      //   662	2	3	localObject3	Object
      //   38	618	4	localObject4	Object
      //   33	308	5	localSecurityException	java.lang.SecurityException
      //   370	33	5	localObject5	Object
      //   426	249	5	localObject6	Object
      //   16	638	6	localJarFile	java.util.jar.JarFile
      //   67	605	7	localObject7	Object
      //   110	324	8	localObject8	Object
      //   23	219	9	arrayOfByte	byte[]
      //   30	28	10	localEnumeration	java.util.Enumeration
      // Exception table:
      //   from	to	target	type
      //   42	52	343	java/lang/Exception
      //   57	69	343	java/lang/Exception
      //   74	82	343	java/lang/Exception
      //   87	100	343	java/lang/Exception
      //   105	112	343	java/lang/Exception
      //   117	127	343	java/lang/Exception
      //   132	142	343	java/lang/Exception
      //   147	159	343	java/lang/Exception
      //   164	168	343	java/lang/Exception
      //   173	188	343	java/lang/Exception
      //   193	201	343	java/lang/Exception
      //   206	231	343	java/lang/Exception
      //   240	254	343	java/lang/Exception
      //   259	263	343	java/lang/Exception
      //   268	275	343	java/lang/Exception
      //   285	291	343	java/lang/Exception
      //   296	325	343	java/lang/Exception
      //   330	335	343	java/lang/Exception
      //   340	343	343	java/lang/Exception
      //   412	421	343	java/lang/Exception
      //   451	473	343	java/lang/Exception
      //   351	370	370	finally
      //   478	483	495	java/io/IOException
      //   483	488	511	java/io/IOException
      //   532	537	550	java/io/IOException
      //   537	542	566	java/io/IOException
      //   381	385	582	java/io/IOException
      //   390	395	598	java/io/IOException
      //   5	18	614	finally
      //   18	32	623	finally
      //   42	52	633	finally
      //   57	69	633	finally
      //   74	82	633	finally
      //   87	100	633	finally
      //   105	112	633	finally
      //   117	127	633	finally
      //   132	142	633	finally
      //   147	159	633	finally
      //   164	168	633	finally
      //   173	188	633	finally
      //   193	201	633	finally
      //   206	231	633	finally
      //   240	254	633	finally
      //   259	263	633	finally
      //   268	275	633	finally
      //   285	291	633	finally
      //   296	325	633	finally
      //   330	335	633	finally
      //   340	343	633	finally
      //   412	421	633	finally
      //   451	473	633	finally
      //   5	18	641	java/lang/Exception
      //   18	32	650	java/lang/Exception
    }
  }
  
  public static final class c
  {
    public final int mHa;
    public final String mHb;
    public final String pkgName;
    
    public c(String paramString1, int paramInt, String paramString2)
    {
      this.pkgName = paramString1;
      this.mHa = paramInt;
      this.mHb = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.af
 * JD-Core Version:    0.7.0.1
 */