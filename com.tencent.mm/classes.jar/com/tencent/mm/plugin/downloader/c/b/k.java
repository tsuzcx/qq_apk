package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends com.tencent.mm.bv.a
{
  public boolean kXa;
  public String kXb;
  public String kXc;
  public String kXd;
  public int kXe;
  public boolean kXf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(35537);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.kXa);
      if (this.kXb != null) {
        paramVarArgs.e(2, this.kXb);
      }
      if (this.kXc != null) {
        paramVarArgs.e(3, this.kXc);
      }
      if (this.kXd != null) {
        paramVarArgs.e(4, this.kXd);
      }
      paramVarArgs.aO(5, this.kXe);
      paramVarArgs.aS(6, this.kXf);
      AppMethodBeat.o(35537);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 1 + 0;
      paramInt = i;
      if (this.kXb != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.kXb);
      }
      i = paramInt;
      if (this.kXc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.kXc);
      }
      paramInt = i;
      if (this.kXd != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.kXd);
      }
      i = e.a.a.b.b.a.bl(5, this.kXe);
      int j = e.a.a.b.b.a.eW(6);
      AppMethodBeat.o(35537);
      return paramInt + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(35537);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      k localk = (k)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(35537);
        return -1;
      case 1: 
        localk.kXa = locala.CLY.emu();
        AppMethodBeat.o(35537);
        return 0;
      case 2: 
        localk.kXb = locala.CLY.readString();
        AppMethodBeat.o(35537);
        return 0;
      case 3: 
        localk.kXc = locala.CLY.readString();
        AppMethodBeat.o(35537);
        return 0;
      case 4: 
        localk.kXd = locala.CLY.readString();
        AppMethodBeat.o(35537);
        return 0;
      case 5: 
        localk.kXe = locala.CLY.sl();
        AppMethodBeat.o(35537);
        return 0;
      }
      localk.kXf = locala.CLY.emu();
      AppMethodBeat.o(35537);
      return 0;
    }
    AppMethodBeat.o(35537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.k
 * JD-Core Version:    0.7.0.1
 */