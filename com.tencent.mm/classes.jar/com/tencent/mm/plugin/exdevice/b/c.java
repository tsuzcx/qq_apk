package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.exdevice.e.e;

public abstract class c
{
  public long hXu = -1L;
  public short jsV = -1;
  public e jsW = null;
  protected a jsX = null;
  
  protected final e Z(int paramInt, String paramString)
  {
    this.jsW = new e();
    this.jsW.jxl = paramInt;
    this.jsW.jxm = paramString;
    return this.jsW;
  }
  
  public abstract short aLh();
  
  public abstract short aLi();
  
  public abstract byte[] aLj();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.c
 * JD-Core Version:    0.7.0.1
 */