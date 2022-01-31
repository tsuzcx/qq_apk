package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bz
  extends com.tencent.mm.bv.a
{
  public String cDz;
  public String desc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111633);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.cDz != null) {
        paramVarArgs.e(1, this.cDz);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      AppMethodBeat.o(111633);
      return 0;
    }
    if (paramInt == 1) {
      if (this.cDz == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.cDz) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.desc);
      }
      AppMethodBeat.o(111633);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111633);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bz localbz = (bz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111633);
          return -1;
        case 1: 
          localbz.cDz = locala.CLY.readString();
          AppMethodBeat.o(111633);
          return 0;
        }
        localbz.desc = locala.CLY.readString();
        AppMethodBeat.o(111633);
        return 0;
      }
      AppMethodBeat.o(111633);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.bz
 * JD-Core Version:    0.7.0.1
 */