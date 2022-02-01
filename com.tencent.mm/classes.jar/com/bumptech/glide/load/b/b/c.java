package com.bumptech.glide.load.b.b;

import com.bumptech.glide.g.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c
{
  final Map<String, a> aIP;
  final b aIQ;
  
  c()
  {
    AppMethodBeat.i(77147);
    this.aIP = new HashMap();
    this.aIQ = new b();
    AppMethodBeat.o(77147);
  }
  
  final void release(String arg1)
  {
    AppMethodBeat.i(77148);
    a locala1;
    try
    {
      locala1 = (a)j.checkNotNull(this.aIP.get(???), "Argument must not be null");
      if (locala1.aIS <= 0)
      {
        ??? = new IllegalStateException("Cannot release a lock that is not held, safeKey: " + ??? + ", interestedThreads: " + locala1.aIS);
        AppMethodBeat.o(77148);
        throw ???;
      }
    }
    finally
    {
      AppMethodBeat.o(77148);
    }
    locala1.aIS -= 1;
    a locala2;
    b localb;
    if (locala1.aIS == 0)
    {
      locala2 = (a)this.aIP.remove(???);
      if (!locala2.equals(locala1))
      {
        ??? = new IllegalStateException("Removed the wrong lock, expected to remove: " + locala1 + ", but actually removed: " + locala2 + ", safeKey: " + ???);
        AppMethodBeat.o(77148);
        throw ???;
      }
      localb = this.aIQ;
    }
    synchronized (localb.aIT)
    {
      if (localb.aIT.size() < 10) {
        localb.aIT.offer(locala2);
      }
      locala1.aIR.unlock();
      AppMethodBeat.o(77148);
      return;
    }
  }
  
  static final class a
  {
    final Lock aIR;
    int aIS;
    
    a()
    {
      AppMethodBeat.i(77144);
      this.aIR = new ReentrantLock();
      AppMethodBeat.o(77144);
    }
  }
  
  static final class b
  {
    final Queue<c.a> aIT;
    
    b()
    {
      AppMethodBeat.i(77145);
      this.aIT = new ArrayDeque();
      AppMethodBeat.o(77145);
    }
    
    final c.a pg()
    {
      AppMethodBeat.i(77146);
      synchronized (this.aIT)
      {
        c.a locala = (c.a)this.aIT.poll();
        ??? = locala;
        if (locala == null) {
          ??? = new c.a();
        }
        AppMethodBeat.o(77146);
        return ???;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.b.c
 * JD-Core Version:    0.7.0.1
 */