package com.tencent.mm.bd;

import com.tencent.map.swlocation.api.SwEngine;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    y.i("MicroMsg.SenseWhereHelper", "it stop sense where sdk.");
    a.udP.d(b.f(this.eyi));
    SwEngine.stopContinousLocationUpdate();
    SwEngine.onDestroy();
    if (b.g(this.eyi) != null)
    {
      b.g(this.eyi).finish();
      b.a(this.eyi, null);
    }
    b.l(this.eyi);
    b.m(this.eyi);
    b.n(this.eyi);
    b.a(this.eyi, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.bd.b.2
 * JD-Core Version:    0.7.0.1
 */