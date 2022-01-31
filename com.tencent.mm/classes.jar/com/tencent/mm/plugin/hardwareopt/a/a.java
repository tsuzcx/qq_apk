package com.tencent.mm.plugin.hardwareopt.a;

import com.tencent.mm.plugin.hardwareopt.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.e;

public final class a
  implements com.tencent.mm.plugin.hardwareopt.a.a.a
{
  public final void gF(boolean paramBoolean)
  {
    new e().y(new Object[] { ae.getContext() }).e(new com.tencent.mm.plugin.hardwareopt.c.a()).d(new b(paramBoolean)).a(new d.a()
    {
      public final void aE(Object paramAnonymousObject)
      {
        y.w("MicroMsg.HardwareProvider", "hy: on interrupt.");
      }
    }).a(new a.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hardwareopt.a.a
 * JD-Core Version:    0.7.0.1
 */