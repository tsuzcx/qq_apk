package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bw.a
{
  public int qGD;
  public String xuH;
  public String xuI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40867);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xuH != null) {
        paramVarArgs.e(1, this.xuH);
      }
      if (this.xuI != null) {
        paramVarArgs.e(2, this.xuI);
      }
      paramVarArgs.aM(3, this.qGD);
      AppMethodBeat.o(40867);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xuH == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.xuH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xuI != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xuI);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.qGD);
      AppMethodBeat.o(40867);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(40867);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(40867);
          return -1;
        case 1: 
          locald.xuH = locala.UbS.readString();
          AppMethodBeat.o(40867);
          return 0;
        case 2: 
          locald.xuI = locala.UbS.readString();
          AppMethodBeat.o(40867);
          return 0;
        }
        locald.qGD = locala.UbS.zi();
        AppMethodBeat.o(40867);
        return 0;
      }
      AppMethodBeat.o(40867);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.d
 * JD-Core Version:    0.7.0.1
 */