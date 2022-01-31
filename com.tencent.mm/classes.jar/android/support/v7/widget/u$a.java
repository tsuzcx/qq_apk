package android.support.v7.widget;

final class u$a
{
  long abk = 0L;
  a abl;
  
  private void gy()
  {
    if (this.abl == null) {
      this.abl = new a();
    }
  }
  
  final boolean bu(int paramInt)
  {
    a locala = this;
    while (paramInt >= 64)
    {
      locala.gy();
      locala = locala.abl;
      paramInt -= 64;
    }
    long l1 = 1L << paramInt;
    if ((locala.abk & l1) != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      locala.abk &= (l1 ^ 0xFFFFFFFF);
      l1 -= 1L;
      long l2 = locala.abk;
      locala.abk = (Long.rotateRight((l1 ^ 0xFFFFFFFF) & locala.abk, 1) | l2 & l1);
      if (locala.abl != null)
      {
        if (locala.abl.get(0)) {
          locala.set(63);
        }
        locala.abl.bu(0);
      }
      return bool;
    }
  }
  
  final int bv(int paramInt)
  {
    if (this.abl == null)
    {
      if (paramInt >= 64) {
        return Long.bitCount(this.abk);
      }
      return Long.bitCount(this.abk & (1L << paramInt) - 1L);
    }
    if (paramInt < 64) {
      return Long.bitCount(this.abk & (1L << paramInt) - 1L);
    }
    return this.abl.bv(paramInt - 64) + Long.bitCount(this.abk);
  }
  
  final void clear(int paramInt)
  {
    a locala = this;
    while (paramInt >= 64)
    {
      if (locala.abl == null) {
        return;
      }
      locala = locala.abl;
      paramInt -= 64;
    }
    locala.abk &= (1L << paramInt ^ 0xFFFFFFFF);
  }
  
  final boolean get(int paramInt)
  {
    a locala = this;
    while (paramInt >= 64)
    {
      locala.gy();
      locala = locala.abl;
      paramInt -= 64;
    }
    return (locala.abk & 1L << paramInt) != 0L;
  }
  
  final void o(int paramInt, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    a locala = this;
    while (paramInt >= 64)
    {
      locala.gy();
      locala = locala.abl;
      paramInt -= 64;
    }
    if ((locala.abk & 0x0) != 0L)
    {
      paramBoolean = true;
      label47:
      long l1 = (1L << paramInt) - 1L;
      long l2 = locala.abk;
      locala.abk = (((l1 ^ 0xFFFFFFFF) & locala.abk) << 1 | l2 & l1);
      if (!bool) {
        break label132;
      }
      locala.set(paramInt);
    }
    for (;;)
    {
      if ((!paramBoolean) && (locala.abl == null)) {
        return;
      }
      locala.gy();
      locala = locala.abl;
      paramInt = 0;
      bool = paramBoolean;
      break;
      paramBoolean = false;
      break label47;
      label132:
      locala.clear(paramInt);
    }
  }
  
  final void set(int paramInt)
  {
    a locala = this;
    while (paramInt >= 64)
    {
      locala.gy();
      locala = locala.abl;
      paramInt -= 64;
    }
    locala.abk |= 1L << paramInt;
  }
  
  public final String toString()
  {
    if (this.abl == null) {
      return Long.toBinaryString(this.abk);
    }
    return this.abl.toString() + "xx" + Long.toBinaryString(this.abk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.u.a
 * JD-Core Version:    0.7.0.1
 */