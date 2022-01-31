package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends com.tencent.mm.bv.a
{
  public int id;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35534);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.id);
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      AppMethodBeat.o(35534);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.id) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.name);
      }
      AppMethodBeat.o(35534);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(35534);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      h localh = (h)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(35534);
        return -1;
      case 1: 
        localh.id = locala.CLY.sl();
        AppMethodBeat.o(35534);
        return 0;
      }
      localh.name = locala.CLY.readString();
      AppMethodBeat.o(35534);
      return 0;
    }
    AppMethodBeat.o(35534);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.h
 * JD-Core Version:    0.7.0.1
 */