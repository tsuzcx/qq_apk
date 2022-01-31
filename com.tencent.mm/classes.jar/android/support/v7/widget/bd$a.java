package android.support.v7.widget;

final class bd$a
{
  int ann = 0;
  int ano;
  int anp;
  int anq;
  int anr;
  
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
    this.ann |= paramInt;
  }
  
  final boolean jf()
  {
    if (((this.ann & 0x7) != 0) && ((this.ann & compare(this.anq, this.ano) << 0) == 0)) {}
    while ((((this.ann & 0x70) != 0) && ((this.ann & compare(this.anq, this.anp) << 4) == 0)) || (((this.ann & 0x700) != 0) && ((this.ann & compare(this.anr, this.ano) << 8) == 0)) || (((this.ann & 0x7000) != 0) && ((this.ann & compare(this.anr, this.anp) << 12) == 0))) {
      return false;
    }
    return true;
  }
  
  final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ano = paramInt1;
    this.anp = paramInt2;
    this.anq = paramInt3;
    this.anr = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.v7.widget.bd.a
 * JD-Core Version:    0.7.0.1
 */