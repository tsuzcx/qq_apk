package com.tencent.mm.plugin.appbrand.widget.e;

import java.lang.ref.WeakReference;

final class d
  implements Runnable
{
  private final WeakReference<c> gVz;
  
  public d(c paramc)
  {
    this.gVz = new WeakReference(paramc);
  }
  
  public final void run()
  {
    c localc = (c)this.gVz.get();
    if (localc != null) {
      localc.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.d
 * JD-Core Version:    0.7.0.1
 */