package com.tencent.av.core;

import android.os.Build;
import android.os.Build.VERSION;
import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public class VcSystemInfo
{
  public static final int CHIP_ARM_V5 = 1;
  public static final int CHIP_ARM_V6 = 2;
  public static final int CHIP_ARM_V7_NENO = 4;
  public static final int CHIP_ARM_V7_NO_NENO = 3;
  public static final int CHIP_ARM_V8 = 5;
  public static final int CHIP_MIPS = 6;
  public static final int CHIP_UNKNOW = 0;
  public static final int CHIP_X86 = 7;
  private static int mChip;
  private static int mCoreNumber;
  private static int mCpuArchitecture;
  private static String mFeature;
  private static boolean mIsSupportSharpAudio;
  private static boolean mIsSupportSharpVideo;
  private static long mMaxCpuFreq;
  private static String mProcessorName;
  private static String mVendorId;
  public static int sDisplayHeight;
  public static int sDisplayWidth;
  private static boolean sReadCpuInfo = false;
  public static int sScreenHeight;
  public static int sScreenWidth;
  private static String strCPUModel;
  
  static
  {
    mProcessorName = "";
    mFeature = "";
    mVendorId = null;
    mCpuArchitecture = 5;
    mMaxCpuFreq = 0L;
    mCoreNumber = 1;
    mChip = 1;
    mIsSupportSharpAudio = true;
    mIsSupportSharpVideo = true;
    sScreenWidth = 320;
    sScreenHeight = 480;
    sDisplayWidth = 320;
    sDisplayHeight = 480;
    getCpuInfo();
  }
  
  public static String getCPUName()
  {
    getCpuInfo();
    return mProcessorName;
  }
  
  public static int getCameraFacing()
  {
    return 2;
  }
  
  public static int getCpuArchitecture()
  {
    getCpuInfo();
    return mChip;
  }
  
  /* Error */
  private static void getCpuInfo()
  {
    // Byte code:
    //   0: getstatic 46	com/tencent/av/core/VcSystemInfo:sReadCpuInfo	Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: aconst_null
    //   8: astore 10
    //   10: aconst_null
    //   11: astore 9
    //   13: ldc2_w 91
    //   16: lstore 4
    //   18: ldc 93
    //   20: fstore_0
    //   21: new 95	java/lang/StringBuilder
    //   24: dup
    //   25: sipush 1024
    //   28: invokespecial 98	java/lang/StringBuilder:<init>	(I)V
    //   31: astore 11
    //   33: new 100	java/io/BufferedReader
    //   36: dup
    //   37: new 102	java/io/FileReader
    //   40: dup
    //   41: ldc 104
    //   43: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   46: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   49: astore 8
    //   51: aload 8
    //   53: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 9
    //   58: aload 9
    //   60: ifnonnull +228 -> 288
    //   63: iconst_1
    //   64: putstatic 46	com/tencent/av/core/VcSystemInfo:sReadCpuInfo	Z
    //   67: aload 8
    //   69: ifnull +1061 -> 1130
    //   72: aload 8
    //   74: invokevirtual 116	java/io/BufferedReader:close	()V
    //   77: fload_0
    //   78: fstore_1
    //   79: lload 4
    //   81: lstore 6
    //   83: invokestatic 119	com/tencent/av/core/VcSystemInfo:readNumCores	()I
    //   86: istore_2
    //   87: iload_2
    //   88: ifle +871 -> 959
    //   91: iload_2
    //   92: putstatic 60	com/tencent/av/core/VcSystemInfo:mCoreNumber	I
    //   95: aload 11
    //   97: ldc 121
    //   99: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 11
    //   105: getstatic 60	com/tencent/av/core/VcSystemInfo:mCoreNumber	I
    //   108: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 11
    //   114: ldc 130
    //   116: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: invokestatic 134	com/tencent/av/core/VcSystemInfo:readMaxCpuFreq	()J
    //   123: lstore 4
    //   125: lload 4
    //   127: lconst_0
    //   128: lcmp
    //   129: ifle +871 -> 1000
    //   132: lload 4
    //   134: putstatic 58	com/tencent/av/core/VcSystemInfo:mMaxCpuFreq	J
    //   137: aload 11
    //   139: ldc 136
    //   141: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 11
    //   147: getstatic 58	com/tencent/av/core/VcSystemInfo:mMaxCpuFreq	J
    //   150: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 11
    //   156: ldc 130
    //   158: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: getstatic 60	com/tencent/av/core/VcSystemInfo:mCoreNumber	I
    //   165: ifle +11 -> 176
    //   168: getstatic 58	com/tencent/av/core/VcSystemInfo:mMaxCpuFreq	J
    //   171: lconst_0
    //   172: lcmp
    //   173: ifgt +917 -> 1090
    //   176: iconst_0
    //   177: putstatic 46	com/tencent/av/core/VcSystemInfo:sReadCpuInfo	Z
    //   180: aload 11
    //   182: ldc 141
    //   184: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 11
    //   190: getstatic 60	com/tencent/av/core/VcSystemInfo:mCoreNumber	I
    //   193: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 11
    //   199: ldc 143
    //   201: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 11
    //   207: getstatic 58	com/tencent/av/core/VcSystemInfo:mMaxCpuFreq	J
    //   210: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 11
    //   216: ldc 130
    //   218: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: invokestatic 146	com/tencent/av/core/VcSystemInfo:readCpuArchitecture	()I
    //   225: putstatic 62	com/tencent/av/core/VcSystemInfo:mChip	I
    //   228: aload 11
    //   230: ldc 148
    //   232: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 11
    //   238: getstatic 62	com/tencent/av/core/VcSystemInfo:mChip	I
    //   241: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload 11
    //   247: ldc 150
    //   249: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 11
    //   255: getstatic 66	com/tencent/av/core/VcSystemInfo:mIsSupportSharpVideo	Z
    //   258: invokevirtual 153	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 11
    //   264: ldc 155
    //   266: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 11
    //   272: getstatic 64	com/tencent/av/core/VcSystemInfo:mIsSupportSharpAudio	Z
    //   275: invokevirtual 153	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 11
    //   281: ldc 130
    //   283: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: return
    //   288: aload 9
    //   290: ldc 157
    //   292: invokevirtual 163	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   295: ifeq +78 -> 373
    //   298: aload 9
    //   300: bipush 58
    //   302: invokevirtual 167	java/lang/String:indexOf	(I)I
    //   305: istore_2
    //   306: iload_2
    //   307: iconst_1
    //   308: if_icmple -257 -> 51
    //   311: aload 9
    //   313: iload_2
    //   314: iconst_1
    //   315: iadd
    //   316: invokevirtual 171	java/lang/String:substring	(I)Ljava/lang/String;
    //   319: invokevirtual 174	java/lang/String:trim	()Ljava/lang/String;
    //   322: ldc 176
    //   324: ldc 48
    //   326: invokevirtual 180	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   329: putstatic 182	com/tencent/av/core/VcSystemInfo:strCPUModel	Ljava/lang/String;
    //   332: goto -281 -> 51
    //   335: astore 9
    //   337: lload 4
    //   339: lstore 6
    //   341: fload_0
    //   342: fstore_1
    //   343: aload 8
    //   345: ifnull -262 -> 83
    //   348: aload 8
    //   350: invokevirtual 116	java/io/BufferedReader:close	()V
    //   353: lload 4
    //   355: lstore 6
    //   357: fload_0
    //   358: fstore_1
    //   359: goto -276 -> 83
    //   362: astore 8
    //   364: lload 4
    //   366: lstore 6
    //   368: fload_0
    //   369: fstore_1
    //   370: goto -287 -> 83
    //   373: aload 9
    //   375: ldc 184
    //   377: invokevirtual 163	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   380: ifeq +103 -> 483
    //   383: aload 9
    //   385: bipush 58
    //   387: invokevirtual 167	java/lang/String:indexOf	(I)I
    //   390: istore_2
    //   391: iload_2
    //   392: iconst_1
    //   393: if_icmple -342 -> 51
    //   396: aload 9
    //   398: iload_2
    //   399: iconst_1
    //   400: iadd
    //   401: invokevirtual 171	java/lang/String:substring	(I)Ljava/lang/String;
    //   404: putstatic 50	com/tencent/av/core/VcSystemInfo:mProcessorName	Ljava/lang/String;
    //   407: getstatic 50	com/tencent/av/core/VcSystemInfo:mProcessorName	Ljava/lang/String;
    //   410: invokevirtual 174	java/lang/String:trim	()Ljava/lang/String;
    //   413: putstatic 50	com/tencent/av/core/VcSystemInfo:mProcessorName	Ljava/lang/String;
    //   416: aload 11
    //   418: ldc 186
    //   420: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 11
    //   426: getstatic 50	com/tencent/av/core/VcSystemInfo:mProcessorName	Ljava/lang/String;
    //   429: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 11
    //   435: ldc 188
    //   437: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 11
    //   443: aload 9
    //   445: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload 11
    //   451: ldc 130
    //   453: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: goto -406 -> 51
    //   460: astore 10
    //   462: aload 8
    //   464: astore 9
    //   466: aload 10
    //   468: astore 8
    //   470: aload 9
    //   472: ifnull +8 -> 480
    //   475: aload 9
    //   477: invokevirtual 116	java/io/BufferedReader:close	()V
    //   480: aload 8
    //   482: athrow
    //   483: aload 9
    //   485: ldc 190
    //   487: invokevirtual 163	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   490: ifeq +174 -> 664
    //   493: aload 9
    //   495: bipush 58
    //   497: invokevirtual 167	java/lang/String:indexOf	(I)I
    //   500: istore_2
    //   501: iload_2
    //   502: iconst_1
    //   503: if_icmple +44 -> 547
    //   506: aload 9
    //   508: iload_2
    //   509: iconst_1
    //   510: iadd
    //   511: invokevirtual 171	java/lang/String:substring	(I)Ljava/lang/String;
    //   514: invokevirtual 174	java/lang/String:trim	()Ljava/lang/String;
    //   517: astore 10
    //   519: aload 10
    //   521: ifnull +26 -> 547
    //   524: aload 10
    //   526: invokevirtual 193	java/lang/String:length	()I
    //   529: ifle +18 -> 547
    //   532: aload 10
    //   534: ldc 195
    //   536: invokevirtual 198	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   539: ifeq +66 -> 605
    //   542: bipush 8
    //   544: putstatic 56	com/tencent/av/core/VcSystemInfo:mCpuArchitecture	I
    //   547: aload 9
    //   549: ldc 200
    //   551: invokevirtual 204	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   554: ifeq +7 -> 561
    //   557: iconst_5
    //   558: putstatic 56	com/tencent/av/core/VcSystemInfo:mCpuArchitecture	I
    //   561: aload 11
    //   563: ldc 206
    //   565: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload 11
    //   571: getstatic 56	com/tencent/av/core/VcSystemInfo:mCpuArchitecture	I
    //   574: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload 11
    //   580: ldc 188
    //   582: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload 11
    //   588: aload 9
    //   590: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload 11
    //   596: ldc 130
    //   598: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: goto -551 -> 51
    //   605: aload 10
    //   607: invokestatic 212	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   610: l2i
    //   611: putstatic 56	com/tencent/av/core/VcSystemInfo:mCpuArchitecture	I
    //   614: goto -67 -> 547
    //   617: astore 12
    //   619: iconst_1
    //   620: istore_2
    //   621: aload 10
    //   623: invokevirtual 193	java/lang/String:length	()I
    //   626: istore_3
    //   627: iload_2
    //   628: iload_3
    //   629: if_icmpge -82 -> 547
    //   632: aload 10
    //   634: iconst_0
    //   635: aload 10
    //   637: invokevirtual 193	java/lang/String:length	()I
    //   640: iload_2
    //   641: isub
    //   642: invokevirtual 215	java/lang/String:substring	(II)Ljava/lang/String;
    //   645: invokestatic 212	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   648: l2i
    //   649: putstatic 56	com/tencent/av/core/VcSystemInfo:mCpuArchitecture	I
    //   652: goto -105 -> 547
    //   655: astore 12
    //   657: iload_2
    //   658: iconst_1
    //   659: iadd
    //   660: istore_2
    //   661: goto -40 -> 621
    //   664: aload 9
    //   666: ldc 217
    //   668: invokevirtual 163	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   671: ifeq +74 -> 745
    //   674: aload 9
    //   676: bipush 58
    //   678: invokevirtual 167	java/lang/String:indexOf	(I)I
    //   681: istore_2
    //   682: iload_2
    //   683: iconst_1
    //   684: if_icmple +17 -> 701
    //   687: aload 9
    //   689: iload_2
    //   690: iconst_1
    //   691: iadd
    //   692: invokevirtual 171	java/lang/String:substring	(I)Ljava/lang/String;
    //   695: invokevirtual 174	java/lang/String:trim	()Ljava/lang/String;
    //   698: putstatic 52	com/tencent/av/core/VcSystemInfo:mFeature	Ljava/lang/String;
    //   701: aload 11
    //   703: ldc 219
    //   705: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: aload 11
    //   711: getstatic 52	com/tencent/av/core/VcSystemInfo:mFeature	Ljava/lang/String;
    //   714: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 11
    //   720: ldc 188
    //   722: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload 11
    //   728: aload 9
    //   730: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: aload 11
    //   736: ldc 130
    //   738: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: goto -691 -> 51
    //   745: aload 9
    //   747: ldc 221
    //   749: invokevirtual 163	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   752: ifeq +74 -> 826
    //   755: aload 9
    //   757: bipush 58
    //   759: invokevirtual 167	java/lang/String:indexOf	(I)I
    //   762: istore_2
    //   763: iload_2
    //   764: iconst_1
    //   765: if_icmple +17 -> 782
    //   768: aload 9
    //   770: iload_2
    //   771: iconst_1
    //   772: iadd
    //   773: invokevirtual 171	java/lang/String:substring	(I)Ljava/lang/String;
    //   776: invokevirtual 174	java/lang/String:trim	()Ljava/lang/String;
    //   779: putstatic 54	com/tencent/av/core/VcSystemInfo:mVendorId	Ljava/lang/String;
    //   782: aload 11
    //   784: ldc 223
    //   786: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload 11
    //   792: getstatic 54	com/tencent/av/core/VcSystemInfo:mVendorId	Ljava/lang/String;
    //   795: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: aload 11
    //   801: ldc 188
    //   803: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: pop
    //   807: aload 11
    //   809: aload 9
    //   811: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload 11
    //   817: ldc 130
    //   819: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: pop
    //   823: goto -772 -> 51
    //   826: aload 9
    //   828: ldc 225
    //   830: invokevirtual 163	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   833: ifeq +62 -> 895
    //   836: aload 9
    //   838: bipush 58
    //   840: invokevirtual 167	java/lang/String:indexOf	(I)I
    //   843: istore_2
    //   844: iload_2
    //   845: iconst_1
    //   846: if_icmple -795 -> 51
    //   849: aload 9
    //   851: iload_2
    //   852: iconst_1
    //   853: iadd
    //   854: invokevirtual 171	java/lang/String:substring	(I)Ljava/lang/String;
    //   857: invokevirtual 174	java/lang/String:trim	()Ljava/lang/String;
    //   860: astore 9
    //   862: aload 9
    //   864: invokestatic 212	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   867: lstore 6
    //   869: lload 6
    //   871: lconst_0
    //   872: lcmp
    //   873: iflt -822 -> 51
    //   876: lconst_1
    //   877: lload 6
    //   879: ladd
    //   880: lload 4
    //   882: lcmp
    //   883: ifle -832 -> 51
    //   886: lload 6
    //   888: lconst_1
    //   889: ladd
    //   890: lstore 4
    //   892: goto -841 -> 51
    //   895: aload 9
    //   897: ldc 227
    //   899: invokevirtual 163	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   902: ifeq -851 -> 51
    //   905: aload 9
    //   907: bipush 58
    //   909: invokevirtual 167	java/lang/String:indexOf	(I)I
    //   912: istore_2
    //   913: iload_2
    //   914: iconst_1
    //   915: if_icmple -864 -> 51
    //   918: aload 9
    //   920: iload_2
    //   921: iconst_1
    //   922: iadd
    //   923: invokevirtual 171	java/lang/String:substring	(I)Ljava/lang/String;
    //   926: invokevirtual 174	java/lang/String:trim	()Ljava/lang/String;
    //   929: astore 9
    //   931: aload 9
    //   933: invokestatic 233	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   936: fstore_1
    //   937: fload_1
    //   938: fload_0
    //   939: fcmpl
    //   940: ifle -889 -> 51
    //   943: fload_1
    //   944: fstore_0
    //   945: goto -894 -> 51
    //   948: astore 8
    //   950: lload 4
    //   952: lstore 6
    //   954: fload_0
    //   955: fstore_1
    //   956: goto -873 -> 83
    //   959: lload 6
    //   961: lconst_0
    //   962: lcmp
    //   963: ifle -843 -> 120
    //   966: lload 6
    //   968: l2i
    //   969: putstatic 60	com/tencent/av/core/VcSystemInfo:mCoreNumber	I
    //   972: aload 11
    //   974: ldc 235
    //   976: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: pop
    //   980: aload 11
    //   982: getstatic 60	com/tencent/av/core/VcSystemInfo:mCoreNumber	I
    //   985: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   988: pop
    //   989: aload 11
    //   991: ldc 130
    //   993: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: goto -877 -> 120
    //   1000: fload_1
    //   1001: fconst_0
    //   1002: fcmpl
    //   1003: ifle -841 -> 162
    //   1006: fload_1
    //   1007: ldc 236
    //   1009: fcmpg
    //   1010: ifge +45 -> 1055
    //   1013: fload_1
    //   1014: f2d
    //   1015: ldc2_w 237
    //   1018: dmul
    //   1019: ldc2_w 239
    //   1022: dmul
    //   1023: d2l
    //   1024: putstatic 58	com/tencent/av/core/VcSystemInfo:mMaxCpuFreq	J
    //   1027: aload 11
    //   1029: ldc 242
    //   1031: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1034: pop
    //   1035: aload 11
    //   1037: getstatic 58	com/tencent/av/core/VcSystemInfo:mMaxCpuFreq	J
    //   1040: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1043: pop
    //   1044: aload 11
    //   1046: ldc 130
    //   1048: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: pop
    //   1052: goto -890 -> 162
    //   1055: fload_1
    //   1056: ldc 243
    //   1058: fcmpl
    //   1059: ifle +20 -> 1079
    //   1062: fload_1
    //   1063: f2d
    //   1064: ldc2_w 244
    //   1067: ddiv
    //   1068: ldc2_w 239
    //   1071: dmul
    //   1072: d2l
    //   1073: putstatic 58	com/tencent/av/core/VcSystemInfo:mMaxCpuFreq	J
    //   1076: goto -49 -> 1027
    //   1079: ldc 246
    //   1081: fload_1
    //   1082: fmul
    //   1083: f2l
    //   1084: putstatic 58	com/tencent/av/core/VcSystemInfo:mMaxCpuFreq	J
    //   1087: goto -60 -> 1027
    //   1090: iconst_1
    //   1091: putstatic 46	com/tencent/av/core/VcSystemInfo:sReadCpuInfo	Z
    //   1094: goto -914 -> 180
    //   1097: astore 9
    //   1099: goto -1048 -> 51
    //   1102: astore 9
    //   1104: goto -1053 -> 51
    //   1107: astore 9
    //   1109: goto -629 -> 480
    //   1112: astore 8
    //   1114: aload 10
    //   1116: astore 9
    //   1118: goto -648 -> 470
    //   1121: astore 8
    //   1123: aload 9
    //   1125: astore 8
    //   1127: goto -790 -> 337
    //   1130: lload 4
    //   1132: lstore 6
    //   1134: fload_0
    //   1135: fstore_1
    //   1136: goto -1053 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	1115	0	f1	float
    //   78	1058	1	f2	float
    //   86	837	2	i	int
    //   626	4	3	j	int
    //   16	1115	4	l1	long
    //   81	1052	6	l2	long
    //   49	300	8	localBufferedReader	java.io.BufferedReader
    //   362	101	8	localException1	Exception
    //   468	13	8	localObject1	Object
    //   948	1	8	localException2	Exception
    //   1112	1	8	localObject2	Object
    //   1121	1	8	localException3	Exception
    //   1125	1	8	str1	String
    //   11	301	9	str2	String
    //   335	109	9	localException4	Exception
    //   464	468	9	localObject3	Object
    //   1097	1	9	localException5	Exception
    //   1102	1	9	localException6	Exception
    //   1107	1	9	localException7	Exception
    //   1116	8	9	str3	String
    //   8	1	10	localObject4	Object
    //   460	7	10	localObject5	Object
    //   517	598	10	str4	String
    //   31	1014	11	localStringBuilder	java.lang.StringBuilder
    //   617	1	12	localNumberFormatException1	java.lang.NumberFormatException
    //   655	1	12	localNumberFormatException2	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   51	58	335	java/lang/Exception
    //   63	67	335	java/lang/Exception
    //   288	306	335	java/lang/Exception
    //   311	332	335	java/lang/Exception
    //   373	391	335	java/lang/Exception
    //   396	457	335	java/lang/Exception
    //   483	501	335	java/lang/Exception
    //   506	519	335	java/lang/Exception
    //   524	547	335	java/lang/Exception
    //   547	561	335	java/lang/Exception
    //   561	602	335	java/lang/Exception
    //   605	614	335	java/lang/Exception
    //   621	627	335	java/lang/Exception
    //   632	652	335	java/lang/Exception
    //   664	682	335	java/lang/Exception
    //   687	701	335	java/lang/Exception
    //   701	742	335	java/lang/Exception
    //   745	763	335	java/lang/Exception
    //   768	782	335	java/lang/Exception
    //   782	823	335	java/lang/Exception
    //   826	844	335	java/lang/Exception
    //   849	862	335	java/lang/Exception
    //   895	913	335	java/lang/Exception
    //   918	931	335	java/lang/Exception
    //   348	353	362	java/lang/Exception
    //   51	58	460	finally
    //   63	67	460	finally
    //   288	306	460	finally
    //   311	332	460	finally
    //   373	391	460	finally
    //   396	457	460	finally
    //   483	501	460	finally
    //   506	519	460	finally
    //   524	547	460	finally
    //   547	561	460	finally
    //   561	602	460	finally
    //   605	614	460	finally
    //   621	627	460	finally
    //   632	652	460	finally
    //   664	682	460	finally
    //   687	701	460	finally
    //   701	742	460	finally
    //   745	763	460	finally
    //   768	782	460	finally
    //   782	823	460	finally
    //   826	844	460	finally
    //   849	862	460	finally
    //   862	869	460	finally
    //   895	913	460	finally
    //   918	931	460	finally
    //   931	937	460	finally
    //   605	614	617	java/lang/NumberFormatException
    //   632	652	655	java/lang/NumberFormatException
    //   72	77	948	java/lang/Exception
    //   862	869	1097	java/lang/Exception
    //   931	937	1102	java/lang/Exception
    //   475	480	1107	java/lang/Exception
    //   33	51	1112	finally
    //   33	51	1121	java/lang/Exception
  }
  
  public static String getCpuModel()
  {
    getCpuInfo();
    return strCPUModel;
  }
  
  public static String getDeviceName()
  {
    return Build.MODEL;
  }
  
  public static String getDeviceNameForConfigSystem()
  {
    return Build.MANUFACTURER + "_" + Build.MODEL;
  }
  
  public static long getMaxCpuFreq()
  {
    getCpuInfo();
    return mMaxCpuFreq;
  }
  
  public static int getNumCores()
  {
    getCpuInfo();
    return mCoreNumber;
  }
  
  public static int getOsType()
  {
    try
    {
      String str = Build.VERSION.RELEASE;
      if (str.equals("L")) {
        return 118;
      }
      if (Build.VERSION.SDK_INT == 20) {
        return 118;
      }
      if (Build.VERSION.SDK_INT > 20) {
        return 200;
      }
      int j = str.charAt(0);
      int k = str.charAt(2);
      int i = 0;
      if (str.length() >= 5) {
        i = str.charAt(4);
      }
      switch (j)
      {
      default: 
        return 200;
      case 49: 
        if (k == 49) {
          return 101;
        }
        if (k == 53) {
          return 102;
        }
        if (k == 54) {
          return 103;
        }
        break;
      case 50: 
        if (k == 48)
        {
          if (i == 49) {
            return 105;
          }
          return 104;
        }
        if (k == 49) {
          return 106;
        }
        if (k == 50)
        {
          if (i == 49) {
            return 108;
          }
          return 107;
        }
        if ((k == 51) && (i >= 48) && (i <= 57)) {
          return 109;
        }
        break;
      case 51: 
        if (k == 48) {
          return 110;
        }
        if (k == 49) {
          return 111;
        }
        if (k == 50) {
          return 112;
        }
        break;
      case 52: 
        if (k == 48) {
          return 113;
        }
        if (k == 49) {
          return 114;
        }
        if (k == 50) {
          return 115;
        }
        if (k == 51) {
          return 116;
        }
        if (k == 52) {
          return 117;
        }
        break;
      case 53: 
        if (k == 48) {
          return 118;
        }
        break;
      }
    }
    catch (Exception localException) {}
    return 200;
  }
  
  private static int readCpuArchitecture()
  {
    if (mProcessorName.contains("ARMv6")) {}
    do
    {
      return 2;
      if (Build.CPU_ABI.equalsIgnoreCase("armeabi-v7a")) {
        return 4;
      }
    } while (Build.CPU_ABI.equalsIgnoreCase("armeabi"));
    if ((mCpuArchitecture == 7) && (!mFeature.contains("neon")))
    {
      long l = getMaxCpuFreq();
      int i = getNumCores();
      if ((l < 1100000L) || (i < 2)) {
        return 3;
      }
    }
    if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
      return 7;
    }
    switch (mCpuArchitecture)
    {
    case 6: 
    default: 
      if ((mVendorId != null) && ((mVendorId.equalsIgnoreCase("AuthenticAMD")) || (mVendorId.equalsIgnoreCase("GenuineIntel")))) {
        return 7;
      }
      break;
    case 5: 
      return 1;
    case 7: 
      return 4;
    case 8: 
      return 5;
    }
    return 0;
  }
  
  /* Error */
  private static long readMaxCpuFreq()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: lconst_0
    //   3: lstore 5
    //   5: getstatic 60	com/tencent/av/core/VcSystemInfo:mCoreNumber	I
    //   8: iconst_1
    //   9: if_icmpge +8 -> 17
    //   12: bipush 8
    //   14: putstatic 60	com/tencent/av/core/VcSystemInfo:mCoreNumber	I
    //   17: iconst_0
    //   18: istore_1
    //   19: iconst_0
    //   20: istore_0
    //   21: iload_0
    //   22: getstatic 60	com/tencent/av/core/VcSystemInfo:mCoreNumber	I
    //   25: if_icmpge +240 -> 265
    //   28: aconst_null
    //   29: astore 12
    //   31: aconst_null
    //   32: astore 13
    //   34: ldc 48
    //   36: astore 14
    //   38: new 100	java/io/BufferedReader
    //   41: dup
    //   42: new 102	java/io/FileReader
    //   45: dup
    //   46: new 95	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 311
    //   56: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: iload_0
    //   60: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: ldc_w 313
    //   66: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   75: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   78: astore 11
    //   80: lload_3
    //   81: lstore 7
    //   83: aload 11
    //   85: ifnull +55 -> 140
    //   88: aload 11
    //   90: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   93: astore 13
    //   95: aload 14
    //   97: astore 12
    //   99: aload 13
    //   101: invokestatic 318	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: ifne +10 -> 114
    //   107: aload 13
    //   109: invokevirtual 174	java/lang/String:trim	()Ljava/lang/String;
    //   112: astore 12
    //   114: lload_3
    //   115: lstore 7
    //   117: aload 12
    //   119: ifnull +21 -> 140
    //   122: lload_3
    //   123: lstore 7
    //   125: aload 12
    //   127: invokevirtual 193	java/lang/String:length	()I
    //   130: ifle +10 -> 140
    //   133: aload 12
    //   135: invokestatic 212	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   138: lstore 7
    //   140: aload 11
    //   142: ifnull +8 -> 150
    //   145: aload 11
    //   147: invokevirtual 116	java/io/BufferedReader:close	()V
    //   150: lload 7
    //   152: lstore_3
    //   153: lload 5
    //   155: lstore 7
    //   157: lload_3
    //   158: lload 5
    //   160: lcmp
    //   161: ifle +6 -> 167
    //   164: lload_3
    //   165: lstore 7
    //   167: iload_0
    //   168: iconst_1
    //   169: iadd
    //   170: istore_0
    //   171: lload 7
    //   173: lstore 5
    //   175: goto -154 -> 21
    //   178: astore 11
    //   180: aload 11
    //   182: invokevirtual 321	java/io/IOException:printStackTrace	()V
    //   185: lload 7
    //   187: lstore_3
    //   188: goto -35 -> 153
    //   191: astore 11
    //   193: aload 13
    //   195: astore 11
    //   197: lconst_0
    //   198: lstore 7
    //   200: iconst_1
    //   201: istore_2
    //   202: iload_2
    //   203: istore_1
    //   204: lload 7
    //   206: lstore_3
    //   207: aload 11
    //   209: ifnull -56 -> 153
    //   212: aload 11
    //   214: invokevirtual 116	java/io/BufferedReader:close	()V
    //   217: iload_2
    //   218: istore_1
    //   219: lload 7
    //   221: lstore_3
    //   222: goto -69 -> 153
    //   225: astore 11
    //   227: aload 11
    //   229: invokevirtual 321	java/io/IOException:printStackTrace	()V
    //   232: iload_2
    //   233: istore_1
    //   234: lload 7
    //   236: lstore_3
    //   237: goto -84 -> 153
    //   240: astore 11
    //   242: aload 12
    //   244: ifnull +8 -> 252
    //   247: aload 12
    //   249: invokevirtual 116	java/io/BufferedReader:close	()V
    //   252: aload 11
    //   254: athrow
    //   255: astore 12
    //   257: aload 12
    //   259: invokevirtual 321	java/io/IOException:printStackTrace	()V
    //   262: goto -10 -> 252
    //   265: lload 5
    //   267: lstore 7
    //   269: iload_1
    //   270: ifeq +23 -> 293
    //   273: invokestatic 324	com/tencent/av/core/VcSystemInfo:readMaxCpuFreqFromState	()J
    //   276: lstore 9
    //   278: lload 5
    //   280: lstore 7
    //   282: lload 9
    //   284: lload_3
    //   285: lcmp
    //   286: ifle +7 -> 293
    //   289: lload 9
    //   291: lstore 7
    //   293: lload 7
    //   295: lreturn
    //   296: astore 13
    //   298: aload 11
    //   300: astore 12
    //   302: aload 13
    //   304: astore 11
    //   306: goto -64 -> 242
    //   309: astore 12
    //   311: goto -114 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	151	0	i	int
    //   18	252	1	j	int
    //   201	32	2	k	int
    //   1	284	3	l1	long
    //   3	276	5	l2	long
    //   81	213	7	l3	long
    //   276	14	9	l4	long
    //   78	68	11	localBufferedReader	java.io.BufferedReader
    //   178	3	11	localIOException1	java.io.IOException
    //   191	1	11	localException1	Exception
    //   195	18	11	str1	String
    //   225	3	11	localIOException2	java.io.IOException
    //   240	59	11	localObject1	Object
    //   304	1	11	localObject2	Object
    //   29	219	12	localObject3	Object
    //   255	3	12	localIOException3	java.io.IOException
    //   300	1	12	localObject4	Object
    //   309	1	12	localException2	Exception
    //   32	162	13	str2	String
    //   296	7	13	localObject5	Object
    //   36	60	14	str3	String
    // Exception table:
    //   from	to	target	type
    //   145	150	178	java/io/IOException
    //   38	80	191	java/lang/Exception
    //   212	217	225	java/io/IOException
    //   38	80	240	finally
    //   247	252	255	java/io/IOException
    //   88	95	296	finally
    //   99	114	296	finally
    //   125	140	296	finally
    //   88	95	309	java/lang/Exception
    //   99	114	309	java/lang/Exception
    //   125	140	309	java/lang/Exception
  }
  
  /* Error */
  private static long readMaxCpuFreqFromState()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_3
    //   2: aconst_null
    //   3: astore 7
    //   5: aconst_null
    //   6: astore 5
    //   8: new 100	java/io/BufferedReader
    //   11: dup
    //   12: new 102	java/io/FileReader
    //   15: dup
    //   16: ldc_w 326
    //   19: invokespecial 107	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   22: invokespecial 110	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore 6
    //   27: lload_3
    //   28: lstore_1
    //   29: aload 6
    //   31: ifnull +75 -> 106
    //   34: aconst_null
    //   35: astore 7
    //   37: aload 6
    //   39: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 5
    //   44: aload 5
    //   46: ifnull +160 -> 206
    //   49: aload 6
    //   51: invokevirtual 113	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore 8
    //   56: aload 5
    //   58: astore 7
    //   60: aload 8
    //   62: astore 5
    //   64: goto -20 -> 44
    //   67: lload_3
    //   68: lstore_1
    //   69: iload_0
    //   70: iconst_m1
    //   71: if_icmpeq +35 -> 106
    //   74: aload 7
    //   76: iconst_0
    //   77: iload_0
    //   78: invokevirtual 215	java/lang/String:substring	(II)Ljava/lang/String;
    //   81: astore 5
    //   83: lload_3
    //   84: lstore_1
    //   85: aload 5
    //   87: ifnull +19 -> 106
    //   90: lload_3
    //   91: lstore_1
    //   92: aload 5
    //   94: invokevirtual 193	java/lang/String:length	()I
    //   97: ifle +9 -> 106
    //   100: aload 5
    //   102: invokestatic 212	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   105: lstore_1
    //   106: aload 6
    //   108: ifnull +8 -> 116
    //   111: aload 6
    //   113: invokevirtual 116	java/io/BufferedReader:close	()V
    //   116: lload_1
    //   117: lreturn
    //   118: aload 7
    //   120: bipush 9
    //   122: invokevirtual 167	java/lang/String:indexOf	(I)I
    //   125: istore_0
    //   126: goto -59 -> 67
    //   129: astore 5
    //   131: aload 5
    //   133: invokevirtual 321	java/io/IOException:printStackTrace	()V
    //   136: lload_1
    //   137: lreturn
    //   138: astore 6
    //   140: lconst_0
    //   141: lstore_1
    //   142: aload 5
    //   144: ifnull -28 -> 116
    //   147: aload 5
    //   149: invokevirtual 116	java/io/BufferedReader:close	()V
    //   152: lconst_0
    //   153: lreturn
    //   154: astore 5
    //   156: aload 5
    //   158: invokevirtual 321	java/io/IOException:printStackTrace	()V
    //   161: lconst_0
    //   162: lreturn
    //   163: astore 5
    //   165: aload 7
    //   167: astore 6
    //   169: aload 6
    //   171: ifnull +8 -> 179
    //   174: aload 6
    //   176: invokevirtual 116	java/io/BufferedReader:close	()V
    //   179: aload 5
    //   181: athrow
    //   182: astore 6
    //   184: aload 6
    //   186: invokevirtual 321	java/io/IOException:printStackTrace	()V
    //   189: goto -10 -> 179
    //   192: astore 5
    //   194: goto -25 -> 169
    //   197: astore 5
    //   199: aload 6
    //   201: astore 5
    //   203: goto -63 -> 140
    //   206: aload 7
    //   208: ifnonnull -90 -> 118
    //   211: iconst_m1
    //   212: istore_0
    //   213: goto -146 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   69	144	0	i	int
    //   28	114	1	l1	long
    //   1	90	3	l2	long
    //   6	95	5	localObject1	Object
    //   129	19	5	localIOException1	java.io.IOException
    //   154	3	5	localIOException2	java.io.IOException
    //   163	17	5	localObject2	Object
    //   192	1	5	localObject3	Object
    //   197	1	5	localException1	Exception
    //   201	1	5	localObject4	Object
    //   25	87	6	localBufferedReader	java.io.BufferedReader
    //   138	1	6	localException2	Exception
    //   167	8	6	localObject5	Object
    //   182	18	6	localIOException3	java.io.IOException
    //   3	204	7	localObject6	Object
    //   54	7	8	str	String
    // Exception table:
    //   from	to	target	type
    //   111	116	129	java/io/IOException
    //   8	27	138	java/lang/Exception
    //   147	152	154	java/io/IOException
    //   8	27	163	finally
    //   174	179	182	java/io/IOException
    //   37	44	192	finally
    //   49	56	192	finally
    //   74	83	192	finally
    //   92	106	192	finally
    //   118	126	192	finally
    //   37	44	197	java/lang/Exception
    //   49	56	197	java/lang/Exception
    //   74	83	197	java/lang/Exception
    //   92	106	197	java/lang/Exception
    //   118	126	197	java/lang/Exception
  }
  
  private static int readNumCores()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          return Pattern.matches("cpu[0-9]", paramAnonymousFile.getName());
        }
      }).length;
      return i;
    }
    catch (Exception localException) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.av.core.VcSystemInfo
 * JD-Core Version:    0.7.0.1
 */