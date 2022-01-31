package com.tencent.mm.compatible.b;

import java.util.concurrent.locks.Lock;

public final class a
{
  public int dtT = 0;
  public int dtU = 0;
  public byte[] dtV = null;
  public int dtW = 0;
  public int dtX = 0;
  public boolean dtY = false;
  public Lock dtZ = null;
  
  public final int yg()
  {
    if (this.dtY) {
      this.dtZ.lock();
    }
    if (this.dtW == this.dtX) {
      return 0;
    }
    if (this.dtW < this.dtX) {
      this.dtU = (this.dtX - this.dtW);
    }
    for (;;)
    {
      if (this.dtY) {
        this.dtZ.unlock();
      }
      return this.dtU;
      if (this.dtW > this.dtX) {
        this.dtU = (this.dtX + this.dtT - this.dtW);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.b.a
 * JD-Core Version:    0.7.0.1
 */