package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bx.a
{
  public int IGR;
  public int IGS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149405);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IGR);
      paramVarArgs.bS(2, this.IGS);
      AppMethodBeat.o(149405);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.IGR);
      int i = i.a.a.b.b.a.cJ(2, this.IGS);
      AppMethodBeat.o(149405);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(149405);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149405);
        return -1;
      case 1: 
        localf.IGR = locala.ajGk.aar();
        AppMethodBeat.o(149405);
        return 0;
      }
      localf.IGS = locala.ajGk.aar();
      AppMethodBeat.o(149405);
      return 0;
    }
    AppMethodBeat.o(149405);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.f
 * JD-Core Version:    0.7.0.1
 */