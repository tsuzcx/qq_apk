package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class x
  extends com.tencent.mm.bv.a
{
  public String Name;
  public String nqE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111561);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nqE != null) {
        paramVarArgs.e(1, this.nqE);
      }
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      AppMethodBeat.o(111561);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nqE == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.nqE) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Name != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.Name);
      }
      AppMethodBeat.o(111561);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111561);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111561);
          return -1;
        case 1: 
          localx.nqE = locala.CLY.readString();
          AppMethodBeat.o(111561);
          return 0;
        }
        localx.Name = locala.CLY.readString();
        AppMethodBeat.o(111561);
        return 0;
      }
      AppMethodBeat.o(111561);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.x
 * JD-Core Version:    0.7.0.1
 */