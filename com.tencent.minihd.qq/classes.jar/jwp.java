import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.mobileqq.app.CoreService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.StatisticCollector.StatisticCallback;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqwifi.QQWiFiAssistService;
import cooperation.qzone.QzonePluginProxyService;
import java.util.ArrayList;
import java.util.Arrays;

public class jwp
  implements CrashHandleListener
{
  public jwp(StatisticCollector paramStatisticCollector) {}
  
  public byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  /* Error */
  public String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: ldc 24
    //   2: iconst_1
    //   3: new 26	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   10: ldc 29
    //   12: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: iload_1
    //   16: invokevirtual 36	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   19: ldc 38
    //   21: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_2
    //   25: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 40
    //   30: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_3
    //   34: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 42
    //   39: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload 4
    //   44: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 44
    //   49: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: iload 5
    //   54: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc 49
    //   59: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: lload 6
    //   64: invokevirtual 52	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   67: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: new 26	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   80: astore_3
    //   81: aload_3
    //   82: ldc 64
    //   84: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_3
    //   89: new 26	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   96: ldc 66
    //   98: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: getstatic 72	com/tencent/common/app/BaseApplicationImpl:sInjectResult	Ljava/lang/String;
    //   104: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_3
    //   115: new 26	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   122: ldc 74
    //   124: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: getstatic 76	com/tencent/common/app/BaseApplicationImpl:a	Ljava/lang/String;
    //   130: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_3
    //   141: new 26	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   148: ldc 78
    //   150: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: getstatic 81	com/tencent/common/app/BaseApplicationImpl:b	Ljava/lang/String;
    //   156: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_3
    //   167: new 26	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   174: ldc 83
    //   176: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: getstatic 89	com/tencent/mobileqq/startup/director/StartupDirector:c	I
    //   182: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: getstatic 94	com/tencent/mobileqq/util/WebpSoLoader:a	[I
    //   195: astore_2
    //   196: aload_2
    //   197: ifnull +50 -> 247
    //   200: aload_2
    //   201: arraylength
    //   202: iconst_3
    //   203: if_icmplt +44 -> 247
    //   206: aload_3
    //   207: ldc 96
    //   209: iconst_3
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_2
    //   216: iconst_0
    //   217: iaload
    //   218: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: aastore
    //   222: dup
    //   223: iconst_1
    //   224: aload_2
    //   225: iconst_1
    //   226: iaload
    //   227: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   230: aastore
    //   231: dup
    //   232: iconst_2
    //   233: aload_2
    //   234: iconst_2
    //   235: iaload
    //   236: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aastore
    //   240: invokestatic 108	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   243: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_3
    //   248: ldc 110
    //   250: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: invokestatic 114	com/tencent/mobileqq/statistics/StatisticCollector:a	()Ljava/lang/String;
    //   257: astore 4
    //   259: invokestatic 119	mqq/app/AppRuntime:showInfo	()Ljava/lang/String;
    //   262: astore 9
    //   264: new 26	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   271: ldc 121
    //   273: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: astore 10
    //   278: getstatic 127	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   281: ifnonnull +103 -> 384
    //   284: ldc 129
    //   286: astore_2
    //   287: aload 10
    //   289: aload_2
    //   290: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc 110
    //   295: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: astore_2
    //   302: new 26	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   309: astore 10
    //   311: aload_0
    //   312: getfield 12	jwp:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   315: invokestatic 132	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/Stack;
    //   318: invokevirtual 138	java/util/Stack:size	()I
    //   321: istore 8
    //   323: iload 8
    //   325: iconst_5
    //   326: invokestatic 144	java/lang/Math:min	(II)I
    //   329: istore 5
    //   331: iload 5
    //   333: ifle +61 -> 394
    //   336: aload_0
    //   337: getfield 12	jwp:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   340: invokestatic 132	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/Stack;
    //   343: invokevirtual 148	java/util/Stack:pop	()Ljava/lang/Object;
    //   346: checkcast 104	java/lang/String
    //   349: astore 11
    //   351: aload 10
    //   353: invokevirtual 151	java/lang/StringBuilder:length	()I
    //   356: ifle +11 -> 367
    //   359: aload 10
    //   361: ldc 153
    //   363: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 10
    //   369: aload 11
    //   371: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: iload 5
    //   377: iconst_1
    //   378: isub
    //   379: istore 5
    //   381: goto -50 -> 331
    //   384: getstatic 127	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   387: invokevirtual 154	java/lang/Object:toString	()Ljava/lang/String;
    //   390: astore_2
    //   391: goto -104 -> 287
    //   394: aload_0
    //   395: getfield 12	jwp:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   398: invokestatic 132	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/Stack;
    //   401: invokevirtual 157	java/util/Stack:clear	()V
    //   404: aload_3
    //   405: new 26	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   412: aload 4
    //   414: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: ldc 110
    //   419: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload_3
    //   430: new 26	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   437: aload 9
    //   439: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc 110
    //   444: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload_3
    //   455: aload_2
    //   456: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload_3
    //   461: new 26	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   468: ldc 159
    //   470: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: iload 8
    //   475: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   478: ldc 161
    //   480: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload_3
    //   491: new 26	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   498: aload 10
    //   500: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   503: ldc 110
    //   505: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload_3
    //   516: ldc 166
    //   518: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: pop
    //   522: aload_3
    //   523: aload_0
    //   524: getfield 12	jwp:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   527: invokestatic 169	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/HashMap;
    //   530: invokevirtual 172	java/util/HashMap:toString	()Ljava/lang/String;
    //   533: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload_3
    //   538: ldc 110
    //   540: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: getstatic 175	cooperation/qzone/QZoneCrashHandler:a	Ljava/lang/String;
    //   547: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   550: ifne +49 -> 599
    //   553: getstatic 186	android/os/Build$VERSION:SDK_INT	I
    //   556: bipush 8
    //   558: if_icmplt +41 -> 599
    //   561: aload_3
    //   562: new 26	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   569: ldc 188
    //   571: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: getstatic 175	cooperation/qzone/QZoneCrashHandler:a	Ljava/lang/String;
    //   577: invokevirtual 192	java/lang/String:getBytes	()[B
    //   580: iconst_0
    //   581: invokestatic 198	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   584: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: ldc 110
    //   589: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: getstatic 199	cooperation/qzone/QZoneCrashHandler:b	Ljava/lang/String;
    //   602: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   605: ifne +34 -> 639
    //   608: aload_3
    //   609: new 26	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   616: ldc 201
    //   618: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: getstatic 199	cooperation/qzone/QZoneCrashHandler:b	Ljava/lang/String;
    //   624: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: ldc 110
    //   629: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: pop
    //   639: aload_3
    //   640: invokestatic 206	cooperation/qzone/RDMEtraMsgCollector:a	()Lcooperation/qzone/RDMEtraMsgCollector;
    //   643: invokevirtual 207	cooperation/qzone/RDMEtraMsgCollector:a	()Ljava/lang/String;
    //   646: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload_3
    //   651: ldc 110
    //   653: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: pop
    //   657: aload_0
    //   658: getfield 12	jwp:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   661: invokestatic 210	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/LinkedList;
    //   664: invokevirtual 213	java/util/LinkedList:size	()I
    //   667: ifle +28 -> 695
    //   670: aload_3
    //   671: aload_0
    //   672: getfield 12	jwp:a	Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   675: invokestatic 210	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lcom/tencent/mobileqq/statistics/StatisticCollector;)Ljava/util/LinkedList;
    //   678: invokevirtual 216	java/util/LinkedList:removeLast	()Ljava/lang/Object;
    //   681: checkcast 218	jwq
    //   684: invokevirtual 219	jwq:toString	()Ljava/lang/String;
    //   687: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: goto -34 -> 657
    //   694: astore_2
    //   695: invokestatic 222	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   698: invokestatic 228	com/tencent/smtt/sdk/WebView:getTbsSDKVersion	(Landroid/content/Context;)I
    //   701: istore 5
    //   703: invokestatic 222	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   706: invokestatic 233	com/tencent/smtt/sdk/QbSdk:getTbsVersion	(Landroid/content/Context;)I
    //   709: istore 8
    //   711: aload_3
    //   712: bipush 10
    //   714: invokevirtual 236	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   717: ldc 238
    //   719: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: astore 4
    //   724: iload 8
    //   726: ifne +102 -> 828
    //   729: ldc 240
    //   731: astore_2
    //   732: aload 4
    //   734: aload_2
    //   735: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: ldc 242
    //   740: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: iload 5
    //   745: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   748: ldc 244
    //   750: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: iload 8
    //   755: invokevirtual 47	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: getstatic 247	com/tencent/common/app/BaseApplicationImpl:g	I
    //   762: iconst_3
    //   763: if_icmpne +32 -> 795
    //   766: aload_3
    //   767: new 26	java/lang/StringBuilder
    //   770: dup
    //   771: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   774: ldc 249
    //   776: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: invokestatic 222	com/tencent/mobileqq/statistics/StatisticCollector:a	()Landroid/content/Context;
    //   782: invokestatic 252	com/tencent/smtt/sdk/WebView:getCrashExtraMessage	(Landroid/content/Context;)Ljava/lang/String;
    //   785: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: ldc 24
    //   797: iconst_1
    //   798: new 26	java/lang/StringBuilder
    //   801: dup
    //   802: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   805: ldc 254
    //   807: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: aload_3
    //   811: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   814: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   820: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   823: aload_3
    //   824: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: areturn
    //   828: ldc_w 256
    //   831: astore_2
    //   832: goto -100 -> 732
    //   835: astore_2
    //   836: goto -41 -> 795
    //   839: astore_2
    //   840: goto -183 -> 657
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	843	0	this	jwp
    //   0	843	1	paramBoolean	boolean
    //   0	843	2	paramString1	String
    //   0	843	3	paramString2	String
    //   0	843	4	paramString3	String
    //   0	843	5	paramInt	int
    //   0	843	6	paramLong	long
    //   321	433	8	i	int
    //   262	176	9	str1	String
    //   276	223	10	localStringBuilder	java.lang.StringBuilder
    //   349	21	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   657	691	694	java/lang/Throwable
    //   695	724	835	java/lang/Throwable
    //   732	795	835	java/lang/Throwable
    //   81	196	839	java/lang/Throwable
    //   200	247	839	java/lang/Throwable
    //   247	284	839	java/lang/Throwable
    //   287	331	839	java/lang/Throwable
    //   336	367	839	java/lang/Throwable
    //   367	375	839	java/lang/Throwable
    //   384	391	839	java/lang/Throwable
    //   394	599	839	java/lang/Throwable
    //   599	639	839	java/lang/Throwable
    //   639	657	839	java/lang/Throwable
  }
  
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    QLog.d("StatisticCollector", 1, "onCrashHandleEnd...isNativeCrashed: " + paramBoolean);
    Object localObject1 = BaseApplicationImpl.processName;
    ArrayList localArrayList;
    if (((String)localObject1).equals("com.tencent.minihd.qq")) {
      try
      {
        localObject1 = new Intent("com.tencent.process.exit");
        localArrayList = new ArrayList(Arrays.asList(new String[] { "com.tencent.minihd.qq:qzone" }));
        ((Intent)localObject1).putStringArrayListExtra("procNameList", localArrayList);
        ((Intent)localObject1).putExtra("verify", BaseApplicationImpl.a(localArrayList, false));
        StatisticCollector.a().sendBroadcast((Intent)localObject1);
        CoreService.d();
        CoreService.b();
        if (paramBoolean) {
          BaseApplicationImpl.a().QQProcessExit(true);
        }
        return true;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        return true;
      }
    }
    if (localException1.endsWith(":qzone")) {
      try
      {
        Intent localIntent = new Intent("com.tencent.process.exit");
        localArrayList = new ArrayList(Arrays.asList(new String[] { "com.tencent.minihd.qq:picture", "com.tencent.minihd.qq:qzonevideo" }));
        localIntent.putStringArrayListExtra("procNameList", localArrayList);
        localIntent.putExtra("verify", BaseApplicationImpl.a(localArrayList, false));
        StatisticCollector.a().sendBroadcast(localIntent);
        localIntent = new Intent(StatisticCollector.a(), QzonePluginProxyService.class);
        StatisticCollector.a().stopService(localIntent);
        BaseApplicationImpl.a().otherProcessExit(false);
        return true;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        return true;
      }
    }
    Object localObject2;
    if (localException2.endsWith(":video"))
    {
      localObject2 = BaseApplicationImpl.a().a();
      if ((localObject2 != null) && ((localObject2 instanceof StatisticCollector.StatisticCallback))) {
        ((StatisticCollector.StatisticCallback)localObject2).a();
      }
      BaseApplicationImpl.a().otherProcessExit(false);
      return true;
    }
    if (((String)localObject2).endsWith(":qqwifi")) {
      try
      {
        localObject2 = new Intent(StatisticCollector.a(), QQWiFiAssistService.class);
        StatisticCollector.a().stopService((Intent)localObject2);
        BaseApplicationImpl.a().otherProcessExit(false);
        return true;
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
        return true;
      }
    }
    BaseApplicationImpl.a().otherProcessExit(false);
    return true;
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    QLog.d("StatisticCollector", 1, "onCrashHandleStart...isNativeCrashed: " + paramBoolean);
  }
  
  public boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    WebpSoLoader.a(paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     jwp
 * JD-Core Version:    0.7.0.1
 */