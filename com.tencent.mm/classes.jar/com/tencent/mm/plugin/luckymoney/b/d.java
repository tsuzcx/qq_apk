package com.tencent.mm.plugin.luckymoney.b;

public final class d
  extends com.tencent.mm.bv.a
{
  public int iHA;
  public int lKX;
  public double lKY;
  public double lKZ;
  public double lLa;
  public double lLb;
  public String lLc;
  public String lLd;
  public String lPM;
  public String lPN;
  public int lPO;
  public String lPP;
  public String lPQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.lKX);
      paramVarArgs.b(2, this.lLa);
      if (this.lPM != null) {
        paramVarArgs.d(3, this.lPM);
      }
      if (this.lPN != null) {
        paramVarArgs.d(4, this.lPN);
      }
      paramVarArgs.b(5, this.lKY);
      paramVarArgs.b(6, this.lLb);
      paramVarArgs.b(7, this.lKZ);
      paramVarArgs.gB(8, this.lPO);
      paramVarArgs.gB(9, this.iHA);
      if (this.lLc != null) {
        paramVarArgs.d(10, this.lLc);
      }
      if (this.lLd != null) {
        paramVarArgs.d(11, this.lLd);
      }
      if (this.lPP != null) {
        paramVarArgs.d(12, this.lPP);
      }
      if (this.lPQ != null) {
        paramVarArgs.d(13, this.lPQ);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.lKX) + 0 + (d.a.a.b.b.a.dQ(2) + 8);
      paramInt = i;
      if (this.lPM != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.lPM);
      }
      i = paramInt;
      if (this.lPN != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.lPN);
      }
      i = i + (d.a.a.b.b.a.dQ(5) + 8) + (d.a.a.b.b.a.dQ(6) + 8) + (d.a.a.b.b.a.dQ(7) + 8) + d.a.a.a.gy(8, this.lPO) + d.a.a.a.gy(9, this.iHA);
      paramInt = i;
      if (this.lLc != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.lLc);
      }
      i = paramInt;
      if (this.lLd != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.lLd);
      }
      paramInt = i;
      if (this.lPP != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.lPP);
      }
      i = paramInt;
    } while (this.lPQ == null);
    return paramInt + d.a.a.b.b.a.e(13, this.lPQ);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locald.lKX = locala.xpH.oD();
        return 0;
      case 2: 
        locald.lLa = locala.xpH.readDouble();
        return 0;
      case 3: 
        locald.lPM = locala.xpH.readString();
        return 0;
      case 4: 
        locald.lPN = locala.xpH.readString();
        return 0;
      case 5: 
        locald.lKY = locala.xpH.readDouble();
        return 0;
      case 6: 
        locald.lLb = locala.xpH.readDouble();
        return 0;
      case 7: 
        locald.lKZ = locala.xpH.readDouble();
        return 0;
      case 8: 
        locald.lPO = locala.xpH.oD();
        return 0;
      case 9: 
        locald.iHA = locala.xpH.oD();
        return 0;
      case 10: 
        locald.lLc = locala.xpH.readString();
        return 0;
      case 11: 
        locald.lLd = locala.xpH.readString();
        return 0;
      case 12: 
        locald.lPP = locala.xpH.readString();
        return 0;
      }
      locald.lPQ = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.d
 * JD-Core Version:    0.7.0.1
 */