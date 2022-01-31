package c.t.m.g;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ab
{
  private static String a = "info.3g.qq.com";
  
  public static boolean a()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    aa.a.a().a.execute(new ac(arrayOfBoolean, localCountDownLatch));
    try
    {
      localCountDownLatch.await(5L, TimeUnit.SECONDS);
      label46:
      return arrayOfBoolean[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      break label46;
    }
  }
  
  /* Error */
  private static boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: new 60	java/net/Socket
    //   7: dup
    //   8: invokespecial 62	java/net/Socket:<init>	()V
    //   11: astore 4
    //   13: aload 4
    //   15: new 64	java/net/InetSocketAddress
    //   18: dup
    //   19: aload_0
    //   20: bipush 80
    //   22: invokespecial 67	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   25: sipush 5000
    //   28: invokevirtual 71	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   31: aload 4
    //   33: invokevirtual 74	java/net/Socket:isConnected	()Z
    //   36: istore_3
    //   37: iload_3
    //   38: ifeq +5 -> 43
    //   41: iconst_1
    //   42: istore_1
    //   43: aload 4
    //   45: invokevirtual 77	java/net/Socket:close	()V
    //   48: iload_1
    //   49: ireturn
    //   50: astore_0
    //   51: aconst_null
    //   52: astore 4
    //   54: iload_2
    //   55: istore_1
    //   56: aload 4
    //   58: ifnull -10 -> 48
    //   61: aload 4
    //   63: invokevirtual 77	java/net/Socket:close	()V
    //   66: iconst_0
    //   67: ireturn
    //   68: astore_0
    //   69: iconst_0
    //   70: ireturn
    //   71: astore_0
    //   72: aconst_null
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +8 -> 85
    //   80: aload 4
    //   82: invokevirtual 77	java/net/Socket:close	()V
    //   85: aload_0
    //   86: athrow
    //   87: astore_0
    //   88: iload_1
    //   89: ireturn
    //   90: astore 4
    //   92: goto -7 -> 85
    //   95: astore_0
    //   96: goto -21 -> 75
    //   99: astore_0
    //   100: goto -46 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramString	String
    //   3	86	1	bool1	boolean
    //   1	54	2	bool2	boolean
    //   36	2	3	bool3	boolean
    //   11	70	4	localSocket	java.net.Socket
    //   90	1	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   4	13	50	java/lang/Throwable
    //   61	66	68	java/lang/Throwable
    //   4	13	71	finally
    //   43	48	87	java/lang/Throwable
    //   80	85	90	java/lang/Throwable
    //   13	37	95	finally
    //   13	37	99	java/lang/Throwable
  }
  
  public static boolean b()
  {
    return a(a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.g.ab
 * JD-Core Version:    0.7.0.1
 */