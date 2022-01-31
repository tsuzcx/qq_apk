package com.tencent.mm.plugin.backup.backuppcmodel;

final class d$1$1
  implements Runnable
{
  d$1$1(d.1 param1, int paramInt1, byte[] paramArrayOfByte, int paramInt2) {}
  
  public final void run()
  {
    if (this.bns == 3) {
      d.a(this.hKP.hKO, this.hFT, this.hFQ);
    }
    do
    {
      return;
      if (this.bns == 11)
      {
        d.b(this.hKP.hKO, this.hFT, this.hFQ);
        return;
      }
      if (this.bns == 6)
      {
        d.c(this.hKP.hKO, this.hFT, this.hFQ);
        return;
      }
      if (this.bns == 13)
      {
        d.H(this.hFT, this.hFQ);
        return;
      }
      if (this.bns == 15)
      {
        d.d(this.hKP.hKO, this.hFT, this.hFQ);
        return;
      }
    } while (this.bns != 8);
    d.a(this.hKP.hKO, this.hFT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.d.1.1
 * JD-Core Version:    0.7.0.1
 */