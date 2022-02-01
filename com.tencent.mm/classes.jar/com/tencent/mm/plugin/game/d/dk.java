package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dk
  extends com.tencent.mm.bw.a
{
  public String uuq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(221894);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uuq != null) {
        paramVarArgs.d(1, this.uuq);
      }
      AppMethodBeat.o(221894);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uuq == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.uuq) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(221894);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(221894);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dk localdk = (dk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(221894);
          return -1;
        }
        localdk.uuq = locala.OmT.readString();
        AppMethodBeat.o(221894);
        return 0;
      }
      AppMethodBeat.o(221894);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dk
 * JD-Core Version:    0.7.0.1
 */