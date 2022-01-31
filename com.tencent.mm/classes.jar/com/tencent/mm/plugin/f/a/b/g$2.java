package com.tencent.mm.plugin.f.a.b;

import android.bluetooth.BluetoothDevice;
import java.util.ArrayList;

final class g$2
  implements Runnable
{
  g$2(g paramg, BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    int i = 0;
    while (i < g.a(this.hUZ).size())
    {
      ((g.a)g.a(this.hUZ).get(i)).b(this.hTF, this.hTC, this.hUc);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.g.2
 * JD-Core Version:    0.7.0.1
 */