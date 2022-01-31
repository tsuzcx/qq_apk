package com.tencent.mm.plugin.f.a.b;

import com.tencent.mm.sdk.platformtools.y;

final class f$4
  implements Runnable
{
  f$4(f paramf) {}
  
  public final void run()
  {
    if (f.k(this.hUU))
    {
      if (f.i(this.hUU) != null) {
        f.i(this.hUU).a(f.g(this.hUU), false, f.l(this.hUU));
      }
      y.d("MicroMsg.exdevice.BluetoothLESimpleSession", "close timeout!!! stop handle thread.");
      f.m(this.hUU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.f.4
 * JD-Core Version:    0.7.0.1
 */