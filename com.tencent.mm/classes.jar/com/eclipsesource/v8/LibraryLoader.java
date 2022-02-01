package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

class LibraryLoader
{
  static final String DELIMITER;
  static final String SEPARATOR;
  static final String SWT_LIB_DIR = ".j2v8";
  
  static
  {
    AppMethodBeat.i(61585);
    DELIMITER = System.getProperty("line.separator");
    SEPARATOR = System.getProperty("file.separator");
    AppMethodBeat.o(61585);
  }
  
  static void chmod(String paramString1, String paramString2)
  {
    AppMethodBeat.i(61575);
    if (isWindows())
    {
      AppMethodBeat.o(61575);
      return;
    }
    try
    {
      Runtime.getRuntime().exec(new String[] { "chmod", paramString1, paramString2 }).waitFor();
      AppMethodBeat.o(61575);
      return;
    }
    catch (Throwable paramString1)
    {
      AppMethodBeat.o(61575);
    }
  }
  
  private static String computeLibraryFullName()
  {
    AppMethodBeat.i(61571);
    String str = "lib" + computeLibraryShortName() + "." + getOSFileExtension();
    AppMethodBeat.o(61571);
    return str;
  }
  
  private static String computeLibraryShortName()
  {
    AppMethodBeat.i(61570);
    String str1 = getOS();
    String str2 = getArchSuffix();
    str1 = "j2v8" + "_" + str1 + "_" + str2;
    AppMethodBeat.o(61570);
    return str1;
  }
  
  static boolean extract(String paramString1, String paramString2, StringBuffer paramStringBuffer)
  {
    i = 1;
    AppMethodBeat.i(61574);
    File localFile = new File(paramString1);
    for (;;)
    {
      try
      {
        if (localFile.exists()) {
          localFile.delete();
        }
        paramString2 = LibraryLoader.class.getResourceAsStream("/".concat(String.valueOf(paramString2)));
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
          AppMethodBeat.o(61574);
          return false;
          localFileOutputStream.close();
          paramString2.close();
          chmod("755", paramString1);
          bool = load(paramString1, paramStringBuffer);
          if (!bool) {
            continue;
          }
          AppMethodBeat.o(61574);
          return true;
          paramString1 = paramString1;
        }
        catch (IOException paramString1) {}
      }
    }
  }
  
  static String getArchSuffix()
  {
    AppMethodBeat.i(61582);
    String str = System.getProperty("os.arch");
    if (str.equals("i686"))
    {
      AppMethodBeat.o(61582);
      return "x86";
    }
    if (str.equals("amd64"))
    {
      AppMethodBeat.o(61582);
      return "x86_64";
    }
    if (str.equals("nacl"))
    {
      AppMethodBeat.o(61582);
      return "armv7l";
    }
    if (str.equals("aarch64"))
    {
      AppMethodBeat.o(61582);
      return "armv7l";
    }
    AppMethodBeat.o(61582);
    return str;
  }
  
  static String getOS()
  {
    AppMethodBeat.i(61584);
    if (isWindows())
    {
      AppMethodBeat.o(61584);
      return "win32";
    }
    if (isMac())
    {
      AppMethodBeat.o(61584);
      return "macosx";
    }
    if ((isLinux()) && (!isAndroid()))
    {
      AppMethodBeat.o(61584);
      return "linux";
    }
    if (isAndroid())
    {
      AppMethodBeat.o(61584);
      return "android";
    }
    UnsatisfiedLinkError localUnsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported platform: " + getOsName());
    AppMethodBeat.o(61584);
    throw localUnsatisfiedLinkError;
  }
  
  static String getOSFileExtension()
  {
    AppMethodBeat.i(61583);
    if (isWindows())
    {
      AppMethodBeat.o(61583);
      return "dll";
    }
    if (isMac())
    {
      AppMethodBeat.o(61583);
      return "dylib";
    }
    if (isLinux())
    {
      AppMethodBeat.o(61583);
      return "so";
    }
    if (isNativeClient())
    {
      AppMethodBeat.o(61583);
      return "so";
    }
    UnsatisfiedLinkError localUnsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported platform: " + getOsName());
    AppMethodBeat.o(61583);
    throw localUnsatisfiedLinkError;
  }
  
  static String getOsName()
  {
    AppMethodBeat.i(61576);
    String str = System.getProperty("os.name") + System.getProperty("java.specification.vendor");
    AppMethodBeat.o(61576);
    return str;
  }
  
  static boolean isAndroid()
  {
    AppMethodBeat.i(61581);
    boolean bool = getOsName().contains("Android");
    AppMethodBeat.o(61581);
    return bool;
  }
  
  static boolean isLinux()
  {
    AppMethodBeat.i(61579);
    boolean bool = getOsName().startsWith("Linux");
    AppMethodBeat.o(61579);
    return bool;
  }
  
  static boolean isMac()
  {
    AppMethodBeat.i(61578);
    boolean bool = getOsName().startsWith("Mac");
    AppMethodBeat.o(61578);
    return bool;
  }
  
  static boolean isNativeClient()
  {
    AppMethodBeat.i(61580);
    boolean bool = getOsName().startsWith("nacl");
    AppMethodBeat.o(61580);
    return bool;
  }
  
  static boolean isWindows()
  {
    AppMethodBeat.i(61577);
    boolean bool = getOsName().startsWith("Windows");
    AppMethodBeat.o(61577);
    return bool;
  }
  
  static boolean load(String paramString, StringBuffer paramStringBuffer)
  {
    AppMethodBeat.i(61573);
    try
    {
      if (paramString.indexOf(SEPARATOR) != -1) {
        System.load(paramString);
      }
      for (;;)
      {
        AppMethodBeat.o(61573);
        return true;
        System.loadLibrary(paramString);
      }
      return false;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      if (paramStringBuffer.length() == 0) {
        paramStringBuffer.append(DELIMITER);
      }
      paramStringBuffer.append('\t');
      paramStringBuffer.append(paramString.getMessage());
      paramStringBuffer.append(DELIMITER);
      AppMethodBeat.o(61573);
    }
  }
  
  static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(61572);
    if (isAndroid())
    {
      System.loadLibrary("mmj2v8");
      AppMethodBeat.o(61572);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    String str1 = computeLibraryShortName();
    String str2 = computeLibraryFullName();
    String str3 = System.getProperty("user.dir") + SEPARATOR + "jni" + SEPARATOR + computeLibraryFullName();
    if (load(str2, localStringBuffer))
    {
      AppMethodBeat.o(61572);
      return;
    }
    if (load(str1, localStringBuffer))
    {
      AppMethodBeat.o(61572);
      return;
    }
    if ((new File(str3).exists()) && (load(str3, localStringBuffer)))
    {
      AppMethodBeat.o(61572);
      return;
    }
    str1 = paramString;
    if (paramString == null) {
      str1 = System.getProperty("java.io.tmpdir");
    }
    if (extract(str1 + SEPARATOR + str2, str2, localStringBuffer))
    {
      AppMethodBeat.o(61572);
      return;
    }
    paramString = new UnsatisfiedLinkError("Could not load J2V8 library. Reasons: " + localStringBuffer.toString());
    AppMethodBeat.o(61572);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.LibraryLoader
 * JD-Core Version:    0.7.0.1
 */