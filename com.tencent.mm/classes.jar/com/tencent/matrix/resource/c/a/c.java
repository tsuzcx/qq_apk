package com.tencent.matrix.resource.c.a;

import java.util.HashMap;
import java.util.Map;

public enum c
{
  private static Map<Integer, c> cfw;
  private int mId;
  private int mSize;
  
  static
  {
    int i = 0;
    cIk = new c("OBJECT", 0, 2, 0);
    cIl = new c("BOOLEAN", 1, 4, 1);
    cIm = new c("CHAR", 2, 5, 2);
    cIn = new c("FLOAT", 3, 6, 4);
    cIo = new c("DOUBLE", 4, 7, 8);
    cIp = new c("BYTE", 5, 8, 1);
    cIq = new c("SHORT", 6, 9, 2);
    cIr = new c("INT", 7, 10, 4);
    cIs = new c("LONG", 8, 11, 8);
    cIt = new c[] { cIk, cIl, cIm, cIn, cIo, cIp, cIq, cIr, cIs };
    cfw = new HashMap();
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    while (i < j)
    {
      c localc = arrayOfc[i];
      cfw.put(Integer.valueOf(localc.mId), localc);
      i += 1;
    }
  }
  
  private c(int paramInt1, int paramInt2)
  {
    this.mId = paramInt1;
    this.mSize = paramInt2;
  }
  
  public static c gZ(int paramInt)
  {
    return (c)cfw.get(Integer.valueOf(paramInt));
  }
  
  public final int getSize(int paramInt)
  {
    if (this.mSize != 0) {
      paramInt = this.mSize;
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.c.a.c
 * JD-Core Version:    0.7.0.1
 */