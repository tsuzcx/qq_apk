package com.tencent.mm.cd;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bv.a
{
  public int chT;
  public int jpD;
  public int jpE;
  public int jpF;
  public int size;
  public int yuB = -1;
  public int yuC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62664);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.jpD);
      paramVarArgs.aO(2, this.jpE);
      paramVarArgs.aO(3, this.jpF);
      paramVarArgs.aO(41, this.yuB);
      paramVarArgs.aO(5, this.yuC);
      paramVarArgs.aO(6, this.chT);
      paramVarArgs.aO(7, this.size);
      AppMethodBeat.o(62664);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.jpD);
      int i = e.a.a.b.b.a.bl(2, this.jpE);
      int j = e.a.a.b.b.a.bl(3, this.jpF);
      int k = e.a.a.b.b.a.bl(41, this.yuB);
      int m = e.a.a.b.b.a.bl(5, this.yuC);
      int n = e.a.a.b.b.a.bl(6, this.chT);
      int i1 = e.a.a.b.b.a.bl(7, this.size);
      AppMethodBeat.o(62664);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(62664);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(62664);
        return -1;
      case 1: 
        localc.jpD = locala.CLY.sl();
        AppMethodBeat.o(62664);
        return 0;
      case 2: 
        localc.jpE = locala.CLY.sl();
        AppMethodBeat.o(62664);
        return 0;
      case 3: 
        localc.jpF = locala.CLY.sl();
        AppMethodBeat.o(62664);
        return 0;
      case 41: 
        localc.yuB = locala.CLY.sl();
        AppMethodBeat.o(62664);
        return 0;
      case 5: 
        localc.yuC = locala.CLY.sl();
        AppMethodBeat.o(62664);
        return 0;
      case 6: 
        localc.chT = locala.CLY.sl();
        AppMethodBeat.o(62664);
        return 0;
      }
      localc.size = locala.CLY.sl();
      AppMethodBeat.o(62664);
      return 0;
    }
    AppMethodBeat.o(62664);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cd.c
 * JD-Core Version:    0.7.0.1
 */