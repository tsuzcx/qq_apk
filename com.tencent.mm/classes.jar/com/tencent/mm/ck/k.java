package com.tencent.mm.ck;

public final class k
{
  public final byte[] dIn = new byte[1];
  
  public final void done()
  {
    synchronized (this.dIn)
    {
      if (this.dIn[0] == -1)
      {
        this.dIn[0] = 1;
        this.dIn.notifyAll();
        com.tencent.mm.kernel.k.i("MicroMsg.WxWaitingLock", "notify done %s", new Object[] { this });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ck.k
 * JD-Core Version:    0.7.0.1
 */