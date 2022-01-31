package com.tencent.mm.plugin.backup.i;

public final class s
  extends com.tencent.mm.bv.a
{
  public long hQJ;
  public long hQK;
  public long hQm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.hQm);
      paramVarArgs.Y(2, this.hQJ);
      paramVarArgs.Y(3, this.hQK);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.X(1, this.hQm) + 0 + d.a.a.a.X(2, this.hQJ) + d.a.a.a.X(3, this.hQK);
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
      s locals = (s)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locals.hQm = locala.xpH.oE();
        return 0;
      case 2: 
        locals.hQJ = locala.xpH.oE();
        return 0;
      }
      locals.hQK = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.s
 * JD-Core Version:    0.7.0.1
 */