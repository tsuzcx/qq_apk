package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class cg
  extends com.tencent.mm.bv.a
{
  public String Name;
  public String ntA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111643);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(111643);
        throw paramVarArgs;
      }
      if (this.ntA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Color");
        AppMethodBeat.o(111643);
        throw paramVarArgs;
      }
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      if (this.ntA != null) {
        paramVarArgs.e(2, this.ntA);
      }
      AppMethodBeat.o(111643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = e.a.a.b.b.a.f(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ntA != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.ntA);
      }
      AppMethodBeat.o(111643);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Name == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(111643);
          throw paramVarArgs;
        }
        if (this.ntA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Color");
          AppMethodBeat.o(111643);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111643);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cg localcg = (cg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111643);
          return -1;
        case 1: 
          localcg.Name = locala.CLY.readString();
          AppMethodBeat.o(111643);
          return 0;
        }
        localcg.ntA = locala.CLY.readString();
        AppMethodBeat.o(111643);
        return 0;
      }
      AppMethodBeat.o(111643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cg
 * JD-Core Version:    0.7.0.1
 */