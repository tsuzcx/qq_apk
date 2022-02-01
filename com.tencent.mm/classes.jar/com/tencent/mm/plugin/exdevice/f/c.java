package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bw.a
{
  public String rBK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23487);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rBK != null) {
        paramVarArgs.e(1, this.rBK);
      }
      AppMethodBeat.o(23487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rBK == null) {
        break label220;
      }
    }
    label220:
    for (paramInt = g.a.a.b.b.a.f(1, this.rBK) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(23487);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        localc.rBK = locala.UbS.readString();
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