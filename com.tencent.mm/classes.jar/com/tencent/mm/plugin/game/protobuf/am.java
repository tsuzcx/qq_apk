package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
  extends com.tencent.mm.bw.a
{
  public String xKn;
  public String xKo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41731);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xKn != null) {
        paramVarArgs.e(1, this.xKn);
      }
      if (this.xKo != null) {
        paramVarArgs.e(2, this.xKo);
      }
      AppMethodBeat.o(41731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xKn == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.xKn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xKo != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xKo);
      }
      AppMethodBeat.o(41731);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41731);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        am localam = (am)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41731);
          return -1;
        case 1: 
          localam.xKn = locala.UbS.readString();
          AppMethodBeat.o(41731);
          return 0;
        }
        localam.xKo = locala.UbS.readString();
        AppMethodBeat.o(41731);
        return 0;
      }
      AppMethodBeat.o(41731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.am
 * JD-Core Version:    0.7.0.1
 */