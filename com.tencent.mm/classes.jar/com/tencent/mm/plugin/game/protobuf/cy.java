package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class cy
  extends com.tencent.mm.bx.a
{
  public int IKZ;
  public String IcT;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(276911);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oOI == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(276911);
        throw paramVarArgs;
      }
      if (this.oOI != null) {
        paramVarArgs.g(1, this.oOI);
      }
      if (this.IcT != null) {
        paramVarArgs.g(2, this.IcT);
      }
      paramVarArgs.bS(3, this.IKZ);
      AppMethodBeat.o(276911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oOI == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = i.a.a.b.b.a.h(1, this.oOI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IcT != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IcT);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.IKZ);
      AppMethodBeat.o(276911);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.oOI == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(276911);
          throw paramVarArgs;
        }
        AppMethodBeat.o(276911);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cy localcy = (cy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(276911);
          return -1;
        case 1: 
          localcy.oOI = locala.ajGk.readString();
          AppMethodBeat.o(276911);
          return 0;
        case 2: 
          localcy.IcT = locala.ajGk.readString();
          AppMethodBeat.o(276911);
          return 0;
        }
        localcy.IKZ = locala.ajGk.aar();
        AppMethodBeat.o(276911);
        return 0;
      }
      AppMethodBeat.o(276911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cy
 * JD-Core Version:    0.7.0.1
 */