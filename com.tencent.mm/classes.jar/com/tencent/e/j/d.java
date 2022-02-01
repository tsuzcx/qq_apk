package com.tencent.e.j;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
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
  AtomicBoolean Mrj;
  Handler MsJ;
  final d MsK;
  HashSet<e> MsL;
  LinkedList<e> MsM;
  final LinkedList<c> MsN;
  c[] MsO;
  boolean isRunning;
  
  d(d paramd)
  {
    AppMethodBeat.i(183466);
    this.MsJ = com.tencent.e.e.d.a("SerialQueueLeader", this);
    this.Mrj = new AtomicBoolean(false);
    this.isRunning = false;
    this.MsL = new HashSet();
    this.MsM = new LinkedList();
    this.MsN = new LinkedList();
    this.MsK = paramd;
    AppMethodBeat.o(183466);
  }
  
  private LinkedList<e> gay()
  {
    AppMethodBeat.i(183474);
    try
    {
      LinkedList localLinkedList = new LinkedList(this.MsM);
      localLinkedList.addAll(this.MsL);
      return localLinkedList;
    }
    finally
    {
      AppMethodBeat.o(183474);
    }
  }
  
  public final void a(long paramLong, e parame)
  {
    AppMethodBeat.i(183467);
    try
    {
      if (this.Mrj.get()) {
        return;
      }
      if (parame == null) {
        return;
      }
      if (parame.isCancelled()) {
        return;
      }
      if (paramLong > 0L)
      {
        Message localMessage = this.MsJ.obtainMessage();
        localMessage.obj = parame;
        localMessage.what = 1;
        try
        {
          this.MsL.add(parame);
          this.MsJ.sendMessageAtTime(localMessage, SystemClock.uptimeMillis() + paramLong);
          return;
        }
        finally {}
      }
      bool = this.MsM.isEmpty();
    }
    finally
    {
      AppMethodBeat.o(183467);
    }
    boolean bool;
    if ((bool) && (!this.isRunning))
    {
      this.isRunning = true;
      ((d)Objects.requireNonNull(this.MsK)).a(parame);
      AppMethodBeat.o(183467);
      return;
    }
    if ((bool) || (paramLong == -9223372036854775808L)) {
      this.MsM.addFirst(parame);
    }
    for (;;)
    {
      AppMethodBeat.o(183467);
      return;
      this.MsM.addLast(parame);
    }
  }
  
  final void a(b paramb)
  {
    AppMethodBeat.i(183471);
    Objects.requireNonNull(paramb);
    Iterator localIterator;
    e locale;
    try
    {
      localIterator = this.MsL.iterator();
      while (localIterator.hasNext())
      {
        locale = (e)localIterator.next();
        if (paramb.c(locale))
        {
          this.MsJ.removeMessages(1, locale);
          if (!locale.isCancelled()) {
            locale.cancel(false);
          }
          localIterator.remove();
        }
      }
      localIterator = this.MsM.iterator();
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
      Iterator localIterator = this.MsL.iterator();
      while (localIterator.hasNext()) {
        if (parama.d((e)localIterator.next())) {
          return true;
        }
      }
      localIterator = this.MsM.iterator();
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
      this.MsJ.removeMessages(1);
      Iterator localIterator1 = this.MsM.iterator();
      while (localIterator1.hasNext())
      {
        locale = (e)localIterator1.next();
        if (!locale.isCancelled()) {
          locale.cancel(false);
        }
      }
      this.MsM.clear();
    }
    finally
    {
      AppMethodBeat.o(183469);
    }
    Iterator localIterator2 = this.MsL.iterator();
    while (localIterator2.hasNext())
    {
      locale = (e)localIterator2.next();
      if (!locale.isCancelled()) {
        locale.cancel(false);
      }
    }
    this.MsL.clear();
    AppMethodBeat.o(183469);
  }
  
  public final List<String> gax()
  {
    AppMethodBeat.i(183470);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = gay().iterator();
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
      if (this.MsL.remove(paramMessage.obj))
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
    if (this.Mrj.compareAndSet(false, true)) {
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
    int i = this.MsM.size();
    int j = this.MsL.size();
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