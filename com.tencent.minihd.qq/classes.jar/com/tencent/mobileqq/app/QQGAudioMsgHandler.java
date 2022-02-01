package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;
import java.util.Vector;

public class QQGAudioMsgHandler
{
  static final int jdField_a_of_type_Int = 141;
  static final String jdField_a_of_type_JavaLangString = "QQGAudioMsgHandler";
  static final int jdField_b_of_type_Int = 195;
  private static final String jdField_b_of_type_JavaLangString = "com.tencent.minihd.qq:video";
  static final int c = 149;
  static final int d = 49;
  static final int e = 59;
  static final int f = 7;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  Vector jdField_a_of_type_JavaUtilVector = new Vector();
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = new byte['ª'];
  
  public QQGAudioMsgHandler(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt)
  {
    int k = 0;
    int j = 0;
    int i = j;
    if (paramArrayOfByte.length == paramInt)
    {
      if (paramArrayOfByte.length > 4) {
        i = j;
      }
    }
    else {
      return i;
    }
    j = paramInt - 1;
    paramInt = k;
    for (;;)
    {
      i = paramInt;
      if (j < 0) {
        break;
      }
      paramInt = (int)(paramInt | (paramArrayOfByte[j] & 0xFF) << j * 8);
      j -= 1;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilVector != null) {
      this.jdField_a_of_type_JavaUtilVector.clear();
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2) {}
  
  void a(int paramInt, byte[] paramArrayOfByte) {}
  
  void a(long paramLong) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 2);
    int i = arrayOfByte[0];
    i = (arrayOfByte[1] & 0xFF) << 0 | (i & 0xFF) << 8;
    if (QLog.isColorLevel()) {
      QLog.d("QQGAudioMsgHandler", 2, "onRecvMultiVideoS2CData: msgType = " + i);
    }
    if (!a()) {
      if ((141 == i) || (7 == i)) {
        a(i, paramArrayOfByte);
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (i)
            {
            case 59: 
            case 195: 
            default: 
              return;
            }
          } while (this.jdField_a_of_type_ArrayOfByte == null);
          i = paramArrayOfByte.length;
        } while (i < 40);
        if (this.jdField_a_of_type_ArrayOfByte.length < i) {
          this.jdField_a_of_type_ArrayOfByte = new byte[i];
        }
        System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, i);
        h(paramArrayOfByte);
        return;
      } while (this.jdField_a_of_type_ArrayOfByte == null);
      i = paramArrayOfByte.length;
    } while (i < 40);
    if (this.jdField_a_of_type_ArrayOfByte.length < i) {
      this.jdField_a_of_type_ArrayOfByte = new byte[i];
    }
    System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, i);
    g(this.jdField_a_of_type_ArrayOfByte);
    return;
    f(paramArrayOfByte);
  }
  
  void a(byte[] paramArrayOfByte, int paramInt) {}
  
  boolean a()
  {
    return false;
  }
  
  void b(long paramLong) {}
  
  public void b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[2];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 2);
    int i = arrayOfByte[0];
    if (((arrayOfByte[1] & 0xFF) << 0 | (i & 0xFF) << 8) == 49) {
      d(paramArrayOfByte);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
  }
  
  void c(long paramLong) {}
  
  public void c(byte[] paramArrayOfByte) {}
  
  public void d(byte[] paramArrayOfByte) {}
  
  public void e(byte[] paramArrayOfByte) {}
  
  public void f(byte[] paramArrayOfByte) {}
  
  void g(byte[] paramArrayOfByte) {}
  
  void h(byte[] paramArrayOfByte) {}
  
  public void i(byte[] paramArrayOfByte) {}
  
  void j(byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQGAudioMsgHandler
 * JD-Core Version:    0.7.0.1
 */