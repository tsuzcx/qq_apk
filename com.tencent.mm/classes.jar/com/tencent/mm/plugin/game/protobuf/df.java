package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class df
  extends com.tencent.mm.cd.a
{
  public String CMD;
  public String CNj;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41818);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CNj != null) {
        paramVarArgs.f(1, this.CNj);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      if (this.CMD != null) {
        paramVarArgs.f(3, this.CMD);
      }
      AppMethodBeat.o(41818);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CNj == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.CNj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = paramInt;
      if (this.CMD != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.CMD);
      }
      AppMethodBeat.o(41818);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(41818);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        df localdf = (df)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41818);
          return -1;
        case 1: 
          localdf.CNj = locala.abFh.readString();
          AppMethodBeat.o(41818);
          return 0;
        case 2: 
          localdf.fwr = locala.abFh.readString();
          AppMethodBeat.o(41818);
          return 0;
        }
        localdf.CMD = locala.abFh.readString();
        AppMethodBeat.o(41818);
        return 0;
      }
      AppMethodBeat.o(41818);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.df
 * JD-Core Version:    0.7.0.1
 */