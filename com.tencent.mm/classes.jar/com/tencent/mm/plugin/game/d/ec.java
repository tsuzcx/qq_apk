package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ec
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String Title;
  public String ueX;
  public String ukk;
  
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
      if (this.ukk != null) {
        paramVarArgs.d(3, this.ukk);
      }
      if (this.ueX != null) {
        paramVarArgs.d(4, this.ueX);
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
      if (this.ukk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ukk);
      }
      paramInt = i;
      if (this.ueX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ueX);
      }
      AppMethodBeat.o(41845);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41845);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ec localec = (ec)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41845);
          return -1;
        case 1: 
          localec.Title = locala.NPN.readString();
          AppMethodBeat.o(41845);
          return 0;
        case 2: 
          localec.Desc = locala.NPN.readString();
          AppMethodBeat.o(41845);
          return 0;
        case 3: 
          localec.ukk = locala.NPN.readString();
          AppMethodBeat.o(41845);
          return 0;
        }
        localec.ueX = locala.NPN.readString();
        AppMethodBeat.o(41845);
        return 0;
      }
      AppMethodBeat.o(41845);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ec
 * JD-Core Version:    0.7.0.1
 */