package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bx.a
{
  public String pla;
  public String tSB;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40879);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.pla != null) {
        paramVarArgs.d(1, this.pla);
      }
      if (this.tSB != null) {
        paramVarArgs.d(2, this.tSB);
      }
      paramVarArgs.aS(3, this.width);
      AppMethodBeat.o(40879);
      return 0;
    }
    if (paramInt == 1) {
      if (this.pla == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.pla) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tSB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.tSB);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.width);
      AppMethodBeat.o(40879);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          locall.pla = locala.NPN.readString();
          AppMethodBeat.o(40879);
          return 0;
        case 2: 
          locall.tSB = locala.NPN.readString();
          AppMethodBeat.o(40879);
          return 0;
        }
        locall.width = locala.NPN.zc();
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