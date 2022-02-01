package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothGattCharacteristic;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private byte[] mData = null;
  BluetoothGattCharacteristic pgA = null;
  private int pgx = 20;
  private int pgy = 0;
  private int pgz = 0;
  
  public final byte[] ckC()
  {
    AppMethodBeat.i(22473);
    int i = this.pgz - this.pgy;
    if (i == 0)
    {
      AppMethodBeat.o(22473);
      return null;
    }
    if (i < this.pgx) {}
    for (;;)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.mData, this.pgy, arrayOfByte, 0, i);
      this.pgy = (i + this.pgy);
      AppMethodBeat.o(22473);
      return arrayOfByte;
      i = this.pgx;
    }
  }
  
  public final void setData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22472);
    if (paramArrayOfByte == null)
    {
      this.mData = null;
      this.pgz = 0;
      this.pgy = 0;
      AppMethodBeat.o(22472);
      return;
    }
    this.mData = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.mData, 0, paramArrayOfByte.length);
    this.pgz = paramArrayOfByte.length;
    this.pgy = 0;
    AppMethodBeat.o(22472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a
 * JD-Core Version:    0.7.0.1
 */