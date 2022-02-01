package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cw
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public String CQM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41808);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(41808);
        throw paramVarArgs;
      }
      if (this.CQM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Color");
        AppMethodBeat.o(41808);
        throw paramVarArgs;
      }
      if (this.CMP != null) {
        paramVarArgs.f(1, this.CMP);
      }
      if (this.CQM != null) {
        paramVarArgs.f(2, this.CQM);
      }
      AppMethodBeat.o(41808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMP == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = g.a.a.b.b.a.g(1, this.CMP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CQM != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CQM);
      }
      AppMethodBeat.o(41808);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CMP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(41808);
          throw paramVarArgs;
        }
        if (this.CQM == null)
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
        cw localcw = (cw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41808);
          return -1;
        case 1: 
          localcw.CMP = locala.abFh.readString();
          AppMethodBeat.o(41808);
          return 0;
        }
        localcw.CQM = locala.abFh.readString();
        AppMethodBeat.o(41808);
        return 0;
      }
      AppMethodBeat.o(41808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cw
 * JD-Core Version:    0.7.0.1
 */