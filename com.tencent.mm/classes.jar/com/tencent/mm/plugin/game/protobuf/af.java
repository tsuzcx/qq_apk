package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class af
  extends com.tencent.mm.bw.a
{
  public String UserName;
  public String xKd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41725);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(41725);
        throw paramVarArgs;
      }
      if (this.xKd == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41725);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.xKd != null) {
        paramVarArgs.e(2, this.xKd);
      }
      AppMethodBeat.o(41725);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.f(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xKd != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xKd);
      }
      AppMethodBeat.o(41725);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.UserName == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(41725);
          throw paramVarArgs;
        }
        if (this.xKd == null)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        af localaf = (af)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41725);
          return -1;
        case 1: 
          localaf.UserName = locala.UbS.readString();
          AppMethodBeat.o(41725);
          return 0;
        }
        localaf.xKd = locala.UbS.readString();
        AppMethodBeat.o(41725);
        return 0;
      }
      AppMethodBeat.o(41725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.af
 * JD-Core Version:    0.7.0.1
 */