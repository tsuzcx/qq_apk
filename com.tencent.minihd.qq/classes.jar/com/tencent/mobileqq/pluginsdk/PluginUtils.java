package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PluginUtils
{
  public static final String CONFIG_FILE_EXTEND_NAME = ".cfg";
  private static final int a = 8192;
  private static Map b = new ConcurrentHashMap();
  private static Map c = new ConcurrentHashMap();
  private static final String d = ".tmp";
  
  private static File a(Context paramContext, String paramString)
  {
    File localFile = (File)b.get(paramString);
    Object localObject = localFile;
    if (localFile == null)
    {
      localObject = getPluginInstallDir(paramContext);
      if (localObject == null) {
        localObject = null;
      }
    }
    else
    {
      return localObject;
    }
    int i = paramString.lastIndexOf('.');
    if ((i != -1) && (!paramString.substring(i).equalsIgnoreCase(".apk"))) {
      paramContext = paramString.substring(0, i) + ".apk";
    }
    for (;;)
    {
      paramString = new File((File)localObject, paramContext);
      localObject = paramString;
      if (paramString == null) {
        break;
      }
      b.put(paramContext, paramString);
      return paramString;
      paramContext = paramString;
      if (i == -1) {
        paramContext = paramString + ".apk";
      }
    }
  }
  
  /* Error */
  public static String extractLibs(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_1
    //   7: astore 6
    //   9: aload_1
    //   10: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   13: invokevirtual 94	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   16: ifne +25 -> 41
    //   19: new 65	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   26: aload_1
    //   27: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   33: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 6
    //   41: new 96	java/util/zip/ZipFile
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 99	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   49: astore 5
    //   51: aload 5
    //   53: astore 4
    //   55: aload 5
    //   57: invokevirtual 103	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   60: astore 10
    //   62: aconst_null
    //   63: astore_1
    //   64: aload 5
    //   66: astore 4
    //   68: aload 10
    //   70: invokeinterface 109 1 0
    //   75: ifeq +232 -> 307
    //   78: aload 5
    //   80: astore 4
    //   82: aload 10
    //   84: invokeinterface 113 1 0
    //   89: checkcast 115	java/util/zip/ZipEntry
    //   92: invokevirtual 118	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: astore_3
    //   96: aload 5
    //   98: astore 4
    //   100: aload_3
    //   101: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   104: invokevirtual 94	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   107: ifne -43 -> 64
    //   110: aload 5
    //   112: astore 4
    //   114: new 43	java/io/File
    //   117: dup
    //   118: new 65	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   125: aload 6
    //   127: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   140: astore 7
    //   142: aload_1
    //   143: astore_3
    //   144: aload 7
    //   146: ifnull +730 -> 876
    //   149: aload 5
    //   151: astore 4
    //   153: aload 7
    //   155: invokevirtual 120	java/io/File:getName	()Ljava/lang/String;
    //   158: getstatic 125	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   161: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   164: ifeq +14 -> 178
    //   167: aload 5
    //   169: astore 4
    //   171: getstatic 125	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   174: astore_3
    //   175: goto +701 -> 876
    //   178: aload 5
    //   180: astore 4
    //   182: getstatic 134	android/os/Build$VERSION:SDK_INT	I
    //   185: bipush 7
    //   187: if_icmple +38 -> 225
    //   190: aload 5
    //   192: astore 4
    //   194: aload 7
    //   196: invokevirtual 120	java/io/File:getName	()Ljava/lang/String;
    //   199: getstatic 137	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   202: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq +20 -> 225
    //   208: aload_1
    //   209: ifnonnull +16 -> 225
    //   212: aload 5
    //   214: astore 4
    //   216: getstatic 137	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   219: astore_3
    //   220: aload_3
    //   221: astore_1
    //   222: goto -80 -> 142
    //   225: aload 5
    //   227: astore 4
    //   229: getstatic 125	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   232: ldc 139
    //   234: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   237: ifeq +56 -> 293
    //   240: aload_1
    //   241: ifnonnull +52 -> 293
    //   244: aload 5
    //   246: astore 4
    //   248: aload 7
    //   250: invokevirtual 120	java/io/File:getName	()Ljava/lang/String;
    //   253: ldc 141
    //   255: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifne +20 -> 278
    //   261: aload 5
    //   263: astore 4
    //   265: aload 7
    //   267: invokevirtual 120	java/io/File:getName	()Ljava/lang/String;
    //   270: ldc 143
    //   272: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   275: ifeq +18 -> 293
    //   278: aload 5
    //   280: astore 4
    //   282: aload 7
    //   284: invokevirtual 120	java/io/File:getName	()Ljava/lang/String;
    //   287: astore_3
    //   288: aload_3
    //   289: astore_1
    //   290: goto -148 -> 142
    //   293: aload 5
    //   295: astore 4
    //   297: aload 7
    //   299: invokevirtual 147	java/io/File:getParentFile	()Ljava/io/File;
    //   302: astore 7
    //   304: goto -162 -> 142
    //   307: aload 5
    //   309: invokestatic 153	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   312: aconst_null
    //   313: astore_3
    //   314: aload_1
    //   315: astore 5
    //   317: aload_3
    //   318: astore_1
    //   319: aload 9
    //   321: astore 4
    //   323: aload_3
    //   324: ifnonnull +319 -> 643
    //   327: aload_3
    //   328: astore_1
    //   329: aload 9
    //   331: astore 4
    //   333: aload 5
    //   335: ifnull +308 -> 643
    //   338: new 96	java/util/zip/ZipFile
    //   341: dup
    //   342: aload_0
    //   343: invokespecial 99	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   346: astore_1
    //   347: aload_1
    //   348: astore 4
    //   350: sipush 4096
    //   353: newarray byte
    //   355: astore 10
    //   357: aload_1
    //   358: astore 4
    //   360: aload_1
    //   361: invokevirtual 103	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   364: astore 11
    //   366: aload_3
    //   367: astore_0
    //   368: aload_1
    //   369: astore 4
    //   371: aload 11
    //   373: invokeinterface 109 1 0
    //   378: ifeq +490 -> 868
    //   381: aload_1
    //   382: astore 4
    //   384: aload 11
    //   386: invokeinterface 113 1 0
    //   391: checkcast 115	java/util/zip/ZipEntry
    //   394: astore 12
    //   396: aload_1
    //   397: astore 4
    //   399: aload 12
    //   401: invokevirtual 118	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   404: astore 9
    //   406: aload_1
    //   407: astore 4
    //   409: aload 9
    //   411: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   414: invokevirtual 94	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   417: ifne -49 -> 368
    //   420: aload_1
    //   421: astore 4
    //   423: new 43	java/io/File
    //   426: dup
    //   427: new 65	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   434: aload 6
    //   436: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 9
    //   441: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   450: astore 7
    //   452: aload_1
    //   453: astore 4
    //   455: aload 9
    //   457: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   460: invokevirtual 156	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   463: istore_2
    //   464: aload 9
    //   466: astore_3
    //   467: iload_2
    //   468: iconst_m1
    //   469: if_icmpeq +15 -> 484
    //   472: aload_1
    //   473: astore 4
    //   475: aload 9
    //   477: iload_2
    //   478: iconst_1
    //   479: iadd
    //   480: invokevirtual 57	java/lang/String:substring	(I)Ljava/lang/String;
    //   483: astore_3
    //   484: aload_1
    //   485: astore 4
    //   487: new 43	java/io/File
    //   490: dup
    //   491: new 65	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   498: aload 6
    //   500: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_3
    //   504: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   513: astore 9
    //   515: aload 7
    //   517: astore_3
    //   518: aload_3
    //   519: ifnull +344 -> 863
    //   522: aload_1
    //   523: astore 4
    //   525: aload_3
    //   526: invokevirtual 120	java/io/File:getName	()Ljava/lang/String;
    //   529: aload 5
    //   531: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   534: ifeq +161 -> 695
    //   537: iconst_1
    //   538: istore_2
    //   539: iload_2
    //   540: ifeq +226 -> 766
    //   543: aload_1
    //   544: astore 4
    //   546: aload 9
    //   548: invokevirtual 147	java/io/File:getParentFile	()Ljava/io/File;
    //   551: invokevirtual 159	java/io/File:mkdirs	()Z
    //   554: pop
    //   555: aload_1
    //   556: aload 12
    //   558: invokevirtual 163	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   561: astore_3
    //   562: new 165	java/io/FileOutputStream
    //   565: dup
    //   566: aload 9
    //   568: invokespecial 168	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   571: astore 7
    //   573: aload_3
    //   574: aload 10
    //   576: invokevirtual 174	java/io/InputStream:read	([B)I
    //   579: istore_2
    //   580: iload_2
    //   581: ifle +125 -> 706
    //   584: aload 7
    //   586: aload 10
    //   588: iconst_0
    //   589: iload_2
    //   590: invokevirtual 178	java/io/FileOutputStream:write	([BII)V
    //   593: goto -20 -> 573
    //   596: astore 4
    //   598: aload_3
    //   599: astore_0
    //   600: aload 7
    //   602: astore_3
    //   603: aload 4
    //   605: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   608: aload 4
    //   610: invokestatic 185	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   613: astore 7
    //   615: aload_1
    //   616: astore 4
    //   618: aload_3
    //   619: invokestatic 189	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   622: aload_1
    //   623: astore 4
    //   625: aload_0
    //   626: invokestatic 189	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   629: aload 7
    //   631: astore_0
    //   632: aload_0
    //   633: astore_3
    //   634: aload_0
    //   635: ifnull +133 -> 768
    //   638: aload_1
    //   639: astore 4
    //   641: aload_0
    //   642: astore_1
    //   643: aload 4
    //   645: invokestatic 153	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   648: aload_1
    //   649: areturn
    //   650: astore_3
    //   651: aconst_null
    //   652: astore 5
    //   654: aconst_null
    //   655: astore_1
    //   656: aload 5
    //   658: astore 4
    //   660: aload_3
    //   661: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   664: aload 5
    //   666: astore 4
    //   668: aload_3
    //   669: invokestatic 185	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   672: astore_3
    //   673: aload 5
    //   675: invokestatic 153	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   678: aload_1
    //   679: astore 5
    //   681: goto -364 -> 317
    //   684: astore_0
    //   685: aconst_null
    //   686: astore 4
    //   688: aload 4
    //   690: invokestatic 153	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   693: aload_0
    //   694: athrow
    //   695: aload_1
    //   696: astore 4
    //   698: aload_3
    //   699: invokevirtual 147	java/io/File:getParentFile	()Ljava/io/File;
    //   702: astore_3
    //   703: goto -185 -> 518
    //   706: aload_1
    //   707: astore 4
    //   709: aload 7
    //   711: invokestatic 189	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   714: aload_1
    //   715: astore 4
    //   717: aload_3
    //   718: invokestatic 189	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   721: goto -89 -> 632
    //   724: aload_1
    //   725: astore 4
    //   727: aload 5
    //   729: invokestatic 189	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   732: aload_1
    //   733: astore 4
    //   735: aload_3
    //   736: invokestatic 189	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   739: aload_1
    //   740: astore 4
    //   742: aload_0
    //   743: athrow
    //   744: astore_0
    //   745: aload_1
    //   746: astore 4
    //   748: aload_0
    //   749: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   752: aload_1
    //   753: astore 4
    //   755: aload_0
    //   756: invokestatic 185	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   759: astore_0
    //   760: aload_1
    //   761: invokestatic 153	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   764: aload_0
    //   765: areturn
    //   766: aload_0
    //   767: astore_3
    //   768: aload_3
    //   769: astore_0
    //   770: goto -402 -> 368
    //   773: astore_0
    //   774: aconst_null
    //   775: astore 4
    //   777: aload 4
    //   779: invokestatic 153	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   782: aload_0
    //   783: athrow
    //   784: astore_0
    //   785: goto -8 -> 777
    //   788: astore_0
    //   789: aconst_null
    //   790: astore_1
    //   791: goto -46 -> 745
    //   794: astore_0
    //   795: aload 8
    //   797: astore 5
    //   799: goto -75 -> 724
    //   802: astore_0
    //   803: aload 7
    //   805: astore 5
    //   807: goto -83 -> 724
    //   810: astore 5
    //   812: aload_0
    //   813: astore 4
    //   815: aload 5
    //   817: astore_0
    //   818: aload_3
    //   819: astore 5
    //   821: aload 4
    //   823: astore_3
    //   824: goto -100 -> 724
    //   827: astore 4
    //   829: aconst_null
    //   830: astore_0
    //   831: aconst_null
    //   832: astore_3
    //   833: goto -230 -> 603
    //   836: astore 4
    //   838: aload_3
    //   839: astore_0
    //   840: aconst_null
    //   841: astore_3
    //   842: goto -239 -> 603
    //   845: astore_0
    //   846: goto -158 -> 688
    //   849: astore_3
    //   850: aconst_null
    //   851: astore_1
    //   852: goto -196 -> 656
    //   855: astore_3
    //   856: goto -200 -> 656
    //   859: astore_3
    //   860: goto -204 -> 656
    //   863: iconst_0
    //   864: istore_2
    //   865: goto -326 -> 539
    //   868: aload_1
    //   869: astore 4
    //   871: aload_0
    //   872: astore_1
    //   873: goto -230 -> 643
    //   876: aload_3
    //   877: astore_1
    //   878: goto -814 -> 64
    //   881: astore_0
    //   882: aconst_null
    //   883: astore_3
    //   884: aload 8
    //   886: astore 5
    //   888: goto -164 -> 724
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	891	0	paramString1	String
    //   0	891	1	paramString2	String
    //   463	402	2	i	int
    //   95	539	3	localObject1	Object
    //   650	19	3	localIOException1	java.io.IOException
    //   672	170	3	localObject2	Object
    //   849	1	3	localIOException2	java.io.IOException
    //   855	1	3	localIOException3	java.io.IOException
    //   859	18	3	localIOException4	java.io.IOException
    //   883	1	3	localObject3	Object
    //   53	492	4	localObject4	Object
    //   596	13	4	localIOException5	java.io.IOException
    //   616	206	4	localObject5	Object
    //   827	1	4	localIOException6	java.io.IOException
    //   836	1	4	localIOException7	java.io.IOException
    //   869	1	4	str1	String
    //   49	757	5	localObject6	Object
    //   810	6	5	localObject7	Object
    //   819	68	5	localObject8	Object
    //   7	492	6	str2	String
    //   140	664	7	localObject9	Object
    //   1	884	8	localObject10	Object
    //   4	563	9	localObject11	Object
    //   60	527	10	localObject12	Object
    //   364	21	11	localEnumeration	java.util.Enumeration
    //   394	163	12	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   573	580	596	java/io/IOException
    //   584	593	596	java/io/IOException
    //   41	51	650	java/io/IOException
    //   41	51	684	finally
    //   350	357	744	java/io/IOException
    //   360	366	744	java/io/IOException
    //   371	381	744	java/io/IOException
    //   384	396	744	java/io/IOException
    //   399	406	744	java/io/IOException
    //   409	420	744	java/io/IOException
    //   423	452	744	java/io/IOException
    //   455	464	744	java/io/IOException
    //   475	484	744	java/io/IOException
    //   487	515	744	java/io/IOException
    //   525	537	744	java/io/IOException
    //   546	555	744	java/io/IOException
    //   618	622	744	java/io/IOException
    //   625	629	744	java/io/IOException
    //   698	703	744	java/io/IOException
    //   709	714	744	java/io/IOException
    //   717	721	744	java/io/IOException
    //   727	732	744	java/io/IOException
    //   735	739	744	java/io/IOException
    //   742	744	744	java/io/IOException
    //   338	347	773	finally
    //   350	357	784	finally
    //   360	366	784	finally
    //   371	381	784	finally
    //   384	396	784	finally
    //   399	406	784	finally
    //   409	420	784	finally
    //   423	452	784	finally
    //   455	464	784	finally
    //   475	484	784	finally
    //   487	515	784	finally
    //   525	537	784	finally
    //   546	555	784	finally
    //   618	622	784	finally
    //   625	629	784	finally
    //   698	703	784	finally
    //   709	714	784	finally
    //   717	721	784	finally
    //   727	732	784	finally
    //   735	739	784	finally
    //   742	744	784	finally
    //   748	752	784	finally
    //   755	760	784	finally
    //   338	347	788	java/io/IOException
    //   562	573	794	finally
    //   573	580	802	finally
    //   584	593	802	finally
    //   603	615	810	finally
    //   555	562	827	java/io/IOException
    //   562	573	836	java/io/IOException
    //   55	62	845	finally
    //   68	78	845	finally
    //   82	96	845	finally
    //   100	110	845	finally
    //   114	142	845	finally
    //   153	167	845	finally
    //   171	175	845	finally
    //   182	190	845	finally
    //   194	208	845	finally
    //   216	220	845	finally
    //   229	240	845	finally
    //   248	261	845	finally
    //   265	278	845	finally
    //   282	288	845	finally
    //   297	304	845	finally
    //   660	664	845	finally
    //   668	673	845	finally
    //   55	62	849	java/io/IOException
    //   153	167	855	java/io/IOException
    //   171	175	855	java/io/IOException
    //   182	190	855	java/io/IOException
    //   194	208	855	java/io/IOException
    //   216	220	855	java/io/IOException
    //   229	240	855	java/io/IOException
    //   248	261	855	java/io/IOException
    //   265	278	855	java/io/IOException
    //   282	288	855	java/io/IOException
    //   297	304	855	java/io/IOException
    //   68	78	859	java/io/IOException
    //   82	96	859	java/io/IOException
    //   100	110	859	java/io/IOException
    //   114	142	859	java/io/IOException
    //   555	562	881	finally
  }
  
  /* Error */
  public static String extractPluginAndGetMd5Code(Context paramContext, String paramString, File paramFile)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: ldc 195
    //   8: invokestatic 200	com/tencent/mobileqq/pluginsdk/DebugHelper:debug	(Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 202
    //   14: ldc 204
    //   16: invokevirtual 207	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 6
    //   21: aload_2
    //   22: invokevirtual 210	java/io/File:exists	()Z
    //   25: ifeq +8 -> 33
    //   28: aload_2
    //   29: invokevirtual 213	java/io/File:delete	()Z
    //   32: pop
    //   33: new 43	java/io/File
    //   36: dup
    //   37: new 65	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   44: aload_2
    //   45: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: ldc 21
    //   50: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 210	java/io/File:exists	()Z
    //   64: ifeq +8 -> 72
    //   67: aload_1
    //   68: invokevirtual 213	java/io/File:delete	()Z
    //   71: pop
    //   72: aload_1
    //   73: invokevirtual 219	java/io/File:createNewFile	()Z
    //   76: pop
    //   77: aload_0
    //   78: invokevirtual 225	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   81: new 65	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   88: ldc 227
    //   90: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 6
    //   95: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokevirtual 233	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   104: astore_0
    //   105: new 165	java/io/FileOutputStream
    //   108: dup
    //   109: aload_1
    //   110: invokespecial 168	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   113: astore 4
    //   115: sipush 8192
    //   118: newarray byte
    //   120: astore 5
    //   122: aload_0
    //   123: aload 5
    //   125: invokevirtual 174	java/io/InputStream:read	([B)I
    //   128: istore_3
    //   129: iload_3
    //   130: iconst_m1
    //   131: if_icmpeq +51 -> 182
    //   134: aload 4
    //   136: aload 5
    //   138: iconst_0
    //   139: iload_3
    //   140: invokevirtual 236	java/io/OutputStream:write	([BII)V
    //   143: goto -21 -> 122
    //   146: astore_2
    //   147: aload_0
    //   148: astore_1
    //   149: aload 4
    //   151: astore_0
    //   152: new 193	java/lang/Exception
    //   155: dup
    //   156: ldc 238
    //   158: aload_2
    //   159: invokespecial 241	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   162: athrow
    //   163: astore 4
    //   165: aload_1
    //   166: astore_2
    //   167: aload_0
    //   168: astore_1
    //   169: aload 4
    //   171: astore_0
    //   172: aload_2
    //   173: invokestatic 189	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   176: aload_1
    //   177: invokestatic 189	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   180: aload_0
    //   181: athrow
    //   182: aload_1
    //   183: aload_2
    //   184: invokevirtual 245	java/io/File:renameTo	(Ljava/io/File;)Z
    //   187: pop
    //   188: aload_2
    //   189: invokevirtual 248	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   192: invokestatic 254	com/tencent/mobileqq/pluginsdk/PluginStatic:encodeFile	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore_1
    //   196: aload_0
    //   197: invokestatic 189	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   200: aload 4
    //   202: invokestatic 189	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   205: aload_1
    //   206: areturn
    //   207: astore_0
    //   208: aconst_null
    //   209: astore_1
    //   210: aload 5
    //   212: astore_2
    //   213: goto -41 -> 172
    //   216: astore 4
    //   218: aconst_null
    //   219: astore_1
    //   220: aload_0
    //   221: astore_2
    //   222: aload 4
    //   224: astore_0
    //   225: goto -53 -> 172
    //   228: astore_1
    //   229: aload_0
    //   230: astore_2
    //   231: aload_1
    //   232: astore_0
    //   233: aload 4
    //   235: astore_1
    //   236: goto -64 -> 172
    //   239: astore_2
    //   240: aconst_null
    //   241: astore_0
    //   242: aload 4
    //   244: astore_1
    //   245: goto -93 -> 152
    //   248: astore_2
    //   249: aconst_null
    //   250: astore 4
    //   252: aload_0
    //   253: astore_1
    //   254: aload 4
    //   256: astore_0
    //   257: goto -105 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramContext	Context
    //   0	260	1	paramString	String
    //   0	260	2	paramFile	File
    //   128	12	3	i	int
    //   4	146	4	localFileOutputStream	java.io.FileOutputStream
    //   163	38	4	localCloseable	java.io.Closeable
    //   216	27	4	localObject1	Object
    //   250	5	4	localObject2	Object
    //   1	210	5	arrayOfByte	byte[]
    //   19	75	6	str	String
    // Exception table:
    //   from	to	target	type
    //   115	122	146	java/lang/Exception
    //   122	129	146	java/lang/Exception
    //   134	143	146	java/lang/Exception
    //   182	196	146	java/lang/Exception
    //   152	163	163	finally
    //   77	105	207	finally
    //   105	115	216	finally
    //   115	122	228	finally
    //   122	129	228	finally
    //   134	143	228	finally
    //   182	196	228	finally
    //   77	105	239	java/lang/Exception
    //   105	115	248	java/lang/Exception
  }
  
  public static String getExceptionInfo(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter, true));
    return localStringWriter.getBuffer().toString();
  }
  
  public static File getInstalledPluginPath(Context paramContext, String paramString)
  {
    Object localObject = null;
    PluginBaseInfo localPluginBaseInfo = PluginBaseInfoHelper.createFromFile(getPluginCfgFile(getPluginInstallDir(paramContext), paramString), PluginBaseInfo.class);
    if ((localPluginBaseInfo == null) || (localPluginBaseInfo.mState != 4) || (localPluginBaseInfo.mInstalledPath == null)) {
      paramContext = a(paramContext, paramString);
    }
    do
    {
      return paramContext;
      paramContext = localObject;
    } while (!PluginStatic.a(localPluginBaseInfo.mInstalledPath));
    return new File(localPluginBaseInfo.mInstalledPath);
  }
  
  public static File getOptimizedDexPath(Context paramContext)
  {
    return paramContext.getDir("odex", 0);
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    PackageInfo localPackageInfo = (PackageInfo)c.get(paramString);
    paramContext = localPackageInfo;
    if (localPackageInfo == null)
    {
      DebugHelper.debug("PluginUtils.verifyPlugin.getPackageArchiveInfo start");
      localPackageInfo = localPackageManager.getPackageArchiveInfo(paramString, 128);
      DebugHelper.debug("PluginUtils.verifyPlugin.getPackageArchiveInfo end");
      paramContext = localPackageInfo;
      if (localPackageInfo != null)
      {
        c.put(paramString, localPackageInfo);
        paramContext = localPackageInfo;
      }
    }
    return paramContext;
  }
  
  public static File getPluginCfgFile(File paramFile, String paramString)
  {
    return new File(paramFile, paramString + ".cfg");
  }
  
  public static File getPluginInstallDir(Context paramContext)
  {
    return paramContext.getDir("installed_plugin", 0);
  }
  
  public static File getPluginLibPath(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString.endsWith(".apk")) {
      str = paramString.substring(0, paramString.length() - ".apk".length());
    }
    return new File(paramContext.getDir("lib", 0), str);
  }
  
  static class a
    extends Exception
  {
    private static final long a = 1L;
    
    public a(String paramString)
    {
      super();
    }
  }
  
  static class b
    extends Exception
  {
    private static final long a = 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginUtils
 * JD-Core Version:    0.7.0.1
 */