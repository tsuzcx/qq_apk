package android.support.v7.widget;

final class ap
{
  int Al = 0;
  int An = 0;
  int Pc = -2147483648;
  int avh = -2147483648;
  int avi = 0;
  int avj = 0;
  boolean avk = false;
  boolean mIsRtl = false;
  
  public final void aA(int paramInt1, int paramInt2)
  {
    this.avh = paramInt1;
    this.Pc = paramInt2;
    this.avk = true;
    if (this.mIsRtl)
    {
      if (paramInt2 != -2147483648) {
        this.Al = paramInt2;
      }
      if (paramInt1 != -2147483648) {
        this.An = paramInt1;
      }
    }
    do
    {
      return;
      if (paramInt1 != -2147483648) {
        this.Al = paramInt1;
      }
    } while (paramInt2 == -2147483648);
    this.An = paramInt2;
  }
  
  public final void aB(int paramInt1, int paramInt2)
  {
    this.avk = false;
    if (paramInt1 != -2147483648)
    {
      this.avi = paramInt1;
      this.Al = paramInt1;
    }
    if (paramInt2 != -2147483648)
    {
      this.avj = paramInt2;
      this.An = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ap
 * JD-Core Version:    0.7.0.1
 */