package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.exdevice.f.e;

public abstract class c
{
  public long mQq = -1L;
  public short oTg = -1;
  public e oTh = null;
  protected a oTi = null;
  
  protected final e aH(int paramInt, String paramString)
  {
    this.oTh = new e();
    this.oTh.oXv = paramInt;
    this.oTh.oXw = paramString;
    return this.oTh;
  }
  
  public abstract short bZb();
  
  public abstract short bZc();
  
  public abstract byte[] bZd();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.c
 * JD-Core Version:    0.7.0.1
 */