package com.google.b;

public class bi
{
  private static final ap bPb = ;
  protected volatile bw bZA;
  private volatile g bZB;
  private g bZy;
  private ap bZz;
  
  private bw f(bw parambw)
  {
    h(parambw);
    return this.bZA;
  }
  
  private void h(bw parambw)
  {
    if (this.bZA != null) {
      return;
    }
    try
    {
      if (this.bZA != null) {
        return;
      }
    }
    finally {}
    try
    {
      if (this.bZy != null) {
        this.bZA = ((bw)parambw.Co().b(this.bZy, this.bZz));
      }
      for (this.bZB = this.bZy;; this.bZB = g.bPf)
      {
        return;
        this.bZA = parambw;
      }
    }
    catch (bf localbf)
    {
      for (;;)
      {
        this.bZA = parambw;
        this.bZB = g.bPf;
      }
    }
  }
  
  public final int Ad()
  {
    if (this.bZB != null) {
      return this.bZB.size();
    }
    if (this.bZy != null) {
      return this.bZy.size();
    }
    if (this.bZA != null) {
      return this.bZA.Ad();
    }
    return 0;
  }
  
  public final g Aj()
  {
    if (this.bZB != null) {
      return this.bZB;
    }
    if (this.bZy != null) {
      return this.bZy;
    }
    try
    {
      if (this.bZB != null)
      {
        g localg1 = this.bZB;
        return localg1;
      }
    }
    finally {}
    if (this.bZA == null) {}
    for (this.bZB = g.bPf;; this.bZB = this.bZA.Aj())
    {
      g localg2 = this.bZB;
      return localg2;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof bi)) {
      return false;
    }
    paramObject = (bi)paramObject;
    bw localbw1 = this.bZA;
    bw localbw2 = paramObject.bZA;
    if ((localbw1 == null) && (localbw2 == null)) {
      return Aj().equals(paramObject.Aj());
    }
    if ((localbw1 != null) && (localbw2 != null)) {
      return localbw1.equals(localbw2);
    }
    if (localbw1 != null) {
      return localbw1.equals(paramObject.f(localbw1.Cs()));
    }
    return f(localbw2.Cs()).equals(localbw2);
  }
  
  public final bw g(bw parambw)
  {
    bw localbw = this.bZA;
    this.bZy = null;
    this.bZB = null;
    this.bZA = parambw;
    return localbw;
  }
  
  public int hashCode()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.bi
 * JD-Core Version:    0.7.0.1
 */