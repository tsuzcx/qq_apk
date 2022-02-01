package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cu
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String ueY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(41816);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Desc != null) {
        paramVarArgs.d(1, this.Desc);
      }
      if (this.ueY != null) {
        paramVarArgs.d(2, this.ueY);
      }
      AppMethodBeat.o(41816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Desc == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Desc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ueY != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ueY);
      }
      AppMethodBeat.o(41816);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(41816);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cu localcu = (cu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(41816);
          return -1;
        case 1: 
          localcu.Desc = locala.NPN.readString();
          AppMethodBeat.o(41816);
          return 0;
        }
        localcu.ueY = locala.NPN.readString();
        AppMethodBeat.o(41816);
        return 0;
      }
      AppMethodBeat.o(41816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.cu
 * JD-Core Version:    0.7.0.1
 */