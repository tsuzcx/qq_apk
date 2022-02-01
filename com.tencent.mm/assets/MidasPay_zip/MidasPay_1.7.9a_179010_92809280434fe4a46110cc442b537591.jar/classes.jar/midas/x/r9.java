package midas.x;

import android.os.Handler;
import android.os.Looper;

public class r9
{
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 20
    //   5: ldc 22
    //   7: invokestatic 27	midas/x/ca:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: invokestatic 33	midas/x/y9:d	()Lmidas/x/y9;
    //   13: invokevirtual 35	midas/x/y9:a	()V
    //   16: goto +17 -> 33
    //   19: astore_0
    //   20: aload_0
    //   21: invokevirtual 40	java/lang/Throwable:printStackTrace	()V
    //   24: ldc 20
    //   26: aload_0
    //   27: invokevirtual 44	java/lang/Throwable:toString	()Ljava/lang/String;
    //   30: invokestatic 47	midas/x/ca:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc 2
    //   35: monitorexit
    //   36: return
    //   37: astore_0
    //   38: ldc 2
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   19	8	0	localObject1	Object
    //   37	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	19	finally
    //   20	33	37	finally
  }
  
  public static void a(Handler paramHandler, s9 params9, final q9 paramq9)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("connect() handler=");
      ((StringBuilder)localObject).append(paramHandler);
      ((StringBuilder)localObject).append(", request=");
      ((StringBuilder)localObject).append(params9);
      ((StringBuilder)localObject).append(", listener=");
      ((StringBuilder)localObject).append(paramq9);
      ca.a("PushAPI", ((StringBuilder)localObject).toString());
      localObject = paramHandler;
      if (paramHandler == null)
      {
        ca.d("PushAPI", "connect() Hander is null! So replaced handler with MainLooper");
        localObject = new Handler(Looper.getMainLooper());
      }
      paramHandler = (Handler)localObject;
      if (((Handler)localObject).getLooper() == null)
      {
        ca.d("PushAPI", "connect() Hander is not looper! So replaced handler with MainLooper");
        paramHandler = new Handler(Looper.getMainLooper());
      }
      y9.d().a(paramHandler, params9, new a(paramHandler, paramq9));
    }
    finally {}
    try
    {
      paramHandler.printStackTrace();
      ca.b("PushAPI", paramHandler.toString());
      return;
    }
    finally
    {
      paramHandler = finally;
      throw paramHandler;
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 51	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   10: astore 4
    //   12: aload 4
    //   14: ldc 96
    //   16: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload 4
    //   22: aload_0
    //   23: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 4
    //   29: ldc 98
    //   31: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 4
    //   37: aload_1
    //   38: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload 4
    //   44: ldc 100
    //   46: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 4
    //   52: aload_2
    //   53: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 4
    //   59: ldc 102
    //   61: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 4
    //   67: aload_3
    //   68: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: ldc 20
    //   74: aload 4
    //   76: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 27	midas/x/ca:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: invokestatic 33	midas/x/y9:d	()Lmidas/x/y9;
    //   85: aload_0
    //   86: aload_1
    //   87: aload_2
    //   88: aload_3
    //   89: invokevirtual 104	midas/x/y9:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   92: goto +17 -> 109
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 40	java/lang/Throwable:printStackTrace	()V
    //   100: ldc 20
    //   102: aload_0
    //   103: invokevirtual 44	java/lang/Throwable:toString	()Ljava/lang/String;
    //   106: invokestatic 47	midas/x/ca:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: ldc 2
    //   111: monitorexit
    //   112: return
    //   113: astore_0
    //   114: ldc 2
    //   116: monitorexit
    //   117: aload_0
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramString1	String
    //   0	119	1	paramString2	String
    //   0	119	2	paramString3	String
    //   0	119	3	paramString4	String
    //   10	65	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	92	95	finally
    //   96	109	113	finally
  }
  
  public static u9 b()
  {
    try
    {
      u9 localu9 = u9.a();
      return localu9;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static final class a
    implements q9
  {
    public a(Handler paramHandler, q9 paramq9) {}
    
    public void a(final int paramInt, final String paramString)
    {
      if (pa.a(this.a))
      {
        paramq9.a(paramInt, paramString);
        return;
      }
      this.a.post(new c(paramInt, paramString));
    }
    
    public void a(final int paramInt, final v9 paramv9)
    {
      if (pa.a(this.a))
      {
        paramq9.a(paramInt, paramv9);
        return;
      }
      this.a.post(new d(paramInt, paramv9));
    }
    
    public void a(final t9 paramt9)
    {
      if (pa.a(this.a))
      {
        paramq9.a(paramt9);
        return;
      }
      this.a.post(new a(paramt9));
    }
    
    public void a(final x9 paramx9)
    {
      if (pa.a(this.a))
      {
        paramq9.a(paramx9);
        return;
      }
      this.a.post(new b(paramx9));
    }
    
    public void b(final int paramInt, final String paramString)
    {
      if (pa.a(this.a))
      {
        paramq9.b(paramInt, paramString);
        return;
      }
      this.a.post(new e(paramInt, paramString));
    }
    
    public class a
      implements Runnable
    {
      public a(t9 paramt9) {}
      
      public void run()
      {
        r9.a.this.b.a(paramt9);
      }
    }
    
    public class b
      implements Runnable
    {
      public b(x9 paramx9) {}
      
      public void run()
      {
        r9.a.this.b.a(paramx9);
      }
    }
    
    public class c
      implements Runnable
    {
      public c(int paramInt, String paramString) {}
      
      public void run()
      {
        r9.a.this.b.a(paramInt, paramString);
      }
    }
    
    public class d
      implements Runnable
    {
      public d(int paramInt, v9 paramv9) {}
      
      public void run()
      {
        r9.a.this.b.a(paramInt, paramv9);
      }
    }
    
    public class e
      implements Runnable
    {
      public e(int paramInt, String paramString) {}
      
      public void run()
      {
        r9.a.this.b.b(paramInt, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.r9
 * JD-Core Version:    0.7.0.1
 */