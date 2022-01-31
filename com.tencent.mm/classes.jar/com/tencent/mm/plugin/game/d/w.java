package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class w
  extends com.tencent.mm.bv.a
{
  public String jJA;
  public String nqY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111560);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(111560);
        throw paramVarArgs;
      }
      if (this.nqY == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(111560);
        throw paramVarArgs;
      }
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      if (this.nqY != null) {
        paramVarArgs.e(2, this.nqY);
      }
      AppMethodBeat.o(111560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = e.a.a.b.b.a.f(1, this.jJA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nqY != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.nqY);
      }
      AppMethodBeat.o(111560);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.jJA == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(111560);
          throw paramVarArgs;
        }
        if (this.nqY == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(111560);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111560);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        w localw = (w)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111560);
          return -1;
        case 1: 
          localw.jJA = locala.CLY.readString();
          AppMethodBeat.o(111560);
          return 0;
        }
        localw.nqY = locala.CLY.readString();
        AppMethodBeat.o(111560);
        return 0;
      }
      AppMethodBeat.o(111560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.w
 * JD-Core Version:    0.7.0.1
 */