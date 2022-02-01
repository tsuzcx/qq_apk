package androidx.appcompat.widget;

final class v
{
  int uE = 0;
  int uF = 0;
  int uG = -2147483648;
  int uH = -2147483648;
  int uI = 0;
  int uJ = 0;
  boolean uK = false;
  boolean uL = false;
  
  public final void p(int paramInt1, int paramInt2)
  {
    this.uG = paramInt1;
    this.uH = paramInt2;
    this.uL = true;
    if (this.uK)
    {
      if (paramInt2 != -2147483648) {
        this.uE = paramInt2;
      }
      if (paramInt1 != -2147483648) {
        this.uF = paramInt1;
      }
    }
    do
    {
      return;
      if (paramInt1 != -2147483648) {
        this.uE = paramInt1;
      }
    } while (paramInt2 == -2147483648);
    this.uF = paramInt2;
  }
  
  public final void q(int paramInt1, int paramInt2)
  {
    this.uL = false;
    if (paramInt1 != -2147483648)
    {
      this.uI = paramInt1;
      this.uE = paramInt1;
    }
    if (paramInt2 != -2147483648)
    {
      this.uJ = paramInt2;
      this.uF = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.v
 * JD-Core Version:    0.7.0.1
 */