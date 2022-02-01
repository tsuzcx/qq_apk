package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ea
  extends com.tencent.mm.bw.a
{
  public String ikm;
  public String uuA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221900);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ikm == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(221900);
        throw paramVarArgs;
      }
      if (this.ikm != null) {
        paramVarArgs.d(1, this.ikm);
      }
      if (this.uuA != null) {
        paramVarArgs.d(2, this.uuA);
      }
      AppMethodBeat.o(221900);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ikm == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(1, this.ikm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uuA != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uuA);
      }
      AppMethodBeat.o(221900);
      return i;
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
          AppMethodBeat.o(221900);
          throw paramVarArgs;
        }
        AppMethodBeat.o(221900);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ea localea = (ea)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(221900);
          return -1;
        case 1: 
          localea.ikm = locala.OmT.readString();
          AppMethodBeat.o(221900);
          return 0;
        }
        localea.uuA = locala.OmT.readString();
        AppMethodBeat.o(221900);
        return 0;
      }
      AppMethodBeat.o(221900);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ea
 * JD-Core Version:    0.7.0.1
 */