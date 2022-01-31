package com.b.a.a;

import java.lang.ref.WeakReference;

abstract class r$a
  implements Runnable
{
  private final WeakReference<r> bpx;
  
  private r$a(r paramr)
  {
    this.bpx = new WeakReference(paramr);
  }
  
  final r tv()
  {
    r localr = (r)this.bpx.get();
    if (localr == null) {
      throw new Exception("OnlineModule.AbstractOnlineModuleRunnable: online module not available");
    }
    return localr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.b.a.a.r.a
 * JD-Core Version:    0.7.0.1
 */