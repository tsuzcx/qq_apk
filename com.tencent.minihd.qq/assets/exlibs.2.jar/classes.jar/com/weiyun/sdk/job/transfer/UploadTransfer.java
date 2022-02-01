package com.weiyun.sdk.job.transfer;

import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.BaseUploadJob;
import com.weiyun.sdk.job.UploadJobContext;
import com.weiyun.sdk.job.af.AddressFetcher.UploadAddress;
import com.weiyun.sdk.job.api.StoragePlatomProto;
import com.weiyun.sdk.job.api.UploadTaskRequestRetryHandler;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.util.NetworkUtils;
import com.weiyun.sdk.util.UtilsMisc;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

public class UploadTransfer
  implements Transfer
{
  private static final long FILE_SIZE_4G = 4294967296L;
  private static final String TAG = "UploadTransfer";
  protected final AddressFetcher.UploadAddress mAddress;
  protected final UploadJobContext mContext;
  protected final byte[] mFileHash;
  protected DefaultHttpClient mHttpClient = null;
  protected final BaseUploadJob mJob;
  protected int mRewardThreshold = 4;
  protected int mSliceSize = 0;
  protected int mSuccSliceTimes = 0;
  protected int mTimeoutTimes = 0;
  protected final byte[] mUkey;
  
  public UploadTransfer(AddressFetcher.UploadAddress paramUploadAddress, UploadJobContext paramUploadJobContext, BaseUploadJob paramBaseUploadJob)
  {
    this.mContext = paramUploadJobContext;
    this.mAddress = paramUploadAddress;
    this.mJob = paramBaseUploadJob;
    this.mUkey = UtilsMisc.hexStringToByteArray(this.mAddress.getUKey());
    this.mFileHash = UtilsMisc.hexStringToByteArray(this.mContext.getSha());
  }
  
  private void adjustProgress(StoragePlatomProto paramStoragePlatomProto, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mJob.getId());
    localStringBuilder.append(", server's offset: ");
    localStringBuilder.append(paramStoragePlatomProto.getUploadRspNextOffset());
    localStringBuilder.append(", local's offset: ");
    localStringBuilder.append(paramLong);
    Log.v("UploadTransfer", localStringBuilder.toString());
    if (paramLong != paramStoragePlatomProto.getUploadRspNextOffset()) {
      this.mContext.setCurSize(paramStoragePlatomProto.getUploadRspNextOffset());
    }
    for (;;)
    {
      this.mJob.notifyProgressChanged(this.mContext.getCurSize(), this.mContext.getTotalSize());
      return;
      this.mContext.setCurSize(paramLong);
    }
  }
  
  private void closeFile(RandomAccessFile paramRandomAccessFile)
  {
    if (paramRandomAccessFile != null) {}
    try
    {
      paramRandomAccessFile.close();
      return;
    }
    catch (IOException paramRandomAccessFile)
    {
      for (;;)
      {
        Log.w("UploadTransfer", "close file failed!");
      }
    }
  }
  
  private void closeHttpClient()
  {
    if (this.mHttpClient != null)
    {
      this.mHttpClient.getConnectionManager().shutdown();
      this.mHttpClient = null;
    }
  }
  
  /* Error */
  private int httpPostData(StoragePlatomProto paramStoragePlatomProto, URL paramURL, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 163	com/weiyun/sdk/job/transfer/ByteArrayPool:getInstance	()Lcom/weiyun/sdk/job/transfer/ByteArrayPool;
    //   3: invokevirtual 167	com/weiyun/sdk/job/transfer/ByteArrayPool:createBuffer	()Lcom/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer;
    //   6: astore 28
    //   8: new 77	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   15: astore 29
    //   17: aconst_null
    //   18: astore 22
    //   20: iconst_0
    //   21: istore 8
    //   23: aload_0
    //   24: iconst_0
    //   25: putfield 39	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   28: iconst_0
    //   29: istore 9
    //   31: iconst_0
    //   32: istore 13
    //   34: iconst_0
    //   35: istore 12
    //   37: aconst_null
    //   38: astore 23
    //   40: iload 12
    //   42: iconst_3
    //   43: if_icmplt +14 -> 57
    //   46: iload 9
    //   48: ifeq +2009 -> 2057
    //   51: iload 13
    //   53: iconst_3
    //   54: if_icmpge +2003 -> 2057
    //   57: aload_0
    //   58: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   61: invokevirtual 171	com/weiyun/sdk/job/BaseUploadJob:isAlive	()Z
    //   64: ifne +38 -> 102
    //   67: ldc 14
    //   69: ldc 173
    //   71: invokestatic 176	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: sipush -10002
    //   77: istore 4
    //   79: invokestatic 163	com/weiyun/sdk/job/transfer/ByteArrayPool:getInstance	()Lcom/weiyun/sdk/job/transfer/ByteArrayPool;
    //   82: astore_1
    //   83: iload 4
    //   85: ifne +1934 -> 2019
    //   88: iconst_1
    //   89: istore 19
    //   91: aload_1
    //   92: aload 28
    //   94: iload 19
    //   96: invokevirtual 180	com/weiyun/sdk/job/transfer/ByteArrayPool:freeBuffer	(Lcom/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer;Z)V
    //   99: iload 4
    //   101: ireturn
    //   102: iload 5
    //   104: istore 14
    //   106: iload 5
    //   108: sipush 8192
    //   111: if_icmple +48 -> 159
    //   114: iload 12
    //   116: i2d
    //   117: dstore 6
    //   119: iload 9
    //   121: istore 10
    //   123: aload 22
    //   125: astore 24
    //   127: iload 9
    //   129: istore 11
    //   131: aload 22
    //   133: astore 26
    //   135: aload 22
    //   137: astore 27
    //   139: iload 5
    //   141: ldc2_w 181
    //   144: dload 6
    //   146: invokestatic 188	java/lang/Math:pow	(DD)D
    //   149: d2i
    //   150: idiv
    //   151: sipush 8192
    //   154: invokestatic 192	java/lang/Math:max	(II)I
    //   157: istore 14
    //   159: iload 9
    //   161: istore 10
    //   163: aload 22
    //   165: astore 24
    //   167: iload 9
    //   169: istore 11
    //   171: aload 22
    //   173: astore 26
    //   175: aload 22
    //   177: astore 27
    //   179: aload_1
    //   180: aload_0
    //   181: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   184: invokevirtual 116	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   187: iload 14
    //   189: aload_3
    //   190: iconst_0
    //   191: iload 4
    //   193: invokevirtual 196	com/weiyun/sdk/job/api/StoragePlatomProto:buildUploadRequestHead	(JI[BII)I
    //   196: istore 15
    //   198: iload 9
    //   200: istore 10
    //   202: aload 22
    //   204: astore 24
    //   206: iload 9
    //   208: istore 11
    //   210: aload 22
    //   212: astore 26
    //   214: aload 22
    //   216: astore 27
    //   218: aload_0
    //   219: aload_2
    //   220: invokevirtual 200	com/weiyun/sdk/job/transfer/UploadTransfer:configHttpClient	(Ljava/net/URL;)Lorg/apache/http/client/methods/HttpPost;
    //   223: astore 25
    //   225: iload 9
    //   227: istore 10
    //   229: aload 22
    //   231: astore 24
    //   233: iload 9
    //   235: istore 11
    //   237: aload 22
    //   239: astore 26
    //   241: aload 22
    //   243: astore 27
    //   245: aload 25
    //   247: new 202	com/weiyun/sdk/job/api/SppByteArrayEntity
    //   250: dup
    //   251: aload_3
    //   252: iconst_0
    //   253: iload 14
    //   255: iload 15
    //   257: iadd
    //   258: invokespecial 205	com/weiyun/sdk/job/api/SppByteArrayEntity:<init>	([BII)V
    //   261: invokevirtual 211	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   264: iconst_0
    //   265: istore 9
    //   267: iconst_0
    //   268: istore 17
    //   270: iconst_0
    //   271: istore 16
    //   273: iconst_0
    //   274: istore 18
    //   276: iconst_0
    //   277: istore 15
    //   279: iload 9
    //   281: istore 10
    //   283: aload 22
    //   285: astore 24
    //   287: iload 16
    //   289: istore 11
    //   291: aload 22
    //   293: astore 26
    //   295: aload 22
    //   297: astore 27
    //   299: aload_0
    //   300: getfield 37	com/weiyun/sdk/job/transfer/UploadTransfer:mHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   303: aload 25
    //   305: invokevirtual 215	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   308: astore 22
    //   310: aload 22
    //   312: ifnonnull +95 -> 407
    //   315: iload 9
    //   317: istore 10
    //   319: aload 22
    //   321: astore 24
    //   323: iload 16
    //   325: istore 11
    //   327: aload 22
    //   329: astore 26
    //   331: aload 22
    //   333: astore 27
    //   335: aload_0
    //   336: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   339: iload 8
    //   341: istore 9
    //   343: aload 22
    //   345: ifnull +1693 -> 2038
    //   348: iload 8
    //   350: istore 9
    //   352: aload 22
    //   354: invokeinterface 223 1 0
    //   359: ifnull +1679 -> 2038
    //   362: aload 22
    //   364: invokeinterface 223 1 0
    //   369: invokeinterface 228 1 0
    //   374: aload 22
    //   376: astore 24
    //   378: iload 13
    //   380: istore 11
    //   382: iload 15
    //   384: istore 10
    //   386: iload 12
    //   388: iconst_1
    //   389: iadd
    //   390: istore 12
    //   392: iload 10
    //   394: istore 9
    //   396: iload 11
    //   398: istore 13
    //   400: aload 24
    //   402: astore 22
    //   404: goto -364 -> 40
    //   407: iload 9
    //   409: istore 10
    //   411: aload 22
    //   413: astore 24
    //   415: iload 16
    //   417: istore 11
    //   419: aload 22
    //   421: astore 26
    //   423: aload 22
    //   425: astore 27
    //   427: aload 22
    //   429: invokeinterface 232 1 0
    //   434: invokeinterface 238 1 0
    //   439: istore 8
    //   441: iload 8
    //   443: sipush 200
    //   446: if_icmpeq +703 -> 1149
    //   449: iload 9
    //   451: istore 10
    //   453: aload 22
    //   455: astore 24
    //   457: iload 16
    //   459: istore 11
    //   461: aload 22
    //   463: astore 26
    //   465: aload 22
    //   467: astore 27
    //   469: aload 29
    //   471: iconst_0
    //   472: aload 29
    //   474: invokevirtual 241	java/lang/StringBuilder:length	()I
    //   477: invokevirtual 245	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: iload 9
    //   483: istore 10
    //   485: aload 22
    //   487: astore 24
    //   489: iload 16
    //   491: istore 11
    //   493: aload 22
    //   495: astore 26
    //   497: aload 22
    //   499: astore 27
    //   501: aload 29
    //   503: ldc 247
    //   505: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: iload 8
    //   510: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   513: ldc 252
    //   515: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload_1
    //   519: invokevirtual 255	com/weiyun/sdk/job/api/StoragePlatomProto:getUploadRspErrCode	()I
    //   522: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: iload 9
    //   528: istore 10
    //   530: aload 22
    //   532: astore 24
    //   534: iload 16
    //   536: istore 11
    //   538: aload 22
    //   540: astore 26
    //   542: aload 22
    //   544: astore 27
    //   546: ldc 14
    //   548: aload 29
    //   550: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   553: invokestatic 137	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: iload 8
    //   558: sipush 30000
    //   561: isub
    //   562: istore 14
    //   564: iload 9
    //   566: istore 10
    //   568: aload 22
    //   570: astore 24
    //   572: iload 16
    //   574: istore 11
    //   576: aload 22
    //   578: astore 26
    //   580: aload 22
    //   582: astore 27
    //   584: aload 22
    //   586: ldc_w 257
    //   589: invokeinterface 261 2 0
    //   594: astore 25
    //   596: iload 14
    //   598: istore 8
    //   600: aload 25
    //   602: ifnull +137 -> 739
    //   605: iload 14
    //   607: istore 8
    //   609: iload 9
    //   611: istore 10
    //   613: aload 22
    //   615: astore 24
    //   617: iload 16
    //   619: istore 11
    //   621: aload 22
    //   623: astore 26
    //   625: aload 22
    //   627: astore 27
    //   629: aload 25
    //   631: arraylength
    //   632: ifle +107 -> 739
    //   635: iload 9
    //   637: istore 10
    //   639: aload 22
    //   641: astore 24
    //   643: iload 16
    //   645: istore 11
    //   647: aload 22
    //   649: astore 26
    //   651: aload 22
    //   653: astore 27
    //   655: aload 25
    //   657: iconst_0
    //   658: aaload
    //   659: invokeinterface 266 1 0
    //   664: astore 25
    //   666: iload 9
    //   668: istore 10
    //   670: aload 22
    //   672: astore 24
    //   674: iload 16
    //   676: istore 11
    //   678: aload 22
    //   680: astore 26
    //   682: aload 22
    //   684: astore 27
    //   686: ldc 14
    //   688: new 77	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   695: ldc_w 268
    //   698: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload 25
    //   703: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 137	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   712: iload 9
    //   714: istore 10
    //   716: aload 22
    //   718: astore 24
    //   720: iload 16
    //   722: istore 11
    //   724: aload 22
    //   726: astore 26
    //   728: aload 22
    //   730: astore 27
    //   732: aload 25
    //   734: invokestatic 274	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   737: istore 8
    //   739: iload 9
    //   741: istore 10
    //   743: aload 22
    //   745: astore 24
    //   747: iload 16
    //   749: istore 11
    //   751: aload 22
    //   753: astore 26
    //   755: aload 22
    //   757: astore 27
    //   759: aload_0
    //   760: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   763: iload 8
    //   765: istore 9
    //   767: aload 22
    //   769: ifnull +1269 -> 2038
    //   772: iload 8
    //   774: istore 9
    //   776: aload 22
    //   778: invokeinterface 223 1 0
    //   783: ifnull +1255 -> 2038
    //   786: aload 22
    //   788: invokeinterface 223 1 0
    //   793: invokeinterface 228 1 0
    //   798: iload 15
    //   800: istore 10
    //   802: iload 13
    //   804: istore 11
    //   806: aload 22
    //   808: astore 24
    //   810: goto -424 -> 386
    //   813: astore 25
    //   815: iload 9
    //   817: istore 10
    //   819: aload 22
    //   821: astore 24
    //   823: iload 16
    //   825: istore 11
    //   827: aload 22
    //   829: astore 26
    //   831: aload 22
    //   833: astore 27
    //   835: ldc 14
    //   837: aload 25
    //   839: invokestatic 277	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   842: iload 14
    //   844: istore 8
    //   846: goto -107 -> 739
    //   849: astore 26
    //   851: aload 24
    //   853: astore 22
    //   855: iload 10
    //   857: istore 8
    //   859: aload 23
    //   861: astore 25
    //   863: aload 26
    //   865: astore 24
    //   867: aload 22
    //   869: astore 23
    //   871: aload 24
    //   873: invokestatic 283	com/weiyun/sdk/util/ErrCodeUtil:getErrCodeFromIOException	(Ljava/io/IOException;)I
    //   876: istore 11
    //   878: aload 22
    //   880: astore 23
    //   882: ldc 14
    //   884: new 77	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   891: ldc_w 285
    //   894: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: iload 11
    //   899: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   902: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: aload 24
    //   907: invokestatic 289	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   910: aload 25
    //   912: astore 26
    //   914: iload 11
    //   916: istore 9
    //   918: iload 8
    //   920: istore 10
    //   922: aload 22
    //   924: astore 27
    //   926: aload 22
    //   928: ifnull +57 -> 985
    //   931: aload 25
    //   933: astore 26
    //   935: iload 11
    //   937: istore 9
    //   939: iload 8
    //   941: istore 10
    //   943: aload 22
    //   945: astore 27
    //   947: aload 22
    //   949: invokeinterface 223 1 0
    //   954: ifnull +31 -> 985
    //   957: aload 22
    //   959: invokeinterface 223 1 0
    //   964: invokeinterface 228 1 0
    //   969: aload 22
    //   971: astore 27
    //   973: iload 8
    //   975: istore 10
    //   977: iload 11
    //   979: istore 9
    //   981: aload 25
    //   983: astore 26
    //   985: aload_0
    //   986: iconst_0
    //   987: putfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   990: aload_0
    //   991: aload_0
    //   992: getfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mRewardThreshold	I
    //   995: i2d
    //   996: ldc2_w 290
    //   999: dmul
    //   1000: d2i
    //   1001: putfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mRewardThreshold	I
    //   1004: iload 9
    //   1006: sipush -30002
    //   1009: if_icmpne +909 -> 1918
    //   1012: aload_0
    //   1013: aload_0
    //   1014: getfield 39	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   1017: iconst_1
    //   1018: iadd
    //   1019: putfield 39	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   1022: iload 9
    //   1024: sipush -30024
    //   1027: if_icmpeq +107 -> 1134
    //   1030: iload 9
    //   1032: sipush -30001
    //   1035: if_icmpeq +99 -> 1134
    //   1038: iload 9
    //   1040: sipush -30002
    //   1043: if_icmpeq +91 -> 1134
    //   1046: iload 9
    //   1048: sipush -30010
    //   1051: if_icmpeq +83 -> 1134
    //   1054: iload 9
    //   1056: sipush -30014
    //   1059: if_icmpeq +75 -> 1134
    //   1062: iload 9
    //   1064: sipush -30015
    //   1067: if_icmpeq +67 -> 1134
    //   1070: iload 9
    //   1072: sipush -30018
    //   1075: if_icmpeq +59 -> 1134
    //   1078: iload 9
    //   1080: sipush -30023
    //   1083: if_icmpeq +51 -> 1134
    //   1086: iload 9
    //   1088: sipush -30090
    //   1091: if_icmpeq +43 -> 1134
    //   1094: iload 9
    //   1096: sipush -30025
    //   1099: if_icmpeq +35 -> 1134
    //   1102: iload 9
    //   1104: sipush -30091
    //   1107: if_icmpeq +27 -> 1134
    //   1110: aload 26
    //   1112: astore 23
    //   1114: iload 9
    //   1116: istore 8
    //   1118: iload 13
    //   1120: istore 11
    //   1122: aload 27
    //   1124: astore 24
    //   1126: iload 9
    //   1128: sipush -30027
    //   1131: if_icmpne -745 -> 386
    //   1134: aconst_null
    //   1135: invokestatic 297	com/weiyun/sdk/util/NetworkUtils:hasInternet	(Landroid/content/Context;)Z
    //   1138: ifne +788 -> 1926
    //   1141: sipush -10003
    //   1144: istore 4
    //   1146: goto -1067 -> 79
    //   1149: iload 9
    //   1151: istore 10
    //   1153: aload 22
    //   1155: astore 24
    //   1157: iload 16
    //   1159: istore 11
    //   1161: aload 22
    //   1163: astore 26
    //   1165: aload 22
    //   1167: astore 27
    //   1169: new 299	java/io/BufferedInputStream
    //   1172: dup
    //   1173: aload 22
    //   1175: invokeinterface 223 1 0
    //   1180: invokeinterface 303 1 0
    //   1185: invokespecial 306	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1188: astore 25
    //   1190: aload 22
    //   1192: astore 23
    //   1194: aload 25
    //   1196: aload 28
    //   1198: getfield 311	com/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer:backingArray	[B
    //   1201: invokevirtual 317	java/io/InputStream:read	([B)I
    //   1204: istore 9
    //   1206: iload 9
    //   1208: ifgt +110 -> 1318
    //   1211: aload 22
    //   1213: astore 23
    //   1215: ldc 14
    //   1217: ldc_w 319
    //   1220: invokestatic 137	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1223: sipush -29003
    //   1226: istore 9
    //   1228: aload 25
    //   1230: astore 23
    //   1232: iload 9
    //   1234: istore 8
    //   1236: iload 15
    //   1238: istore 10
    //   1240: iload 13
    //   1242: istore 11
    //   1244: aload 22
    //   1246: astore 24
    //   1248: aload 22
    //   1250: ifnull -864 -> 386
    //   1253: aload 25
    //   1255: astore 23
    //   1257: iload 9
    //   1259: istore 8
    //   1261: iload 15
    //   1263: istore 10
    //   1265: iload 13
    //   1267: istore 11
    //   1269: aload 22
    //   1271: astore 24
    //   1273: aload 22
    //   1275: invokeinterface 223 1 0
    //   1280: ifnull -894 -> 386
    //   1283: aload 22
    //   1285: invokeinterface 223 1 0
    //   1290: invokeinterface 228 1 0
    //   1295: aload 25
    //   1297: astore 23
    //   1299: iload 9
    //   1301: istore 8
    //   1303: iload 15
    //   1305: istore 10
    //   1307: iload 13
    //   1309: istore 11
    //   1311: aload 22
    //   1313: astore 24
    //   1315: goto -929 -> 386
    //   1318: iload 8
    //   1320: sipush 200
    //   1323: if_icmpne +178 -> 1501
    //   1326: iconst_1
    //   1327: istore 19
    //   1329: aload 22
    //   1331: astore 23
    //   1333: aload_1
    //   1334: iload 19
    //   1336: aload 28
    //   1338: getfield 311	com/weiyun/sdk/job/transfer/ByteArrayPool$ByteArrayBuffer:backingArray	[B
    //   1341: iload 9
    //   1343: invokevirtual 323	com/weiyun/sdk/job/api/StoragePlatomProto:parseUploadRsp	(Z[BI)I
    //   1346: istore 8
    //   1348: iload 8
    //   1350: ifne +185 -> 1535
    //   1353: aload 22
    //   1355: astore 23
    //   1357: aload_0
    //   1358: iconst_0
    //   1359: putfield 39	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   1362: aload 22
    //   1364: astore 23
    //   1366: aload_0
    //   1367: iload 14
    //   1369: putfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1372: iload 12
    //   1374: ifne +57 -> 1431
    //   1377: aload 22
    //   1379: astore 23
    //   1381: aload_0
    //   1382: aload_0
    //   1383: getfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1386: iconst_1
    //   1387: iadd
    //   1388: putfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1391: aload 22
    //   1393: astore 23
    //   1395: aload_0
    //   1396: getfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1399: aload_0
    //   1400: getfield 45	com/weiyun/sdk/job/transfer/UploadTransfer:mRewardThreshold	I
    //   1403: if_icmplt +28 -> 1431
    //   1406: aload 22
    //   1408: astore 23
    //   1410: aload_0
    //   1411: aload_0
    //   1412: getfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1415: sipush 8192
    //   1418: iadd
    //   1419: putfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1422: aload 22
    //   1424: astore 23
    //   1426: aload_0
    //   1427: iconst_0
    //   1428: putfield 43	com/weiyun/sdk/job/transfer/UploadTransfer:mSuccSliceTimes	I
    //   1431: aload 22
    //   1433: astore 23
    //   1435: aload_0
    //   1436: getfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1439: sipush 8192
    //   1442: if_icmpge +65 -> 1507
    //   1445: aload 22
    //   1447: astore 23
    //   1449: aload_0
    //   1450: sipush 8192
    //   1453: putfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1456: iconst_0
    //   1457: istore 5
    //   1459: iload 5
    //   1461: istore 4
    //   1463: aload 22
    //   1465: ifnull -1386 -> 79
    //   1468: iload 5
    //   1470: istore 4
    //   1472: aload 22
    //   1474: invokeinterface 223 1 0
    //   1479: ifnull -1400 -> 79
    //   1482: aload 22
    //   1484: invokeinterface 223 1 0
    //   1489: invokeinterface 228 1 0
    //   1494: iload 5
    //   1496: istore 4
    //   1498: goto -1419 -> 79
    //   1501: iconst_0
    //   1502: istore 19
    //   1504: goto -175 -> 1329
    //   1507: aload 22
    //   1509: astore 23
    //   1511: aload_0
    //   1512: getfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1515: ldc_w 324
    //   1518: if_icmple -62 -> 1456
    //   1521: aload 22
    //   1523: astore 23
    //   1525: aload_0
    //   1526: ldc_w 324
    //   1529: putfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   1532: goto -76 -> 1456
    //   1535: ldc_w 325
    //   1538: iload 8
    //   1540: if_icmpne +145 -> 1685
    //   1543: aload 22
    //   1545: astore 23
    //   1547: aload 29
    //   1549: iconst_0
    //   1550: aload 29
    //   1552: invokevirtual 241	java/lang/StringBuilder:length	()I
    //   1555: invokevirtual 245	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1558: pop
    //   1559: aload 22
    //   1561: astore 23
    //   1563: aload 29
    //   1565: ldc_w 327
    //   1568: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1571: iload 8
    //   1573: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1576: pop
    //   1577: aload 22
    //   1579: astore 23
    //   1581: ldc 14
    //   1583: aload 29
    //   1585: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1588: invokestatic 137	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1591: iload 8
    //   1593: istore 9
    //   1595: aload 25
    //   1597: astore 23
    //   1599: iload 9
    //   1601: istore 8
    //   1603: iload 15
    //   1605: istore 10
    //   1607: iload 13
    //   1609: istore 11
    //   1611: aload 22
    //   1613: astore 24
    //   1615: aload 22
    //   1617: ifnull -1231 -> 386
    //   1620: aload 25
    //   1622: astore 23
    //   1624: iload 9
    //   1626: istore 8
    //   1628: iload 15
    //   1630: istore 10
    //   1632: iload 13
    //   1634: istore 11
    //   1636: aload 22
    //   1638: astore 24
    //   1640: aload 22
    //   1642: invokeinterface 223 1 0
    //   1647: ifnull -1261 -> 386
    //   1650: aload 22
    //   1652: invokeinterface 223 1 0
    //   1657: invokeinterface 228 1 0
    //   1662: aload 25
    //   1664: astore 23
    //   1666: iload 9
    //   1668: istore 8
    //   1670: iload 15
    //   1672: istore 10
    //   1674: iload 13
    //   1676: istore 11
    //   1678: aload 22
    //   1680: astore 24
    //   1682: goto -1296 -> 386
    //   1685: aload 22
    //   1687: astore 23
    //   1689: aload 29
    //   1691: iconst_0
    //   1692: aload 29
    //   1694: invokevirtual 241	java/lang/StringBuilder:length	()I
    //   1697: invokevirtual 245	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1700: pop
    //   1701: aload 22
    //   1703: astore 23
    //   1705: aload 29
    //   1707: ldc_w 329
    //   1710: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1713: iload 8
    //   1715: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1718: pop
    //   1719: aload 22
    //   1721: astore 23
    //   1723: ldc 14
    //   1725: aload 29
    //   1727: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1730: invokestatic 137	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1733: iload 8
    //   1735: istore 4
    //   1737: aload 22
    //   1739: ifnull -1660 -> 79
    //   1742: iload 8
    //   1744: istore 4
    //   1746: aload 22
    //   1748: invokeinterface 223 1 0
    //   1753: ifnull -1674 -> 79
    //   1756: aload 22
    //   1758: invokeinterface 223 1 0
    //   1763: invokeinterface 228 1 0
    //   1768: iload 8
    //   1770: istore 4
    //   1772: goto -1693 -> 79
    //   1775: astore 24
    //   1777: aload 26
    //   1779: astore 22
    //   1781: aload 23
    //   1783: astore 25
    //   1785: aload 22
    //   1787: astore 23
    //   1789: ldc 14
    //   1791: aload 24
    //   1793: invokevirtual 332	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1796: aload 24
    //   1798: invokestatic 289	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1801: sipush -10014
    //   1804: istore 8
    //   1806: aload 25
    //   1808: astore 26
    //   1810: iload 8
    //   1812: istore 9
    //   1814: iload 11
    //   1816: istore 10
    //   1818: aload 22
    //   1820: astore 27
    //   1822: aload 22
    //   1824: ifnull -839 -> 985
    //   1827: aload 25
    //   1829: astore 26
    //   1831: iload 8
    //   1833: istore 9
    //   1835: iload 11
    //   1837: istore 10
    //   1839: aload 22
    //   1841: astore 27
    //   1843: aload 22
    //   1845: invokeinterface 223 1 0
    //   1850: ifnull -865 -> 985
    //   1853: aload 22
    //   1855: invokeinterface 223 1 0
    //   1860: invokeinterface 228 1 0
    //   1865: aload 25
    //   1867: astore 26
    //   1869: iload 8
    //   1871: istore 9
    //   1873: iload 11
    //   1875: istore 10
    //   1877: aload 22
    //   1879: astore 27
    //   1881: goto -896 -> 985
    //   1884: astore_1
    //   1885: aload 27
    //   1887: astore 23
    //   1889: aload 23
    //   1891: ifnull +25 -> 1916
    //   1894: aload 23
    //   1896: invokeinterface 223 1 0
    //   1901: ifnull +15 -> 1916
    //   1904: aload 23
    //   1906: invokeinterface 223 1 0
    //   1911: invokeinterface 228 1 0
    //   1916: aload_1
    //   1917: athrow
    //   1918: aload_0
    //   1919: iconst_0
    //   1920: putfield 39	com/weiyun/sdk/job/transfer/UploadTransfer:mTimeoutTimes	I
    //   1923: goto -901 -> 1022
    //   1926: iconst_1
    //   1927: istore 10
    //   1929: iload 13
    //   1931: iconst_1
    //   1932: iadd
    //   1933: istore 11
    //   1935: ldc2_w 333
    //   1938: ldc2_w 181
    //   1941: iload 12
    //   1943: i2d
    //   1944: ldc2_w 335
    //   1947: invokestatic 188	java/lang/Math:pow	(DD)D
    //   1950: dadd
    //   1951: dmul
    //   1952: d2l
    //   1953: lstore 20
    //   1955: ldc 14
    //   1957: new 77	java/lang/StringBuilder
    //   1960: dup
    //   1961: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1964: ldc_w 338
    //   1967: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1970: lload 20
    //   1972: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1975: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1978: invokestatic 341	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1981: lload 20
    //   1983: invokestatic 346	java/lang/Thread:sleep	(J)V
    //   1986: aload 26
    //   1988: astore 23
    //   1990: iload 9
    //   1992: istore 8
    //   1994: aload 27
    //   1996: astore 24
    //   1998: goto -1612 -> 386
    //   2001: astore_1
    //   2002: ldc 14
    //   2004: aload_1
    //   2005: invokevirtual 347	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   2008: aload_1
    //   2009: invokestatic 349	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2012: iload 9
    //   2014: istore 4
    //   2016: goto -1937 -> 79
    //   2019: iconst_0
    //   2020: istore 19
    //   2022: goto -1931 -> 91
    //   2025: astore_1
    //   2026: goto -137 -> 1889
    //   2029: astore 24
    //   2031: iload 18
    //   2033: istore 11
    //   2035: goto -250 -> 1785
    //   2038: iload 9
    //   2040: istore 8
    //   2042: iload 15
    //   2044: istore 10
    //   2046: iload 13
    //   2048: istore 11
    //   2050: aload 22
    //   2052: astore 24
    //   2054: goto -1668 -> 386
    //   2057: iload 8
    //   2059: istore 4
    //   2061: goto -1982 -> 79
    //   2064: astore 24
    //   2066: iload 17
    //   2068: istore 8
    //   2070: goto -1203 -> 867
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2073	0	this	UploadTransfer
    //   0	2073	1	paramStoragePlatomProto	StoragePlatomProto
    //   0	2073	2	paramURL	URL
    //   0	2073	3	paramArrayOfByte	byte[]
    //   0	2073	4	paramInt1	int
    //   0	2073	5	paramInt2	int
    //   117	28	6	d	double
    //   21	2048	8	i	int
    //   29	2010	9	j	int
    //   121	1924	10	k	int
    //   129	1920	11	m	int
    //   35	1907	12	n	int
    //   32	2015	13	i1	int
    //   104	1264	14	i2	int
    //   196	1847	15	i3	int
    //   271	887	16	i4	int
    //   268	1799	17	i5	int
    //   274	1758	18	i6	int
    //   89	1932	19	bool	boolean
    //   1953	29	20	l	long
    //   18	2033	22	localObject1	Object
    //   38	1951	23	localObject2	Object
    //   125	1556	24	localObject3	Object
    //   1775	22	24	localException1	java.lang.Exception
    //   1996	1	24	localObject4	Object
    //   2029	1	24	localException2	java.lang.Exception
    //   2052	1	24	localObject5	Object
    //   2064	1	24	localIOException1	IOException
    //   223	510	25	localObject6	Object
    //   813	25	25	localThrowable	java.lang.Throwable
    //   861	1005	25	localObject7	Object
    //   133	697	26	localObject8	Object
    //   849	15	26	localIOException2	IOException
    //   912	1075	26	localObject9	Object
    //   137	1858	27	localObject10	Object
    //   6	1331	28	localByteArrayBuffer	ByteArrayPool.ByteArrayBuffer
    //   15	1711	29	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   584	596	813	java/lang/Throwable
    //   629	635	813	java/lang/Throwable
    //   655	666	813	java/lang/Throwable
    //   686	712	813	java/lang/Throwable
    //   732	739	813	java/lang/Throwable
    //   139	159	849	java/io/IOException
    //   179	198	849	java/io/IOException
    //   218	225	849	java/io/IOException
    //   245	264	849	java/io/IOException
    //   299	310	849	java/io/IOException
    //   335	339	849	java/io/IOException
    //   427	441	849	java/io/IOException
    //   469	481	849	java/io/IOException
    //   501	526	849	java/io/IOException
    //   546	556	849	java/io/IOException
    //   584	596	849	java/io/IOException
    //   629	635	849	java/io/IOException
    //   655	666	849	java/io/IOException
    //   686	712	849	java/io/IOException
    //   732	739	849	java/io/IOException
    //   759	763	849	java/io/IOException
    //   835	842	849	java/io/IOException
    //   1169	1190	849	java/io/IOException
    //   139	159	1775	java/lang/Exception
    //   179	198	1775	java/lang/Exception
    //   218	225	1775	java/lang/Exception
    //   245	264	1775	java/lang/Exception
    //   299	310	1775	java/lang/Exception
    //   335	339	1775	java/lang/Exception
    //   427	441	1775	java/lang/Exception
    //   469	481	1775	java/lang/Exception
    //   501	526	1775	java/lang/Exception
    //   546	556	1775	java/lang/Exception
    //   584	596	1775	java/lang/Exception
    //   629	635	1775	java/lang/Exception
    //   655	666	1775	java/lang/Exception
    //   686	712	1775	java/lang/Exception
    //   732	739	1775	java/lang/Exception
    //   759	763	1775	java/lang/Exception
    //   835	842	1775	java/lang/Exception
    //   1169	1190	1775	java/lang/Exception
    //   139	159	1884	finally
    //   179	198	1884	finally
    //   218	225	1884	finally
    //   245	264	1884	finally
    //   299	310	1884	finally
    //   335	339	1884	finally
    //   427	441	1884	finally
    //   469	481	1884	finally
    //   501	526	1884	finally
    //   546	556	1884	finally
    //   584	596	1884	finally
    //   629	635	1884	finally
    //   655	666	1884	finally
    //   686	712	1884	finally
    //   732	739	1884	finally
    //   759	763	1884	finally
    //   835	842	1884	finally
    //   1169	1190	1884	finally
    //   1981	1986	2001	java/lang/InterruptedException
    //   871	878	2025	finally
    //   882	910	2025	finally
    //   1194	1206	2025	finally
    //   1215	1223	2025	finally
    //   1333	1348	2025	finally
    //   1357	1362	2025	finally
    //   1366	1372	2025	finally
    //   1381	1391	2025	finally
    //   1395	1406	2025	finally
    //   1410	1422	2025	finally
    //   1426	1431	2025	finally
    //   1435	1445	2025	finally
    //   1449	1456	2025	finally
    //   1511	1521	2025	finally
    //   1525	1532	2025	finally
    //   1547	1559	2025	finally
    //   1563	1577	2025	finally
    //   1581	1591	2025	finally
    //   1689	1701	2025	finally
    //   1705	1719	2025	finally
    //   1723	1733	2025	finally
    //   1789	1801	2025	finally
    //   1194	1206	2029	java/lang/Exception
    //   1215	1223	2029	java/lang/Exception
    //   1333	1348	2029	java/lang/Exception
    //   1357	1362	2029	java/lang/Exception
    //   1366	1372	2029	java/lang/Exception
    //   1381	1391	2029	java/lang/Exception
    //   1395	1406	2029	java/lang/Exception
    //   1410	1422	2029	java/lang/Exception
    //   1426	1431	2029	java/lang/Exception
    //   1435	1445	2029	java/lang/Exception
    //   1449	1456	2029	java/lang/Exception
    //   1511	1521	2029	java/lang/Exception
    //   1525	1532	2029	java/lang/Exception
    //   1547	1559	2029	java/lang/Exception
    //   1563	1577	2029	java/lang/Exception
    //   1581	1591	2029	java/lang/Exception
    //   1689	1701	2029	java/lang/Exception
    //   1705	1719	2029	java/lang/Exception
    //   1723	1733	2029	java/lang/Exception
    //   1194	1206	2064	java/io/IOException
    //   1215	1223	2064	java/io/IOException
    //   1333	1348	2064	java/io/IOException
    //   1357	1362	2064	java/io/IOException
    //   1366	1372	2064	java/io/IOException
    //   1381	1391	2064	java/io/IOException
    //   1395	1406	2064	java/io/IOException
    //   1410	1422	2064	java/io/IOException
    //   1426	1431	2064	java/io/IOException
    //   1435	1445	2064	java/io/IOException
    //   1449	1456	2064	java/io/IOException
    //   1511	1521	2064	java/io/IOException
    //   1525	1532	2064	java/io/IOException
    //   1547	1559	2064	java/io/IOException
    //   1563	1577	2064	java/io/IOException
    //   1581	1591	2064	java/io/IOException
    //   1689	1701	2064	java/io/IOException
    //   1705	1719	2064	java/io/IOException
    //   1723	1733	2064	java/io/IOException
  }
  
  /* Error */
  private int processUpload()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 361	com/weiyun/sdk/job/transfer/UploadTransfer:createUrl	()Ljava/net/URL;
    //   4: astore 10
    //   6: new 129	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   14: invokevirtual 364	com/weiyun/sdk/job/UploadJobContext:getSrcPath	()Ljava/lang/String;
    //   17: ldc_w 366
    //   20: invokespecial 368	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: astore 9
    //   25: iconst_0
    //   26: istore_1
    //   27: aload_0
    //   28: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   31: invokevirtual 119	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   34: ldc2_w 9
    //   37: lcmp
    //   38: ifle +134 -> 172
    //   41: new 95	com/weiyun/sdk/job/api/StoragePlatomProto
    //   44: dup
    //   45: sipush 1007
    //   48: aload_0
    //   49: getfield 72	com/weiyun/sdk/job/transfer/UploadTransfer:mFileHash	[B
    //   52: aload_0
    //   53: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   56: invokevirtual 119	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   59: aload_0
    //   60: getfield 65	com/weiyun/sdk/job/transfer/UploadTransfer:mUkey	[B
    //   63: iconst_0
    //   64: i2l
    //   65: invokespecial 371	com/weiyun/sdk/job/api/StoragePlatomProto:<init>	(I[BJ[BJ)V
    //   68: astore 8
    //   70: ldc_w 372
    //   73: newarray byte
    //   75: astore 11
    //   77: aload_0
    //   78: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   81: invokevirtual 171	com/weiyun/sdk/job/BaseUploadJob:isAlive	()Z
    //   84: ifne +133 -> 217
    //   87: ldc 14
    //   89: ldc 173
    //   91: invokestatic 176	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_0
    //   95: aload 9
    //   97: invokespecial 374	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   100: aload_0
    //   101: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   104: sipush -10002
    //   107: ireturn
    //   108: astore 8
    //   110: ldc 14
    //   112: new 77	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 376
    //   122: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 8
    //   127: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 381	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: sipush -10006
    //   139: ireturn
    //   140: astore 8
    //   142: ldc 14
    //   144: new 77	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 383
    //   154: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 8
    //   159: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 381	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: sipush -29002
    //   171: ireturn
    //   172: new 95	com/weiyun/sdk/job/api/StoragePlatomProto
    //   175: dup
    //   176: sipush 1000
    //   179: aload_0
    //   180: getfield 72	com/weiyun/sdk/job/transfer/UploadTransfer:mFileHash	[B
    //   183: aload_0
    //   184: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   187: invokevirtual 119	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   190: aload_0
    //   191: getfield 65	com/weiyun/sdk/job/transfer/UploadTransfer:mUkey	[B
    //   194: iconst_0
    //   195: i2l
    //   196: invokespecial 371	com/weiyun/sdk/job/api/StoragePlatomProto:<init>	(I[BJ[BJ)V
    //   199: astore 8
    //   201: goto -131 -> 70
    //   204: astore 8
    //   206: ldc 14
    //   208: aload 8
    //   210: invokestatic 385	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: sipush -10001
    //   216: ireturn
    //   217: aload_0
    //   218: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   221: invokevirtual 388	com/weiyun/sdk/job/BaseUploadJob:checkFile	()Z
    //   224: ifne +31 -> 255
    //   227: ldc 14
    //   229: ldc_w 390
    //   232: invokestatic 176	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload_0
    //   236: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   239: invokevirtual 393	com/weiyun/sdk/job/BaseUploadJob:getLastErrorNo	()I
    //   242: istore_1
    //   243: aload_0
    //   244: aload 9
    //   246: invokespecial 374	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   249: aload_0
    //   250: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   253: iload_1
    //   254: ireturn
    //   255: aload_0
    //   256: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   259: invokevirtual 396	com/weiyun/sdk/job/BaseUploadJob:checkEnvironment	()Z
    //   262: ifne +31 -> 293
    //   265: ldc 14
    //   267: ldc_w 398
    //   270: invokestatic 176	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: aload_0
    //   274: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   277: invokevirtual 393	com/weiyun/sdk/job/BaseUploadJob:getLastErrorNo	()I
    //   280: istore_1
    //   281: aload_0
    //   282: aload 9
    //   284: invokespecial 374	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   287: aload_0
    //   288: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   291: iload_1
    //   292: ireturn
    //   293: aload_0
    //   294: getfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   297: ifgt +44 -> 341
    //   300: invokestatic 403	com/weiyun/sdk/context/SdkContext:getInstance	()Lcom/weiyun/sdk/context/SdkContext;
    //   303: invokevirtual 407	com/weiyun/sdk/context/SdkContext:getContext	()Landroid/content/Context;
    //   306: invokestatic 411	com/weiyun/sdk/util/NetworkUtils:getPacketSize	(Landroid/content/Context;)I
    //   309: istore_2
    //   310: iload_2
    //   311: ifge +25 -> 336
    //   314: ldc 14
    //   316: ldc_w 413
    //   319: invokestatic 381	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload_0
    //   323: aload 9
    //   325: invokespecial 374	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   328: aload_0
    //   329: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   332: sipush -10003
    //   335: ireturn
    //   336: aload_0
    //   337: iload_2
    //   338: putfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   341: aload 9
    //   343: aload_0
    //   344: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   347: invokevirtual 116	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   350: invokevirtual 416	java/io/RandomAccessFile:seek	(J)V
    //   353: aload 8
    //   355: invokevirtual 419	com/weiyun/sdk/job/api/StoragePlatomProto:getHeadLength	()I
    //   358: istore_3
    //   359: aload 9
    //   361: aload 11
    //   363: iload_3
    //   364: aload_0
    //   365: getfield 41	com/weiyun/sdk/job/transfer/UploadTransfer:mSliceSize	I
    //   368: invokevirtual 422	java/io/RandomAccessFile:read	([BII)I
    //   371: istore_2
    //   372: iload_2
    //   373: ifgt +43 -> 416
    //   376: aload_0
    //   377: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   380: invokevirtual 116	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   383: lstore 4
    //   385: aload_0
    //   386: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   389: invokevirtual 119	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   392: lstore 6
    //   394: lload 4
    //   396: lload 6
    //   398: lcmp
    //   399: ifge +17 -> 416
    //   402: aload_0
    //   403: aload 9
    //   405: invokespecial 374	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   408: aload_0
    //   409: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   412: sipush -10009
    //   415: ireturn
    //   416: iload_2
    //   417: ifgt +41 -> 458
    //   420: aload_0
    //   421: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   424: invokevirtual 116	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   427: lstore 4
    //   429: aload_0
    //   430: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   433: invokevirtual 119	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   436: lstore 6
    //   438: lload 4
    //   440: lload 6
    //   442: lcmp
    //   443: ifne +15 -> 458
    //   446: aload_0
    //   447: aload 9
    //   449: invokespecial 374	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   452: aload_0
    //   453: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   456: iconst_0
    //   457: ireturn
    //   458: iload_1
    //   459: iconst_1
    //   460: iadd
    //   461: istore_1
    //   462: iload_1
    //   463: i2l
    //   464: lstore 4
    //   466: aload 8
    //   468: lload 4
    //   470: invokevirtual 425	com/weiyun/sdk/job/api/StoragePlatomProto:setSeq	(J)V
    //   473: aload_0
    //   474: aload 8
    //   476: aload 10
    //   478: aload 11
    //   480: iload_3
    //   481: iload_2
    //   482: invokespecial 427	com/weiyun/sdk/job/transfer/UploadTransfer:httpPostData	(Lcom/weiyun/sdk/job/api/StoragePlatomProto;Ljava/net/URL;[BII)I
    //   485: istore_3
    //   486: iload_3
    //   487: ifeq +40 -> 527
    //   490: ldc 14
    //   492: new 77	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   499: ldc_w 429
    //   502: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: iload_3
    //   506: invokevirtual 250	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   509: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 341	com/weiyun/sdk/log/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: aload_0
    //   516: aload 9
    //   518: invokespecial 374	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   521: aload_0
    //   522: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   525: iload_3
    //   526: ireturn
    //   527: aload_0
    //   528: getfield 51	com/weiyun/sdk/job/transfer/UploadTransfer:mJob	Lcom/weiyun/sdk/job/BaseUploadJob;
    //   531: invokevirtual 171	com/weiyun/sdk/job/BaseUploadJob:isAlive	()Z
    //   534: ifne +24 -> 558
    //   537: ldc 14
    //   539: ldc 173
    //   541: invokestatic 176	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   544: aload_0
    //   545: aload 9
    //   547: invokespecial 374	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   550: aload_0
    //   551: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   554: sipush -10002
    //   557: ireturn
    //   558: aload_0
    //   559: aload 8
    //   561: iload_2
    //   562: invokespecial 433	com/weiyun/sdk/job/transfer/UploadTransfer:processUploadRsp	(Lcom/weiyun/sdk/job/api/StoragePlatomProto;I)V
    //   565: aload_0
    //   566: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   569: invokevirtual 116	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   572: aload_0
    //   573: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   576: invokevirtual 119	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   579: lcmp
    //   580: ifeq -134 -> 446
    //   583: aload_0
    //   584: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   587: invokevirtual 116	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   590: aload_0
    //   591: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   594: invokevirtual 119	com/weiyun/sdk/job/UploadJobContext:getTotalSize	()J
    //   597: lcmp
    //   598: ifle -521 -> 77
    //   601: ldc 14
    //   603: new 77	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   610: ldc_w 435
    //   613: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload_0
    //   617: getfield 47	com/weiyun/sdk/job/transfer/UploadTransfer:mContext	Lcom/weiyun/sdk/job/UploadJobContext;
    //   620: invokevirtual 116	com/weiyun/sdk/job/UploadJobContext:getCurSize	()J
    //   623: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   626: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 137	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   632: aload_0
    //   633: aload 9
    //   635: invokespecial 374	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   638: aload_0
    //   639: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   642: sipush -10013
    //   645: ireturn
    //   646: astore 8
    //   648: ldc 14
    //   650: new 77	java/lang/StringBuilder
    //   653: dup
    //   654: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   657: ldc_w 437
    //   660: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: aload 8
    //   665: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   668: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 381	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   674: aload_0
    //   675: aload 9
    //   677: invokespecial 374	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   680: aload_0
    //   681: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   684: sipush -10008
    //   687: ireturn
    //   688: astore 8
    //   690: ldc 14
    //   692: aload 8
    //   694: invokevirtual 438	java/lang/Exception:toString	()Ljava/lang/String;
    //   697: invokestatic 381	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   700: aload_0
    //   701: aload 9
    //   703: invokespecial 374	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   706: aload_0
    //   707: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   710: sipush -10014
    //   713: ireturn
    //   714: astore 8
    //   716: aload_0
    //   717: aload 9
    //   719: invokespecial 374	com/weiyun/sdk/job/transfer/UploadTransfer:closeFile	(Ljava/io/RandomAccessFile;)V
    //   722: aload_0
    //   723: invokespecial 217	com/weiyun/sdk/job/transfer/UploadTransfer:closeHttpClient	()V
    //   726: aload 8
    //   728: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	729	0	this	UploadTransfer
    //   26	437	1	i	int
    //   309	253	2	j	int
    //   358	168	3	k	int
    //   383	86	4	l1	long
    //   392	49	6	l2	long
    //   68	1	8	localStoragePlatomProto1	StoragePlatomProto
    //   108	18	8	localFileNotFoundException	java.io.FileNotFoundException
    //   140	18	8	localMalformedURLException	MalformedURLException
    //   199	1	8	localStoragePlatomProto2	StoragePlatomProto
    //   204	356	8	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   646	18	8	localIOException	IOException
    //   688	5	8	localException	java.lang.Exception
    //   714	13	8	localObject	Object
    //   23	695	9	localRandomAccessFile	RandomAccessFile
    //   4	473	10	localURL	URL
    //   75	404	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	25	108	java/io/FileNotFoundException
    //   0	25	140	java/net/MalformedURLException
    //   27	70	204	java/lang/IllegalArgumentException
    //   172	201	204	java/lang/IllegalArgumentException
    //   77	94	646	java/io/IOException
    //   217	243	646	java/io/IOException
    //   255	281	646	java/io/IOException
    //   293	310	646	java/io/IOException
    //   314	322	646	java/io/IOException
    //   336	341	646	java/io/IOException
    //   341	372	646	java/io/IOException
    //   376	394	646	java/io/IOException
    //   420	438	646	java/io/IOException
    //   466	486	646	java/io/IOException
    //   490	515	646	java/io/IOException
    //   527	544	646	java/io/IOException
    //   558	583	646	java/io/IOException
    //   583	632	646	java/io/IOException
    //   77	94	688	java/lang/Exception
    //   217	243	688	java/lang/Exception
    //   255	281	688	java/lang/Exception
    //   293	310	688	java/lang/Exception
    //   314	322	688	java/lang/Exception
    //   336	341	688	java/lang/Exception
    //   341	372	688	java/lang/Exception
    //   376	394	688	java/lang/Exception
    //   420	438	688	java/lang/Exception
    //   466	486	688	java/lang/Exception
    //   490	515	688	java/lang/Exception
    //   527	544	688	java/lang/Exception
    //   558	583	688	java/lang/Exception
    //   583	632	688	java/lang/Exception
    //   77	94	714	finally
    //   217	243	714	finally
    //   255	281	714	finally
    //   293	310	714	finally
    //   314	322	714	finally
    //   336	341	714	finally
    //   341	372	714	finally
    //   376	394	714	finally
    //   420	438	714	finally
    //   466	486	714	finally
    //   490	515	714	finally
    //   527	544	714	finally
    //   558	583	714	finally
    //   583	632	714	finally
    //   648	674	714	finally
    //   690	700	714	finally
  }
  
  private void processUploadRsp(StoragePlatomProto paramStoragePlatomProto, int paramInt)
  {
    switch (paramStoragePlatomProto.getUploadRspFlag())
    {
    default: 
      return;
    case 1: 
      if (this.mContext.getCurSize() + paramInt < this.mContext.getTotalSize())
      {
        Log.i("UploadTransfer", "some file has the same md5. file = " + this.mContext.getFileName());
        this.mContext.setContentExist(true);
        BaseUploadJob.makeFakeTransfer(this.mContext, this.mJob);
      }
      this.mContext.setCurSize(this.mContext.getTotalSize());
      this.mJob.notifyProgressChanged(this.mContext.getTotalSize(), this.mContext.getTotalSize());
      return;
    }
    adjustProgress(paramStoragePlatomProto, this.mContext.getCurSize() + paramInt);
  }
  
  protected HttpPost configHttpClient(URL paramURL)
  {
    paramURL = new HttpPost(paramURL.toString());
    paramURL.addHeader("Accept", "*/*");
    paramURL.addHeader("User-Agent", "QdiskAndroid1.1.0");
    paramURL.addHeader("Accept-Language", "zh-CN");
    paramURL.addHeader("Referer", "http://udisk.qq.com/android");
    paramURL.addHeader("Charset", "UTF-8");
    paramURL.addHeader("Proxy-Connection", "Keep-Alive");
    paramURL.addHeader("Pragma", "no-cache");
    paramURL.addHeader("Content-type", "text/octet");
    if (this.mHttpClient == null)
    {
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      localBasicHttpParams.setParameter("http.connection.timeout", Integer.valueOf(30000));
      localBasicHttpParams.setParameter("http.socket.timeout", Integer.valueOf(45000));
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      this.mHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
      this.mHttpClient.setHttpRequestRetryHandler(createHttpRequestRetryHandler(1, true));
    }
    if (!NetworkUtils.isWIFI(SdkContext.getInstance().getContext()))
    {
      this.mHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(this.mTimeoutTimes * 5000 + 45000));
      this.mHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(60000 + this.mTimeoutTimes * 5000));
      return paramURL;
    }
    this.mHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(this.mTimeoutTimes * 5000 + 30000));
    this.mHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(this.mTimeoutTimes * 5000 + 45000));
    return paramURL;
  }
  
  protected DefaultHttpRequestRetryHandler createHttpRequestRetryHandler(int paramInt, boolean paramBoolean)
  {
    return new UploadTaskRequestRetryHandler(paramInt, true);
  }
  
  protected URL createUrl()
    throws MalformedURLException
  {
    return new URL("http", this.mAddress.getHost(), this.mAddress.getPort(), this.mAddress.getFile());
  }
  
  public int transfer()
  {
    return processUpload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.UploadTransfer
 * JD-Core Version:    0.7.0.1
 */