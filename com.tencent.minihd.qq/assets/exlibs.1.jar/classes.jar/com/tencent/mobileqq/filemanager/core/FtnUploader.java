package com.tencent.mobileqq.filemanager.core;

import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import isc;
import isd;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class FtnUploader
  implements IHttpCommunicatorListener, isd
{
  private static final String jdField_a_of_type_JavaLangString = "FtnHttpUploader<FileAssistant>";
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  private isc jdField_a_of_type_Isc;
  private boolean jdField_a_of_type_Boolean = false;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  private final int jdField_b_of_type_Int;
  private final long jdField_b_of_type_Long;
  private final byte[] jdField_b_of_type_ArrayOfByte;
  
  private FtnUploader(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(paramString1);
    this.jdField_b_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(paramString2);
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public static FtnUploader a(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, String paramString1, String paramString2, long paramLong2)
  {
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFtnHttpUploader strCheckSum is null");
      }
      return null;
    }
    if (paramString1.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFtnHttpUploader strCheckSum is empty");
      }
      return null;
    }
    if (paramString2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFtnHttpUploader strSHA is null");
      }
      return null;
    }
    if (paramString2.length() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "getFtnHttpUploader strSHA is empty");
      }
      return null;
    }
    return new FtnUploader(paramQQAppInterface, paramLong1, paramInt1, paramInt2, paramString1, paramString2, paramLong2);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    DataInputStream localDataInputStream = new DataInputStream(paramArrayOfByte);
    try
    {
      localDataInputStream.skip(4L);
      if (localDataInputStream.readInt() != 0) {
        this.jdField_a_of_type_Isc.a(9001, "httpServer retCode!=0");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        int i;
        int j;
        long l1;
        long l2;
        localIOException.printStackTrace();
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "unPackageData exception:" + localIOException.toString());
        this.jdField_a_of_type_Isc.a(9001, "httpServer flag!=0 flag!=1");
        try
        {
          paramArrayOfByte.close();
          localDataInputStream.close();
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          return;
        }
        this.jdField_a_of_type_Isc.a(9001, "httpServer flag!=0 flag!=1");
      }
    }
    finally
    {
      try
      {
        paramArrayOfByte.close();
        localDataInputStream.close();
        throw localObject;
      }
      catch (Exception paramArrayOfByte)
      {
        break label240;
      }
    }
    try
    {
      paramArrayOfByte.close();
      localDataInputStream.close();
      return;
    }
    catch (Exception paramArrayOfByte) {}
    localDataInputStream.skip(8L);
    i = localDataInputStream.readByte();
    if (i == 0)
    {
      i = localDataInputStream.readInt();
      j = localDataInputStream.readInt();
      l1 = i;
      l2 = j << 32;
      this.jdField_a_of_type_Isc.a(l1 & 0xFFFFFFF | l2, null);
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte.close();
        localDataInputStream.close();
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        return;
      }
      if (i != 1) {
        break;
      }
      this.jdField_a_of_type_Isc.b();
    }
    label240:
  }
  
  private byte[] a(long paramLong, byte[] paramArrayOfByte)
  {
    int i = this.jdField_a_of_type_ArrayOfByte.length + 2 + 2 + this.jdField_b_of_type_ArrayOfByte.length + 20 + paramArrayOfByte.length;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(i + 16);
    DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
    try
    {
      localDataOutputStream.writeInt(-1412589450);
      localDataOutputStream.writeInt(1007);
      localDataOutputStream.writeInt(0);
      localDataOutputStream.writeInt(i);
      localDataOutputStream.writeShort(this.jdField_a_of_type_ArrayOfByte.length);
      localDataOutputStream.write(this.jdField_a_of_type_ArrayOfByte);
      localDataOutputStream.writeShort(this.jdField_b_of_type_ArrayOfByte.length);
      localDataOutputStream.write(this.jdField_b_of_type_ArrayOfByte);
      localDataOutputStream.writeInt((int)(this.jdField_b_of_type_Long & 0xFFFFFFFF));
      localDataOutputStream.writeInt((int)(paramLong & 0xFFFFFFFF));
      localDataOutputStream.writeInt(paramArrayOfByte.length);
      localDataOutputStream.writeInt((int)(this.jdField_b_of_type_Long >> 32));
      localDataOutputStream.writeInt((int)(paramLong >> 32));
      localDataOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      label255:
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramArrayOfByte.printStackTrace();
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "packageData exception:" + paramArrayOfByte.toString());
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        return null;
      }
    }
    finally
    {
      try
      {
        localByteArrayOutputStream.close();
        localDataOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (Exception localException1)
      {
        break label255;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
    }
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    int i;
    int j;
    int k;
    if (paramHttpMsg != null)
    {
      i = paramHttpMsg.d;
      j = paramHttpMsg.e;
      k = paramHttpMsg.f;
      if (!"POST".equals(paramHttpMsg.e())) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool, k, i, j, paramHttpMsg.i);
      return;
    }
  }
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Long) + "]已经结束,返回");
      }
    }
    do
    {
      return;
      if (paramHttpMsg1 == this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) {
        break;
      }
      if ((paramHttpMsg1 != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null))
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(paramHttpMsg1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a()) + "]");
        return;
      }
      if (paramHttpMsg1 != null)
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(paramHttpMsg1.a()) + "]");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null);
    QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a()) + "]");
    return;
    if (paramHttpMsg2.c() == 200) {
      if (paramHttpMsg2.a("User-ReturnCode") == null) {
        break label374;
      }
    }
    label374:
    for (long l = Long.parseLong(paramHttpMsg2.a("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.jdField_a_of_type_Isc.a(paramHttpMsg2.h, paramHttpMsg2.d(), paramHttpMsg2.ah);
        return;
      }
      a(paramHttpMsg2.a());
      return;
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],decode but response Code [" + paramHttpMsg2.c() + "] is not 200");
      return;
    }
  }
  
  public void a(isc paramisc)
  {
    this.jdField_a_of_type_Isc = paramisc;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Isc.a(paramString);
  }
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = a(paramLong, paramArrayOfByte);
    if (paramArrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FtnHttpUploader<FileAssistant>", 2, "sendData packageData return null");
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = new HttpMsg(paramString, paramArrayOfByte, this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.b(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a("cache-control", "no-cache");
    paramString = "gprs";
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
      paramString = "wifi";
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a("Net-type", paramString);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.c("POST");
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.b(1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.e = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.ae = String.valueOf(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    return true;
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Isc.a(paramHttpMsg2.h, paramHttpMsg2.d(), paramHttpMsg2.ah);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FtnUploader
 * JD-Core Version:    0.7.0.1
 */