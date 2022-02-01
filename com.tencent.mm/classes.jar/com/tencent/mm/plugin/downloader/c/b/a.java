package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bx.a
{
  public long ocW;
  public long ocX;
  public String ocY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153058);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.ocW);
      paramVarArgs.aG(2, this.ocX);
      if (this.ocY != null) {
        paramVarArgs.d(3, this.ocY);
      }
      AppMethodBeat.o(153058);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.ocW) + 0 + f.a.a.b.b.a.q(2, this.ocX);
      paramInt = i;
      if (this.ocY != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ocY);
      }
      AppMethodBeat.o(153058);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(153058);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      a locala1 = (a)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153058);
        return -1;
      case 1: 
        locala1.ocW = locala.KhF.xT();
        AppMethodBeat.o(153058);
        return 0;
      case 2: 
        locala1.ocX = locala.KhF.xT();
        AppMethodBeat.o(153058);
        return 0;
      }
      locala1.ocY = locala.KhF.readString();
      AppMethodBeat.o(153058);
      return 0;
    }
    AppMethodBeat.o(153058);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.a
 * JD-Core Version:    0.7.0.1
 */