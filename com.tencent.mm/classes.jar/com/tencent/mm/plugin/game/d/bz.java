package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bz
  extends com.tencent.mm.bw.a
{
  public String desc;
  public String drM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41798);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.drM != null) {
        paramVarArgs.d(1, this.drM);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      AppMethodBeat.o(41798);
      return 0;
    }
    if (paramInt == 1) {
      if (this.drM == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.drM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.desc);
      }
      AppMethodBeat.o(41798);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41798);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bz localbz = (bz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41798);
          return -1;
        case 1: 
          localbz.drM = locala.LVo.readString();
          AppMethodBeat.o(41798);
          return 0;
        }
        localbz.desc = locala.LVo.readString();
        AppMethodBeat.o(41798);
        return 0;
      }
      AppMethodBeat.o(41798);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bz
 * JD-Core Version:    0.7.0.1
 */