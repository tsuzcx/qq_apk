package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cr
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String Title;
  public String ueX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41813);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.ueX != null) {
        paramVarArgs.d(2, this.ueX);
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
      if (this.ueX != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ueX);
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
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41813);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cr localcr = (cr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41813);
          return -1;
        case 1: 
          localcr.Title = locala.NPN.readString();
          AppMethodBeat.o(41813);
          return 0;
        case 2: 
          localcr.ueX = locala.NPN.readString();
          AppMethodBeat.o(41813);
          return 0;
        }
        localcr.Desc = locala.NPN.readString();
        AppMethodBeat.o(41813);
        return 0;
      }
      AppMethodBeat.o(41813);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cr
 * JD-Core Version:    0.7.0.1
 */