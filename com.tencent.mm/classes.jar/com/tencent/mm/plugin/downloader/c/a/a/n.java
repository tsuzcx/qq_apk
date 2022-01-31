package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bv.a
{
  public int kWh;
  public boolean kWi;
  public long kWj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35523);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.kWh);
      paramVarArgs.aS(2, this.kWi);
      paramVarArgs.am(3, this.kWj);
      AppMethodBeat.o(35523);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.kWh);
      int i = e.a.a.b.b.a.eW(2);
      int j = e.a.a.b.b.a.p(3, this.kWj);
      AppMethodBeat.o(35523);
      return paramInt + 0 + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(35523);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(35523);
        return -1;
      case 1: 
        localn.kWh = locala.CLY.sl();
        AppMethodBeat.o(35523);
        return 0;
      case 2: 
        localn.kWi = locala.CLY.emu();
        AppMethodBeat.o(35523);
        return 0;
      }
      localn.kWj = locala.CLY.sm();
      AppMethodBeat.o(35523);
      return 0;
    }
    AppMethodBeat.o(35523);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.n
 * JD-Core Version:    0.7.0.1
 */