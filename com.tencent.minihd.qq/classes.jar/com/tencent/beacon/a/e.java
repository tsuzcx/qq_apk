package com.tencent.beacon.a;

import android.content.Context;

public final class e
{
  private static e n = null;
  private Context a = null;
  private String b = "";
  private String c = "";
  private byte d = -1;
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private long j = 0L;
  private String k = "";
  private String l = "";
  private String m = "";
  
  private void a(byte paramByte)
  {
    try
    {
      this.d = 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +189 -> 193
    //   7: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   10: ifnonnull +13 -> 23
    //   13: new 2	com/tencent/beacon/a/e
    //   16: dup
    //   17: invokespecial 62	com/tencent/beacon/a/e:<init>	()V
    //   20: putstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   23: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   26: astore_1
    //   27: aload_1
    //   28: monitorenter
    //   29: ldc 64
    //   31: iconst_0
    //   32: anewarray 4	java/lang/Object
    //   35: invokestatic 69	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   41: aload_0
    //   42: putfield 33	com/tencent/beacon/a/e:a	Landroid/content/Context;
    //   45: aload_0
    //   46: invokestatic 74	com/tencent/beacon/a/g:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/g;
    //   49: pop
    //   50: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   53: invokestatic 77	com/tencent/beacon/a/g:a	()Ljava/lang/String;
    //   56: putfield 37	com/tencent/beacon/a/e:b	Ljava/lang/String;
    //   59: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   62: astore_2
    //   63: new 79	java/lang/StringBuffer
    //   66: dup
    //   67: invokespecial 80	java/lang/StringBuffer:<init>	()V
    //   70: astore_3
    //   71: aload_3
    //   72: ldc 82
    //   74: invokevirtual 86	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   77: pop
    //   78: aload_3
    //   79: invokestatic 88	com/tencent/beacon/a/g:b	()Ljava/lang/String;
    //   82: invokevirtual 86	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   85: pop
    //   86: aload_3
    //   87: ldc 90
    //   89: invokevirtual 86	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   92: pop
    //   93: aload_3
    //   94: invokestatic 92	com/tencent/beacon/a/g:c	()Ljava/lang/String;
    //   97: invokevirtual 86	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   100: pop
    //   101: aload_2
    //   102: aload_3
    //   103: invokevirtual 95	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   106: putfield 39	com/tencent/beacon/a/e:c	Ljava/lang/String;
    //   109: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   112: iconst_1
    //   113: invokespecial 97	com/tencent/beacon/a/e:a	(B)V
    //   116: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   119: aload_0
    //   120: invokestatic 102	com/tencent/beacon/a/a:e	(Landroid/content/Context;)Ljava/lang/String;
    //   123: invokespecial 105	com/tencent/beacon/a/e:e	(Ljava/lang/String;)V
    //   126: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   129: aload_0
    //   130: invokestatic 107	com/tencent/beacon/a/a:f	(Landroid/content/Context;)Ljava/lang/String;
    //   133: invokespecial 109	com/tencent/beacon/a/e:f	(Ljava/lang/String;)V
    //   136: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   139: ldc 111
    //   141: invokespecial 113	com/tencent/beacon/a/e:g	(Ljava/lang/String;)V
    //   144: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   147: ldc 115
    //   149: invokespecial 117	com/tencent/beacon/a/e:h	(Ljava/lang/String;)V
    //   152: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   155: ldc 119
    //   157: invokevirtual 121	com/tencent/beacon/a/e:a	(Ljava/lang/String;)V
    //   160: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   163: aload_0
    //   164: invokestatic 123	com/tencent/beacon/a/g:b	(Landroid/content/Context;)Ljava/lang/String;
    //   167: invokevirtual 125	com/tencent/beacon/a/e:b	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: invokestatic 127	com/tencent/beacon/a/a:a	(Landroid/content/Context;)Ljava/lang/String;
    //   174: astore_0
    //   175: ldc 35
    //   177: aload_0
    //   178: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   181: ifne +16 -> 197
    //   184: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   187: aload_0
    //   188: invokevirtual 135	com/tencent/beacon/a/e:d	(Ljava/lang/String;)V
    //   191: aload_1
    //   192: monitorexit
    //   193: ldc 2
    //   195: monitorexit
    //   196: return
    //   197: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   200: getstatic 27	com/tencent/beacon/a/e:n	Lcom/tencent/beacon/a/e;
    //   203: invokespecial 137	com/tencent/beacon/a/e:n	()Ljava/lang/String;
    //   206: invokevirtual 135	com/tencent/beacon/a/e:d	(Ljava/lang/String;)V
    //   209: goto -18 -> 191
    //   212: astore_0
    //   213: aload_1
    //   214: monitorexit
    //   215: aload_0
    //   216: athrow
    //   217: astore_0
    //   218: ldc 2
    //   220: monitorexit
    //   221: aload_0
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	paramContext	Context
    //   62	40	2	locale2	e
    //   70	33	3	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   29	191	212	finally
    //   191	193	212	finally
    //   197	209	212	finally
    //   7	23	217	finally
    //   23	29	217	finally
    //   213	217	217	finally
  }
  
  private void e(String paramString)
  {
    try
    {
      this.e = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void f(String paramString)
  {
    try
    {
      this.f = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void g(String paramString)
  {
    try
    {
      this.g = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void h(String paramString)
  {
    try
    {
      this.h = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static e m()
  {
    try
    {
      e locale = n;
      return locale;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private String n()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final void a(long paramLong)
  {
    try
    {
      this.j = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      this.i = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String b()
  {
    return this.c;
  }
  
  /* Error */
  public final void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 35
    //   4: aload_1
    //   5: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifne +14 -> 24
    //   13: aload_0
    //   14: getfield 33	com/tencent/beacon/a/e:a	Landroid/content/Context;
    //   17: ldc 150
    //   19: aload_1
    //   20: invokestatic 153	com/tencent/beacon/a/a:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   23: pop
    //   24: aload_0
    //   25: aload_1
    //   26: putfield 55	com/tencent/beacon/a/e:k	Ljava/lang/String;
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    //   37: astore_3
    //   38: goto -14 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	e
    //   0	41	1	paramString	String
    //   8	2	2	bool	boolean
    //   37	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	9	32	finally
    //   13	24	32	finally
    //   24	29	32	finally
    //   13	24	37	java/lang/Exception
  }
  
  public final byte c()
  {
    try
    {
      byte b1 = this.d;
      return b1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void c(String paramString)
  {
    try
    {
      this.m = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String d()
  {
    try
    {
      String str = this.f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void d(String paramString)
  {
    try
    {
      this.l = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final String e()
  {
    try
    {
      String str = this.g;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String f()
  {
    try
    {
      String str = this.h;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String g()
  {
    try
    {
      String str = this.i;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long h()
  {
    try
    {
      long l1 = this.j;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final String i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 35
    //   4: aload_0
    //   5: getfield 55	com/tencent/beacon/a/e:k	Ljava/lang/String;
    //   8: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   11: istore_1
    //   12: iload_1
    //   13: ifeq +18 -> 31
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 33	com/tencent/beacon/a/e:a	Landroid/content/Context;
    //   21: ldc 150
    //   23: ldc 35
    //   25: invokestatic 158	com/tencent/beacon/a/a:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   28: putfield 55	com/tencent/beacon/a/e:k	Ljava/lang/String;
    //   31: aload_0
    //   32: getfield 55	com/tencent/beacon/a/e:k	Ljava/lang/String;
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: areturn
    //   40: astore_2
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_2
    //   44: athrow
    //   45: astore_2
    //   46: goto -15 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	e
    //   11	2	1	bool	boolean
    //   35	4	2	str	String
    //   40	4	2	localObject	Object
    //   45	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   2	12	40	finally
    //   16	31	40	finally
    //   31	36	40	finally
    //   16	31	45	java/lang/Exception
  }
  
  public final String j()
  {
    try
    {
      String str = this.l;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String k()
  {
    try
    {
      String str = this.m;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final Context l()
  {
    try
    {
      Context localContext = this.a;
      return localContext;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.e
 * JD-Core Version:    0.7.0.1
 */