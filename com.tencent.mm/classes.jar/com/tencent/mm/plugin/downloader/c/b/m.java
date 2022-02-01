package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.cd.a
{
  public long duration;
  public long interval;
  public long ugk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153073);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.duration);
      paramVarArgs.bm(2, this.interval);
      paramVarArgs.bm(3, this.ugk);
      AppMethodBeat.o(153073);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.duration);
      int i = g.a.a.b.b.a.p(2, this.interval);
      int j = g.a.a.b.b.a.p(3, this.ugk);
      AppMethodBeat.o(153073);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(153073);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153073);
        return -1;
      case 1: 
        localm.duration = locala.abFh.AN();
        AppMethodBeat.o(153073);
        return 0;
      case 2: 
        localm.interval = locala.abFh.AN();
        AppMethodBeat.o(153073);
        return 0;
      }
      localm.ugk = locala.abFh.AN();
      AppMethodBeat.o(153073);
      return 0;
    }
    AppMethodBeat.o(153073);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.m
 * JD-Core Version:    0.7.0.1
 */