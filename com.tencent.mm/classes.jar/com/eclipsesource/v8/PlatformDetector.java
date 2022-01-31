package com.eclipsesource.v8;

import java.util.Locale;

public class PlatformDetector
{
  private static String normalize(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
  }
  
  private static String normalizeArch(String paramString)
  {
    paramString = normalize(paramString);
    if (paramString.matches("^(x8664|amd64|ia32e|em64t|x64)$")) {
      return "x86_64";
    }
    if (paramString.matches("^(x8632|x86|i[3-6]86|ia32|x32)$")) {
      return "x86_32";
    }
    if (paramString.matches("^(ia64|itanium64)$")) {
      return "itanium_64";
    }
    if (paramString.matches("^(sparc|sparc32)$")) {
      return "sparc_32";
    }
    if (paramString.matches("^(sparcv9|sparc64)$")) {
      return "sparc_64";
    }
    if (paramString.matches("^(arm|arm32)$")) {
      return "arm_32";
    }
    if ("aarch64".equals(paramString)) {
      return "aarch_64";
    }
    if (paramString.matches("^(ppc|ppc32)$")) {
      return "ppc_32";
    }
    if ("ppc64".equals(paramString)) {
      return "ppc_64";
    }
    if ("ppc64le".equals(paramString)) {
      return "ppcle_64";
    }
    if ("s390".equals(paramString)) {
      return "s390_32";
    }
    if ("s390x".equals(paramString)) {
      return "s390_64";
    }
    return "unknown";
  }
  
  private static String normalizeOs(String paramString)
  {
    paramString = normalize(paramString);
    if (paramString.startsWith("aix")) {
      return "aix";
    }
    if (paramString.startsWith("hpux")) {
      return "hpux";
    }
    if ((paramString.startsWith("os400")) && ((paramString.length() <= 5) || (!Character.isDigit(paramString.charAt(5))))) {
      return "os400";
    }
    if (paramString.startsWith("android")) {
      return "android";
    }
    if (paramString.startsWith("linux")) {
      return "linux";
    }
    if (paramString.startsWith("nacl")) {
      return "nacl";
    }
    if ((paramString.startsWith("macosx")) || (paramString.startsWith("osx"))) {
      return "macosx";
    }
    if (paramString.startsWith("freebsd")) {
      return "freebsd";
    }
    if (paramString.startsWith("openbsd")) {
      return "openbsd";
    }
    if (paramString.startsWith("netbsd")) {
      return "netbsd";
    }
    if ((paramString.startsWith("solaris")) || (paramString.startsWith("sunos"))) {
      return "sunos";
    }
    if (paramString.startsWith("windows")) {
      return "windows";
    }
    return "unknown";
  }
  
  private static String normalizeOsReleaseValue(String paramString)
  {
    return paramString.trim().replace("\"", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.PlatformDetector
 * JD-Core Version:    0.7.0.1
 */