package com.google.b;

public final class dh
{
  static final int ccb = 11;
  static final int ccc = 12;
  static final int ccd = 16;
  static final int cce = 26;
  
  static Object a(h paramh, a parama, c paramc)
  {
    switch (1.bWE[parama.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1: 
      return Double.valueOf(paramh.readDouble());
    case 2: 
      return Float.valueOf(paramh.readFloat());
    case 3: 
      return Long.valueOf(paramh.Ax());
    case 4: 
      return Long.valueOf(paramh.Aw());
    case 5: 
      return Integer.valueOf(paramh.Ay());
    case 6: 
      return Long.valueOf(paramh.Az());
    case 7: 
      return Integer.valueOf(paramh.AA());
    case 8: 
      return Boolean.valueOf(paramh.AB());
    case 9: 
      return paramh.AD();
    case 10: 
      return Integer.valueOf(paramh.AE());
    case 11: 
      return Integer.valueOf(paramh.AG());
    case 12: 
      return Long.valueOf(paramh.AH());
    case 13: 
      return Integer.valueOf(paramh.AI());
    case 14: 
      return Long.valueOf(paramh.AJ());
    case 15: 
      return paramc.d(paramh);
    case 16: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    case 17: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    }
    throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
  }
  
  static int bT(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static int hO(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int hP(int paramInt)
  {
    return paramInt >>> 3;
  }
  
  public static enum a
  {
    final dh.b ccx;
    final int ccy;
    
    private a(dh.b paramb, int paramInt)
    {
      this.ccx = paramb;
      this.ccy = paramInt;
    }
    
    public boolean Hr()
    {
      return true;
    }
  }
  
  public static enum b
  {
    private final Object bVf;
    
    private b(Object paramObject)
    {
      this.bVf = paramObject;
    }
  }
  
  static abstract enum c
  {
    private c() {}
    
    abstract Object d(h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.dh
 * JD-Core Version:    0.7.0.1
 */