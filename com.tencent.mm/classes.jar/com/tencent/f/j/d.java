package com.tencent.f.j;

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
  Handler RVa;
  final d RVb;
  HashSet<e> RVc;
  LinkedList<e> RVd;
  final LinkedList<c> RVe;
  c[] RVf;
  AtomicBoolean isQuit;
  boolean isRunning;
  
  d(d paramd)
  {
    AppMethodBeat.i(183466);
    this.RVa = com.tencent.f.e.d.a("SerialQueueLeader", this);
    this.isQuit = new AtomicBoolean(false);
    this.isRunning = false;
    this.RVc = new HashSet();
    this.RVd = new LinkedList();
    this.RVe = new LinkedList();
    this.RVb = paramd;
    AppMethodBeat.o(183466);
  }
  
  private LinkedList<e> hmJ()
  {
    AppMethodBeat.i(183474);
    try
    {
      LinkedList localLinkedList = new LinkedList(this.RVd);
      localLinkedList.addAll(this.RVc);
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
        Message localMessage = this.RVa.obtainMessage();
        localMessage.obj = parame;
        localMessage.what = 1;
        try
        {
          this.RVc.add(parame);
          this.RVa.sendMessageAtTime(localMessage, SystemClock.uptimeMillis() + paramLong);
          return;
        }
        finally {}
      }
      bool = this.RVd.isEmpty();
    }
    finally
    {
      AppMethodBeat.o(183467);
    }
    boolean bool;
    if ((bool) && (!this.isRunning))
    {
      this.isRunning = true;
      ((d)Objects.requireNonNull(this.RVb)).a(parame);
      AppMethodBeat.o(183467);
      return;
    }
    if ((bool) || (paramLong == -9223372036854775808L)) {
      this.RVd.addFirst(parame);
    }
    for (;;)
    {
      AppMethodBeat.o(183467);
      return;
      this.RVd.addLast(parame);
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
      localIterator = this.RVc.iterator();
      while (localIterator.hasNext())
      {
        locale = (e)localIterator.next();
        if (paramb.c(locale))
        {
          this.RVa.removeMessages(1, locale);
          if (!locale.isCancelled()) {
            locale.cancel(false);
          }
          localIterator.remove();
        }
      }
      localIterator = this.RVd.iterator();
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
      Iterator localIterator = this.RVc.iterator();
      while (localIterator.hasNext()) {
        if (parama.d((e)localIterator.next())) {
          return true;
        }
      }
      localIterator = this.RVd.iterator();
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
      this.RVa.removeMessages(1);
      Iterator localIterator1 = this.RVd.iterator();
      while (localIterator1.hasNext())
      {
        locale = (e)localIterator1.next();
        if (!locale.isCancelled()) {
          locale.cancel(false);
        }
      }
      this.RVd.clear();
    }
    finally
    {
      AppMethodBeat.o(183469);
    }
    Iterator localIterator2 = this.RVc.iterator();
    while (localIterator2.hasNext())
    {
      locale = (e)localIterator2.next();
      if (!locale.isCancelled()) {
        locale.cancel(false);
      }
    }
    this.RVc.clear();
    AppMethodBeat.o(183469);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(183465);
    if (paramMessage.what == 1) {}
    try
    {
      if (this.RVc.remove(paramMessage.obj))
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
  
  public final List<String> hmI()
  {
    AppMethodBeat.i(183470);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = hmJ().iterator();
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
    int i = this.RVd.size();
    int j = this.RVc.size();
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
 * Qualified Name:     com.tencent.f.j.d
 * JD-Core Version:    0.7.0.1
 */