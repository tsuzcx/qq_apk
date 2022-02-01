package com.tencent.biz.common.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cef;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util
{
  private static char a(int paramInt)
  {
    paramInt &= 0xF;
    if (paramInt < 10) {
      return (char)(paramInt + 48);
    }
    return (char)(paramInt - 10 + 97);
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static final String a(int paramInt)
  {
    String str = "";
    if (paramInt == 0) {
      str = "contact";
    }
    do
    {
      return str;
      if (paramInt == 1) {
        return "group";
      }
    } while (paramInt != 3000);
    return "discussions";
  }
  
  public static String a(InputStream paramInputStream)
  {
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
      String str;
      InputStream localInputStream;
      for (paramInputStream = "";; paramInputStream = paramInputStream + str)
      {
        str = localBufferedReader.readLine();
        localInputStream = paramInputStream;
        if (str == null) {
          break;
        }
      }
      return localInputStream;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
      localInputStream = null;
    }
  }
  
  public static String a(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      byte[] arrayOfByte = ((MessageDigest)localObject).digest();
      localObject = paramString;
      if (arrayOfByte != null)
      {
        localObject = new StringBuilder();
        int j = arrayOfByte.length;
        int i = 0;
        while (i < j)
        {
          int k = arrayOfByte[i];
          ((StringBuilder)localObject).append(a(k >>> 4));
          ((StringBuilder)localObject).append(a(k));
          i += 1;
        }
        localObject = ((StringBuilder)localObject).toString();
      }
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return paramString;
  }
  
  public static String a(String paramString, String... paramVarArgs)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      str = paramString;
      return str;
    }
    paramString = paramString.replaceAll("(?<=\\?|#|&)((?i)sid|3g_sid|uin|sec_sig|MOBINFO|originuin)=[^&#]*&", "").replaceAll("[\\?#&]((?i)sid|3g_sid|uin|sec_sig|MOBINFO|originuin)=[^&#]*(?=#|$)", "").replaceAll("(?<=\\?|#|&)((?i)from)=androidqq&", "").replaceAll("[\\?#&]((?i)from)=androidqq(?=#|$)", "");
    int j = paramVarArgs.length;
    int i = 0;
    for (;;)
    {
      str = paramString;
      if (i >= j) {
        break;
      }
      paramString = paramString.replace(paramVarArgs[i], "");
      i += 1;
    }
  }
  
  public static void a(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    ((Activity)paramContext).setResult(-1, localIntent);
  }
  
  public static final void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addCategory("android.intent.category.BROWSABLE");
    localIntent.setData(Uri.parse(paramString));
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QLog", 2, paramContext.getMessage());
    }
  }
  
  public static final void a(QQAppInterface paramQQAppInterface, LoadedCallBack paramLoadedCallBack)
  {
    new Thread(new cef(paramQQAppInterface, paramLoadedCallBack)).start();
  }
  
  public static final void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3)
  {
    a(paramQQAppInterface, paramString1, "connect_share2qq", paramString2, paramLong1, paramLong2, paramString3);
  }
  
  public static final void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, String paramString4)
  {
    if (paramString4 == null) {
      paramString4 = "";
    }
    for (;;)
    {
      if (paramString1 == null) {
        paramString1 = "";
      }
      for (;;)
      {
        String str1 = "";
        if (paramLong2 > 0L) {
          str1 = String.valueOf(paramLong2);
        }
        String str2 = "";
        if (paramLong1 > 0L) {
          str2 = String.valueOf(paramLong1);
        }
        ReportController.b(paramQQAppInterface, "P_CliOper", "qqconnect", paramString1, paramString2, paramString3, 0, 0, str2, str1, paramString4, "");
        return;
      }
    }
  }
  
  public static boolean a()
  {
    File localFile = null;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localFile = Environment.getExternalStorageDirectory();
    }
    return localFile != null;
  }
  
  public static boolean a(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject;
    do
    {
      do
      {
        return false;
        localObject = paramString;
        if (!paramString.endsWith(File.separator)) {
          localObject = paramString + File.separator;
        }
        paramString = new File((String)localObject);
      } while ((paramString == null) || (!paramString.exists()) || (!paramString.isDirectory()));
      localObject = paramString.listFiles();
    } while (localObject == null);
    if (i < localObject.length)
    {
      if (localObject[i] == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (localObject[i].isFile()) {
          b(localObject[i].getAbsolutePath());
        } else {
          a(localObject[i].getAbsolutePath());
        }
      }
    }
    paramString.delete();
    return true;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    localStringBuilder.append("\"");
    int j = paramString.length();
    int i = 0;
    if (i < j)
    {
      char c = paramString.charAt(i);
      switch (c)
      {
      default: 
        if (c <= '\037') {
          localStringBuilder.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
        }
        break;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append('\\').append(c);
        continue;
        localStringBuilder.append("\\t");
        continue;
        localStringBuilder.append("\\b");
        continue;
        localStringBuilder.append("\\n");
        continue;
        localStringBuilder.append("\\r");
        continue;
        localStringBuilder.append("\\f");
        continue;
        localStringBuilder.append(c);
      }
    }
    localStringBuilder.append("\"");
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString, String... paramVarArgs)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.replaceAll("((?i)sid|uin|sec_sig|MOBINFO)=[^&#]+", "$1=****");
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString);
    boolean bool1 = bool2;
    if (paramString.isFile())
    {
      bool1 = bool2;
      if (!paramString.exists()) {}
    }
    try
    {
      paramString.delete();
      bool1 = true;
      return bool1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public static String c(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString.isHierarchical())
      {
        paramString = paramString.getHost();
        if (paramString != null)
        {
          paramString = paramString.split("\\.");
          if (paramString.length > 0)
          {
            int i = Math.max(0, paramString.length - 2);
            StringBuilder localStringBuilder = new StringBuilder(256);
            localStringBuilder.append(paramString[i]);
            i += 1;
            while (i < paramString.length)
            {
              localStringBuilder.append('.').append(paramString[i]);
              i += 1;
            }
            paramString = localStringBuilder.toString();
            return paramString;
          }
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String d(String paramString)
  {
    paramString = Uri.parse(paramString);
    if (paramString.isHierarchical())
    {
      paramString = paramString.getHost();
      if (paramString != null)
      {
        paramString = paramString.split("\\.");
        if (paramString.length > 0)
        {
          int i = Math.max(0, paramString.length - 3);
          StringBuilder localStringBuilder = new StringBuilder(256);
          localStringBuilder.append(paramString[i]);
          i += 1;
          while (i < paramString.length)
          {
            localStringBuilder.append('.').append(paramString[i]);
            i += 1;
          }
          return localStringBuilder.toString();
        }
      }
    }
    return "";
  }
  
  public static String e(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
          paramString[i] = ((char)(paramString[i] - 65248));
        }
      }
    }
    return new String(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.common.util.Util
 * JD-Core Version:    0.7.0.1
 */