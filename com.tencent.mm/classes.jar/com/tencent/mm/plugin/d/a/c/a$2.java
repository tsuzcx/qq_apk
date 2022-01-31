package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(18476);
    if (a.b(this.jQO).isDiscovering()) {
      a.b(this.jQO).cancelDiscovery();
    }
    AppMethodBeat.o(18476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.a.2
 * JD-Core Version:    0.7.0.1
 */