package com.tencent.mm.ce;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bw.a
{
  public int NKP = -1;
  public int NKQ;
  public int bNu;
  public int owH;
  public int owI;
  public int owJ;
  public int size;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104918);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.owH);
      paramVarArgs.aM(2, this.owI);
      paramVarArgs.aM(3, this.owJ);
      paramVarArgs.aM(41, this.NKP);
      paramVarArgs.aM(5, this.NKQ);
      paramVarArgs.aM(6, this.bNu);
      paramVarArgs.aM(7, this.size);
      AppMethodBeat.o(104918);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.owH);
      int i = g.a.a.b.b.a.bu(2, this.owI);
      int j = g.a.a.b.b.a.bu(3, this.owJ);
      int k = g.a.a.b.b.a.bu(41, this.NKP);
      int m = g.a.a.b.b.a.bu(5, this.NKQ);
      int n = g.a.a.b.b.a.bu(6, this.bNu);
      int i1 = g.a.a.b.b.a.bu(7, this.size);
      AppMethodBeat.o(104918);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
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
        localc.owH = locala.UbS.zi();
        AppMethodBeat.o(104918);
        return 0;
      case 2: 
        localc.owI = locala.UbS.zi();
        AppMethodBeat.o(104918);
        return 0;
      case 3: 
        localc.owJ = locala.UbS.zi();
        AppMethodBeat.o(104918);
        return 0;
      case 41: 
        localc.NKP = locala.UbS.zi();
        AppMethodBeat.o(104918);
        return 0;
      case 5: 
        localc.NKQ = locala.UbS.zi();
        AppMethodBeat.o(104918);
        return 0;
      case 6: 
        localc.bNu = locala.UbS.zi();
        AppMethodBeat.o(104918);
        return 0;
      }
      localc.size = locala.UbS.zi();
      AppMethodBeat.o(104918);
      return 0;
    }
    AppMethodBeat.o(104918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ce.c
 * JD-Core Version:    0.7.0.1
 */