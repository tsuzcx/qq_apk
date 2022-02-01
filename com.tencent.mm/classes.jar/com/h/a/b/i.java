package com.h.a.b;

import com.h.a.b.a.a;
import java.util.ArrayList;

public abstract class i
{
  protected final long dI;
  protected final n eaU;
  long eaV;
  g eaW;
  int eaX = 2147483647;
  boolean eaY = false;
  i eaZ = null;
  private final ArrayList<i> eba = new ArrayList();
  private ArrayList<i> ebb = null;
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
    this.eaU = paramn;
  }
  
  protected final Object a(p paramp)
  {
    switch (1.ebc[paramp.ordinal()])
    {
    default: 
      return null;
    case 1: 
      long l = alc();
      return this.eaW.eaN.dm(l);
    case 2: 
      if (alg().readByte() != 0) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    case 3: 
      return Character.valueOf(alg().readChar());
    case 4: 
      return Float.valueOf(alg().readFloat());
    case 5: 
      return Double.valueOf(alg().readDouble());
    case 6: 
      return Byte.valueOf(alg().readByte());
    case 7: 
      return Short.valueOf(alg().readShort());
    case 8: 
      return Integer.valueOf(alg().readInt());
    }
    return Long.valueOf(alg().readLong());
  }
  
  public c akV()
  {
    return this.eaW.eaN.dn(this.eaV);
  }
  
  protected final long alc()
  {
    switch (this.eaW.eaN.b(p.ebK))
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 0L;
    case 1: 
      return alg().readByte();
    case 2: 
      return alg().readShort();
    case 4: 
      return alg().readInt();
    }
    return alg().readLong();
  }
  
  public final long alf()
  {
    return this.dI & this.eaW.eaN.ebD;
  }
  
  protected final a alg()
  {
    return this.eaW.eaN.eby;
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
    return alg().readByte() & 0xFF;
  }
  
  protected final int readUnsignedShort()
  {
    return alg().readShort() & 0xFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.b.i
 * JD-Core Version:    0.7.0.1
 */