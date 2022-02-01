package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bw.a
{
  public int xIH;
  public int xII;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149405);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.xIH);
      paramVarArgs.aM(2, this.xII);
      AppMethodBeat.o(149405);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.xIH);
      int i = g.a.a.b.b.a.bu(2, this.xII);
      AppMethodBeat.o(149405);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(149405);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      f localf = (f)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149405);
        return -1;
      case 1: 
        localf.xIH = locala.UbS.zi();
        AppMethodBeat.o(149405);
        return 0;
      }
      localf.xII = locala.UbS.zi();
      AppMethodBeat.o(149405);
      return 0;
    }
    AppMethodBeat.o(149405);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.f
 * JD-Core Version:    0.7.0.1
 */