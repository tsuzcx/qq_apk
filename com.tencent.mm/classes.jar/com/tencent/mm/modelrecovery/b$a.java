package com.tencent.mm.modelrecovery;

public final class b$a
{
  public int dsw;
  public int exj;
  public int exk;
  public int exl;
  public int exm;
  public int exn;
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.dsw > 0) {
      localStringBuffer.append("totalCount:" + this.dsw + " ");
    }
    if (this.exj > 0) {
      localStringBuffer.append("enterRecoveryCount:" + this.exj + " ");
    }
    if (this.exk > 0) {
      localStringBuffer.append("existRecoveryProcessCount:" + this.exk + " ");
    }
    if (this.exl > 0) {
      localStringBuffer.append("foregroundExpCount:" + this.exl + " ");
    }
    if (this.exm > 0) {
      localStringBuffer.append("backgroundExpCount:" + this.exm + " ");
    }
    if (this.exn > 0) {
      localStringBuffer.append("normalCount:" + this.exn + " ");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelrecovery.b.a
 * JD-Core Version:    0.7.0.1
 */