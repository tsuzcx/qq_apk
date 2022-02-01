package com.e.a.b;

import com.e.a.b.a.a;
import java.util.ArrayList;

public abstract class i
{
  protected final long MI;
  i ceA = null;
  private final ArrayList<i> ceB = new ArrayList();
  private ArrayList<i> ceC = null;
  protected final n cev;
  long cew;
  g cex;
  int cey = 2147483647;
  boolean cez = false;
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
    this.MI = paramLong;
    this.cev = paramn;
  }
  
  public c Bh()
  {
    return this.cex.ceo.aF(this.cew);
  }
  
  protected final long Bp()
  {
    switch (this.cex.ceo.b(p.cfn))
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 0L;
    case 1: 
      return Bt().readByte();
    case 2: 
      return Bt().readShort();
    case 4: 
      return Bt().readInt();
    }
    return Bt().readLong();
  }
  
  public final long Bs()
  {
    return this.MI & this.cex.ceo.cfe;
  }
  
  protected final a Bt()
  {
    return this.cex.ceo.ceZ;
  }
  
  protected final Object a(p paramp)
  {
    switch (1.ceD[paramp.ordinal()])
    {
    default: 
      return null;
    case 1: 
      long l = Bp();
      return this.cex.ceo.aE(l);
    case 2: 
      if (Bt().readByte() != 0) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    case 3: 
      return Character.valueOf(Bt().readChar());
    case 4: 
      return Float.valueOf(Bt().readFloat());
    case 5: 
      return Double.valueOf(Bt().readDouble());
    case 6: 
      return Byte.valueOf(Bt().readByte());
    case 7: 
      return Short.valueOf(Bt().readShort());
    case 8: 
      return Integer.valueOf(Bt().readInt());
    }
    return Long.valueOf(Bt().readLong());
  }
  
  public final long getId()
  {
    return this.MI;
  }
  
  public int getSize()
  {
    return this.mSize;
  }
  
  protected final int readUnsignedByte()
  {
    return Bt().readByte() & 0xFF;
  }
  
  protected final int readUnsignedShort()
  {
    return Bt().readShort() & 0xFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.b.i
 * JD-Core Version:    0.7.0.1
 */