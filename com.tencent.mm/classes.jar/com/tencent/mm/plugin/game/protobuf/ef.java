package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ef
  extends com.tencent.mm.cd.a
{
  public String CMC;
  public String CMD;
  public String CNA;
  public int CRP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41838);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CMC != null) {
        paramVarArgs.f(1, this.CMC);
      }
      if (this.CMD != null) {
        paramVarArgs.f(2, this.CMD);
      }
      paramVarArgs.aY(3, this.CRP);
      if (this.CNA != null) {
        paramVarArgs.f(4, this.CNA);
      }
      AppMethodBeat.o(41838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CMC == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = g.a.a.b.b.a.g(1, this.CMC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CMD != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.CMD);
      }
      i += g.a.a.b.b.a.bM(3, this.CRP);
      paramInt = i;
      if (this.CNA != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CNA);
      }
      AppMethodBeat.o(41838);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41838);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ef localef = (ef)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41838);
          return -1;
        case 1: 
          localef.CMC = locala.abFh.readString();
          AppMethodBeat.o(41838);
          return 0;
        case 2: 
          localef.CMD = locala.abFh.readString();
          AppMethodBeat.o(41838);
          return 0;
        case 3: 
          localef.CRP = locala.abFh.AK();
          AppMethodBeat.o(41838);
          return 0;
        }
        localef.CNA = locala.abFh.readString();
        AppMethodBeat.o(41838);
        return 0;
      }
      AppMethodBeat.o(41838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.ef
 * JD-Core Version:    0.7.0.1
 */