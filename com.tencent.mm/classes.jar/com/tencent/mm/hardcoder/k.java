package com.tencent.mm.hardcoder;

public final class k
{
  /* Error */
  public static void a(java.io.InputStream paramInputStream, a parama)
  {
    // Byte code:
    //   0: new 12	java/io/BufferedReader
    //   3: dup
    //   4: new 14	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 18	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 21	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_3
    //   16: aload_3
    //   17: astore_0
    //   18: aload_3
    //   19: invokevirtual 25	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   22: astore 4
    //   24: aload 4
    //   26: ifnull +22 -> 48
    //   29: aload_1
    //   30: ifnull -14 -> 16
    //   33: aload_3
    //   34: astore_0
    //   35: aload_1
    //   36: aload 4
    //   38: invokeinterface 29 2 0
    //   43: istore_2
    //   44: iload_2
    //   45: ifne -29 -> 16
    //   48: aload_3
    //   49: invokevirtual 33	java/io/BufferedReader:close	()V
    //   52: return
    //   53: astore_0
    //   54: ldc 35
    //   56: new 37	java/lang/StringBuilder
    //   59: dup
    //   60: ldc 39
    //   62: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   69: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 58	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: return
    //   79: astore 4
    //   81: aconst_null
    //   82: astore_1
    //   83: aload_1
    //   84: astore_0
    //   85: ldc 35
    //   87: new 37	java/lang/StringBuilder
    //   90: dup
    //   91: ldc 39
    //   93: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload 4
    //   98: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   101: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 58	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_1
    //   111: ifnull -59 -> 52
    //   114: aload_1
    //   115: invokevirtual 33	java/io/BufferedReader:close	()V
    //   118: return
    //   119: astore_0
    //   120: ldc 35
    //   122: new 37	java/lang/StringBuilder
    //   125: dup
    //   126: ldc 39
    //   128: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload_0
    //   132: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   135: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 58	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: return
    //   145: astore_1
    //   146: aconst_null
    //   147: astore_0
    //   148: aload_0
    //   149: ifnull +7 -> 156
    //   152: aload_0
    //   153: invokevirtual 33	java/io/BufferedReader:close	()V
    //   156: aload_1
    //   157: athrow
    //   158: astore_0
    //   159: ldc 35
    //   161: new 37	java/lang/StringBuilder
    //   164: dup
    //   165: ldc 39
    //   167: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 58	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: goto -27 -> 156
    //   186: astore_1
    //   187: goto -39 -> 148
    //   190: astore 4
    //   192: aload_3
    //   193: astore_1
    //   194: goto -111 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	paramInputStream	java.io.InputStream
    //   0	197	1	parama	a
    //   43	2	2	bool	boolean
    //   15	178	3	localBufferedReader	java.io.BufferedReader
    //   22	15	4	str	String
    //   79	18	4	localException1	java.lang.Exception
    //   190	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   48	52	53	java/lang/Exception
    //   0	16	79	java/lang/Exception
    //   114	118	119	java/lang/Exception
    //   0	16	145	finally
    //   152	156	158	java/lang/Exception
    //   18	24	186	finally
    //   35	44	186	finally
    //   85	110	186	finally
    //   18	24	190	java/lang/Exception
    //   35	44	190	java/lang/Exception
  }
  
  /* Error */
  public static void a(String paramString, a parama)
  {
    // Byte code:
    //   0: new 62	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 63	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_0
    //   11: aload_2
    //   12: aload_1
    //   13: invokestatic 65	com/tencent/mm/hardcoder/k:a	(Ljava/io/InputStream;Lcom/tencent/mm/hardcoder/k$a;)V
    //   16: aload_2
    //   17: invokevirtual 68	java/io/InputStream:close	()V
    //   20: return
    //   21: astore_0
    //   22: ldc 35
    //   24: new 37	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 39
    //   30: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload_0
    //   34: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   37: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 58	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: return
    //   47: astore_3
    //   48: aconst_null
    //   49: astore_1
    //   50: aload_1
    //   51: astore_0
    //   52: ldc 35
    //   54: new 37	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 39
    //   60: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_3
    //   64: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   67: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 58	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_1
    //   77: ifnull -57 -> 20
    //   80: aload_1
    //   81: invokevirtual 68	java/io/InputStream:close	()V
    //   84: return
    //   85: astore_0
    //   86: ldc 35
    //   88: new 37	java/lang/StringBuilder
    //   91: dup
    //   92: ldc 39
    //   94: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: aload_0
    //   98: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   101: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 58	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: return
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: ifnull +7 -> 122
    //   118: aload_0
    //   119: invokevirtual 68	java/io/InputStream:close	()V
    //   122: aload_1
    //   123: athrow
    //   124: astore_0
    //   125: ldc 35
    //   127: new 37	java/lang/StringBuilder
    //   130: dup
    //   131: ldc 39
    //   133: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: aload_0
    //   137: invokevirtual 45	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   140: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 58	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: goto -27 -> 122
    //   152: astore_1
    //   153: goto -39 -> 114
    //   156: astore_3
    //   157: aload_2
    //   158: astore_1
    //   159: goto -109 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	String
    //   0	162	1	parama	a
    //   8	150	2	localFileInputStream	java.io.FileInputStream
    //   47	17	3	localException1	java.lang.Exception
    //   156	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   16	20	21	java/lang/Exception
    //   0	9	47	java/lang/Exception
    //   80	84	85	java/lang/Exception
    //   0	9	111	finally
    //   118	122	124	java/lang/Exception
    //   11	16	152	finally
    //   52	76	152	finally
    //   11	16	156	java/lang/Exception
  }
  
  public static abstract interface a
  {
    public abstract boolean fz(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.k
 * JD-Core Version:    0.7.0.1
 */