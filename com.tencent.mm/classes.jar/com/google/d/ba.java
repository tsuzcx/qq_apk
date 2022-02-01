package com.google.d;

import java.lang.reflect.Type;

public enum ba
{
  private static final ba[] dRu;
  private static final Type[] dRv;
  final bl dRq;
  final a dRr;
  private final Class<?> dRs;
  private final boolean dRt;
  final int id;
  
  static
  {
    int i = 0;
    dQr = new ba("DOUBLE", 0, 0, a.dRy, bl.dSY);
    dQs = new ba("FLOAT", 1, 1, a.dRy, bl.dSX);
    dQt = new ba("INT64", 2, 2, a.dRy, bl.dSW);
    dQu = new ba("UINT64", 3, 3, a.dRy, bl.dSW);
    dQv = new ba("INT32", 4, 4, a.dRy, bl.dSV);
    dQw = new ba("FIXED64", 5, 5, a.dRy, bl.dSW);
    dQx = new ba("FIXED32", 6, 6, a.dRy, bl.dSV);
    dQy = new ba("BOOL", 7, 7, a.dRy, bl.dSZ);
    dQz = new ba("STRING", 8, 8, a.dRy, bl.dTa);
    dQA = new ba("MESSAGE", 9, 9, a.dRy, bl.dTd);
    dQB = new ba("BYTES", 10, 10, a.dRy, bl.dTb);
    dQC = new ba("UINT32", 11, 11, a.dRy, bl.dSV);
    dQD = new ba("ENUM", 12, 12, a.dRy, bl.dTc);
    dQE = new ba("SFIXED32", 13, 13, a.dRy, bl.dSV);
    dQF = new ba("SFIXED64", 14, 14, a.dRy, bl.dSW);
    dQG = new ba("SINT32", 15, 15, a.dRy, bl.dSV);
    dQH = new ba("SINT64", 16, 16, a.dRy, bl.dSW);
    dQI = new ba("GROUP", 17, 17, a.dRy, bl.dTd);
    dQJ = new ba("DOUBLE_LIST", 18, 18, a.dRz, bl.dSY);
    dQK = new ba("FLOAT_LIST", 19, 19, a.dRz, bl.dSX);
    dQL = new ba("INT64_LIST", 20, 20, a.dRz, bl.dSW);
    dQM = new ba("UINT64_LIST", 21, 21, a.dRz, bl.dSW);
    dQN = new ba("INT32_LIST", 22, 22, a.dRz, bl.dSV);
    dQO = new ba("FIXED64_LIST", 23, 23, a.dRz, bl.dSW);
    dQP = new ba("FIXED32_LIST", 24, 24, a.dRz, bl.dSV);
    dQQ = new ba("BOOL_LIST", 25, 25, a.dRz, bl.dSZ);
    dQR = new ba("STRING_LIST", 26, 26, a.dRz, bl.dTa);
    dQS = new ba("MESSAGE_LIST", 27, 27, a.dRz, bl.dTd);
    dQT = new ba("BYTES_LIST", 28, 28, a.dRz, bl.dTb);
    dQU = new ba("UINT32_LIST", 29, 29, a.dRz, bl.dSV);
    dQV = new ba("ENUM_LIST", 30, 30, a.dRz, bl.dTc);
    dQW = new ba("SFIXED32_LIST", 31, 31, a.dRz, bl.dSV);
    dQX = new ba("SFIXED64_LIST", 32, 32, a.dRz, bl.dSW);
    dQY = new ba("SINT32_LIST", 33, 33, a.dRz, bl.dSV);
    dQZ = new ba("SINT64_LIST", 34, 34, a.dRz, bl.dSW);
    dRa = new ba("DOUBLE_LIST_PACKED", 35, 35, a.dRA, bl.dSY);
    dRb = new ba("FLOAT_LIST_PACKED", 36, 36, a.dRA, bl.dSX);
    dRc = new ba("INT64_LIST_PACKED", 37, 37, a.dRA, bl.dSW);
    dRd = new ba("UINT64_LIST_PACKED", 38, 38, a.dRA, bl.dSW);
    dRe = new ba("INT32_LIST_PACKED", 39, 39, a.dRA, bl.dSV);
    dRf = new ba("FIXED64_LIST_PACKED", 40, 40, a.dRA, bl.dSW);
    dRg = new ba("FIXED32_LIST_PACKED", 41, 41, a.dRA, bl.dSV);
    dRh = new ba("BOOL_LIST_PACKED", 42, 42, a.dRA, bl.dSZ);
    dRi = new ba("UINT32_LIST_PACKED", 43, 43, a.dRA, bl.dSV);
    dRj = new ba("ENUM_LIST_PACKED", 44, 44, a.dRA, bl.dTc);
    dRk = new ba("SFIXED32_LIST_PACKED", 45, 45, a.dRA, bl.dSV);
    dRl = new ba("SFIXED64_LIST_PACKED", 46, 46, a.dRA, bl.dSW);
    dRm = new ba("SINT32_LIST_PACKED", 47, 47, a.dRA, bl.dSV);
    dRn = new ba("SINT64_LIST_PACKED", 48, 48, a.dRA, bl.dSW);
    dRo = new ba("GROUP_LIST", 49, 49, a.dRz, bl.dTd);
    dRp = new ba("MAP", 50, 50, a.dRB, bl.dSU);
    dRw = new ba[] { dQr, dQs, dQt, dQu, dQv, dQw, dQx, dQy, dQz, dQA, dQB, dQC, dQD, dQE, dQF, dQG, dQH, dQI, dQJ, dQK, dQL, dQM, dQN, dQO, dQP, dQQ, dQR, dQS, dQT, dQU, dQV, dQW, dQX, dQY, dQZ, dRa, dRb, dRc, dRd, dRe, dRf, dRg, dRh, dRi, dRj, dRk, dRl, dRm, dRn, dRo, dRp };
    dRv = new Type[0];
    ba[] arrayOfba = values();
    dRu = new ba[arrayOfba.length];
    int j = arrayOfba.length;
    while (i < j)
    {
      ba localba = arrayOfba[i];
      dRu[localba.id] = localba;
      i += 1;
    }
  }
  
  private ba(int paramInt, a parama, bl parambl)
  {
    this.id = paramInt;
    this.dRr = parama;
    this.dRq = parambl;
    switch (1.dRx[parama.ordinal()])
    {
    default: 
      this.dRs = null;
    }
    for (;;)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (parama == a.dRy)
      {
        bool1 = bool2;
        switch (1.dJw[parambl.ordinal()])
        {
        default: 
          bool1 = true;
        }
      }
      this.dRt = bool1;
      return;
      this.dRs = parambl.dTe;
      continue;
      this.dRs = parambl.dTe;
    }
  }
  
  static enum a
  {
    final boolean dRC;
    
    private a(boolean paramBoolean)
    {
      this.dRC = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.ba
 * JD-Core Version:    0.7.0.1
 */