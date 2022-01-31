package com.tencent.mm.modelrecovery;

public final class b$b
{
  public int exo;
  public int exp;
  public int exq;
  public int exr;
  public int exs;
  public int ext;
  public int exu;
  public int exv;
  public int exw;
  public int exx;
  public int exy;
  public int exz;
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.exo > 0) {
      localStringBuffer.append("appForegroundExpCount:" + this.exo + " ");
    }
    if (this.exp > 0) {
      localStringBuffer.append("appBackgroundExpCount:" + this.exp + " ");
    }
    if (this.exq > 0) {
      localStringBuffer.append("componentForegroundExpCount:" + this.exq + " ");
    }
    if (this.exr > 0) {
      localStringBuffer.append("componentBackgroundExpCount:" + this.exr + " ");
    }
    if (this.exs > 0) {
      localStringBuffer.append("appForegroundCrashOrAnrExpCount:" + this.exs + " ");
    }
    if (this.ext > 0) {
      localStringBuffer.append("appBackgroundCrashOrAnrExpCount:" + this.ext + " ");
    }
    if (this.exu > 0) {
      localStringBuffer.append("componentForegroundCrashOrAnrExpCount:" + this.exu + " ");
    }
    if (this.exv > 0) {
      localStringBuffer.append("componentBackgroundCrashOrAnrExpCount:" + this.exv + " ");
    }
    if (this.exw > 0) {
      localStringBuffer.append("appForegroundTimeoutExpCount:" + this.exw + " ");
    }
    if (this.exx > 0) {
      localStringBuffer.append("appBackgroundTimeoutExpCount:" + this.exx + " ");
    }
    if (this.exy > 0) {
      localStringBuffer.append("componentForegroundTimeoutExpCount:" + this.exy + " ");
    }
    if (this.exz > 0) {
      localStringBuffer.append("componentBackgroundTimeoutExpCount:" + this.exz + " ");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.b.b
 * JD-Core Version:    0.7.0.1
 */