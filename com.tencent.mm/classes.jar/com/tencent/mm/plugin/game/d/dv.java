package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dv
  extends com.tencent.mm.bx.a
{
  public String ueX;
  public String ueY;
  public String ufG;
  public int ukh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41838);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ueX != null) {
        paramVarArgs.d(1, this.ueX);
      }
      if (this.ueY != null) {
        paramVarArgs.d(2, this.ueY);
      }
      paramVarArgs.aS(3, this.ukh);
      if (this.ufG != null) {
        paramVarArgs.d(4, this.ufG);
      }
      AppMethodBeat.o(41838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ueX == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.ueX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ueY != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ueY);
      }
      i += f.a.a.b.b.a.bz(3, this.ukh);
      paramInt = i;
      if (this.ufG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ufG);
      }
      AppMethodBeat.o(41838);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41838);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dv localdv = (dv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41838);
          return -1;
        case 1: 
          localdv.ueX = locala.NPN.readString();
          AppMethodBeat.o(41838);
          return 0;
        case 2: 
          localdv.ueY = locala.NPN.readString();
          AppMethodBeat.o(41838);
          return 0;
        case 3: 
          localdv.ukh = locala.NPN.zc();
          AppMethodBeat.o(41838);
          return 0;
        }
        localdv.ufG = locala.NPN.readString();
        AppMethodBeat.o(41838);
        return 0;
      }
      AppMethodBeat.o(41838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dv
 * JD-Core Version:    0.7.0.1
 */