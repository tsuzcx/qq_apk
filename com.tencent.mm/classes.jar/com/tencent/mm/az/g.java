package com.tencent.mm.az;

public final class g
  extends com.tencent.mm.bv.a
{
  public int ewK;
  public int ewL;
  public int ewz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.ewz);
      paramVarArgs.gB(2, this.ewK);
      paramVarArgs.gB(3, this.ewL);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.ewz) + 0 + d.a.a.a.gy(2, this.ewK) + d.a.a.a.gy(3, this.ewL);
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
      g localg = (g)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localg.ewz = locala.xpH.oD();
        return 0;
      case 2: 
        localg.ewK = locala.xpH.oD();
        return 0;
      }
      localg.ewL = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.az.g
 * JD-Core Version:    0.7.0.1
 */