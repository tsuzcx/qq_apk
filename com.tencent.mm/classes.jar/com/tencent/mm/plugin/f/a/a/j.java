package com.tencent.mm.plugin.f.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.y;

public abstract class j
{
  protected byte hTN = 0;
  protected byte[] hTO = null;
  protected int mLength = -1;
  
  abstract boolean Y(byte[] paramArrayOfByte);
  
  public final boolean a(a parama)
  {
    if (parama.getSize() == 0)
    {
      y.w("MicroMsg.exdevice.TLVBase", "autoBuffer is null or nil");
      return false;
    }
    byte[] arrayOfByte = new byte[1];
    parama.O(arrayOfByte, 1);
    int i = arrayOfByte[0];
    if (i + 1 > parama.getSize())
    {
      y.w("MicroMsg.exdevice.TLVBase", "lengthInt(%d) + 1 > autoBuffer.getSize()(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(parama.getSize()) });
      return false;
    }
    if (i <= 1)
    {
      y.w("MicroMsg.exdevice.TLVBase", "length(%d) <= 1", new Object[] { Integer.valueOf(i) });
      return false;
    }
    this.mLength = i;
    parama.O(arrayOfByte, 1);
    this.hTN = arrayOfByte[0];
    this.hTO = new byte[this.mLength - 1];
    parama.O(this.hTO, this.hTO.length);
    return Y(this.hTO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.a.j
 * JD-Core Version:    0.7.0.1
 */