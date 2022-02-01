package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class as
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String uqf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41740);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Desc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(41740);
        throw paramVarArgs;
      }
      if (this.Desc != null) {
        paramVarArgs.d(1, this.Desc);
      }
      if (this.uqf != null) {
        paramVarArgs.d(2, this.uqf);
      }
      AppMethodBeat.o(41740);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Desc == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(1, this.Desc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uqf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uqf);
      }
      AppMethodBeat.o(41740);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Desc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(41740);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41740);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        as localas = (as)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41740);
          return -1;
        case 1: 
          localas.Desc = locala.OmT.readString();
          AppMethodBeat.o(41740);
          return 0;
        }
        localas.uqf = locala.OmT.readString();
        AppMethodBeat.o(41740);
        return 0;
      }
      AppMethodBeat.o(41740);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.as
 * JD-Core Version:    0.7.0.1
 */