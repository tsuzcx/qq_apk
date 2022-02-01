package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class av
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String IGI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41740);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(41740);
        throw paramVarArgs;
      }
      if (this.IGG != null) {
        paramVarArgs.g(1, this.IGG);
      }
      if (this.IGI != null) {
        paramVarArgs.g(2, this.IGI);
      }
      AppMethodBeat.o(41740);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGG == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = i.a.a.b.b.a.h(1, this.IGG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IGI != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IGI);
      }
      AppMethodBeat.o(41740);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IGG == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        av localav = (av)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41740);
          return -1;
        case 1: 
          localav.IGG = locala.ajGk.readString();
          AppMethodBeat.o(41740);
          return 0;
        }
        localav.IGI = locala.ajGk.readString();
        AppMethodBeat.o(41740);
        return 0;
      }
      AppMethodBeat.o(41740);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.av
 * JD-Core Version:    0.7.0.1
 */