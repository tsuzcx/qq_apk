package android.support.v7.widget;

final class ap
{
  int MZ = -2147483648;
  int atr = -2147483648;
  int ats = 0;
  int att = 0;
  boolean atu = false;
  boolean mIsRtl = false;
  int ym = 0;
  int yo = 0;
  
  public final void aF(int paramInt1, int paramInt2)
  {
    this.atr = paramInt1;
    this.MZ = paramInt2;
    this.atu = true;
    if (this.mIsRtl)
    {
      if (paramInt2 != -2147483648) {
        this.ym = paramInt2;
      }
      if (paramInt1 != -2147483648) {
        this.yo = paramInt1;
      }
    }
    do
    {
      return;
      if (paramInt1 != -2147483648) {
        this.ym = paramInt1;
      }
    } while (paramInt2 == -2147483648);
    this.yo = paramInt2;
  }
  
  public final void aG(int paramInt1, int paramInt2)
  {
    this.atu = false;
    if (paramInt1 != -2147483648)
    {
      this.ats = paramInt1;
      this.ym = paramInt1;
    }
    if (paramInt2 != -2147483648)
    {
      this.att = paramInt2;
      this.yo = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ap
 * JD-Core Version:    0.7.0.1
 */