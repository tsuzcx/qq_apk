package com.e.a.b;

import com.e.a.a.b.j;
import java.util.Map;

public enum p
{
  private static Map<Integer, p> cfw;
  int mId;
  int mSize;
  
  static
  {
    int i = 0;
    cfn = new p("OBJECT", 0, 2, 0);
    cfo = new p("BOOLEAN", 1, 4, 1);
    cfp = new p("CHAR", 2, 5, 2);
    cfq = new p("FLOAT", 3, 6, 4);
    cfr = new p("DOUBLE", 4, 7, 8);
    cfs = new p("BYTE", 5, 8, 1);
    cft = new p("SHORT", 6, 9, 2);
    cfu = new p("INT", 7, 10, 4);
    cfv = new p("LONG", 8, 11, 8);
    cfx = new p[] { cfn, cfo, cfp, cfq, cfr, cfs, cft, cfu, cfv };
    cfw = j.Be();
    p[] arrayOfp = values();
    int j = arrayOfp.length;
    while (i < j)
    {
      p localp = arrayOfp[i];
      cfw.put(Integer.valueOf(localp.mId), localp);
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
    switch (1.ceD[paramp.ordinal()])
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
  
  public static p gj(int paramInt)
  {
    return (p)cfw.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.e.a.b.p
 * JD-Core Version:    0.7.0.1
 */