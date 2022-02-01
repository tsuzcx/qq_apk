package com.tencent.e.j;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
  implements Handler.Callback
{
  Handler IAj;
  final d IAk;
  HashSet<e> IAl;
  LinkedList<e> IAm;
  final LinkedList<c> IAn;
  c[] IAo;
  AtomicBoolean IyI;
  boolean isRunning;
  
  d(d paramd)
  {
    AppMethodBeat.i(183466);
    this.IAj = com.tencent.e.e.d.a("SerialQueueLeader", this);
    this.IyI = new AtomicBoolean(false);
    this.isRunning = false;
    this.IAl = new HashSet();
    this.IAm = new LinkedList();
    this.IAn = new LinkedList();
    this.IAk = paramd;
    AppMethodBeat.o(183466);
  }
  
  private LinkedList<e> jdMethod_for()
  {
    AppMethodBeat.i(183474);
    try
    {
      LinkedList localLinkedList = new LinkedList(this.IAm);
      localLinkedList.addAll(this.IAl);
      return localLinkedList;
    }
    finally
    {
      AppMethodBeat.o(183474);
    }
  }
  
  /* Error */
  public final void a(long paramLong, e parame)
  {
    // Byte code:
    //   0: ldc 98
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 64	com/tencent/e/j/d:IyI	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   9: invokevirtual 102	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   12: ifeq +9 -> 21
    //   15: ldc 98
    //   17: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: return
    //   21: aload_3
    //   22: ifnonnull +9 -> 31
    //   25: ldc 98
    //   27: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: return
    //   31: lload_1
    //   32: lconst_0
    //   33: lcmp
    //   34: ifle +68 -> 102
    //   37: aload_0
    //   38: getfield 57	com/tencent/e/j/d:IAj	Landroid/os/Handler;
    //   41: invokevirtual 108	android/os/Handler:obtainMessage	()Landroid/os/Message;
    //   44: astore 5
    //   46: aload 5
    //   48: aload_3
    //   49: putfield 114	android/os/Message:obj	Ljava/lang/Object;
    //   52: aload 5
    //   54: iconst_1
    //   55: putfield 118	android/os/Message:what	I
    //   58: aload_0
    //   59: monitorenter
    //   60: aload_0
    //   61: getfield 71	com/tencent/e/j/d:IAl	Ljava/util/HashSet;
    //   64: aload_3
    //   65: invokevirtual 122	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   68: pop
    //   69: aload_0
    //   70: getfield 57	com/tencent/e/j/d:IAj	Landroid/os/Handler;
    //   73: aload 5
    //   75: invokestatic 128	android/os/SystemClock:uptimeMillis	()J
    //   78: lload_1
    //   79: ladd
    //   80: invokevirtual 132	android/os/Handler:sendMessageAtTime	(Landroid/os/Message;J)Z
    //   83: pop
    //   84: aload_0
    //   85: monitorexit
    //   86: ldc 98
    //   88: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: return
    //   92: astore_3
    //   93: aload_0
    //   94: monitorexit
    //   95: ldc 98
    //   97: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: aload_3
    //   101: athrow
    //   102: aload_0
    //   103: monitorenter
    //   104: aload_0
    //   105: getfield 76	com/tencent/e/j/d:IAm	Ljava/util/LinkedList;
    //   108: invokevirtual 135	java/util/LinkedList:isEmpty	()Z
    //   111: istore 4
    //   113: iload 4
    //   115: ifeq +39 -> 154
    //   118: aload_0
    //   119: getfield 66	com/tencent/e/j/d:isRunning	Z
    //   122: ifne +32 -> 154
    //   125: aload_0
    //   126: iconst_1
    //   127: putfield 66	com/tencent/e/j/d:isRunning	Z
    //   130: aload_0
    //   131: getfield 80	com/tencent/e/j/d:IAk	Lcom/tencent/e/j/d$d;
    //   134: invokestatic 141	java/util/Objects:requireNonNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   137: checkcast 17	com/tencent/e/j/d$d
    //   140: aload_3
    //   141: invokeinterface 144 2 0
    //   146: aload_0
    //   147: monitorexit
    //   148: ldc 98
    //   150: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: return
    //   154: iload 4
    //   156: ifne +11 -> 167
    //   159: lload_1
    //   160: ldc2_w 145
    //   163: lcmp
    //   164: ifne +19 -> 183
    //   167: aload_0
    //   168: getfield 76	com/tencent/e/j/d:IAm	Ljava/util/LinkedList;
    //   171: aload_3
    //   172: invokevirtual 150	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   175: aload_0
    //   176: monitorexit
    //   177: ldc 98
    //   179: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: return
    //   183: aload_0
    //   184: getfield 76	com/tencent/e/j/d:IAm	Ljava/util/LinkedList;
    //   187: aload_3
    //   188: invokevirtual 153	java/util/LinkedList:addLast	(Ljava/lang/Object;)V
    //   191: goto -16 -> 175
    //   194: astore_3
    //   195: aload_0
    //   196: monitorexit
    //   197: ldc 98
    //   199: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_3
    //   203: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	d
    //   0	204	1	paramLong	long
    //   0	204	3	parame	e
    //   111	44	4	bool	boolean
    //   44	30	5	localMessage	Message
    // Exception table:
    //   from	to	target	type
    //   60	86	92	finally
    //   93	95	92	finally
    //   104	113	194	finally
    //   118	148	194	finally
    //   167	175	194	finally
    //   175	177	194	finally
    //   183	191	194	finally
    //   195	197	194	finally
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(183471);
    Objects.requireNonNull(paramb);
    Iterator localIterator;
    e locale;
    try
    {
      localIterator = this.IAl.iterator();
      while (localIterator.hasNext())
      {
        locale = (e)localIterator.next();
        if (paramb.c(locale))
        {
          this.IAj.removeMessages(1, locale);
          if (!locale.isCancelled()) {
            locale.cancel(false);
          }
          localIterator.remove();
        }
      }
      localIterator = this.IAm.iterator();
    }
    finally
    {
      AppMethodBeat.o(183471);
    }
    while (localIterator.hasNext())
    {
      locale = (e)localIterator.next();
      if (paramb.c(locale))
      {
        if (!locale.isCancelled()) {
          locale.cancel(false);
        }
        localIterator.remove();
      }
    }
    AppMethodBeat.o(183471);
  }
  
  final boolean a(a parama)
  {
    AppMethodBeat.i(183472);
    try
    {
      Iterator localIterator = this.IAl.iterator();
      while (localIterator.hasNext()) {
        if (parama.d((e)localIterator.next())) {
          return true;
        }
      }
      localIterator = this.IAm.iterator();
      while (localIterator.hasNext()) {
        if (parama.d((e)localIterator.next())) {
          return true;
        }
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(183472);
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(183469);
    e locale;
    try
    {
      this.IAj.removeMessages(1);
      Iterator localIterator1 = this.IAm.iterator();
      while (localIterator1.hasNext())
      {
        locale = (e)localIterator1.next();
        if (!locale.isCancelled()) {
          locale.cancel(false);
        }
      }
      this.IAm.clear();
    }
    finally
    {
      AppMethodBeat.o(183469);
    }
    Iterator localIterator2 = this.IAl.iterator();
    while (localIterator2.hasNext())
    {
      locale = (e)localIterator2.next();
      if (!locale.isCancelled()) {
        locale.cancel(false);
      }
    }
    this.IAl.clear();
    AppMethodBeat.o(183469);
  }
  
  public final List<String> foq()
  {
    AppMethodBeat.i(183470);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = jdMethod_for().iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((e)localIterator.next()).getKey());
    }
    AppMethodBeat.o(183470);
    return localLinkedList;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(183465);
    if (paramMessage.what == 1) {}
    try
    {
      if (this.IAl.remove(paramMessage.obj))
      {
        a(0L, (e)paramMessage.obj);
        return true;
      }
      return false;
    }
    finally
    {
      AppMethodBeat.o(183465);
    }
  }
  
  public final boolean isRunning()
  {
    return this.isRunning;
  }
  
  public final boolean quit()
  {
    AppMethodBeat.i(183473);
    if (this.IyI.compareAndSet(false, true)) {
      try
      {
        clear();
        this.isRunning = false;
        return true;
      }
      finally
      {
        AppMethodBeat.o(183473);
      }
    }
    AppMethodBeat.o(183473);
    return false;
  }
  
  public final int size()
  {
    AppMethodBeat.i(183468);
    int i = this.IAm.size();
    int j = this.IAl.size();
    AppMethodBeat.o(183468);
    return i + j;
  }
  
  public static abstract interface a
  {
    public abstract boolean d(e parame);
  }
  
  public static abstract interface b
  {
    public abstract boolean c(e parame);
  }
  
  public static abstract interface c
    extends MessageQueue.IdleHandler
  {}
  
  public static abstract interface d
  {
    public abstract void a(e parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.j.d
 * JD-Core Version:    0.7.0.1
 */