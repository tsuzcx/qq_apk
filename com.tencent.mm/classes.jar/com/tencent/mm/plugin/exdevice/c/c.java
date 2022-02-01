package com.tencent.mm.plugin.exdevice.c;

import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.exdevice.f.e;

public abstract class c
{
  public long vyj = -1L;
  public short yoQ = -1;
  public e yoR = null;
  protected a yoS = null;
  
  protected final e bh(int paramInt, String paramString)
  {
    this.yoR = new e();
    this.yoR.ytv = paramInt;
    this.yoR.ytw = paramString;
    return this.yoR;
  }
  
  public abstract short dFh();
  
  public abstract short dFi();
  
  public abstract byte[] dFj();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.c
 * JD-Core Version:    0.7.0.1
 */