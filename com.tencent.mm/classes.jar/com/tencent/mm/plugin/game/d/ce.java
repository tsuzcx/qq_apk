package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class ce
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String npU;
  public String nqa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111640);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nqa == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconURL");
        AppMethodBeat.o(111640);
        throw paramVarArgs;
      }
      if (this.nqa != null) {
        paramVarArgs.e(1, this.nqa);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.npU != null) {
        paramVarArgs.e(3, this.npU);
      }
      AppMethodBeat.o(111640);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nqa == null) {
        break label382;
      }
    }
    label382:
    for (int i = e.a.a.b.b.a.f(1, this.nqa) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.npU != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.npU);
      }
      AppMethodBeat.o(111640);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.nqa == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconURL");
          AppMethodBeat.o(111640);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111640);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ce localce = (ce)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111640);
          return -1;
        case 1: 
          localce.nqa = locala.CLY.readString();
          AppMethodBeat.o(111640);
          return 0;
        case 2: 
          localce.Title = locala.CLY.readString();
          AppMethodBeat.o(111640);
          return 0;
        }
        localce.npU = locala.CLY.readString();
        AppMethodBeat.o(111640);
        return 0;
      }
      AppMethodBeat.o(111640);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ce
 * JD-Core Version:    0.7.0.1
 */