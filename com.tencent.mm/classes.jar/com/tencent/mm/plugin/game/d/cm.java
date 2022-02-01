package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cm
  extends com.tencent.mm.bw.a
{
  public String thk;
  public String tlf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41815);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tlf != null) {
        paramVarArgs.d(1, this.tlf);
      }
      if (this.thk != null) {
        paramVarArgs.d(2, this.thk);
      }
      AppMethodBeat.o(41815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tlf == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.tlf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thk != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.thk);
      }
      AppMethodBeat.o(41815);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41815);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cm localcm = (cm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41815);
          return -1;
        case 1: 
          localcm.tlf = locala.LVo.readString();
          AppMethodBeat.o(41815);
          return 0;
        }
        localcm.thk = locala.LVo.readString();
        AppMethodBeat.o(41815);
        return 0;
      }
      AppMethodBeat.o(41815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cm
 * JD-Core Version:    0.7.0.1
 */