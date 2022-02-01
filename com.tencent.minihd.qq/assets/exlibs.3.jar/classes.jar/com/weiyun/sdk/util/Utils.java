package com.weiyun.sdk.util;

import com.weiyun.sdk.log.Log;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils
{
  private static final String TAG = "Utils";
  
  public static boolean checkDirAndCreate(String paramString)
  {
    File localFile = new File(paramString);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      Log.e("Utils", "mkdirs failed, path:" + paramString);
      return false;
    }
    return true;
  }
  
  public static boolean checkFileExist(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static String encodeUrlString(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Log.w("Utils", localUnsupportedEncodingException);
    }
    return paramString;
  }
  
  public static String fileRename(String paramString, int paramInt)
  {
    int i = paramString.lastIndexOf('.');
    String str2 = paramString;
    String str1 = "";
    if (i >= 0)
    {
      str2 = paramString.substring(0, i);
      str1 = paramString.substring(i);
    }
    paramString = new StringBuilder(str2);
    paramString.append("(").append(String.valueOf(paramInt)).append(")").append(str1);
    return paramString.toString();
  }
  
  public static String generateNewFilename(String paramString)
  {
    if (paramString.matches(".*\\(\\d*\\)[\\.]*[a-zA-Z0-9]*$"))
    {
      String str1 = paramString.substring(paramString.lastIndexOf("(") + 1, paramString.lastIndexOf(")"));
      try
      {
        int i = Integer.valueOf(str1).intValue();
        int j = paramString.lastIndexOf(".");
        String str2 = paramString.substring(0, paramString.lastIndexOf("("));
        str1 = "";
        if (j >= 0) {
          str1 = paramString.substring(j);
        }
        return fileRename(str2 + str1, i + 1);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        return fileRename(paramString, 1);
      }
    }
    return fileRename(paramString, 1);
  }
  
  public static String getFileNameFromPath(String paramString)
  {
    return new File(paramString).getName();
  }
  
  public static long getFileSize(String paramString)
  {
    try
    {
      long l = new File(paramString).length();
      return l;
    }
    catch (Exception paramString)
    {
      Log.w("Utils", paramString);
    }
    return -1L;
  }
  
  public static String getStackTraceAsString(Throwable paramThrowable)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder(" StackTrace:");
    if ((arrayOfStackTraceElement != null) && (arrayOfStackTraceElement.length > 0))
    {
      int i = 0;
      while ((i < arrayOfStackTraceElement.length) && (i < 2))
      {
        localStringBuilder.append(arrayOfStackTraceElement[i]);
        i += 1;
      }
    }
    paramThrowable = paramThrowable.toString() + localStringBuilder.toString();
    return Pattern.compile("\t|\r|\n").matcher(paramThrowable).replaceAll(" ");
  }
  
  public static URL getURL(String paramString)
    throws MalformedURLException
  {
    URL localURL = new URL(paramString);
    String str = localURL.getHost();
    int i = str.indexOf(':');
    paramString = localURL;
    if (i >= 0)
    {
      paramString = str.substring(0, i);
      i = Integer.parseInt(str.substring(i + 1));
      paramString = new URL(localURL.getProtocol(), paramString, i, localURL.getFile());
    }
    return paramString;
  }
  
  public static boolean isEmptyString(String paramString)
  {
    return (paramString == null) || (paramString.equals(""));
  }
  
  public static void removeFile(String paramString)
  {
    File localFile = new File(paramString);
    if ((localFile.exists()) && (!localFile.delete())) {
      Log.d("Utils", "delete file failed. path=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.util.Utils
 * JD-Core Version:    0.7.0.1
 */