package com.google.a;

import java.lang.reflect.Type;

public enum y
{
  private static final y[] bVK;
  private static final Type[] bVL;
  final ag bVG;
  final y.a bVH;
  private final Class<?> bVI;
  private final boolean bVJ;
  final int id;
  
  static
  {
    int i = 0;
    bUH = new y("DOUBLE", 0, 0, y.a.bVO, ag.bXw);
    bUI = new y("FLOAT", 1, 1, y.a.bVO, ag.bXv);
    bUJ = new y("INT64", 2, 2, y.a.bVO, ag.bXu);
    bUK = new y("UINT64", 3, 3, y.a.bVO, ag.bXu);
    bUL = new y("INT32", 4, 4, y.a.bVO, ag.bXt);
    bUM = new y("FIXED64", 5, 5, y.a.bVO, ag.bXu);
    bUN = new y("FIXED32", 6, 6, y.a.bVO, ag.bXt);
    bUO = new y("BOOL", 7, 7, y.a.bVO, ag.bXx);
    bUP = new y("STRING", 8, 8, y.a.bVO, ag.bXy);
    bUQ = new y("MESSAGE", 9, 9, y.a.bVO, ag.bXB);
    bUR = new y("BYTES", 10, 10, y.a.bVO, ag.bXz);
    bUS = new y("UINT32", 11, 11, y.a.bVO, ag.bXt);
    bUT = new y("ENUM", 12, 12, y.a.bVO, ag.bXA);
    bUU = new y("SFIXED32", 13, 13, y.a.bVO, ag.bXt);
    bUV = new y("SFIXED64", 14, 14, y.a.bVO, ag.bXu);
    bUW = new y("SINT32", 15, 15, y.a.bVO, ag.bXt);
    bUX = new y("SINT64", 16, 16, y.a.bVO, ag.bXu);
    bUY = new y("GROUP", 17, 17, y.a.bVO, ag.bXB);
    bUZ = new y("DOUBLE_LIST", 18, 18, y.a.bVP, ag.bXw);
    bVa = new y("FLOAT_LIST", 19, 19, y.a.bVP, ag.bXv);
    bVb = new y("INT64_LIST", 20, 20, y.a.bVP, ag.bXu);
    bVc = new y("UINT64_LIST", 21, 21, y.a.bVP, ag.bXu);
    bVd = new y("INT32_LIST", 22, 22, y.a.bVP, ag.bXt);
    bVe = new y("FIXED64_LIST", 23, 23, y.a.bVP, ag.bXu);
    bVf = new y("FIXED32_LIST", 24, 24, y.a.bVP, ag.bXt);
    bVg = new y("BOOL_LIST", 25, 25, y.a.bVP, ag.bXx);
    bVh = new y("STRING_LIST", 26, 26, y.a.bVP, ag.bXy);
    bVi = new y("MESSAGE_LIST", 27, 27, y.a.bVP, ag.bXB);
    bVj = new y("BYTES_LIST", 28, 28, y.a.bVP, ag.bXz);
    bVk = new y("UINT32_LIST", 29, 29, y.a.bVP, ag.bXt);
    bVl = new y("ENUM_LIST", 30, 30, y.a.bVP, ag.bXA);
    bVm = new y("SFIXED32_LIST", 31, 31, y.a.bVP, ag.bXt);
    bVn = new y("SFIXED64_LIST", 32, 32, y.a.bVP, ag.bXu);
    bVo = new y("SINT32_LIST", 33, 33, y.a.bVP, ag.bXt);
    bVp = new y("SINT64_LIST", 34, 34, y.a.bVP, ag.bXu);
    bVq = new y("DOUBLE_LIST_PACKED", 35, 35, y.a.bVQ, ag.bXw);
    bVr = new y("FLOAT_LIST_PACKED", 36, 36, y.a.bVQ, ag.bXv);
    bVs = new y("INT64_LIST_PACKED", 37, 37, y.a.bVQ, ag.bXu);
    bVt = new y("UINT64_LIST_PACKED", 38, 38, y.a.bVQ, ag.bXu);
    bVu = new y("INT32_LIST_PACKED", 39, 39, y.a.bVQ, ag.bXt);
    bVv = new y("FIXED64_LIST_PACKED", 40, 40, y.a.bVQ, ag.bXu);
    bVw = new y("FIXED32_LIST_PACKED", 41, 41, y.a.bVQ, ag.bXt);
    bVx = new y("BOOL_LIST_PACKED", 42, 42, y.a.bVQ, ag.bXx);
    bVy = new y("UINT32_LIST_PACKED", 43, 43, y.a.bVQ, ag.bXt);
    bVz = new y("ENUM_LIST_PACKED", 44, 44, y.a.bVQ, ag.bXA);
    bVA = new y("SFIXED32_LIST_PACKED", 45, 45, y.a.bVQ, ag.bXt);
    bVB = new y("SFIXED64_LIST_PACKED", 46, 46, y.a.bVQ, ag.bXu);
    bVC = new y("SINT32_LIST_PACKED", 47, 47, y.a.bVQ, ag.bXt);
    bVD = new y("SINT64_LIST_PACKED", 48, 48, y.a.bVQ, ag.bXu);
    bVE = new y("GROUP_LIST", 49, 49, y.a.bVP, ag.bXB);
    bVF = new y("MAP", 50, 50, y.a.bVR, ag.bXs);
    bVM = new y[] { bUH, bUI, bUJ, bUK, bUL, bUM, bUN, bUO, bUP, bUQ, bUR, bUS, bUT, bUU, bUV, bUW, bUX, bUY, bUZ, bVa, bVb, bVc, bVd, bVe, bVf, bVg, bVh, bVi, bVj, bVk, bVl, bVm, bVn, bVo, bVp, bVq, bVr, bVs, bVt, bVu, bVv, bVw, bVx, bVy, bVz, bVA, bVB, bVC, bVD, bVE, bVF };
    bVL = new Type[0];
    y[] arrayOfy = values();
    bVK = new y[arrayOfy.length];
    int j = arrayOfy.length;
    while (i < j)
    {
      y localy = arrayOfy[i];
      bVK[localy.id] = localy;
      i += 1;
    }
  }
  
  private y(int paramInt, y.a parama, ag paramag)
  {
    this.id = paramInt;
    this.bVH = parama;
    this.bVG = paramag;
    switch (1.bVN[parama.ordinal()])
    {
    default: 
      this.bVI = null;
    }
    for (;;)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (parama == y.a.bVO)
      {
        bool1 = bool2;
        switch (1.bNF[paramag.ordinal()])
        {
        default: 
          bool1 = true;
        }
      }
      this.bVJ = bool1;
      return;
      this.bVI = paramag.bXC;
      continue;
      this.bVI = paramag.bXC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.y
 * JD-Core Version:    0.7.0.1
 */