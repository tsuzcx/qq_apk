package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dc
  extends com.tencent.mm.bw.a
{
  public String Title;
  public String thg;
  public String thh;
  public int tlF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41834);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.thh != null) {
        paramVarArgs.d(2, this.thh);
      }
      if (this.thg != null) {
        paramVarArgs.d(3, this.thg);
      }
      paramVarArgs.aR(4, this.tlF);
      AppMethodBeat.o(41834);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.thh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.thh);
      }
      i = paramInt;
      if (this.thg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.thg);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.tlF);
      AppMethodBeat.o(41834);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(41834);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dc localdc = (dc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41834);
          return -1;
        case 1: 
          localdc.Title = locala.LVo.readString();
          AppMethodBeat.o(41834);
          return 0;
        case 2: 
          localdc.thh = locala.LVo.readString();
          AppMethodBeat.o(41834);
          return 0;
        case 3: 
          localdc.thg = locala.LVo.readString();
          AppMethodBeat.o(41834);
          return 0;
        }
        localdc.tlF = locala.LVo.xF();
        AppMethodBeat.o(41834);
        return 0;
      }
      AppMethodBeat.o(41834);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dc
 * JD-Core Version:    0.7.0.1
 */