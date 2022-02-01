package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class p
  extends com.tencent.mm.cd.a
{
  public String ID;
  public long rVT;
  public int rVW;
  public int rVX;
  public int rVY;
  public long rVZ;
  public long rWa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(22120);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ID");
        AppMethodBeat.o(22120);
        throw paramVarArgs;
      }
      if (this.ID != null) {
        paramVarArgs.f(1, this.ID);
      }
      paramVarArgs.aY(2, this.rVW);
      paramVarArgs.aY(3, this.rVX);
      paramVarArgs.aY(4, this.rVY);
      paramVarArgs.bm(5, this.rVT);
      paramVarArgs.bm(6, this.rVZ);
      paramVarArgs.bm(7, this.rWa);
      AppMethodBeat.o(22120);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ID == null) {
        break label555;
      }
    }
    label555:
    for (paramInt = g.a.a.b.b.a.g(1, this.ID) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.rVW);
      int j = g.a.a.b.b.a.bM(3, this.rVX);
      int k = g.a.a.b.b.a.bM(4, this.rVY);
      int m = g.a.a.b.b.a.p(5, this.rVT);
      int n = g.a.a.b.b.a.p(6, this.rVZ);
      int i1 = g.a.a.b.b.a.p(7, this.rWa);
      AppMethodBeat.o(22120);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.ID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ID");
          AppMethodBeat.o(22120);
          throw paramVarArgs;
        }
        AppMethodBeat.o(22120);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        p localp = (p)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(22120);
          return -1;
        case 1: 
          localp.ID = locala.abFh.readString();
          AppMethodBeat.o(22120);
          return 0;
        case 2: 
          localp.rVW = locala.abFh.AK();
          AppMethodBeat.o(22120);
          return 0;
        case 3: 
          localp.rVX = locala.abFh.AK();
          AppMethodBeat.o(22120);
          return 0;
        case 4: 
          localp.rVY = locala.abFh.AK();
          AppMethodBeat.o(22120);
          return 0;
        case 5: 
          localp.rVT = locala.abFh.AN();
          AppMethodBeat.o(22120);
          return 0;
        case 6: 
          localp.rVZ = locala.abFh.AN();
          AppMethodBeat.o(22120);
          return 0;
        }
        localp.rWa = locala.abFh.AN();
        AppMethodBeat.o(22120);
        return 0;
      }
      AppMethodBeat.o(22120);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.i.p
 * JD-Core Version:    0.7.0.1
 */