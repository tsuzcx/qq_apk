package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public String prA;
  public String prB;
  public int prC;
  public boolean prD;
  public boolean pry;
  public String prz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153072);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.pry);
      if (this.prz != null) {
        paramVarArgs.d(2, this.prz);
      }
      if (this.prA != null) {
        paramVarArgs.d(3, this.prA);
      }
      if (this.prB != null) {
        paramVarArgs.d(4, this.prB);
      }
      paramVarArgs.aS(5, this.prC);
      paramVarArgs.bC(6, this.prD);
      AppMethodBeat.o(153072);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amF(1) + 0;
      paramInt = i;
      if (this.prz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.prz);
      }
      i = paramInt;
      if (this.prA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.prA);
      }
      paramInt = i;
      if (this.prB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.prB);
      }
      i = f.a.a.b.b.a.bz(5, this.prC);
      int j = f.a.a.b.b.a.amF(6);
      AppMethodBeat.o(153072);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        locall.pry = locala.OmT.gvY();
        AppMethodBeat.o(153072);
        return 0;
      case 2: 
        locall.prz = locala.OmT.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 3: 
        locall.prA = locala.OmT.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 4: 
        locall.prB = locala.OmT.readString();
        AppMethodBeat.o(153072);
        return 0;
      case 5: 
        locall.prC = locala.OmT.zc();
        AppMethodBeat.o(153072);
        return 0;
      }
      locall.prD = locala.OmT.gvY();
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