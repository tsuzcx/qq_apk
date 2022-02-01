package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothGattCharacteristic;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private byte[] mData = null;
  private int noY = 20;
  private int noZ = 0;
  private int npa = 0;
  BluetoothGattCharacteristic npb = null;
  
  public final byte[] bIr()
  {
    AppMethodBeat.i(22473);
    int i = this.npa - this.noZ;
    if (i == 0)
    {
      AppMethodBeat.o(22473);
      return null;
    }
    if (i < this.noY) {}
    for (;;)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.mData, this.noZ, arrayOfByte, 0, i);
      this.noZ = (i + this.noZ);
      AppMethodBeat.o(22473);
      return arrayOfByte;
      i = this.noY;
    }
  }
  
  public final void setData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22472);
    if (paramArrayOfByte == null)
    {
      this.mData = null;
      this.npa = 0;
      this.noZ = 0;
      AppMethodBeat.o(22472);
      return;
    }
    this.mData = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.mData, 0, paramArrayOfByte.length);
    this.npa = paramArrayOfByte.length;
    this.noZ = 0;
    AppMethodBeat.o(22472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a
 * JD-Core Version:    0.7.0.1
 */