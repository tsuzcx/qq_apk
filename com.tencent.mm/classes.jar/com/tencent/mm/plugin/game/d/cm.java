package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cm
  extends com.tencent.mm.bw.a
{
  public String dEM;
  public String desc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41798);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dEM != null) {
        paramVarArgs.d(1, this.dEM);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      AppMethodBeat.o(41798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dEM == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.dEM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.desc);
      }
      AppMethodBeat.o(41798);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41798);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cm localcm = (cm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41798);
          return -1;
        case 1: 
          localcm.dEM = locala.OmT.readString();
          AppMethodBeat.o(41798);
          return 0;
        }
        localcm.desc = locala.OmT.readString();
        AppMethodBeat.o(41798);
        return 0;
      }
      AppMethodBeat.o(41798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cm
 * JD-Core Version:    0.7.0.1
 */