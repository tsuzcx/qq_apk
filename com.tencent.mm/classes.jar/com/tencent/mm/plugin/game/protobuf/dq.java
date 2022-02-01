package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class dq
  extends com.tencent.mm.bx.a
{
  public String ILw;
  public String ILx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(182780);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ILw == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(182780);
        throw paramVarArgs;
      }
      if (this.ILw != null) {
        paramVarArgs.g(1, this.ILw);
      }
      if (this.ILx != null) {
        paramVarArgs.g(2, this.ILx);
      }
      AppMethodBeat.o(182780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ILw == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = i.a.a.b.b.a.h(1, this.ILw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ILx != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ILx);
      }
      AppMethodBeat.o(182780);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ILw == null)
        {
          paramVarArgs = new b("Not all required fields were included: Key");
          AppMethodBeat.o(182780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(182780);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dq localdq = (dq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(182780);
          return -1;
        case 1: 
          localdq.ILw = locala.ajGk.readString();
          AppMethodBeat.o(182780);
          return 0;
        }
        localdq.ILx = locala.ajGk.readString();
        AppMethodBeat.o(182780);
        return 0;
      }
      AppMethodBeat.o(182780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dq
 * JD-Core Version:    0.7.0.1
 */