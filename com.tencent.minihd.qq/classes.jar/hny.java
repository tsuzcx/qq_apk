import AvatarInfo.QQHeadInfo;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class hny
{
  private static final int jdField_a_of_type_Int = 30000;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "Q.qqhead.dh";
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130838508, 2130842100, 2130842101, 2130842102 };
  private byte jdField_a_of_type_Byte;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private hob[] jdField_a_of_type_ArrayOfHob = null;
  private int b = 2;
  private int c = 10;
  private int d = 4;
  private int e = 2;
  private int f = this.e;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j;
  
  public hny(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = paramFriendListHandler;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (NetworkUtil.g(paramQQAppInterface.a()))
    {
      this.f = this.d;
      this.j = a();
      switch (this.j)
      {
      }
    }
    for (;;)
    {
      this.h = this.f;
      this.jdField_a_of_type_ArrayOfHob = new hob[this.f];
      while (k < this.jdField_a_of_type_ArrayOfHob.length)
      {
        this.jdField_a_of_type_ArrayOfHob[k] = new hob(this, k);
        this.jdField_a_of_type_ArrayOfHob[k].start();
        k += 1;
      }
      this.f = this.e;
      break;
      this.jdField_a_of_type_Byte = 3;
      continue;
      this.jdField_a_of_type_Byte = 2;
      continue;
      this.jdField_a_of_type_Byte = 0;
    }
  }
  
  private int a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
    int k = Math.min(localBaseApplicationImpl.getResources().getDisplayMetrics().widthPixels, localBaseApplicationImpl.getResources().getDisplayMetrics().heightPixels);
    if (k > 720) {}
    while (k > 640) {
      return 100;
    }
    return 40;
  }
  
  private String a(String paramString, byte paramByte1, byte paramByte2)
  {
    if (paramByte2 == 32) {}
    for (paramByte2 = 140;; paramByte2 = a(paramByte1)) {
      return paramString + paramByte2;
    }
  }
  
  private void a(int paramInt, File paramFile)
  {
    int k;
    if (paramInt >= 0)
    {
      k = paramInt;
      if (paramInt < jdField_a_of_type_ArrayOfInt.length) {}
    }
    else
    {
      k = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dh", 2, "writeTroopSystemHead. systemFaceId=" + k);
    }
    InputStream localInputStream = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().openRawResource(jdField_a_of_type_ArrayOfInt[k]);
    byte[] arrayOfByte = new byte[512];
    paramFile = new FileOutputStream(paramFile);
    for (;;)
    {
      paramInt = localInputStream.read(arrayOfByte);
      if (paramInt <= 0) {
        break;
      }
      paramFile.write(arrayOfByte, 0, paramInt);
    }
    paramFile.close();
    localInputStream.close();
  }
  
  /* Error */
  private void a(hoa paramhoa)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 199	hoa:jdField_a_of_type_AvatarInfoQQHeadInfo	LAvatarInfo/QQHeadInfo;
    //   4: astore 24
    //   6: aload_1
    //   7: getfield 202	hoa:jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg	Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   10: astore 26
    //   12: aload_0
    //   13: getfield 63	hny:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   16: aload 24
    //   18: getfield 208	AvatarInfo/QQHeadInfo:uin	J
    //   21: aload 24
    //   23: getfield 211	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   26: invokevirtual 216	com/tencent/mobileqq/app/FriendListHandler:a	(JLjava/lang/String;)Ljava/lang/String;
    //   29: astore 23
    //   31: iconst_0
    //   32: istore 10
    //   34: iconst_0
    //   35: istore 15
    //   37: iconst_0
    //   38: istore 9
    //   40: iconst_0
    //   41: istore 13
    //   43: iconst_0
    //   44: istore 14
    //   46: iconst_0
    //   47: istore 12
    //   49: aload 24
    //   51: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   54: astore_1
    //   55: iconst_0
    //   56: istore 6
    //   58: iconst_0
    //   59: istore 4
    //   61: iconst_0
    //   62: istore_3
    //   63: aload_0
    //   64: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   67: invokevirtual 222	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   70: invokevirtual 228	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   73: astore 25
    //   75: iload 15
    //   77: istore 11
    //   79: aload 24
    //   81: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   84: ifnull +2550 -> 2634
    //   87: iload 15
    //   89: istore 11
    //   91: ldc 230
    //   93: aload 24
    //   95: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   98: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   101: ifne +2533 -> 2634
    //   104: iconst_1
    //   105: istore_2
    //   106: iload 15
    //   108: istore 11
    //   110: aload 24
    //   112: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   115: iconst_4
    //   116: if_icmpne +1099 -> 1215
    //   119: iload 15
    //   121: istore 11
    //   123: new 128	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   130: ldc 241
    //   132: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 23
    //   137: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: astore 20
    //   145: iload 15
    //   147: istore 11
    //   149: aload 25
    //   151: ldc 243
    //   153: aload 20
    //   155: invokevirtual 248	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   158: checkcast 243	com/tencent/mobileqq/data/Setting
    //   161: astore 21
    //   163: aload 21
    //   165: ifnonnull +2455 -> 2620
    //   168: iload 15
    //   170: istore 11
    //   172: new 243	com/tencent/mobileqq/data/Setting
    //   175: dup
    //   176: invokespecial 249	com/tencent/mobileqq/data/Setting:<init>	()V
    //   179: astore 21
    //   181: iload 15
    //   183: istore 11
    //   185: aload 21
    //   187: aload 20
    //   189: putfield 251	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   192: iconst_1
    //   193: istore 10
    //   195: iconst_0
    //   196: istore_2
    //   197: iload 10
    //   199: istore 11
    //   201: aload 21
    //   203: aload 24
    //   205: getfield 254	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   208: putfield 257	com/tencent/mobileqq/data/Setting:bFaceFlags	B
    //   211: iload 10
    //   213: istore 11
    //   215: aload 21
    //   217: aload 24
    //   219: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   222: putfield 260	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   225: iload 10
    //   227: istore 11
    //   229: aload 21
    //   231: aload 24
    //   233: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   236: putfield 263	com/tencent/mobileqq/data/Setting:url	Ljava/lang/String;
    //   239: iload 10
    //   241: istore 11
    //   243: aload 21
    //   245: invokestatic 269	java/lang/System:currentTimeMillis	()J
    //   248: putfield 272	com/tencent/mobileqq/data/Setting:updateTimestamp	J
    //   251: iload 10
    //   253: istore 11
    //   255: aload 24
    //   257: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   260: ifne +1016 -> 1276
    //   263: iload 10
    //   265: istore 11
    //   267: aload 21
    //   269: iconst_0
    //   270: putfield 278	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   273: iload 10
    //   275: istore 9
    //   277: iload 10
    //   279: ifne +136 -> 415
    //   282: iload 10
    //   284: istore 11
    //   286: aload 21
    //   288: getfield 281	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   291: aload 24
    //   293: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   296: if_icmpeq +1288 -> 1584
    //   299: iconst_1
    //   300: istore 10
    //   302: iload 10
    //   304: istore 9
    //   306: iload 10
    //   308: ifeq +107 -> 415
    //   311: iload 10
    //   313: istore 9
    //   315: iload 10
    //   317: istore 11
    //   319: aload 21
    //   321: getfield 281	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   324: iconst_1
    //   325: if_icmpne +90 -> 415
    //   328: iload 10
    //   330: istore 9
    //   332: iload 10
    //   334: istore 11
    //   336: aload 24
    //   338: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   341: ifne +74 -> 415
    //   344: iload 10
    //   346: istore 11
    //   348: new 283	java/io/File
    //   351: dup
    //   352: aload_0
    //   353: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   356: aload 21
    //   358: getfield 260	com/tencent/mobileqq/data/Setting:bUsrType	B
    //   361: aload 23
    //   363: aload 24
    //   365: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   368: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   371: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   374: astore 20
    //   376: iload 10
    //   378: istore 9
    //   380: aload 20
    //   382: ifnull +33 -> 415
    //   385: iload 10
    //   387: istore 9
    //   389: iload 10
    //   391: istore 11
    //   393: aload 20
    //   395: invokevirtual 295	java/io/File:exists	()Z
    //   398: ifeq +17 -> 415
    //   401: iload 10
    //   403: istore 11
    //   405: aload 20
    //   407: invokevirtual 298	java/io/File:delete	()Z
    //   410: pop
    //   411: iload 10
    //   413: istore 9
    //   415: aload 21
    //   417: aload 24
    //   419: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   422: putfield 281	com/tencent/mobileqq/data/Setting:bHeadType	B
    //   425: aload 21
    //   427: aload 24
    //   429: getfield 302	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   432: putfield 303	com/tencent/mobileqq/data/Setting:systemHeadID	S
    //   435: aload 21
    //   437: aload 24
    //   439: getfield 306	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   442: putfield 309	com/tencent/mobileqq/data/Setting:headImgTimestamp	J
    //   445: aload_0
    //   446: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   449: aload 21
    //   451: invokevirtual 312	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/data/Setting;)V
    //   454: iload_2
    //   455: ifeq +1210 -> 1665
    //   458: aload 25
    //   460: aload 21
    //   462: invokevirtual 315	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   465: pop
    //   466: aload_0
    //   467: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   470: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   473: invokevirtual 321	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   476: invokestatic 325	com/tencent/mobileqq/utils/ContactConfig:a	(Landroid/content/Context;)Z
    //   479: ifeq +109 -> 588
    //   482: invokestatic 329	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   485: ifeq +103 -> 588
    //   488: getstatic 39	hny:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   491: astore 20
    //   493: aload 20
    //   495: monitorenter
    //   496: aload_0
    //   497: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   500: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   503: invokevirtual 321	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   506: invokestatic 325	com/tencent/mobileqq/utils/ContactConfig:a	(Landroid/content/Context;)Z
    //   509: ifeq +62 -> 571
    //   512: invokestatic 329	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   515: istore 10
    //   517: iload 10
    //   519: ifeq +52 -> 571
    //   522: new 128	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   529: getstatic 331	com/tencent/mobileqq/util/SystemUtil:a	Ljava/lang/String;
    //   532: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: ldc_w 333
    //   538: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: new 128	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   551: getstatic 338	com/tencent/mobileqq/app/AppConstants:aG	Ljava/lang/String;
    //   554: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: ldc_w 333
    //   560: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: iconst_1
    //   567: invokestatic 343	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)I
    //   570: pop
    //   571: aload_0
    //   572: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   575: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   578: invokevirtual 321	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   581: iconst_0
    //   582: invokestatic 346	com/tencent/mobileqq/utils/ContactConfig:a	(Landroid/content/Context;Z)V
    //   585: aload 20
    //   587: monitorexit
    //   588: aload_0
    //   589: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   592: aload 24
    //   594: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   597: aload 23
    //   599: aload 24
    //   601: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   604: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   607: astore 20
    //   609: new 283	java/io/File
    //   612: dup
    //   613: aload 20
    //   615: invokespecial 292	java/io/File:<init>	(Ljava/lang/String;)V
    //   618: astore 27
    //   620: iload 9
    //   622: ifne +1991 -> 2613
    //   625: aload 27
    //   627: invokevirtual 295	java/io/File:exists	()Z
    //   630: istore 10
    //   632: iload 10
    //   634: ifne +1080 -> 1714
    //   637: iconst_1
    //   638: istore 9
    //   640: iload 9
    //   642: istore 10
    //   644: iload 10
    //   646: ifeq +1956 -> 2602
    //   649: aload_0
    //   650: aload 24
    //   652: getfield 219	AvatarInfo/QQHeadInfo:downLoadUrl	Ljava/lang/String;
    //   655: aload 24
    //   657: getfield 254	AvatarInfo/QQHeadInfo:dwFaceFlgas	B
    //   660: aload 24
    //   662: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   665: invokespecial 348	hny:a	(Ljava/lang/String;BB)Ljava/lang/String;
    //   668: astore 22
    //   670: aload 22
    //   672: astore_1
    //   673: ldc_w 350
    //   676: aload 22
    //   678: invokestatic 356	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   681: astore 22
    //   683: aload 22
    //   685: astore_1
    //   686: aload 24
    //   688: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   691: bipush 32
    //   693: if_icmpne +1903 -> 2596
    //   696: aload 22
    //   698: astore_1
    //   699: new 128	java/lang/StringBuilder
    //   702: dup
    //   703: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   706: aload 22
    //   708: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: ldc_w 358
    //   714: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: invokestatic 269	java/lang/System:currentTimeMillis	()J
    //   720: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   723: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: astore 22
    //   728: aload 22
    //   730: astore_1
    //   731: iload 14
    //   733: istore 11
    //   735: iload 4
    //   737: istore 5
    //   739: aload 24
    //   741: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   744: ifne +1085 -> 1829
    //   747: iload 14
    //   749: istore 11
    //   751: iload 4
    //   753: istore 5
    //   755: aload 24
    //   757: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   760: istore_2
    //   761: iload_2
    //   762: iconst_4
    //   763: if_icmpne +1066 -> 1829
    //   766: iload 14
    //   768: istore 11
    //   770: iload 4
    //   772: istore 5
    //   774: aload 27
    //   776: invokevirtual 295	java/io/File:exists	()Z
    //   779: ifne +22 -> 801
    //   782: iload 14
    //   784: istore 11
    //   786: iload 4
    //   788: istore 5
    //   790: aload_0
    //   791: aload 24
    //   793: getfield 302	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   796: aload 27
    //   798: invokespecial 363	hny:a	(ILjava/io/File;)V
    //   801: iconst_1
    //   802: istore 9
    //   804: iconst_0
    //   805: istore 4
    //   807: iload 9
    //   809: ifeq +1574 -> 2383
    //   812: iload 9
    //   814: istore 11
    //   816: iload_3
    //   817: istore 5
    //   819: aload 24
    //   821: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   824: bipush 32
    //   826: if_icmpne +1458 -> 2284
    //   829: iload 9
    //   831: istore 11
    //   833: iload_3
    //   834: istore 5
    //   836: new 128	java/lang/StringBuilder
    //   839: dup
    //   840: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   843: ldc_w 365
    //   846: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: aload 24
    //   851: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   854: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   857: ldc_w 367
    //   860: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: aload 23
    //   865: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: astore 22
    //   873: iload 9
    //   875: istore 11
    //   877: iload_3
    //   878: istore 5
    //   880: aload 22
    //   882: invokestatic 372	com/tencent/mobileqq/util/ProfileCardUtil:a	(Ljava/lang/String;)Z
    //   885: pop
    //   886: iload 9
    //   888: istore 11
    //   890: iload_3
    //   891: istore 5
    //   893: aload_0
    //   894: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   897: aload 22
    //   899: invokestatic 375	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   902: iload 9
    //   904: istore 11
    //   906: iload_3
    //   907: istore 5
    //   909: aload 24
    //   911: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   914: iconst_4
    //   915: if_icmpne +1401 -> 2316
    //   918: iload 9
    //   920: istore 11
    //   922: iload_3
    //   923: istore 5
    //   925: aload_0
    //   926: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   929: iconst_4
    //   930: aload 23
    //   932: aload 24
    //   934: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   937: invokevirtual 378	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)V
    //   940: iload_3
    //   941: istore_2
    //   942: iload 9
    //   944: ifeq +34 -> 978
    //   947: aload 24
    //   949: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   952: bipush 11
    //   954: if_icmpne +1434 -> 2388
    //   957: aload_0
    //   958: getfield 63	hny:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   961: aload 26
    //   963: bipush 39
    //   965: iconst_1
    //   966: iconst_1
    //   967: anewarray 4	java/lang/Object
    //   970: dup
    //   971: iconst_0
    //   972: aload 23
    //   974: aastore
    //   975: invokevirtual 381	com/tencent/mobileqq/app/FriendListHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;IZLjava/lang/Object;)V
    //   978: aload_0
    //   979: getfield 63	hny:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   982: bipush 45
    //   984: iconst_1
    //   985: aload 21
    //   987: invokevirtual 384	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   990: new 128	java/lang/StringBuilder
    //   993: dup
    //   994: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   997: aload 24
    //   999: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1002: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1005: ldc_w 367
    //   1008: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: aload 23
    //   1013: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1019: astore 21
    //   1021: aload 24
    //   1023: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1026: bipush 32
    //   1028: if_icmpne +43 -> 1071
    //   1031: new 128	java/lang/StringBuilder
    //   1034: dup
    //   1035: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1038: ldc_w 365
    //   1041: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: aload 24
    //   1046: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   1049: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1052: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: ldc_w 367
    //   1058: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: aload 23
    //   1063: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1069: astore 21
    //   1071: aload_0
    //   1072: getfield 63	hny:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   1075: aload 21
    //   1077: iconst_1
    //   1078: invokevirtual 391	com/tencent/mobileqq/app/FriendListHandler:b	(Ljava/lang/String;Z)V
    //   1081: aload 25
    //   1083: invokevirtual 393	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1086: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1089: ifeq +125 -> 1214
    //   1092: ldc 11
    //   1094: iconst_2
    //   1095: new 128	java/lang/StringBuilder
    //   1098: dup
    //   1099: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1102: ldc_w 395
    //   1105: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: iload 9
    //   1110: invokevirtual 398	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1113: ldc_w 400
    //   1116: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: iload 4
    //   1121: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1124: ldc_w 402
    //   1127: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1130: aload 24
    //   1132: getfield 208	AvatarInfo/QQHeadInfo:uin	J
    //   1135: invokevirtual 361	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1138: ldc_w 404
    //   1141: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1144: iload 10
    //   1146: invokevirtual 398	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1149: ldc_w 406
    //   1152: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: aload 24
    //   1157: getfield 211	AvatarInfo/QQHeadInfo:phoneNum	Ljava/lang/String;
    //   1160: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1163: ldc_w 408
    //   1166: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1169: aload 24
    //   1171: getfield 302	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   1174: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1177: ldc_w 410
    //   1180: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: iload_2
    //   1184: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1187: ldc_w 412
    //   1190: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: aload 20
    //   1195: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: ldc_w 414
    //   1201: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: aload_1
    //   1205: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1208: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1211: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1214: return
    //   1215: iload 15
    //   1217: istore 11
    //   1219: aload 24
    //   1221: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1224: bipush 32
    //   1226: if_icmpne +1401 -> 2627
    //   1229: iload 15
    //   1231: istore 11
    //   1233: new 128	java/lang/StringBuilder
    //   1236: dup
    //   1237: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1240: ldc_w 365
    //   1243: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: aload 24
    //   1248: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   1251: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1254: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: ldc_w 367
    //   1260: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: aload 23
    //   1265: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1271: astore 20
    //   1273: goto -1128 -> 145
    //   1276: iload 10
    //   1278: istore 11
    //   1280: aload 24
    //   1282: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1285: iconst_1
    //   1286: if_icmpne +281 -> 1567
    //   1289: iload 10
    //   1291: istore 11
    //   1293: aload_0
    //   1294: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1297: bipush 8
    //   1299: invokevirtual 418	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1302: checkcast 420	com/tencent/mobileqq/model/FriendManager
    //   1305: aload 21
    //   1307: getfield 251	com/tencent/mobileqq/data/Setting:uin	Ljava/lang/String;
    //   1310: invokestatic 423	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1313: invokeinterface 426 2 0
    //   1318: ifnonnull +138 -> 1456
    //   1321: iload 10
    //   1323: istore 11
    //   1325: aload 21
    //   1327: aload 24
    //   1329: getfield 429	AvatarInfo/QQHeadInfo:soruceType	B
    //   1332: putfield 278	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   1335: goto -1062 -> 273
    //   1338: astore 20
    //   1340: iconst_0
    //   1341: istore 9
    //   1343: aconst_null
    //   1344: astore 20
    //   1346: iconst_0
    //   1347: istore_2
    //   1348: iload 11
    //   1350: istore 10
    //   1352: new 128	java/lang/StringBuilder
    //   1355: dup
    //   1356: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1359: aload 24
    //   1361: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1364: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1367: ldc_w 367
    //   1370: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1373: aload 23
    //   1375: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1381: astore 21
    //   1383: aload 24
    //   1385: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1388: bipush 32
    //   1390: if_icmpne +43 -> 1433
    //   1393: new 128	java/lang/StringBuilder
    //   1396: dup
    //   1397: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1400: ldc_w 365
    //   1403: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1406: aload 24
    //   1408: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   1411: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1414: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: ldc_w 367
    //   1420: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: aload 23
    //   1425: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1431: astore 21
    //   1433: aload_0
    //   1434: getfield 63	hny:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   1437: aload 21
    //   1439: iconst_1
    //   1440: invokevirtual 391	com/tencent/mobileqq/app/FriendListHandler:b	(Ljava/lang/String;Z)V
    //   1443: aload 25
    //   1445: invokevirtual 393	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1448: sipush 9204
    //   1451: istore 4
    //   1453: goto -367 -> 1086
    //   1456: iload 10
    //   1458: istore 11
    //   1460: aload 21
    //   1462: iconst_0
    //   1463: putfield 278	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   1466: goto -1193 -> 273
    //   1469: astore 20
    //   1471: new 128	java/lang/StringBuilder
    //   1474: dup
    //   1475: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1478: aload 24
    //   1480: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1483: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1486: ldc_w 367
    //   1489: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: aload 23
    //   1494: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1500: astore_1
    //   1501: aload 24
    //   1503: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1506: bipush 32
    //   1508: if_icmpne +42 -> 1550
    //   1511: new 128	java/lang/StringBuilder
    //   1514: dup
    //   1515: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1518: ldc_w 365
    //   1521: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1524: aload 24
    //   1526: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   1529: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1532: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1535: ldc_w 367
    //   1538: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1541: aload 23
    //   1543: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1549: astore_1
    //   1550: aload_0
    //   1551: getfield 63	hny:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   1554: aload_1
    //   1555: iconst_1
    //   1556: invokevirtual 391	com/tencent/mobileqq/app/FriendListHandler:b	(Ljava/lang/String;Z)V
    //   1559: aload 25
    //   1561: invokevirtual 393	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1564: aload 20
    //   1566: athrow
    //   1567: iload 10
    //   1569: istore 11
    //   1571: aload 21
    //   1573: aload 24
    //   1575: getfield 429	AvatarInfo/QQHeadInfo:soruceType	B
    //   1578: putfield 278	com/tencent/mobileqq/data/Setting:bSourceType	B
    //   1581: goto -1308 -> 273
    //   1584: iload 10
    //   1586: istore 11
    //   1588: aload 24
    //   1590: getfield 275	AvatarInfo/QQHeadInfo:cHeadType	B
    //   1593: ifne +26 -> 1619
    //   1596: iload 10
    //   1598: istore 11
    //   1600: aload 21
    //   1602: getfield 303	com/tencent/mobileqq/data/Setting:systemHeadID	S
    //   1605: aload 24
    //   1607: getfield 302	AvatarInfo/QQHeadInfo:systemHeadID	S
    //   1610: if_icmpeq +1045 -> 2655
    //   1613: iconst_1
    //   1614: istore 9
    //   1616: goto +1032 -> 2648
    //   1619: iload 10
    //   1621: istore 11
    //   1623: aload 21
    //   1625: getfield 309	com/tencent/mobileqq/data/Setting:headImgTimestamp	J
    //   1628: lstore 16
    //   1630: iload 10
    //   1632: istore 11
    //   1634: aload 24
    //   1636: getfield 306	AvatarInfo/QQHeadInfo:dwTimestamp	J
    //   1639: lstore 18
    //   1641: lload 16
    //   1643: lload 18
    //   1645: lcmp
    //   1646: ifeq +13 -> 1659
    //   1649: iconst_1
    //   1650: istore 9
    //   1652: iload 9
    //   1654: istore 10
    //   1656: goto -1354 -> 302
    //   1659: iconst_0
    //   1660: istore 9
    //   1662: goto -10 -> 1652
    //   1665: aload 25
    //   1667: aload 21
    //   1669: invokevirtual 432	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   1672: goto -1206 -> 466
    //   1675: astore 20
    //   1677: iconst_0
    //   1678: istore 11
    //   1680: iload 9
    //   1682: istore 10
    //   1684: aconst_null
    //   1685: astore 20
    //   1687: iconst_0
    //   1688: istore_2
    //   1689: iload 11
    //   1691: istore 9
    //   1693: goto -341 -> 1352
    //   1696: astore 22
    //   1698: aload 22
    //   1700: invokevirtual 435	java/lang/Exception:printStackTrace	()V
    //   1703: goto -1132 -> 571
    //   1706: astore 21
    //   1708: aload 20
    //   1710: monitorexit
    //   1711: aload 21
    //   1713: athrow
    //   1714: iconst_0
    //   1715: istore 9
    //   1717: goto -1077 -> 640
    //   1720: astore_1
    //   1721: new 128	java/lang/StringBuilder
    //   1724: dup
    //   1725: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1728: aload 24
    //   1730: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1733: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1736: ldc_w 367
    //   1739: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1742: aload 23
    //   1744: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1747: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1750: astore_1
    //   1751: aload 24
    //   1753: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1756: bipush 32
    //   1758: if_icmpne +42 -> 1800
    //   1761: new 128	java/lang/StringBuilder
    //   1764: dup
    //   1765: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1768: ldc_w 365
    //   1771: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1774: aload 24
    //   1776: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   1779: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1782: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1785: ldc_w 367
    //   1788: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1791: aload 23
    //   1793: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1796: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1799: astore_1
    //   1800: aload_0
    //   1801: getfield 63	hny:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   1804: aload_1
    //   1805: iconst_1
    //   1806: invokevirtual 391	com/tencent/mobileqq/app/FriendListHandler:b	(Ljava/lang/String;Z)V
    //   1809: aload 25
    //   1811: invokevirtual 393	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1814: return
    //   1815: astore 22
    //   1817: sipush 9202
    //   1820: istore 4
    //   1822: iload 12
    //   1824: istore 9
    //   1826: goto -1019 -> 807
    //   1829: iload 14
    //   1831: istore 11
    //   1833: iload 4
    //   1835: istore 5
    //   1837: aload_0
    //   1838: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1841: aload_1
    //   1842: aload 27
    //   1844: invokestatic 440	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/io/File;)I
    //   1847: istore 7
    //   1849: iload 7
    //   1851: ifne +347 -> 2198
    //   1854: iload 14
    //   1856: istore 11
    //   1858: iload 4
    //   1860: istore 5
    //   1862: aload 27
    //   1864: invokevirtual 443	java/io/File:length	()J
    //   1867: lstore 16
    //   1869: lload 16
    //   1871: l2i
    //   1872: istore_3
    //   1873: aload_0
    //   1874: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1877: invokevirtual 73	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1880: invokestatic 446	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)Landroid/net/NetworkInfo;
    //   1883: invokevirtual 451	android/net/NetworkInfo:getType	()I
    //   1886: istore 4
    //   1888: iconst_0
    //   1889: istore_2
    //   1890: aload 24
    //   1892: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1895: iconst_1
    //   1896: if_icmpne +252 -> 2148
    //   1899: iconst_0
    //   1900: istore_2
    //   1901: aload_0
    //   1902: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1905: aload_0
    //   1906: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1909: invokevirtual 453	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1912: iconst_0
    //   1913: iload 4
    //   1915: ldc_w 454
    //   1918: iload_2
    //   1919: iload_3
    //   1920: bipush 126
    //   1922: iadd
    //   1923: sipush 239
    //   1926: iadd
    //   1927: i2l
    //   1928: invokevirtual 457	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;ZIIIJ)V
    //   1931: iconst_0
    //   1932: istore_2
    //   1933: iconst_1
    //   1934: istore 12
    //   1936: iload 12
    //   1938: istore 11
    //   1940: iload 6
    //   1942: istore 5
    //   1944: aload 24
    //   1946: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1949: iconst_1
    //   1950: if_icmpeq +53 -> 2003
    //   1953: iload 12
    //   1955: istore 11
    //   1957: iload 6
    //   1959: istore 5
    //   1961: aload 24
    //   1963: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1966: bipush 11
    //   1968: if_icmpeq +35 -> 2003
    //   1971: iload 12
    //   1973: istore 11
    //   1975: iload 6
    //   1977: istore 5
    //   1979: aload 24
    //   1981: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   1984: istore 8
    //   1986: iload_2
    //   1987: istore 4
    //   1989: iload 12
    //   1991: istore 9
    //   1993: iload 6
    //   1995: istore_3
    //   1996: iload 8
    //   1998: bipush 32
    //   2000: if_icmpne -1193 -> 807
    //   2003: iload 12
    //   2005: istore 11
    //   2007: iload 6
    //   2009: istore 5
    //   2011: aload 27
    //   2013: invokevirtual 443	java/io/File:length	()J
    //   2016: l2i
    //   2017: istore_3
    //   2018: iload 12
    //   2020: istore 11
    //   2022: iload 6
    //   2024: istore 5
    //   2026: ldc_w 459
    //   2029: iconst_1
    //   2030: new 128	java/lang/StringBuilder
    //   2033: dup
    //   2034: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   2037: ldc_w 461
    //   2040: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2043: aload 24
    //   2045: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2048: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2051: ldc_w 463
    //   2054: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2057: iload 7
    //   2059: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2062: ldc_w 465
    //   2065: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2068: aload_1
    //   2069: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2072: ldc_w 467
    //   2075: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2078: iload_3
    //   2079: bipush 126
    //   2081: iadd
    //   2082: sipush 239
    //   2085: iadd
    //   2086: invokevirtual 136	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2089: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2092: invokestatic 156	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2095: iload_2
    //   2096: istore 4
    //   2098: iload 12
    //   2100: istore 9
    //   2102: iload 6
    //   2104: istore_3
    //   2105: goto -1298 -> 807
    //   2108: astore 22
    //   2110: iload 12
    //   2112: istore 11
    //   2114: iload 6
    //   2116: istore 5
    //   2118: aload 22
    //   2120: invokevirtual 435	java/lang/Exception:printStackTrace	()V
    //   2123: iload_2
    //   2124: istore 4
    //   2126: iload 12
    //   2128: istore 9
    //   2130: iload 6
    //   2132: istore_3
    //   2133: goto -1326 -> 807
    //   2136: astore 21
    //   2138: iload 5
    //   2140: istore_2
    //   2141: iload 11
    //   2143: istore 9
    //   2145: goto -793 -> 1352
    //   2148: aload 24
    //   2150: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2153: iconst_4
    //   2154: if_icmpne +8 -> 2162
    //   2157: iconst_1
    //   2158: istore_2
    //   2159: goto -258 -> 1901
    //   2162: aload 24
    //   2164: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2167: bipush 11
    //   2169: if_icmpne +8 -> 2177
    //   2172: iconst_3
    //   2173: istore_2
    //   2174: goto -273 -> 1901
    //   2177: aload 24
    //   2179: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2182: istore 5
    //   2184: iload 5
    //   2186: bipush 32
    //   2188: if_icmpne -287 -> 1901
    //   2191: sipush 1003
    //   2194: istore_2
    //   2195: goto -294 -> 1901
    //   2198: iload 7
    //   2200: tableswitch	default:+36 -> 2236, 1:+51->2251, 2:+36->2236, 3:+36->2236, 4:+62->2262, 5:+73->2273
    //   2237: fload_1
    //   2238: <illegal opcode>
    //   2239: istore_2
    //   2240: iload 7
    //   2242: istore 6
    //   2244: iload 13
    //   2246: istore 12
    //   2248: goto -312 -> 1936
    //   2251: sipush 9206
    //   2254: istore_2
    //   2255: iload 13
    //   2257: istore 12
    //   2259: goto -323 -> 1936
    //   2262: sipush 9202
    //   2265: istore_2
    //   2266: iload 13
    //   2268: istore 12
    //   2270: goto -334 -> 1936
    //   2273: sipush 9204
    //   2276: istore_2
    //   2277: iload 13
    //   2279: istore 12
    //   2281: goto -345 -> 1936
    //   2284: iload 9
    //   2286: istore 11
    //   2288: iload_3
    //   2289: istore 5
    //   2291: aload 23
    //   2293: invokestatic 372	com/tencent/mobileqq/util/ProfileCardUtil:a	(Ljava/lang/String;)Z
    //   2296: pop
    //   2297: iload 9
    //   2299: istore 11
    //   2301: iload_3
    //   2302: istore 5
    //   2304: aload_0
    //   2305: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2308: aload 23
    //   2310: invokestatic 375	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   2313: goto -1411 -> 902
    //   2316: iload 9
    //   2318: istore 11
    //   2320: iload_3
    //   2321: istore 5
    //   2323: aload 24
    //   2325: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2328: bipush 32
    //   2330: if_icmpne +31 -> 2361
    //   2333: iload 9
    //   2335: istore 11
    //   2337: iload_3
    //   2338: istore 5
    //   2340: aload_0
    //   2341: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2344: bipush 32
    //   2346: aload 23
    //   2348: aload 24
    //   2350: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   2353: invokevirtual 378	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)V
    //   2356: iload_3
    //   2357: istore_2
    //   2358: goto -1416 -> 942
    //   2361: iload 9
    //   2363: istore 11
    //   2365: iload_3
    //   2366: istore 5
    //   2368: aload_0
    //   2369: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2372: iconst_1
    //   2373: aload 23
    //   2375: aload 24
    //   2377: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   2380: invokevirtual 378	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)V
    //   2383: iload_3
    //   2384: istore_2
    //   2385: goto -1443 -> 942
    //   2388: aload 24
    //   2390: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2393: iconst_4
    //   2394: if_icmpne +35 -> 2429
    //   2397: aload_0
    //   2398: getfield 63	hny:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   2401: bipush 30
    //   2403: iconst_1
    //   2404: iconst_1
    //   2405: anewarray 4	java/lang/Object
    //   2408: dup
    //   2409: iconst_0
    //   2410: aload 23
    //   2412: aastore
    //   2413: invokevirtual 384	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   2416: aload_0
    //   2417: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2420: aload 23
    //   2422: iconst_4
    //   2423: invokevirtual 470	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;I)V
    //   2426: goto -1448 -> 978
    //   2429: aload 24
    //   2431: getfield 239	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2434: bipush 32
    //   2436: if_icmpne +89 -> 2525
    //   2439: sipush 3000
    //   2442: istore 5
    //   2444: iload 5
    //   2446: istore_3
    //   2447: aload 24
    //   2449: getfield 286	AvatarInfo/QQHeadInfo:subType	I
    //   2452: tableswitch	default:+214 -> 2666, 200:+220->2672, 201:+36->2488, 202:+227->2679, 203:+36->2488, 204:+234->2686
    //   2489: getfield 63	hny:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   2492: aload 26
    //   2494: iconst_5
    //   2495: iconst_1
    //   2496: iconst_3
    //   2497: anewarray 4	java/lang/Object
    //   2500: dup
    //   2501: iconst_0
    //   2502: aload 23
    //   2504: aastore
    //   2505: dup
    //   2506: iconst_1
    //   2507: iload_3
    //   2508: invokestatic 475	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2511: aastore
    //   2512: dup
    //   2513: iconst_2
    //   2514: iconst_1
    //   2515: invokestatic 480	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2518: aastore
    //   2519: invokevirtual 381	com/tencent/mobileqq/app/FriendListHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;IZLjava/lang/Object;)V
    //   2522: goto -1544 -> 978
    //   2525: aload_0
    //   2526: getfield 61	hny:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2529: aload 23
    //   2531: iconst_1
    //   2532: invokevirtual 470	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;I)V
    //   2535: aload_0
    //   2536: getfield 63	hny:jdField_a_of_type_ComTencentMobileqqAppFriendListHandler	Lcom/tencent/mobileqq/app/FriendListHandler;
    //   2539: aload 26
    //   2541: iconst_4
    //   2542: iconst_1
    //   2543: iconst_1
    //   2544: anewarray 4	java/lang/Object
    //   2547: dup
    //   2548: iconst_0
    //   2549: aload 23
    //   2551: aastore
    //   2552: invokevirtual 381	com/tencent/mobileqq/app/FriendListHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;IZLjava/lang/Object;)V
    //   2555: goto -1577 -> 978
    //   2558: astore 21
    //   2560: iconst_0
    //   2561: istore 11
    //   2563: iload 9
    //   2565: istore 10
    //   2567: iconst_0
    //   2568: istore_2
    //   2569: iload 11
    //   2571: istore 9
    //   2573: goto -1221 -> 1352
    //   2576: astore 21
    //   2578: iconst_0
    //   2579: istore 9
    //   2581: iconst_0
    //   2582: istore_2
    //   2583: goto -1231 -> 1352
    //   2586: astore 21
    //   2588: iconst_0
    //   2589: istore_2
    //   2590: iconst_1
    //   2591: istore 9
    //   2593: goto -1241 -> 1352
    //   2596: aload 22
    //   2598: astore_1
    //   2599: goto -1868 -> 731
    //   2602: iconst_0
    //   2603: istore_2
    //   2604: iconst_0
    //   2605: istore 9
    //   2607: iconst_0
    //   2608: istore 4
    //   2610: goto -1668 -> 942
    //   2613: iload 9
    //   2615: istore 10
    //   2617: goto -1973 -> 644
    //   2620: iload 9
    //   2622: istore 10
    //   2624: goto -2427 -> 197
    //   2627: aload 23
    //   2629: astore 20
    //   2631: goto -2486 -> 145
    //   2634: iconst_0
    //   2635: istore_2
    //   2636: aconst_null
    //   2637: astore 20
    //   2639: iconst_0
    //   2640: istore 9
    //   2642: iconst_0
    //   2643: istore 4
    //   2645: goto -1655 -> 990
    //   2648: iload 9
    //   2650: istore 10
    //   2652: goto -2350 -> 302
    //   2655: iconst_0
    //   2656: istore 9
    //   2658: goto -10 -> 2648
    //   2661: astore 21
    //   2663: goto -1311 -> 1352
    //   2666: iload 5
    //   2668: istore_3
    //   2669: goto -181 -> 2488
    //   2672: sipush 3000
    //   2675: istore_3
    //   2676: goto -188 -> 2488
    //   2679: sipush 3001
    //   2682: istore_3
    //   2683: goto -195 -> 2488
    //   2686: sipush 3002
    //   2689: istore_3
    //   2690: goto -202 -> 2488
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2693	0	this	hny
    //   0	2693	1	paramhoa	hoa
    //   105	2531	2	k	int
    //   62	2628	3	m	int
    //   59	2585	4	n	int
    //   737	1930	5	i1	int
    //   56	2187	6	i2	int
    //   1847	394	7	i3	int
    //   1984	17	8	i4	int
    //   38	2619	9	bool1	boolean
    //   32	2619	10	bool2	boolean
    //   77	2493	11	bool3	boolean
    //   47	2233	12	bool4	boolean
    //   41	2237	13	bool5	boolean
    //   44	1811	14	bool6	boolean
    //   35	1195	15	bool7	boolean
    //   1628	242	16	l1	long
    //   1639	5	18	l2	long
    //   1338	1	20	localThrowable1	java.lang.Throwable
    //   1344	1	20	localObject2	Object
    //   1469	96	20	localObject3	Object
    //   1675	1	20	localThrowable2	java.lang.Throwable
    //   1685	953	20	str1	String
    //   161	1507	21	localObject4	Object
    //   1706	6	21	localObject5	Object
    //   2136	1	21	localThrowable3	java.lang.Throwable
    //   2558	1	21	localThrowable4	java.lang.Throwable
    //   2576	1	21	localThrowable5	java.lang.Throwable
    //   2586	1	21	localThrowable6	java.lang.Throwable
    //   2661	1	21	localThrowable7	java.lang.Throwable
    //   668	230	22	str2	String
    //   1696	3	22	localException1	java.lang.Exception
    //   1815	1	22	localException2	java.lang.Exception
    //   2108	489	22	localException3	java.lang.Exception
    //   29	2599	23	str3	String
    //   4	2444	24	localQQHeadInfo	QQHeadInfo
    //   73	1737	25	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   10	2530	26	localToServiceMsg	ToServiceMsg
    //   618	1394	27	localFile	File
    // Exception table:
    //   from	to	target	type
    //   79	87	1338	java/lang/Throwable
    //   91	104	1338	java/lang/Throwable
    //   110	119	1338	java/lang/Throwable
    //   123	145	1338	java/lang/Throwable
    //   149	163	1338	java/lang/Throwable
    //   172	181	1338	java/lang/Throwable
    //   185	192	1338	java/lang/Throwable
    //   201	211	1338	java/lang/Throwable
    //   215	225	1338	java/lang/Throwable
    //   229	239	1338	java/lang/Throwable
    //   243	251	1338	java/lang/Throwable
    //   255	263	1338	java/lang/Throwable
    //   267	273	1338	java/lang/Throwable
    //   286	299	1338	java/lang/Throwable
    //   319	328	1338	java/lang/Throwable
    //   336	344	1338	java/lang/Throwable
    //   348	376	1338	java/lang/Throwable
    //   393	401	1338	java/lang/Throwable
    //   405	411	1338	java/lang/Throwable
    //   1219	1229	1338	java/lang/Throwable
    //   1233	1273	1338	java/lang/Throwable
    //   1280	1289	1338	java/lang/Throwable
    //   1293	1321	1338	java/lang/Throwable
    //   1325	1335	1338	java/lang/Throwable
    //   1460	1466	1338	java/lang/Throwable
    //   1571	1581	1338	java/lang/Throwable
    //   1588	1596	1338	java/lang/Throwable
    //   1600	1613	1338	java/lang/Throwable
    //   1623	1630	1338	java/lang/Throwable
    //   1634	1641	1338	java/lang/Throwable
    //   79	87	1469	finally
    //   91	104	1469	finally
    //   110	119	1469	finally
    //   123	145	1469	finally
    //   149	163	1469	finally
    //   172	181	1469	finally
    //   185	192	1469	finally
    //   201	211	1469	finally
    //   215	225	1469	finally
    //   229	239	1469	finally
    //   243	251	1469	finally
    //   255	263	1469	finally
    //   267	273	1469	finally
    //   286	299	1469	finally
    //   319	328	1469	finally
    //   336	344	1469	finally
    //   348	376	1469	finally
    //   393	401	1469	finally
    //   405	411	1469	finally
    //   415	454	1469	finally
    //   458	466	1469	finally
    //   466	496	1469	finally
    //   588	609	1469	finally
    //   609	620	1469	finally
    //   625	632	1469	finally
    //   649	670	1469	finally
    //   673	683	1469	finally
    //   686	696	1469	finally
    //   699	728	1469	finally
    //   739	747	1469	finally
    //   755	761	1469	finally
    //   774	782	1469	finally
    //   790	801	1469	finally
    //   819	829	1469	finally
    //   836	873	1469	finally
    //   880	886	1469	finally
    //   893	902	1469	finally
    //   909	918	1469	finally
    //   925	940	1469	finally
    //   947	978	1469	finally
    //   978	990	1469	finally
    //   1219	1229	1469	finally
    //   1233	1273	1469	finally
    //   1280	1289	1469	finally
    //   1293	1321	1469	finally
    //   1325	1335	1469	finally
    //   1460	1466	1469	finally
    //   1571	1581	1469	finally
    //   1588	1596	1469	finally
    //   1600	1613	1469	finally
    //   1623	1630	1469	finally
    //   1634	1641	1469	finally
    //   1665	1672	1469	finally
    //   1711	1714	1469	finally
    //   1837	1849	1469	finally
    //   1862	1869	1469	finally
    //   1873	1888	1469	finally
    //   1890	1899	1469	finally
    //   1901	1931	1469	finally
    //   1944	1953	1469	finally
    //   1961	1971	1469	finally
    //   1979	1986	1469	finally
    //   2011	2018	1469	finally
    //   2026	2095	1469	finally
    //   2118	2123	1469	finally
    //   2148	2157	1469	finally
    //   2162	2172	1469	finally
    //   2177	2184	1469	finally
    //   2291	2297	1469	finally
    //   2304	2313	1469	finally
    //   2323	2333	1469	finally
    //   2340	2356	1469	finally
    //   2368	2383	1469	finally
    //   2388	2426	1469	finally
    //   2429	2439	1469	finally
    //   2447	2488	1469	finally
    //   2488	2522	1469	finally
    //   2525	2555	1469	finally
    //   415	454	1675	java/lang/Throwable
    //   458	466	1675	java/lang/Throwable
    //   466	496	1675	java/lang/Throwable
    //   588	609	1675	java/lang/Throwable
    //   1665	1672	1675	java/lang/Throwable
    //   1711	1714	1675	java/lang/Throwable
    //   522	571	1696	java/lang/Exception
    //   496	517	1706	finally
    //   522	571	1706	finally
    //   571	588	1706	finally
    //   1698	1703	1706	finally
    //   1708	1711	1706	finally
    //   588	609	1720	java/lang/Exception
    //   609	620	1720	java/lang/Exception
    //   625	632	1720	java/lang/Exception
    //   774	782	1815	java/lang/Exception
    //   790	801	1815	java/lang/Exception
    //   2011	2018	2108	java/lang/Exception
    //   2026	2095	2108	java/lang/Exception
    //   739	747	2136	java/lang/Throwable
    //   755	761	2136	java/lang/Throwable
    //   774	782	2136	java/lang/Throwable
    //   790	801	2136	java/lang/Throwable
    //   819	829	2136	java/lang/Throwable
    //   836	873	2136	java/lang/Throwable
    //   880	886	2136	java/lang/Throwable
    //   893	902	2136	java/lang/Throwable
    //   909	918	2136	java/lang/Throwable
    //   925	940	2136	java/lang/Throwable
    //   1837	1849	2136	java/lang/Throwable
    //   1862	1869	2136	java/lang/Throwable
    //   1944	1953	2136	java/lang/Throwable
    //   1961	1971	2136	java/lang/Throwable
    //   1979	1986	2136	java/lang/Throwable
    //   2011	2018	2136	java/lang/Throwable
    //   2026	2095	2136	java/lang/Throwable
    //   2118	2123	2136	java/lang/Throwable
    //   2291	2297	2136	java/lang/Throwable
    //   2304	2313	2136	java/lang/Throwable
    //   2323	2333	2136	java/lang/Throwable
    //   2340	2356	2136	java/lang/Throwable
    //   2368	2383	2136	java/lang/Throwable
    //   609	620	2558	java/lang/Throwable
    //   625	632	2558	java/lang/Throwable
    //   649	670	2576	java/lang/Throwable
    //   673	683	2576	java/lang/Throwable
    //   686	696	2576	java/lang/Throwable
    //   699	728	2576	java/lang/Throwable
    //   1873	1888	2586	java/lang/Throwable
    //   1890	1899	2586	java/lang/Throwable
    //   1901	1931	2586	java/lang/Throwable
    //   2148	2157	2586	java/lang/Throwable
    //   2162	2172	2586	java/lang/Throwable
    //   2177	2184	2586	java/lang/Throwable
    //   947	978	2661	java/lang/Throwable
    //   978	990	2661	java/lang/Throwable
    //   2388	2426	2661	java/lang/Throwable
    //   2429	2439	2661	java/lang/Throwable
    //   2447	2488	2661	java/lang/Throwable
    //   2488	2522	2661	java/lang/Throwable
    //   2525	2555	2661	java/lang/Throwable
  }
  
  protected int a(byte paramByte)
  {
    byte b3 = paramByte;
    if (paramByte == 0) {
      b3 = 1;
    }
    paramByte = 1 << this.jdField_a_of_type_Byte;
    if ((paramByte & b3) == paramByte) {
      return this.j;
    }
    byte b2 = 0;
    paramByte = this.jdField_a_of_type_Byte - 1;
    byte b1 = b2;
    if (paramByte >= 0)
    {
      b1 = (byte)(1 << paramByte);
      if ((b1 & b3) == b1) {
        b1 = 1;
      }
    }
    else
    {
      b2 = paramByte;
      if (b1 != 0) {
        break label167;
      }
      paramByte = this.jdField_a_of_type_Byte + 1;
      b2 = paramByte;
      if (paramByte >= 8) {
        break label167;
      }
      b2 = (byte)(1 << paramByte);
      if ((b2 & b3) != b2) {
        break label146;
      }
      b1 = 1;
    }
    for (;;)
    {
      if (b1 != 0) {}
      switch (paramByte)
      {
      case 1: 
      default: 
        return 100;
        paramByte -= 1;
        break;
        paramByte += 1;
        break;
      case 0: 
        return 40;
      case 2: 
        return 100;
      case 3: 
        return 140;
      case 4: 
        label146:
        return 640;
        label167:
        paramByte = b2;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQHeadDownloadHandler", 2, "QQHeadDownloadHandler close.");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    int k = 0;
    while (k < this.jdField_a_of_type_ArrayOfHob.length)
    {
      if (this.jdField_a_of_type_ArrayOfHob[k] != null) {
        this.jdField_a_of_type_ArrayOfHob[k].a();
      }
      k += 1;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.notifyAll();
        return;
      }
    }
  }
  
  public void a(int paramInt)
  {
    int n = 0;
    int k = 0;
    int m;
    if ((paramInt == this.f) && (this.h < this.f) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.g))
    {
      m = this.h + this.jdField_a_of_type_JavaUtilArrayList.size() - this.g + 1;
      paramInt = m;
      if (m <= 0) {
        paramInt = 1;
      }
      if (paramInt >= this.f) {}
    }
    while (k < paramInt)
    {
      if (this.jdField_a_of_type_ArrayOfHob[k] == null)
      {
        this.jdField_a_of_type_ArrayOfHob[k] = new hob(this, k);
        this.jdField_a_of_type_ArrayOfHob[k].start();
        this.h += 1;
      }
      k += 1;
      continue;
      paramInt = this.f;
      continue;
      if ((paramInt > 0) && (paramInt != this.f))
      {
        hob[] arrayOfhob = new hob[paramInt];
        m = 0;
        k = n;
        n = k;
        if (m < this.jdField_a_of_type_ArrayOfHob.length)
        {
          if ((this.jdField_a_of_type_ArrayOfHob[m] != null) && (k < paramInt))
          {
            arrayOfhob[k] = this.jdField_a_of_type_ArrayOfHob[m];
            arrayOfhob[k].a(k);
            n = k + 1;
          }
          for (;;)
          {
            m += 1;
            k = n;
            break;
            n = k;
            if (this.jdField_a_of_type_ArrayOfHob[m] != null)
            {
              this.jdField_a_of_type_ArrayOfHob[m].a();
              n = k;
            }
          }
        }
        while (n < paramInt)
        {
          arrayOfhob[n] = new hob(this, n);
          arrayOfhob[n].start();
          this.h += 1;
          n += 1;
        }
        this.f = paramInt;
        this.jdField_a_of_type_ArrayOfHob = arrayOfhob;
      }
    }
  }
  
  public boolean a(QQHeadInfo arg1, ToServiceMsg paramToServiceMsg)
  {
    hoa localhoa = new hoa(this, null);
    localhoa.jdField_a_of_type_AvatarInfoQQHeadInfo = ???;
    localhoa.jdField_a_of_type_ComTencentQphoneBaseRemoteToServiceMsg = paramToServiceMsg;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dh", 2, "downloadAndNotifyQQhead|uin=" + ???.uin + ", phoneNum=" + ???.phoneNum + ", cHeadType=" + ???.cHeadType + ", dstUsrType=" + ???.dstUsrType + ", dwFaceFlgas=" + ???.dwFaceFlgas + ", systemHeadID=" + ???.systemHeadID + ", dwTimestamp=" + ???.dwTimestamp + ", downLoadUrl=" + ???.downLoadUrl);
    }
    int k = this.f;
    if (this.i > 5)
    {
      this.i = 0;
      if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a())) {
        break label228;
      }
      k = this.d;
    }
    for (;;)
    {
      this.i += 1;
      a(k);
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(localhoa);
        this.jdField_a_of_type_JavaUtilArrayList.notify();
        return false;
        label228:
        k = this.e;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hny
 * JD-Core Version:    0.7.0.1
 */