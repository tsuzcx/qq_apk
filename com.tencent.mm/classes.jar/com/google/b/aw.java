package com.google.b;

import java.lang.reflect.Type;

public enum aw
{
  private static final aw[] bXI;
  private static final Type[] bXJ;
  final bg bXE;
  final a bXF;
  private final Class<?> bXG;
  private final boolean bXH;
  final int id;
  
  static
  {
    int i = 0;
    bWF = new aw("DOUBLE", 0, 0, a.bXM, bg.bZo);
    bWG = new aw("FLOAT", 1, 1, a.bXM, bg.bZn);
    bWH = new aw("INT64", 2, 2, a.bXM, bg.bZm);
    bWI = new aw("UINT64", 3, 3, a.bXM, bg.bZm);
    bWJ = new aw("INT32", 4, 4, a.bXM, bg.bZl);
    bWK = new aw("FIXED64", 5, 5, a.bXM, bg.bZm);
    bWL = new aw("FIXED32", 6, 6, a.bXM, bg.bZl);
    bWM = new aw("BOOL", 7, 7, a.bXM, bg.bZp);
    bWN = new aw("STRING", 8, 8, a.bXM, bg.bZq);
    bWO = new aw("MESSAGE", 9, 9, a.bXM, bg.bZt);
    bWP = new aw("BYTES", 10, 10, a.bXM, bg.bZr);
    bWQ = new aw("UINT32", 11, 11, a.bXM, bg.bZl);
    bWR = new aw("ENUM", 12, 12, a.bXM, bg.bZs);
    bWS = new aw("SFIXED32", 13, 13, a.bXM, bg.bZl);
    bWT = new aw("SFIXED64", 14, 14, a.bXM, bg.bZm);
    bWU = new aw("SINT32", 15, 15, a.bXM, bg.bZl);
    bWV = new aw("SINT64", 16, 16, a.bXM, bg.bZm);
    bWW = new aw("GROUP", 17, 17, a.bXM, bg.bZt);
    bWX = new aw("DOUBLE_LIST", 18, 18, a.bXN, bg.bZo);
    bWY = new aw("FLOAT_LIST", 19, 19, a.bXN, bg.bZn);
    bWZ = new aw("INT64_LIST", 20, 20, a.bXN, bg.bZm);
    bXa = new aw("UINT64_LIST", 21, 21, a.bXN, bg.bZm);
    bXb = new aw("INT32_LIST", 22, 22, a.bXN, bg.bZl);
    bXc = new aw("FIXED64_LIST", 23, 23, a.bXN, bg.bZm);
    bXd = new aw("FIXED32_LIST", 24, 24, a.bXN, bg.bZl);
    bXe = new aw("BOOL_LIST", 25, 25, a.bXN, bg.bZp);
    bXf = new aw("STRING_LIST", 26, 26, a.bXN, bg.bZq);
    bXg = new aw("MESSAGE_LIST", 27, 27, a.bXN, bg.bZt);
    bXh = new aw("BYTES_LIST", 28, 28, a.bXN, bg.bZr);
    bXi = new aw("UINT32_LIST", 29, 29, a.bXN, bg.bZl);
    bXj = new aw("ENUM_LIST", 30, 30, a.bXN, bg.bZs);
    bXk = new aw("SFIXED32_LIST", 31, 31, a.bXN, bg.bZl);
    bXl = new aw("SFIXED64_LIST", 32, 32, a.bXN, bg.bZm);
    bXm = new aw("SINT32_LIST", 33, 33, a.bXN, bg.bZl);
    bXn = new aw("SINT64_LIST", 34, 34, a.bXN, bg.bZm);
    bXo = new aw("DOUBLE_LIST_PACKED", 35, 35, a.bXO, bg.bZo);
    bXp = new aw("FLOAT_LIST_PACKED", 36, 36, a.bXO, bg.bZn);
    bXq = new aw("INT64_LIST_PACKED", 37, 37, a.bXO, bg.bZm);
    bXr = new aw("UINT64_LIST_PACKED", 38, 38, a.bXO, bg.bZm);
    bXs = new aw("INT32_LIST_PACKED", 39, 39, a.bXO, bg.bZl);
    bXt = new aw("FIXED64_LIST_PACKED", 40, 40, a.bXO, bg.bZm);
    bXu = new aw("FIXED32_LIST_PACKED", 41, 41, a.bXO, bg.bZl);
    bXv = new aw("BOOL_LIST_PACKED", 42, 42, a.bXO, bg.bZp);
    bXw = new aw("UINT32_LIST_PACKED", 43, 43, a.bXO, bg.bZl);
    bXx = new aw("ENUM_LIST_PACKED", 44, 44, a.bXO, bg.bZs);
    bXy = new aw("SFIXED32_LIST_PACKED", 45, 45, a.bXO, bg.bZl);
    bXz = new aw("SFIXED64_LIST_PACKED", 46, 46, a.bXO, bg.bZm);
    bXA = new aw("SINT32_LIST_PACKED", 47, 47, a.bXO, bg.bZl);
    bXB = new aw("SINT64_LIST_PACKED", 48, 48, a.bXO, bg.bZm);
    bXC = new aw("GROUP_LIST", 49, 49, a.bXN, bg.bZt);
    bXD = new aw("MAP", 50, 50, a.bXP, bg.bZk);
    bXK = new aw[] { bWF, bWG, bWH, bWI, bWJ, bWK, bWL, bWM, bWN, bWO, bWP, bWQ, bWR, bWS, bWT, bWU, bWV, bWW, bWX, bWY, bWZ, bXa, bXb, bXc, bXd, bXe, bXf, bXg, bXh, bXi, bXj, bXk, bXl, bXm, bXn, bXo, bXp, bXq, bXr, bXs, bXt, bXu, bXv, bXw, bXx, bXy, bXz, bXA, bXB, bXC, bXD };
    bXJ = new Type[0];
    aw[] arrayOfaw = values();
    bXI = new aw[arrayOfaw.length];
    int j = arrayOfaw.length;
    while (i < j)
    {
      aw localaw = arrayOfaw[i];
      bXI[localaw.id] = localaw;
      i += 1;
    }
  }
  
  private aw(int paramInt, a parama, bg parambg)
  {
    this.id = paramInt;
    this.bXF = parama;
    this.bXE = parambg;
    switch (1.bXL[parama.ordinal()])
    {
    default: 
      this.bXG = null;
    }
    for (;;)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (parama == a.bXM)
      {
        bool1 = bool2;
        switch (1.bPE[parambg.ordinal()])
        {
        default: 
          bool1 = true;
        }
      }
      this.bXH = bool1;
      return;
      this.bXG = parambg.bZu;
      continue;
      this.bXG = parambg.bZu;
    }
  }
  
  static enum a
  {
    final boolean bXQ;
    
    private a(boolean paramBoolean)
    {
      this.bXQ = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.aw
 * JD-Core Version:    0.7.0.1
 */