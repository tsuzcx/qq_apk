package com.e.a.b;

public class a
  extends i
{
  public final p cdS;
  private final long cdT;
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
    this.cdS = paramp;
    this.mLength = paramInt;
    this.cdT = paramLong2;
  }
  
  public final Object[] Bg()
  {
    Object[] arrayOfObject = new Object[this.mLength];
    Bt().aG(this.cdT);
    int i = 0;
    while (i < this.mLength)
    {
      arrayOfObject[i] = a(this.cdS);
      i += 1;
    }
    return arrayOfObject;
  }
  
  public final c Bh()
  {
    if (this.cdS == p.cfn) {
      return super.Bh();
    }
    return this.cex.ceo.cu(p.c(this.cdS));
  }
  
  byte[] bR(int paramInt1, int paramInt2)
  {
    Bt().aG(this.cdT);
    assert (this.cdS != p.cfn);
    assert (paramInt1 + paramInt2 <= this.mLength);
    byte[] arrayOfByte = new byte[this.cdS.mSize * paramInt2];
    Bt().p(arrayOfByte, this.cdS.mSize * paramInt1, this.cdS.mSize * paramInt2);
    return arrayOfByte;
  }
  
  public final int getSize()
  {
    return this.mLength * this.cex.ceo.b(this.cdS);
  }
  
  public final String toString()
  {
    String str2 = Bh().mClassName;
    String str1 = str2;
    if (str2.endsWith("[]")) {
      str1 = str2.substring(0, str2.length() - 2);
    }
    return String.format("%s[%d]@%d (0x%x)", new Object[] { str1, Integer.valueOf(this.mLength), Long.valueOf(Bs()), Long.valueOf(Bs()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.b.a
 * JD-Core Version:    0.7.0.1
 */