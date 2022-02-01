package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bx.a
{
  public boolean pkT;
  public String pkU;
  public String pkV;
  public String pkW;
  public int pkX;
  public boolean pkY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153072);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.pkT);
      if (this.pkU != null) {
        paramVarArgs.d(2, this.pkU);
      }
      if (this.pkV != null) {
        paramVarArgs.d(3, this.pkV);
      }
      if (this.pkW != null) {
        paramVarArgs.d(4, this.pkW);
      }
      paramVarArgs.aS(5, this.pkX);
      paramVarArgs.bt(6, this.pkY);
      AppMethodBeat.o(153072);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alV(1) + 0;
      paramInt = i;
      if (this.pkU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.pkU);
      }
      i = paramInt;
      if (this.pkV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pkV);
      }
      paramInt = i;
      if (this.pkW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.pkW);
      }
      i = f.a.a.b.b.a.bz(5, this.pkX);
      int j = f.a.a.b.b.a.alV(6);
      AppMethodBeat.o(153072);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
        locall.pkT = locala.NPN.grw();
        AppMethodBeat.o(153072);
        return 0;
      case 2: 
        locall.pkU = locala.NPN.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 3: 
        locall.pkV = locala.NPN.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 4: 
        locall.pkW = locala.NPN.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 5: 
        locall.pkX = locala.NPN.zc();
        AppMethodBeat.o(153072);
        return 0;
      }
      locall.pkY = locala.NPN.grw();
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