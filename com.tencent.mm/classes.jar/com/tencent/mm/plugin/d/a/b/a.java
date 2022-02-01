package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothGattCharacteristic;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private byte[] mData = null;
  private int nPU = 20;
  private int nPV = 0;
  private int nPW = 0;
  BluetoothGattCharacteristic nPX = null;
  
  public final byte[] bME()
  {
    AppMethodBeat.i(22473);
    int i = this.nPW - this.nPV;
    if (i == 0)
    {
      AppMethodBeat.o(22473);
      return null;
    }
    if (i < this.nPU) {}
    for (;;)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.mData, this.nPV, arrayOfByte, 0, i);
      this.nPV = (i + this.nPV);
      AppMethodBeat.o(22473);
      return arrayOfByte;
      i = this.nPU;
    }
  }
  
  public final void setData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22472);
    if (paramArrayOfByte == null)
    {
      this.mData = null;
      this.nPW = 0;
      this.nPV = 0;
      AppMethodBeat.o(22472);
      return;
    }
    this.mData = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.mData, 0, paramArrayOfByte.length);
    this.nPW = paramArrayOfByte.length;
    this.nPV = 0;
    AppMethodBeat.o(22472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a
 * JD-Core Version:    0.7.0.1
 */