package com.google.android.exoplayer2.c.c;

public final class u$d
{
  private String aDt;
  private final String aFE;
  private final int aFF;
  private final int aFG;
  private int aFH;
  
  public u$d()
  {
    this(-2147483648, 0, 1);
  }
  
  public u$d(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -2147483648) {}
    for (String str = paramInt1 + "/";; str = "")
    {
      this.aFE = str;
      this.aFF = paramInt2;
      this.aFG = paramInt3;
      this.aFH = -2147483648;
      return;
    }
  }
  
  private void mj()
  {
    if (this.aFH == -2147483648) {
      throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
    }
  }
  
  public final void mg()
  {
    if (this.aFH == -2147483648) {}
    for (int i = this.aFF;; i = this.aFH + this.aFG)
    {
      this.aFH = i;
      this.aDt = (this.aFE + this.aFH);
      return;
    }
  }
  
  public final int mh()
  {
    mj();
    return this.aFH;
  }
  
  public final String mi()
  {
    mj();
    return this.aDt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.c.c.u.d
 * JD-Core Version:    0.7.0.1
 */