package com.d.a.b;

import com.d.a.b.a.a;
import java.util.ArrayList;

public abstract class i
{
  protected final long JV;
  protected final n bWA;
  long bWB;
  g bWC;
  int bWD = 2147483647;
  boolean bWE = false;
  i bWF = null;
  private final ArrayList<i> bWG = new ArrayList();
  private ArrayList<i> bWH = null;
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
    this.JV = paramLong;
    this.bWA = paramn;
  }
  
  protected final long Ae()
  {
    switch (this.bWC.bWt.b(p.bXr))
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 0L;
    case 1: 
      return Ai().readByte();
    case 2: 
      return Ai().readShort();
    case 4: 
      return Ai().readInt();
    }
    return Ai().readLong();
  }
  
  public final long Ah()
  {
    return this.JV & this.bWC.bWt.bXj;
  }
  
  protected final a Ai()
  {
    return this.bWC.bWt.bXe;
  }
  
  protected final Object a(p paramp)
  {
    switch (1.bWI[paramp.ordinal()])
    {
    default: 
      return null;
    case 1: 
      long l = Ae();
      return this.bWC.bWt.aI(l);
    case 2: 
      if (Ai().readByte() != 0) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    case 3: 
      return Character.valueOf(Ai().readChar());
    case 4: 
      return Float.valueOf(Ai().readFloat());
    case 5: 
      return Double.valueOf(Ai().readDouble());
    case 6: 
      return Byte.valueOf(Ai().readByte());
    case 7: 
      return Short.valueOf(Ai().readShort());
    case 8: 
      return Integer.valueOf(Ai().readInt());
    }
    return Long.valueOf(Ai().readLong());
  }
  
  public final long getId()
  {
    return this.JV;
  }
  
  public int getSize()
  {
    return this.mSize;
  }
  
  protected final int readUnsignedByte()
  {
    return Ai().readByte() & 0xFF;
  }
  
  protected final int readUnsignedShort()
  {
    return Ai().readShort() & 0xFFFF;
  }
  
  public c zW()
  {
    return this.bWC.bWt.aJ(this.bWB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.i
 * JD-Core Version:    0.7.0.1
 */