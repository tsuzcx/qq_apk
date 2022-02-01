package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cv
  extends com.tencent.mm.bw.a
{
  public String Name;
  public String xMD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41808);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Name == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41808);
        throw paramVarArgs;
      }
      if (this.xMD == null)
      {
        paramVarArgs = new b("Not all required fields were included: Color");
        AppMethodBeat.o(41808);
        throw paramVarArgs;
      }
      if (this.Name != null) {
        paramVarArgs.e(1, this.Name);
      }
      if (this.xMD != null) {
        paramVarArgs.e(2, this.xMD);
      }
      AppMethodBeat.o(41808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.f(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xMD != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.xMD);
      }
      AppMethodBeat.o(41808);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Name == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(41808);
          throw paramVarArgs;
        }
        if (this.xMD == null)
        {
          paramVarArgs = new b("Not all required fields were included: Color");
          AppMethodBeat.o(41808);
          throw paramVarArgs;
        }
        AppMethodBeat.o(41808);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cv localcv = (cv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41808);
          return -1;
        case 1: 
          localcv.Name = locala.UbS.readString();
          AppMethodBeat.o(41808);
          return 0;
        }
        localcv.xMD = locala.UbS.readString();
        AppMethodBeat.o(41808);
        return 0;
      }
      AppMethodBeat.o(41808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cv
 * JD-Core Version:    0.7.0.1
 */