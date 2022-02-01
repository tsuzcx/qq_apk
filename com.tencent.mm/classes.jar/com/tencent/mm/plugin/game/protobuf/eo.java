package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class eo
  extends com.tencent.mm.bx.a
{
  public String IMh;
  public String IMi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41844);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IMh == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(41844);
        throw paramVarArgs;
      }
      if (this.IMi == null)
      {
        paramVarArgs = new b("Not all required fields were included: TimeDesc");
        AppMethodBeat.o(41844);
        throw paramVarArgs;
      }
      if (this.IMh != null) {
        paramVarArgs.g(1, this.IMh);
      }
      if (this.IMi != null) {
        paramVarArgs.g(2, this.IMi);
      }
      AppMethodBeat.o(41844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IMh == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = i.a.a.b.b.a.h(1, this.IMh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IMi != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IMi);
      }
      AppMethodBeat.o(41844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IMh == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(41844);
          throw paramVarArgs;
        }
        if (this.IMi == null)
        {
          paramVarArgs = new b("Not all required fields were included: TimeDesc");
          AppMethodBeat.o(41844);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41844);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eo localeo = (eo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41844);
          return -1;
        case 1: 
          localeo.IMh = locala.ajGk.readString();
          AppMethodBeat.o(41844);
          return 0;
        }
        localeo.IMi = locala.ajGk.readString();
        AppMethodBeat.o(41844);
        return 0;
      }
      AppMethodBeat.o(41844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.eo
 * JD-Core Version:    0.7.0.1
 */