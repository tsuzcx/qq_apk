package com.tencent.mm.plugin.f.a.b;

import android.bluetooth.BluetoothGattCharacteristic;

public final class a
{
  private int hTP = 20;
  private int hTQ = 0;
  private int hTR = 0;
  BluetoothGattCharacteristic hTS = null;
  private byte[] mData = null;
  
  public final byte[] awo()
  {
    int i = this.hTR - this.hTQ;
    if (i == 0) {
      return null;
    }
    if (i < this.hTP) {}
    for (;;)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.mData, this.hTQ, arrayOfByte, 0, i);
      this.hTQ = (i + this.hTQ);
      return arrayOfByte;
      i = this.hTP;
    }
  }
  
  public final void setData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      this.mData = null;
      this.hTR = 0;
      this.hTQ = 0;
      return;
    }
    this.mData = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.mData, 0, paramArrayOfByte.length);
    this.hTR = paramArrayOfByte.length;
    this.hTQ = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.b.a
 * JD-Core Version:    0.7.0.1
 */