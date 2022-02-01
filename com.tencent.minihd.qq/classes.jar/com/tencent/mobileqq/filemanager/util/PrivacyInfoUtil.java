package com.tencent.mobileqq.filemanager.util;

import com.tencent.qphone.base.util.QLog;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class PrivacyInfoUtil
{
  private final byte jdField_a_of_type_Byte = 0;
  private final int jdField_a_of_type_Int = 20;
  private final String jdField_a_of_type_JavaLangString = "PrivacyInfoUtil";
  private final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final byte[] jdField_a_of_type_ArrayOfByte = "gavinhuangdaydayup_happy".getBytes();
  private final byte jdField_b_of_type_Byte = 0;
  private final String jdField_b_of_type_JavaLangString = "DESede/ECB/PKCS5Padding";
  private final byte[] jdField_b_of_type_ArrayOfByte = "doscarlettmarryrenzzhang".getBytes();
  private final byte jdField_c_of_type_Byte = 1;
  private final String jdField_c_of_type_JavaLangString = "random";
  private final byte[] jdField_c_of_type_ArrayOfByte = "wangpeilin_georgewangson".getBytes();
  private final byte jdField_d_of_type_Byte = 0;
  private final byte[] jdField_d_of_type_ArrayOfByte = "georgebirthdayis19790526".getBytes();
  private final byte[] e = "qlinkwillthebestfunction".getBytes();
  private final byte[] f = "qqwillbebetterthanwechat".getBytes();
  private final byte[] g = "whowillbethenextbigtiger".getBytes();
  private final byte[] h = "whenwillwefindmahang_370".getBytes();
  private final byte[] i = "whenwillchinagetworldcap".getBytes();
  
  public PrivacyInfoUtil()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ArrayOfByte);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_ArrayOfByte);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_c_of_type_ArrayOfByte);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_d_of_type_ArrayOfByte);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.e);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.f);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.g);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.h);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.i);
  }
  
  private byte a()
  {
    return 0;
  }
  
  private String a(byte paramByte)
  {
    switch (paramByte)
    {
    default: 
      return null;
    case 0: 
      return "DESede/ECB/PKCS5Padding";
    }
    return "random";
  }
  
  private String a(byte paramByte1, byte paramByte2, byte paramByte3, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(20);
    Object localObject = a(paramByte1);
    if (localObject == null)
    {
      QLog.e("PrivacyInfoUtil", 1, "createCipherHotspot algorithm is null");
      return null;
    }
    byte[] arrayOfByte = a(paramByte3);
    if (arrayOfByte == null)
    {
      QLog.e("PrivacyInfoUtil", 1, "createCipherHotspot key is null");
      return null;
    }
    int j = 7;
    if (paramArrayOfByte.length < 8) {
      j = paramArrayOfByte.length - 1;
    }
    localObject = b((String)localObject, arrayOfByte, paramArrayOfByte, 1, j);
    if (localObject == null)
    {
      QLog.e("PrivacyInfoUtil", 1, "createCipherHotspot doCipher return null");
      return null;
    }
    j = 0;
    while (j < localObject.length)
    {
      localStringBuilder.append(Integer.toHexString((localObject[j] & 0xF0) >> 4));
      localStringBuilder.append(Integer.toHexString(localObject[j] & 0xF));
      j += 1;
    }
    localStringBuilder.append(Integer.toHexString((paramByte1 << 2) + paramByte2));
    localStringBuilder.append(Integer.toHexString(paramByte3));
    localStringBuilder.append(Integer.toHexString((paramArrayOfByte[0] & 0xF0) >> 4));
    localStringBuilder.append(Integer.toHexString(paramArrayOfByte[0] & 0xF));
    return localStringBuilder.toString();
  }
  
  private byte[] a(byte paramByte)
  {
    if ((paramByte >= 0) && (paramByte < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (byte[])this.jdField_a_of_type_JavaUtilArrayList.get(paramByte);
    }
    return null;
  }
  
  private byte[] a(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int j = 0;
    while (j < 8)
    {
      arrayOfByte[j] = ((byte)(int)(paramLong >> (7 - j) * 8 & 0xFF));
      j += 1;
    }
    return arrayOfByte;
  }
  
  private byte[] b(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, paramString);
      Cipher localCipher = Cipher.getInstance(paramString);
      localCipher.init(1, paramArrayOfByte1);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte2, paramInt1, paramInt2);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      QLog.e("PrivacyInfoUtil", 1, "doCipher NoSuchAlgorithmException exception, algorithm[" + paramString + "]");
      return null;
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
        QLog.e("PrivacyInfoUtil", 1, "doCipher NoSuchPaddingException exception, algorithm[" + paramString + "]");
      }
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
        QLog.e("PrivacyInfoUtil", 1, "doCipher lang exception, algorithm[" + paramString + "]");
      }
    }
  }
  
  public long a(String paramString)
  {
    int k = 0;
    long l2;
    if ((paramString == null) || (paramString.length() < 20)) {
      l2 = 0L;
    }
    for (;;)
    {
      return l2;
      try
      {
        j = Integer.valueOf(paramString.substring(16, 17), 16).byteValue();
        if ((byte)(j & 0x3) != 0) {
          return 0L;
        }
      }
      catch (NumberFormatException paramString)
      {
        return 0L;
      }
      Object localObject = a((byte)((j & 0xC) >> 2));
      if (localObject == null) {
        return 0L;
      }
      byte[] arrayOfByte1;
      try
      {
        byte b1 = Integer.valueOf(paramString.substring(17, 18), 16).byteValue();
        arrayOfByte1 = a(b1);
        if (arrayOfByte1 == null) {
          return 0L;
        }
      }
      catch (NumberFormatException paramString)
      {
        return 0L;
      }
      byte[] arrayOfByte2 = new byte[8];
      int j = 0;
      while (j < 8) {
        try
        {
          arrayOfByte2[j] = Integer.valueOf(paramString.substring(j * 2, j * 2 + 2), 16).byteValue();
          j += 1;
        }
        catch (NumberFormatException paramString)
        {
          return 0L;
        }
      }
      localObject = a((String)localObject, arrayOfByte1, arrayOfByte2, 0, arrayOfByte2.length);
      if (localObject == null) {
        return 0L;
      }
      try
      {
        j = Integer.valueOf(paramString.substring(18, 20), 16).byteValue();
        long l1 = j;
        j = k;
        for (;;)
        {
          l2 = l1;
          if (j >= 7) {
            break;
          }
          l1 = ((l1 << 4) + ((localObject[j] & 0xF0) >> 4) << 4) + (localObject[j] & 0xF);
          j += 1;
        }
        return 0L;
      }
      catch (NumberFormatException paramString) {}
    }
  }
  
  public String a(long paramLong)
  {
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (str != null) {
      return str;
    }
    str = a(a(), (byte)0, (byte)0, a(paramLong));
    if (this.jdField_a_of_type_JavaUtilHashMap.size() > 20) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), str);
    return str;
  }
  
  public byte[] a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, paramString);
      Cipher localCipher = Cipher.getInstance(paramString);
      localCipher.init(2, paramArrayOfByte1);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte2, paramInt1, paramInt2);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("PrivacyInfoUtil", 2, "doDecrypt NoSuchAlgorithmException exception, algorithm[" + paramString + "]");
      }
      return null;
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PrivacyInfoUtil", 2, "doDecrypt NoSuchPaddingException exception, algorithm[" + paramString + "]");
        }
      }
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PrivacyInfoUtil", 2, "doDecrypt lang exception, algorithm[" + paramString + "]");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.PrivacyInfoUtil
 * JD-Core Version:    0.7.0.1
 */