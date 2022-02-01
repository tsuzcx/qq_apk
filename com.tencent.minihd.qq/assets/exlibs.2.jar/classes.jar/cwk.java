import com.tencent.component.network.module.base.b;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.FutureListener;
import com.tencent.component.network.utils.thread.ThreadPool;
import com.tencent.component.network.utils.thread.ThreadPool.CancelListener;
import com.tencent.component.network.utils.thread.ThreadPool.Job;
import com.tencent.component.network.utils.thread.ThreadPool.JobContext;

public class cwk
  implements Future, ThreadPool.JobContext, Comparable, Runnable
{
  private int jdField_a_of_type_Int;
  private final FutureListener jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFutureListener;
  private ThreadPool.CancelListener jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$CancelListener;
  private final ThreadPool.Job jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$Job;
  private cwj jdField_a_of_type_Cwj;
  private Object jdField_a_of_type_JavaLangObject;
  private volatile boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public cwk(ThreadPool paramThreadPool, ThreadPool.Job paramJob, FutureListener paramFutureListener)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$Job = paramJob;
    this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFutureListener = paramFutureListener;
  }
  
  private cwj a(int paramInt)
  {
    if (paramInt == 1) {
      return this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool.jdField_a_of_type_Cwj;
    }
    if (paramInt == 2) {
      return this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool.b;
    }
    return null;
  }
  
  private void a(cwj paramcwj)
  {
    try
    {
      paramcwj.jdField_a_of_type_Int += 1;
      paramcwj.notifyAll();
      return;
    }
    finally {}
  }
  
  /* Error */
  private boolean a(cwj paramcwj)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	cwk:jdField_a_of_type_Boolean	Z
    //   6: ifeq +12 -> 18
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 55	cwk:jdField_a_of_type_Cwj	Lcwj;
    //   14: aload_0
    //   15: monitorexit
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: aload_1
    //   20: putfield 55	cwk:jdField_a_of_type_Cwj	Lcwj;
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: monitorenter
    //   27: aload_1
    //   28: getfield 46	cwj:jdField_a_of_type_Int	I
    //   31: ifle +31 -> 62
    //   34: aload_1
    //   35: aload_1
    //   36: getfield 46	cwj:jdField_a_of_type_Int	I
    //   39: iconst_1
    //   40: isub
    //   41: putfield 46	cwj:jdField_a_of_type_Int	I
    //   44: aload_1
    //   45: monitorexit
    //   46: aload_0
    //   47: monitorenter
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 55	cwk:jdField_a_of_type_Cwj	Lcwj;
    //   53: aload_0
    //   54: monitorexit
    //   55: iconst_1
    //   56: ireturn
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    //   62: aload_1
    //   63: invokevirtual 58	java/lang/Object:wait	()V
    //   66: aload_1
    //   67: monitorexit
    //   68: goto -68 -> 0
    //   71: astore_2
    //   72: aload_1
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    //   81: astore_2
    //   82: goto -16 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	cwk
    //   0	85	1	paramcwj	cwj
    //   71	4	2	localObject	Object
    //   81	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	16	57	finally
    //   18	25	57	finally
    //   58	60	57	finally
    //   27	46	71	finally
    //   62	66	71	finally
    //   66	68	71	finally
    //   72	74	71	finally
    //   48	55	76	finally
    //   77	79	76	finally
    //   62	66	81	java/lang/InterruptedException
  }
  
  public int a(cwk paramcwk)
  {
    return ((Comparable)this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$Job).compareTo(paramcwk.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$Job);
  }
  
  public Object a()
  {
    try
    {
      for (;;)
      {
        boolean bool = this.b;
        if (bool) {
          break;
        }
        try
        {
          wait();
        }
        catch (Exception localException)
        {
          b.c("Worker", "ignore exception", localException);
        }
      }
      localObject2 = this.jdField_a_of_type_JavaLangObject;
    }
    finally {}
    Object localObject2;
    return localObject2;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 54	cwk:jdField_a_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 54	cwk:jdField_a_of_type_Boolean	Z
    //   19: aload_0
    //   20: getfield 55	cwk:jdField_a_of_type_Cwj	Lcwj;
    //   23: ifnull +19 -> 42
    //   26: aload_0
    //   27: getfield 55	cwk:jdField_a_of_type_Cwj	Lcwj;
    //   30: astore_2
    //   31: aload_2
    //   32: monitorenter
    //   33: aload_0
    //   34: getfield 55	cwk:jdField_a_of_type_Cwj	Lcwj;
    //   37: invokevirtual 49	java/lang/Object:notifyAll	()V
    //   40: aload_2
    //   41: monitorexit
    //   42: aload_0
    //   43: getfield 82	cwk:jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$CancelListener	Lcom/tencent/component/network/utils/thread/ThreadPool$CancelListener;
    //   46: ifnull -35 -> 11
    //   49: aload_0
    //   50: getfield 82	cwk:jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$CancelListener	Lcom/tencent/component/network/utils/thread/ThreadPool$CancelListener;
    //   53: invokeinterface 86 1 0
    //   58: goto -47 -> 11
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    //   66: astore_3
    //   67: aload_2
    //   68: monitorexit
    //   69: aload_3
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	cwk
    //   6	2	1	bool	boolean
    //   61	7	2	localObject1	Object
    //   66	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	61	finally
    //   14	33	61	finally
    //   42	58	61	finally
    //   69	71	61	finally
    //   33	42	66	finally
    //   67	69	66	finally
  }
  
  public void a(ThreadPool.CancelListener paramCancelListener)
  {
    try
    {
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$CancelListener = paramCancelListener;
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$CancelListener != null)) {
        this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$CancelListener.a();
      }
      return;
    }
    finally
    {
      paramCancelListener = finally;
      throw paramCancelListener;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    cwj localcwj = a(this.jdField_a_of_type_Int);
    if (localcwj != null) {
      a(localcwj);
    }
    this.jdField_a_of_type_Int = 0;
    localcwj = a(paramInt);
    if (localcwj != null)
    {
      if (!a(localcwj)) {
        return false;
      }
      this.jdField_a_of_type_Int = paramInt;
    }
    return true;
  }
  
  public void b()
  {
    a();
  }
  
  public boolean b()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFutureListener != null) {
      this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFutureListener.a(this);
    }
    Object localObject4 = null;
    Object localObject1 = localObject4;
    if (a(1)) {}
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadThreadPool$Job.a(this);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          a(0);
          this.jdField_a_of_type_JavaLangObject = localObject1;
          this.b = true;
          notifyAll();
          if (this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFutureListener != null) {
            this.jdField_a_of_type_ComTencentComponentNetworkUtilsThreadFutureListener.b(this);
          }
          return;
        }
        finally {}
        localThrowable = localThrowable;
        b.c("Worker", "Exception in running a job", localThrowable);
        Object localObject2 = localObject4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cwk
 * JD-Core Version:    0.7.0.1
 */