package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class l
  extends com.tencent.mm.bw.a
{
  public String oGf;
  public int uIW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218211);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uIW);
      if (this.oGf != null) {
        paramVarArgs.d(2, this.oGf);
      }
      AppMethodBeat.o(218211);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uIW) + 0;
      paramInt = i;
      if (this.oGf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oGf);
      }
      AppMethodBeat.o(218211);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(218211);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(218211);
        return -1;
      case 1: 
        locall.uIW = locala.OmT.zc();
        AppMethodBeat.o(218211);
        return 0;
      }
      locall.oGf = locala.OmT.readString();
      AppMethodBeat.o(218211);
      return 0;
    }
    AppMethodBeat.o(218211);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.b.l
 * JD-Core Version:    0.7.0.1
 */