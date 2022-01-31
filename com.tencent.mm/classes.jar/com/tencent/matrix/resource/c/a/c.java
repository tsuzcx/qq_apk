package com.tencent.matrix.resource.c.a;

import java.util.HashMap;
import java.util.Map;

public enum c
{
  private static Map<Integer, c> bpM;
  private int mId;
  private int mSize;
  
  static
  {
    int i = 0;
    bpD = new c("OBJECT", 0, 2, 0);
    bpE = new c("BOOLEAN", 1, 4, 1);
    bpF = new c("CHAR", 2, 5, 2);
    bpG = new c("FLOAT", 3, 6, 4);
    bpH = new c("DOUBLE", 4, 7, 8);
    bpI = new c("BYTE", 5, 8, 1);
    bpJ = new c("SHORT", 6, 9, 2);
    bpK = new c("INT", 7, 10, 4);
    bpL = new c("LONG", 8, 11, 8);
    bpN = new c[] { bpD, bpE, bpF, bpG, bpH, bpI, bpJ, bpK, bpL };
    bpM = new HashMap();
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    while (i < j)
    {
      c localc = arrayOfc[i];
      bpM.put(Integer.valueOf(localc.mId), localc);
      i += 1;
    }
  }
  
  private c(int paramInt1, int paramInt2)
  {
    this.mId = paramInt1;
    this.mSize = paramInt2;
  }
  
  public static c ef(int paramInt)
  {
    return (c)bpM.get(Integer.valueOf(paramInt));
  }
  
  public final int getSize(int paramInt)
  {
    if (this.mSize != 0) {
      paramInt = this.mSize;
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.c.a.c
 * JD-Core Version:    0.7.0.1
 */