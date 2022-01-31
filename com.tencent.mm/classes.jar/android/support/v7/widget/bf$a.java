package android.support.v7.widget;

final class bf$a
{
  int apE = 0;
  int apF;
  int apG;
  int apH;
  int apI;
  
  private static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return 1;
    }
    if (paramInt1 == paramInt2) {
      return 2;
    }
    return 4;
  }
  
  final void addFlags(int paramInt)
  {
    this.apE |= paramInt;
  }
  
  final boolean la()
  {
    if (((this.apE & 0x7) != 0) && ((this.apE & compare(this.apH, this.apF) << 0) == 0)) {}
    while ((((this.apE & 0x70) != 0) && ((this.apE & compare(this.apH, this.apG) << 4) == 0)) || (((this.apE & 0x700) != 0) && ((this.apE & compare(this.apI, this.apF) << 8) == 0)) || (((this.apE & 0x7000) != 0) && ((this.apE & compare(this.apI, this.apG) << 12) == 0))) {
      return false;
    }
    return true;
  }
  
  final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.apF = paramInt1;
    this.apG = paramInt2;
    this.apH = paramInt3;
    this.apI = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.widget.bf.a
 * JD-Core Version:    0.7.0.1
 */