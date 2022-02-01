package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class df
  extends com.tencent.mm.bx.a
{
  public String IGL;
  public String ILk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41815);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ILk != null) {
        paramVarArgs.g(1, this.ILk);
      }
      if (this.IGL != null) {
        paramVarArgs.g(2, this.IGL);
      }
      AppMethodBeat.o(41815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ILk == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.ILk) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IGL != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IGL);
      }
      AppMethodBeat.o(41815);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(41815);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        df localdf = (df)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41815);
          return -1;
        case 1: 
          localdf.ILk = locala.ajGk.readString();
          AppMethodBeat.o(41815);
          return 0;
        }
        localdf.IGL = locala.ajGk.readString();
        AppMethodBeat.o(41815);
        return 0;
      }
      AppMethodBeat.o(41815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.protobuf.df
 * JD-Core Version:    0.7.0.1
 */