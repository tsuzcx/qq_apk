package android.support.v7.h;

public final class b
  implements d
{
  final d abf;
  int abg = 0;
  int abh = -1;
  int abj = -1;
  Object abk = null;
  
  public b(d paramd)
  {
    this.abf = paramd;
  }
  
  public final void E(int paramInt1, int paramInt2)
  {
    if ((this.abg == 1) && (paramInt1 >= this.abh) && (paramInt1 <= this.abh + this.abj))
    {
      this.abj += paramInt2;
      this.abh = Math.min(paramInt1, this.abh);
      return;
    }
    gY();
    this.abh = paramInt1;
    this.abj = paramInt2;
    this.abg = 1;
  }
  
  public final void F(int paramInt1, int paramInt2)
  {
    if ((this.abg == 2) && (this.abh >= paramInt1) && (this.abh <= paramInt1 + paramInt2))
    {
      this.abj += paramInt2;
      this.abh = paramInt1;
      return;
    }
    gY();
    this.abh = paramInt1;
    this.abj = paramInt2;
    this.abg = 2;
  }
  
  public final void G(int paramInt1, int paramInt2)
  {
    gY();
    this.abf.G(paramInt1, paramInt2);
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.abg == 3) && (paramInt1 <= this.abh + this.abj) && (paramInt1 + paramInt2 >= this.abh) && (this.abk == paramObject))
    {
      int i = this.abh;
      int j = this.abj;
      this.abh = Math.min(paramInt1, this.abh);
      this.abj = (Math.max(i + j, paramInt1 + paramInt2) - this.abh);
      return;
    }
    gY();
    this.abh = paramInt1;
    this.abj = paramInt2;
    this.abk = paramObject;
    this.abg = 3;
  }
  
  public final void gY()
  {
    if (this.abg == 0) {
      return;
    }
    switch (this.abg)
    {
    }
    for (;;)
    {
      this.abk = null;
      this.abg = 0;
      return;
      this.abf.E(this.abh, this.abj);
      continue;
      this.abf.F(this.abh, this.abj);
      continue;
      this.abf.c(this.abh, this.abj, this.abk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.h.b
 * JD-Core Version:    0.7.0.1
 */