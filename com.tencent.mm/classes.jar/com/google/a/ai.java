package com.google.a;

public class ai
{
  private static final r bNc = ;
  private g bXH;
  private r bXI;
  protected volatile aw bXJ;
  private volatile g bXK;
  
  public ai() {}
  
  public ai(r paramr, g paramg)
  {
    if (paramr == null) {
      throw new NullPointerException("found null ExtensionRegistry");
    }
    if (paramg == null) {
      throw new NullPointerException("found null ByteString");
    }
    this.bXI = paramr;
    this.bXH = paramg;
  }
  
  private void i(aw paramaw)
  {
    if (this.bXJ != null) {
      return;
    }
    try
    {
      if (this.bXJ != null) {
        return;
      }
    }
    finally {}
    try
    {
      if (this.bXH != null) {
        this.bXJ = ((aw)paramaw.AK().e(this.bXH, this.bXI));
      }
      for (this.bXK = this.bXH;; this.bXK = g.bNg)
      {
        return;
        this.bXJ = paramaw;
      }
    }
    catch (af localaf)
    {
      for (;;)
      {
        this.bXJ = paramaw;
        this.bXK = g.bNg;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ai)) {
      return false;
    }
    paramObject = (ai)paramObject;
    aw localaw1 = this.bXJ;
    aw localaw2 = paramObject.bXJ;
    if ((localaw1 == null) && (localaw2 == null)) {
      return yI().equals(paramObject.yI());
    }
    if ((localaw1 != null) && (localaw2 != null)) {
      return localaw1.equals(localaw2);
    }
    if (localaw1 != null) {
      return localaw1.equals(paramObject.g(localaw1.AP()));
    }
    return g(localaw2.AP()).equals(localaw2);
  }
  
  public final aw g(aw paramaw)
  {
    i(paramaw);
    return this.bXJ;
  }
  
  public final aw h(aw paramaw)
  {
    aw localaw = this.bXJ;
    this.bXH = null;
    this.bXK = null;
    this.bXJ = paramaw;
    return localaw;
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public final int yC()
  {
    if (this.bXK != null) {
      return this.bXK.size();
    }
    if (this.bXH != null) {
      return this.bXH.size();
    }
    if (this.bXJ != null) {
      return this.bXJ.yC();
    }
    return 0;
  }
  
  public final g yI()
  {
    if (this.bXK != null) {
      return this.bXK;
    }
    if (this.bXH != null) {
      return this.bXH;
    }
    try
    {
      if (this.bXK != null)
      {
        g localg1 = this.bXK;
        return localg1;
      }
    }
    finally {}
    if (this.bXJ == null) {}
    for (this.bXK = g.bNg;; this.bXK = this.bXJ.yI())
    {
      g localg2 = this.bXK;
      return localg2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.ai
 * JD-Core Version:    0.7.0.1
 */