package com.bumptech.glide.c.b.b;

import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c
{
  final Map<String, a> aIW;
  final b aIX;
  
  c()
  {
    AppMethodBeat.i(77147);
    this.aIW = new HashMap();
    this.aIX = new b();
    AppMethodBeat.o(77147);
  }
  
  final void release(String arg1)
  {
    AppMethodBeat.i(77148);
    a locala1;
    try
    {
      locala1 = (a)i.checkNotNull(this.aIW.get(???), "Argument must not be null");
      if (locala1.aIZ <= 0)
      {
        ??? = new IllegalStateException("Cannot release a lock that is not held, safeKey: " + ??? + ", interestedThreads: " + locala1.aIZ);
        AppMethodBeat.o(77148);
        throw ???;
      }
    }
    finally
    {
      AppMethodBeat.o(77148);
    }
    locala1.aIZ -= 1;
    a locala2;
    b localb;
    if (locala1.aIZ == 0)
    {
      locala2 = (a)this.aIW.remove(???);
      if (!locala2.equals(locala1))
      {
        ??? = new IllegalStateException("Removed the wrong lock, expected to remove: " + locala1 + ", but actually removed: " + locala2 + ", safeKey: " + ???);
        AppMethodBeat.o(77148);
        throw ???;
      }
      localb = this.aIX;
    }
    synchronized (localb.aJa)
    {
      if (localb.aJa.size() < 10) {
        localb.aJa.offer(locala2);
      }
      locala1.aIY.unlock();
      AppMethodBeat.o(77148);
      return;
    }
  }
  
  static final class a
  {
    final Lock aIY;
    int aIZ;
    
    a()
    {
      AppMethodBeat.i(77144);
      this.aIY = new ReentrantLock();
      AppMethodBeat.o(77144);
    }
  }
  
  static final class b
  {
    final Queue<c.a> aJa;
    
    b()
    {
      AppMethodBeat.i(77145);
      this.aJa = new ArrayDeque();
      AppMethodBeat.o(77145);
    }
    
    final c.a pb()
    {
      AppMethodBeat.i(77146);
      synchronized (this.aJa)
      {
        c.a locala = (c.a)this.aJa.poll();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.b.c
 * JD-Core Version:    0.7.0.1
 */