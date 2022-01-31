package com.tencent.mm.plugin.f.a.b;

import android.bluetooth.BluetoothDevice;
import java.util.ArrayList;

final class c$2
  implements Runnable
{
  c$2(c paramc, BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte) {}
  
  public final void run()
  {
    int i = 0;
    while (i < c.a(this.hUl).size())
    {
      ((c.a)c.a(this.hUl).get(i)).b(this.hTF, this.hTC, this.hUc);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.c.2
 * JD-Core Version:    0.7.0.1
 */