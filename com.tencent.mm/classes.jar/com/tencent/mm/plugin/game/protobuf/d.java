package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.cd.a
{
  public String CMH;
  public String CMI;
  public String CMJ;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207157);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lVG != null) {
        paramVarArgs.f(1, this.lVG);
      }
      if (this.CMH != null) {
        paramVarArgs.f(2, this.CMH);
      }
      if (this.CMI != null) {
        paramVarArgs.f(3, this.CMI);
      }
      if (this.CMJ != null) {
        paramVarArgs.f(4, this.CMJ);
      }
      AppMethodBeat.o(207157);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lVG == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.lVG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMH);
      }
      i = paramInt;
      if (this.CMI != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMI);
      }
      paramInt = i;
      if (this.CMJ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CMJ);
      }
      AppMethodBeat.o(207157);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207157);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207157);
          return -1;
        case 1: 
          locald.lVG = locala.abFh.readString();
          AppMethodBeat.o(207157);
          return 0;
        case 2: 
          locald.CMH = locala.abFh.readString();
          AppMethodBeat.o(207157);
          return 0;
        case 3: 
          locald.CMI = locala.abFh.readString();
          AppMethodBeat.o(207157);
          return 0;
        }
        locald.CMJ = locala.abFh.readString();
        AppMethodBeat.o(207157);
        return 0;
      }
      AppMethodBeat.o(207157);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.d
 * JD-Core Version:    0.7.0.1
 */