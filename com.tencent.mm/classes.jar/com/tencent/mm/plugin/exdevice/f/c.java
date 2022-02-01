package com.tencent.mm.plugin.exdevice.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bw.a
{
  public String pAF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23487);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pAF != null) {
        paramVarArgs.d(1, this.pAF);
      }
      AppMethodBeat.o(23487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pAF == null) {
        break label220;
      }
    }
    label220:
    for (paramInt = f.a.a.b.b.a.e(1, this.pAF) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(23487);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(23487);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(23487);
          return -1;
        }
        localc.pAF = locala.LVo.readString();
        AppMethodBeat.o(23487);
        return 0;
      }
      AppMethodBeat.o(23487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.c
 * JD-Core Version:    0.7.0.1
 */