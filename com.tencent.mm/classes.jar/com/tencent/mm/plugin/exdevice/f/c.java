package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.cd.a
{
  public String vhs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23487);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.vhs != null) {
        paramVarArgs.f(1, this.vhs);
      }
      AppMethodBeat.o(23487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhs == null) {
        break label220;
      }
    }
    label220:
    for (paramInt = g.a.a.b.b.a.g(1, this.vhs) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(23487);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(23487);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(23487);
          return -1;
        }
        localc.vhs = locala.abFh.readString();
        AppMethodBeat.o(23487);
        return 0;
      }
      AppMethodBeat.o(23487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.c
 * JD-Core Version:    0.7.0.1
 */