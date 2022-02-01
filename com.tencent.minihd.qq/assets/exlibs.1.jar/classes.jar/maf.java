import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qwallet.plugin.ipc.PersonalInfoReq;

public class maf
  implements Runnable
{
  public maf(PersonalInfoReq paramPersonalInfoReq, QQAppInterface paramQQAppInterface) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 13	maf:jdField_a_of_type_CooperationQwalletPluginIpcPersonalInfoReq	Lcooperation/qwallet/plugin/ipc/PersonalInfoReq;
    //   4: aload_0
    //   5: getfield 15	maf:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8: invokevirtual 29	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   11: invokevirtual 34	cooperation/qwallet/plugin/ipc/PersonalInfoReq:a	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_3
    //   15: new 36	java/io/File
    //   18: dup
    //   19: invokestatic 42	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   22: invokevirtual 48	android/content/Context:getFilesDir	()Ljava/io/File;
    //   25: aload_3
    //   26: invokespecial 51	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_3
    //   30: aload_3
    //   31: invokevirtual 55	java/io/File:exists	()Z
    //   34: ifne +12 -> 46
    //   37: aload_0
    //   38: getfield 13	maf:jdField_a_of_type_CooperationQwalletPluginIpcPersonalInfoReq	Lcooperation/qwallet/plugin/ipc/PersonalInfoReq;
    //   41: aconst_null
    //   42: invokevirtual 59	cooperation/qwallet/plugin/ipc/PersonalInfoReq:b	(LWallet/RspH5Config;)V
    //   45: return
    //   46: new 61	java/io/FileInputStream
    //   49: dup
    //   50: aload_3
    //   51: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: astore_3
    //   55: new 66	java/io/ByteArrayOutputStream
    //   58: dup
    //   59: invokespecial 67	java/io/ByteArrayOutputStream:<init>	()V
    //   62: astore 4
    //   64: sipush 4096
    //   67: newarray byte
    //   69: astore 5
    //   71: aload_3
    //   72: aload 5
    //   74: iconst_0
    //   75: sipush 4096
    //   78: invokevirtual 71	java/io/FileInputStream:read	([BII)I
    //   81: istore_1
    //   82: iload_1
    //   83: iconst_m1
    //   84: if_icmpeq +43 -> 127
    //   87: aload 4
    //   89: aload 5
    //   91: iconst_0
    //   92: iload_1
    //   93: invokevirtual 75	java/io/ByteArrayOutputStream:write	([BII)V
    //   96: goto -25 -> 71
    //   99: astore_3
    //   100: aload_3
    //   101: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   104: aload_0
    //   105: getfield 13	maf:jdField_a_of_type_CooperationQwalletPluginIpcPersonalInfoReq	Lcooperation/qwallet/plugin/ipc/PersonalInfoReq;
    //   108: aconst_null
    //   109: invokevirtual 59	cooperation/qwallet/plugin/ipc/PersonalInfoReq:b	(LWallet/RspH5Config;)V
    //   112: return
    //   113: astore_3
    //   114: aload_3
    //   115: invokevirtual 79	java/lang/Exception:printStackTrace	()V
    //   118: aload_0
    //   119: getfield 13	maf:jdField_a_of_type_CooperationQwalletPluginIpcPersonalInfoReq	Lcooperation/qwallet/plugin/ipc/PersonalInfoReq;
    //   122: aconst_null
    //   123: invokevirtual 59	cooperation/qwallet/plugin/ipc/PersonalInfoReq:b	(LWallet/RspH5Config;)V
    //   126: return
    //   127: new 81	java/lang/String
    //   130: dup
    //   131: aload 4
    //   133: invokevirtual 85	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   136: ldc 87
    //   138: invokespecial 90	java/lang/String:<init>	([BLjava/lang/String;)V
    //   141: astore 5
    //   143: aload_3
    //   144: ifnull +7 -> 151
    //   147: aload_3
    //   148: invokevirtual 93	java/io/FileInputStream:close	()V
    //   151: aload 4
    //   153: ifnull +8 -> 161
    //   156: aload 4
    //   158: invokevirtual 94	java/io/ByteArrayOutputStream:close	()V
    //   161: aload 5
    //   163: ifnull -45 -> 118
    //   166: new 96	org/json/JSONObject
    //   169: dup
    //   170: aload 5
    //   172: invokespecial 99	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   175: astore 4
    //   177: new 101	Wallet/RspH5Config
    //   180: dup
    //   181: invokespecial 102	Wallet/RspH5Config:<init>	()V
    //   184: astore_3
    //   185: aload_3
    //   186: aload 4
    //   188: ldc 104
    //   190: invokevirtual 108	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   193: putfield 111	Wallet/RspH5Config:ret	I
    //   196: aload_3
    //   197: aload 4
    //   199: ldc 113
    //   201: invokevirtual 116	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: putfield 119	Wallet/RspH5Config:msg	Ljava/lang/String;
    //   207: aload_3
    //   208: aload 4
    //   210: ldc 121
    //   212: invokevirtual 108	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   215: putfield 123	Wallet/RspH5Config:refreshPeriod	I
    //   218: aload 4
    //   220: ldc 125
    //   222: invokevirtual 129	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   225: astore 4
    //   227: aload 4
    //   229: ifnull +127 -> 356
    //   232: aload 4
    //   234: invokevirtual 135	org/json/JSONArray:length	()I
    //   237: ifle +119 -> 356
    //   240: aload_3
    //   241: new 137	java/util/ArrayList
    //   244: dup
    //   245: invokespecial 138	java/util/ArrayList:<init>	()V
    //   248: putfield 141	Wallet/RspH5Config:vecH5Info	Ljava/util/ArrayList;
    //   251: iconst_0
    //   252: istore_1
    //   253: iload_1
    //   254: aload 4
    //   256: invokevirtual 135	org/json/JSONArray:length	()I
    //   259: if_icmpge +97 -> 356
    //   262: new 137	java/util/ArrayList
    //   265: dup
    //   266: invokespecial 138	java/util/ArrayList:<init>	()V
    //   269: astore 5
    //   271: aload 4
    //   273: iload_1
    //   274: invokevirtual 145	org/json/JSONArray:getJSONArray	(I)Lorg/json/JSONArray;
    //   277: astore 6
    //   279: iconst_0
    //   280: istore_2
    //   281: iload_2
    //   282: aload 6
    //   284: invokevirtual 135	org/json/JSONArray:length	()I
    //   287: if_icmpge +48 -> 335
    //   290: aload_0
    //   291: getfield 13	maf:jdField_a_of_type_CooperationQwalletPluginIpcPersonalInfoReq	Lcooperation/qwallet/plugin/ipc/PersonalInfoReq;
    //   294: aload 6
    //   296: iload_2
    //   297: invokevirtual 149	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   300: invokevirtual 152	cooperation/qwallet/plugin/ipc/PersonalInfoReq:a	(Lorg/json/JSONObject;)LWallet/H5Info;
    //   303: astore 7
    //   305: aload 7
    //   307: ifnull +58 -> 365
    //   310: aload 5
    //   312: aload 7
    //   314: invokevirtual 156	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   317: pop
    //   318: goto +47 -> 365
    //   321: astore_3
    //   322: aload_3
    //   323: invokevirtual 79	java/lang/Exception:printStackTrace	()V
    //   326: aload_0
    //   327: getfield 13	maf:jdField_a_of_type_CooperationQwalletPluginIpcPersonalInfoReq	Lcooperation/qwallet/plugin/ipc/PersonalInfoReq;
    //   330: aconst_null
    //   331: invokevirtual 59	cooperation/qwallet/plugin/ipc/PersonalInfoReq:b	(LWallet/RspH5Config;)V
    //   334: return
    //   335: aload 5
    //   337: invokevirtual 159	java/util/ArrayList:size	()I
    //   340: ifle +32 -> 372
    //   343: aload_3
    //   344: getfield 141	Wallet/RspH5Config:vecH5Info	Ljava/util/ArrayList;
    //   347: aload 5
    //   349: invokevirtual 156	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   352: pop
    //   353: goto +19 -> 372
    //   356: aload_0
    //   357: getfield 13	maf:jdField_a_of_type_CooperationQwalletPluginIpcPersonalInfoReq	Lcooperation/qwallet/plugin/ipc/PersonalInfoReq;
    //   360: aload_3
    //   361: invokevirtual 59	cooperation/qwallet/plugin/ipc/PersonalInfoReq:b	(LWallet/RspH5Config;)V
    //   364: return
    //   365: iload_2
    //   366: iconst_1
    //   367: iadd
    //   368: istore_2
    //   369: goto -88 -> 281
    //   372: iload_1
    //   373: iconst_1
    //   374: iadd
    //   375: istore_1
    //   376: goto -123 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	maf
    //   81	295	1	i	int
    //   280	89	2	j	int
    //   14	58	3	localObject1	Object
    //   99	2	3	localIOException	java.io.IOException
    //   113	35	3	localException1	java.lang.Exception
    //   184	57	3	localRspH5Config	Wallet.RspH5Config
    //   321	40	3	localException2	java.lang.Exception
    //   62	210	4	localObject2	Object
    //   69	279	5	localObject3	Object
    //   277	18	6	localJSONArray	org.json.JSONArray
    //   303	10	7	localH5Info	Wallet.H5Info
    // Exception table:
    //   from	to	target	type
    //   71	82	99	java/io/IOException
    //   87	96	99	java/io/IOException
    //   127	143	99	java/io/IOException
    //   0	45	113	java/lang/Exception
    //   46	71	113	java/lang/Exception
    //   71	82	113	java/lang/Exception
    //   87	96	113	java/lang/Exception
    //   100	112	113	java/lang/Exception
    //   127	143	113	java/lang/Exception
    //   166	227	113	java/lang/Exception
    //   232	251	113	java/lang/Exception
    //   253	279	113	java/lang/Exception
    //   281	305	113	java/lang/Exception
    //   310	318	113	java/lang/Exception
    //   322	334	113	java/lang/Exception
    //   335	353	113	java/lang/Exception
    //   356	364	113	java/lang/Exception
    //   147	151	321	java/lang/Exception
    //   156	161	321	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     maf
 * JD-Core Version:    0.7.0.1
 */