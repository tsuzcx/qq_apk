package com.d.a.b;

public class a
  extends i
{
  public final p bTF;
  private final long bTG;
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
    this.bTF = paramp;
    this.mLength = paramInt;
    this.bTG = paramLong2;
  }
  
  byte[] bP(int paramInt1, int paramInt2)
  {
    zV().aG(this.bTG);
    assert (this.bTF != p.bUZ);
    assert (paramInt1 + paramInt2 <= this.mLength);
    byte[] arrayOfByte = new byte[this.bTF.mSize * paramInt2];
    zV().p(arrayOfByte, this.bTF.mSize * paramInt1, this.bTF.mSize * paramInt2);
    return arrayOfByte;
  }
  
  public final int getSize()
  {
    return this.mLength * this.bUk.bUb.b(this.bTF);
  }
  
  public final String toString()
  {
    String str2 = zJ().mClassName;
    String str1 = str2;
    if (str2.endsWith("[]")) {
      str1 = str2.substring(0, str2.length() - 2);
    }
    return String.format("%s[%d]@%d (0x%x)", new Object[] { str1, Integer.valueOf(this.mLength), Long.valueOf(zU()), Long.valueOf(zU()) });
  }
  
  public final Object[] zI()
  {
    Object[] arrayOfObject = new Object[this.mLength];
    zV().aG(this.bTG);
    int i = 0;
    while (i < this.mLength)
    {
      arrayOfObject[i] = a(this.bTF);
      i += 1;
    }
    return arrayOfObject;
  }
  
  public final c zJ()
  {
    if (this.bTF == p.bUZ) {
      return super.zJ();
    }
    return this.bUk.bUb.bA(p.c(this.bTF));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.a
 * JD-Core Version:    0.7.0.1
 */