package com.tencent.mm.plugin.luckymoney.b;

public final class i
  extends com.tencent.mm.bv.a
{
  public String lMg;
  public int lPR;
  public String lPV;
  public long lPY;
  public String lQA;
  public String lQB;
  public long lQC;
  public int lQD;
  public long lQa;
  public String lQb;
  public int lQm;
  public String lQx;
  public long lQy;
  public String lQz;
  public int status;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.lQx != null) {
        paramVarArgs.d(1, this.lQx);
      }
      if (this.lPV != null) {
        paramVarArgs.d(2, this.lPV);
      }
      paramVarArgs.Y(3, this.lQy);
      if (this.lQz != null) {
        paramVarArgs.d(4, this.lQz);
      }
      paramVarArgs.gB(5, this.lPR);
      if (this.lQA != null) {
        paramVarArgs.d(6, this.lQA);
      }
      if (this.lQB != null) {
        paramVarArgs.d(7, this.lQB);
      }
      paramVarArgs.Y(8, this.lQa);
      paramVarArgs.Y(9, this.lQC);
      paramVarArgs.Y(10, this.lPY);
      paramVarArgs.gB(11, this.status);
      paramVarArgs.gB(12, this.lQD);
      if (this.lQb != null) {
        paramVarArgs.d(13, this.lQb);
      }
      if (this.lMg != null) {
        paramVarArgs.d(14, this.lMg);
      }
      paramVarArgs.gB(15, this.lQm);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lQx == null) {
        break label829;
      }
    }
    label829:
    for (paramInt = d.a.a.b.b.a.e(1, this.lQx) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lPV != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.lPV);
      }
      i += d.a.a.a.X(3, this.lQy);
      paramInt = i;
      if (this.lQz != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.lQz);
      }
      i = paramInt + d.a.a.a.gy(5, this.lPR);
      paramInt = i;
      if (this.lQA != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.lQA);
      }
      i = paramInt;
      if (this.lQB != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.lQB);
      }
      i = i + d.a.a.a.X(8, this.lQa) + d.a.a.a.X(9, this.lQC) + d.a.a.a.X(10, this.lPY) + d.a.a.a.gy(11, this.status) + d.a.a.a.gy(12, this.lQD);
      paramInt = i;
      if (this.lQb != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.lQb);
      }
      i = paramInt;
      if (this.lMg != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.lMg);
      }
      return i + d.a.a.a.gy(15, this.lQm);
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
        i locali = (i)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          locali.lQx = locala.xpH.readString();
          return 0;
        case 2: 
          locali.lPV = locala.xpH.readString();
          return 0;
        case 3: 
          locali.lQy = locala.xpH.oE();
          return 0;
        case 4: 
          locali.lQz = locala.xpH.readString();
          return 0;
        case 5: 
          locali.lPR = locala.xpH.oD();
          return 0;
        case 6: 
          locali.lQA = locala.xpH.readString();
          return 0;
        case 7: 
          locali.lQB = locala.xpH.readString();
          return 0;
        case 8: 
          locali.lQa = locala.xpH.oE();
          return 0;
        case 9: 
          locali.lQC = locala.xpH.oE();
          return 0;
        case 10: 
          locali.lPY = locala.xpH.oE();
          return 0;
        case 11: 
          locali.status = locala.xpH.oD();
          return 0;
        case 12: 
          locali.lQD = locala.xpH.oD();
          return 0;
        case 13: 
          locali.lQb = locala.xpH.readString();
          return 0;
        case 14: 
          locali.lMg = locala.xpH.readString();
          return 0;
        }
        locali.lQm = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.i
 * JD-Core Version:    0.7.0.1
 */