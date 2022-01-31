package com.tencent.mm.plugin.downloader.e;

public final class s
  extends com.tencent.mm.bv.a
{
  public long iRd;
  public int limit;
  public int offset;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.offset);
      paramVarArgs.gB(2, this.limit);
      paramVarArgs.Y(3, this.iRd);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.offset) + 0 + d.a.a.a.gy(2, this.limit) + d.a.a.a.X(3, this.iRd);
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
        locals.offset = locala.xpH.oD();
        return 0;
      case 2: 
        locals.limit = locala.xpH.oD();
        return 0;
      }
      locals.iRd = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.e.s
 * JD-Core Version:    0.7.0.1
 */