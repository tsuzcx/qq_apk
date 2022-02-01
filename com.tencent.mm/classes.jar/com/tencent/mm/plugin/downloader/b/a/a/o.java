package com.tencent.mm.plugin.downloader.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bx.a
{
  public int limit;
  public int offset;
  public long xlk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153057);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.offset);
      paramVarArgs.bS(2, this.limit);
      paramVarArgs.bv(3, this.xlk);
      AppMethodBeat.o(153057);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.offset);
      int i = i.a.a.b.b.a.cJ(2, this.limit);
      int j = i.a.a.b.b.a.q(3, this.xlk);
      AppMethodBeat.o(153057);
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
      AppMethodBeat.o(153057);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153057);
        return -1;
      case 1: 
        localo.offset = locala.ajGk.aar();
        AppMethodBeat.o(153057);
        return 0;
      case 2: 
        localo.limit = locala.ajGk.aar();
        AppMethodBeat.o(153057);
        return 0;
      }
      localo.xlk = locala.ajGk.aaw();
      AppMethodBeat.o(153057);
      return 0;
    }
    AppMethodBeat.o(153057);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.a.a.o
 * JD-Core Version:    0.7.0.1
 */