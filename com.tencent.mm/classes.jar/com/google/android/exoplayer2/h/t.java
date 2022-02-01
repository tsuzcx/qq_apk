package com.google.android.exoplayer2.h;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class t
{
  final ExecutorService bFG;
  b<? extends c> bFH;
  IOException bxE;
  
  public t(String paramString)
  {
    AppMethodBeat.i(93096);
    this.bFG = x.bE(paramString);
    AppMethodBeat.o(93096);
  }
  
  public final <T extends c> long a(T paramT, a<T> parama, int paramInt)
  {
    AppMethodBeat.i(93097);
    Looper localLooper = Looper.myLooper();
    if (localLooper != null) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      long l = SystemClock.elapsedRealtime();
      new b(localLooper, paramT, parama, paramInt, l).start(0L);
      AppMethodBeat.o(93097);
      return l;
    }
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(93099);
    boolean bool2 = false;
    boolean bool1;
    if (this.bFH != null)
    {
      this.bFH.cancel(true);
      bool1 = bool2;
      if (paramd != null)
      {
        this.bFG.execute(new e(paramd));
        bool1 = bool2;
      }
    }
    for (;;)
    {
      this.bFG.shutdown();
      AppMethodBeat.o(93099);
      return bool1;
      bool1 = bool2;
      if (paramd != null)
      {
        paramd.vv();
        bool1 = true;
      }
    }
  }
  
  public final void cancelLoading()
  {
    AppMethodBeat.i(93098);
    this.bFH.cancel(false);
    AppMethodBeat.o(93098);
  }
  
  public final boolean isLoading()
  {
    return this.bFH != null;
  }
  
  public static abstract interface a<T extends t.c>
  {
    public abstract int a(T paramT, long paramLong1, long paramLong2, IOException paramIOException);
    
    public abstract void a(T paramT, long paramLong1, long paramLong2);
    
    public abstract void a(T paramT, long paramLong1, long paramLong2, boolean paramBoolean);
  }
  
  @SuppressLint({"HandlerLeak"})
  final class b<T extends t.c>
    extends Handler
    implements Runnable
  {
    private final T bFI;
    private final t.a<T> bFJ;
    public final int bFK;
    private IOException bFL;
    private int bFM;
    private volatile Thread bFN;
    private volatile boolean released;
    private final long startTimeMs;
    
    public b(T paramT, t.a<T> parama, int paramInt, long paramLong)
    {
      super();
      this.bFI = parama;
      this.bFJ = paramInt;
      this.bFK = paramLong;
      Object localObject;
      this.startTimeMs = localObject;
    }
    
    private void execute()
    {
      AppMethodBeat.i(93092);
      this.bFL = null;
      t.this.bFG.execute(t.this.bFH);
      AppMethodBeat.o(93092);
    }
    
    private void finish()
    {
      t.this.bFH = null;
    }
    
    public final void cancel(boolean paramBoolean)
    {
      AppMethodBeat.i(93089);
      this.released = paramBoolean;
      this.bFL = null;
      if (hasMessages(0))
      {
        removeMessages(0);
        if (!paramBoolean) {
          sendEmptyMessage(1);
        }
      }
      for (;;)
      {
        if (paramBoolean)
        {
          finish();
          long l = SystemClock.elapsedRealtime();
          this.bFJ.a(this.bFI, l, l - this.startTimeMs, true);
        }
        AppMethodBeat.o(93089);
        return;
        this.bFI.vA();
        if (this.bFN != null) {
          this.bFN.interrupt();
        }
      }
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(93091);
      if (this.released)
      {
        AppMethodBeat.o(93091);
        return;
      }
      if (paramMessage.what == 0)
      {
        execute();
        AppMethodBeat.o(93091);
        return;
      }
      if (paramMessage.what == 4)
      {
        paramMessage = (Error)paramMessage.obj;
        AppMethodBeat.o(93091);
        throw paramMessage;
      }
      finish();
      long l1 = SystemClock.elapsedRealtime();
      long l2 = l1 - this.startTimeMs;
      if (this.bFI.vB())
      {
        this.bFJ.a(this.bFI, l1, l2, false);
        AppMethodBeat.o(93091);
        return;
      }
      switch (paramMessage.what)
      {
      }
      do
      {
        AppMethodBeat.o(93091);
        return;
        this.bFJ.a(this.bFI, l1, l2, false);
        AppMethodBeat.o(93091);
        return;
        this.bFJ.a(this.bFI, l1, l2);
        AppMethodBeat.o(93091);
        return;
        this.bFL = ((IOException)paramMessage.obj);
        i = this.bFJ.a(this.bFI, l1, l2, this.bFL);
        if (i == 3)
        {
          t.this.bxE = this.bFL;
          AppMethodBeat.o(93091);
          return;
        }
      } while (i == 2);
      if (i == 1) {}
      for (int i = 1;; i = this.bFM + 1)
      {
        this.bFM = i;
        start(Math.min((this.bFM - 1) * 1000, 5000));
        break;
      }
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 170
      //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokestatic 174	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   9: putfield 114	com/google/android/exoplayer2/h/t$b:bFN	Ljava/lang/Thread;
      //   12: aload_0
      //   13: getfield 41	com/google/android/exoplayer2/h/t$b:bFI	Lcom/google/android/exoplayer2/h/t$c;
      //   16: invokeinterface 139 1 0
      //   21: ifne +43 -> 64
      //   24: new 176	java/lang/StringBuilder
      //   27: dup
      //   28: ldc 178
      //   30: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   33: aload_0
      //   34: getfield 41	com/google/android/exoplayer2/h/t$b:bFI	Lcom/google/android/exoplayer2/h/t$c;
      //   37: invokevirtual 187	java/lang/Object:getClass	()Ljava/lang/Class;
      //   40: invokevirtual 193	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   43: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   46: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   49: invokestatic 205	com/google/android/exoplayer2/i/v:beginSection	(Ljava/lang/String;)V
      //   52: aload_0
      //   53: getfield 41	com/google/android/exoplayer2/h/t$b:bFI	Lcom/google/android/exoplayer2/h/t$c;
      //   56: invokeinterface 208 1 0
      //   61: invokestatic 211	com/google/android/exoplayer2/i/v:endSection	()V
      //   64: aload_0
      //   65: getfield 83	com/google/android/exoplayer2/h/t$b:released	Z
      //   68: ifne +9 -> 77
      //   71: aload_0
      //   72: iconst_2
      //   73: invokevirtual 93	com/google/android/exoplayer2/h/t$b:sendEmptyMessage	(I)Z
      //   76: pop
      //   77: ldc 170
      //   79: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   82: return
      //   83: astore_1
      //   84: invokestatic 211	com/google/android/exoplayer2/i/v:endSection	()V
      //   87: ldc 170
      //   89: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   92: aload_1
      //   93: athrow
      //   94: astore_1
      //   95: aload_0
      //   96: getfield 83	com/google/android/exoplayer2/h/t$b:released	Z
      //   99: ifne +12 -> 111
      //   102: aload_0
      //   103: iconst_3
      //   104: aload_1
      //   105: invokevirtual 215	com/google/android/exoplayer2/h/t$b:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   108: invokevirtual 218	android/os/Message:sendToTarget	()V
      //   111: ldc 170
      //   113: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   116: return
      //   117: astore_1
      //   118: aload_0
      //   119: getfield 41	com/google/android/exoplayer2/h/t$b:bFI	Lcom/google/android/exoplayer2/h/t$c;
      //   122: invokeinterface 139 1 0
      //   127: invokestatic 223	com/google/android/exoplayer2/i/a:checkState	(Z)V
      //   130: aload_0
      //   131: getfield 83	com/google/android/exoplayer2/h/t$b:released	Z
      //   134: ifne +9 -> 143
      //   137: aload_0
      //   138: iconst_2
      //   139: invokevirtual 93	com/google/android/exoplayer2/h/t$b:sendEmptyMessage	(I)Z
      //   142: pop
      //   143: ldc 170
      //   145: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   148: return
      //   149: astore_1
      //   150: aload_0
      //   151: getfield 83	com/google/android/exoplayer2/h/t$b:released	Z
      //   154: ifne +19 -> 173
      //   157: aload_0
      //   158: iconst_3
      //   159: new 225	com/google/android/exoplayer2/h/t$f
      //   162: dup
      //   163: aload_1
      //   164: invokespecial 228	com/google/android/exoplayer2/h/t$f:<init>	(Ljava/lang/Throwable;)V
      //   167: invokevirtual 215	com/google/android/exoplayer2/h/t$b:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   170: invokevirtual 218	android/os/Message:sendToTarget	()V
      //   173: ldc 170
      //   175: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   178: return
      //   179: astore_1
      //   180: aload_0
      //   181: getfield 83	com/google/android/exoplayer2/h/t$b:released	Z
      //   184: ifne +19 -> 203
      //   187: aload_0
      //   188: iconst_3
      //   189: new 225	com/google/android/exoplayer2/h/t$f
      //   192: dup
      //   193: aload_1
      //   194: invokespecial 228	com/google/android/exoplayer2/h/t$f:<init>	(Ljava/lang/Throwable;)V
      //   197: invokevirtual 215	com/google/android/exoplayer2/h/t$b:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   200: invokevirtual 218	android/os/Message:sendToTarget	()V
      //   203: ldc 170
      //   205: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   208: return
      //   209: astore_1
      //   210: aload_0
      //   211: getfield 83	com/google/android/exoplayer2/h/t$b:released	Z
      //   214: ifne +12 -> 226
      //   217: aload_0
      //   218: iconst_4
      //   219: aload_1
      //   220: invokevirtual 215	com/google/android/exoplayer2/h/t$b:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   223: invokevirtual 218	android/os/Message:sendToTarget	()V
      //   226: ldc 170
      //   228: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   231: aload_1
      //   232: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	233	0	this	b
      //   83	10	1	localObject	Object
      //   94	11	1	localIOException	IOException
      //   117	1	1	localInterruptedException	java.lang.InterruptedException
      //   149	15	1	localException	java.lang.Exception
      //   179	15	1	localOutOfMemoryError	java.lang.OutOfMemoryError
      //   209	23	1	localError	Error
      // Exception table:
      //   from	to	target	type
      //   52	61	83	finally
      //   5	52	94	java/io/IOException
      //   61	64	94	java/io/IOException
      //   64	77	94	java/io/IOException
      //   84	94	94	java/io/IOException
      //   5	52	117	java/lang/InterruptedException
      //   61	64	117	java/lang/InterruptedException
      //   64	77	117	java/lang/InterruptedException
      //   84	94	117	java/lang/InterruptedException
      //   5	52	149	java/lang/Exception
      //   61	64	149	java/lang/Exception
      //   64	77	149	java/lang/Exception
      //   84	94	149	java/lang/Exception
      //   5	52	179	java/lang/OutOfMemoryError
      //   61	64	179	java/lang/OutOfMemoryError
      //   64	77	179	java/lang/OutOfMemoryError
      //   84	94	179	java/lang/OutOfMemoryError
      //   5	52	209	java/lang/Error
      //   61	64	209	java/lang/Error
      //   64	77	209	java/lang/Error
      //   84	94	209	java/lang/Error
    }
    
    public final void start(long paramLong)
    {
      AppMethodBeat.i(93088);
      if (t.this.bFH == null) {}
      for (boolean bool = true;; bool = false)
      {
        a.checkState(bool);
        t.this.bFH = this;
        if (paramLong <= 0L) {
          break;
        }
        sendEmptyMessageDelayed(0, paramLong);
        AppMethodBeat.o(93088);
        return;
      }
      execute();
      AppMethodBeat.o(93088);
    }
  }
  
  public static abstract interface c
  {
    public abstract void vA();
    
    public abstract boolean vB();
    
    public abstract void vC();
  }
  
  public static abstract interface d
  {
    public abstract void vv();
  }
  
  static final class e
    extends Handler
    implements Runnable
  {
    private final t.d bFP;
    
    public e(t.d paramd)
    {
      this.bFP = paramd;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(93094);
      this.bFP.vv();
      AppMethodBeat.o(93094);
    }
    
    public final void run()
    {
      AppMethodBeat.i(93093);
      sendEmptyMessage(0);
      AppMethodBeat.o(93093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.h.t
 * JD-Core Version:    0.7.0.1
 */