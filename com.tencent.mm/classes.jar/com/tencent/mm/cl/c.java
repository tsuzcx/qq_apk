package com.tencent.mm.cl;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.cd.a
{
  public int UYr = -1;
  public int UYs;
  public int bPt;
  public int rzB;
  public int rzC;
  public int rzD;
  public int size;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104918);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rzB);
      paramVarArgs.aY(2, this.rzC);
      paramVarArgs.aY(3, this.rzD);
      paramVarArgs.aY(41, this.UYr);
      paramVarArgs.aY(5, this.UYs);
      paramVarArgs.aY(6, this.bPt);
      paramVarArgs.aY(7, this.size);
      AppMethodBeat.o(104918);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.rzB);
      int i = g.a.a.b.b.a.bM(2, this.rzC);
      int j = g.a.a.b.b.a.bM(3, this.rzD);
      int k = g.a.a.b.b.a.bM(41, this.UYr);
      int m = g.a.a.b.b.a.bM(5, this.UYs);
      int n = g.a.a.b.b.a.bM(6, this.bPt);
      int i1 = g.a.a.b.b.a.bM(7, this.size);
      AppMethodBeat.o(104918);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(104918);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104918);
        return -1;
      case 1: 
        localc.rzB = locala.abFh.AK();
        AppMethodBeat.o(104918);
        return 0;
      case 2: 
        localc.rzC = locala.abFh.AK();
        AppMethodBeat.o(104918);
        return 0;
      case 3: 
        localc.rzD = locala.abFh.AK();
        AppMethodBeat.o(104918);
        return 0;
      case 41: 
        localc.UYr = locala.abFh.AK();
        AppMethodBeat.o(104918);
        return 0;
      case 5: 
        localc.UYs = locala.abFh.AK();
        AppMethodBeat.o(104918);
        return 0;
      case 6: 
        localc.bPt = locala.abFh.AK();
        AppMethodBeat.o(104918);
        return 0;
      }
      localc.size = locala.abFh.AK();
      AppMethodBeat.o(104918);
      return 0;
    }
    AppMethodBeat.o(104918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cl.c
 * JD-Core Version:    0.7.0.1
 */