package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class el
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String uqe;
  public String uvH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41845);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      if (this.uvH != null) {
        paramVarArgs.d(3, this.uvH);
      }
      if (this.uqe != null) {
        paramVarArgs.d(4, this.uqe);
      }
      AppMethodBeat.o(41845);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Desc);
      }
      i = paramInt;
      if (this.uvH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvH);
      }
      paramInt = i;
      if (this.uqe != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uqe);
      }
      AppMethodBeat.o(41845);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(41845);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        el localel = (el)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41845);
          return -1;
        case 1: 
          localel.Title = locala.OmT.readString();
          AppMethodBeat.o(41845);
          return 0;
        case 2: 
          localel.Desc = locala.OmT.readString();
          AppMethodBeat.o(41845);
          return 0;
        case 3: 
          localel.uvH = locala.OmT.readString();
          AppMethodBeat.o(41845);
          return 0;
        }
        localel.uqe = locala.OmT.readString();
        AppMethodBeat.o(41845);
        return 0;
      }
      AppMethodBeat.o(41845);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.el
 * JD-Core Version:    0.7.0.1
 */