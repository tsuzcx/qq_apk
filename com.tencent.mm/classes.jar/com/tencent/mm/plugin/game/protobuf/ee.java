package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ee
  extends com.tencent.mm.bw.a
{
  public String xIx;
  public String xIy;
  public String xJt;
  public int xNF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41838);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xIx != null) {
        paramVarArgs.e(1, this.xIx);
      }
      if (this.xIy != null) {
        paramVarArgs.e(2, this.xIy);
      }
      paramVarArgs.aM(3, this.xNF);
      if (this.xJt != null) {
        paramVarArgs.e(4, this.xJt);
      }
      AppMethodBeat.o(41838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xIx == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.f(1, this.xIx) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xIy != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xIy);
      }
      i += g.a.a.b.b.a.bu(3, this.xNF);
      paramInt = i;
      if (this.xJt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.xJt);
      }
      AppMethodBeat.o(41838);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(41838);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ee localee = (ee)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41838);
          return -1;
        case 1: 
          localee.xIx = locala.UbS.readString();
          AppMethodBeat.o(41838);
          return 0;
        case 2: 
          localee.xIy = locala.UbS.readString();
          AppMethodBeat.o(41838);
          return 0;
        case 3: 
          localee.xNF = locala.UbS.zi();
          AppMethodBeat.o(41838);
          return 0;
        }
        localee.xJt = locala.UbS.readString();
        AppMethodBeat.o(41838);
        return 0;
      }
      AppMethodBeat.o(41838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ee
 * JD-Core Version:    0.7.0.1
 */