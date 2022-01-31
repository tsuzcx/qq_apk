package com.tencent.mm.plugin.game.d;

public final class cj
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRN;
  public String kRO;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.kRO != null) {
        paramVarArgs.d(2, this.kRO);
      }
      if (this.kRN != null) {
        paramVarArgs.d(3, this.kRN);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.bGw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRO != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRO);
      }
      i = paramInt;
      if (this.kRN != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRN);
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
        cj localcj = (cj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcj.bGw = locala.xpH.readString();
          return 0;
        case 2: 
          localcj.kRO = locala.xpH.readString();
          return 0;
        }
        localcj.kRN = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cj
 * JD-Core Version:    0.7.0.1
 */