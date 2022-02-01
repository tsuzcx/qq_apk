package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ck
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String thg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41813);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.thg != null) {
        paramVarArgs.d(2, this.thg);
      }
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      AppMethodBeat.o(41813);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.thg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.thg);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Desc);
      }
      AppMethodBeat.o(41813);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41813);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ck localck = (ck)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41813);
          return -1;
        case 1: 
          localck.Title = locala.LVo.readString();
          AppMethodBeat.o(41813);
          return 0;
        case 2: 
          localck.thg = locala.LVo.readString();
          AppMethodBeat.o(41813);
          return 0;
        }
        localck.Desc = locala.LVo.readString();
        AppMethodBeat.o(41813);
        return 0;
      }
      AppMethodBeat.o(41813);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ck
 * JD-Core Version:    0.7.0.1
 */