package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class t
  extends com.tencent.mm.bw.a
{
  public String ID;
  public int oUq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22125);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22125);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.e(1, this.ID);
      }
      paramVarArgs.aM(2, this.oUq);
      AppMethodBeat.o(22125);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.ID) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.oUq);
      AppMethodBeat.o(22125);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22125);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22125);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22125);
          return -1;
        case 1: 
          localt.ID = locala.UbS.readString();
          AppMethodBeat.o(22125);
          return 0;
        }
        localt.oUq = locala.UbS.zi();
        AppMethodBeat.o(22125);
        return 0;
      }
      AppMethodBeat.o(22125);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.t
 * JD-Core Version:    0.7.0.1
 */