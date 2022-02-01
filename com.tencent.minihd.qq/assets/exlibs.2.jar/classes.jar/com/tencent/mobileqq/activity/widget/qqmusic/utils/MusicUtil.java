package com.tencent.mobileqq.activity.widget.qqmusic.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.activity.widget.qqmusic.common.MusicPreferences;
import com.tencent.open.business.base.MobileInfoUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.zip.Inflater;

public class MusicUtil
{
  private static char jdField_a_of_type_Char = '\000';
  public static String a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "|", "\\", "*", "\"", ":" };
  private static char b = '\000';
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  private static final String f = "MusicUtil";
  private static String g;
  private static String h;
  
  static
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_b_of_type_JavaLangString = null;
    c = null;
    d = null;
    e = null;
    jdField_a_of_type_Char = '<';
    jdField_b_of_type_Char = '>';
    h = "em";
  }
  
  public static float a(String paramString, float paramFloat)
  {
    float f1 = paramFloat;
    if (paramString != null)
    {
      f1 = paramFloat;
      if (paramString.length() <= 0) {}
    }
    try
    {
      f1 = Float.parseFloat(paramString);
      return f1;
    }
    catch (Exception paramString) {}
    return paramFloat;
  }
  
  public static int a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static int a(String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramString != null)
    {
      i = paramInt;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public static long a()
  {
    return System.currentTimeMillis() / 1000L / 3600L / 24L;
  }
  
  public static long a(String paramString, int paramInt)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        long l = Long.parseLong(paramString);
        return l;
      }
      catch (Exception paramString) {}
    }
    return paramInt;
  }
  
  public static ColorSet a(String paramString)
  {
    int j = 0;
    CharStack localCharStack1 = new CharStack();
    CharStack localCharStack2 = new CharStack();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    char[] arrayOfChar = paramString.toCharArray();
    ColorSet localColorSet = new ColorSet();
    int i = 0;
    for (;;)
    {
      StringBuffer localStringBuffer;
      try
      {
        if (i >= arrayOfChar.length) {
          break label291;
        }
        if (arrayOfChar[i] == jdField_a_of_type_Char)
        {
          localCharStack2.a(arrayOfChar[i]);
          localCharStack1.a(arrayOfChar[i]);
          k = j;
        }
        else if (arrayOfChar[i] == jdField_b_of_type_Char)
        {
          k = j;
          if (localCharStack2.b() != jdField_a_of_type_Char) {
            break label311;
          }
          localStringBuffer = new StringBuffer();
          localStringBuffer.insert(0, localCharStack1.a());
          if (localCharStack1.b() != jdField_a_of_type_Char) {
            continue;
          }
          if (localStringBuffer.toString().equals(h))
          {
            localCharStack1.a();
            k = localCharStack1.a();
          }
          else if (localStringBuffer.toString().equals("/" + h))
          {
            localCharStack1.a();
            localLinkedHashMap.put(Integer.valueOf(j), localCharStack1.a(j, localCharStack1.a()).toString());
            k = j;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localColorSet.jdField_a_of_type_JavaLangString = paramString;
        return localColorSet;
      }
      localException.a(localStringBuffer.toString());
      localException.a(arrayOfChar[i]);
      int k = j;
      break label311;
      localException.a(arrayOfChar[i]);
      k = j;
      break label311;
      label291:
      localColorSet.jdField_a_of_type_JavaUtilLinkedHashMap = localLinkedHashMap;
      localColorSet.jdField_a_of_type_JavaLangString = localException.toString();
      return localColorSet;
      label311:
      i += 1;
      j = k;
    }
  }
  
  public static String a()
  {
    return "10014292";
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      if (jdField_a_of_type_JavaLangString == null)
      {
        String str = "" + MobileInfoUtil.c();
        long l1 = ("" + Settings.Secure.getString(paramContext.getContentResolver(), "android_id")).hashCode();
        long l2 = str.hashCode();
        paramContext = new UUID(l1, "".hashCode() | l2 << 32 | System.currentTimeMillis());
        if (paramContext.toString() != null) {
          jdField_a_of_type_JavaLangString = paramContext.toString().replace("-", "");
        }
      }
      paramContext = jdField_a_of_type_JavaLangString;
      return paramContext;
    }
    finally {}
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return a(a(a(a(paramString, "&", "&amp;"), "<", "&lt;"), ">", "&gt;"), "\"", "&quot;");
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      localObject = null;
    }
    int i;
    String str;
    do
    {
      return localObject;
      i = paramString1.indexOf(paramString2);
      str = "";
      localObject = paramString1;
    } while (i < 0);
    Object localObject = str;
    while (i >= 0)
    {
      localObject = (String)localObject + paramString1.substring(0, i) + paramString3;
      paramString1 = paramString1.substring(i + paramString2.length());
      i = paramString1.indexOf(paramString2);
    }
    return (String)localObject + paramString1;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return "";
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() <= 0);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return true;
    }
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.equals(paramString2);
    }
    return false;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Inflater localInflater = new Inflater();
    localInflater.reset();
    localInflater.setInput(paramArrayOfByte);
    localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      paramArrayOfByte = new byte[1024];
      while (!localInflater.finished()) {
        localByteArrayOutputStream.write(paramArrayOfByte, 0, localInflater.inflate(paramArrayOfByte));
      }
      try
      {
        localByteArrayOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte = paramArrayOfByte;
      paramArrayOfByte.printStackTrace();
      for (;;)
      {
        try
        {
          localByteArrayOutputStream.close();
          paramArrayOfByte = null;
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
          continue;
        }
        localInflater.end();
        return paramArrayOfByte;
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        try
        {
          localByteArrayOutputStream.close();
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
        }
      }
    }
    finally {}
  }
  
  public static char[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    Charset localCharset = Charset.forName("UTF-8");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfByte.length);
    localByteBuffer.put(paramArrayOfByte);
    localByteBuffer.flip();
    return localCharset.decode(localByteBuffer).array();
  }
  
  public static String b()
  {
    String str2 = a();
    try
    {
      e = MusicPreferences.a().b();
      label13:
      String str1;
      if (e == null)
      {
        str1 = MusicPreferences.a().c();
        if (str1 != null) {
          break label62;
        }
        str1 = str2;
        if (str2 == null) {
          str1 = "0000";
        }
        MusicPreferences.a().c(str1);
        MusicPreferences.a().b(str1);
        e = str1;
      }
      for (;;)
      {
        return e;
        label62:
        if (!str1.equalsIgnoreCase(str2))
        {
          MusicPreferences.a().b(str1);
          e = str1;
          MusicPreferences.a().c(str2);
        }
        else
        {
          e = MusicPreferences.a().b();
          if (e == null) {
            e = str1;
          }
        }
      }
    }
    catch (Exception localException)
    {
      break label13;
    }
  }
  
  public static String b(Context paramContext)
  {
    if (jdField_b_of_type_JavaLangString == null)
    {
      String str = "" + MobileInfoUtil.c();
      long l1 = ("" + Settings.Secure.getString(paramContext.getContentResolver(), "android_id")).hashCode();
      long l2 = str.hashCode();
      paramContext = new UUID(l1, "".hashCode() | l2 << 32);
      if (paramContext.toString() != null) {
        jdField_b_of_type_JavaLangString = paramContext.toString().replace("-", "");
      }
    }
    return jdField_b_of_type_JavaLangString;
  }
  
  public static String b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new String(Base64.decode(paramString, 0), "UTF-8");
        return paramString;
      }
      catch (Exception paramString)
      {
        MLog.d("MusicUtil", "decode error : " + paramString.getMessage());
      }
    }
    return "";
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length - 5];
    try
    {
      paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
      paramArrayOfByte.skip(5L);
      paramArrayOfByte.read(arrayOfByte);
      paramArrayOfByte = new ByteArrayOutputStream();
      paramArrayOfByte.write(arrayOfByte, 0, arrayOfByte.length);
      paramArrayOfByte = a(paramArrayOfByte.toByteArray());
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext == null) {}
    while (MobileInfoUtil.d() != null) {
      return null;
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        paramString = new String(URLDecoder.decode(paramString, "UTF-8"));
        return paramString;
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  public static String d(Context paramContext)
  {
    if ((c == null) && (paramContext != null))
    {
      paramContext = c(paramContext);
      if ((paramContext != null) && (paramContext.length() == 15)) {
        c = paramContext.substring(0, 2);
      }
    }
    return c;
  }
  
  public static String d(String paramString)
  {
    if (paramString != null)
    {
      int i = 0;
      for (;;)
      {
        str = paramString;
        if (i >= jdField_a_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        paramString = paramString.replace(jdField_a_of_type_ArrayOfJavaLangString[i], "_");
        i += 1;
      }
    }
    String str = "";
    return str;
  }
  
  public static String e(Context paramContext)
  {
    if ((d == null) && (paramContext != null))
    {
      paramContext = c(paramContext);
      if ((paramContext != null) && (paramContext.length() == 15)) {
        d = paramContext.substring(3, 4);
      }
    }
    return d;
  }
  
  public static String e(String paramString)
  {
    int i = 1;
    if ((paramString == null) || (paramString.length() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (paramString.length() > 8)
    {
      int j = paramString.length() - 8;
      str = paramString.substring(0, paramString.length() - 8);
      i = j;
      while (i < paramString.length())
      {
        localStringBuilder.append((Integer.parseInt(paramString.substring(i, i + 1)) + 8 - i + j) % 10);
        i += 1;
      }
    }
    for (paramString = str;; paramString = str)
    {
      return paramString + localStringBuilder.toString();
      str = paramString.substring(0, 1);
      while (i < paramString.length())
      {
        localStringBuilder.append((Integer.parseInt(paramString.substring(i, i + 1)) + paramString.length() - i) % 10);
        i += 1;
      }
    }
  }
  
  public static String f(Context paramContext)
  {
    if ((g != null) && (!TextUtils.isEmpty(g))) {
      return g;
    }
    if (paramContext == null) {
      return "";
    }
    g = MobileInfoUtil.c();
    if (g == null) {
      g = "";
    }
    return g;
  }
  
  public static String g(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        Object localObject;
        if (paramContext != null)
        {
          paramContext = paramContext.getConnectionInfo();
          if (paramContext != null)
          {
            paramContext = paramContext.getMacAddress();
            localObject = paramContext;
            if (paramContext != null) {
              localObject = paramContext;
            }
          }
        }
        byte[] arrayOfByte;
        int i;
        paramContext = "";
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if (paramContext.length() > 0)
          {
            arrayOfByte = paramContext.getBytes();
            localObject = paramContext;
            if (arrayOfByte != null)
            {
              localObject = paramContext;
              if (arrayOfByte.length > 0)
              {
                i = 0;
                localObject = paramContext;
                if (i < arrayOfByte.length)
                {
                  if (arrayOfByte[0] != 0) {
                    continue;
                  }
                  localObject = "";
                }
              }
            }
          }
          return localObject;
          i += 1;
          continue;
          localThrowable1 = localThrowable1;
          paramContext = "";
        }
        catch (Throwable localThrowable2)
        {
          continue;
        }
        localThrowable1.printStackTrace();
        return paramContext;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil
 * JD-Core Version:    0.7.0.1
 */