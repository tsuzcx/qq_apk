package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ej
  extends com.tencent.mm.bw.a
{
  public String xNH;
  public String xNI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41844);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xNH == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(41844);
        throw paramVarArgs;
      }
      if (this.xNI == null)
      {
        paramVarArgs = new b("Not all required fields were included: TimeDesc");
        AppMethodBeat.o(41844);
        throw paramVarArgs;
      }
      if (this.xNH != null) {
        paramVarArgs.e(1, this.xNH);
      }
      if (this.xNI != null) {
        paramVarArgs.e(2, this.xNI);
      }
      AppMethodBeat.o(41844);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xNH == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.f(1, this.xNH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xNI != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xNI);
      }
      AppMethodBeat.o(41844);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.xNH == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(41844);
          throw paramVarArgs;
        }
        if (this.xNI == null)
        {
          paramVarArgs = new b("Not all required fields were included: TimeDesc");
          AppMethodBeat.o(41844);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41844);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ej localej = (ej)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41844);
          return -1;
        case 1: 
          localej.xNH = locala.UbS.readString();
          AppMethodBeat.o(41844);
          return 0;
        }
        localej.xNI = locala.UbS.readString();
        AppMethodBeat.o(41844);
        return 0;
      }
      AppMethodBeat.o(41844);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ej
 * JD-Core Version:    0.7.0.1
 */