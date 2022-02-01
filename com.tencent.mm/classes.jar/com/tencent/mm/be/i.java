package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends com.tencent.mm.cd.a
{
  public int fSe;
  public int lXw;
  public int lXx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(150799);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.fSe);
      paramVarArgs.aY(2, this.lXw);
      paramVarArgs.aY(3, this.lXx);
      AppMethodBeat.o(150799);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.fSe);
      int i = g.a.a.b.b.a.bM(2, this.lXw);
      int j = g.a.a.b.b.a.bM(3, this.lXx);
      AppMethodBeat.o(150799);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(150799);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(150799);
        return -1;
      case 1: 
        locali.fSe = locala.abFh.AK();
        AppMethodBeat.o(150799);
        return 0;
      case 2: 
        locali.lXw = locala.abFh.AK();
        AppMethodBeat.o(150799);
        return 0;
      }
      locali.lXx = locala.abFh.AK();
      AppMethodBeat.o(150799);
      return 0;
    }
    AppMethodBeat.o(150799);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.be.i
 * JD-Core Version:    0.7.0.1
 */