package com.tencent.matrix.resource.c.a;

import java.util.HashMap;
import java.util.Map;

public enum c
{
  private static Map<Integer, c> bXA;
  private int mId;
  private int mSize;
  
  static
  {
    int i = 0;
    cAg = new c("OBJECT", 0, 2, 0);
    cAh = new c("BOOLEAN", 1, 4, 1);
    cAi = new c("CHAR", 2, 5, 2);
    cAj = new c("FLOAT", 3, 6, 4);
    cAk = new c("DOUBLE", 4, 7, 8);
    cAl = new c("BYTE", 5, 8, 1);
    cAm = new c("SHORT", 6, 9, 2);
    cAn = new c("INT", 7, 10, 4);
    cAo = new c("LONG", 8, 11, 8);
    cAp = new c[] { cAg, cAh, cAi, cAj, cAk, cAl, cAm, cAn, cAo };
    bXA = new HashMap();
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    while (i < j)
    {
      c localc = arrayOfc[i];
      bXA.put(Integer.valueOf(localc.mId), localc);
      i += 1;
    }
  }
  
  private c(int paramInt1, int paramInt2)
  {
    this.mId = paramInt1;
    this.mSize = paramInt2;
  }
  
  public static c hl(int paramInt)
  {
    return (c)bXA.get(Integer.valueOf(paramInt));
  }
  
  public final int getSize(int paramInt)
  {
    if (this.mSize != 0) {
      paramInt = this.mSize;
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.c.a.c
 * JD-Core Version:    0.7.0.1
 */