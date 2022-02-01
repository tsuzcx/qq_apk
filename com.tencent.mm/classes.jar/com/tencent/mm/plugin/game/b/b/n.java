package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public int duration;
  public String hDz;
  public int height;
  public String iTL;
  public String title;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40882);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hDz != null) {
        paramVarArgs.d(1, this.hDz);
      }
      if (this.iTL != null) {
        paramVarArgs.d(2, this.iTL);
      }
      paramVarArgs.aS(3, this.height);
      paramVarArgs.aS(4, this.width);
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      paramVarArgs.aS(6, this.duration);
      AppMethodBeat.o(40882);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hDz == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.hDz) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iTL != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.iTL);
      }
      i = i + f.a.a.b.b.a.bz(3, this.height) + f.a.a.b.b.a.bz(4, this.width);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.title);
      }
      i = f.a.a.b.b.a.bz(6, this.duration);
      AppMethodBeat.o(40882);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(40882);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(40882);
          return -1;
        case 1: 
          localn.hDz = locala.NPN.readString();
          AppMethodBeat.o(40882);
          return 0;
        case 2: 
          localn.iTL = locala.NPN.readString();
          AppMethodBeat.o(40882);
          return 0;
        case 3: 
          localn.height = locala.NPN.zc();
          AppMethodBeat.o(40882);
          return 0;
        case 4: 
          localn.width = locala.NPN.zc();
          AppMethodBeat.o(40882);
          return 0;
        case 5: 
          localn.title = locala.NPN.readString();
          AppMethodBeat.o(40882);
          return 0;
        }
        localn.duration = locala.NPN.zc();
        AppMethodBeat.o(40882);
        return 0;
      }
      AppMethodBeat.o(40882);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.b.b.n
 * JD-Core Version:    0.7.0.1
 */