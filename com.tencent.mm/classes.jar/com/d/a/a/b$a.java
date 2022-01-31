package com.d.a.a;

import java.lang.ref.WeakReference;

final class b$a
  implements Runnable
{
  private final WeakReference<b> aVG;
  private final p aVH;
  
  private b$a(b paramb, p paramp)
  {
    if ((paramb == null) || (paramp == null)) {
      throw new Exception("CoreAssembly: HandleMsgTask: null arg");
    }
    this.aVG = new WeakReference(paramb);
    this.aVH = paramp;
  }
  
  public final void run()
  {
    b localb = (b)this.aVG.get();
    if (localb != null) {}
    switch (this.aVH.what)
    {
    default: 
      return;
    }
    r.f localf = (r.f)this.aVH;
    if (localf.aYY == 1)
    {
      localb.a(localf.aYZ, localf.aYz, localf.aYA);
      return;
    }
    localb.a(localf.aYY, localf.message, localf.aYz, localf.aYA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.d.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */