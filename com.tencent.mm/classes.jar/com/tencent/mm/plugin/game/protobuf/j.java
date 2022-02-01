package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class j
  extends com.tencent.mm.bw.a
{
  public String xJh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149408);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xJh == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppStoreUrl");
        AppMethodBeat.o(149408);
        throw paramVarArgs;
      }
      if (this.xJh != null) {
        paramVarArgs.e(1, this.xJh);
      }
      AppMethodBeat.o(149408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJh == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = g.a.a.b.b.a.f(1, this.xJh) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(149408);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xJh == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppStoreUrl");
          AppMethodBeat.o(149408);
          throw paramVarArgs;
        }
        AppMethodBeat.o(149408);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149408);
          return -1;
        }
        localj.xJh = locala.UbS.readString();
        AppMethodBeat.o(149408);
        return 0;
      }
      AppMethodBeat.o(149408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.j
 * JD-Core Version:    0.7.0.1
 */