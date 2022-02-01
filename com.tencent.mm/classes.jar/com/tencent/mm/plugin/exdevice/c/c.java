package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.exdevice.f.e;

public abstract class c
{
  public long nZd = -1L;
  public short qgB = -1;
  public e qgC = null;
  protected a qgD = null;
  
  protected final e aL(int paramInt, String paramString)
  {
    this.qgC = new e();
    this.qgC.qkQ = paramInt;
    this.qgC.qkR = paramString;
    return this.qgC;
  }
  
  public abstract short cme();
  
  public abstract short cmf();
  
  public abstract byte[] cmg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.c
 * JD-Core Version:    0.7.0.1
 */