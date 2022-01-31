package android.support.v7.h;

public final class b
  implements d
{
  final d Th;
  int Ti = 0;
  int Tj = -1;
  int Tk = -1;
  Object Tl = null;
  
  public b(d paramd)
  {
    this.Th = paramd;
  }
  
  public final void C(int paramInt1, int paramInt2)
  {
    if ((this.Ti == 1) && (paramInt1 >= this.Tj) && (paramInt1 <= this.Tj + this.Tk))
    {
      this.Tk += paramInt2;
      this.Tj = Math.min(paramInt1, this.Tj);
      return;
    }
    fu();
    this.Tj = paramInt1;
    this.Tk = paramInt2;
    this.Ti = 1;
  }
  
  public final void D(int paramInt1, int paramInt2)
  {
    if ((this.Ti == 2) && (this.Tj >= paramInt1) && (this.Tj <= paramInt1 + paramInt2))
    {
      this.Tk += paramInt2;
      this.Tj = paramInt1;
      return;
    }
    fu();
    this.Tj = paramInt1;
    this.Tk = paramInt2;
    this.Ti = 2;
  }
  
  public final void E(int paramInt1, int paramInt2)
  {
    fu();
    this.Th.E(paramInt1, paramInt2);
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.Ti == 3) && (paramInt1 <= this.Tj + this.Tk) && (paramInt1 + paramInt2 >= this.Tj) && (this.Tl == paramObject))
    {
      int i = this.Tj;
      int j = this.Tk;
      this.Tj = Math.min(paramInt1, this.Tj);
      this.Tk = (Math.max(i + j, paramInt1 + paramInt2) - this.Tj);
      return;
    }
    fu();
    this.Tj = paramInt1;
    this.Tk = paramInt2;
    this.Tl = paramObject;
    this.Ti = 3;
  }
  
  public final void fu()
  {
    if (this.Ti == 0) {
      return;
    }
    switch (this.Ti)
    {
    }
    for (;;)
    {
      this.Tl = null;
      this.Ti = 0;
      return;
      this.Th.C(this.Tj, this.Tk);
      continue;
      this.Th.D(this.Tj, this.Tk);
      continue;
      this.Th.c(this.Tj, this.Tk, this.Tl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.h.b
 * JD-Core Version:    0.7.0.1
 */