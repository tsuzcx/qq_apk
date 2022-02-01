package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import irz;
import isa;
import isb;
import isc;
import isd;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileUploader
  implements isc
{
  private static final int jdField_a_of_type_Int = 6000;
  private static final String jdField_a_of_type_JavaLangString = "FtnHttpUploader<FileAssistant>";
  private static final int jdField_b_of_type_Int = 8;
  private final long jdField_a_of_type_Long;
  private FileUploader.IFileUploaderSink jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink;
  private FileUploader.IFlowControl jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl = new isb(this);
  private final HttpUrlProcessor jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor;
  private isd jdField_a_of_type_Isd = null;
  private InputStream jdField_a_of_type_JavaIoInputStream = null;
  private boolean jdField_a_of_type_Boolean = false;
  private final long jdField_b_of_type_Long;
  private final String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long = 0L;
  private int jdField_e_of_type_Int = 0;
  private long jdField_e_of_type_Long = 0L;
  private int f = 0;
  private int g = 0;
  
  private FileUploader(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new File(paramString1).length();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(paramQQAppInterface, paramString2);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    this.jdField_a_of_type_Isd = Md5HttpUploader.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Isd != null) {
      this.jdField_a_of_type_Isd.a(this);
    }
  }
  
  private FileUploader(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new File(paramString1).length();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(paramQQAppInterface, paramString4);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    this.jdField_a_of_type_Isd = FtnUploader.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2, paramString2, paramString3, this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_Isd != null) {
      this.jdField_a_of_type_Isd.a(this);
    }
  }
  
  private FileUploader(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, List paramList, String paramString4)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new File(paramString1).length();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(paramQQAppInterface, paramList, paramString4);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    this.jdField_a_of_type_Isd = FtnUploader.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2, paramString2, paramString3, this.jdField_b_of_type_Long);
    if (this.jdField_a_of_type_Isd != null) {
      this.jdField_a_of_type_Isd.a(this);
    }
  }
  
  private FileUploader(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, List paramList, String paramString2)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Long = new File(paramString1).length();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(paramQQAppInterface, paramList, paramString2);
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    this.jdField_a_of_type_Isd = Md5HttpUploader.a(paramQQAppInterface, this.jdField_a_of_type_Long, paramInt1, paramInt2);
    if (this.jdField_a_of_type_Isd != null) {
      this.jdField_a_of_type_Isd.a(this);
    }
  }
  
  public static FileUploader a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      if (paramString1.length() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
        }
        return null;
      }
      if (paramString2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is null");
        }
        return null;
      }
      if (paramString2.length() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is empty");
        }
        return null;
      }
      paramString1 = new FileUploader(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2);
      paramQQAppInterface = paramString1;
    } while (paramString1.a());
    return null;
  }
  
  public static FileUploader a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      if (paramString1.length() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
        }
        return null;
      }
      if (paramString2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strCheckSum is null");
        }
        return null;
      }
      if (paramString3 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strSHA is null");
        }
        return null;
      }
      if (paramString4 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is null");
        }
        return null;
      }
      if (paramString4.length() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strUrl is empty");
        }
        return null;
      }
      paramString1 = new FileUploader(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4);
      paramQQAppInterface = paramString1;
    } while (paramString1.a());
    return null;
  }
  
  public static FileUploader a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, List paramList, String paramString4)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      if (paramString1.length() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
        }
        return null;
      }
      if (paramString2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strCheckSum is null");
        }
        return null;
      }
      if (paramString3 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strSHA is null");
        }
        return null;
      }
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is null");
        }
        return null;
      }
      if (paramList.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is empty");
        }
        return null;
      }
      if (paramString4 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is null");
        }
        return null;
      }
      if (paramString4.length() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is empty");
        }
        return null;
      }
      paramString1 = new FileUploader(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramList, paramString4);
      paramQQAppInterface = paramString1;
    } while (paramString1.a());
    return null;
  }
  
  public static FileUploader a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2, String paramString1, List paramList, String paramString2)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is null");
      }
      paramQQAppInterface = null;
    }
    do
    {
      return paramQQAppInterface;
      if (paramString1.length() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader strFilePath is empty");
        }
        return null;
      }
      if (paramList == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is null");
        }
        return null;
      }
      if (paramList.size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader lstUrl is empty");
        }
        return null;
      }
      if (paramString2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is null");
        }
        return null;
      }
      if (paramString2.length() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFileUploader urlParams is empty");
        }
        return null;
      }
      paramString1 = new FileUploader(paramQQAppInterface, paramLong, paramInt1, paramInt2, paramString1, paramList, paramString2);
      paramQQAppInterface = paramString1;
    } while (paramString1.a());
    return null;
  }
  
  private void a(int paramInt)
  {
    String str = null;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor != null) {
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
    }
    if ((str == null) || (str.length() == 0))
    {
      QLog.i("FtnHttpUploader<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Long + "] need chang Ip ,but can not get next ip errCode[" + paramInt + "]");
      return;
    }
    this.jdField_c_of_type_JavaLangString = str;
    this.jdField_e_of_type_Int += 1;
    this.jdField_c_of_type_Int = 0;
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_JavaIoInputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoInputStream.close();
      this.jdField_a_of_type_JavaIoInputStream = null;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_JavaIoInputStream = new FileInputStream(this.jdField_b_of_type_JavaLangString);
          return true;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          this.jdField_a_of_type_JavaIoInputStream = null;
          localFileNotFoundException.printStackTrace();
        }
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
    }
    return false;
  }
  
  /* Error */
  private byte[] a(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifne +21 -> 24
    //   6: aload_0
    //   7: getfield 60	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   10: lconst_0
    //   11: lcmp
    //   12: ifeq +35 -> 47
    //   15: aload_0
    //   16: invokespecial 137	com/tencent/mobileqq/filemanager/core/FileUploader:a	()Z
    //   19: ifne +28 -> 47
    //   22: aconst_null
    //   23: areturn
    //   24: lload_1
    //   25: aload_0
    //   26: getfield 60	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   29: lcmp
    //   30: ifle +80 -> 110
    //   33: aload_0
    //   34: getfield 58	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   37: lload_1
    //   38: aload_0
    //   39: getfield 60	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   42: lsub
    //   43: invokevirtual 212	java/io/InputStream:skip	(J)J
    //   46: pop2
    //   47: aload_0
    //   48: lload_1
    //   49: putfield 60	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   52: aload_0
    //   53: getfield 40	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl	Lcom/tencent/mobileqq/filemanager/core/FileUploader$IFlowControl;
    //   56: aload_0
    //   57: getfield 56	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_d_of_type_Long	J
    //   60: aload_0
    //   61: getfield 75	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_b_of_type_Long	J
    //   64: invokeinterface 217 5 0
    //   69: istore_3
    //   70: iload_3
    //   71: newarray byte
    //   73: astore 4
    //   75: aload_0
    //   76: getfield 58	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   79: aload 4
    //   81: iconst_0
    //   82: iload_3
    //   83: invokevirtual 221	java/io/InputStream:read	([BII)I
    //   86: pop
    //   87: aload_0
    //   88: aload_0
    //   89: getfield 60	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   92: iload_3
    //   93: i2l
    //   94: ladd
    //   95: putfield 60	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   98: aload 4
    //   100: areturn
    //   101: astore 4
    //   103: aload 4
    //   105: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   108: aconst_null
    //   109: areturn
    //   110: lload_1
    //   111: aload_0
    //   112: getfield 60	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_e_of_type_Long	J
    //   115: lcmp
    //   116: ifge -69 -> 47
    //   119: aload_0
    //   120: invokespecial 137	com/tencent/mobileqq/filemanager/core/FileUploader:a	()Z
    //   123: ifeq -101 -> 22
    //   126: aload_0
    //   127: getfield 58	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   130: lload_1
    //   131: invokevirtual 212	java/io/InputStream:skip	(J)J
    //   134: pop2
    //   135: goto -88 -> 47
    //   138: astore 4
    //   140: aload_0
    //   141: aconst_null
    //   142: putfield 58	com/tencent/mobileqq/filemanager/core/FileUploader:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   145: aload 4
    //   147: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   150: aconst_null
    //   151: areturn
    //   152: astore 4
    //   154: aload 4
    //   156: invokevirtual 222	java/lang/Exception:printStackTrace	()V
    //   159: ldc 12
    //   161: iconst_1
    //   162: new 166	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   169: ldc 224
    //   171: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 4
    //   176: invokevirtual 225	java/lang/Exception:toString	()Ljava/lang/String;
    //   179: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aconst_null
    //   189: astore 4
    //   191: goto -93 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	FileUploader
    //   0	194	1	paramLong	long
    //   69	24	3	i	int
    //   73	26	4	arrayOfByte	byte[]
    //   101	3	4	localIOException1	IOException
    //   138	8	4	localIOException2	IOException
    //   152	23	4	localException	java.lang.Exception
    //   189	1	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   33	47	101	java/io/IOException
    //   126	135	138	java/io/IOException
    //   75	98	152	java/lang/Exception
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl = new isb(this);
    new Handler().postDelayed(new isa(this), paramInt);
  }
  
  private void b(long paramLong, String paramString)
  {
    String str = "RangSizeError_rangError tSize[" + paramLong + "]<=mSize[" + this.jdField_d_of_type_Long + "], lastRoolbackSize[" + this.jdField_c_of_type_Long + "], retry[" + this.g + "]";
    if (paramLong <= this.jdField_c_of_type_Long)
    {
      int i = this.g + 1;
      this.g = i;
      if (i > 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, paramLong, str, paramString);
        return;
      }
    }
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_d_of_type_Long = paramLong;
    new Handler().postDelayed(new irz(this), 6000L);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(false, paramLong, str, paramString);
  }
  
  public int a()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Isd.a();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, 9343, "parseDataErr", null);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (-9527 == paramInt)
    {
      if (paramString1.indexOf("-29602") > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, -29602, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-6101") > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, 9042, paramString1, paramString2);
        return;
      }
      if (paramString1.indexOf("-29120") > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.g();
        return;
      }
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2);
      return;
    }
    if (FileHttpUtils.a(paramInt)) {
      a(paramInt);
    }
    if (this.jdField_c_of_type_Int < 8)
    {
      this.f += 1;
      if ((this.jdField_d_of_type_Int < 3) && (9056 == paramInt))
      {
        this.jdField_d_of_type_Int += 1;
        if (paramInt != 9056) {
          break label248;
        }
      }
    }
    label248:
    for (int i = 0;; i = 6000)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(false, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2);
      b(i);
      return;
      this.jdField_d_of_type_Int = 0;
      this.jdField_c_of_type_Int += 1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFlowControl.a();
    if (paramLong <= this.jdField_d_of_type_Long)
    {
      b(paramLong, paramString);
      return;
    }
    if ((this.jdField_d_of_type_Long == 0L) && (paramLong == this.jdField_b_of_type_Long))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a();
      return;
    }
    this.jdField_d_of_type_Long = paramLong;
    if (QLog.isColorLevel()) {
      QLog.i("FtnHttpUploader<FileAssistant>", 2, "send http data size[" + String.valueOf(this.jdField_d_of_type_Long) + "] fileSize[" + this.jdField_b_of_type_Long + "] success!");
    }
    if (paramLong < this.jdField_b_of_type_Long)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(paramLong);
      this.jdField_d_of_type_Int = 0;
      this.jdField_c_of_type_Int = 0;
      a(this.jdField_d_of_type_Long);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.b();
  }
  
  public void a(FileUploader.IFileUploaderSink paramIFileUploaderSink)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink = paramIFileUploaderSink;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a(true, this.jdField_d_of_type_Long, 9062, "UrlOver", null);
  }
  
  public boolean a(long paramLong)
  {
    byte[] arrayOfByte = a(paramLong);
    if (arrayOfByte == null)
    {
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "getSendStreamSlice return null");
      return false;
    }
    return this.jdField_a_of_type_Isd.a(this.jdField_c_of_type_JavaLangString, paramLong, arrayOfByte);
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFileUploader$IFileUploaderSink.a();
  }
  
  public int c()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileUploader
 * JD-Core Version:    0.7.0.1
 */