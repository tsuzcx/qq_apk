package com.tencent.mm.plugin.game.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String Name;
  public String npR;
  public String nqE;
  public int nqF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(111553);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.nqE != null) {
        paramVarArgs.e(1, this.nqE);
      }
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      if (this.Desc != null) {
        paramVarArgs.e(3, this.Desc);
      }
      if (this.npR != null) {
        paramVarArgs.e(4, this.npR);
      }
      paramVarArgs.aO(5, this.nqF);
      AppMethodBeat.o(111553);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nqE == null) {
        break label438;
      }
    }
    label438:
    for (int i = e.a.a.b.b.a.f(1, this.nqE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Name);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.Desc);
      }
      paramInt = i;
      if (this.npR != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.npR);
      }
      i = e.a.a.b.b.a.bl(5, this.nqF);
      AppMethodBeat.o(111553);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(111553);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(111553);
          return -1;
        case 1: 
          localn.nqE = locala.CLY.readString();
          AppMethodBeat.o(111553);
          return 0;
        case 2: 
          localn.Name = locala.CLY.readString();
          AppMethodBeat.o(111553);
          return 0;
        case 3: 
          localn.Desc = locala.CLY.readString();
          AppMethodBeat.o(111553);
          return 0;
        case 4: 
          localn.npR = locala.CLY.readString();
          AppMethodBeat.o(111553);
          return 0;
        }
        localn.nqF = locala.CLY.sl();
        AppMethodBeat.o(111553);
        return 0;
      }
      AppMethodBeat.o(111553);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.n
 * JD-Core Version:    0.7.0.1
 */