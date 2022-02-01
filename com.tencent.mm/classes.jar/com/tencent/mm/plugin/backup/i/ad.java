package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ad
  extends com.tencent.mm.cd.a
{
  public int rWB;
  public int rWC;
  public int rWE;
  public String rWy;
  public int rWz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22136);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rWy == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataID");
        AppMethodBeat.o(22136);
        throw paramVarArgs;
      }
      if (this.rWy != null) {
        paramVarArgs.f(1, this.rWy);
      }
      paramVarArgs.aY(2, this.rWz);
      paramVarArgs.aY(3, this.rWB);
      paramVarArgs.aY(4, this.rWC);
      paramVarArgs.aY(5, this.rWE);
      AppMethodBeat.o(22136);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rWy == null) {
        break label457;
      }
    }
    label457:
    for (paramInt = g.a.a.b.b.a.g(1, this.rWy) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.rWz);
      int j = g.a.a.b.b.a.bM(3, this.rWB);
      int k = g.a.a.b.b.a.bM(4, this.rWC);
      int m = g.a.a.b.b.a.bM(5, this.rWE);
      AppMethodBeat.o(22136);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.rWy == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataID");
          AppMethodBeat.o(22136);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22136);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ad localad = (ad)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22136);
          return -1;
        case 1: 
          localad.rWy = locala.abFh.readString();
          AppMethodBeat.o(22136);
          return 0;
        case 2: 
          localad.rWz = locala.abFh.AK();
          AppMethodBeat.o(22136);
          return 0;
        case 3: 
          localad.rWB = locala.abFh.AK();
          AppMethodBeat.o(22136);
          return 0;
        case 4: 
          localad.rWC = locala.abFh.AK();
          AppMethodBeat.o(22136);
          return 0;
        }
        localad.rWE = locala.abFh.AK();
        AppMethodBeat.o(22136);
        return 0;
      }
      AppMethodBeat.o(22136);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.ad
 * JD-Core Version:    0.7.0.1
 */