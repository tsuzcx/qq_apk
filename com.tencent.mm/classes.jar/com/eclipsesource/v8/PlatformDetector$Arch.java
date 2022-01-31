package com.eclipsesource.v8;

public class PlatformDetector$Arch
{
  public static String getName()
  {
    String str1 = System.getProperty("os.arch");
    String str2 = PlatformDetector.access$000(str1);
    if (str2.equals("unknown")) {
      throw new UnsatisfiedLinkError("Unsupported arch: " + str1);
    }
    return str2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.eclipsesource.v8.PlatformDetector.Arch
 * JD-Core Version:    0.7.0.1
 */