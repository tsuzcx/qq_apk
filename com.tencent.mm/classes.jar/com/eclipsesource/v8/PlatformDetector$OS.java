package com.eclipsesource.v8;

public class PlatformDetector$OS
{
  public static String getLibFileExtension()
  {
    if (isWindows()) {
      return "dll";
    }
    if (isMac()) {
      return "dylib";
    }
    if ((isLinux()) || (isAndroid()) || (isNativeClient())) {
      return "so";
    }
    throw new UnsatisfiedLinkError("Unsupported platform library-extension for: " + getName());
  }
  
  public static String getName()
  {
    String str3 = System.getProperty("os.name");
    String str2 = PlatformDetector.access$100(str3);
    String str4 = System.getProperty("java.specification.vendor");
    String str1;
    if ((PlatformDetector.access$200(str4).contains("android")) || (str2.contains("android"))) {
      str1 = "android";
    }
    do
    {
      return str1;
      str1 = str2;
    } while (!str2.equals("unknown"));
    throw new UnsatisfiedLinkError("Unsupported platform/vendor: " + str3 + " / " + str4);
  }
  
  public static boolean isAndroid()
  {
    return getName().equals("android");
  }
  
  public static boolean isLinux()
  {
    return getName().equals("linux");
  }
  
  public static boolean isMac()
  {
    return getName().equals("macosx");
  }
  
  public static boolean isNativeClient()
  {
    return getName().equals("nacl");
  }
  
  public static boolean isWindows()
  {
    return getName().equals("windows");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.eclipsesource.v8.PlatformDetector.OS
 * JD-Core Version:    0.7.0.1
 */