package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ee
  extends com.tencent.mm.bw.a
{
  public String uqe;
  public String uqf;
  public String ura;
  public int uvE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41838);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uqe != null) {
        paramVarArgs.d(1, this.uqe);
      }
      if (this.uqf != null) {
        paramVarArgs.d(2, this.uqf);
      }
      paramVarArgs.aS(3, this.uvE);
      if (this.ura != null) {
        paramVarArgs.d(4, this.ura);
      }
      AppMethodBeat.o(41838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uqe == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.uqe) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uqf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uqf);
      }
      i += f.a.a.b.b.a.bz(3, this.uvE);
      paramInt = i;
      if (this.ura != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ura);
      }
      AppMethodBeat.o(41838);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41838);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ee localee = (ee)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41838);
          return -1;
        case 1: 
          localee.uqe = locala.OmT.readString();
          AppMethodBeat.o(41838);
          return 0;
        case 2: 
          localee.uqf = locala.OmT.readString();
          AppMethodBeat.o(41838);
          return 0;
        case 3: 
          localee.uvE = locala.OmT.zc();
          AppMethodBeat.o(41838);
          return 0;
        }
        localee.ura = locala.OmT.readString();
        AppMethodBeat.o(41838);
        return 0;
      }
      AppMethodBeat.o(41838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ee
 * JD-Core Version:    0.7.0.1
 */