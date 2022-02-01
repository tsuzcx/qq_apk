package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothGattCharacteristic;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private byte[] mData = null;
  private int nVA = 20;
  private int nVB = 0;
  private int nVC = 0;
  BluetoothGattCharacteristic nVD = null;
  
  public final byte[] bNC()
  {
    AppMethodBeat.i(22473);
    int i = this.nVC - this.nVB;
    if (i == 0)
    {
      AppMethodBeat.o(22473);
      return null;
    }
    if (i < this.nVA) {}
    for (;;)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.mData, this.nVB, arrayOfByte, 0, i);
      this.nVB = (i + this.nVB);
      AppMethodBeat.o(22473);
      return arrayOfByte;
      i = this.nVA;
    }
  }
  
  public final void setData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22472);
    if (paramArrayOfByte == null)
    {
      this.mData = null;
      this.nVC = 0;
      this.nVB = 0;
      AppMethodBeat.o(22472);
      return;
    }
    this.mData = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.mData, 0, paramArrayOfByte.length);
    this.nVC = paramArrayOfByte.length;
    this.nVB = 0;
    AppMethodBeat.o(22472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a
 * JD-Core Version:    0.7.0.1
 */