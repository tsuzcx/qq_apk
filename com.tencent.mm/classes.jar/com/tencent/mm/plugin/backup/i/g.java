package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class g
  extends com.tencent.mm.bx.a
{
  public String vgL;
  public int vgM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22107);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vgL == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22107);
        throw paramVarArgs;
      }
      if (this.vgL != null) {
        paramVarArgs.g(1, this.vgL);
      }
      paramVarArgs.bS(2, this.vgM);
      AppMethodBeat.o(22107);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vgL == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.vgL) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vgM);
      AppMethodBeat.o(22107);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.vgL == null)
        {
          paramVarArgs = new b("Not all required fields were included: BakChatName");
          AppMethodBeat.o(22107);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22107);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22107);
          return -1;
        case 1: 
          localg.vgL = locala.ajGk.readString();
          AppMethodBeat.o(22107);
          return 0;
        }
        localg.vgM = locala.ajGk.aar();
        AppMethodBeat.o(22107);
        return 0;
      }
      AppMethodBeat.o(22107);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.g
 * JD-Core Version:    0.7.0.1
 */