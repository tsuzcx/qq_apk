package com.tencent.mm.plugin.game.d;

public final class p
  extends com.tencent.mm.bv.a
{
  public String kSI;
  public String kSJ;
  public String kSK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSI != null) {
        paramVarArgs.d(1, this.kSI);
      }
      if (this.kSJ != null) {
        paramVarArgs.d(2, this.kSJ);
      }
      if (this.kSK != null) {
        paramVarArgs.d(3, this.kSK);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSI == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.kSI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kSJ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kSJ);
      }
      i = paramInt;
      if (this.kSK != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kSK);
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
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localp.kSI = locala.xpH.readString();
          return 0;
        case 2: 
          localp.kSJ = locala.xpH.readString();
          return 0;
        }
        localp.kSK = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.p
 * JD-Core Version:    0.7.0.1
 */