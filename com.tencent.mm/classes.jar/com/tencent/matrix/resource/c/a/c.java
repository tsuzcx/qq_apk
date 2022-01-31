package com.tencent.matrix.resource.c.a;

import java.util.HashMap;
import java.util.Map;

public enum c
{
  private static Map<Integer, c> bPN;
  private int mId;
  private int mSize;
  
  static
  {
    int i = 0;
    bPE = new c("OBJECT", 0, 2, 0);
    bPF = new c("BOOLEAN", 1, 4, 1);
    bPG = new c("CHAR", 2, 5, 2);
    bPH = new c("FLOAT", 3, 6, 4);
    bPI = new c("DOUBLE", 4, 7, 8);
    bPJ = new c("BYTE", 5, 8, 1);
    bPK = new c("SHORT", 6, 9, 2);
    bPL = new c("INT", 7, 10, 4);
    bPM = new c("LONG", 8, 11, 8);
    bPO = new c[] { bPE, bPF, bPG, bPH, bPI, bPJ, bPK, bPL, bPM };
    bPN = new HashMap();
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    while (i < j)
    {
      c localc = arrayOfc[i];
      bPN.put(Integer.valueOf(localc.mId), localc);
      i += 1;
    }
  }
  
  private c(int paramInt1, int paramInt2)
  {
    this.mId = paramInt1;
    this.mSize = paramInt2;
  }
  
  public static c fP(int paramInt)
  {
    return (c)bPN.get(Integer.valueOf(paramInt));
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