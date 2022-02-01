package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ek
  extends com.tencent.mm.bw.a
{
  public String uvI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149419);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uvI != null) {
        paramVarArgs.d(1, this.uvI);
      }
      AppMethodBeat.o(149419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uvI == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.uvI) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(149419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(149419);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ek localek = (ek)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149419);
          return -1;
        }
        localek.uvI = locala.OmT.readString();
        AppMethodBeat.o(149419);
        return 0;
      }
      AppMethodBeat.o(149419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ek
 * JD-Core Version:    0.7.0.1
 */