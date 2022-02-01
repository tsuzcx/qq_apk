package com.tencent.mm.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.cd.a
{
  public long jmE;
  public long jmF;
  public long jmG;
  public long jmH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42663);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.jmE);
      paramVarArgs.bm(2, this.jmF);
      paramVarArgs.bm(3, this.jmG);
      paramVarArgs.bm(4, this.jmH);
      AppMethodBeat.o(42663);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.jmE);
      int i = g.a.a.b.b.a.p(2, this.jmF);
      int j = g.a.a.b.b.a.p(3, this.jmG);
      int k = g.a.a.b.b.a.p(4, this.jmH);
      AppMethodBeat.o(42663);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(42663);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(42663);
        return -1;
      case 1: 
        localc.jmE = locala.abFh.AN();
        AppMethodBeat.o(42663);
        return 0;
      case 2: 
        localc.jmF = locala.abFh.AN();
        AppMethodBeat.o(42663);
        return 0;
      case 3: 
        localc.jmG = locala.abFh.AN();
        AppMethodBeat.o(42663);
        return 0;
      }
      localc.jmH = locala.abFh.AN();
      AppMethodBeat.o(42663);
      return 0;
    }
    AppMethodBeat.o(42663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.k.a.a.c
 * JD-Core Version:    0.7.0.1
 */