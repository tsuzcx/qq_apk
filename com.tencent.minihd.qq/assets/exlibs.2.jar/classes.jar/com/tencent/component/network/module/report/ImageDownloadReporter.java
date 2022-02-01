package com.tencent.component.network.module.report;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.DownloadResult.Content;
import com.tencent.component.network.downloader.DownloadResult.Status;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject;
import com.tencent.component.network.module.base.b;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.component.network.utils.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;

public class ImageDownloadReporter
  implements ReportHandler
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static int a(Throwable paramThrowable, int paramInt)
  {
    int i = paramInt;
    if (paramThrowable != null)
    {
      if (!(paramThrowable instanceof ClientProtocolException)) {
        break label18;
      }
      i = 8;
    }
    label18:
    do
    {
      return i;
      if ((paramThrowable instanceof SSLPeerUnverifiedException)) {
        return 12;
      }
      if ((paramThrowable instanceof NoHttpResponseException)) {
        return 11;
      }
      if ((paramThrowable instanceof UnknownHostException)) {
        return 9;
      }
      if ((paramThrowable instanceof ConnectionPoolTimeoutException)) {
        return 13;
      }
      if ((paramThrowable instanceof ConnectTimeoutException)) {
        return 10;
      }
      if ((paramThrowable instanceof IllegalStateException)) {
        return 5;
      }
      if ((paramThrowable instanceof SocketException)) {
        return 6;
      }
      if ((paramThrowable instanceof SocketTimeoutException)) {
        return 7;
      }
      if ((paramThrowable instanceof FileNotFoundException)) {
        return 1;
      }
      if ((paramThrowable instanceof IOException))
      {
        paramThrowable = Log.getStackTraceString(paramThrowable);
        if ((paramThrowable != null) && (paramThrowable.contains("No-space-left-on-device"))) {}
        for (paramInt = 50003;; paramInt = 2) {
          return paramInt;
        }
      }
      if ((paramThrowable instanceof Exception)) {
        return 4;
      }
      i = paramInt;
    } while (!(paramThrowable instanceof OutOfMemoryError));
    return 3;
  }
  
  private int a(HttpResponse paramHttpResponse, int paramInt)
  {
    int i;
    if (paramHttpResponse == null)
    {
      paramHttpResponse = null;
      i = paramInt;
      if (paramHttpResponse == null) {}
    }
    for (;;)
    {
      i = paramInt;
      Header localHeader;
      if (paramHttpResponse.hasNext())
      {
        localHeader = paramHttpResponse.nextHeader();
        if (localHeader == null) {}
      }
      else
      {
        try
        {
          i = Integer.parseInt(localHeader.getValue());
          return i;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          b.c("ImageDownload", "getRetCodeFrom", localNumberFormatException);
        }
        paramHttpResponse = paramHttpResponse.headerIterator("Retcode");
        break;
      }
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = a[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2)] = a[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  /* Error */
  private static byte[] a(File paramFile, long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 10
    //   9: aload 10
    //   11: astore 9
    //   13: aload_0
    //   14: ifnull +25 -> 39
    //   17: aload 10
    //   19: astore 9
    //   21: aload_0
    //   22: invokevirtual 129	java/io/File:exists	()Z
    //   25: ifeq +14 -> 39
    //   28: aload_0
    //   29: invokevirtual 132	java/io/File:isFile	()Z
    //   32: ifne +10 -> 42
    //   35: aload 10
    //   37: astore 9
    //   39: aload 9
    //   41: areturn
    //   42: aload_0
    //   43: invokevirtual 136	java/io/File:length	()J
    //   46: lstore 6
    //   48: lload_1
    //   49: lstore 4
    //   51: lload_1
    //   52: lconst_0
    //   53: lcmp
    //   54: ifge +6 -> 60
    //   57: lconst_0
    //   58: lstore 4
    //   60: aload 10
    //   62: astore 9
    //   64: lload 4
    //   66: lload 6
    //   68: lcmp
    //   69: ifge -30 -> 39
    //   72: aload 10
    //   74: astore 9
    //   76: iload_3
    //   77: ifle -38 -> 39
    //   80: iload_3
    //   81: lload 6
    //   83: lload 4
    //   85: lsub
    //   86: l2i
    //   87: invokestatic 142	java/lang/Math:min	(II)I
    //   90: istore_3
    //   91: iload_3
    //   92: newarray byte
    //   94: astore 9
    //   96: new 144	java/io/RandomAccessFile
    //   99: dup
    //   100: aload_0
    //   101: ldc 146
    //   103: invokespecial 149	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   106: astore 8
    //   108: aload 8
    //   110: lload 4
    //   112: invokevirtual 153	java/io/RandomAccessFile:seek	(J)V
    //   115: aload 8
    //   117: aload 9
    //   119: invokevirtual 157	java/io/RandomAccessFile:read	([B)I
    //   122: istore_3
    //   123: iload_3
    //   124: ifgt +28 -> 152
    //   127: aload 12
    //   129: astore_0
    //   130: aload_0
    //   131: astore 9
    //   133: aload 8
    //   135: ifnull -96 -> 39
    //   138: aload_0
    //   139: astore 9
    //   141: aload 8
    //   143: invokevirtual 160	java/io/RandomAccessFile:close	()V
    //   146: aload_0
    //   147: areturn
    //   148: astore_0
    //   149: aload 9
    //   151: areturn
    //   152: iload_3
    //   153: aload 9
    //   155: arraylength
    //   156: if_icmpge +72 -> 228
    //   159: iload_3
    //   160: newarray byte
    //   162: astore_0
    //   163: aload 9
    //   165: iconst_0
    //   166: aload_0
    //   167: iconst_0
    //   168: iload_3
    //   169: invokestatic 166	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   172: goto -42 -> 130
    //   175: astore_0
    //   176: aconst_null
    //   177: astore 8
    //   179: aload 8
    //   181: ifnull +8 -> 189
    //   184: aload 8
    //   186: invokevirtual 160	java/io/RandomAccessFile:close	()V
    //   189: aload_0
    //   190: athrow
    //   191: astore_0
    //   192: aconst_null
    //   193: astore_0
    //   194: aload 10
    //   196: astore 9
    //   198: aload_0
    //   199: ifnull -160 -> 39
    //   202: aload 11
    //   204: astore 9
    //   206: aload_0
    //   207: invokevirtual 160	java/io/RandomAccessFile:close	()V
    //   210: aconst_null
    //   211: areturn
    //   212: astore 8
    //   214: goto -25 -> 189
    //   217: astore_0
    //   218: goto -39 -> 179
    //   221: astore_0
    //   222: aload 8
    //   224: astore_0
    //   225: goto -31 -> 194
    //   228: aload 9
    //   230: astore_0
    //   231: goto -101 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	paramFile	File
    //   0	234	1	paramLong	long
    //   0	234	3	paramInt	int
    //   49	62	4	l1	long
    //   46	36	6	l2	long
    //   106	79	8	localRandomAccessFile	java.io.RandomAccessFile
    //   212	11	8	localIOException	IOException
    //   11	218	9	localObject1	Object
    //   7	188	10	localObject2	Object
    //   4	199	11	localObject3	Object
    //   1	127	12	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   141	146	148	java/io/IOException
    //   206	210	148	java/io/IOException
    //   91	108	175	finally
    //   91	108	191	java/lang/Throwable
    //   184	189	212	java/io/IOException
    //   108	123	217	finally
    //   152	172	217	finally
    //   108	123	221	java/lang/Throwable
    //   152	172	221	java/lang/Throwable
  }
  
  public ReportHandler.DownloadReportObject a(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport)
  {
    ReportHandler.DownloadReportObject localDownloadReportObject = new ReportHandler.DownloadReportObject();
    localDownloadReportObject.a();
    localDownloadReportObject.a(paramDownloadReport.jdField_a_of_type_JavaLangString);
    localDownloadReportObject.jdField_h_of_type_Long = paramDownloadReport.jdField_c_of_type_Long;
    localDownloadReportObject.j = paramDownloadReport.jdField_a_of_type_Long;
    localDownloadReportObject.jdField_k_of_type_Long = paramDownloadReport.jdField_b_of_type_Long;
    localDownloadReportObject.jdField_i_of_type_Long = (localDownloadReportObject.jdField_k_of_type_Long - localDownloadReportObject.j);
    localDownloadReportObject.q = paramDownloadReport.jdField_a_of_type_Int;
    localDownloadReportObject.o = NetworkState.a().a();
    localDownloadReportObject.jdField_k_of_type_JavaLangString = paramDownloadReport.jdField_c_of_type_JavaLangString;
    localDownloadReportObject.jdField_b_of_type_JavaLangString = paramDownloadReport.jdField_b_of_type_JavaLangString;
    localDownloadReportObject.jdField_b_of_type_Int = paramDownloadReport.jdField_c_of_type_Int;
    localDownloadReportObject.jdField_c_of_type_JavaLangString = paramDownloadReport.jdField_f_of_type_JavaLangString;
    localDownloadReportObject.jdField_d_of_type_JavaLangString = paramDownloadReport.jdField_g_of_type_JavaLangString;
    localDownloadReportObject.jdField_a_of_type_Long = paramDownloadReport.jdField_e_of_type_Long;
    localDownloadReportObject.jdField_b_of_type_Long = paramDownloadReport.jdField_f_of_type_Long;
    localDownloadReportObject.jdField_c_of_type_Long = paramDownloadReport.jdField_g_of_type_Long;
    localDownloadReportObject.jdField_d_of_type_Long = paramDownloadReport.jdField_h_of_type_Long;
    localDownloadReportObject.jdField_e_of_type_Long = paramDownloadReport.jdField_i_of_type_Long;
    localDownloadReportObject.jdField_f_of_type_Long = paramDownloadReport.j;
    localDownloadReportObject.jdField_g_of_type_Long = paramDownloadReport.jdField_k_of_type_Long;
    localDownloadReportObject.jdField_e_of_type_JavaLangString = paramDownloadReport.jdField_h_of_type_JavaLangString;
    localDownloadReportObject.jdField_f_of_type_Int = paramDownloadReport.d;
    localDownloadReportObject.jdField_f_of_type_JavaLangString = paramDownloadReport.jdField_i_of_type_JavaLangString;
    localDownloadReportObject.jdField_a_of_type_JavaLangThrowable = paramDownloadReport.jdField_a_of_type_JavaLangThrowable;
    if (paramDownloadResult.a().a())
    {
      if (paramDownloadResult.a().jdField_a_of_type_Boolean)
      {
        localDownloadReportObject.p = a(paramDownloadReport.jdField_a_of_type_OrgApacheHttpHttpResponse, 0);
        if (localDownloadReportObject.p == 0) {
          localDownloadReportObject.p = -2;
        }
        return localDownloadReportObject;
      }
      if (paramDownloadResult.a().jdField_b_of_type_Long != paramDownloadResult.a().jdField_a_of_type_Long)
      {
        localDownloadReportObject.p = -3;
        localDownloadReportObject.jdField_a_of_type_JavaLangStringBuilder.append(";content-length:" + paramDownloadResult.a().jdField_a_of_type_Long + ";actual-size:" + paramDownloadResult.a().jdField_b_of_type_Long);
        paramDownloadReport = new File(paramDownloadResult.b());
        paramDownloadResult = a(a(paramDownloadReport, 0L, 1024));
        paramDownloadReport = a(a(paramDownloadReport, paramDownloadReport.length() - 1024L, 1024));
        localDownloadReportObject.jdField_a_of_type_JavaLangStringBuilder.append(";head-content:" + paramDownloadResult);
        localDownloadReportObject.jdField_a_of_type_JavaLangStringBuilder.append(";tail-content:" + paramDownloadReport);
        return localDownloadReportObject;
      }
      if ((paramDownloadResult.a().jdField_c_of_type_Long > 0L) && (paramDownloadResult.a().jdField_c_of_type_Long != paramDownloadResult.a().jdField_a_of_type_Long))
      {
        localDownloadReportObject.p = 50002;
        localDownloadReportObject.jdField_a_of_type_JavaLangStringBuilder.append(";content-length:" + paramDownloadResult.a().jdField_a_of_type_Long + ";real-size:" + paramDownloadResult.a().jdField_c_of_type_Long);
        return localDownloadReportObject;
      }
      localDownloadReportObject.p = 0;
      return localDownloadReportObject;
    }
    localDownloadReportObject.jdField_a_of_type_JavaLangStringBuilder.append("httpStatus:" + paramDownloadReport.jdField_b_of_type_Int + "; ");
    if (paramDownloadReport.jdField_a_of_type_JavaLangThrowable != null)
    {
      localDownloadReportObject.p = a(paramDownloadReport.jdField_a_of_type_JavaLangThrowable, localDownloadReportObject.p);
      localDownloadReportObject.jdField_a_of_type_JavaLangStringBuilder.append(Log.getStackTraceString(paramDownloadReport.jdField_a_of_type_JavaLangThrowable));
      return localDownloadReportObject;
    }
    if (paramDownloadResult.a().a() == 5)
    {
      localDownloadReportObject.p = -1;
      localDownloadReportObject.jdField_a_of_type_JavaLangStringBuilder.append("content-type:" + paramDownloadResult.a().jdField_a_of_type_JavaLangString + "; data:" + paramDownloadResult.a().jdField_a_of_type_JavaLangObject + "; ");
      return localDownloadReportObject;
    }
    if (paramDownloadReport.jdField_a_of_type_OrgApacheHttpHttpResponse == null)
    {
      localDownloadReportObject.p = -99997;
      return localDownloadReportObject;
    }
    localDownloadReportObject.p = paramDownloadReport.jdField_b_of_type_Int;
    return localDownloadReportObject;
  }
  
  public void a(DownloadResult paramDownloadResult, DownloadReport paramDownloadReport)
  {
    a(a(paramDownloadResult, paramDownloadReport));
  }
  
  public void a(ReportHandler.DownloadReportObject paramDownloadReportObject)
  {
    if (paramDownloadReportObject == null) {
      return;
    }
    BusinessReport.a(paramDownloadReportObject, paramDownloadReportObject.jdField_a_of_type_Int, 1);
  }
  
  public boolean a(DownloadResult paramDownloadResult, HttpResponse paramHttpResponse)
  {
    Object localObject1 = paramDownloadResult.a().jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    Object localObject2;
    for (;;)
    {
      return false;
      if (f.a((String)localObject1, "text/html"))
      {
        localObject2 = null;
        localObject1 = null;
        try
        {
          paramHttpResponse = paramHttpResponse.getEntity().getContent();
          localObject1 = paramHttpResponse;
          localObject2 = paramHttpResponse;
          Object localObject3 = new byte[1024];
          localObject1 = paramHttpResponse;
          localObject2 = paramHttpResponse;
          int i = paramHttpResponse.read((byte[])localObject3);
          if (i > 0)
          {
            localObject1 = paramHttpResponse;
            localObject2 = paramHttpResponse;
            localObject3 = new String((byte[])localObject3, 0, i);
            localObject1 = paramHttpResponse;
            localObject2 = paramHttpResponse;
            paramDownloadResult.a().jdField_a_of_type_JavaLangObject = localObject3;
          }
          if (paramHttpResponse != null) {
            try
            {
              paramHttpResponse.close();
              return false;
            }
            catch (IOException paramDownloadResult)
            {
              b.c("ImageDownloader", "", paramDownloadResult);
              return false;
            }
          }
        }
        catch (IOException paramDownloadResult)
        {
          for (;;)
          {
            localObject2 = localObject1;
            b.c("ImageDownloadReporter", "handleContentType", paramDownloadResult);
            if (localObject1 == null) {
              break;
            }
            try
            {
              ((InputStream)localObject1).close();
              return false;
            }
            catch (IOException paramDownloadResult) {}
          }
        }
        finally
        {
          if (localObject2 == null) {}
        }
      }
    }
    try
    {
      ((InputStream)localObject2).close();
      throw paramDownloadResult;
    }
    catch (IOException paramHttpResponse)
    {
      for (;;)
      {
        b.c("ImageDownloader", "", paramHttpResponse);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.report.ImageDownloadReporter
 * JD-Core Version:    0.7.0.1
 */