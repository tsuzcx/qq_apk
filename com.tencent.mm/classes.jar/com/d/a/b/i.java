package com.d.a.b;

import com.d.a.b.a.a;
import java.util.ArrayList;

public abstract class i
{
  protected final long KQ;
  protected final n bUi;
  long bUj;
  g bUk;
  int bUl = 2147483647;
  boolean bUm = false;
  i bUn = null;
  private final ArrayList<i> bUo = new ArrayList();
  private ArrayList<i> bUp = null;
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
    this.KQ = paramLong;
    this.bUi = paramn;
  }
  
  protected final Object a(p paramp)
  {
    switch (1.bUq[paramp.ordinal()])
    {
    default: 
      return null;
    case 1: 
      long l = zR();
      return this.bUk.bUb.aE(l);
    case 2: 
      if (zV().readByte() != 0) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    case 3: 
      return Character.valueOf(zV().readChar());
    case 4: 
      return Float.valueOf(zV().readFloat());
    case 5: 
      return Double.valueOf(zV().readDouble());
    case 6: 
      return Byte.valueOf(zV().readByte());
    case 7: 
      return Short.valueOf(zV().readShort());
    case 8: 
      return Integer.valueOf(zV().readInt());
    }
    return Long.valueOf(zV().readLong());
  }
  
  public final long getId()
  {
    return this.KQ;
  }
  
  public int getSize()
  {
    return this.mSize;
  }
  
  protected final int readUnsignedByte()
  {
    return zV().readByte() & 0xFF;
  }
  
  protected final int readUnsignedShort()
  {
    return zV().readShort() & 0xFFFF;
  }
  
  public c zJ()
  {
    return this.bUk.bUb.aF(this.bUj);
  }
  
  protected final long zR()
  {
    switch (this.bUk.bUb.b(p.bUZ))
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return 0L;
    case 1: 
      return zV().readByte();
    case 2: 
      return zV().readShort();
    case 4: 
      return zV().readInt();
    }
    return zV().readLong();
  }
  
  public final long zU()
  {
    return this.KQ & this.bUk.bUb.bUR;
  }
  
  protected final a zV()
  {
    return this.bUk.bUb.bUM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.b.i
 * JD-Core Version:    0.7.0.1
 */