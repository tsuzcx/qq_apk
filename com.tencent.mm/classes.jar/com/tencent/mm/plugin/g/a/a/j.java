package com.tencent.mm.plugin.g.a.a;

import com.tencent.mm.plugin.exdevice.k.a;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class j
{
  protected int mLength = -1;
  protected byte vuF = 0;
  protected byte[] vuG = null;
  
  public final boolean a(a parama)
  {
    if (parama.getSize() == 0)
    {
      Log.w("MicroMsg.exdevice.TLVBase", "autoBuffer is null or nil");
      return false;
    }
    byte[] arrayOfByte = new byte[1];
    parama.U(arrayOfByte, 1);
    int i = arrayOfByte[0];
    if (i + 1 > parama.getSize())
    {
      Log.w("MicroMsg.exdevice.TLVBase", "lengthInt(%d) + 1 > autoBuffer.getSize()(%d)", new Object[] { Integer.valueOf(i), Integer.valueOf(parama.getSize()) });
      return false;
    }
    if (i <= 1)
    {
      Log.w("MicroMsg.exdevice.TLVBase", "length(%d) <= 1", new Object[] { Integer.valueOf(i) });
      return false;
    }
    this.mLength = i;
    parama.U(arrayOfByte, 1);
    this.vuF = arrayOfByte[0];
    this.vuG = new byte[this.mLength - 1];
    parama.U(this.vuG, this.vuG.length);
    return bj(this.vuG);
  }
  
  abstract boolean bj(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.g.a.a.j
 * JD-Core Version:    0.7.0.1
 */