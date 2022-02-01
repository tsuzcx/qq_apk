package com.tencent.smtt.export.external;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.DexClassLoader;
import dalvik.system.VMStack;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class DexLoader
{
  private static final String JAVACORE_PACKAGE_PREFIX = "org.chromium";
  private static final String TAF_PACKAGE_PREFIX = "com.taf";
  private static final String TAG = "DexLoader";
  private static final String TBS_FUSION_DEX = "tbs_jars_fusion_dex";
  private static final String TBS_WEBVIEW_DEX = "webview_dex";
  private static final String TENCENT_PACKAGE_PREFIX = "com.tencent";
  static boolean mCanUseDexLoaderProviderService = true;
  private static boolean mMttClassUseCorePrivate = false;
  private static boolean mUseSpeedyClassLoader;
  private static boolean mUseTbsCorePrivateClassLoader = false;
  private DexClassLoader mClassLoader;
  
  static
  {
    mUseSpeedyClassLoader = false;
  }
  
  public DexLoader(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, new String[] { paramString1 }, paramString2);
  }
  
  public DexLoader(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    this(null, paramContext, paramArrayOfString, paramString);
  }
  
  public DexLoader(Context paramContext, String[] paramArrayOfString, String paramString, DexLoader paramDexLoader)
  {
    paramDexLoader = paramDexLoader.getClassLoader();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramDexLoader = createDexClassLoader(paramArrayOfString[i], paramString, paramContext.getApplicationInfo().nativeLibraryDir, paramDexLoader, paramContext);
      this.mClassLoader = paramDexLoader;
      i += 1;
    }
  }
  
  public DexLoader(Context paramContext, String[] paramArrayOfString, String paramString1, String paramString2)
  {
    ClassLoader localClassLoader = paramContext.getClassLoader();
    String str2 = paramContext.getApplicationInfo().nativeLibraryDir;
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString2)) {
      str1 = str2 + File.pathSeparator + paramString2;
    }
    int i = 0;
    paramString2 = localClassLoader;
    while (i < paramArrayOfString.length)
    {
      paramString2 = createDexClassLoader(paramArrayOfString[i], paramString1, str1, paramString2, paramContext);
      this.mClassLoader = paramString2;
      i += 1;
    }
  }
  
  public DexLoader(String paramString1, Context paramContext, String[] paramArrayOfString, String paramString2)
  {
    this(paramString1, paramContext, paramArrayOfString, paramString2, null);
  }
  
  public DexLoader(String paramString1, Context paramContext, String[] paramArrayOfString, String paramString2, Map<String, Object> paramMap)
  {
    initTbsSettings(paramMap);
    ClassLoader localClassLoader = VMStack.getCallingClassLoader();
    paramMap = localClassLoader;
    if (localClassLoader == null) {
      paramMap = paramContext.getClassLoader();
    }
    Log.d("dexloader", "Set base classLoader for DexClassLoader: " + paramMap);
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      paramMap = createDexClassLoader(paramArrayOfString[i], paramString2, paramString1, paramMap, paramContext);
      this.mClassLoader = paramMap;
      i += 1;
    }
  }
  
  /* Error */
  private DexClassLoader createDexClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, Context paramContext)
  {
    // Byte code:
    //   0: getstatic 143	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 29
    //   5: if_icmplt +707 -> 712
    //   8: new 90	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15: aload_1
    //   16: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc 145
    //   21: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 10
    //   29: new 90	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   36: aload_1
    //   37: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 147
    //   42: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore 11
    //   50: new 90	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   57: aload_1
    //   58: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc 149
    //   63: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: astore 12
    //   71: aload 5
    //   73: ldc 151
    //   75: iconst_0
    //   76: invokevirtual 155	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   79: astore 13
    //   81: new 97	java/io/File
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 16
    //   91: new 97	java/io/File
    //   94: dup
    //   95: aload 5
    //   97: ldc 160
    //   99: iconst_0
    //   100: invokevirtual 164	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   103: ldc 166
    //   105: invokespecial 169	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   108: astore 8
    //   110: aconst_null
    //   111: astore 9
    //   113: aload 13
    //   115: aload 10
    //   117: iconst_m1
    //   118: invokeinterface 175 3 0
    //   123: istore 7
    //   125: aload 13
    //   127: aload 11
    //   129: ldc 177
    //   131: invokeinterface 181 3 0
    //   136: astore 17
    //   138: aload 13
    //   140: aload 12
    //   142: ldc 177
    //   144: invokeinterface 181 3 0
    //   149: astore 18
    //   151: aload 5
    //   153: invokevirtual 184	android/content/Context:getPackageName	()Ljava/lang/String;
    //   156: astore 14
    //   158: aload 5
    //   160: invokevirtual 188	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   163: aload 14
    //   165: iconst_0
    //   166: invokevirtual 194	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   169: astore 14
    //   171: aload 14
    //   173: getfield 199	android/content/pm/PackageInfo:versionCode	I
    //   176: istore 6
    //   178: aload 14
    //   180: getfield 202	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   183: astore 14
    //   185: getstatic 207	android/os/Build:DISPLAY	Ljava/lang/String;
    //   188: astore 15
    //   190: ldc 17
    //   192: new 90	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   199: ldc 209
    //   201: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 17
    //   206: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 211
    //   211: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: iload 6
    //   216: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: ldc 216
    //   221: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload 17
    //   226: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc 218
    //   231: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload 14
    //   236: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc 220
    //   241: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload 18
    //   246: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: ldc 222
    //   251: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload 15
    //   256: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 225	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   265: pop
    //   266: iload 6
    //   268: iload 7
    //   270: if_icmpne +23 -> 293
    //   273: aload 14
    //   275: aload 17
    //   277: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   280: ifeq +13 -> 293
    //   283: aload 15
    //   285: aload 18
    //   287: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   290: ifne +682 -> 972
    //   293: ldc 17
    //   295: ldc 231
    //   297: invokestatic 234	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   300: pop
    //   301: new 236	com/tencent/smtt/utils/l
    //   304: dup
    //   305: aload 8
    //   307: new 90	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   314: aload 16
    //   316: invokevirtual 239	java/io/File:getName	()Ljava/lang/String;
    //   319: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: ldc 241
    //   324: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokespecial 242	com/tencent/smtt/utils/l:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   333: astore 8
    //   335: aload 8
    //   337: invokevirtual 245	com/tencent/smtt/utils/l:b	()V
    //   340: aload 13
    //   342: aload 10
    //   344: iconst_m1
    //   345: invokeinterface 175 3 0
    //   350: istore 7
    //   352: aload 13
    //   354: aload 11
    //   356: ldc 177
    //   358: invokeinterface 181 3 0
    //   363: astore 9
    //   365: aload 13
    //   367: aload 12
    //   369: ldc 177
    //   371: invokeinterface 181 3 0
    //   376: astore 17
    //   378: iload 6
    //   380: iload 7
    //   382: if_icmpne +27 -> 409
    //   385: aload 14
    //   387: aload 9
    //   389: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   392: ifeq +17 -> 409
    //   395: aload 8
    //   397: astore 9
    //   399: aload 15
    //   401: aload 17
    //   403: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   406: ifne +296 -> 702
    //   409: new 97	java/io/File
    //   412: dup
    //   413: aload 16
    //   415: invokevirtual 248	java/io/File:getParent	()Ljava/lang/String;
    //   418: ldc 250
    //   420: invokespecial 253	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   423: astore 18
    //   425: aload 16
    //   427: invokevirtual 239	java/io/File:getName	()Ljava/lang/String;
    //   430: invokestatic 257	com/tencent/smtt/export/external/DexLoader:getFileNameNoEx	(Ljava/lang/String;)Ljava/lang/String;
    //   433: astore 17
    //   435: new 97	java/io/File
    //   438: dup
    //   439: aload 18
    //   441: new 90	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   448: aload 16
    //   450: invokevirtual 239	java/io/File:getName	()Ljava/lang/String;
    //   453: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: ldc_w 259
    //   459: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   465: invokespecial 169	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   468: astore 9
    //   470: new 97	java/io/File
    //   473: dup
    //   474: aload 18
    //   476: new 90	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   483: aload 16
    //   485: invokevirtual 239	java/io/File:getName	()Ljava/lang/String;
    //   488: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: ldc_w 261
    //   494: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokespecial 169	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   503: astore 16
    //   505: new 97	java/io/File
    //   508: dup
    //   509: aload 18
    //   511: ldc_w 263
    //   514: invokespecial 169	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   517: astore 19
    //   519: new 97	java/io/File
    //   522: dup
    //   523: aload 19
    //   525: new 90	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   532: aload 17
    //   534: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: ldc_w 265
    //   540: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokespecial 169	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   549: astore 18
    //   551: new 97	java/io/File
    //   554: dup
    //   555: aload 19
    //   557: new 90	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   564: aload 17
    //   566: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: ldc_w 267
    //   572: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   578: invokespecial 169	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   581: astore 17
    //   583: aload 9
    //   585: invokestatic 271	com/tencent/smtt/export/external/DexLoader:delete	(Ljava/io/File;)V
    //   588: aload 16
    //   590: invokestatic 271	com/tencent/smtt/export/external/DexLoader:delete	(Ljava/io/File;)V
    //   593: aload 18
    //   595: invokestatic 271	com/tencent/smtt/export/external/DexLoader:delete	(Ljava/io/File;)V
    //   598: aload 17
    //   600: invokestatic 271	com/tencent/smtt/export/external/DexLoader:delete	(Ljava/io/File;)V
    //   603: ldc 17
    //   605: new 90	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   612: ldc_w 273
    //   615: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload 9
    //   620: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   623: aload 16
    //   625: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   628: aload 18
    //   630: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   633: aload 17
    //   635: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   638: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokestatic 225	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   644: pop
    //   645: aload 13
    //   647: invokeinterface 277 1 0
    //   652: astore 9
    //   654: aload 9
    //   656: aload 11
    //   658: aload 14
    //   660: invokeinterface 283 3 0
    //   665: pop
    //   666: aload 9
    //   668: aload 10
    //   670: iload 6
    //   672: invokeinterface 287 3 0
    //   677: pop
    //   678: aload 9
    //   680: aload 12
    //   682: aload 15
    //   684: invokeinterface 283 3 0
    //   689: pop
    //   690: aload 9
    //   692: invokeinterface 290 1 0
    //   697: pop
    //   698: aload 8
    //   700: astore 9
    //   702: aload 9
    //   704: ifnull +8 -> 712
    //   707: aload 9
    //   709: invokevirtual 292	com/tencent/smtt/utils/l:e	()V
    //   712: ldc 118
    //   714: new 90	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   721: ldc_w 294
    //   724: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: aload_1
    //   728: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: invokestatic 129	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   737: pop
    //   738: aload_0
    //   739: aload_1
    //   740: invokespecial 298	com/tencent/smtt/export/external/DexLoader:shouldUseTbsCorePrivateClassLoader	(Ljava/lang/String;)Z
    //   743: ifeq +88 -> 831
    //   746: new 6	com/tencent/smtt/export/external/DexLoader$TbsCorePrivateClassLoader
    //   749: dup
    //   750: aload_1
    //   751: aload_2
    //   752: aload_3
    //   753: aload 4
    //   755: invokespecial 301	com/tencent/smtt/export/external/DexLoader$TbsCorePrivateClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   758: astore_1
    //   759: ldc 118
    //   761: new 90	java/lang/StringBuilder
    //   764: dup
    //   765: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   768: ldc_w 303
    //   771: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: aload_1
    //   775: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   778: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   781: invokestatic 129	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   784: pop
    //   785: aload_1
    //   786: areturn
    //   787: astore 10
    //   789: aload 9
    //   791: astore 8
    //   793: aload 10
    //   795: astore 9
    //   797: aload 9
    //   799: invokevirtual 306	java/lang/Exception:printStackTrace	()V
    //   802: aload 8
    //   804: ifnull -92 -> 712
    //   807: aload 8
    //   809: invokevirtual 292	com/tencent/smtt/utils/l:e	()V
    //   812: goto -100 -> 712
    //   815: astore_1
    //   816: aconst_null
    //   817: astore 8
    //   819: aload 8
    //   821: ifnull +8 -> 829
    //   824: aload 8
    //   826: invokevirtual 292	com/tencent/smtt/utils/l:e	()V
    //   829: aload_1
    //   830: athrow
    //   831: getstatic 143	android/os/Build$VERSION:SDK_INT	I
    //   834: bipush 21
    //   836: if_icmplt +98 -> 934
    //   839: getstatic 143	android/os/Build$VERSION:SDK_INT	I
    //   842: bipush 25
    //   844: if_icmpgt +90 -> 934
    //   847: getstatic 39	com/tencent/smtt/export/external/DexLoader:mUseSpeedyClassLoader	Z
    //   850: ifeq +84 -> 934
    //   853: ldc 118
    //   855: ldc_w 308
    //   858: invokestatic 129	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   861: pop
    //   862: aload_1
    //   863: aload_2
    //   864: aload_3
    //   865: aload 4
    //   867: aload 5
    //   869: invokestatic 311	com/tencent/smtt/export/external/DexClassLoaderProvider:createDexClassLoader	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;Landroid/content/Context;)Ldalvik/system/DexClassLoader;
    //   872: astore 5
    //   874: aload 5
    //   876: astore_1
    //   877: goto -118 -> 759
    //   880: astore 5
    //   882: ldc 118
    //   884: new 90	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   891: ldc_w 313
    //   894: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: aload 5
    //   899: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   902: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokestatic 234	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   908: pop
    //   909: ldc 118
    //   911: ldc_w 315
    //   914: invokestatic 129	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   917: pop
    //   918: new 317	dalvik/system/DexClassLoader
    //   921: dup
    //   922: aload_1
    //   923: aload_2
    //   924: aload_3
    //   925: aload 4
    //   927: invokespecial 318	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   930: astore_1
    //   931: goto -172 -> 759
    //   934: ldc 118
    //   936: ldc_w 320
    //   939: invokestatic 129	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   942: pop
    //   943: new 317	dalvik/system/DexClassLoader
    //   946: dup
    //   947: aload_1
    //   948: aload_2
    //   949: aload_3
    //   950: aload 4
    //   952: invokespecial 318	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   955: astore_1
    //   956: goto -197 -> 759
    //   959: astore_1
    //   960: goto -141 -> 819
    //   963: astore_1
    //   964: goto -145 -> 819
    //   967: astore 9
    //   969: goto -172 -> 797
    //   972: aconst_null
    //   973: astore 9
    //   975: goto -273 -> 702
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	978	0	this	DexLoader
    //   0	978	1	paramString1	String
    //   0	978	2	paramString2	String
    //   0	978	3	paramString3	String
    //   0	978	4	paramClassLoader	ClassLoader
    //   0	978	5	paramContext	Context
    //   176	495	6	i	int
    //   123	260	7	j	int
    //   108	717	8	localObject1	Object
    //   111	687	9	localObject2	Object
    //   967	1	9	localException1	java.lang.Exception
    //   973	1	9	localObject3	Object
    //   27	642	10	str1	String
    //   787	7	10	localException2	java.lang.Exception
    //   48	609	11	str2	String
    //   69	612	12	str3	String
    //   79	567	13	localSharedPreferences	android.content.SharedPreferences
    //   156	503	14	localObject4	Object
    //   188	495	15	str4	String
    //   89	535	16	localFile1	File
    //   136	498	17	localObject5	Object
    //   149	480	18	localObject6	Object
    //   517	39	19	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   113	266	787	java/lang/Exception
    //   273	293	787	java/lang/Exception
    //   293	335	787	java/lang/Exception
    //   113	266	815	finally
    //   273	293	815	finally
    //   293	335	815	finally
    //   862	874	880	java/lang/Throwable
    //   335	378	959	finally
    //   385	395	959	finally
    //   399	409	959	finally
    //   409	698	959	finally
    //   797	802	963	finally
    //   335	378	967	java/lang/Exception
    //   385	395	967	java/lang/Exception
    //   399	409	967	java/lang/Exception
    //   409	698	967	java/lang/Exception
  }
  
  public static void delete(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    File[] arrayOfFile;
    do
    {
      return;
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      arrayOfFile = paramFile.listFiles();
    } while (arrayOfFile == null);
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      delete(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  public static String getFileNameNoEx(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 0)
      {
        int i = paramString.lastIndexOf('.');
        str = paramString;
        if (i > -1)
        {
          str = paramString;
          if (i < paramString.length()) {
            str = paramString.substring(0, i);
          }
        }
      }
    }
    return str;
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    Log.d("DexLoader", "initTbsSettings - " + paramMap);
    if (paramMap != null) {}
    try
    {
      Object localObject = paramMap.get("use_private_classloader");
      if ((localObject instanceof Boolean)) {
        mUseTbsCorePrivateClassLoader = ((Boolean)localObject).booleanValue();
      }
      localObject = paramMap.get("use_speedy_classloader");
      if ((localObject instanceof Boolean)) {
        mUseSpeedyClassLoader = ((Boolean)localObject).booleanValue();
      }
      localObject = paramMap.get("use_dexloader_service");
      if ((localObject instanceof Boolean)) {
        mCanUseDexLoaderProviderService = ((Boolean)localObject).booleanValue();
      }
      paramMap = paramMap.get("use_mtt_classes");
      if ((paramMap instanceof Boolean)) {
        mMttClassUseCorePrivate = ((Boolean)paramMap).booleanValue();
      }
      return;
    }
    catch (Throwable paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  private boolean shouldUseTbsCorePrivateClassLoader(String paramString)
  {
    if (!mUseTbsCorePrivateClassLoader) {}
    while ((!paramString.contains("tbs_jars_fusion_dex")) && (!paramString.contains("webview_dex"))) {
      return false;
    }
    return true;
  }
  
  public DexClassLoader getClassLoader()
  {
    return this.mClassLoader;
  }
  
  public Object getStaticField(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = this.mClassLoader.loadClass(paramString1).getField(paramString2);
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.e(getClass().getSimpleName(), "'" + paramString1 + "' get field '" + paramString2 + "' failed", localThrowable);
    }
    return null;
  }
  
  public Object invokeMethod(Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramArrayOfClass = this.mClassLoader.loadClass(paramString1).getMethod(paramString2, paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramObject = paramArrayOfClass.invoke(paramObject, paramVarArgs);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      Log.e(getClass().getSimpleName(), "'" + paramString1 + "' invoke method '" + paramString2 + "' failed", paramObject);
    }
    return null;
  }
  
  public Object invokeStaticMethod(String paramString1, String paramString2, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramArrayOfClass = this.mClassLoader.loadClass(paramString1).getMethod(paramString2, paramArrayOfClass);
      paramArrayOfClass.setAccessible(true);
      paramArrayOfClass = paramArrayOfClass.invoke(null, paramVarArgs);
      return paramArrayOfClass;
    }
    catch (Throwable paramArrayOfClass)
    {
      if ((paramString2 != null) && (paramString2.equalsIgnoreCase("initTesRuntimeEnvironment")))
      {
        Log.e(getClass().getSimpleName(), "'" + paramString1 + "' invoke static method '" + paramString2 + "' failed", paramArrayOfClass);
        return paramArrayOfClass;
      }
      Log.i(getClass().getSimpleName(), "'" + paramString1 + "' invoke static method '" + paramString2 + "' failed", paramArrayOfClass);
    }
    return null;
  }
  
  public Class<?> loadClass(String paramString)
  {
    try
    {
      Class localClass = this.mClassLoader.loadClass(paramString);
      return localClass;
    }
    catch (Throwable localThrowable)
    {
      Log.e(getClass().getSimpleName(), "loadClass '" + paramString + "' failed", localThrowable);
    }
    return null;
  }
  
  public Object newInstance(String paramString)
  {
    try
    {
      Object localObject = this.mClassLoader.loadClass(paramString).newInstance();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Log.e(getClass().getSimpleName(), "create " + paramString + " instance failed", localThrowable);
    }
    return null;
  }
  
  public Object newInstance(String paramString, Class<?>[] paramArrayOfClass, Object... paramVarArgs)
  {
    try
    {
      paramArrayOfClass = this.mClassLoader.loadClass(paramString).getConstructor(paramArrayOfClass).newInstance(paramVarArgs);
      return paramArrayOfClass;
    }
    catch (Throwable paramArrayOfClass)
    {
      if ("com.tencent.smtt.webkit.adapter.X5WebViewAdapter".equalsIgnoreCase(paramString))
      {
        Log.e(getClass().getSimpleName(), "'newInstance " + paramString + " failed", paramArrayOfClass);
        return paramArrayOfClass;
      }
      Log.e(getClass().getSimpleName(), "create '" + paramString + "' instance failed", paramArrayOfClass);
    }
    return null;
  }
  
  public void setStaticField(String paramString1, String paramString2, Object paramObject)
  {
    try
    {
      Field localField = this.mClassLoader.loadClass(paramString1).getField(paramString2);
      localField.setAccessible(true);
      localField.set(null, paramObject);
      return;
    }
    catch (Throwable paramObject)
    {
      Log.e(getClass().getSimpleName(), "'" + paramString1 + "' set field '" + paramString2 + "' failed", paramObject);
    }
  }
  
  private static class TbsCorePrivateClassLoader
    extends DexClassLoader
  {
    public TbsCorePrivateClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
    {
      super(paramString2, paramString3, paramClassLoader);
    }
    
    protected Class<?> loadClass(String paramString, boolean paramBoolean)
      throws ClassNotFoundException
    {
      if (paramString != null)
      {
        boolean bool2 = paramString.startsWith("org.chromium");
        boolean bool1 = bool2;
        Object localObject1;
        if (DexLoader.mMttClassUseCorePrivate)
        {
          if ((bool2) || (paramString.startsWith("com.tencent")) || (paramString.startsWith("com.taf"))) {
            bool1 = true;
          }
        }
        else
        {
          if (bool1) {
            break label66;
          }
          localObject1 = super.loadClass(paramString, paramBoolean);
        }
        label66:
        do
        {
          Object localObject2;
          do
          {
            do
            {
              return localObject1;
              bool1 = false;
              break;
              localObject2 = findLoadedClass(paramString);
              localObject1 = localObject2;
            } while (localObject2 != null);
            try
            {
              Log.d("DexLoader", "WebCoreClassLoader - loadClass(" + paramString + "," + paramBoolean + ")...");
              localObject1 = findClass(paramString);
              localObject2 = localObject1;
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              ClassLoader localClassLoader;
              break label132;
            }
            localObject1 = localObject2;
          } while (localObject2 != null);
          localClassLoader = getParent();
          localObject1 = localObject2;
        } while (localClassLoader == null);
        label132:
        return localClassLoader.loadClass(paramString);
      }
      else
      {
        return super.loadClass(paramString, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexLoader
 * JD-Core Version:    0.7.0.1
 */