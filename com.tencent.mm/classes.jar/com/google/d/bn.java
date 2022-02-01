package com.google.d;

public class bn
{
  private static final at EMPTY_REGISTRY = ;
  private h dTh;
  private at dTi;
  protected volatile ce dTj;
  private volatile h dTk;
  
  private ce e(ce paramce)
  {
    g(paramce);
    return this.dTj;
  }
  
  private void g(ce paramce)
  {
    if (this.dTj != null) {
      return;
    }
    try
    {
      if (this.dTj != null) {
        return;
      }
    }
    finally {}
    try
    {
      if (this.dTh != null) {
        this.dTj = ((ce)paramce.getParserForType().parseFrom(this.dTh, this.dTi));
      }
      for (this.dTk = this.dTh;; this.dTk = h.dIJ)
      {
        return;
        this.dTj = paramce;
      }
    }
    catch (bk localbk)
    {
      for (;;)
      {
        this.dTj = paramce;
        this.dTk = h.dIJ;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof bn)) {
      return false;
    }
    paramObject = (bn)paramObject;
    ce localce1 = this.dTj;
    ce localce2 = paramObject.dTj;
    if ((localce1 == null) && (localce2 == null)) {
      return toByteString().equals(paramObject.toByteString());
    }
    if ((localce1 != null) && (localce2 != null)) {
      return localce1.equals(localce2);
    }
    if (localce1 != null) {
      return localce1.equals(paramObject.e(localce1.getDefaultInstanceForType()));
    }
    return e(localce2.getDefaultInstanceForType()).equals(localce2);
  }
  
  public final ce f(ce paramce)
  {
    ce localce = this.dTj;
    this.dTh = null;
    this.dTk = null;
    this.dTj = paramce;
    return localce;
  }
  
  public final int getSerializedSize()
  {
    if (this.dTk != null) {
      return this.dTk.size();
    }
    if (this.dTh != null) {
      return this.dTh.size();
    }
    if (this.dTj != null) {
      return this.dTj.getSerializedSize();
    }
    return 0;
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public final h toByteString()
  {
    if (this.dTk != null) {
      return this.dTk;
    }
    if (this.dTh != null) {
      return this.dTh;
    }
    try
    {
      if (this.dTk != null)
      {
        h localh1 = this.dTk;
        return localh1;
      }
    }
    finally {}
    if (this.dTj == null) {}
    for (this.dTk = h.dIJ;; this.dTk = this.dTj.toByteString())
    {
      h localh2 = this.dTk;
      return localh2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bn
 * JD-Core Version:    0.7.0.1
 */