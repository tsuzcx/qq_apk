package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class dj
  extends com.tencent.mm.bw.a
{
  public String xJD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149417);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xJD == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(149417);
        throw paramVarArgs;
      }
      if (this.xJD != null) {
        paramVarArgs.e(1, this.xJD);
      }
      AppMethodBeat.o(149417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJD == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = g.a.a.b.b.a.f(1, this.xJD) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(149417);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xJD == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgId");
          AppMethodBeat.o(149417);
          throw paramVarArgs;
        }
        AppMethodBeat.o(149417);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dj localdj = (dj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149417);
          return -1;
        }
        localdj.xJD = locala.UbS.readString();
        AppMethodBeat.o(149417);
        return 0;
      }
      AppMethodBeat.o(149417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dj
 * JD-Core Version:    0.7.0.1
 */