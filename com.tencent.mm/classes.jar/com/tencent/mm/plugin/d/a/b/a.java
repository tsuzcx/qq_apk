package com.tencent.mm.plugin.d.a.b;

import android.bluetooth.BluetoothGattCharacteristic;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private byte[] mData = null;
  private int mMM = 20;
  private int mMN = 0;
  private int mMO = 0;
  BluetoothGattCharacteristic mMP = null;
  
  public final byte[] bBt()
  {
    AppMethodBeat.i(22473);
    int i = this.mMO - this.mMN;
    if (i == 0)
    {
      AppMethodBeat.o(22473);
      return null;
    }
    if (i < this.mMM) {}
    for (;;)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.mData, this.mMN, arrayOfByte, 0, i);
      this.mMN = (i + this.mMN);
      AppMethodBeat.o(22473);
      return arrayOfByte;
      i = this.mMM;
    }
  }
  
  public final void setData(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22472);
    if (paramArrayOfByte == null)
    {
      this.mData = null;
      this.mMO = 0;
      this.mMN = 0;
      AppMethodBeat.o(22472);
      return;
    }
    this.mData = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.mData, 0, paramArrayOfByte.length);
    this.mMO = paramArrayOfByte.length;
    this.mMN = 0;
    AppMethodBeat.o(22472);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.b.a
 * JD-Core Version:    0.7.0.1
 */