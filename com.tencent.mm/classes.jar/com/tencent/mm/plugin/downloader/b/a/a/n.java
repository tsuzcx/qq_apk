package com.tencent.mm.plugin.downloader.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public boolean has_next;
  public int xlj;
  public long xlk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153056);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.xlj);
      paramVarArgs.di(2, this.has_next);
      paramVarArgs.bv(3, this.xlk);
      AppMethodBeat.o(153056);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.xlj);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.q(3, this.xlk);
      AppMethodBeat.o(153056);
      return paramInt + 0 + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(153056);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153056);
        return -1;
      case 1: 
        localn.xlj = locala.ajGk.aar();
        AppMethodBeat.o(153056);
        return 0;
      case 2: 
        localn.has_next = locala.ajGk.aai();
        AppMethodBeat.o(153056);
        return 0;
      }
      localn.xlk = locala.ajGk.aaw();
      AppMethodBeat.o(153056);
      return 0;
    }
    AppMethodBeat.o(153056);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.a.a.n
 * JD-Core Version:    0.7.0.1
 */