package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public int pjW;
  public boolean pjX;
  public long pjY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153056);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.pjW);
      paramVarArgs.bt(2, this.pjX);
      paramVarArgs.aY(3, this.pjY);
      AppMethodBeat.o(153056);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.pjW);
      int i = f.a.a.b.b.a.alV(2);
      int j = f.a.a.b.b.a.p(3, this.pjY);
      AppMethodBeat.o(153056);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(153056);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153056);
        return -1;
      case 1: 
        localn.pjW = locala.NPN.zc();
        AppMethodBeat.o(153056);
        return 0;
      case 2: 
        localn.pjX = locala.NPN.grw();
        AppMethodBeat.o(153056);
        return 0;
      }
      localn.pjY = locala.NPN.zd();
      AppMethodBeat.o(153056);
      return 0;
    }
    AppMethodBeat.o(153056);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.a.a.n
 * JD-Core Version:    0.7.0.1
 */