package com.tencent.mm.plugin.backup.i;

import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bv.a
{
  public LinkedList<String> hPU = new LinkedList();
  public LinkedList<Long> hPV = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 1, this.hPU);
      paramVarArgs.d(2, 3, this.hPV);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.c(1, 1, this.hPU) + 0 + d.a.a.a.c(2, 3, this.hPV);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hPU.clear();
      this.hPV.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
      i locali = (i)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        locali.hPU.add(locala.xpH.readString());
        return 0;
      }
      locali.hPV.add(Long.valueOf(locala.xpH.oE()));
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.i
 * JD-Core Version:    0.7.0.1
 */