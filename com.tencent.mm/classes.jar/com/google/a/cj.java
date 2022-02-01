package com.google.a;

public final class cj
{
  static final int caA = 16;
  static final int caB = 26;
  static final int cay = 11;
  static final int caz = 12;
  
  static Object a(h paramh, a parama, c paramc)
  {
    switch (1.bUG[parama.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1: 
      return Double.valueOf(paramh.readDouble());
    case 2: 
      return Float.valueOf(paramh.readFloat());
    case 3: 
      return Long.valueOf(paramh.yV());
    case 4: 
      return Long.valueOf(paramh.yU());
    case 5: 
      return Integer.valueOf(paramh.yW());
    case 6: 
      return Long.valueOf(paramh.yX());
    case 7: 
      return Integer.valueOf(paramh.yY());
    case 8: 
      return Boolean.valueOf(paramh.yZ());
    case 9: 
      return paramh.zb();
    case 10: 
      return Integer.valueOf(paramh.zc());
    case 11: 
      return Integer.valueOf(paramh.ze());
    case 12: 
      return Long.valueOf(paramh.zf());
    case 13: 
      return Integer.valueOf(paramh.zg());
    case 14: 
      return Long.valueOf(paramh.zh());
    case 15: 
      return paramc.d(paramh);
    case 16: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    case 17: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    }
    throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
  }
  
  static int bA(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static int gX(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int gY(int paramInt)
  {
    return paramInt >>> 3;
  }
  
  public static enum a
  {
    final cj.b caU;
    final int caV;
    
    private a(cj.b paramb, int paramInt)
    {
      this.caU = paramb;
      this.caV = paramInt;
    }
    
    public boolean FL()
    {
      return true;
    }
  }
  
  public static enum b
  {
    private final Object bTf;
    
    private b(Object paramObject)
    {
      this.bTf = paramObject;
    }
  }
  
  static abstract enum c
  {
    private c() {}
    
    abstract Object d(h paramh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.cj
 * JD-Core Version:    0.7.0.1
 */