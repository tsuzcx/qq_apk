package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public String prF;
  public String uds;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40879);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.prF != null) {
        paramVarArgs.d(1, this.prF);
      }
      if (this.uds != null) {
        paramVarArgs.d(2, this.uds);
      }
      paramVarArgs.aS(3, this.width);
      AppMethodBeat.o(40879);
      return 0;
    }
    if (paramInt == 1) {
      if (this.prF == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.prF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uds != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uds);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.width);
      AppMethodBeat.o(40879);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          locall.prF = locala.OmT.readString();
          AppMethodBeat.o(40879);
          return 0;
        case 2: 
          locall.uds = locala.OmT.readString();
          AppMethodBeat.o(40879);
          return 0;
        }
        locall.width = locala.OmT.zc();
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