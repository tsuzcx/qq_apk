package androidx.core.d;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class c
{
  private Handler.Callback LA;
  final int LB;
  private int mGeneration;
  Handler mHandler;
  final Object mLock;
  private final int mPriority;
  HandlerThread mThread;
  private final String mThreadName;
  
  public c(String paramString)
  {
    AppMethodBeat.i(251161);
    this.mLock = new Object();
    this.LA = new Handler.Callback()
    {
      public final boolean handleMessage(Message arg1)
      {
        AppMethodBeat.i(251100);
        switch (???.what)
        {
        default: 
          AppMethodBeat.o(251100);
          return true;
        case 1: 
          c localc1 = c.this;
          ((Runnable)???.obj).run();
          synchronized (localc1.mLock)
          {
            localc1.mHandler.removeMessages(0);
            localc1.mHandler.sendMessageDelayed(localc1.mHandler.obtainMessage(0), localc1.LB);
            AppMethodBeat.o(251100);
            return true;
          }
        }
        c localc2 = c.this;
        synchronized (localc2.mLock)
        {
          if (localc2.mHandler.hasMessages(1))
          {
            AppMethodBeat.o(251100);
            return true;
          }
          localc2.mThread.quit();
          localc2.mThread = null;
          localc2.mHandler = null;
        }
      }
    };
    this.mThreadName = paramString;
    this.mPriority = 10;
    this.LB = 10000;
    this.mGeneration = 0;
    AppMethodBeat.o(251161);
  }
  
  /* Error */
  public final <T> T a(final Callable<T> paramCallable, int paramInt)
  {
    // Byte code:
    //   0: ldc 64
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 66	java/util/concurrent/locks/ReentrantLock
    //   8: dup
    //   9: invokespecial 67	java/util/concurrent/locks/ReentrantLock:<init>	()V
    //   12: astore 7
    //   14: aload 7
    //   16: invokevirtual 71	java/util/concurrent/locks/ReentrantLock:newCondition	()Ljava/util/concurrent/locks/Condition;
    //   19: astore 8
    //   21: new 73	java/util/concurrent/atomic/AtomicReference
    //   24: dup
    //   25: invokespecial 74	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   28: astore 9
    //   30: new 76	java/util/concurrent/atomic/AtomicBoolean
    //   33: dup
    //   34: iconst_1
    //   35: invokespecial 79	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   38: astore 10
    //   40: aload_0
    //   41: new 12	androidx/core/d/c$3
    //   44: dup
    //   45: aload_0
    //   46: aload 9
    //   48: aload_1
    //   49: aload 7
    //   51: aload 10
    //   53: aload 8
    //   55: invokespecial 82	androidx/core/d/c$3:<init>	(Landroidx/core/d/c;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/Callable;Ljava/util/concurrent/locks/ReentrantLock;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/locks/Condition;)V
    //   58: invokevirtual 86	androidx/core/d/c:post	(Ljava/lang/Runnable;)V
    //   61: aload 7
    //   63: invokevirtual 89	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   66: aload 10
    //   68: invokevirtual 93	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   71: ifne +21 -> 92
    //   74: aload 9
    //   76: invokevirtual 96	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   79: astore_1
    //   80: aload 7
    //   82: invokevirtual 99	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   85: ldc 64
    //   87: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aload_1
    //   91: areturn
    //   92: getstatic 105	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   95: iload_2
    //   96: i2l
    //   97: invokevirtual 109	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   100: lstore_3
    //   101: aload 8
    //   103: lload_3
    //   104: invokeinterface 114 3 0
    //   109: lstore 5
    //   111: aload 10
    //   113: invokevirtual 93	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   116: ifne +21 -> 137
    //   119: aload 9
    //   121: invokevirtual 96	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   124: astore_1
    //   125: aload 7
    //   127: invokevirtual 99	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   130: ldc 64
    //   132: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_1
    //   136: areturn
    //   137: lload 5
    //   139: lstore_3
    //   140: lload 5
    //   142: lconst_0
    //   143: lcmp
    //   144: ifgt -43 -> 101
    //   147: new 63	java/lang/InterruptedException
    //   150: dup
    //   151: ldc 116
    //   153: invokespecial 118	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   156: astore_1
    //   157: ldc 64
    //   159: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aload_1
    //   163: athrow
    //   164: astore_1
    //   165: aload 7
    //   167: invokevirtual 99	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   170: ldc 64
    //   172: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_1
    //   176: athrow
    //   177: astore_1
    //   178: lload_3
    //   179: lstore 5
    //   181: goto -70 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	c
    //   0	184	1	paramCallable	Callable<T>
    //   0	184	2	paramInt	int
    //   100	79	3	l1	long
    //   109	71	5	l2	long
    //   12	154	7	localReentrantLock	ReentrantLock
    //   19	83	8	localCondition	Condition
    //   28	92	9	localAtomicReference	AtomicReference
    //   38	74	10	localAtomicBoolean	AtomicBoolean
    // Exception table:
    //   from	to	target	type
    //   66	80	164	finally
    //   92	101	164	finally
    //   101	111	164	finally
    //   111	125	164	finally
    //   147	164	164	finally
    //   101	111	177	java/lang/InterruptedException
  }
  
  final void post(Runnable paramRunnable)
  {
    AppMethodBeat.i(251162);
    synchronized (this.mLock)
    {
      if (this.mThread == null)
      {
        this.mThread = new HandlerThread(this.mThreadName, this.mPriority);
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper(), this.LA);
        this.mGeneration += 1;
      }
      this.mHandler.removeMessages(0);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramRunnable));
      AppMethodBeat.o(251162);
      return;
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract void C(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.d.c
 * JD-Core Version:    0.7.0.1
 */