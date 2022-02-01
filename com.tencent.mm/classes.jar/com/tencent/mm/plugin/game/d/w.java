package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class w
  extends com.tencent.mm.bw.a
{
  public String tiu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41723);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tiu != null) {
        paramVarArgs.d(1, this.tiu);
      }
      AppMethodBeat.o(41723);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tiu == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.tiu) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(41723);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41723);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        w localw = (w)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41723);
          return -1;
        }
        localw.tiu = locala.LVo.readString();
        AppMethodBeat.o(41723);
        return 0;
      }
      AppMethodBeat.o(41723);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.w
 * JD-Core Version:    0.7.0.1
 */