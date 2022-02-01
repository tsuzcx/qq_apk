package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
  extends com.tencent.mm.bx.a
{
  public String iTL;
  public String ozD;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153076);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.iTL != null) {
        paramVarArgs.d(2, this.iTL);
      }
      if (this.ozD != null) {
        paramVarArgs.d(3, this.ozD);
      }
      AppMethodBeat.o(153076);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.iTL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iTL);
      }
      i = paramInt;
      if (this.ozD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ozD);
      }
      AppMethodBeat.o(153076);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(153076);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      p localp = (p)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153076);
        return -1;
      case 1: 
        localp.type = locala.NPN.zc();
        AppMethodBeat.o(153076);
        return 0;
      case 2: 
        localp.iTL = locala.NPN.readString();
        AppMethodBeat.o(153076);
        return 0;
      }
      localp.ozD = locala.NPN.readString();
      AppMethodBeat.o(153076);
      return 0;
    }
    AppMethodBeat.o(153076);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.b.p
 * JD-Core Version:    0.7.0.1
 */