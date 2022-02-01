package com.google.b;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class an
  extends ap
{
  static final an bWc = new an((byte)0);
  private final Map<String, b> bVY;
  private final Map<String, b> bVZ;
  private final Map<a, b> bWa;
  private final Map<a, b> bWb;
  
  private an()
  {
    this.bVY = new HashMap();
    this.bVZ = new HashMap();
    this.bWa = new HashMap();
    this.bWb = new HashMap();
  }
  
  private an(byte paramByte)
  {
    super(bWh);
    this.bVY = Collections.emptyMap();
    this.bVZ = Collections.emptyMap();
    this.bWa = Collections.emptyMap();
    this.bWb = Collections.emptyMap();
  }
  
  public static an HE()
  {
    return bWc;
  }
  
  public final b a(aj.a parama, int paramInt)
  {
    return (b)this.bWa.get(new a(parama, paramInt));
  }
  
  static final class a
  {
    private final aj.a bPJ;
    private final int number;
    
    a(aj.a parama, int paramInt)
    {
      this.bPJ = parama;
      this.number = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {}
      do
      {
        return false;
        paramObject = (a)paramObject;
      } while ((this.bPJ != paramObject.bPJ) || (this.number != paramObject.number));
      return true;
    }
    
    public final int hashCode()
    {
      return this.bPJ.hashCode() * 65535 + this.number;
    }
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.an
 * JD-Core Version:    0.7.0.1
 */