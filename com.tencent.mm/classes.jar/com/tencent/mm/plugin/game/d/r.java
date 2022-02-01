package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
  extends com.tencent.mm.bx.a
{
  public String ufU;
  public String ufV;
  public String ufW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41720);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ufU != null) {
        paramVarArgs.d(1, this.ufU);
      }
      if (this.ufV != null) {
        paramVarArgs.d(2, this.ufV);
      }
      if (this.ufW != null) {
        paramVarArgs.d(3, this.ufW);
      }
      AppMethodBeat.o(41720);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ufU == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.ufU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ufV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ufV);
      }
      i = paramInt;
      if (this.ufW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ufW);
      }
      AppMethodBeat.o(41720);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41720);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41720);
          return -1;
        case 1: 
          localr.ufU = locala.NPN.readString();
          AppMethodBeat.o(41720);
          return 0;
        case 2: 
          localr.ufV = locala.NPN.readString();
          AppMethodBeat.o(41720);
          return 0;
        }
        localr.ufW = locala.NPN.readString();
        AppMethodBeat.o(41720);
        return 0;
      }
      AppMethodBeat.o(41720);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.r
 * JD-Core Version:    0.7.0.1
 */