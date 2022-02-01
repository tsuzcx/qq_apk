package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends com.tencent.mm.bx.a
{
  public long pjZ;
  public long pka;
  public String pkb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153058);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.pjZ);
      paramVarArgs.aY(2, this.pka);
      if (this.pkb != null) {
        paramVarArgs.d(3, this.pkb);
      }
      AppMethodBeat.o(153058);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.pjZ) + 0 + f.a.a.b.b.a.p(2, this.pka);
      paramInt = i;
      if (this.pkb != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.pkb);
      }
      AppMethodBeat.o(153058);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
        locala1.pjZ = locala.NPN.zd();
        AppMethodBeat.o(153058);
        return 0;
      case 2: 
        locala1.pka = locala.NPN.zd();
        AppMethodBeat.o(153058);
        return 0;
      }
      locala1.pkb = locala.NPN.readString();
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