package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseUploadProcessor
  extends BaseTransProcessor
{
  static final int aM = 32768;
  static final int aN = 131072;
  static final int av = 14600;
  public long a;
  public Transaction a;
  SSCM jdField_a_of_type_ComTencentWsttSSCMSSCM = new SSCM();
  RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean a;
  byte[] jdField_a_of_type_ArrayOfByte;
  public int aO = 0;
  String ac;
  String ad;
  int aq;
  int ar;
  int as = 0;
  int at = 0;
  int au = 0;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean = false;
  String c;
  String d;
  String e;
  String f;
  public long h = 0L;
  long i = 20480L;
  public long j;
  boolean k = false;
  boolean l = false;
  protected boolean m = false;
  
  public BaseUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = null;
    b(paramTransferRequest.jdField_b_of_type_JavaLangString + paramTransferRequest.jdField_a_of_type_Long);
    this.jdField_a_of_type_Boolean = paramTransferRequest.jdField_e_of_type_Boolean;
  }
  
  protected long a(long paramLong)
  {
    long l1 = this.jdField_a_of_type_Long;
    return Math.min(this.i, l1 - paramLong);
  }
  
  protected HttpNetReq a(byte[] paramArrayOfByte)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_a_of_type_JavaLangString = a(paramArrayOfByte);
    localHttpNetReq.c = 1;
    localHttpNetReq.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    localHttpNetReq.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilArrayList;
    localHttpNetReq.d = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long);
    localHttpNetReq.n = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int;
    localHttpNetReq.m = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_b_of_type_Int;
    localHttpNetReq.jdField_b_of_type_Boolean = true;
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Range", "bytes=" + this.h + "-");
    localHttpNetReq.jdField_a_of_type_JavaUtilHashMap.put("Accept-Encoding", "identity");
    return localHttpNetReq;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 1, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 1, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(true, 0, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  final void a(PBUInt32Field paramPBUInt32Field)
  {
    int i1 = paramPBUInt32Field.get();
    int n;
    if ("jpg".equals(this.jdField_e_of_type_JavaLangString)) {
      n = i1 | 0x1000;
    }
    for (;;)
    {
      paramPBUInt32Field.set(n);
      return;
      if ("pjpg".equals(this.jdField_e_of_type_JavaLangString))
      {
        n = i1 | 0x1003;
      }
      else if ("png".equals(this.jdField_e_of_type_JavaLangString))
      {
        n = i1 | 0x1001;
      }
      else if ("bmp".equals(this.jdField_e_of_type_JavaLangString))
      {
        n = i1 | 0x1005;
      }
      else if ("gif".equals(this.jdField_e_of_type_JavaLangString))
      {
        n = i1 | 0x2000;
      }
      else if ("apng".equals(this.jdField_e_of_type_JavaLangString))
      {
        n = i1 | 0x2001;
      }
      else if ("sharpp".equals(this.jdField_e_of_type_JavaLangString))
      {
        n = i1 | 0x1004;
      }
      else
      {
        n = i1;
        if ("webp".equals(this.jdField_e_of_type_JavaLangString)) {
          n = i1 | 0x1002;
        }
      }
    }
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    try
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile.seek(paramInt1);
      byte[] arrayOfByte = new byte[paramInt2];
      int n = 0;
      paramInt1 = paramInt2;
      while (n < paramInt2)
      {
        int i1 = this.jdField_a_of_type_JavaIoRandomAccessFile.read(arrayOfByte, n, paramInt1);
        if (i1 == -1)
        {
          a(9303, "fileSize not enough");
          this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.b();
          return null;
        }
        n += i1;
        paramInt1 -= i1;
      }
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      localIOException.printStackTrace();
    }
    return null;
  }
  
  protected void c()
  {
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    long l1 = this.h;
    long l2 = a(l1);
    Object localObject = a((int)l1, (int)l2);
    if (localObject == null) {
      d();
    }
    do
    {
      return;
      a("sendingdata", "pos:" + l1 + "  transferData len:" + localObject.length);
      localObject = a((byte[])localObject);
      if (l1 + l2 >= this.jdField_a_of_type_Long) {
        ((HttpNetReq)localObject).jdField_a_of_type_JavaUtilHashMap.put("Connection", "close");
      }
    } while (!e());
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetReq = ((NetReq)localObject);
    p();
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a((NetReq)localObject);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, paramString);
    }
  }
  
  public int f()
  {
    return super.f();
  }
  
  /* Error */
  boolean f()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 137	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   4: getfield 308	com/tencent/mobileqq/transfile/TransferRequest:h	Ljava/lang/String;
    //   7: astore 4
    //   9: new 310	java/io/FileInputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 312	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_3
    //   19: aload_3
    //   20: astore_2
    //   21: aload_0
    //   22: aload_3
    //   23: aload_0
    //   24: getfield 315	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   27: getfield 318	com/tencent/mobileqq/transfile/FileMsg:jdField_a_of_type_Long	J
    //   30: invokestatic 324	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   33: putfield 325	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   36: aload_3
    //   37: astore_2
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 325	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   43: invokestatic 330	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   46: putfield 331	com/tencent/mobileqq/transfile/BaseUploadProcessor:d	Ljava/lang/String;
    //   49: aload_3
    //   50: astore_2
    //   51: aload_0
    //   52: aload_0
    //   53: getfield 331	com/tencent/mobileqq/transfile/BaseUploadProcessor:d	Ljava/lang/String;
    //   56: putfield 333	com/tencent/mobileqq/transfile/BaseUploadProcessor:c	Ljava/lang/String;
    //   59: aload_3
    //   60: astore_2
    //   61: aload_0
    //   62: getfield 315	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ComTencentMobileqqTransfileFileMsg	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   65: aload_0
    //   66: getfield 331	com/tencent/mobileqq/transfile/BaseUploadProcessor:d	Ljava/lang/String;
    //   69: putfield 334	com/tencent/mobileqq/transfile/FileMsg:h	Ljava/lang/String;
    //   72: aload_3
    //   73: astore_2
    //   74: aload_0
    //   75: new 83	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   82: aload_0
    //   83: getfield 331	com/tencent/mobileqq/transfile/BaseUploadProcessor:d	Ljava/lang/String;
    //   86: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 336
    //   92: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_0
    //   96: getfield 194	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   99: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: putfield 331	com/tencent/mobileqq/transfile/BaseUploadProcessor:d	Ljava/lang/String;
    //   108: aload_3
    //   109: ifnull +7 -> 116
    //   112: aload_3
    //   113: invokevirtual 338	java/io/FileInputStream:close	()V
    //   116: iconst_1
    //   117: istore_1
    //   118: iload_1
    //   119: ireturn
    //   120: astore_2
    //   121: aload_3
    //   122: astore_2
    //   123: new 340	java/io/File
    //   126: dup
    //   127: aload 4
    //   129: invokespecial 341	java/io/File:<init>	(Ljava/lang/String;)V
    //   132: astore 4
    //   134: aload_3
    //   135: astore_2
    //   136: aload 4
    //   138: invokevirtual 344	java/io/File:exists	()Z
    //   141: istore_1
    //   142: iload_1
    //   143: ifeq -107 -> 36
    //   146: aload_3
    //   147: astore_2
    //   148: aload 4
    //   150: invokestatic 349	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/io/File;)Ljava/lang/String;
    //   153: astore 4
    //   155: aload 4
    //   157: ifnull +17 -> 174
    //   160: aload_3
    //   161: astore_2
    //   162: aload_0
    //   163: aload 4
    //   165: invokestatic 353	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   168: putfield 325	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   171: goto -135 -> 36
    //   174: ldc_w 355
    //   177: astore 4
    //   179: goto -19 -> 160
    //   182: astore_2
    //   183: aload_2
    //   184: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   187: goto -71 -> 116
    //   190: astore 4
    //   192: aconst_null
    //   193: astore_3
    //   194: aload_3
    //   195: astore_2
    //   196: aload_0
    //   197: aconst_null
    //   198: putfield 325	com/tencent/mobileqq/transfile/BaseUploadProcessor:jdField_a_of_type_ArrayOfByte	[B
    //   201: aload_3
    //   202: astore_2
    //   203: aload_0
    //   204: aload 4
    //   206: invokevirtual 246	com/tencent/mobileqq/transfile/BaseUploadProcessor:a	(Ljava/io/IOException;)V
    //   209: iconst_0
    //   210: istore_1
    //   211: aload_3
    //   212: ifnull -94 -> 118
    //   215: aload_3
    //   216: invokevirtual 338	java/io/FileInputStream:close	()V
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_2
    //   222: aload_2
    //   223: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   226: iconst_0
    //   227: ireturn
    //   228: astore_3
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_2
    //   232: ifnull +7 -> 239
    //   235: aload_2
    //   236: invokevirtual 338	java/io/FileInputStream:close	()V
    //   239: aload_3
    //   240: athrow
    //   241: astore_2
    //   242: aload_2
    //   243: invokevirtual 249	java/io/IOException:printStackTrace	()V
    //   246: goto -7 -> 239
    //   249: astore_3
    //   250: goto -19 -> 231
    //   253: astore 4
    //   255: goto -61 -> 194
    //   258: astore_2
    //   259: goto -223 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	BaseUploadProcessor
    //   117	94	1	bool	boolean
    //   20	54	2	localFileInputStream1	java.io.FileInputStream
    //   120	1	2	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   122	40	2	localFileInputStream2	java.io.FileInputStream
    //   182	2	2	localIOException1	IOException
    //   195	8	2	localFileInputStream3	java.io.FileInputStream
    //   221	2	2	localIOException2	IOException
    //   230	6	2	localObject1	Object
    //   241	2	2	localIOException3	IOException
    //   258	1	2	localIOException4	IOException
    //   18	198	3	localFileInputStream4	java.io.FileInputStream
    //   228	12	3	localObject2	Object
    //   249	1	3	localObject3	Object
    //   7	171	4	localObject4	Object
    //   190	15	4	localIOException5	IOException
    //   253	1	4	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   21	36	120	java/lang/UnsatisfiedLinkError
    //   112	116	182	java/io/IOException
    //   9	19	190	java/io/IOException
    //   215	219	221	java/io/IOException
    //   9	19	228	finally
    //   235	239	241	java/io/IOException
    //   21	36	249	finally
    //   38	49	249	finally
    //   51	59	249	finally
    //   61	72	249	finally
    //   74	108	249	finally
    //   123	134	249	finally
    //   136	142	249	finally
    //   148	155	249	finally
    //   162	171	249	finally
    //   196	201	249	finally
    //   203	209	249	finally
    //   21	36	253	java/io/IOException
    //   38	49	253	java/io/IOException
    //   51	59	253	java/io/IOException
    //   61	72	253	java/io/IOException
    //   74	108	253	java/io/IOException
    //   123	134	253	java/io/IOException
    //   136	142	253	java/io/IOException
    //   148	155	258	java/io/IOException
    //   162	171	258	java/io/IOException
  }
  
  public int g()
  {
    return super.g();
  }
  
  public void i()
  {
    super.i();
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        a("pause", "");
      }
      d(1004);
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
  
  protected void q()
  {
    int n = 1;
    if ((this.aO == 2) && (!this.jdField_a_of_type_JavaUtilHashMap.containsKey("param_BdhTrans"))) {
      if ((this.f > 0L) && (this.g > 0L))
      {
        if ((this.j) && (n != 0))
        {
          this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
          this.jdField_a_of_type_JavaLangStringBuilder.append("s").append(this.aL).append("_").append("tr").append(this.f).append("_").append("ht").append(this.jdField_e_of_type_Long).append("_").append("pic").append(this.g).append(";");
          this.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.g));
          this.jdField_a_of_type_JavaUtilHashMap.put("param_CostEach", this.jdField_a_of_type_JavaLangStringBuilder.toString());
          this.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(this.aL));
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("sn:").append(this.aL).append(";").append("tc_s:").append(this.f).append(";").append("tc_h:").append(this.jdField_e_of_type_Long).append(";").append("tc_p:").append(this.g).append(";");
        this.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", localStringBuilder.toString());
      }
    }
    while ((this.aO != 1) || (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction == null)) {
      for (;;)
      {
        StringBuilder localStringBuilder;
        return;
        n = 0;
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.timeCost_Cache));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseUploadProcessor
 * JD-Core Version:    0.7.0.1
 */