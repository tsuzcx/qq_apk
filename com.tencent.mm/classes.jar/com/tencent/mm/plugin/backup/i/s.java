package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
  extends com.tencent.mm.bw.a
{
  public long nIX;
  public long nJt;
  public long nJu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22124);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.nIX);
      paramVarArgs.aZ(2, this.nJt);
      paramVarArgs.aZ(3, this.nJu);
      AppMethodBeat.o(22124);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.nIX);
      int i = f.a.a.b.b.a.p(2, this.nJt);
      int j = f.a.a.b.b.a.p(3, this.nJu);
      AppMethodBeat.o(22124);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        locals.nIX = locala.OmT.zd();
        AppMethodBeat.o(22124);
        return 0;
      case 2: 
        locals.nJt = locala.OmT.zd();
        AppMethodBeat.o(22124);
        return 0;
      }
      locals.nJu = locala.OmT.zd();
      AppMethodBeat.o(22124);
      return 0;
    }
    AppMethodBeat.o(22124);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.s
 * JD-Core Version:    0.7.0.1
 */