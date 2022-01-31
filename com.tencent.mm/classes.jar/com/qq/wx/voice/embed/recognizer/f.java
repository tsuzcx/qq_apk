package com.qq.wx.voice.embed.recognizer;

import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;

final class f
{
  private boolean a = false;
  String b = null;
  
  private static boolean a(String paramString1, String paramString2)
  {
    return new File(paramString2 + "/" + paramString1).exists();
  }
  
  private static boolean a(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfString.length) {
        return false;
      }
      if (paramString.compareTo(paramArrayOfString[i]) == 0) {
        return true;
      }
      i += 1;
    }
  }
  
  /* Error */
  private static String b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 20	java/io/File
    //   3: dup
    //   4: new 22	java/lang/StringBuilder
    //   7: dup
    //   8: aload_1
    //   9: invokestatic 28	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   12: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: ldc 33
    //   17: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: new 58	java/io/FileInputStream
    //   34: dup
    //   35: aload_1
    //   36: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 65	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   44: getstatic 71	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   47: lconst_0
    //   48: aload_1
    //   49: invokevirtual 75	java/io/File:length	()J
    //   52: invokevirtual 81	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   55: astore_1
    //   56: ldc 83
    //   58: invokestatic 89	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   61: astore_2
    //   62: aload_2
    //   63: aload_1
    //   64: invokevirtual 93	java/security/MessageDigest:update	(Ljava/nio/ByteBuffer;)V
    //   67: new 95	java/math/BigInteger
    //   70: dup
    //   71: iconst_1
    //   72: aload_2
    //   73: invokevirtual 99	java/security/MessageDigest:digest	()[B
    //   76: invokespecial 102	java/math/BigInteger:<init>	(I[B)V
    //   79: bipush 16
    //   81: invokevirtual 105	java/math/BigInteger:toString	(I)Ljava/lang/String;
    //   84: astore_1
    //   85: aload_0
    //   86: invokevirtual 108	java/io/FileInputStream:close	()V
    //   89: aload_1
    //   90: areturn
    //   91: astore_1
    //   92: aload_0
    //   93: invokevirtual 108	java/io/FileInputStream:close	()V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_0
    //   99: aconst_null
    //   100: areturn
    //   101: astore_1
    //   102: aload_0
    //   103: invokevirtual 108	java/io/FileInputStream:close	()V
    //   106: aload_1
    //   107: athrow
    //   108: astore_0
    //   109: goto -3 -> 106
    //   112: astore_0
    //   113: aload_1
    //   114: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramString1	String
    //   0	115	1	paramString2	String
    //   61	12	2	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   40	85	91	java/lang/Exception
    //   92	96	98	java/io/IOException
    //   40	85	101	finally
    //   102	106	108	java/io/IOException
    //   85	89	112	java/io/IOException
  }
  
  /* Error */
  private static void d(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 20	java/io/File
    //   3: dup
    //   4: new 22	java/lang/StringBuilder
    //   7: dup
    //   8: aload_1
    //   9: invokestatic 28	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   12: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: ldc 33
    //   17: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore_1
    //   31: new 20	java/io/File
    //   34: dup
    //   35: new 22	java/lang/StringBuilder
    //   38: dup
    //   39: aload_2
    //   40: invokestatic 28	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   43: invokespecial 31	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: ldc 33
    //   48: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_0
    //   52: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   61: astore_2
    //   62: new 58	java/io/FileInputStream
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   70: astore_0
    //   71: new 112	java/io/FileOutputStream
    //   74: dup
    //   75: aload_2
    //   76: invokespecial 113	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   79: astore 4
    //   81: aload_0
    //   82: invokevirtual 65	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   85: astore_1
    //   86: aload 4
    //   88: invokevirtual 114	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   91: astore 5
    //   93: aload_1
    //   94: lconst_0
    //   95: aload_1
    //   96: invokevirtual 117	java/nio/channels/FileChannel:size	()J
    //   99: aload 5
    //   101: invokevirtual 121	java/nio/channels/FileChannel:transferTo	(JJLjava/nio/channels/WritableByteChannel;)J
    //   104: pop2
    //   105: aload_0
    //   106: invokevirtual 108	java/io/FileInputStream:close	()V
    //   109: aload_1
    //   110: invokevirtual 122	java/nio/channels/FileChannel:close	()V
    //   113: aload 4
    //   115: invokevirtual 123	java/io/FileOutputStream:close	()V
    //   118: aload 5
    //   120: invokevirtual 122	java/nio/channels/FileChannel:close	()V
    //   123: return
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_3
    //   129: aconst_null
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_1
    //   134: invokevirtual 108	java/io/FileInputStream:close	()V
    //   137: aload_3
    //   138: invokevirtual 122	java/nio/channels/FileChannel:close	()V
    //   141: aload_0
    //   142: invokevirtual 123	java/io/FileOutputStream:close	()V
    //   145: aload_2
    //   146: invokevirtual 122	java/nio/channels/FileChannel:close	()V
    //   149: return
    //   150: astore_0
    //   151: return
    //   152: astore_1
    //   153: aconst_null
    //   154: astore_3
    //   155: aconst_null
    //   156: astore_2
    //   157: aconst_null
    //   158: astore 4
    //   160: aconst_null
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 108	java/io/FileInputStream:close	()V
    //   166: aload_2
    //   167: invokevirtual 122	java/nio/channels/FileChannel:close	()V
    //   170: aload 4
    //   172: invokevirtual 123	java/io/FileOutputStream:close	()V
    //   175: aload_3
    //   176: invokevirtual 122	java/nio/channels/FileChannel:close	()V
    //   179: aload_1
    //   180: athrow
    //   181: astore_0
    //   182: return
    //   183: astore_0
    //   184: goto -5 -> 179
    //   187: astore_1
    //   188: aconst_null
    //   189: astore_3
    //   190: aconst_null
    //   191: astore_2
    //   192: aconst_null
    //   193: astore 4
    //   195: goto -33 -> 162
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_3
    //   201: aconst_null
    //   202: astore_2
    //   203: goto -41 -> 162
    //   206: astore 5
    //   208: aconst_null
    //   209: astore_3
    //   210: aload_1
    //   211: astore_2
    //   212: aload 5
    //   214: astore_1
    //   215: goto -53 -> 162
    //   218: astore_2
    //   219: aload_1
    //   220: astore_3
    //   221: aload_2
    //   222: astore_1
    //   223: aload_3
    //   224: astore_2
    //   225: aload 5
    //   227: astore_3
    //   228: goto -66 -> 162
    //   231: astore_1
    //   232: aconst_null
    //   233: astore_2
    //   234: aconst_null
    //   235: astore_3
    //   236: aconst_null
    //   237: astore 4
    //   239: aload_0
    //   240: astore_1
    //   241: aload 4
    //   243: astore_0
    //   244: goto -111 -> 133
    //   247: astore_1
    //   248: aconst_null
    //   249: astore_2
    //   250: aconst_null
    //   251: astore_3
    //   252: aload_0
    //   253: astore_1
    //   254: aload 4
    //   256: astore_0
    //   257: goto -124 -> 133
    //   260: astore_2
    //   261: aconst_null
    //   262: astore 5
    //   264: aload_0
    //   265: astore_2
    //   266: aload_1
    //   267: astore_3
    //   268: aload 4
    //   270: astore_0
    //   271: aload_2
    //   272: astore_1
    //   273: aload 5
    //   275: astore_2
    //   276: goto -143 -> 133
    //   279: astore_2
    //   280: aload_0
    //   281: astore_2
    //   282: aload_1
    //   283: astore_3
    //   284: aload 4
    //   286: astore_0
    //   287: aload_2
    //   288: astore_1
    //   289: aload 5
    //   291: astore_2
    //   292: goto -159 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	paramString1	String
    //   0	295	1	paramString2	String
    //   0	295	2	paramString3	String
    //   128	156	3	localObject1	Object
    //   79	206	4	localFileOutputStream	java.io.FileOutputStream
    //   91	28	5	localFileChannel	java.nio.channels.FileChannel
    //   206	20	5	localObject2	Object
    //   262	28	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   62	71	124	java/io/IOException
    //   133	149	150	java/io/IOException
    //   62	71	152	finally
    //   105	123	181	java/io/IOException
    //   162	179	183	java/io/IOException
    //   71	81	187	finally
    //   81	86	198	finally
    //   86	93	206	finally
    //   93	105	218	finally
    //   71	81	231	java/io/IOException
    //   81	86	247	java/io/IOException
    //   86	93	260	java/io/IOException
    //   93	105	279	java/io/IOException
  }
  
  public final int c(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (this.a) {
      return 0;
    }
    if (!a("libwxvoiceembed.so", paramString1)) {
      return -201;
    }
    if (!a("libwxvoiceembed.bin", paramString1)) {
      return -202;
    }
    paramContext = paramContext.getFilesDir().getAbsolutePath() + "/NamesSearch/";
    Object localObject = new File(paramContext);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    if (!a("libwxvoiceembed.so", paramContext)) {
      d("libwxvoiceembed.so", paramString1, paramContext);
    }
    if (!a("libwxvoiceembed.bin", paramContext)) {
      d("libwxvoiceembed.bin", paramString1, paramContext);
    }
    try
    {
      localObject = b("libwxvoiceembed.so", paramContext);
      String str = b("libwxvoiceembed.so", paramString1);
      if (((String)localObject).compareTo(str) != 0) {
        d("libwxvoiceembed.so", paramString1, paramContext);
      }
      if (!a((String)localObject, paramString2.split(";"))) {
        return -203;
      }
    }
    catch (FileNotFoundException paramContext)
    {
      return -203;
    }
    try
    {
      paramString2 = b("libwxvoiceembed.bin", paramContext);
      localObject = b("libwxvoiceembed.bin", paramString1);
      if (paramString2.compareTo((String)localObject) != 0) {
        d("libwxvoiceembed.bin", paramString1, paramContext);
      }
      if (!a(paramString2, paramString3.split(";"))) {
        return -204;
      }
    }
    catch (FileNotFoundException paramContext)
    {
      return -204;
    }
    this.b = paramContext;
    this.a = true;
    return 0;
  }
  
  public final int c(String paramString1, String paramString2, String paramString3)
  {
    if (this.a) {
      return 0;
    }
    if (!a("libwxvoiceembed.so", paramString1)) {
      return -201;
    }
    if (!a("libwxvoiceembed.bin", paramString1)) {
      return -202;
    }
    try
    {
      String str = b("libwxvoiceembed.so", paramString1);
      if (!a(str, paramString2.split(";"))) {
        return -203;
      }
    }
    catch (FileNotFoundException paramString1)
    {
      return -203;
    }
    try
    {
      paramString2 = b("libwxvoiceembed.bin", paramString1);
      if (!a(paramString2, paramString3.split(";"))) {
        return -204;
      }
    }
    catch (FileNotFoundException paramString1)
    {
      return -204;
    }
    this.b = paramString1;
    this.a = true;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.f
 * JD-Core Version:    0.7.0.1
 */