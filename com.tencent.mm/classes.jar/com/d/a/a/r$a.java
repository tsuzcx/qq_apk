package com.d.a.a;

import java.lang.ref.WeakReference;

abstract class r$a
  implements Runnable
{
  private final WeakReference<r> aYP;
  
  private r$a(r paramr)
  {
    this.aYP = new WeakReference(paramr);
  }
  
  final r pp()
  {
    r localr = (r)this.aYP.get();
    if (localr == null) {
      throw new Exception("OnlineModule.AbstractOnlineModuleRunnable: online module not available");
    }
    return localr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.d.a.a.r.a
 * JD-Core Version:    0.7.0.1
 */