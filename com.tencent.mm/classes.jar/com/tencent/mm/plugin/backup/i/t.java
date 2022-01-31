package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class t
  extends com.tencent.mm.bv.a
{
  public String ID;
  public int jKn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18068);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(18068);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.e(1, this.ID);
      }
      paramVarArgs.aO(2, this.jKn);
      AppMethodBeat.o(18068);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.ID) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.jKn);
      AppMethodBeat.o(18068);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(18068);
          throw paramVarArgs;
        }
        AppMethodBeat.o(18068);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(18068);
          return -1;
        case 1: 
          localt.ID = locala.CLY.readString();
          AppMethodBeat.o(18068);
          return 0;
        }
        localt.jKn = locala.CLY.sl();
        AppMethodBeat.o(18068);
        return 0;
      }
      AppMethodBeat.o(18068);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.t
 * JD-Core Version:    0.7.0.1
 */