package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  extends com.tencent.mm.bx.a
{
  public long vhC;
  public long vhD;
  public long vhg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22124);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.vhg);
      paramVarArgs.bv(2, this.vhC);
      paramVarArgs.bv(3, this.vhD);
      AppMethodBeat.o(22124);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.vhg);
      int i = i.a.a.b.b.a.q(2, this.vhC);
      int j = i.a.a.b.b.a.q(3, this.vhD);
      AppMethodBeat.o(22124);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(22124);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      s locals = (s)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22124);
        return -1;
      case 1: 
        locals.vhg = locala.ajGk.aaw();
        AppMethodBeat.o(22124);
        return 0;
      case 2: 
        locals.vhC = locala.ajGk.aaw();
        AppMethodBeat.o(22124);
        return 0;
      }
      locals.vhD = locala.ajGk.aaw();
      AppMethodBeat.o(22124);
      return 0;
    }
    AppMethodBeat.o(22124);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.s
 * JD-Core Version:    0.7.0.1
 */