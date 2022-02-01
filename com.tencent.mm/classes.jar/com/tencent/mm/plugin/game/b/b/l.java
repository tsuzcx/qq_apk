package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public String qHk;
  public int width;
  public String xve;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40879);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.qHk != null) {
        paramVarArgs.e(1, this.qHk);
      }
      if (this.xve != null) {
        paramVarArgs.e(2, this.xve);
      }
      paramVarArgs.aM(3, this.width);
      AppMethodBeat.o(40879);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qHk == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.qHk) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xve != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xve);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.width);
      AppMethodBeat.o(40879);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(40879);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(40879);
          return -1;
        case 1: 
          locall.qHk = locala.UbS.readString();
          AppMethodBeat.o(40879);
          return 0;
        case 2: 
          locall.xve = locala.UbS.readString();
          AppMethodBeat.o(40879);
          return 0;
        }
        locall.width = locala.UbS.zi();
        AppMethodBeat.o(40879);
        return 0;
      }
      AppMethodBeat.o(40879);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.l
 * JD-Core Version:    0.7.0.1
 */