package com.eclipsesource.a;

public final class e$a
{
  final byte[] arI = new byte[32];
  
  final int N(Object paramObject)
  {
    return paramObject.hashCode() & this.arI.length - 1;
  }
  
  final void h(String paramString, int paramInt)
  {
    int i = N(paramString);
    if (paramInt < 255)
    {
      this.arI[i] = ((byte)(paramInt + 1));
      return;
    }
    this.arI[i] = 0;
  }
  
  public final void remove(int paramInt)
  {
    int i = 0;
    if (i < this.arI.length)
    {
      if (this.arI[i] == paramInt + 1) {
        this.arI[i] = 0;
      }
      for (;;)
      {
        i += 1;
        break;
        if (this.arI[i] > paramInt + 1)
        {
          byte[] arrayOfByte = this.arI;
          arrayOfByte[i] = ((byte)(arrayOfByte[i] - 1));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.a.e.a
 * JD-Core Version:    0.7.0.1
 */