package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bw.a
{
  public long uIN;
  public long uIO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218198);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.uIN);
      paramVarArgs.aZ(2, this.uIO);
      AppMethodBeat.o(218198);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.uIN);
      int i = f.a.a.b.b.a.p(2, this.uIO);
      AppMethodBeat.o(218198);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(218198);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(218198);
        return -1;
      case 1: 
        localc.uIN = locala.OmT.zd();
        AppMethodBeat.o(218198);
        return 0;
      }
      localc.uIO = locala.OmT.zd();
      AppMethodBeat.o(218198);
      return 0;
    }
    AppMethodBeat.o(218198);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.c
 * JD-Core Version:    0.7.0.1
 */