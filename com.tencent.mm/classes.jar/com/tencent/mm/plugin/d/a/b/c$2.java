package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class c$2
  implements Runnable
{
  c$2(c paramc, BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(18380);
    int i = 0;
    while (i < c.a(this.jOf).size())
    {
      ((c.a)c.a(this.jOf).get(i)).a(this.jNz, this.jNw, this.jNW);
      i += 1;
    }
    AppMethodBeat.o(18380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.c.2
 * JD-Core Version:    0.7.0.1
 */