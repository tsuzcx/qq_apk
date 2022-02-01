package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dm
  extends com.tencent.mm.bx.a
{
  public String hAD;
  public String udZ;
  public String ujP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149418);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hAD != null) {
        paramVarArgs.d(1, this.hAD);
      }
      if (this.udZ != null) {
        paramVarArgs.d(2, this.udZ);
      }
      if (this.ujP != null) {
        paramVarArgs.d(3, this.ujP);
      }
      AppMethodBeat.o(149418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAD == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.hAD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.udZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.udZ);
      }
      i = paramInt;
      if (this.ujP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ujP);
      }
      AppMethodBeat.o(149418);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(149418);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dm localdm = (dm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149418);
          return -1;
        case 1: 
          localdm.hAD = locala.NPN.readString();
          AppMethodBeat.o(149418);
          return 0;
        case 2: 
          localdm.udZ = locala.NPN.readString();
          AppMethodBeat.o(149418);
          return 0;
        }
        localdm.ujP = locala.NPN.readString();
        AppMethodBeat.o(149418);
        return 0;
      }
      AppMethodBeat.o(149418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.dm
 * JD-Core Version:    0.7.0.1
 */