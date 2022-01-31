package com.tencent.mm.ae;

public final class m
  extends com.tencent.mm.bv.a
{
  public String dTB;
  public String dTC;
  public String dTD;
  public String dTE;
  public String dTF;
  public int dTG;
  public int dTH;
  public String dTI;
  public String dTJ;
  public int dTK;
  public int dTL;
  public String dTM;
  public String dTN;
  public String dTO;
  public String dTP;
  public String dTQ;
  public String dTR;
  public int dTS;
  public int dTT;
  public String dTU;
  public long time;
  public String title;
  public int type;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.dTB != null) {
        paramVarArgs.d(3, this.dTB);
      }
      if (this.dTC != null) {
        paramVarArgs.d(4, this.dTC);
      }
      paramVarArgs.Y(5, this.time);
      if (this.dTD != null) {
        paramVarArgs.d(6, this.dTD);
      }
      if (this.dTE != null) {
        paramVarArgs.d(7, this.dTE);
      }
      if (this.dTF != null) {
        paramVarArgs.d(8, this.dTF);
      }
      paramVarArgs.gB(9, this.type);
      paramVarArgs.gB(10, this.dTG);
      paramVarArgs.gB(11, this.dTH);
      if (this.dTI != null) {
        paramVarArgs.d(12, this.dTI);
      }
      if (this.dTJ != null) {
        paramVarArgs.d(13, this.dTJ);
      }
      paramVarArgs.gB(14, this.dTK);
      paramVarArgs.gB(15, this.dTL);
      if (this.dTM != null) {
        paramVarArgs.d(16, this.dTM);
      }
      if (this.dTN != null) {
        paramVarArgs.d(17, this.dTN);
      }
      if (this.dTO != null) {
        paramVarArgs.d(18, this.dTO);
      }
      if (this.dTP != null) {
        paramVarArgs.d(19, this.dTP);
      }
      if (this.dTQ != null) {
        paramVarArgs.d(20, this.dTQ);
      }
      if (this.dTR != null) {
        paramVarArgs.d(21, this.dTR);
      }
      paramVarArgs.gB(22, this.dTS);
      paramVarArgs.gB(23, this.dTT);
      if (this.dTU != null) {
        paramVarArgs.d(24, this.dTU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1344;
      }
    }
    label1344:
    for (int i = d.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.dTB != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.dTB);
      }
      paramInt = i;
      if (this.dTC != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.dTC);
      }
      i = paramInt + d.a.a.a.X(5, this.time);
      paramInt = i;
      if (this.dTD != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.dTD);
      }
      i = paramInt;
      if (this.dTE != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.dTE);
      }
      paramInt = i;
      if (this.dTF != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.dTF);
      }
      i = paramInt + d.a.a.a.gy(9, this.type) + d.a.a.a.gy(10, this.dTG) + d.a.a.a.gy(11, this.dTH);
      paramInt = i;
      if (this.dTI != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.dTI);
      }
      i = paramInt;
      if (this.dTJ != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.dTJ);
      }
      i = i + d.a.a.a.gy(14, this.dTK) + d.a.a.a.gy(15, this.dTL);
      paramInt = i;
      if (this.dTM != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.dTM);
      }
      i = paramInt;
      if (this.dTN != null) {
        i = paramInt + d.a.a.b.b.a.e(17, this.dTN);
      }
      paramInt = i;
      if (this.dTO != null) {
        paramInt = i + d.a.a.b.b.a.e(18, this.dTO);
      }
      i = paramInt;
      if (this.dTP != null) {
        i = paramInt + d.a.a.b.b.a.e(19, this.dTP);
      }
      paramInt = i;
      if (this.dTQ != null) {
        paramInt = i + d.a.a.b.b.a.e(20, this.dTQ);
      }
      i = paramInt;
      if (this.dTR != null) {
        i = paramInt + d.a.a.b.b.a.e(21, this.dTR);
      }
      i = i + d.a.a.a.gy(22, this.dTS) + d.a.a.a.gy(23, this.dTT);
      paramInt = i;
      if (this.dTU != null) {
        paramInt = i + d.a.a.b.b.a.e(24, this.dTU);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        m localm = (m)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localm.title = locala.xpH.readString();
          return 0;
        case 2: 
          localm.url = locala.xpH.readString();
          return 0;
        case 3: 
          localm.dTB = locala.xpH.readString();
          return 0;
        case 4: 
          localm.dTC = locala.xpH.readString();
          return 0;
        case 5: 
          localm.time = locala.xpH.oE();
          return 0;
        case 6: 
          localm.dTD = locala.xpH.readString();
          return 0;
        case 7: 
          localm.dTE = locala.xpH.readString();
          return 0;
        case 8: 
          localm.dTF = locala.xpH.readString();
          return 0;
        case 9: 
          localm.type = locala.xpH.oD();
          return 0;
        case 10: 
          localm.dTG = locala.xpH.oD();
          return 0;
        case 11: 
          localm.dTH = locala.xpH.oD();
          return 0;
        case 12: 
          localm.dTI = locala.xpH.readString();
          return 0;
        case 13: 
          localm.dTJ = locala.xpH.readString();
          return 0;
        case 14: 
          localm.dTK = locala.xpH.oD();
          return 0;
        case 15: 
          localm.dTL = locala.xpH.oD();
          return 0;
        case 16: 
          localm.dTM = locala.xpH.readString();
          return 0;
        case 17: 
          localm.dTN = locala.xpH.readString();
          return 0;
        case 18: 
          localm.dTO = locala.xpH.readString();
          return 0;
        case 19: 
          localm.dTP = locala.xpH.readString();
          return 0;
        case 20: 
          localm.dTQ = locala.xpH.readString();
          return 0;
        case 21: 
          localm.dTR = locala.xpH.readString();
          return 0;
        case 22: 
          localm.dTS = locala.xpH.oD();
          return 0;
        case 23: 
          localm.dTT = locala.xpH.oD();
          return 0;
        }
        localm.dTU = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ae.m
 * JD-Core Version:    0.7.0.1
 */