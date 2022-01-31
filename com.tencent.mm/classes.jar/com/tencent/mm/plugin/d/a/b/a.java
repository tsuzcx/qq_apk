package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothGattCharacteristic;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private int jNJ = 20;
  private int jNK = 0;
  private int jNL = 0;
  BluetoothGattCharacteristic jNM = null;
  private byte[] mData = null;
  
  public final byte[] aVR()
  {
    AppMethodBeat.i(18362);
    int i = this.jNL - this.jNK;
    if (i == 0)
    {
      AppMethodBeat.o(18362);
      return null;
    }
    if (i < this.jNJ) {}
    for (;;)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.mData, this.jNK, arrayOfByte, 0, i);
      this.jNK = (i + this.jNK);
      AppMethodBeat.o(18362);
      return arrayOfByte;
      i = this.jNJ;
    }
  }
  
  public final void setData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18361);
    if (paramArrayOfByte == null)
    {
      this.mData = null;
      this.jNL = 0;
      this.jNK = 0;
      AppMethodBeat.o(18361);
      return;
    }
    this.mData = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.mData, 0, paramArrayOfByte.length);
    this.jNL = paramArrayOfByte.length;
    this.jNK = 0;
    AppMethodBeat.o(18361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a
 * JD-Core Version:    0.7.0.1
 */