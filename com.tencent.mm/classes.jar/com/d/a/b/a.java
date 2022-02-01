package com.d.a.b;

public class a
  extends i
{
  public final p cjW;
  private final long cjX;
  private final int mLength;
  
  static
  {
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public a(long paramLong1, n paramn, p paramp, int paramInt, long paramLong2)
  {
    super(paramLong1, paramn);
    this.cjW = paramp;
    this.mLength = paramInt;
    this.cjX = paramLong2;
  }
  
  public final Object[] KT()
  {
    Object[] arrayOfObject = new Object[this.mLength];
    Lf().aV(this.cjX);
    int i = 0;
    while (i < this.mLength)
    {
      arrayOfObject[i] = a(this.cjW);
      i += 1;
    }
    return arrayOfObject;
  }
  
  public final c KU()
  {
    if (this.cjW == p.clp) {
      return super.KU();
    }
    return this.ckB.cks.cW(p.c(this.cjW));
  }
  
  byte[] cj(int paramInt1, int paramInt2)
  {
    Lf().aV(this.cjX);
    assert (this.cjW != p.clp);
    assert (paramInt1 + paramInt2 <= this.mLength);
    byte[] arrayOfByte = new byte[this.cjW.mSize * paramInt2];
    Lf().y(arrayOfByte, this.cjW.mSize * paramInt1, this.cjW.mSize * paramInt2);
    return arrayOfByte;
  }
  
  public final int getSize()
  {
    return this.mLength * this.ckB.cks.b(this.cjW);
  }
  
  public final String toString()
  {
    String str2 = KU().mClassName;
    String str1 = str2;
    if (str2.endsWith("[]")) {
      str1 = str2.substring(0, str2.length() - 2);
    }
    return String.format("%s[%d]@%d (0x%x)", new Object[] { str1, Integer.valueOf(this.mLength), Long.valueOf(Le()), Long.valueOf(Le()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.b.a
 * JD-Core Version:    0.7.0.1
 */