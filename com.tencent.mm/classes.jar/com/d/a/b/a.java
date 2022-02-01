package com.d.a.b;

public class a
  extends i
{
  public final p bVX;
  private final long bVY;
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
    this.bVX = paramp;
    this.mLength = paramInt;
    this.bVY = paramLong2;
  }
  
  byte[] bS(int paramInt1, int paramInt2)
  {
    Ai().aK(this.bVY);
    assert (this.bVX != p.bXr);
    assert (paramInt1 + paramInt2 <= this.mLength);
    byte[] arrayOfByte = new byte[this.bVX.mSize * paramInt2];
    Ai().q(arrayOfByte, this.bVX.mSize * paramInt1, this.bVX.mSize * paramInt2);
    return arrayOfByte;
  }
  
  public final int getSize()
  {
    return this.mLength * this.bWC.bWt.b(this.bVX);
  }
  
  public final String toString()
  {
    String str2 = zW().mClassName;
    String str1 = str2;
    if (str2.endsWith("[]")) {
      str1 = str2.substring(0, str2.length() - 2);
    }
    return String.format("%s[%d]@%d (0x%x)", new Object[] { str1, Integer.valueOf(this.mLength), Long.valueOf(Ah()), Long.valueOf(Ah()) });
  }
  
  public final Object[] zV()
  {
    Object[] arrayOfObject = new Object[this.mLength];
    Ai().aK(this.bVY);
    int i = 0;
    while (i < this.mLength)
    {
      arrayOfObject[i] = a(this.bVX);
      i += 1;
    }
    return arrayOfObject;
  }
  
  public final c zW()
  {
    if (this.bVX == p.bXr) {
      return super.zW();
    }
    return this.bWC.bWt.bJ(p.c(this.bVX));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.a
 * JD-Core Version:    0.7.0.1
 */