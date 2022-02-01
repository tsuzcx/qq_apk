package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothGattCharacteristic;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private byte[] mData = null;
  private int vuH = 20;
  private int vuI = 0;
  private int vuJ = 0;
  BluetoothGattCharacteristic vuK = null;
  
  public final byte[] daO()
  {
    AppMethodBeat.i(22473);
    int i = this.vuJ - this.vuI;
    if (i == 0)
    {
      AppMethodBeat.o(22473);
      return null;
    }
    if (i < this.vuH) {}
    for (;;)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.mData, this.vuI, arrayOfByte, 0, i);
      this.vuI = (i + this.vuI);
      AppMethodBeat.o(22473);
      return arrayOfByte;
      i = this.vuH;
    }
  }
  
  public final void setData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22472);
    if (paramArrayOfByte == null)
    {
      this.mData = null;
      this.vuJ = 0;
      this.vuI = 0;
      AppMethodBeat.o(22472);
      return;
    }
    this.mData = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.mData, 0, paramArrayOfByte.length);
    this.vuJ = paramArrayOfByte.length;
    this.vuI = 0;
    AppMethodBeat.o(22472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.b.a
 * JD-Core Version:    0.7.0.1
 */