package com.c.a.b;

import com.c.a.a.b.j;
import java.util.Map;

public enum p
{
  private static Map<Integer, p> cpY;
  int mId;
  int mSize;
  
  static
  {
    int i = 0;
    cpP = new p("OBJECT", 0, 2, 0);
    cpQ = new p("BOOLEAN", 1, 4, 1);
    cpR = new p("CHAR", 2, 5, 2);
    cpS = new p("FLOAT", 3, 6, 4);
    cpT = new p("DOUBLE", 4, 7, 8);
    cpU = new p("BYTE", 5, 8, 1);
    cpV = new p("SHORT", 6, 9, 2);
    cpW = new p("INT", 7, 10, 4);
    cpX = new p("LONG", 8, 11, 8);
    cpZ = new p[] { cpP, cpQ, cpR, cpS, cpT, cpU, cpV, cpW, cpX };
    cpY = j.JX();
    p[] arrayOfp = values();
    int j = arrayOfp.length;
    while (i < j)
    {
      p localp = arrayOfp[i];
      cpY.put(Integer.valueOf(localp.mId), localp);
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
    switch (1.cph[paramp.ordinal()])
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
  
  public static p hu(int paramInt)
  {
    return (p)cpY.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.b.p
 * JD-Core Version:    0.7.0.1
 */