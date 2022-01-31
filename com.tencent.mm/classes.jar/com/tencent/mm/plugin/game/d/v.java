package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class v
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String jJA;
  public String nqY;
  public String nqa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111559);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(111559);
        throw paramVarArgs;
      }
      if (this.nqY == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(111559);
        throw paramVarArgs;
      }
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      if (this.nqa != null) {
        paramVarArgs.e(2, this.nqa);
      }
      if (this.Title != null) {
        paramVarArgs.e(3, this.Title);
      }
      if (this.nqY != null) {
        paramVarArgs.e(4, this.nqY);
      }
      AppMethodBeat.o(111559);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label490;
      }
    }
    label490:
    for (int i = e.a.a.b.b.a.f(1, this.jJA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nqa != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.nqa);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Title);
      }
      paramInt = i;
      if (this.nqY != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.nqY);
      }
      AppMethodBeat.o(111559);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(111559);
          throw paramVarArgs;
        }
        if (this.nqY == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(111559);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111559);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        v localv = (v)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111559);
          return -1;
        case 1: 
          localv.jJA = locala.CLY.readString();
          AppMethodBeat.o(111559);
          return 0;
        case 2: 
          localv.nqa = locala.CLY.readString();
          AppMethodBeat.o(111559);
          return 0;
        case 3: 
          localv.Title = locala.CLY.readString();
          AppMethodBeat.o(111559);
          return 0;
        }
        localv.nqY = locala.CLY.readString();
        AppMethodBeat.o(111559);
        return 0;
      }
      AppMethodBeat.o(111559);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.v
 * JD-Core Version:    0.7.0.1
 */