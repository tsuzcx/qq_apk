package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ah
  extends com.tencent.mm.bx.a
{
  public String IIu;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41725);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(41725);
        throw paramVarArgs;
      }
      if (this.IIu == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41725);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.IIu != null) {
        paramVarArgs.g(2, this.IIu);
      }
      AppMethodBeat.o(41725);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = i.a.a.b.b.a.h(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IIu != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IIu);
      }
      AppMethodBeat.o(41725);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.UserName == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(41725);
          throw paramVarArgs;
        }
        if (this.IIu == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41725);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41725);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ah localah = (ah)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41725);
          return -1;
        case 1: 
          localah.UserName = locala.ajGk.readString();
          AppMethodBeat.o(41725);
          return 0;
        }
        localah.IIu = locala.ajGk.readString();
        AppMethodBeat.o(41725);
        return 0;
      }
      AppMethodBeat.o(41725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ah
 * JD-Core Version:    0.7.0.1
 */