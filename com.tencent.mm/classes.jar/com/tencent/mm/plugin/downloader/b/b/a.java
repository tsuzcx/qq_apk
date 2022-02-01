package com.tencent.mm.plugin.downloader.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bx.a
{
  public long xll;
  public long xlm;
  public String xln;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153058);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.xll);
      paramVarArgs.bv(2, this.xlm);
      if (this.xln != null) {
        paramVarArgs.g(3, this.xln);
      }
      AppMethodBeat.o(153058);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.xll) + 0 + i.a.a.b.b.a.q(2, this.xlm);
      paramInt = i;
      if (this.xln != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.xln);
      }
      AppMethodBeat.o(153058);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(153058);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153058);
        return -1;
      case 1: 
        locala1.xll = locala.ajGk.aaw();
        AppMethodBeat.o(153058);
        return 0;
      case 2: 
        locala1.xlm = locala.ajGk.aaw();
        AppMethodBeat.o(153058);
        return 0;
      }
      locala1.xln = locala.ajGk.readString();
      AppMethodBeat.o(153058);
      return 0;
    }
    AppMethodBeat.o(153058);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.b.b.a
 * JD-Core Version:    0.7.0.1
 */