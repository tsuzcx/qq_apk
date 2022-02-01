package com.tencent.matrix.resource.d.a;

import java.util.HashMap;
import java.util.Map;

public enum c
{
  private static Map<Integer, c> ebT;
  private int mId;
  private int mSize;
  
  static
  {
    int i = 0;
    fcc = new c("OBJECT", 0, 2, 0);
    fcd = new c("BOOLEAN", 1, 4, 1);
    fce = new c("CHAR", 2, 5, 2);
    fcf = new c("FLOAT", 3, 6, 4);
    fcg = new c("DOUBLE", 4, 7, 8);
    fch = new c("BYTE", 5, 8, 1);
    fci = new c("SHORT", 6, 9, 2);
    fcj = new c("INT", 7, 10, 4);
    fck = new c("LONG", 8, 11, 8);
    fcl = new c[] { fcc, fcd, fce, fcf, fcg, fch, fci, fcj, fck };
    ebT = new HashMap();
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    while (i < j)
    {
      c localc = arrayOfc[i];
      ebT.put(Integer.valueOf(localc.mId), localc);
      i += 1;
    }
  }
  
  private c(int paramInt1, int paramInt2)
  {
    this.mId = paramInt1;
    this.mSize = paramInt2;
  }
  
  public static c nu(int paramInt)
  {
    return (c)ebT.get(Integer.valueOf(paramInt));
  }
  
  public final int nv(int paramInt)
  {
    if (this.mSize != 0) {
      paramInt = this.mSize;
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.matrix.resource.d.a.c
 * JD-Core Version:    0.7.0.1
 */