package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bx.a
{
  public String odX;
  public String rOf;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40879);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.odX != null) {
        paramVarArgs.d(1, this.odX);
      }
      if (this.rOf != null) {
        paramVarArgs.d(2, this.rOf);
      }
      paramVarArgs.aR(3, this.width);
      AppMethodBeat.o(40879);
      return 0;
    }
    if (paramInt == 1) {
      if (this.odX == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.odX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rOf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.rOf);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.width);
      AppMethodBeat.o(40879);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(40879);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(40879);
          return -1;
        case 1: 
          locall.odX = locala.KhF.readString();
          AppMethodBeat.o(40879);
          return 0;
        case 2: 
          locall.rOf = locala.KhF.readString();
          AppMethodBeat.o(40879);
          return 0;
        }
        locall.width = locala.KhF.xS();
        AppMethodBeat.o(40879);
        return 0;
      }
      AppMethodBeat.o(40879);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.l
 * JD-Core Version:    0.7.0.1
 */