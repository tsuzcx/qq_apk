package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cu
  extends com.tencent.mm.bw.a
{
  public String jfi;
  public int xMC;
  public String xut;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256644);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jfi == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(256644);
        throw paramVarArgs;
      }
      if (this.jfi != null) {
        paramVarArgs.e(1, this.jfi);
      }
      if (this.xut != null) {
        paramVarArgs.e(2, this.xut);
      }
      paramVarArgs.aM(3, this.xMC);
      AppMethodBeat.o(256644);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jfi == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.f(1, this.jfi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xut != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xut);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.xMC);
      AppMethodBeat.o(256644);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.jfi == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(256644);
          throw paramVarArgs;
        }
        AppMethodBeat.o(256644);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cu localcu = (cu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(256644);
          return -1;
        case 1: 
          localcu.jfi = locala.UbS.readString();
          AppMethodBeat.o(256644);
          return 0;
        case 2: 
          localcu.xut = locala.UbS.readString();
          AppMethodBeat.o(256644);
          return 0;
        }
        localcu.xMC = locala.UbS.zi();
        AppMethodBeat.o(256644);
        return 0;
      }
      AppMethodBeat.o(256644);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cu
 * JD-Core Version:    0.7.0.1
 */