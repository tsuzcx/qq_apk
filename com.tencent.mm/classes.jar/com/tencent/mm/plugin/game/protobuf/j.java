package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class j
  extends com.tencent.mm.cd.a
{
  public String CNo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149408);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CNo == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppStoreUrl");
        AppMethodBeat.o(149408);
        throw paramVarArgs;
      }
      if (this.CNo != null) {
        paramVarArgs.f(1, this.CNo);
      }
      AppMethodBeat.o(149408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNo == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = g.a.a.b.b.a.g(1, this.CNo) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(149408);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CNo == null)
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
        localj.CNo = locala.abFh.readString();
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