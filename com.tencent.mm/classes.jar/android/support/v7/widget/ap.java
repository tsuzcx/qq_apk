package android.support.v7.widget;

public final class ap
{
  int Fe = -2147483648;
  int akX = -2147483648;
  int akY = 0;
  int akZ = 0;
  boolean ala = false;
  boolean mIsRtl = false;
  int qO = 0;
  int qQ = 0;
  
  public final void aE(int paramInt1, int paramInt2)
  {
    this.akX = paramInt1;
    this.Fe = paramInt2;
    this.ala = true;
    if (this.mIsRtl)
    {
      if (paramInt2 != -2147483648) {
        this.qO = paramInt2;
      }
      if (paramInt1 != -2147483648) {
        this.qQ = paramInt1;
      }
    }
    do
    {
      return;
      if (paramInt1 != -2147483648) {
        this.qO = paramInt1;
      }
    } while (paramInt2 == -2147483648);
    this.qQ = paramInt2;
  }
  
  public final void aF(int paramInt1, int paramInt2)
  {
    this.ala = false;
    if (paramInt1 != -2147483648)
    {
      this.akY = paramInt1;
      this.qO = paramInt1;
    }
    if (paramInt2 != -2147483648)
    {
      this.akZ = paramInt2;
      this.qQ = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.ap
 * JD-Core Version:    0.7.0.1
 */