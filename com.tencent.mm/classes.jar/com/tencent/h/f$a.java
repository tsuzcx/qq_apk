package com.tencent.h;

import com.tencent.h.b.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

final class f$a
{
  private final HashMap<String, Object> ByK;
  private final Object mLock;
  
  f$a(f paramf)
  {
    AppMethodBeat.i(127748);
    this.mLock = new Object();
    this.ByK = new HashMap();
    AppMethodBeat.o(127748);
  }
  
  final void iT(String arg1, String paramString2)
  {
    AppMethodBeat.i(127749);
    String str = ??? + paramString2;
    synchronized (this.mLock)
    {
      for (;;)
      {
        Object localObject = this.ByK.get(str);
        if (localObject != null) {
          try
          {
            this.mLock.wait();
          }
          catch (InterruptedException paramString2)
          {
            paramString2 = new c("install fail,lock interrupted!");
            AppMethodBeat.o(127749);
            throw paramString2;
          }
        }
      }
    }
    this.ByK.put(str, paramString2);
    AppMethodBeat.o(127749);
  }
  
  final void iU(String arg1, String paramString2)
  {
    AppMethodBeat.i(127750);
    paramString2 = ??? + paramString2;
    synchronized (this.mLock)
    {
      this.ByK.remove(paramString2);
      this.mLock.notifyAll();
      AppMethodBeat.o(127750);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.f.a
 * JD-Core Version:    0.7.0.1
 */