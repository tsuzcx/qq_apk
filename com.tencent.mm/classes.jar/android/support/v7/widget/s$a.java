package android.support.v7.widget;

final class s$a
{
  long abV = 0L;
  a abW;
  
  private void hy()
  {
    if (this.abW == null) {
      this.abW = new a();
    }
  }
  
  final boolean bu(int paramInt)
  {
    a locala = this;
    while (paramInt >= 64)
    {
      locala.hy();
      locala = locala.abW;
      paramInt -= 64;
    }
    long l1 = 1L << paramInt;
    if ((locala.abV & l1) != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      locala.abV &= (l1 ^ 0xFFFFFFFF);
      l1 -= 1L;
      long l2 = locala.abV;
      locala.abV = (Long.rotateRight((l1 ^ 0xFFFFFFFF) & locala.abV, 1) | l2 & l1);
      if (locala.abW != null)
      {
        if (locala.abW.get(0)) {
          locala.set(63);
        }
        locala.abW.bu(0);
      }
      return bool;
    }
  }
  
  final int bv(int paramInt)
  {
    if (this.abW == null)
    {
      if (paramInt >= 64) {
        return Long.bitCount(this.abV);
      }
      return Long.bitCount(this.abV & (1L << paramInt) - 1L);
    }
    if (paramInt < 64) {
      return Long.bitCount(this.abV & (1L << paramInt) - 1L);
    }
    return this.abW.bv(paramInt - 64) + Long.bitCount(this.abV);
  }
  
  final void clear(int paramInt)
  {
    a locala = this;
    while (paramInt >= 64)
    {
      if (locala.abW == null) {
        return;
      }
      locala = locala.abW;
      paramInt -= 64;
    }
    locala.abV &= (1L << paramInt ^ 0xFFFFFFFF);
  }
  
  final boolean get(int paramInt)
  {
    a locala = this;
    while (paramInt >= 64)
    {
      locala.hy();
      locala = locala.abW;
      paramInt -= 64;
    }
    return (locala.abV & 1L << paramInt) != 0L;
  }
  
  final void i(int paramInt, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    a locala = this;
    while (paramInt >= 64)
    {
      locala.hy();
      locala = locala.abW;
      paramInt -= 64;
    }
    if ((locala.abV & 0x0) != 0L)
    {
      paramBoolean = true;
      label47:
      long l1 = (1L << paramInt) - 1L;
      long l2 = locala.abV;
      locala.abV = (((l1 ^ 0xFFFFFFFF) & locala.abV) << 1 | l2 & l1);
      if (!bool) {
        break label132;
      }
      locala.set(paramInt);
    }
    for (;;)
    {
      if ((!paramBoolean) && (locala.abW == null)) {
        return;
      }
      locala.hy();
      locala = locala.abW;
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
      locala.hy();
      locala = locala.abW;
      paramInt -= 64;
    }
    locala.abV |= 1L << paramInt;
  }
  
  public final String toString()
  {
    if (this.abW == null) {
      return Long.toBinaryString(this.abV);
    }
    return this.abW.toString() + "xx" + Long.toBinaryString(this.abV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.s.a
 * JD-Core Version:    0.7.0.1
 */