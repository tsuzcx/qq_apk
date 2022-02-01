package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dz
  extends com.tencent.mm.bw.a
{
  public String xMX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256650);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xMX != null) {
        paramVarArgs.e(1, this.xMX);
      }
      AppMethodBeat.o(256650);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xMX == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.f(1, this.xMX) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(256650);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256650);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dz localdz = (dz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(256650);
          return -1;
        }
        localdz.xMX = locala.UbS.readString();
        AppMethodBeat.o(256650);
        return 0;
      }
      AppMethodBeat.o(256650);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dz
 * JD-Core Version:    0.7.0.1
 */