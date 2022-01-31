package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
{
  private int aJm;
  public int aJn;
  public int aJo;
  public byte[] data;
  
  public l() {}
  
  public l(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.i(95893);
    AppMethodBeat.o(95893);
  }
  
  public l(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.aJm = paramInt;
  }
  
  private void qK()
  {
    AppMethodBeat.i(95896);
    int i = this.aJo + 1;
    this.aJo = i;
    if (i == 8)
    {
      this.aJo = 0;
      this.aJn += 1;
    }
    ok();
    AppMethodBeat.o(95896);
  }
  
  public final int dD(int paramInt)
  {
    AppMethodBeat.i(95899);
    if (paramInt == 0)
    {
      AppMethodBeat.o(95899);
      return 0;
    }
    this.aJo += paramInt;
    int i = 0;
    while (this.aJo > 8)
    {
      this.aJo -= 8;
      byte[] arrayOfByte = this.data;
      j = this.aJn;
      this.aJn = (j + 1);
      i |= (arrayOfByte[j] & 0xFF) << this.aJo;
    }
    int j = this.data[this.aJn];
    int k = this.aJo;
    if (this.aJo == 8)
    {
      this.aJo = 0;
      this.aJn += 1;
    }
    ok();
    AppMethodBeat.o(95899);
    return (i | (j & 0xFF) >> 8 - k) & -1 >>> 32 - paramInt;
  }
  
  public final void dE(int paramInt)
  {
    AppMethodBeat.i(95897);
    int i = paramInt / 8;
    this.aJn += i;
    this.aJo = (paramInt - i * 8 + this.aJo);
    if (this.aJo > 7)
    {
      this.aJn += 1;
      this.aJo -= 8;
    }
    ok();
    AppMethodBeat.o(95897);
  }
  
  public final void l(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.aJn = 0;
    this.aJo = 0;
    this.aJm = paramInt;
  }
  
  public final void m(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(95901);
    if (this.aJo == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      System.arraycopy(this.data, this.aJn, paramArrayOfByte, 0, paramInt);
      this.aJn += paramInt;
      ok();
      AppMethodBeat.o(95901);
      return;
    }
  }
  
  public final boolean oj()
  {
    AppMethodBeat.i(95898);
    if ((this.data[this.aJn] & 128 >> this.aJo) != 0) {}
    for (boolean bool = true;; bool = false)
    {
      qK();
      AppMethodBeat.o(95898);
      return bool;
    }
  }
  
  public final void ok()
  {
    AppMethodBeat.i(95902);
    if ((this.aJn >= 0) && ((this.aJn < this.aJm) || ((this.aJn == this.aJm) && (this.aJo == 0)))) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      AppMethodBeat.o(95902);
      return;
    }
  }
  
  public final int qI()
  {
    return (this.aJm - this.aJn) * 8 - this.aJo;
  }
  
  public final int qJ()
  {
    AppMethodBeat.i(95894);
    if (this.aJo == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      int i = this.aJn;
      AppMethodBeat.o(95894);
      return i;
    }
  }
  
  public final void qL()
  {
    AppMethodBeat.i(95900);
    if (this.aJo == 0)
    {
      AppMethodBeat.o(95900);
      return;
    }
    this.aJo = 0;
    this.aJn += 1;
    ok();
    AppMethodBeat.o(95900);
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(95895);
    this.aJn = (paramInt / 8);
    this.aJo = (paramInt - this.aJn * 8);
    ok();
    AppMethodBeat.o(95895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.i.l
 * JD-Core Version:    0.7.0.1
 */