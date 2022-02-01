package midas.x;

import android.os.AsyncTask;
import java.util.concurrent.ExecutorService;

public final class rd
{
  public static void a(ExecutorService paramExecutorService1, ExecutorService paramExecutorService2, od paramod, Object[] paramArrayOfObject, pd parampd, final long paramLong)
  {
    paramod = new b(paramod);
    paramod.executeOnExecutor(paramExecutorService1, paramArrayOfObject);
    paramExecutorService2.submit(new a(paramod, paramLong, parampd));
  }
  
  public static void a(ExecutorService paramExecutorService, od paramod, Object[] paramArrayOfObject, pd parampd)
  {
    new b(paramod, parampd).executeOnExecutor(paramExecutorService, paramArrayOfObject);
  }
  
  public static final class a
    implements Runnable
  {
    public a(rd.b paramb, long paramLong, pd parampd) {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 20	midas/x/rd$a:a	Lmidas/x/rd$b;
      //   4: aload_0
      //   5: getfield 22	midas/x/rd$a:b	J
      //   8: getstatic 43	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   11: invokevirtual 49	android/os/AsyncTask:get	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
      //   14: astore_1
      //   15: aload_0
      //   16: getfield 24	midas/x/rd$a:c	Lmidas/x/pd;
      //   19: iconst_0
      //   20: aload_1
      //   21: invokeinterface 54 3 0
      //   26: goto +64 -> 90
      //   29: astore_1
      //   30: goto +70 -> 100
      //   33: astore_1
      //   34: aload_0
      //   35: getfield 24	midas/x/rd$a:c	Lmidas/x/pd;
      //   38: iconst_m1
      //   39: aload_1
      //   40: invokeinterface 54 3 0
      //   45: goto +45 -> 90
      //   48: astore_1
      //   49: aload_0
      //   50: getfield 24	midas/x/rd$a:c	Lmidas/x/pd;
      //   53: iconst_m1
      //   54: aload_1
      //   55: invokeinterface 54 3 0
      //   60: goto +30 -> 90
      //   63: astore_1
      //   64: aload_0
      //   65: getfield 24	midas/x/rd$a:c	Lmidas/x/pd;
      //   68: iconst_m1
      //   69: aload_1
      //   70: invokeinterface 54 3 0
      //   75: goto +15 -> 90
      //   78: astore_1
      //   79: aload_0
      //   80: getfield 24	midas/x/rd$a:c	Lmidas/x/pd;
      //   83: iconst_m1
      //   84: aload_1
      //   85: invokeinterface 54 3 0
      //   90: aload_0
      //   91: getfield 20	midas/x/rd$a:a	Lmidas/x/rd$b;
      //   94: iconst_1
      //   95: invokevirtual 58	android/os/AsyncTask:cancel	(Z)Z
      //   98: pop
      //   99: return
      //   100: aload_0
      //   101: getfield 20	midas/x/rd$a:a	Lmidas/x/rd$b;
      //   104: iconst_1
      //   105: invokevirtual 58	android/os/AsyncTask:cancel	(Z)Z
      //   108: pop
      //   109: aload_1
      //   110: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	111	0	this	a
      //   14	7	1	localObject1	Object
      //   29	1	1	localObject2	Object
      //   33	7	1	localException	Exception
      //   48	7	1	localTimeoutException	java.util.concurrent.TimeoutException
      //   63	7	1	localExecutionException	java.util.concurrent.ExecutionException
      //   78	32	1	localInterruptedException	java.lang.InterruptedException
      // Exception table:
      //   from	to	target	type
      //   0	26	29	finally
      //   34	45	29	finally
      //   49	60	29	finally
      //   64	75	29	finally
      //   79	90	29	finally
      //   0	26	33	java/lang/Exception
      //   0	26	48	java/util/concurrent/TimeoutException
      //   0	26	63	java/util/concurrent/ExecutionException
      //   0	26	78	java/lang/InterruptedException
    }
  }
  
  public static final class b
    extends AsyncTask
  {
    public od a;
    public pd b;
    
    public b(od paramod)
    {
      this.a = paramod;
    }
    
    public b(od paramod, pd parampd)
    {
      this.a = paramod;
      this.b = parampd;
    }
    
    public Object doInBackground(Object[] paramArrayOfObject)
    {
      try
      {
        if (this.a != null)
        {
          paramArrayOfObject = this.a.a(paramArrayOfObject);
          return paramArrayOfObject;
        }
      }
      catch (Exception paramArrayOfObject)
      {
        paramArrayOfObject.printStackTrace();
      }
      return null;
    }
    
    public void onPostExecute(Object paramObject)
    {
      pd localpd = this.b;
      if (localpd != null) {
        localpd.a(0, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.rd
 * JD-Core Version:    0.7.0.1
 */