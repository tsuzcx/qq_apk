package com.tencent.mm.modelvoiceaddr.a;

public final class a
{
  int eMv = 0;
  int eMw = 0;
  int eMx = 0;
  short[] eMy;
  
  public a(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 1) {
      i = 512;
    }
    this.eMy = new short[i];
  }
  
  final int c(short[] paramArrayOfShort, int paramInt)
  {
    if (paramInt > paramArrayOfShort.length) {
      paramInt = paramArrayOfShort.length;
    }
    for (;;)
    {
      if (paramInt == 0) {
        return 0;
      }
      int i = this.eMy.length;
      if (paramInt < this.eMx)
      {
        if (paramInt > i - this.eMv) {
          break label96;
        }
        System.arraycopy(this.eMy, this.eMv, paramArrayOfShort, 0, paramInt);
        this.eMv += paramInt;
        if (this.eMv < i) {}
      }
      label96:
      int j;
      for (this.eMv = 0;; this.eMv = j)
      {
        this.eMx -= paramInt;
        return paramInt;
        paramInt = this.eMx;
        break;
        i -= this.eMv;
        System.arraycopy(this.eMy, this.eMv, paramArrayOfShort, 0, i);
        j = paramInt - i;
        System.arraycopy(this.eMy, 0, paramArrayOfShort, i, j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.a.a
 * JD-Core Version:    0.7.0.1
 */