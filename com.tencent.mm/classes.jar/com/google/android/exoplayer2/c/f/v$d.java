package com.google.android.exoplayer2.c.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v$d
{
  private String aKf;
  private final String aMs;
  private final int aMt;
  private final int aMu;
  private int aMv;
  
  public v$d(int paramInt1, int paramInt2)
  {
    this(-2147483648, paramInt1, paramInt2);
  }
  
  public v$d(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(95179);
    if (paramInt1 != -2147483648) {}
    for (String str = paramInt1 + "/";; str = "")
    {
      this.aMs = str;
      this.aMt = paramInt2;
      this.aMu = paramInt3;
      this.aMv = -2147483648;
      AppMethodBeat.o(95179);
      return;
    }
  }
  
  private void oA()
  {
    AppMethodBeat.i(95183);
    if (this.aMv == -2147483648)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("generateNewId() must be called before retrieving ids.");
      AppMethodBeat.o(95183);
      throw localIllegalStateException;
    }
    AppMethodBeat.o(95183);
  }
  
  public final void ox()
  {
    AppMethodBeat.i(95180);
    if (this.aMv == -2147483648) {}
    for (int i = this.aMt;; i = this.aMv + this.aMu)
    {
      this.aMv = i;
      this.aKf = (this.aMs + this.aMv);
      AppMethodBeat.o(95180);
      return;
    }
  }
  
  public final int oy()
  {
    AppMethodBeat.i(95181);
    oA();
    int i = this.aMv;
    AppMethodBeat.o(95181);
    return i;
  }
  
  public final String oz()
  {
    AppMethodBeat.i(95182);
    oA();
    String str = this.aKf;
    AppMethodBeat.o(95182);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.c.f.v.d
 * JD-Core Version:    0.7.0.1
 */