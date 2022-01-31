package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class ad
  extends com.tencent.mm.bv.a
{
  public int jKA;
  public int jKC;
  public String jKw;
  public int jKx;
  public int jKz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(18079);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jKw == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataID");
        AppMethodBeat.o(18079);
        throw paramVarArgs;
      }
      if (this.jKw != null) {
        paramVarArgs.e(1, this.jKw);
      }
      paramVarArgs.aO(2, this.jKx);
      paramVarArgs.aO(3, this.jKz);
      paramVarArgs.aO(4, this.jKA);
      paramVarArgs.aO(5, this.jKC);
      AppMethodBeat.o(18079);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jKw == null) {
        break label457;
      }
    }
    label457:
    for (paramInt = e.a.a.b.b.a.f(1, this.jKw) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.jKx);
      int j = e.a.a.b.b.a.bl(3, this.jKz);
      int k = e.a.a.b.b.a.bl(4, this.jKA);
      int m = e.a.a.b.b.a.bl(5, this.jKC);
      AppMethodBeat.o(18079);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.jKw == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataID");
          AppMethodBeat.o(18079);
          throw paramVarArgs;
        }
        AppMethodBeat.o(18079);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(18079);
          return -1;
        case 1: 
          localad.jKw = locala.CLY.readString();
          AppMethodBeat.o(18079);
          return 0;
        case 2: 
          localad.jKx = locala.CLY.sl();
          AppMethodBeat.o(18079);
          return 0;
        case 3: 
          localad.jKz = locala.CLY.sl();
          AppMethodBeat.o(18079);
          return 0;
        case 4: 
          localad.jKA = locala.CLY.sl();
          AppMethodBeat.o(18079);
          return 0;
        }
        localad.jKC = locala.CLY.sl();
        AppMethodBeat.o(18079);
        return 0;
      }
      AppMethodBeat.o(18079);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ad
 * JD-Core Version:    0.7.0.1
 */