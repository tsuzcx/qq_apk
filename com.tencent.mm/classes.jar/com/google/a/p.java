package com.google.a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class p
  extends r
{
  static final p bUc = new p((byte)0);
  private final Map<String, b> bTY;
  private final Map<String, b> bTZ;
  private final Map<a, b> bUa;
  private final Map<a, b> bUb;
  
  private p()
  {
    this.bTY = new HashMap();
    this.bTZ = new HashMap();
    this.bUa = new HashMap();
    this.bUb = new HashMap();
  }
  
  private p(byte paramByte)
  {
    super(bUj);
    this.bTY = Collections.emptyMap();
    this.bTZ = Collections.emptyMap();
    this.bUa = Collections.emptyMap();
    this.bUb = Collections.emptyMap();
  }
  
  public static p FY()
  {
    return bUc;
  }
  
  public final b a(l.a parama, int paramInt)
  {
    return (b)this.bUa.get(new a(parama, paramInt));
  }
  
  static final class a
  {
    private final l.a bNK;
    private final int number;
    
    a(l.a parama, int paramInt)
    {
      this.bNK = parama;
      this.number = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {}
      do
      {
        return false;
        paramObject = (a)paramObject;
      } while ((this.bNK != paramObject.bNK) || (this.number != paramObject.number));
      return true;
    }
    
    public final int hashCode()
    {
      return this.bNK.hashCode() * 65535 + this.number;
    }
  }
  
  public static final class b
  {
    public final l.f bUd;
    public final at bUe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.p
 * JD-Core Version:    0.7.0.1
 */