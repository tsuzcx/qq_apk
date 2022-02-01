package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cy
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String CMD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41811);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMB == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(41811);
        throw paramVarArgs;
      }
      if (this.CMB != null) {
        paramVarArgs.f(1, this.CMB);
      }
      if (this.CMD != null) {
        paramVarArgs.f(2, this.CMD);
      }
      AppMethodBeat.o(41811);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMB == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = g.a.a.b.b.a.g(1, this.CMB) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CMD != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CMD);
      }
      AppMethodBeat.o(41811);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CMB == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(41811);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41811);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cy localcy = (cy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41811);
          return -1;
        case 1: 
          localcy.CMB = locala.abFh.readString();
          AppMethodBeat.o(41811);
          return 0;
        }
        localcy.CMD = locala.abFh.readString();
        AppMethodBeat.o(41811);
        return 0;
      }
      AppMethodBeat.o(41811);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cy
 * JD-Core Version:    0.7.0.1
 */