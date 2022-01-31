package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

class c$2
  implements Runnable
{
  c$2(c paramc) {}
  
  public void run()
  {
    AppMethodBeat.i(66542);
    if ((c.a(this.a) != null) && (c.b(this.a) != null)) {
      ((TelephonyManager)c.b(this.a).getApplicationContext().getSystemService("phone")).listen(c.a(this.a), 0);
    }
    c.a(this.a, null);
    AppMethodBeat.o(66542);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.c.2
 * JD-Core Version:    0.7.0.1
 */