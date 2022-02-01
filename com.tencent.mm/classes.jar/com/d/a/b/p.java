package com.d.a.b;

import com.d.a.a.b.j;
import java.util.Map;

public enum p
{
  private static Map<Integer, p> cly;
  int mId;
  int mSize;
  
  static
  {
    int i = 0;
    clp = new p("OBJECT", 0, 2, 0);
    clq = new p("BOOLEAN", 1, 4, 1);
    clr = new p("CHAR", 2, 5, 2);
    cls = new p("FLOAT", 3, 6, 4);
    clt = new p("DOUBLE", 4, 7, 8);
    clu = new p("BYTE", 5, 8, 1);
    clv = new p("SHORT", 6, 9, 2);
    clw = new p("INT", 7, 10, 4);
    clx = new p("LONG", 8, 11, 8);
    clz = new p[] { clp, clq, clr, cls, clt, clu, clv, clw, clx };
    cly = j.KR();
    p[] arrayOfp = values();
    int j = arrayOfp.length;
    while (i < j)
    {
      p localp = arrayOfp[i];
      cly.put(Integer.valueOf(localp.mId), localp);
      i += 1;
    }
  }
  
  private p(int paramInt1, int paramInt2)
  {
    this.mId = paramInt1;
    this.mSize = paramInt2;
  }
  
  public static String c(p paramp)
  {
    switch (1.ckH[paramp.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("OBJECT type is not a primitive type");
    case 1: 
      return "boolean[]";
    case 2: 
      return "char[]";
    case 3: 
      return "float[]";
    case 4: 
      return "double[]";
    case 5: 
      return "byte[]";
    case 6: 
      return "short[]";
    case 7: 
      return "int[]";
    }
    return "long[]";
  }
  
  public static p in(int paramInt)
  {
    return (p)cly.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.b.p
 * JD-Core Version:    0.7.0.1
 */