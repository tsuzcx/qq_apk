package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ao
  extends com.tencent.mm.bx.a
{
  public String ueY;
  public int ugV;
  public String ugW;
  public int ugz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.ugz);
      if (this.ueY != null) {
        paramVarArgs.d(2, this.ueY);
      }
      paramVarArgs.aS(3, this.ugV);
      if (this.ugW != null) {
        paramVarArgs.d(4, this.ugW);
      }
      AppMethodBeat.o(149414);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.ugz) + 0;
      paramInt = i;
      if (this.ueY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ueY);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.ugV);
      paramInt = i;
      if (this.ugW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ugW);
      }
      AppMethodBeat.o(149414);
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
      AppMethodBeat.o(149414);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ao localao = (ao)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(149414);
        return -1;
      case 1: 
        localao.ugz = locala.NPN.zc();
        AppMethodBeat.o(149414);
        return 0;
      case 2: 
        localao.ueY = locala.NPN.readString();
        AppMethodBeat.o(149414);
        return 0;
      case 3: 
        localao.ugV = locala.NPN.zc();
        AppMethodBeat.o(149414);
        return 0;
      }
      localao.ugW = locala.NPN.readString();
      AppMethodBeat.o(149414);
      return 0;
    }
    AppMethodBeat.o(149414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.ao
 * JD-Core Version:    0.7.0.1
 */