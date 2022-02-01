package com.eclipsesource.mmv8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class PlatformDetector
{
  private static String normalize(String paramString)
  {
    AppMethodBeat.i(61645);
    if (paramString == null)
    {
      AppMethodBeat.o(61645);
      return "";
    }
    paramString = paramString.toLowerCase(Locale.US).replaceAll("[^a-z0-9]+", "");
    AppMethodBeat.o(61645);
    return paramString;
  }
  
  private static String normalizeArch(String paramString)
  {
    AppMethodBeat.i(61644);
    paramString = normalize(paramString);
    if (paramString.matches("^(x8664|amd64|ia32e|em64t|x64)$"))
    {
      AppMethodBeat.o(61644);
      return "x86_64";
    }
    if (paramString.matches("^(x8632|x86|i[3-6]86|ia32|x32)$"))
    {
      AppMethodBeat.o(61644);
      return "x86_32";
    }
    if (paramString.matches("^(ia64|itanium64)$"))
    {
      AppMethodBeat.o(61644);
      return "itanium_64";
    }
    if (paramString.matches("^(sparc|sparc32)$"))
    {
      AppMethodBeat.o(61644);
      return "sparc_32";
    }
    if (paramString.matches("^(sparcv9|sparc64)$"))
    {
      AppMethodBeat.o(61644);
      return "sparc_64";
    }
    if (paramString.matches("^(arm|arm32)$"))
    {
      AppMethodBeat.o(61644);
      return "arm_32";
    }
    if ("aarch64".equals(paramString))
    {
      AppMethodBeat.o(61644);
      return "aarch_64";
    }
    if (paramString.matches("^(ppc|ppc32)$"))
    {
      AppMethodBeat.o(61644);
      return "ppc_32";
    }
    if ("ppc64".equals(paramString))
    {
      AppMethodBeat.o(61644);
      return "ppc_64";
    }
    if ("ppc64le".equals(paramString))
    {
      AppMethodBeat.o(61644);
      return "ppcle_64";
    }
    if ("s390".equals(paramString))
    {
      AppMethodBeat.o(61644);
      return "s390_32";
    }
    if ("s390x".equals(paramString))
    {
      AppMethodBeat.o(61644);
      return "s390_64";
    }
    AppMethodBeat.o(61644);
    return "unknown";
  }
  
  private static String normalizeOs(String paramString)
  {
    AppMethodBeat.i(61643);
    paramString = normalize(paramString);
    if (paramString.startsWith("aix"))
    {
      AppMethodBeat.o(61643);
      return "aix";
    }
    if (paramString.startsWith("hpux"))
    {
      AppMethodBeat.o(61643);
      return "hpux";
    }
    if ((paramString.startsWith("os400")) && ((paramString.length() <= 5) || (!Character.isDigit(paramString.charAt(5)))))
    {
      AppMethodBeat.o(61643);
      return "os400";
    }
    if (paramString.startsWith("android"))
    {
      AppMethodBeat.o(61643);
      return "android";
    }
    if (paramString.startsWith("linux"))
    {
      AppMethodBeat.o(61643);
      return "linux";
    }
    if (paramString.startsWith("nacl"))
    {
      AppMethodBeat.o(61643);
      return "nacl";
    }
    if ((paramString.startsWith("macosx")) || (paramString.startsWith("osx")))
    {
      AppMethodBeat.o(61643);
      return "macosx";
    }
    if (paramString.startsWith("freebsd"))
    {
      AppMethodBeat.o(61643);
      return "freebsd";
    }
    if (paramString.startsWith("openbsd"))
    {
      AppMethodBeat.o(61643);
      return "openbsd";
    }
    if (paramString.startsWith("netbsd"))
    {
      AppMethodBeat.o(61643);
      return "netbsd";
    }
    if ((paramString.startsWith("solaris")) || (paramString.startsWith("sunos")))
    {
      AppMethodBeat.o(61643);
      return "sunos";
    }
    if (paramString.startsWith("windows"))
    {
      AppMethodBeat.o(61643);
      return "windows";
    }
    AppMethodBeat.o(61643);
    return "unknown";
  }
  
  private static String normalizeOsReleaseValue(String paramString)
  {
    AppMethodBeat.i(61642);
    paramString = paramString.trim().replace("\"", "");
    AppMethodBeat.o(61642);
    return paramString;
  }
  
  public static class Arch
  {
    public static String getName()
    {
      AppMethodBeat.i(61629);
      Object localObject = System.getProperty("os.arch");
      String str = PlatformDetector.access$000((String)localObject);
      if (str.equals("unknown"))
      {
        localObject = new UnsatisfiedLinkError("Unsupported arch: ".concat(String.valueOf(localObject)));
        AppMethodBeat.o(61629);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(61629);
      return str;
    }
  }
  
  public static class OS
  {
    public static String getLibFileExtension()
    {
      AppMethodBeat.i(61636);
      if (isWindows())
      {
        AppMethodBeat.o(61636);
        return "dll";
      }
      if (isMac())
      {
        AppMethodBeat.o(61636);
        return "dylib";
      }
      if ((isLinux()) || (isAndroid()) || (isNativeClient()))
      {
        AppMethodBeat.o(61636);
        return "so";
      }
      UnsatisfiedLinkError localUnsatisfiedLinkError = new UnsatisfiedLinkError("Unsupported platform library-extension for: " + getName());
      AppMethodBeat.o(61636);
      throw localUnsatisfiedLinkError;
    }
    
    public static String getName()
    {
      AppMethodBeat.i(61630);
      Object localObject = System.getProperty("os.name");
      String str1 = PlatformDetector.access$100((String)localObject);
      String str2 = System.getProperty("java.specification.vendor");
      if ((PlatformDetector.access$200(str2).contains("android")) || (str1.contains("android")))
      {
        AppMethodBeat.o(61630);
        return "android";
      }
      if (str1.equals("unknown"))
      {
        localObject = new UnsatisfiedLinkError("Unsupported platform/vendor: " + (String)localObject + " / " + str2);
        AppMethodBeat.o(61630);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(61630);
      return str1;
    }
    
    public static boolean isAndroid()
    {
      AppMethodBeat.i(61635);
      boolean bool = getName().equals("android");
      AppMethodBeat.o(61635);
      return bool;
    }
    
    public static boolean isLinux()
    {
      AppMethodBeat.i(61633);
      boolean bool = getName().equals("linux");
      AppMethodBeat.o(61633);
      return bool;
    }
    
    public static boolean isMac()
    {
      AppMethodBeat.i(61632);
      boolean bool = getName().equals("macosx");
      AppMethodBeat.o(61632);
      return bool;
    }
    
    public static boolean isNativeClient()
    {
      AppMethodBeat.i(61634);
      boolean bool = getName().equals("nacl");
      AppMethodBeat.o(61634);
      return bool;
    }
    
    public static boolean isWindows()
    {
      AppMethodBeat.i(61631);
      boolean bool = getName().equals("windows");
      AppMethodBeat.o(61631);
      return bool;
    }
  }
  
  public static class Vendor
  {
    private static final String LINUX_ID_PREFIX = "ID=";
    private static final String[] LINUX_OS_RELEASE_FILES = { "/etc/os-release", "/usr/lib/os-release" };
    private static final String REDHAT_RELEASE_FILE = "/etc/redhat-release";
    
    private static void closeQuietly(Closeable paramCloseable)
    {
      AppMethodBeat.i(61641);
      if (paramCloseable != null) {}
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(61641);
        return;
      }
      catch (IOException paramCloseable)
      {
        AppMethodBeat.o(61641);
      }
    }
    
    private static String getLinuxOsReleaseId()
    {
      AppMethodBeat.i(61638);
      Object localObject = LINUX_OS_RELEASE_FILES;
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        File localFile = new File(localObject[i]);
        if (localFile.exists())
        {
          localObject = parseLinuxOsReleaseFile(localFile);
          AppMethodBeat.o(61638);
          return localObject;
        }
        i += 1;
      }
      localObject = new File("/etc/redhat-release");
      if (((File)localObject).exists())
      {
        localObject = parseLinuxRedhatReleaseFile((File)localObject);
        AppMethodBeat.o(61638);
        return localObject;
      }
      localObject = new UnsatisfiedLinkError("Unsupported linux vendor: " + getName());
      AppMethodBeat.o(61638);
      throw ((Throwable)localObject);
    }
    
    public static String getName()
    {
      AppMethodBeat.i(61637);
      if (PlatformDetector.OS.isWindows())
      {
        AppMethodBeat.o(61637);
        return "microsoft";
      }
      if (PlatformDetector.OS.isMac())
      {
        AppMethodBeat.o(61637);
        return "apple";
      }
      if (PlatformDetector.OS.isLinux())
      {
        localObject = getLinuxOsReleaseId();
        AppMethodBeat.o(61637);
        return localObject;
      }
      if (PlatformDetector.OS.isAndroid())
      {
        AppMethodBeat.o(61637);
        return "google";
      }
      Object localObject = new UnsatisfiedLinkError("Unsupported vendor: " + getName());
      AppMethodBeat.o(61637);
      throw ((Throwable)localObject);
    }
    
    /* Error */
    private static String parseLinuxOsReleaseFile(File paramFile)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: ldc 112
      //   4: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: new 114	java/io/BufferedReader
      //   10: dup
      //   11: new 116	java/io/InputStreamReader
      //   14: dup
      //   15: new 118	java/io/FileInputStream
      //   18: dup
      //   19: aload_0
      //   20: invokespecial 121	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   23: ldc 123
      //   25: invokespecial 126	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
      //   28: invokespecial 129	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   31: astore_0
      //   32: aload_0
      //   33: invokevirtual 132	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   36: astore_3
      //   37: aload_2
      //   38: astore_1
      //   39: aload_3
      //   40: ifnull +21 -> 61
      //   43: aload_3
      //   44: ldc 11
      //   46: invokevirtual 136	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   49: ifeq -17 -> 32
      //   52: aload_3
      //   53: iconst_3
      //   54: invokevirtual 140	java/lang/String:substring	(I)Ljava/lang/String;
      //   57: invokestatic 144	com/eclipsesource/mmv8/PlatformDetector:access$300	(Ljava/lang/String;)Ljava/lang/String;
      //   60: astore_1
      //   61: aload_0
      //   62: invokestatic 146	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
      //   65: ldc 112
      //   67: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   70: aload_1
      //   71: areturn
      //   72: astore_0
      //   73: aconst_null
      //   74: astore_0
      //   75: aload_0
      //   76: invokestatic 146	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
      //   79: ldc 112
      //   81: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   84: aconst_null
      //   85: areturn
      //   86: astore_0
      //   87: aconst_null
      //   88: astore_1
      //   89: aload_1
      //   90: invokestatic 146	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
      //   93: ldc 112
      //   95: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   98: aload_0
      //   99: athrow
      //   100: astore_1
      //   101: aload_0
      //   102: astore_2
      //   103: aload_1
      //   104: astore_0
      //   105: aload_2
      //   106: astore_1
      //   107: goto -18 -> 89
      //   110: astore_1
      //   111: goto -36 -> 75
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	114	0	paramFile	File
      //   38	52	1	localObject1	Object
      //   100	4	1	localObject2	Object
      //   106	1	1	localFile1	File
      //   110	1	1	localIOException	IOException
      //   1	105	2	localFile2	File
      //   36	17	3	str	String
      // Exception table:
      //   from	to	target	type
      //   7	32	72	java/io/IOException
      //   7	32	86	finally
      //   32	37	100	finally
      //   43	61	100	finally
      //   32	37	110	java/io/IOException
      //   43	61	110	java/io/IOException
    }
    
    /* Error */
    private static String parseLinuxRedhatReleaseFile(File paramFile)
    {
      // Byte code:
      //   0: ldc 147
      //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: new 114	java/io/BufferedReader
      //   8: dup
      //   9: new 116	java/io/InputStreamReader
      //   12: dup
      //   13: new 118	java/io/FileInputStream
      //   16: dup
      //   17: aload_0
      //   18: invokespecial 121	java/io/FileInputStream:<init>	(Ljava/io/File;)V
      //   21: ldc 123
      //   23: invokespecial 126	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
      //   26: invokespecial 129	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   29: astore_1
      //   30: aload_1
      //   31: invokevirtual 132	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   34: astore_0
      //   35: aload_0
      //   36: ifnull +75 -> 111
      //   39: aload_0
      //   40: getstatic 153	java/util/Locale:US	Ljava/util/Locale;
      //   43: invokevirtual 157	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
      //   46: astore_0
      //   47: aload_0
      //   48: ldc 159
      //   50: invokevirtual 163	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   53: ifeq +17 -> 70
      //   56: ldc 159
      //   58: astore_0
      //   59: aload_1
      //   60: invokestatic 146	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
      //   63: ldc 147
      //   65: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   68: aload_0
      //   69: areturn
      //   70: aload_0
      //   71: ldc 165
      //   73: invokevirtual 163	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   76: ifeq +9 -> 85
      //   79: ldc 165
      //   81: astore_0
      //   82: goto -23 -> 59
      //   85: aload_0
      //   86: ldc 167
      //   88: invokevirtual 163	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   91: ifeq +9 -> 100
      //   94: ldc 169
      //   96: astore_0
      //   97: goto -38 -> 59
      //   100: aload_1
      //   101: invokestatic 146	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
      //   104: ldc 147
      //   106: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   109: aconst_null
      //   110: areturn
      //   111: aload_1
      //   112: invokestatic 146	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
      //   115: ldc 147
      //   117: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   120: aconst_null
      //   121: areturn
      //   122: astore_0
      //   123: aconst_null
      //   124: astore_1
      //   125: aload_1
      //   126: invokestatic 146	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
      //   129: goto -14 -> 115
      //   132: astore_0
      //   133: aconst_null
      //   134: astore_1
      //   135: aload_1
      //   136: invokestatic 146	com/eclipsesource/mmv8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
      //   139: ldc 147
      //   141: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   144: aload_0
      //   145: athrow
      //   146: astore_0
      //   147: goto -12 -> 135
      //   150: astore_0
      //   151: goto -26 -> 125
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	154	0	paramFile	File
      //   29	107	1	localBufferedReader	java.io.BufferedReader
      // Exception table:
      //   from	to	target	type
      //   5	30	122	java/io/IOException
      //   5	30	132	finally
      //   30	35	146	finally
      //   39	56	146	finally
      //   70	79	146	finally
      //   85	94	146	finally
      //   30	35	150	java/io/IOException
      //   39	56	150	java/io/IOException
      //   70	79	150	java/io/IOException
      //   85	94	150	java/io/IOException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.mmv8.PlatformDetector
 * JD-Core Version:    0.7.0.1
 */