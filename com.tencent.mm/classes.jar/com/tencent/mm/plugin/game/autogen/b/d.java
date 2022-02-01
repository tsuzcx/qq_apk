package com.tencent.mm.plugin.game.autogen.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.cd.a
{
  public String CqZ;
  public String Cra;
  public int ufE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40867);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CqZ != null) {
        paramVarArgs.f(1, this.CqZ);
      }
      if (this.Cra != null) {
        paramVarArgs.f(2, this.Cra);
      }
      paramVarArgs.aY(3, this.ufE);
      AppMethodBeat.o(40867);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CqZ == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.CqZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Cra != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Cra);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.ufE);
      AppMethodBeat.o(40867);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(40867);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(40867);
          return -1;
        case 1: 
          locald.CqZ = locala.abFh.readString();
          AppMethodBeat.o(40867);
          return 0;
        case 2: 
          locald.Cra = locala.abFh.readString();
          AppMethodBeat.o(40867);
          return 0;
        }
        locald.ufE = locala.abFh.AK();
        AppMethodBeat.o(40867);
        return 0;
      }
      AppMethodBeat.o(40867);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.autogen.b.d
 * JD-Core Version:    0.7.0.1
 */