package com.tencent.g;

import com.tencent.g.b.c;
import java.util.HashMap;

final class f$a
{
  private final Object mLock = new Object();
  private final HashMap<String, Object> xce = new HashMap();
  
  f$a(f paramf) {}
  
  final void gN(String arg1, String paramString2)
  {
    String str = ??? + paramString2;
    synchronized (this.mLock)
    {
      for (;;)
      {
        Object localObject = this.xce.get(str);
        if (localObject != null) {
          try
          {
            this.mLock.wait();
          }
          catch (InterruptedException paramString2)
          {
            throw new c("install fail,lock interrupted!");
          }
        }
      }
    }
    this.xce.put(str, paramString2);
  }
  
  final void gO(String arg1, String paramString2)
  {
    paramString2 = ??? + paramString2;
    synchronized (this.mLock)
    {
      this.xce.remove(paramString2);
      this.mLock.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.g.f.a
 * JD-Core Version:    0.7.0.1
 */