package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cu
  extends com.tencent.mm.bw.a
{
  public String ikm;
  public String uuA;
  public int uuB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221893);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ikm == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(221893);
        throw paramVarArgs;
      }
      if (this.ikm != null) {
        paramVarArgs.d(1, this.ikm);
      }
      if (this.uuA != null) {
        paramVarArgs.d(2, this.uuA);
      }
      paramVarArgs.aS(3, this.uuB);
      AppMethodBeat.o(221893);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ikm == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.ikm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uuA != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uuA);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.uuB);
      AppMethodBeat.o(221893);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.ikm == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(221893);
          throw paramVarArgs;
        }
        AppMethodBeat.o(221893);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cu localcu = (cu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(221893);
          return -1;
        case 1: 
          localcu.ikm = locala.OmT.readString();
          AppMethodBeat.o(221893);
          return 0;
        case 2: 
          localcu.uuA = locala.OmT.readString();
          AppMethodBeat.o(221893);
          return 0;
        }
        localcu.uuB = locala.OmT.zc();
        AppMethodBeat.o(221893);
        return 0;
      }
      AppMethodBeat.o(221893);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cu
 * JD-Core Version:    0.7.0.1
 */