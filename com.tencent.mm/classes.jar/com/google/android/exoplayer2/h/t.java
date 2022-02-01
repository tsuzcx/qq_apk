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
  IOException bhg;
  final ExecutorService bpk;
  b<? extends c> bpl;
  
  public t(String paramString)
  {
    AppMethodBeat.i(93096);
    this.bpk = x.bP(paramString);
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
    if (this.bpl != null)
    {
      this.bpl.cancel(true);
      bool1 = bool2;
      if (paramd != null)
      {
        this.bpk.execute(new e(paramd));
        bool1 = bool2;
      }
    }
    for (;;)
    {
      this.bpk.shutdown();
      AppMethodBeat.o(93099);
      return bool1;
      bool1 = bool2;
      if (paramd != null)
      {
        paramd.tt();
        bool1 = true;
      }
    }
  }
  
  public final void cancelLoading()
  {
    AppMethodBeat.i(93098);
    this.bpl.cancel(false);
    AppMethodBeat.o(93098);
  }
  
  public final boolean isLoading()
  {
    return this.bpl != null;
  }
  
  public final void uO()
  {
    AppMethodBeat.i(199984);
    if (this.bhg != null)
    {
      IOException localIOException = this.bhg;
      AppMethodBeat.o(199984);
      throw localIOException;
    }
    if (this.bpl != null) {
      this.bpl.fr(this.bpl.bpo);
    }
    AppMethodBeat.o(199984);
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
    private final T bpm;
    private final t.a<T> bpn;
    public final int bpo;
    private IOException bpp;
    private int bpq;
    private volatile Thread bpr;
    private volatile boolean released;
    private final long startTimeMs;
    
    public b(T paramT, t.a<T> parama, int paramInt, long paramLong)
    {
      super();
      this.bpm = parama;
      this.bpn = paramInt;
      this.bpo = paramLong;
      Object localObject;
      this.startTimeMs = localObject;
    }
    
    private void execute()
    {
      AppMethodBeat.i(93092);
      this.bpp = null;
      t.this.bpk.execute(t.this.bpl);
      AppMethodBeat.o(93092);
    }
    
    private void finish()
    {
      t.this.bpl = null;
    }
    
    public final void cancel(boolean paramBoolean)
    {
      AppMethodBeat.i(93089);
      this.released = paramBoolean;
      this.bpp = null;
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
          this.bpn.a(this.bpm, l, l - this.startTimeMs, true);
        }
        AppMethodBeat.o(93089);
        return;
        this.bpm.ty();
        if (this.bpr != null) {
          this.bpr.interrupt();
        }
      }
    }
    
    public final void fr(int paramInt)
    {
      if ((this.bpp != null) && (this.bpq > paramInt)) {
        throw this.bpp;
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
      if (this.bpm.tz())
      {
        this.bpn.a(this.bpm, l1, l2, false);
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
        this.bpn.a(this.bpm, l1, l2, false);
        AppMethodBeat.o(93091);
        return;
        this.bpn.a(this.bpm, l1, l2);
        AppMethodBeat.o(93091);
        return;
        this.bpp = ((IOException)paramMessage.obj);
        i = this.bpn.a(this.bpm, l1, l2, this.bpp);
        if (i == 3)
        {
          t.this.bhg = this.bpp;
          AppMethodBeat.o(93091);
          return;
        }
      } while (i == 2);
      if (i == 1) {}
      for (int i = 1;; i = this.bpq + 1)
      {
        this.bpq = i;
        start(Math.min((this.bpq - 1) * 1000, 5000));
        break;
      }
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 171
      //   2: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokestatic 175	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   9: putfield 114	com/google/android/exoplayer2/h/t$b:bpr	Ljava/lang/Thread;
      //   12: aload_0
      //   13: getfield 41	com/google/android/exoplayer2/h/t$b:bpm	Lcom/google/android/exoplayer2/h/t$c;
      //   16: invokeinterface 142 1 0
      //   21: ifne +43 -> 64
      //   24: new 177	java/lang/StringBuilder
      //   27: dup
      //   28: ldc 179
      //   30: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   33: aload_0
      //   34: getfield 41	com/google/android/exoplayer2/h/t$b:bpm	Lcom/google/android/exoplayer2/h/t$c;
      //   37: invokevirtual 188	java/lang/Object:getClass	()Ljava/lang/Class;
      //   40: invokevirtual 194	java/lang/Class:getSimpleName	()Ljava/lang/String;
      //   43: invokevirtual 198	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   46: invokevirtual 201	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   49: invokestatic 206	com/google/android/exoplayer2/i/v:D	(Ljava/lang/String;)V
      //   52: aload_0
      //   53: getfield 41	com/google/android/exoplayer2/h/t$b:bpm	Lcom/google/android/exoplayer2/h/t$c;
      //   56: invokeinterface 209 1 0
      //   61: invokestatic 212	com/google/android/exoplayer2/i/v:gH	()V
      //   64: aload_0
      //   65: getfield 83	com/google/android/exoplayer2/h/t$b:released	Z
      //   68: ifne +9 -> 77
      //   71: aload_0
      //   72: iconst_2
      //   73: invokevirtual 93	com/google/android/exoplayer2/h/t$b:sendEmptyMessage	(I)Z
      //   76: pop
      //   77: ldc 171
      //   79: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   82: return
      //   83: astore_1
      //   84: invokestatic 212	com/google/android/exoplayer2/i/v:gH	()V
      //   87: ldc 171
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
      //   105: invokevirtual 216	com/google/android/exoplayer2/h/t$b:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   108: invokevirtual 219	android/os/Message:sendToTarget	()V
      //   111: ldc 171
      //   113: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   116: return
      //   117: astore_1
      //   118: aload_0
      //   119: getfield 41	com/google/android/exoplayer2/h/t$b:bpm	Lcom/google/android/exoplayer2/h/t$c;
      //   122: invokeinterface 142 1 0
      //   127: invokestatic 224	com/google/android/exoplayer2/i/a:checkState	(Z)V
      //   130: aload_0
      //   131: getfield 83	com/google/android/exoplayer2/h/t$b:released	Z
      //   134: ifne +9 -> 143
      //   137: aload_0
      //   138: iconst_2
      //   139: invokevirtual 93	com/google/android/exoplayer2/h/t$b:sendEmptyMessage	(I)Z
      //   142: pop
      //   143: ldc 171
      //   145: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   148: return
      //   149: astore_1
      //   150: aload_0
      //   151: getfield 83	com/google/android/exoplayer2/h/t$b:released	Z
      //   154: ifne +19 -> 173
      //   157: aload_0
      //   158: iconst_3
      //   159: new 226	com/google/android/exoplayer2/h/t$f
      //   162: dup
      //   163: aload_1
      //   164: invokespecial 229	com/google/android/exoplayer2/h/t$f:<init>	(Ljava/lang/Throwable;)V
      //   167: invokevirtual 216	com/google/android/exoplayer2/h/t$b:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   170: invokevirtual 219	android/os/Message:sendToTarget	()V
      //   173: ldc 171
      //   175: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   178: return
      //   179: astore_1
      //   180: aload_0
      //   181: getfield 83	com/google/android/exoplayer2/h/t$b:released	Z
      //   184: ifne +19 -> 203
      //   187: aload_0
      //   188: iconst_3
      //   189: new 226	com/google/android/exoplayer2/h/t$f
      //   192: dup
      //   193: aload_1
      //   194: invokespecial 229	com/google/android/exoplayer2/h/t$f:<init>	(Ljava/lang/Throwable;)V
      //   197: invokevirtual 216	com/google/android/exoplayer2/h/t$b:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   200: invokevirtual 219	android/os/Message:sendToTarget	()V
      //   203: ldc 171
      //   205: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   208: return
      //   209: astore_1
      //   210: aload_0
      //   211: getfield 83	com/google/android/exoplayer2/h/t$b:released	Z
      //   214: ifne +12 -> 226
      //   217: aload_0
      //   218: iconst_4
      //   219: aload_1
      //   220: invokevirtual 216	com/google/android/exoplayer2/h/t$b:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
      //   223: invokevirtual 219	android/os/Message:sendToTarget	()V
      //   226: ldc 171
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
      if (t.this.bpl == null) {}
      for (boolean bool = true;; bool = false)
      {
        a.checkState(bool);
        t.this.bpl = this;
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
    public abstract void tA();
    
    public abstract void ty();
    
    public abstract boolean tz();
  }
  
  public static abstract interface d
  {
    public abstract void tt();
  }
  
  static final class e
    extends Handler
    implements Runnable
  {
    private final t.d bpt;
    
    public e(t.d paramd)
    {
      this.bpt = paramd;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(93094);
      this.bpt.tt();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.t
 * JD-Core Version:    0.7.0.1
 */