package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  extends com.tencent.mm.bw.a
{
  public long ndB;
  public long ndC;
  public long ndf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22124);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.ndf);
      paramVarArgs.aO(2, this.ndB);
      paramVarArgs.aO(3, this.ndC);
      AppMethodBeat.o(22124);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.ndf);
      int i = f.a.a.b.b.a.p(2, this.ndB);
      int j = f.a.a.b.b.a.p(3, this.ndC);
      AppMethodBeat.o(22124);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(22124);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      s locals = (s)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(22124);
        return -1;
      case 1: 
        locals.ndf = locala.LVo.xG();
        AppMethodBeat.o(22124);
        return 0;
      case 2: 
        locals.ndB = locala.LVo.xG();
        AppMethodBeat.o(22124);
        return 0;
      }
      locals.ndC = locala.LVo.xG();
      AppMethodBeat.o(22124);
      return 0;
    }
    AppMethodBeat.o(22124);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.s
 * JD-Core Version:    0.7.0.1
 */