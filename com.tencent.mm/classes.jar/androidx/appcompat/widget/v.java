package androidx.appcompat.widget;

final class v
{
  int tF = 0;
  int tG = 0;
  int tH = -2147483648;
  int tI = -2147483648;
  int tJ = 0;
  int tK = 0;
  boolean tL = false;
  boolean tM = false;
  
  public final void k(int paramInt1, int paramInt2)
  {
    this.tH = paramInt1;
    this.tI = paramInt2;
    this.tM = true;
    if (this.tL)
    {
      if (paramInt2 != -2147483648) {
        this.tF = paramInt2;
      }
      if (paramInt1 != -2147483648) {
        this.tG = paramInt1;
      }
    }
    do
    {
      return;
      if (paramInt1 != -2147483648) {
        this.tF = paramInt1;
      }
    } while (paramInt2 == -2147483648);
    this.tG = paramInt2;
  }
  
  public final void l(int paramInt1, int paramInt2)
  {
    this.tM = false;
    if (paramInt1 != -2147483648)
    {
      this.tJ = paramInt1;
      this.tF = paramInt1;
    }
    if (paramInt2 != -2147483648)
    {
      this.tK = paramInt2;
      this.tG = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.v
 * JD-Core Version:    0.7.0.1
 */