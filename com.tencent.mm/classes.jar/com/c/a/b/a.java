package com.c.a.b;

public class a
  extends i
{
  public final p cow;
  private final long cox;
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
    this.cow = paramp;
    this.mLength = paramInt;
    this.cox = paramLong2;
  }
  
  public final Object[] JZ()
  {
    Object[] arrayOfObject = new Object[this.mLength];
    Kl().aT(this.cox);
    int i = 0;
    while (i < this.mLength)
    {
      arrayOfObject[i] = a(this.cow);
      i += 1;
    }
    return arrayOfObject;
  }
  
  public final c Ka()
  {
    if (this.cow == p.cpP) {
      return super.Ka();
    }
    return this.cpb.coS.cJ(p.c(this.cow));
  }
  
  byte[] bR(int paramInt1, int paramInt2)
  {
    Kl().aT(this.cox);
    assert (this.cow != p.cpP);
    assert (paramInt1 + paramInt2 <= this.mLength);
    byte[] arrayOfByte = new byte[this.cow.mSize * paramInt2];
    Kl().y(arrayOfByte, this.cow.mSize * paramInt1, this.cow.mSize * paramInt2);
    return arrayOfByte;
  }
  
  public final int getSize()
  {
    return this.mLength * this.cpb.coS.b(this.cow);
  }
  
  public final String toString()
  {
    String str2 = Ka().mClassName;
    String str1 = str2;
    if (str2.endsWith("[]")) {
      str1 = str2.substring(0, str2.length() - 2);
    }
    return String.format("%s[%d]@%d (0x%x)", new Object[] { str1, Integer.valueOf(this.mLength), Long.valueOf(getUniqueId()), Long.valueOf(getUniqueId()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.b.a
 * JD-Core Version:    0.7.0.1
 */