package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class a
  extends com.tencent.mm.bw.a
{
  public String username;
  public boolean yaY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225884);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(225884);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      paramVarArgs.cc(2, this.yaY);
      AppMethodBeat.o(225884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.username) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.fS(2);
      AppMethodBeat.o(225884);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(225884);
          throw paramVarArgs;
        }
        AppMethodBeat.o(225884);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(225884);
          return -1;
        case 1: 
          locala1.username = locala.UbS.readString();
          AppMethodBeat.o(225884);
          return 0;
        }
        locala1.yaY = locala.UbS.yZ();
        AppMethodBeat.o(225884);
        return 0;
      }
      AppMethodBeat.o(225884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.a
 * JD-Core Version:    0.7.0.1
 */