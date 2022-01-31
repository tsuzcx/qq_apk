package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothDevice;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class g$2
  implements Runnable
{
  g$2(g paramg, BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    AppMethodBeat.i(18446);
    int i = 0;
    while (i < g.a(this.jOT).size())
    {
      ((g.a)g.a(this.jOT).get(i)).a(this.jNz, this.jNw, this.jNW);
      i += 1;
    }
    AppMethodBeat.o(18446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.g.2
 * JD-Core Version:    0.7.0.1
 */