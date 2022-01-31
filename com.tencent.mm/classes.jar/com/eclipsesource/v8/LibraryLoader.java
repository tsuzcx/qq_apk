package com.eclipsesource.v8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class LibraryLoader
{
  static final String DELIMITER = System.getProperty("line.separator");
  static final String SEPARATOR = System.getProperty("file.separator");
  static final String SWT_LIB_DIR = ".j2v8";
  
  static void chmod(String paramString1, String paramString2)
  {
    if (isWindows()) {
      return;
    }
    try
    {
      Runtime.getRuntime().exec(new String[] { "chmod", paramString1, paramString2 }).waitFor();
      return;
    }
    catch (Throwable paramString1) {}
  }
  
  private static String computeLibraryFullName()
  {
    return "lib" + computeLibraryShortName() + "." + getOSFileExtension();
  }
  
  private static String computeLibraryShortName()
  {
    String str1 = getOS();
    String str2 = getArchSuffix();
    return "j2v8" + "_" + str1 + "_" + str2;
  }
  
  static boolean extract(String paramString1, String paramString2, StringBuffer paramStringBuffer)
  {
    i = 1;
    File localFile = new File(paramString1);
    for (;;)
    {
      try
      {
        if (localFile.exists()) {
          localFile.delete();
        }
        paramString2 = LibraryLoader.class.getResourceAsStream("/" + paramString2);
        if (paramString2 == null) {}
      }
      catch (Throwable paramString1)
      {
        byte[] arrayOfByte;
        FileOutputStream localFileOutputStream;
        boolean bool;
        i = 0;
        paramString2 = null;
        paramString1 = null;
        continue;
      }
      try
      {
        arrayOfByte = new byte[4096];
        localFileOutputStream = new FileOutputStream(paramString1);
        try
        {
          int j = paramString2.read(arrayOfByte);
          if (j != -1)
          {
            localFileOutputStream.write(arrayOfByte, 0, j);
            continue;
            if (paramString1 == null) {}
          }
        }
        catch (Throwable paramString1)
        {
          paramString1 = localFileOutputStream;
        }
      }
      catch (Throwable paramString1)
      {
        paramString1 = null;
        continue;
      }
      try
      {
        paramString1.close();
        if (paramString2 == null) {}
      }
      catch (IOException paramString1)
      {
        try
        {
          paramString2.close();
          if ((i != 0) && (localFile.exists())) {
            localFile.delete();
          }
          return false;
          localFileOutputStream.close();
          paramString2.close();
          chmod("755", paramString1);
          bool = load(paramString1, paramStringBuffer);
          if (!bool) {
            continue;
          }
          return true;
          paramString1 = paramString1;
        }
        catch (IOException paramString1) {}
      }
    }
  }
  
  static String getArchSuffix()
  {
    String str2 = System.getProperty("os.arch");
    String str1;
    if (str2.equals("i686")) {
      str1 = "x86";
    }
    do
    {
      return str1;
      if (str2.equals("amd64")) {
        return "x86_64";
      }
      if (str2.equals("nacl")) {
        return "armv7l";
      }
      str1 = str2;
    } while (!str2.equals("aarch64"));
    return "armv7l";
  }
  
  static String getOS()
  {
    if (isWindows()) {
      return "win32";
    }
    if (isMac()) {
      return "macosx";
    }
    if ((isLinux()) && (!isAndroid())) {
      return "linux";
    }
    if (isAndroid()) {
      return "android";
    }
    throw new UnsatisfiedLinkError("Unsupported platform: " + getOsName());
  }
  
  static String getOSFileExtension()
  {
    if (isWindows()) {
      return "dll";
    }
    if (isMac()) {
      return "dylib";
    }
    if (isLinux()) {
      return "so";
    }
    if (isNativeClient()) {
      return "so";
    }
    throw new UnsatisfiedLinkError("Unsupported platform: " + getOsName());
  }
  
  static String getOsName()
  {
    return System.getProperty("os.name") + System.getProperty("java.specification.vendor");
  }
  
  static boolean isAndroid()
  {
    return getOsName().contains("Android");
  }
  
  static boolean isLinux()
  {
    return getOsName().startsWith("Linux");
  }
  
  static boolean isMac()
  {
    return getOsName().startsWith("Mac");
  }
  
  static boolean isNativeClient()
  {
    return getOsName().startsWith("nacl");
  }
  
  static boolean isWindows()
  {
    return getOsName().startsWith("Windows");
  }
  
  static boolean load(String paramString, StringBuffer paramStringBuffer)
  {
    try
    {
      if (paramString.indexOf(SEPARATOR) != -1) {
        System.load(paramString);
      } else {
        System.loadLibrary(paramString);
      }
    }
    catch (UnsatisfiedLinkError paramString)
    {
      if (paramStringBuffer.length() == 0) {
        paramStringBuffer.append(DELIMITER);
      }
      paramStringBuffer.append('\t');
      paramStringBuffer.append(paramString.getMessage());
      paramStringBuffer.append(DELIMITER);
      return false;
    }
    return true;
  }
  
  static void loadLibrary(String paramString)
  {
    if (isAndroid()) {
      System.loadLibrary("j2v8");
    }
    StringBuffer localStringBuffer;
    String str1;
    String str2;
    do
    {
      String str3;
      do
      {
        return;
        localStringBuffer = new StringBuffer();
        str1 = computeLibraryShortName();
        str2 = computeLibraryFullName();
        str3 = System.getProperty("user.dir") + SEPARATOR + "jni" + SEPARATOR + computeLibraryFullName();
      } while ((load(str2, localStringBuffer)) || (load(str1, localStringBuffer)) || ((new File(str3).exists()) && (load(str3, localStringBuffer))));
      str1 = paramString;
      if (paramString == null) {
        str1 = System.getProperty("java.io.tmpdir");
      }
    } while (extract(str1 + SEPARATOR + str2, str2, localStringBuffer));
    throw new UnsatisfiedLinkError("Could not load J2V8 library. Reasons: " + localStringBuffer.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.v8.LibraryLoader
 * JD-Core Version:    0.7.0.1
 */