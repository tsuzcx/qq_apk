package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoDownReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoDownResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kay;
import kbd;

public class ShortVideoDownloadProcessor
  extends BaseDownloadProcessor
{
  static HashSet a;
  public static final String ac = "ShortVideoDownloadProcessor";
  private String ad;
  private String ae = "";
  private int as;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
  }
  
  public ShortVideoDownloadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    paramTransFileController = paramTransferRequest.h;
    String[] arrayOfString = paramTransFileController.split("QQ_&_MoblieQQ_&_QQ");
    if (3 != arrayOfString.length)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "path was not set correctlly------path = " + paramTransFileController);
      }
      throw new IllegalArgumentException("path was not set correctlly.");
    }
    paramTransferRequest.g = arrayOfString[0];
    this.ad = arrayOfString[1];
    this.as = Integer.parseInt(arrayOfString[2]);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "start()----runningTasks.contains(mFileId) = " + jdField_a_of_type_JavaUtilHashSet.contains(this.ad));
    }
    if (jdField_a_of_type_JavaUtilHashSet.contains(this.ad)) {
      return;
    }
    jdField_a_of_type_JavaUtilHashSet.add(this.ad);
    d(2001);
    c();
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.e = paramLong1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = paramLong2;
    d(2002);
  }
  
  /* Error */
  public void a(NetResp paramNetResp)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 122	com/tencent/mobileqq/transfile/BaseDownloadProcessor:a	(Lcom/tencent/mobileqq/transfile/NetResp;)V
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 125	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   12: new 52	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   19: ldc 127
    //   21: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_0
    //   25: getfield 131	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Boolean	Z
    //   28: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   31: ldc 133
    //   33: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: astore 4
    //   38: aload_1
    //   39: getfield 137	com/tencent/mobileqq/transfile/NetResp:jdField_e_of_type_Int	I
    //   42: ifne +352 -> 394
    //   45: iconst_1
    //   46: istore_2
    //   47: aload_0
    //   48: ldc 139
    //   50: aload 4
    //   52: iload_2
    //   53: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   56: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokevirtual 142	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: invokestatic 50	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   65: ifeq +87 -> 152
    //   68: ldc 10
    //   70: iconst_2
    //   71: new 52	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   78: ldc 144
    //   80: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_1
    //   84: getfield 137	com/tencent/mobileqq/transfile/NetResp:jdField_e_of_type_Int	I
    //   87: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: ldc 10
    //   98: iconst_2
    //   99: new 52	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   106: ldc 149
    //   108: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: getfield 152	com/tencent/mobileqq/transfile/NetResp:f	I
    //   115: invokevirtual 147	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: ldc 10
    //   126: iconst_2
    //   127: new 52	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   134: ldc 154
    //   136: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_1
    //   140: getfield 156	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   143: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_0
    //   153: getfield 131	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Boolean	Z
    //   156: ifeq +243 -> 399
    //   159: aload_0
    //   160: getfield 159	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   163: astore 4
    //   165: aload_1
    //   166: getfield 137	com/tencent/mobileqq/transfile/NetResp:jdField_e_of_type_Int	I
    //   169: ifne +239 -> 408
    //   172: iload_3
    //   173: istore_2
    //   174: aload_0
    //   175: aload 4
    //   177: aload_1
    //   178: iload_2
    //   179: invokevirtual 162	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;Lcom/tencent/mobileqq/transfile/NetResp;Z)V
    //   182: aload_0
    //   183: aload_1
    //   184: getfield 163	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_Long	J
    //   187: putfield 164	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Long	J
    //   190: aload_0
    //   191: getfield 164	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Long	J
    //   194: lconst_0
    //   195: lcmp
    //   196: ifgt +19 -> 215
    //   199: aload_0
    //   200: aload_1
    //   201: getfield 166	com/tencent/mobileqq/transfile/NetResp:jdField_b_of_type_Long	J
    //   204: aload_1
    //   205: getfield 167	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_ComTencentMobileqqTransfileNetReq	Lcom/tencent/mobileqq/transfile/NetReq;
    //   208: getfield 170	com/tencent/mobileqq/transfile/NetReq:jdField_a_of_type_Long	J
    //   211: ladd
    //   212: putfield 164	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_Long	J
    //   215: aload_0
    //   216: aload_0
    //   217: getfield 171	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Long	J
    //   220: aload_1
    //   221: getfield 173	com/tencent/mobileqq/transfile/NetResp:jdField_c_of_type_Long	J
    //   224: ladd
    //   225: putfield 171	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Long	J
    //   228: aload_1
    //   229: getfield 137	com/tencent/mobileqq/transfile/NetResp:jdField_e_of_type_Int	I
    //   232: ifne +333 -> 565
    //   235: aload_0
    //   236: getfield 176	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   239: getfield 178	com/tencent/mobileqq/transfile/TransferRequest:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   242: astore 5
    //   244: aload 5
    //   246: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   249: ifne +189 -> 438
    //   252: aload_0
    //   253: getfield 176	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   256: getfield 77	com/tencent/mobileqq/transfile/TransferRequest:g	Ljava/lang/String;
    //   259: astore 6
    //   261: new 186	java/io/FileInputStream
    //   264: dup
    //   265: aload 6
    //   267: invokespecial 187	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   270: astore 4
    //   272: aload 4
    //   274: astore_1
    //   275: aload 4
    //   277: aload 4
    //   279: invokevirtual 191	java/io/FileInputStream:available	()I
    //   282: i2l
    //   283: invokestatic 197	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   286: astore 7
    //   288: aload 7
    //   290: ifnull +138 -> 428
    //   293: aload 4
    //   295: astore_1
    //   296: aload_0
    //   297: aload 7
    //   299: invokestatic 203	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   302: putfield 31	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:ae	Ljava/lang/String;
    //   305: aload 4
    //   307: astore_1
    //   308: aload_0
    //   309: getfield 31	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:ae	Ljava/lang/String;
    //   312: aload 5
    //   314: invokevirtual 206	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   317: ifne +111 -> 428
    //   320: aload 4
    //   322: astore_1
    //   323: aload_0
    //   324: getfield 176	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   327: getfield 208	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_Int	I
    //   330: bipush 6
    //   332: if_icmpeq +33 -> 365
    //   335: aload 4
    //   337: astore_1
    //   338: aload_0
    //   339: getfield 176	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   342: getfield 208	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_Int	I
    //   345: bipush 9
    //   347: if_icmpeq +18 -> 365
    //   350: aload 4
    //   352: astore_1
    //   353: aload_0
    //   354: getfield 176	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   357: getfield 208	com/tencent/mobileqq/transfile/TransferRequest:jdField_b_of_type_Int	I
    //   360: bipush 17
    //   362: if_icmpne +66 -> 428
    //   365: aload 4
    //   367: astore_1
    //   368: aload_0
    //   369: ldc 209
    //   371: ldc 211
    //   373: invokevirtual 214	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   376: aload 4
    //   378: astore_1
    //   379: aload_0
    //   380: invokevirtual 216	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   383: aload 4
    //   385: ifnull +8 -> 393
    //   388: aload 4
    //   390: invokevirtual 219	java/io/FileInputStream:close	()V
    //   393: return
    //   394: iconst_0
    //   395: istore_2
    //   396: goto -349 -> 47
    //   399: aload_0
    //   400: getfield 221	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo	Lcom/tencent/mobileqq/transfile/BaseTransProcessor$StepInfo;
    //   403: astore 4
    //   405: goto -240 -> 165
    //   408: iconst_0
    //   409: istore_2
    //   410: goto -236 -> 174
    //   413: astore_1
    //   414: aload_0
    //   415: sipush 9041
    //   418: ldc 223
    //   420: invokevirtual 214	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   423: aload_0
    //   424: invokevirtual 216	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   427: return
    //   428: aload 4
    //   430: ifnull +8 -> 438
    //   433: aload 4
    //   435: invokevirtual 219	java/io/FileInputStream:close	()V
    //   438: aload_0
    //   439: invokevirtual 225	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:e	()V
    //   442: return
    //   443: astore_1
    //   444: aload_0
    //   445: sipush 9041
    //   448: ldc 223
    //   450: invokevirtual 214	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   453: aload_0
    //   454: invokevirtual 216	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   457: return
    //   458: astore 5
    //   460: aconst_null
    //   461: astore 4
    //   463: aload 4
    //   465: astore_1
    //   466: aload_0
    //   467: aload 5
    //   469: invokevirtual 228	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(Ljava/io/IOException;)V
    //   472: aload 4
    //   474: astore_1
    //   475: aload_0
    //   476: sipush 9041
    //   479: new 52	java/lang/StringBuilder
    //   482: dup
    //   483: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   486: ldc 230
    //   488: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: aload 6
    //   493: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokevirtual 214	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   502: aload 4
    //   504: astore_1
    //   505: aload_0
    //   506: invokevirtual 216	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   509: aload 4
    //   511: ifnull -118 -> 393
    //   514: aload 4
    //   516: invokevirtual 219	java/io/FileInputStream:close	()V
    //   519: return
    //   520: astore_1
    //   521: aload_0
    //   522: sipush 9041
    //   525: ldc 223
    //   527: invokevirtual 214	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   530: aload_0
    //   531: invokevirtual 216	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   534: return
    //   535: astore 4
    //   537: aconst_null
    //   538: astore_1
    //   539: aload_1
    //   540: ifnull +7 -> 547
    //   543: aload_1
    //   544: invokevirtual 219	java/io/FileInputStream:close	()V
    //   547: aload 4
    //   549: athrow
    //   550: astore_1
    //   551: aload_0
    //   552: sipush 9041
    //   555: ldc 223
    //   557: invokevirtual 214	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   560: aload_0
    //   561: invokevirtual 216	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   564: return
    //   565: aload_0
    //   566: getfield 131	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:jdField_b_of_type_Boolean	Z
    //   569: ifeq +8 -> 577
    //   572: aload_0
    //   573: invokevirtual 105	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:c	()V
    //   576: return
    //   577: aload_1
    //   578: getfield 152	com/tencent/mobileqq/transfile/NetResp:f	I
    //   581: sipush 9364
    //   584: if_icmpne +38 -> 622
    //   587: aload_0
    //   588: getfield 233	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:aE	I
    //   591: iconst_3
    //   592: if_icmpge +30 -> 622
    //   595: aload_0
    //   596: ldc 235
    //   598: ldc 237
    //   600: invokevirtual 142	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   603: aload_0
    //   604: aload_0
    //   605: getfield 233	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:aE	I
    //   608: iconst_1
    //   609: iadd
    //   610: putfield 233	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:aE	I
    //   613: aload_0
    //   614: invokevirtual 240	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:o	()V
    //   617: aload_0
    //   618: invokevirtual 105	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:c	()V
    //   621: return
    //   622: aload_0
    //   623: aload_1
    //   624: getfield 152	com/tencent/mobileqq/transfile/NetResp:f	I
    //   627: aload_1
    //   628: getfield 156	com/tencent/mobileqq/transfile/NetResp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   631: invokevirtual 214	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:a	(ILjava/lang/String;)V
    //   634: aload_0
    //   635: invokevirtual 216	com/tencent/mobileqq/transfile/ShortVideoDownloadProcessor:d	()V
    //   638: return
    //   639: astore 4
    //   641: goto -102 -> 539
    //   644: astore 5
    //   646: goto -183 -> 463
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	649	0	this	ShortVideoDownloadProcessor
    //   0	649	1	paramNetResp	NetResp
    //   46	364	2	bool1	boolean
    //   1	172	3	bool2	boolean
    //   36	479	4	localObject1	java.lang.Object
    //   535	13	4	localObject2	java.lang.Object
    //   639	1	4	localObject3	java.lang.Object
    //   242	71	5	str1	String
    //   458	10	5	localIOException1	java.io.IOException
    //   644	1	5	localIOException2	java.io.IOException
    //   259	233	6	str2	String
    //   286	12	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   388	393	413	java/io/IOException
    //   433	438	443	java/io/IOException
    //   261	272	458	java/io/IOException
    //   514	519	520	java/io/IOException
    //   261	272	535	finally
    //   543	547	550	java/io/IOException
    //   275	288	639	finally
    //   296	305	639	finally
    //   308	320	639	finally
    //   323	335	639	finally
    //   338	350	639	finally
    //   353	365	639	finally
    //   368	376	639	finally
    //   379	383	639	finally
    //   466	472	639	finally
    //   475	502	639	finally
    //   505	509	639	finally
    //   275	288	644	java/io/IOException
    //   296	305	644	java/io/IOException
    //   308	320	644	java/io/IOException
    //   323	335	644	java/io/IOException
    //   338	350	644	java/io/IOException
    //   353	365	644	java/io/IOException
    //   368	376	644	java/io/IOException
    //   379	383	644	java/io/IOException
  }
  
  public void a(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
    int i;
    if (paramRichProtoResp != null) {
      i = 0;
    }
    for (;;)
    {
      if (i < paramRichProtoResp.jdField_a_of_type_JavaUtilList.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoDownResp)paramRichProtoResp.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          a("procUrl", paramRichProtoReq.toString());
        }
        a(this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo, paramRichProtoReq);
        this.jdField_a_of_type_JavaUtilArrayList = paramRichProtoReq.jdField_a_of_type_JavaUtilArrayList;
        if (paramRichProtoReq.jdField_c_of_type_Int != 0) {
          break;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- mIpList:" + this.jdField_a_of_type_JavaUtilArrayList);
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString);
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- downResp.md5:" + HexUtil.bytes2HexStr(paramRichProtoReq.jdField_a_of_type_ArrayOfByte));
        }
        this.jdField_e_of_type_JavaLangString = paramRichProtoReq.jdField_a_of_type_JavaLangString;
        String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString;
        if ((!TextUtils.isEmpty(str)) && (paramRichProtoReq.jdField_a_of_type_ArrayOfByte != null) && (!str.equals(HexUtil.bytes2HexStr(paramRichProtoReq.jdField_a_of_type_ArrayOfByte))))
        {
          a(-6103066, "申请信令阶段md5校验失败");
          d();
        }
      }
      else
      {
        return;
      }
      q();
      i += 1;
    }
    if (-5100026 == this.aC)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 安全打击mUiRequest.mMd5:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString);
      }
      a(-5100026, "安全打击");
    }
    for (;;)
    {
      d();
      return;
      if ((-9527 == this.aC) && ((this.T.equals("H_400_-5103017")) || (this.T.equals("H_400_-5103059"))))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoDownloadProcessor", 2, "onBusiProtoResp()---- 视频文件过期errCode=" + this.aC);
        }
        a(this.aC, "视频文件过期");
      }
      else
      {
        a(9045, "申请信令失败");
      }
    }
  }
  
  protected String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ServerAddr localServerAddr = (ServerAddr)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    localStringBuilder.append("http://");
    localStringBuilder.append(localServerAddr.jdField_a_of_type_JavaLangString);
    if (localServerAddr.jdField_b_of_type_Int != 80)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(localServerAddr.jdField_b_of_type_Int);
    }
    localStringBuilder.append("/qqdownload?ver=");
    localStringBuilder.append("3468");
    localStringBuilder.append("&rkey=");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("&filetype=");
    localStringBuilder.append(this.as);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "getConnUrl()---------- url = " + localStringBuilder.toString());
    }
    localStringBuilder.append("&mType=shortVideo");
    return localStringBuilder.toString();
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.ShortVideoDownReq localShortVideoDownReq = new RichProto.RichProtoReq.ShortVideoDownReq();
    localShortVideoDownReq.jdField_d_of_type_Int = ((int)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + localShortVideoDownReq.jdField_d_of_type_Int);
    }
    localShortVideoDownReq.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_JavaLangString;
    localShortVideoDownReq.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localShortVideoDownReq.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_c_of_type_JavaLangString;
    localShortVideoDownReq.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localShortVideoDownReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString;
    localShortVideoDownReq.jdField_e_of_type_Int = 0;
    if (localShortVideoDownReq.jdField_c_of_type_Int == 0) {
      localShortVideoDownReq.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      localShortVideoDownReq.jdField_b_of_type_Int = 2;
      localShortVideoDownReq.jdField_a_of_type_JavaLangString = this.ad;
      localShortVideoDownReq.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProtoProc$RichProtoCallback = this;
      localRichProtoReq.jdField_a_of_type_JavaLangString = "short_video_dw";
      localRichProtoReq.jdField_a_of_type_JavaUtilList.add(localShortVideoDownReq);
      localRichProtoReq.jdField_a_of_type_ComTencentMobileqqTransfileProtoReqManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (d()) {
        break;
      }
      a(9366, "illegal app", null, this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
      return;
      if (1 == localShortVideoDownReq.jdField_c_of_type_Int) {
        localShortVideoDownReq.jdField_a_of_type_Int = 1;
      } else if (3000 == localShortVideoDownReq.jdField_c_of_type_Int) {
        localShortVideoDownReq.jdField_a_of_type_Int = 2;
      } else {
        localShortVideoDownReq.jdField_a_of_type_Int = 3;
      }
    }
    if (QLog.isColorLevel()) {
      a("requestStart", localRichProtoReq.toString());
    }
    if (!e())
    {
      jdField_a_of_type_JavaUtilHashSet.remove(this.ad);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = localRichProtoReq;
    RichProtoProc.a(localRichProtoReq);
  }
  
  protected void c(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.c(this.aC))) {}
    while ((this.jdField_c_of_type_Boolean) || ((paramBoolean) && ((this.aF & 0x2) > 0)) || ((!paramBoolean) && ((this.aF & 0x1) > 0))) {
      return;
    }
    int j = this.aF;
    int i;
    String str1;
    label88:
    long l;
    if (paramBoolean)
    {
      i = 2;
      this.aF = (i | j);
      str1 = "actShortVideoDownloadVideo";
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 7) {
        break label326;
      }
      str1 = "actShortVideoDownloadThumb";
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoDownloadProcessor", 2, "reportTag = " + str1);
      }
      l = (System.nanoTime() - this.jdField_c_of_type_Long) / 1000000L;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(1) + ";" + this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(2) + ";" + this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a(3);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_step", str2);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_fromUin", this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_iplist", this.jdField_a_of_type_JavaUtilArrayList.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_uuid", this.ad);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long));
      if (!paramBoolean) {
        break label410;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, true, l, this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      n();
      return;
      i = 1;
      break;
      label326:
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 6)
      {
        str1 = "actShortVideoDownloadVideo";
        break label88;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 16) || (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int == 18))
      {
        str1 = "actShortVideoDiscussgroupDownloadThumb";
        break label88;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 9) && (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int != 17)) {
        break label88;
      }
      str1 = "actShortVideoDiscussgroupDownloadVideo";
      break label88;
      label410:
      if (this.aC != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.aC));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.T);
      if (this.aC == -6103066) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_picmd5", "uierquest md5=" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_e_of_type_JavaLangString + "fileMd5=" + this.ae);
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, str1, false, l, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  void d()
  {
    super.d();
    jdField_a_of_type_JavaUtilHashSet.remove(this.ad);
    if (-5100026 == this.aC) {
      d(5001);
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errCode:" + this.aC);
        QLog.d("ShortVideoDownloadProcessor", 2, "onError()---- errDesc:" + this.T);
      }
      return;
      if ((-9527 == this.aC) && ((this.T.equals("H_400_-5103017")) || (this.T.equals("H_400_-5103059")))) {
        d(5002);
      } else {
        d(2005);
      }
    }
  }
  
  protected void d(int paramInt)
  {
    super.d(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "sendMessageToUpdate state = " + paramInt);
    }
    if ((this.jdField_e_of_type_Boolean) && (2004 != paramInt)) {
      return;
    }
    ShortVideoBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g == null)
    {
      a(9302, "下载路径文件保存路径未指定。");
      d();
      return -1;
    }
    this.h = true;
    return 0;
  }
  
  void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "successfully downloaded.");
    }
    jdField_a_of_type_JavaUtilHashSet.remove(this.ad);
    d(2003);
  }
  
  public int f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "resume()");
    }
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      this.i = false;
      d(2001);
      this.aC = 0;
      this.T = "";
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a.post(new kay(this));
    }
    return 0;
  }
  
  public int g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "cancel()");
    }
    jdField_a_of_type_JavaUtilHashSet.remove(this.ad);
    return super.g();
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoDownloadProcessor", 2, "pause() mIsPause : " + this.jdField_e_of_type_Boolean);
    }
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = true;
      d(2004);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq != null)
      {
        RichProtoProc.b(this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileProtohandlerRichProto$RichProtoReq = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.b(this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = null;
      }
    }
  }
  
  void q()
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    String str = c();
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = str;
    localHttpNetReq.jdField_c_of_type_Int = 0;
    localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localHttpNetReq.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.g;
    localHttpNetReq.jdField_d_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localHttpNetReq.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localHttpNetReq.m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    localHttpNetReq.jdField_a_of_type_Long = 0L;
    ShortVideoUtils.a(localHttpNetReq.jdField_b_of_type_JavaLangString, localHttpNetReq.jdField_a_of_type_JavaLangString);
    localHttpNetReq.jdField_b_of_type_Boolean = true;
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix = jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix;
    a("httpDown", "url:" + str + ",downOffset:" + localHttpNetReq.jdField_a_of_type_Long);
    if (!e())
    {
      jdField_a_of_type_JavaUtilHashSet.remove(this.ad);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = localHttpNetReq;
    p();
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */