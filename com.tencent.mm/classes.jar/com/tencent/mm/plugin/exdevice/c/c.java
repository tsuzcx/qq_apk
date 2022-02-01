package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.exdevice.f.e;

public abstract class c
{
  public long pkb = -1L;
  public short rxx = -1;
  public e rxy = null;
  protected a rxz = null;
  
  protected final e aQ(int paramInt, String paramString)
  {
    this.rxy = new e();
    this.rxy.rBL = paramInt;
    this.rxy.rBM = paramString;
    return this.rxy;
  }
  
  public abstract short cKg();
  
  public abstract short cKh();
  
  public abstract byte[] cKi();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.c
 * JD-Core Version:    0.7.0.1
 */