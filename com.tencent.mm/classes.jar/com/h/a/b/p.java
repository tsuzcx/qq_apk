package com.h.a.b;

import com.h.a.a.b.j;
import java.util.Map;

public enum p
{
  private static Map<Integer, p> ebT;
  int mId;
  int mSize;
  
  static
  {
    int i = 0;
    ebK = new p("OBJECT", 0, 2, 0);
    ebL = new p("BOOLEAN", 1, 4, 1);
    ebM = new p("CHAR", 2, 5, 2);
    ebN = new p("FLOAT", 3, 6, 4);
    ebO = new p("DOUBLE", 4, 7, 8);
    ebP = new p("BYTE", 5, 8, 1);
    ebQ = new p("SHORT", 6, 9, 2);
    ebR = new p("INT", 7, 10, 4);
    ebS = new p("LONG", 8, 11, 8);
    ebU = new p[] { ebK, ebL, ebM, ebN, ebO, ebP, ebQ, ebR, ebS };
    ebT = j.akS();
    p[] arrayOfp = values();
    int j = arrayOfp.length;
    while (i < j)
    {
      p localp = arrayOfp[i];
      ebT.put(Integer.valueOf(localp.mId), localp);
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
    switch (1.ebc[paramp.ordinal()])
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
  
  public static p lS(int paramInt)
  {
    return (p)ebT.get(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.b.p
 * JD-Core Version:    0.7.0.1
 */