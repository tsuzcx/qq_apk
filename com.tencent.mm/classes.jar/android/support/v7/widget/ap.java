package android.support.v7.widget;

final class ap
{
  int Af = 0;
  int Ah = 0;
  int OQ = -2147483648;
  int avj = -2147483648;
  int avk = 0;
  int avl = 0;
  boolean avm = false;
  boolean mIsRtl = false;
  
  public final void aG(int paramInt1, int paramInt2)
  {
    this.avj = paramInt1;
    this.OQ = paramInt2;
    this.avm = true;
    if (this.mIsRtl)
    {
      if (paramInt2 != -2147483648) {
        this.Af = paramInt2;
      }
      if (paramInt1 != -2147483648) {
        this.Ah = paramInt1;
      }
    }
    do
    {
      return;
      if (paramInt1 != -2147483648) {
        this.Af = paramInt1;
      }
    } while (paramInt2 == -2147483648);
    this.Ah = paramInt2;
  }
  
  public final void aH(int paramInt1, int paramInt2)
  {
    this.avm = false;
    if (paramInt1 != -2147483648)
    {
      this.avk = paramInt1;
      this.Af = paramInt1;
    }
    if (paramInt2 != -2147483648)
    {
      this.avl = paramInt2;
      this.Ah = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ap
 * JD-Core Version:    0.7.0.1
 */