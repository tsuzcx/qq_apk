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
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ac
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
              if (new u(str).jKS()) {
                ((List)localObject1).add(str);
              }
              paramArrayList = ((String)localObject3).replace(paramArrayList, (String)localObject2 + "-2");
              if (new u(paramArrayList).jKS()) {
                ((List)localObject1).add(paramArrayList);
              }
            }
          }
        } while (((List)localObject1).size() <= 0);
        localObject1 = ((List)localObject1).iterator();
      }
      localObject2 = new u((String)((Iterator)localObject1).next());
    } while (!((u)localObject2).jKS());
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
          localObject3 = localc.pDC;
          if ((TextUtils.isEmpty(paramArrayList)) || (!paramArrayList.equalsIgnoreCase(localc.pDC))) {
            break label832;
          }
          bool = true;
          Log.i("MicroMsg.YYBMarketVerify", "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infoMD5[%s], sigMD5[%s], equal[%b], takes[%d]ms", new Object[] { Boolean.valueOf(paramBoolean), localObject2, localObject3, paramArrayList, Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
          if ((TextUtils.isEmpty(paramArrayList)) || (!paramArrayList.equalsIgnoreCase(localc.pDC))) {
            break label256;
          }
          l = System.currentTimeMillis();
          if (!paramBoolean) {
            continue;
          }
          i = paramContext.getPackageManager().getPackageInfo(localc.pkgName, 0).versionCode;
          paramArrayList = localc.pkgName;
          int j = localc.pDB;
          if (i > localc.pDB) {
            continue;
          }
          bool = true;
          Log.i("MicroMsg.YYBMarketVerify", "summertoken containLowerMarket usesSystemApi[%b], infopkg[%s], infovc[%d], versionCode[%d], less[%b], takes[%d]ms", new Object[] { Boolean.valueOf(paramBoolean), paramArrayList, Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(bool), Long.valueOf(System.currentTimeMillis() - l) });
          j = localc.pDB;
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
          if (new u((String)localObject3).jKS()) {
            ((List)localObject1).add(localObject3);
          }
          paramArrayList = paramArrayList + (String)localObject2 + "-2.apk";
          if (!new u(paramArrayList).jKS()) {
            break label237;
          }
          ((List)localObject1).add(paramArrayList);
          break label237;
        }
        paramArrayList = b.m(((u)localObject2).jKU());
        continue;
        i = ac.a.S(paramContext, localc.pkgName);
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
    public static String m(u paramu)
    {
      // Byte code:
      //   0: ldc 17
      //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 25	java/util/jar/JarFile
      //   8: dup
      //   9: aload_0
      //   10: invokevirtual 31	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
      //   13: invokestatic 37	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
      //   16: invokespecial 41	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
      //   19: astore 6
      //   21: sipush 8192
      //   24: newarray byte
      //   26: astore 9
      //   28: aload 6
      //   30: invokevirtual 45	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
      //   33: astore 10
      //   35: aconst_null
      //   36: astore 5
      //   38: aconst_null
      //   39: astore_0
      //   40: aload_0
      //   41: astore 4
      //   43: aload_0
      //   44: astore_3
      //   45: aload 10
      //   47: invokeinterface 51 1 0
      //   52: ifeq +620 -> 672
      //   55: aload_0
      //   56: astore 4
      //   58: aload_0
      //   59: astore_3
      //   60: aload 10
      //   62: invokeinterface 55 1 0
      //   67: checkcast 57	java/util/jar/JarEntry
      //   70: astore 7
      //   72: aload_0
      //   73: astore 4
      //   75: aload_0
      //   76: astore_3
      //   77: aload 7
      //   79: invokevirtual 60	java/util/jar/JarEntry:isDirectory	()Z
      //   82: ifne -42 -> 40
      //   85: aload_0
      //   86: astore 4
      //   88: aload_0
      //   89: astore_3
      //   90: aload 7
      //   92: invokevirtual 64	java/util/jar/JarEntry:getName	()Ljava/lang/String;
      //   95: ldc 66
      //   97: invokevirtual 72	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   100: ifne -60 -> 40
      //   103: aload_0
      //   104: astore 4
      //   106: aload_0
      //   107: astore_3
      //   108: aload 7
      //   110: invokevirtual 64	java/util/jar/JarEntry:getName	()Ljava/lang/String;
      //   113: astore 8
      //   115: aload_0
      //   116: astore 4
      //   118: aload_0
      //   119: astore_3
      //   120: ldc 74
      //   122: aload 8
      //   124: invokevirtual 78	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   127: ifne -87 -> 40
      //   130: aload_0
      //   131: astore 4
      //   133: aload_0
      //   134: astore_3
      //   135: ldc 80
      //   137: aload 8
      //   139: invokevirtual 78	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   142: ifne -102 -> 40
      //   145: aload_0
      //   146: astore 4
      //   148: aload_0
      //   149: astore_3
      //   150: aload 7
      //   152: invokevirtual 84	java/util/jar/JarEntry:getSize	()J
      //   155: ldc2_w 85
      //   158: lcmp
      //   159: ifgt -119 -> 40
      //   162: aload_0
      //   163: astore 4
      //   165: aload_0
      //   166: astore_3
      //   167: invokestatic 91	java/lang/System:currentTimeMillis	()J
      //   170: lstore_1
      //   171: aload_0
      //   172: astore 4
      //   174: aload_0
      //   175: astore_3
      //   176: ldc 93
      //   178: ldc 95
      //   180: aload 8
      //   182: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   185: invokevirtual 103	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   188: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   191: aload_0
      //   192: astore 4
      //   194: aload_0
      //   195: astore_3
      //   196: aload 6
      //   198: aload 7
      //   200: invokevirtual 113	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
      //   203: astore_0
      //   204: aload_0
      //   205: astore 4
      //   207: aload_0
      //   208: astore_3
      //   209: ldc 93
      //   211: new 115	java/lang/StringBuilder
      //   214: dup
      //   215: ldc 117
      //   217: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   220: invokestatic 91	java/lang/System:currentTimeMillis	()J
      //   223: lload_1
      //   224: lsub
      //   225: invokevirtual 122	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   228: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   231: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   234: aload_0
      //   235: ifnull +31 -> 266
      //   238: aload_0
      //   239: astore 4
      //   241: aload_0
      //   242: astore_3
      //   243: aload_0
      //   244: aload 9
      //   246: iconst_0
      //   247: sipush 8192
      //   250: invokevirtual 131	java/io/InputStream:read	([BII)I
      //   253: iconst_m1
      //   254: if_icmpne -16 -> 238
      //   257: aload_0
      //   258: astore 4
      //   260: aload_0
      //   261: astore_3
      //   262: aload_0
      //   263: invokevirtual 135	java/io/InputStream:close	()V
      //   266: aload_0
      //   267: astore 4
      //   269: aload_0
      //   270: astore_3
      //   271: aload 7
      //   273: invokevirtual 139	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
      //   276: astore 8
      //   278: aload 8
      //   280: ifnull +14 -> 294
      //   283: aload_0
      //   284: astore 4
      //   286: aload_0
      //   287: astore_3
      //   288: aload 8
      //   290: arraylength
      //   291: ifne +114 -> 405
      //   294: aload_0
      //   295: astore 4
      //   297: aload_0
      //   298: astore_3
      //   299: new 141	java/lang/SecurityException
      //   302: dup
      //   303: new 115	java/lang/StringBuilder
      //   306: dup
      //   307: ldc 143
      //   309: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   312: aload 7
      //   314: invokevirtual 64	java/util/jar/JarEntry:getName	()Ljava/lang/String;
      //   317: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   320: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   323: invokespecial 147	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
      //   326: astore 5
      //   328: aload_0
      //   329: astore 4
      //   331: aload_0
      //   332: astore_3
      //   333: ldc 17
      //   335: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   338: aload_0
      //   339: astore 4
      //   341: aload_0
      //   342: astore_3
      //   343: aload 5
      //   345: athrow
      //   346: astore_3
      //   347: aload 4
      //   349: astore_0
      //   350: aload 6
      //   352: astore 4
      //   354: ldc 152
      //   356: aload_3
      //   357: ldc 154
      //   359: iconst_0
      //   360: anewarray 4	java/lang/Object
      //   363: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   366: ldc 17
      //   368: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   371: aload_3
      //   372: athrow
      //   373: astore 5
      //   375: aload_0
      //   376: astore_3
      //   377: aload 5
      //   379: astore_0
      //   380: aload_3
      //   381: ifnull +7 -> 388
      //   384: aload_3
      //   385: invokevirtual 135	java/io/InputStream:close	()V
      //   388: aload 4
      //   390: ifnull +8 -> 398
      //   393: aload 4
      //   395: invokevirtual 159	java/util/jar/JarFile:close	()V
      //   398: ldc 17
      //   400: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   403: aload_0
      //   404: athrow
      //   405: aload 5
      //   407: ifnonnull +256 -> 663
      //   410: aload_0
      //   411: astore 4
      //   413: aload_0
      //   414: astore_3
      //   415: aload 8
      //   417: iconst_0
      //   418: aaload
      //   419: checkcast 161	java/security/cert/X509Certificate
      //   422: astore 8
      //   424: aload 8
      //   426: astore 7
      //   428: aload_0
      //   429: astore 5
      //   431: aload 8
      //   433: ifnonnull +9 -> 442
      //   436: aload 8
      //   438: astore_3
      //   439: goto +227 -> 666
      //   442: aload 7
      //   444: ifnull +86 -> 530
      //   447: aload 5
      //   449: astore 4
      //   451: aload 5
      //   453: astore_3
      //   454: new 68	java/lang/String
      //   457: dup
      //   458: aload 7
      //   460: invokevirtual 165	java/security/cert/X509Certificate:getEncoded	()[B
      //   463: invokestatic 167	com/tencent/mm/platformtools/ac$b:aO	([B)[C
      //   466: invokespecial 170	java/lang/String:<init>	([C)V
      //   469: invokevirtual 173	java/lang/String:getBytes	()[B
      //   472: invokestatic 179	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	([B)Ljava/lang/String;
      //   475: astore_0
      //   476: aload 5
      //   478: ifnull +8 -> 486
      //   481: aload 5
      //   483: invokevirtual 135	java/io/InputStream:close	()V
      //   486: aload 6
      //   488: invokevirtual 159	java/util/jar/JarFile:close	()V
      //   491: ldc 17
      //   493: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   496: aload_0
      //   497: areturn
      //   498: astore_3
      //   499: ldc 152
      //   501: aload_3
      //   502: ldc 154
      //   504: iconst_0
      //   505: anewarray 4	java/lang/Object
      //   508: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   511: goto -25 -> 486
      //   514: astore_3
      //   515: ldc 152
      //   517: aload_3
      //   518: ldc 154
      //   520: iconst_0
      //   521: anewarray 4	java/lang/Object
      //   524: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   527: goto -36 -> 491
      //   530: aload 5
      //   532: ifnull +8 -> 540
      //   535: aload 5
      //   537: invokevirtual 135	java/io/InputStream:close	()V
      //   540: aload 6
      //   542: invokevirtual 159	java/util/jar/JarFile:close	()V
      //   545: ldc 17
      //   547: invokestatic 150	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   550: ldc 154
      //   552: areturn
      //   553: astore_0
      //   554: ldc 152
      //   556: aload_0
      //   557: ldc 154
      //   559: iconst_0
      //   560: anewarray 4	java/lang/Object
      //   563: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   566: goto -26 -> 540
      //   569: astore_0
      //   570: ldc 152
      //   572: aload_0
      //   573: ldc 154
      //   575: iconst_0
      //   576: anewarray 4	java/lang/Object
      //   579: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   582: goto -37 -> 545
      //   585: astore_3
      //   586: ldc 152
      //   588: aload_3
      //   589: ldc 154
      //   591: iconst_0
      //   592: anewarray 4	java/lang/Object
      //   595: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   598: goto -210 -> 388
      //   601: astore_3
      //   602: ldc 152
      //   604: aload_3
      //   605: ldc 154
      //   607: iconst_0
      //   608: anewarray 4	java/lang/Object
      //   611: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   614: goto -216 -> 398
      //   617: astore_0
      //   618: aconst_null
      //   619: astore_3
      //   620: aconst_null
      //   621: astore 4
      //   623: goto -243 -> 380
      //   626: astore_0
      //   627: aconst_null
      //   628: astore_3
      //   629: aload 6
      //   631: astore 4
      //   633: goto -253 -> 380
      //   636: astore_0
      //   637: aload 6
      //   639: astore 4
      //   641: goto -261 -> 380
      //   644: astore_3
      //   645: aconst_null
      //   646: astore_0
      //   647: aconst_null
      //   648: astore 4
      //   650: goto -296 -> 354
      //   653: astore_3
      //   654: aconst_null
      //   655: astore_0
      //   656: aload 6
      //   658: astore 4
      //   660: goto -306 -> 354
      //   663: aload 5
      //   665: astore_3
      //   666: aload_3
      //   667: astore 5
      //   669: goto -629 -> 40
      //   672: aload 5
      //   674: astore 7
      //   676: aload_0
      //   677: astore 5
      //   679: goto -237 -> 442
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	682	0	paramu	u
      //   170	54	1	l	long
      //   44	299	3	localu	u
      //   346	26	3	localException1	Exception
      //   376	78	3	localObject1	Object
      //   498	4	3	localIOException1	java.io.IOException
      //   514	4	3	localIOException2	java.io.IOException
      //   585	4	3	localIOException3	java.io.IOException
      //   601	4	3	localIOException4	java.io.IOException
      //   619	10	3	localObject2	Object
      //   644	1	3	localException2	Exception
      //   653	1	3	localException3	Exception
      //   665	2	3	localObject3	Object
      //   41	618	4	localObject4	Object
      //   36	308	5	localSecurityException	java.lang.SecurityException
      //   373	33	5	localObject5	Object
      //   429	249	5	localObject6	Object
      //   19	638	6	localJarFile	java.util.jar.JarFile
      //   70	605	7	localObject7	Object
      //   113	324	8	localObject8	Object
      //   26	219	9	arrayOfByte	byte[]
      //   33	28	10	localEnumeration	java.util.Enumeration
      // Exception table:
      //   from	to	target	type
      //   45	55	346	java/lang/Exception
      //   60	72	346	java/lang/Exception
      //   77	85	346	java/lang/Exception
      //   90	103	346	java/lang/Exception
      //   108	115	346	java/lang/Exception
      //   120	130	346	java/lang/Exception
      //   135	145	346	java/lang/Exception
      //   150	162	346	java/lang/Exception
      //   167	171	346	java/lang/Exception
      //   176	191	346	java/lang/Exception
      //   196	204	346	java/lang/Exception
      //   209	234	346	java/lang/Exception
      //   243	257	346	java/lang/Exception
      //   262	266	346	java/lang/Exception
      //   271	278	346	java/lang/Exception
      //   288	294	346	java/lang/Exception
      //   299	328	346	java/lang/Exception
      //   333	338	346	java/lang/Exception
      //   343	346	346	java/lang/Exception
      //   415	424	346	java/lang/Exception
      //   454	476	346	java/lang/Exception
      //   354	373	373	finally
      //   481	486	498	java/io/IOException
      //   486	491	514	java/io/IOException
      //   535	540	553	java/io/IOException
      //   540	545	569	java/io/IOException
      //   384	388	585	java/io/IOException
      //   393	398	601	java/io/IOException
      //   5	21	617	finally
      //   21	35	626	finally
      //   45	55	636	finally
      //   60	72	636	finally
      //   77	85	636	finally
      //   90	103	636	finally
      //   108	115	636	finally
      //   120	130	636	finally
      //   135	145	636	finally
      //   150	162	636	finally
      //   167	171	636	finally
      //   176	191	636	finally
      //   196	204	636	finally
      //   209	234	636	finally
      //   243	257	636	finally
      //   262	266	636	finally
      //   271	278	636	finally
      //   288	294	636	finally
      //   299	328	636	finally
      //   333	338	636	finally
      //   343	346	636	finally
      //   415	424	636	finally
      //   454	476	636	finally
      //   5	21	644	java/lang/Exception
      //   21	35	653	java/lang/Exception
    }
  }
  
  public static final class c
  {
    public final int pDB;
    public final String pDC;
    public final String pkgName;
    
    public c(String paramString1, int paramInt, String paramString2)
    {
      this.pkgName = paramString1;
      this.pDB = paramInt;
      this.pDC = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.ac
 * JD-Core Version:    0.7.0.1
 */