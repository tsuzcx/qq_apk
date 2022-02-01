package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.exdevice.f.e;

public abstract class c
{
  public long nTx = -1L;
  public short pZW = -1;
  public e pZX = null;
  protected a pZY = null;
  
  protected final e aM(int paramInt, String paramString)
  {
    this.pZX = new e();
    this.pZX.qel = paramInt;
    this.pZX.qem = paramString;
    return this.pZX;
  }
  
  public abstract short ckO();
  
  public abstract short ckP();
  
  public abstract byte[] ckQ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.c
 * JD-Core Version:    0.7.0.1
 */