package com.google.d;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ar
  extends at
{
  static final ar dPQ = new ar((byte)0);
  private final Map<String, b> dPM;
  private final Map<String, b> dPN;
  private final Map<a, b> dPO;
  private final Map<a, b> dPP;
  
  private ar()
  {
    this.dPM = new HashMap();
    this.dPN = new HashMap();
    this.dPO = new HashMap();
    this.dPP = new HashMap();
  }
  
  private ar(byte paramByte)
  {
    super(dPV);
    this.dPM = Collections.emptyMap();
    this.dPN = Collections.emptyMap();
    this.dPO = Collections.emptyMap();
    this.dPP = Collections.emptyMap();
  }
  
  public static ar ahE()
  {
    return dPQ;
  }
  
  public final b a(am.a parama, int paramInt)
  {
    return (b)this.dPO.get(new a(parama, paramInt));
  }
  
  static final class a
  {
    private final am.a dJB;
    private final int number;
    
    a(am.a parama, int paramInt)
    {
      this.dJB = parama;
      this.number = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {}
      do
      {
        return false;
        paramObject = (a)paramObject;
      } while ((this.dJB != paramObject.dJB) || (this.number != paramObject.number));
      return true;
    }
    
    public final int hashCode()
    {
      return this.dJB.hashCode() * 65535 + this.number;
    }
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.ar
 * JD-Core Version:    0.7.0.1
 */