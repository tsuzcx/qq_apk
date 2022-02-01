package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class a
  extends com.tencent.mm.bx.a
{
  public String username;
  public boolean uxk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211154);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(211154);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.bt(2, this.uxk);
      AppMethodBeat.o(211154);
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
      int i = f.a.a.b.b.a.alV(2);
      AppMethodBeat.o(211154);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(211154);
          throw paramVarArgs;
        }
        AppMethodBeat.o(211154);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(211154);
          return -1;
        case 1: 
          locala1.username = locala.NPN.readString();
          AppMethodBeat.o(211154);
          return 0;
        }
        locala1.uxk = locala.NPN.grw();
        AppMethodBeat.o(211154);
        return 0;
      }
      AppMethodBeat.o(211154);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.a
 * JD-Core Version:    0.7.0.1
 */