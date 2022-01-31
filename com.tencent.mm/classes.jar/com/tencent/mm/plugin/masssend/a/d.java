package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bv.a
{
  public int bVp;
  public int end;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22735);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.bVp);
      paramVarArgs.aO(2, this.end);
      AppMethodBeat.o(22735);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.bVp);
      int i = e.a.a.b.b.a.bl(2, this.end);
      AppMethodBeat.o(22735);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(22735);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22735);
        return -1;
      case 1: 
        locald.bVp = locala.CLY.sl();
        AppMethodBeat.o(22735);
        return 0;
      }
      locald.end = locala.CLY.sl();
      AppMethodBeat.o(22735);
      return 0;
    }
    AppMethodBeat.o(22735);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.d
 * JD-Core Version:    0.7.0.1
 */