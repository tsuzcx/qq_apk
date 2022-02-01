package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cv
  extends com.tencent.mm.cd.a
{
  public int CQL;
  public String CqK;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207057);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lVG == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(207057);
        throw paramVarArgs;
      }
      if (this.lVG != null) {
        paramVarArgs.f(1, this.lVG);
      }
      if (this.CqK != null) {
        paramVarArgs.f(2, this.CqK);
      }
      paramVarArgs.aY(3, this.CQL);
      AppMethodBeat.o(207057);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lVG == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.g(1, this.lVG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CqK != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CqK);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.CQL);
      AppMethodBeat.o(207057);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.lVG == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(207057);
          throw paramVarArgs;
        }
        AppMethodBeat.o(207057);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cv localcv = (cv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207057);
          return -1;
        case 1: 
          localcv.lVG = locala.abFh.readString();
          AppMethodBeat.o(207057);
          return 0;
        case 2: 
          localcv.CqK = locala.abFh.readString();
          AppMethodBeat.o(207057);
          return 0;
        }
        localcv.CQL = locala.abFh.AK();
        AppMethodBeat.o(207057);
        return 0;
      }
      AppMethodBeat.o(207057);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.cv
 * JD-Core Version:    0.7.0.1
 */