package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import java.io.File;

public class SignatureTemplateConfig
{
  public static final int a = 16;
  public static final String a = "vipSignature_common_data";
  public static final int b = 17;
  public static final String b = "vipSignature_item";
  public static final int c = 18;
  public static final int d = 19;
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.bo);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static SignatureTemplateConfig.SignatureTemplateType[] a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: new 58	java/util/LinkedHashMap
    //   3: dup
    //   4: invokespecial 59	java/util/LinkedHashMap:<init>	()V
    //   7: astore 7
    //   9: new 42	java/io/File
    //   12: dup
    //   13: getstatic 64	com/tencent/mobileqq/app/SignatureManager:f	Ljava/lang/String;
    //   16: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: invokestatic 70	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)Ljava/lang/String;
    //   22: astore_0
    //   23: new 72	org/json/JSONObject
    //   26: dup
    //   27: aload_0
    //   28: aload_0
    //   29: ldc 74
    //   31: invokevirtual 80	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   34: aload_0
    //   35: invokevirtual 84	java/lang/String:length	()I
    //   38: invokevirtual 88	java/lang/String:subSequence	(II)Ljava/lang/CharSequence;
    //   41: checkcast 76	java/lang/String
    //   44: invokespecial 89	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   47: ldc 91
    //   49: invokevirtual 95	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   52: astore_0
    //   53: aload_0
    //   54: ldc 97
    //   56: invokevirtual 101	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   59: astore 8
    //   61: iconst_0
    //   62: istore_3
    //   63: iload_3
    //   64: aload 8
    //   66: invokevirtual 104	org/json/JSONArray:length	()I
    //   69: if_icmpge +69 -> 138
    //   72: aload 8
    //   74: iload_3
    //   75: invokevirtual 107	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   78: astore 9
    //   80: new 109	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType
    //   83: dup
    //   84: invokespecial 110	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:<init>	()V
    //   87: astore 10
    //   89: aload 10
    //   91: aload 9
    //   93: ldc 112
    //   95: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   98: putfield 117	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_Int	I
    //   101: aload 10
    //   103: aload 9
    //   105: ldc 119
    //   107: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: putfield 125	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   113: aload 7
    //   115: aload 10
    //   117: getfield 117	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_Int	I
    //   120: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: aload 10
    //   125: invokeinterface 137 3 0
    //   130: pop
    //   131: iload_3
    //   132: iconst_1
    //   133: iadd
    //   134: istore_3
    //   135: goto -72 -> 63
    //   138: aload_0
    //   139: ldc 139
    //   141: invokevirtual 95	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   144: astore 8
    //   146: aload 8
    //   148: invokevirtual 143	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   151: astore 9
    //   153: aload 9
    //   155: invokeinterface 149 1 0
    //   160: ifeq +1218 -> 1378
    //   163: aload 8
    //   165: aload 9
    //   167: invokeinterface 153 1 0
    //   172: checkcast 76	java/lang/String
    //   175: invokevirtual 101	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   178: astore 10
    //   180: iconst_0
    //   181: istore 4
    //   183: iload 4
    //   185: aload 10
    //   187: invokevirtual 104	org/json/JSONArray:length	()I
    //   190: if_icmpge -37 -> 153
    //   193: aload 10
    //   195: iload 4
    //   197: invokevirtual 107	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   200: astore 12
    //   202: new 155	com/tencent/mobileqq/vas/SignatureTemplateInfo
    //   205: dup
    //   206: aload 12
    //   208: ldc 157
    //   210: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   213: invokespecial 158	com/tencent/mobileqq/vas/SignatureTemplateInfo:<init>	(Ljava/lang/String;)V
    //   216: astore 11
    //   218: aload 12
    //   220: ldc 91
    //   222: invokevirtual 101	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   225: astore 13
    //   227: iconst_0
    //   228: istore_3
    //   229: iload_3
    //   230: aload 13
    //   232: invokevirtual 104	org/json/JSONArray:length	()I
    //   235: if_icmpge +712 -> 947
    //   238: aload 13
    //   240: iload_3
    //   241: invokevirtual 107	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   244: astore 14
    //   246: aload 14
    //   248: ldc 160
    //   250: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   253: iconst_1
    //   254: if_icmpne +6 -> 260
    //   257: goto +1210 -> 1467
    //   260: aload 11
    //   262: aload 14
    //   264: ldc 162
    //   266: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   269: putfield 163	com/tencent/mobileqq/vas/SignatureTemplateInfo:f	Ljava/lang/String;
    //   272: aload 11
    //   274: getfield 163	com/tencent/mobileqq/vas/SignatureTemplateInfo:f	Ljava/lang/String;
    //   277: ldc 165
    //   279: invokevirtual 168	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   282: ifgt +1185 -> 1467
    //   285: aload 14
    //   287: ldc 170
    //   289: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   292: ifeq +612 -> 904
    //   295: aload 14
    //   297: ldc 170
    //   299: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   302: astore_0
    //   303: aload 11
    //   305: aload_0
    //   306: putfield 176	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   309: aload 14
    //   311: ldc 178
    //   313: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   316: ifeq +1158 -> 1474
    //   319: aload 14
    //   321: ldc 178
    //   323: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   326: istore 5
    //   328: aload 11
    //   330: iload 5
    //   332: putfield 180	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_b_of_type_Int	I
    //   335: aload 14
    //   337: ldc 182
    //   339: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   342: ifeq +1138 -> 1480
    //   345: aload 14
    //   347: ldc 182
    //   349: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   352: istore 5
    //   354: aload 11
    //   356: iload 5
    //   358: putfield 183	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_Int	I
    //   361: aload 14
    //   363: ldc 185
    //   365: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   368: ifeq +1118 -> 1486
    //   371: aload 14
    //   373: ldc 185
    //   375: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   378: astore_0
    //   379: aload 11
    //   381: aload_0
    //   382: putfield 187	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   385: aload 14
    //   387: ldc 189
    //   389: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   392: ifeq +1099 -> 1491
    //   395: aload 14
    //   397: ldc 189
    //   399: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   402: istore 5
    //   404: aload 11
    //   406: iload 5
    //   408: putfield 191	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_c_of_type_Int	I
    //   411: aload 11
    //   413: aload 14
    //   415: ldc 160
    //   417: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   420: putfield 193	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_d_of_type_Int	I
    //   423: aload 14
    //   425: ldc 195
    //   427: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   430: ifeq +1067 -> 1497
    //   433: aload 14
    //   435: ldc 195
    //   437: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   440: astore_0
    //   441: aload 11
    //   443: aload_0
    //   444: putfield 198	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   447: aload 11
    //   449: getfield 198	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   452: invokestatic 203	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   455: pop
    //   456: aload 14
    //   458: ldc 205
    //   460: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   463: ifeq +1041 -> 1504
    //   466: aload 14
    //   468: ldc 205
    //   470: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   473: astore_0
    //   474: aload 11
    //   476: aload_0
    //   477: putfield 208	com/tencent/mobileqq/vas/SignatureTemplateInfo:n	Ljava/lang/String;
    //   480: aload 14
    //   482: ldc 210
    //   484: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   487: ifeq +1024 -> 1511
    //   490: aload 14
    //   492: ldc 210
    //   494: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   497: astore_0
    //   498: aload 11
    //   500: aload_0
    //   501: putfield 213	com/tencent/mobileqq/vas/SignatureTemplateInfo:o	Ljava/lang/String;
    //   504: aload 11
    //   506: getfield 213	com/tencent/mobileqq/vas/SignatureTemplateInfo:o	Ljava/lang/String;
    //   509: invokestatic 203	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   512: pop
    //   513: aload 14
    //   515: ldc 215
    //   517: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   520: ifeq +998 -> 1518
    //   523: aload 14
    //   525: ldc 215
    //   527: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   530: astore_0
    //   531: aload 11
    //   533: aload_0
    //   534: putfield 218	com/tencent/mobileqq/vas/SignatureTemplateInfo:p	Ljava/lang/String;
    //   537: aload 11
    //   539: getfield 218	com/tencent/mobileqq/vas/SignatureTemplateInfo:p	Ljava/lang/String;
    //   542: invokestatic 203	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   545: pop
    //   546: aload 14
    //   548: ldc 220
    //   550: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   553: ifeq +972 -> 1525
    //   556: aload 14
    //   558: ldc 220
    //   560: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   563: istore 5
    //   565: aload 11
    //   567: iload 5
    //   569: putfield 222	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_Int	I
    //   572: aload 14
    //   574: ldc 224
    //   576: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   579: ifeq +952 -> 1531
    //   582: aload 14
    //   584: ldc 224
    //   586: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   589: astore_0
    //   590: aload 11
    //   592: aload_0
    //   593: putfield 227	com/tencent/mobileqq/vas/SignatureTemplateInfo:q	Ljava/lang/String;
    //   596: aload 14
    //   598: ldc 229
    //   600: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   603: ifeq +935 -> 1538
    //   606: aload 14
    //   608: ldc 229
    //   610: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   613: astore_0
    //   614: aload 11
    //   616: aload_0
    //   617: putfield 232	com/tencent/mobileqq/vas/SignatureTemplateInfo:r	Ljava/lang/String;
    //   620: aload 14
    //   622: ldc 234
    //   624: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   627: ifeq +918 -> 1545
    //   630: aload 14
    //   632: ldc 234
    //   634: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   637: astore_0
    //   638: aload 11
    //   640: aload_0
    //   641: putfield 237	com/tencent/mobileqq/vas/SignatureTemplateInfo:s	Ljava/lang/String;
    //   644: aload 14
    //   646: ldc 239
    //   648: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   651: ifeq +15 -> 666
    //   654: aload 11
    //   656: aload 14
    //   658: ldc 239
    //   660: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   663: putfield 241	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   666: aload 14
    //   668: ldc 243
    //   670: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   673: ifeq +15 -> 688
    //   676: aload 11
    //   678: aload 14
    //   680: ldc 243
    //   682: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   685: putfield 246	com/tencent/mobileqq/vas/SignatureTemplateInfo:g	Ljava/lang/String;
    //   688: aload 14
    //   690: ldc 248
    //   692: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   695: ifeq +15 -> 710
    //   698: aload 11
    //   700: aload 14
    //   702: ldc 248
    //   704: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   707: putfield 251	com/tencent/mobileqq/vas/SignatureTemplateInfo:h	Ljava/lang/String;
    //   710: aload 14
    //   712: ldc 253
    //   714: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   717: ifeq +15 -> 732
    //   720: aload 11
    //   722: aload 14
    //   724: ldc 253
    //   726: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   729: putfield 256	com/tencent/mobileqq/vas/SignatureTemplateInfo:i	Ljava/lang/String;
    //   732: aload 14
    //   734: ldc_w 258
    //   737: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   740: ifeq +16 -> 756
    //   743: aload 11
    //   745: aload 14
    //   747: ldc_w 258
    //   750: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   753: putfield 261	com/tencent/mobileqq/vas/SignatureTemplateInfo:j	Ljava/lang/String;
    //   756: aload 14
    //   758: ldc_w 263
    //   761: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   764: ifeq +16 -> 780
    //   767: aload 11
    //   769: aload 14
    //   771: ldc_w 263
    //   774: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   777: putfield 266	com/tencent/mobileqq/vas/SignatureTemplateInfo:k	Ljava/lang/String;
    //   780: aload 14
    //   782: ldc_w 268
    //   785: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   788: ifeq +16 -> 804
    //   791: aload 11
    //   793: aload 14
    //   795: ldc_w 268
    //   798: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   801: putfield 271	com/tencent/mobileqq/vas/SignatureTemplateInfo:l	Ljava/lang/String;
    //   804: aload 14
    //   806: ldc_w 273
    //   809: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   812: ifeq +655 -> 1467
    //   815: aload 11
    //   817: aload 14
    //   819: ldc_w 273
    //   822: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   825: putfield 276	com/tencent/mobileqq/vas/SignatureTemplateInfo:m	Ljava/lang/String;
    //   828: goto +639 -> 1467
    //   831: astore_0
    //   832: new 42	java/io/File
    //   835: dup
    //   836: getstatic 64	com/tencent/mobileqq/app/SignatureManager:f	Ljava/lang/String;
    //   839: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   842: astore 7
    //   844: aload 7
    //   846: invokevirtual 279	java/io/File:exists	()Z
    //   849: ifeq +17 -> 866
    //   852: aload 7
    //   854: invokevirtual 282	java/io/File:isFile	()Z
    //   857: ifeq +9 -> 866
    //   860: aload 7
    //   862: invokevirtual 285	java/io/File:delete	()Z
    //   865: pop
    //   866: invokestatic 290	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   869: ifeq +33 -> 902
    //   872: ldc_w 292
    //   875: iconst_2
    //   876: new 32	java/lang/StringBuilder
    //   879: dup
    //   880: invokespecial 293	java/lang/StringBuilder:<init>	()V
    //   883: ldc_w 295
    //   886: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: aload_0
    //   890: invokevirtual 298	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   893: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   899: invokestatic 301	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   902: aconst_null
    //   903: areturn
    //   904: ldc_w 303
    //   907: astore_0
    //   908: goto -605 -> 303
    //   911: astore_0
    //   912: aload 11
    //   914: ldc_w 305
    //   917: putfield 198	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   920: goto -464 -> 456
    //   923: astore_0
    //   924: aload 11
    //   926: ldc_w 305
    //   929: putfield 213	com/tencent/mobileqq/vas/SignatureTemplateInfo:o	Ljava/lang/String;
    //   932: goto -419 -> 513
    //   935: astore_0
    //   936: aload 11
    //   938: ldc_w 305
    //   941: putfield 218	com/tencent/mobileqq/vas/SignatureTemplateInfo:p	Ljava/lang/String;
    //   944: goto -398 -> 546
    //   947: aload 12
    //   949: ldc_w 307
    //   952: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   955: ifeq +387 -> 1342
    //   958: aload 12
    //   960: ldc_w 307
    //   963: invokevirtual 101	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   966: astore 12
    //   968: iconst_0
    //   969: istore 5
    //   971: iload 5
    //   973: aload 12
    //   975: invokevirtual 104	org/json/JSONArray:length	()I
    //   978: if_icmpge +364 -> 1342
    //   981: aload 12
    //   983: iload 5
    //   985: invokevirtual 107	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   988: astore 13
    //   990: aload 13
    //   992: ldc_w 309
    //   995: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   998: ifeq +580 -> 1578
    //   1001: aload 13
    //   1003: ldc_w 309
    //   1006: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1009: istore_3
    //   1010: goto +542 -> 1552
    //   1013: aload 11
    //   1015: getfield 312	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1018: astore_0
    //   1019: iload_3
    //   1020: ifne +563 -> 1583
    //   1023: iload_3
    //   1024: istore 6
    //   1026: aload_0
    //   1027: iload 6
    //   1029: aaload
    //   1030: iload_3
    //   1031: putfield 315	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_Int	I
    //   1034: aload 11
    //   1036: getfield 312	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1039: astore_0
    //   1040: iload_3
    //   1041: ifne +550 -> 1591
    //   1044: iload_3
    //   1045: istore 6
    //   1047: aload_0
    //   1048: iload 6
    //   1050: aaload
    //   1051: astore 14
    //   1053: aload 13
    //   1055: ldc_w 317
    //   1058: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1061: ifeq +538 -> 1599
    //   1064: aload 13
    //   1066: ldc_w 317
    //   1069: invokevirtual 123	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1072: astore_0
    //   1073: aload 14
    //   1075: aload_0
    //   1076: putfield 318	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1079: aload 11
    //   1081: getfield 312	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1084: astore_0
    //   1085: iload_3
    //   1086: ifne +520 -> 1606
    //   1089: iload_3
    //   1090: istore 6
    //   1092: aload_0
    //   1093: iload 6
    //   1095: aaload
    //   1096: astore_0
    //   1097: aload 13
    //   1099: ldc_w 320
    //   1102: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1105: ifeq +509 -> 1614
    //   1108: aload 13
    //   1110: ldc_w 320
    //   1113: invokevirtual 324	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1116: dstore_1
    //   1117: aload_0
    //   1118: dload_1
    //   1119: d2f
    //   1120: putfield 327	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_a_of_type_Float	F
    //   1123: aload 11
    //   1125: getfield 312	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1128: astore_0
    //   1129: iload_3
    //   1130: ifne +489 -> 1619
    //   1133: iload_3
    //   1134: istore 6
    //   1136: aload_0
    //   1137: iload 6
    //   1139: aaload
    //   1140: astore_0
    //   1141: aload 13
    //   1143: ldc_w 329
    //   1146: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1149: ifeq +478 -> 1627
    //   1152: aload 13
    //   1154: ldc_w 329
    //   1157: invokevirtual 324	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1160: dstore_1
    //   1161: aload_0
    //   1162: dload_1
    //   1163: d2f
    //   1164: putfield 331	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_b_of_type_Float	F
    //   1167: aload 11
    //   1169: getfield 312	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1172: astore_0
    //   1173: iload_3
    //   1174: ifne +458 -> 1632
    //   1177: iload_3
    //   1178: istore 6
    //   1180: aload_0
    //   1181: iload 6
    //   1183: aaload
    //   1184: astore_0
    //   1185: aload 13
    //   1187: ldc_w 333
    //   1190: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1193: ifeq +447 -> 1640
    //   1196: aload 13
    //   1198: ldc_w 333
    //   1201: invokevirtual 324	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1204: dstore_1
    //   1205: aload_0
    //   1206: dload_1
    //   1207: d2f
    //   1208: putfield 335	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_c_of_type_Float	F
    //   1211: aload 11
    //   1213: getfield 312	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1216: astore_0
    //   1217: iload_3
    //   1218: ifne +427 -> 1645
    //   1221: iload_3
    //   1222: istore 6
    //   1224: aload_0
    //   1225: iload 6
    //   1227: aaload
    //   1228: astore_0
    //   1229: aload 13
    //   1231: ldc_w 337
    //   1234: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1237: ifeq +416 -> 1653
    //   1240: aload 13
    //   1242: ldc_w 337
    //   1245: invokevirtual 324	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   1248: dstore_1
    //   1249: aload_0
    //   1250: dload_1
    //   1251: d2f
    //   1252: putfield 339	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:d	F
    //   1255: aload 11
    //   1257: getfield 312	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1260: astore_0
    //   1261: iload_3
    //   1262: ifne +396 -> 1658
    //   1265: iload_3
    //   1266: istore 6
    //   1268: aload_0
    //   1269: iload 6
    //   1271: aaload
    //   1272: astore_0
    //   1273: aload 13
    //   1275: ldc_w 341
    //   1278: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1281: ifeq +385 -> 1666
    //   1284: aload 13
    //   1286: ldc_w 341
    //   1289: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1292: istore 6
    //   1294: aload_0
    //   1295: iload 6
    //   1297: putfield 342	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_b_of_type_Int	I
    //   1300: aload 11
    //   1302: getfield 312	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_a_of_type_ArrayOfComTencentMobileqqVasSignatureTemplateInfo$DynamicItem	[Lcom/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem;
    //   1305: astore_0
    //   1306: iload_3
    //   1307: ifne +365 -> 1672
    //   1310: aload_0
    //   1311: iload_3
    //   1312: aaload
    //   1313: astore_0
    //   1314: aload 13
    //   1316: ldc_w 344
    //   1319: invokevirtual 174	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1322: ifeq +357 -> 1679
    //   1325: aload 13
    //   1327: ldc_w 344
    //   1330: invokevirtual 115	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1333: istore_3
    //   1334: aload_0
    //   1335: iload_3
    //   1336: putfield 345	com/tencent/mobileqq/vas/SignatureTemplateInfo$DynamicItem:jdField_c_of_type_Int	I
    //   1339: goto +230 -> 1569
    //   1342: aload 7
    //   1344: aload 11
    //   1346: getfield 180	com/tencent/mobileqq/vas/SignatureTemplateInfo:jdField_b_of_type_Int	I
    //   1349: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1352: invokeinterface 349 2 0
    //   1357: checkcast 109	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType
    //   1360: astore_0
    //   1361: aload_0
    //   1362: ifnull +322 -> 1684
    //   1365: aload_0
    //   1366: getfield 352	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1369: aload 11
    //   1371: invokevirtual 358	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1374: pop
    //   1375: goto +309 -> 1684
    //   1378: aload 7
    //   1380: invokeinterface 362 1 0
    //   1385: invokeinterface 367 1 0
    //   1390: astore_0
    //   1391: aload_0
    //   1392: invokeinterface 149 1 0
    //   1397: ifeq +38 -> 1435
    //   1400: aload_0
    //   1401: invokeinterface 153 1 0
    //   1406: checkcast 369	java/util/Map$Entry
    //   1409: invokeinterface 372 1 0
    //   1414: checkcast 109	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType
    //   1417: getfield 352	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1420: invokevirtual 375	java/util/ArrayList:size	()I
    //   1423: ifne -32 -> 1391
    //   1426: aload_0
    //   1427: invokeinterface 378 1 0
    //   1432: goto -41 -> 1391
    //   1435: aload 7
    //   1437: invokeinterface 382 1 0
    //   1442: invokeinterface 385 1 0
    //   1447: anewarray 109	com/tencent/mobileqq/vas/SignatureTemplateConfig$SignatureTemplateType
    //   1450: astore_0
    //   1451: aload 7
    //   1453: invokeinterface 382 1 0
    //   1458: aload_0
    //   1459: invokeinterface 389 2 0
    //   1464: pop
    //   1465: aload_0
    //   1466: areturn
    //   1467: iload_3
    //   1468: iconst_1
    //   1469: iadd
    //   1470: istore_3
    //   1471: goto -1242 -> 229
    //   1474: iconst_m1
    //   1475: istore 5
    //   1477: goto -1149 -> 328
    //   1480: iconst_1
    //   1481: istore 5
    //   1483: goto -1129 -> 354
    //   1486: aconst_null
    //   1487: astore_0
    //   1488: goto -1109 -> 379
    //   1491: iconst_0
    //   1492: istore 5
    //   1494: goto -1090 -> 404
    //   1497: ldc_w 305
    //   1500: astore_0
    //   1501: goto -1060 -> 441
    //   1504: ldc_w 305
    //   1507: astore_0
    //   1508: goto -1034 -> 474
    //   1511: ldc_w 305
    //   1514: astore_0
    //   1515: goto -1017 -> 498
    //   1518: ldc_w 305
    //   1521: astore_0
    //   1522: goto -991 -> 531
    //   1525: iconst_1
    //   1526: istore 5
    //   1528: goto -963 -> 565
    //   1531: ldc_w 305
    //   1534: astore_0
    //   1535: goto -945 -> 590
    //   1538: ldc_w 305
    //   1541: astore_0
    //   1542: goto -928 -> 614
    //   1545: ldc_w 305
    //   1548: astore_0
    //   1549: goto -911 -> 638
    //   1552: iload_3
    //   1553: ifeq -540 -> 1013
    //   1556: iload_3
    //   1557: iconst_1
    //   1558: if_icmple +11 -> 1569
    //   1561: iload_3
    //   1562: iconst_5
    //   1563: if_icmpge +6 -> 1569
    //   1566: goto -553 -> 1013
    //   1569: iload 5
    //   1571: iconst_1
    //   1572: iadd
    //   1573: istore 5
    //   1575: goto -604 -> 971
    //   1578: iconst_m1
    //   1579: istore_3
    //   1580: goto -28 -> 1552
    //   1583: iload_3
    //   1584: iconst_1
    //   1585: isub
    //   1586: istore 6
    //   1588: goto -562 -> 1026
    //   1591: iload_3
    //   1592: iconst_1
    //   1593: isub
    //   1594: istore 6
    //   1596: goto -549 -> 1047
    //   1599: ldc_w 305
    //   1602: astore_0
    //   1603: goto -530 -> 1073
    //   1606: iload_3
    //   1607: iconst_1
    //   1608: isub
    //   1609: istore 6
    //   1611: goto -519 -> 1092
    //   1614: dconst_0
    //   1615: dstore_1
    //   1616: goto -499 -> 1117
    //   1619: iload_3
    //   1620: iconst_1
    //   1621: isub
    //   1622: istore 6
    //   1624: goto -488 -> 1136
    //   1627: dconst_0
    //   1628: dstore_1
    //   1629: goto -468 -> 1161
    //   1632: iload_3
    //   1633: iconst_1
    //   1634: isub
    //   1635: istore 6
    //   1637: goto -457 -> 1180
    //   1640: dconst_0
    //   1641: dstore_1
    //   1642: goto -437 -> 1205
    //   1645: iload_3
    //   1646: iconst_1
    //   1647: isub
    //   1648: istore 6
    //   1650: goto -426 -> 1224
    //   1653: dconst_0
    //   1654: dstore_1
    //   1655: goto -406 -> 1249
    //   1658: iload_3
    //   1659: iconst_1
    //   1660: isub
    //   1661: istore 6
    //   1663: goto -395 -> 1268
    //   1666: iconst_0
    //   1667: istore 6
    //   1669: goto -375 -> 1294
    //   1672: iload_3
    //   1673: iconst_1
    //   1674: isub
    //   1675: istore_3
    //   1676: goto -366 -> 1310
    //   1679: iconst_0
    //   1680: istore_3
    //   1681: goto -347 -> 1334
    //   1684: iload 4
    //   1686: iconst_1
    //   1687: iadd
    //   1688: istore 4
    //   1690: goto -1507 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1693	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   1116	539	1	d1	double
    //   62	1619	3	i	int
    //   181	1508	4	j	int
    //   326	1248	5	k	int
    //   1024	644	6	m	int
    //   7	1445	7	localObject1	Object
    //   59	105	8	localObject2	Object
    //   78	88	9	localObject3	Object
    //   87	107	10	localObject4	Object
    //   216	1154	11	localSignatureTemplateInfo	SignatureTemplateInfo
    //   200	782	12	localObject5	Object
    //   225	1101	13	localObject6	Object
    //   244	830	14	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	61	831	java/lang/Exception
    //   63	131	831	java/lang/Exception
    //   138	153	831	java/lang/Exception
    //   153	180	831	java/lang/Exception
    //   183	227	831	java/lang/Exception
    //   229	257	831	java/lang/Exception
    //   260	303	831	java/lang/Exception
    //   303	328	831	java/lang/Exception
    //   328	354	831	java/lang/Exception
    //   354	379	831	java/lang/Exception
    //   379	404	831	java/lang/Exception
    //   404	441	831	java/lang/Exception
    //   441	447	831	java/lang/Exception
    //   456	474	831	java/lang/Exception
    //   474	498	831	java/lang/Exception
    //   498	504	831	java/lang/Exception
    //   513	531	831	java/lang/Exception
    //   531	537	831	java/lang/Exception
    //   546	565	831	java/lang/Exception
    //   565	590	831	java/lang/Exception
    //   590	614	831	java/lang/Exception
    //   614	638	831	java/lang/Exception
    //   638	666	831	java/lang/Exception
    //   666	688	831	java/lang/Exception
    //   688	710	831	java/lang/Exception
    //   710	732	831	java/lang/Exception
    //   732	756	831	java/lang/Exception
    //   756	780	831	java/lang/Exception
    //   780	804	831	java/lang/Exception
    //   804	828	831	java/lang/Exception
    //   912	920	831	java/lang/Exception
    //   924	932	831	java/lang/Exception
    //   936	944	831	java/lang/Exception
    //   947	968	831	java/lang/Exception
    //   971	1010	831	java/lang/Exception
    //   1013	1019	831	java/lang/Exception
    //   1026	1040	831	java/lang/Exception
    //   1053	1073	831	java/lang/Exception
    //   1073	1085	831	java/lang/Exception
    //   1097	1117	831	java/lang/Exception
    //   1117	1129	831	java/lang/Exception
    //   1141	1161	831	java/lang/Exception
    //   1161	1173	831	java/lang/Exception
    //   1185	1205	831	java/lang/Exception
    //   1205	1217	831	java/lang/Exception
    //   1229	1249	831	java/lang/Exception
    //   1249	1261	831	java/lang/Exception
    //   1273	1294	831	java/lang/Exception
    //   1294	1306	831	java/lang/Exception
    //   1314	1334	831	java/lang/Exception
    //   1334	1339	831	java/lang/Exception
    //   1342	1361	831	java/lang/Exception
    //   1365	1375	831	java/lang/Exception
    //   1378	1391	831	java/lang/Exception
    //   1391	1432	831	java/lang/Exception
    //   1435	1465	831	java/lang/Exception
    //   447	456	911	java/lang/Exception
    //   504	513	923	java/lang/Exception
    //   537	546	935	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vas.SignatureTemplateConfig
 * JD-Core Version:    0.7.0.1
 */