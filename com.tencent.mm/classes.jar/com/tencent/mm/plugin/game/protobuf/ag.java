package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ag
  extends com.tencent.mm.cd.a
{
  public String COk;
  public String UserName;
  
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
      if (this.COk == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41725);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.COk != null) {
        paramVarArgs.f(2, this.COk);
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
    for (paramInt = g.a.a.b.b.a.g(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.COk != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.COk);
      }
      AppMethodBeat.o(41725);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UserName == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(41725);
          throw paramVarArgs;
        }
        if (this.COk == null)
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
        ag localag = (ag)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41725);
          return -1;
        case 1: 
          localag.UserName = locala.abFh.readString();
          AppMethodBeat.o(41725);
          return 0;
        }
        localag.COk = locala.abFh.readString();
        AppMethodBeat.o(41725);
        return 0;
      }
      AppMethodBeat.o(41725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ag
 * JD-Core Version:    0.7.0.1
 */