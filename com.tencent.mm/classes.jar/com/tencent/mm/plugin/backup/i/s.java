package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  extends com.tencent.mm.bv.a
{
  public long jJO;
  public long jKl;
  public long jKm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18067);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.jJO);
      paramVarArgs.am(2, this.jKl);
      paramVarArgs.am(3, this.jKm);
      AppMethodBeat.o(18067);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.jJO);
      int i = e.a.a.b.b.a.p(2, this.jKl);
      int j = e.a.a.b.b.a.p(3, this.jKm);
      AppMethodBeat.o(18067);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(18067);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      s locals = (s)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(18067);
        return -1;
      case 1: 
        locals.jJO = locala.CLY.sm();
        AppMethodBeat.o(18067);
        return 0;
      case 2: 
        locals.jKl = locala.CLY.sm();
        AppMethodBeat.o(18067);
        return 0;
      }
      locals.jKm = locala.CLY.sm();
      AppMethodBeat.o(18067);
      return 0;
    }
    AppMethodBeat.o(18067);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.s
 * JD-Core Version:    0.7.0.1
 */