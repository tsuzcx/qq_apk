package com.tencent.mm.ce;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bw.a
{
  public int max;
  public int min;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104919);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.min);
      paramVarArgs.aM(2, this.max);
      AppMethodBeat.o(104919);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.min);
      int i = g.a.a.b.b.a.bu(2, this.max);
      AppMethodBeat.o(104919);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(104919);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104919);
        return -1;
      case 1: 
        locald.min = locala.UbS.zi();
        AppMethodBeat.o(104919);
        return 0;
      }
      locald.max = locala.UbS.zi();
      AppMethodBeat.o(104919);
      return 0;
    }
    AppMethodBeat.o(104919);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ce.d
 * JD-Core Version:    0.7.0.1
 */