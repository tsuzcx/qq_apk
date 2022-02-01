package com.tencent.mm.plugin.d.a.a;

import com.tencent.mm.plugin.exdevice.k.a;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class j
{
  protected int mLength = -1;
  protected byte nVy = 0;
  protected byte[] nVz = null;
  
  public final boolean a(a parama)
  {
    if (parama.getSize() == 0)
    {
      ae.w("MicroMsg.exdevice.TLVBase", "autoBuffer is null or nil");
      return false;
    }
    byte[] arrayOfByte = new byte[1];
    parama.R(arrayOfByte, 1);
    int i = arrayOfByte[0];
    if (i + 1 > parama.getSize())
    {
      ae.w("MicroMsg.exdevice.TLVBase", "lengthInt(%d) + 1 > autoBuffer.getSize()(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(parama.getSize()) });
      return false;
    }
    if (i <= 1)
    {
      ae.w("MicroMsg.exdevice.TLVBase", "length(%d) <= 1", new Object[] { Integer.valueOf(i) });
      return false;
    }
    this.mLength = i;
    parama.R(arrayOfByte, 1);
    this.nVy = arrayOfByte[0];
    this.nVz = new byte[this.mLength - 1];
    parama.R(this.nVz, this.nVz.length);
    return aF(this.nVz);
  }
  
  abstract boolean aF(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.j
 * JD-Core Version:    0.7.0.1
 */