package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bv.a
{
  public long duration;
  public long interval;
  public long kXg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35538);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.duration);
      paramVarArgs.am(2, this.interval);
      paramVarArgs.am(3, this.kXg);
      AppMethodBeat.o(35538);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.duration);
      int i = e.a.a.b.b.a.p(2, this.interval);
      int j = e.a.a.b.b.a.p(3, this.kXg);
      AppMethodBeat.o(35538);
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
      AppMethodBeat.o(35538);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(35538);
        return -1;
      case 1: 
        locall.duration = locala.CLY.sm();
        AppMethodBeat.o(35538);
        return 0;
      case 2: 
        locall.interval = locala.CLY.sm();
        AppMethodBeat.o(35538);
        return 0;
      }
      locall.kXg = locala.CLY.sm();
      AppMethodBeat.o(35538);
      return 0;
    }
    AppMethodBeat.o(35538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.l
 * JD-Core Version:    0.7.0.1
 */