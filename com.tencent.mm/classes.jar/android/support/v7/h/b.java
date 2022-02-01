package android.support.v7.h;

public final class b
  implements d
{
  final d aak;
  int aal = 0;
  int aam = -1;
  int aan = -1;
  Object aao = null;
  
  public b(d paramd)
  {
    this.aak = paramd;
  }
  
  public final void E(int paramInt1, int paramInt2)
  {
    if ((this.aal == 1) && (paramInt1 >= this.aam) && (paramInt1 <= this.aam + this.aan))
    {
      this.aan += paramInt2;
      this.aam = Math.min(paramInt1, this.aam);
      return;
    }
    gQ();
    this.aam = paramInt1;
    this.aan = paramInt2;
    this.aal = 1;
  }
  
  public final void F(int paramInt1, int paramInt2)
  {
    if ((this.aal == 2) && (this.aam >= paramInt1) && (this.aam <= paramInt1 + paramInt2))
    {
      this.aan += paramInt2;
      this.aam = paramInt1;
      return;
    }
    gQ();
    this.aam = paramInt1;
    this.aan = paramInt2;
    this.aal = 2;
  }
  
  public final void G(int paramInt1, int paramInt2)
  {
    gQ();
    this.aak.G(paramInt1, paramInt2);
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.aal == 3) && (paramInt1 <= this.aam + this.aan) && (paramInt1 + paramInt2 >= this.aam) && (this.aao == paramObject))
    {
      int i = this.aam;
      int j = this.aan;
      this.aam = Math.min(paramInt1, this.aam);
      this.aan = (Math.max(i + j, paramInt1 + paramInt2) - this.aam);
      return;
    }
    gQ();
    this.aam = paramInt1;
    this.aan = paramInt2;
    this.aao = paramObject;
    this.aal = 3;
  }
  
  public final void gQ()
  {
    if (this.aal == 0) {
      return;
    }
    switch (this.aal)
    {
    }
    for (;;)
    {
      this.aao = null;
      this.aal = 0;
      return;
      this.aak.E(this.aam, this.aan);
      continue;
      this.aak.F(this.aam, this.aan);
      continue;
      this.aak.c(this.aam, this.aan, this.aao);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.h.b
 * JD-Core Version:    0.7.0.1
 */