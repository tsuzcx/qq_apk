package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bw.a
{
  public String desc;
  public String ucS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40866);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.desc != null) {
        paramVarArgs.d(1, this.desc);
      }
      if (this.ucS != null) {
        paramVarArgs.d(2, this.ucS);
      }
      AppMethodBeat.o(40866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.desc == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.desc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ucS != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ucS);
      }
      AppMethodBeat.o(40866);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(40866);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(40866);
          return -1;
        case 1: 
          localc.desc = locala.OmT.readString();
          AppMethodBeat.o(40866);
          return 0;
        }
        localc.ucS = locala.OmT.readString();
        AppMethodBeat.o(40866);
        return 0;
      }
      AppMethodBeat.o(40866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.c
 * JD-Core Version:    0.7.0.1
 */