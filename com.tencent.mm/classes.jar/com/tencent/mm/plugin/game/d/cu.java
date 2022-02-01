package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cu
  extends com.tencent.mm.bx.a
{
  public String sag;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149417);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sag == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(149417);
        throw paramVarArgs;
      }
      if (this.sag != null) {
        paramVarArgs.d(1, this.sag);
      }
      AppMethodBeat.o(149417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sag == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = f.a.a.b.b.a.e(1, this.sag) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(149417);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.sag == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgId");
          AppMethodBeat.o(149417);
          throw paramVarArgs;
        }
        AppMethodBeat.o(149417);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cu localcu = (cu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149417);
          return -1;
        }
        localcu.sag = locala.KhF.readString();
        AppMethodBeat.o(149417);
        return 0;
      }
      AppMethodBeat.o(149417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cu
 * JD-Core Version:    0.7.0.1
 */