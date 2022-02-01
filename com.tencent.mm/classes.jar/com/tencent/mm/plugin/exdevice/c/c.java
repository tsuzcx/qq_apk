package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.exdevice.f.e;

public abstract class c
{
  public long smk = -1L;
  public short vdd = -1;
  public e vde = null;
  protected a vdf = null;
  
  protected final e aP(int paramInt, String paramString)
  {
    this.vde = new e();
    this.vde.vht = paramInt;
    this.vde.vhu = paramString;
    return this.vde;
  }
  
  public abstract short cYQ();
  
  public abstract short cYR();
  
  public abstract byte[] cYS();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.c
 * JD-Core Version:    0.7.0.1
 */