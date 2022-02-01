package androidx.core.g;

public final class r
{
  private int Nr;
  private int Ns;
  
  public final void F(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      this.Ns = paramInt1;
      return;
    }
    this.Nr = paramInt1;
  }
  
  public final void bz(int paramInt)
  {
    if (paramInt == 1)
    {
      this.Ns = 0;
      return;
    }
    this.Nr = 0;
  }
  
  public final int getNestedScrollAxes()
  {
    return this.Nr | this.Ns;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.g.r
 * JD-Core Version:    0.7.0.1
 */