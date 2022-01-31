package com.tencent.mm.plugin.d.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class j
{
  protected byte jNH = 0;
  protected byte[] jNI = null;
  protected int mLength = -1;
  
  public final boolean a(a parama)
  {
    if (parama.getSize() == 0)
    {
      ab.w("MicroMsg.exdevice.TLVBase", "autoBuffer is null or nil");
      return false;
    }
    byte[] arrayOfByte = new byte[1];
    parama.P(arrayOfByte, 1);
    int i = arrayOfByte[0];
    if (i + 1 > parama.getSize())
    {
      ab.w("MicroMsg.exdevice.TLVBase", "lengthInt(%d) + 1 > autoBuffer.getSize()(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(parama.getSize()) });
      return false;
    }
    if (i <= 1)
    {
      ab.w("MicroMsg.exdevice.TLVBase", "length(%d) <= 1", new Object[] { Integer.valueOf(i) });
      return false;
    }
    this.mLength = i;
    parama.P(arrayOfByte, 1);
    this.jNH = arrayOfByte[0];
    this.jNI = new byte[this.mLength - 1];
    parama.P(this.jNI, this.jNI.length);
    return ar(this.jNI);
  }
  
  abstract boolean ar(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.j
 * JD-Core Version:    0.7.0.1
 */