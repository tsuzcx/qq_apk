package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class ai
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String npR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111575);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Desc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(111575);
        throw paramVarArgs;
      }
      if (this.Desc != null) {
        paramVarArgs.e(1, this.Desc);
      }
      if (this.npR != null) {
        paramVarArgs.e(2, this.npR);
      }
      AppMethodBeat.o(111575);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Desc == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = e.a.a.b.b.a.f(1, this.Desc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.npR != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.npR);
      }
      AppMethodBeat.o(111575);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Desc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(111575);
          throw paramVarArgs;
        }
        AppMethodBeat.o(111575);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111575);
          return -1;
        case 1: 
          localai.Desc = locala.CLY.readString();
          AppMethodBeat.o(111575);
          return 0;
        }
        localai.npR = locala.CLY.readString();
        AppMethodBeat.o(111575);
        return 0;
      }
      AppMethodBeat.o(111575);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ai
 * JD-Core Version:    0.7.0.1
 */