package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
  extends com.tencent.mm.bw.a
{
  public String rBI;
  public String xJH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256629);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rBI != null) {
        paramVarArgs.e(1, this.rBI);
      }
      if (this.xJH != null) {
        paramVarArgs.e(2, this.xJH);
      }
      AppMethodBeat.o(256629);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rBI == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.rBI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xJH != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xJH);
      }
      AppMethodBeat.o(256629);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(256629);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        u localu = (u)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(256629);
          return -1;
        case 1: 
          localu.rBI = locala.UbS.readString();
          AppMethodBeat.o(256629);
          return 0;
        }
        localu.xJH = locala.UbS.readString();
        AppMethodBeat.o(256629);
        return 0;
      }
      AppMethodBeat.o(256629);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.u
 * JD-Core Version:    0.7.0.1
 */