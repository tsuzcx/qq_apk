package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class PlatformDetector$Arch
{
  public static String getName()
  {
    AppMethodBeat.i(75005);
    Object localObject = System.getProperty("os.arch");
    String str = PlatformDetector.access$000((String)localObject);
    if (str.equals("unknown"))
    {
      localObject = new UnsatisfiedLinkError("Unsupported arch: ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(75005);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(75005);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.v8.PlatformDetector.Arch
 * JD-Core Version:    0.7.0.1
 */