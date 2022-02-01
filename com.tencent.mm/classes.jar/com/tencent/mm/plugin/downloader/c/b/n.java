package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public String odX;
  public String odY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153074);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.odX != null) {
        paramVarArgs.d(1, this.odX);
      }
      if (this.odY != null) {
        paramVarArgs.d(2, this.odY);
      }
      AppMethodBeat.o(153074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.odX == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.odX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.odY != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.odY);
      }
      AppMethodBeat.o(153074);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153074);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153074);
          return -1;
        case 1: 
          localn.odX = locala.KhF.readString();
          AppMethodBeat.o(153074);
          return 0;
        }
        localn.odY = locala.KhF.readString();
        AppMethodBeat.o(153074);
        return 0;
      }
      AppMethodBeat.o(153074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.n
 * JD-Core Version:    0.7.0.1
 */