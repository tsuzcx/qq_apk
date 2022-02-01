package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  extends com.tencent.mm.bw.a
{
  public long oTS;
  public long oUo;
  public long oUp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22124);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.oTS);
      paramVarArgs.bb(2, this.oUo);
      paramVarArgs.bb(3, this.oUp);
      AppMethodBeat.o(22124);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.oTS);
      int i = g.a.a.b.b.a.r(2, this.oUo);
      int j = g.a.a.b.b.a.r(3, this.oUp);
      AppMethodBeat.o(22124);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(22124);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      s locals = (s)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22124);
        return -1;
      case 1: 
        locals.oTS = locala.UbS.zl();
        AppMethodBeat.o(22124);
        return 0;
      case 2: 
        locals.oUo = locala.UbS.zl();
        AppMethodBeat.o(22124);
        return 0;
      }
      locals.oUp = locala.UbS.zl();
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