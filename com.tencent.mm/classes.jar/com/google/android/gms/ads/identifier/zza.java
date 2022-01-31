package com.google.android.gms.ads.identifier;

public class zza
{
  /* Error */
  public void zzu(java.lang.String paramString)
  {
    // Byte code:
    //   0: new 19	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 21	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 25	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 27	java/net/HttpURLConnection
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 31	java/net/HttpURLConnection:getResponseCode	()I
    //   19: istore_2
    //   20: iload_2
    //   21: sipush 200
    //   24: if_icmplt +10 -> 34
    //   27: iload_2
    //   28: sipush 300
    //   31: if_icmplt +39 -> 70
    //   34: new 33	java/lang/StringBuilder
    //   37: dup
    //   38: aload_1
    //   39: invokestatic 39	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   42: invokevirtual 42	java/lang/String:length	()I
    //   45: bipush 65
    //   47: iadd
    //   48: invokespecial 45	java/lang/StringBuilder:<init>	(I)V
    //   51: ldc 47
    //   53: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: iload_2
    //   57: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: ldc 56
    //   62: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_1
    //   66: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_3
    //   71: invokevirtual 59	java/net/HttpURLConnection:disconnect	()V
    //   74: return
    //   75: astore 4
    //   77: aload_3
    //   78: invokevirtual 59	java/net/HttpURLConnection:disconnect	()V
    //   81: aload 4
    //   83: athrow
    //   84: astore_3
    //   85: aload_3
    //   86: invokevirtual 63	java/lang/IndexOutOfBoundsException:getMessage	()Ljava/lang/String;
    //   89: invokestatic 39	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   92: astore_3
    //   93: new 33	java/lang/StringBuilder
    //   96: dup
    //   97: aload_1
    //   98: invokestatic 39	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   101: invokevirtual 42	java/lang/String:length	()I
    //   104: bipush 32
    //   106: iadd
    //   107: aload_3
    //   108: invokestatic 39	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   111: invokevirtual 42	java/lang/String:length	()I
    //   114: iadd
    //   115: invokespecial 45	java/lang/StringBuilder:<init>	(I)V
    //   118: ldc 65
    //   120: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_1
    //   124: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 67
    //   129: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_3
    //   133: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: return
    //   138: astore_3
    //   139: aload_3
    //   140: invokevirtual 70	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   143: invokestatic 39	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   146: astore_3
    //   147: new 33	java/lang/StringBuilder
    //   150: dup
    //   151: aload_1
    //   152: invokestatic 39	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   155: invokevirtual 42	java/lang/String:length	()I
    //   158: bipush 27
    //   160: iadd
    //   161: aload_3
    //   162: invokestatic 39	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   165: invokevirtual 42	java/lang/String:length	()I
    //   168: iadd
    //   169: invokespecial 45	java/lang/StringBuilder:<init>	(I)V
    //   172: ldc 72
    //   174: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_1
    //   178: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: ldc 67
    //   183: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_3
    //   187: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: return
    //   192: astore_3
    //   193: goto -54 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	zza
    //   0	196	1	paramString	java.lang.String
    //   19	38	2	i	int
    //   14	64	3	localHttpURLConnection	java.net.HttpURLConnection
    //   84	2	3	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    //   92	41	3	str1	java.lang.String
    //   138	2	3	localRuntimeException	java.lang.RuntimeException
    //   146	41	3	str2	java.lang.String
    //   192	1	3	localIOException	java.io.IOException
    //   75	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	20	75	finally
    //   34	70	75	finally
    //   0	15	84	java/lang/IndexOutOfBoundsException
    //   70	74	84	java/lang/IndexOutOfBoundsException
    //   77	84	84	java/lang/IndexOutOfBoundsException
    //   0	15	138	java/lang/RuntimeException
    //   70	74	138	java/lang/RuntimeException
    //   77	84	138	java/lang/RuntimeException
    //   0	15	192	java/io/IOException
    //   70	74	192	java/io/IOException
    //   77	84	192	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.zza
 * JD-Core Version:    0.7.0.1
 */