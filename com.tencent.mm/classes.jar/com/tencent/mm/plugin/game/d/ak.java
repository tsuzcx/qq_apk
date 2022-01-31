package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class ak
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRP;
  public String kSs;
  public int kSu;
  public String kTD;
  public boolean kTE;
  public boolean kTF;
  public String kTG;
  public String kTH;
  public int kTI;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.kTD == null) {
        throw new b("Not all required fields were included: NavKey");
      }
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.kTD != null) {
        paramVarArgs.d(2, this.kTD);
      }
      if (this.kRP != null) {
        paramVarArgs.d(3, this.kRP);
      }
      paramVarArgs.aA(4, this.kTE);
      paramVarArgs.aA(5, this.kTF);
      if (this.kTG != null) {
        paramVarArgs.d(6, this.kTG);
      }
      if (this.kTH != null) {
        paramVarArgs.d(7, this.kTH);
      }
      paramVarArgs.gB(8, this.kTI);
      paramVarArgs.gB(9, this.kSu);
      if (this.kSs != null) {
        paramVarArgs.d(10, this.kSs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label672;
      }
    }
    label672:
    for (int i = d.a.a.b.b.a.e(1, this.bGw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kTD != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kTD);
      }
      i = paramInt;
      if (this.kRP != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRP);
      }
      i = i + (d.a.a.b.b.a.dQ(4) + 1) + (d.a.a.b.b.a.dQ(5) + 1);
      paramInt = i;
      if (this.kTG != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.kTG);
      }
      i = paramInt;
      if (this.kTH != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.kTH);
      }
      i = i + d.a.a.a.gy(8, this.kTI) + d.a.a.a.gy(9, this.kSu);
      paramInt = i;
      if (this.kSs != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.kSs);
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
        if (this.bGw == null) {
          throw new b("Not all required fields were included: Title");
        }
        if (this.kTD != null) {
          break;
        }
        throw new b("Not all required fields were included: NavKey");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ak localak = (ak)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localak.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          localak.kTD = locala.xpH.readString();
          return 0;
        case 3: 
          localak.kRP = locala.xpH.readString();
          return 0;
        case 4: 
          localak.kTE = locala.cUr();
          return 0;
        case 5: 
          localak.kTF = locala.cUr();
          return 0;
        case 6: 
          localak.kTG = locala.xpH.readString();
          return 0;
        case 7: 
          localak.kTH = locala.xpH.readString();
          return 0;
        case 8: 
          localak.kTI = locala.xpH.oD();
          return 0;
        case 9: 
          localak.kSu = locala.xpH.oD();
          return 0;
        }
        localak.kSs = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ak
 * JD-Core Version:    0.7.0.1
 */