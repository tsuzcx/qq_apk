package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bx.a
{
  public boolean odQ;
  public String odR;
  public String odS;
  public String odT;
  public int odU;
  public boolean odV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153072);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.odQ);
      if (this.odR != null) {
        paramVarArgs.d(2, this.odR);
      }
      if (this.odS != null) {
        paramVarArgs.d(3, this.odS);
      }
      if (this.odT != null) {
        paramVarArgs.d(4, this.odT);
      }
      paramVarArgs.aR(5, this.odU);
      paramVarArgs.bg(6, this.odV);
      AppMethodBeat.o(153072);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 1 + 0;
      paramInt = i;
      if (this.odR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.odR);
      }
      i = paramInt;
      if (this.odS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.odS);
      }
      paramInt = i;
      if (this.odT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.odT);
      }
      i = f.a.a.b.b.a.bA(5, this.odU);
      int j = f.a.a.b.b.a.fY(6);
      AppMethodBeat.o(153072);
      return paramInt + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(153072);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153072);
        return -1;
      case 1: 
        locall.odQ = locala.KhF.fHu();
        AppMethodBeat.o(153072);
        return 0;
      case 2: 
        locall.odR = locala.KhF.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 3: 
        locall.odS = locala.KhF.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 4: 
        locall.odT = locala.KhF.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 5: 
        locall.odU = locala.KhF.xS();
        AppMethodBeat.o(153072);
        return 0;
      }
      locall.odV = locala.KhF.fHu();
      AppMethodBeat.o(153072);
      return 0;
    }
    AppMethodBeat.o(153072);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.l
 * JD-Core Version:    0.7.0.1
 */