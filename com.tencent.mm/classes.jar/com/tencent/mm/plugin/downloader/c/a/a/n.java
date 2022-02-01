package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bw.a
{
  public int qGg;
  public boolean qGh;
  public long qGi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153056);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.qGg);
      paramVarArgs.cc(2, this.qGh);
      paramVarArgs.bb(3, this.qGi);
      AppMethodBeat.o(153056);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.qGg);
      int i = g.a.a.b.b.a.fS(2);
      int j = g.a.a.b.b.a.r(3, this.qGi);
      AppMethodBeat.o(153056);
      return paramInt + 0 + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(153056);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153056);
        return -1;
      case 1: 
        localn.qGg = locala.UbS.zi();
        AppMethodBeat.o(153056);
        return 0;
      case 2: 
        localn.qGh = locala.UbS.yZ();
        AppMethodBeat.o(153056);
        return 0;
      }
      localn.qGi = locala.UbS.zl();
      AppMethodBeat.o(153056);
      return 0;
    }
    AppMethodBeat.o(153056);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.n
 * JD-Core Version:    0.7.0.1
 */