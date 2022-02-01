package com.h.a.b;

public class a
  extends i
{
  public final p ear;
  private final long eas;
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
    this.ear = paramp;
    this.mLength = paramInt;
    this.eas = paramLong2;
  }
  
  public final Object[] akU()
  {
    Object[] arrayOfObject = new Object[this.mLength];
    alg().jdMethod_do(this.eas);
    int i = 0;
    while (i < this.mLength)
    {
      arrayOfObject[i] = a(this.ear);
      i += 1;
    }
    return arrayOfObject;
  }
  
  public final c akV()
  {
    if (this.ear == p.ebK) {
      return super.akV();
    }
    return this.eaW.eaN.eq(p.c(this.ear));
  }
  
  byte[] cW(int paramInt1, int paramInt2)
  {
    alg().jdMethod_do(this.eas);
    assert (this.ear != p.ebK);
    assert (paramInt1 + paramInt2 <= this.mLength);
    byte[] arrayOfByte = new byte[this.ear.mSize * paramInt2];
    alg().w(arrayOfByte, this.ear.mSize * paramInt1, this.ear.mSize * paramInt2);
    return arrayOfByte;
  }
  
  public final int getSize()
  {
    return this.mLength * this.eaW.eaN.b(this.ear);
  }
  
  public final String toString()
  {
    String str2 = akV().mClassName;
    String str1 = str2;
    if (str2.endsWith("[]")) {
      str1 = str2.substring(0, str2.length() - 2);
    }
    return String.format("%s[%d]@%d (0x%x)", new Object[] { str1, Integer.valueOf(this.mLength), Long.valueOf(alf()), Long.valueOf(alf()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.b.a
 * JD-Core Version:    0.7.0.1
 */