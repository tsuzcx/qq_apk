package com.c.a.b;

import com.c.a.b.a.a;
import java.util.ArrayList;

public abstract class i
{
  protected final long MS;
  protected final n coZ;
  long cpa;
  g cpb;
  int cpc = 2147483647;
  boolean cpd = false;
  i cpe = null;
  private final ArrayList<i> cpf = new ArrayList();
  private ArrayList<i> cpg = null;
  int mSize;
  
  static
  {
    if (!i.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  i(long paramLong, n paramn)
  {
    this.MS = paramLong;
    this.coZ = paramn;
  }
  
  public c Ka()
  {
    return this.cpb.coS.aS(this.cpa);
  }
  
  protected final long Ki()
  {
    switch (this.cpb.coS.b(p.cpP))
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 0L;
    case 1: 
      return Kl().readByte();
    case 2: 
      return Kl().readShort();
    case 4: 
      return Kl().readInt();
    }
    return Kl().readLong();
  }
  
  protected final a Kl()
  {
    return this.cpb.coS.cpD;
  }
  
  protected final Object a(p paramp)
  {
    switch (1.cph[paramp.ordinal()])
    {
    default: 
      return null;
    case 1: 
      long l = Ki();
      return this.cpb.coS.aR(l);
    case 2: 
      if (Kl().readByte() != 0) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    case 3: 
      return Character.valueOf(Kl().readChar());
    case 4: 
      return Float.valueOf(Kl().readFloat());
    case 5: 
      return Double.valueOf(Kl().readDouble());
    case 6: 
      return Byte.valueOf(Kl().readByte());
    case 7: 
      return Short.valueOf(Kl().readShort());
    case 8: 
      return Integer.valueOf(Kl().readInt());
    }
    return Long.valueOf(Kl().readLong());
  }
  
  public final long getId()
  {
    return this.MS;
  }
  
  public int getSize()
  {
    return this.mSize;
  }
  
  public final long getUniqueId()
  {
    return this.MS & this.cpb.coS.cpI;
  }
  
  protected final int readUnsignedByte()
  {
    return Kl().readByte() & 0xFF;
  }
  
  protected final int readUnsignedShort()
  {
    return Kl().readShort() & 0xFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.b.i
 * JD-Core Version:    0.7.0.1
 */