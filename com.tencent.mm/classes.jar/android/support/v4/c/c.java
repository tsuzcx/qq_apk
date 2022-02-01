package android.support.v4.c;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class c
{
  private Handler.Callback NI = new Handler.Callback()
  {
    public final boolean handleMessage(Message arg1)
    {
      switch (???.what)
      {
      default: 
        return true;
      case 1: 
        c localc1 = c.this;
        ((Runnable)???.obj).run();
        synchronized (localc1.mLock)
        {
          localc1.mHandler.removeMessages(0);
          localc1.mHandler.sendMessageDelayed(localc1.mHandler.obtainMessage(0), localc1.NJ);
          return true;
        }
      }
      c localc2 = c.this;
      synchronized (localc2.mLock)
      {
        if (localc2.mHandler.hasMessages(1)) {
          return true;
        }
      }
      localObject2.mThread.quit();
      localObject2.mThread = null;
      localObject2.mHandler = null;
      return true;
    }
  };
  final int NJ;
  private int mGeneration;
  Handler mHandler;
  final Object mLock = new Object();
  private final int mPriority;
  HandlerThread mThread;
  private final String mThreadName;
  
  public c(String paramString)
  {
    this.mThreadName = paramString;
    this.mPriority = 10;
    this.NJ = 10000;
    this.mGeneration = 0;
  }
  
  /* Error */
  public final <T> T a(final Callable<T> paramCallable, int paramInt)
  {
    // Byte code:
    //   0: new 55	java/util/concurrent/locks/ReentrantLock
    //   3: dup
    //   4: invokespecial 56	java/util/concurrent/locks/ReentrantLock:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: invokevirtual 60	java/util/concurrent/locks/ReentrantLock:newCondition	()Ljava/util/concurrent/locks/Condition;
    //   14: astore 8
    //   16: new 62	java/util/concurrent/atomic/AtomicReference
    //   19: dup
    //   20: invokespecial 63	java/util/concurrent/atomic/AtomicReference:<init>	()V
    //   23: astore 9
    //   25: new 65	java/util/concurrent/atomic/AtomicBoolean
    //   28: dup
    //   29: iconst_1
    //   30: invokespecial 68	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   33: astore 10
    //   35: aload_0
    //   36: new 12	android/support/v4/c/c$3
    //   39: dup
    //   40: aload_0
    //   41: aload 9
    //   43: aload_1
    //   44: aload 7
    //   46: aload 10
    //   48: aload 8
    //   50: invokespecial 71	android/support/v4/c/c$3:<init>	(Landroid/support/v4/c/c;Ljava/util/concurrent/atomic/AtomicReference;Ljava/util/concurrent/Callable;Ljava/util/concurrent/locks/ReentrantLock;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/util/concurrent/locks/Condition;)V
    //   53: invokevirtual 75	android/support/v4/c/c:post	(Ljava/lang/Runnable;)V
    //   56: aload 7
    //   58: invokevirtual 78	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   61: aload 10
    //   63: invokevirtual 82	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   66: ifne +16 -> 82
    //   69: aload 9
    //   71: invokevirtual 85	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   74: astore_1
    //   75: aload 7
    //   77: invokevirtual 88	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   80: aload_1
    //   81: areturn
    //   82: getstatic 94	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   85: iload_2
    //   86: i2l
    //   87: invokevirtual 98	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   90: lstore_3
    //   91: aload 8
    //   93: lload_3
    //   94: invokeinterface 103 3 0
    //   99: lstore 5
    //   101: aload 10
    //   103: invokevirtual 82	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   106: ifne +16 -> 122
    //   109: aload 9
    //   111: invokevirtual 85	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   114: astore_1
    //   115: aload 7
    //   117: invokevirtual 88	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   120: aload_1
    //   121: areturn
    //   122: lload 5
    //   124: lstore_3
    //   125: lload 5
    //   127: lconst_0
    //   128: lcmp
    //   129: ifgt -38 -> 91
    //   132: new 53	java/lang/InterruptedException
    //   135: dup
    //   136: ldc 105
    //   138: invokespecial 107	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   141: athrow
    //   142: astore_1
    //   143: aload 7
    //   145: invokevirtual 88	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   148: aload_1
    //   149: athrow
    //   150: astore_1
    //   151: lload_3
    //   152: lstore 5
    //   154: goto -53 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	c
    //   0	157	1	paramCallable	Callable<T>
    //   0	157	2	paramInt	int
    //   90	62	3	l1	long
    //   99	54	5	l2	long
    //   7	137	7	localReentrantLock	ReentrantLock
    //   14	78	8	localCondition	Condition
    //   23	87	9	localAtomicReference	AtomicReference
    //   33	69	10	localAtomicBoolean	AtomicBoolean
    // Exception table:
    //   from	to	target	type
    //   61	75	142	finally
    //   82	91	142	finally
    //   91	101	142	finally
    //   101	115	142	finally
    //   132	142	142	finally
    //   91	101	150	java/lang/InterruptedException
  }
  
  final void post(Runnable paramRunnable)
  {
    synchronized (this.mLock)
    {
      if (this.mThread == null)
      {
        this.mThread = new HandlerThread(this.mThreadName, this.mPriority);
        this.mThread.start();
        this.mHandler = new Handler(this.mThread.getLooper(), this.NI);
        this.mGeneration += 1;
      }
      this.mHandler.removeMessages(0);
      this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramRunnable));
      return;
    }
  }
  
  public static abstract interface a<T>
  {
    public abstract void D(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.c.c
 * JD-Core Version:    0.7.0.1
 */