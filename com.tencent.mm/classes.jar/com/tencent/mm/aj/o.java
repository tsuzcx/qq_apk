package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
  extends com.tencent.mm.cd.a
{
  public int lpp;
  public int lpq;
  public String lpr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116410);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.lpp);
      paramVarArgs.aY(2, this.lpq);
      if (this.lpr != null) {
        paramVarArgs.f(3, this.lpr);
      }
      AppMethodBeat.o(116410);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.lpp) + 0 + g.a.a.b.b.a.bM(2, this.lpq);
      paramInt = i;
      if (this.lpr != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.lpr);
      }
      AppMethodBeat.o(116410);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(116410);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      o localo = (o)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116410);
        return -1;
      case 1: 
        localo.lpp = locala.abFh.AK();
        AppMethodBeat.o(116410);
        return 0;
      case 2: 
        localo.lpq = locala.abFh.AK();
        AppMethodBeat.o(116410);
        return 0;
      }
      localo.lpr = locala.abFh.readString();
      AppMethodBeat.o(116410);
      return 0;
    }
    AppMethodBeat.o(116410);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.o
 * JD-Core Version:    0.7.0.1
 */