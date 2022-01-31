package com.tencent.mm.plugin.game.d;

public final class dp
  extends com.tencent.mm.bv.a
{
  public String kSL;
  public String kWA;
  public String kWB;
  public String kWv;
  public String kWw;
  public String kWx;
  public String kWy;
  public int kWz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSL != null) {
        paramVarArgs.d(1, this.kSL);
      }
      if (this.kWv != null) {
        paramVarArgs.d(2, this.kWv);
      }
      if (this.kWw != null) {
        paramVarArgs.d(3, this.kWw);
      }
      if (this.kWx != null) {
        paramVarArgs.d(4, this.kWx);
      }
      if (this.kWy != null) {
        paramVarArgs.d(5, this.kWy);
      }
      paramVarArgs.gB(6, this.kWz);
      if (this.kWA != null) {
        paramVarArgs.d(7, this.kWA);
      }
      if (this.kWB != null) {
        paramVarArgs.d(8, this.kWB);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSL == null) {
        break label552;
      }
    }
    label552:
    for (int i = d.a.a.b.b.a.e(1, this.kSL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kWv != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kWv);
      }
      i = paramInt;
      if (this.kWw != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kWw);
      }
      paramInt = i;
      if (this.kWx != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kWx);
      }
      i = paramInt;
      if (this.kWy != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kWy);
      }
      i += d.a.a.a.gy(6, this.kWz);
      paramInt = i;
      if (this.kWA != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.kWA);
      }
      i = paramInt;
      if (this.kWB != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.kWB);
      }
      return i;
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
        dp localdp = (dp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localdp.kSL = locala.xpH.readString();
          return 0;
        case 2: 
          localdp.kWv = locala.xpH.readString();
          return 0;
        case 3: 
          localdp.kWw = locala.xpH.readString();
          return 0;
        case 4: 
          localdp.kWx = locala.xpH.readString();
          return 0;
        case 5: 
          localdp.kWy = locala.xpH.readString();
          return 0;
        case 6: 
          localdp.kWz = locala.xpH.oD();
          return 0;
        case 7: 
          localdp.kWA = locala.xpH.readString();
          return 0;
        }
        localdp.kWB = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dp
 * JD-Core Version:    0.7.0.1
 */