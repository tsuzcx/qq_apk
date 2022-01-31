package com.tencent.mm.model;

public final class br
  extends com.tencent.mm.bv.a
{
  public long dXA;
  public String dXz;
  public int key;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.key);
      if (this.dXz != null) {
        paramVarArgs.d(2, this.dXz);
      }
      paramVarArgs.Y(3, this.dXA);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.key) + 0;
      paramInt = i;
      if (this.dXz != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.dXz);
      }
      return paramInt + d.a.a.a.X(3, this.dXA);
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
      br localbr = (br)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbr.key = locala.xpH.oD();
        return 0;
      case 2: 
        localbr.dXz = locala.xpH.readString();
        return 0;
      }
      localbr.dXA = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.br
 * JD-Core Version:    0.7.0.1
 */