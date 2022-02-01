package com.tencent.mm.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends com.tencent.mm.bw.a
{
  public long gCA;
  public long gCB;
  public long gCy;
  public long gCz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42663);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.gCy);
      paramVarArgs.bb(2, this.gCz);
      paramVarArgs.bb(3, this.gCA);
      paramVarArgs.bb(4, this.gCB);
      AppMethodBeat.o(42663);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.gCy);
      int i = g.a.a.b.b.a.r(2, this.gCz);
      int j = g.a.a.b.b.a.r(3, this.gCA);
      int k = g.a.a.b.b.a.r(4, this.gCB);
      AppMethodBeat.o(42663);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
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
        localc.gCy = locala.UbS.zl();
        AppMethodBeat.o(42663);
        return 0;
      case 2: 
        localc.gCz = locala.UbS.zl();
        AppMethodBeat.o(42663);
        return 0;
      case 3: 
        localc.gCA = locala.UbS.zl();
        AppMethodBeat.o(42663);
        return 0;
      }
      localc.gCB = locala.UbS.zl();
      AppMethodBeat.o(42663);
      return 0;
    }
    AppMethodBeat.o(42663);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.k.a.a.c
 * JD-Core Version:    0.7.0.1
 */