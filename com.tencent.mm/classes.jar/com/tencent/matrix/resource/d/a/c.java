package com.tencent.matrix.resource.d.a;

import java.util.HashMap;
import java.util.Map;

public enum c
{
  private static Map<Integer, c> cly;
  private int mId;
  private int mSize;
  
  static
  {
    int i = 0;
    ddB = new c("OBJECT", 0, 2, 0);
    ddC = new c("BOOLEAN", 1, 4, 1);
    ddD = new c("CHAR", 2, 5, 2);
    ddE = new c("FLOAT", 3, 6, 4);
    ddF = new c("DOUBLE", 4, 7, 8);
    ddG = new c("BYTE", 5, 8, 1);
    ddH = new c("SHORT", 6, 9, 2);
    ddI = new c("INT", 7, 10, 4);
    ddJ = new c("LONG", 8, 11, 8);
    ddK = new c[] { ddB, ddC, ddD, ddE, ddF, ddG, ddH, ddI, ddJ };
    cly = new HashMap();
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    while (i < j)
    {
      c localc = arrayOfc[i];
      cly.put(Integer.valueOf(localc.mId), localc);
      i += 1;
    }
  }
  
  private c(int paramInt1, int paramInt2)
  {
    this.mId = paramInt1;
    this.mSize = paramInt2;
  }
  
  public static c jF(int paramInt)
  {
    return (c)cly.get(Integer.valueOf(paramInt));
  }
  
  public final int jG(int paramInt)
  {
    if (this.mSize != 0) {
      paramInt = this.mSize;
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.matrix.resource.d.a.c
 * JD-Core Version:    0.7.0.1
 */