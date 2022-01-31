package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.exdevice.e.e;

public abstract class c
{
  public long jRn = -1L;
  public short lCu = -1;
  public e lCv = null;
  protected a lCw = null;
  
  protected final e as(int paramInt, String paramString)
  {
    this.lCv = new e();
    this.lCv.lGK = paramInt;
    this.lCv.lGL = paramString;
    return this.lCv;
  }
  
  public abstract short bpu();
  
  public abstract short bpv();
  
  public abstract byte[] bpw();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.c
 * JD-Core Version:    0.7.0.1
 */