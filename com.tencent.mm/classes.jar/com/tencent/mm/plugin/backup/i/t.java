package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class t
  extends com.tencent.mm.bx.a
{
  public String vgy;
  public int vhE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22125);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vgy == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22125);
        throw paramVarArgs;
      }
      if (this.vgy != null) {
        paramVarArgs.g(1, this.vgy);
      }
      paramVarArgs.bS(2, this.vhE);
      AppMethodBeat.o(22125);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vgy == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.vgy) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vhE);
      AppMethodBeat.o(22125);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.vgy == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22125);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22125);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22125);
          return -1;
        case 1: 
          localt.vgy = locala.ajGk.readString();
          AppMethodBeat.o(22125);
          return 0;
        }
        localt.vhE = locala.ajGk.aar();
        AppMethodBeat.o(22125);
        return 0;
      }
      AppMethodBeat.o(22125);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.t
 * JD-Core Version:    0.7.0.1
 */