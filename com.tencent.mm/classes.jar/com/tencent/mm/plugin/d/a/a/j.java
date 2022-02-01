package com.tencent.mm.plugin.d.a.a;

import com.tencent.mm.plugin.exdevice.k.a;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class j
{
  protected int mLength = -1;
  protected byte pgv = 0;
  protected byte[] pgw = null;
  
  public final boolean a(a parama)
  {
    if (parama.getSize() == 0)
    {
      Log.w("MicroMsg.exdevice.TLVBase", "autoBuffer is null or nil");
      return false;
    }
    byte[] arrayOfByte = new byte[1];
    parama.T(arrayOfByte, 1);
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
    parama.T(arrayOfByte, 1);
    this.pgv = arrayOfByte[0];
    this.pgw = new byte[this.mLength - 1];
    parama.T(this.pgw, this.pgw.length);
    return aW(this.pgw);
  }
  
  abstract boolean aW(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.a.j
 * JD-Core Version:    0.7.0.1
 */