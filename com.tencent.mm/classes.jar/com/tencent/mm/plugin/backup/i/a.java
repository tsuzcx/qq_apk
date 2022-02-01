package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class a
  extends com.tencent.mm.cd.a
{
  public String ID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22101);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22101);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.f(1, this.ID);
      }
      AppMethodBeat.o(22101);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label268;
      }
    }
    label268:
    for (paramInt = g.a.a.b.b.a.g(1, this.ID) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(22101);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22101);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22101);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        a locala1 = (a)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22101);
          return -1;
        }
        locala1.ID = locala.abFh.readString();
        AppMethodBeat.o(22101);
        return 0;
      }
      AppMethodBeat.o(22101);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.a
 * JD-Core Version:    0.7.0.1
 */