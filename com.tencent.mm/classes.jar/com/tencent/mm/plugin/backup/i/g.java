package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class g
  extends com.tencent.mm.bw.a
{
  public String oTx;
  public int oTy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22107);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oTx == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22107);
        throw paramVarArgs;
      }
      if (this.oTx != null) {
        paramVarArgs.e(1, this.oTx);
      }
      paramVarArgs.aM(2, this.oTy);
      AppMethodBeat.o(22107);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oTx == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.oTx) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.oTy);
      AppMethodBeat.o(22107);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.oTx == null)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22107);
          return -1;
        case 1: 
          localg.oTx = locala.UbS.readString();
          AppMethodBeat.o(22107);
          return 0;
        }
        localg.oTy = locala.UbS.zi();
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