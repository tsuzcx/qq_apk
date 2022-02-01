package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
  extends com.tencent.mm.bw.a
{
  public long duration;
  public long interval;
  public long oHv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153073);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.duration);
      paramVarArgs.aO(2, this.interval);
      paramVarArgs.aO(3, this.oHv);
      AppMethodBeat.o(153073);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.duration);
      int i = f.a.a.b.b.a.p(2, this.interval);
      int j = f.a.a.b.b.a.p(3, this.oHv);
      AppMethodBeat.o(153073);
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
      AppMethodBeat.o(153073);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153073);
        return -1;
      case 1: 
        localm.duration = locala.LVo.xG();
        AppMethodBeat.o(153073);
        return 0;
      case 2: 
        localm.interval = locala.LVo.xG();
        AppMethodBeat.o(153073);
        return 0;
      }
      localm.oHv = locala.LVo.xG();
      AppMethodBeat.o(153073);
      return 0;
    }
    AppMethodBeat.o(153073);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.m
 * JD-Core Version:    0.7.0.1
 */