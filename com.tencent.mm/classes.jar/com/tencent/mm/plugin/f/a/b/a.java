package com.tencent.mm.plugin.f.a.b;

import android.bluetooth.BluetoothGattCharacteristic;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private byte[] mData = null;
  private int siI = 20;
  private int siJ = 0;
  private int siK = 0;
  BluetoothGattCharacteristic siL = null;
  
  public final byte[] cxW()
  {
    AppMethodBeat.i(22473);
    int i = this.siK - this.siJ;
    if (i == 0)
    {
      AppMethodBeat.o(22473);
      return null;
    }
    if (i < this.siI) {}
    for (;;)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.mData, this.siJ, arrayOfByte, 0, i);
      this.siJ = (i + this.siJ);
      AppMethodBeat.o(22473);
      return arrayOfByte;
      i = this.siI;
    }
  }
  
  public final void setData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22472);
    if (paramArrayOfByte == null)
    {
      this.mData = null;
      this.siK = 0;
      this.siJ = 0;
      AppMethodBeat.o(22472);
      return;
    }
    this.mData = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.mData, 0, paramArrayOfByte.length);
    this.siK = paramArrayOfByte.length;
    this.siJ = 0;
    AppMethodBeat.o(22472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.a
 * JD-Core Version:    0.7.0.1
 */