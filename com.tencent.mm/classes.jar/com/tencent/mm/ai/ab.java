package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ab
  extends com.tencent.mm.bx.a
{
  public int style;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217235);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).aS(1, this.style);
      AppMethodBeat.o(217235);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.style);
      AppMethodBeat.o(217235);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(217235);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ab localab = (ab)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(217235);
        return -1;
      }
      localab.style = locala.NPN.zc();
      AppMethodBeat.o(217235);
      return 0;
    }
    AppMethodBeat.o(217235);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.ab
 * JD-Core Version:    0.7.0.1
 */