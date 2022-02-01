package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bw.a
{
  public long qGj;
  public long qGk;
  public String qGl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153058);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.qGj);
      paramVarArgs.bb(2, this.qGk);
      if (this.qGl != null) {
        paramVarArgs.e(3, this.qGl);
      }
      AppMethodBeat.o(153058);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.qGj) + 0 + g.a.a.b.b.a.r(2, this.qGk);
      paramInt = i;
      if (this.qGl != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qGl);
      }
      AppMethodBeat.o(153058);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(153058);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153058);
        return -1;
      case 1: 
        locala1.qGj = locala.UbS.zl();
        AppMethodBeat.o(153058);
        return 0;
      case 2: 
        locala1.qGk = locala.UbS.zl();
        AppMethodBeat.o(153058);
        return 0;
      }
      locala1.qGl = locala.UbS.readString();
      AppMethodBeat.o(153058);
      return 0;
    }
    AppMethodBeat.o(153058);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.a
 * JD-Core Version:    0.7.0.1
 */