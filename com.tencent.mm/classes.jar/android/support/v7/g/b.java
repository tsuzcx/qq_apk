package android.support.v7.g;

public final class b
  implements d
{
  int SA = -1;
  Object SB = null;
  final d Sx;
  int Sy = 0;
  int Sz = -1;
  
  public b(d paramd)
  {
    this.Sx = paramd;
  }
  
  public final void A(int paramInt1, int paramInt2)
  {
    if ((this.Sy == 2) && (this.Sz >= paramInt1) && (this.Sz <= paramInt1 + paramInt2))
    {
      this.SA += paramInt2;
      this.Sz = paramInt1;
      return;
    }
    eH();
    this.Sz = paramInt1;
    this.SA = paramInt2;
    this.Sy = 2;
  }
  
  public final void B(int paramInt1, int paramInt2)
  {
    eH();
    this.Sx.B(paramInt1, paramInt2);
  }
  
  public final void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.Sy == 3) && (paramInt1 <= this.Sz + this.SA) && (paramInt1 + paramInt2 >= this.Sz) && (this.SB == paramObject))
    {
      int i = this.Sz;
      int j = this.SA;
      this.Sz = Math.min(paramInt1, this.Sz);
      this.SA = (Math.max(i + j, paramInt1 + paramInt2) - this.Sz);
      return;
    }
    eH();
    this.Sz = paramInt1;
    this.SA = paramInt2;
    this.SB = paramObject;
    this.Sy = 3;
  }
  
  public final void eH()
  {
    if (this.Sy == 0) {
      return;
    }
    switch (this.Sy)
    {
    }
    for (;;)
    {
      this.SB = null;
      this.Sy = 0;
      return;
      this.Sx.z(this.Sz, this.SA);
      continue;
      this.Sx.A(this.Sz, this.SA);
      continue;
      this.Sx.a(this.Sz, this.SA, this.SB);
    }
  }
  
  public final void z(int paramInt1, int paramInt2)
  {
    if ((this.Sy == 1) && (paramInt1 >= this.Sz) && (paramInt1 <= this.Sz + this.SA))
    {
      this.SA += paramInt2;
      this.Sz = Math.min(paramInt1, this.Sz);
      return;
    }
    eH();
    this.Sz = paramInt1;
    this.SA = paramInt2;
    this.Sy = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.g.b
 * JD-Core Version:    0.7.0.1
 */