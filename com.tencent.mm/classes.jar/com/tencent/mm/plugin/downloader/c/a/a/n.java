package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bx.a
{
  public int ocT;
  public boolean ocU;
  public long ocV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153056);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ocT);
      paramVarArgs.bg(2, this.ocU);
      paramVarArgs.aG(3, this.ocV);
      AppMethodBeat.o(153056);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.ocT);
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.q(3, this.ocV);
      AppMethodBeat.o(153056);
      return paramInt + 0 + (i + 1) + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        localn.ocT = locala.KhF.xS();
        AppMethodBeat.o(153056);
        return 0;
      case 2: 
        localn.ocU = locala.KhF.fHu();
        AppMethodBeat.o(153056);
        return 0;
      }
      localn.ocV = locala.KhF.xT();
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