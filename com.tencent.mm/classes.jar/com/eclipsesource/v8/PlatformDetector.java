package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public class PlatformDetector
{
  private static String normalize(String paramString)
  {
    AppMethodBeat.i(75021);
    if (paramString == null)
    {
      AppMethodBeat.o(75021);
      return "";
    }
    paramString = paramString.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    AppMethodBeat.o(75021);
    return paramString;
  }
  
  private static String normalizeArch(String paramString)
  {
    AppMethodBeat.i(75020);
    paramString = normalize(paramString);
    if (paramString.matches("^(x8664|amd64|ia32e|em64t|x64)$"))
    {
      AppMethodBeat.o(75020);
      return "x86_64";
    }
    if (paramString.matches("^(x8632|x86|i[3-6]86|ia32|x32)$"))
    {
      AppMethodBeat.o(75020);
      return "x86_32";
    }
    if (paramString.matches("^(ia64|itanium64)$"))
    {
      AppMethodBeat.o(75020);
      return "itanium_64";
    }
    if (paramString.matches("^(sparc|sparc32)$"))
    {
      AppMethodBeat.o(75020);
      return "sparc_32";
    }
    if (paramString.matches("^(sparcv9|sparc64)$"))
    {
      AppMethodBeat.o(75020);
      return "sparc_64";
    }
    if (paramString.matches("^(arm|arm32)$"))
    {
      AppMethodBeat.o(75020);
      return "arm_32";
    }
    if ("aarch64".equals(paramString))
    {
      AppMethodBeat.o(75020);
      return "aarch_64";
    }
    if (paramString.matches("^(ppc|ppc32)$"))
    {
      AppMethodBeat.o(75020);
      return "ppc_32";
    }
    if ("ppc64".equals(paramString))
    {
      AppMethodBeat.o(75020);
      return "ppc_64";
    }
    if ("ppc64le".equals(paramString))
    {
      AppMethodBeat.o(75020);
      return "ppcle_64";
    }
    if ("s390".equals(paramString))
    {
      AppMethodBeat.o(75020);
      return "s390_32";
    }
    if ("s390x".equals(paramString))
    {
      AppMethodBeat.o(75020);
      return "s390_64";
    }
    AppMethodBeat.o(75020);
    return "unknown";
  }
  
  private static String normalizeOs(String paramString)
  {
    AppMethodBeat.i(75019);
    paramString = normalize(paramString);
    if (paramString.startsWith("aix"))
    {
      AppMethodBeat.o(75019);
      return "aix";
    }
    if (paramString.startsWith("hpux"))
    {
      AppMethodBeat.o(75019);
      return "hpux";
    }
    if ((paramString.startsWith("os400")) && ((paramString.length() <= 5) || (!Character.isDigit(paramString.charAt(5)))))
    {
      AppMethodBeat.o(75019);
      return "os400";
    }
    if (paramString.startsWith("android"))
    {
      AppMethodBeat.o(75019);
      return "android";
    }
    if (paramString.startsWith("linux"))
    {
      AppMethodBeat.o(75019);
      return "linux";
    }
    if (paramString.startsWith("nacl"))
    {
      AppMethodBeat.o(75019);
      return "nacl";
    }
    if ((paramString.startsWith("macosx")) || (paramString.startsWith("osx")))
    {
      AppMethodBeat.o(75019);
      return "macosx";
    }
    if (paramString.startsWith("freebsd"))
    {
      AppMethodBeat.o(75019);
      return "freebsd";
    }
    if (paramString.startsWith("openbsd"))
    {
      AppMethodBeat.o(75019);
      return "openbsd";
    }
    if (paramString.startsWith("netbsd"))
    {
      AppMethodBeat.o(75019);
      return "netbsd";
    }
    if ((paramString.startsWith("solaris")) || (paramString.startsWith("sunos")))
    {
      AppMethodBeat.o(75019);
      return "sunos";
    }
    if (paramString.startsWith("windows"))
    {
      AppMethodBeat.o(75019);
      return "windows";
    }
    AppMethodBeat.o(75019);
    return "unknown";
  }
  
  private static String normalizeOsReleaseValue(String paramString)
  {
    AppMethodBeat.i(75018);
    paramString = paramString.trim().replace("\"", "");
    AppMethodBeat.o(75018);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.v8.PlatformDetector
 * JD-Core Version:    0.7.0.1
 */