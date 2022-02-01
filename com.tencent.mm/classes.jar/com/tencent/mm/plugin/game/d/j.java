package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class j
  extends com.tencent.mm.bw.a
{
  public String uqP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149408);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uqP == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppStoreUrl");
        AppMethodBeat.o(149408);
        throw paramVarArgs;
      }
      if (this.uqP != null) {
        paramVarArgs.d(1, this.uqP);
      }
      AppMethodBeat.o(149408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uqP == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = f.a.a.b.b.a.e(1, this.uqP) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(149408);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.uqP == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppStoreUrl");
          AppMethodBeat.o(149408);
          throw paramVarArgs;
        }
        AppMethodBeat.o(149408);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149408);
          return -1;
        }
        localj.uqP = locala.OmT.readString();
        AppMethodBeat.o(149408);
        return 0;
      }
      AppMethodBeat.o(149408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.j
 * JD-Core Version:    0.7.0.1
 */