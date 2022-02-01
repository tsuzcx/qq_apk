package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bx.a
{
  public String Idg;
  public String desc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40866);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.desc != null) {
        paramVarArgs.g(1, this.desc);
      }
      if (this.Idg != null) {
        paramVarArgs.g(2, this.Idg);
      }
      AppMethodBeat.o(40866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.desc == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.desc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Idg != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Idg);
      }
      AppMethodBeat.o(40866);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(40866);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(40866);
          return -1;
        case 1: 
          localc.desc = locala.ajGk.readString();
          AppMethodBeat.o(40866);
          return 0;
        }
        localc.Idg = locala.ajGk.readString();
        AppMethodBeat.o(40866);
        return 0;
      }
      AppMethodBeat.o(40866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.c
 * JD-Core Version:    0.7.0.1
 */