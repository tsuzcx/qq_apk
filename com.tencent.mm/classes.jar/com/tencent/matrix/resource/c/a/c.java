package com.tencent.matrix.resource.c.a;

import java.util.HashMap;
import java.util.Map;

public enum c
{
  private static Map<Integer, c> cpY;
  private int mId;
  private int mSize;
  
  static
  {
    int i = 0;
    cZq = new c("OBJECT", 0, 2, 0);
    cZr = new c("BOOLEAN", 1, 4, 1);
    cZs = new c("CHAR", 2, 5, 2);
    cZt = new c("FLOAT", 3, 6, 4);
    cZu = new c("DOUBLE", 4, 7, 8);
    cZv = new c("BYTE", 5, 8, 1);
    cZw = new c("SHORT", 6, 9, 2);
    cZx = new c("INT", 7, 10, 4);
    cZy = new c("LONG", 8, 11, 8);
    cZz = new c[] { cZq, cZr, cZs, cZt, cZu, cZv, cZw, cZx, cZy };
    cpY = new HashMap();
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    while (i < j)
    {
      c localc = arrayOfc[i];
      cpY.put(Integer.valueOf(localc.mId), localc);
      i += 1;
    }
  }
  
  private c(int paramInt1, int paramInt2)
  {
    this.mId = paramInt1;
    this.mSize = paramInt2;
  }
  
  public static c iu(int paramInt)
  {
    return (c)cpY.get(Integer.valueOf(paramInt));
  }
  
  public final int getSize(int paramInt)
  {
    if (this.mSize != 0) {
      paramInt = this.mSize;
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.matrix.resource.c.a.c
 * JD-Core Version:    0.7.0.1
 */