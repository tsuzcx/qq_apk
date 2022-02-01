package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cm
  extends com.tencent.mm.bx.a
{
  public String rZr;
  public String sdl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41815);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sdl != null) {
        paramVarArgs.d(1, this.sdl);
      }
      if (this.rZr != null) {
        paramVarArgs.d(2, this.rZr);
      }
      AppMethodBeat.o(41815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sdl == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.sdl) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rZr != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.rZr);
      }
      AppMethodBeat.o(41815);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41815);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cm localcm = (cm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41815);
          return -1;
        case 1: 
          localcm.sdl = locala.KhF.readString();
          AppMethodBeat.o(41815);
          return 0;
        }
        localcm.rZr = locala.KhF.readString();
        AppMethodBeat.o(41815);
        return 0;
      }
      AppMethodBeat.o(41815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cm
 * JD-Core Version:    0.7.0.1
 */