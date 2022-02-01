package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bw.a
{
  public int limit;
  public int offset;
  public long qGi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153057);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.offset);
      paramVarArgs.aM(2, this.limit);
      paramVarArgs.bb(3, this.qGi);
      AppMethodBeat.o(153057);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.offset);
      int i = g.a.a.b.b.a.bu(2, this.limit);
      int j = g.a.a.b.b.a.r(3, this.qGi);
      AppMethodBeat.o(153057);
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
      AppMethodBeat.o(153057);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153057);
        return -1;
      case 1: 
        localo.offset = locala.UbS.zi();
        AppMethodBeat.o(153057);
        return 0;
      case 2: 
        localo.limit = locala.UbS.zi();
        AppMethodBeat.o(153057);
        return 0;
      }
      localo.qGi = locala.UbS.zl();
      AppMethodBeat.o(153057);
      return 0;
    }
    AppMethodBeat.o(153057);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.o
 * JD-Core Version:    0.7.0.1
 */