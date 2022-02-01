package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.exdevice.f.e;

public abstract class c
{
  public long nsB = -1L;
  public short pwr = -1;
  public e pws = null;
  protected a pwt = null;
  
  protected final e aJ(int paramInt, String paramString)
  {
    this.pws = new e();
    this.pws.pAG = paramInt;
    this.pws.pAH = paramString;
    return this.pws;
  }
  
  public abstract short cgk();
  
  public abstract short cgl();
  
  public abstract byte[] cgm();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.c
 * JD-Core Version:    0.7.0.1
 */