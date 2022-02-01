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
  Handler ZxC;
  final d ZxD;
  HashSet<e> ZxE;
  LinkedList<e> ZxF;
  final LinkedList<c> ZxG;
  c[] ZxH;
  AtomicBoolean isQuit;
  boolean isRunning;
  
  d(d paramd)
  {
    AppMethodBeat.i(183466);
    this.ZxC = com.tencent.e.e.d.a("SerialQueueLeader", this);
    this.isQuit = new AtomicBoolean(false);
    this.isRunning = false;
    this.ZxE = new HashSet();
    this.ZxF = new LinkedList();
    this.ZxG = new LinkedList();
    this.ZxD = paramd;
    AppMethodBeat.o(183466);
  }
  
  private LinkedList<e> iqk()
  {
    AppMethodBeat.i(183474);
    try
    {
      LinkedList localLinkedList = new LinkedList(this.ZxF);
      localLinkedList.addAll(this.ZxE);
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
      if (this.isQuit.get()) {
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
        Message localMessage = this.ZxC.obtainMessage();
        localMessage.obj = parame;
        localMessage.what = 1;
        try
        {
          this.ZxE.add(parame);
          this.ZxC.sendMessageAtTime(localMessage, SystemClock.uptimeMillis() + paramLong);
          return;
        }
        finally {}
      }
      bool = this.ZxF.isEmpty();
    }
    finally
    {
      AppMethodBeat.o(183467);
    }
    boolean bool;
    if ((bool) && (!this.isRunning))
    {
      this.isRunning = true;
      ((d)Objects.requireNonNull(this.ZxD)).a(parame);
      AppMethodBeat.o(183467);
      return;
    }
    if ((bool) || (paramLong == -9223372036854775808L)) {
      this.ZxF.addFirst(parame);
    }
    for (;;)
    {
      AppMethodBeat.o(183467);
      return;
      this.ZxF.addLast(parame);
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
      localIterator = this.ZxE.iterator();
      while (localIterator.hasNext())
      {
        locale = (e)localIterator.next();
        if (paramb.c(locale))
        {
          this.ZxC.removeMessages(1, locale);
          if (!locale.isCancelled()) {
            locale.cancel(false);
          }
          localIterator.remove();
        }
      }
      localIterator = this.ZxF.iterator();
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
      Iterator localIterator = this.ZxE.iterator();
      while (localIterator.hasNext()) {
        if (parama.d((e)localIterator.next())) {
          return true;
        }
      }
      localIterator = this.ZxF.iterator();
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
      this.ZxC.removeMessages(1);
      Iterator localIterator1 = this.ZxF.iterator();
      while (localIterator1.hasNext())
      {
        locale = (e)localIterator1.next();
        if (!locale.isCancelled()) {
          locale.cancel(false);
        }
      }
      this.ZxF.clear();
    }
    finally
    {
      AppMethodBeat.o(183469);
    }
    Iterator localIterator2 = this.ZxE.iterator();
    while (localIterator2.hasNext())
    {
      locale = (e)localIterator2.next();
      if (!locale.isCancelled()) {
        locale.cancel(false);
      }
    }
    this.ZxE.clear();
    AppMethodBeat.o(183469);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(183465);
    if (paramMessage.what == 1) {}
    try
    {
      if (this.ZxE.remove(paramMessage.obj))
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
  
  public final List<String> iqj()
  {
    AppMethodBeat.i(183470);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = iqk().iterator();
    while (localIterator.hasNext()) {
      localLinkedList.add(((e)localIterator.next()).getKey());
    }
    AppMethodBeat.o(183470);
    return localLinkedList;
  }
  
  public final boolean isRunning()
  {
    return this.isRunning;
  }
  
  public final boolean quit()
  {
    AppMethodBeat.i(183473);
    if (this.isQuit.compareAndSet(false, true)) {
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
    int i = this.ZxF.size();
    int j = this.ZxE.size();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.j.d
 * JD-Core Version:    0.7.0.1
 */