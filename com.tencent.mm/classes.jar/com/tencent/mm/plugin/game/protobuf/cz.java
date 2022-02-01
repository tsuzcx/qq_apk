package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class cz
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public String ILa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41808);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IGU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41808);
        throw paramVarArgs;
      }
      if (this.ILa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Color");
        AppMethodBeat.o(41808);
        throw paramVarArgs;
      }
      if (this.IGU != null) {
        paramVarArgs.g(1, this.IGU);
      }
      if (this.ILa != null) {
        paramVarArgs.g(2, this.ILa);
      }
      AppMethodBeat.o(41808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGU == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = i.a.a.b.b.a.h(1, this.IGU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ILa != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ILa);
      }
      AppMethodBeat.o(41808);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.IGU == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(41808);
          throw paramVarArgs;
        }
        if (this.ILa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Color");
          AppMethodBeat.o(41808);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41808);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cz localcz = (cz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41808);
          return -1;
        case 1: 
          localcz.IGU = locala.ajGk.readString();
          AppMethodBeat.o(41808);
          return 0;
        }
        localcz.ILa = locala.ajGk.readString();
        AppMethodBeat.o(41808);
        return 0;
      }
      AppMethodBeat.o(41808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cz
 * JD-Core Version:    0.7.0.1
 */