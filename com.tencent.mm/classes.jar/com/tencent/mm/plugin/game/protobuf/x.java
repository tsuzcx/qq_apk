package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
  extends com.tencent.mm.bx.a
{
  public String IIa;
  public String IIb;
  public String IIc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41720);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.IIa != null) {
        paramVarArgs.g(1, this.IIa);
      }
      if (this.IIb != null) {
        paramVarArgs.g(2, this.IIb);
      }
      if (this.IIc != null) {
        paramVarArgs.g(3, this.IIc);
      }
      AppMethodBeat.o(41720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IIa == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.IIa) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IIb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IIb);
      }
      i = paramInt;
      if (this.IIc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IIc);
      }
      AppMethodBeat.o(41720);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41720);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41720);
          return -1;
        case 1: 
          localx.IIa = locala.ajGk.readString();
          AppMethodBeat.o(41720);
          return 0;
        case 2: 
          localx.IIb = locala.ajGk.readString();
          AppMethodBeat.o(41720);
          return 0;
        }
        localx.IIc = locala.ajGk.readString();
        AppMethodBeat.o(41720);
        return 0;
      }
      AppMethodBeat.o(41720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.x
 * JD-Core Version:    0.7.0.1
 */