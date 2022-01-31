package com.eclipsesource.v8;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class PlatformDetector$Vendor
{
  private static final String LINUX_ID_PREFIX = "ID=";
  private static final String[] LINUX_OS_RELEASE_FILES = { "/etc/os-release", "/usr/lib/os-release" };
  private static final String REDHAT_RELEASE_FILE = "/etc/redhat-release";
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  private static String getLinuxOsReleaseId()
  {
    Object localObject = LINUX_OS_RELEASE_FILES;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      File localFile = new File(localObject[i]);
      if (localFile.exists()) {
        return parseLinuxOsReleaseFile(localFile);
      }
      i += 1;
    }
    localObject = new File("/etc/redhat-release");
    if (((File)localObject).exists()) {
      return parseLinuxRedhatReleaseFile((File)localObject);
    }
    throw new UnsatisfiedLinkError("Unsupported linux vendor: " + getName());
  }
  
  public static String getName()
  {
    if (PlatformDetector.OS.isWindows()) {
      return "microsoft";
    }
    if (PlatformDetector.OS.isMac()) {
      return "apple";
    }
    if (PlatformDetector.OS.isLinux()) {
      return getLinuxOsReleaseId();
    }
    if (PlatformDetector.OS.isAndroid()) {
      return "google";
    }
    throw new UnsatisfiedLinkError("Unsupported vendor: " + getName());
  }
  
  /* Error */
  private static String parseLinuxOsReleaseFile(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 101	java/io/BufferedReader
    //   5: dup
    //   6: new 103	java/io/InputStreamReader
    //   9: dup
    //   10: new 105	java/io/FileInputStream
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   18: ldc 110
    //   20: invokespecial 113	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   23: invokespecial 116	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   26: astore_0
    //   27: aload_0
    //   28: invokevirtual 119	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_2
    //   33: astore_1
    //   34: aload_3
    //   35: ifnull +21 -> 56
    //   38: aload_3
    //   39: ldc 11
    //   41: invokevirtual 123	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   44: ifeq -17 -> 27
    //   47: aload_3
    //   48: iconst_3
    //   49: invokevirtual 127	java/lang/String:substring	(I)Ljava/lang/String;
    //   52: invokestatic 131	com/eclipsesource/v8/PlatformDetector:access$300	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_1
    //   56: aload_0
    //   57: invokestatic 133	com/eclipsesource/v8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   60: aload_1
    //   61: areturn
    //   62: astore_0
    //   63: aconst_null
    //   64: astore_0
    //   65: aload_0
    //   66: invokestatic 133	com/eclipsesource/v8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_0
    //   72: aconst_null
    //   73: astore_1
    //   74: aload_1
    //   75: invokestatic 133	com/eclipsesource/v8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   78: aload_0
    //   79: athrow
    //   80: astore_1
    //   81: aload_0
    //   82: astore_2
    //   83: aload_1
    //   84: astore_0
    //   85: aload_2
    //   86: astore_1
    //   87: goto -13 -> 74
    //   90: astore_1
    //   91: goto -26 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramFile	File
    //   33	42	1	localObject1	Object
    //   80	4	1	localObject2	Object
    //   86	1	1	localFile1	File
    //   90	1	1	localIOException	IOException
    //   1	85	2	localFile2	File
    //   31	17	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	27	62	java/io/IOException
    //   2	27	71	finally
    //   27	32	80	finally
    //   38	56	80	finally
    //   27	32	90	java/io/IOException
    //   38	56	90	java/io/IOException
  }
  
  /* Error */
  private static String parseLinuxRedhatReleaseFile(File paramFile)
  {
    // Byte code:
    //   0: new 101	java/io/BufferedReader
    //   3: dup
    //   4: new 103	java/io/InputStreamReader
    //   7: dup
    //   8: new 105	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 108	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: ldc 110
    //   18: invokespecial 113	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   21: invokespecial 116	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 119	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: astore_0
    //   30: aload_0
    //   31: ifnull +65 -> 96
    //   34: aload_0
    //   35: getstatic 139	java/util/Locale:US	Ljava/util/Locale;
    //   38: invokevirtual 143	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   41: astore_0
    //   42: aload_0
    //   43: ldc 145
    //   45: invokevirtual 149	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   48: ifeq +12 -> 60
    //   51: ldc 145
    //   53: astore_0
    //   54: aload_1
    //   55: invokestatic 133	com/eclipsesource/v8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   58: aload_0
    //   59: areturn
    //   60: aload_0
    //   61: ldc 151
    //   63: invokevirtual 149	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   66: ifeq +9 -> 75
    //   69: ldc 151
    //   71: astore_0
    //   72: goto -18 -> 54
    //   75: aload_0
    //   76: ldc 153
    //   78: invokevirtual 149	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +9 -> 90
    //   84: ldc 155
    //   86: astore_0
    //   87: goto -33 -> 54
    //   90: aload_1
    //   91: invokestatic 133	com/eclipsesource/v8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   94: aconst_null
    //   95: areturn
    //   96: aload_1
    //   97: invokestatic 133	com/eclipsesource/v8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: aconst_null
    //   104: astore_1
    //   105: aload_1
    //   106: invokestatic 133	com/eclipsesource/v8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: invokestatic 133	com/eclipsesource/v8/PlatformDetector$Vendor:closeQuietly	(Ljava/io/Closeable;)V
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: goto -7 -> 114
    //   124: astore_0
    //   125: goto -20 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramFile	File
    //   24	91	1	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   0	25	102	java/io/IOException
    //   0	25	111	finally
    //   25	30	120	finally
    //   34	51	120	finally
    //   60	69	120	finally
    //   75	84	120	finally
    //   25	30	124	java/io/IOException
    //   34	51	124	java/io/IOException
    //   60	69	124	java/io/IOException
    //   75	84	124	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.v8.PlatformDetector.Vendor
 * JD-Core Version:    0.7.0.1
 */