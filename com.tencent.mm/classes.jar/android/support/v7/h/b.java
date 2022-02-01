package android.support.v7.h;

public final class b
  implements d
{
  final d adk;
  int adl = 0;
  int adm = -1;
  int adn = -1;
  Object ado = null;
  
  public b(d paramd)
  {
    this.adk = paramd;
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.adl == 3) && (paramInt1 <= this.adm + this.adn) && (paramInt1 + paramInt2 >= this.adm) && (this.ado == paramObject))
    {
      int i = this.adm;
      int j = this.adn;
      this.adm = Math.min(paramInt1, this.adm);
      this.adn = (Math.max(i + j, paramInt1 + paramInt2) - this.adm);
      return;
    }
    hz();
    this.adm = paramInt1;
    this.adn = paramInt2;
    this.ado = paramObject;
    this.adl = 3;
  }
  
  public final void f(int paramInt1, int paramInt2)
  {
    if ((this.adl == 1) && (paramInt1 >= this.adm) && (paramInt1 <= this.adm + this.adn))
    {
      this.adn += paramInt2;
      this.adm = Math.min(paramInt1, this.adm);
      return;
    }
    hz();
    this.adm = paramInt1;
    this.adn = paramInt2;
    this.adl = 1;
  }
  
  public final void hz()
  {
    if (this.adl == 0) {
      return;
    }
    switch (this.adl)
    {
    }
    for (;;)
    {
      this.ado = null;
      this.adl = 0;
      return;
      this.adk.f(this.adm, this.adn);
      continue;
      this.adk.k(this.adm, this.adn);
      continue;
      this.adk.c(this.adm, this.adn, this.ado);
    }
  }
  
  public final void k(int paramInt1, int paramInt2)
  {
    if ((this.adl == 2) && (this.adm >= paramInt1) && (this.adm <= paramInt1 + paramInt2))
    {
      this.adn += paramInt2;
      this.adm = paramInt1;
      return;
    }
    hz();
    this.adm = paramInt1;
    this.adn = paramInt2;
    this.adl = 2;
  }
  
  public final void l(int paramInt1, int paramInt2)
  {
    hz();
    this.adk.l(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.h.b
 * JD-Core Version:    0.7.0.1
 */