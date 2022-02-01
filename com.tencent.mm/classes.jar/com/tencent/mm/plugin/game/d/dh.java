package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dh
  extends com.tencent.mm.bx.a
{
  public String rZW;
  public String rZn;
  public String rZo;
  public int sdO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41838);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rZn != null) {
        paramVarArgs.d(1, this.rZn);
      }
      if (this.rZo != null) {
        paramVarArgs.d(2, this.rZo);
      }
      paramVarArgs.aR(3, this.sdO);
      if (this.rZW != null) {
        paramVarArgs.d(4, this.rZW);
      }
      AppMethodBeat.o(41838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rZn == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.rZn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rZo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.rZo);
      }
      i += f.a.a.b.b.a.bA(3, this.sdO);
      paramInt = i;
      if (this.rZW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.rZW);
      }
      AppMethodBeat.o(41838);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(41838);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dh localdh = (dh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41838);
          return -1;
        case 1: 
          localdh.rZn = locala.KhF.readString();
          AppMethodBeat.o(41838);
          return 0;
        case 2: 
          localdh.rZo = locala.KhF.readString();
          AppMethodBeat.o(41838);
          return 0;
        case 3: 
          localdh.sdO = locala.KhF.xS();
          AppMethodBeat.o(41838);
          return 0;
        }
        localdh.rZW = locala.KhF.readString();
        AppMethodBeat.o(41838);
        return 0;
      }
      AppMethodBeat.o(41838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dh
 * JD-Core Version:    0.7.0.1
 */