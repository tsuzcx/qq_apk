package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ce
  extends com.tencent.mm.cd.a
{
  public int key;
  public long kje;
  public String lvH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143730);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.key);
      if (this.lvH != null) {
        paramVarArgs.f(2, this.lvH);
      }
      paramVarArgs.bm(3, this.kje);
      AppMethodBeat.o(143730);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.key) + 0;
      paramInt = i;
      if (this.lvH != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lvH);
      }
      i = g.a.a.b.b.a.p(3, this.kje);
      AppMethodBeat.o(143730);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143730);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ce localce = (ce)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143730);
        return -1;
      case 1: 
        localce.key = locala.abFh.AK();
        AppMethodBeat.o(143730);
        return 0;
      case 2: 
        localce.lvH = locala.abFh.readString();
        AppMethodBeat.o(143730);
        return 0;
      }
      localce.kje = locala.abFh.AN();
      AppMethodBeat.o(143730);
      return 0;
    }
    AppMethodBeat.o(143730);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.ce
 * JD-Core Version:    0.7.0.1
 */