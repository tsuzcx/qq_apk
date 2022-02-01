package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class do
  extends com.tencent.mm.bx.a
{
  public String IHV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149417);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IHV == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(149417);
        throw paramVarArgs;
      }
      if (this.IHV != null) {
        paramVarArgs.g(1, this.IHV);
      }
      AppMethodBeat.o(149417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IHV == null) {
        break label257;
      }
    }
    label257:
    for (paramInt = i.a.a.b.b.a.h(1, this.IHV) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(149417);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IHV == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        do localdo = (do)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149417);
          return -1;
        }
        localdo.IHV = locala.ajGk.readString();
        AppMethodBeat.o(149417);
        return 0;
      }
      AppMethodBeat.o(149417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.do
 * JD-Core Version:    0.7.0.1
 */