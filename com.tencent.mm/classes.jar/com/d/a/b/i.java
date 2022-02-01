package com.d.a.b;

import com.d.a.b.a.a;
import java.util.ArrayList;

public abstract class i
{
  long ckA;
  g ckB;
  int ckC = 2147483647;
  boolean ckD = false;
  i ckE = null;
  private final ArrayList<i> ckF = new ArrayList();
  private ArrayList<i> ckG = null;
  protected final n ckz;
  protected final long dI;
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
    this.dI = paramLong;
    this.ckz = paramn;
  }
  
  public c KU()
  {
    return this.ckB.cks.aU(this.ckA);
  }
  
  protected final long Lb()
  {
    switch (this.ckB.cks.b(p.clp))
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 0L;
    case 1: 
      return Lf().readByte();
    case 2: 
      return Lf().readShort();
    case 4: 
      return Lf().readInt();
    }
    return Lf().readLong();
  }
  
  public final long Le()
  {
    return this.dI & this.ckB.cks.cli;
  }
  
  protected final a Lf()
  {
    return this.ckB.cks.cld;
  }
  
  protected final Object a(p paramp)
  {
    switch (1.ckH[paramp.ordinal()])
    {
    default: 
      return null;
    case 1: 
      long l = Lb();
      return this.ckB.cks.aT(l);
    case 2: 
      if (Lf().readByte() != 0) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    case 3: 
      return Character.valueOf(Lf().readChar());
    case 4: 
      return Float.valueOf(Lf().readFloat());
    case 5: 
      return Double.valueOf(Lf().readDouble());
    case 6: 
      return Byte.valueOf(Lf().readByte());
    case 7: 
      return Short.valueOf(Lf().readShort());
    case 8: 
      return Integer.valueOf(Lf().readInt());
    }
    return Long.valueOf(Lf().readLong());
  }
  
  public final long getId()
  {
    return this.dI;
  }
  
  public int getSize()
  {
    return this.mSize;
  }
  
  protected final int readUnsignedByte()
  {
    return Lf().readByte() & 0xFF;
  }
  
  protected final int readUnsignedShort()
  {
    return Lf().readShort() & 0xFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.b.i
 * JD-Core Version:    0.7.0.1
 */