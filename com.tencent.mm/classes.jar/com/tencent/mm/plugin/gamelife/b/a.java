package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class a
  extends com.tencent.mm.bw.a
{
  public boolean uIK;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218196);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(218196);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.bC(2, this.uIK);
      AppMethodBeat.o(218196);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.amF(2);
      AppMethodBeat.o(218196);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(218196);
          throw paramVarArgs;
        }
        AppMethodBeat.o(218196);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(218196);
          return -1;
        case 1: 
          locala1.username = locala.OmT.readString();
          AppMethodBeat.o(218196);
          return 0;
        }
        locala1.uIK = locala.OmT.gvY();
        AppMethodBeat.o(218196);
        return 0;
      }
      AppMethodBeat.o(218196);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.a
 * JD-Core Version:    0.7.0.1
 */