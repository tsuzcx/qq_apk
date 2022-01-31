package com.qq.wx.voice.embed.recognizer;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;

final class f
{
  private boolean a = false;
  String b = null;
  
  private static boolean a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123208);
    boolean bool = new File(paramString2 + "/" + paramString1).exists();
    AppMethodBeat.o(123208);
    return bool;
  }
  
  private static boolean a(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(123206);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfString.length)
      {
        AppMethodBeat.o(123206);
        return false;
      }
      if (paramString.compareTo(paramArrayOfString[i]) == 0)
      {
        AppMethodBeat.o(123206);
        return true;
      }
      i += 1;
    }
  }
  
  /* Error */
  private static String b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 68
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 27	java/io/File
    //   8: dup
    //   9: new 29	java/lang/StringBuilder
    //   12: dup
    //   13: aload_1
    //   14: invokestatic 35	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   17: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: ldc 40
    //   22: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 49	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_0
    //   36: new 70	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 73	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: astore_1
    //   45: aload_1
    //   46: invokevirtual 77	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   49: getstatic 83	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   52: lconst_0
    //   53: aload_0
    //   54: invokevirtual 87	java/io/File:length	()J
    //   57: invokevirtual 93	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   60: astore_0
    //   61: ldc 95
    //   63: invokestatic 101	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   66: astore_2
    //   67: aload_2
    //   68: aload_0
    //   69: invokevirtual 105	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   72: new 107	java/math/BigInteger
    //   75: dup
    //   76: iconst_1
    //   77: aload_2
    //   78: invokevirtual 111	java/security/MessageDigest:digest	()[B
    //   81: invokespecial 114	java/math/BigInteger:<init>	(I[B)V
    //   84: bipush 16
    //   86: invokevirtual 117	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   89: astore_0
    //   90: aload_1
    //   91: invokevirtual 120	java/io/FileInputStream:close	()V
    //   94: ldc 68
    //   96: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: aload_0
    //   100: areturn
    //   101: astore_0
    //   102: aload_1
    //   103: invokevirtual 120	java/io/FileInputStream:close	()V
    //   106: aconst_null
    //   107: astore_0
    //   108: goto -14 -> 94
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_0
    //   114: goto -20 -> 94
    //   117: astore_0
    //   118: aload_1
    //   119: invokevirtual 120	java/io/FileInputStream:close	()V
    //   122: ldc 68
    //   124: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload_0
    //   128: athrow
    //   129: astore_1
    //   130: goto -8 -> 122
    //   133: astore_1
    //   134: goto -40 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramString1	String
    //   0	137	1	paramString2	String
    //   66	12	2	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   45	90	101	java/lang/Exception
    //   102	106	111	java/io/IOException
    //   45	90	117	finally
    //   118	122	129	java/io/IOException
    //   90	94	133	java/io/IOException
  }
  
  /* Error */
  private static void f(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 123
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 27	java/io/File
    //   8: dup
    //   9: new 29	java/lang/StringBuilder
    //   12: dup
    //   13: aload_1
    //   14: invokestatic 35	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   17: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: ldc 40
    //   22: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 49	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: new 27	java/io/File
    //   39: dup
    //   40: new 29	java/lang/StringBuilder
    //   43: dup
    //   44: aload_2
    //   45: invokestatic 35	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   48: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   51: ldc 40
    //   53: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_0
    //   57: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokespecial 49	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore_2
    //   67: new 70	java/io/FileInputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 73	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: astore_0
    //   76: new 125	java/io/FileOutputStream
    //   79: dup
    //   80: aload_2
    //   81: invokespecial 126	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   84: astore 4
    //   86: aload_0
    //   87: invokevirtual 77	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   90: astore_1
    //   91: aload 4
    //   93: invokevirtual 127	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   96: astore 5
    //   98: aload_1
    //   99: lconst_0
    //   100: aload_1
    //   101: invokevirtual 130	java/nio/channels/FileChannel:size	()J
    //   104: aload 5
    //   106: invokevirtual 134	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   109: pop2
    //   110: aload_0
    //   111: invokevirtual 120	java/io/FileInputStream:close	()V
    //   114: aload_1
    //   115: invokevirtual 135	java/nio/channels/FileChannel:close	()V
    //   118: aload 4
    //   120: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   123: aload 5
    //   125: invokevirtual 135	java/nio/channels/FileChannel:close	()V
    //   128: ldc 123
    //   130: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: return
    //   134: astore_0
    //   135: aconst_null
    //   136: astore_2
    //   137: aconst_null
    //   138: astore_3
    //   139: aconst_null
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual 120	java/io/FileInputStream:close	()V
    //   147: aload_3
    //   148: invokevirtual 135	java/nio/channels/FileChannel:close	()V
    //   151: aload_0
    //   152: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   155: aload_2
    //   156: invokevirtual 135	java/nio/channels/FileChannel:close	()V
    //   159: ldc 123
    //   161: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: return
    //   165: astore_0
    //   166: ldc 123
    //   168: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: return
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_3
    //   175: aconst_null
    //   176: astore_2
    //   177: aconst_null
    //   178: astore 4
    //   180: aconst_null
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 120	java/io/FileInputStream:close	()V
    //   186: aload_2
    //   187: invokevirtual 135	java/nio/channels/FileChannel:close	()V
    //   190: aload 4
    //   192: invokevirtual 136	java/io/FileOutputStream:close	()V
    //   195: aload_3
    //   196: invokevirtual 135	java/nio/channels/FileChannel:close	()V
    //   199: ldc 123
    //   201: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: aload_1
    //   205: athrow
    //   206: astore_0
    //   207: ldc 123
    //   209: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: return
    //   213: astore_0
    //   214: goto -15 -> 199
    //   217: astore_1
    //   218: aconst_null
    //   219: astore_3
    //   220: aconst_null
    //   221: astore_2
    //   222: aconst_null
    //   223: astore 4
    //   225: goto -43 -> 182
    //   228: astore_1
    //   229: aconst_null
    //   230: astore_3
    //   231: aconst_null
    //   232: astore_2
    //   233: goto -51 -> 182
    //   236: astore 5
    //   238: aconst_null
    //   239: astore_3
    //   240: aload_1
    //   241: astore_2
    //   242: aload 5
    //   244: astore_1
    //   245: goto -63 -> 182
    //   248: astore_2
    //   249: aload_1
    //   250: astore_3
    //   251: aload_2
    //   252: astore_1
    //   253: aload_3
    //   254: astore_2
    //   255: aload 5
    //   257: astore_3
    //   258: goto -76 -> 182
    //   261: astore_1
    //   262: aconst_null
    //   263: astore_2
    //   264: aconst_null
    //   265: astore_3
    //   266: aconst_null
    //   267: astore 4
    //   269: aload_0
    //   270: astore_1
    //   271: aload 4
    //   273: astore_0
    //   274: goto -131 -> 143
    //   277: astore_1
    //   278: aconst_null
    //   279: astore_2
    //   280: aconst_null
    //   281: astore_3
    //   282: aload_0
    //   283: astore_1
    //   284: aload 4
    //   286: astore_0
    //   287: goto -144 -> 143
    //   290: astore_2
    //   291: aconst_null
    //   292: astore 5
    //   294: aload_0
    //   295: astore_2
    //   296: aload_1
    //   297: astore_3
    //   298: aload 4
    //   300: astore_0
    //   301: aload_2
    //   302: astore_1
    //   303: aload 5
    //   305: astore_2
    //   306: goto -163 -> 143
    //   309: astore_2
    //   310: aload_0
    //   311: astore_2
    //   312: aload_1
    //   313: astore_3
    //   314: aload 4
    //   316: astore_0
    //   317: aload_2
    //   318: astore_1
    //   319: aload 5
    //   321: astore_2
    //   322: goto -179 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	paramString1	String
    //   0	325	1	paramString2	String
    //   0	325	2	paramString3	String
    //   138	176	3	localObject1	Object
    //   84	231	4	localFileOutputStream	java.io.FileOutputStream
    //   96	28	5	localFileChannel	java.nio.channels.FileChannel
    //   236	20	5	localObject2	Object
    //   292	28	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   67	76	134	java/io/IOException
    //   143	159	165	java/io/IOException
    //   67	76	172	finally
    //   110	128	206	java/io/IOException
    //   182	199	213	java/io/IOException
    //   76	86	217	finally
    //   86	91	228	finally
    //   91	98	236	finally
    //   98	110	248	finally
    //   76	86	261	java/io/IOException
    //   86	91	277	java/io/IOException
    //   91	98	290	java/io/IOException
    //   98	110	309	java/io/IOException
  }
  
  public final int c(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(123204);
    if (this.a)
    {
      AppMethodBeat.o(123204);
      return 0;
    }
    if (!a("libwxvoiceembed.so", paramString1))
    {
      AppMethodBeat.o(123204);
      return -201;
    }
    if (!a("libwxvoiceembed.bin", paramString1))
    {
      AppMethodBeat.o(123204);
      return -202;
    }
    paramContext = paramContext.getFilesDir().getAbsolutePath() + "/NamesSearch/";
    Object localObject = new File(paramContext);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    if (!a("libwxvoiceembed.so", paramContext)) {
      f("libwxvoiceembed.so", paramString1, paramContext);
    }
    if (!a("libwxvoiceembed.bin", paramContext)) {
      f("libwxvoiceembed.bin", paramString1, paramContext);
    }
    try
    {
      localObject = b("libwxvoiceembed.so", paramContext);
      String str = b("libwxvoiceembed.so", paramString1);
      if (((String)localObject).compareTo(str) != 0) {
        f("libwxvoiceembed.so", paramString1, paramContext);
      }
      if (!a((String)localObject, paramString2.split(";")))
      {
        AppMethodBeat.o(123204);
        return -203;
      }
    }
    catch (FileNotFoundException paramContext)
    {
      AppMethodBeat.o(123204);
      return -203;
    }
    try
    {
      paramString2 = b("libwxvoiceembed.bin", paramContext);
      localObject = b("libwxvoiceembed.bin", paramString1);
      if (paramString2.compareTo((String)localObject) != 0) {
        f("libwxvoiceembed.bin", paramString1, paramContext);
      }
      if (!a(paramString2, paramString3.split(";")))
      {
        AppMethodBeat.o(123204);
        return -204;
      }
    }
    catch (FileNotFoundException paramContext)
    {
      AppMethodBeat.o(123204);
      return -204;
    }
    this.b = paramContext;
    this.a = true;
    AppMethodBeat.o(123204);
    return 0;
  }
  
  public final int e(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(123205);
    if (this.a)
    {
      AppMethodBeat.o(123205);
      return 0;
    }
    if (!a("libwxvoiceembed.so", paramString1))
    {
      AppMethodBeat.o(123205);
      return -201;
    }
    if (!a("libwxvoiceembed.bin", paramString1))
    {
      AppMethodBeat.o(123205);
      return -202;
    }
    try
    {
      String str = b("libwxvoiceembed.so", paramString1);
      if (!a(str, paramString2.split(";")))
      {
        AppMethodBeat.o(123205);
        return -203;
      }
    }
    catch (FileNotFoundException paramString1)
    {
      AppMethodBeat.o(123205);
      return -203;
    }
    try
    {
      paramString2 = b("libwxvoiceembed.bin", paramString1);
      if (!a(paramString2, paramString3.split(";")))
      {
        AppMethodBeat.o(123205);
        return -204;
      }
    }
    catch (FileNotFoundException paramString1)
    {
      AppMethodBeat.o(123205);
      return -204;
    }
    this.b = paramString1;
    this.a = true;
    AppMethodBeat.o(123205);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.f
 * JD-Core Version:    0.7.0.1
 */