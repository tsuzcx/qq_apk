package com.tencent.mm.plugin.game.d;

public final class n
  extends com.tencent.mm.bv.a
{
  public String kRN;
  public String kRP;
  public String kRZ;
  public String kSF;
  public int kSG;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSF != null) {
        paramVarArgs.d(1, this.kSF);
      }
      if (this.kRZ != null) {
        paramVarArgs.d(2, this.kRZ);
      }
      if (this.kRN != null) {
        paramVarArgs.d(3, this.kRN);
      }
      if (this.kRP != null) {
        paramVarArgs.d(4, this.kRP);
      }
      paramVarArgs.gB(5, this.kSG);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSF == null) {
        break label379;
      }
    }
    label379:
    for (int i = d.a.a.b.b.a.e(1, this.kSF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRZ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRZ);
      }
      i = paramInt;
      if (this.kRN != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRN);
      }
      paramInt = i;
      if (this.kRP != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRP);
      }
      return paramInt + d.a.a.a.gy(5, this.kSG);
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
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localn.kSF = locala.xpH.readString();
          return 0;
        case 2: 
          localn.kRZ = locala.xpH.readString();
          return 0;
        case 3: 
          localn.kRN = locala.xpH.readString();
          return 0;
        case 4: 
          localn.kRP = locala.xpH.readString();
          return 0;
        }
        localn.kSG = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.n
 * JD-Core Version:    0.7.0.1
 */