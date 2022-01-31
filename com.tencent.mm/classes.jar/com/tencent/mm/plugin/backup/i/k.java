package com.tencent.mm.plugin.backup.i;

import d.a.a.b;

public final class k
  extends com.tencent.mm.bv.a
{
  public int hPW;
  public int hPX;
  public String hPY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY == null) {
        throw new b("Not all required fields were included: UserName");
      }
      paramVarArgs.gB(1, this.hPW);
      paramVarArgs.gB(2, this.hPX);
      if (this.hPY != null) {
        paramVarArgs.d(3, this.hPY);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.hPW) + 0 + d.a.a.a.gy(2, this.hPX);
      paramInt = i;
    } while (this.hPY == null);
    return i + d.a.a.b.b.a.e(3, this.hPY);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.hPY == null) {
        throw new b("Not all required fields were included: UserName");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localk.hPW = locala.xpH.oD();
        return 0;
      case 2: 
        localk.hPX = locala.xpH.oD();
        return 0;
      }
      localk.hPY = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.k
 * JD-Core Version:    0.7.0.1
 */