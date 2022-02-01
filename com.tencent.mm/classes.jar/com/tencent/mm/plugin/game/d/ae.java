package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ae
  extends com.tencent.mm.bw.a
{
  public String nIJ;
  public String urL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41725);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(41725);
        throw paramVarArgs;
      }
      if (this.urL == null)
      {
        paramVarArgs = new b("Not all required fields were included: Detail");
        AppMethodBeat.o(41725);
        throw paramVarArgs;
      }
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      if (this.urL != null) {
        paramVarArgs.d(2, this.urL);
      }
      AppMethodBeat.o(41725);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.nIJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.urL != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.urL);
      }
      AppMethodBeat.o(41725);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.nIJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(41725);
          throw paramVarArgs;
        }
        if (this.urL == null)
        {
          paramVarArgs = new b("Not all required fields were included: Detail");
          AppMethodBeat.o(41725);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41725);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41725);
          return -1;
        case 1: 
          localae.nIJ = locala.OmT.readString();
          AppMethodBeat.o(41725);
          return 0;
        }
        localae.urL = locala.OmT.readString();
        AppMethodBeat.o(41725);
        return 0;
      }
      AppMethodBeat.o(41725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ae
 * JD-Core Version:    0.7.0.1
 */