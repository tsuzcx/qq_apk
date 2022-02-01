package com.tencent.mobileqq.portal;

import android.text.TextUtils;
import com.tencent.qphone.base.util.MD5;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PortalUtils
{
  public static final String a = "com.tencent.msg.permission.pushnotify2";
  protected static MessageDigest a;
  private static char[] a;
  
  static
  {
    jdField_a_of_type_JavaSecurityMessageDigest = null;
    jdField_a_of_type_ArrayOfChar = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  }
  
  public static String a(long paramLong)
  {
    Object localObject = new java.sql.Date(paramLong);
    localObject = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format((java.util.Date)localObject);
    return ((String)localObject).substring(0, ((String)localObject).lastIndexOf(":"));
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = b(MD5.getPartfileMd5(paramString, 0L));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    int i = paramString1.indexOf("?");
    if (i > 0) {
      if (paramString1.length() == i + 1) {
        paramString1 = paramString1 + paramString2;
      }
    }
    for (;;)
    {
      return paramString1;
      i = paramString1.indexOf("#", i);
      if (i > -1)
      {
        paramString1 = paramString1.substring(0, i);
        if (paramString1.endsWith("&")) {
          paramString1 = paramString1 + paramString2 + paramString1.substring(i);
        } else {
          paramString1 = paramString1 + "&" + paramString2 + paramString1.substring(i);
        }
      }
      else if (paramString1.endsWith("&"))
      {
        paramString1 = paramString1 + paramString2;
      }
      else
      {
        paramString1 = paramString1 + "&" + paramString2;
        continue;
        if (paramString1.length() > 0) {
          paramString1 = paramString1 + "?" + paramString2;
        }
      }
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (jdField_a_of_type_JavaSecurityMessageDigest == null) {}
    try
    {
      jdField_a_of_type_JavaSecurityMessageDigest = MessageDigest.getInstance("MD5");
      jdField_a_of_type_JavaSecurityMessageDigest.update(paramArrayOfByte);
      return b(jdField_a_of_type_JavaSecurityMessageDigest.digest());
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      a(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static ArrayList a(String paramString)
  {
    paramString = paramString.split("\\|");
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramString.length)
    {
      if ((TextUtils.isEmpty(paramString[i])) || (!a(paramString[i]))) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(Integer.valueOf(Integer.valueOf(paramString[i]).intValue() * 1000));
      }
    }
    return localArrayList;
  }
  
  private static void a(byte paramByte, StringBuffer paramStringBuffer)
  {
    char c1 = jdField_a_of_type_ArrayOfChar[((paramByte & 0xF0) >> 4)];
    char c2 = jdField_a_of_type_ArrayOfChar[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalUtils
 * JD-Core Version:    0.7.0.1
 */