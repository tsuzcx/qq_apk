package com.tencent.mm.plugin.backup.d;

final class c$7
  implements Runnable
{
  c$7(c paramc, int paramInt1, byte[] paramArrayOfByte, int paramInt2) {}
  
  public final void run()
  {
    if (this.bns == 11) {
      c.a(this.hIn, this.hFT, this.hFQ);
    }
    do
    {
      return;
      if (this.bns == 6)
      {
        c.b(this.hIn, this.hFT, this.hFQ);
        return;
      }
      if (this.bns == 13)
      {
        c.G(this.hFT, this.hFQ);
        return;
      }
      if (this.bns == 15)
      {
        c.c(this.hIn, this.hFT, this.hFQ);
        return;
      }
    } while (this.bns != 8);
    c.a(this.hIn, this.hFT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.c.7
 * JD-Core Version:    0.7.0.1
 */