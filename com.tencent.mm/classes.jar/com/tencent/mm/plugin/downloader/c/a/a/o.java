package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bv.a
{
  public long kWj;
  public int limit;
  public int offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35524);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.offset);
      paramVarArgs.aO(2, this.limit);
      paramVarArgs.am(3, this.kWj);
      AppMethodBeat.o(35524);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.offset);
      int i = e.a.a.b.b.a.bl(2, this.limit);
      int j = e.a.a.b.b.a.p(3, this.kWj);
      AppMethodBeat.o(35524);
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
      AppMethodBeat.o(35524);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(35524);
        return -1;
      case 1: 
        localo.offset = locala.CLY.sl();
        AppMethodBeat.o(35524);
        return 0;
      case 2: 
        localo.limit = locala.CLY.sl();
        AppMethodBeat.o(35524);
        return 0;
      }
      localo.kWj = locala.CLY.sm();
      AppMethodBeat.o(35524);
      return 0;
    }
    AppMethodBeat.o(35524);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.o
 * JD-Core Version:    0.7.0.1
 */