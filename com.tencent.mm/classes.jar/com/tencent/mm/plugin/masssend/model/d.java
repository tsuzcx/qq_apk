package com.tencent.mm.plugin.masssend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bx.a
{
  public int begin;
  public int end;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(26357);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.begin);
      paramVarArgs.bS(2, this.end);
      AppMethodBeat.o(26357);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.begin);
      int i = i.a.a.b.b.a.cJ(2, this.end);
      AppMethodBeat.o(26357);
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
      AppMethodBeat.o(26357);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(26357);
        return -1;
      case 1: 
        locald.begin = locala.ajGk.aar();
        AppMethodBeat.o(26357);
        return 0;
      }
      locald.end = locala.ajGk.aar();
      AppMethodBeat.o(26357);
      return 0;
    }
    AppMethodBeat.o(26357);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.model.d
 * JD-Core Version:    0.7.0.1
 */