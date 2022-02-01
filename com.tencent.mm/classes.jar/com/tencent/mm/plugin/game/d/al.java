package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class al
  extends com.tencent.mm.bw.a
{
  public String urV;
  public String urW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41731);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.urV != null) {
        paramVarArgs.d(1, this.urV);
      }
      if (this.urW != null) {
        paramVarArgs.d(2, this.urW);
      }
      AppMethodBeat.o(41731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.urV == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.urV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.urW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.urW);
      }
      AppMethodBeat.o(41731);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41731);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        al localal = (al)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41731);
          return -1;
        case 1: 
          localal.urV = locala.OmT.readString();
          AppMethodBeat.o(41731);
          return 0;
        }
        localal.urW = locala.OmT.readString();
        AppMethodBeat.o(41731);
        return 0;
      }
      AppMethodBeat.o(41731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.al
 * JD-Core Version:    0.7.0.1
 */