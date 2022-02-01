package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ds
  extends com.tencent.mm.bx.a
{
  public String ufG;
  public int ufI;
  public int ujV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199589);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.ujV);
      paramVarArgs.aS(2, this.ufI);
      if (this.ufG != null) {
        paramVarArgs.d(3, this.ufG);
      }
      AppMethodBeat.o(199589);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.ujV) + 0 + f.a.a.b.b.a.bz(2, this.ufI);
      paramInt = i;
      if (this.ufG != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ufG);
      }
      AppMethodBeat.o(199589);
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
      AppMethodBeat.o(199589);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ds localds = (ds)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(199589);
        return -1;
      case 1: 
        localds.ujV = locala.NPN.zc();
        AppMethodBeat.o(199589);
        return 0;
      case 2: 
        localds.ufI = locala.NPN.zc();
        AppMethodBeat.o(199589);
        return 0;
      }
      localds.ufG = locala.NPN.readString();
      AppMethodBeat.o(199589);
      return 0;
    }
    AppMethodBeat.o(199589);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ds
 * JD-Core Version:    0.7.0.1
 */