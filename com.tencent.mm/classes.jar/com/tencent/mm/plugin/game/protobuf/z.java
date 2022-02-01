package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class z
  extends com.tencent.mm.bw.a
{
  public boolean xJV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256630);
    if (paramInt == 0)
    {
      ((g.a.a.c.a)paramVarArgs[0]).cc(1, this.xJV);
      AppMethodBeat.o(256630);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.fS(1);
      AppMethodBeat.o(256630);
      return paramInt + 1 + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(256630);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      z localz = (z)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(256630);
        return -1;
      }
      localz.xJV = locala.UbS.yZ();
      AppMethodBeat.o(256630);
      return 0;
    }
    AppMethodBeat.o(256630);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.z
 * JD-Core Version:    0.7.0.1
 */