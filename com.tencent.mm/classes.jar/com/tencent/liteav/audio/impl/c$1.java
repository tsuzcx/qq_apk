package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

class c$1
  implements Runnable
{
  c$1(c paramc) {}
  
  public void run()
  {
    AppMethodBeat.i(66636);
    if (c.a(this.a) != null)
    {
      AppMethodBeat.o(66636);
      return;
    }
    c.a(this.a, new c.1.1(this));
    ((TelephonyManager)c.b(this.a).getSystemService("phone")).listen(c.a(this.a), 32);
    AppMethodBeat.o(66636);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.c.1
 * JD-Core Version:    0.7.0.1
 */