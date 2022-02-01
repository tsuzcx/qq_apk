package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dt
  extends com.tencent.mm.cd.a
{
  public String CMC;
  public String CMD;
  public int CRx;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41834);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.CMD != null) {
        paramVarArgs.f(2, this.CMD);
      }
      if (this.CMC != null) {
        paramVarArgs.f(3, this.CMC);
      }
      paramVarArgs.aY(4, this.CRx);
      AppMethodBeat.o(41834);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMD != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMD);
      }
      i = paramInt;
      if (this.CMC != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMC);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.CRx);
      AppMethodBeat.o(41834);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41834);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dt localdt = (dt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41834);
          return -1;
        case 1: 
          localdt.fwr = locala.abFh.readString();
          AppMethodBeat.o(41834);
          return 0;
        case 2: 
          localdt.CMD = locala.abFh.readString();
          AppMethodBeat.o(41834);
          return 0;
        case 3: 
          localdt.CMC = locala.abFh.readString();
          AppMethodBeat.o(41834);
          return 0;
        }
        localdt.CRx = locala.abFh.AK();
        AppMethodBeat.o(41834);
        return 0;
      }
      AppMethodBeat.o(41834);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.dt
 * JD-Core Version:    0.7.0.1
 */