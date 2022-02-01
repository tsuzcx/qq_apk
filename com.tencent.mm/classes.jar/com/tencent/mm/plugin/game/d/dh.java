package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dh
  extends com.tencent.mm.bw.a
{
  public String thP;
  public String thg;
  public String thh;
  public int tlI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41838);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.thg != null) {
        paramVarArgs.d(1, this.thg);
      }
      if (this.thh != null) {
        paramVarArgs.d(2, this.thh);
      }
      paramVarArgs.aR(3, this.tlI);
      if (this.thP != null) {
        paramVarArgs.d(4, this.thP);
      }
      AppMethodBeat.o(41838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.thg == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.thg) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.thh != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.thh);
      }
      i += f.a.a.b.b.a.bx(3, this.tlI);
      paramInt = i;
      if (this.thP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.thP);
      }
      AppMethodBeat.o(41838);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41838);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dh localdh = (dh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41838);
          return -1;
        case 1: 
          localdh.thg = locala.LVo.readString();
          AppMethodBeat.o(41838);
          return 0;
        case 2: 
          localdh.thh = locala.LVo.readString();
          AppMethodBeat.o(41838);
          return 0;
        case 3: 
          localdh.tlI = locala.LVo.xF();
          AppMethodBeat.o(41838);
          return 0;
        }
        localdh.thP = locala.LVo.readString();
        AppMethodBeat.o(41838);
        return 0;
      }
      AppMethodBeat.o(41838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dh
 * JD-Core Version:    0.7.0.1
 */