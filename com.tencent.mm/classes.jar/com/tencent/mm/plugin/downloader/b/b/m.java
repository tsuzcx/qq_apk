package com.tencent.mm.plugin.downloader.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bx.a
{
  public long duration;
  public long interval;
  public long xmr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153073);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.duration);
      paramVarArgs.bv(2, this.interval);
      paramVarArgs.bv(3, this.xmr);
      AppMethodBeat.o(153073);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.duration);
      int i = i.a.a.b.b.a.q(2, this.interval);
      int j = i.a.a.b.b.a.q(3, this.xmr);
      AppMethodBeat.o(153073);
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
      AppMethodBeat.o(153073);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153073);
        return -1;
      case 1: 
        localm.duration = locala.ajGk.aaw();
        AppMethodBeat.o(153073);
        return 0;
      case 2: 
        localm.interval = locala.ajGk.aaw();
        AppMethodBeat.o(153073);
        return 0;
      }
      localm.xmr = locala.ajGk.aaw();
      AppMethodBeat.o(153073);
      return 0;
    }
    AppMethodBeat.o(153073);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.b.m
 * JD-Core Version:    0.7.0.1
 */