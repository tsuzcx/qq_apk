package com.eclipsesource.mmv8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

class LibraryLoader
{
  static final String DELIMITER;
  static final String SEPARATOR;
  static final String SWT_LIB_DIR = ".j2v8";
  private byte _hellAccFlag_;
  
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
      return;
    }
    finally
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
  
  /* Error */
  static boolean extract(String paramString1, String paramString2, StringBuffer paramStringBuffer)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 110
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 112	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore 7
    //   17: aload 7
    //   19: invokevirtual 116	java/io/File:exists	()Z
    //   22: ifeq +9 -> 31
    //   25: aload 7
    //   27: invokevirtual 119	java/io/File:delete	()Z
    //   30: pop
    //   31: ldc 2
    //   33: ldc 121
    //   35: aload_1
    //   36: invokestatic 125	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   39: invokevirtual 128	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokevirtual 134	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +85 -> 132
    //   50: sipush 4096
    //   53: newarray byte
    //   55: astore 8
    //   57: new 136	java/io/FileOutputStream
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 137	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   65: astore 6
    //   67: aload_1
    //   68: aload 8
    //   70: invokevirtual 143	java/io/InputStream:read	([B)I
    //   73: istore 4
    //   75: iload 4
    //   77: iconst_m1
    //   78: if_icmpeq +61 -> 139
    //   81: aload 6
    //   83: aload 8
    //   85: iconst_0
    //   86: iload 4
    //   88: invokevirtual 147	java/io/FileOutputStream:write	([BII)V
    //   91: goto -24 -> 67
    //   94: astore_0
    //   95: aload 6
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 151	java/io/InputStream:close	()V
    //   114: iload_3
    //   115: ifeq +17 -> 132
    //   118: aload 7
    //   120: invokevirtual 116	java/io/File:exists	()Z
    //   123: ifeq +9 -> 132
    //   126: aload 7
    //   128: invokevirtual 119	java/io/File:delete	()Z
    //   131: pop
    //   132: ldc 110
    //   134: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iconst_0
    //   138: ireturn
    //   139: aload 6
    //   141: invokevirtual 150	java/io/FileOutputStream:close	()V
    //   144: aload_1
    //   145: invokevirtual 151	java/io/InputStream:close	()V
    //   148: ldc 153
    //   150: aload_0
    //   151: invokestatic 155	com/eclipsesource/mmv8/LibraryLoader:chmod	(Ljava/lang/String;Ljava/lang/String;)V
    //   154: aload_0
    //   155: aload_2
    //   156: invokestatic 159	com/eclipsesource/mmv8/LibraryLoader:load	(Ljava/lang/String;Ljava/lang/StringBuffer;)Z
    //   159: istore 5
    //   161: iload 5
    //   163: ifeq -31 -> 132
    //   166: ldc 110
    //   168: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: iconst_1
    //   172: ireturn
    //   173: astore_0
    //   174: goto -68 -> 106
    //   177: astore_0
    //   178: goto -64 -> 114
    //   181: astore_0
    //   182: iconst_0
    //   183: istore_3
    //   184: aconst_null
    //   185: astore_1
    //   186: aconst_null
    //   187: astore_0
    //   188: goto -90 -> 98
    //   191: astore_0
    //   192: aconst_null
    //   193: astore_0
    //   194: goto -96 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramString1	String
    //   0	197	1	paramString2	String
    //   0	197	2	paramStringBuffer	StringBuffer
    //   1	183	3	i	int
    //   73	14	4	j	int
    //   159	3	5	bool	boolean
    //   65	75	6	localFileOutputStream	java.io.FileOutputStream
    //   15	112	7	localFile	File
    //   55	29	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   67	75	94	finally
    //   81	91	94	finally
    //   139	161	94	finally
    //   102	106	173	java/io/IOException
    //   110	114	177	java/io/IOException
    //   17	31	181	finally
    //   31	46	181	finally
    //   50	67	191	finally
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
        paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramString.aYi(), "com/eclipsesource/mmv8/LibraryLoader", "load", "(Ljava/lang/String;Ljava/lang/StringBuffer;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
        System.loadLibrary((String)paramString.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/eclipsesource/mmv8/LibraryLoader", "load", "(Ljava/lang/String;Ljava/lang/StringBuffer;)Z", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
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
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG("mmj2v8");
      localObject = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramString.aYi(), "com/eclipsesource/mmv8/LibraryLoader", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      System.loadLibrary((String)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/eclipsesource/mmv8/LibraryLoader", "loadLibrary", "(Ljava/lang/String;)V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
      AppMethodBeat.o(61572);
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = computeLibraryShortName();
    String str1 = computeLibraryFullName();
    String str2 = System.getProperty("user.dir") + SEPARATOR + "jni" + SEPARATOR + computeLibraryFullName();
    if (load(str1, localStringBuffer))
    {
      AppMethodBeat.o(61572);
      return;
    }
    if (load((String)localObject, localStringBuffer))
    {
      AppMethodBeat.o(61572);
      return;
    }
    if ((new File(str2).exists()) && (load(str2, localStringBuffer)))
    {
      AppMethodBeat.o(61572);
      return;
    }
    localObject = paramString;
    if (paramString == null) {
      localObject = System.getProperty("java.io.tmpdir");
    }
    if (extract((String)localObject + SEPARATOR + str1, str1, localStringBuffer))
    {
      AppMethodBeat.o(61572);
      return;
    }
    paramString = new UnsatisfiedLinkError("Could not load J2V8 library. Reasons: " + localStringBuffer.toString());
    AppMethodBeat.o(61572);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.mmv8.LibraryLoader
 * JD-Core Version:    0.7.0.1
 */