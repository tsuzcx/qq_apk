package com.google.a;

public abstract class h
{
  int bNo;
  int bNp = 100;
  int bNq = 2147483647;
  boolean bNr = false;
  
  public static h B(byte[] paramArrayOfByte)
  {
    return c(paramArrayOfByte, 0, paramArrayOfByte.length, false);
  }
  
  static h c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramArrayOfByte = new h.a(paramArrayOfByte, paramInt1, paramInt2, paramBoolean, (byte)0);
    try
    {
      paramArrayOfByte.fH(paramInt2);
      return paramArrayOfByte;
    }
    catch (af paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  public abstract <T extends aw> T a(bj<T> parambj, r paramr);
  
  public abstract void a(int paramInt, aw.a parama, r paramr);
  
  public abstract void a(aw.a parama, r paramr);
  
  public abstract void fF(int paramInt);
  
  public abstract boolean fG(int paramInt);
  
  public abstract int fH(int paramInt);
  
  public abstract void fI(int paramInt);
  
  public abstract double readDouble();
  
  public abstract float readFloat();
  
  public abstract String readString();
  
  public abstract int yT();
  
  public abstract long yU();
  
  public abstract long yV();
  
  public abstract int yW();
  
  public abstract long yX();
  
  public abstract int yY();
  
  public abstract boolean yZ();
  
  public abstract String za();
  
  public abstract g zb();
  
  public abstract int zc();
  
  public abstract int zd();
  
  public abstract int ze();
  
  public abstract long zf();
  
  public abstract int zg();
  
  public abstract long zh();
  
  public abstract int zi();
  
  abstract long zj();
  
  public abstract int zk();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.h
 * JD-Core Version:    0.7.0.1
 */