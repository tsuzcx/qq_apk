package com.google.d;

public final class du
{
  static final int dWC = 11;
  static final int dWD = 12;
  static final int dWE = 16;
  static final int dWF = 26;
  
  static Object a(i parami, a parama, c paramc)
  {
    switch (1.dJl[parama.ordinal()])
    {
    default: 
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1: 
      return Double.valueOf(parami.readDouble());
    case 2: 
      return Float.valueOf(parami.readFloat());
    case 3: 
      return Long.valueOf(parami.aae());
    case 4: 
      return Long.valueOf(parami.aad());
    case 5: 
      return Integer.valueOf(parami.aaf());
    case 6: 
      return Long.valueOf(parami.aag());
    case 7: 
      return Integer.valueOf(parami.aah());
    case 8: 
      return Boolean.valueOf(parami.aai());
    case 9: 
      return parami.aak();
    case 10: 
      return Integer.valueOf(parami.aal());
    case 11: 
      return Integer.valueOf(parami.aan());
    case 12: 
      return Long.valueOf(parami.aao());
    case 13: 
      return Integer.valueOf(parami.aap());
    case 14: 
      return Long.valueOf(parami.aaq());
    case 15: 
      return paramc.c(parami);
    case 16: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    case 17: 
      throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    }
    throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
  }
  
  static int cU(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static int lD(int paramInt)
  {
    return paramInt & 0x7;
  }
  
  public static int lE(int paramInt)
  {
    return paramInt >>> 3;
  }
  
  public static enum a
  {
    final du.b dWY;
    final int dWZ;
    
    private a(du.b paramb, int paramInt)
    {
      this.dWY = paramb;
      this.dWZ = paramInt;
    }
    
    public boolean ahn()
    {
      return true;
    }
  }
  
  public static enum b
  {
    private final Object dOS;
    
    private b(Object paramObject)
    {
      this.dOS = paramObject;
    }
  }
  
  static abstract enum c
  {
    private c() {}
    
    abstract Object c(i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.du
 * JD-Core Version:    0.7.0.1
 */