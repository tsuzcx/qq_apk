package com.tencent.mm.k.a.a;

public final class c
  extends com.tencent.mm.bv.a
{
  public long dtN;
  public long dtO;
  public long dtP;
  public long dtQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.dtN);
      paramVarArgs.Y(2, this.dtO);
      paramVarArgs.Y(3, this.dtP);
      paramVarArgs.Y(4, this.dtQ);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.X(1, this.dtN) + 0 + d.a.a.a.X(2, this.dtO) + d.a.a.a.X(3, this.dtP) + d.a.a.a.X(4, this.dtQ);
    }
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
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localc.dtN = locala.xpH.oE();
        return 0;
      case 2: 
        localc.dtO = locala.xpH.oE();
        return 0;
      case 3: 
        localc.dtP = locala.xpH.oE();
        return 0;
      }
      localc.dtQ = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.k.a.a.c
 * JD-Core Version:    0.7.0.1
 */