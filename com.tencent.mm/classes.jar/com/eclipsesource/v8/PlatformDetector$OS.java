package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class PlatformDetector$OS
{
  public static String getLibFileExtension()
  {
    AppMethodBeat.i(75012);
    if (isWindows())
    {
      AppMethodBeat.o(75012);
      return "dll";
    }
    if (isMac())
    {
      AppMethodBeat.o(75012);
      return "dylib";
    }
    if ((isLinux()) || (isAndroid()) || (isNativeClient()))
    {
      AppMethodBeat.o(75012);
      return "so";
    }
    UnsatisfiedLinkError localUnsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported platform library-extension for: " + getName());
    AppMethodBeat.o(75012);
    throw localUnsatisfiedLinkError;
  }
  
  public static String getName()
  {
    AppMethodBeat.i(75006);
    Object localObject = System.getProperty("os.name");
    String str1 = PlatformDetector.access$100((String)localObject);
    String str2 = System.getProperty("java.specification.vendor");
    if ((PlatformDetector.access$200(str2).contains("android")) || (str1.contains("android")))
    {
      AppMethodBeat.o(75006);
      return "android";
    }
    if (str1.equals("unknown"))
    {
      localObject = new UnsatisfiedLinkError("Unsupported platform/vendor: " + (String)localObject + " / " + str2);
      AppMethodBeat.o(75006);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(75006);
    return str1;
  }
  
  public static boolean isAndroid()
  {
    AppMethodBeat.i(75011);
    boolean bool = getName().equals("android");
    AppMethodBeat.o(75011);
    return bool;
  }
  
  public static boolean isLinux()
  {
    AppMethodBeat.i(75009);
    boolean bool = getName().equals("linux");
    AppMethodBeat.o(75009);
    return bool;
  }
  
  public static boolean isMac()
  {
    AppMethodBeat.i(75008);
    boolean bool = getName().equals("macosx");
    AppMethodBeat.o(75008);
    return bool;
  }
  
  public static boolean isNativeClient()
  {
    AppMethodBeat.i(75010);
    boolean bool = getName().equals("nacl");
    AppMethodBeat.o(75010);
    return bool;
  }
  
  public static boolean isWindows()
  {
    AppMethodBeat.i(75007);
    boolean bool = getName().equals("windows");
    AppMethodBeat.o(75007);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.v8.PlatformDetector.OS
 * JD-Core Version:    0.7.0.1
 */