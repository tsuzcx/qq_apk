package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.bw.a
{
  public int hFL;
  public int hFM;
  public String hFN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116410);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.hFL);
      paramVarArgs.aS(2, this.hFM);
      if (this.hFN != null) {
        paramVarArgs.d(3, this.hFN);
      }
      AppMethodBeat.o(116410);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.hFL) + 0 + f.a.a.b.b.a.bz(2, this.hFM);
      paramInt = i;
      if (this.hFN != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.hFN);
      }
      AppMethodBeat.o(116410);
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
      AppMethodBeat.o(116410);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116410);
        return -1;
      case 1: 
        localo.hFL = locala.OmT.zc();
        AppMethodBeat.o(116410);
        return 0;
      case 2: 
        localo.hFM = locala.OmT.zc();
        AppMethodBeat.o(116410);
        return 0;
      }
      localo.hFN = locala.OmT.readString();
      AppMethodBeat.o(116410);
      return 0;
    }
    AppMethodBeat.o(116410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ah.o
 * JD-Core Version:    0.7.0.1
 */