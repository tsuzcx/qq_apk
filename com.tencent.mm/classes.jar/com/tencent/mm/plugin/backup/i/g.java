package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class g
  extends com.tencent.mm.bw.a
{
  public String nIB;
  public int nIC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22107);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIB == null)
      {
        paramVarArgs = new b("Not all required fields were included: BakChatName");
        AppMethodBeat.o(22107);
        throw paramVarArgs;
      }
      if (this.nIB != null) {
        paramVarArgs.d(1, this.nIB);
      }
      paramVarArgs.aS(2, this.nIC);
      AppMethodBeat.o(22107);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIB == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.nIB) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.nIC);
      AppMethodBeat.o(22107);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.nIB == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        g localg = (g)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22107);
          return -1;
        case 1: 
          localg.nIB = locala.OmT.readString();
          AppMethodBeat.o(22107);
          return 0;
        }
        localg.nIC = locala.OmT.zc();
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