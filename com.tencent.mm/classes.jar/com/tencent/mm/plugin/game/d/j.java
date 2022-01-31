package com.tencent.mm.plugin.game.d;

import d.a.a.b;

public final class j
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRN;
  public String kRP;
  public String kSs;
  public int kSu;
  public String kSy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSy == null) {
        throw new b("Not all required fields were included: IconUrl");
      }
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.kRP == null) {
        throw new b("Not all required fields were included: JumpUrl");
      }
      if (this.kSy != null) {
        paramVarArgs.d(1, this.kSy);
      }
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      if (this.kRN != null) {
        paramVarArgs.d(3, this.kRN);
      }
      if (this.kRP != null) {
        paramVarArgs.d(4, this.kRP);
      }
      paramVarArgs.gB(5, this.kSu);
      if (this.kSs != null) {
        paramVarArgs.d(6, this.kSs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSy == null) {
        break label542;
      }
    }
    label542:
    for (int i = d.a.a.b.b.a.e(1, this.kSy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bGw);
      }
      i = paramInt;
      if (this.kRN != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRN);
      }
      paramInt = i;
      if (this.kRP != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRP);
      }
      i = paramInt + d.a.a.a.gy(5, this.kSu);
      paramInt = i;
      if (this.kSs != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.kSs);
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
        if (this.kSy == null) {
          throw new b("Not all required fields were included: IconUrl");
        }
        if (this.bGw == null) {
          throw new b("Not all required fields were included: Title");
        }
        if (this.kRP != null) {
          break;
        }
        throw new b("Not all required fields were included: JumpUrl");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localj.kSy = locala.xpH.readString();
          return 0;
        case 2: 
          localj.bGw = locala.xpH.readString();
          return 0;
        case 3: 
          localj.kRN = locala.xpH.readString();
          return 0;
        case 4: 
          localj.kRP = locala.xpH.readString();
          return 0;
        case 5: 
          localj.kSu = locala.xpH.oD();
          return 0;
        }
        localj.kSs = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.j
 * JD-Core Version:    0.7.0.1
 */